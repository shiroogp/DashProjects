/********************************************************************************
** Form generated from reading UI file 'obdscanner.ui'
**
** Created by: Qt User Interface Compiler version 5.11.4
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_OBDSCANNER_H
#define UI_OBDSCANNER_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDial>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QFrame>
#include <QtWidgets/QLCDNumber>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenu>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QRadioButton>
#include <QtWidgets/QScrollArea>
#include <QtWidgets/QTabWidget>
#include <QtWidgets/QTextEdit>
#include <QtWidgets/QToolButton>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_OBDScanner
{
public:
    QAction *actionQuit;
    QWidget *centralWidget;
    QRadioButton *btRadioButton;
    QToolButton *btConfigButton;
    QLabel *label;
    QLabel *connectedDeviceName;
    QTabWidget *tabWidget;
    QWidget *rtd_tab;
    QDial *speed_dial;
    QLCDNumber *speedLcd;
    QLCDNumber *rpmLcd;
    QLabel *label_2;
    QLabel *label_3;
    QLabel *label_4;
    QLCDNumber *inTempLcd;
    QLabel *label_5;
    QLCDNumber *coolantLcd;
    QDial *coolant_dial;
    QDial *intake_dial;
    QDial *rpm_dial;
    QLabel *label_6;
    QLabel *label_7;
    QLabel *label_8;
    QLabel *label_9;
    QPushButton *rtd_startButton;
    QWidget *dtc_tab;
    QScrollArea *scrollArea;
    QWidget *scrollAreaWidgetContents;
    QPushButton *dtc_checkErrNumberButton;
    QPushButton *dtc_getErrCodesButton;
    QPushButton *dtc_clearErrors;
    QLineEdit *dtc_numberEdit;
    QLabel *label_10;
    QLabel *label_11;
    QTextEdit *dtc_descriptionEdit;
    QRadioButton *dtc_milIndicatorON;
    QFrame *dtc_confirmatioFrame;
    QDialogButtonBox *dtc_confirmationBox;
    QLabel *label_12;
    QWidget *cmd_tab;
    QPushButton *cmd_sendButton;
    QLineEdit *cmd_input;
    QTextEdit *cmd_console;
    QPushButton *cmd_clearButton;
    QWidget *widget;
    QMenuBar *menuBar;
    QMenu *menuOBDScanner;

    void setupUi(QMainWindow *OBDScanner)
    {
        if (OBDScanner->objectName().isEmpty())
            OBDScanner->setObjectName(QStringLiteral("OBDScanner"));
        OBDScanner->resize(684, 399);
        actionQuit = new QAction(OBDScanner);
        actionQuit->setObjectName(QStringLiteral("actionQuit"));
        centralWidget = new QWidget(OBDScanner);
        centralWidget->setObjectName(QStringLiteral("centralWidget"));
        btRadioButton = new QRadioButton(centralWidget);
        btRadioButton->setObjectName(QStringLiteral("btRadioButton"));
        btRadioButton->setGeometry(QRect(10, 10, 96, 23));
        btRadioButton->setChecked(true);
        btConfigButton = new QToolButton(centralWidget);
        btConfigButton->setObjectName(QStringLiteral("btConfigButton"));
        btConfigButton->setGeometry(QRect(100, 10, 24, 24));
        label = new QLabel(centralWidget);
        label->setObjectName(QStringLiteral("label"));
        label->setGeometry(QRect(140, 10, 81, 17));
        connectedDeviceName = new QLabel(centralWidget);
        connectedDeviceName->setObjectName(QStringLiteral("connectedDeviceName"));
        connectedDeviceName->setGeometry(QRect(230, 10, 131, 17));
        tabWidget = new QTabWidget(centralWidget);
        tabWidget->setObjectName(QStringLiteral("tabWidget"));
        tabWidget->setEnabled(true);
        tabWidget->setGeometry(QRect(10, 50, 661, 301));
        tabWidget->setTabPosition(QTabWidget::North);
        tabWidget->setTabShape(QTabWidget::Rounded);
        tabWidget->setTabsClosable(false);
        tabWidget->setTabBarAutoHide(false);
        rtd_tab = new QWidget();
        rtd_tab->setObjectName(QStringLiteral("rtd_tab"));
        speed_dial = new QDial(rtd_tab);
        speed_dial->setObjectName(QStringLiteral("speed_dial"));
        speed_dial->setEnabled(true);
        speed_dial->setGeometry(QRect(30, 80, 131, 131));
        speed_dial->setMouseTracking(false);
        speed_dial->setFocusPolicy(Qt::WheelFocus);
        speed_dial->setAcceptDrops(false);
        speed_dial->setAutoFillBackground(true);
        speed_dial->setMaximum(230);
        speed_dial->setPageStep(5);
        speed_dial->setSliderPosition(0);
        speed_dial->setTracking(true);
        speed_dial->setInvertedAppearance(false);
        speed_dial->setInvertedControls(false);
        speed_dial->setWrapping(false);
        speed_dial->setNotchesVisible(true);
        speedLcd = new QLCDNumber(rtd_tab);
        speedLcd->setObjectName(QStringLiteral("speedLcd"));
        speedLcd->setGeometry(QRect(70, 30, 64, 23));
        rpmLcd = new QLCDNumber(rtd_tab);
        rpmLcd->setObjectName(QStringLiteral("rpmLcd"));
        rpmLcd->setGeometry(QRect(220, 40, 64, 23));
        label_2 = new QLabel(rtd_tab);
        label_2->setObjectName(QStringLiteral("label_2"));
        label_2->setGeometry(QRect(190, 10, 131, 20));
        label_2->setAlignment(Qt::AlignCenter);
        label_3 = new QLabel(rtd_tab);
        label_3->setObjectName(QStringLiteral("label_3"));
        label_3->setGeometry(QRect(40, 10, 121, 20));
        label_3->setAlignment(Qt::AlignCenter);
        label_4 = new QLabel(rtd_tab);
        label_4->setObjectName(QStringLiteral("label_4"));
        label_4->setGeometry(QRect(350, 10, 131, 20));
        label_4->setAlignment(Qt::AlignCenter);
        inTempLcd = new QLCDNumber(rtd_tab);
        inTempLcd->setObjectName(QStringLiteral("inTempLcd"));
        inTempLcd->setGeometry(QRect(380, 40, 64, 23));
        label_5 = new QLabel(rtd_tab);
        label_5->setObjectName(QStringLiteral("label_5"));
        label_5->setGeometry(QRect(510, 10, 131, 20));
        label_5->setAlignment(Qt::AlignCenter);
        coolantLcd = new QLCDNumber(rtd_tab);
        coolantLcd->setObjectName(QStringLiteral("coolantLcd"));
        coolantLcd->setGeometry(QRect(540, 30, 64, 23));
        coolant_dial = new QDial(rtd_tab);
        coolant_dial->setObjectName(QStringLiteral("coolant_dial"));
        coolant_dial->setEnabled(true);
        coolant_dial->setGeometry(QRect(510, 80, 131, 131));
        coolant_dial->setMouseTracking(false);
        coolant_dial->setFocusPolicy(Qt::WheelFocus);
        coolant_dial->setAcceptDrops(false);
        coolant_dial->setAutoFillBackground(true);
        coolant_dial->setMinimum(-20);
        coolant_dial->setMaximum(150);
        coolant_dial->setPageStep(5);
        coolant_dial->setValue(-20);
        coolant_dial->setSliderPosition(-20);
        coolant_dial->setTracking(true);
        coolant_dial->setOrientation(Qt::Horizontal);
        coolant_dial->setInvertedAppearance(false);
        coolant_dial->setInvertedControls(false);
        coolant_dial->setWrapping(false);
        coolant_dial->setNotchesVisible(true);
        intake_dial = new QDial(rtd_tab);
        intake_dial->setObjectName(QStringLiteral("intake_dial"));
        intake_dial->setEnabled(true);
        intake_dial->setGeometry(QRect(350, 80, 131, 131));
        intake_dial->setMouseTracking(false);
        intake_dial->setFocusPolicy(Qt::WheelFocus);
        intake_dial->setAcceptDrops(false);
        intake_dial->setAutoFillBackground(true);
        intake_dial->setMinimum(-40);
        intake_dial->setMaximum(130);
        intake_dial->setPageStep(5);
        intake_dial->setValue(-40);
        intake_dial->setSliderPosition(-40);
        intake_dial->setTracking(true);
        intake_dial->setInvertedAppearance(false);
        intake_dial->setInvertedControls(false);
        intake_dial->setWrapping(false);
        intake_dial->setNotchesVisible(true);
        rpm_dial = new QDial(rtd_tab);
        rpm_dial->setObjectName(QStringLiteral("rpm_dial"));
        rpm_dial->setEnabled(true);
        rpm_dial->setGeometry(QRect(190, 80, 131, 131));
        rpm_dial->setMouseTracking(false);
        rpm_dial->setFocusPolicy(Qt::WheelFocus);
        rpm_dial->setAcceptDrops(false);
        rpm_dial->setAutoFillBackground(true);
        rpm_dial->setMaximum(9000);
        rpm_dial->setSingleStep(1);
        rpm_dial->setPageStep(100);
        rpm_dial->setSliderPosition(0);
        rpm_dial->setTracking(true);
        rpm_dial->setInvertedAppearance(false);
        rpm_dial->setInvertedControls(false);
        rpm_dial->setWrapping(false);
        rpm_dial->setNotchesVisible(true);
        label_6 = new QLabel(rtd_tab);
        label_6->setObjectName(QStringLiteral("label_6"));
        label_6->setGeometry(QRect(60, 230, 71, 17));
        label_6->setLayoutDirection(Qt::LeftToRight);
        label_6->setAlignment(Qt::AlignCenter);
        label_7 = new QLabel(rtd_tab);
        label_7->setObjectName(QStringLiteral("label_7"));
        label_7->setGeometry(QRect(220, 230, 71, 17));
        label_7->setLayoutDirection(Qt::LeftToRight);
        label_7->setAlignment(Qt::AlignCenter);
        label_8 = new QLabel(rtd_tab);
        label_8->setObjectName(QStringLiteral("label_8"));
        label_8->setGeometry(QRect(380, 230, 71, 17));
        label_8->setLayoutDirection(Qt::LeftToRight);
        label_8->setAlignment(Qt::AlignCenter);
        label_9 = new QLabel(rtd_tab);
        label_9->setObjectName(QStringLiteral("label_9"));
        label_9->setGeometry(QRect(540, 230, 71, 17));
        label_9->setLayoutDirection(Qt::LeftToRight);
        label_9->setAlignment(Qt::AlignCenter);
        rtd_startButton = new QPushButton(rtd_tab);
        rtd_startButton->setObjectName(QStringLiteral("rtd_startButton"));
        rtd_startButton->setGeometry(QRect(0, 10, 31, 25));
        tabWidget->addTab(rtd_tab, QString());
        dtc_tab = new QWidget();
        dtc_tab->setObjectName(QStringLiteral("dtc_tab"));
        scrollArea = new QScrollArea(dtc_tab);
        scrollArea->setObjectName(QStringLiteral("scrollArea"));
        scrollArea->setGeometry(QRect(10, 10, 631, 241));
        scrollArea->setWidgetResizable(true);
        scrollAreaWidgetContents = new QWidget();
        scrollAreaWidgetContents->setObjectName(QStringLiteral("scrollAreaWidgetContents"));
        scrollAreaWidgetContents->setGeometry(QRect(0, 0, 629, 239));
        dtc_checkErrNumberButton = new QPushButton(scrollAreaWidgetContents);
        dtc_checkErrNumberButton->setObjectName(QStringLiteral("dtc_checkErrNumberButton"));
        dtc_checkErrNumberButton->setGeometry(QRect(400, 10, 131, 25));
        dtc_getErrCodesButton = new QPushButton(scrollAreaWidgetContents);
        dtc_getErrCodesButton->setObjectName(QStringLiteral("dtc_getErrCodesButton"));
        dtc_getErrCodesButton->setGeometry(QRect(400, 50, 131, 25));
        dtc_clearErrors = new QPushButton(scrollAreaWidgetContents);
        dtc_clearErrors->setObjectName(QStringLiteral("dtc_clearErrors"));
        dtc_clearErrors->setGeometry(QRect(400, 90, 131, 25));
        dtc_numberEdit = new QLineEdit(scrollAreaWidgetContents);
        dtc_numberEdit->setObjectName(QStringLiteral("dtc_numberEdit"));
        dtc_numberEdit->setGeometry(QRect(160, 10, 71, 25));
        label_10 = new QLabel(scrollAreaWidgetContents);
        label_10->setObjectName(QStringLiteral("label_10"));
        label_10->setGeometry(QRect(10, 10, 141, 21));
        label_11 = new QLabel(scrollAreaWidgetContents);
        label_11->setObjectName(QStringLiteral("label_11"));
        label_11->setGeometry(QRect(10, 50, 171, 21));
        dtc_descriptionEdit = new QTextEdit(scrollAreaWidgetContents);
        dtc_descriptionEdit->setObjectName(QStringLiteral("dtc_descriptionEdit"));
        dtc_descriptionEdit->setGeometry(QRect(10, 80, 341, 151));
        dtc_milIndicatorON = new QRadioButton(scrollAreaWidgetContents);
        dtc_milIndicatorON->setObjectName(QStringLiteral("dtc_milIndicatorON"));
        dtc_milIndicatorON->setEnabled(false);
        dtc_milIndicatorON->setGeometry(QRect(240, 10, 111, 23));
        dtc_confirmatioFrame = new QFrame(scrollAreaWidgetContents);
        dtc_confirmatioFrame->setObjectName(QStringLiteral("dtc_confirmatioFrame"));
        dtc_confirmatioFrame->setEnabled(false);
        dtc_confirmatioFrame->setGeometry(QRect(370, 120, 191, 80));
        dtc_confirmatioFrame->setFrameShape(QFrame::StyledPanel);
        dtc_confirmatioFrame->setFrameShadow(QFrame::Raised);
        dtc_confirmationBox = new QDialogButtonBox(dtc_confirmatioFrame);
        dtc_confirmationBox->setObjectName(QStringLiteral("dtc_confirmationBox"));
        dtc_confirmationBox->setEnabled(false);
        dtc_confirmationBox->setGeometry(QRect(10, 50, 166, 25));
        dtc_confirmationBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        dtc_confirmationBox->setCenterButtons(false);
        label_12 = new QLabel(dtc_confirmatioFrame);
        label_12->setObjectName(QStringLiteral("label_12"));
        label_12->setGeometry(QRect(10, 10, 91, 20));
        scrollArea->setWidget(scrollAreaWidgetContents);
        tabWidget->addTab(dtc_tab, QString());
        cmd_tab = new QWidget();
        cmd_tab->setObjectName(QStringLiteral("cmd_tab"));
        cmd_sendButton = new QPushButton(cmd_tab);
        cmd_sendButton->setObjectName(QStringLiteral("cmd_sendButton"));
        cmd_sendButton->setGeometry(QRect(450, 220, 71, 25));
        cmd_input = new QLineEdit(cmd_tab);
        cmd_input->setObjectName(QStringLiteral("cmd_input"));
        cmd_input->setGeometry(QRect(10, 220, 431, 25));
        cmd_console = new QTextEdit(cmd_tab);
        cmd_console->setObjectName(QStringLiteral("cmd_console"));
        cmd_console->setGeometry(QRect(10, 10, 601, 201));
        cmd_console->setTabChangesFocus(false);
        cmd_console->setReadOnly(true);
        cmd_clearButton = new QPushButton(cmd_tab);
        cmd_clearButton->setObjectName(QStringLiteral("cmd_clearButton"));
        cmd_clearButton->setGeometry(QRect(540, 220, 71, 25));
        tabWidget->addTab(cmd_tab, QString());
        widget = new QWidget();
        widget->setObjectName(QStringLiteral("widget"));
        widget->setEnabled(false);
        QFont font;
        font.setKerning(true);
        widget->setFont(font);
        tabWidget->addTab(widget, QString());
        OBDScanner->setCentralWidget(centralWidget);
        menuBar = new QMenuBar(OBDScanner);
        menuBar->setObjectName(QStringLiteral("menuBar"));
        menuBar->setGeometry(QRect(0, 0, 684, 22));
        menuOBDScanner = new QMenu(menuBar);
        menuOBDScanner->setObjectName(QStringLiteral("menuOBDScanner"));
        OBDScanner->setMenuBar(menuBar);

        menuBar->addAction(menuOBDScanner->menuAction());
        menuOBDScanner->addAction(actionQuit);

        retranslateUi(OBDScanner);
        QObject::connect(actionQuit, SIGNAL(triggered()), OBDScanner, SLOT(close()));

        tabWidget->setCurrentIndex(0);


        QMetaObject::connectSlotsByName(OBDScanner);
    } // setupUi

    void retranslateUi(QMainWindow *OBDScanner)
    {
        OBDScanner->setWindowTitle(QApplication::translate("OBDScanner", "OBDScanner", nullptr));
        actionQuit->setText(QApplication::translate("OBDScanner", "&Quit", nullptr));
        btRadioButton->setText(QApplication::translate("OBDScanner", "Bluetooth", nullptr));
        btConfigButton->setText(QApplication::translate("OBDScanner", "...", nullptr));
        label->setText(QApplication::translate("OBDScanner", "Connected to:", nullptr));
        connectedDeviceName->setText(QString());
        label_2->setText(QApplication::translate("OBDScanner", "RPM", nullptr));
        label_3->setText(QApplication::translate("OBDScanner", "Speed", nullptr));
        label_4->setText(QApplication::translate("OBDScanner", "Intake temp.", nullptr));
        label_5->setText(QApplication::translate("OBDScanner", "Coolant temp.", nullptr));
        label_6->setText(QApplication::translate("OBDScanner", "km/h", nullptr));
        label_7->setText(QApplication::translate("OBDScanner", "r/min", nullptr));
        label_8->setText(QApplication::translate("OBDScanner", "<html><head/><body><p><span style=\" vertical-align:super;\">o</span>C</p></body></html>", nullptr));
        label_9->setText(QApplication::translate("OBDScanner", "<html><head/><body><p><span style=\" vertical-align:super;\">o</span>C</p></body></html>", nullptr));
        rtd_startButton->setText(QApplication::translate("OBDScanner", "Start", nullptr));
        tabWidget->setTabText(tabWidget->indexOf(rtd_tab), QApplication::translate("OBDScanner", "RTD", nullptr));
        dtc_checkErrNumberButton->setText(QApplication::translate("OBDScanner", "Check error number", nullptr));
        dtc_getErrCodesButton->setText(QApplication::translate("OBDScanner", "Get error codes", nullptr));
        dtc_clearErrors->setText(QApplication::translate("OBDScanner", "Clear errors", nullptr));
        label_10->setText(QApplication::translate("OBDScanner", "Number of error codes:", nullptr));
        label_11->setText(QApplication::translate("OBDScanner", "Diagnostic Trouble Codes :", nullptr));
        dtc_milIndicatorON->setText(QApplication::translate("OBDScanner", "&MIL turned on", nullptr));
        label_12->setText(QApplication::translate("OBDScanner", "Are You sure ?", nullptr));
        tabWidget->setTabText(tabWidget->indexOf(dtc_tab), QApplication::translate("OBDScanner", "DTC", nullptr));
        cmd_sendButton->setText(QApplication::translate("OBDScanner", "send", nullptr));
        cmd_clearButton->setText(QApplication::translate("OBDScanner", "clear", nullptr));
        tabWidget->setTabText(tabWidget->indexOf(cmd_tab), QApplication::translate("OBDScanner", "CMD console", nullptr));
        tabWidget->setTabText(tabWidget->indexOf(widget), QApplication::translate("OBDScanner", "Info", nullptr));
        menuOBDScanner->setTitle(QApplication::translate("OBDScanner", "OBDSca&nner", nullptr));
    } // retranslateUi

};

namespace Ui {
    class OBDScanner: public Ui_OBDScanner {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_OBDSCANNER_H
