# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'receiverselectordialog.ui'
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
from PySide6.QtWidgets import (QAbstractItemView, QApplication, QDialog, QHBoxLayout,
    QLabel, QListView, QPushButton, QSizePolicy,
    QSpacerItem, QVBoxLayout, QWidget)
import res_rc

class Ui_ReceiverSelectorDialog(object):
    def setupUi(self, ReceiverSelectorDialog):
        if not ReceiverSelectorDialog.objectName():
            ReceiverSelectorDialog.setObjectName(u"ReceiverSelectorDialog")
        ReceiverSelectorDialog.resize(380, 300)
        sizePolicy = QSizePolicy(QSizePolicy.Policy.Fixed, QSizePolicy.Policy.Fixed)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(ReceiverSelectorDialog.sizePolicy().hasHeightForWidth())
        ReceiverSelectorDialog.setSizePolicy(sizePolicy)
        ReceiverSelectorDialog.setMinimumSize(QSize(380, 300))
        ReceiverSelectorDialog.setMaximumSize(QSize(380, 300))
        icon = QIcon()
        icon.addFile(u":/img/icon.png", QSize(), QIcon.Mode.Normal, QIcon.State.Off)
        ReceiverSelectorDialog.setWindowIcon(icon)
        self.verticalLayout = QVBoxLayout(ReceiverSelectorDialog)
        self.verticalLayout.setObjectName(u"verticalLayout")
        self.horizontalLayout_2 = QHBoxLayout()
        self.horizontalLayout_2.setObjectName(u"horizontalLayout_2")
        self.label = QLabel(ReceiverSelectorDialog)
        self.label.setObjectName(u"label")

        self.horizontalLayout_2.addWidget(self.label)

        self.horizontalSpacer_2 = QSpacerItem(40, 20, QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Minimum)

        self.horizontalLayout_2.addItem(self.horizontalSpacer_2)

        self.pushButton_3 = QPushButton(ReceiverSelectorDialog)
        self.pushButton_3.setObjectName(u"pushButton_3")
        icon1 = QIcon()
        icon1.addFile(u":/img/refresh.png", QSize(), QIcon.Mode.Normal, QIcon.State.Off)
        self.pushButton_3.setIcon(icon1)
        self.pushButton_3.setIconSize(QSize(18, 18))
        self.pushButton_3.setFlat(True)

        self.horizontalLayout_2.addWidget(self.pushButton_3)


        self.verticalLayout.addLayout(self.horizontalLayout_2)

        self.listView = QListView(ReceiverSelectorDialog)
        self.listView.setObjectName(u"listView")
        self.listView.setSelectionMode(QAbstractItemView.ExtendedSelection)

        self.verticalLayout.addWidget(self.listView)

        self.label_multicast = QLabel(ReceiverSelectorDialog)
        self.label_multicast.setObjectName(u"label_multicast")
        font = QFont()
        font.setItalic(True)
        self.label_multicast.setFont(font)
        self.label_multicast.setWordWrap(True)

        self.verticalLayout.addWidget(self.label_multicast)

        self.horizontalLayout = QHBoxLayout()
        self.horizontalLayout.setObjectName(u"horizontalLayout")
        self.horizontalSpacer = QSpacerItem(40, 20, QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Minimum)

        self.horizontalLayout.addItem(self.horizontalSpacer)

        self.pushButton_2 = QPushButton(ReceiverSelectorDialog)
        self.pushButton_2.setObjectName(u"pushButton_2")

        self.horizontalLayout.addWidget(self.pushButton_2)

        self.pushButton = QPushButton(ReceiverSelectorDialog)
        self.pushButton.setObjectName(u"pushButton")

        self.horizontalLayout.addWidget(self.pushButton)


        self.verticalLayout.addLayout(self.horizontalLayout)


        self.retranslateUi(ReceiverSelectorDialog)
        self.pushButton_2.clicked.connect(ReceiverSelectorDialog.reject)
        self.pushButton.clicked.connect(ReceiverSelectorDialog.onSendClicked)
        self.pushButton_3.clicked.connect(ReceiverSelectorDialog.onRefreshClicked)

        self.pushButton.setDefault(True)


        QMetaObject.connectSlotsByName(ReceiverSelectorDialog)
    # setupUi

    def retranslateUi(self, ReceiverSelectorDialog):
        ReceiverSelectorDialog.setWindowTitle(QCoreApplication.translate("ReceiverSelectorDialog", u"Select Receiver", None))
        self.label.setText(QCoreApplication.translate("ReceiverSelectorDialog", u"Select receiver", None))
#if QT_CONFIG(tooltip)
        self.pushButton_3.setToolTip(QCoreApplication.translate("ReceiverSelectorDialog", u"Refresh list", None))
#endif // QT_CONFIG(tooltip)
        self.pushButton_3.setText("")
#if QT_CONFIG(tooltip)
        self.listView.setToolTip(QCoreApplication.translate("ReceiverSelectorDialog", u"You can select multiple receivers", None))
#endif // QT_CONFIG(tooltip)
        self.label_multicast.setText(QCoreApplication.translate("ReceiverSelectorDialog", u"Note: it is possible to select multiple receivers for multicast using Ctrl+MouseClick or Ctrl+A", None))
        self.pushButton_2.setText(QCoreApplication.translate("ReceiverSelectorDialog", u"Cancel", None))
        self.pushButton.setText(QCoreApplication.translate("ReceiverSelectorDialog", u"Send", None))
    # retranslateUi

