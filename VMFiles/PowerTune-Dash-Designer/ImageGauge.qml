import QtQuick 2.8
import QtGraphicalEffects 1.0
import QtQuick.Controls 2.1
import QtQuick.Controls.Styles 1.4
import QtQuick.Extras 1.4
//import "../Gauges"


Rectangle {
    Drag.active: dragArea.drag.active


    MouseArea {
        // Mouse area in which the item can be dragged
        id: dragArea
        anchors.fill: parent
        drag.target: parent
    }


    MouseArea {
        id: mouseAreaLeft

        property int oldMouseX

        anchors.right: parent.right
        anchors.bottom: parent.bottom
        width: 30
        height: 30
        hoverEnabled: true

        onPressed: {
            oldMouseX = mouseX
        }

        onPositionChanged: {
            if (pressed) {
                if(left.width < 150)
                    left.width = left.width + (mouseX - oldMouseX)
            }
        }
    }

    id: initialID
    width: 250
    height: 200
//    z: -2147483647

    property string imgSource:""
    property string title
    property string mainunit
    property string vertgaugevisible
    property string horigaugevisible
    property string secvaluevisible
    property string secvalue
    property string maintextvalue
    property string mainvalue
    property string maxvalue
    property string maxval: maxvalue
    property string titlecolor
    property string titlefontsize
    property string mainfontsize
    property string resettitlecolor
    property string resetbackroundcolor: "transparent"
    property string framecolor: "transparent"
    property string titletextcolor
    property string textcolor
    property string barcolor
    property double warnvaluehigh: 20000
    property double warnvaluelow : -20000
    property string gaugecolor1 : "white" //speedo color below current speed
    property string gaugecolor2 : "red" // speedo color above current speed
    property string gaugecolor3 : "#ffffff" // Speedo text  --------Qt.rgba(0.66, 0, 0, 0.66); // needle color
    property string gaugecolor4 : "blue" // needle color
    property string gaugecolor5 : "red" // redline
    property string gaugecolor6 : "red"
    property string gaugecolor7 : "blue"
    property string gaugecolor8 : "white"
    property string gaugecolor9 : "red"
    property string shadecolor1 : "#ffffff"
    property string shadecolor2 : "#e96448"
    property string shadecolor3 : "#f22900"
    property string shadecolor4 : "transparent"
    property int stepsize : 1
    property real maxValueAngle : 180
    property real minValueAngle : -90
    property bool fullCirc: false
    property string subDivVal: "6"
//    property alias rotation : rotation
    Image {
        id: bgImage
        z:0
        source: imgSource
        anchors.fill: parent

    }
}

