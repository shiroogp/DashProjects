#Rpi Boosted Dash

import serial
import io
import os
import pygame, sys
from pygame.locals import *
import pygame, sys, math, array
from pygame.locals import *
from math import *
import time
from time import strftime
import datetime
from time import strftime
import datetime
# import RPi.GPIO as GPIO

import time, signal, sys 
import socket
screen_init=0
en_buttons=1
demomode=0
ratio=105
#Enter code here else bootup on screen 9 only
dashnumber="00001"
sernum="000000000f8b6eb0"
dispv=1
spits=0
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
rpml=1
rpmh=1
displ=1
alarm_led=0
data_refresh=1
gps_refresh=1
ecu_alarm=0
data_rate=1
gps_rate=0
get_index=1
log_count=1
cyl=4
m=84
o=36
d=chr(36)
rpmh=2
rpmfp=0
rpmd=3000
rpmdisplay=3000
fuel_M = 2
fuel_T = 7.5
fuel_A = .6
ign_A = 12
ecu_id = 1
w_temp= 84
a_temp = 60
tps = 75
tpsmsb=0
mapmsb=3
an_1msb=0
an_1=0
an_2 = 90
afr=13.4
mapsensor=2.5
volts=13.8
dtset=0
log_gps = 1
speed_l=250
speed1 = 0
speed2 = 0
speed3 = 0
speed4 = 0
speed5 = 0
speed = str(0)
vector = "0.0"
vector1 ="0"
vector2 ="0"
vector3 ="0"
vector4 ="."
vector5 ="0"
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
dategps ="010115"
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
gear=1
#Default Zwartkops
x_lat=25.809317
y_long=28.112109
latcen=x_lat-0.01
longcen=y_long-0.01
lap_lat=25.809317
lap_long=28.112109
s1_lat=25.808270
s1_long=28.109386
s2_lat=25.811848
s2_long=28.111715
s1latcen=s1_lat-0.01
s1longcen=s1_long-0.01
s2latcen=s2_lat-0.01
s2longcen=s2_long-0.01
X=10
Y=20
gpslock = 0
start_log_en=0
log_en=0
log_size=0
rpmlow_count = 0
rpmhigh_count=0
log_man=0
lastsec=strftime("%S",time.localtime())
lastmin=strftime("%M",time.localtime())
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
s1_time=0
s2_time=0
laptrig=0
s1_trig=0
s2_trig=0
laps_done=0
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
lap_reset=1
start_time = 0
laptime = 0
start_time = time.time()
data_time = time.time()
kw_time = time.time()
gps_time = time.time()
disp_now=1
screen_view = 0
load_site = 1
rpm_site = 1
all_ranges = 33
ranges = "1"
map_site = 12
load_site = 12
afr_lim=13
batt_lim=11.5
boost_lim=1
oiltemp_lim=145
oilpress_lim=2
fuelpress_lim=2
watertemp_lim=90
sl_max=6800
sl_step=100
k_temp=1
ka_temp=1
k_an1=1
k_an2=1
chipswop=300
map_kpa=2
lap_dia=5
lat_acc=0
long_acc=0
an_mode=0   #0=oil press+temp 1=egt1+egt2 2=dbw1+dbw2
ign_trig=40
adxl_sel=0
adc_sel=0
gps_sel=1
ecu_alarm=0
ecu_sel=0
dirx=1
diry=1
Xlat=525
Ylong=240
blink=0
log_on=0
log_time=1
besttime=300
bestlap=1
xlattest = 0
an_log20=1
track_sel = 0
track_no = 0
track_name="My Track"
sector1_name="Sector 1"
sector2_name="Sector 2"
data_ave=0
uparrow=1
downarrow=1
leftarrow=1
rightarrow=1
kw_cal=1000
rpmkw2=500
rpmkw1=400
chipswop=300



pygame.init()
screen = pygame.display.set_mode((800,480))
pygame.display.set_caption('PowerMods ECU Display')
pygame.font.init()
pygame.display.update()
pygame.mouse.set_visible(False)
serlog_val=0
        
background = pygame.Surface(screen.get_size())
background = background.convert()
background.fill((0,0,0))


pygame.font.init()
pygame.display.update()
pygame.mouse.set_visible(False)

font = pygame.font.SysFont("freemono", 40, bold = 1)
text = font.render("PowerMods Dash ECU",1,(250,0,0))
textpos = text.get_rect()
textpos.centerx = background.get_rect().centerx
background.blit(text,textpos)
screen.blit(background,(0,0))
pygame.display.flip()
load=1


# allips = []
# f = open("broadcastips.txt", "r")
# for x in f:
#     print(x)
#     allips.append(x)  
	
# basicips = []
# f = open("basicbroadcastips.txt", "r")
# for x in f:
#     print(x)
#     basicips.append(x)  





UDP_IP = "localhost"
#UDP_IP = "192.168.1.123"
#UDP_IP = "255.255.255.255"
UDP_PORT = 45454
MESSAGE = "Hello, World!"

print ("UDP target IP:", UDP_IP)
print ("UDP target port:", UDP_PORT)
intspeed = 1
intrpm = 100
boost = 0.1


sock = socket.socket(socket.AF_INET, # Internet
            socket.SOCK_DGRAM) # UDP
sock.setsockopt(socket.SOL_SOCKET, socket.SO_BROADCAST,1)
sock.bind(('', UDP_PORT))

# connected = False
# while (connected == False):
#    try:
#       ArduinoSerial = serial.Serial('/dev/ttyACM0',115200, timeout = 0.012) #timeout for response on readline()
#       print("ECU Ready")
#       connected = True
#       time.sleep(3)
#    except:
#       try:
#          ArduinoSerial = serial.Serial('/dev/ttyUSB0',115200, timeout = 0.012) #timeout for response on readline()
#          print("ECU Ready")
#          connected = True
#          time.sleep(3)
#       except:
#          print("ECU ttyUSB Not Ready")
#       print("ECU ttyACM Not Ready")
#       time.sleep(2)

# time.sleep(2) #allow time for serial port to open
var = "A"
# get input from user
print ("Sending Command:  ", var )

# print the input for confirmation
count = 1
while True:
#send to Arduino
 #read echo back from arduino to verify receipt of message
   #print ("Writing to Serial:", var )
   # ArduinoSerial.write(var.encode())
   # data = ArduinoSerial.read() #the last bit gets rid of the new-line char
   # lineout = ""
   # bytecount = 0
   # while data:
   #    bytecount += 1
   #    try:
   #       #print("Decoded message: " + data.decode())
   #       lineout +=   str(ord(data.decode())) + " "
   #       #print(data.decode())
   #    except:
   #       #print (data + " - " + str(ord(data)))
   #       lineout +=   str(ord(data)) + " "
   
   #    data = ArduinoSerial.read()
   # try:   
   #    #print (lineout + " - " + str(bytecount))
   #    vars = lineout.split()
   #    #print ("syncLossCounter" + " - " + vars[3])
   #    #print ("map" + " - " + vars[4])
   #    #print ("iatRaw" + " - " + vars[6])
   #    #print ("coolantRaw" + " - " + vars[7])
   #    #print ("batteryVoltage" + " - " + vars[9])
   #    #print ("afr" + " - " + vars[10])
   #    #print ("afrTarget" + " - " + vars[21])
   #    #print ("advance" + " - " + vars[23])
   #    #print ("tps" + " - " + vars[24])
   #    #print ("boostTarget" + " - " + vars[29])
   #    #print ("boostDuty" + " - " + vars[30])
   #    #print ("flex" + " - " + vars[34])
   #    #print ("baro" + " - " + vars[40])
   #    map_bar      = (int(vars[4]) - int(vars[40])) / 101.33
   #    map_psi      = (int(vars[4]) - int(vars[40])) * 0.145038
   #    map_inhg     = (int(vars[40]) - int(vars[4])) * 0.2953007 
   #    temprpm = int(map_psi *100)
   #    if (temprpm < 0):
   #        temprpm = temprpm * -1
   #    vars[14] = str(temprpm)
   #    #print ("map_bar" + " - " + str(map_bar))
   #    #print ("map_psi" + " - " + str(map_psi))
   #    #print ("map_inhg" + " - " + str(map_inhg))
   #    for extip in basicips:
   #        try:
   #           print("sending to IP - " + extip)
   #           basicdashdata = "BASIC~"+vars[4]+" "+vars[40]+" "+vars[7]+" "+vars[6]+" "+vars[114]+" "+vars[10]+" "+vars[105]+" "+vars[106]+" "+vars[14]+" "+vars[9]+" "+vars[24]
   #           sock.sendto(basicdashdata.encode('utf-8'), (extip, UDP_PORT))
   #        except:
   #           print("Error sending to IP - " + extip)

   #    for extip in allips:
   #        try:
   #           print("sending to IP - " + extip)
   #           #fulldata = "FULL~155,"+vars[4] + "~210,"+vars[24] +"~135,"+vars[6]+ "~179,"+vars[14] + "~199,"+str(count) + "~6,"+vars[10] + "~22,"+str(map_psi)
   #           #sock.sendto(fulldata.encode('utf-8'), (extip, UDP_PORT))
   #           coredata = "CORE~,"+lineout
   #           sock.sendto(coredata.encode('utf-8'), (extip, UDP_PORT))
   #           #sock.sendto(("155,"+vars[4]).encode('utf-8'), (extip, UDP_PORT))
   #           #sock.sendto(("210,"+vars[24]).encode('utf-8'), (extip, UDP_PORT))
   #           #sock.sendto(("135,"+vars[6]).encode('utf-8'), (extip, UDP_PORT))
   #           #sock.sendto(("179,"+vars[14]).encode('utf-8'), (extip, UDP_PORT))
   #           #sock.sendto(("199,"+str(count)).encode('utf-8'), (extip, UDP_PORT))
   #           #sock.sendto(("6,"+vars[10]).encode('utf-8'), (extip, UDP_PORT))
   #           #sock.sendto(("22,"+str(map_psi)).encode('utf-8'), (extip, UDP_PORT))
   #        except:
   #           print("Error sending to IP - " + extip)

   #    sock.sendto(("155,"+vars[4]).encode('utf-8'), (UDP_IP, UDP_PORT))
   #    sock.sendto(("210,"+vars[24]).encode('utf-8'), (UDP_IP, UDP_PORT))
   #    sock.sendto(("135,"+vars[6]).encode('utf-8'), (UDP_IP, UDP_PORT))
   #    sock.sendto(("179,"+vars[14]).encode('utf-8'), (UDP_IP, UDP_PORT))
   #    sock.sendto(("199,"+str(count)).encode('utf-8'), (UDP_IP, UDP_PORT))
   #    sock.sendto(("6,"+vars[10]).encode('utf-8'), (UDP_IP, UDP_PORT))
   #    sock.sendto(("22,"+str(map_psi)).encode('utf-8'), (UDP_IP, UDP_PORT))
   #    count = count +1
   #    if (count > 300):
   #        count = 1
   # except Exception as e: 
   #    print(e)
   #    print("Serial data corrupt")
   #    ArduinoSerial.flush()
   #    ArduinoSerial.close()
   #    try:
   #       ArduinoSerial = serial.Serial('/dev/ttyACM0',115200, timeout = 0.012) #timeout for response on readline()
   #    except:
   #       ArduinoSerial = serial.Serial('/dev/ttyUSB0',115200, timeout = 0.012) #timeout for response on readline()

   #    print("ECU Ready")
   #    connected = True
   #    time.sleep(2)



      data, addr = sock.recvfrom(300)
      #print ("Data from socket : " + data)
      datalist = data.decode().split('~')
      listdata = datalist[1].split(' ')
      print ("Data from socket : " + datalist[1])
      try:
         map = int(listdata[0])
         baro = int(listdata[1])
         coolantRaw = int(listdata[2])
         iatRaw = int(listdata[3])
         fueltempRaw = int(listdata[4])
         afr = int(listdata[5])
         fuelpressureRaw = int(listdata[6]);
         oilpressureRaw = int(listdata[7]);
         rpmd = int(listdata[8])
         batt_v = int(listdata[9])
         tps = int(listdata[10])

         #map = int(listdata[4])
         #baro = int(listdata[40])
         #coolantRaw = int(listdata[7])
         #iatRaw = int(listdata[6])
         #fueltempRaw = int(listdata[114])
         #afr = int(listdata[10])
         #fuelpressureRaw = int(listdata[105]);
         #oilpressureRaw = int(listdata[106]);
         #rpmd = int(listdata[14])
         #batt_v = int(listdata[9])
         #tps = int(listdata[24])


         map_bar      = { (map - baro) / 101.33 }
         map_psi      = { (map - baro) * 0.145038 }
         map_inhg     = { (baro - map) * 0.2953007 } 
         #map_vacboost = { map < baro ? -map_inhg : map_psi };
         # fueltemp = fueltempRaw - 40
         # afrTarget = int(listdata[21]
         # lambda1           =  afr / stoich ;
         # lambdaTarget     =  afrTarget / stoich ;

      

         coolant = coolantRaw - 40
         iat = iatRaw - 40
         stoich = 14.7
         fuelpressure = fuelpressureRaw * 0.06894;
         oilpressure = oilpressureRaw * 0.06894;
         a_temp = iat
         map_kpa = map_bar
         w_temp = coolant
         oil_press = oilpressure
         fuel_press = fuelpressure
               
      except Exception as e: print(e)
            #print (ecudata1[0]) 


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
      for k in range (1,int(krpm)):
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
      # text = font.render(str('%.1f' %power)+" Kw",2,green)
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
      # text = font.render(str(curminute) + ":" + str('%.2f' %cursec),2,cyan)
      # if cursec<10:
      #    text = font.render(str(curminute) + ":0" + str('%.2f' %cursec),2,cyan)
      #    textpos.top = 380
      #    textpos.left = 520
      #    background.blit(text,textpos)
      if disp_now==1:
         disp_now=0
         pygame.draw.rect(background,black,(650,120,150,200))
         font = pygame.font.Font(None, 50)
         text = font.render("LAP " + str(laps_done) ,2,white)
         textpos = text.get_rect()
         textpos.top = 120
         textpos.left = 650
         background.blit(text,textpos)

      # font = pygame.font.Font(None, 50)
      # text = font.render(str(lapminute) + ":" + str('%.1f' %lapsec),2,yellow)

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

      # time.sleep(1)
