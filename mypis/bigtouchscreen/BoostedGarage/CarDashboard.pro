PROJECT = CarDashboard

SOURCES += main.cpp

INCLUDEPATH += $$PWD

QT += qml

include(./QtQuickViewManager/View.pri)

# Default rules for deployment.
include(deployment.pri)

RESOURCES += qml_resources.qrc

OTHER_FILES += \
    qml/main.qml \
    qml/RoundGauge.qml \
    qml/GraphGauge.qml \
    qml/needle.png

DISTFILES += \
    deployment.pri
