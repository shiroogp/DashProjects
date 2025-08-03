import sys
import serial
import time
import threading

#import praw

from PyQt5.QtCore import *
from PyQt5.QtGui import *
from PyQt5.QtWidgets import *
from PyQt5.QtQuick import *


global ser
#define and open the serial port
ser=serial.Serial(port='/dev/ttyUSB0',
      baudrate=38400,
      parity=serial.PARITY_NONE,
      stopbits=serial.STOPBITS_ONE,
      bytesize=serial.EIGHTBITS,
    )
    
    
class Submission:
    def __init__(self, speed, rpm, wtemp):
        self._speed = speed
        self._rpm = rpm
        self._wtemp= wtemp

    def myspeed(self):
        return self._speed

    def myrpm(self):
        return self._rpm

    def mywtemp(self):
        return self._wtemp

class SubmissionModel(QAbstractListModel):
    SpeedRole = Qt.UserRole + 1
    RPMRole = Qt.UserRole + 2
    WTempRole = Qt.UserRole + 3

    _roles = {SpeedRole: b"name", RPMRole: b"link", WTempRole: b"time"}

    def __init__(self, parent=None):
        super(SubmissionModel, self).__init__(parent)

        self._submissions = []

    @pyqtSlot(Submission)
    def addSubmission(self, submission):
        self.beginInsertRows(QModelIndex(), self.rowCount(), self.rowCount())
        self._submissions.append(submission)
        self.endInsertRows()

    def rowCount(self, parent=QModelIndex()):
        return len(self._submissions)

    def data(self, index, role=Qt.DisplayRole):
        try:
            submission = self._submissions[index.row()]
        except IndexError:
            return QVariant()

        if role == self.SpeedRole:
            return submission.myspeed()

        if role == self.RPMRole:
            return submission.myrpm()

        if role == self.WTempRole:
            return submission.mywtemp()

        return QVariant()

    def roleNames(self):
        return self._roles

class Message(QObject):
    submissionSignal = pyqtSignal(Submission)
#    speedSignal = pyqtSignal(Submission.myspeed)
#    rmpSignal = pyqtSignal(Submission.myrpm)
#    wtempSignal = pyqtSignal(Submission.mywtemp)
    

def fetch():
    
    counter = 0  
    message = Message()
    message.submissionSignal.connect(model.addSubmission, Qt.QueuedConnection)    
    while True:
        counter+=1
        data=ser.readline(120) #read the stream
        print(data)

        submission = Submission(counter*10, counter*100,
                                       time.time())
        message.submissionSignal.emit(submission)
                                       
#        QMetaObject.invokeMethod(model, "addSubmission", Qt.QueuedConnection, Q_ARG(Submission, submission))
        QThread.msleep(100)

        if counter == 1001:
            break

class RedditRunnable(QRunnable):
    def run(self):
        fetch()

if __name__ == '__main__':
    import sys

    app = QGuiApplication(sys.argv)

    model = SubmissionModel()

    view = QQuickView()
    view.setResizeMode(QQuickView.SizeRootObjectToView)
    ctxt = view.rootContext()
    ctxt.setContextProperty('myModel', model)

    view.setSource(QUrl('mainlist.qml'))
    view.show()
    thread = threading.Thread(target=fetch)
    thread.start()

    sys.exit(app.exec_())
