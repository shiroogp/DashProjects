#Hud.py
#This program will compile all the IMU and OBDII readings
#and display them onto the TFT screen.
#Created by XiaoXing Zhao and William Voge
#Edited 5/16/2016

import sys
#import pydevd;pydevd.settrace("10.0.3.47", port=5678)
import os
import time
from rpiIMU import *
from temp_read import *
#from pynog import *
import serial
import io
import os
from math import *
import time
from time import strftime
import datetime
from time import strftime
import datetime
import RPi.GPIO as GPIO

import time, signal, sys 
from PyQt5.QtCore import *
from PyQt5.QtGui import *
from PyQt5.QtWidgets import *
from PyQt5.QtQuick import *

# os.environ['SDL_VIDEODRIVER'] = 'fbcon'   #set up os environment to display to TFT
# os.environ['SDL_FBDEV'] = '/dev/fb1'
# os.environ['SDL_MOUSEDEV'] = '/dev/input/touchscreen' #set up touchscreen as mouse input
# os.environ['SDL_MOUSEDRV'] = 'TSLIB'


def timestamp():
  now = time.time()
  localtime = time.localtime(now)
  milliseconds = '%03d' % int((now - int(now)) * 1000)



class WorkerSignals(QObject):
    '''
    Defines the signals available from a running worker thread.

    Supported signals are:

    finished
        No data

    error
        `tuple` (exctype, value, traceback.format_exc() )

    result
        `object` data returned from processing, anything

    progress
        `int` indicating % progress

    '''
    finished = pyqtSignal()
    error = pyqtSignal(tuple)
    result = pyqtSignal(object)
    progress = pyqtSignal(int)
    speed = pyqtSignal(int)
    rpm = pyqtSignal(int)
    wtemp = pyqtSignal(int)
    atemp = pyqtSignal(int)
    otemp = pyqtSignal(int)

class Worker(QRunnable):
    '''
    Worker thread

    Inherits from QRunnable to handler worker thread setup, signals and wrap-up.

    :param callback: The function callback to run on this worker thread. Supplied args and 
                     kwargs will be passed through to the runner.
    :type callback: function
    :param args: Arguments to pass to the callback function
    :param kwargs: Keywords to pass to the callback function

    '''

    def __init__(self, fn, *args, **kwargs):
        super(Worker, self).__init__()

        # Store constructor arguments (re-used for processing)
        self.fn = fn
        self.args = args
        self.kwargs = kwargs
        self.signals = WorkerSignals()

        # Add the callback to our kwargs
        self.kwargs['progress_callback'] = self.signals.progress

#    @pyqtSlot()

#if cpuserial != sernum:
#  try:
#    file = open("/home/pi/sernum.dat", "r")
#    sernum = file.readline(16)
#    print ("SD card Serial ID " + sernum
#    if cpuserial != sernum:
#      print ("Mismatch ID"
#      mismach = 1
#      screen_view = 15
#  except:
#    print ("No security set"
    @pyqtSlot()
    def run(self):
        '''
        Initialise the runner function with passed args, kwargs.
        '''
        black = 0, 0, 0
        white = 255, 255, 255
        blue = 84,179,247
        red = 255, 71, 71
        
        
        
        time_count = 0
        acceleration = 0
        
        
        
        
        en_buttons = 1
        demomode = 0
        ratio = 105
        # Enter code here else bootup on screen 9 only
        dashnumber = "00001"
        sernum = "000000000f8b6eb0"
        dispv = 1
        spits = 0
        black = (0, 0, 0)
        blue = (0, 0, 200)
        red = (255, 0, 0)
        green = (0, 255, 0)
        white = (255, 255, 255)
        yellow = (255, 255, 0)
        cyan = (0, 255, 255)
        purple = (128, 0, 128)
        grey = (125, 125, 125)
        silver = (192, 192, 192)
        orange = (255, 128, 0)
        pink = (255, 128, 255)
        darkgreen = (0, 128, 64)
        darkblue = (0, 0, 160)
        rpml = 1
        rpmh = 1
        
        # GPIO Dash Button Inputs
        
        # External Inputs
        GPIO.setmode(GPIO.BCM)
        GPIO.setwarnings(False)
        GPIO.setup(22, GPIO.IN, pull_up_down=GPIO.PUD_UP)
        
        # GPIO Outputs
        GPIO.setup(23, GPIO.OUT)
        GPIO.setup(24, GPIO.OUT)
        GPIO.setup(25, GPIO.OUT)
        GPIO.setup(26, GPIO.OUT)
        GPIO.setup(27, GPIO.OUT)
        GPIO.output(23, 1)
        GPIO.output(24, 1)
        GPIO.output(25, 1)
        GPIO.output(26, 1)
        GPIO.output(27, 1)
        
        gettime = strftime("%H%M", time.localtime())
        getdate = strftime("%d%b", time.localtime())
        
        # This works to set date / time
        # gpsdt = "20150222 13:23:03.000"
        # os.system('sudo date -u --set="%s"' % gpsdt)
        
        # pygame.init()
        # screen = pygame.display.set_mode((1200,720))
        # pygame.display.set_caption('PowerMods ECU Display')
        # pygame.font.init()
        # pygame.display.update()
        # pygame.mouse.set_visible(False)
        serlog_val = 0
        
        # background = pygame.Surface(screen.get_size())
        # background = background.convert()
        # background.fill((0,0,0))
        
        
        # pygame.font.init()
        # pygame.display.update()
        # pygame.mouse.set_visible(False)
        
        # font = pygame.font.SysFont("freemono", 40, bold = 1)
        # text = font.render("PowerMods Dash ECU",1,(250,0,0))
        # textpos = text.get_rect()
        # textpos.centerx = background.get_rect().centerx
        # background.blit(text,textpos)
        # screen.blit(background,(0,0))
        # pygame.display.flip()
        load = 1
        
        os.system('cd /home/pi/pi-car-hud')
        # load new dash.cfg logo.jpg dash.py track.dat
        # if os.path.exists("/dev/sda1"):
        print "Mounting usb drive"
        os.system('mount /dev/sda1 /media/Transcend')
        if GPIO.input(22) == 0:
          en_buttons = 0
        
        if os.path.exists("/media/Transcend/dashKi.py"):
          # pygame.draw.rect(background,(250,250,250),(200,450,450,30))
          # font = pygame.font.Font(None, 30)
          # text = font.render("Dash File Reading",2,(0,0,0))
          # textpos.top = 450
          # textpos.left = 200
          # background.blit(text,textpos)
          # screen.blit(background,(0,0))
          # pygame.display.flip()
          os.system('cp /media/Transcend/dashKi.py /home/pi/')
          time.sleep(2)
          # pygame.draw.rect(background,(250,250,250),(200,450,450,30))
          # font = pygame.font.Font(None, 30)
          # text = font.render("Dash File Loading",2,(0,0,0))
          # textpos.top = 450
          # textpos.left = 200
          # background.blit(text,textpos)
          # screen.blit(background,(0,0))
          # pygame.display.flip()
          os.system('cp /media/Transcend/dashKi.py /home/pi/')
          time.sleep(2)
          # pygame.draw.rect(background,(250,250,250),(200,450,450,30))
          # font = pygame.font.Font(None, 30)
          # text = font.render("Dash File Preparing",2,(0,0,0))
          # textpos.top = 450
          # textpos.left = 200
          # background.blit(text,textpos)
          # screen.blit(background,(0,0))
          # pygame.display.flip()
          # time.sleep(2)
          os.system('sudo chmod 755 dashKi.py')
          # pygame.draw.rect(background,(250,250,250),(200,450,450,30))
          # font = pygame.font.Font(None, 30)
          # text = font.render("Dash File Load Complete",2,(0,0,0))
          # textpos.top = 450
          # textpos.left = 200
          # background.blit(text,textpos)
          # screen.blit(background,(0,0))
          # pygame.display.flip()
          time.sleep(2)
        
        # if os.path.exists("/media/Transcend/logo.jpg"):
        #     	img=pygame.image.load("/media/Transcend/logo.jpg")
        #     	img=pygame.transform.scale(img,(800,480))
        #     	screen.blit(img,(0,0))
        #     	pygame.display.flip()
        # 	time.sleep(.5)
        # else:
        #     if os.path.exists("/media/Transcend/logo.png"):
        #     	img=pygame.image.load("/media/Transcend/logo.png")
        #         img=pygame.transform.scale(img,(800,480))
        #         screen.blit(img,(0,0))
        #         pygame.display.flip()
        # 	time.sleep(.5)
        
        displ = 1
        alarm_led = 0
        data_refresh = 1
        gps_refresh = 1
        ecu_alarm = 0
        red = 1
        green = 1
        blue = 1
        data_rate = 1
        gps_rate = 0
        get_index = 1
        log_count = 1
        cyl = 4
        m = 84
        o = 36
        d = chr(36)
        rpmh = 2
        rpmfp = 0
        rpmd = 3000
        rpmdisplay = 3000
        fuel_M = 2
        fuel_T = 7.5
        fuel_A = .6
        ign_A = 12
        ecu_id = 1
        w_temp = 84
        a_temp = 60
        tps = 75
        tpsmsb = 0
        mapmsb = 3
        an_1msb = 0
        an_1 = 0
        an_2 = 90
        afr = 13.4
        mapsensor = 2.5
        volts = 13.8
        dtset = 0
        log_gps = 1
        speed_l = 250
        speed1 = 0
        speed2 = 0
        speed3 = 0
        speed4 = 0
        speed5 = 0
        speed = str(0)
        vector = "0.0"
        vector1 = "0"
        vector2 = "0"
        vector3 = "0"
        vector4 = "."
        vector5 = "0"
        lattitude = "00.0000"
        latbit1 = "0"
        latbit2 = "0"
        latbit3 = "."
        latbit4 = "0"
        latbit5 = "0"
        latbit6 = "0"
        latbit7 = "0"
        latbit8 = "0"
        latbit9 = "0"
        longitude = "00.00"
        longbit1 = "0"
        longbit2 = "0"
        longbit3 = "0"
        longbit4 = "."
        longbit5 = "0"
        longbit6 = "0"
        longbit7 = "0"
        longbit8 = "0"
        longbit9 = "0"
        longbit10 = "0"
        dategps = "010115"
        datebit1 = "0"
        datebit2 = "1"
        datebit3 = "0"
        datebit4 = "1"
        datebit5 = "1"
        datebit6 = "5"
        timegps = "130000"
        timebit1 = "1"
        timebit2 = "3"
        timebit3 = "0"
        timebit4 = "0"
        timebit5 = "0"
        timebit6 = "0"
        speedg = 0
        gear = 1
        # Default Zwartkops
        x_lat = 25.809317
        y_long = 28.112109
        latcen = x_lat - 0.01
        longcen = y_long - 0.01
        lap_lat = 25.809317
        lap_long = 28.112109
        s1_lat = 25.808270
        s1_long = 28.109386
        s2_lat = 25.811848
        s2_long = 28.111715
        s1latcen = s1_lat - 0.01
        s1longcen = s1_long - 0.01
        s2latcen = s2_lat - 0.01
        s2longcen = s2_long - 0.01
        X = 10
        Y = 20
        gpslock = 0
        start_log_en = 0
        log_en = 0
        log_size = 0
        rpmlow_count = 0
        rpmhigh_count = 0
        log_man = 0
        lastsec = strftime("%S", time.localtime())
        lastmin = strftime("%M", time.localtime())
        lastmilli = 0
        laptime = 0
        laptime1 = 0
        laptime2 = 0
        laptime3 = 0
        laptime4 = 0
        laptime5 = 0
        laptime6 = 0
        laptime7 = 0
        laptime8 = 0
        laptime9 = 0
        laptime10 = 0
        laptime11 = 0
        s1_time = 0
        s2_time = 0
        laptrig = 0
        s1_trig = 0
        s2_trig = 0
        laps_done = 0
        splittime1 = 1
        splittime2 = 1
        splittime3 = 1
        splittime4 = 1
        splittime5 = 1
        splittime6 = 1
        splittime7 = 1
        splittime8 = 1
        splittime9 = 1
        splittime10 = 1
        splittime11 = 1
        deltatime = 0
        lap_reset = 1
        start_time = 0
        laptime = 0
        start_time = time.time()
        data_time = time.time()
        kw_time = time.time()
        gps_time = time.time()
        disp_now = 1
        screen_view = 0
        load_site = 1
        rpm_site = 1
        all_ranges = 33
        ranges = "1"
        map_site = 12
        load_site = 12
        afr_lim = 13
        batt_lim = 11.5
        boost_lim = 1
        oiltemp_lim = 145
        oilpress_lim = 2
        fuelpress_lim = 2
        watertemp_lim = 90
        sl_max = 6800
        sl_step = 100
        k_temp = 1
        ka_temp = 1
        k_an1 = 1
        k_an2 = 1
        chipswop = 300
        map_kpa = 2
        lap_dia = 5
        lat_acc = 0
        long_acc = 0
        an_mode = 0  # 0=oil press+temp 1=egt1+egt2 2=dbw1+dbw2
        ign_trig = 40
        adxl_sel = 0
        adc_sel = 0
        gps_sel = 1
        ecu_alarm = 0
        ecu_sel = 0
        dirx = 1
        diry = 1
        Xlat = 525
        Ylong = 240
        blink = 0
        log_on = 0
        log_time = 1
        besttime = 300
        bestlap = 1
        xlattest = 0
        an_log20 = 1
        track_sel = 0
        track_no = 0
        track_name = "My Track"
        sector1_name = "Sector 1"
        sector2_name = "Sector 2"
        data_ave = 0
        uparrow = 1
        downarrow = 1
        leftarrow = 1
        rightarrow = 1
        kw_cal = 1000
        rpmkw2 = 500
        rpmkw1 = 400
        chipswop = 300
        # ser.write("H")     #Trig????
        # ser.write("W")     #AUX
        # ser.write("X")     #MAIN????
        # ser.write("Q")     #All Ranges on
        # ser.write("Y")     #All ranges off
        # ser.write("J")     #Apply Config
        
        if os.path.exists("/media/Transcend/dash.cfg"):
          try:
            file = open("/media/Transcend/dash.cfg", "r")
            desc_line = file.readline()
            sl_max = int(file.readline())
            desc_line = file.readline()
            sl_step = int(file.readline())
            desc_line = file.readline()
            boost_lim = float(file.readline())
            desc_line = file.readline()
            oiltemp_lim = float(file.readline())
            desc_line = file.readline()
            oilpress_lim = float(file.readline())
            desc_line = file.readline()
            watertemp_lim = float(file.readline())
            desc_line = file.readline()
            batt_lim = float(file.readline())
            desc_line = file.readline()
            afr_lim = float(file.readline())
            desc_line = file.readline()
            map_kpa = float(file.readline())
            desc_line = file.readline()
            lap_dia = int(file.readline())
            desc_line = file.readline()
            an_mode = int(file.readline())
            desc_line = file.readline()
            ign_trig = int(file.readline())
            desc_line = file.readline()
            screen_view = int(file.readline())
            desc_line = file.readline()
            adxl_sel = int(file.readline())
            desc_line = file.readline()
            adc_sel = int(file.readline())
            desc_line = file.readline()
            gps_sel = int(file.readline())
            desc_line = file.readline()
            ecu_sel = int(file.readline())
            desc_line = file.readline()
            ratio = int(file.readline())
            desc_line = file.readline()
            k_temp = float(file.readline())
            desc_line = file.readline()
            ka_temp = float(file.readline())
            desc_line = file.readline()
            k_an1 = float(file.readline())
            desc_line = file.readline()
            k_an2 = float(file.readline())
            desc_line = file.readline()
            kw_cal = float(file.readline())
            file.close()
          except:
            print "File usb error"
        
        else:
          try:
            if os.path.exists("/home/pi/dash.cfg"):
              file = open("/home/pi/dash.cfg", "r")
              desc_line = file.readline()
              sl_max = int(file.readline())
              desc_line = file.readline()
              sl_step = int(file.readline())
              desc_line = file.readline()
              boost_lim = float(file.readline())
              desc_line = file.readline()
              oiltemp_lim = float(file.readline())
              desc_line = file.readline()
              oilpress_lim = float(file.readline())
              desc_line = file.readline()
              watertemp_lim = float(file.readline())
              desc_line = file.readline()
              batt_lim = float(file.readline())
              desc_line = file.readline()
              afr_lim = float(file.readline())
              desc_line = file.readline()
              map_kpa = float(file.readline())
              desc_line = file.readline()
              lap_dia = int(file.readline())
              desc_line = file.readline()
              an_mode = int(file.readline())
              desc_line = file.readline()
              ign_trig = int(file.readline())
              desc_line = file.readline()
              screen_view = int(file.readline())
              desc_line = file.readline()
              adxl_sel = int(file.readline())
              desc_line = file.readline()
              adc_sel = int(file.readline())
              desc_line = file.readline()
              gps_sel = int(file.readline())
              desc_line = file.readline()
              ecu_sel = int(file.readline())
              desc_line = file.readline()
              ratio = int(file.readline())
              desc_line = file.readline()
              k_temp = float(file.readline())
              desc_line = file.readline()
              ka_temp = float(file.readline())
              desc_line = file.readline()
              k_an1 = float(file.readline())
              desc_line = file.readline()
              k_an2 = float(file.readline())
              desc_line = file.readline()
              kw_cal = float(file.readline())
              file.close()
          except:
            print "File sd card error"
        
        if not os.path.exists("/home/pi/dash.cfg"):
          file = open("/home/pi/dash.cfg", "a")
          file.write("Rpm max eg 6800:- " + "\n")
          file.write(str(sl_max) + "\n")
          file.write("Rpm sl step eg 150:- " + "\n")
          file.write(str(sl_step) + "\n")
          file.write("Boost max kPa eg 0.5:- " + "\n")
          file.write(str(boost_lim) + "\n")
          file.write("Oil Temp max eg 120:- " + "\n")
          file.write(str(oiltemp_lim) + "\n")
          file.write("Oil Press min kPa eg 2.5:- " + "\n")
          file.write(str(oilpress_lim) + "\n")
          file.write("Water Temp max eg 98:- " + "\n")
          file.write(str(watertemp_lim) + "\n")
          file.write("Battery Min eg 11.5:- " + "\n")
          file.write(str(batt_lim) + "\n")
          file.write("AFR Max eg 13.2:- " + "\n")
          file.write(str(afr_lim) + "\n")
          file.write("Mapsensor Range Bar eg 2:- = Std 3 = 3bar" + "\n")
          file.write(str(map_kpa) + "\n")
          file.write("Lap Time Circle eg 5:- " + "\n")
          file.write(str(lap_dia) + "\n")
          file.write("Analog Mode eg (0=Oil P + Oil T) (1 = EGT1 +EGT2) (2 = DBW1 + DBW2):- " + "\n")
          file.write(str(an_mode) + "\n")
          file.write("Ignition Preset eg 40:- " + "\n")
          file.write(str(ign_trig) + "\n")
          file.write("Boot Screen eg 0=classic 1=data 2=gauge 3=laptimes 4=GPs 5=mapping 6=hi speed log :- " + "\n")
          file.write(str(screen_view) + "\n")
          file.write("Adxl Screen eg 0=no adxl345, 1=adxl345 present:- " + "\n")
          file.write(str(adxl_sel) + "\n")
          file.write("Adc Screen eg 0=no Adc, 1=Adc present:- " + "\n")
          file.write(str(adc_sel) + "\n")
          file.write("Gps Screen eg 0=no Gps, 1=Gps present:- " + "\n")
          file.write(str(gps_sel) + "\n")
          file.write("ECUs Type eg 0=PowerMods, 1=Gotech, 2=Dicktator:- " + "\n")
          file.write(str(ecu_sel) + "\n")
          file.write("Gear Ratio. Speed at 3000rpm in 4th gear:- " + "\n")
          file.write(str(ratio) + "\n")
          file.write("Temp Cal:- " + "\n")
          file.write(str(k_temp) + "\n")
          file.write("A Temp Cal:- " + "\n")
          file.write(str(ka_temp) + "\n")
          file.write("Analog 1 Cal:- " + "\n")
          file.write(str(k_an1) + "\n")
          file.write("Analog 2 Cal:- " + "\n")
          file.write(str(k_an2) + "\n")
          file.write("Power Calibrate:- " + "\n")
          file.write(str(kw_cal) + "\n")
          file.close()
        
        kw_refresh = 1
        power = 100
        power1 = 100
        power2 = 100
        power_adj = 1
        
        # if GPIO.input(22)==0:
        # 	font = pygame.font.Font(None,50)
        #         text = font.render("BUTTON PRESSED ON BOOT, SAFE MODE SET" ,2,(255,0,0))
        #         textpos.top = 100
        #         textpos.left = 5
        #         background.blit(text,textpos)
        #         screen.blit(background,(0,0))
        #         pygame.display.flip()
        # 	time.sleep(1)
        # 	print "Button Screen view pressed on boot"
        # 	adc_sel=0
        #         adxl_sel=0
        # 	gps_sel=0
        # en_buttons=0
        adc_sel = 0
        adxl_sel = 0
        adxl_s = adxl_sel
        adc_s = adc_sel
        scr_view = screen_view
        print "sl max: " + str(sl_max)
        print "sl step: " + str(sl_step)
        print "boost alarm: " + str(boost_lim)
        print "Oil T alarm: " + str(oiltemp_lim)
        print "Oil P alarm: " + str(oilpress_lim)
        print "Water T alarm: " + str(watertemp_lim)
        print "Battery alarm: " + str(batt_lim)
        print "AFR alarm: " + str(afr_lim)
        print "Map Type: " + str(map_kpa)
        print "Lap Trig Diameter: " + str(lap_dia)
        print "Analog Mode: " + str(an_mode)
        print "Ignition Preset: " + str(ign_trig)
        print "Boot Screen: " + str(screen_view)
        print "ADXL 345: " + str(adxl_sel)
        print "ADC 1015: " + str(adc_sel)
        print "GPS : " + str(gps_sel)
        print "ECU : " + str(ecu_sel)
        print sernum
        if ecu_sel == 2 or ecu_sel == 3:
          cyl = ign_trig
          ign_trig = 40
        swap_usb = 0
        
        while not os.path.exists("/dev/ttyUSB0"):
          print "USB0 SER NOT PRESENT"
          # font = pygame.font.Font(None,50)
          #    text = font.render("USB0 SER NOT PRESENT" ,2,(255,0,0))
          #    textpos.top = 200
          #    textpos.left = 20
          #    background.blit(text,textpos)
          #    screen.blit(background,(0,0))
          #    pygame.display.flip()
          time.sleep(1)
        
        if gps_sel==1:
          try:
        #     if not os.path.exists("/dev/ttyUSB1"):
        # 	font = pygame.font.Font(None,50)
        #         text = font.render("USB1 SER NOT PRESENT, UNLOADING GPS" ,2,(255,0,0))
        #         textpos.top = 200
        #         textpos.left = 20
        #         background.blit(text,textpos)
        #         screen.blit(background,(0,0))
        #         pygame.display.flip()
        # 	time.sleep(0.5)
                 gps_sel=0
          except:
                 gps_sel=0
        
        if ecu_sel == 0:
          ser = serial.Serial(
            port='/dev/ttyUSB0',
            baudrate=115200,
            parity=serial.PARITY_NONE,
            stopbits=serial.STOPBITS_ONE,
            bytesize=serial.EIGHTBITS,
          )
        else:
          ser = serial.Serial(
            port='/dev/ttyUSB0',
            baudrate=19200,
            parity=serial.PARITY_NONE,
            stopbits=serial.STOPBITS_ONE,
            bytesize=serial.EIGHTBITS,
          )
        
        i = 0
        tcount = 0
        while i < 300 and os.path.exists("/dev/ttyUSB1"):
          chgps = ser.read(size=1)
          o = (ord(chgps))
          d = chr(o)
          while d <> "T" and i < 300:
            i = i + 1
            chgps = ser.read(size=1)
            o = (ord(chgps))
            d = chr(o)
            print "D " + d
            print "C " + str(i)
          tcount = tcount + 1
          i = i + 1
          print "T " + str(tcount)
        if tcount < 3 and os.path.exists("/dev/ttyUSB1"):
          swap_usb = 1
          print "USB Swapped"
          if ecu_sel == 0:
            ser = serial.Serial(
              port='/dev/ttyUSB1',
              baudrate=115200,
              parity=serial.PARITY_NONE,
              stopbits=serial.STOPBITS_ONE,
              bytesize=serial.EIGHTBITS,
            )
          else:
            ser = serial.Serial(
              port='/dev/ttyUSB1',
              baudrate=19200,
              parity=serial.PARITY_NONE,
              stopbits=serial.STOPBITS_ONE,
              bytesize=serial.EIGHTBITS,
            )
        
        if os.path.exists("/dev/ttyUSB1"):
          print "USB1 Found"
          if swap_usb == 0:
            sergps = serial.Serial(
              port='/dev/ttyUSB1',
              baudrate=38400,
              parity=serial.PARITY_NONE,
              stopbits=serial.STOPBITS_ONE,
              bytesize=serial.EIGHTBITS,
            )
          else:
            sergps = serial.Serial(
              port='/dev/ttyUSB0',
              baudrate=38400,
              parity=serial.PARITY_NONE,
              stopbits=serial.STOPBITS_ONE,
              bytesize=serial.EIGHTBITS,
            )
        
          sergps.write("$PMTK314,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0*28\r\n")  #
          time.sleep(.2)
          sergps.write("$PMTK220,100*2F\r\n")  # 10Hz
          time.sleep(.2)
        
        p = "100"
        ser.write("Y")  # Fuel
        time.sleep(.5)
        ser.write("a")  # Fuel Map 0
        rpmsite = 97
        Cmapf = " Config"
        Cmapi = " Config"
        bar_desc = "Not Def"
        screen_init = 0
        reload = 1
        scant = 1
        new_marker = 0
        # lap marker bit 0=auto 1= manual set
        # Test for GPS 10Hz
        if os.path.exists("/dev/ttyUSB1"):
          p = sergps.inWaiting()
          print p
        
          if p > 20:
            chgps = sergps.read(size=1)
            o = (ord(chgps))
            d = chr(o)
            while o <> 36 and scant < 500:
              chgps = sergps.read(size=1)
              o = (ord(chgps))
              d = chr(o)
              scant = scant + 1
            chgps = sergps.read(size=1)
            if "G" == chgps:
              reload = 0
            else:
              reload = 1
        if gps_sel == 0:
          reload = 0
        if reload == 1 and os.path.exists("/dev/ttyUSB1"):
          if swap_usb == 0:
            sergps = serial.Serial(
              port='/dev/ttyUSB1',
              baudrate=9600,
              parity=serial.PARITY_NONE,
              stopbits=serial.STOPBITS_ONE,
              bytesize=serial.EIGHTBITS,
            )
        
            sergps.write("$PMTK251,38400*27\r\n")  # Baud rate
            time.sleep(1)
            sergps = serial.Serial(
              port='/dev/ttyUSB1',
              baudrate=38400,
              parity=serial.PARITY_NONE,
              stopbits=serial.STOPBITS_ONE,
              bytesize=serial.EIGHTBITS,
            )
          else:
            sergps = serial.Serial(
              port='/dev/ttyUSB0',
              baudrate=9600,
              parity=serial.PARITY_NONE,
              stopbits=serial.STOPBITS_ONE,
              bytesize=serial.EIGHTBITS,
            )
        
            sergps.write("$PMTK251,38400*27\r\n")  # Baud rate
            time.sleep(1)
            sergps = serial.Serial(
              port='/dev/ttyUSB0',
              baudrate=38400,
              parity=serial.PARITY_NONE,
              stopbits=serial.STOPBITS_ONE,
              bytesize=serial.EIGHTBITS,
            )
        
          sergps.write("$PMTK314,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0*28\r\n")  #
          time.sleep(.5)
          sergps.write("$PMTK220,100*2F\r\n")  # 10Hz
          time.sleep(.5)
        
        adc0_desc = "Water T"
        adc2_desc = "Oil Press"
        adc0_desc = "Fuel Press"
        adc0_desc = "Oil Temp"
        adc_0 = 1
        adc_1 = 1
        adc_2 = 1
        adc_3 = 1
        adc_4 = 1
        adc_5 = 1
        adc_6 = 1
        adc_7 = 1
        wt_temp = -10
        oil_temp = -10
        oil_press = 0
        fuel_press = 0
        tps2 = 0
        boostsensor = -1
        afr_2 = 0
        batt_v = 0
        
        # def getserial():
        # Extract serial from cpuinfo file
        cpuserial = "0000000000000000"
        try:
          f = open('/proc/cpuinfo', 'r')
          for line in f:
            if line[0:6] == 'Serial':
              cpuserial = line[10:26]
          f.close()
        except:
          cpuserial = "ERROR000000000"
        
        # return cpuserial
        print "ECU serial ID " + cpuserial
        print "Program ID card Serial ID " + sernum
        mismatch = 0
        if cpuserial <> sernum:
          try:
            file = open("/home/pi/sernum.dat", "r")
            sernum = file.readline(16)
            print "SD card Serial ID " + sernum
            if cpuserial <> sernum:
              print "Mismatch ID"
              mismach = 1
              screen_view = 15
          except:
            print "No security set"
        
        while 1:
          	time_count += 1
          	try:
        		if screen_view==11:
        			print " This is a test "
        
        		else:
                        #Enter Config
        		  if GPIO.input(22)==0 and en_buttons==1:
        		    disp_now=1
        	            screen_init=0
        		    chipswop=300
                    	    screen_view = screen_view+1
                    	    if screen_view > 7:
                      		screen_view = 0
        
        		    time.sleep(1)
        	  	    if GPIO.input(22)==0 and en_buttons==1:
        			screen_view=11
        			set_conf=0
        			time.sleep(1)
        
        #        	print " Check ECU "
        		if ecu_sel<2:
        		  n = ser.inWaiting()
                          while n>171:
                            rawdata=ser.read(size=86)
                            n = ser.inWaiting()
                                        
                          if n>86:
                            while m<>84: 	
                            	ch=ser.read(size=1)
                            	m=(ord(ch))
        
                            
                            if 84==m:
                                
                                #if screen_view==5:
                                #    i_start=1
                                    
                                i_start=65
                                rawdata=ser.read(size=64)
                                
                                for i in range (i_start, 86):
                                    ch=ser.read(size=1)
                                    m=(ord(ch))
        
                                
                                                
        			    if screen_view<5:
        				gear=0.5+(speedg * ratio/(rpmd+1))
        				#gear=1+(speedg * 105.0/(rpmd+1))
        				if gear>6:
        					gear=6      
                                    if 65==i:
                                        map_site= m
                                       
                                    if 66==i:
                                        rpm_site= m
                                                  
                                    if 67==i:
                                        Rpmh= m
        
                                    if 68==i:
        				w_temp= k_temp * 0.85*(-(1.6*m/51*m/51*m/51) + (13.2*m/51*m/51) -(58*m/51) + 140)
        
                                    if 69==i:
        				a_temp= 0.85*(-(1.6*m/51*m/51*m/51) + (13.2*m/51*m/51) -(58*m/51) + 150)                                                                            
                                                                                    
                                    if 70==i:
                                        if an_mode==0 or an_mode==3:
                                            an_1s=((m/25.5)-0.6) * 1.25 * k_an1
        				    if (an_1-an_1s)>1 or  (an_1-an_1s)<-1:		
        					    an_1=an_1s
        				    else:
        				        if an_1<an_1s:
        					    an_1=an_1+0.1
        					if an_1>an_1s:
        					    an_1=an_1-0.1
                                        if an_mode==1:
                                            an_1=k_an1 * m*3.14
                                        if an_mode==2:
                                            an_1=k_an1 * m/2.55
                                                
                                    if 71==i:
        				if screen_view==5:
        				    gear=m
        				    cyl=8
        				    speed_l=gear*(rpmd/120)
                                    if 72==i:
        				if screen_view<>5:
                                            cyl= m
                                            if 0== cyl:
                                                cyl= 4
                                            
                                    if 73==i:
                                            tps=m/2.55
                                   
                                    if 74==i:
                                            volts= m/16.33
        
                                    if 75==i:
                                            afr=20 -(m/25.5)
                                            
                                    if 76==i:
                                            preset=ign_trig            #insert your preset here for correct reading 40 default
                                            p1=10.0/cyl
                                            p2=55.0/preset
                                            ign_A = 3+((330-(p1 *p2*m))*preset/330)
                                            
                                    if 77==i:
                                            all_ranges=m               #insert your preset here for correct reading 40 default
                                    
                                            
                                            
                                    if 78==i:
                                            Rpml=m
                                            rpmd= (1021000 * 4)/(cyl * ((Rpmh*255) + Rpml +1))
        
                                    if 79==i:
                                            fuel_T=m*fuel_M*0.029
                                            
                                    if 80==i:
                                        if map_kpa==2:
                                            mapsensor=(m*(255/240.78)/100)-1  #std map sensor
                                        if map_kpa==3:
                                            mapsensor=((m-16)*(255.1/125.1)/100)-1   #3 bar map sensor
        
                                    if 81==i:
                                        load_site=m
                                        
                                    if 82==i:
                                        if an_mode==0:
        				    an_2s= k_an2 * (-(1.27*m/51*m/51*m/51) + (12.5*m/51*m/51) -(57*m/51) + 155)                                    
                                            if (an_2-an_2s)>5 or (an_2-an_2s)<-5:     
                                                an_2=an_2s
                                            else:
                                                    if an_2<an_2s:
                                                        an_2=an_2+0.02
                                                    if an_2>an_2s:
                                                        an_2=an_2-0.02
        
                                        if an_mode==1:
                                            an_2=k_an2 * m*3.14
                                        if an_mode==2:
                                            an_2=k_an2 * m/2.55
                                        if an_mode==3:
        				    an_2s=((m/25.5)-0.6) * 1.25 * k_an2
        				    if (an_2-an_2s)>1 or (an_2-an_2s)<-1:		
        					    an_2=an_2s
        				    else:
        				        if an_2<an_2s:
        					    an_2=an_2+0.1
        					if an_2>an_2s:
        					    an_2=an_2-0.1
                                            
                                    if 83==i:
                                                fuel_M=m
                                                if 0==fuel_M or 3>fuel_M:
                                                        fuel_M=2
                                                                                    
                                    if 84==i:
                                            fuel_A=m*fuel_M*0.029
        
                                    if 85==i:
                                            rpmlow_count = rpmlow_count+1
                                            ecu_id = m
                                            if chipswop>2:
        				      chipswop=chipswop-1
                                              if screen_view==5:
                                                  ser.write("W")      #Fuel
        				      else:
                                                if ecu_id<30:
                                                  ser.write("Y")      #Fuel
        
                                                if ecu_id>39 and ecu_id<50:
                                                  ser.write("Y")      #Fuel
        
                        if ecu_sel==2:
        		        n = ser.inWaiting()
        		        while n>33:
        		            rawdata=ser.read(size=33)
        		            n = ser.inWaiting()
        		        if n>0:
        		         get_index= get_index + 1
        		         ch=ser.read(size=1)
        		         m=(ord(ch))
        		         if 69==m:
        		           ch=ser.read(size=1)
        		           m=(ord(ch))
        		           if 78==m:
        		            ch=ser.read(size=1)
        		            m=(ord(ch))
        		            if 68==m:
        		             ch=ser.read(size=1)
        		             m=(ord(ch))
        		             if 83==m:
        		              ch=ser.read(size=1)
        		              m=(ord(ch))
        		              if 84==m:
        		               ch=ser.read(size=1)
        		               m=(ord(ch))
        		               if 65==m:
        		                ch=ser.read(size=1)
        		                m=(ord(ch))
        		                if 82==m:
        		                 ch=ser.read(size=1)
        		                 m=(ord(ch))
        		                 if 84==m:
        	                            i_start=1
        				    #Dicktator formulae here.
        				    for i in range (i_start, 26):
        		                            ch=ser.read(size=1)
                        		            m=(ord(ch))          
        		                            if 1==i:
                        		                    rpml=m
                                        		    rpmd=rpmfp * (27800000 * 4)/(cyl * ((rpmh*255) + rpml +1))
        		                                    if rpmd<10:
                        		                        rpmd=0
                                        		    if rpmd > 4000:
        		                                        rpmlow_count = 0
        
        		                            if 2==i:
                        		                rpmh= m
        
                        		            if 3==i:
        						if cyl==0:
                                        		    cyl= 4
                        		                rpmfp=1
        						if 255==m:
        						  rpmfp=0
        
        		                            if 4==i:
        		                                an_1=((an_1msb + m/255)/1.24) - 51.6
                                                                                
        		                            if 5==i:
        						an_1msb=m                                                
        
        		                            if 6==i:
        						random_e=m
        
        		                            if 7==i:
                        				fuel_T=m
        						random_a=m
         
        		                            if 8==i:
                        		                    preset=ign_trig            #insert your preset here for correct reading 40 default
                                        		    p1=10.0/cyl
        		                                    p2=55.0/preset
                        		                    ign_A =m # 3+((330-(p1 *p2*m))*preset/330)
                                            		    afr=10
        						    random_b=m
        
        		                            if 9==i:
        						    random_c=m
        
        
                				    if 10==i:
        						maplsb=m
                                        		mapsensor=(map_kpa*((mapmsb*260)+maplsb)*0.001)-1   
        
        					    if 11==i:
        						mapmsb=m
        
        
                        		            if 12==i:
        						w_temp= (-(1.7*m/51*m/51*m/51) + (13.2*m/51*m/51) -(58*m/51) + 150)
                                        		#w_temp=((240-m)/2.33)
                                            
        		                            if 13==i:
        						#a_temp= 0.85*(-(1.6*m/51*m/51*m/51) + (13.2*m/51*m/51) -(58*m/51) + 150)
                        				a_temp= ((240-m)/2.33)
        
        		                            if 14==i:
                        				volts= m/15.9
                                                                                
        		                            if 15==i:
        						tpslsb=m
                        				tps=((tpsmsb*255)+(m))/10.24
                                   
        		                            if 16==i:
                        				tpsmsb=m
        
        		                            if 17==i:
                        				random_1=m
        
        		                            if 18==i:
                        				random_2=m
        
        		                            if 19==i:
                        				random_3=m
        
        		                            if 20==i:
                        				random_4=m
        
        		                            if 21==i:
                        				random_5=m
        
        		                            if 22==i:
                        				random_6=m
        
        		                            if 23==i:
                        				random_7=m
        
        		                            if 24==i:
                        				random_8=m
        
        		                            if 25==i:
                        				random_9=m
        
        
                        if ecu_sel==3:
        		        n = ser.inWaiting()
        		        while n>0:
        		            rawdata=ser.read(size=1)
        		            n = ser.inWaiting()
                                if spits<1:
        			    spits=1
        			    print chr(82)
        			    ser.write(chr(255))
                                    #ser.write(hex(FF))      #Fuel
                                else:
        			    print chr(84)
        			    ser.write(chr(252))
                                    #ser.write(hex(FC))      #Fuel
                        	    spits=1
                                    i_start=1
        		            #Spitronics Titan formulae here.
        			    for i in range (i_start, 10):
        					
        				        n = ser.inWaiting()
        					t_out=0
        					while n==0 and t_out<10000:
        					        n = ser.inWaiting()
        						t_out=t_out+1
        					if n > 0:
        		                            ch=ser.read(size=1)
                        		            m=(ord(ch))          
        					    print m
        		                            if 1==i:
                        		                    rpml=m
                                        		    rpmd=cyl * (rpml-1) * 25
        		                                    if rpmd<10:
                        		                        rpmd=0
                                        		    if rpmd > 4000:
        		                                        rpmlow_count = 0
        
                				    if 2==i:
                                        		mapsensor=(map_kpa*m/255)-1   
        
        		                            if 3==i:
                        				tps=m
        
        		                            if 4==i:
        						afr=m
        
                        		            if 5==i:
        						w_temp=m-1
                                            
        		                            if 6==i:
                        				a_temp= m-21
        
        		                            if 7==i:
        		                                an_1=m/10.0
                                                        fuel_T=an_1
                      
        		                            if 8==i:
                        				volts= m/10.0
        
        		                            if 9==i:
        						spits=500
                        		                an_2= m-1
        						ign_A=an_2
        
                                                else:
        					    print chr(83)
        					    ser.write(chr(255))
        
                	displ = 1
        
        #Screen 0			    
        		if displ==1:
                                            if rpmd>25000:
                                                rpmd=25000
                                            if rpmd<10:
                                                rpmd=0
        				    dispv=dispv+1
                                            if demomode==1:
                                             if rpmd<100:
                                              rpmd= rpmdisplay
                                              rpmdisplay = rpmdisplay + 50
                                              if rpmdisplay > sl_max + 300:
                                                  rpmdisplay = 0
                                              
                                            if rpmd > 4000:
                                                rpmlow_count = 0
        
                                            if rpmd < sl_max-(4*sl_step):
        					GPIO.output(27, 1)
                                            if rpmd > sl_max-(4*sl_step):
        					GPIO.output(27, 0)
                                            if rpmd < sl_max-(3*sl_step):
        					GPIO.output(23, 1)
                                            if rpmd > sl_max-(3*sl_step):
        					GPIO.output(23, 0)
                                            if rpmd < sl_max-(2*sl_step):
        					GPIO.output(24, 1)
                                            if rpmd > sl_max-(2*sl_step):
        					GPIO.output(24, 0)
                                            if rpmd < sl_max-sl_step:
        					GPIO.output(25, 1)
                                            if rpmd > sl_max-sl_step:
        					GPIO.output(25, 0)
                                            if rpmd < sl_max:
        					GPIO.output(26, 1)
                                            if rpmd > sl_max:
        					GPIO.output(26, 0)
        
        
                                            black=(0,0,0)
                                            blue=(0,0,200)
                                            red=(255,0,0)
                                            green=(0,255,0)
                                            white=(255,255,255)
                                            yellow=(255,255,0)
                                            cyan=(0,255,255)
                                            purple=(128,0,128)
                                            grey=(125,125,125)
        				    silver=(192,192,192)
        				    orange=(255,128,0)
        				    pink=(255,128,255)
        				    darkgreen=(0,128,64)
        				    darkblue=(0,0,160)
        				    if data_refresh<5:
        					    alarm_led=10
        					    if ecu_sel<2:
        	                                        if afr>afr_lim:
                	                                   alarm_led=0
        	                                        if volts<batt_lim or mapsensor>boost_lim:
                	                                   alarm_led=1
                        	                        if w_temp>watertemp_lim or an_2>oiltemp_lim:
                                	                   alarm_led=2
                        	                        if an_1<oilpress_lim:
                                	                   alarm_led=3
        					    else:
        	                                        if volts<batt_lim or mapsensor>boost_lim:
                	                                   alarm_led=1
        	                                        if w_temp>watertemp_lim or oil_temp>oiltemp_lim:
                	                                   alarm_led=2
        	                                        if oil_press<oilpress_lim:
                	                                   alarm_led=3
        
        
                                        	    if alarm_led==0:
                                                	  GPIO.output(27, 0)
        				    
                                        	    if alarm_led==1:
                                                	  GPIO.output(23, 0)
        				    
                                        	    if alarm_led==2:
        	                                          GPIO.output(24, 0)
        				    
                                        	    if alarm_led==3:
                                                	  GPIO.output(26, 0)
        	                                          GPIO.output(25, 0)
        				    
        				    if data_refresh==10:
        					data_refresh=0
        				    	data_rate = 10/(float(time.time()) - float(data_time))
        				    	data_time = time.time()
        				    data_refresh=data_refresh+1
        
        				    if kw_refresh==10:
        					kw_refresh=0
        				    	kw_rate = 10/(float(time.time()) - float(kw_time))
        				    	kw_time = time.time()
        					rpmkw1=rpmkw2
        					rpmkw2=rpmd
        					if gear==0:
        					    gear=1
        					if demomode==1:
        					    gear=3
        					power2=power1
        					power1=((rpmkw2-rpmkw1)*gear*kw_rate*4)/kw_cal
        					power_adj=(power1-power2)/10
        				    kw_refresh=kw_refresh+1
        				    power=power2+power_adj
        				    power2=power
        				    if power>999 or power < -999:
        				        power=0
        				
        				    #power1=power
        
        				    #Lap Trigger
        				    if laptime>0:
        				      if laptime<5 or laptime>1200:
        					laptime=0
        					laps_done=0
        					disp_now=1
                                            Xlat=int((x_lat-latcen)*27500)
                                            Ylong=int((y_long-longcen)*24000)
                                            X = Xlat
                                            Y = Ylong
                                            if laptrig==0:
                                                    if Xlat<275+lap_dia and Xlat>275-lap_dia and Ylong<240+lap_dia and Ylong>240-lap_dia:
        						disp_now=1
                                                        laptrig=1
                                                        laps_done = laps_done+1
                                                        laptime = float(time.time()) - float(start_time)
        						if laptime>600 or laptime<0:
        						    laptime = 600
                                                        start_time = time.time()
                                                        laptime11 = laptime10
                                                        laptime10 = laptime9
                                                        laptime9 = laptime8
                                                        laptime8 = laptime7
                                                        laptime7 = laptime6
                                                        laptime6 = laptime5
                                                        laptime5 = laptime4
                                                        laptime4 = laptime3
                                                        laptime3 = laptime2
                                                        laptime2 = laptime1
                                                        laptime1 = laptime
        						deltatime=laptime-besttime
        						if deltatime>50 or deltatime<-50: 
        					  		deltatime = 0
                                                  	splittime1 = laptime1-laptime2
                                                  	splittime2 = laptime2-laptime3
                                                  	splittime3 = laptime3-laptime4
                                                  	splittime4 = laptime4-laptime5
                                                  	splittime5 = laptime5-laptime6
                                                  	splittime6 = laptime6-laptime7
                                                  	splittime7 = laptime7-laptime8
                                                  	splittime8 = laptime8-laptime9
                                                  	splittime9 = laptime9-laptime10
                                                  	splittime10 = laptime10 -laptime11
                                            if Xlat>275+lap_dia or Xlat<275-lap_dia or Ylong >240+lap_dia or Ylong<240-lap_dia:
                                                        laptrig=0
        						lap_reset=1
                                            if s1_trig==0:
                                                    if Xlat<s1latcen+lap_dia and Xlat>s1latcen-lap_dia and Ylong<s1longcen+lap_dia and Ylong>s1longcen-lap_dia:
        						disp_now=1
                                                        s1_trig=1
                                                        s1_time = float(time.time()) - float(start_time)
                                            if Xlat>s1latcen+lap_dia or Xlat<s1latcen-lap_dia or Ylong>s1longcen+lap_dia or Ylong<s1longcen-lap_dia:
                                                        s1_trig=0
                                            if s2_trig==0:
                                                    if Xlat<s2latcen+lap_dia and Xlat>s2latcen-lap_dia and Ylong<s2longcen+lap_dia and Ylong>s2longcen-lap_dia:
        						disp_now=1
                                                        s2_trig=1
                                                        s2_time = float(time.time()) - float(start_time)
                                            if Xlat>s2latcen+lap_dia or Xlat<s2latcen-lap_dia or Ylong>s2longcen+lap_dia or Ylong<s2longcen-lap_dia:
                                                        s2_trig=0
        
        				    #Lap times
                                            lapminute=0
                                            lapmin = laptime/60.0
        				    if lapmin>0 and lapmin <1:
                                                    lapminute=0
                                            if lapmin>1 and lapmin<2:
                                                    lapminute=1
                                            if lapmin>2 and lapmin<3:
                                                    lapminute=2
                                            if lapmin>3 and lapmin<4:
                                                    lapminute = 3
                                            if lapmin>4 and lapmin<5:
                                                    lapminute=4
                                            if lapmin>5 and lapmin<6:
                                                    lapminute=5
                                            if lapmin>6 and lapmin<7:
                                                    lapminute=6
                                            if lapmin>7 and lapmin<8:
                                                    lapminute=7
                                            if lapmin>8 and lapmin<9:
                                                    lapminute=8
                                            if lapmin>9 and lapmin<10:
                                                    lapminute=9
                                            if lapmin>10 and lapmin<11:
                                                    lapminute=10
                                            if lapmin>11:
                                                    lapminute=11
                                            lapsec = laptime - (lapminute*60)
        				    if lapsec>60 or lapsec<0:
        					    lapsec=0
                                            
        				    if laptime>15:
        					if laptime<besttime:
        						besttime=laptime
        						bestlap=laps_done
        
        
        				    bestminute=0
                                            bestmin = besttime/60.0
                                            if bestmin>0 and bestmin <1:
                                                    bestminute=0
                                            if bestmin>1 and bestmin<2:
                                                    bestminute=1
                                            if bestmin>2 and bestmin<3:
                                                    bestminute=2
                                            if bestmin>3 and bestmin<4:
                                                    bestminute = 3
                                            if bestmin>4 and bestmin<5:
                                                    bestminute=4
                                            if bestmin>5 and bestmin<6:
                                                    bestminute=5
                                            bestsec = besttime - (bestminute*60)
        				    if bestsec>60 or bestsec<0:
        				            bestsec=0
        
                                            curtime = float(time.time()) - float(start_time)
                                            curminute=0
                                            curmin = curtime/60.0
        				    if curmin>0 and curmin <1:
                                                    curminute=0
                                            if curmin>1 and curmin<2:
                                                    curminute=1
                                            if curmin>2 and curmin<3:
                                                    curminute=2
                                            if curmin>3 and curmin<4:
                                                    curminute = 3
                                            if curmin>4 and curmin<5:
                                                    curminute=4
                                            if curmin>5 and curmin<6:
                                                    curminute=5
                                            if curmin>6:
                                                    curminute=6
                                            cursec = curtime - (curminute*60)
        				    if cursec>60 or cursec<0:
        					    cursec=0
        
        
        #Screen7-----ECU DATA----------------
        
        #Screen 6 Manny Trix		-------
        #Screen 3		---------------------------------------------
        #Screen 4----------------------------------------------------------
        #Screen 15		-----
        #Screen 5 LEXUS		-----------
        
        #Screen 7		-----------------------------------------------------------------------------
        
        				    if 1==start_log_en:
        		                            log_en=1
        
                                            if 1==log_en:
                                                f= open(logfile, "a")
        					f.write("\n T" + str(log_count)+", ")
        					log_count=log_count+1
                                                f.write(str('%.0f' %rpmd)+", ")
                                                f.write(str('%.1f' %an_1)+", ")
                                                f.write(str('%.1f' %an_2)+", ")
                                                f.write(str('%.1f' %mapsensor)+", ")
                                                f.write(str(map_site)+", ")
                                                f.write(str('%.1f' %w_temp)+", ")
                                                f.write(str('%.1f' %a_temp)+", ")
                                                f.write(str(cyl)+", ")
                                                f.write(str('%.1f' %tps)+", ")
                                                f.write(str('%.1f' %volts)+", ")
                                                f.write(str('%.1f' %afr)+", ") 
                                                f.write(str('%.1f' %ign_A)+", ")
                                                f.write(str('%.2f' %fuel_T)+", ")
                                                f.write(str('%.2f' %fuel_A)+", ")
                                                if adxl_sel==1:
        					  f.write( str(axes['x']) +", ")
                                                  f.write( str(axes['z']) +", ")
                                                  f.write( str(axes['y']) +", ")
        					else:
        					  f.write("0" +", ")
                                                  f.write("0"  +", ")
                                                  f.write("0"  +", ")
        
                                                f.write(str('%.0f' %speedg) +", ")
                                                f.write(vector +", ")
                                                f.write(lattitude +", ")
                                                f.write(longitude +", ")
                                                f.write(str(gpslock) +", ")
                                                f.write(dategps +", ")
                                                f.write(timegps +", ")
                                                f.write(str('%.2f' %laptime)+", ")
                                                f.write(str(laps_done)+", ")
                                                log_time = float(time.time()) - float(start_time) 
                                                f.write(str('%.3f' %log_time) +", ")
                                                if adc_sel==1 or adc_sel==2:
                                                    f.write(str('%.1f' %wt_temp) +", ")
                                                    f.write(str('%.2f' %oil_temp) +", ")
                                                    f.write(str('%.2f' %oil_press) +", ")
                                                    f.write(str('%.2f' %fuel_press) +", ")
                                                    #f.write(str('%.3f' %adc_0) +", ")
                                                    #f.write(str('%.3f' %adc_1) +", ")
                                                    #f.write(str('%.3f' %adc_2) +", ")
                                                    #f.write(str('%.3f' %adc_3) +", ")
                                                    f.write(str('%.3f' %adc_4) +", ")
                                                    f.write(str('%.3f' %adc_5) +", ")
                                                    f.write(str('%.3f' %adc_6) +", ")
                                                    f.write(str('%.3f' %adc_7) +", ")
                                                
                        #GPS DATA
                        if gps_sel==1:
                            p = sergps.inWaiting()
                            gps_scan=0
                            if p>250:
                                while gps_scan==0: 
                                    chgps=sergps.read(size=1)
                                    o=(ord(chgps))
                                    d=chr(o)
                                    while o<>36:
                                        chgps=sergps.read(size=1)
                                        o=(ord(chgps))
                                        d=chr(o)
                            
                                    chgps=sergps.read(size=5)
                                    if "GPRMC" == chgps:
                                        if gps_refresh==10:
                                            gps_refresh=0
                                            gps_rate = 10/(float(time.time()) - float(gps_time))
                                            gps_time = time.time()
                                        gps_refresh=gps_refresh+1
                                        gps_scan=1
                                        o=35
                                        comma=0
                                        latbit=0
                                        longbit=0
                                        timebit=0
                                        sbit=0
                                        vbit=0
                                        datebit=0
                                        while o<>36:
                                            chgps=sergps.read(size=1)
                                            if ","==chgps:
                                                comma = comma+1
                                            if ","<>chgps:
                                                if 1==comma:
                                                    timebit=timebit+1
                                                    if 1==timebit:
                                                        timebit1=chgps
                                                    if 2==timebit:
                                                        timebit2=chgps
                                                    if 3==timebit:
                                                        timebit3=chgps
                                                    if 4==timebit:
                                                        timebit4=chgps
                                                    if 5==timebit:
                                                        timebit5=chgps
                                                    if 6==timebit:
                                                        timebit6=chgps
                                            
                                                if 2==comma:
                                                    if "V"==chgps:
                                                        gpslock=0
                                                    if "A"==chgps:
                                                        gpslock=1
                                            
                                                if 3==comma:
                                                    latbit=latbit+1
                                                    if 1==latbit:
                                                        latbit1=chgps
                                                    if 2==latbit:
                                                        latbit2=chgps
                                                    if 3==latbit:
                                                        latbit3=chgps
                                                    if 4==latbit:
                                                        latbit4=chgps
                                                    if 5==latbit:
                                                        latbit5=chgps
                                                    if 6==latbit:
                                                        latbit6=chgps
                                                    if 7==latbit:
                                                        latbit7=chgps
                                                    if 8==latbit:
                                                        latbit8=chgps
                                                    if 9==latbit:
                                                        latbit9=chgps
                                                        
                                                if 5==comma:
                                                    longbit=longbit+1
                                                    if 1==longbit:
                                                        longbit1=chgps
                                                    if 2==longbit:
                                                        longbit2=chgps
                                                    if 3==longbit:
                                                        longbit3=chgps
                                                    if 4==longbit:
                                                        longbit4=chgps
                                                    if 5==longbit:
                                                        longbit5=chgps
                                                    if 6==longbit:
                                                        longbit6=chgps
                                                    if 7==longbit:
                                                        longbit7=chgps
                                                    if 8==longbit:
                                                        longbit8=chgps
                                                    if 9==longbit:
                                                        longbit9=chgps
                                                    if 10==longbit:
                                                        longbit10=chgps
                    
                                                if 7==comma:
                                                        sbit=sbit+1
                                                        if 1==sbit:
                                                            speed1=chgps
                                                        if 2==sbit:
                                                            speed2=chgps
                                                        if 3==sbit:
                                                            speed3=chgps
                                                        if 4==sbit:
                                                            speed4=chgps
                                                        if 5==sbit:
                                                            speed5=chgps
                                                    
                    
                                                if 8==comma:
                                                        vbit=vbit+1
                                                        if 1==vbit:
                                                            vector1=chgps
                                                        if 2==vbit:
                                                            vector2=chgps
                                                        if 3==vbit:
                                                            vector3=chgps
                                                        if 4==vbit:
                                                            vector4=chgps
                                                        if 5==vbit:
                                                            vector5=chgps
                                                        
                                                if 9==comma:
                                                    datebit=datebit+1
                                                    if 1==datebit:
                                                        datebit1=chgps
                                                    if 2==datebit:
                                                        datebit2=chgps
                                                    if 3==datebit:
                                                        datebit3=chgps
                                                    if 4==datebit:
                                                        datebit4=chgps
                                                    if 5==datebit:
                                                        datebit5=chgps
                                                    if 6==datebit:
                                                        datebit6=chgps
                                                        
                                    
                                        
                                        
                                                o=(ord(chgps))
                                                d=chr(o)
        
                            while p>600:
                              rawdata=sergps.read(size=200)
                              p = sergps.inWaiting()
                            speed = str(speed1)+ str(speed2) + str(speed3) + str(speed4) +str(speed5)    
                            speedg = 1.852*(float(speed))
                            vector = str(vector1)+ str(vector2) + str(vector3) + str(vector4) + str(vector5)
                            timegps = str(timebit1)+str(timebit2)+str(timebit3)+str(timebit4)+str(timebit5)+str(timebit6)
                            dategps = str(datebit1)+str(datebit2)+str(datebit3)+str(datebit4)+str(datebit5)+str(datebit6)
                            latti = str(latbit3)+str(latbit4)+str(latbit5)+str(latbit6)+str(latbit7)+str(latbit8)+str(latbit9) 
                            longi = str(longbit4)+str(longbit5)+str(longbit6)+str(longbit7)+str(longbit8)+str(longbit9)+str(longbit10)
                            latcor=(float(latti)*16666.667)
                            longcor=(float(longi)*16666.667)
                    
                            lattest = str(latbit3)+str(latbit4) 
                            testlat = float(lattest)
                            longtest = str(longbit4)+str(longbit5)
                            testlong = float(longtest)
        
                            lattitude = str(latbit1)+str(latbit2)+"."+str('%.0f' %latcor)
                            if testlat<6: 
                                lattitude = str(latbit1)+str(latbit2)+".0"+str('%.0f' %latcor) 
        
                            longitude = str(longbit1)+str(longbit2)+str(longbit3)+"."+str('%.0f' %longcor)
                            if testlong<6:
                                longitude = str(longbit1)+str(longbit2)+str(longbit3)+".0"+str('%.0f' %longcor)
                            x_lat=float(lattitude)
                            y_long=float(longitude)
        
                            
                            if dtset == 0 and gpslock==1:
                                dtset = 1
                                gpsdt = "20" + str(datebit5) + str(datebit6) + str(datebit3) + str(datebit4) + str(datebit1) + str(datebit2)  + " " + str(timebit1) + str(timebit2) + ":" + str(timebit3) + str(timebit4) + ":" + str(timebit5) + str(timebit6) + ".000"
                                os.system('sudo date -u --set="%s"' % gpsdt)
                            
                            pygame.display.flip()
                    #if x_lat+0.04<lap_lat or x_lat-0.04>lap_lat or y_long+0.04<lap_long or y_long-0.04>lap_long:
                    #    track_sel=50
                    #    print "Searching for track"
                            if 1==gpslock:
                                                    try:
                                                        if os.path.exists("/media/Transcend/track.dat") and track_sel<100:
                                                                file = open("/media/Transcend/track.dat", "r")
                                                                track_found=0
                                                                track_no=0
                                                                track_sel=track_sel+1
                                                                while track_found==0 and  track_no<999:
                                                                    track_no=int(file.readline())
                                                                    print track_no
                                                                    print x_lat
                                                                    print y_long
                                                                    track_name=file.readline(12)
                                                                    track_name1=file.readline()
                                                                    print track_name
                                                                    tlap_lat=file.readline()
                                                                    tlap_long=file.readline()
                                                                    lap_lat=float(tlap_lat)
                                                                    lap_long=float(tlap_long)
                                                                    sector1_name=file.readline()
                                                                    sec1_lat=file.readline()
                                                                    sec1_long=file.readline()
                                                                    s1_lat=float(sec1_lat)
                                                                    s1_long=float(sec1_long)
                                                                    sector2_name=file.readline()
                                                                    sec2_lat=file.readline()
                                                                    sec2_long=file.readline()
                                                                    s2_lat=float(sec2_lat)
                                                                    s2_long=float(sec2_long)
                                                                    if x_lat+0.012>lap_lat and x_lat-0.012<lap_lat and y_long+0.012>lap_long and y_long-0.012<lap_long:
                                                                        track_found=1
                                                                        track_no=1000
                                                                        latcen=lap_lat-0.01
                                                                        longcen=lap_long-0.01
                                                                        s1latcen=int((s1_lat-latcen)*27500)
                                                                        s1longcen=int((s1_long-longcen)*24000)
                                                                        s2latcen=int((s2_lat-latcen)*27500)
                                                                        s2longcen=int((s2_long-longcen)*24000)
                                                                file.close() 
                                                        else:
                                                          if os.path.exists("/home/pi/track.dat") and track_sel<100:
                                                                    file = open("/home/pi/track.dat", "r")
                                                                    track_found=0
                                                                    track_no=0
                                                                    track_sel=track_sel+1
                                                                    while track_found==0 and  track_no<999:
                                                                        track_no=int(file.readline())
                                                                        print track_no
                                                                        print x_lat
                                                                        print y_long
                                                                        track_name=file.readline(12)
                                                                        track_name1=file.readline()
                                                                        print track_name
                                                                        tlap_lat=file.readline()
                                                                        tlap_long=file.readline()
                                                                        lap_lat=float(tlap_lat)
                                                                        lap_long=float(tlap_long)
                                                                        sector1_name=file.readline()
                                                                        sec1_lat=file.readline()
                                                                        sec1_long=file.readline()
                                                                        s1_lat=float(sec1_lat)
                                                                        s1_long=float(sec1_long)
                                                                        sector2_name=file.readline()
                                                                        sec2_lat=file.readline()
                                                                        sec2_long=file.readline()
                                                                        s2_lat=float(sec2_lat)
                                                                        s2_long=float(sec2_long)
                                                                        if x_lat+0.012>lap_lat and x_lat-0.012<lap_lat and y_long+0.012>lap_long and y_long-0.012<lap_long:
                                                                                track_found=1
                                                                                track_no=1000
                                                                                latcen=lap_lat-0.01
                                                                                longcen=lap_long-0.01
                                                                                s1latcen=int((s1_lat-latcen)*27500)
                                                                                s1longcen=int((s1_long-longcen)*24000)
                                                                                s2latcen=int((s2_lat-latcen)*27500)
                                                                                s2longcen=int((s2_long-longcen)*24000)
                                                                    file.close() 
                                                    except:
                                                        print "Invalid track data"
                                                        track_sel=track_sel+1
                                                        track_name="Error Data"
                                                        
           	except Exception as e:
                   print(e)
                   time.sleep(3)
                   print "fault error"
        
        
          	speed = speedg
          	rpm = rpmd
          	acceleration = volts
          	load = w_temp
          	throttle = tps
          	self.signals.speed.emit(speed)
          	self.signals.rpm.emit(rpm)
          	self.signals.wtemp.emit(w_temp)
          	self.signals.otemp.emit(a_temp)
          	self.signals.atemp.emit(volts)
          	QThread.msleep(5)			
			  #Handle value error due to incorrect math domain
#			  	try:
#			    		heading = int(calcHeading()) - 20
#			    		if heading < 0:
#			      			heading = 360 + heading
#			    		if time_count % 5: 
#			      			temperature = an_2
#			      			coolant = w_temp
#			      			intake = a_temp
#			  	except ValueError:
#			    		pass
			
#			  	for event in pygame.event.get():
#			    		if event.type == pygame.MOUSEBUTTONDOWN:
#			      			p = pygame.mouse.get_pos()
			      			#touch screen button press detection logic, for quit button
			#      		if p[0]>240 and p[0]<285 and p[1]>200 and p[1]<220: 
			#        		sys.exit()
			#      		elif p[0]>50 and p[0]<90 and p[1]>200 and p[1]<230:
			#        		display_compass ^= 1
			#      		elif p[0]>213 and p[0]<300 and p[1]>140 and p[1]<200 :
			#        		display_F ^= 1
			#      		elif p[0]>20 and p[0]<width/3 and p[1]>20 and p[1]<70:
			#        		display_kph ^= 1 
			
			  # print "temperature is " + str(temperature)
			  # print "heading is " + str(heading)
			  # print "acceleration is " + str(acceleration)
			
#			  	screen.fill(black)
#			  	screen.blit(quit_text, q_text_pos)
#			  	screen.blit(compass_text, c_text_pos)
			

