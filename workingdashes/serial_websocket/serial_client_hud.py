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
import pygame

class SerialWs(WebSocketClient):
    serial_thread = None
    serialopen = False


    def opened(self):
        print("serial_client_opend")
        if self.serialopen == False:
            self.serial_thread = SerialThread(
                "/dev/ttyUSB0",
                "115200",
                "8",
                "1",
                "N",
                self
            )
            self.serial_thread.setDaemon(True)
            self.serial_thread.start()
            self.serialopen = True
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
            if self.serialopen == False:
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
                self.serialopen = True
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
        self.black = 0, 0, 0
        self.white = 255, 255, 255
        self.blue = 84,179,247
        self.red = 255, 71, 71

        pygame.init()
        pygame.mouse.set_visible(False)

        self.size = width, height = 320, 240
        self.screen = pygame.display.set_mode(self.size)

        self.compass_background = pygame.image.load('compass_background.png')
        self.compass_background = pygame.transform.scale(self.compass_background, (200,200))
        self.compass_needle = pygame.image.load('compass_needle.png')
        self.compass_needle = pygame.transform.scale(self.compass_needle, (150,150))
        self.cb_rect = self.compass_background.get_rect()
        self.cn_rect = self.compass_background.get_rect()

        self.cb_rect.centerx = 165
        self.cb_rect.centery = 107
        self.cn_rect.centerx = 193
        self.cn_rect.centery = 130

        self.font = pygame.font.Font(None, 20)
        self.font2 = pygame.font.Font(None, 30)
        self.font3 = pygame.font.Font(None, 27)
        self.font_small = pygame.font.Font(None, 18)

        self.quit_text = self.font.render("QUIT",1,(255,250,255))   #set up texts as buttons
        self.q_text_pos = self.quit_text.get_rect()
        self.q_text_pos.centerx = self.screen.get_rect().centerx + 100
        self.q_text_pos.centery = self.screen.get_rect().centery + 100

        self.compass_text = self.font.render("COMPASS",1,(255,250,255))
        self.c_text_pos = self.compass_text.get_rect()
        self.c_text_pos.centerx = 70
        self.c_text_pos.centery = 220

        self.degree_text = self.font2.render("degrees",1,(255,250,255))
        self.d_text_pos = self.degree_text.get_rect()
        self.d_text_pos.centerx = 295
        self.d_text_pos.centery = 25

        self.temp_text = self.font2.render("temp",1,(255,250,255))
        self.t_text_pos = self.temp_text.get_rect()
        self.t_text_pos.centerx = 265
        self.t_text_pos.centery = 180

        self.accel_text = self.font3.render("accel",1,(255,250,255))
        self.a_text_pos = self.accel_text.get_rect()
        self.a_text_pos.centerx = 255
        self.a_text_pos.centery = 110

        self.velocity_text = self.font3.render("velocity",1,(255,250,255))
        self.v_text_pos = self.velocity_text.get_rect()
        self.v_text_pos.centerx = 60
        self.v_text_pos.centery = 45

        self.rpm_text = self.font3.render("rpm",1,(255,250,255))
        self.r_text_pos = self.velocity_text.get_rect()
        self.r_text_pos.centerx = 165
        self.r_text_pos.centery = 45

        self.dir_text = self.font3.render("N",1,(255,250,255))
        self.dir_text_pos = self.velocity_text.get_rect()
        self.dir_text_pos.centerx = 290
        self.dir_text_pos.centery = 45

        self.coolant_text = self.font_small.render("Coolant:",1,self.white)
        self.cool_text_pos = self.coolant_text.get_rect()
        self.cool_text_pos.centerx = 60
        self.cool_text_pos.centery = 156 

        self.ctemp_text = self.font2.render("123", 1, self.white)
        self.ctemp_pos = self.ctemp_text.get_rect()
        self.ctemp_pos.centerx = 45
        self.ctemp_pos.centery = 180

        self.intake_text = self.font_small.render("Intake:",1,self.white)
        self.intake_text_pos = self.coolant_text.get_rect()
        self.intake_text_pos.centerx = 165
        self.intake_text_pos.centery = 156

        self.itemp_text = self.font2.render("123", 1, self.white)
        self.itemp_pos = self.ctemp_text.get_rect()
        self.itemp_pos.centerx = 150
        self.itemp_pos.centery = 180

        self.ambient_text = self.font_small.render("Ambient:",1,self.white)
        self.ambient_text_pos = self.coolant_text.get_rect()
        self.ambient_text_pos.centerx = 260
        self.ambient_text_pos.centery = 156

        self.load_text = self.font_small.render("Load:",1,self.white)
        self.load_text_pos = self.load_text.get_rect()
        self.load_text_pos.centerx = 60
        self.load_text_pos.centery = 85

        self.lvalue_text = self.font3.render("55",1, self.blue)
        self.lvalue_text_pos = self.lvalue_text.get_rect()
        self.lvalue_text_pos.centerx = 50
        self.lvalue_text_pos.centery = 110

        self.tvalue_text = self.font3.render("55",1, self.blue)
        self.tvalue_text_pos = self.tvalue_text.get_rect()
        self.tvalue_text_pos.centerx = 160
        self.tvalue_text_pos.centery = 110

        self.throttle_text = self.font_small.render("Throttle:",1,self.white)
        self.throttle_text_pos = self.throttle_text.get_rect()
        self.throttle_text_pos.centerx = 165
        self.throttle_text_pos.centery = 85

        self.acceleration_text = self.font_small.render("Acceleration:",1,self.white)
        self.acceleration_text_pos = self.acceleration_text.get_rect()
        self.acceleration_text_pos.centerx = 265
        self.acceleration_text_pos.centery = 85

        self.speed_text = self.font_small.render("Speed:",1,self.white)
        self.speed_text_pos = self.speed_text.get_rect()
        self.speed_text_pos.centerx = 60
        self.speed_text_pos.centery = 16

        self.rotation_text = self.font_small.render("RPM:",1,self.white)
        self.rotation_text_pos = self.rotation_text.get_rect()
        self.rotation_text_pos.centerx = 165
        self.rotation_text_pos.centery = 16

        self.direction_text = self.font_small.render("Direction:",1,self.white)
        self.direction_text_pos = self.direction_text.get_rect()
        self.direction_text_pos.centerx = 265
        self.direction_text_pos.centery = 16


        self.display_compass = 0     #toggle displaying compass
        self.display_F = 0           #toggle displaying fahrenheit
        self.display_kph = 0         #toggle displaying km per hour


        self.time_count = 0
        self.acceleration = 0

    def stop(self):
        self.stop_event.set()

    def send_message(self, message):
        self.serial_port.reset_output_buffer()
        self.serial_port.write(message.encode('utf-8').decode('unicode_escape').encode('utf-8'))
        # self.serial_port.write(message.encode('utf-8'))

    def rot_center(self, image, angle):
        """rotate an image while keeping its center and size"""
        self.orig_rect = image.get_rect()
        self.rot_image = pygame.transform.rotate(image, angle)
        self.rot_rect = self.orig_rect.copy()
        self.rot_rect.center = self.rot_image.get_rect().center
        self.rot_image = self.rot_image.subsurface(self.rot_rect).copy()
        return self.rot_image

    def run(self):
        self.count = 0
        print("Starting run tthread")
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
            print(json.dumps({
                "type":"status",
                "status":"connected",
                "condition": self.port + "/" + str(self.databit) + "/" + str(self.stopbit) + "/" + self.parity
            }))
            self.serial_port.reset_input_buffer()
            self.serial_port.reset_output_buffer()
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
                    list = lineout.split()
                    map = list[4]
                    baro = list[40]

                    map_bar = (map - baro) / 101.33
                    map_psi = (map - baro) * 0.145038
                    map_inhg = (baro - map) * 0.2953007
                    # map_vacboost = map < baro ? -map_inhg : map_psi;

                    coolantRaw = list[7]
                    coolant = coolantRaw - 40
                    iatRaw = list[6]
                    iat = iatRaw - 40
                    fueltempRaw = list[114]
                    fueltemp = fueltempRaw - 40
                    afr = list[10]
                    stoich = 14.7
                    afrTarget = list[21]
                    lambdaval = afr / stoich
                    lambdaTarget = afrTarget / stoich
                    fuelpressureRaw = list[105]
                    fuelpressure = fuelpressureRaw * 0.06894
                    oilpressureRaw = list[105]
                    oilpressure = oilpressureRaw * 0.06894
                    rpm = list[14]
                    vss=  list[14]
                    tps = list[24]
                    map = map_bar
                    clt = coolant
                    mat = iat
                    oilPress = oilpressure
                    oilTemp=  fueltemp
                    fuelPress=  fuelpressure
                    boost = map_psi
                    batt = list[9]
                    lambdaval = afr / stoich
                    speed = vss
                    speed_kph = vss
                    intake = iat
                    load = 44
                    throttle = tps
                    self.screen.fill(self.black)
                    self.screen.blit(self.quit_text, self.q_text_pos)
                    self.screen.blit(self.compass_text, self.c_text_pos)
                    pygame.draw.line(self.screen, self.white, (20, 70), (300, 70))  
                    pygame.draw.line(self.screen, self.white, (20, 140), (300, 140))  
                    pygame.draw.line(self.screen, self.white, (self.width/3, 20), (self.width/3, 200))  
                    pygame.draw.line(self.screen, self.white, (2*self.width/3, 20), (2*self.width/3, 200))  
                    self.rpm_text = self.font3.render(str(rpm)+' rpm', 1, self.blue)
                    self.screen.blit(self.rpm_text, self.r_text_pos)
                    self.screen.blit(self.coolant_text, self.cool_text_pos)
                    self.screen.blit(self.intake_text, self.intake_text_pos)
                    self.screen.blit(self.ambient_text, self.ambient_text_pos)
                    self.screen.blit(self.load_text, self.load_text_pos)
                    self.screen.blit(self.throttle_text, self.throttle_text_pos)
                    self.screen.blit(self.acceleration_text, self.acceleration_text_pos)
                    self.screen.blit(self.speed_text, self.speed_text_pos)
                    self.screen.blit(self.rotation_text, self.rotation_text_pos)
                    # self.screen.blit(self.direction_text, self.direction_text_pos)

                    self.ctemp_text = self.font2.render(str(coolant)+'\xb0F', 1, self.blue)
                    self.screen.blit(self.ctemp_text, self.ctemp_pos)

                    self.itemp_text = self.font2.render(str(intake)+'\xb0F', 1, self.blue)
                    self.screen.blit(self.itemp_text, self.itemp_pos)
                    self.lvalue_text = self.font2.render(str(load)+'%', 1, self.blue)
                    self.screen.blit(self.lvalue_text, self.lvalue_text_pos)
                    self.tvalue_text = self.font2.render(str(throttle)+'%', 1, self.blue)
                    self.screen.blit(self.tvalue_text, self.tvalue_text_pos)

                except:
                    error2 = "error"
                data["data"] = data["data"] + "\n"
                # self.ws.send(json.dumps(data, ensure_ascii=False))
                if lineout != "":
                    lineout = lineout + "\n"
                    # print(lineout)
                    self.ws.send(lineout.encode("ascii"))
                # self.ws.send(basicdashdata.encode("ascii"))
            self.ws.send(json.dumps({"type":"status","status":"disconnected","device":self.port}))
            print(json.dumps({"type":"status","status":"disconnected","device":self.port}))
            pygame.display.flip()
        except ValueError as error:
            self.ws.send(json.dumps({"type":"error","error":"value error\n"}))
            print(json.dumps({"type":"error","error":"value error\n"}))
        except Exception as error1:
            print("An exception occurred:", type(error1).__name__, "–", error1)
            print(json.dumps({"type":"error","error":"serial exception","exception":error1.__traceback__}))
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
