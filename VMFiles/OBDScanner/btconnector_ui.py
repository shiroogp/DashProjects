# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'btconnector.ui'
##
## Created by: Qt User Interface Compiler version 6.7.2
##
## WARNING! All changes made in this file will be lost when recompiling UI file!
################################################################################

from PySide6.QtCore import (QCoreApplication, QDate, QDateTime, QLocale,
    QMetaObject, QObject, QPoint, QRect,
    QSize, QTime, QUrl, Qt)
from PySide6.QtGui import (QBrush, QColor, QConicalGradient, QCursor,
    QFont, QFontDatabase, QGradient, QIcon,
    QImage, QKeySequence, QLinearGradient, QPainter,
    QPalette, QPixmap, QRadialGradient, QTransform)
from PySide6.QtWidgets import (QApplication, QDialog, QGroupBox, QLabel,
    QLineEdit, QListWidget, QListWidgetItem, QPushButton,
    QSizePolicy, QTextEdit, QWidget)

class Ui_BtConnector(object):
    def setupUi(self, BtConnector):
        if not BtConnector.objectName():
            BtConnector.setObjectName(u"BtConnector")
        BtConnector.resize(672, 435)
        self.listDevicesNearby = QListWidget(BtConnector)
        self.listDevicesNearby.setObjectName(u"listDevicesNearby")
        self.listDevicesNearby.setGeometry(QRect(10, 150, 511, 201))
        self.label = QLabel(BtConnector)
        self.label.setObjectName(u"label")
        self.label.setGeometry(QRect(10, 130, 161, 17))
        self.buttonScan = QPushButton(BtConnector)
        self.buttonScan.setObjectName(u"buttonScan")
        self.buttonScan.setGeometry(QRect(570, 150, 80, 25))
        self.buttonPair = QPushButton(BtConnector)
        self.buttonPair.setObjectName(u"buttonPair")
        self.buttonPair.setGeometry(QRect(570, 230, 80, 25))
        self.buttonDisconnect = QPushButton(BtConnector)
        self.buttonDisconnect.setObjectName(u"buttonDisconnect")
        self.buttonDisconnect.setGeometry(QRect(570, 310, 80, 25))
        self.buttonRemoteDeviceInfo = QPushButton(BtConnector)
        self.buttonRemoteDeviceInfo.setObjectName(u"buttonRemoteDeviceInfo")
        self.buttonRemoteDeviceInfo.setGeometry(QRect(570, 190, 80, 25))
        self.label_localDevice = QLabel(BtConnector)
        self.label_localDevice.setObjectName(u"label_localDevice")
        self.label_localDevice.setGeometry(QRect(10, 20, 381, 17))
        self.buttonClose = QPushButton(BtConnector)
        self.buttonClose.setObjectName(u"buttonClose")
        self.buttonClose.setGeometry(QRect(570, 400, 80, 25))
        self.groupBox = QGroupBox(BtConnector)
        self.groupBox.setObjectName(u"groupBox")
        self.groupBox.setGeometry(QRect(10, 10, 641, 111))
        self.label_2 = QLabel(self.groupBox)
        self.label_2.setObjectName(u"label_2")
        self.label_2.setGeometry(QRect(10, 30, 54, 17))
        self.label_3 = QLabel(self.groupBox)
        self.label_3.setObjectName(u"label_3")
        self.label_3.setGeometry(QRect(10, 50, 54, 17))
        self.lineEdit_name = QLineEdit(self.groupBox)
        self.lineEdit_name.setObjectName(u"lineEdit_name")
        self.lineEdit_name.setEnabled(False)
        self.lineEdit_name.setGeometry(QRect(80, 30, 113, 16))
        self.lineEdit_address = QLineEdit(self.groupBox)
        self.lineEdit_address.setObjectName(u"lineEdit_address")
        self.lineEdit_address.setEnabled(False)
        self.lineEdit_address.setGeometry(QRect(80, 50, 113, 16))
        self.textEdit = QTextEdit(BtConnector)
        self.textEdit.setObjectName(u"textEdit")
        self.textEdit.setGeometry(QRect(10, 360, 511, 70))
        self.buttonUnpair = QPushButton(BtConnector)
        self.buttonUnpair.setObjectName(u"buttonUnpair")
        self.buttonUnpair.setGeometry(QRect(570, 270, 80, 25))

        self.retranslateUi(BtConnector)

        QMetaObject.connectSlotsByName(BtConnector)
    # setupUi

    def retranslateUi(self, BtConnector):
        BtConnector.setWindowTitle(QCoreApplication.translate("BtConnector", u"Dialog", None))
        self.label.setText(QCoreApplication.translate("BtConnector", u"Bluetooth devices nearby :", None))
        self.buttonScan.setText(QCoreApplication.translate("BtConnector", u"Find", None))
        self.buttonPair.setText(QCoreApplication.translate("BtConnector", u"Pair", None))
        self.buttonDisconnect.setText(QCoreApplication.translate("BtConnector", u"Disconnnect", None))
        self.buttonRemoteDeviceInfo.setText(QCoreApplication.translate("BtConnector", u"Device Info", None))
        self.label_localDevice.setText("")
        self.buttonClose.setText(QCoreApplication.translate("BtConnector", u"Close", None))
        self.groupBox.setTitle(QCoreApplication.translate("BtConnector", u"Local device info:", None))
        self.label_2.setText(QCoreApplication.translate("BtConnector", u"Name :", None))
        self.label_3.setText(QCoreApplication.translate("BtConnector", u"Address:", None))
        self.buttonUnpair.setText(QCoreApplication.translate("BtConnector", u"Unpair", None))
    # retranslateUi

