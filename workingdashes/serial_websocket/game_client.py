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


class HUDWs(WebSocketClient):
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
        data = message.decode('utf-8')
        print(data)
        self.serial_thread.send_message(data)
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
        os.environ['SDL_VIDEODRIVER'] = 'fbcon'   #set up os environment to display to TFT
        os.environ['SDL_FBDEV'] = '/dev/fb1'
        os.putenv('SDL_FBDEV','/dev/fb1')
        os.putenv('SDL_MOUSEDEV', '/dev/null')
        os.environ['SDL_MOUSEDEV'] = '/dev/null'        
        self.black = 0, 0, 0
        self.white = 255, 255, 255
        self.blue = 84,179,247
        self.red = 255, 71, 71

        pygame.init()
        self.size = width, height = 480, 320
        self.screen = pygame.display.set_mode(self.size)
        # screen = pygame.display.set_mode((0,0), pygame.FULLSCREEN)
        self.width, self.height = self.screen.get_size()

        self.xfactor = self.width / 320
        self.yfactor = self.height / 240

        self.compass_background = pygame.image.load('compass_background.png')
        self.compass_background = pygame.transform.scale(self.compass_background, (int(200*self.xfactor),int(200*self.yfactor)))
        self.compass_needle = pygame.image.load('compass_needle.png')
        self.compass_needle = pygame.transform.scale(self.compass_needle, (int(150*self.xfactor),int(150*self.yfactor)))
        self.cb_rect = self.compass_background.get_rect()
        self.cn_rect = self.compass_background.get_rect()

        self.cb_rect.centerx = 165*self.xfactor
        self.cb_rect.centery = 107*self.yfactor
        self.cn_rect.centerx = 193*self.xfactor
        self.cn_rect.centery = 130*self.yfactor

        self.font = pygame.font.Font(None, int(20*self.yfactor))
        self.font2 = pygame.font.Font(None, int(30*self.yfactor))
        self.font3 = pygame.font.Font(None, int(27*self.yfactor))
        self.font_small = pygame.font.Font(None, int(18*self.yfactor))

        self.quit_text = self.font.render("QUIT",1,(255,250,255))   #set up texts as buttons
        self.q_text_pos = self.quit_text.get_rect()
        self.q_text_pos.centerx = screen.get_rect().centerx + (100*self.xfactor)
        self.q_text_pos.centery = screen.get_rect().centery + (100*self.yfactor)

        self.compass_text = self.font.render("COMPASS",1,(255,250,255))
        self.c_text_pos = self.compass_text.get_rect()
        self.c_text_pos.centerx = 70*self.xfactor
        self.c_text_pos.centery = 220*self.yfactor

        self.degree_text = self.font2.render("degrees",1,(255,250,255))
        self.d_text_pos = self.degree_text.get_rect()
        self.d_text_pos.centerx = 295*self.xfactor
        self.d_text_pos.centery = 25*self.yfactor

        self.temp_text = self.font2.render("temp",1,(255,250,255))
        self.t_text_pos = self.temp_text.get_rect()
        self.t_text_pos.centerx = 265*self.xfactor
        self.t_text_pos.centery = 180*self.yfactor

        self.accel_text = self.font3.render("accel",1,(255,250,255))
        self.a_text_pos = self.accel_text.get_rect()
        self.a_text_pos.centerx = 255*self.xfactor
        self.a_text_pos.centery = 110*self.yfactor

        self.velocity_text = self.font3.render("velocity",1,(255,250,255))
        self.v_text_pos = self.velocity_text.get_rect()
        self.v_text_pos.centerx = 60*self.xfactor
        self.v_text_pos.centery = 45*self.yfactor

        self.rpm_text = self.font3.render("rpm",1,(255,250,255))
        self.r_text_pos = self.velocity_text.get_rect()
        self.r_text_pos.centerx = 165*self.xfactor
        self.r_text_pos.centery = 45*self.yfactor

        self.dir_text = self.font3.render("N",1,(255,250,255))
        self.dir_text_pos = self.velocity_text.get_rect()
        self.dir_text_pos.centerx = 290*self.xfactor
        self.dir_text_pos.centery = 45*self.yfactor

        self.coolant_text = self.font_small.render("Coolant:",1,self.white)
        self.cool_text_pos = self.coolant_text.get_rect()
        self.cool_text_pos.centerx = 60*self.xfactor
        self.cool_text_pos.centery = 156 *self.yfactor

        self.ctemp_text = self.font2.render("123", 1, self.white)
        self.ctemp_pos = self.ctemp_text.get_rect()
        self.ctemp_pos.centerx = 45*self.xfactor
        self.ctemp_pos.centery = 180*self.yfactor

        self.intake_text = self.font_small.render("Intake:",1,self.white)
        self.intake_text_pos = self.coolant_text.get_rect()
        self.intake_text_pos.centerx = 165*self.xfactor
        self.intake_text_pos.centery = 156*self.yfactor

        self.itemp_text = self.font2.render("123", 1, self.white)
        self.itemp_pos = self.ctemp_text.get_rect()
        self.itemp_pos.centerx = 150*self.xfactor
        self.itemp_pos.centery = 180*self.yfactor

        self.ambient_text = self.font_small.render("Ambient:",1,self.white)
        self.ambient_text_pos = self.coolant_text.get_rect()
        self.ambient_text_pos.centerx = 260*self.xfactor
        self.ambient_text_pos.centery = 156*self.yfactor

        self.load_text = self.font_small.render("Load:",1,self.white)
        self.load_text_pos = self.load_text.get_rect()
        self.load_text_pos.centerx = 60*self.xfactor
        self.load_text_pos.centery = 85*self.yfactor

        self.lvalue_text = self.font3.render("55",1, self.blue)
        self.lvalue_text_pos = self.lvalue_text.get_rect()
        self.lvalue_text_pos.centerx = 50*self.xfactor
        self.lvalue_text_pos.centery = 110*self.yfactor

        self.tvalue_text = self.font3.render("55",1, self.blue)
        self.tvalue_text_pos = self.tvalue_text.get_rect()
        self.tvalue_text_pos.centerx = 160*self.xfactor
        self.tvalue_text_pos.centery = 110*self.yfactor

        self.throttle_text = self.font_small.render("Throttle:",1,self.white)
        self.throttle_text_pos = self.throttle_text.get_rect()
        self.throttle_text_pos.centerx = 165*self.xfactor
        self.throttle_text_pos.centery = 85*self.yfactor

        self.acceleration_text = self.font_small.render("Acceleration:",1,self.white)
        self.acceleration_text_pos = self.acceleration_text.get_rect()
        self.acceleration_text_pos.centerx = 265*self.xfactor
        self.acceleration_text_pos.centery = 85*self.yfactor

        self.speed_text = self.font_small.render("Speed:",1,self.white)
        self.speed_text_pos = self.speed_text.get_rect()
        self.speed_text_pos.centerx = 60*self.xfactor
        self.speed_text_pos.centery = 16*self.yfactor

        self.rotation_text = self.font_small.render("RPM:",1,self.white)
        self.rotation_text_pos = self.rotation_text.get_rect()
        self.rotation_text_pos.centerx = 165*self.xfactor
        self.rotation_text_pos.centery = 16*self.yfactor

        self.direction_text = self.font_small.render("Direction:",1,self.white)
        self.direction_text_pos = self.direction_text.get_rect()
        self.direction_text_pos.centerx = 265*self.xfactor
        self.direction_text_pos.centery = 16*self.yfactor


        self.display_compass = 0     #toggle displaying compass
        self.display_F = 0           #toggle displaying fahrenheit
        self.display_kph = 0         #toggle displaying km per hour


        self.time_count = 0
        self.acceleration = 0
        self.temperature = 55
    def stop(self):
        self.stop_event.set()

    def send_message(self, message):
        self.message = message
        # self.serial_port.reset_output_buffer()
        # self.serial_port.write(message.encode('utf-8').decode('unicode_escape').encode('utf-8'))
        # self.serial_port.write(message.encode('utf-8'))

    def run(self):
        self.count = 0
        print("Starting run tthread")
        try:
            print(self.message)       # data type is dict.. only showing values for the key 'price'
            self.time_count += 1
            try:
                result =  self.message    
                #   print(result)
                list = result.split()
                rpm = float(list[14])
                speed_kph=  rpm / 10
                speed=  speed_kph / 1.6
                coolantRaw = float(list[7])
                coolant = coolantRaw - 40
                iatRaw = float(list[6])
                intake = iatRaw - 40
                load = list[10]
                throttle = list[24]

                # data = result.decode('utf-8')
                # print(data)
                # temperature = getTMP()
                # speed = getSpeed()
                # rpm = getRPM()
                # coolant = getCoolantTemp()
                # intake = getIntakeTemp()
                # load = getLoad()
                # throttle = getThrottle()
            except Exception as error1:

                speed = 55 # temp
                speed_kph=  48

                rpm = 879 # temp
                coolant = 170
                intake = 110
                load = 44
                throttle = 78  
                # temperature = getTMP()
            # #speed = getSpeed()
            # #speed_kph = int(speed * 1.609344)
            # #rpm = getRMP()
            # #coolant = getCoolantTemp()
            # #intake = getIntakeTemp()
            # #load = getLoad()
            # #throttle = getThrottle()
            # speed = 55
            # speed_kph = 69
            # rpm = 879
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
                if p[0]>240 and p[0]<285 and p[1]>200 and p[1]<220: 
                    sys.exit()
                elif p[0]>50 and p[0]<90 and p[1]>200 and p[1]<230:
                    self.display_compass ^= 1
                elif p[0]>213 and p[0]<300 and p[1]>140 and p[1]<200 :
                    self.display_F ^= 1
                elif p[0]>20 and p[0]<self.width/3 and p[1]>20 and p[1]<70:
                    self.display_kph ^= 1 
                elif event.type == pygame.KEYDOWN:
                    k = event.key
                    print (k)
                    print(pygame.key.name(k))
                    #touch screen button press detection logic, for quit button
                    if k == pygame.K_q: 
                        sys.exit()
                    elif k == pygame.K_c: 
                        self.display_compass ^= 1
                    elif k == pygame.K_t: 
                        self.display_F ^= 1
                    elif k == pygame.K_k: 
                        self.display_kph ^= 1 

            #   print ("temperature is " + str(temperature))
            #   print ("heading is " + str(heading))
            #   print ("acceleration is " + str(acceleration))

            self.screen.fill(self.black)
            self.screen.blit(self.quit_text, self.q_text_pos)
            self.screen.blit(self.compass_text, self.c_text_pos)

            if self.display_compass:
                self.degree_text = self.font2.render(str(int(heading))+'\xb0', 1,(84,179,247))
                self.screen.blit(self.degree_text, self.d_text_pos)
                self.screen.blit(self.compass_background, self.cb_rect)
                new_compass_needle = self.rot_center(self.compass_needle, heading)  #added 90 as offset
                self.screen.blit(new_compass_needle, self.cn_rect)
            else:
                pygame.draw.line(self.screen, self.white, (20*self.xfactor, 70*self.yfactor), (300*self.xfactor, 70*self.yfactor))  
                pygame.draw.line(self.screen, self.white, (20*self.xfactor, 140*self.yfactor), (300*self.xfactor, 140*self.yfactor))  
                pygame.draw.line(self.screen, self.white, (self.width/3, 20*self.yfactor), (self.width/3, 200*self.yfactor))  
                pygame.draw.line(self.screen, self.white, (2*self.width/3, 20*self.yfactor), (2*self.width/3, 200*self.yfactor))  

                if self.display_F:
                    self.temperature = int(self.temperature * 9.0/5.0 + 32)
                    self.temp_text = self.font2.render(str(int(self.temperature))+'\xb0F', 1, self.blue)  
                else:
                    self.temp_text = self.font2.render(str(int(self.temperature))+'\xb0C', 1, self.blue)   
                self.screen.blit(temp_text, self.t_text_pos) 

                if abs(self.acceleration) < 1:
                    self.accel_text = self.font3.render('~0m/s\xb2', 1, self.blue)
                else:
                    self.accel_text = self.font3.render('%.2fm/s\xb2'%acceleration, 1, self.blue)
                self.screen.blit(self.accel_text, self.a_text_pos)

                if self.display_kph:
                    self.velocity_text = self.font3.render(str(speed_kph)+' km/h', 1, self.blue)
                else:
                    self.velocity_text = self.font3.render(str(speed)+' mph', 1, self.blue)
                self.screen.blit(velocity_text, v_text_pos)
                
                if heading < 22.5 or heading > 337.5:
                    self.dir_text = self.font2.render("N", 1, self.red)     
                elif heading > 22.5 and heading < 67.5:
                    self.dir_text = self.font2.render("NE", 1, self.red)
                elif heading > 67.5 and heading < 112.5:
                    self.dir_text = self.font2.render("E", 1, self.red)
                elif heading > 112.5 and heading < 157.5:
                    self.dir_text = self.font2.render("SE", 1, self.red)
                elif heading > 157.5 and heading < 202.5:
                    self.dir_text = self.font2.render("S", 1, self.red)
                elif heading > 202.5 and heading < 247.5:
                    self.dir_text = self.font2.render("SW", 1, self.red)
                elif heading > 247.5 and heading < 292.5:
                    self.dir_text = self.font2.render("W", 1, self.red)
                else:
                    self.dir_text = self.font2.render("NW", 1, self.red)
                self.screen.blit(self.dir_text, self.dir_text_pos)

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
                self.screen.blit(self.direction_text, self.direction_text_pos)

                self.ctemp_text = self.font2.render(str(coolant)+'\xb0F', 1, self.blue)
                self.screen.blit(self.ctemp_text, self.ctemp_pos)
                
                self.itemp_text = self.font2.render(str(intake)+'\xb0F', 1, self.blue)
                self.screen.blit(self.itemp_text, self.itemp_pos)

                self.lvalue_text = self.font2.render(str(load)+'%', 1, self.blue)
                self.screen.blit(self.lvalue_text, self.lvalue_text_pos)
                
                self.tvalue_text = self.font2.render(str(throttle)+'%', 1, self.blue)
                self.screen.blit(self.tvalue_text, self.tvalue_text_pos)

            pygame.display.flip()            
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
