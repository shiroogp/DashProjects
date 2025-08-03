import time
import math
from PyQt5.QtGui import QGuiApplication
from PyQt5.QtQml import QQmlApplicationEngine
from PyQt5.QtCore import QObject, pyqtSignal, pyqtSlot
 
global ser
#define and open the serial port
ser=serial.Serial(port='/dev/ttyUSB0',
      baudrate=38400,
      parity=serial.PARITY_NONE,
      stopbits=serial.STOPBITS_ONE,
      bytesize=serial.EIGHTBITS,
    )

 
class Calculator(QObject):
    def __init__(self):
        QObject.__init__(self)
    
    randomnum = 1

    # Signal sending sum
    # Necessarily give the name of the argument through arguments=['sum']
    # Otherwise it will not be possible to get it up in QML
    sumResult = pyqtSignal(int, arguments=['sum'])
 
    subResult = pyqtSignal(int, arguments=['sub'])
 
    random = pyqtSignal(int,  arguments=['rand'])
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
        self.random.emit(self.randomnum)
        self.randomnum+=1
 
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
    engine.quit.connect(app.quit)
    i = 0.01
    j = 99
    while i < 0:
        #calculator.sum(i, j)
        #calculator.rand(i)
        i+=0.01
        j-=1
        #print ("i = " + str(i))
        #print ("j = " + str(j)) 
        time.sleep(0.01)
    sys.exit(app.exec_())
