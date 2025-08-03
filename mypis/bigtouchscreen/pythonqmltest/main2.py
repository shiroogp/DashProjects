import sys
import datetime
import time
import praw
import threading

from PyQt5.QtCore import *
from PyQt5.QtGui import *
from PyQt5.QtWidgets import *
from PyQt5.QtQuick import *

class Submission:
    def __init__(self, title, url, time):
        self._title = title
        self._url = url
        self._time = time

    def name(self):
        return self._title

    def link(self):
        return self._url

    def time(self):
        return self._time

class SubmissionModel(QAbstractListModel):
    NameRole = Qt.UserRole + 1
    LinkRole = Qt.UserRole + 2
    TimeRole = Qt.UserRole + 3

    _roles = {NameRole: b"name", LinkRole: b"link", TimeRole: b"time"}

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

        if role == self.NameRole:
            return submission.name()

        if role == self.LinkRole:
            return submission.link()

        if role == self.TimeRole:
            return submission.time()

        return QVariant()

    def roleNames(self):
        return self._roles

class Message(QObject):
    submissionSignal = pyqtSignal(Submission)

def init_reddit():
    reddit = praw.Reddit(
        client_id='', 
        client_secret='',
        password='', 
        user_agent='',
        username=''
        )
    return reddit

def fetch():
    reddit = init_reddit()

    subreddit = reddit.subreddit('LandscapePhotography')
    counter = 0
    message = Message()
    message.submissionSignal.connect(model.addSubmission, Qt.QueuedConnection)
    for submission in subreddit.submissions(None, time.time()):
        counter += 1
        print(
            "Counter: {} Submission title: {} , Submission URL: {} ,Created at: {}".format(
                counter, submission.title,
                submission.url,
                datetime.datetime.fromtimestamp(int(submission.created)).strftime('%Y-%m-%d %H:%M:%S')))

        submission = Submission(submission.title, submission.url,
                                       datetime.datetime.fromtimestamp(int(submission.created)).strftime(
                                           '%Y-%m-%d %H:%M:%S'))
        message.submissionSignal.emit(submission)
        QThread.msleep(10)

        if counter == 400:
            break


if __name__ == '__main__':
    import sys

    app = QGuiApplication(sys.argv)

    model = SubmissionModel()

    view = QQuickView()
    view.setResizeMode(QQuickView.SizeRootObjectToView)
    ctxt = view.rootContext()
    ctxt.setContextProperty('myModel', model)

    view.setSource(QUrl('main.qml'))
    view.show()
    thread = threading.Thread(target=fetch)
    thread.start()

    sys.exit(app.exec_())
