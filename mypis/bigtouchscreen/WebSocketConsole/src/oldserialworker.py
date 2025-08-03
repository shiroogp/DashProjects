import serial
import time
import multiprocessing

## Change this to match your local settings
SERIAL_PORT = '/dev/ttyUSB0'
SERIAL_BAUDRATE = 115200

class SerialProcess(multiprocessing.Process):
    running=true 
    
    def __init__(self, input_queue, output_queue):
        print ("Starting serial process")
        multiprocessing.Process.__init__(self)
        self.input_queue = input_queue
        self.output_queue = output_queue
        self.sp = serial.Serial(SERIAL_PORT, SERIAL_BAUDRATE, timeout=1)
        print ("serial process: connected")

    def close(self):
        self.sp.close()
 
    def writeSerial(self, data):
        self.sp.write(data)
        # time.sleep(1)
        
    def readSerial(self):
        return self.sp.readline().replace("\n", "")
 
    def run(self):
 
        self.sp.flushInput()
        var = "A"
        self.writeSerial(var.encode())
        print ("writing to serial: A") 
#        data = self.readSerial()
#        print ("reading from serial: " + data)
        time.sleep(1) 
        while self.running == true:
            # look for incoming tornado request
            if not self.input_queue.empty():
                data = self.input_queue.get()
 
                # send it to the serial device
                self.writeSerial(data)
                print ("writing to serial: " + data)
 
            # look for incoming serial data
            #if (self.sp.inWaiting() > 0):
            data = self.readSerial()
            print ("reading from serial: " + data)
            # send it back to tornado
            self.output_queue.put(data)
            self.writeSerial(var.encode())
            time.sleep(0.1)

# look for incoming tornado request

