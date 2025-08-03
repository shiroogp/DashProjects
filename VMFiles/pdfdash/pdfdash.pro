QT += quick
CONFIG += c++11

# The following define makes your compiler emit warnings if you use
# any Qt feature that has been marked deprecated (the exact warnings
# depend on your compiler). Refer to the documentation for the
# deprecated API to know how to port your code away from it.
DEFINES += QT_DEPRECATED_WARNINGS

# You can also make your code fail to compile if it uses deprecated APIs.
# In order to do so, uncomment the following line.
# You can also select to disable deprecated APIs only up to a certain version of Qt.
#DEFINES += QT_DISABLE_DEPRECATED_BEFORE=0x060000    # disables all the APIs deprecated before Qt 6.0.0

include(qtquick2applicationviewer/qtquick2applicationviewer.pri)
qtcAddDeployment()

QMAKE_CXXFLAGS += -ldlt
QMAKE_CFLAGS += -ldlt

SOURCES += \
        main.cpp \
    hmi_dashboard.cpp \
    hmi_shared_memory.cpp \
    hmi_states_values.cpp

RESOURCES +=

# Additional import path used to resolve QML modules in Qt Creator's code model
QML_IMPORT_PATH =

# Additional import path used to resolve QML modules just for Qt Quick Designer
QML_DESIGNER_IMPORT_PATH =

# Default rules for deployment.
qnx: target.path = /tmp/$${TARGET}/bin
else: unix:!android: target.path = /opt/$${TARGET}/bin
!isEmpty(target.path): INSTALLS += target

HEADERS += \
    hmi_dashboard.h \
    hmi_shared_memory.h \
    hmi_states_values.h

DISTFILES += \
    qtquick2applicationviewer/qtquick2applicationviewer.pri \
    qml/Dashboard/main.qml \
    qml/Dashboard/fonts/digital-7 (mono italic).ttf \
    qml/Dashboard/fonts/digital-7 (mono).ttf \
    qml/Dashboard/fonts/digital-7-italic.ttf \
    qml/Dashboard/fonts/digital-7.ttf \
    qml/Dashboard/images/abs_break.png \
    qml/Dashboard/images/airbag.png \
    qml/Dashboard/images/arrow.png \
    qml/Dashboard/images/batery_needle.png \
    qml/Dashboard/images/battery.png \
    qml/Dashboard/images/battery_warning.png \
    qml/Dashboard/images/check_engine.png \
    qml/Dashboard/images/dashboard.png \
    qml/Dashboard/images/dashboard_panel.png \
    qml/Dashboard/images/door_warning_light.png \
    qml/Dashboard/images/fuel.png \
    qml/Dashboard/images/fuel_needle.png \
    qml/Dashboard/images/fuel_warning.png \
    qml/Dashboard/images/handbrake.png \
    qml/Dashboard/images/hazard_warning_light.png \
    qml/Dashboard/images/high_beam.png \
    qml/Dashboard/images/iol.png \
    qml/Dashboard/images/key_status.png \
    qml/Dashboard/images/low_beam.png \
    qml/Dashboard/images/motor_temperature.png \
    qml/Dashboard/images/oil.png \
    qml/Dashboard/images/rpm_needle.png \
    qml/Dashboard/images/sattelital_notification.png \
    qml/Dashboard/images/seatbelt.png \
    qml/Dashboard/images/speed_needle.png \
    qml/Dashboard/images/tire_pressure.png \
    qml/Dashboard/images/tire_pressure_warning.png \
    qml/Dashboard/main.qml

#unix|win32: LIBS += -ldlt


win32:CONFIG(release, debug|release): LIBS += -L$$PWD/../raspi/sysroot/usr/include/lib/release/ -ldlt
else:win32:CONFIG(debug, debug|release): LIBS += -L$$PWD/../raspi/sysroot/usr/include/lib/debug/ -ldlt
else:unix: LIBS += -L$$PWD/../raspi/sysroot/usr/include/lib/ -ldlt

INCLUDEPATH += $$PWD/../raspi/sysroot/usr/include/include
DEPENDPATH += $$PWD/../raspi/sysroot/usr/include/include

#win32:CONFIG(release, debug|release): LIBS += -L$$PWD/../../../usr/local/lib/release/ -ldlt
#else:win32:CONFIG(debug, debug|release): LIBS += -L$$PWD/../../../usr/local/lib/debug/ -ldlt
#else:unix: LIBS += -L$$PWD/../../../usr/local/lib/ -ldlt

#INCLUDEPATH += $$PWD/../../../usr/local/include
#DEPENDPATH += $$PWD/../../../usr/local/include
