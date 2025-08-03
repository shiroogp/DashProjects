# TODO: someone smarter than me should evaluate DBUS_ADAPTORS/DBUS_INTERFACES
# here and see if they can be used instead of all these system calls
system($$[QT_HOST_BINS]/qdbusxml2cpp -p bluemanager.h:bluemanager.cpp manager.xml)
system($$[QT_HOST_BINS]/qdbusxml2cpp -p blueadapter.h:blueadapter.cpp adapter.xml)
system($$[QT_HOST_BINS]/qdbusxml2cpp -p bluedevice.h:bluedevice.cpp -i devicetypes.h device.xml)
system($$[QT_HOST_BINS]/qdbusxml2cpp -p audio.h:audio.cpp audio.xml)
system($$[QT_HOST_BINS]/qdbusxml2cpp -p audiosink.h:audiosink.cpp audiosink.xml)
system($$[QT_HOST_BINS]/qdbusxml2cpp -p audiosource.h:audiosource.cpp audiosrc.xml)
system($$[QT_HOST_BINS]/qdbusxml2cpp -p headset.h:headset.cpp headset.xml)
system($$[QT_HOST_BINS]/qdbusxml2cpp -p input.h:input.cpp input.xml)
include(obex/obex.pri)

VERSION+= 0.1.26

isEmpty(PREFIX) {
  PREFIX=/usr
}

TEMPLATE = lib
TARGET = bluez-qt5
QT += dbus
CONFIG += link_pkgconfig \
	debug
OTHER_FILES += \
	manager.xml \
	device.xml \
	audiosrc.xml \
	audiosink.xml \
	adapter.xml \
	headset.xml \
    input.xml
HEADERS += bluetoothagentadaptor.h \
	bluemanager.h \
	bluedevice.h \
	blueadapter.h \
	audiosource.h \
	audiosink.h \
	headset.h \
	btprofiles.h \
	nearbydevicesmodel.h \
	bluetoothbaseagent.h \
	asyncagent.h \
	devicetypes.h \
    bluetoothdevice.h \
	bluetoothdevicemodel.h \
	audio.h \
	input.h
SOURCES += bluetoothagentadaptor.cpp \
	bluemanager.cpp \
	bluedevice.cpp \
	blueadapter.cpp \
	audiosource.cpp \
	audiosink.cpp \
	headset.cpp \
	nearbydevicesmodel.cpp \
	bluetoothbaseagent.cpp \
	asyncagent.cpp \
	bluetoothdevice.cpp \
	bluetoothdevicemodel.cpp \
	audio.cpp \
	input.cpp

target.path = $$INSTALL_ROOT$$PREFIX/lib
headers.path = $$INSTALL_ROOT$$PREFIX/include/bluez-qt5/
headers.files = $$HEADERS
INSTALLS += target \
	headers

CONFIG += create_pc create_prl
QMAKE_PKGCONFIG_DESCRIPTION = Bluez Qt Bindings Library
QMAKE_PKGCONFIG_INCDIR = $$headers.path
pkgconfig.path = $$INSTALL_ROOT$$PREFIX/lib/pkgconfig
pkgconfig.files = bluez-qt5.pc

INSTALLS += pkgconfig


INSTALLS += dbusfiles
