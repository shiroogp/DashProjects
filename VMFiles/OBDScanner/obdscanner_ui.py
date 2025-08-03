# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'obdscanner.ui'
##
## Created by: Qt User Interface Compiler version 6.7.2
##
## WARNING! All changes made in this file will be lost when recompiling UI file!
################################################################################

from PySide6.QtCore import (QCoreApplication, QDate, QDateTime, QLocale,
    QMetaObject, QObject, QPoint, QRect,
    QSize, QTime, QUrl, Qt)
from PySide6.QtGui import (QAction, QBrush, QColor, QConicalGradient,
    QCursor, QFont, QFontDatabase, QGradient,
    QIcon, QImage, QKeySequence, QLinearGradient,
    QPainter, QPalette, QPixmap, QRadialGradient,
    QTransform)
from PySide6.QtWidgets import (QApplication, QMainWindow, QMenu, QMenuBar,
    QRadioButton, QSizePolicy, QToolButton, QWidget)

class Ui_OBDScanner(object):
    def setupUi(self, OBDScanner):
        if not OBDScanner.objectName():
            OBDScanner.setObjectName(u"OBDScanner")
        OBDScanner.resize(400, 300)
        self.actionQuit = QAction(OBDScanner)
        self.actionQuit.setObjectName(u"actionQuit")
        self.centralWidget = QWidget(OBDScanner)
        self.centralWidget.setObjectName(u"centralWidget")
        self.btRadioButton = QRadioButton(self.centralWidget)
        self.btRadioButton.setObjectName(u"btRadioButton")
        self.btRadioButton.setGeometry(QRect(10, 10, 161, 23))
        self.btRadioButton.setChecked(True)
        self.btConfigButton = QToolButton(self.centralWidget)
        self.btConfigButton.setObjectName(u"btConfigButton")
        self.btConfigButton.setGeometry(QRect(200, 10, 24, 24))
        OBDScanner.setCentralWidget(self.centralWidget)
        self.menuBar = QMenuBar(OBDScanner)
        self.menuBar.setObjectName(u"menuBar")
        self.menuBar.setGeometry(QRect(0, 0, 400, 23))
        self.menuOBDScanner = QMenu(self.menuBar)
        self.menuOBDScanner.setObjectName(u"menuOBDScanner")
        OBDScanner.setMenuBar(self.menuBar)

        self.menuBar.addAction(self.menuOBDScanner.menuAction())
        self.menuOBDScanner.addAction(self.actionQuit)

        self.retranslateUi(OBDScanner)
        self.actionQuit.triggered.connect(OBDScanner.close)

        QMetaObject.connectSlotsByName(OBDScanner)
    # setupUi

    def retranslateUi(self, OBDScanner):
        OBDScanner.setWindowTitle(QCoreApplication.translate("OBDScanner", u"OBDScanner", None))
        self.actionQuit.setText(QCoreApplication.translate("OBDScanner", u"Quit", None))
        self.btRadioButton.setText(QCoreApplication.translate("OBDScanner", u"Bluetooth", None))
        self.btConfigButton.setText(QCoreApplication.translate("OBDScanner", u"...", None))
        self.menuOBDScanner.setTitle(QCoreApplication.translate("OBDScanner", u"OBDSca&nner", None))
    # retranslateUi

