import serial  
import time  

import socket

UDP_IP = "127.0.0.1"
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

ArduinoSerial = serial.Serial('/dev/ttyACM0',115200, timeout = 0.012) #timeout for response on readline()
time.sleep(2) #allow time for serial port to open
print ("enter message for Arduino")
var = "A"
# get input from user
print ("you entered", var )

# print the input for confirmation
count = 1
while True:
#send to Arduino
 #read echo back from arduino to verify receipt of message
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
   print (lineout + " - " + str(bytecount))
   vars = lineout.split()
   print ("syncLossCounter" + " - " + vars[3])
   print ("map" + " - " + vars[4])
   print ("iatRaw" + " - " + vars[6])
   print ("coolantRaw" + " - " + vars[7])
   print ("batteryVoltage" + " - " + vars[9])
   print ("afr" + " - " + vars[10])
   print ("afrTarget" + " - " + vars[21])
   print ("advance" + " - " + vars[23])
   print ("tps" + " - " + vars[24])
   print ("boostTarget" + " - " + vars[29])
   print ("boostDuty" + " - " + vars[30])
   print ("flex" + " - " + vars[34])
   print ("baro" + " - " + vars[40])
   map_bar      = (int(vars[4]) - int(vars[40])) / 101.33
   map_psi      = (int(vars[4]) - int(vars[40])) * 0.145038
   map_inhg     = (int(vars[40]) - int(vars[4])) * 0.2953007 
   print ("map_bar" + " - " + str(map_bar))
   print ("map_psi" + " - " + str(map_psi))
   print ("map_inhg" + " - " + str(map_inhg))
   sock.sendto("199,"+str(intspeed), (UDP_IP, UDP_PORT))
   sock.sendto("179,"+vars[14], (UDP_IP, UDP_PORT))
   sock.sendto("22,"+str(map_psi), (UDP_IP, UDP_PORT))
   # print ("map" + " - " + vars[4])
   # print ("map" + " - " + vars[4])
   # print ("map" + " - " + vars[4])
   # print ("map" + " - " + vars[4])
   # print ("map" + " - " + vars[4])
   # print ("map" + " - " + vars[4])
   count+=1 #the last bit gets rid of the new-line char
 #time.sleep(1)
