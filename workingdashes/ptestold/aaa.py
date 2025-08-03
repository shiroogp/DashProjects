import serial  
import time  

import socket


allips = []
f = open("broadcastips.txt", "r")
for x in f:
    print(x)
    allips.append(x)  
	





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

connected = False
while (connected == False):
   try:
      ArduinoSerial = serial.Serial('/dev/ttyACM0',115200, timeout = 0.012) #timeout for response on readline()
      print("ECU Ready")
      connected = True
      time.sleep(3)
   except:
      try:
         ArduinoSerial = serial.Serial('/dev/ttyUSB0',115200, timeout = 0.012) #timeout for response on readline()
         print("ECU Ready")
         connected = True
         time.sleep(3)
      except:
         print("ECU ttyUSB Not Ready")
      print("ECU ttyACM Not Ready")
      time.sleep(2)

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
   ArduinoSerial.write(var.encode())
   data = ArduinoSerial.read() #the last bit gets rid of the new-line char
   lineout = ""
   bytecount = 0
   while data:
      bytecount += 1
      try:
         #print("Decoded message: " + data.decode())
         lineout +=   str(ord(data.decode())) + " "
         #print(data.decode())
      except:
         #print (data + " - " + str(ord(data)))
         lineout +=   str(ord(data)) + " "
   
      data = ArduinoSerial.read()
   try:   
      #print (lineout + " - " + str(bytecount))
      vars = lineout.split()
      #print ("syncLossCounter" + " - " + vars[3])
      #print ("map" + " - " + vars[4])
      #print ("iatRaw" + " - " + vars[6])
      #print ("coolantRaw" + " - " + vars[7])
      #print ("batteryVoltage" + " - " + vars[9])
      #print ("afr" + " - " + vars[10])
      #print ("afrTarget" + " - " + vars[21])
      #print ("advance" + " - " + vars[23])
      #print ("tps" + " - " + vars[24])
      #print ("boostTarget" + " - " + vars[29])
      #print ("boostDuty" + " - " + vars[30])
      #print ("flex" + " - " + vars[34])
      #print ("baro" + " - " + vars[40])
      map_bar      = (int(vars[4]) - int(vars[40])) / 101.33
      map_psi      = (int(vars[4]) - int(vars[40])) * 0.145038
      map_inhg     = (int(vars[40]) - int(vars[4])) * 0.2953007 
      temprpm = int(map_psi *100)
      if (temprpm < 0):
          temprpm = temprpm * -1
      vars[14] = str(temprpm)
      #print ("map_bar" + " - " + str(map_bar))
      #print ("map_psi" + " - " + str(map_psi))
      #print ("map_inhg" + " - " + str(map_inhg))
      for extip in allips:
          try:
             #print("sending to IP - " + extip)
             fulldata = "FULL~155,"+vars[4] + "~210,"+vars[24] +"~135,"+vars[6]+ "~179,"+vars[14] + "~199,"+str(count) + "~6,"+vars[10] + "~22,"+str(map_psi)
             sock.sendto(fulldata.encode('utf-8'), (extip, UDP_PORT))
             #sock.sendto(("155,"+vars[4]).encode('utf-8'), (extip, UDP_PORT))
             #sock.sendto(("210,"+vars[24]).encode('utf-8'), (extip, UDP_PORT))
             #sock.sendto(("135,"+vars[6]).encode('utf-8'), (extip, UDP_PORT))
             #sock.sendto(("179,"+vars[14]).encode('utf-8'), (extip, UDP_PORT))
             #sock.sendto(("199,"+str(count)).encode('utf-8'), (extip, UDP_PORT))
             #sock.sendto(("6,"+vars[10]).encode('utf-8'), (extip, UDP_PORT))
             #sock.sendto(("22,"+str(map_psi)).encode('utf-8'), (extip, UDP_PORT))
          except:
             print("Error sending to IP - " + extip)

      sock.sendto(("155,"+vars[4]).encode('utf-8'), (UDP_IP, UDP_PORT))
      sock.sendto(("210,"+vars[24]).encode('utf-8'), (UDP_IP, UDP_PORT))
      sock.sendto(("135,"+vars[6]).encode('utf-8'), (UDP_IP, UDP_PORT))
      sock.sendto(("179,"+vars[14]).encode('utf-8'), (UDP_IP, UDP_PORT))
      sock.sendto(("199,"+str(count)).encode('utf-8'), (extip, UDP_PORT))
      sock.sendto(("6,"+vars[10]).encode('utf-8'), (UDP_IP, UDP_PORT))
      sock.sendto(("22,"+str(map_psi)).encode('utf-8'), (UDP_IP, UDP_PORT))
      count = count +1
      if (count > 300):
          count = 1
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

      # time.sleep(1)
