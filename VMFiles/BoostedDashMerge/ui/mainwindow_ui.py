# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'mainwindow.ui'
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
from PySide6.QtWidgets import (QAbstractItemView, QApplication, QHBoxLayout, QHeaderView,
    QLabel, QMainWindow, QPushButton, QSizePolicy,
    QSpacerItem, QSplitter, QTableView, QToolBar,
    QVBoxLayout, QWidget)
import res_rc

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        if not MainWindow.objectName():
            MainWindow.setObjectName(u"MainWindow")
        MainWindow.resize(920, 500)
        icon = QIcon()
        icon.addFile(u":/img/icon.png", QSize(), QIcon.Mode.Normal, QIcon.State.Off)
        MainWindow.setWindowIcon(icon)
        self.centralWidget = QWidget(MainWindow)
        self.centralWidget.setObjectName(u"centralWidget")
        self.verticalLayout_3 = QVBoxLayout(self.centralWidget)
        self.verticalLayout_3.setSpacing(6)
        self.verticalLayout_3.setContentsMargins(11, 11, 11, 11)
        self.verticalLayout_3.setObjectName(u"verticalLayout_3")
        self.splitter = QSplitter(self.centralWidget)
        self.splitter.setObjectName(u"splitter")
        self.splitter.setLineWidth(2)
        self.splitter.setOrientation(Qt.Vertical)
        self.splitter.setOpaqueResize(True)
        self.splitter.setChildrenCollapsible(False)
        self.layoutWidget = QWidget(self.splitter)
        self.layoutWidget.setObjectName(u"layoutWidget")
        self.verticalLayout = QVBoxLayout(self.layoutWidget)
        self.verticalLayout.setSpacing(6)
        self.verticalLayout.setContentsMargins(11, 11, 11, 11)
        self.verticalLayout.setObjectName(u"verticalLayout")
        self.verticalLayout.setContentsMargins(0, 0, 0, 0)
        self.horizontalLayout = QHBoxLayout()
        self.horizontalLayout.setSpacing(6)
        self.horizontalLayout.setObjectName(u"horizontalLayout")
        self.label_3 = QLabel(self.layoutWidget)
        self.label_3.setObjectName(u"label_3")
        self.label_3.setPixmap(QPixmap(u":/img/up.png"))
        self.label_3.setScaledContents(False)

        self.horizontalLayout.addWidget(self.label_3)

        self.label = QLabel(self.layoutWidget)
        self.label.setObjectName(u"label")

        self.horizontalLayout.addWidget(self.label)

        self.horizontalSpacer = QSpacerItem(40, 20, QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Minimum)

        self.horizontalLayout.addItem(self.horizontalSpacer)

        self.resumeSenderBtn = QPushButton(self.layoutWidget)
        self.resumeSenderBtn.setObjectName(u"resumeSenderBtn")
        self.resumeSenderBtn.setEnabled(False)
        icon1 = QIcon()
        icon1.addFile(u":/img/resume.png", QSize(), QIcon.Mode.Normal, QIcon.State.Off)
        self.resumeSenderBtn.setIcon(icon1)
        self.resumeSenderBtn.setIconSize(QSize(18, 18))
        self.resumeSenderBtn.setFlat(True)

        self.horizontalLayout.addWidget(self.resumeSenderBtn)

        self.pauseSenderBtn = QPushButton(self.layoutWidget)
        self.pauseSenderBtn.setObjectName(u"pauseSenderBtn")
        self.pauseSenderBtn.setEnabled(False)
        icon2 = QIcon()
        icon2.addFile(u":/img/pause.png", QSize(), QIcon.Mode.Normal, QIcon.State.Off)
        self.pauseSenderBtn.setIcon(icon2)
        self.pauseSenderBtn.setIconSize(QSize(18, 18))
        self.pauseSenderBtn.setFlat(True)

        self.horizontalLayout.addWidget(self.pauseSenderBtn)

        self.cancelSenderBtn = QPushButton(self.layoutWidget)
        self.cancelSenderBtn.setObjectName(u"cancelSenderBtn")
        self.cancelSenderBtn.setEnabled(False)
        icon3 = QIcon()
        icon3.addFile(u":/img/cancel.png", QSize(), QIcon.Mode.Normal, QIcon.State.Off)
        self.cancelSenderBtn.setIcon(icon3)
        self.cancelSenderBtn.setIconSize(QSize(18, 18))
        self.cancelSenderBtn.setFlat(True)

        self.horizontalLayout.addWidget(self.cancelSenderBtn)

        self.pushButton_2 = QPushButton(self.layoutWidget)
        self.pushButton_2.setObjectName(u"pushButton_2")
        icon4 = QIcon()
        icon4.addFile(u":/img/clear.png", QSize(), QIcon.Mode.Normal, QIcon.State.Off)
        self.pushButton_2.setIcon(icon4)
        self.pushButton_2.setIconSize(QSize(18, 18))
        self.pushButton_2.setFlat(True)

        self.horizontalLayout.addWidget(self.pushButton_2)


        self.verticalLayout.addLayout(self.horizontalLayout)

        self.senderTableView = QTableView(self.layoutWidget)
        self.senderTableView.setObjectName(u"senderTableView")
        self.senderTableView.setContextMenuPolicy(Qt.CustomContextMenu)
        self.senderTableView.setSelectionMode(QAbstractItemView.SingleSelection)
        self.senderTableView.setSelectionBehavior(QAbstractItemView.SelectRows)
        self.senderTableView.setVerticalScrollMode(QAbstractItemView.ScrollPerPixel)
        self.senderTableView.setHorizontalScrollMode(QAbstractItemView.ScrollPerPixel)
        self.senderTableView.setWordWrap(False)
        self.senderTableView.horizontalHeader().setStretchLastSection(True)
        self.senderTableView.verticalHeader().setVisible(False)

        self.verticalLayout.addWidget(self.senderTableView)

        self.splitter.addWidget(self.layoutWidget)
        self.layoutWidget1 = QWidget(self.splitter)
        self.layoutWidget1.setObjectName(u"layoutWidget1")
        self.verticalLayout_2 = QVBoxLayout(self.layoutWidget1)
        self.verticalLayout_2.setSpacing(6)
        self.verticalLayout_2.setContentsMargins(11, 11, 11, 11)
        self.verticalLayout_2.setObjectName(u"verticalLayout_2")
        self.verticalLayout_2.setContentsMargins(0, 0, 0, 0)
        self.horizontalLayout_2 = QHBoxLayout()
        self.horizontalLayout_2.setSpacing(6)
        self.horizontalLayout_2.setObjectName(u"horizontalLayout_2")
        self.label_4 = QLabel(self.layoutWidget1)
        self.label_4.setObjectName(u"label_4")
        self.label_4.setPixmap(QPixmap(u":/img/down.png"))

        self.horizontalLayout_2.addWidget(self.label_4)

        self.label_2 = QLabel(self.layoutWidget1)
        self.label_2.setObjectName(u"label_2")

        self.horizontalLayout_2.addWidget(self.label_2)

        self.horizontalSpacer_2 = QSpacerItem(40, 20, QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Minimum)

        self.horizontalLayout_2.addItem(self.horizontalSpacer_2)

        self.resumeReceiverBtn = QPushButton(self.layoutWidget1)
        self.resumeReceiverBtn.setObjectName(u"resumeReceiverBtn")
        self.resumeReceiverBtn.setEnabled(False)
        self.resumeReceiverBtn.setIcon(icon1)
        self.resumeReceiverBtn.setIconSize(QSize(18, 18))
        self.resumeReceiverBtn.setFlat(True)

        self.horizontalLayout_2.addWidget(self.resumeReceiverBtn)

        self.pauseReceiverBtn = QPushButton(self.layoutWidget1)
        self.pauseReceiverBtn.setObjectName(u"pauseReceiverBtn")
        self.pauseReceiverBtn.setEnabled(False)
        self.pauseReceiverBtn.setIcon(icon2)
        self.pauseReceiverBtn.setIconSize(QSize(18, 18))
        self.pauseReceiverBtn.setFlat(True)

        self.horizontalLayout_2.addWidget(self.pauseReceiverBtn)

        self.cancelReceiverBtn = QPushButton(self.layoutWidget1)
        self.cancelReceiverBtn.setObjectName(u"cancelReceiverBtn")
        self.cancelReceiverBtn.setEnabled(False)
        self.cancelReceiverBtn.setIcon(icon3)
        self.cancelReceiverBtn.setIconSize(QSize(18, 18))
        self.cancelReceiverBtn.setFlat(True)

        self.horizontalLayout_2.addWidget(self.cancelReceiverBtn)

        self.pushButton = QPushButton(self.layoutWidget1)
        self.pushButton.setObjectName(u"pushButton")
        self.pushButton.setIcon(icon4)
        self.pushButton.setIconSize(QSize(18, 18))
        self.pushButton.setFlat(True)

        self.horizontalLayout_2.addWidget(self.pushButton)


        self.verticalLayout_2.addLayout(self.horizontalLayout_2)

        self.receiverTableView = QTableView(self.layoutWidget1)
        self.receiverTableView.setObjectName(u"receiverTableView")
        self.receiverTableView.setContextMenuPolicy(Qt.CustomContextMenu)
        self.receiverTableView.setSelectionMode(QAbstractItemView.SingleSelection)
        self.receiverTableView.setSelectionBehavior(QAbstractItemView.SelectRows)
        self.receiverTableView.setVerticalScrollMode(QAbstractItemView.ScrollPerPixel)
        self.receiverTableView.setHorizontalScrollMode(QAbstractItemView.ScrollPerPixel)
        self.receiverTableView.setWordWrap(False)
        self.receiverTableView.horizontalHeader().setStretchLastSection(True)
        self.receiverTableView.verticalHeader().setVisible(False)

        self.verticalLayout_2.addWidget(self.receiverTableView)

        self.splitter.addWidget(self.layoutWidget1)

        self.verticalLayout_3.addWidget(self.splitter)

        MainWindow.setCentralWidget(self.centralWidget)
        self.mainToolBar = QToolBar(MainWindow)
        self.mainToolBar.setObjectName(u"mainToolBar")
        self.mainToolBar.setMovable(False)
        self.mainToolBar.setAllowedAreas(Qt.LeftToolBarArea)
        self.mainToolBar.setIconSize(QSize(58, 38))
        self.mainToolBar.setToolButtonStyle(Qt.ToolButtonTextUnderIcon)
        self.mainToolBar.setFloatable(False)
        MainWindow.addToolBar(Qt.ToolBarArea.LeftToolBarArea, self.mainToolBar)

        self.retranslateUi(MainWindow)
        self.senderTableView.doubleClicked.connect(MainWindow.onSenderTableDoubleClicked)
        self.receiverTableView.doubleClicked.connect(MainWindow.onReceiverTableDoubleClicked)
        self.pushButton_2.clicked.connect(MainWindow.onSenderClearClicked)
        self.pushButton.clicked.connect(MainWindow.onReceiverClearClicked)
        self.cancelReceiverBtn.clicked.connect(MainWindow.onReceiverCancelClicked)
        self.pauseReceiverBtn.clicked.connect(MainWindow.onReceiverPauseClicked)
        self.resumeReceiverBtn.clicked.connect(MainWindow.onReceiverResumeClicked)
        self.senderTableView.customContextMenuRequested.connect(MainWindow.onSenderTableContextMenuRequested)
        self.receiverTableView.customContextMenuRequested.connect(MainWindow.onReceiverTableContextMenuRequested)
        self.cancelSenderBtn.clicked.connect(MainWindow.onSenderCancelClicked)
        self.pauseSenderBtn.clicked.connect(MainWindow.onSenderPauseClicked)
        self.resumeSenderBtn.clicked.connect(MainWindow.onSenderResumeClicked)

        QMetaObject.connectSlotsByName(MainWindow)
    # setupUi

    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QCoreApplication.translate("MainWindow", u"Locally", None))
        self.label_3.setText("")
        self.label.setText(QCoreApplication.translate("MainWindow", u"Uploads", None))
#if QT_CONFIG(tooltip)
        self.resumeSenderBtn.setToolTip(QCoreApplication.translate("MainWindow", u"Resume", None))
#endif // QT_CONFIG(tooltip)
        self.resumeSenderBtn.setText("")
#if QT_CONFIG(tooltip)
        self.pauseSenderBtn.setToolTip(QCoreApplication.translate("MainWindow", u"Pause", None))
#endif // QT_CONFIG(tooltip)
        self.pauseSenderBtn.setText("")
#if QT_CONFIG(tooltip)
        self.cancelSenderBtn.setToolTip(QCoreApplication.translate("MainWindow", u"Cancel selected item", None))
#endif // QT_CONFIG(tooltip)
        self.cancelSenderBtn.setText(QCoreApplication.translate("MainWindow", u"Cancel", None))
#if QT_CONFIG(tooltip)
        self.pushButton_2.setToolTip(QCoreApplication.translate("MainWindow", u"Clear completed items", None))
#endif // QT_CONFIG(tooltip)
        self.pushButton_2.setText("")
        self.label_4.setText("")
        self.label_2.setText(QCoreApplication.translate("MainWindow", u"Downloads", None))
#if QT_CONFIG(tooltip)
        self.resumeReceiverBtn.setToolTip(QCoreApplication.translate("MainWindow", u"Resume", None))
#endif // QT_CONFIG(tooltip)
        self.resumeReceiverBtn.setText("")
#if QT_CONFIG(tooltip)
        self.pauseReceiverBtn.setToolTip(QCoreApplication.translate("MainWindow", u"Pause", None))
#endif // QT_CONFIG(tooltip)
        self.pauseReceiverBtn.setText("")
#if QT_CONFIG(tooltip)
        self.cancelReceiverBtn.setToolTip(QCoreApplication.translate("MainWindow", u"Cancel selected item", None))
#endif // QT_CONFIG(tooltip)
        self.cancelReceiverBtn.setText(QCoreApplication.translate("MainWindow", u"Cancel", None))
#if QT_CONFIG(tooltip)
        self.pushButton.setToolTip(QCoreApplication.translate("MainWindow", u"Clear completed items", None))
#endif // QT_CONFIG(tooltip)
        self.pushButton.setText("")
    # retranslateUi

