TEMPLATE = lib

CONFIG += qt \
    plugin \
    link_pkgconfig

INCLUDEPATH += ../bluez-qt
LIBS += -L../bluez-qt

QT += qml dbus
LIBS += -lbluez-qt5

TARGET = Bluez-qt
OBJECTS_DIR = .obj
MOC_DIR = .moc

# Input
SOURCES += components.cpp

OTHER_FILES += qmldir

qmldir.files += qmldir
qmldir.path = $$[QT_INSTALL_QML]/Bluetooth
target.path = $$[QT_INSTALL_QML]/Bluetooth

INSTALLS += qmldir target
