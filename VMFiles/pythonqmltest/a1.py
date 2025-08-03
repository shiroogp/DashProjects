import serial  
import time  

ArduinoSerial = serial.Serial('/dev/ttyACM0',115200, timeout = 0.012) #timeout for response on readline()
time.sleep(2) #allow time for serial port to open
print ("enter message for Arduino")
var = "A"
# get input from user
print ("you entered", var )

# print the input for confirmation

while True:
#send to Arduino
 #read echo back from arduino to verify receipt of message
 ArduinoSerial.write(var.encode())
 data = ArduinoSerial.readline() #the last bit gets rid of the new-line char
 while data:
    
    try:
      print("Decoded message: " + data.decode(unicode_escape))
    	#print(data.decode())
    except:
    	print (data)
    data = ArduinoSerial.readline() #the last bit gets rid of the new-line char
 #time.sleep(1)
