TEMPLATE = subdirs
SUBDIRS += bluez-qt declarative
CONFIG += ordered


!notests {
  SUBDIRS += tests
}

# Adds 'coverage' target
include(coverage.pri)

target.path = /opt/bluezqt/bin # path on device
INSTALLS += target
