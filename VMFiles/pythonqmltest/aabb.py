#======================================

def displayData(data):

  n = len(data) - 3

  #print ("NUM BYTES SENT->   " + str(ord(data[1])))
  print ("DATA RECVD BYTES-> " + bytesToString(data[2:-1]))
  print ("DATA RECVD CHARS-> " + data[2: -1])


#======================================

def bytesToString(data):

  byteString = ""
  n = len(data)
  
  for s in range(0, n):
    byteString = byteString + str(ord(data[s]))
    byteString = byteString + "-"
    
  return(byteString)
  


import serial  
import time  

ArduinoSerial = serial.Serial('/dev/ttyACM0',115200, timeout = 0.02) #timeout for response on readline()
time.sleep(2) #allow time for serial port to open
var = "A"
print ("you entered", var )

# print the input for confirmation
#ArduinoSerial.write(var.encode())

while True:
 #print ("enter message for Arduino")
 #var = input()
# get input from user
# var = "A"
# print ("you entered", var )
 
# print the input for confirmation
  ArduinoSerial.write(var.encode())
#send to Arduino
 #read echo back from arduino to verify receipt of message
  data = ArduinoSerial.readline() #the last bit gets rid of the new-line char
  if data:
    print("received message back from Arduino")
    try:
      print(data.decode('latin-1'))
    except:
      #displayData(data)
      print(data)
  time.sleep(0.001)
