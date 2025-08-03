import QtQuick 2.8
import QtQuick.Window 2.2
import QtGraphicalEffects 1.0
import QtQuick.Controls 1.4
import QtQuick.Controls.Styles 1.4
import QtQuick.Controls 2.1
import QtQuick.Extras 1.4


Rectangle {
    id:groove1
    color:"grey"
    anchors.fill:parent
    property  var unit : Dashboard.speedunits;
    Component.onCompleted: {units.unitadjust();}


    Gauge {
        id: gauge
        height: parent.height
        width: parent.width /1.025
        y:0
        minorTickmarkCount: 0
        tickmarkStepSize : Dashboard.maxRPM
        orientation : Qt.Horizontal
        minimumValue: 0
        maximumValue: Dashboard.maxRPM

        value: Dashboard.rpm
        Behavior on value {
            NumberAnimation {
                duration: 5
            }
        }
        style: GaugeStyle {
            tickmarkLabel: Text {
                font.pixelSize: 14
                color: "transparent"
            }
            tickmark: Item {
                implicitWidth: 18
                implicitHeight: 1

                Rectangle {
                    color: "transparent"
                    anchors.fill: parent
                    anchors.leftMargin: 3
                    anchors.rightMargin: 3
                }
            }
            valueBar: Rectangle {
                width:  400
                color: Qt.rgba(gauge.value / gauge.maximumValue, 1.1 - gauge.value / gauge.maximumValue, 0, 1)
            }
        }
    }

    Image
    {
        source:"qrc:/graphics/Racedash.png"
        anchors.fill: parent
        smooth: true

    }

    Text {
        id: anchortext
        x: -9
        y: 150
        color: "#808080"
        text: ""
        anchors.horizontalCenter: parent.horizontalCenter
        font.family: "Eurostile"
        font.bold: true
        font.pixelSize: 20
    }
    Text {
        text:"RPM"
        anchors.right: rpm.left
        anchors.rightMargin: -1
        font.pixelSize: 20
        y: 180
        x: groove1.width - 1024 + 180
        font.bold: true
        font.family: "Eurostile"
        color: "grey"

    }
    Text {
        id:rpm
        text: (Dashboard.rpm)
        anchors.right: anchortext.left
        anchors.rightMargin: -50
        font.pixelSize: 100
        y: 130
        width: 300
        x: groove1.width - 1024 + 220
        font.italic: true
        font.bold: true
        font.family: "Eurostile"
        color: "white"

    }
    Text {
        id :speed
        text: "km/h"
        anchors.left: anchortext.right
        anchors.leftMargin: 60
        font.pixelSize: 20
        y: 180
        font.bold: true
        font.family: "Eurostile"
        color: "grey"

    }
    Text {
        id:speedtext

        text: (Dashboard.speed)
        anchors.left: speed.right
        anchors.leftMargin: 4
        font.pixelSize: 100
        y: 130
        width: 300
        font.italic: true
        font.bold: true
        font.family: "Eurostile"
        color: "white"

    }

//    Text {
//        text:"RPM"
//        font.pixelSize: 20
//        y: 150
//        x: groove1.width - 1024 + 180
//        font.bold: true
//        font.family: "Eurostile"
//        color: "grey"

//    }
//    Text {
//        text: (Dashboard.rpm)
//        font.pixelSize: 100
//        y: 110
//        x: groove1.width - 1024 + 220
//        font.italic: true
//        font.bold: true
//        font.family: "Eurostile"
//        color: "white"

//    }
//    Text {
//        id :speed
//        text: "km/h"
//        font.pixelSize: 20
//        y: 150
//        x: groove1.width - 1024 + 510
//        font.bold: true
//        font.family: "Eurostile"
//        color: "grey"

//    }
//    Text {
//        text: (Dashboard.speed)
//        font.pixelSize: 100
//        y: 110
//        x: groove1.width - 1024 + 570
//        font.italic: true
//        font.bold: true
//        font.family: "Eurostile"
//        color: "white"

//    }
    ShiftLights{ anchors.horizontalCenter: parent.horizontalCenter}

    Item {
        id: units
        function unitadjust()
        {
            if (unit == "imperial") {speed.text = "mph"};
            if (unit == "metric") {speed.text = "km/h"};
        }
    }
    Connections{
        target: Dashboard
        onOrientationChanged:{
            groove1.width = Connect.getWidth();
        }
    }
}




















/*##^## Designer {
    D{i:0;autoSize:true;height:480;width:640}D{i:1;anchors_height:600;anchors_width:999.0243902439025;anchors_y:0}
}
 ##^##*/
