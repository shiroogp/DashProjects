/*
* Copyright (C) 2017 Bastian Gschrey & Markus Ippy
*
* Digital Gauges for Apexi Power FC for RX7 on Raspberry Pi
*
*
* This software comes under the GPL (GNU Public License)
* You may freely copy,distribute etc. this as long as the source code
* is made available for FREE.
*
* No warranty is made or implied. You use this program at your own risk.
*/

/*!
  \file Connect.cpp
  \author Bastian Gschrey & Markus Ippy
*/

#include "datalogger.h"
#include "connect.h"
#include "calculations.h"
#include "sensors.h"
#include "AdaptronicSelect.h"
#include "Apexi.h"
#include "dashboard.h"
#include "serialport.h"
#include "appsettings.h"
#include "gopro.h"
#include "gps.h"
#include "udpreceiver.h"
#include "arduino.h"
#include "ui/mainwindow.h"
#include <QDebug>
#include <QTime>
#include <QTimer>
#include <QSerialPort>
#include <QSerialPortInfo>
#include <QQmlContext>
#include <QQmlApplicationEngine>
#include <QFile>
#include <QFileInfo>
#include <QTextStream>
#include <QByteArrayMatcher>
#include <QProcess>
#include <QStandardPaths>


int ecu; //0=apex, 1=adaptronic;2= OBD; 3= Dicktator ECU
int logging; // 0 Logging off , 1 Logging to file
int connectclicked =0;
int writingDefaultFiles = 0;
int width = 0;
int height = 0;
QByteArray checksumhex;
QByteArray recvchecksumhex;
QString selectedPort;
QString dashfilename1;
QString dashfilename2;
QString dashfilename3;
QString dashfilename4;
QString dashfilename5;
QString dashdash1;
QString dashdash2;
QString dashdash3;
QString dashdash4;
QString dashdash5;
QString dashdash6;
QProcess *powermods;

Connect::Connect(QObject *parent) :
    QObject(parent),
    m_serialport(Q_NULLPTR),
    m_dashBoard(Q_NULLPTR),
    m_gopro(Q_NULLPTR),
    m_gps(Q_NULLPTR),
    m_udpreceiver(Q_NULLPTR),
    m_adaptronicselect(Q_NULLPTR),
    m_apexi(Q_NULLPTR),
    m_sensors(Q_NULLPTR),
    m_datalogger(Q_NULLPTR),
    m_calculations(Q_NULLPTR),
    m_arduino(Q_NULLPTR),
  m_mainwindow(Q_NULLPTR)

{

    getPorts();
    m_dashBoard = new DashBoard(this);
    m_appSettings = new AppSettings(this);
    m_gopro = new GoPro(this);
    m_gps = new GPS(m_dashBoard, this);
    m_adaptronicselect= new AdaptronicSelect(m_dashBoard, this);
    m_udpreceiver= new udpreceiver(m_dashBoard, this);
    m_apexi= new Apexi(m_dashBoard, this);
    m_sensors = new Sensors(m_dashBoard, this);
    m_datalogger = new datalogger(m_dashBoard, this);
    m_calculations = new calculations(m_dashBoard, this);
    m_arduino = new Arduino(m_dashBoard, this);
    QString mPath = "/";
    // DIRECTORIES
    dirModel = new QFileSystemModel(this);
    // Set filter
    dirModel->setFilter(QDir::NoDotAndDotDot |QDir::AllDirs);
    // QFileSystemModel requires root path
    dirModel->setRootPath(mPath);
    fileModel = new QFileSystemModel(this);
    // Set filter
    fileModel->setFilter(QDir::NoDotAndDotDot | QDir::Files);
    // QFileSystemModel requires root path
    fileModel->setRootPath(mPath);



    QQmlApplicationEngine *engine = dynamic_cast<QQmlApplicationEngine*>( parent );
    if (engine == Q_NULLPTR)
        return;
    m_mainwindow = new MainWindow(engine, m_dashBoard, this);

    engine->rootContext()->setContextProperty("Dashboard", m_dashBoard);
    engine->rootContext()->setContextProperty("AppSettings", m_appSettings);
    engine->rootContext()->setContextProperty("GoPro", m_gopro);
    engine->rootContext()->setContextProperty("GPS", m_gps);
    engine->rootContext()->setContextProperty("Sens", m_sensors);
    engine->rootContext()->setContextProperty("Logger", m_datalogger);
    engine->rootContext()->setContextProperty("Calculations", m_calculations);
    engine->rootContext()->setContextProperty("Dirmodel", dirModel);
    engine->rootContext()->setContextProperty("Filemodel", fileModel);
    engine->rootContext()->setContextProperty("Apexi", m_apexi);
    engine->rootContext()->setContextProperty("Arduino", m_arduino);
    engine->rootContext()->setContextProperty("MainWindow", m_mainwindow);

}



Connect::~Connect()
{


}

QStringList Connect::getAddresses()
{
    return m_mainwindow->getAddresses();
}


QStringList Connect::getNetwork()
{
    return m_mainwindow->getmynetwork();
}

QString Connect::getfilename1()
{
    return dashfilename1;

}

QString Connect::getfilename2()
{
    return dashfilename2;
}

QString Connect::getfilename3()
{
    return dashfilename3;
}

QString Connect::getfilename4()
{
    return dashfilename4;
}

QString Connect::getfilename5()
{
    return dashfilename5;
}

void Connect::setfilename1(const QString &file1)
{
    dashfilename1 = file1;

    qDebug()<<"FILENAMES" << dashfilename1<< dashfilename2<< dashfilename3<< dashfilename4<< dashfilename5;
}

void Connect::setfilename2(const QString &file2)
{
    dashfilename2 = file2;
    qDebug()<<"FILENAMES" << dashfilename1<< dashfilename2<< dashfilename3<< dashfilename4<< dashfilename5;
}

void Connect::setfilename3(const QString &file3)
{
    dashfilename3 = file3;
    qDebug()<<"FILENAMES" << dashfilename1<< dashfilename2<< dashfilename3<< dashfilename4<< dashfilename5;
}

void Connect::setfilename4(const QString &file4)
{
    dashfilename4 = file4;
    qDebug()<<"FILENAMES" << dashfilename1<< dashfilename2<< dashfilename3<< dashfilename4<< dashfilename5;
}

void Connect::setfilename5(const QString &file5)
{
    dashfilename5 = file5;
    qDebug()<<"FILENAMES" << dashfilename1<< dashfilename2<< dashfilename3<< dashfilename4<< dashfilename5;
}

QString Connect::getdash1()
{
    return dashdash1;

}

QString Connect::getdash2()
{
    return dashdash2;
}

QString Connect::getdash3()
{
    return dashdash3;
}

QString Connect::getdash4()
{
    return dashdash4;
}

QString Connect::getdash5()
{
    return dashdash5;
}

QString Connect::getdash6()
{
    return dashdash6;
}

void Connect::setdash1(const QString &file1)
{
    dashdash1 = file1;

    qDebug()<<"dash" << dashdash1<< dashdash2<< dashdash3<< dashdash4<< dashdash5<< dashdash6;
}

void Connect::setdash2(const QString &file2)
{
    dashdash2 = file2;
    qDebug()<<"dash" << dashdash1<< dashdash2<< dashdash3<< dashdash4<< dashdash5<< dashdash6;
}

void Connect::setdash3(const QString &file3)
{
    dashdash3 = file3;
    qDebug()<<"dash" << dashdash1<< dashdash2<< dashdash3<< dashdash4<< dashdash5<< dashdash6;
}

void Connect::setdash4(const QString &file4)
{
    dashdash4 = file4;
    qDebug()<<"dash" << dashdash1<< dashdash2<< dashdash3<< dashdash4<< dashdash5<< dashdash6;
}

void Connect::setdash5(const QString &file5)
{
    dashdash5 = file5;
    qDebug()<<"dash" << dashdash1<< dashdash2<< dashdash3<< dashdash4<< dashdash5<< dashdash6;
}

void Connect::setdash6(const QString &file6)
{
    dashdash6 = file6;
    qDebug()<<"dash" << dashdash1<< dashdash2<< dashdash3<< dashdash4<< dashdash5<< dashdash6;
}

void Connect::setrpm(const int &dash1,const int &dash2,const int &dash3,const int &dash4)
{
    //qDebug()<<"rpm source" << dash1<< dash2<< dash3;
    m_dashBoard->setrpmstyle1(dash1);
    m_dashBoard->setrpmstyle2(dash2);
    m_dashBoard->setrpmstyle3(dash3);
    m_dashBoard->setrpmstyle4(dash4);
}
void Connect::checkifraspberrypi()
{
    QString path = "/sys/class/backlight/rpi_backlight/brightness";
    if (QFileInfo::exists(path))
    {

        m_dashBoard->setscreen(true);

    }
    else
    {
        m_dashBoard->setscreen(false);
    }
}



void Connect::writeDefaultFiles()
{
QDir dir(QStandardPaths::writableLocation(QStandardPaths::AppDataLocation)+"/dashfiles");
if (dir.exists()){
//    QString path = "whatever";
//    QDir dir(path);
    dir.setNameFilters(QStringList() << "*.*");
    dir.setFilter(QDir::Files);
    foreach(QString dirFile, dir.entryList())
    {
        dir.remove(dirFile);
    }
    bool removed = dir.rmpath(".");
    if (removed){
        dir.mkpath(".");
    }
}
    dir.mkpath(".");

    writingDefaultFiles = 1;
    writeDashFile("Sample2.txt","150,80,823,172,2,2,,BOOST,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,#00000000,grey,red,blue,25,35,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,844,76,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,#00000000,grey,red,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,908,255,5,0,,KNOCK,false,false,false,Dashboard,Knock,Knock,20000,-2000,transparent,transparent,#00000000,grey,white,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,943,165,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,#00000000,grey,white,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n250,250,476,4,8,0,rpm,Tacho,false,false,false,Dashboard,rpm,rpm,6.5,-2000,transparent,transparent,transparent,grey,white,blue,28,40,TachoGauge,white,red,#ffffff,pink,red,red,blue,white,red,green,yellow,orange,transparent,1,-90,180,45,false,6,\n250,250,483,300,10,0,rpm,Tacho2,false,false,false,Dashboard,rpm,rpm,5,-2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,TachoGauge,blue,purple,pink,steelblue,red,red,blue,white,red,pink,red,red,transparent,1,-135,135,135,false,6,\n250,250,353,273,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,6000,1000,transparent,transparent,transparent,grey,grey,steelblue,28,40,RoundGauge,lightblue,red,black,red,white,blue,black,white,red,pink,red,red,transparent,1,-135,135,0,true,9,\n250,250,330,-7,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,RoundGauge,#0066FF,#cc0000,white,#0099FF,white,blue,black,white,red,pink,red,red,transparent,1,-135,135,0,false,20,");
    writeDashFile("Sample3.txt","1024,600,0,0,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,image,#0066FF,#cc0000,white,#0099FF,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,false,20,/home/pi/splash.png\n150,80,300,200,2,2,,BOOST,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,transparent,grey,red,blue,25,35\n150,80,450,200,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,transparent,grey,red,blue,28,40\n150,80,300,280,5,0,,KNOCK,false,false,false,Dashboard,Knock,Knock,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n150,80,450,280,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n250,250,100,0,300,0,kph,Speedo,false,false,false,Dashboard,Speed,Speed,260,-2000,transparent,transparent,transparent,grey,white,blue,28,40,speedogauge,,,,yellow,,,,,,blue,steelblue,lightblue,,10,-180,90,-45\n250,250,550,0,8,0,rpm,Tacho,false,false,false,Dashboard,rpm,rpm,6.5,-2000,transparent,transparent,transparent,grey,white,blue,28,40,tachogauge,,,,pink,,,,,,green,yellow,orange,transparent,1,-90,180,45\n250,250,100,300,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,6000,1000,transparent,transparent,transparent,grey,grey,steelblue,28,40,roundgauge,lightblue,red,black,red,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,true,9\n250,250,550,300,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,roundgauge,#0066FF,#cc0000,white,#0099FF,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,false,20");
    writeDashFile("Sample4.txt","1024,600,0,0,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,ImageGauge,#0066FF,#cc0000,white,#0099FF,white,blue,black,white,red,pink,red,red,transparent,1,-135,135,0,false,20,/home/pi/splash.png\n150,80,987,305,2,2,,BOOST,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,#00000000,grey,red,blue,25,35,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,989,214,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,#00000000,grey,red,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,989,3,5,0,,KNOCK,false,false,false,Dashboard,Knock,Knock,20000,-2000,transparent,transparent,#00000000,grey,white,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,988,113,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,#00000000,grey,white,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n250,250,660,238,300,0,kph,Speedo,false,false,false,Dashboard,Speed,Speed,260,-2000,transparent,transparent,transparent,grey,white,blue,28,40,SpeedoGauge,white,red,#ffffff,yellow,red,red,blue,white,red,blue,steelblue,lightblue,transparent,10,-180,90,-45,false,6,\n250,250,68,7,8,0,rpm,Tacho,false,false,false,Dashboard,rpm,rpm,6.5,-2000,transparent,transparent,transparent,grey,white,blue,28,40,TachoGauge,white,red,#ffffff,pink,red,red,blue,white,red,green,yellow,orange,transparent,1,-90,180,45,false,6,\n250,250,641,-4,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,6000,1000,transparent,transparent,transparent,grey,grey,steelblue,28,40,RoundGauge,lightblue,red,black,red,white,blue,black,white,red,pink,red,red,transparent,1,-135,135,0,true,9,\n250,250,114,266,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,RoundGauge,#0066FF,#cc0000,white,#0099FF,white,blue,black,white,red,pink,red,red,transparent,1,-135,135,0,false,20,");
    writeDashFile("DigitalDash.txt","266,120,150,250,8500,0,rpm,MAP,false,true,true,Dashboard,rpm,rpm,8600,-1,transparent,transparent,transparent,white,white,red,15,30\n266,120,417,250,22,2,A/F,AFR,true,false,false,Dashboard,AFR,AFR,0,15,transparent,transparent,transparent,white,red,gold,15,30\n266,120,684,250,11000,0,kg/m²,MAP,true,false,false,Dashboard,Intakepress,Intakepress,320,1,transparent,transparent,transparent,white,blue,gold,15,30\n266,120,150,370,120,0,deg,Water Temp,false,true,false,Dashboard,Watertemp,Watertemp,108,40,transparent,transparent,transparent,white,pink,gold,15,30\n266,120,417,370,120,0,,Knock,false,true,false,Dashboard,Knock,Knock,0,60,transparent,transparent,transparent,white,purple,gold,15,30\n266,120,684,370,5,2,V,O2 Voltage,false,true,false,Dashboard,O2volt,O2volt,700,80,transparent,transparent,transparent,white,orange,gold,15,30\n199,120,150,490,70,0,deg,Intake Temp,false,true,false,Dashboard,Intaketemp,Intaketemp,50,0,transparent,transparent,transparent,white,grey,gold,15,30\n199,120,350,490,15,2,V,Battery Volts,false,true,false,Dashboard,BatteryV,BatteryV,14.88,11.80,transparent,transparent,transparent,white,cyan,gold,15,30\n219,120,550,490,3,2,,Boost,true,false,true,Dashboard,BoostPres,BoostPres,2.5,-0.5,transparent,transparent,transparent,white,steelblue,steelblue,15,30\n179,120,770,490,5,2,V,TPS,true,false,false,Dashboard,ThrottleV,ThrottleV,101,-1,transparent,transparent,transparent,white,lightgreen,gold,15,30");
    writeDashFile("Sample5.txt","150,80,300,200,2,2,,BOOST,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,transparent,grey,red,blue,25,35\n150,80,450,200,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,transparent,grey,red,blue,28,40\n150,80,300,280,5,0,,KNOCK,false,false,false,Dashboard,Knock,Knock,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n150,80,450,280,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n250,250,100,0,300,0,kph,Speedo,false,false,false,Dashboard,Speed,Speed,260,-2000,transparent,transparent,transparent,grey,white,blue,28,40,speedogauge,,,,yellow,,,,,,blue,steelblue,lightblue,,10,-180,90,-45\n250,250,550,0,8,0,rpm,Tacho,false,false,false,Dashboard,rpm,rpm,6.5,-2000,transparent,transparent,transparent,grey,white,blue,28,40,tachogauge,,,,pink,,,,,,green,yellow,orange,transparent,1,-90,180,45\n250,250,100,300,300,0,kph,Speedo2,false,false,false,Dashboard,Speed,Speed,260,-2000,transparent,transparent,transparent,grey,red,yellow,28,40,speedogauge,red,yellow,green,orange,,,,,,lightblue,blue,darkblue,black,10,-180,90,-135\n250,250,550,300,10,0,rpm,Tacho2,false,false,false,Dashboard,rpm,rpm,5,-2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,tachogauge,blue,purple,pink,steelblue,,,,,,pink,red,red,transparent,1,-135,135,135\n250,250,850,300,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,6000,1000,transparent,transparent,transparent,grey,grey,steelblue,28,40,roundgauge,lightblue,red,black,red,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,true,9\n250,250,850,0,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,roundgauge,#0066FF,#cc0000,white,#0099FF,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,false,20");
    writeDashFile("Sample6.txt","266,80,380,305,2,2,,Boost,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,transparent,grey,white,blue,25,35\n266,80,0,480,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n266,80,380,480,5,0,,Knock,false,false,false,Dashboard,Knock,Knock,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n266,80,760,480,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40");
    writeDashFile("Sample7.txt","266,80,267,215,2,2,,Boost,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,transparent,grey,white,blue,25,35\n266,80,0,390,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n266,80,267,390,5,2,,BAT,false,false,false,Dashboard,BatteryV,BatteryV,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n266,80,534,390,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n266,80,534,390,100,3,,LAMBDA,false,false,false,Dashboard,LAMBDA,LAMBDA,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40");
    writeDashFile("Sample8.txt","266,120,0,240,300,0,kPa,MAP,false,true,false,Dashboard,MAP,MAP,10000,-10000,grey,black,grey,white,white,blue,25,40\n266,120,267,240,2,3,λ,LAMBDA,false,true,false,Dashboard,LAMBDA,LAMBDA,10000,-10000,grey,black,grey,white,white,blue,25,40\n                      266,120,534,240,100,0,°C,IAT,false,true,false,Dashboard,Intaketemp,Intaketemp,10000,-10000,grey,black,grey,white,white,blue,25,40\n199,120,0,360,500,0,kPa,FUEL P.,false,true,false,Dashboard,FuelPress,FuelPress,10000,-10000,grey,black,grey,white,white,blue,25,40\n199,120,200,360,500,0,kPa,OIL P.,false,true,false,Dashboard,oilpres,oilpres,10000,-10000,grey,black,grey,white,white,blue,25,40\n219,120,400,360,100,0,%,ETHANOL %,false,true,false,Dashboard,fuelcomposition,fuelcomposition,10000,-10000,grey,black,grey,white,white,blue,25,40\n179,120,620,360,100,0,°C,ECT,false,true,false,Dashboard,Watertemp,Watertemp,94,-10,grey,black,grey,white,white,blue,25,40");
    writeDashFile("Sample9.txt","266,120,0,240,120,0,deg,Water Temp,false,true,false,Dashboard,Watertemp,Watertemp,108,40,lightsteelblue,black,lightsteelblue,white,white,blue,25,40\n266,120,267,240,120,0,deg,Oil Temp,false,true,false,Dashboard,oiltemp,oiltemp,115,60,lightsteelblue,black,lightsteelblue,white,white,blue,25,40\n266,120,534,240,700,0,kpa,Oil Pressure,false,false,false,Dashboard,oilpres,oilpres,700,80,lightsteelblue,black,lightsteelblue,white,white,blue,25,40\n199,120,0,360,70,0,deg,Intake Temp,false,false,false,Dashboard,Intaketemp,Intaketemp,50,0,lightsteelblue,black,lightsteelblue,white,white,blue,25,40\n199,120,200,360,0,2,V,Battery Volts,false,false,false,Dashboard,BatteryV,BatteryV,14.88,12.50,lightsteelblue,black,lightsteelblue,white,white,blue,25,40\n219,120,400,360,0,0,kpa,Fuel Pressure,false,false,false,Dashboard,FuelPress,FuelPress,600,250,lightsteelblue,black,lightsteelblue,white,white,blue,25,40\n179,120,620,360,0,0,%,Injector Duty,false,true,false,Dashboard,InjDuty,InjDuty,85,-1,lightsteelblue,black,lightsteelblue,white,white,blue,25,40");
    writeDashFile("Sample10.txt","266,120,0,0,8500,0,rpm,MAP,false,true,false,Dashboard,rpm,rpm,8600,-1,blue,black,blue,white,white,blue,25,40\n266,120,267,0,1.3,2,?,Lambda,false,true,false,Dashboard,LAMBDA,LAMBDA,2,0.6,blue,black,blue,white,white,blue,25,40\n266,120,534,0,300,2,kpa,MAP,false,true,false,Dashboard,MAP,MAP,320,1,blue,black,blue,white,white,blue,25,40\n266,120,0,120,120,0,deg,Water Temp,false,true,false,Dashboard,Watertemp,Watertemp,108,40,blue,black,blue,white,white,blue,25,40\n266,120,267,120,120,0,deg,Oil Temp,false,true,false,Dashboard,oiltemp,oiltemp,115,60,blue,black,blue,white,white,blue,25,40\n266,120,534,120,700,0,kpa,Oil Pressure,false,true,false,Dashboard,oilpres,oilpres,700,80,blue,black,blue,white,white,blue,25,40\n199,120,0,240,70,0,deg,Intake Temp,false,true,false,Dashboard,Intaketemp,Intaketemp,50,0,blue,black,blue,white,white,blue,25,40\n199,120,200,240,15,2,V,Battery Volts,false,true,false,Dashboard,BatteryV,BatteryV,14.88,11.80,blue,black,blue,white,white,blue,25,40\n219,120,400,240,700,0,kpa,Fuel Pressure,false,true,false,Dashboard,FuelPress,FuelPress,600,240,blue,black,blue,white,white,blue,25,40\n179,120,620,240,100,0,%,Injector Duty,false,true,false,Dashboard,InjDuty,InjDuty,85,-1,blue,black,blue,white,white,blue,25,40\n219,120,0,360,0,0,kpa,Barometric,false,false,false,Dashboard,ambipress,ambipress,150,0,blue,black,blue,white,white,blue,25,40\n199,120,220,360,0,0,deg,Ignition Angle,false,false,false,Dashboard,Ign,Ign,-30,50,blue,black,blue,white,white,blue,25,40\n199,120,420,360,0,0,ms,Injector MS,false,false,false,Dashboard,injms,injms,250,-1,blue,black,blue,white,white,blue,25,40\n179,120,620,360,100,0,%,TPS,false,true,false,Dashboard,TPS,TPS,101,-1,blue,black,blue,white,white,blue,25,40");
    writeDashFile("Sample11.txt","266,120,0,0,8500,0,rpm,MAP,false,true,false,Dashboard,rpm,rpm,8600,-1,yellow,black,yellow,black,white,gold,25,35\n266,120,267,0,22,2,A/F,AFR,false,true,false,Dashboard,AFR,AFR,0,15,yellow,black,yellow,black,white,gold,25,35\n266,120,534,0,11000,0,kg/m²,MAP,false,true,false,Dashboard,Intakepress,Intakepress,320,1,yellow,black,yellow,black,white,gold,25,35\n266,120,0,120,120,0,deg,Water Temp,false,true,false,Dashboard,Watertemp,Watertemp,108,40,yellow,black,yellow,black,white,gold,25,35\n266,120,267,120,120,0,,Knock,false,true,false,Dashboard,Knock,Knock,0,60,yellow,black,yellow,black,white,gold,25,35\n266,120,534,120,5,2,V,O2 Voltage,false,true,false,Dashboard,O2volt,O2volt,700,80,yellow,black,yellow,black,white,gold,25,35\n199,120,0,240,70,0,deg,Intake Temp,false,true,false,Dashboard,Intaketemp,Intaketemp,50,0,yellow,black,yellow,black,white,gold,25,35\n199,120,200,240,15,2,V,Battery Volts,false,true,false,Dashboard,BatteryV,BatteryV,14.88,11.80,yellow,black,yellow,black,white,gold,25,35\n219,120,400,240,20,0,,Boost,false,true,false,Dashboard,BoostPres,BoostPres,-1000,1,yellow,black,yellow,black,white,gold,25,35\n179,120,620,240,100,0,%,Injector Duty,false,true,false,Dashboard,InjDuty,InjDuty,0,90,yellow,black,yellow,black,white,gold,25,35\n219,120,0,360,100,0,%,BoostDuty,false,true,false,Dashboard,BoostDuty,BoostDuty,0,120,yellow,black,yellow,black,white,gold,25,35\n199,120,220,360,0,0,deg,Ignition Angle,false,false,false,Dashboard,Ign,Ign,-30,50,yellow,black,yellow,black,white,gold,25,35\n199,120,420,360,0,0,ms,Injector MS,false,false,false,Dashboard,injms,injms,250,-1,yellow,black,yellow,black,white,gold,25,35\n179,120,620,360,5,2,V,TPS,false,true,false,Dashboard,ThrottleV,ThrottleV,101,-1,yellow,black,yellow,black,white,gold,25,35");
    writeDashFile("Sample12.txt","266,120,1,0,8500,0,rpm,RPM,false,true,false,Dashboard,rpm,rpm,8600,-1,yellow,black,yellow,black,yellow,gold,25,35\n266,120,267,0,6000,3,ms,Inj ms,false,true,false,Dashboard,injms,injms,8600,-1,yellow,black,yellow,black,yellow,gold,25,35\n266,120,533,0,8500,0,°,IAT,false,true,false,Dashboard,Intaketemp,Intaketemp,80,-1,yellow,black,yellow,black,yellow,gold,25,35\n266,120,1,120,100,0,%,Eng. Load,false,true,false,Dashboard,EngLoad,EngLoad,8600,-1,yellow,black,yellow,black,yellow,gold,25,35\n266,120,267,120,8500,0,°,IGN,false,true,false,Dashboard,Ign,Ign,8600,-40,yellow,black,yellow,black,yellow,gold,25,35\n266,120,533,120,120,0,,Knock,false,true,false,Dashboard,Knock,Knock,70,-1,yellow,black,yellow,black,yellow,gold,25,35\n266,120,1,240,5,2,V,MAF1,false,true,false,Dashboard,MAF1V,MAF1V,8600,-1,yellow,black,yellow,black,yellow,gold,25,35\n266,120,267,240,8500,0,,Dwell,false,false,false,Dashboard,Dwell,Dwell,8600,-1,yellow,black,yellow,black,yellow,gold,25,35\n266,120,533,240,16,2,V,Battery,false,true,false,Dashboard,BatteryV,BatteryV,8600,11.5,yellow,black,yellow,black,yellow,gold,25,35\n266,120,1,360,5,2,V,MAF2,false,true,false,Dashboard,MAF2V,MAF2V,8600,-1,yellow,black,yellow,black,yellow,gold,25,35\n266,120,267,360,95,0,°,ECT,false,true,false,Dashboard,Watertemp,Watertemp,98,-1,yellow,black,yellow,black,yellow,gold,25,35\n266,120,533,360,100,2,V,TPS V,false,true,false,Dashboard,ThrottleV,ThrottleV,8600,-1,yellow,black,yellow,black,yellow,gold,25,35");
    writeDashFile("MainDash.txt","266,80,380,305,2,2,,Boost,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,transparent,grey,white,blue,25,35\n266,80,0,480,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n266,80,380,480,5,0,,Knock,false,false,false,Dashboard,Knock,Knock,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n266,80,760,480,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40");
    writingDefaultFiles = 0;
    readavailabledashfiles();
}
void Connect::readavailabledashfiles()
{
    //QDir directory(""); //for Windows
//    QDir directory("/home/pi/BoostedGarage/exampleDash/");


    QDir dir(QStandardPaths::writableLocation(QStandardPaths::AppDataLocation)+"/dashfiles");
    if (!dir.exists()){
        writeDefaultFiles();
//        dir.mkpath(".");
//        writingDefaultFiles = 1;
//        writeDashFile("Sample2.txt","150,80,823,172,2,2,,BOOST,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,#00000000,grey,red,blue,25,35,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,844,76,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,#00000000,grey,red,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,908,255,5,0,,KNOCK,false,false,false,Dashboard,Knock,Knock,20000,-2000,transparent,transparent,#00000000,grey,white,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,943,165,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,#00000000,grey,white,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n250,250,476,4,8,0,rpm,Tacho,false,false,false,Dashboard,rpm,rpm,6.5,-2000,transparent,transparent,transparent,grey,white,blue,28,40,TachoGauge,white,red,#ffffff,pink,red,red,blue,white,red,green,yellow,orange,transparent,1,-90,180,45,false,6,\n250,250,483,300,10,0,rpm,Tacho2,false,false,false,Dashboard,rpm,rpm,5,-2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,TachoGauge,blue,purple,pink,steelblue,red,red,blue,white,red,pink,red,red,transparent,1,-135,135,135,false,6,\n250,250,353,273,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,6000,1000,transparent,transparent,transparent,grey,grey,steelblue,28,40,RoundGauge,lightblue,red,black,red,white,blue,black,white,red,pink,red,red,transparent,1,-135,135,0,true,9,\n250,250,330,-7,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,RoundGauge,#0066FF,#cc0000,white,#0099FF,white,blue,black,white,red,pink,red,red,transparent,1,-135,135,0,false,20,");
//        writeDashFile("Sample3.txt","1024,600,0,0,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,image,#0066FF,#cc0000,white,#0099FF,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,false,20,/home/pi/splash.png\n150,80,300,200,2,2,,BOOST,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,transparent,grey,red,blue,25,35\n150,80,450,200,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,transparent,grey,red,blue,28,40\n150,80,300,280,5,0,,KNOCK,false,false,false,Dashboard,Knock,Knock,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n150,80,450,280,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n250,250,100,0,300,0,kph,Speedo,false,false,false,Dashboard,Speed,Speed,260,-2000,transparent,transparent,transparent,grey,white,blue,28,40,speedogauge,,,,yellow,,,,,,blue,steelblue,lightblue,,10,-180,90,-45\n250,250,550,0,8,0,rpm,Tacho,false,false,false,Dashboard,rpm,rpm,6.5,-2000,transparent,transparent,transparent,grey,white,blue,28,40,tachogauge,,,,pink,,,,,,green,yellow,orange,transparent,1,-90,180,45\n250,250,100,300,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,6000,1000,transparent,transparent,transparent,grey,grey,steelblue,28,40,roundgauge,lightblue,red,black,red,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,true,9\n250,250,550,300,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,roundgauge,#0066FF,#cc0000,white,#0099FF,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,false,20");
//        writeDashFile("Sample4.txt","1024,600,0,0,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,ImageGauge,#0066FF,#cc0000,white,#0099FF,white,blue,black,white,red,pink,red,red,transparent,1,-135,135,0,false,20,/home/pi/splash.png\n150,80,987,305,2,2,,BOOST,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,#00000000,grey,red,blue,25,35,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,989,214,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,#00000000,grey,red,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,989,3,5,0,,KNOCK,false,false,false,Dashboard,Knock,Knock,20000,-2000,transparent,transparent,#00000000,grey,white,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,988,113,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,#00000000,grey,white,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n250,250,660,238,300,0,kph,Speedo,false,false,false,Dashboard,Speed,Speed,260,-2000,transparent,transparent,transparent,grey,white,blue,28,40,SpeedoGauge,white,red,#ffffff,yellow,red,red,blue,white,red,blue,steelblue,lightblue,transparent,10,-180,90,-45,false,6,\n250,250,68,7,8,0,rpm,Tacho,false,false,false,Dashboard,rpm,rpm,6.5,-2000,transparent,transparent,transparent,grey,white,blue,28,40,TachoGauge,white,red,#ffffff,pink,red,red,blue,white,red,green,yellow,orange,transparent,1,-90,180,45,false,6,\n250,250,641,-4,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,6000,1000,transparent,transparent,transparent,grey,grey,steelblue,28,40,RoundGauge,lightblue,red,black,red,white,blue,black,white,red,pink,red,red,transparent,1,-135,135,0,true,9,\n250,250,114,266,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,RoundGauge,#0066FF,#cc0000,white,#0099FF,white,blue,black,white,red,pink,red,red,transparent,1,-135,135,0,false,20,");
//        writeDashFile("DigitalDash.txt","266,120,150,250,8500,0,rpm,MAP,false,true,true,Dashboard,rpm,rpm,8600,-1,transparent,transparent,transparent,white,white,red,15,30\n266,120,417,250,22,2,A/F,AFR,true,false,false,Dashboard,AFR,AFR,0,15,transparent,transparent,transparent,white,red,gold,15,30\n266,120,684,250,11000,0,kg/m²,MAP,true,false,false,Dashboard,Intakepress,Intakepress,320,1,transparent,transparent,transparent,white,blue,gold,15,30\n266,120,150,370,120,0,deg,Water Temp,false,true,false,Dashboard,Watertemp,Watertemp,108,40,transparent,transparent,transparent,white,pink,gold,15,30\n266,120,417,370,120,0,,Knock,false,true,false,Dashboard,Knock,Knock,0,60,transparent,transparent,transparent,white,purple,gold,15,30\n266,120,684,370,5,2,V,O2 Voltage,false,true,false,Dashboard,O2volt,O2volt,700,80,transparent,transparent,transparent,white,orange,gold,15,30\n199,120,150,490,70,0,deg,Intake Temp,false,true,false,Dashboard,Intaketemp,Intaketemp,50,0,transparent,transparent,transparent,white,grey,gold,15,30\n199,120,350,490,15,2,V,Battery Volts,false,true,false,Dashboard,BatteryV,BatteryV,14.88,11.80,transparent,transparent,transparent,white,cyan,gold,15,30\n219,120,550,490,3,2,,Boost,true,false,true,Dashboard,BoostPres,BoostPres,2.5,-0.5,transparent,transparent,transparent,white,steelblue,steelblue,15,30\n179,120,770,490,5,2,V,TPS,true,false,false,Dashboard,ThrottleV,ThrottleV,101,-1,transparent,transparent,transparent,white,lightgreen,gold,15,30");
//        writeDashFile("Sample5.txt","150,80,300,200,2,2,,BOOST,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,transparent,grey,red,blue,25,35\n150,80,450,200,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,transparent,grey,red,blue,28,40\n150,80,300,280,5,0,,KNOCK,false,false,false,Dashboard,Knock,Knock,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n150,80,450,280,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n250,250,100,0,300,0,kph,Speedo,false,false,false,Dashboard,Speed,Speed,260,-2000,transparent,transparent,transparent,grey,white,blue,28,40,speedogauge,,,,yellow,,,,,,blue,steelblue,lightblue,,10,-180,90,-45\n250,250,550,0,8,0,rpm,Tacho,false,false,false,Dashboard,rpm,rpm,6.5,-2000,transparent,transparent,transparent,grey,white,blue,28,40,tachogauge,,,,pink,,,,,,green,yellow,orange,transparent,1,-90,180,45\n250,250,100,300,300,0,kph,Speedo2,false,false,false,Dashboard,Speed,Speed,260,-2000,transparent,transparent,transparent,grey,red,yellow,28,40,speedogauge,red,yellow,green,orange,,,,,,lightblue,blue,darkblue,black,10,-180,90,-135\n250,250,550,300,10,0,rpm,Tacho2,false,false,false,Dashboard,rpm,rpm,5,-2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,tachogauge,blue,purple,pink,steelblue,,,,,,pink,red,red,transparent,1,-135,135,135\n250,250,850,300,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,6000,1000,transparent,transparent,transparent,grey,grey,steelblue,28,40,roundgauge,lightblue,red,black,red,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,true,9\n250,250,850,0,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,roundgauge,#0066FF,#cc0000,white,#0099FF,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,false,20");
//        writeDashFile("Sample6.txt","266,80,380,305,2,2,,Boost,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,transparent,grey,white,blue,25,35\n266,80,0,480,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n266,80,380,480,5,0,,Knock,false,false,false,Dashboard,Knock,Knock,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n266,80,760,480,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40");
//        writeDashFile("Sample7.txt","266,80,267,215,2,2,,Boost,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,transparent,grey,white,blue,25,35\n266,80,0,390,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n266,80,267,390,5,2,,BAT,false,false,false,Dashboard,BatteryV,BatteryV,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n266,80,534,390,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n266,80,534,390,100,3,,LAMBDA,false,false,false,Dashboard,LAMBDA,LAMBDA,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40");
//        writeDashFile("Sample8.txt","266,120,0,240,300,0,kPa,MAP,false,true,false,Dashboard,MAP,MAP,10000,-10000,grey,black,grey,white,white,blue,25,40\n266,120,267,240,2,3,λ,LAMBDA,false,true,false,Dashboard,LAMBDA,LAMBDA,10000,-10000,grey,black,grey,white,white,blue,25,40\n                      266,120,534,240,100,0,°C,IAT,false,true,false,Dashboard,Intaketemp,Intaketemp,10000,-10000,grey,black,grey,white,white,blue,25,40\n199,120,0,360,500,0,kPa,FUEL P.,false,true,false,Dashboard,FuelPress,FuelPress,10000,-10000,grey,black,grey,white,white,blue,25,40\n199,120,200,360,500,0,kPa,OIL P.,false,true,false,Dashboard,oilpres,oilpres,10000,-10000,grey,black,grey,white,white,blue,25,40\n219,120,400,360,100,0,%,ETHANOL %,false,true,false,Dashboard,fuelcomposition,fuelcomposition,10000,-10000,grey,black,grey,white,white,blue,25,40\n179,120,620,360,100,0,°C,ECT,false,true,false,Dashboard,Watertemp,Watertemp,94,-10,grey,black,grey,white,white,blue,25,40");
//        writeDashFile("Sample9.txt","266,120,0,240,120,0,deg,Water Temp,false,true,false,Dashboard,Watertemp,Watertemp,108,40,lightsteelblue,black,lightsteelblue,white,white,blue,25,40\n266,120,267,240,120,0,deg,Oil Temp,false,true,false,Dashboard,oiltemp,oiltemp,115,60,lightsteelblue,black,lightsteelblue,white,white,blue,25,40\n266,120,534,240,700,0,kpa,Oil Pressure,false,false,false,Dashboard,oilpres,oilpres,700,80,lightsteelblue,black,lightsteelblue,white,white,blue,25,40\n199,120,0,360,70,0,deg,Intake Temp,false,false,false,Dashboard,Intaketemp,Intaketemp,50,0,lightsteelblue,black,lightsteelblue,white,white,blue,25,40\n199,120,200,360,0,2,V,Battery Volts,false,false,false,Dashboard,BatteryV,BatteryV,14.88,12.50,lightsteelblue,black,lightsteelblue,white,white,blue,25,40\n219,120,400,360,0,0,kpa,Fuel Pressure,false,false,false,Dashboard,FuelPress,FuelPress,600,250,lightsteelblue,black,lightsteelblue,white,white,blue,25,40\n179,120,620,360,0,0,%,Injector Duty,false,true,false,Dashboard,InjDuty,InjDuty,85,-1,lightsteelblue,black,lightsteelblue,white,white,blue,25,40");
//        writeDashFile("Sample10.txt","266,120,0,0,8500,0,rpm,MAP,false,true,false,Dashboard,rpm,rpm,8600,-1,blue,black,blue,white,white,blue,25,40\n266,120,267,0,1.3,2,?,Lambda,false,true,false,Dashboard,LAMBDA,LAMBDA,2,0.6,blue,black,blue,white,white,blue,25,40\n266,120,534,0,300,2,kpa,MAP,false,true,false,Dashboard,MAP,MAP,320,1,blue,black,blue,white,white,blue,25,40\n266,120,0,120,120,0,deg,Water Temp,false,true,false,Dashboard,Watertemp,Watertemp,108,40,blue,black,blue,white,white,blue,25,40\n266,120,267,120,120,0,deg,Oil Temp,false,true,false,Dashboard,oiltemp,oiltemp,115,60,blue,black,blue,white,white,blue,25,40\n266,120,534,120,700,0,kpa,Oil Pressure,false,true,false,Dashboard,oilpres,oilpres,700,80,blue,black,blue,white,white,blue,25,40\n199,120,0,240,70,0,deg,Intake Temp,false,true,false,Dashboard,Intaketemp,Intaketemp,50,0,blue,black,blue,white,white,blue,25,40\n199,120,200,240,15,2,V,Battery Volts,false,true,false,Dashboard,BatteryV,BatteryV,14.88,11.80,blue,black,blue,white,white,blue,25,40\n219,120,400,240,700,0,kpa,Fuel Pressure,false,true,false,Dashboard,FuelPress,FuelPress,600,240,blue,black,blue,white,white,blue,25,40\n179,120,620,240,100,0,%,Injector Duty,false,true,false,Dashboard,InjDuty,InjDuty,85,-1,blue,black,blue,white,white,blue,25,40\n219,120,0,360,0,0,kpa,Barometric,false,false,false,Dashboard,ambipress,ambipress,150,0,blue,black,blue,white,white,blue,25,40\n199,120,220,360,0,0,deg,Ignition Angle,false,false,false,Dashboard,Ign,Ign,-30,50,blue,black,blue,white,white,blue,25,40\n199,120,420,360,0,0,ms,Injector MS,false,false,false,Dashboard,injms,injms,250,-1,blue,black,blue,white,white,blue,25,40\n179,120,620,360,100,0,%,TPS,false,true,false,Dashboard,TPS,TPS,101,-1,blue,black,blue,white,white,blue,25,40");
//        writeDashFile("Sample11.txt","266,120,0,0,8500,0,rpm,MAP,false,true,false,Dashboard,rpm,rpm,8600,-1,yellow,black,yellow,black,white,gold,25,35\n266,120,267,0,22,2,A/F,AFR,false,true,false,Dashboard,AFR,AFR,0,15,yellow,black,yellow,black,white,gold,25,35\n266,120,534,0,11000,0,kg/m²,MAP,false,true,false,Dashboard,Intakepress,Intakepress,320,1,yellow,black,yellow,black,white,gold,25,35\n266,120,0,120,120,0,deg,Water Temp,false,true,false,Dashboard,Watertemp,Watertemp,108,40,yellow,black,yellow,black,white,gold,25,35\n266,120,267,120,120,0,,Knock,false,true,false,Dashboard,Knock,Knock,0,60,yellow,black,yellow,black,white,gold,25,35\n266,120,534,120,5,2,V,O2 Voltage,false,true,false,Dashboard,O2volt,O2volt,700,80,yellow,black,yellow,black,white,gold,25,35\n199,120,0,240,70,0,deg,Intake Temp,false,true,false,Dashboard,Intaketemp,Intaketemp,50,0,yellow,black,yellow,black,white,gold,25,35\n199,120,200,240,15,2,V,Battery Volts,false,true,false,Dashboard,BatteryV,BatteryV,14.88,11.80,yellow,black,yellow,black,white,gold,25,35\n219,120,400,240,20,0,,Boost,false,true,false,Dashboard,BoostPres,BoostPres,-1000,1,yellow,black,yellow,black,white,gold,25,35\n179,120,620,240,100,0,%,Injector Duty,false,true,false,Dashboard,InjDuty,InjDuty,0,90,yellow,black,yellow,black,white,gold,25,35\n219,120,0,360,100,0,%,BoostDuty,false,true,false,Dashboard,BoostDuty,BoostDuty,0,120,yellow,black,yellow,black,white,gold,25,35\n199,120,220,360,0,0,deg,Ignition Angle,false,false,false,Dashboard,Ign,Ign,-30,50,yellow,black,yellow,black,white,gold,25,35\n199,120,420,360,0,0,ms,Injector MS,false,false,false,Dashboard,injms,injms,250,-1,yellow,black,yellow,black,white,gold,25,35\n179,120,620,360,5,2,V,TPS,false,true,false,Dashboard,ThrottleV,ThrottleV,101,-1,yellow,black,yellow,black,white,gold,25,35");
//        writeDashFile("Sample12.txt","266,120,1,0,8500,0,rpm,RPM,false,true,false,Dashboard,rpm,rpm,8600,-1,yellow,black,yellow,black,yellow,gold,25,35\n266,120,267,0,6000,3,ms,Inj ms,false,true,false,Dashboard,injms,injms,8600,-1,yellow,black,yellow,black,yellow,gold,25,35\n266,120,533,0,8500,0,°,IAT,false,true,false,Dashboard,Intaketemp,Intaketemp,80,-1,yellow,black,yellow,black,yellow,gold,25,35\n266,120,1,120,100,0,%,Eng. Load,false,true,false,Dashboard,EngLoad,EngLoad,8600,-1,yellow,black,yellow,black,yellow,gold,25,35\n266,120,267,120,8500,0,°,IGN,false,true,false,Dashboard,Ign,Ign,8600,-40,yellow,black,yellow,black,yellow,gold,25,35\n266,120,533,120,120,0,,Knock,false,true,false,Dashboard,Knock,Knock,70,-1,yellow,black,yellow,black,yellow,gold,25,35\n266,120,1,240,5,2,V,MAF1,false,true,false,Dashboard,MAF1V,MAF1V,8600,-1,yellow,black,yellow,black,yellow,gold,25,35\n266,120,267,240,8500,0,,Dwell,false,false,false,Dashboard,Dwell,Dwell,8600,-1,yellow,black,yellow,black,yellow,gold,25,35\n266,120,533,240,16,2,V,Battery,false,true,false,Dashboard,BatteryV,BatteryV,8600,11.5,yellow,black,yellow,black,yellow,gold,25,35\n266,120,1,360,5,2,V,MAF2,false,true,false,Dashboard,MAF2V,MAF2V,8600,-1,yellow,black,yellow,black,yellow,gold,25,35\n266,120,267,360,95,0,°,ECT,false,true,false,Dashboard,Watertemp,Watertemp,98,-1,yellow,black,yellow,black,yellow,gold,25,35\n266,120,533,360,100,2,V,TPS V,false,true,false,Dashboard,ThrottleV,ThrottleV,8600,-1,yellow,black,yellow,black,yellow,gold,25,35");
//        writeDashFile("MainDash.txt","266,80,380,305,2,2,,Boost,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,transparent,grey,white,blue,25,35\n266,80,0,480,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n266,80,380,480,5,0,,Knock,false,false,false,Dashboard,Knock,Knock,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n266,80,760,480,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40");
//        writingDefaultFiles = 0;
    }


    QDir directory(QStandardPaths::writableLocation(QStandardPaths::AppDataLocation)+"/dashfiles/");
    QStringList dashfiles = directory.entryList(QStringList() << "*.txt",QDir::Files);
    m_dashBoard->setdashfiles(dashfiles);
//    QRect rec = QApplication::desktop()->screenGeometry();
//    int height = rec.height();
//    int width = rec.width();
//    qDebug()<< "height";
//    qDebug()<< height;
//    qDebug()<< "width";
//    qDebug()<< width;
    //qDebug() <<"files" << dashfiles ;
}

void Connect::readMaindashsetup()
{
    // QString path = "MainDash.txt";//for Windows
//    QString path = "/home/pi/BoostedGarage/exampleDash/MainDash.txt";
    QString path = QStandardPaths::writableLocation(QStandardPaths::AppDataLocation) + "/dashfiles/" + "MainDash.txt";
    QFile inputFile(path);
    if (inputFile.open(QIODevice::ReadOnly))
    {
        QTextStream in(&inputFile);
        while (!in.atEnd())
        {
            QString line = in.readLine();
            QStringList list = line.split(QRegExp("\\,"));
            m_dashBoard->setmaindashsetup(list);
        }
        inputFile.close();
    }

}
void Connect::readdashsetup5()
{
    //QString path = dashfilename4;//for Windows
//    QString path = "/home/pi/BoostedGarage/exampleDash/"+dashfilename5;
    QString path = QStandardPaths::writableLocation(QStandardPaths::AppDataLocation) + "/dashfiles/" +dashfilename5;
    QFile inputFile(path);
    if (inputFile.open(QIODevice::ReadOnly))
    {
        QTextStream in(&inputFile);
        while (!in.atEnd())
        {
            QString line = in.readLine();
            QStringList list = line.split(QRegExp("\\,"));
            m_dashBoard->setdashsetup5(list);
        }
        inputFile.close();
    }

}
void Connect::readdashsetup4()
{
    //QString path = dashfilename4;//for Windows
//    QString path = "/home/pi/BoostedGarage/exampleDash/"+dashfilename4;
    QString path = QStandardPaths::writableLocation(QStandardPaths::AppDataLocation) + "/dashfiles/" +dashfilename4;

    QFile inputFile(path);
    if (inputFile.open(QIODevice::ReadOnly))
    {
        QTextStream in(&inputFile);
        while (!in.atEnd())
        {
            QString line = in.readLine();
            QStringList list = line.split(QRegExp("\\,"));
            m_dashBoard->setdashsetup4(list);
        }
        inputFile.close();
    }

}
void Connect::readdashsetup3()
{
    //QString path = dashfilename3;//for Windows
//    QString path = "/home/pi/BoostedGarage/exampleDash/"+dashfilename3;
    QString path = QStandardPaths::writableLocation(QStandardPaths::AppDataLocation) + "/dashfiles/" +dashfilename3;

    QFile inputFile(path);
    if (inputFile.open(QIODevice::ReadOnly))
    {
        QTextStream in(&inputFile);
        while (!in.atEnd())
        {
            QString line = in.readLine();
            QStringList list = line.split(QRegExp("\\,"));
            m_dashBoard->setdashsetup3(list);
        }
        inputFile.close();
    }

}
void Connect::readdashsetup2()
{

    //QString path = dashfilename2;//for Windows
//    QString path = "/home/pi/BoostedGarage/exampleDash/"+dashfilename2;
    QString path = QStandardPaths::writableLocation(QStandardPaths::AppDataLocation) + "/dashfiles/" +dashfilename2;

    QFile inputFile(path);
    if (inputFile.open(QIODevice::ReadOnly))
    {
        QTextStream in(&inputFile);
        while (!in.atEnd())
        {
            QString line = in.readLine();
            QStringList list = line.split(QRegExp("\\,"));
            m_dashBoard->setdashsetup2(list);
        }
        inputFile.close();
    }

}
void Connect::readdashsetup1()
{

    //QString path = dashfilename1;//for Windows
//    QString path = "/home/pi/BoostedGarage/exampleDash/"+dashfilename1;
    QString path = QStandardPaths::writableLocation(QStandardPaths::AppDataLocation) + "/dashfiles/" +dashfilename1;

    QFile inputFile(path);
    if (inputFile.open(QIODevice::ReadOnly))
    {
        QTextStream in(&inputFile);
        while (!in.atEnd())
        {
            QString line = in.readLine();
            QStringList list = line.split(QRegExp("\\,"));
            m_dashBoard->setdashsetup1(list);
        }
        inputFile.close();
    }

}

void Connect::setSreenbrightness(const int &brightness)
{

    //This works only on raspberry pi
    QFile f("/sys/class/backlight/rpi_backlight/brightness");
    //f.close();
    f.open(QIODevice::WriteOnly | QIODevice::Truncate);
    QTextStream out(&f);
    out << brightness;
    //qDebug() << brightness;
    f.close();
}
void Connect::setRemoteDash(const QString &remotedashurl, const QString &remotedashport)
{

    //This works only on raspberry pi
    QDir dir(QStandardPaths::writableLocation(QStandardPaths::AppDataLocation));
    if (!dir.exists())
        dir.mkpath(".");
    QString pathTo = QStandardPaths::writableLocation(QStandardPaths::AppDataLocation) + "/remotedash.cfg";
    QFile f(pathTo);
//    QFile f("/home/pi/BoostedGarage/remotedash.cfg");
    //f.close();
    if (remotedashurl.length() == 0) {
        f.remove();
    }else {
        f.open(QIODevice::WriteOnly | QIODevice::Truncate);
        QTextStream out(&f);
        out << remotedashurl << "\n";
        out << remotedashport;
        //qDebug() << brightness;
        f.close();
    }
}
void Connect::writeReceivedDashFile(const QString &raw)
{
    QStringList list = raw.split( "~" );
    if (list.size() > 1){
        QString fileName = list[1];
        QString filecontents = list[2];
        writeDashFile(fileName,filecontents);
    }
}
void Connect::writeDashFile(const QString &fileName, const QString &fileContents)
{

    //This works only on raspberry pi
    QDir dir(QStandardPaths::writableLocation(QStandardPaths::AppDataLocation)+"/dashfiles/");
    if (!dir.exists()){
        dir.mkpath(".");
//        writeDashFile("Sample2","150,80,823,172,2,2,,BOOST,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,#00000000,grey,red,blue,25,35,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,844,76,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,#00000000,grey,red,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,908,255,5,0,,KNOCK,false,false,false,Dashboard,Knock,Knock,20000,-2000,transparent,transparent,#00000000,grey,white,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,943,165,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,#00000000,grey,white,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n250,250,476,4,8,0,rpm,Tacho,false,false,false,Dashboard,rpm,rpm,6.5,-2000,transparent,transparent,transparent,grey,white,blue,28,40,TachoGauge,white,red,#ffffff,pink,red,red,blue,white,red,green,yellow,orange,transparent,1,-90,180,45,false,6,\n250,250,483,300,10,0,rpm,Tacho2,false,false,false,Dashboard,rpm,rpm,5,-2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,TachoGauge,blue,purple,pink,steelblue,red,red,blue,white,red,pink,red,red,transparent,1,-135,135,135,false,6,\n250,250,353,273,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,6000,1000,transparent,transparent,transparent,grey,grey,steelblue,28,40,RoundGauge,lightblue,red,black,red,white,blue,black,white,red,pink,red,red,transparent,1,-135,135,0,true,9,\n250,250,330,-7,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,RoundGauge,#0066FF,#cc0000,white,#0099FF,white,blue,black,white,red,pink,red,red,transparent,1,-135,135,0,false,20,");
//        writeDashFile("Sample3","1024,600,0,0,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,image,#0066FF,#cc0000,white,#0099FF,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,false,20,/home/pi/splash.png\n150,80,300,200,2,2,,BOOST,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,transparent,grey,red,blue,25,35\n150,80,450,200,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,transparent,grey,red,blue,28,40\n150,80,300,280,5,0,,KNOCK,false,false,false,Dashboard,Knock,Knock,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n150,80,450,280,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n250,250,100,0,300,0,kph,Speedo,false,false,false,Dashboard,Speed,Speed,260,-2000,transparent,transparent,transparent,grey,white,blue,28,40,speedogauge,,,,yellow,,,,,,blue,steelblue,lightblue,,10,-180,90,-45\n250,250,550,0,8,0,rpm,Tacho,false,false,false,Dashboard,rpm,rpm,6.5,-2000,transparent,transparent,transparent,grey,white,blue,28,40,tachogauge,,,,pink,,,,,,green,yellow,orange,transparent,1,-90,180,45\n250,250,100,300,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,6000,1000,transparent,transparent,transparent,grey,grey,steelblue,28,40,roundgauge,lightblue,red,black,red,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,true,9\n250,250,550,300,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,roundgauge,#0066FF,#cc0000,white,#0099FF,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,false,20");
    }
    QString pathTo = QStandardPaths::writableLocation(QStandardPaths::AppDataLocation) + "/dashfiles/";

    QString writeFileName=pathTo+fileName;
    QFile f(writeFileName);
    //f.close();
    if (f.exists()){
        int i = 0;
        QTime now = QTime::currentTime();
        QString oldFileName = writeFileName+"."+ now.toString("hh:mm:ss.zzz");
//        newFileName += i;
        while (f.rename(oldFileName) == false){
            i+=1;
            oldFileName = writeFileName+ now.toString("hh:mm:ss.zzz");
        }

    }
        QFile fwrite(writeFileName);
        fwrite.open(QIODevice::WriteOnly | QIODevice::Truncate);
        QTextStream out(&fwrite);
        out << fileContents;
        fwrite.close();
        if (writingDefaultFiles == 0){
            readavailabledashfiles();
        }

}
QString Connect::copyFileToStore(const QString &oldfileName, const QString &newFileName1)
{

    QStringList fields = newFileName1.split('/');
    QString newFileName = fields[fields.size()-1];
    QDir dir(QStandardPaths::writableLocation(QStandardPaths::AppDataLocation)+"/resources/");
    if (!dir.exists()){
        dir.mkpath(".");
//        writeDashFile("Sample2","150,80,823,172,2,2,,BOOST,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,#00000000,grey,red,blue,25,35,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,844,76,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,#00000000,grey,red,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,908,255,5,0,,KNOCK,false,false,false,Dashboard,Knock,Knock,20000,-2000,transparent,transparent,#00000000,grey,white,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,943,165,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,#00000000,grey,white,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n250,250,476,4,8,0,rpm,Tacho,false,false,false,Dashboard,rpm,rpm,6.5,-2000,transparent,transparent,transparent,grey,white,blue,28,40,TachoGauge,white,red,#ffffff,pink,red,red,blue,white,red,green,yellow,orange,transparent,1,-90,180,45,false,6,\n250,250,483,300,10,0,rpm,Tacho2,false,false,false,Dashboard,rpm,rpm,5,-2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,TachoGauge,blue,purple,pink,steelblue,red,red,blue,white,red,pink,red,red,transparent,1,-135,135,135,false,6,\n250,250,353,273,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,6000,1000,transparent,transparent,transparent,grey,grey,steelblue,28,40,RoundGauge,lightblue,red,black,red,white,blue,black,white,red,pink,red,red,transparent,1,-135,135,0,true,9,\n250,250,330,-7,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,RoundGauge,#0066FF,#cc0000,white,#0099FF,white,blue,black,white,red,pink,red,red,transparent,1,-135,135,0,false,20,");
//        writeDashFile("Sample3","1024,600,0,0,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,image,#0066FF,#cc0000,white,#0099FF,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,false,20,/home/pi/splash.png\n150,80,300,200,2,2,,BOOST,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,transparent,grey,red,blue,25,35\n150,80,450,200,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,transparent,grey,red,blue,28,40\n150,80,300,280,5,0,,KNOCK,false,false,false,Dashboard,Knock,Knock,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n150,80,450,280,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n250,250,100,0,300,0,kph,Speedo,false,false,false,Dashboard,Speed,Speed,260,-2000,transparent,transparent,transparent,grey,white,blue,28,40,speedogauge,,,,yellow,,,,,,blue,steelblue,lightblue,,10,-180,90,-45\n250,250,550,0,8,0,rpm,Tacho,false,false,false,Dashboard,rpm,rpm,6.5,-2000,transparent,transparent,transparent,grey,white,blue,28,40,tachogauge,,,,pink,,,,,,green,yellow,orange,transparent,1,-90,180,45\n250,250,100,300,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,6000,1000,transparent,transparent,transparent,grey,grey,steelblue,28,40,roundgauge,lightblue,red,black,red,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,true,9\n250,250,550,300,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,roundgauge,#0066FF,#cc0000,white,#0099FF,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,false,20");
    }
    QString pathTo = QStandardPaths::writableLocation(QStandardPaths::AppDataLocation) + "/resources/";

    QString writeFileName=pathTo+newFileName;
    QFile f(writeFileName);
    //f.close();
    if (f.exists()){
        int i = 0;
        QTime now = QTime::currentTime();
        QString oldFileName = writeFileName+"."+ now.toString("hh:mm:ss.zzz");
//        newFileName += i;
        while (f.rename(oldFileName) == false){
            i+=1;
            oldFileName = writeFileName+ now.toString("hh:mm:ss.zzz");
        }

    }
        QFile fwrite(oldfileName);
        fwrite.copy(writeFileName);
//        fwrite.open(QIODevice::WriteOnly | QIODevice::Truncate);
//        QTextStream out(&fwrite);
//        out << fileContents;
//        fwrite.close();
//        if (writingDefaultFiles == 0){
//            readavailabledashfiles();
//        }
        return writeFileName;

}
QString Connect::copyDashFile(const QString &oldfileName, const QString &newFileName1)
{

    QStringList fields = newFileName1.split('/');
    QString newFileName = fields[fields.size()-1];
    QDir dir(QStandardPaths::writableLocation(QStandardPaths::AppDataLocation)+"/dashfiles/");
    if (!dir.exists()){
        dir.mkpath(".");
//        writeDashFile("Sample2","150,80,823,172,2,2,,BOOST,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,#00000000,grey,red,blue,25,35,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,844,76,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,#00000000,grey,red,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,908,255,5,0,,KNOCK,false,false,false,Dashboard,Knock,Knock,20000,-2000,transparent,transparent,#00000000,grey,white,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n150,80,943,165,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,#00000000,grey,white,blue,28,40,SquareGauge,white,red,#ffffff,blue,red,red,blue,white,red,#ffffff,#e96448,#f22900,transparent,20,-90,180,0,false,6,\n250,250,476,4,8,0,rpm,Tacho,false,false,false,Dashboard,rpm,rpm,6.5,-2000,transparent,transparent,transparent,grey,white,blue,28,40,TachoGauge,white,red,#ffffff,pink,red,red,blue,white,red,green,yellow,orange,transparent,1,-90,180,45,false,6,\n250,250,483,300,10,0,rpm,Tacho2,false,false,false,Dashboard,rpm,rpm,5,-2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,TachoGauge,blue,purple,pink,steelblue,red,red,blue,white,red,pink,red,red,transparent,1,-135,135,135,false,6,\n250,250,353,273,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,6000,1000,transparent,transparent,transparent,grey,grey,steelblue,28,40,RoundGauge,lightblue,red,black,red,white,blue,black,white,red,pink,red,red,transparent,1,-135,135,0,true,9,\n250,250,330,-7,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,RoundGauge,#0066FF,#cc0000,white,#0099FF,white,blue,black,white,red,pink,red,red,transparent,1,-135,135,0,false,20,");
//        writeDashFile("Sample3","1024,600,0,0,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,image,#0066FF,#cc0000,white,#0099FF,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,false,20,/home/pi/splash.png\n150,80,300,200,2,2,,BOOST,false,false,false,Dashboard,BoostPres,BoostPres,20000,-2000,transparent,transparent,transparent,grey,red,blue,25,35\n150,80,450,200,160,0,,ECT,false,false,false,Dashboard,Watertemp,Watertemp,20000,-2000,transparent,transparent,transparent,grey,red,blue,28,40\n150,80,300,280,5,0,,KNOCK,false,false,false,Dashboard,Knock,Knock,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n150,80,450,280,100,0,,IAT,false,false,false,Dashboard,Intaketemp,Intaketemp,20000,-2000,transparent,transparent,transparent,grey,white,blue,28,40\n250,250,100,0,300,0,kph,Speedo,false,false,false,Dashboard,Speed,Speed,260,-2000,transparent,transparent,transparent,grey,white,blue,28,40,speedogauge,,,,yellow,,,,,,blue,steelblue,lightblue,,10,-180,90,-45\n250,250,550,0,8,0,rpm,Tacho,false,false,false,Dashboard,rpm,rpm,6.5,-2000,transparent,transparent,transparent,grey,white,blue,28,40,tachogauge,,,,pink,,,,,,green,yellow,orange,transparent,1,-90,180,45\n250,250,100,300,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,6000,1000,transparent,transparent,transparent,grey,grey,steelblue,28,40,roundgauge,lightblue,red,black,red,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,true,9\n250,250,550,300,10000,0,rpm,Tacho3,false,false,false,Dashboard,rpm,rpm,8500,2000,transparent,transparent,transparent,grey,grey,steelblue,28,40,roundgauge,#0066FF,#cc0000,white,#0099FF,white,blue,black,,,pink,red,red,transparent,1,-135,135,0,false,20");
    }
    QString pathTo = QStandardPaths::writableLocation(QStandardPaths::AppDataLocation) + "/dashfiles/";

    QString writeFileName=pathTo+newFileName;
    QFile f(writeFileName);
    //f.close();
    if (f.exists()){
        int i = 0;
        QTime now = QTime::currentTime();
        QString oldFileName = writeFileName+"."+ now.toString("hh:mm:ss.zzz");
//        newFileName += i;
        while (f.rename(oldFileName) == false){
            i+=1;
            oldFileName = writeFileName+ now.toString("hh:mm:ss.zzz");
        }

    }
        QFile fwrite(oldfileName);
        fwrite.copy(writeFileName);
        fwrite.open(QIODevice::ReadOnly);
//        m_udpreceiver->broadcastFile("NEWDASH~"+newFileName+"~"+fwrite.readAll());
        m_mainwindow->onSendFilesActionTriggered(oldfileName);
        //        fwrite.open(QIODevice::WriteOnly | QIODevice::Truncate);
//        QTextStream out(&fwrite);
//        out << fileContents;
//        fwrite.close();
//        if (writingDefaultFiles == 0){
            readavailabledashfiles();
//        }
        return writeFileName;

}
void Connect::setSpeedUnits(const int &units1)
{
    switch (units1)
    {
    case 0:
        m_dashBoard->setspeedunits("metric");
        break;
    case 1:
        m_dashBoard->setspeedunits("imperial");
        break;

    default:
        break;
    }

}
void Connect::setUnits(const int &units)
{
    switch (units)
    {
    case 0:
        m_dashBoard->setunits("metric");
        break;
    case 1:
        m_dashBoard->setunits("imperial");
        break;

    default:
        break;
    }

}
void Connect::setWidth(const int &width1)
{
    width = width1;
}
void Connect::setHeight(const int &height1)
{
    height = height1;
//    m_dashBoard->setOrientation(height1);
}
void Connect::setOrientation()
{
    m_dashBoard->setOrientation(5);
}
int Connect::getWidth()
{
    return width;
}
int Connect::getHeight()
{
    return height;
}

void Connect::setPressUnits(const int &units2)
{

    switch (units2)
    {
    case 0:
        m_dashBoard->setpressureunits("metric");
        break;
    case 1:
        m_dashBoard->setpressureunits("imperial");
        break;

    default:
        break;
    }

}

void Connect::setWeight(const int &weight)
{
    m_dashBoard->setWeight(weight);
}

void Connect::pageNo(const qreal &pageNo)
{
    m_dashBoard->pageNo(pageNo);
}

void Connect::updatePageNo(const qreal &pageNo)
{
    m_dashBoard->updatePageNo(pageNo);
}

void Connect::sourceIndex(const qreal &sourceIndex)
{
    m_dashBoard->sourceIndex(sourceIndex);
}

void Connect::setOdometer(const qreal &Odometer)
{
    m_dashBoard->setOdo(Odometer);
    m_calculations->start();
}
void Connect::qmlTreeviewclicked(const QModelIndex &index)
{
    QString mPath = dirModel->fileInfo(index).absoluteFilePath();
    //mPath.remove(0, 2); //this is needed for windows
    QString mPathnew = "file://" + mPath;
    m_dashBoard->setmusicpath(mPathnew);
}

void Connect::getPorts()
{
    QStringList PortList;
    foreach(const QSerialPortInfo &info, QSerialPortInfo::availablePorts())
    {
        PortList.append(info.portName());
    }
    setPortsNames(PortList);
    // Check available ports every 1000 ms
    QTimer::singleShot(1000, this, SLOT(getPorts()));
}
//function for flushing all Connect buffers
void Connect::clear() const
{
    // m_Connectport->clear();
}
// Reads the file of supported OBD PIDS and makes it available to QML for the User to select which PIDS should be polled 
void Connect::checkOBDReg() 
{
    int i = 0;
    bool ok;
    QStringList list;

    QString path = "/home/pi/daemons/OBDPIDS.txt";
    // QString path = "SupportedPIDS.txt";
    QFile inputFile(path);
    if (inputFile.open(QIODevice::ReadOnly))
    {
        QTextStream in(&inputFile);
        while (!in.atEnd())
        {
            QString line = in.readLine();
            list = line.split(QRegExp("\\,"));
        }
        inputFile.close();
    }
    while (i < list.length()) {
        //qDebug()<< "Enter Loop" <<i;
        int pidread = (list[i].toInt(&ok, 16));
        m_dashBoard->setsupportedReg(pidread);
        //qDebug()<< "Reading" << list[i];
        i ++;
    }

}

void Connect::checkReg()
{
    int i = 0;
    bool ok;
    QStringList list;
    //QString path = "Regs.txt";
    QString path = "/home/pi/daemons/Regs.txt";
    QFile inputFile(path);
    if (inputFile.open(QIODevice::ReadOnly))
    {
        QTextStream in(&inputFile);
        while (!in.atEnd())
        {
            QString line = in.readLine();
            list = line.split(QRegExp("\\,"));
        }
        inputFile.close();
    }
    while (i < list.length()) {
        qDebug()<< "Read supported Consult Reg" <<list[i];
        switch (list[i].toInt(&ok, 16))
        {

        case 0x00:
            m_dashBoard->setsupportedReg(0);
            i ++;
            break;
        case 0x01:
            m_dashBoard->setsupportedReg(1);
            i ++;
            break;
        case 0x02:
            m_dashBoard->setsupportedReg(2);
            i ++;
            break;
        case 0x03:
            m_dashBoard->setsupportedReg(3);
            i ++;
            break;
        case 0x04:
            m_dashBoard->setsupportedReg(4);
            i ++;
            break;
        case 0x05:
            m_dashBoard->setsupportedReg(5);
            i ++;
            break;
        case 0x06:
            m_dashBoard->setsupportedReg(6);
            i ++;
            break;
        case 0x07:
            m_dashBoard->setsupportedReg(7);
            i ++;
            break;
        case 0x08:
            m_dashBoard->setsupportedReg(8);
            i ++;
            break;
        case 0x09:
            m_dashBoard->setsupportedReg(9);
            i ++;
            break;
        case 0x0a:
            m_dashBoard->setsupportedReg(10);
            i ++;
            break;
        case 0x0b:
            m_dashBoard->setsupportedReg(11);
            i ++;
            break;
        case 0x0c:
            m_dashBoard->setsupportedReg(12);
            i ++;
            break;
        case 0x0d:
            m_dashBoard->setsupportedReg(13);
            i ++;
            break;
        case 0x0f:
            m_dashBoard->setsupportedReg(14);
            i ++;
            break;
        case 0x11:
            m_dashBoard->setsupportedReg(15);
            i ++;
            break;
        case 0x12:
            m_dashBoard->setsupportedReg(16);
            i ++;
            break;
        case 0x13:
            m_dashBoard->setsupportedReg(17);
            i ++;
            break;
        case 0x14:
            m_dashBoard->setsupportedReg(18);
            i ++;
            break;
        case 0x15:
            m_dashBoard->setsupportedReg(19);
            i ++;
            break;
        case 0x16:
            m_dashBoard->setsupportedReg(20);
            i ++;
            break;
        case 0x17:
            m_dashBoard->setsupportedReg(21);
            i ++;
            break;
        case 0x1a:
            m_dashBoard->setsupportedReg(22);
            i ++;
            break;
        case 0x1b:
            m_dashBoard->setsupportedReg(23);
            i ++;
            break;
        case 0x1c:
            m_dashBoard->setsupportedReg(24);
            i ++;
            break;
        case 0x1d:
            m_dashBoard->setsupportedReg(25);
            i ++;
            break;
        case 0x1e:
            m_dashBoard->setsupportedReg(26);
            i ++;
            break;
        case 0x1f:
            m_dashBoard->setsupportedReg(27);
            i ++;
            break;
        case 0x21:
            m_dashBoard->setsupportedReg(28);
            i ++;
            break;
        case 0x22:
            m_dashBoard->setsupportedReg(29);
            i ++;
            break;
        case 0x23:
            m_dashBoard->setsupportedReg(30);
            i ++;
            break;
        case 0x28:
            m_dashBoard->setsupportedReg(31);
            i ++;
            break;
        case 0x29://corrct
            m_dashBoard->setsupportedReg(32);
            i ++;
            break;
        case 0x2a://corrct
            m_dashBoard->setsupportedReg(33);
            i ++;
            break;
        case 0x2e://corrct
            m_dashBoard->setsupportedReg(34);
            i ++;
            break;
        case 0x25://corrct
            m_dashBoard->setsupportedReg(35);
            i ++;
            break;
        case 0x26://corrct
            m_dashBoard->setsupportedReg(36);
            i ++;
            break;
        case 0x27://corrct
            m_dashBoard->setsupportedReg(37);
            i ++;
            break;
        case 0x2f:
            m_dashBoard->setsupportedReg(38);
            i ++;
            break;
        case 0x30:
            m_dashBoard->setsupportedReg(39);
            i ++;
            break;
        case 0x31:
            m_dashBoard->setsupportedReg(40);
            i ++;
            break;
        case 0x32:
            m_dashBoard->setsupportedReg(41);
            i ++;
            break;
        case 0x33:
            m_dashBoard->setsupportedReg(42);
            i ++;
            break;
        case 0x34:
            m_dashBoard->setsupportedReg(43);
            i ++;
            break;
        case 0x35:
            m_dashBoard->setsupportedReg(44);
            i ++;
            break;
        case 0x36:
            m_dashBoard->setsupportedReg(45);
            i ++;
            break;
        case 0x37:
            m_dashBoard->setsupportedReg(46);
            i ++;
            break;
        case 0x38:
            m_dashBoard->setsupportedReg(47);
            i ++;
            break;
        case 0x39:
            m_dashBoard->setsupportedReg(48);
            i ++;
            break;
        case 0x3a:
            m_dashBoard->setsupportedReg(49);
            i ++;
            break;
        case 0x4a:
            m_dashBoard->setsupportedReg(50);
            i ++;
            break;
        case 0x52:
            m_dashBoard->setsupportedReg(51);
            i ++;
            break;
        case 0x53:
            m_dashBoard->setsupportedReg(52);
            i ++;
            break;
        case 0xFE:
            //Not supported Register
            i ++;
            break;

        default:
            break;
        }
    }

}

void Connect::liveReqMsgOBD(const QString &obdpids)
{
    qDebug()<< "PIDS" <<obdpids;
    QString Message;
    QStringList list = obdpids.split( "," );
    //qDebug()<< "Raw list" <<list;
    QString fileName = "/home/pi/daemons/OBD.cfg";//This will be the correct path on pi
    //QString fileName = "OBD.cfg";//for testing on windows
    QFile mFile(fileName);
    mFile.open(QIODevice::ReadWrite | QIODevice::Truncate | QIODevice::Text);
    int i =0;
    while(i < list.length())
    {
        if (list[i] == "2")
        {
            // qDebug()<< "i" <<i;
            QString hexadecimal;
            hexadecimal.setNum(i,16);
            if(hexadecimal.length() %2)hexadecimal.insert(0,QLatin1String("0"));
            // qDebug()<< "Hex" <<hexadecimal;
            Message.append("0x"+hexadecimal);
            Message.append(",");
        }
        i++;
    }
    Message.remove(Message.length()-1,1); //Remove the last Comma
    //qDebug()<< "PID LST" <<Message;
    QTextStream out(&mFile);
    out << Message;
    mFile.close();

    //Reboot the PI for settings to take Effect
    m_dashBoard->setSerialStat("Rebooting ");
    QProcess *process = new QProcess(this);
    process->start("sudo reboot");
    process->waitForFinished(100); // 10 minutes time before timeout
}

void Connect::daemonstartup(const int &daemon)
{
    QString daemonstart;
    switch (daemon)
    {
    case 0:
        daemonstart = "";
        break;
    case 1:
        daemonstart = "./Haltechd";
        break;
    case 2:
        daemonstart = "./Linkd";
        break;
    case 3:
        daemonstart = "./Microtechd";
        break;
    case 4:
        daemonstart = "./Consult /dev/ttyUSB0";
        break;
    case 5:
        daemonstart = "./Apexid /dev/ttyUSB0";
        break;
    case 6:
        daemonstart = "./OBD /dev/ttyUSB0";
        break;

    }
    QString fileName = "/home/pi/startdaemon.sh";//This will be the correct path on pi
    //QString fileName = "startdaemon.sh";//for testing on windows
    QFile mFile(fileName);
    mFile.open(QIODevice::ReadWrite | QIODevice::Truncate | QIODevice::Text);
    QTextStream out(&mFile);
    out << "#!/bin/sh"
        << endl
        << "cd /home/pi/daemons"
        << endl
        << daemonstart
        << endl;
    mFile.close();

    //Reboot the PI for settings to take Effect
    m_dashBoard->setSerialStat("Rebooting ");
    QProcess *process = new QProcess(this);
    process->start("sudo reboot");
    process->waitForFinished(100); // 10 minutes time before timeout
}

void Connect::liveReqMsg(const int &val1, const int &val2, const int &val3, const int &val4, const int &val5, const int &val6, const int &val7, const int &val8, const int &val9, const int &val10, const int &val11, const int &val12, const int &val13, const int &val14, const int &val15, const int &val16, const int &val17, const int &val18, const int &val19, const int &val20, const int &val21, const int &val22, const int &val23, const int &val24, const int &val25, const int &val26, const int &val27, const int &val28, const int &val29, const int &val30, const int &val31, const int &val32, const int &val33, const int &val34, const int &val35, const int &val36, const int &val37, const int &val38, const int &val39, const int &val40, const int &val41, const int &val42, const int &val43, const int &val44 , const int &val45)
{
    QString Message;

    if (val1 == 2)
    {Message.append("0x00,0x01,");}//RPM}
    if (val2 == 2)
    {Message.append("0x02,0x03,");}//RPMREF}
    if (val3 == 2)
    {Message.append("0x04,0x05,");}//MAFVoltage}
    if (val4 == 2)
    {Message.append("0x06,0x07,");}//RHMAFVoltage}
    if (val5 == 2)
    {Message.append("0x08,");}//Coolant Temp}
    if (val6 == 2)
    {Message.append("0x09,");}//LH 02 volt}
    if (val7 == 2)
    {Message.append("0x0a,");}//RH 02 volt}
    if (val8 == 2)
    {Message.append("0x0b,");}//Speed}
    if (val9 == 2)
    {Message.append("0x0c,");}//Battery Voltage}
    if (val10 == 2)
    {Message.append("0x0d,");}//TPS Voltage}
    if (val11 == 2)
    {Message.append("0x0f,");}//FuelTemp}
    if (val12 == 2)
    {Message.append("0x11,");}//Intake Temp}
    if (val13 == 2)
    {Message.append("0x12,");}//EGT}
    if (val14 == 2)
    {Message.append("0x13,");}//Digital Bit Register}
    if (val15 == 2)
    {Message.append("0x14,0x15,");}//Injection Time (LH)}
    if (val16 == 2)
    {Message.append("0x16,");}//Ignition Timing}
    if (val17 == 2)
    {Message.append("0x17,");}//AAC Valve (Idle Air Valve %)}
    if (val18 == 2)
    {Message.append("0x1a,");}//A/F ALPHA-LH}
    if (val19 == 2)
    {Message.append("0x1b,");}//A/F ALPHA-RH}
    if (val20 == 2)
    {Message.append("0x1c,");}//A/F ALPHA-LH (SELFLEARN)}
    if (val21 == 2)
    {Message.append("0x1d,");}//A/F ALPHA-RH (SELFLEARN)}
    if (val22 == 2)
    {Message.append("0x1e,");}//Digital Control Register 1}
    if (val23 == 2)
    {Message.append("0x1f,");}//Digital Control Register 2}
    if (val24 == 2)
    {Message.append("0x21,");}//M/R F/C MNT}
    if (val25 == 2)
    {Message.append("0x22,0x23,");}//Injector time (RH)}
    if (val26 == 2)
    {Message.append("0x28,");}//Waste Gate Solenoid %}
    if (val27 == 2)
    {Message.append("0x29,");}//Turbo Boost Sensor, Voltage}
    if (val28 == 2)
    {Message.append("0x2a,");}//Engine Mount On/Off}
    if (val29 == 2)
    {Message.append("0x2e,");}//Position Counter}
    if (val30 == 2)
    {Message.append("0x25,");}//Purg. Vol. Control Valve, Step}
    if (val31 == 2)
    {Message.append("0x26,");}//Tank Fuel Temperature, C}
    if (val32 == 2)
    {Message.append("0x27,");}//FPCM DR, Voltage}
    if (val33 == 2)
    {Message.append("0x2f,");}//Fuel Gauge, Voltage}
    if (val34 == 2)
    {Message.append("0x30,");}//FR O2 Heater-B1}
    if (val35 == 2)
    {Message.append("0x31,");}//FR O2 Heater-B2}
    if (val36 == 2)
    {Message.append("0x32,");}//Ignition Switch}
    if (val37 == 2)
    {Message.append("0x33,");}//CAL/LD Value, %}
    if (val38 == 2)
    {Message.append("0x34,");}//B/Fuel Schedule, mS}
    if (val39 == 2)
    {Message.append("0x35,");}//RR O2 Sensor Voltage}
    if (val40 == 2)
    {Message.append("0x36,");}//RR O2 Sensor-B2 Voltage}
    if (val41 == 2)
    {Message.append("0x37,");}//Absolute Throttle Position, Voltage }
    if (val42 == 2)
    {Message.append("0x38,");}//MAF gm/S}
    if (val43 == 2)
    {Message.append("0x39,");}//Evap System Pressure, Voltage}
    if (val44 == 2)
    {Message.append("0x3a,0x4a,");}//Absolute Pressure Sensor,Voltage}
    if (val45 == 2)
    {Message.append("0x52,0x53,");}//FPCM F/P Voltage}
    Message.remove(Message.length()-1,1); // remove the last comma from string
    //qDebug()<< "write" <<Message;


    QString fileName = "/home/pi/daemons/Consult.cfg";//This will be the correct path on pi
    //QString fileName = "Consult.cfg";//for testing on windows
    QFile mFile(fileName);
    mFile.open(QIODevice::ReadWrite | QIODevice::Truncate | QIODevice::Text);

    QTextStream out(&mFile);
    out << Message;
    mFile.close();

    //Reboot the PI for settings to take Effect
    m_dashBoard->setSerialStat("Rebooting ");
    QProcess *process = new QProcess(this);
    process->start("sudo reboot");
    process->waitForFinished(100); // 10 minutes time before timeout

}
void Connect::openConnection(const QString &portName, const int &ecuSelect)
{
    ecu = ecuSelect;
    selectedPort = portName;

    //Apexi
    if (ecuSelect == 0)
    {
        m_udpreceiver->startreceiver();

//        m_apexi->openConnection(portName);

    }

    //UDP receiver
    if (ecu == 1)
    {
        m_udpreceiver->startreceiver();
    }
    //Adaptronic
    if (ecuSelect == 2)
    {
        m_adaptronicselect->openConnection(portName);

    }

    //Adaptronic ModularCAN protocol
    if (ecuSelect == 3)
    {
        QProcess *process = new QProcess(this);
        process->start("/home/pi/Adaptronic/AdaptronicCAN");
        m_udpreceiver->startreceiver();
    }
    if (ecuSelect == 4)
    {
        //NissanConsult
        //QProcess *process = new QProcess(this);
        //process->start("/home/pi/Consult/Consult /dev/"+(portName));
        //qDebug() << "/dev/"+(portName);
        //m_udpreceiver->startreceiver();
        //        m_arduino->openConnection(portName);
        powermods = new QProcess(this);  // create on the heap, so it doesn't go out of scope
        connect (powermods, SIGNAL(readyReadStandardOutput()), this, SLOT(processOutputPMods()));  // connect process signals with your code
        connect (powermods, SIGNAL(readyReadStandardError()), this, SLOT(processOutputPMods()));  // same here
        powermods->start("python /home/pi/pythonqmltest/connector.py");  // start the process

    }
    if (ecuSelect == 5)
    {
        //HaltechV1
        QProcess *process = new QProcess(this);
        process->start("/home/pi/Haltech/HaltechV1");
        m_udpreceiver->startreceiver();
    }
    if (ecuSelect == 6)
    {
        //HaltechV2
        m_dashBoard->setFlagString1("Clutch");
        m_dashBoard->setFlagString2("Brake");
        m_dashBoard->setFlagString3("TransThrottle");
        m_dashBoard->setFlagString4("Decel Cut");
        m_dashBoard->setFlagString5("Gear Switch");
        m_dashBoard->setFlagString6("Torque Red.");
        m_dashBoard->setFlagString7("Flat Shift");
        m_dashBoard->setFlagString8("Aux RPM Limit");
        m_dashBoard->setFlagString9("Antilag");
        m_dashBoard->setFlagString10("MIL");
        m_dashBoard->setFlagString11("Batt. Light");
        m_dashBoard->setFlagString12("Eng. Limiter");
        m_dashBoard->setFlagString13("Ignition");
        m_dashBoard->setFlagString14("NOS Stage 1");
        m_dashBoard->setFlagString15("NOS Stage 2");
        m_dashBoard->setFlagString16("NOS Stage 3");
        //m_dashBoard->setFlagString17("NOS Stage 4");
        //m_dashBoard->setFlagString18("NOS Stage 5");
        //m_dashBoard->setFlagString19("NOS Stage 6");

        QProcess *process = new QProcess(this);
        process->start("/home/pi/Haltech/HaltechV2");
        m_udpreceiver->startreceiver();
    }

    if (ecuSelect == 7)
    {
        m_udpreceiver->startreceiver();
    }
    /* //Dicktator
    if (ecuSelect == 9)
    {

        initConnectPort();
        m_Connectport->setPortName(portName);
        m_Connectport->setBaudRate(QConnectPort::Baud19200);
        m_Connectport->setParity(QConnectPort::NoParity);
        m_Connectport->setDataBits(QConnectPort::Data8);
        m_Connectport->setStopBits(QConnectPort::OneStop);
        m_Connectport->setFlowControl(QConnectPort::NoFlowControl);

        if(m_Connectport->open(QIODevice::ReadWrite) == false)
        {
            m_dashBoard->setConnectStat(m_Connectport->errorString());
        }
        else
        {
            m_dashBoard->setConnectStat(QString("Connected to Connectport"));
        }
    }*/

}

void Connect::reopenConnection()
{
    //    ecu = ecuSelect;
    //    selectedPort = portName;

    //Apexi
    closeConnection();
    if (ecu == 0)
    {

        m_apexi->openConnection(selectedPort);

    }

    //UDP receiver
    if (ecu == 1)
    {
        m_udpreceiver->startreceiver();
    }
    //Adaptronic
    if (ecu == 2)
    {
        m_adaptronicselect->openConnection(selectedPort);

    }

    //Adaptronic ModularCAN protocol
    if (ecu == 3)
    {
        QProcess *process = new QProcess(this);
        process->start("/home/pi/Adaptronic/AdaptronicCAN");
        m_udpreceiver->startreceiver();
    }
    if (ecu == 4)
    {
        //NissanConsult
        //QProcess *process = new QProcess(this);
        //process->start("/home/pi/Consult/Consult /dev/"+(portName));
        //qDebug() << "/dev/"+(portName);
        //m_udpreceiver->startreceiver();
        //        m_arduino->openConnection(portName);
        powermods = new QProcess(this);  // create on the heap, so it doesn't go out of scope
        connect (powermods, SIGNAL(readyReadStandardOutput()), this, SLOT(processOutputPMods()));  // connect process signals with your code
        connect (powermods, SIGNAL(readyReadStandardError()), this, SLOT(processOutputPMods()));  // same here
        powermods->start("python /home/pi/pythonqmltest/connector.py");  // start the process

    }
    if (ecu == 5)
    {
        //HaltechV1
        QProcess *process = new QProcess(this);
        process->start("/home/pi/Haltech/HaltechV1");
        m_udpreceiver->startreceiver();
    }
    if (ecu == 6)
    {
        //HaltechV2
        m_dashBoard->setFlagString1("Clutch");
        m_dashBoard->setFlagString2("Brake");
        m_dashBoard->setFlagString3("TransThrottle");
        m_dashBoard->setFlagString4("Decel Cut");
        m_dashBoard->setFlagString5("Gear Switch");
        m_dashBoard->setFlagString6("Torque Red.");
        m_dashBoard->setFlagString7("Flat Shift");
        m_dashBoard->setFlagString8("Aux RPM Limit");
        m_dashBoard->setFlagString9("Antilag");
        m_dashBoard->setFlagString10("MIL");
        m_dashBoard->setFlagString11("Batt. Light");
        m_dashBoard->setFlagString12("Eng. Limiter");
        m_dashBoard->setFlagString13("Ignition");
        m_dashBoard->setFlagString14("NOS Stage 1");
        m_dashBoard->setFlagString15("NOS Stage 2");
        m_dashBoard->setFlagString16("NOS Stage 3");
        //m_dashBoard->setFlagString17("NOS Stage 4");
        //m_dashBoard->setFlagString18("NOS Stage 5");
        //m_dashBoard->setFlagString19("NOS Stage 6");

        QProcess *process = new QProcess(this);
        process->start("/home/pi/Haltech/HaltechV2");
        m_udpreceiver->startreceiver();
    }

    if (ecu == 7)
    {
        m_udpreceiver->startreceiver();
    }
    /* //Dicktator
    if (ecuSelect == 9)
    {

        initConnectPort();
        m_Connectport->setPortName(portName);
        m_Connectport->setBaudRate(QConnectPort::Baud19200);
        m_Connectport->setParity(QConnectPort::NoParity);
        m_Connectport->setDataBits(QConnectPort::Data8);
        m_Connectport->setStopBits(QConnectPort::OneStop);
        m_Connectport->setFlowControl(QConnectPort::NoFlowControl);

        if(m_Connectport->open(QIODevice::ReadWrite) == false)
        {
            m_dashBoard->setConnectStat(m_Connectport->errorString());
        }
        else
        {
            m_dashBoard->setConnectStat(QString("Connected to Connectport"));
        }
    }*/

}

void Connect::processOutputPMods()
{
    qDebug() << powermods->readAllStandardOutput();  // read normal output
    qDebug() << powermods->readAllStandardError();  // read error channel
}

void Connect::closeConnection()
{

    m_calculations->stop();
    //Apexi
    if (ecu == 0)
    {

        m_apexi->closeConnection();

    }
    //UDP receiver
    if (ecu == 1)
    {
        m_udpreceiver->closeConnection();
    }

    //Adaptronic Select
    if (ecu == 2)
    {
        m_adaptronicselect->closeConnection();

    }
    //Adaptronic ModularCAN protocol
    if (ecu == 3)
    {

        m_udpreceiver->closeConnection();

    }
    if (ecu == 4)
    {

        // QProcess *process = new QProcess(this);
        // process->start("sudo pkill Consult");
        // qDebug()<<"Kill";
        m_udpreceiver->closeConnection();
    }
    if (ecu == 5)
    {

        QProcess *process = new QProcess(this);
        process->start("sudo pkill HaltechV1");
        qDebug()<<"Kill";

    }
    if (ecu == 6)
    {

        QProcess *process = new QProcess(this);
        process->start("sudo pkill HaltechV2");
        qDebug()<<"Kill";

    }

}

void Connect::update()
{
    /*
    m_dashBoard->setSerialStat("Update started");
    QProcess *process = new QProcess(this);
    connect(process , SIGNAL(finished(int,QProcess::ExitStatus)), this, SLOT(updatefinished(int, QProcess::ExitStatus)));
    process->start("/home/pi/updateBoostedGarage.sh");
    process->waitForFinished(6000000); // 10 minutes time before timeout
    */
    QProcess *p = new QProcess( this );

    if (p)
    {
        p->setEnvironment( QProcess::systemEnvironment() );
        p->setProcessChannelMode( QProcess::MergedChannels );
        p->start("/home/pi/updateBoostedGarage.sh", QStringList() << "echo" << "hye" );
        p->waitForStarted();

        connect( p, SIGNAL(readyReadStandardOutput()), this, SLOT(processOutput()) );
        //connect( p, SIGNAL(readyReadStandardError()), this, SLOT(ReadErr()) );
    }
}

void Connect::shutdown()
{
    m_dashBoard->setSerialStat("Shutting Down");
    QProcess *process = new QProcess(this);
    process->start("sudo shutdown -h now");
    process->waitForFinished(100); // 10 minutes time before timeout
}
void Connect::reboot()
{
    m_dashBoard->setSerialStat("Rebooting");
    QProcess *process = new QProcess(this);
    process->start("sudo reboot");
    process->waitForFinished(100); // 10 minutes time before timeout
}
void Connect::candump()
{
    QProcess *p = new QProcess( this );

    if (p)
    {
        p->setEnvironment( QProcess::systemEnvironment() );
        p->setProcessChannelMode( QProcess::MergedChannels );
        p->start( "/home/pi/daemons/OBD /dev/ttyUSB0", QStringList() << "echo" << "hye" );
        p->waitForStarted();

        connect( p, SIGNAL(readyReadStandardOutput()), this, SLOT(processOutput()) );
        //connect( p, SIGNAL(readyReadStandardError()), this, SLOT(ReadErr()) );
    }
}
void Connect::minicom()
{
    QProcess *p = new QProcess( this );

    if (p)
    {
        p->setEnvironment( QProcess::systemEnvironment() );
        p->setProcessChannelMode( QProcess::MergedChannels );
        p->start( "minicom", QStringList() << "echo" << "hye" );
        p->waitForStarted();

        connect( p, SIGNAL(readyReadStandardOutput()), this, SLOT(processOutput()) );
        //connect( p, SIGNAL(readyReadStandardError()), this, SLOT(ReadErr()) );
    }
}


// this gets called whenever the process has something to say...
void Connect::processOutput()
{
    QProcess *p = dynamic_cast<QProcess *>( sender() );

    if (p)
        m_dashBoard->setSerialStat( p->readAllStandardOutput() );
}

void Connect::updatefinished(int exitCode, QProcess::ExitStatus exitStatus)
{
    qDebug() << "code" <<exitCode;
    qDebug() << "status" <<exitStatus;
    QString fileName = "/home/pi/build/BoostedGarageQMLGui";
    QFile file(fileName);
    if(QFileInfo::exists(fileName))
    {
        m_dashBoard->setSerialStat("Update Successful");
        file.close();
    }
    else
    {
        m_dashBoard->setSerialStat("Update Unsuccessful");
    }
}

void Connect::RequestLicence()
{
    QProcess *process = new QProcess(this);
    process->start("/home/pi/licencerequest");
    process->waitForFinished(100); // 10 minutes time before timeout

    QString path = "/home/pi/Licrequest.lic";
    QFile inputFile(path);
    if (inputFile.open(QIODevice::ReadOnly))
    {
        QTextStream in(&inputFile);
        while (!in.atEnd())
        {
            QString line = in.readLine();
            m_dashBoard->setSerialStat(line);
        }
        inputFile.close();
    }
}
/*
void Connect::handleError(QConnectPort::ConnectPortError ConnectPortError)
{
    if (ConnectPortError == QConnectPort::ReadError) {
        QString fileName = "Errors.txt";
        QFile mFile(fileName);
        if(!mFile.open(QFile::Append | QFile::Text)){
        }
        QTextStream out(&mFile);
        out << "Connect Error " << (m_Connectport->errorString()) <<endl;
        mFile.close();
        m_dashBoard->setConnectStat(m_Connectport->errorString());

    }
}

*/
/*
void Connect::readyToRead()
{

    if(ecu == 1)
    {


    }

    if(ecu == 9) //Dicktator ECU
    {
        m_readData = m_Connectport->readAll();
        Connect::dicktatorECU(m_readData);
        m_readData.clear();
    }

}

void Connect::dicktatorECU(const QByteArray &buffer)
{
    //Appending the message until the patterns Start and End Are found , then removing all bytes before and after the message
    m_buffer.append(buffer);
    QByteArray startpattern("START");
    QByteArrayMatcher startmatcher(startpattern);
    QByteArray endpattern("END");
    QByteArrayMatcher endmatcher(endpattern);
    int pos = 0;
    while((pos = startmatcher.indexIn(m_buffer, pos)) != -1)
    {

        if (pos !=0)
        {
            m_buffer.remove(0, pos);
        }
        if (pos == 0 ) break;
    }
    int pos2 = 0;
    while((pos2 = endmatcher.indexIn(m_buffer, pos2)) != -1)
    {


    if (pos2 > 30)
        {
            m_buffer.remove(0,pos2-30);
        }

        if (pos2 == 30 )
        {
            m_dicktatorMsg = m_buffer;
            m_buffer.clear();
            m_decoder->decodeDicktator(m_dicktatorMsg);
            break;
        }
    }

}
*/
