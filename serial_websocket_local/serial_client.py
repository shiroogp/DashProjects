from ws4py.client.threadedclient import WebSocketClient
import serial
import json
import threading
# import codecs
# from datetime import datetime
import time
import sys
import glob
import subprocess


class SerialWs(WebSocketClient):
    serial_thread = None

    def opened(self):
        print("serial_client_opend")
        pass

    def closed(self, code, reason=None):
        print("serial_client_closed")
        # pass

    def received_message(self, message):
        # print(message.data)
        data = json.loads(message.data.decode('utf-8'))
        print(data)
        if data["type"] == "send":
            self.serial_thread.send_message(data["message"])
        elif data["type"] == "open":
            self.serial_thread = SerialThread(
                data["port"],
                data["baudrate"],
                data["databit"],
                data["stopbit"],
                data["parity"],
                self
            )
            self.serial_thread.setDaemon(True)
            self.serial_thread.start()
        elif data["type"] == "close":
            self.serial_thread.stop()
        elif data["type"] == "exit":
            subprocess.check_output('killall - KILL SerialTool', shell=True)
            sys.exit()
        else:
            pass


class SerialThread(threading.Thread):
    def __init__(self, port, baudrate, databit, stopbit, parity, ws):
        super(SerialThread, self).__init__()
        self.stop_event = threading.Event()
        self.port = port
        self.baudrate = int(baudrate)
        self.databit = int(databit)
        self.stopbit = int(stopbit)
        self.parity = parity
        self.ws = ws
        self.serial_port = None

    def stop(self):
        self.stop_event.set()

    def send_message(self, message):
        self.serial_port.reset_output_buffer()
        self.serial_port.write(message.encode('utf-8').decode('unicode_escape').encode('utf-8'))
        # self.serial_port.write(message.encode('utf-8'))

    def run(self):
        self.count = 0
        try:
            self.serial_port = serial.Serial(
                port=self.port,
                baudrate=self.baudrate,
                bytesize=self.databit,
                parity=self.parity,
                stopbits=self.stopbit,
                timeout=0
            )
            self.ws.send(json.dumps({
                "type":"status",
                "status":"connected",
                "condition": self.port + "/" + str(self.databit) + "/" + str(self.stopbit) + "/" + self.parity
            }))
            self.serial_port.reset_input_buffer()
            self.serial_port.reset_output_buffer()
            while not self.stop_event.is_set():
                self.count = self.count +1
                if self.count < 11:
                    time.sleep(0.1)
                elif self.count == 300:
                    self.count=11
                else:
                    time.sleep(0.002)
                    print("serial requesting data")
                    self.serial_port.write("A".encode('utf-8').decode('unicode_escape').encode('utf-8'))
                reading = self.serial_port.read()
                data = {}
                data["type"] = "data"
                data["data"] = ""
                lineout = ""
                bytecount = 0
                basicdashdata = ""
                while len(reading) != 0:
                    # print(reading)
                    try:
                        currval1 = str(ord(reading.decode()))
                    except:
                        currval1 = str(ord(reading))
                    # remove the below code when live   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    if bytecount == 14:
                        currval1 = str(self.count * 10)
                    bytecount += 1
                    lineout += currval1 + " "

                    try:
                        # data["name"] = self.port
                        if reading == b'\n':
                            data["data"] = data["data"] + '0x%02x' % ord(reading.decode('utf-8')) + "\n"
                        else:
                            data["data"] = data["data"] + '0x%02x' % ord(reading.decode('utf-8')) + ","
                        # data["timestamp"] = datetime.now().strftime('%Y-%m-%d %H:%M:%S.%f')
                        # print(json.dumps(data))
                        # self.ws.send(json.dumps(data, ensure_ascii=False))
                    except ValueError as error:
                        # self.ws.send(json.dumps({"type":"error","error":"decode error"}))
                        error1=error
                    reading = self.serial_port.read()
                try:
                    vars = lineout.split()
                    map_bar = (int(vars[4]) - int(vars[40])) / 101.33
                    map_psi = (int(vars[4]) - int(vars[40])) * 0.145038
                    map_inhg = (int(vars[40]) - int(vars[4])) * 0.2953007
                    basicdashdata = (
                        "BASIC~"
                        + vars[4]
                        + " "
                        + vars[40]
                        + " "
                        + vars[7]
                        + " "
                        + vars[6]
                        + " "
                        + vars[114]
                        + " "
                        + vars[10]
                        + " "
                        + vars[105]
                        + " "
                        + vars[106]
                        + " "
                        + vars[14]
                        + " "
                        + vars[9]
                        + " "
                        + vars[24]
                        + "\n"
                    )
                except:
                    error2 = "error"
                data["data"] = data["data"] + "\n"
                # self.ws.send(json.dumps(data, ensure_ascii=False))
                if lineout != "":
                    lineout = lineout + "\n"
                    print(lineout)
                    self.ws.send(lineout.encode("ascii"))
                # self.ws.send(basicdashdata.encode("ascii"))
            self.ws.send(json.dumps({"type":"status","status":"disconnected","device":self.port}))
        except ValueError as error:
            self.ws.send(json.dumps({"type":"error","error":"value error\n"}))
        except serial.SerialException as error:
            self.ws.send(json.dumps({"type":"error","error":"serial exception\n"}))


# def serial_ws_run():
#     # enableTrace(True)
#     ws = SerialWs('ws://localhost:8080/ws', protocols=['http-only', 'chat'])
#     ws.connect()
#     ws.run_forever()


def serial_ports():
    # windows
    if sys.platform.startswith('win'):
        ports = ['COM%s' % (i + 1) for i in range(256)]
    # linux
    elif sys.platform.startswith('linux') or sys.platform.startswith('cygwin'):
        ports = glob.glob('/dev/tty[A-Za-z]*')
    # osX
    elif sys.platform.startswith('darwin'):
        ports = glob.glob('/dev/tty.*')
    else:
        raise EnvironmentError('Unsupported platform')

    return ports
