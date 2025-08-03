import sys
import serial
from io import StringIO
import csv
#from openpyxl import Workbook
import datetime
from PyQt5.QtGui import QGuiApplication
from PyQt5.QtQml import QQmlApplicationEngine
from PyQt5.QtCore import QObject, pyqtSignal, pyqtSlot, QThread

global ser,  dashboard
#define and open the serial port
ser=serial.Serial(port='/dev/ttyUSB0',
      baudrate=38400,
      parity=serial.PARITY_NONE,
      stopbits=serial.STOPBITS_ONE,
      bytesize=serial.EIGHTBITS,
    )
class Dash(QObject):
    def __init__(self):
        QObject.__init__(self)

#    ampHourvalue = pyqtSignal(int, arguments=['amphour'])
    ampHourvalue = pyqtSignal(float, arguments=['amphour'])
    auxVoltage = pyqtSignal(str, arguments=['auxvolt'])
    mainVoltage = pyqtSignal(int, arguments=['mainvolt'])
    arrayCurrent = pyqtSignal(int, arguments=['arraycurrent'])
    motorCurrent = pyqtSignal(int, arguments=['motorcurrent'])

    @pyqtSlot(int)
    def reset(self, value):

        value=100  #put amp hour capacity here
        self.auxVoltage.emit(value)


class ThreadClass(QThread):
    # Create the signal

    def __init__(self, parent=None):
        super(ThreadClass, self).__init__(parent)
        
#        self.auxVoltage.connect(dashboard.auxVoltage)
#        self.mainVoltage.connect(dashboard.mainVoltage)
#        self.motorCurrent.connect(dashboard.motorCurrent)
#        self.arrayCurrent.connect(dashboard.arrayCurrent)
#        self.ampHourvalue.connect(dashboard.ampHourvalue)        

    def run(self):
#        try:
#            wb=load_workbook("History.xls") #attemps to open the history excel file
#        except:
#            wb=Workbook() #creates and empty excel workbook if histortory is not found
#
#        WorkSheetName=datetime.date.today() #get todays date
#        ws = wb.create_sheet("%s" %WorkSheetName) #create worksheet with the date as tittle

        while True:
            data=ser.readline(120) #read the stream
            print(data)
            data=data.decode() #convert stream from bytes to characters
            data=StringIO(data)#convert a stream of characters into string
            dataset=csv.reader(data, delimiter= ',') #read the CSV string into individual array
            dataset=list(dataset) #convert the array to list

#            ws.append(dataset[0])
#            wb.save("History.xls")

            #extract individual data points
            aux=data
#            print("Aux ", aux)
#            mainvolt=dataset[0][2]
#            print("Main ", mainvolt)
#            arraycurrent=dataset[0][3]
#            motorcurrent=dataset[0][4]

            # Emit the signals
            
            
            dashboard.reset(dashboard, aux)
#            Dash.mainVoltage.emit(mainvolt)
#            Dash.arrayCurrent.emit(arraycurrent) 
#            Dash.motorCurrent.emit(motorcurrent) 

            pass       


def main():
    import sys
    # Create an instance of the application
    app = QGuiApplication(sys.argv)

    #start the thread
    threadclass=ThreadClass()
    threadclass.start()


    # Create QML engine
    engine = QQmlApplicationEngine()
    # Create a Dash object
    dashboard = Dash()
    # And register it in the context of QML
    engine.rootContext().setContextProperty("dashboard", dashboard)
    # Load the qml file into the engine
    engine.load("take2.qml")

    engine.quit.connect(app.quit)
    sys.exit(app.exec_())


if __name__ == "__main__":
    main()
