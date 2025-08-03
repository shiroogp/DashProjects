import QtQuick 2.8

Rectangle {
    id: intro
    anchors.fill : parent
    color: "white"
    Component.onCompleted: {
        Connect.setHeight(intro.height);
        Connect.setWidth(intro.width);

    }

    Image {
        width: parent.width
        height: parent.height
        fillMode: Image.PreserveAspectFit
        source: "/graphics/splash.png"
    }

}
