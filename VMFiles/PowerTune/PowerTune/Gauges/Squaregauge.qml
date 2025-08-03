import QtQuick 2.8
import QtGraphicalEffects 1.0
import QtQuick.Controls 2.1
import QtQuick.Controls.Styles 1.4
import QtQuick.Extras 1.4

Rectangle {
    Drag.active: dragArea.drag.active
        MouseArea {
            // Mouse area in which the item can be dragged
            id: dragArea
            anchors.fill: parent
            drag.target: parent
            onDoubleClicked: {
                if(minusRect.visible == false){
                    minusDivRect.visible = true;
                    minusRect.visible = true;
                    plusDivRect.visible = true;
                    plusRect.visible = true;
                } else{
                    minusDivRect.visible = false;
                    minusRect.visible = false;
                    plusDivRect.visible = false;
                    plusRect.visible = false;
                }
            }
        }


//        MouseArea {
//            id: mouseAreaLeft

//            property int oldMouseX

//            anchors.right: parent.right
//            anchors.bottom: parent.bottom
//            width: 30
//            height: 30
//            hoverEnabled: true

//            onPressed: {
//                oldMouseX = mouseX
//            }

//            onPositionChanged: {
//                if (pressed) {
//                    if(left.width < 150)
//                        left.width = left.width + (mouseX - oldMouseX)
//                }
//            }
//        }

    id: initialID
    width: 250
    height: 200
    //color: "black"
    border.color: "#9f9f9f"
    border.width: 2
    Component.onCompleted: colorsettings.set()
    onXChanged: initialX = x * 1024 / Connect.getWidth()
    onYChanged: initialY = y * 600 / Connect.getHeight()
    onSubDivValChanged: colorsettings.setsizes()
    property string imgSource:""
    property string myID:""
    property string decPlace:""
    property string valuePropertyMain:""
    property string valuePropertySec:""
    property alias title: gaugetextfield.text
    property alias mainunit: mainvalueunittextfield.text
    property alias vertgaugevisible: vertgauge.visible
    property alias horigaugevisible: horizgauge.visible
    property alias secvaluevisible: secondaryvaluetextfield.visible
    property alias secvalue: secondaryvaluetextfield.text
    property alias maintextvalue: mainvaluetextfield.text
    property alias mainvalue: mainvaluetextfield.text
    property alias maxvalue: vertgauge.maximumValue
    property alias titlecolor: titlebar.color
    property alias titlefontsize :gaugetextfield.font.pixelSize
    property alias mainfontsize :mainvaluetextfield.font.pixelSize
    property string resettitlecolor
    property string resetbackroundcolor
    property string framecolor
    property string titletextcolor
    property string textcolor
    property string barcolor
    property double mainvalue
    property int maxvalue
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
    objectName: "SquareGauge"


    property int saveInitialSizes: 0
    property int initialX: 0
    property int initialY: 0
    property int initialWidth: 0
    property int initialHeight: 0
    property int initialtitlefontsize: 0
    property int initialmainfontsize:0

    Rectangle {
        id: titlebar
        width: parent.width - 4
        //height: (parent.height) * 0.2
        height: parent.height/ 8
        anchors.top : parent.top
        anchors.left: parent.left
        color: titlecolor
        clip: false
        visible: true
        anchors.topMargin: 2
        anchors.leftMargin: 2

    }

    SequentialAnimation {
        id: anim
        loops: Animation.Infinite
        running: false
        PropertyAnimation {
            target: titlebar
            property: "color"
            from: "darkred"
            to: "red"
            duration: 3
        }
        PropertyAnimation {
            target: titlebar
            property: "color"
            from: "red"
            to: "darkred"
            duration: 3
        }
    }
    SequentialAnimation {
        id: anim2
        loops: Animation.Infinite
        running: false
        PropertyAnimation {
            target: initialID
            property: "color"
            from: "darkred"
            to: "red"
            duration: 3
        }
        PropertyAnimation {
            target: initialID
            property: "color"
            from: "red"
            to: "darkred"
            duration: 3
        }
    }
    Text {
        id: gaugetextfield
        anchors.top: parent.top
        anchors.horizontalCenter: parent.horizontalCenter
        font.pixelSize: 23
        font.bold: true
        font.family: "Eurostile"
        color: titletextcolor

    }

    Text {
        id: mainvaluetextfield
        /*anchors.top: parent.top
            anchors.horizontalCenter: parent.horizontalCenter
            anchors.topMargin: 30*/
        anchors.horizontalCenter: parent.horizontalCenter
        anchors.verticalCenter: parent.verticalCenter
        font.pixelSize: 50
        font.family: "Eurostile"
        color: textcolor
        onTextChanged: warningindication.warn()
    }

    Text {
        id: mainvalueunittextfield
        anchors.right: parent.right
        anchors.rightMargin: 5
        anchors.verticalCenter: parent.verticalCenter

        font.pixelSize: mainfontsize * 0.5
        font.family: "Eurostile"
        font.bold: true
        color: textcolor
    }



    Gauge {
        id: vertgauge
        height: parent.height - 50
        width: parent.width * 0.1
        anchors.bottom: parent.bottom
        anchors.bottomMargin: 0
        anchors.top: parent.top
        anchors.topMargin: 30
        anchors.left: parent.left
        anchors.leftMargin: 10
        orientation: Qt.Vertical
        minorTickmarkCount: 0
        tickmarkAlignment: Qt.AlignRight
        value: parent.mainvalue
        maximumValue: parent.maxvalue

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
                implicitWidth: 25
                color: barcolor
            }
        }

    }



//    Item {
//        //Set the colors of backround and Boarder
//        id: colorsettings
//        function set()
//        {
//            initialID.color = resetbackroundcolor;
//            initialID.border.color = framecolor;
//        }
//        function setsizes(){
//            if(saveInitialSizes == 0){
//                saveInitialSizes = 1;
//                initialID.initialWidth = initialID.width;
//                initialID.initialHeight = initialID.height;
//                initialID.initialX = initialID.x;
//                initialID.initialY = initialID.y;
//                initialID.initialtitlefontsize = initialID.titlefontsize;
//                initialID.initialmainfontsize = initialID.mainfontsize;
//            }

//            initialID.width = initialID.initialWidth * Connect.getWidth() /1024;
//            initialID.height = initialID.initialHeight * Connect.getHeight() /600;
//            console.log(initialID.initialWidth);
//            console.log(Connect.getWidth());
//            console.log(initialID.initialHeight);
//            console.log(Connect.getHeight());
//            initialID.titlefontsize = initialID.initialtitlefontsize * Connect.getHeight() /600;
//            initialID.mainfontsize = initialID.initialmainfontsize * Connect.getHeight() /600;
//            initialID.x = initialID.initialX * Connect.getWidth() /1024;
//            initialID.y = initialID.initialY * Connect.getHeight() /600;

//        }
//    }


    Gauge {
        id: horizgauge
        height: parent.height * 0.2
        width: parent.width * 0.9
        anchors.bottom: parent.bottom
        anchors.bottomMargin: 10
        anchors.left: parent.left
        anchors.leftMargin: 0
        //anchors.right: parent.right
        //anchors.rightMargin: 0
        anchors.horizontalCenter: parent.horizontalCenter
        orientation: Qt.Horizontal
        minorTickmarkCount: 0
        tickmarkAlignment: Qt.AlignRight
        value: parent.mainvalue
        maximumValue: parent.maxvalue

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
                implicitWidth: 25
                color: barcolor
            }
        }

    }


    Text {
        id: secondaryvaluetextfield
        anchors.bottom: parent.bottom
        anchors.bottomMargin: 10
        anchors.right: parent.right
        anchors.rightMargin: 10
        height: parent.height * 0.2
        font.pixelSize: mainfontsize * 0.75
        font.family: "Eurostile"
        color: textcolor
    }
    Item {
        //to change the warning
        id: warningindication
        function warn()
        {
            if (mainvaluetextfield.text > warnvaluehigh || mainvaluetextfield.text < warnvaluelow )anim.running = true,anim2.running = true;
            else anim.running = false,anim2.running = false,titlebar.color = resettitlecolor ,initialID.color = resetbackroundcolor;

        }
    }
    Connections{
        target: Dashboard
        onOrientationChanged:{
            colorsettings.setsizes();
        }
    }
    Item {
        //Set the colors of backround and Boarder
        id: colorsettings
        function set()
        {
            initialID.color = resetbackroundcolor;
            initialID.border.color = framecolor;
        }
        function setsizes(){
            if(saveInitialSizes == 0){
                saveInitialSizes = 1;
                initialID.initialWidth = initialID.width;
                initialID.initialHeight = initialID.height;
                initialID.initialX = initialID.x;
                initialID.initialY = initialID.y;
                initialID.initialtitlefontsize = initialID.titlefontsize;
                initialID.initialmainfontsize = initialID.mainfontsize;
            }

            initialID.width = initialID.initialWidth * Connect.getWidth() /1024;
            initialID.height = initialID.initialHeight * Connect.getHeight() /600;
//            console.log(initialID.initialWidth);
//            console.log(Connect.getWidth());
//            console.log(initialID.initialHeight);
//            console.log(Connect.getHeight());
            initialID.titlefontsize = initialID.initialtitlefontsize * Connect.getHeight() /600;
            initialID.mainfontsize = initialID.initialmainfontsize * Connect.getHeight() /600;
            initialID.x = initialID.initialX * Connect.getWidth() /1024;
            initialID.y = initialID.initialY * Connect.getHeight() /600;

        }
        function increase(){
            initialID.initialWidth = initialID.initialWidth * 5 / 4;
            initialID.initialHeight = initialID.initialHeight  * 5 / 4;

            initialID.width = initialID.initialWidth * Connect.getWidth() /1024;
            initialID.height = initialID.initialHeight * Connect.getHeight() /600;
//            initialID.x = initialID.initialX * Connect.getWidth() /1024;
//            initialID.y = initialID.initialY * Connect.getHeight() /600;

        }
        function increaseFonts(){
            initialID.initialtitlefontsize = initialID.initialtitlefontsize  * 11 / 10;
            initialID.initialmainfontsize = initialID.initialmainfontsize  * 11 / 10;
            initialID.titlefontsize = initialID.initialtitlefontsize * Connect.getHeight() /600;
            initialID.mainfontsize = initialID.initialmainfontsize * Connect.getHeight() /600;

        }
        function decrease(){
            initialID.initialWidth = initialID.initialWidth * 4 / 5;
            initialID.initialHeight = initialID.initialHeight  * 4 / 5;
            initialID.width = initialID.initialWidth * Connect.getWidth() /1024;
            initialID.height = initialID.initialHeight * Connect.getHeight() /600;
//            initialID.x = initialID.initialX * Connect.getWidth() /1024;
//            initialID.y = initialID.initialY * Connect.getHeight() /600;

        }
        function decreaseFonts(){
            initialID.initialtitlefontsize = initialID.initialtitlefontsize  * 10 / 11;
            initialID.initialmainfontsize = initialID.initialmainfontsize  * 10 / 11;
            initialID.titlefontsize = initialID.initialtitlefontsize * Connect.getHeight() /600;
            initialID.mainfontsize = initialID.initialmainfontsize * Connect.getHeight() /600;

        }

    }
    Rectangle {
        id : plusRect
        color: "red"
        anchors.right: parent.right
        anchors.top: parent.top
        width: parent.width / 4
        height: parent.height / 4
        visible: false
        MouseArea {
            id: mouseAreaPlus

            property int oldMouseX

            anchors.fill: parent
            hoverEnabled: true

            onClicked: {
                plusRect.color = "lightblue"
                colorsettings.increase();
                plusRect.color = "red"
            }

        }

    }
    Rectangle {
        id : minusRect
        color: "green"
        anchors.right: parent.right
        anchors.bottom: parent.bottom
        width: parent.width / 4
        height: parent.height / 4
        visible: false
        MouseArea {
            id: mouseAreaMinus
            anchors.fill: parent
            hoverEnabled: true

            onClicked: {
                minusRect.color = "lightblue"
                colorsettings.decrease();
                minusRect.color = "green"
            }

        }
    }

    Rectangle {
        id : plusDivRect
        color: "green"
        anchors.left: parent.left
        anchors.top: parent.top
        width: parent.width / 4
        height: parent.height / 4
        visible: false
        MouseArea {
            id: mouseAreaDivPlus

            property int oldMouseX

            anchors.fill: parent
            hoverEnabled: true

            onClicked: {
                plusDivRect.color = "lightblue"
                colorsettings.increaseFonts()
                plusDivRect.color = "green"
            }

        }

    }
    Rectangle {
        id : minusDivRect
        color: "red"
        anchors.left: parent.left
        anchors.bottom: parent.bottom
        width: parent.width / 4
        height: parent.height / 4
        visible: false
        MouseArea {
            id: mouseAreaDivMinus
            anchors.fill: parent
            hoverEnabled: true

            onClicked: {
                minusDivRect.color = "lightblue"
                colorsettings.decreaseFonts()
                minusDivRect.color = "red"
            }

        }
    }
}
