# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'aboutdialog.ui'
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
from PySide6.QtWidgets import (QApplication, QDialog, QFrame, QHBoxLayout,
    QLabel, QPushButton, QSizePolicy, QSpacerItem,
    QTextEdit, QVBoxLayout, QWidget)
import res_rc

class Ui_AboutDialog(object):
    def setupUi(self, AboutDialog):
        if not AboutDialog.objectName():
            AboutDialog.setObjectName(u"AboutDialog")
        AboutDialog.resize(480, 350)
        sizePolicy = QSizePolicy(QSizePolicy.Policy.Preferred, QSizePolicy.Policy.Preferred)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(AboutDialog.sizePolicy().hasHeightForWidth())
        AboutDialog.setSizePolicy(sizePolicy)
        AboutDialog.setMinimumSize(QSize(480, 350))
        AboutDialog.setMaximumSize(QSize(480, 350))
        icon = QIcon()
        icon.addFile(u":/img/about.png", QSize(), QIcon.Mode.Normal, QIcon.State.Off)
        AboutDialog.setWindowIcon(icon)
        self.verticalLayout_2 = QVBoxLayout(AboutDialog)
        self.verticalLayout_2.setObjectName(u"verticalLayout_2")
        self.label_3 = QLabel(AboutDialog)
        self.label_3.setObjectName(u"label_3")
        self.label_3.setMinimumSize(QSize(0, 0))
        self.label_3.setMaximumSize(QSize(16777215, 16777215))
        self.label_3.setPixmap(QPixmap(u":/img/icon.png"))
        self.label_3.setScaledContents(False)
        self.label_3.setAlignment(Qt.AlignCenter)

        self.verticalLayout_2.addWidget(self.label_3)

        self.programNameLbl = QLabel(AboutDialog)
        self.programNameLbl.setObjectName(u"programNameLbl")
        self.programNameLbl.setStyleSheet(u"font-weight: bold")
        self.programNameLbl.setAlignment(Qt.AlignCenter)
        self.programNameLbl.setWordWrap(True)

        self.verticalLayout_2.addWidget(self.programNameLbl)

        self.textContent = QWidget(AboutDialog)
        self.textContent.setObjectName(u"textContent")
        self.verticalLayout = QVBoxLayout(self.textContent)
        self.verticalLayout.setObjectName(u"verticalLayout")
        self.verticalLayout.setContentsMargins(0, 9, 0, -1)
        self.programVersionLbl = QLabel(self.textContent)
        self.programVersionLbl.setObjectName(u"programVersionLbl")
        self.programVersionLbl.setStyleSheet(u"color: rgb(31, 31, 31);")
        self.programVersionLbl.setAlignment(Qt.AlignCenter)
        self.programVersionLbl.setWordWrap(True)

        self.verticalLayout.addWidget(self.programVersionLbl)

        self.programDescLbl = QLabel(self.textContent)
        self.programDescLbl.setObjectName(u"programDescLbl")
        self.programDescLbl.setStyleSheet(u"color: rgb(31, 31, 31);")
        self.programDescLbl.setAlignment(Qt.AlignCenter)
        self.programDescLbl.setWordWrap(True)

        self.verticalLayout.addWidget(self.programDescLbl)

        self.verticalSpacer = QSpacerItem(20, 40, QSizePolicy.Policy.Minimum, QSizePolicy.Policy.Expanding)

        self.verticalLayout.addItem(self.verticalSpacer)

        self.line = QFrame(self.textContent)
        self.line.setObjectName(u"line")
        self.line.setFrameShape(QFrame.Shape.HLine)
        self.line.setFrameShadow(QFrame.Shadow.Sunken)

        self.verticalLayout.addWidget(self.line)

        self.label_2 = QLabel(self.textContent)
        self.label_2.setObjectName(u"label_2")
        self.label_2.setAlignment(Qt.AlignCenter)

        self.verticalLayout.addWidget(self.label_2)


        self.verticalLayout_2.addWidget(self.textContent)

        self.textEdit = QTextEdit(AboutDialog)
        self.textEdit.setObjectName(u"textEdit")
        self.textEdit.setStyleSheet(u"font: 8pt \"Sans\";")
        self.textEdit.setReadOnly(True)
        self.textEdit.setTextInteractionFlags(Qt.LinksAccessibleByKeyboard|Qt.LinksAccessibleByMouse|Qt.TextBrowserInteraction|Qt.TextSelectableByKeyboard|Qt.TextSelectableByMouse)

        self.verticalLayout_2.addWidget(self.textEdit)

        self.horizontalLayout = QHBoxLayout()
        self.horizontalLayout.setSpacing(6)
        self.horizontalLayout.setObjectName(u"horizontalLayout")
        self.creditBtn = QPushButton(AboutDialog)
        self.creditBtn.setObjectName(u"creditBtn")
        self.creditBtn.setCheckable(True)
        self.creditBtn.setAutoDefault(False)

        self.horizontalLayout.addWidget(self.creditBtn)

        self.licenseBtn = QPushButton(AboutDialog)
        self.licenseBtn.setObjectName(u"licenseBtn")
        self.licenseBtn.setCheckable(True)
        self.licenseBtn.setAutoDefault(False)

        self.horizontalLayout.addWidget(self.licenseBtn)

        self.horizontalSpacer = QSpacerItem(40, 20, QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Minimum)

        self.horizontalLayout.addItem(self.horizontalSpacer)

        self.pushButton_3 = QPushButton(AboutDialog)
        self.pushButton_3.setObjectName(u"pushButton_3")
        self.pushButton_3.setMinimumSize(QSize(70, 0))
        self.pushButton_3.setMaximumSize(QSize(16777215, 16777215))

        self.horizontalLayout.addWidget(self.pushButton_3)


        self.verticalLayout_2.addLayout(self.horizontalLayout)


        self.retranslateUi(AboutDialog)
        self.pushButton_3.clicked.connect(AboutDialog.accept)
        self.creditBtn.clicked["bool"].connect(AboutDialog.onCreditsClicked)
        self.licenseBtn.clicked["bool"].connect(AboutDialog.onLicenseClicked)

        QMetaObject.connectSlotsByName(AboutDialog)
    # setupUi

    def retranslateUi(self, AboutDialog):
        AboutDialog.setWindowTitle(QCoreApplication.translate("AboutDialog", u"About", None))
        self.label_3.setText("")
        self.programNameLbl.setText(QCoreApplication.translate("AboutDialog", u"TextLabel", None))
        self.programVersionLbl.setText(QCoreApplication.translate("AboutDialog", u"TextLabel", None))
        self.programDescLbl.setText(QCoreApplication.translate("AboutDialog", u"TextLabel", None))
        self.label_2.setText(QCoreApplication.translate("AboutDialog", u"<html><head/><body><p><span style=\" font-size:8pt; color:#2b2b2b;\">Copyright (c) 2016, Abdul Aris R.</span></p></body></html>", None))
        self.creditBtn.setText(QCoreApplication.translate("AboutDialog", u"Credits", None))
        self.licenseBtn.setText(QCoreApplication.translate("AboutDialog", u"License", None))
        self.pushButton_3.setText(QCoreApplication.translate("AboutDialog", u"Close", None))
    # retranslateUi

