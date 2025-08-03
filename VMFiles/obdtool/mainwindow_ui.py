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
from PySide6.QtGui import (QAction, QBrush, QColor, QConicalGradient,
    QCursor, QFont, QFontDatabase, QGradient,
    QIcon, QImage, QKeySequence, QLinearGradient,
    QPainter, QPalette, QPixmap, QRadialGradient,
    QTransform)
from PySide6.QtWidgets import (QApplication, QCheckBox, QComboBox, QGroupBox,
    QHBoxLayout, QHeaderView, QLabel, QLineEdit,
    QMainWindow, QMenu, QMenuBar, QPushButton,
    QRadioButton, QSizePolicy, QSpacerItem, QSpinBox,
    QStatusBar, QTabWidget, QTableWidget, QTableWidgetItem,
    QTextBrowser, QVBoxLayout, QWidget)

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        if not MainWindow.objectName():
            MainWindow.setObjectName(u"MainWindow")
        MainWindow.resize(1234, 833)
        self.actionConnect = QAction(MainWindow)
        self.actionConnect.setObjectName(u"actionConnect")
        self.actionSettings = QAction(MainWindow)
        self.actionSettings.setObjectName(u"actionSettings")
        self.actionSettings_2 = QAction(MainWindow)
        self.actionSettings_2.setObjectName(u"actionSettings_2")
        self.action_Exit = QAction(MainWindow)
        self.action_Exit.setObjectName(u"action_Exit")
        self.centralwidget = QWidget(MainWindow)
        self.centralwidget.setObjectName(u"centralwidget")
        self.tabWidget = QTabWidget(self.centralwidget)
        self.tabWidget.setObjectName(u"tabWidget")
        self.tabWidget.setGeometry(QRect(10, 0, 1231, 721))
        self.tabWidget.setTabPosition(QTabWidget.North)
        self.tabWidget.setTabShape(QTabWidget.Rounded)
        self.summaryTab = QWidget()
        self.summaryTab.setObjectName(u"summaryTab")
        self.verticalLayout_5 = QVBoxLayout(self.summaryTab)
        self.verticalLayout_5.setObjectName(u"verticalLayout_5")
        self.verticalLayout_4 = QVBoxLayout()
        self.verticalLayout_4.setObjectName(u"verticalLayout_4")
        self.connectionInfoTableWidget = QTableWidget(self.summaryTab)
        self.connectionInfoTableWidget.setObjectName(u"connectionInfoTableWidget")

        self.verticalLayout_4.addWidget(self.connectionInfoTableWidget)

        self.horizontalLayout_2 = QHBoxLayout()
        self.horizontalLayout_2.setObjectName(u"horizontalLayout_2")
        self.connectPushButton = QPushButton(self.summaryTab)
        self.connectPushButton.setObjectName(u"connectPushButton")

        self.horizontalLayout_2.addWidget(self.connectPushButton)

        self.disconnectPushButton = QPushButton(self.summaryTab)
        self.disconnectPushButton.setObjectName(u"disconnectPushButton")

        self.horizontalLayout_2.addWidget(self.disconnectPushButton)

        self.horizontalSpacer_2 = QSpacerItem(40, 20, QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Minimum)

        self.horizontalLayout_2.addItem(self.horizontalSpacer_2)


        self.verticalLayout_4.addLayout(self.horizontalLayout_2)


        self.verticalLayout_5.addLayout(self.verticalLayout_4)

        self.tabWidget.addTab(self.summaryTab, "")
        self.supportedPidsTab = QWidget()
        self.supportedPidsTab.setObjectName(u"supportedPidsTab")
        self.verticalLayout_22 = QVBoxLayout(self.supportedPidsTab)
        self.verticalLayout_22.setObjectName(u"verticalLayout_22")
        self.horizontalLayout_6 = QHBoxLayout()
        self.horizontalLayout_6.setObjectName(u"horizontalLayout_6")
        self.verticalLayout_3 = QVBoxLayout()
        self.verticalLayout_3.setObjectName(u"verticalLayout_3")
        self.label_3 = QLabel(self.supportedPidsTab)
        self.label_3.setObjectName(u"label_3")

        self.verticalLayout_3.addWidget(self.label_3)

        self.label_4 = QLabel(self.supportedPidsTab)
        self.label_4.setObjectName(u"label_4")

        self.verticalLayout_3.addWidget(self.label_4)

        self.pidSelectTableWidget = QTableWidget(self.supportedPidsTab)
        self.pidSelectTableWidget.setObjectName(u"pidSelectTableWidget")

        self.verticalLayout_3.addWidget(self.pidSelectTableWidget)


        self.horizontalLayout_6.addLayout(self.verticalLayout_3)

        self.verticalLayout_12 = QVBoxLayout()
        self.verticalLayout_12.setObjectName(u"verticalLayout_12")
        self.verticalSpacer_3 = QSpacerItem(20, 40, QSizePolicy.Policy.Minimum, QSizePolicy.Policy.Expanding)

        self.verticalLayout_12.addItem(self.verticalSpacer_3)

        self.pidSelectAllPushButton = QPushButton(self.supportedPidsTab)
        self.pidSelectAllPushButton.setObjectName(u"pidSelectAllPushButton")

        self.verticalLayout_12.addWidget(self.pidSelectAllPushButton)

        self.pidSelectNonePushButton = QPushButton(self.supportedPidsTab)
        self.pidSelectNonePushButton.setObjectName(u"pidSelectNonePushButton")

        self.verticalLayout_12.addWidget(self.pidSelectNonePushButton)

        self.pidSelectSavePushButton = QPushButton(self.supportedPidsTab)
        self.pidSelectSavePushButton.setObjectName(u"pidSelectSavePushButton")

        self.verticalLayout_12.addWidget(self.pidSelectSavePushButton)

        self.verticalSpacer_2 = QSpacerItem(20, 40, QSizePolicy.Policy.Minimum, QSizePolicy.Policy.Expanding)

        self.verticalLayout_12.addItem(self.verticalSpacer_2)

        self.verticalLayout_12.setStretch(0, 1)
        self.verticalLayout_12.setStretch(1, 1)
        self.verticalLayout_12.setStretch(2, 1)
        self.verticalLayout_12.setStretch(4, 8)

        self.horizontalLayout_6.addLayout(self.verticalLayout_12)

        self.verticalLayout = QVBoxLayout()
        self.verticalLayout.setObjectName(u"verticalLayout")
        self.readPidsTableWidget = QTableWidget(self.supportedPidsTab)
        self.readPidsTableWidget.setObjectName(u"readPidsTableWidget")

        self.verticalLayout.addWidget(self.readPidsTableWidget)

        self.horizontalLayout = QHBoxLayout()
        self.horizontalLayout.setSpacing(6)
        self.horizontalLayout.setObjectName(u"horizontalLayout")
        self.horizontalLayout.setContentsMargins(0, -1, 0, -1)
        self.readPidsPushButton = QPushButton(self.supportedPidsTab)
        self.readPidsPushButton.setObjectName(u"readPidsPushButton")
        self.readPidsPushButton.setEnabled(False)

        self.horizontalLayout.addWidget(self.readPidsPushButton)

        self.cancelReadPidsPushButton = QPushButton(self.supportedPidsTab)
        self.cancelReadPidsPushButton.setObjectName(u"cancelReadPidsPushButton")
        self.cancelReadPidsPushButton.setEnabled(False)

        self.horizontalLayout.addWidget(self.cancelReadPidsPushButton)

        self.horizontalSpacer = QSpacerItem(40, 20, QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Minimum)

        self.horizontalLayout.addItem(self.horizontalSpacer)


        self.verticalLayout.addLayout(self.horizontalLayout)


        self.horizontalLayout_6.addLayout(self.verticalLayout)

        self.horizontalLayout_6.setStretch(2, 1)

        self.verticalLayout_22.addLayout(self.horizontalLayout_6)

        self.tabWidget.addTab(self.supportedPidsTab, "")
        self.gaugesTab = QWidget()
        self.gaugesTab.setObjectName(u"gaugesTab")
        self.tabWidget.addTab(self.gaugesTab, "")
        self.graphsTab = QWidget()
        self.graphsTab.setObjectName(u"graphsTab")
        self.graphZoomCheckBox = QCheckBox(self.graphsTab)
        self.graphZoomCheckBox.setObjectName(u"graphZoomCheckBox")
        self.graphZoomCheckBox.setGeometry(QRect(10, 690, 131, 21))
        self.graphScrollCheckBox = QCheckBox(self.graphsTab)
        self.graphScrollCheckBox.setObjectName(u"graphScrollCheckBox")
        self.graphScrollCheckBox.setGeometry(QRect(210, 690, 151, 21))
        self.tabWidget.addTab(self.graphsTab, "")
        self.readinessTab = QWidget()
        self.readinessTab.setObjectName(u"readinessTab")
        self.verticalLayout_8 = QVBoxLayout(self.readinessTab)
        self.verticalLayout_8.setObjectName(u"verticalLayout_8")
        self.verticalLayout_7 = QVBoxLayout()
        self.verticalLayout_7.setObjectName(u"verticalLayout_7")
        self.horizontalLayout_3 = QHBoxLayout()
        self.horizontalLayout_3.setObjectName(u"horizontalLayout_3")
        self.verticalLayout_6 = QVBoxLayout()
        self.verticalLayout_6.setObjectName(u"verticalLayout_6")
        self.conTableWidget = QTableWidget(self.readinessTab)
        self.conTableWidget.setObjectName(u"conTableWidget")

        self.verticalLayout_6.addWidget(self.conTableWidget)

        self.monitorStatusTableWidget = QTableWidget(self.readinessTab)
        self.monitorStatusTableWidget.setObjectName(u"monitorStatusTableWidget")

        self.verticalLayout_6.addWidget(self.monitorStatusTableWidget)


        self.horizontalLayout_3.addLayout(self.verticalLayout_6)

        self.nonconTableWidget = QTableWidget(self.readinessTab)
        self.nonconTableWidget.setObjectName(u"nonconTableWidget")

        self.horizontalLayout_3.addWidget(self.nonconTableWidget)


        self.verticalLayout_7.addLayout(self.horizontalLayout_3)

        self.verticalSpacer = QSpacerItem(20, 40, QSizePolicy.Policy.Minimum, QSizePolicy.Policy.Expanding)

        self.verticalLayout_7.addItem(self.verticalSpacer)

        self.horizontalLayout_5 = QHBoxLayout()
        self.horizontalLayout_5.setObjectName(u"horizontalLayout_5")
        self.readReadinessPushButton = QPushButton(self.readinessTab)
        self.readReadinessPushButton.setObjectName(u"readReadinessPushButton")

        self.horizontalLayout_5.addWidget(self.readReadinessPushButton)

        self.horizontalSpacer_3 = QSpacerItem(40, 20, QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Minimum)

        self.horizontalLayout_5.addItem(self.horizontalSpacer_3)


        self.verticalLayout_7.addLayout(self.horizontalLayout_5)

        self.verticalLayout_7.setStretch(0, 10)
        self.verticalLayout_7.setStretch(1, 15)
        self.verticalLayout_7.setStretch(2, 1)

        self.verticalLayout_8.addLayout(self.verticalLayout_7)

        self.tabWidget.addTab(self.readinessTab, "")
        self.onBoardMonitoringTab = QWidget()
        self.onBoardMonitoringTab.setObjectName(u"onBoardMonitoringTab")
        self.verticalLayout_16 = QVBoxLayout(self.onBoardMonitoringTab)
        self.verticalLayout_16.setObjectName(u"verticalLayout_16")
        self.verticalLayout_15 = QVBoxLayout()
        self.verticalLayout_15.setObjectName(u"verticalLayout_15")
        self.mode06TableWidget = QTableWidget(self.onBoardMonitoringTab)
        self.mode06TableWidget.setObjectName(u"mode06TableWidget")

        self.verticalLayout_15.addWidget(self.mode06TableWidget)

        self.horizontalLayout_8 = QHBoxLayout()
        self.horizontalLayout_8.setObjectName(u"horizontalLayout_8")
        self.monitorPushButton = QPushButton(self.onBoardMonitoringTab)
        self.monitorPushButton.setObjectName(u"monitorPushButton")

        self.horizontalLayout_8.addWidget(self.monitorPushButton)

        self.horizontalSpacer_6 = QSpacerItem(40, 20, QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Minimum)

        self.horizontalLayout_8.addItem(self.horizontalSpacer_6)


        self.verticalLayout_15.addLayout(self.horizontalLayout_8)


        self.verticalLayout_16.addLayout(self.verticalLayout_15)

        self.tabWidget.addTab(self.onBoardMonitoringTab, "")
        self.tab = QWidget()
        self.tab.setObjectName(u"tab")
        self.verticalLayout_21 = QVBoxLayout(self.tab)
        self.verticalLayout_21.setObjectName(u"verticalLayout_21")
        self.verticalLayout_19 = QVBoxLayout()
        self.verticalLayout_19.setObjectName(u"verticalLayout_19")
        self.horizontalLayout_17 = QHBoxLayout()
        self.horizontalLayout_17.setObjectName(u"horizontalLayout_17")
        self.verticalLayout_2 = QVBoxLayout()
        self.verticalLayout_2.setObjectName(u"verticalLayout_2")
        self.horizontalLayout_14 = QHBoxLayout()
        self.horizontalLayout_14.setObjectName(u"horizontalLayout_14")
        self.canMonitorStartPushButton = QPushButton(self.tab)
        self.canMonitorStartPushButton.setObjectName(u"canMonitorStartPushButton")

        self.horizontalLayout_14.addWidget(self.canMonitorStartPushButton)

        self.canMonitorStopPushButton = QPushButton(self.tab)
        self.canMonitorStopPushButton.setObjectName(u"canMonitorStopPushButton")

        self.horizontalLayout_14.addWidget(self.canMonitorStopPushButton)


        self.verticalLayout_2.addLayout(self.horizontalLayout_14)

        self.canMsgLabel = QLabel(self.tab)
        self.canMsgLabel.setObjectName(u"canMsgLabel")

        self.verticalLayout_2.addWidget(self.canMsgLabel)


        self.horizontalLayout_17.addLayout(self.verticalLayout_2)

        self.verticalLayout_18 = QVBoxLayout()
        self.verticalLayout_18.setObjectName(u"verticalLayout_18")
        self.horizontalLayout_12 = QHBoxLayout()
        self.horizontalLayout_12.setObjectName(u"horizontalLayout_12")
        self.label_10 = QLabel(self.tab)
        self.label_10.setObjectName(u"label_10")

        self.horizontalLayout_12.addWidget(self.label_10)

        self.canStyleComboBox = QComboBox(self.tab)
        self.canStyleComboBox.setObjectName(u"canStyleComboBox")

        self.horizontalLayout_12.addWidget(self.canStyleComboBox)

        self.horizontalLayout_12.setStretch(0, 1)
        self.horizontalLayout_12.setStretch(1, 9)

        self.verticalLayout_18.addLayout(self.horizontalLayout_12)

        self.horizontalLayout_15 = QHBoxLayout()
        self.horizontalLayout_15.setObjectName(u"horizontalLayout_15")
        self.label_11 = QLabel(self.tab)
        self.label_11.setObjectName(u"label_11")

        self.horizontalLayout_15.addWidget(self.label_11)

        self.canProtocolComboBox = QComboBox(self.tab)
        self.canProtocolComboBox.setObjectName(u"canProtocolComboBox")

        self.horizontalLayout_15.addWidget(self.canProtocolComboBox)

        self.horizontalLayout_15.setStretch(1, 2)

        self.verticalLayout_18.addLayout(self.horizontalLayout_15)


        self.horizontalLayout_17.addLayout(self.verticalLayout_18)

        self.verticalLayout_20 = QVBoxLayout()
        self.verticalLayout_20.setObjectName(u"verticalLayout_20")
        self.horizontalLayout_16 = QHBoxLayout()
        self.horizontalLayout_16.setObjectName(u"horizontalLayout_16")
        self.label_12 = QLabel(self.tab)
        self.label_12.setObjectName(u"label_12")

        self.horizontalLayout_16.addWidget(self.label_12)

        self.canLoadLogFileLineEdit = QLineEdit(self.tab)
        self.canLoadLogFileLineEdit.setObjectName(u"canLoadLogFileLineEdit")

        self.horizontalLayout_16.addWidget(self.canLoadLogFileLineEdit)

        self.canLoadLogFileBrowseButton = QPushButton(self.tab)
        self.canLoadLogFileBrowseButton.setObjectName(u"canLoadLogFileBrowseButton")

        self.horizontalLayout_16.addWidget(self.canLoadLogFileBrowseButton)

        self.canLoadLogPushButton = QPushButton(self.tab)
        self.canLoadLogPushButton.setObjectName(u"canLoadLogPushButton")

        self.horizontalLayout_16.addWidget(self.canLoadLogPushButton)


        self.verticalLayout_20.addLayout(self.horizontalLayout_16)

        self.horizontalLayout_9 = QHBoxLayout()
        self.horizontalLayout_9.setObjectName(u"horizontalLayout_9")
        self.label_8 = QLabel(self.tab)
        self.label_8.setObjectName(u"label_8")

        self.horizontalLayout_9.addWidget(self.label_8)

        self.canSaveLogFileLineEdit = QLineEdit(self.tab)
        self.canSaveLogFileLineEdit.setObjectName(u"canSaveLogFileLineEdit")

        self.horizontalLayout_9.addWidget(self.canSaveLogFileLineEdit)

        self.canSaveLogFileBrowseButton = QPushButton(self.tab)
        self.canSaveLogFileBrowseButton.setObjectName(u"canSaveLogFileBrowseButton")

        self.horizontalLayout_9.addWidget(self.canSaveLogFileBrowseButton)


        self.verticalLayout_20.addLayout(self.horizontalLayout_9)

        self.verticalSpacer_4 = QSpacerItem(20, 5, QSizePolicy.Policy.Minimum, QSizePolicy.Policy.Expanding)

        self.verticalLayout_20.addItem(self.verticalSpacer_4)

        self.canClearRedPushButton = QPushButton(self.tab)
        self.canClearRedPushButton.setObjectName(u"canClearRedPushButton")

        self.verticalLayout_20.addWidget(self.canClearRedPushButton)


        self.horizontalLayout_17.addLayout(self.verticalLayout_20)

        self.horizontalLayout_17.setStretch(1, 6)
        self.horizontalLayout_17.setStretch(2, 5)

        self.verticalLayout_19.addLayout(self.horizontalLayout_17)

        self.canMsgTableWidget = QTableWidget(self.tab)
        self.canMsgTableWidget.setObjectName(u"canMsgTableWidget")

        self.verticalLayout_19.addWidget(self.canMsgTableWidget)

        self.verticalLayout_19.setStretch(1, 1)

        self.verticalLayout_21.addLayout(self.verticalLayout_19)

        self.tabWidget.addTab(self.tab, "")
        self.tab_2 = QWidget()
        self.tab_2.setObjectName(u"tab_2")
        self.groupBox = QGroupBox(self.tab_2)
        self.groupBox.setObjectName(u"groupBox")
        self.groupBox.setGeometry(QRect(120, 30, 211, 151))
        self.verticalLayoutWidget = QWidget(self.groupBox)
        self.verticalLayoutWidget.setObjectName(u"verticalLayoutWidget")
        self.verticalLayoutWidget.setGeometry(QRect(0, 30, 201, 101))
        self.verticalLayout_17 = QVBoxLayout(self.verticalLayoutWidget)
        self.verticalLayout_17.setObjectName(u"verticalLayout_17")
        self.verticalLayout_17.setContentsMargins(0, 0, 0, 0)
        self.radioButton_2 = QRadioButton(self.verticalLayoutWidget)
        self.radioButton_2.setObjectName(u"radioButton_2")

        self.verticalLayout_17.addWidget(self.radioButton_2)

        self.radioButton = QRadioButton(self.verticalLayoutWidget)
        self.radioButton.setObjectName(u"radioButton")

        self.verticalLayout_17.addWidget(self.radioButton)

        self.radioButton_3 = QRadioButton(self.verticalLayoutWidget)
        self.radioButton_3.setObjectName(u"radioButton_3")

        self.verticalLayout_17.addWidget(self.radioButton_3)

        self.groupBox_2 = QGroupBox(self.tab_2)
        self.groupBox_2.setObjectName(u"groupBox_2")
        self.groupBox_2.setGeometry(QRect(340, 30, 321, 131))
        self.horizontalLayoutWidget = QWidget(self.groupBox_2)
        self.horizontalLayoutWidget.setObjectName(u"horizontalLayoutWidget")
        self.horizontalLayoutWidget.setGeometry(QRect(0, 30, 311, 41))
        self.horizontalLayout_10 = QHBoxLayout(self.horizontalLayoutWidget)
        self.horizontalLayout_10.setObjectName(u"horizontalLayout_10")
        self.horizontalLayout_10.setContentsMargins(0, 0, 0, 0)
        self.label_9 = QLabel(self.horizontalLayoutWidget)
        self.label_9.setObjectName(u"label_9")

        self.horizontalLayout_10.addWidget(self.label_9)

        self.datalogLocationLineEdit = QLineEdit(self.horizontalLayoutWidget)
        self.datalogLocationLineEdit.setObjectName(u"datalogLocationLineEdit")

        self.horizontalLayout_10.addWidget(self.datalogLocationLineEdit)

        self.datalogBrowsePushButton = QPushButton(self.horizontalLayoutWidget)
        self.datalogBrowsePushButton.setObjectName(u"datalogBrowsePushButton")

        self.horizontalLayout_10.addWidget(self.datalogBrowsePushButton)

        self.tabWidget.addTab(self.tab_2, "")
        self.troubleCodesTab = QWidget()
        self.troubleCodesTab.setObjectName(u"troubleCodesTab")
        self.verticalLayout_14 = QVBoxLayout(self.troubleCodesTab)
        self.verticalLayout_14.setObjectName(u"verticalLayout_14")
        self.verticalLayout_13 = QVBoxLayout()
        self.verticalLayout_13.setObjectName(u"verticalLayout_13")
        self.label_6 = QLabel(self.troubleCodesTab)
        self.label_6.setObjectName(u"label_6")

        self.verticalLayout_13.addWidget(self.label_6)

        self.troubleStoredTableWidget = QTableWidget(self.troubleCodesTab)
        self.troubleStoredTableWidget.setObjectName(u"troubleStoredTableWidget")

        self.verticalLayout_13.addWidget(self.troubleStoredTableWidget)

        self.label_5 = QLabel(self.troubleCodesTab)
        self.label_5.setObjectName(u"label_5")

        self.verticalLayout_13.addWidget(self.label_5)

        self.tableWidget = QTableWidget(self.troubleCodesTab)
        self.tableWidget.setObjectName(u"tableWidget")

        self.verticalLayout_13.addWidget(self.tableWidget)

        self.horizontalLayout_7 = QHBoxLayout()
        self.horizontalLayout_7.setObjectName(u"horizontalLayout_7")
        self.troubleReadPushButton = QPushButton(self.troubleCodesTab)
        self.troubleReadPushButton.setObjectName(u"troubleReadPushButton")

        self.horizontalLayout_7.addWidget(self.troubleReadPushButton)

        self.troubleClearPushButton = QPushButton(self.troubleCodesTab)
        self.troubleClearPushButton.setObjectName(u"troubleClearPushButton")

        self.horizontalLayout_7.addWidget(self.troubleClearPushButton)

        self.horizontalSpacer_5 = QSpacerItem(40, 20, QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Minimum)

        self.horizontalLayout_7.addItem(self.horizontalSpacer_5)


        self.verticalLayout_13.addLayout(self.horizontalLayout_7)


        self.verticalLayout_14.addLayout(self.verticalLayout_13)

        self.tabWidget.addTab(self.troubleCodesTab, "")
        self.consoleTab = QWidget()
        self.consoleTab.setObjectName(u"consoleTab")
        self.verticalLayout_11 = QVBoxLayout(self.consoleTab)
        self.verticalLayout_11.setObjectName(u"verticalLayout_11")
        self.verticalLayout_9 = QVBoxLayout()
        self.verticalLayout_9.setObjectName(u"verticalLayout_9")
        self.horizontalLayout_11 = QHBoxLayout()
        self.horizontalLayout_11.setObjectName(u"horizontalLayout_11")
        self.label_2 = QLabel(self.consoleTab)
        self.label_2.setObjectName(u"label_2")

        self.horizontalLayout_11.addWidget(self.label_2)

        self.horizontalSpacer_7 = QSpacerItem(40, 20, QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Minimum)

        self.horizontalLayout_11.addItem(self.horizontalSpacer_7)

        self.label_7 = QLabel(self.consoleTab)
        self.label_7.setObjectName(u"label_7")

        self.horizontalLayout_11.addWidget(self.label_7)

        self.debugOutputLinesSpinBox = QSpinBox(self.consoleTab)
        self.debugOutputLinesSpinBox.setObjectName(u"debugOutputLinesSpinBox")
        self.debugOutputLinesSpinBox.setMaximum(5000)
        self.debugOutputLinesSpinBox.setValue(500)

        self.horizontalLayout_11.addWidget(self.debugOutputLinesSpinBox)


        self.verticalLayout_9.addLayout(self.horizontalLayout_11)

        self.debugTextBrowser = QTextBrowser(self.consoleTab)
        self.debugTextBrowser.setObjectName(u"debugTextBrowser")

        self.verticalLayout_9.addWidget(self.debugTextBrowser)


        self.verticalLayout_11.addLayout(self.verticalLayout_9)

        self.verticalLayout_10 = QVBoxLayout()
        self.verticalLayout_10.setObjectName(u"verticalLayout_10")
        self.label = QLabel(self.consoleTab)
        self.label.setObjectName(u"label")

        self.verticalLayout_10.addWidget(self.label)

        self.rawConsoleTextBrowser = QTextBrowser(self.consoleTab)
        self.rawConsoleTextBrowser.setObjectName(u"rawConsoleTextBrowser")

        self.verticalLayout_10.addWidget(self.rawConsoleTextBrowser)

        self.horizontalLayout_4 = QHBoxLayout()
        self.horizontalLayout_4.setObjectName(u"horizontalLayout_4")
        self.rawConsoleLineEdit = QLineEdit(self.consoleTab)
        self.rawConsoleLineEdit.setObjectName(u"rawConsoleLineEdit")

        self.horizontalLayout_4.addWidget(self.rawConsoleLineEdit)

        self.consoleSendPushButton = QPushButton(self.consoleTab)
        self.consoleSendPushButton.setObjectName(u"consoleSendPushButton")

        self.horizontalLayout_4.addWidget(self.consoleSendPushButton)


        self.verticalLayout_10.addLayout(self.horizontalLayout_4)


        self.verticalLayout_11.addLayout(self.verticalLayout_10)

        self.tabWidget.addTab(self.consoleTab, "")
        self.status_comPortLabel = QLabel(self.centralwidget)
        self.status_comPortLabel.setObjectName(u"status_comPortLabel")
        self.status_comPortLabel.setGeometry(QRect(10, 750, 150, 13))
        self.status_comPortLabel.setMinimumSize(QSize(150, 0))
        self.status_comBaudLabel = QLabel(self.centralwidget)
        self.status_comBaudLabel.setObjectName(u"status_comBaudLabel")
        self.status_comBaudLabel.setGeometry(QRect(150, 750, 75, 16))
        self.status_comBaudLabel.setMinimumSize(QSize(75, 0))
        self.status_comStatusLabel = QLabel(self.centralwidget)
        self.status_comStatusLabel.setObjectName(u"status_comStatusLabel")
        self.status_comStatusLabel.setGeometry(QRect(240, 750, 200, 16))
        self.status_comStatusLabel.setMinimumSize(QSize(200, 0))
        self.status_comInterfaceLabel = QLabel(self.centralwidget)
        self.status_comInterfaceLabel.setObjectName(u"status_comInterfaceLabel")
        self.status_comInterfaceLabel.setGeometry(QRect(430, 750, 200, 13))
        self.status_comInterfaceLabel.setMinimumSize(QSize(200, 0))
        self.status_comProtocolLabel = QLabel(self.centralwidget)
        self.status_comProtocolLabel.setObjectName(u"status_comProtocolLabel")
        self.status_comProtocolLabel.setGeometry(QRect(640, 750, 175, 13))
        self.status_comProtocolLabel.setMinimumSize(QSize(175, 0))
        self.status_pidUpdateRateLabel = QLabel(self.centralwidget)
        self.status_pidUpdateRateLabel.setObjectName(u"status_pidUpdateRateLabel")
        self.status_pidUpdateRateLabel.setGeometry(QRect(810, 750, 175, 13))
        self.status_pidUpdateRateLabel.setMinimumSize(QSize(175, 0))
        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QMenuBar(MainWindow)
        self.menubar.setObjectName(u"menubar")
        self.menubar.setGeometry(QRect(0, 0, 1234, 21))
        self.menuFile = QMenu(self.menubar)
        self.menuFile.setObjectName(u"menuFile")
        self.menuConnection = QMenu(self.menubar)
        self.menuConnection.setObjectName(u"menuConnection")
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QStatusBar(MainWindow)
        self.statusbar.setObjectName(u"statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.menubar.addAction(self.menuFile.menuAction())
        self.menubar.addAction(self.menuConnection.menuAction())
        self.menuFile.addAction(self.action_Exit)
        self.menuConnection.addAction(self.actionConnect)
        self.menuConnection.addAction(self.actionSettings)

        self.retranslateUi(MainWindow)

        self.tabWidget.setCurrentIndex(0)


        QMetaObject.connectSlotsByName(MainWindow)
    # setupUi

    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QCoreApplication.translate("MainWindow", u"MainWindow", None))
        self.actionConnect.setText(QCoreApplication.translate("MainWindow", u"&Connect", None))
        self.actionSettings.setText(QCoreApplication.translate("MainWindow", u"&Settings", None))
        self.actionSettings_2.setText(QCoreApplication.translate("MainWindow", u"Settings", None))
        self.action_Exit.setText(QCoreApplication.translate("MainWindow", u"&Exit", None))
        self.connectPushButton.setText(QCoreApplication.translate("MainWindow", u"Connect", None))
        self.disconnectPushButton.setText(QCoreApplication.translate("MainWindow", u"Disconnect", None))
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.summaryTab), QCoreApplication.translate("MainWindow", u"Connection Summary", None))
        self.label_3.setText(QCoreApplication.translate("MainWindow", u"PIDs supported by this vehicle", None))
        self.label_4.setText(QCoreApplication.translate("MainWindow", u"Select which PIDs you which to have requested.\n"
"The more PIDs you select, the slower they will update.", None))
        self.pidSelectAllPushButton.setText(QCoreApplication.translate("MainWindow", u"Select All", None))
        self.pidSelectNonePushButton.setText(QCoreApplication.translate("MainWindow", u"Select None", None))
        self.pidSelectSavePushButton.setText(QCoreApplication.translate("MainWindow", u"Save", None))
        self.readPidsPushButton.setText(QCoreApplication.translate("MainWindow", u"Read Pids", None))
        self.cancelReadPidsPushButton.setText(QCoreApplication.translate("MainWindow", u"Cancel Read", None))
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.supportedPidsTab), QCoreApplication.translate("MainWindow", u"Supported Pids", None))
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.gaugesTab), QCoreApplication.translate("MainWindow", u"Gauges", None))
        self.graphZoomCheckBox.setText(QCoreApplication.translate("MainWindow", u"Zoom all data", None))
        self.graphScrollCheckBox.setText(QCoreApplication.translate("MainWindow", u"Scroll with data", None))
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.graphsTab), QCoreApplication.translate("MainWindow", u"Graphs", None))
        self.readReadinessPushButton.setText(QCoreApplication.translate("MainWindow", u"Read", None))
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.readinessTab), QCoreApplication.translate("MainWindow", u"Readiness Status", None))
        self.monitorPushButton.setText(QCoreApplication.translate("MainWindow", u"Read Monitors", None))
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.onBoardMonitoringTab), QCoreApplication.translate("MainWindow", u"On Board Monitoring", None))
        self.canMonitorStartPushButton.setText(QCoreApplication.translate("MainWindow", u"Start Monitor", None))
        self.canMonitorStopPushButton.setText(QCoreApplication.translate("MainWindow", u"Stop Monitor", None))
        self.canMsgLabel.setText(QCoreApplication.translate("MainWindow", u"Messages: 0", None))
        self.label_10.setText(QCoreApplication.translate("MainWindow", u"Style", None))
        self.label_11.setText(QCoreApplication.translate("MainWindow", u"Protocol", None))
        self.label_12.setText(QCoreApplication.translate("MainWindow", u"Load Log", None))
        self.canLoadLogFileBrowseButton.setText(QCoreApplication.translate("MainWindow", u"Browse", None))
        self.canLoadLogPushButton.setText(QCoreApplication.translate("MainWindow", u"Load", None))
        self.label_8.setText(QCoreApplication.translate("MainWindow", u"Save Log", None))
        self.canSaveLogFileBrowseButton.setText(QCoreApplication.translate("MainWindow", u"Browse", None))
        self.canClearRedPushButton.setText(QCoreApplication.translate("MainWindow", u"Clear Change Color", None))
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.tab), QCoreApplication.translate("MainWindow", u"CAN Messaging", None))
        self.groupBox.setTitle(QCoreApplication.translate("MainWindow", u"Format", None))
        self.radioButton_2.setText(QCoreApplication.translate("MainWindow", u"JSON", None))
        self.radioButton.setText(QCoreApplication.translate("MainWindow", u"obdgpslogger sqlite", None))
        self.radioButton_3.setText(QCoreApplication.translate("MainWindow", u"csv", None))
        self.groupBox_2.setTitle(QCoreApplication.translate("MainWindow", u"Location", None))
        self.label_9.setText(QCoreApplication.translate("MainWindow", u"Folder", None))
        self.datalogBrowsePushButton.setText(QCoreApplication.translate("MainWindow", u"Browse", None))
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.tab_2), QCoreApplication.translate("MainWindow", u"Datalogging", None))
        self.label_6.setText(QCoreApplication.translate("MainWindow", u"Mode $03 Stored Diagnostic Trouble Codes", None))
        self.label_5.setText(QCoreApplication.translate("MainWindow", u"Mode $07 Pending Diagnostic Trouble Codes", None))
        self.troubleReadPushButton.setText(QCoreApplication.translate("MainWindow", u"Read", None))
        self.troubleClearPushButton.setText(QCoreApplication.translate("MainWindow", u"Clear", None))
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.troubleCodesTab), QCoreApplication.translate("MainWindow", u"Trouble Codes", None))
        self.label_2.setText(QCoreApplication.translate("MainWindow", u"Debug Output", None))
        self.label_7.setText(QCoreApplication.translate("MainWindow", u"Lines of History", None))
        self.label.setText(QCoreApplication.translate("MainWindow", u"Raw Console", None))
        self.consoleSendPushButton.setText(QCoreApplication.translate("MainWindow", u"Send", None))
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.consoleTab), QCoreApplication.translate("MainWindow", u"Console", None))
        self.status_comPortLabel.setText(QCoreApplication.translate("MainWindow", u"Com Port: None", None))
        self.status_comBaudLabel.setText(QCoreApplication.translate("MainWindow", u"Baud: None", None))
        self.status_comStatusLabel.setText(QCoreApplication.translate("MainWindow", u"Status: Disconnected", None))
        self.status_comInterfaceLabel.setText(QCoreApplication.translate("MainWindow", u"Interface: None", None))
        self.status_comProtocolLabel.setText(QCoreApplication.translate("MainWindow", u"Protocol: None", None))
        self.status_pidUpdateRateLabel.setText(QCoreApplication.translate("MainWindow", u"Pid Rate: 0", None))
        self.menuFile.setTitle(QCoreApplication.translate("MainWindow", u"&File", None))
        self.menuConnection.setTitle(QCoreApplication.translate("MainWindow", u"&Connection", None))
    # retranslateUi

