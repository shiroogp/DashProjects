import threading
import time
import math
import serial
from io import StringIO
import csv
#from PyQt5.QtGui import QGuiApplication
from PyQt5.QtQml import QQmlApplicationEngine
#from PyQt5.QtCore import QObject, pyqtSignal, pyqtSlot
from PyQt5.QtCore import *
from PyQt5.QtGui import *
from PyQt5.QtWidgets import *
from PyQt5.QtQuick import *
import random
from Car_HUD_test_untabify import *
 
#global ser
##define and open the serial port
#ser=serial.Serial(port='/dev/ttyUSB0',
#      baudrate=38400,
#      parity=serial.PARITY_NONE,
#      stopbits=serial.STOPBITS_ONE,
#      bytesize=serial.EIGHTBITS,
#    )
    
#class WorkerSignals(QObject):
#    '''
#    Defines the signals available from a running worker thread.
#
#    Supported signals are:
#
#    finished
#        No data
#
#    error
#        `tuple` (exctype, value, traceback.format_exc() )
#
#    result
#        `object` data returned from processing, anything
#
#    progress
#        `int` indicating % progress
#
#    '''
#    finished = pyqtSignal()
#    error = pyqtSignal(tuple)
#    result = pyqtSignal(object)
#    progress = pyqtSignal(int)
#    speed = pyqtSignal(int)
#    rpm = pyqtSignal(int)
#    wtemp = pyqtSignal(int)
#
#class Worker(QRunnable):
#    '''
#    Worker thread
#
#    Inherits from QRunnable to handler worker thread setup, signals and wrap-up.
#
#    :param callback: The function callback to run on this worker thread. Supplied args and 
#                     kwargs will be passed through to the runner.
#    :type callback: function
#    :param args: Arguments to pass to the callback function
#    :param kwargs: Keywords to pass to the callback function
#
#    '''
#
#    def __init__(self, fn, *args, **kwargs):
#        super(Worker, self).__init__()
#
#        # Store constructor arguments (re-used for processing)
#        self.fn = fn
#        self.args = args
#        self.kwargs = kwargs
#        self.signals = WorkerSignals()
#
#        # Add the callback to our kwargs
#        self.kwargs['progress_callback'] = self.signals.progress
#
#    @pyqtSlot()
#    def run(self):
#        '''
#        Initialise the runner function with passed args, kwargs.
#        '''
#
#        # Retrieve args/kwargs here; and fire processing using them
#        try:
#            counter = 0
#            message = Calculator()
#        #    message.random.connect(model.addSubmission, Qt.QueuedConnection)
#            while True:
#                counter+=1
#                data=ser.readline(120) #read the stream
#                print(data)
#        #        data=data.decode() #convert stream from bytes to characters
#        #        data=StringIO(data)#convert a stream of characters into string
#        #        dataset=csv.reader(data, delimiter= ',') #read the CSV string into individual array
#        #        dataset=list(dataset) #convert the array to list
#                self.signals.speed.emit(counter)
#                QThread.msleep(100)
#
#                if counter == 400:
#                    break        
#        except:
#            traceback.print_exc()
#            exctype, value = sys.exc_info()[:2]
#            self.signals.error.emit((exctype, value, traceback.format_exc()))
#        else:
#            self.signals.result.emit(result)  # Return the result of the processing
#        finally:
#            self.signals.finished.emit()  # Done
 
class Calculator(QObject):
    def __init__(self):
        QObject.__init__(self)
        self.threadpool = QThreadPool()
        print("Multithreading with maximum %d threads" % self.threadpool.maxThreadCount())

        self.timer = QTimer()
        self.timer.setInterval(1000)
        self.timer.timeout.connect(self.recurring_timer)
        self.timer.start()
        self.counter = 0

    def keyPressEvent(self, e):  
        if e.key() == QtCore.Qt.Key_Escape:
            self.close()
        if e.key() == QtCore.Qt.Key_F11:
            if self.isMaximized():
                self.showNormal()
            else:
                self.showMaximized()
    randomnum = 1
    
    # Signal sending sum
    # Necessarily give the name of the argument through arguments=['sum']
    # Otherwise it will not be possible to get it up in QML
    sumResult = pyqtSignal(int, arguments=['sum'])
 
    subResult = pyqtSignal(int, arguments=['sub'])
 
    random = pyqtSignal(int,  arguments=['rand'])
    
    speed = pyqtSignal(int,  arguments=['speed'])
    
    rpm = pyqtSignal(int,  arguments=['rpm'])
    
    water = pyqtSignal(int,  arguments=['water'])
    
    oil = pyqtSignal(int,  arguments=['oil'])
    
    fuel = pyqtSignal(int,  arguments=['fuel'])
    
    # Slot for summing two numbers
    @pyqtSlot(int, int)
    def sum(self, arg1, arg2):
        # Sum two arguments and emit a signal
        self.sumResult.emit(arg1 + arg2)
 
    # Slot for subtraction of two numbers
    @pyqtSlot(int, int)
    def sub(self, arg1, arg2):
        # Subtract arguments and emit a signal
        self.subResult.emit(arg1 - arg2)
 
    @pyqtSlot(float)
    def rand(self, arg1):
        print("called random method - "+str(self.randomnum))
        self.random.emit(random.randint(1,10))
#        self.speed.emit(random.randint(1,300))
#        self.rpm.emit(random.randint(1,7000))
#        self.water.emit(random.randint(1,110))
        self.oil.emit(random.randint(1,130))
        self.fuel.emit(random.randint(1,60))
        
        self.randomnum+=1
    
    @pyqtSlot(float)
    def oh_no(self, arg1):
        # Pass the function to execute
        worker = Worker(self.execute_this_fn) # Any other args, kwargs are passed to the run function
        worker.signals.result.connect(self.print_output)
        worker.signals.finished.connect(self.thread_complete)
        worker.signals.progress.connect(self.progress_fn)
        worker.signals.speed.connect(self.updatespeed)
        worker.signals.rpm.connect(self.updaterpm)
        worker.signals.wtemp.connect(self.updatewtemp)
        worker.signals.atemp.connect(self.updateatemp)
        worker.signals.otemp.connect(self.updateotemp)

        # Execute
        self.threadpool.start(worker)

    
    def progress_fn(self, n):
        print("%d%% done" % n)

    def execute_this_fn(self, progress_callback):
        for n in range(0, 5):
            time.sleep(1)
            progress_callback.emit(n*100/4)

        return "Done."

    def print_output(self, s):
        print(s)

    def thread_complete(self):
        print("THREAD COMPLETE!")

    def updatespeed(self, s):
        print("Speed Update!" + str(s))
        self.speed.emit(s)
        

    def updaterpm(self, s):
        print("RPM Update!" + str(s))
        self.rpm.emit(s)

    def updatewtemp(self, s):
        print("WTemp Update!" + str(s))
        self.water.emit(s)

    def updateatemp(self, s):
        print("Voltage Update!" + str(s))
        self.fuel.emit(s)

    def updateotemp(self, s):
        print("Air Temp Update!" + str(s))
        self.oil.emit(s)


    def recurring_timer(self):
        self.counter +=1
        print("Counter: %d" % self.counter)


class RedditRunnable(QRunnable):
    def run(self):
        fetch()
        


if __name__ == "__main__":
    import sys
    
    # Create an instance of the application
    app = QGuiApplication(sys.argv)
    # Create QML engine
    engine = QQmlApplicationEngine()
    # Create a calculator object
    calculator = Calculator()
    # And register it in the context of QML
    engine.rootContext().setContextProperty("calculator", calculator)
    # Load the qml file into the engine
    engine.load("main2.qml")

#    i = 0.01
#    j = 99
#    while i < 0:
#        #calculator.sum(i, j)
#        #calculator.rand(i)
#        i+=0.01
#        j-=1
#        #print ("i = " + str(i))
#        #print ("j = " + str(j)) 
#        time.sleep(0.01)
#    app.showMaximized()
    sys.exit(app.exec_())
