TEMPLATE = app

QT += qml quick serialport serialbus network charts positioning sensors multimedia widgets positioning location
CONFIG += c++11
static {
    QT += svg
    QTPLUGIN += qtvirtualkeyboardplugin
}


SOURCES += main.cpp \
    dashboard.cpp \
    serialport.cpp \
    appsettings.cpp \
    gopro.cpp \
    gps.cpp \
    sensors.cpp \
    datalogger.cpp \
    Apexi.cpp \
    AdaptronicSelect.cpp \
    connect.cpp \
    calculations.cpp \
    udpreceiver.cpp \
    arduino.cpp \
    settings.cpp \
    singleinstance.cpp \
    util.cpp \
    ViewManagement.cpp \
    ui/mainwindow.cpp \
    ui/receiverselectordialog.cpp \
    ui/settingsdialog.cpp \
    transfer/devicebroadcaster.cpp \
    transfer/receiver.cpp \
    transfer/sender.cpp \
    transfer/transfer.cpp \
    transfer/transferserver.cpp \
    model/device.cpp \
    model/devicelistmodel.cpp \
    model/transferinfo.cpp \
    model/transfertablemodel.cpp


RESOURCES += qml.qrc \
    configfiles.qrc \
    res.qrc

# Additional import path used to resolve QML modules in Qt Creator's code model
QML_IMPORT_PATH =

# Default rules for deployment.
#include(deployment.pri)

HEADERS += \
    dashboard.h \
    serialport.h \
    appsettings.h \
    gopro.h \
    gps.h \
    sensors.h \
    datalogger.h \
    Apexi.h \
    AdaptronicSelect.h \
    connect.h \
    calculations.h \
    udpreceiver.h \
    Gauges/squaregaugeracedash.h \
    arduino.h \
    appsettings.h \
    settings.h \
    singleinstance.h \
    util.h \
    ViewManagement.h \
    ui/mainwindow.h \
    ui/receiverselectordialog.h \
    ui/settingsdialog.h \
    transfer/devicebroadcaster.h \
    transfer/receiver.h \
    transfer/sender.h \
    transfer/transfer.h \
    transfer/transferserver.h \
    model/device.h \
    model/devicelistmodel.h \
    model/transferinfo.h \
    model/transfertablemodel.h


FORMS += \
    ui/aboutdialog.ui \
    ui/mainwindow.ui \
    ui/receiverselectordialog.ui \
    ui/settingsdialog.ui

target.path = /opt/$${TARGET}/bin
INSTALLS += target

CONFIG+=qml_debug

#DISTFILES += \
#    qml/Dashboard/fonts/digital-7 (mono italic).ttf \
#    qml/Dashboard/fonts/digital-7 (mono).ttf \
#    qml/Dashboard/fonts/digital-7-italic.ttf \
#    qml/Dashboard/fonts/digital-7.ttf \
#    qml/Dashboard/images/abs_break.png \
#    qml/Dashboard/images/airbag.png \
#    qml/Dashboard/images/arrow.png \
#    qml/Dashboard/images/batery_needle.png \
#    qml/Dashboard/images/battery.png \
#    qml/Dashboard/images/battery_warning.png \
#    qml/Dashboard/images/check_engine.png \0 MiB
#    qml/Dashboard/images/dashboard.png \
#    qml/Dashboard/images/dashboard_panel.png \
#    qml/Dashboard/images/door_warning_light.png \
#    qml/Dashboard/images/fuel.png \
#    qml/Dashboard/images/fuel_needle.png \
#    qml/Dashboard/images/fuel_warning.png \
#    qml/Dashboard/images/handbrake.png \
#    qml/Dashboard/images/hazard_warning_light.png \
#    qml/Dashboard/images/high_beam.png \
#    qml/Dashboard/images/iol.png \
#    qml/Dashboard/images/key_status.png \
#    qml/Dashboard/images/low_beam.png \
#    qml/Dashboard/images/motor_temperature.png \
#    qml/Dashboard/images/oil.png \
#    qml/Dashboard/images/rpm_needle.png \
#    qml/Dashboard/images/sattelital_notification.png \
#    qml/Dashboard/images/seatbelt.png \
#    qml/Dashboard/images/speed_needle.png \
#    qml/Dashboard/images/tire_pressure.png \
#    qml/Dashboard/images/tire_pressure_warning.png \
#    qml/Dashboard/main.qml
