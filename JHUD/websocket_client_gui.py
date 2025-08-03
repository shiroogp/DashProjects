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
import sys
import os
import time

black = 0, 0, 0
white = 255, 255, 255
green = 50, 226, 50
blue = 84, 179, 247
red = 255, 71, 71

pygame.init()
pygame.mouse.set_visible(True) # no touch screen yet

screen = pygame.display.set_mode((0,0), pygame.FULLSCREEN)
width, height = screen.get_size()

font = pygame.font.Font(None, 40)
font2 = pygame.font.Font(None, 60)
font3 = pygame.font.Font(None, 54)
fontSmall = pygame.font.Font(None, 36)

quit_text = font.render("QUIT", 1, (255, 250, 255))   #set up texts as buttons
q_text_pos = quit_text.get_rect()
q_text_pos.centerx = screen.get_rect().centerx + 100
q_text_pos.centery = screen.get_rect().centery + 100

compass_text = font.render("COMPASS", 1, (255, 250, 255))
c_text_pos = compass_text.get_rect()
c_text_pos.centerx = 70
c_text_pos.centery = 220

display_compass = 0     #toggle displaying compass
display_F = 1           #toggle displaying fahrenheit
display_kph = 0         #toggle displaying km per hour

def rot_center(image, angle):
    """rotate an image while keeping its center and size"""
    orig_rect = image.get_rect()
    rot_image = pygame.transform.rotate(image, angle)
    rot_rect = orig_rect.copy()
    rot_rect.center = rot_image.get_rect().center
    rot_image = rot_image.subsurface(rot_rect).copy()
    return rot_image

time_count = 0
acceleration = 0

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
            black = 0, 0, 0
            white = 255, 255, 255
            green = 50, 226, 50
            blue = 84, 179, 247
            red = 255, 71, 71

            pygame.init()
            pygame.mouse.set_visible(True) # no touch screen yet

            screen = pygame.display.set_mode((0,0), pygame.FULLSCREEN)
            width, height = screen.get_size()

            font = pygame.font.Font(None, 40)
            font2 = pygame.font.Font(None, 60)
            font3 = pygame.font.Font(None, 54)
            fontSmall = pygame.font.Font(None, 36)

            quit_text = font.render("QUIT", 1, (255, 250, 255))   #set up texts as buttons
            q_text_pos = quit_text.get_rect()
            q_text_pos.centerx = screen.get_rect().centerx + 100
            q_text_pos.centery = screen.get_rect().centery + 100

            compass_text = font.render("COMPASS", 1, (255, 250, 255))
            c_text_pos = compass_text.get_rect()
            c_text_pos.centerx = 70
            c_text_pos.centery = 220

            # display_compass = 0     #toggle displaying compass
            # display_F = 1           #toggle displaying fahrenheit
            # display_kph = 0         #toggle displaying km per hour

            # def rot_center(image, angle):
            #     """rotate an image while keeping its center and size"""
            #     orig_rect = image.get_rect()
            #     rot_image = pygame.transform.rotate(image, angle)
            #     rot_rect = orig_rect.copy()
            #     rot_rect.center = rot_image.get_rect().center
            #     rot_image = rot_image.subsurface(rot_rect).copy()
            #     return rot_image

            time_count = 0
            acceleration = 0            
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
        while not self.stop_event.is_set():
            try:
                # print("serial loop")
                self.count = self.count +1
                if self.count < 11:
                    time.sleep(0.1)
                elif self.count == 300:
                    self.count=11
                else:
                    time.sleep(0.01)
                    # print("serial requesting data")
                time_count += 1
                temperature = getTMP()
                speed = getSpeed()
                rpm = getRPM()
                coolant = getCoolantTemp()
                intake = getIntakeTemp()
                load = getLoad()
                throttle = getThrottle()

                # speed = 55 # temp
                # rpm = 879 # temp
                # coolant = 170
                # intake = 110
                # load = 44
                # throttle = 78
                #Handle value error due to incorrect math domain
                try:
                    heading = 1000
                    if heading < 0:
                        heading = 360 + heading
                    if time_count % 2: 
                        acceleration = 50
                except ValueError:
                    pass

                for event in pygame.event.get():
                    if event.type == pygame.MOUSEBUTTONDOWN:
                        p = pygame.mouse.get_pos()
                    #touch screen button press detection logic, for quit button

                    # MARK: added in order to silence p event in the beiginning before p is defined
                    try:
                        if p == 0:
                            testedP = 1
                    except NameError:
                        continue

                    if p[0]>240 and p[0]<285 and p[1]>200 and p[1]<220: 
                        sys.exit()
                    elif p[0]>50 and p[0]<90 and p[1]>200 and p[1]<230:
                        display_compass ^= 1
                    elif p[0]>213 and p[0]<300 and p[1]>140 and p[1]<200 :
                        display_F ^= 1
                    elif p[0]>20 and p[0]<width/3 and p[1]>20 and p[1]<70:
                        display_kph ^= 1

                print("temperature is " + str(heading))
                print("heading is " + str(heading))
                print("acceleration is " + str(acceleration))
                print("speed is " + str(speed))
                print("RPM is " + str(rpm))
                print("coolant is " + str(coolant))
                print("intake is " + str(intake))
                print("load is " + str(load))
                print("throttle is " + str(throttle))

                screen.fill(black)
                screen.blit(quit_text, q_text_pos)
                screen.blit(compass_text, c_text_pos)

                # MARK: New Compass
                pygame.draw.line(screen, green, (width / 4, height / 2), (3 * width / 4, height / 2))

                # heading = 40 # used for debuging
                offset = (10 - (heading % 10)) / 10.0
                greenBarArray = [-1.5, -1.0, -0.5, 0.0, 0.5]
                if offset >= 0.8:
                    greenBarArray = [-2.0, -1.5, -1.0, -0.5, 0.0]
                elif offset <= 0.2:
                    greenBarArray = [-1.0, -0.5, 0.0, 0.5, 1.0]
                for mover in greenBarArray:
                    posComp = ((width / 2) + ((mover + offset) * (width / 5))) # HERE
                    pygame.draw.line(screen, green, (posComp, height / 2), (posComp, (height / 2) + (height / 12)))
                    if abs(mover) != 1.5 and abs(mover) != 0.5:
                        if offset > 0.5:
                            headingGText = font2.render(str(int(round(heading / 10) + mover + 1) * 10), 1, red)
                            greenHeadingRect = headingGText.get_rect()
                            greenHeadingRect.centerx = posComp
                            greenHeadingRect.centery = (height / 2) + (height / 6)
                            screen.blit(headingGText, greenHeadingRect)
                        else:
                            headingGText = font2.render(str(int(round(heading / 10) + mover) * 10), 1, red)
                            greenHeadingRect = headingGText.get_rect()
                            greenHeadingRect.centerx = posComp
                            greenHeadingRect.centery = (height / 2) + (height / 6)
                            screen.blit(headingGText, greenHeadingRect)

                # MARK: New Speed
                pygame.draw.line(screen, green, (width / 7, (height / 7) - 2), (width / 7, (6 * height / 7) + 2))
                pygame.draw.line(screen, green, (width / 7, (height / 7) - 2), (0, (height / 7) - 2))
                pygame.draw.line(screen, green, (width / 7, (6 * height / 7) + 2), (0, (6 * height / 7) + 2))

                offsetS = (speed % 10) / 10.0
                print("Offset: " + str(offsetS))

                speedBarArray = [-1.5, -1.0, -0.5, 0.0, 0.5, 1.0, 1.5]
                if offsetS >= 0.8:
                    speedBarArray = [-2.5, -2.0, -1.5, -1.0, -0.5, 0.0, 0.5]
                elif offsetS >= 0.3 and offsetS < 0.8:
                    speedBarArray = [-2.0, -1.5, -1.0, -0.5, 0.0, 0.5, 1.0]
                for moverB in speedBarArray:
                    if ((round(speed / 10) + (-1 * moverB)) * 10 < 0 and offsetS <= 0.5) or ((round(speed / 10) + (-1 * moverB)) * 10 < 10 and offsetS > 0.5):
                        continue
                    posSpeedBar = (height / 2) + ((moverB + (offsetS)) * (height / 5))
                    pygame.draw.line(screen, green, (width / 7, posSpeedBar), ((width / 7) - (height / 24), posSpeedBar))
                    if abs(moverB) != 1.5 and abs(moverB) != 0.5 and abs(moverB) != 2.5:
                        if offsetS > 0.5 or speed == 15:
                            speedTinyText = font.render(str(int(round(speed / 10) + (-1 * moverB)) * 10 - 10), 1, red)
                            speedTinyRect = speedTinyText.get_rect()
                            speedTinyRect.centerx = (width / 7) - (width / 14)
                            speedTinyRect.centery = posSpeedBar
                            screen.blit(speedTinyText, speedTinyRect)
                        else:
                            speedTinyText = font.render(str(int(round(speed / 10) + (-1 * moverB)) * 10), 1, red)
                            speedTinyRect = speedTinyText.get_rect()
                            speedTinyRect.centerx = (width / 7) - (width / 14)
                            speedTinyRect.centery = posSpeedBar
                            screen.blit(speedTinyText, speedTinyRect)

                rectBlackOut = pygame.Rect(0, 0, 0, 0)
                rectBlackOut.top = (height / 2) - (width / 25)
                rectBlackOut.left = (width / 7) - (width / 9)
                rectBlackOut.height = (2 * width / 25) + 1
                rectBlackOut.width = (width / 9) - 1
                pygame.draw.rect(screen, black, rectBlackOut)

                pygame.draw.line(screen, green, (width / 7, height / 2), ((width / 7) - (width / 25), (height / 2) + (width / 25)))
                pygame.draw.line(screen, green, (width / 7, height / 2), ((width / 7) - (width / 25), (height / 2) - (width / 25)))
                pygame.draw.line(screen, green, ((width / 7) - (width / 9), (height / 2) - (width / 25)), ((width / 7) - (width / 25), (height / 2) - (width / 25)))
                pygame.draw.line(screen, green, ((width / 7) - (width / 9), (height / 2) + (width / 25)), ((width / 7) - (width / 25), (height / 2) + (width / 25)))
                pygame.draw.line(screen, green, ((width / 7) - (width / 9), (height / 2) + (width / 25)), ((width / 7) - (width / 9), (height / 2) - (width / 25)))

                speedTrueText = font3.render(str(speed), 1, red)
                speedTrueRect = speedTrueText.get_rect()
                speedTrueRect.centerx = (width / 7) - ((width / 15))
                speedTrueRect.centery = height / 2
                screen.blit(speedTrueText, speedTrueRect)

                # MARK: New RPM
                pygame.draw.line(screen, green, (6 * width / 7, (height / 7) - 2), (6 * width / 7, (6 * height / 7) + 2))
                pygame.draw.line(screen, green, (6 * width / 7, (height / 7) - 2), (width, (height / 7) - 2))
                pygame.draw.line(screen, green, (6 * width / 7, (6 * height / 7) + 2), (width, (6 * height / 7) + 2))

                rpm = int(rpm / 10)
                offsetS = (rpm % 10) / 10.0
                print("Offset: " + str(offsetS))

                speedBarArray = [-1.5, -1.0, -0.5, 0.0, 0.5, 1.0, 1.5]
                if offsetS >= 0.8:
                    speedBarArray = [-2.5, -2.0, -1.5, -1.0, -0.5, 0.0, 0.5]
                elif offsetS >= 0.3 and offsetS < 0.8:
                    speedBarArray = [-2.0, -1.5, -1.0, -0.5, 0.0, 0.5, 1.0]
                for moverB in speedBarArray:
                    if ((round(rpm / 10) + (-1 * moverB)) * 10 < 0 and offsetS <= 0.5) or ((round(rpm / 10) + (-1 * moverB)) * 10 < 10 and offsetS > 0.5):
                        continue
                    posSpeedBar = (height / 2) + ((moverB + (offsetS)) * (height / 5))
                    pygame.draw.line(screen, green, (6 * width / 7, posSpeedBar), ((6 * width / 7) + (height / 24), posSpeedBar))
                    if abs(moverB) != 1.5 and abs(moverB) != 0.5 and abs(moverB) != 2.5:
                        if offsetS > 0.5 or rpm == 15:
                            speedTinyText = font.render(str(int(round(rpm / 10) + (-1 * moverB)) * 10 - 10), 1, red)
                            speedTinyRect = speedTinyText.get_rect()
                            speedTinyRect.centerx = (6 * width / 7) + (width / 14)
                            speedTinyRect.centery = posSpeedBar
                            screen.blit(speedTinyText, speedTinyRect)
                        else:
                            speedTinyText = font.render(str(int(round(rpm / 10) + (-1 * moverB)) * 10), 1, red)
                            speedTinyRect = speedTinyText.get_rect()
                            speedTinyRect.centerx = (6 * width / 7) + (width / 14)
                            speedTinyRect.centery = posSpeedBar
                            screen.blit(speedTinyText, speedTinyRect)

                rectBlackOutRev = pygame.Rect(0, 0, 0, 0)
                rectBlackOutRev.top = (height / 2) - (width / 25)
                rectBlackOutRev.width = (width / 9) - 1
                rectBlackOutRev.right = (6 * width / 7) + (width / 9) # Check Debug Here
                rectBlackOutRev.height = (2 * width / 25) + 1
                
                pygame.draw.rect(screen, black, rectBlackOutRev)

                pygame.draw.line(screen, green, (6 * width / 7, height / 2), ((6 * width / 7) + (width / 25), (height / 2) + (width / 25)))
                pygame.draw.line(screen, green, (6 * width / 7, height / 2), ((6 * width / 7) + (width / 25), (height / 2) - (width / 25)))
                pygame.draw.line(screen, green, ((6 * width / 7) + (width / 9), (height / 2) - (width / 25)), ((6 * width / 7) + (width / 25), (height / 2) - (width / 25)))
                pygame.draw.line(screen, green, ((6 * width / 7) + (width / 9), (height / 2) + (width / 25)), ((6 * width / 7) + (width / 25), (height / 2) + (width / 25)))
                pygame.draw.line(screen, green, ((6 * width / 7) + (width / 9), (height / 2) + (width / 25)), ((6 * width / 7) + (width / 9), (height / 2) - (width / 25)))

                speedTrueText = font3.render(str(rpm), 1, red)
                speedTrueRect = speedTrueText.get_rect()
                speedTrueRect.centerx = (6 * width / 7) + ((width / 15))
                speedTrueRect.centery = height / 2
                screen.blit(speedTrueText, speedTrueRect)
                
                pygame.display.flip()
                time.sleep(0.1)                    
            except ValueError as error:
                # self.ws.send(json.dumps({"type":"error","error":"value error\n"}))
                print(json.dumps({"type":"error","error":"value error\n"}))
            except Exception as error1:
                print("An exception occurred:", type(error1).__name__, "–", error1)
                # print(json.dumps({"type":"error","error":"serial exception","exception":error1.__traceback__}))
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