import QtQuick 2.5
import QtQuick.Window 2.2
import QtGraphicalEffects 1.0
import QtQuick.Controls 1.4
import QtQuick.Controls.Styles 1.4
Rectangle {
    id: rectangle
    visible: true
    color:"transparent"
    anchors.fill:parent
    property  var unit : Dashboard.speedunits;
    Component.onCompleted: {units.unitadjust()}


    Item {
        id: units
        function unitadjust()
        {
            if (unit == "imperial") {speed.text = "mph"};
            if (unit == "metric") {speed.text = "km/h"};
        }
    }


    Image
    {
        id:groove1
        source:"qrc:/graphics/RPM_BG.png"
        anchors.top:parent.top
        anchors.left:parent.left
        width: 1012
        smooth: true

        Item{
            id: displayWindow1
            height: parent.height
            width: ((groove1.width-47)*(Dashboard.rpm)/Dashboard.maxRPM)+47 //+61 is the pixel where the RPM bar starts and from there is 651 pixels wide

            clip: true

            anchors.bottom: parent.bottom
            anchors.left: parent.left
            anchors.rightMargin:{switch(true)
                {
                case Dashboard.rpm>=0 && Dashboard.rpm < 500:return 10;
                case Dashboard.rpm>=500 && Dashboard.rpm < 700:return 9.7;
                case Dashboard.rpm>=700 && Dashboard.rpm < 900:return 8.4;
                case Dashboard.rpm>=900 && Dashboard.rpm < 1000:return 8;
                case Dashboard.rpm>=1100 && Dashboard.rpm <= 1200:return 7.15;
                case Dashboard.rpm>=1200 && Dashboard.rpm <= 1300:return 6;

                }
            }

            Image
            {
                id:speedarcfill
                anchors.top:parent.top
                anchors.left:parent.left
                width: groove1.width
                source:"qrc:/graphics/RPM_Fill.png"
                smooth: true
                z: 1
            }
        }

        PathInterpolator {
            id: motionPath
            property int value

            path: Path {
                startX: 47; startY: 186
                PathLine { x: 137; y: 123 }
                PathArc { x: 251; y: 88; radiusX: 90; radiusY: 90 }
                PathLine { x: (groove1.width-200); y: 76 }
            }
            progress: Dashboard.rpm / Dashboard.maxRPM
        }
    }
    ShiftLights{ anchors.horizontalCenter: parent.horizontalCenter}
    Connections{
        target: Dashboard
        onOrientationChanged:{
            groove1.width = Connect.getWidth();
        }
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

}












































/*##^## Designer {
    D{i:0;autoSize:true;height:480;width:640}
}
 ##^##*/
