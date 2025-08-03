#!/usr/bin/env python3

# Rpi Boosted Dash - Core EFI
import serial
import io
import os
import pygame
import sys
from pygame.locals import *
import pygame
import sys
import math
import array
from pygame.locals import *
from math import *
import time
from time import strftime
import datetime
from time import strftime
import datetime

import time
import signal
import sys
import socket
import select
import threading

# UDP_IP = "192.168.1.129"
UDP_PORT = 45454
TCP_PORT = 45554
MESSAGE = "Hello, World!"


sock = socket.socket(socket.AF_INET,  # Internet
             socket.SOCK_DGRAM)  # UDP
sock.bind(('', UDP_PORT))




server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.bind(("0.0.0.0", TCP_PORT))
server_socket.listen(100)

inputs = [server_socket]
outputs = []

allips = []
f = open("/home/pi/broadcastips.txt", "r")
for x in f:
    print(x)
    allips.append(x)  


def timestamp():
    now = time.time()
    localtime = time.localtime(now)
    milliseconds = '%03d' % int((now - int(now))*1000)
global displ
global alarm_led
global data_refresh 
global gps_refresh
global ecu_alarm
global red
global green
global blue 
global data_rate
global gps_rate 
global get_index
global log_count
global cyl
global m
global o
global d
global rpmh 
global rpmfp
global rpmd 
global rpmdisplay 
global fuel_M 
global fuel_T 
global fuel_A 
global ign_A
global ecu_id 
global w_temp 
global a_temp 
global tps
global tpsmsb 
global mapmsb 
global an_1msb
global an_1 
global an_2 
global afr
global mapsensor
global volts
global dtset
global log_gps
global speed_l
global speed1 
global speed2 
global speed3 
global speed4 
global speed5 
global speed
global vector 
global vector1
global vector2
global vector3
global vector4
global vector5
global lattitude
global latbit1
global latbit2
global latbit3
global latbit4
global latbit5
global latbit6
global latbit7
global latbit8
global latbit9
global longitude
global longbit1 
global longbit2 
global longbit3 
global longbit4 
global longbit5 
global longbit6 
global longbit7 
global longbit8 
global longbit9 
global longbit10
global dategps
global datebit1 
global datebit2 
global datebit3 
global datebit4 
global datebit5 
global datebit6 
global timegps
global timebit1 
global timebit2 
global timebit3 
global timebit4 
global timebit5 
global timebit6 
global speedg 
global gear 
global x_lat
global y_long 
global latcen 
global longcen
global lap_lat
global lap_long 
global s1_lat 
global s1_long
global s2_lat 
global s2_long
global s1latcen 
global s1longcen
global s2latcen 
global s2longcen
global X
global Y
global gpslock
global start_log_en 
global log_en 
global log_size 
global rpmlow_count 
global rpmhigh_count
global log_man
global lastsec
global lastmin
global lastmilli
global laptime
global laptime1 
global laptime2 
global laptime3 
global laptime4 
global laptime5 
global laptime6 
global laptime7 
global laptime8 
global laptime9 
global laptime10
global laptime11
global s1_time
global s2_time
global laptrig
global s1_trig
global s2_trig
global laps_done
global splittime1 
global splittime2 
global splittime3 
global splittime4 
global splittime5 
global splittime6 
global splittime7 
global splittime8 
global splittime9 
global splittime10
global splittime11
global deltatime
global lap_reset
global start_time 
global data_time
global kw_time
global gps_time 
global disp_now 
global screen_view
global load_site
global rpm_site 
global all_ranges 
global ranges 
global map_site 
global batt_lim 
global boost_lim
global oiltemp_lim
global oilpress_lim 
global fuelpress_lim
global watertemp_lim
global sl_max 
global sl_step
global k_temp 
global ka_temp
global k_an1
global k_an2
global chipswop 
global map_kpa
global lap_dia
global lat_acc
global long_acc 
global an_mode
global ign_trig 
global adxl_sel 
global adc_sel
global gps_sel
global dirx 
global diry 
global Xlat 
global Ylong
global blink
global log_on 
global log_time 
global besttime 
global bestlap
global xlattest 
global an_log20 
global track_sel
global track_no 
global track_name 
global sector1_name 
global sector2_name 
global data_ave 
global uparrow
global downarrow
global leftarrow
global rightarrow 
global kw_cal 
global rpmkw2 
global rpmkw1 

en_buttons = 1
demomode = 0
ratio = 105
# Enter code here else bootup on screen 9 only
dashnumber = 1
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

# GPIO Outputs


gettime = strftime("%H%M", time.localtime())
getdate = strftime("%d%b", time.localtime())

# This works to set date / time
# gpsdt = "20150222 13:23:03.000"
# os.system('sudo date -u --set="%s"' % gpsdt)

pygame.init()
screen = pygame.display.set_mode((800, 480))
pygame.display.set_caption('Boosted Dash')
pygame.font.init()
pygame.display.update()
pygame.mouse.set_visible(False)
serlog_val = 0

background = pygame.Surface(screen.get_size())
background = background.convert()
background.fill((0, 0, 0))


pygame.font.init()
pygame.display.update()
pygame.mouse.set_visible(False)

font = pygame.font.SysFont("freemono", 40, bold=1)
text = font.render("Boosted Dash", 1, (250, 0, 0))
textpos = text.get_rect()
textpos.centerx = background.get_rect().centerx
background.blit(text, textpos)
screen.blit(background, (0, 0))
pygame.display.flip()
load = 1

os.system('cd /home/pi/')
# load new dash.cfg logo.jpg dash.py track.dat
# if os.path.exists("/dev/sda1"):
print ("Mounting usb drive")
os.system('mount /dev/sda1 /media/Transcend')

if os.path.exists("/media/Transcend/dashKi.py"):
	pygame.draw.rect(background, (250, 250, 250), (200, 450, 450, 30))
	font = pygame.font.Font(None, 30)
	text = font.render("Dash File Reading", 2, (0, 0, 0))
	textpos.top = 450
	textpos.left = 200
	background.blit(text, textpos)
	screen.blit(background, (0, 0))
	pygame.display.flip()
	os.system('cp /media/Transcend/dashKi.py /home/pi/')
	time.sleep(2)
	pygame.draw.rect(background, (250, 250, 250), (200, 450, 450, 30))
	font = pygame.font.Font(None, 30)
	text = font.render("Dash File Loading", 2, (0, 0, 0))
	textpos.top = 450
	textpos.left = 200
	background.blit(text, textpos)
	screen.blit(background, (0, 0))
	pygame.display.flip()
	os.system('cp /media/Transcend/dashKi.py /home/pi/')
	time.sleep(2)
	pygame.draw.rect(background, (250, 250, 250), (200, 450, 450, 30))
	font = pygame.font.Font(None, 30)
	text = font.render("Dash File Preparing", 2, (0, 0, 0))
	textpos.top = 450
	textpos.left = 200
	background.blit(text, textpos)
	screen.blit(background, (0, 0))
	pygame.display.flip()
	time.sleep(2)
	os.system('sudo chmod 755 dashKi.py')
	pygame.draw.rect(background, (250, 250, 250), (200, 450, 450, 30))
	font = pygame.font.Font(None, 30)
	text = font.render("Dash File Load Complete", 2, (0, 0, 0))
	textpos.top = 450
	textpos.left = 200
	background.blit(text, textpos)
	screen.blit(background, (0, 0))
	pygame.display.flip()
	time.sleep(2)


if os.path.exists("/media/Transcend/logo.jpg"):
    	img = pygame.image.load("/media/Transcend/logo.jpg")
    	img = pygame.transform.scale(img, (800, 480))
    	screen.blit(img, (0, 0))
    	pygame.display.flip()
    	time.sleep(.5)
else:
    if os.path.exists("/media/Transcend/logo.png"):
    	img = pygame.image.load("/media/Transcend/logo.png")
    	img = pygame.transform.scale(img, (800, 480))
    	screen.blit(img, (0, 0))
    	pygame.display.flip()
    	time.sleep(.5)

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
latcen = x_lat-0.01
longcen = y_long-0.01
lap_lat = 25.809317
lap_long = 28.112109
s1_lat = 25.808270
s1_long = 28.109386
s2_lat = 25.811848
s2_long = 28.111715
s1latcen = s1_lat-0.01
s1longcen = s1_long-0.01
s2latcen = s2_lat-0.01
s2longcen = s2_long-0.01
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
ecu_sel = 4
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
        print ("File usb error")

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
        print ("File sd card error")

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
    file.write(
        "Analog Mode eg (0=Oil P + Oil T) (1 = EGT1 +EGT2) (2 = DBW1 + DBW2):- " + "\n")
    file.write(str(an_mode) + "\n")
    file.write("Ignition Preset eg 40:- " + "\n")
    file.write(str(ign_trig) + "\n")
    file.write(
        "Boot Screen eg 0=classic 1=data 2=gauge 3=laptimes 4=GPs 5=mapping 6=hi speed log :- " + "\n")
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

# Shiraaz
ecu_sel = 4

adc_sel = 0
adxl_sel = 0
adxl_s = adxl_sel
adc_s = adc_sel
scr_view = screen_view
print ("sl max: " + str(sl_max))
print ("sl step: " + str(sl_step))
print ("boost alarm: " + str(boost_lim))
print ("Oil T alarm: " + str(oiltemp_lim))
print ("Oil P alarm: " + str(oilpress_lim))
print ("Water T alarm: " + str(watertemp_lim))
print ("Battery alarm: " + str(batt_lim))
print ("AFR alarm: " + str(afr_lim))
print ("Map Type: " + str(map_kpa))
print ("Lap Trig Diameter: " + str(lap_dia))
print ("Analog Mode: " + str(an_mode))
print ("Ignition Preset: " + str(ign_trig))
print ("Boot Screen: " + str(screen_view))
print ("ADXL 345: " + str(adxl_sel))
print ("ADC 1015: " + str(adc_sel))
print ("GPS : " + str(gps_sel))
print ("ECU : " + str(ecu_sel))
print (sernum)
if ecu_sel == 2 or ecu_sel == 3:
	cyl = ign_trig
	ign_trig = 40
swap_usb = 0

# if not os.path.exists("/dev/ttyUSB0"):
# 	font = pygame.font.Font(None, 50)
#         text = font.render("USB0 SER NOT PRESENT", 2, (255, 0, 0))
#         textpos.top = 200
#         textpos.left = 20
#         background.blit(text, textpos)
#         screen.blit(background, (0, 0))
#         pygame.display.flip()
# 	time.sleep(1)

# if gps_sel == 1:
#   try:
#     if not os.path.exists("/dev/ttyUSB1"):
# 	font = pygame.font.Font(None, 50)
#         text = font.render(
#             "USB1 SER NOT PRESENT, UNLOADING GPS", 2, (255, 0, 0))
#         textpos.top = 200
#         textpos.left = 20
#         background.blit(text, textpos)
#         screen.blit(background, (0, 0))
#         pygame.display.flip()
# 	time.sleep(0.5)
#         gps_sel = 0
#   except:
#         gps_sel = 0


i = 0
tcount = 0

p = "100"
time.sleep(.5)
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
print ("ECU serial ID " + cpuserial)
print ("Program ID card Serial ID " + sernum)
mismatch = 0
if cpuserial != sernum:
    try:
        file = open("/home/pi/sernum.dat", "r")
        sernum = file.readline(16)
        print ("SD card Serial ID " + sernum)
        if cpuserial != sernum:
            print ("Mismatch ID")
            mismach = 1
            screen_view = 15
    except:
        print ("No security set")


sock = socket.socket(socket.AF_INET,  # Internet
            socket.SOCK_DGRAM)  # UDP
sock.setsockopt(socket.SOL_SOCKET, socket.SO_BROADCAST, 1)

connected = False
while (connected == False):
   try:
      # timeout for response on readline()
      ArduinoSerial = serial.Serial('/dev/ttyACM0', 115200, timeout=0.005)
      print("ECU Ready")
      font = pygame.font.Font(None, 50)
      text = font.render("Serial Connection Established....", 2, (255, 0, 0))
      textpos.top = 200
      textpos.left = 20
      background.blit(text, textpos)
      screen.blit(background, (0, 0))
      pygame.display.flip()
      connected = True
      time.sleep(3)
   except:
      print("ECU ttyACM Not Ready")
      try:
         # timeout for response on readline()
        ArduinoSerial = serial.Serial('/dev/ttyUSB0', 115200, timeout=0.005)
        print("ECU Ready")
        font = pygame.font.Font(None, 50)
        text = font.render("Serial Connection Established....", 2, (255, 0, 0))
        textpos.top = 200
        textpos.left = 20
        background.blit(text, textpos)
        screen.blit(background, (0, 0))
        pygame.display.flip()
        connected = True
        time.sleep(3)
      except:
         print("ECU ttyUSB Not Ready")
      
# time.sleep(2) #allow time for serial port to open
var = "A"
# get input from user
print("Sending Command:  ", var)

# print the input for confirmation
count = 1

ecu_sel = 4

while True:




    for event in pygame.event.get():
        if event.type == pygame.KEYDOWN:
            print("Key pressed - " + pygame.key.name(event.key))
            if event.key == pygame.K_ASTERISK:
                print("Asterisk pressed - need to quit")
                pygame.display.quit()
                pygame.quit()
                sys.exit()
            if event.key == pygame.K_q:
                print("Q pressed - need to quit")
                pygame.display.quit()
                pygame.quit()
                sys.exit()
            if event.key == pygame.K_s:

                print("S pressed - Sleep for 10")
                time.sleep(10)
                pygame.quit()
                sys.exit()
            if event.key == pygame.K_RIGHT:
                print("You pressed the right arrow")
                
				#Screen view top left	
                disp_now=1 
                background.fill((0,0,0))
                screen_init=0
                screen_view = screen_view+1
                if screen_view > 6:
                    screen_view = 0
                if screen_view==4:
                    pygame.draw.rect(background,(50,50,50),(260,10,530,460))
                    pygame.draw.rect(background,(220,220,220),(265,15,520,450))
                    pygame.draw.circle(background,(0,0,200),(525,240),2+(lap_dia))            #outer black circle
                    pygame.draw.circle(background,(200,200,200),(525,240),lap_dia)            #outer black circle
                time.sleep(.5)                
            if event.key == pygame.K_UP:
                print("You pressed the right arrow")
                
				#Screen view top left	
                disp_now=1 
                background.fill((0,0,0))
                screen_init=0
                screen_view = screen_view+1
                if screen_view > 6:
                    screen_view = 0
                if screen_view==4:
                    pygame.draw.rect(background,(50,50,50),(260,10,530,460))
                    pygame.draw.rect(background,(220,220,220),(265,15,520,450))
                    pygame.draw.circle(background,(0,0,200),(525,240),2+(lap_dia))            #outer black circle
                    pygame.draw.circle(background,(200,200,200),(525,240),lap_dia)            #outer black circle
                time.sleep(.5)                
            if event.type == pygame.MOUSEBUTTONUP:
                print ("You pressed the left mouse button at (%d, %d)" % event.pos)
                x, y = event.pos
				#Screen view top left	
                if x<400 and y<240:	
                    disp_now=1 
                    background.fill((0,0,0))
                    screen_init=0
                    screen_view = screen_view+1
                    if screen_view > 6:
                        screen_view = 0
                    if screen_view==4:
                        pygame.draw.rect(background,(50,50,50),(260,10,530,460))
                        pygame.draw.rect(background,(220,220,220),(265,15,520,450))
                        pygame.draw.circle(background,(0,0,200),(525,240),2+(lap_dia))            #outer black circle
                        pygame.draw.circle(background,(200,200,200),(525,240),lap_dia)            #outer black circle
                    time.sleep(.5)

                                
    ArduinoSerial.write(var.encode())
    data = ArduinoSerial.read()  # the last bit gets rid of the new-line char
    lineout = ""
    bytecount = 0
    while data:
    #    try:
	#       lineout += str(ord(data.decode())) + " "
    #    except:
	#       lineout += str(ord(data)) + " "
        try:
            lineout += str(ord(data.decode())) + " "
            currval1 = str(ord(data.decode()))

        except:
            lineout += str(ord(data)) + " "
            currval1 = str(ord(data))
        if bytecount == 4:
            map = int(currval1)
            print("map + "+str(map))
        elif bytecount == 40:
            baro = int(currval1)
            map_bar = (map - baro) / 101.33
            map_kpa = map_bar
            map_psi = (map - baro) * 0.145038
            map_inhg = (baro - map) * 0.2953007                 
            mapsensor = map_bar
            print("mapsensor + "+str(mapsensor))
            print("map_bar + "+str(map_bar))
            print("map_psi + "+str(map_psi))
            print("map_inhg + "+str(map_inhg))
        elif bytecount == 7:
            coolantRaw = int(currval1)
            coolant = coolantRaw - 40
            w_temp = coolantRaw - 40
        elif bytecount == 6:
            iatRaw = int(currval1)
            iat = iatRaw - 40
            a_temp = iat
        elif bytecount == 114:
            fueltempRaw = int(currval1)
        elif bytecount == 10:
            afr = int(currval1)
        elif bytecount == 105:
            fuelpressureRaw = int(currval1)
            fuelpressure = fuelpressureRaw * 0.06894;
            fuel_press = fuelpressure
        elif bytecount == 106:
            oilpressureRaw = int(currval1)
            oilpressure = oilpressureRaw * 0.06894;
            oil_press = oilpressure
        elif bytecount == 14:
            rpmd = int(currval1)
            rpmd = count*10#int(listdata[14])
        elif bytecount == 9:
            batt_v = int(currval1)
            volts = int(currval1)
        elif bytecount == 24:
            tps = int(currval1)
        elif bytecount == 1:
            map = int(currval1)
        elif bytecount == 1:
            map = int(currval1)
        elif bytecount == 1:
            lineout += str(ord(data)) + " "
        bytecount += 1
        data = ArduinoSerial.read()
    try:
        basicdashdata = "BASIC~"+lineout
        
        #handle_client(basicdashdata)
        # datalist = basicdashdata.split('~')
        # listdata = datalist[1].split(' ')
        # # print("Data from socket : " + datalist[1])
        # try:
        #     map = int(listdata[4])
        #     baro = int(listdata[40])

        #     map_bar = {(map - baro) / 101.33}
        #     map_psi = {(map - baro) * 0.145038}
        #     map_inhg = {(baro - map) * 0.2953007}
        #     # map_vacboost = { map < baro ? -map_inhg : map_psi };
        #     # fueltemp = fueltempRaw - 40
        #     # afrTarget = int(listdata[21]
        #     # lambda1           =  afr / stoich ;
        #     # lambdaTarget     =  afrTarget / stoich ;

        #     coolantRaw = int(listdata[7])
        #     coolant = coolantRaw - 40
        #     iatRaw = int(listdata[6])
        #     iat = iatRaw - 40
        #     fueltempRaw = int(listdata[114])
        #     afr = int(listdata[10])
        #     stoich = 14.7
        #     fuelpressureRaw = int(listdata[105]);
        #     fuelpressure = fuelpressureRaw * 0.06894;
        #     oilpressureRaw = int(listdata[106]);
        #     oilpressure = oilpressureRaw * 0.06894;
        #     a_temp = iat
        #     print("setting RPM val to" + str(count*10))

        #     rpmd = count*10#int(listdata[14])
        #     batt_v = int(listdata[9])
        #     map_kpa = map_bar
        #     w_temp = coolant
        #     tps = int(listdata[24])
        #     oil_press = oilpressure
        #     fuel_press = fuelpressure
        # except Exception as e: print(e)
            

        for extip in allips:
            try:
                print("sending to IP - " + extip)
                # fulldata = "FULL~155,"+vars[4] + "~210,"+vars[24] +"~135,"+vars[6]+ "~179,"+vars[14] + "~199,"+str(count) + "~6,"+vars[10] + "~22,"+str(map_psi)
                # sock.sendto(fulldata.encode('utf-8'), (extip, UDP_PORT))
                coredata = "CORE~,"+lineout
                sock.sendto(coredata.encode('utf-8'), (extip, UDP_PORT))
                # sock.sendto(("155,"+vars[4]).encode('utf-8'), (extip, UDP_PORT))
                # sock.sendto(("210,"+vars[24]).encode('utf-8'), (extip, UDP_PORT))
                # sock.sendto(("135,"+vars[6]).encode('utf-8'), (extip, UDP_PORT))
                # sock.sendto(("179,"+vars[14]).encode('utf-8'), (extip, UDP_PORT))
                # sock.sendto(("199,"+str(count)).encode('utf-8'), (extip, UDP_PORT))
                # sock.sendto(("6,"+vars[10]).encode('utf-8'), (extip, UDP_PORT))
                # sock.sendto(("22,"+str(map_psi)).encode('utf-8'), (extip, UDP_PORT))
            except:
                print("Error sending to IP - " + extip)

        # sock.sendto(("155,"+vars[4]).encode('utf-8'), (UDP_IP, UDP_PORT))
        # sock.sendto(("210,"+vars[24]).encode('utf-8'), (UDP_IP, UDP_PORT))
        # sock.sendto(("135,"+vars[6]).encode('utf-8'), (UDP_IP, UDP_PORT))
        # sock.sendto(("179,"+vars[14]).encode('utf-8'), (UDP_IP, UDP_PORT))
        # sock.sendto(("199,"+str(count)).encode('utf-8'), (UDP_IP, UDP_PORT))
        # sock.sendto(("6,"+vars[10]).encode('utf-8'), (UDP_IP, UDP_PORT))
        # sock.sendto(("22,"+str(map_psi)).encode('utf-8'), (UDP_IP, UDP_PORT))
        count = count + 1
        if (count > 300):
            count = 1
        # print("Count " + str(count) )
        try:  
            # print("displ b4 if - " + str(displ) )
            if displ==1:
                # print("In Displ = " + str(displ))
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
        
                #if rpmd < sl_max-(4*sl_step):    
                		#GPIO.output(27, 1)
                #if rpmd > sl_max-(4*sl_step):
                		#GPIO.output(27, 0)
                #if rpmd < sl_max-(3*sl_step):
                		#GPIO.output(23, 1)
                #if rpmd > sl_max-(3*sl_step):
                		#GPIO.output(23, 0)
                #if rpmd < sl_max-(2*sl_step):
                		#GPIO.output(24, 1)
                #if rpmd > sl_max-(2*sl_step):
                		#GPIO.output(24, 0)
                #if rpmd < sl_max-sl_step:
                		#GPIO.output(25, 1)
                #if rpmd > sl_max-sl_step:
                		#GPIO.output(25, 0)
                #if rpmd < sl_max:
                		#GPIO.output(26, 1)
                #if rpmd > sl_max:
                		#GPIO.output(26, 0)
        
        
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
        
        
                                            #if alarm_led==0:
                    	  #GPIO.output(27, 0)
                
                                            #if alarm_led==1:
                    	  #GPIO.output(23, 0)
                
                                            #if alarm_led==2:
                              #GPIO.output(24, 0)
                
                                            #if alarm_led==3:
                    	  #GPIO.output(26, 0)
                              #GPIO.output(25, 0)
                
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
        
#Scr    een 0-----------------------------------------------------------------------------------------
                if screen_view == 0:
                    # print("screenview = 0")
                    X = 0
                    Y = 300
                    for k in range (1,200):
                        pygame.draw.rect(background,grey,(X,Y-10,4,45+Y/10))
                        if k==20 or k==40 or k==60 or k==80 or k==100 or k==120 or k==140 or k==160 or k==180 or k==199:
                            pygame.draw.rect(background,grey,(X,Y-10,4,45+Y/10))
                        if k==10 or k==30 or k==50 or k==70 or k==90 or k==110 or k==130 or k==150 or k==170 or k==190:
                            pygame.draw.rect(background,grey,(X,Y-15,4,45+Y/10))
                        if k<5:
                            pygame.draw.rect(background,cyan,(X,Y-10,4,45+Y/10))
                        X=X+4
                        Y=Y-(Y/25)
                        if Y<40:
                            Y=40
                    X = 0
                    Y = 300
                    krpm=rpmd/50
                    for k in range (1,krpm):
                            pygame.draw.rect(background,green,(X,Y-10,4,45+Y/10))
                            if k<5:
                                pygame.draw.rect(background,cyan,(X,Y-10,4,45+Y/10))
                            if k>(sl_max/50)-16:
                                pygame.draw.rect(background,yellow,(X,Y-10,4,45+Y/10))
                            if k>sl_max/50:
                                pygame.draw.rect(background,red,(X,Y-10,4,45+Y/10))
                            X=X+4
                            Y=Y-(Y/25)
                            if Y<40:
                                Y=40
                    # print("screeninit = " + str(screen_init))
                    if screen_init==0:
                        background.fill(black)
                        screen_init=1
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("0",2,white)
                        textpos.top = 350
                        textpos.left = 10
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("5",2,white)
                        textpos.top = 250
                        textpos.left = 50
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("10",2,white)
                        textpos.top = 180
                        textpos.left = 85
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("20",2,white)
                        textpos.top = 120
                        textpos.left = 150
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("30",2,white)
                        textpos.top = 85
                        textpos.left = 220
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("40",2,white)
                        textpos.top = 80
                        textpos.left = 300
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("50",2,white)
                        textpos.top = 80
                        textpos.left = 380
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("60",2,white)
                        textpos.top = 80
                        textpos.left = 460
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("70",2,white)
                        textpos.top = 80
                        textpos.left = 540
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("80",2,white)
                        textpos.top = 80
                        textpos.left = 620
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("90",2,white)
                        textpos.top = 80
                        textpos.left = 700
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("X",2,white)
                        textpos.top = 80
                        textpos.left = 780
                        background.blit(text,textpos)
                        
                        #font = pygame.font.Font(None, 60)
                        #text = font.render("Rpm ",2,white)
                        #textpos.top = 120
                        #textpos.left = 280
                        #background.blit(text,textpos)
                        
                        #water_T label
                        font = pygame.font.Font(None, 40)
                        text = font.render("Water" ,2,white)
                        textpos.top = 190
                        textpos.left = 180
                        background.blit(text,textpos)
                        #Oil label
                        font = pygame.font.Font(None, 40)
                        if an_mode==0 or an_mode==3:
                            text = font.render("Oil Press",2,white)
                        if an_mode==1:
                            text = font.render("EGT 1",2,white)
                        if an_mode==2:
                            text = font.render("DBW 1",2,white)
                        if ecu_sel==2:
                            text = font.render("POT 1",2,white)
                        if ecu_sel==3:
                            text = font.render("Fuel mS",2,white)
                        textpos.top = 190
                        textpos.left = 350
                        background.blit(text,textpos)
                        #Gear label
                        font = pygame.font.Font(None, 30)
                        text = font.render("Gear",2,white)
                        textpos.top = 10
                        textpos.left = 5
                        background.blit(text,textpos)
                        #Air temp label
                        font = pygame.font.Font(None, 40)
                        text = font.render("Air T",2,white)
                        textpos.top = 280
                        textpos.left = 500
                        background.blit(text,textpos)
                        #Batt Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("Batt V",2,white)
                        textpos.top = 190
                        textpos.left = 520
                        background.blit(text,textpos)
                        #Boost Batt Log
                        font = pygame.font.Font(None, 40)
                        text = font.render("Boost",2,white)
                        textpos = text.get_rect()
                        textpos.top = 280
                        textpos.left = 160
                        background.blit(text,textpos)
                        #EGT 2 Log
                        font = pygame.font.Font(None, 40)
                        if an_mode==0:
                            text = font.render("Oil Temp",2,white)
                        if an_mode==1:
                            text = font.render("EGT 2",2,white)
                        if an_mode==2:
                            text = font.render("DBW 2",2,white)
                        if an_mode==3:
                            text = font.render("Fuel P",2,white)
                        if ecu_sel==2:
                            text = font.render("POT A",2,white)
                        if ecu_sel==3:
                            text = font.render("Ign A",2,white)
                        textpos = text.get_rect()
                        textpos.top = 280
                        textpos.left = 330
                        background.blit(text,textpos)                  
                    #RPM
                    pygame.draw.rect(background,black,(300,110,300,80))
                    font = pygame.font.Font(None, 100)
                    print("setting RPM dash to" + str(rpmd))
                    text = font.render(str(rpmd),2,white)
                    textpos.top = 110
                    textpos.left = 300
                    background.blit(text,textpos)
                    
                    #Speed
                    pygame.draw.rect(background,black,(0,380,500,100))
                    font = pygame.font.Font(None, 120)
                    if demomode==1:
                        speedg=1000
                    if speedg>900:
                        speedg=888
                    text = font.render(str('%.0f' %speedg),2,white)
                    textpos.top = 400
                    textpos.left = 40
                    background.blit(text,textpos)
                    font = pygame.font.Font(None, 80)
                    text = font.render("kph",2,white)
                    textpos.top = 420
                    textpos.left = 190
                    background.blit(text,textpos)
                    font = pygame.font.Font(None, 40)
                    text = font.render("Power",2,cyan)
                    textpos.top = 400
                    textpos.left = 340
                    background.blit(text,textpos)
    
                    font = pygame.font.Font(None, 40)
                    text = font.render(str('%.1f' %power)+" Kw",2,green)
                    textpos.top = 440
                    textpos.left = 345
                    background.blit(text,textpos)
    
                    if rpmd>sl_max-200:
                        pygame.draw.rect(background,black,(20,380,450,100))
                        font = pygame.font.Font(None, 100)
                        text = font.render("SHIFT UP",2,red)
                        textpos.top = 390
                        textpos.left = 40
                        background.blit(text,textpos)
    
                    if rpmd>sl_max+500:
                        pygame.draw.rect(background,black,(20,380,450,100))
                        font = pygame.font.Font(None, 100)
                        text = font.render("SWINE",2,red)
                        textpos.top = 390
                        textpos.left = 40
                        background.blit(text,textpos)
                        
                    if volts<batt_lim:
                        pygame.draw.rect(background,yellow,(20,380,450,100))
                        font = pygame.font.Font(None, 100)
                        text = font.render("VOLTAGE",2,red)
                        textpos.top = 390
                        textpos.left = 40
                        background.blit(text,textpos)
                        
                    if afr>afr_lim:
                        pygame.draw.rect(background,yellow,(20,380,450,100))
                        font = pygame.font.Font(None, 100)
                        text = font.render("AFR LEAN",2,red)
                        textpos.top = 390
                        textpos.left = 40
                        background.blit(text,textpos)
                        
                    if mapsensor>boost_lim:
                        pygame.draw.rect(background,yellow,(20,380,450,100))
                        font = pygame.font.Font(None, 100)
                        text = font.render("B00ST",2,red)
                        textpos.top = 390
                        textpos.left = 40
                        background.blit(text,textpos)
                        
                    if an_mode>0:
                        if an_2<oiltemp_lim:
                            pygame.draw.rect(background,yellow,(20,380,450,100))
                            font = pygame.font.Font(None, 100)
                            text = font.render("FUEL PRESS",2,red)
                            textpos.top = 390
                            textpos.left = 40
                            background.blit(text,textpos)
                    if an_mode==0:
                        if an_2>oiltemp_lim:
                            pygame.draw.rect(background,yellow,(20,380,450,100))
                            font = pygame.font.Font(None, 100)
                            text = font.render("OIL TEMP",2,red)
                            textpos.top = 390
                            textpos.left = 40
                            background.blit(text,textpos)
    
                    if w_temp>watertemp_lim:
                            pygame.draw.rect(background,yellow,(20,380,450,100))
                            font = pygame.font.Font(None, 100)
                            text = font.render("W TEMP",2,red)
                            textpos.top = 390
                            textpos.left = 40
                            background.blit(text,textpos)
                    if an_mode>0:
                        if an_1>oilpress_lim:
                            pygame.draw.rect(background,yellow,(20,380,450,100))
                            font = pygame.font.Font(None, 100)
                            text = font.render("AN 1 P!",2,red)
                            textpos.top = 390
                            textpos.left = 40
                            background.blit(text,textpos)
                    if an_mode==0:
                        if an_1<oilpress_lim:
                            pygame.draw.rect(background,yellow,(20,380,450,100))
                            font = pygame.font.Font(None, 100)
                            text = font.render("OIL PRESS",2,red)
                            textpos.top = 390
                            textpos.left = 40
                            background.blit(text,textpos)
    
                    #water_T/ Oil
                    if data_refresh==2 or  data_refresh==4 or data_refresh==6 or data_refresh==8 or data_refresh==10 :
                        pygame.draw.rect(background,(black),(190,220,100,60))
                        font = pygame.font.Font(None, 70)
                        text = font.render(str('%.0f' %w_temp),2,yellow)
                        textpos.top = 220
                        textpos.left = 190
                        background.blit(text,textpos)
                        #water_T/ Oil
                        pygame.draw.rect(background,black,(360,220,150,60))
                        font = pygame.font.Font(None, 70)
                        text = font.render(str('%.1f' %an_1),2,yellow)
                        textpos.top = 220
                        textpos.left = 360
                        background.blit(text,textpos)
                        #Boost volts
                    if data_refresh==1 or  data_refresh==3 or data_refresh==5 or data_refresh==7 or data_refresh==9 :
                        pygame.draw.rect(background,black,(170,310,150,60))
                        font = pygame.font.Font(None, 70)
                        text = font.render(str('%.2f' %mapsensor),2,green)
                        textpos = text.get_rect()
                        textpos.top = 310
                        textpos.left = 170
                        background.blit(text,textpos)
                    #EGT2 Log
                    if data_refresh==9:
                        pygame.draw.rect(background,black,(340,310,150,60))
                        font = pygame.font.Font(None, 70)
                        text = font.render(str('%.1f' %an_2),2,green)
                        textpos = text.get_rect()
                        textpos.top = 310
                        textpos.left = 340
                        background.blit(text,textpos)
                    #Current lap time					
                        pygame.draw.rect(background,black,(500,380,300,100))
                        font = pygame.font.Font(None, 120)
                        text = font.render(str(curminute) + ":" + str('%.2f' %cursec),2,cyan)
                    if cursec<10:
                        text = font.render(str(curminute) + ":0" + str('%.2f' %cursec),2,cyan)
                        textpos.top = 380
                        textpos.left = 520
                        background.blit(text,textpos)
                    print("dispnow = " + str(disp_now))

                    if disp_now==1:
                        disp_now=0
                        pygame.draw.rect(background,black,(650,120,150,200))
                        font = pygame.font.Font(None, 50)
                        text = font.render("LAP " + str(laps_done) ,2,white)
                        textpos = text.get_rect()
                        textpos.top = 120
                        textpos.left = 650
                        background.blit(text,textpos)
    
                        font = pygame.font.Font(None, 50)
                        text = font.render(str(lapminute) + ":" + str('%.1f' %lapsec),2,yellow)
                        if lapsec<10:
                            text = font.render(str(lapminute) + ":0" + str('%.1f' %lapsec),2,yellow)
                        textpos = text.get_rect()
                        textpos.top = 160
                        textpos.left = 670
                        background.blit(text,textpos)
    
                        font = pygame.font.Font(None, 50)
                        text = font.render(str(bestminute) +":" + str('%.1f' %bestsec),2,purple)
                        if bestsec<10:
                            text = font.render(str(bestminute) +":0" + str('%.1f' %bestsec),2,purple)
                        textpos = text.get_rect()
                        textpos.top = 200
                        textpos.left = 670
                        background.blit(text,textpos)
    
                        font = pygame.font.Font(None, 35)
                        text = font.render("LAP DELTA",2,white)
                        textpos = text.get_rect()
                        textpos.top = 245
                        textpos.left = 650
                        background.blit(text,textpos)
    
                        font = pygame.font.Font(None, 50)
                        if deltatime>0:
                                text = font.render(str('%.1f' %deltatime),2,red)
                        else:
                                text = font.render(str('%.1f' %deltatime),2,green)
                        textpos = text.get_rect()
                        textpos.top = 280
                        textpos.left = 670
                        background.blit(text,textpos)
    
    
                        pygame.draw.rect(background,black,(600,320,200,80))
                        font = pygame.font.Font(None, 35)
                        text = font.render("Sector 1:  " + ('%.1f' %s1_time),1,grey)
                        textpos.top = 320
                        textpos.left = 620
                        background.blit(text,textpos)
    
                        font = pygame.font.Font(None, 35)
                        text = font.render("Sector 2:  " + ('%.1f' %(s2_time-s1_time)),1,grey)
                        textpos.top = 350
                        textpos.left = 620
                        background.blit(text,textpos)
    
                        pygame.draw.rect(background,black,(80,10,120,30))
                        font = pygame.font.Font(None, 30)
                        text = font.render(str(track_name),1,red)
                        textpos.top = 10
                        textpos.left = 80
                        background.blit(text,textpos)
    
                    if data_refresh==1:
                        pygame.draw.rect(background,black,(400,0,400,25))
                        font = pygame.font.Font(None, 25)
                        text = font.render(str("Log: " + '%.1f' %data_rate)+ "Hz. GPS: " + str('%.1f' %gps_rate)+"Hz " + str(screen_view),2,white)
                        textpos.top = 5
                        textpos.left = 400
                        background.blit(text,textpos)
                        #Gear
                    if data_refresh==3:
                        pygame.draw.rect(background,black,(10,35,50,60))
                        font = pygame.font.Font(None, 80)
                        text = font.render(str('%.0f' %gear),2,(200,200,10))
                        textpos.top = 35
                        textpos.left = 10
                        background.blit(text,textpos)
                        #Air Temp
                    if data_refresh==5:
                        pygame.draw.rect(background,black,(510,310,90,60))
                        font = pygame.font.Font(None, 70)
                        text = font.render(str('%.0f' %a_temp),2,green)
                        textpos.top = 310
                        textpos.left = 510
                        background.blit(text,textpos)
                        #Battery
                    if data_refresh==7:
                        pygame.draw.rect(background,black,(530,220,120,60))
                        font = pygame.font.Font(None, 70)
                        if volts>11.5:
                            text = font.render(str('%.1f' %volts),2,yellow)
                        if volts<11.6:
                            text = font.render(str('%.1f' %volts),2,red)
                        textpos.top = 220
                        textpos.left = 530
                        background.blit(text,textpos)
    
                    if log_on==1 and data_refresh==1:
                        font = pygame.font.Font(None, 20)
                        text = font.render("Logging On",2,red)
                        textpos = text.get_rect()
                        textpos.top = 450
                        textpos.left = 20
                        background.blit(text,textpos)
    
                    screen.blit(background,(0,0))
                    pygame.display.flip()
        
#Scr    een 1 ECU DATA-------------------------------------------------------------------------------------
                if screen_view == 1:
                    print("screenview = 1")
                    X = 0
                    Y = 300
                    for k in range (1,200):
                        pygame.draw.rect(background,grey,(X,Y-10,4,45+Y/10))
                        if k==20 or k==40 or k==60 or k==80 or k==100 or k==120 or k==140 or k==160 or k==180 or k==199:
                            pygame.draw.rect(background,grey,(X,Y-10,4,45+Y/10))
                        if k==10 or k==30 or k==50 or k==70 or k==90 or k==110 or k==130 or k==150 or k==170 or k==190:
                            pygame.draw.rect(background,grey,(X,Y-15,4,45+Y/10))
                        if k<5:
                            pygame.draw.rect(background,cyan,(X,Y-10,4,45+Y/10))
                        X=X+4
                        Y=Y-(Y/25)
                        if Y<40:
                            Y=40
                    X = 0
                    Y = 300
                    krpm=rpmd/50
                    for k in range (1,krpm):
                            pygame.draw.rect(background,green,(X,Y-10,4,45+Y/10))
                            if k<5:
                                pygame.draw.rect(background,cyan,(X,Y-10,4,45+Y/10))
                            if k>(sl_max/50)-16:
                                pygame.draw.rect(background,yellow,(X,Y-10,4,45+Y/10))
                            if k>sl_max/50:
                                pygame.draw.rect(background,red,(X,Y-10,4,45+Y/10))
                            X=X+4
                            Y=Y-(Y/25)
                            if Y<40:
                                Y=40
                    if screen_init==0:
                        background.fill(black)
                        screen_init=1
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("0",2,white)
                        textpos.top = 350
                        textpos.left = 10
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("5",2,white)
                        textpos.top = 250
                        textpos.left = 50
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("10",2,white)
                        textpos.top = 180
                        textpos.left = 85
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("20",2,white)
                        textpos.top = 120
                        textpos.left = 150
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("30",2,white)
                        textpos.top = 85
                        textpos.left = 220
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("40",2,white)
                        textpos.top = 80
                        textpos.left = 300
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("50",2,white)
                        textpos.top = 80
                        textpos.left = 380
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("60",2,white)
                        textpos.top = 80
                        textpos.left = 460
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("70",2,white)
                        textpos.top = 80
                        textpos.left = 540
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("80",2,white)
                        textpos.top = 80
                        textpos.left = 620
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("90",2,white)
                        textpos.top = 80
                        textpos.left = 700
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("X",2,white)
                        textpos.top = 80
                        textpos.left = 780
                        background.blit(text,textpos)
                        
                        #font = pygame.font.Font(None, 60)
                        #text = font.render("Rpm ",2,white)
                        #textpos.top = 120
                        #textpos.left = 280
                        #background.blit(text,textpos)
                        
                        #water_T label
                        font = pygame.font.Font(None, 40)
                        text = font.render("Water" ,2,white)
                        textpos.top = 190
                        textpos.left = 180
                        background.blit(text,textpos)
                        #Oil label
                        font = pygame.font.Font(None, 40)
                        if an_mode==0 or an_mode==3:
                            text = font.render("Oil Press",2,white)
                        if an_mode==1:
                            text = font.render("EGT 1",2,white)
                        if an_mode==2:
                            text = font.render("DBW 1",2,white)
                        if ecu_sel==2:
                            text = font.render("POT 1",2,white)
                        if ecu_sel==3:
                            text = font.render("Fuel mS",2,white)
                            textpos.top = 190
                        textpos.left = 350
                        background.blit(text,textpos)
                        #Gear label
                        font = pygame.font.Font(None, 30)
                        text = font.render("Gear",2,white)
                        textpos.top = 10
                        textpos.left = 5
                        background.blit(text,textpos)
                        #Air temp label
                        font = pygame.font.Font(None, 40)
                        text = font.render("Air T",2,white)
                        textpos.top = 280
                        textpos.left = 500
                        background.blit(text,textpos)
                        #Batt Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("Batt V",2,white)
                        textpos.top = 190
                        textpos.left = 520
                        background.blit(text,textpos)
                        #Boost Batt Log
                        font = pygame.font.Font(None, 40)
                        text = font.render("Throttle",2,white)
                        textpos = text.get_rect()
                        textpos.top = 280
                        textpos.left = 160
                        background.blit(text,textpos)
                        #EGT 2 Log
                        font = pygame.font.Font(None, 40)
                        if an_mode==0:
                            text = font.render("Oil Temp",2,white)
                        if an_mode==1:
                            text = font.render("EGT 2",2,white)
                        if an_mode==2:
                            text = font.render("DBW 2",2,white)
                        if an_mode==3:
                            text = font.render("Fuel P",2,white)
                        if ecu_sel==2:
                            text = font.render("POT A",2,white)
                        if ecu_sel==3:
                            text = font.render("Ign A",2,white)
                        textpos = text.get_rect()
                        textpos.top = 280
                        textpos.left = 330
                        background.blit(text,textpos)
                        
                    #RPM
                    pygame.draw.rect(background,black,(300,110,300,80))
                    font = pygame.font.Font(None, 100)
                    text = font.render(str(rpmd),2,white)
                    textpos.top = 110
                    textpos.left = 300
                    background.blit(text,textpos)
                    
                    #Speed
                    pygame.draw.rect(background,black,(0,380,500,100))
                    font = pygame.font.Font(None, 120)
                    if demomode==1:
                        speedg=1000
                    if speedg>900:
                        speedg=888
                    text = font.render(str('%.0f' %speedg),2,white)
                    textpos.top = 400
                    textpos.left = 40
                    background.blit(text,textpos)
                    font = pygame.font.Font(None, 80)
                    text = font.render("kph",2,white)
                    textpos.top = 420
                    textpos.left = 190
                    background.blit(text,textpos)
                    font = pygame.font.Font(None, 40)
                    text = font.render("Power",2,cyan)
                    textpos.top = 400
                    textpos.left = 340
                    background.blit(text,textpos)
    
                    font = pygame.font.Font(None, 40)
                    text = font.render(str('%.1f' %power)+" Kw",2,green)
                    textpos.top = 440
                    textpos.left = 345
                    background.blit(text,textpos)
    
                    if rpmd>sl_max-200:
                        pygame.draw.rect(background,black,(20,380,450,100))
                        font = pygame.font.Font(None, 100)
                        text = font.render("SHIFT UP",2,red)
                        textpos.top = 390
                        textpos.left = 40
                        background.blit(text,textpos)
    
                    if rpmd>sl_max+500:
                        pygame.draw.rect(background,black,(20,380,450,100))
                        font = pygame.font.Font(None, 100)
                        text = font.render("SWINE",2,red)
                        textpos.top = 390
                        textpos.left = 40
                        background.blit(text,textpos)
                        
                    if volts<batt_lim:
                        pygame.draw.rect(background,yellow,(20,380,450,100))
                        font = pygame.font.Font(None, 100)
                        text = font.render("VOLTAGE",2,red)
                        textpos.top = 390
                        textpos.left = 40
                        background.blit(text,textpos)
                        
                    if afr>afr_lim:
                        pygame.draw.rect(background,yellow,(20,380,450,100))
                        font = pygame.font.Font(None, 100)
                        text = font.render("AFR LEAN",2,red)
                        textpos.top = 390
                        textpos.left = 40
                        background.blit(text,textpos)
                        
                    if tps<3:
                        pygame.draw.rect(background,yellow,(20,380,450,100))
                        font = pygame.font.Font(None, 100)
                        text = font.render("THROTTLE",2,red)
                        textpos.top = 390
                        textpos.left = 40
                        background.blit(text,textpos)
                        
                    if an_mode>0:
                        if an_2<oiltemp_lim:
                            pygame.draw.rect(background,yellow,(20,380,450,100))
                            font = pygame.font.Font(None, 100)
                            text = font.render("FUEL PRESS",2,red)
                            textpos.top = 390
                            textpos.left = 40
                            background.blit(text,textpos)
                    if an_mode==0:
                        if an_2>oiltemp_lim:
                            pygame.draw.rect(background,yellow,(20,380,450,100))
                            font = pygame.font.Font(None, 100)
                            text = font.render("OIL TEMP",2,red)
                            textpos.top = 390
                            textpos.left = 40
                            background.blit(text,textpos)
    
                    if w_temp>watertemp_lim:
                        pygame.draw.rect(background,yellow,(20,380,450,100))
                        font = pygame.font.Font(None, 100)
                        text = font.render("W TEMP",2,red)
                        textpos.top = 390
                        textpos.left = 40
                        background.blit(text,textpos)
                    if an_mode>0:
                        if an_1>oilpress_lim:
                            pygame.draw.rect(background,yellow,(20,380,450,100))
                            font = pygame.font.Font(None, 100)
                            text = font.render("AN 1 P!",2,red)
                            textpos.top = 390
                            textpos.left = 40
                            background.blit(text,textpos)
                    if an_mode==0:
                        if an_1<oilpress_lim:
                            pygame.draw.rect(background,yellow,(20,380,450,100))
                            font = pygame.font.Font(None, 100)
                            text = font.render("OIL PRESS",2,red)
                            textpos.top = 390
                            textpos.left = 40
                            background.blit(text,textpos)
    
                        #water_T/ Oil
                    if data_refresh==2 or  data_refresh==4 or data_refresh==6 or data_refresh==8 or data_refresh==10 :
                        pygame.draw.rect(background,(black),(190,220,100,60))
                        font = pygame.font.Font(None, 70)
                        text = font.render(str('%.0f' %w_temp),2,yellow)
                        textpos.top = 220
                        textpos.left = 190
                        background.blit(text,textpos)
                        #water_T/ Oil
                        pygame.draw.rect(background,black,(360,220,150,60))
                        font = pygame.font.Font(None, 70)
                        text = font.render(str('%.1f' %an_1),2,yellow)
                        textpos.top = 220
                        textpos.left = 360
                        background.blit(text,textpos)
                        #Boost volts
                    if data_refresh==1 or  data_refresh==3 or data_refresh==5 or data_refresh==7 or data_refresh==9 :
                        pygame.draw.rect(background,black,(170,310,150,60))
                        font = pygame.font.Font(None, 70)
                        text = font.render(str('%.1f' %tps),2,green)
                        textpos = text.get_rect()
                        textpos.top = 310
                        textpos.left = 170
                        background.blit(text,textpos)
                    #EGT2 Log
                    if data_refresh==9:
                        pygame.draw.rect(background,black,(340,310,150,60))
                        font = pygame.font.Font(None, 70)
                        text = font.render(str('%.1f' %an_2),2,green)
                        textpos = text.get_rect()
                        textpos.top = 310
                        textpos.left = 340
                        background.blit(text,textpos)
                    #Current lap time					
                        pygame.draw.rect(background,black,(500,380,300,100))
                        font = pygame.font.Font(None, 120)
                        text = font.render(str(curminute) + ":" + str('%.2f' %cursec),2,cyan)
                    if cursec<10:
                        text = font.render(str(curminute) + ":0" + str('%.2f' %cursec),2,cyan)
                        textpos.top = 380
                        textpos.left = 520
                        background.blit(text,textpos)
                    if disp_now==1:
                        disp_now=0
                        pygame.draw.rect(background,black,(650,120,150,200))
                        font = pygame.font.Font(None, 50)
                        text = font.render("LAP " + str(laps_done) ,2,white)
                        textpos = text.get_rect()
                        textpos.top = 120
                        textpos.left = 650
                        background.blit(text,textpos)

                        font = pygame.font.Font(None, 50)
                        text = font.render(str(lapminute) + ":" + str('%.1f' %lapsec),2,yellow)
                        if lapsec<10:
                                    text = font.render(str(lapminute) + ":0" + str('%.1f' %lapsec),2,yellow)
                        textpos = text.get_rect()
                        textpos.top = 160
                        textpos.left = 670
                        background.blit(text,textpos)

                        font = pygame.font.Font(None, 50)
                        text = font.render(str(bestminute) +":" + str('%.1f' %bestsec),2,purple)
                        if bestsec<10:
                                    text = font.render(str(bestminute) +":0" + str('%.1f' %bestsec),2,purple)
                        textpos = text.get_rect()
                        textpos.top = 200
                        textpos.left = 670
                        background.blit(text,textpos)

                        font = pygame.font.Font(None, 35)
                        text = font.render("LAP DELTA",2,white)
                        textpos = text.get_rect()
                        textpos.top = 245
                        textpos.left = 650
                        background.blit(text,textpos)

                        font = pygame.font.Font(None, 50)
                        if deltatime>0:
                            text = font.render(str('%.1f' %deltatime),2,red)
                        else:
                            text = font.render(str('%.1f' %deltatime),2,green)
                        textpos = text.get_rect()
                        textpos.top = 280
                        textpos.left = 670
                        background.blit(text,textpos)


                        pygame.draw.rect(background,black,(600,320,200,80))
                        font = pygame.font.Font(None, 35)
                        text = font.render("Sector 1:  " + ('%.1f' %s1_time),1,grey)
                        textpos.top = 320
                        textpos.left = 620
                        background.blit(text,textpos)

                        font = pygame.font.Font(None, 35)
                        text = font.render("Sector 2:  " + ('%.1f' %(s2_time-s1_time)),1,grey)
                        textpos.top = 350
                        textpos.left = 620
                        background.blit(text,textpos)

                        pygame.draw.rect(background,black,(80,10,120,30))
                        font = pygame.font.Font(None, 30)
                        text = font.render(str(track_name),1,red)
                        textpos.top = 10
                        textpos.left = 80
                        background.blit(text,textpos)

                    if data_refresh==1:
                        pygame.draw.rect(background,black,(400,0,400,25))
                        font = pygame.font.Font(None, 25)
                        text = font.render(str("Log: " + '%.1f' %data_rate)+ "Hz. GPS: " + str('%.1f' %gps_rate)+"Hz " + str(screen_view),2,white)
                        textpos.top = 5
                        textpos.left = 400
                        background.blit(text,textpos)
                        #Gear
                    if data_refresh==3:
                        pygame.draw.rect(background,black,(10,35,50,60))
                        font = pygame.font.Font(None, 80)
                        text = font.render(str('%.0f' %gear),2,(200,200,10))
                        textpos.top = 35
                        textpos.left = 10
                        background.blit(text,textpos)
                        #Air Temp
                    if data_refresh==5:
                        pygame.draw.rect(background,black,(510,310,90,60))
                        font = pygame.font.Font(None, 70)
                        text = font.render(str('%.0f' %a_temp),2,green)
                        textpos.top = 310
                        textpos.left = 510
                        background.blit(text,textpos)
                        #Battery
                    if data_refresh==7:
                        pygame.draw.rect(background,black,(530,220,120,60))
                        font = pygame.font.Font(None, 70)
                        if volts>11.5:
                            text = font.render(str('%.1f' %volts),2,yellow)
                        if volts<11.6:
                            text = font.render(str('%.1f' %volts),2,red)
                        textpos.top = 220
                        textpos.left = 530
                        background.blit(text,textpos)
    
                    if log_on==1 and data_refresh==1:
                        font = pygame.font.Font(None, 20)
                        text = font.render("Logging On",2,red)
                        textpos = text.get_rect()
                        textpos.top = 450
                        textpos.left = 20
                        background.blit(text,textpos)
        
                    screen.blit(background,(0,0))
                    pygame.display.flip()
        
#Scr    een2-----ECU DATA--------------------------------------------------------------------------------------------------------------------------
                if screen_view == 2:
                    print("screenview = 2")
                    X = 0
                    Y = 300
                    for k in range (1,200):
                          pygame.draw.rect(background,grey,(X,Y-20,4,55+Y/10))
                          if k==20 or k==40 or k==60 or k==80 or k==100 or k==120 or k==140 or k==160 or k==180 or k==199:
                              pygame.draw.rect(background,grey,(X,Y-20,4,55+Y/10))
                          if k==10 or k==30 or k==50 or k==70 or k==90 or k==110 or k==130 or k==150 or k==170 or k==190:
                              pygame.draw.rect(background,grey,(X,Y-25,4,55+Y/10))
                          if k<5:
                              pygame.draw.rect(background,cyan,(X,Y-20,4,55+Y/10))
                          X=X+4
                          Y=Y-(Y/25)
                          if Y<40:
                              Y=40
                    X = 0
                    Y = 300
                    krpm=rpmd/50
                    for k in range (1,krpm):
                            pygame.draw.rect(background,green,(X,Y-20,4,55+Y/10))
                            if k<5:
                                pygame.draw.rect(background,cyan,(X,Y-20,4,55+Y/10))
                            if k>(sl_max/50)-16:
                                pygame.draw.rect(background,yellow,(X,Y-20,4,55+Y/10))
                            if k>sl_max/50:
                                pygame.draw.rect(background,red,(X,Y-20,4,55+Y/10))
                            X=X+4
                            Y=Y-(Y/25)
                            if Y<40:
                                Y=40
                    if screen_init==0:
                        background.fill(black)
                        screen_init=1
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("0",2,white)
                        textpos.top = 350
                        textpos.left = 10
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("5",2,white)
                        textpos.top = 250
                        textpos.left = 50
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("10",2,white)
                        textpos.top = 180
                        textpos.left = 85
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("20",2,white)
                        textpos.top = 120
                        textpos.left = 150
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("30",2,white)
                        textpos.top = 85
                        textpos.left = 220
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("40",2,white)
                        textpos.top = 80
                        textpos.left = 300
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("50",2,white)
                        textpos.top = 80
                        textpos.left = 380
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("60",2,white)
                        textpos.top = 80
                        textpos.left = 460
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("70",2,white)
                        textpos.top = 80
                        textpos.left = 540
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("80",2,white)
                        textpos.top = 80
                        textpos.left = 620
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("90",2,white)
                        textpos.top = 80
                        textpos.left = 700
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("X",2,white)
                        textpos.top = 80
                        textpos.left = 780
                        background.blit(text,textpos)
                        
                        #water_T label
                        font = pygame.font.Font(None, 40)
                        text = font.render("Water" ,2,white)
                        textpos.top = 190
                        textpos.left = 160
                        background.blit(text,textpos)
                        #Oil label
                        font = pygame.font.Font(None, 40)
                        if an_mode==0 or an_mode==3:
                            text = font.render("Oil Press",2,white)
                        if an_mode==1:
                            text = font.render("EGT 1",2,white)
                        if an_mode==2:
                            text = font.render("DBW 1",2,white)
                        if ecu_sel==2:
                            text = font.render("POT 1",2,white)
                        if ecu_sel==3:
                            text = font.render("Fuel T",2,white)
                        textpos.top = 190
                        textpos.left = 330
                        background.blit(text,textpos)
                        #Gear label
                        font = pygame.font.Font(None, 30)
                        text = font.render("Gear",2,white)
                        textpos.top = 0
                        textpos.left = 5
                        background.blit(text,textpos)
                        #Air temp label
                        font = pygame.font.Font(None, 40)
                        text = font.render("Ign A",2,white)
                        textpos.top = 280
                        textpos.left = 500
                        background.blit(text,textpos)
                        #Batt Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("Afr",2,white)
                        textpos.top = 190
                        textpos.left = 500
                        background.blit(text,textpos)
                        #Boost Batt Log
                        font = pygame.font.Font(None, 40)
                        text = font.render("Tps      Map",2,white)
                        textpos = text.get_rect()
                        textpos.top = 280
                        textpos.left = 100
                        background.blit(text,textpos)
                        #EGT 2 Log
                        font = pygame.font.Font(None, 40)
                        text = font.render("Batt V",2,white)
                        textpos = text.get_rect()
                        textpos.top = 190
                        textpos.left = 670
                        background.blit(text,textpos)
                        #EGT 2 Log
                        font = pygame.font.Font(None, 40)
                        text = font.render("Fuel mS",2,white)
                        textpos = text.get_rect()
                        textpos.top = 280
                        textpos.left = 330
                        background.blit(text,textpos)
                        #EGT 2 Log
                        font = pygame.font.Font(None, 40)
                        text = font.render("Oil T",2,white)
                        textpos = text.get_rect()
                        textpos.top = 280
                        textpos.left = 670
                        background.blit(text,textpos)
                        
                    #RPM
                    #RPM
                    pygame.draw.rect(background,black,(300,110,300,80))
                    font = pygame.font.Font(None, 100)
                    text = font.render(str(rpmd),2,white)
                    textpos.top = 110
                    textpos.left = 300
                    background.blit(text,textpos)
    
#                		if data_refresh==1 or  data_refresh==3 or data_refresh==5 or data_refresh==7 or data_refresh==9 :
    
                    #Speed
                    pygame.draw.rect(background,black,(0,380,500,100))
                    font = pygame.font.Font(None, 120)
                    if speedg>900:
                        speedg=888
                    text = font.render(str('%.0f' %speedg),2,white)
                    textpos.top = 400
                    textpos.left = 40
                    background.blit(text,textpos)
                    font = pygame.font.Font(None, 80)
                    text = font.render("kph",2,white)
                    textpos.top = 420
                    textpos.left = 190
                    background.blit(text,textpos)
                    font = pygame.font.Font(None, 40)
                    text = font.render("Power",2,cyan)
                    textpos.top = 400
                    textpos.left = 340
                    background.blit(text,textpos)
    
                    font = pygame.font.Font(None, 40)
                    text = font.render(str('%.1f' %power)+" Kw",2,green)
                    textpos.top = 440
                    textpos.left = 345
                    background.blit(text,textpos)
    
                    if rpmd>sl_max-200:
                        pygame.draw.rect(background,black,(20,380,450,100))
                        font = pygame.font.Font(None, 100)
                        text = font.render("SHIFT UP",2,red)
                        textpos.top = 390
                        textpos.left = 40
                        background.blit(text,textpos)
    
                    if rpmd>sl_max+500:
                        pygame.draw.rect(background,black,(20,380,450,100))
                        font = pygame.font.Font(None, 100)
                        text = font.render("SWINE",2,red)
                        textpos.top = 390
                        textpos.left = 40
                        background.blit(text,textpos)
                        
                    if volts<batt_lim:
                        pygame.draw.rect(background,yellow,(20,380,450,100))
                        font = pygame.font.Font(None, 100)
                        text = font.render("VOLTAGE",2,red)
                        textpos.top = 390
                        textpos.left = 40
                        background.blit(text,textpos)
                        
                    if afr>afr_lim:
                        pygame.draw.rect(background,yellow,(20,380,450,100))
                        font = pygame.font.Font(None, 100)
                        text = font.render("AFR LEAN",2,red)
                        textpos.top = 390
                        textpos.left = 40
                        background.blit(text,textpos)
                        
                    if mapsensor>boost_lim:
                        pygame.draw.rect(background,yellow,(20,380,450,100))
                        font = pygame.font.Font(None, 100)
                        text = font.render("B00ST",2,red)
                        textpos.top = 390
                        textpos.left = 40
                        background.blit(text,textpos)
                        
                    if an_mode>0:
                        if an_2<oiltemp_lim:
                            pygame.draw.rect(background,yellow,(20,380,450,100))
                            font = pygame.font.Font(None, 100)
                            text = font.render("FUEL PRESS",2,red)
                            textpos.top = 390
                            textpos.left = 40
                            background.blit(text,textpos)
                    if an_mode==0:
                        if an_2>oiltemp_lim:
                            pygame.draw.rect(background,yellow,(20,380,450,100))
                            font = pygame.font.Font(None, 100)
                            text = font.render("OIL TEMP",2,red)
                            textpos.top = 390
                            textpos.left = 40
                            background.blit(text,textpos)
    
                    if w_temp>watertemp_lim:
                        pygame.draw.rect(background,yellow,(20,380,450,100))
                        font = pygame.font.Font(None, 100)
                        text = font.render("W TEMP",2,red)
                        textpos.top = 390
                        textpos.left = 40
                        background.blit(text,textpos)
                    if an_mode>0:
                        if an_1>oilpress_lim:
                            pygame.draw.rect(background,yellow,(20,380,450,100))
                            font = pygame.font.Font(None, 100)
                            text = font.render("AN 1 P!",2,red)
                            textpos.top = 390
                            textpos.left = 40
                            background.blit(text,textpos)
                    if an_mode==0:
                        if an_1<oilpress_lim:
                            pygame.draw.rect(background,yellow,(20,380,450,100))
                            font = pygame.font.Font(None, 100)
                            text = font.render("OIL PRESS",2,red)
                            textpos.top = 390
                            textpos.left = 40
                            background.blit(text,textpos)
    
                    if data_refresh==1 or data_refresh==3 or data_refresh==5 or data_refresh==7 or data_refresh==9:
                        #water_T/ Oil
                        pygame.draw.rect(background,(black),(170,220,100,60))
                        font = pygame.font.Font(None, 70)
                        text = font.render(str('%.0f' %w_temp),2,cyan)
                        textpos.top = 220
                        textpos.left = 170
                        background.blit(text,textpos)
                        #water_T/ Oil
                        pygame.draw.rect(background,black,(340,220,150,60))
                        font = pygame.font.Font(None, 70)
                        text = font.render(str('%.1f' %an_1),2,grey)
                        textpos.top = 220
                        textpos.left = 340
                        background.blit(text,textpos)
                        #Batt volts
                        pygame.draw.rect(background,black,(510,220,150,60))
                        font = pygame.font.Font(None, 70)
                        if afr<13:
                            text = font.render(str('%.1f' %afr),2,green)
                        if afr>12.9:
                            text = font.render(str('%.1f' %afr),2,red)
                        textpos.top = 220
                        textpos.left = 510
                        background.blit(text,textpos)
                        #EGT2 Log
                        pygame.draw.rect(background,black,(680,220,150,60))
                        font = pygame.font.Font(None, 70)
                        text = font.render(str('%.1f' %volts),2,cyan)
                        textpos = text.get_rect()
                        textpos.top = 220
                        textpos.left = 680
                        background.blit(text,textpos)
    
                    if data_refresh==2 or data_refresh==4 or data_refresh==6 or data_refresh==8 or data_refresh==10:
                        #Air Temp
                        pygame.draw.rect(background,black,(510,310,100,60))
                        font = pygame.font.Font(None, 70)
                        text = font.render(str('%.0f' %ign_A),2,blue)
                        textpos.top = 310
                        textpos.left = 510
                        background.blit(text,textpos)
                        #Boost Batt Log
                        pygame.draw.rect(background,black,(100,310,100,60))
                        font = pygame.font.Font(None, 70)
                        text = font.render(str('%.0f' %tps),2,green)
                        textpos = text.get_rect()
                        textpos.top = 310
                        textpos.left = 100
                        background.blit(text,textpos)
                        #Boost Batt Log
                        pygame.draw.rect(background,black,(220,310,120,60))
                        font = pygame.font.Font(None, 70)
                        text = font.render(str('%.1f' %mapsensor),2,cyan)
                        textpos = text.get_rect()
                        textpos.top = 310
                        textpos.left = 200
                        background.blit(text,textpos)
                        #EGT2 Log
                        pygame.draw.rect(background,black,(340,310,150,60))
                        font = pygame.font.Font(None, 70)
                        text = font.render(str('%.1f' %fuel_T),2,yellow)
                        textpos = text.get_rect()
                        textpos.top = 310
                        textpos.left = 340
                        background.blit(text,textpos)
    
                        #EGT2 Log
                        pygame.draw.rect(background,black,(680,310,150,60))
                        font = pygame.font.Font(None, 70)
                        text = font.render(str('%.0f' %an_2),2,yellow)
                        textpos = text.get_rect()
                        textpos.top = 310
                        textpos.left = 680
                        background.blit(text,textpos)
                    #Current lap time					
                        pygame.draw.rect(background,black,(500,380,300,100))
                        font = pygame.font.Font(None, 120)
                        text = font.render(str(curminute) + ":" + str('%.2f' %cursec),2,cyan)
                        if cursec<10:
                            text = font.render(str(curminute) + ":0" + str('%.2f' %cursec),2,cyan)
                        textpos.top = 380
                        textpos.left = 520
                        background.blit(text,textpos)
                        if disp_now==1:
                            disp_now=0
                            pygame.draw.rect(background,black,(650,110,150,80))
                            font = pygame.font.Font(None, 40)
                            text = font.render("Lap-: " + str(laps_done) ,2,white)
                            textpos = text.get_rect()
                            textpos.top = 110
                            textpos.left = 650
                            background.blit(text,textpos)
    
                            font = pygame.font.Font(None, 50)
                            text = font.render(str(lapminute) + ":" + str('%.1f' %lapsec),2,green)
                            if lapsec<10:
                                text = font.render(str(lapminute) + ":0" + str('%.1f' %lapsec),2,green)
                            textpos = text.get_rect()
                            textpos.top = 150
                            textpos.left = 670
                            background.blit(text,textpos)
    
    
                    if log_on==1:
                        font = pygame.font.Font(None, 20)
                        text = font.render("Logging On",2,red)
                        textpos = text.get_rect()
                        textpos.top = 450
                        textpos.left = 650
                        background.blit(text,textpos)
    
    
    
                    if data_refresh==1:
                        pygame.draw.rect(background,black,(600,0,200,15))
                        font = pygame.font.Font(None, 15)
                        text = font.render(str("Log: " + '%.1f' %data_rate)+ "Hz. GPS: " + str('%.1f' %gps_rate)+"Hz. Screen " + str(screen_view),2,white)
                        textpos.top = 0
                        textpos.left = 600
                        background.blit(text,textpos)
                        #Gear
                    if data_refresh==3:
                        pygame.draw.rect(background,black,(10,25,50,80))
                        font = pygame.font.Font(None, 80)
                        text = font.render(str('%.0f' %gear),2,(200,200,10))
                        textpos.top = 25
                        textpos.left = 10
                        background.blit(text,textpos)
                        #Air Temp
                        font = pygame.font.Font(None, 30)
                        text = font.render(str('%.1f' %gear),2,(200,200,10))
                        textpos.top = 80
                        textpos.left = 10
                        background.blit(text,textpos)
        
                    screen.blit(background,(0,0))
                    pygame.display.flip()
        
        
        
#Scr    een 6 Manny Trix		-----------------------------------------------------------------------------
                if screen_view == 6:    
                    print("screenview = 6")
        
                    X = 0
                    Y = 300
                    for k in range (1,200):
                        pygame.draw.rect(background,grey,(X,Y-10,4,45+Y/10))
                        if k==20 or k==40 or k==60 or k==80 or k==100 or k==120 or k==140 or k==160 or k==180 or k==199:
                          pygame.draw.rect(background,grey,(X,Y-10,4,45+Y/10))
                        if k==10 or k==30 or k==50 or k==70 or k==90 or k==110 or k==130 or k==150 or k==170 or k==190:
                          pygame.draw.rect(background,grey,(X,Y-15,4,45+Y/10))
                        if k<5:
                          pygame.draw.rect(background,cyan,(X,Y-10,4,45+Y/10))
                        X=X+4
                        Y=Y-(Y/25)
                        if Y<40:
                          Y=40
                    X = 0
                    Y = 300
                    krpm=rpmd/50
                    for k in range (1,krpm):
                          pygame.draw.rect(background,green,(X,Y-10,4,45+Y/10))
                          if k<5:
                              pygame.draw.rect(background,cyan,(X,Y-10,4,45+Y/10))
                          if k>(sl_max/50)-16:
                              pygame.draw.rect(background,yellow,(X,Y-10,4,45+Y/10))
                          if k>sl_max/50:
                              pygame.draw.rect(background,red,(X,Y-10,4,45+Y/10))
                          X=X+4
                          Y=Y-(Y/25)
                          if Y<40:
                              Y=40
                    if screen_init==0:
                        background.fill(black)
                        screen_init=1
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("0",2,white)
                        textpos.top = 350
                        textpos.left = 10
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("5",2,white)
                        textpos.top = 250
                        textpos.left = 50
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("10",2,white)
                        textpos.top = 180
                        textpos.left = 85
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("20",2,white)
                        textpos.top = 120
                        textpos.left = 150
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("30",2,white)
                        textpos.top = 85
                        textpos.left = 220
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("40",2,white)
                        textpos.top = 80
                        textpos.left = 300
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("50",2,white)
                        textpos.top = 80
                        textpos.left = 380
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("60",2,white)
                        textpos.top = 80
                        textpos.left = 460
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("70",2,white)
                        textpos.top = 80
                        textpos.left = 540
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("80",2,white)
                        textpos.top = 80
                        textpos.left = 620
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("90",2,white)
                        textpos.top = 80
                        textpos.left = 700
                        background.blit(text,textpos)
                        #Label
                        font = pygame.font.Font(None, 40)
                        text = font.render("X",2,white)
                        textpos.top = 80
                        textpos.left = 780
                        background.blit(text,textpos)
                        
                        #water_T label
                        font = pygame.font.Font(None, 50)
                        text = font.render("Water Temp" ,2,white)
                        textpos.top = 220
                        textpos.left = 200
                        background.blit(text,textpos)
                        #Gear label
                        font = pygame.font.Font(None, 30)
                        text = font.render("GEAR",2,white)
                        textpos.top = 10
                        textpos.left = 5
                        background.blit(text,textpos)
                        #Air temp label
                        font = pygame.font.Font(None, 50)
                        text = font.render("Lambda ",2,white)
                        textpos.top = 330
                        textpos.left = 500
                        background.blit(text,textpos)
                        #Batt Label
                        font = pygame.font.Font(None, 50)
                        text = font.render("Voltage",2,white)
                        textpos.top = 220
                        textpos.left = 500
                        background.blit(text,textpos)
                        #Boost Batt Log
                        font = pygame.font.Font(None, 50)
                        text = font.render("Boost",2,white)
                        textpos = text.get_rect()
                        textpos.top = 330
                        textpos.left = 200
                        background.blit(text,textpos)
                        
                    #RPM
                    pygame.draw.rect(background,black,(250,110,350,110))
                    font = pygame.font.Font(None, 120)
                    text = font.render(str(rpmd),2,white)
                    textpos.top = 110
                    textpos.left = 250
                    background.blit(text,textpos)

                    font = pygame.font.Font(None, 50)
                    text = font.render("Rpm ",2,white)
                    textpos.top = 180
                    textpos.left = 350
                    background.blit(text,textpos)
                    
                
                    #Speed
                    pygame.draw.rect(background,black,(550,110,250,110))
                    font = pygame.font.Font(None, 120)
                    if speedg>900:
                        speedg=888
                    text = font.render(str('%.0f' %speedg),2,white)
                    textpos.top = 110
                    textpos.left = 550
                    background.blit(text,textpos)
                    font = pygame.font.Font(None, 50)
                    text = font.render("kph",2,white)
                    textpos.top = 180
                    textpos.left = 600
                    background.blit(text,textpos)
                    pygame.draw.rect(background,white,(680,260,120,180))
                    pygame.draw.rect(background,black,(682,262,116,176))
                    font = pygame.font.Font(None, 40)
                    text = font.render("Power",2,white)
                    textpos.top = 270
                    textpos.left = 685
                    background.blit(text,textpos)
    
                    font = pygame.font.Font(None, 60)
                    text = font.render(str('%.0f' %power),2,cyan)
                    textpos.top = 350
                    textpos.left = 695
                    background.blit(text,textpos)
    
                    pygame.draw.rect(background,black,(20,440,760,40))                        
                    if rpmd>sl_max-200:
                        pygame.draw.rect(background,black,(20,440,760,40))
                        font = pygame.font.Font(None, 50)
                        text = font.render("SHIFT UP",2,red)
                        textpos.top = 440
                        textpos.left = 100
                        background.blit(text,textpos)
    
                    if rpmd>sl_max+500:
                        pygame.draw.rect(background,black,(20,440,760,40))
                        font = pygame.font.Font(None, 50)
                        text = font.render("SHIFT !! SHIFT !! SHIFT !!",2,red)
                        textpos.top = 440
                        textpos.left = 100
                        background.blit(text,textpos)
    
                    if volts<batt_lim:
                        pygame.draw.rect(background,yellow,(20,440,760,40))
                        font = pygame.font.Font(None, 50)
                        text = font.render("VOLTAGE TOO LOW",2,red)
                        textpos.top = 440
                        textpos.left = 100
                        background.blit(text,textpos)
                        
                    if afr>afr_lim:
                        pygame.draw.rect(background,yellow,(20,440,760,40))
                        font = pygame.font.Font(None, 50)
                        text = font.render("AFR TOO LEAN",2,red)
                        textpos.top = 440
                        textpos.left = 100
                        background.blit(text,textpos)
                        
                    if mapsensor>boost_lim:
                        pygame.draw.rect(background,yellow,(20,440,760,40))
                        font = pygame.font.Font(None, 50)
                        text = font.render("B00ST TOO HIGH",2,red)
                        textpos.top = 440
                        textpos.left = 100
                        background.blit(text,textpos)
                        
                    if an_mode>0:
                        if an_2<oiltemp_lim:
                            pygame.draw.rect(background,yellow,(20,440,760,40))
                            font = pygame.font.Font(None, 50)
                            text = font.render("FUEL PRESS TOO LOW",2,red)
                            textpos.top = 440
                            textpos.left = 100
                            background.blit(text,textpos)
                    if an_mode==0:
                        if an_2>oiltemp_lim:
                            pygame.draw.rect(background,yellow,(20,440,760,40))
                            font = pygame.font.Font(None, 50)
                            text = font.render("OIL TEMP TOO HIGH",2,red)
                            textpos.top = 440
                            textpos.left = 100
                            background.blit(text,textpos)
    
                    if w_temp>watertemp_lim:
                        pygame.draw.rect(background,yellow,(20,440,760,40))
                        font = pygame.font.Font(None, 50)
                        text = font.render("WATER TEMP TOO HIGH",2,red)
                        textpos.top = 440
                        textpos.left = 100
                        background.blit(text,textpos)
                    if an_mode==0:
                        if an_1<oilpress_lim:
                            pygame.draw.rect(background,yellow,(20,440,760,40))
                            font = pygame.font.Font(None, 50)
                            text = font.render("OIL PRESS TOO LOW",2,red)
                            textpos.top = 440
                            textpos.left = 100
                            background.blit(text,textpos)
    
                    #water_T/ Oil
                    if data_refresh==2 or  data_refresh==4 or data_refresh==6 or data_refresh==8 or data_refresh==10 :
                        pygame.draw.rect(background,(white),(200,260,150,70))
                        pygame.draw.rect(background,(20,20,20),(202,262,146,66))
                        font = pygame.font.Font(None, 80)
                        text = font.render(str('%.0f' %w_temp),2,yellow)
                        textpos.top = 260
                        textpos.left = 210
                        background.blit(text,textpos)
    
                        pygame.draw.rect(background,white,(500,260,150,70))
                        pygame.draw.rect(background,(20,20,20),(502,262,146,66))
                        font = pygame.font.Font(None, 80)
                        if volts>11.5:
                            text = font.render(str('%.1f' %volts),2,yellow)
                        if volts<11.6:
                            text = font.render(str('%.1f' %volts),2,red)
                        textpos.top = 260
                        textpos.left = 510
                        background.blit(text,textpos)
                        #Boost volts
                    if data_refresh==1 or  data_refresh==3 or data_refresh==5 or data_refresh==7 or data_refresh==9 :
                        pygame.draw.rect(background,white,(200,370,150,70))
                        pygame.draw.rect(background,(20,20,20),(202,372,146,66))
                        font = pygame.font.Font(None, 80)
                        text = font.render(str('%.2f' %mapsensor),2,green)
                        textpos = text.get_rect()
                        textpos.top = 370
                        textpos.left = 210
                        background.blit(text,textpos)
    
                        pygame.draw.rect(background,white,(500,370,150,70))
                        pygame.draw.rect(background,(20,20,20),(502,372,146,66))
                        font = pygame.font.Font(None, 80)
                        text = font.render(str('%.1f' %afr),2,green)
                        textpos = text.get_rect()
                        textpos.top = 370
                        textpos.left = 510
                        background.blit(text,textpos)
    
                        pygame.draw.rect(background,black,(10,35,50,60))
                        font = pygame.font.Font(None, 80)
                        text = font.render(str('%.0f' %gear),2,(200,200,10))
                        textpos.top = 35
                        textpos.left = 10
                        background.blit(text,textpos)
    
                    if data_refresh==1:
                        pygame.draw.rect(background,black,(400,0,400,25))
                        font = pygame.font.Font(None, 25)
                        text = font.render(str("Log: " + '%.1f' %data_rate)+ "Hz. GPS: " + str('%.1f' %gps_rate)+"Hz " + str(screen_view),2,white)
                        textpos.top = 5
                        textpos.left = 400
                        background.blit(text,textpos)
                        #Gear
                    screen.blit(background,(0,0))
                    pygame.display.flip()
                                                				   
#Scr    een 3		-----------------------------------------------------------------------------
                if screen_view == 3:    
                    print("screenview = " + str(screen_view))
                    background.fill(white)
                    #Rpm Gauge
                    rpm_ind = 0
                    rpm_pointer = (rpmd *(270.0/10000)) - 90
                    X1 = 200-(180 * math.cos(rpm_pointer*3.14/180))
                    Y1 = 200 - (180 * math.sin(rpm_pointer*3.14/180))
        
                    
                    pygame.draw.circle(background,purple,(200,200),202)		#outer black circle
                    pygame.draw.circle(background,grey,(200,200),198)            #outer black circle
                    if rpmd>(sl_max-200) or an_1<oilpress_lim or an_2>oiltemp_lim:
                        pygame.draw.circle(background,yellow,(200,200),178)     #inner white circle
                    else:
                        pygame.draw.circle(background,black,(200,200),178)      #inner white circle
                    pygame.draw.line(background,red,(200,200),(X1,Y1),12)      	#pointer
                    pygame.draw.circle(background,red,(200,200),25)            	#pointer circle
                    pygame.draw.circle(background,green,(200,200),7)               	#pointer circle centre
                    rpm_inds=50
                    for rpm_drw in range(1,100):
                        rpm_points = (rpm_inds *(270.0/10000)) - 90 + (270*sl_max/10000)
                        #rpm_points = (rpm_inds *(270.0/10000)) + 90
                        X2 = 200-(195 * math.cos(rpm_points*3.14/180))
                        Y2 = 200 - (195 * math.sin(rpm_points*3.14/180))
                        X3 = 200-(185 * math.cos(rpm_points*3.14/180))
                        Y3 = 200 - (185 * math.sin(rpm_points*3.14/180))
                        pygame.draw.line(background,(250,0,0),(X2,Y2),(X3,Y3),7)
                        rpm_inds = rpm_inds + 45
                    for rpm_draw in range(1,12):
                        rpm_point = (rpm_ind *(270.0/10000)) - 90
                        X2 = 200-(195 * math.cos(rpm_point*3.14/180))
                        Y2 = 200 - (195 * math.sin(rpm_point*3.14/180))
                        X3 = 200-(175 * math.cos(rpm_point*3.14/180))
                        Y3 = 200 - (175 * math.sin(rpm_point*3.14/180))
                        pygame.draw.line(background,cyan,(X2,Y2),(X3,Y3),6)
                        rpm_ind = rpm_ind + 1000
                        rpm_inds = 200
                    for rpm_drw in range(1,55):
                        rpm_points = (rpm_inds *(270.0/10000)) - 90
                        X2 = 200-(195 * math.cos(rpm_points*3.14/180))
                        Y2 = 200 - (195 * math.sin(rpm_points*3.14/180))
                        X3 = 200-(185 * math.cos(rpm_points*3.14/180))
                        Y3 = 200 - (185 * math.sin(rpm_points*3.14/180))
                        pygame.draw.line(background,cyan,(X2,Y2),(X3,Y3),6)
                        rpm_inds = rpm_inds + 200
        
                    #Temp Gauge
                    wt_ind = 0
                    wt_pointer = ((w_temp+10) *(270.0/110)) - 90
                    X1 = 500-(80 * math.cos(wt_pointer*3.14/180))
                    Y1 = 100 - (80 * math.sin(wt_pointer*3.14/180))
        
                    
                    pygame.draw.circle(background,purple,(500,100),99)        #outer black circle
                    pygame.draw.circle(background,grey,(500,100),97)          #inner white circle
                    if w_temp>watertemp_lim:
                        pygame.draw.circle(background,yellow,(500,100),85)#inner white circle
                    else:
                        pygame.draw.circle(background,black,(500,100),85) #inner white circle
                    pygame.draw.line(background,red,(498,100),(X1,Y1),4)      #pointer
                    pygame.draw.circle(background,red,(500,100),7)            #pointer circle
                    pygame.draw.circle(background,green,(500,100),3)          #pointer circle centre
                    wt_inds=1
                    for wt_drw in range(1,20):
                        wt_points = (wt_inds *(270.0/110)) - 90 + (270*(watertemp_lim+10)/110)
                        #wt_points = (wt_inds *(270.0/110)) + 170
                        X2 = 500-(95 * math.cos(wt_points*3.14/180))
                        Y2 = 100 - (95 * math.sin(wt_points*3.14/180))
                        X3 = 500-(85 * math.cos(wt_points*3.14/180))
                        Y3 = 100 - (85 * math.sin(wt_points*3.14/180))
                        pygame.draw.line(background,(250,0,0),(X2,Y2),(X3,Y3),6)
                        wt_inds = wt_inds + 1
                    for wt_draw in range(1,14):
                        wt_point = (wt_ind *(270.0/110)) - 90
                        X2 = 500-(95 * math.cos(wt_point*3.14/180))
                        Y2 = 100 - (95 * math.sin(wt_point*3.14/180))
                        X3 = 500-(75 * math.cos(wt_point*3.14/180))
                        Y3 = 100 - (75 * math.sin(wt_point*3.14/180))
                        pygame.draw.line(background,cyan,(X2,Y2),(X3,Y3),4)
                        wt_ind = wt_ind + 10
                        wt_inds = 5
                    for wt_drw in range(1,24):
                        wt_points = (wt_inds *(270.0/110)) - 90
                        X2 = 500-(95 * math.cos(wt_points*3.14/180))
                        Y2 = 100 - (95 * math.sin(wt_points*3.14/180))
                        X3 = 500-(85 * math.cos(wt_points*3.14/180))
                        Y3 = 100 - (85 * math.sin(wt_points*3.14/180))
                        pygame.draw.line(background,cyan,(X2,Y2),(X3,Y3),2)
                        wt_inds = wt_inds + 5
        
        
                    #Boost Gauge
                    bst_ind = 0
                    bst_pointer = ((mapsensor+1) *270.0/2.3) - 90
                    X1 = 700-(80 * math.cos(bst_pointer*3.14/180))
                    Y1 = 100 - (80 * math.sin(bst_pointer*3.14/180))
        
                    
                    pygame.draw.circle(background,purple,(700,100),99)        #outer black circle
                    pygame.draw.circle(background,grey,(700,100),97)          #inner white circle
                    if mapsensor>boost_lim:
                        pygame.draw.circle(background,yellow,(700,100),85)         #inner white circle
                    else:
                        pygame.draw.circle(background,black,(700,100),85)         #inner white circle
                    pygame.draw.line(background,red,(698,100),(X1,Y1),4)      #pointer
                    pygame.draw.circle(background,red,(700,100),7)            #pointer circle
                    pygame.draw.circle(background,green,(700,100),3)          #pointer circle centre
                    bst_inds=1
                    for bst_drw in range(1,20):
                        bst_points = (bst_inds *(270.0/110)) - 90 + (270*(boost_lim+1)/2.25)
                        #bst_points = (bst_inds *(270.0/110)) + 170
                        X2 = 700-(95 * math.cos(bst_points*3.14/180))
                        Y2 = 100 - (95 * math.sin(bst_points*3.14/180))
                        X3 = 700-(85 * math.cos(bst_points*3.14/180))
                        Y3 = 100 - (85 * math.sin(bst_points*3.14/180))
                        pygame.draw.line(background,(250,0,0),(X2,Y2),(X3,Y3),6)
                        bst_inds = bst_inds + 1
                    for bst_draw in range(1,14):
                        bst_point = (bst_ind *(270.0/110)) - 90
                        X2 = 700-(95 * math.cos(bst_point*3.14/180))
                        Y2 = 100 - (95 * math.sin(bst_point*3.14/180))
                        X3 = 700-(75 * math.cos(bst_point*3.14/180))
                        Y3 = 100 - (75 * math.sin(bst_point*3.14/180))
                        pygame.draw.line(background,cyan,(X2,Y2),(X3,Y3),4)
                        bst_ind = bst_ind + 10
                        bst_inds = 5
                    for bst_drw in range(1,24):
                        bst_points = (bst_inds *(270.0/110)) - 90
                        X2 = 700-(95 * math.cos(bst_points*3.14/180))
                        Y2 = 100 - (95 * math.sin(bst_points*3.14/180))
                        X3 = 700-(85 * math.cos(bst_points*3.14/180))
                        Y3 = 100 - (85 * math.sin(bst_points*3.14/180))
                        pygame.draw.line(background,cyan,(X2,Y2),(X3,Y3),2)
                        wt_inds = wt_inds + 5
        
        
                    font = pygame.font.Font(None, 60)
                    text = font.render("RPM",2,(150,150,150))
                    textpos.top = 120
                    textpos.left = 150
                    background.blit(text,textpos)
                    screen.blit(background,(0,0))
                    font = pygame.font.Font(None, 30)
                    text = font.render("H2O",2,(150,150,150))
                    textpos.top = 60
                    textpos.left = 480
                    background.blit(text,textpos)
                    screen.blit(background,(0,0))
                    font = pygame.font.Font(None, 30)
                    text = font.render("kPa",2,(150,150,150))
                    textpos.top = 60
                    textpos.left = 680
                    background.blit(text,textpos)
                    screen.blit(background,(0,0))
        
                    #Gauge Markers
                    font = pygame.font.Font(None, 50)
                    text = font.render("0",2,(150,150,150))
                    textpos.top = 340
                    textpos.left = 190
                    background.blit(text,textpos)
                    text = font.render("1",2,(150,150,150))
                    textpos.top = 325
                    textpos.left = 120
                    background.blit(text,textpos)
                    text = font.render("2",2,(150,150,150))
                    textpos.top = 280
                    textpos.left = 60
                    background.blit(text,textpos)
                    text = font.render("3",2,(150,150,150))
                    textpos.top = 210
                    textpos.left = 30
                    background.blit(text,textpos)
                    text = font.render("4",2,(150,150,150))
                    textpos.top = 135
                    textpos.left = 35
                    background.blit(text,textpos)
                    text = font.render("5",2,(150,150,150))
                    textpos.top = 70
                    textpos.left = 75
                    background.blit(text,textpos)
                    text = font.render("6",2,(150,150,150))
                    textpos.top = 30
                    textpos.left = 140
                    background.blit(text,textpos)
                    text = font.render("7",2,(150,150,150))
                    textpos.top = 25
                    textpos.left = 220
                    background.blit(text,textpos)
                    text = font.render("8",2,(150,150,150))
                    textpos.top = 50
                    textpos.left = 285
                    background.blit(text,textpos)
                    text = font.render("9",2,(150,150,150))
                    textpos.top = 105
                    textpos.left = 335
                    background.blit(text,textpos)
                    text = font.render("10",2,(150,150,150))
                    textpos.top = 180
                    textpos.left = 335
                    background.blit(text,textpos)
        
                    
                    #Temp Gauge Markers
                    font = pygame.font.Font(None, 20)
                    text = font.render("-10",2,(150,150,150))
                    textpos.top = 160
                    textpos.left = 490
                    background.blit(text,textpos)
                    text = font.render("0",2,(150,150,150))
                    textpos.top = 155
                    textpos.left = 470
                    background.blit(text,textpos)
                    text = font.render("10",2,(150,150,150))
                    textpos.top = 142
                    textpos.left = 445
                    background.blit(text,textpos)
                    text = font.render("20",2,(150,150,150))
                    textpos.top = 113
                    textpos.left = 430
                    background.blit(text,textpos)
                    text = font.render("30",2,(150,150,150))
                    textpos.top = 82
                    textpos.left = 428
                    background.blit(text,textpos)
                    text = font.render("40",2,(150,150,150))
                    textpos.top = 57
                    textpos.left = 437
                    background.blit(text,textpos)
                    text = font.render("50",2,(150,150,150))
                    textpos.top = 35
                    textpos.left = 455
                    background.blit(text,textpos)
                    text = font.render("60",2,(150,150,150))
                    textpos.top = 25
                    textpos.left = 485
                    background.blit(text,textpos)
                    text = font.render("70",2,(150,150,150))
                    textpos.top = 28
                    textpos.left = 515
                    background.blit(text,textpos)
                    text = font.render("80",2,(150,150,150))
                    textpos.top = 42
                    textpos.left = 540
                    background.blit(text,textpos)
                    text = font.render("90",2,(150,150,150))
                    textpos.top = 64
                    textpos.left = 552
                    background.blit(text,textpos)
                    text = font.render("100",2,(150,150,150))
                    textpos.top = 93
                    textpos.left = 550
                    background.blit(text,textpos)
                    background.blit(text,textpos)
                    text = font.render("110",2,(150,150,150))
                    textpos.top = 122
                    textpos.left = 545
                    background.blit(text,textpos)
        
        
                    #Boost Gauge Markers
                    font = pygame.font.Font(None, 20)
                    text = font.render("-1.0",2,(150,150,150))
                    textpos.top = 160
                    textpos.left = 690
                    background.blit(text,textpos)
                    text = font.render("-0.8",2,(150,150,150))
                    textpos.top = 155
                    textpos.left = 670
                    background.blit(text,textpos)
                    text = font.render("-0.6",2,(150,150,150))
                    textpos.top = 142
                    textpos.left = 645
                    background.blit(text,textpos)
                    text = font.render("-0.4",2,(150,150,150))
                    textpos.top = 113
                    textpos.left = 630
                    background.blit(text,textpos)
                    text = font.render("-0.2",2,(150,150,150))
                    textpos.top = 82
                    textpos.left = 628
                    background.blit(text,textpos)
                    text = font.render("0",2,(150,150,150))
                    textpos.top = 57
                    textpos.left = 637
                    background.blit(text,textpos)
                    text = font.render("0.2",2,(150,150,150))
                    textpos.top = 35
                    textpos.left = 655
                    background.blit(text,textpos)
                    text = font.render("0.4",2,(150,150,150))
                    textpos.top = 25
                    textpos.left = 685
                    background.blit(text,textpos)
                    text = font.render("0.6",2,(150,150,150))
                    textpos.top = 28
                    textpos.left = 715
                    background.blit(text,textpos)
                    text = font.render("0.8",2,(150,150,150))
                    textpos.top = 42
                    textpos.left = 740
                    background.blit(text,textpos)
                    text = font.render("1.0",2,(150,150,150))
                    textpos.top = 64
                    textpos.left = 752
                    background.blit(text,textpos)
                    text = font.render("1.25",2,(150,150,150))
                    textpos.top = 93
                    textpos.left = 750
                    background.blit(text,textpos)
                    background.blit(text,textpos)
                    text = font.render("1.5",2,(150,150,150))
                    textpos.top = 122
                    textpos.left = 745
                    background.blit(text,textpos)
                    
                    #RPM
                    font = pygame.font.Font(None, 60)
                    text = font.render(str(rpmd),2,white)
                    textpos.top = 280
                    textpos.left = 220
                    background.blit(text,textpos)
                    
                    font = pygame.font.Font(None, 40)
                    text = font.render("Gear" ,2,black)
                    textpos.top = 220
                    textpos.left = 650
                    background.blit(text,textpos)
                    font = pygame.font.Font(None, 80)
                    text = font.render(str('%.0f' %gear),2,blue)
                    textpos.top = 260
                    textpos.left = 670
                    background.blit(text,textpos)
        
                    font = pygame.font.Font(None, 60)
                    text = font.render("SPEED" ,2,black)
                    textpos.top = 350
                    textpos.left = 620
                    background.blit(text,textpos)
                    font = pygame.font.Font(None, 80)
                    text = font.render(str('%.0f' %speedg),2,blue)
                    #text = font.render(speed,2,blue)
                    textpos.top = 405
                    textpos.left = 630
                    background.blit(text,textpos)
        
                    #water_T label
                    font = pygame.font.Font(None, 30)
                    text = font.render("TPS:" ,2,black)
                    textpos.top = 215
                    textpos.left = 430
                    background.blit(text,textpos)
                    text = font.render(str('%.1f' %tps),2,blue)
                    textpos.top = 215
                    textpos.left = 530
                    background.blit(text,textpos)
                    #Boost label
                    text = font.render("BOOST:",2,black)
                    textpos.top = 245
                    textpos.left = 430
                    background.blit(text,textpos)
                    text = font.render(str('%.1f' %mapsensor),2,blue)
                    textpos.top = 245
                    textpos.left = 530
                    background.blit(text,textpos)
                    #Oil Pressure
                    if an_mode==0 or an_mode==3:
                        text = font.render("OIL P:" ,2,black)
                    if an_mode==1:
                        text = font.render("EGT 1:" ,2,black)
                    if an_mode==2:
                        text = font.render("DBW 1:" ,2,black)
                    if ecu_sel==2:
                        text = font.render("POT 1",2,black)
                    if ecu_sel==3:
                        text = font.render("Fuel T",2,black)
                    textpos.top = 275
                    textpos.left = 430
                    background.blit(text,textpos)
                    text = font.render(str('%.1f' %an_1),2,blue)
                    textpos.top = 275
                    textpos.left = 530
                    background.blit(text,textpos)
                    #Oil Temp label
                    if an_mode==0:
                        text = font.render("OIL T:" ,2,black)
                    if an_mode==1:
                        text = font.render("EGT 2:" ,2,black)
                    if an_mode==2:
                        text = font.render("DBW 2:" ,2,black)
                    if an_mode==3:
                        text = font.render("Fuel P:" ,2,black)
                    if ecu_sel==2:
                        text = font.render("POT A",2,black)
                    if ecu_sel==3:
                        text = font.render("Ign A",2,black)
                    textpos.top = 305
                    textpos.left = 430
                    background.blit(text,textpos)
                    text = font.render(str('%.1f' %an_2),2,blue)
                    textpos.top = 305
                    textpos.left = 530
                    background.blit(text,textpos)
                    #Volts label
                    text = font.render("VOLTS:" ,2,black)
                    textpos.top = 335
                    textpos.left = 430
                    background.blit(text,textpos)
                    text = font.render(str('%.1f' %volts),2,blue)
                    textpos.top = 335
                    textpos.left = 530
                    background.blit(text,textpos)
                    #AFR label
                    text = font.render("AFR:",2,black)
                    textpos.top = 365
                    textpos.left = 430
                    background.blit(text,textpos)
                    text = font.render(str('%.1f' %afr),2,blue)
                    textpos.top = 365
                    textpos.left = 530
                    background.blit(text,textpos)
                    
                        # Read channel 0 in single-ended mode using the settings above 
                    if adc_sel==1:
                        font = pygame.font.Font(None, 20)
                        text = font.render("ADC WT:",2,black)
                        textpos.top = 400
                        textpos.left = 430
                        background.blit(text,textpos)
                        text = font.render(str('%.1f' %wt_temp),2,blue)
                        textpos.top = 400
                        textpos.left = 530
                        background.blit(text,textpos)
                            
                        text = font.render("ADC Oil T:",2,black)
                        textpos.top = 420
                        textpos.left = 430
                        background.blit(text,textpos)
                        text = font.render(str('%.1f' %oil_temp),2,blue)
                        textpos.top = 420
                        textpos.left = 530
                        background.blit(text,textpos)
                            
                        text = font.render("ADC Oil P:",2,black)
                        textpos.top = 440
                        textpos.left = 430
                        background.blit(text,textpos)
                        text = font.render(str('%.1f' %oil_press),2,blue)
                        textpos.top = 440
                        textpos.left = 530
                        background.blit(text,textpos)
                            
                        text = font.render("ADC Fuel P:",2,black)
                        textpos.top = 460
                        textpos.left = 430
                        background.blit(text,textpos)
                        text = font.render(str('%.1f' %fuel_press),2,blue)
                        textpos.top = 460
                        textpos.left = 530
                        background.blit(text,textpos)
        
                    #Screen
                    font = pygame.font.Font(None, 30)
                    text = font.render("Screen " + str(screen_view),2,green)
                    textpos.top = 10
                    textpos.left = 5
                    background.blit(text,textpos)
                   
                    #pygame.draw.rect(background,black,(200,0,440,20))
                    font = pygame.font.Font(None, 30)
                    text = font.render(str('%.1f' %data_rate)+ " Hz",2,black)
                    textpos.top = 450
                    textpos.left = 20
                    background.blit(text,textpos)
        
                    font = pygame.font.Font(None, 40)
                    text = font.render(track_name,1,red)
                    textpos.top = 410
                    textpos.left = 5
                    background.blit(text,textpos)
        
                    screen.blit(background,(0,0))
                    pygame.display.flip()
        
#Scr    een 4------------------------------------------------------------------------------------------
                if screen_view == 4:    
                    print("screenview = " + str(screen_view))
                    #RPM
                    pygame.draw.rect(background,black,(5,5,250,470))
                    pygame.draw.rect(background,white,(10,10,240,460))
                    #background.fill((250,250,250))
                    #Label
                    font = pygame.font.Font(None, 50)
                    text = font.render("Rpm: " + str(rpmd),2,black)
                    textpos.top = 20
                    textpos.left = 20
                    background.blit(text,textpos)
                    font = pygame.font.Font(None, 40)
                    text = font.render("Temp: " + str('%.0f' %w_temp),2,black)
                    textpos.top = 60
                    textpos.left = 20
                    background.blit(text,textpos)
                    font = pygame.font.Font(None, 40)
                    text = font.render("Oil P: " + str('%.1f' %an_1),2,black)
                    textpos.top = 100
                    textpos.left = 20
                    background.blit(text,textpos)
                                    
                    #Lap1 label
                    font = pygame.font.Font(None, 40)
                    text = font.render("Gps: " + ('%.0f' %speedg) + " Kph",1,black)
                    textpos.top = 140
                    textpos.left = 20
                    background.blit(text,textpos)
                    
                    #Lap2 label
                    font = pygame.font.Font(None, 30)
                    text = font.render("Vector:  " + vector +" deg",1,black)
                    textpos.top = 180
                    textpos.left = 20
                    background.blit(text,textpos)
                    
                    #Lap3 label
                    font = pygame.font.Font(None, 30)
                    text = font.render("Latt:  " + lattitude +" deg",1,black)
                    textpos.top = 210
                    textpos.left = 20
                    background.blit(text,textpos)
                    
                    #Lap4 label
                    font = pygame.font.Font(None, 30)
                    text = font.render("Long:  " + longitude + " deg",1,black)
                    textpos.top = 240
                    textpos.left = 20
                    background.blit(text,textpos)
                    
                    #Lap5 label
                    font = pygame.font.Font(None, 30)
                    text = font.render("Time:  " + timegps,1,black)
                    textpos.top = 270
                    textpos.left = 20
                    background.blit(text,textpos)
                    
                    #Lap5 label
                    font = pygame.font.Font(None, 30)
                    text = font.render("Date:  " + dategps,1,black)
                    textpos.top = 300
                    textpos.left = 20
                    background.blit(text,textpos)
                    Xlat=int((x_lat-latcen)*27500)
                    Ylong=int((y_long-longcen)*24000)
                    pygame.draw.circle(background,(255,0,255),(Xlat+250,Ylong),2)
                    pygame.draw.line(background,(0,0,0),(X+250,Y),(Xlat+250,Ylong),2)
                    X = Xlat
                    Y = Ylong
        
                    font = pygame.font.Font(None, 30)
                    text = font.render(str(Xlat) + " : " + str(Ylong),1,black)
                    textpos.top = 330
                    textpos.left = 20
                    background.blit(text,textpos)
        
                    font = pygame.font.Font(None, 30)
                    text = font.render("Lap Trig: " + str(laptrig),1,black)
                    textpos.top = 360
                    textpos.left = 20
                    background.blit(text,textpos)
        
                    font = pygame.font.Font(None, 30)
                    text = font.render("S1 Trig: " + str(s1_trig) + " - " +  str('%.3f' %s1_time),1,black)
                    textpos.top = 385
                    textpos.left = 20
                    background.blit(text,textpos)
        
                    font = pygame.font.Font(None, 30)
                    text = font.render("S2 Trig: " + str(s2_trig)  +  " - " +  str('%.3f' %s2_time),1,black)
                    textpos.top = 410
                    textpos.left = 20
                    background.blit(text,textpos)
        
        
                    font = pygame.font.Font(None, 40)
                    text = font.render(track_name,1,(210,10,10))
                    textpos.top = 430
                    textpos.left = 270
                    background.blit(text,textpos)
                                    
                    font = pygame.font.Font(None, 40)
                    text = font.render("Lap " +str(laps_done) + ":  "+ str('%.3f' %laptime)+ "s",1,black)
                    textpos.top = 440
                    textpos.left = 20
                    background.blit(text,textpos)
                    
        
                    font = pygame.font.Font(None, 30)
                    text = font.render("Screen " + str(screen_view),2,( 0,0,0))
                    textpos.top = 30
                    textpos.left = 700
                    background.blit(text,textpos)
                    
        
                    screen.blit(background,(0,0))
                    pygame.display.flip()
                
#Scr    een 15		-----------------------------------------------------------------------------
                if screen_view == 15:    
                    print("screenview = " + str(screen_view))
                    background.fill(silver)
                    font = pygame.font.Font(None, 50)
                    text = font.render(" ECU ID: " + cpuserial,2,black)
                    textpos.top = 50
                    textpos.left = 100
                    background.blit(text,textpos)
                    font = pygame.font.Font(None, 50)
                    text = font.render(" USD ID: " + sernum,2,black)
                    textpos.top = 150
                    textpos.left = 100
                    background.blit(text,textpos)
                    screen.blit(background,(0,0))
                    pygame.display.flip()
        
#Scr    een 5 LEXUS		-----------------------------------------------------------------------------
        
                if screen_view == 5:    
                    print("screenview = " + str(screen_view))
                    background.fill(white)
                    #Rpm Gauge
                    rpm_ind = 0
                    rpm_pointer = (rpmd *(270.0/10000)) - 90
                    X1 = 400-(180 * math.cos(rpm_pointer*3.14/180))
                    Y1 = 220 - (180 * math.sin(rpm_pointer*3.14/180))
        
                    
                    pygame.draw.circle(background,black,(400,220),210)             #outer black circle
                    pygame.draw.circle(background,silver,(400,220),208)             #outer black circle
                    pygame.draw.circle(background,black,(400,220),198)          #outer black circle
                    pygame.draw.circle(background,blue,(400,220),178)             #inner white circle
                    pygame.draw.line(background,red,(400,220),(X1,Y1),12)      #pointer
                    pygame.draw.circle(background,red,(400,220),25)            #pointer circle
                    pygame.draw.circle(background,black,(400,220),7)               #pointer circle centre
                    rpm_inds=50
                    for rpm_drw in range(1,100):
                        rpm_points = (rpm_inds *(270.0/10000)) + 90
                        X2 = 400-(195 * math.cos(rpm_points*3.14/180))
                        Y2 = 220 - (195 * math.sin(rpm_points*3.14/180))
                        X3 = 400-(185 * math.cos(rpm_points*3.14/180))
                        Y3 = 220 - (185 * math.sin(rpm_points*3.14/180))
                        pygame.draw.line(background,red,(X2,Y2),(X3,Y3),7)
                        rpm_inds = rpm_inds + 45
                    for rpm_draw in range(1,12):
                        rpm_point = (rpm_ind *(270.0/10000)) - 90
                        X2 = 400-(195 * math.cos(rpm_point*3.14/180))
                        Y2 = 220 - (195 * math.sin(rpm_point*3.14/180))
                        X3 = 400-(175 * math.cos(rpm_point*3.14/180))
                        Y3 = 220 - (175 * math.sin(rpm_point*3.14/180))
                        pygame.draw.line(background,blue,(X2,Y2),(X3,Y3),6)
                        rpm_ind = rpm_ind + 1000
                        rpm_inds = 200
                    for rpm_drw in range(1,55):
                        rpm_points = (rpm_inds *(270.0/10000)) - 90
                        X2 = 400-(195 * math.cos(rpm_points*3.14/180))
                        Y2 = 220 - (195 * math.sin(rpm_points*3.14/180))
                        X3 = 400-(185 * math.cos(rpm_points*3.14/180))
                        Y3 = 220 - (185 * math.sin(rpm_points*3.14/180))
                        pygame.draw.line(background,blue,(X2,Y2),(X3,Y3),6)
                        rpm_inds = rpm_inds + 200
        
                    #Gauge Markers
                    font = pygame.font.Font(None, 50)
                    text = font.render("0",2,(150,150,150))
                    textpos.top = 360
                    textpos.left = 390
                    background.blit(text,textpos)
                    text = font.render("1",2,(150,150,150))
                    textpos.top = 345
                    textpos.left = 320
                    background.blit(text,textpos)
                    text = font.render("2",2,(150,150,150))
                    textpos.top = 300
                    textpos.left = 260
                    background.blit(text,textpos)
                    text = font.render("3",2,(150,150,150))
                    textpos.top = 230
                    textpos.left = 230
                    background.blit(text,textpos)
                    text = font.render("4",2,(150,150,150))
                    textpos.top = 155
                    textpos.left = 235
                    background.blit(text,textpos)
                    text = font.render("5",2,(150,150,150))
                    textpos.top = 90
                    textpos.left = 275
                    background.blit(text,textpos)
                    text = font.render("6",2,(150,150,150))
                    textpos.top = 50
                    textpos.left = 340
                    background.blit(text,textpos)
                    text = font.render("7",2,(150,150,150))
                    textpos.top = 45
                    textpos.left = 420
                    background.blit(text,textpos)
                    text = font.render("8",2,(150,150,150))
                    textpos.top = 70
                    textpos.left = 485
                    background.blit(text,textpos)
                    text = font.render("9",2,(150,150,150))
                    textpos.top = 125
                    textpos.left = 535
                    background.blit(text,textpos)
                    text = font.render("10",2,(150,150,150))
                    textpos.top = 200
                    textpos.left = 535
                    background.blit(text,textpos)
        
                    
                    #RPM
                    font = pygame.font.Font(None, 80)
                    text = font.render(str(rpmd),2,white)
                    textpos.top = 290
                    textpos.left = 400
                    background.blit(text,textpos)
                    
                    font = pygame.font.SysFont("freemono", 120, bold = 1)
                    text = font.render(str('%.0f' %gear),2,red)
                    textpos.top = 160
                    textpos.left = 460
                    background.blit(text,textpos)
        
                    font = pygame.font.SysFont("freemono", 30, bold = 1)
                    #font = pygame.font.Font(None, 40)
        
                    #Water Temp
                    text = font.render("Water Temp" ,2,black)
                    textpos.top = 10
                    textpos.left = 20
                    background.blit(text,textpos)
        
                    #Oil Pressure
                    if an_mode==0 or an_mode==3:
                        text = font.render("Oil Press" ,2,black)
                    if an_mode==1:
                        text = font.render("EGT 1" ,2,black)
                    if an_mode==2:
                        text = font.render("DBW 1" ,2,black)
                    if ecu_sel==2:
                        text = font.render("POT 1",2,black)
                    textpos.top = 110
                    textpos.left = 20
                    background.blit(text,textpos)
        
                    #Oil Temp label
                    text = font.render("ECU Temp" ,2,black)
                    textpos.top = 210
                    textpos.left = 20
                    background.blit(text,textpos)
        
                    #Volts label
                    text = font.render("Voltage" ,2,black)
                    textpos.top = 310
                    textpos.left = 20
                    background.blit(text,textpos)
        
                    #Speed
                    text = font.render("Speed" ,2,black)
                    textpos.top = 10
                    textpos.left = 620
                    background.blit(text,textpos)
        
                    #Throttle
                    text = font.render("Throttle" ,2,black)
                    textpos.top = 110
                    textpos.left = 620
                    background.blit(text,textpos)
        
                    #Boost label
                    text = font.render("Boost",2,black)
                    textpos.top = 210
                    textpos.left = 620
                    background.blit(text,textpos)
        
                    #Lambda
                    text = font.render("Lambda",2,black)
                    textpos.top = 310
                    textpos.left = 620
                    background.blit(text,textpos)
        
                    #font = pygame.font.SysFont("freemono", 45, bold = 1)
                    font = pygame.font.Font(None, 60)
                    #Speed
                    if 0==gpslock:
                        text = font.render(str('%.0f' %speed_l),2,blue)
                    if 1==gpslock:
                        text = font.render(str('%.0f' %speedg),2,blue)
                        #text = font.render(speed,2,blue)
                    textpos.top = 50
                    textpos.left = 640
                    background.blit(text,textpos)
        
                    #TPS
                    text = font.render(str('%.0f' %tps),2,blue)
                    textpos.top = 150
                    textpos.left = 640
                    background.blit(text,textpos)
        
                    #Boost label
                    text = font.render(str('%.2f' %mapsensor),2,blue)
                    textpos.top = 250
                    textpos.left = 640
                    background.blit(text,textpos)
                    #Water Temp
                    text = font.render(str('%.1f' %w_temp),2,blue)
                    textpos.top = 50
                    textpos.left = 40
                    background.blit(text,textpos)
                    #Oil Pressure
                    text = font.render(str('%.1f' %an_1),2,blue)
                    textpos.top = 150
                    textpos.left = 40
                    background.blit(text,textpos)
                    #Oil Temp label
                    text = font.render(str('%.0f' %an_2),2,blue)
                    textpos.top = 250
                    textpos.left = 40
                    background.blit(text,textpos)
                    #Volts label
                    text = font.render(str('%.1f' %(volts*1.2)),2,blue)
                    textpos.top = 350
                    textpos.left = 40
                    background.blit(text,textpos)
                    #AFR label
                    text = font.render(str('%.1f' %afr),2,blue)
                    textpos.top = 350
                    textpos.left = 640
                    background.blit(text,textpos)
                    
                    #pygame.draw.rect(background,black,(200,0,440,20))
                    font = pygame.font.Font(None, 30)
                    text = font.render(str('%.1f' %data_rate)+ " Hz "  + str(screen_view),2,black)
                    textpos.top = 450
                    textpos.left = 20
                    background.blit(text,textpos)
        
                    font = pygame.font.Font(None, 30)
                    text = font.render(track_name,1,black)
                    textpos.top = 430
                    textpos.left = 20
                    background.blit(text,textpos)
        
                    screen.blit(background,(0,0))
                    pygame.display.flip()
        
        
#Scr    een 7		-----------------------------------------------------------------------------
        
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
                        
                        screen.blit(background,(0,0))
                        pygame.display.flip()
                #if x_lat+0.04<lap_lat or x_lat-0.04>lap_lat or y_long+0.04<lap_long or y_long-0.04>lap_long:
                #	track_sel=50
                #	print ("Searching for track"
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
                            	print ("Invalid track data"
                            	track_sel=track_sel+1
                            	track_name="Error Data"
        
        except Exception as e: print(e)
		#print ("fault error"

    except Exception as e: 
        print(e)
        print("Serial data corrupt")
        ArduinoSerial.flush()
        ArduinoSerial.close()
        try:
           ArduinoSerial = serial.Serial('/dev/ttyACM0',115200, timeout = 0.012) #timeout for response on readline()
        except:
           ArduinoSerial = serial.Serial('/dev/ttyUSB0',115200, timeout = 0.012) #timeout for response on readline()
        
        print("ECU Ready")
        connected = True
        time.sleep(2)
		
    