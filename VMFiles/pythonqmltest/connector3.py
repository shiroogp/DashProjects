#!/usr/bin/env python2.7 

#Rpi Powermods Dash
import serial
import io
import os
import sys
#from pygame.locals import *
import sys, math, array
from math import *
import time
from time import strftime
import datetime
from time import strftime
import datetime
#import RPi.GPIO as GPIO
import random
import time, signal, sys 

def timestamp():
    now = time.time()
    localtime = time.localtime(now)
    milliseconds = '%03d' % int((now - int(now))*1000)

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

import socket

UDP_IP = "BoostedDash"
UDP_PORT = 45454
MESSAGE = "Hello, World!"

print ("UDP target IP:", UDP_IP)
print ("UDP target port:", UDP_PORT)
print ("message:", MESSAGE)
intspeed = 1
intrpm = 100
boost = 0.1

sock = socket.socket(socket.AF_INET, # Internet
             socket.SOCK_DGRAM) # UDP
sock.setsockopt(socket.SOL_SOCKET, socket.SO_BROADCAST,1)

UDP_IP_REMOTE = ""
UDP_PORT_REMOTE = ""
remotehost = 0

ser = serial.Serial(
		port='/dev/ttyACM0',
		baudrate=115200,
		parity=serial.PARITY_NONE,
		stopbits=serial.STOPBITS_ONE,
		bytesize=serial.EIGHTBITS,
		)
print ("sending A")

ser.write("A")

if os.path.exists("/home/osboxes/.local/share/Boosted Garage/BoostedGarage/remotedash.cfg"):
	try:
		file = open("/home/osboxes/.local/share/Boosted Garage/BoostedGarage/remotedash.cfg", "r")
		UDP_IP_REMOTE=file.readline().strip()
		UDP_PORT_REMOTE=int(file.readline().strip())
		print ("UDP remote target IP:", UDP_IP_REMOTE)
		print ("UDP remote target port:", UDP_PORT_REMOTE)
		remotehost = 1
	except:
		remotehost = 0
#        sock2 = socket.socket(socket.AF_INET, # Internet
#             socket.SOCK_DGRAM) # UDP

#GPIO Dash Button Inputs

#External Inputs

gettime=strftime("%H%M",time.localtime())
getdate=strftime("%d%b",time.localtime())

#This works to set date / time
#gpsdt = "20150222 13:23:03.000"
#os.system('sudo date -u --set="%s"' % gpsdt)

#pygame.init()
#screen = #pygame.display.set_mode((800,480))
##pygame.display.set_caption('PowerMods ECU Display')
#pygame.font.init()
##pygame.display.update()
#pygame.mouse.set_visible(False)
serlog_val=0
        
#background = pygame.Surface(screen.get_size())
#background = background.convert()
#background.fill((0,0,0))


#pygame.font.init()
##pygame.display.update()
#pygame.mouse.set_visible(False)
#
#font = pygame.font.SysFont("freemono", 40, bold = 1)
#text = font.render("PowerMods Dash ECU",1,(250,0,0))
#textpos = text.get_rect()
#textpos.centerx = background.get_rect().centerx
#background.blit(text,textpos)
##screen.blit(background,(0,0))
##pygame.display.flip()
load=1

os.system('cd /home/pi/')
#load new dash.cfg logo.jpg dash.py track.dat
#if os.path.exists("/dev/sda1"):

while 1:
	intspeed+=1
	intrpm+=100
	boost+=0.1
	if intspeed > 319:
	    intspeed = 1 #randint(1,200)
	if intrpm > 10000:
	    intrpm = 100 #randint(100,9000)
	if boost > 3:
	    boost=0.1  
	print ("Reading serial") 
	res = ser.readline()
	print(res) 
	print ("Checking if remote or local")
	if remotehost == 0:
		print ("remote = 0")
		if os.path.exists("/home/osboxes/.local/share/Boosted Garage/BoostedGarage/remotedash.cfg"):
#			try:
#				file = open("/.local/share/Boosted Garage/BoostedGarage/remotedash.cfg", "r")
#				UDP_IP_REMOTE=file.readline().strip()
#				UDP_PORT_REMOTE=int(file.readline().strip())
			print ("UDP remote target IP:", UDP_IP_REMOTE)
			print ("UDP remote target port:", UDP_PORT_REMOTE)
			remotehost = 1
			print ("remote = 0")
		else:
			remotehost = 0
			print ("remote = 0")
	if remotehost == 1:
		print ("remote = 1")
		sock.sendto("199,"+str(intspeed), ('<broadcast>', UDP_PORT))
		sock.sendto("179,"+str(intrpm), ('<broadcast>', UDP_PORT))
		sock.sendto("22,"+str(boost), ('<broadcast>', UDP_PORT))
		if os.path.exists("/home/osboxes/.local/share/Boosted Garage/BoostedGarage/remotedash.cfg"):
			remotehost = 1			
		else:
			remotehost = 0		
	else:
		print ("remote = 0")
		#sock.sendto(gpsssdata, (UDP_IP, UDP_PORT))
		sock.sendto("199,"+str(intspeed), (UDP_IP, UDP_PORT))
		sock.sendto("179,"+str(intrpm), (UDP_IP, UDP_PORT))
		sock.sendto("22,"+str(boost), (UDP_IP, UDP_PORT))
		#sock.sendto("199,"+str(speedg) + "~" + "179,"+str(rpmd) + "~" + "6,"+str(afr) + "~" + "22,"+str(mapsensor) + "~" + "7,"+str(a_temp) + "~" + "109,"+str(x_lat) + "~" + "110,"+str(y_long) + "~" + "111,"+str(speedg) + "~" + "112,"+str(timegps) + "~" + "135,"+str(a_temp) + "~" + "142,"+str(afr) + "~" + "155,"+str(map_kpa) + "~" + "156,"+str(map_site) + "~" + "170,"+str(oil_temp) + "~" + "173,"+str(power) + "~" + "179,"+str(rpmd) + "~" + "202,"+str(tps) + "~" + "210,"+str(tps) + "~" + "228,"+str(volts), (UDP_IP, UDP_PORT))
	
	time.sleep(0.035)

