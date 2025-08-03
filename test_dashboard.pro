QT += testlib
QT += core gui quick serialport serialbus network charts positioning sensors multimedia widgets positioning location

CONFIG += qt console warn_on depend_includepath testcase
CONFIG -= app_bundle

TEMPLATE = app

SOURCES +=  test_dashboard.cpp \
    BoostedDash/dashboard.cpp \
    BoostedDash/calculations.cpp \
    BoostedDash/util.cpp

HEADERS += \
    BoostedDash/dashboard.h \
    BoostedDash/calculations.h \
    BoostedDash/util.h

INCLUDEPATH += BoostedDash