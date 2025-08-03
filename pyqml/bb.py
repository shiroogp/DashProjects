import serial  
import time  

ArduinoSerial = serial.Serial('/dev/ttyACM0',115200, timeout = 2) #timeout for response on readline()
time.sleep(2) #allow time for serial port to open

while True:
 #print ("enter message for Arduino")
 #var = input()
# get input from user
 var = "A"
 print ("you entered", var )
 
# print the input for confirmation
 ArduinoSerial.write(var.encode())
#send to Arduino
 #read echo back from arduino to verify receipt of message
 data = ArduinoSerial.readline() #the last bit gets rid of the new-line char
 if data:
    print("received message back from Arduino")
    try:
    	print(data.decode())
    except:
    	print (data)
 #time.sleep(1)
