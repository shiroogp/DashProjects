/********************************************************************************
** Form generated from reading UI file 'btconnector.ui'
**
** Created by: Qt User Interface Compiler version 5.11.4
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_BTCONNECTOR_H
#define UI_BTCONNECTOR_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QGroupBox>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QListWidget>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QTextEdit>

QT_BEGIN_NAMESPACE

class Ui_BtConnector
{
public:
    QListWidget *listDevicesNearby;
    QLabel *label;
    QPushButton *buttonScan;
    QPushButton *buttonPair;
    QPushButton *buttonDisconnect;
    QPushButton *buttonRemoteDeviceInfo;
    QLabel *label_localDevice;
    QPushButton *buttonClose;
    QGroupBox *groupBox;
    QLabel *label_2;
    QLabel *label_3;
    QLineEdit *lineEdit_name;
    QLineEdit *lineEdit_address;
    QTextEdit *textEdit;
    QPushButton *buttonUnpair;
    QPushButton *buttonConnect;

    void setupUi(QDialog *BtConnector)
    {
        if (BtConnector->objectName().isEmpty())
            BtConnector->setObjectName(QStringLiteral("BtConnector"));
        BtConnector->resize(397, 395);
        listDevicesNearby = new QListWidget(BtConnector);
        listDevicesNearby->setObjectName(QStringLiteral("listDevicesNearby"));
        listDevicesNearby->setGeometry(QRect(10, 130, 256, 201));
        label = new QLabel(BtConnector);
        label->setObjectName(QStringLiteral("label"));
        label->setGeometry(QRect(10, 110, 161, 17));
        buttonScan = new QPushButton(BtConnector);
        buttonScan->setObjectName(QStringLiteral("buttonScan"));
        buttonScan->setGeometry(QRect(280, 130, 80, 25));
        buttonPair = new QPushButton(BtConnector);
        buttonPair->setObjectName(QStringLiteral("buttonPair"));
        buttonPair->setGeometry(QRect(280, 190, 80, 25));
        buttonDisconnect = new QPushButton(BtConnector);
        buttonDisconnect->setObjectName(QStringLiteral("buttonDisconnect"));
        buttonDisconnect->setGeometry(QRect(280, 310, 80, 25));
        buttonRemoteDeviceInfo = new QPushButton(BtConnector);
        buttonRemoteDeviceInfo->setObjectName(QStringLiteral("buttonRemoteDeviceInfo"));
        buttonRemoteDeviceInfo->setGeometry(QRect(280, 160, 80, 25));
        label_localDevice = new QLabel(BtConnector);
        label_localDevice->setObjectName(QStringLiteral("label_localDevice"));
        label_localDevice->setGeometry(QRect(10, 20, 381, 17));
        buttonClose = new QPushButton(BtConnector);
        buttonClose->setObjectName(QStringLiteral("buttonClose"));
        buttonClose->setGeometry(QRect(280, 360, 80, 25));
        groupBox = new QGroupBox(BtConnector);
        groupBox->setObjectName(QStringLiteral("groupBox"));
        groupBox->setGeometry(QRect(10, 10, 381, 91));
        label_2 = new QLabel(groupBox);
        label_2->setObjectName(QStringLiteral("label_2"));
        label_2->setGeometry(QRect(10, 30, 54, 17));
        label_3 = new QLabel(groupBox);
        label_3->setObjectName(QStringLiteral("label_3"));
        label_3->setGeometry(QRect(10, 50, 54, 17));
        lineEdit_name = new QLineEdit(groupBox);
        lineEdit_name->setObjectName(QStringLiteral("lineEdit_name"));
        lineEdit_name->setEnabled(false);
        lineEdit_name->setGeometry(QRect(80, 30, 113, 16));
        lineEdit_address = new QLineEdit(groupBox);
        lineEdit_address->setObjectName(QStringLiteral("lineEdit_address"));
        lineEdit_address->setEnabled(false);
        lineEdit_address->setGeometry(QRect(80, 50, 113, 16));
        textEdit = new QTextEdit(BtConnector);
        textEdit->setObjectName(QStringLiteral("textEdit"));
        textEdit->setGeometry(QRect(10, 340, 201, 41));
        buttonUnpair = new QPushButton(BtConnector);
        buttonUnpair->setObjectName(QStringLiteral("buttonUnpair"));
        buttonUnpair->setGeometry(QRect(280, 220, 80, 25));
        buttonConnect = new QPushButton(BtConnector);
        buttonConnect->setObjectName(QStringLiteral("buttonConnect"));
        buttonConnect->setGeometry(QRect(280, 280, 80, 25));

        retranslateUi(BtConnector);

        QMetaObject::connectSlotsByName(BtConnector);
    } // setupUi

    void retranslateUi(QDialog *BtConnector)
    {
        BtConnector->setWindowTitle(QApplication::translate("BtConnector", "Dialog", nullptr));
        label->setText(QApplication::translate("BtConnector", "Bluetooth devices nearby :", nullptr));
        buttonScan->setText(QApplication::translate("BtConnector", "Find", nullptr));
        buttonPair->setText(QApplication::translate("BtConnector", "Pair", nullptr));
        buttonDisconnect->setText(QApplication::translate("BtConnector", "Disconnnect", nullptr));
        buttonRemoteDeviceInfo->setText(QApplication::translate("BtConnector", "Device Info", nullptr));
        label_localDevice->setText(QString());
        buttonClose->setText(QApplication::translate("BtConnector", "Close", nullptr));
        groupBox->setTitle(QApplication::translate("BtConnector", "Local device info:", nullptr));
        label_2->setText(QApplication::translate("BtConnector", "Name :", nullptr));
        label_3->setText(QApplication::translate("BtConnector", "Address:", nullptr));
        buttonUnpair->setText(QApplication::translate("BtConnector", "Unpair", nullptr));
        buttonConnect->setText(QApplication::translate("BtConnector", "Connnect", nullptr));
    } // retranslateUi

};

namespace Ui {
    class BtConnector: public Ui_BtConnector {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_BTCONNECTOR_H
