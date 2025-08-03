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

# map = list[4]
# baro = list[40]

# map_bar = (map - baro) / 101.33
# map_psi = (map - baro) * 0.145038
# map_inhg = (baro - map) * 0.2953007
# # map_vacboost = map < baro ? -map_inhg : map_psi;

# coolantRaw = list[7]
# coolant = coolantRaw - 40
# iatRaw = list[6]
# iat = iatRaw - 40
# fueltempRaw = list[114]
# fueltemp = fueltempRaw - 40
# afr = list[10]
# stoich = 14.7
# afrTarget = list[21]
# lambdaval = afr / stoich
# lambdaTarget = afrTarget / stoich
# fuelpressureRaw = list[105]
# fuelpressure = fuelpressureRaw * 0.06894
# oilpressureRaw = list[105]
# oilpressure = oilpressureRaw * 0.06894
# rpm = list[14]
# vss=  list[14]
# tps = list[24]
# map = map_bar
# clt = coolant
# mat = iat
# oilPress = oilpressure
# oilTemp=  fueltemp
# fuelPress=  fuelpressure
# boost = map_psi
# batt = list[9]
# lambdaval = afr / stoich
# speed = vss
# speed_kph = vss
# intake = iat
# load = 44
# throttle
coolantm = 0
speedm = 0
rpmm = 0
coolanttempm = 0
intaketempm = 0
loadm = 0
throttlem =0
class DashWs(WebSocketClient):
    wsclient_thread = None
    wsclientopen = False

    def opened(self):
        print("Dash_opened")
        if self.wsclientopen == False:
            self.wsclient_thread = WSClientThread(
                "/dev/ttyUSB0",
                "115200",
                "8",
                "1",
                "N",
                self
            )
            self.wsclient_thread.setDaemon(True)
            self.wsclient_thread.start()
            self.wsclientopen = True
            pass

    def closed(self, code, reason=None):
        print("dash_closed")
        # pass

    def received_message(self, message):
        print(message.data)
        data = message.data.decode('utf-8')
        print(data)
        try:
            vars = data.split()
            list = data.split()
            # map_bar = (int(vars[4]) - int(vars[40])) / 101.33
            # map_psi = (int(vars[4]) - int(vars[40])) * 0.145038
            # map_inhg = (int(vars[40]) - int(vars[4])) * 0.2953007
            map = list[4]
            baro = list[40]

            # map_bar = (map - baro) / 101.33
            # map_psi = (map - baro) * 0.145038
            # map_inhg = (baro - map) * 0.2953007
            # map_vacboost = map < baro ? -map_inhg : map_psi;

            coolantRaw = list[7]
            # coolant = coolantRaw - 40
            iatRaw = list[6]
            iat = iatRaw# - 40
            fueltempRaw = list[114]
            # fueltemp = fueltempRaw - 40
            afr = list[10]
            stoich = 14.7
            afrTarget = list[21]
            # lambdaval = afr / stoich
            # lambdaTarget = afrTarget / stoich
            fuelpressureRaw = list[105]
            # fuelpressure = fuelpressureRaw * 0.06894
            oilpressureRaw = list[105]
            # oilpressure = oilpressureRaw * 0.06894
            rpm = list[14]
            vss=  list[14]
            tps = list[24]
            # map = map_bar
            # clt = coolant
            mat = iat
            # oilPress = oilpressure
            oilTemp=  fueltempRaw
            # fuelPress=  fuelpressure
            boost = map
            batt = list[9]
            lambdaval = afr# / stoich
            speed = vss
            speed_kph = vss
            intake = iat
            load = 44
            throttle = tps            
            coolantm = map
            speedm = vss
            rpmm = rpm
            coolanttempm = coolantRaw
            intaketempm = iat
            loadm = load
            throttlem =tps

            # print(basicdashdata)
        except Exception as error1:
            print("An exception occurred:", type(error1).__name__, "–", error1)
            print(json.dumps({"type":"error","error":"serial exception","exception":error1.__traceback__}))
        # if data["type"] == "send":
        #     self.wsclient_thread.send_message(data["message"])
        # elif data["type"] == "open":
        #     if self.wsclientopen == False:
        #         self.wsclient_thread = WSClientThread(
        #             data["port"],
        #             data["baudrate"],
        #             data["databit"],
        #             data["stopbit"],
        #             data["parity"],
        #             self
        #         )
        #         self.wsclient_thread.setDaemon(True)
        #         self.wsclient_thread.start()
        #         self.wsclientopen = True
        # elif data["type"] == "close":
        #     self.wsclient_thread.stop()
        # elif data["type"] == "exit":
        #     subprocess.check_output('killall - KILL SerialTool', shell=True)
        #     sys.exit()
        # else:
        #     pass


class WSClientThread(threading.Thread):
    def __init__(self, port, baudrate, databit, stopbit, parity, ws):
        super(WSClientThread, self).__init__()
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
        print("Starting run wsclient tthread")
        try:
            while not self.stop_event.is_set():
                # print("serial loop")
                self.count = self.count +1
                if self.count < 11:
                    time.sleep(0.1)
                elif self.count == 300:
                    self.count=11
                else:
                    time.sleep(0.01)
                    # print("serial requesting data")
                    
        except ValueError as error:
            # self.ws.send(json.dumps({"type":"error","error":"value error\n"}))
            print(json.dumps({"type":"error","error":"value error\n"}))
        except Exception as error1:
            print("An exception occurred:", type(error1).__name__, "–", error1)
            print(json.dumps({"type":"error","error":"serial exception","exception":error1.__traceback__}))
            # self.ws.send(json.dumps({"type":"error","error":"serial exception\n"}))


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


def getTMP():
    return coolantm
def getSpeed():
    return speedm
def getRPM():
    return rpmm
def getCoolantTemp():
    return coolanttempm
def getIntakeTemp():
    return intaketempm
def getLoad():
    return loadm
def getThrottle():
    return throttlem