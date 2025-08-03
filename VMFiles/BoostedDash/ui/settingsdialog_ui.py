# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'settingsdialog.ui'
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
from PySide6.QtWidgets import (QApplication, QCheckBox, QDialog, QGridLayout,
    QGroupBox, QHBoxLayout, QLabel, QLineEdit,
    QPushButton, QSizePolicy, QSpacerItem, QSpinBox,
    QTabWidget, QVBoxLayout, QWidget)
import res_rc

class Ui_SettingsDialog(object):
    def setupUi(self, SettingsDialog):
        if not SettingsDialog.objectName():
            SettingsDialog.setObjectName(u"SettingsDialog")
        SettingsDialog.resize(450, 470)
        SettingsDialog.setMinimumSize(QSize(450, 470))
        SettingsDialog.setMaximumSize(QSize(450, 470))
        icon = QIcon()
        icon.addFile(u":/img/settings.png", QSize(), QIcon.Mode.Normal, QIcon.State.Off)
        SettingsDialog.setWindowIcon(icon)
        self.verticalLayout_6 = QVBoxLayout(SettingsDialog)
        self.verticalLayout_6.setObjectName(u"verticalLayout_6")
        self.tabWidget = QTabWidget(SettingsDialog)
        self.tabWidget.setObjectName(u"tabWidget")
        self.tab = QWidget()
        self.tab.setObjectName(u"tab")
        self.verticalLayout_4 = QVBoxLayout(self.tab)
        self.verticalLayout_4.setObjectName(u"verticalLayout_4")
        self.groupBox = QGroupBox(self.tab)
        self.groupBox.setObjectName(u"groupBox")
        self.verticalLayout = QVBoxLayout(self.groupBox)
        self.verticalLayout.setObjectName(u"verticalLayout")
        self.gridLayout = QGridLayout()
        self.gridLayout.setObjectName(u"gridLayout")
        self.label = QLabel(self.groupBox)
        self.label.setObjectName(u"label")
        self.label.setAlignment(Qt.AlignLeading|Qt.AlignLeft|Qt.AlignVCenter)

        self.gridLayout.addWidget(self.label, 0, 0, 1, 1)

        self.deviceIdLabel = QLabel(self.groupBox)
        self.deviceIdLabel.setObjectName(u"deviceIdLabel")
        self.deviceIdLabel.setMinimumSize(QSize(0, 22))
        self.deviceIdLabel.setStyleSheet(u"")
        self.deviceIdLabel.setWordWrap(True)

        self.gridLayout.addWidget(self.deviceIdLabel, 0, 1, 1, 1)

        self.label_2 = QLabel(self.groupBox)
        self.label_2.setObjectName(u"label_2")
        self.label_2.setAlignment(Qt.AlignLeading|Qt.AlignLeft|Qt.AlignVCenter)

        self.gridLayout.addWidget(self.label_2, 1, 0, 1, 1)

        self.ipAddrLabel = QLabel(self.groupBox)
        self.ipAddrLabel.setObjectName(u"ipAddrLabel")
        self.ipAddrLabel.setMinimumSize(QSize(0, 22))
        self.ipAddrLabel.setStyleSheet(u"")

        self.gridLayout.addWidget(self.ipAddrLabel, 1, 1, 1, 1)

        self.horizontalLayout_4 = QHBoxLayout()
        self.horizontalLayout_4.setObjectName(u"horizontalLayout_4")
        self.deviceNameLineEdit = QLineEdit(self.groupBox)
        self.deviceNameLineEdit.setObjectName(u"deviceNameLineEdit")
        self.deviceNameLineEdit.setMinimumSize(QSize(230, 0))
        self.deviceNameLineEdit.setMaxLength(30)

        self.horizontalLayout_4.addWidget(self.deviceNameLineEdit)

        self.horizontalSpacer_3 = QSpacerItem(40, 20, QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Minimum)

        self.horizontalLayout_4.addItem(self.horizontalSpacer_3)


        self.gridLayout.addLayout(self.horizontalLayout_4, 3, 1, 1, 1)

        self.osNameLabel = QLabel(self.groupBox)
        self.osNameLabel.setObjectName(u"osNameLabel")
        sizePolicy = QSizePolicy(QSizePolicy.Policy.Preferred, QSizePolicy.Policy.Preferred)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(self.osNameLabel.sizePolicy().hasHeightForWidth())
        self.osNameLabel.setSizePolicy(sizePolicy)
        self.osNameLabel.setMinimumSize(QSize(0, 22))

        self.gridLayout.addWidget(self.osNameLabel, 2, 1, 1, 1)

        self.label_9 = QLabel(self.groupBox)
        self.label_9.setObjectName(u"label_9")
        self.label_9.setAlignment(Qt.AlignLeading|Qt.AlignLeft|Qt.AlignVCenter)

        self.gridLayout.addWidget(self.label_9, 2, 0, 1, 1)

        self.label_3 = QLabel(self.groupBox)
        self.label_3.setObjectName(u"label_3")
        self.label_3.setAlignment(Qt.AlignLeading|Qt.AlignLeft|Qt.AlignVCenter)

        self.gridLayout.addWidget(self.label_3, 3, 0, 1, 1)


        self.verticalLayout.addLayout(self.gridLayout)


        self.verticalLayout_4.addWidget(self.groupBox)

        self.groupBox_2 = QGroupBox(self.tab)
        self.groupBox_2.setObjectName(u"groupBox_2")
        self.verticalLayout_2 = QVBoxLayout(self.groupBox_2)
        self.verticalLayout_2.setObjectName(u"verticalLayout_2")
        self.horizontalLayout_3 = QHBoxLayout()
        self.horizontalLayout_3.setObjectName(u"horizontalLayout_3")
        self.label_4 = QLabel(self.groupBox_2)
        self.label_4.setObjectName(u"label_4")

        self.horizontalLayout_3.addWidget(self.label_4)

        self.downDirlineEdit = QLineEdit(self.groupBox_2)
        self.downDirlineEdit.setObjectName(u"downDirlineEdit")

        self.horizontalLayout_3.addWidget(self.downDirlineEdit)

        self.selectDirBtn = QPushButton(self.groupBox_2)
        self.selectDirBtn.setObjectName(u"selectDirBtn")
        sizePolicy1 = QSizePolicy(QSizePolicy.Policy.Fixed, QSizePolicy.Policy.Fixed)
        sizePolicy1.setHorizontalStretch(0)
        sizePolicy1.setVerticalStretch(0)
        sizePolicy1.setHeightForWidth(self.selectDirBtn.sizePolicy().hasHeightForWidth())
        self.selectDirBtn.setSizePolicy(sizePolicy1)
        self.selectDirBtn.setMinimumSize(QSize(28, 0))
        self.selectDirBtn.setMaximumSize(QSize(28, 16777215))

        self.horizontalLayout_3.addWidget(self.selectDirBtn)


        self.verticalLayout_2.addLayout(self.horizontalLayout_3)


        self.verticalLayout_4.addWidget(self.groupBox_2)

        self.groupBox_3 = QGroupBox(self.tab)
        self.groupBox_3.setObjectName(u"groupBox_3")
        self.groupBox_3.setEnabled(True)
        self.verticalLayout_3 = QVBoxLayout(self.groupBox_3)
        self.verticalLayout_3.setObjectName(u"verticalLayout_3")
        self.overwriteCheckBox = QCheckBox(self.groupBox_3)
        self.overwriteCheckBox.setObjectName(u"overwriteCheckBox")
        self.overwriteCheckBox.setEnabled(True)

        self.verticalLayout_3.addWidget(self.overwriteCheckBox)

        self.horizontalLayout_5 = QHBoxLayout()
        self.horizontalLayout_5.setObjectName(u"horizontalLayout_5")
        self.label_10 = QLabel(self.groupBox_3)
        self.label_10.setObjectName(u"label_10")
        self.label_10.setEnabled(False)

        self.horizontalLayout_5.addWidget(self.label_10)

        self.spinBox = QSpinBox(self.groupBox_3)
        self.spinBox.setObjectName(u"spinBox")
        self.spinBox.setEnabled(False)
        self.spinBox.setMinimum(1)
        self.spinBox.setMaximum(100)

        self.horizontalLayout_5.addWidget(self.spinBox)

        self.horizontalSpacer_4 = QSpacerItem(40, 20, QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Minimum)

        self.horizontalLayout_5.addItem(self.horizontalSpacer_4)


        self.verticalLayout_3.addLayout(self.horizontalLayout_5)


        self.verticalLayout_4.addWidget(self.groupBox_3)

        self.verticalSpacer_2 = QSpacerItem(20, 47, QSizePolicy.Policy.Minimum, QSizePolicy.Policy.Expanding)

        self.verticalLayout_4.addItem(self.verticalSpacer_2)

        self.tabWidget.addTab(self.tab, "")
        self.tab_2 = QWidget()
        self.tab_2.setObjectName(u"tab_2")
        self.verticalLayout_7 = QVBoxLayout(self.tab_2)
        self.verticalLayout_7.setObjectName(u"verticalLayout_7")
        self.groupBox_4 = QGroupBox(self.tab_2)
        self.groupBox_4.setObjectName(u"groupBox_4")
        self.verticalLayout_5 = QVBoxLayout(self.groupBox_4)
        self.verticalLayout_5.setObjectName(u"verticalLayout_5")
        self.horizontalLayout = QHBoxLayout()
        self.horizontalLayout.setObjectName(u"horizontalLayout")
        self.gridLayout_2 = QGridLayout()
        self.gridLayout_2.setObjectName(u"gridLayout_2")
        self.label_6 = QLabel(self.groupBox_4)
        self.label_6.setObjectName(u"label_6")
        self.label_6.setAlignment(Qt.AlignLeading|Qt.AlignLeft|Qt.AlignVCenter)

        self.gridLayout_2.addWidget(self.label_6, 0, 0, 1, 1)

        self.bcPortSpinBox = QSpinBox(self.groupBox_4)
        self.bcPortSpinBox.setObjectName(u"bcPortSpinBox")
        self.bcPortSpinBox.setMaximum(65535)

        self.gridLayout_2.addWidget(self.bcPortSpinBox, 0, 1, 1, 1)

        self.label_5 = QLabel(self.groupBox_4)
        self.label_5.setObjectName(u"label_5")
        self.label_5.setAlignment(Qt.AlignLeading|Qt.AlignLeft|Qt.AlignVCenter)

        self.gridLayout_2.addWidget(self.label_5, 1, 0, 1, 1)

        self.bcIntervalSpinBox = QSpinBox(self.groupBox_4)
        self.bcIntervalSpinBox.setObjectName(u"bcIntervalSpinBox")
        self.bcIntervalSpinBox.setMinimum(1000)
        self.bcIntervalSpinBox.setMaximum(20000)
        self.bcIntervalSpinBox.setSingleStep(50)

        self.gridLayout_2.addWidget(self.bcIntervalSpinBox, 1, 1, 1, 1)


        self.horizontalLayout.addLayout(self.gridLayout_2)

        self.horizontalSpacer_2 = QSpacerItem(40, 20, QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Minimum)

        self.horizontalLayout.addItem(self.horizontalSpacer_2)


        self.verticalLayout_5.addLayout(self.horizontalLayout)


        self.verticalLayout_7.addWidget(self.groupBox_4)

        self.groupBox_5 = QGroupBox(self.tab_2)
        self.groupBox_5.setObjectName(u"groupBox_5")
        self.verticalLayout_8 = QVBoxLayout(self.groupBox_5)
        self.verticalLayout_8.setObjectName(u"verticalLayout_8")
        self.horizontalLayout_7 = QHBoxLayout()
        self.horizontalLayout_7.setObjectName(u"horizontalLayout_7")
        self.label_7 = QLabel(self.groupBox_5)
        self.label_7.setObjectName(u"label_7")
        self.label_7.setAlignment(Qt.AlignLeading|Qt.AlignLeft|Qt.AlignVCenter)

        self.horizontalLayout_7.addWidget(self.label_7)

        self.transferPortSpinBox = QSpinBox(self.groupBox_5)
        self.transferPortSpinBox.setObjectName(u"transferPortSpinBox")
        self.transferPortSpinBox.setMaximum(65535)

        self.horizontalLayout_7.addWidget(self.transferPortSpinBox)

        self.horizontalSpacer_6 = QSpacerItem(40, 20, QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Minimum)

        self.horizontalLayout_7.addItem(self.horizontalSpacer_6)


        self.verticalLayout_8.addLayout(self.horizontalLayout_7)

        self.horizontalLayout_6 = QHBoxLayout()
        self.horizontalLayout_6.setObjectName(u"horizontalLayout_6")
        self.label_8 = QLabel(self.groupBox_5)
        self.label_8.setObjectName(u"label_8")
        self.label_8.setAlignment(Qt.AlignLeading|Qt.AlignLeft|Qt.AlignVCenter)

        self.horizontalLayout_6.addWidget(self.label_8)

        self.buffSizeSpinBox = QSpinBox(self.groupBox_5)
        self.buffSizeSpinBox.setObjectName(u"buffSizeSpinBox")
        self.buffSizeSpinBox.setMinimum(8)
        self.buffSizeSpinBox.setMaximum(1024)

        self.horizontalLayout_6.addWidget(self.buffSizeSpinBox)

        self.horizontalSpacer_5 = QSpacerItem(40, 20, QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Minimum)

        self.horizontalLayout_6.addItem(self.horizontalSpacer_5)


        self.verticalLayout_8.addLayout(self.horizontalLayout_6)


        self.verticalLayout_7.addWidget(self.groupBox_5)

        self.verticalSpacer_3 = QSpacerItem(20, 167, QSizePolicy.Policy.Minimum, QSizePolicy.Policy.Expanding)

        self.verticalLayout_7.addItem(self.verticalSpacer_3)

        self.tabWidget.addTab(self.tab_2, "")

        self.verticalLayout_6.addWidget(self.tabWidget)

        self.horizontalLayout_2 = QHBoxLayout()
        self.horizontalLayout_2.setObjectName(u"horizontalLayout_2")
        self.pushButton_3 = QPushButton(SettingsDialog)
        self.pushButton_3.setObjectName(u"pushButton_3")

        self.horizontalLayout_2.addWidget(self.pushButton_3)

        self.horizontalSpacer = QSpacerItem(40, 20, QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Minimum)

        self.horizontalLayout_2.addItem(self.horizontalSpacer)

        self.pushButton_2 = QPushButton(SettingsDialog)
        self.pushButton_2.setObjectName(u"pushButton_2")

        self.horizontalLayout_2.addWidget(self.pushButton_2)

        self.pushButton = QPushButton(SettingsDialog)
        self.pushButton.setObjectName(u"pushButton")

        self.horizontalLayout_2.addWidget(self.pushButton)


        self.verticalLayout_6.addLayout(self.horizontalLayout_2)


        self.retranslateUi(SettingsDialog)
        self.pushButton_2.clicked.connect(SettingsDialog.onCancelClicked)
        self.pushButton.clicked.connect(SettingsDialog.onSaveClicked)
        self.pushButton_3.clicked.connect(SettingsDialog.onResetClicked)
        self.selectDirBtn.clicked.connect(SettingsDialog.onSelectDownDirClicked)

        self.tabWidget.setCurrentIndex(0)
        self.pushButton.setDefault(True)


        QMetaObject.connectSlotsByName(SettingsDialog)
    # setupUi

    def retranslateUi(self, SettingsDialog):
        SettingsDialog.setWindowTitle(QCoreApplication.translate("SettingsDialog", u"Settings", None))
        self.groupBox.setTitle(QCoreApplication.translate("SettingsDialog", u"Profile", None))
        self.label.setText(QCoreApplication.translate("SettingsDialog", u"Id:", None))
        self.deviceIdLabel.setText(QCoreApplication.translate("SettingsDialog", u"-", None))
        self.label_2.setText(QCoreApplication.translate("SettingsDialog", u"Ip Address:", None))
        self.ipAddrLabel.setText(QCoreApplication.translate("SettingsDialog", u"-", None))
        self.deviceNameLineEdit.setText("")
        self.osNameLabel.setText(QCoreApplication.translate("SettingsDialog", u"-", None))
        self.label_9.setText(QCoreApplication.translate("SettingsDialog", u"OS Name:", None))
        self.label_3.setText(QCoreApplication.translate("SettingsDialog", u"Name:", None))
        self.groupBox_2.setTitle(QCoreApplication.translate("SettingsDialog", u"Directory", None))
        self.label_4.setText(QCoreApplication.translate("SettingsDialog", u"Download Dir:", None))
        self.selectDirBtn.setText(QCoreApplication.translate("SettingsDialog", u"...", None))
        self.groupBox_3.setTitle(QCoreApplication.translate("SettingsDialog", u"Behavior", None))
        self.overwriteCheckBox.setText(QCoreApplication.translate("SettingsDialog", u"Overwrite existing file", None))
        self.label_10.setText(QCoreApplication.translate("SettingsDialog", u"Max. Current Transfers:", None))
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.tab), QCoreApplication.translate("SettingsDialog", u"General", None))
        self.groupBox_4.setTitle(QCoreApplication.translate("SettingsDialog", u"Broadcast", None))
        self.label_6.setText(QCoreApplication.translate("SettingsDialog", u"Broadcast Port:", None))
        self.label_5.setText(QCoreApplication.translate("SettingsDialog", u"Broadcast Interval:", None))
        self.bcIntervalSpinBox.setSuffix(QCoreApplication.translate("SettingsDialog", u" ms", None))
        self.groupBox_5.setTitle(QCoreApplication.translate("SettingsDialog", u"Transfer", None))
        self.label_7.setText(QCoreApplication.translate("SettingsDialog", u"Transfer Port:", None))
        self.label_8.setText(QCoreApplication.translate("SettingsDialog", u"Buffer Size:", None))
        self.buffSizeSpinBox.setSuffix(QCoreApplication.translate("SettingsDialog", u" KB", None))
        self.buffSizeSpinBox.setPrefix("")
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.tab_2), QCoreApplication.translate("SettingsDialog", u"Network", None))
        self.pushButton_3.setText(QCoreApplication.translate("SettingsDialog", u"Reset", None))
        self.pushButton_2.setText(QCoreApplication.translate("SettingsDialog", u"Cancel", None))
        self.pushButton.setText(QCoreApplication.translate("SettingsDialog", u"Save", None))
    # retranslateUi

