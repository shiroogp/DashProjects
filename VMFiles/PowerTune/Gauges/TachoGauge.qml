import QtQuick 2.8
import QtGraphicalEffects 1.0
import QtQuick.Controls 2.1
import QtQuick.Controls.Styles 1.4
import QtQuick.Extras 1.4
import "../Gauges"


Rectangle {
    Drag.active: dragArea.drag.active
    objectName: "TachoGauge"


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


    id: initialID
    width: 250
    height: 200
//    z: -2147483647
    //    rotation: rotation
    //color: "black"
    //    border.color: "#9f9f9f"
    //    border.width: 2
    Component.onCompleted: colorsettings.set()
    onXChanged: initialX = x * 1024 / Connect.getWidth()
    onYChanged: initialY = y * 600 / Connect.getHeight()


    property string title
    property string mainunit
    property string vertgaugevisible
    property string horigaugevisible
    property string secvaluevisible
    property string secvalue
    property string maintextvalue
    property alias mainvalue: revcounterticks.value
    property alias maxvalue: revcounterticks.maximumValue
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
    property string imgSource:""
    property string myID:""
    property string decPlace:""
    property string valuePropertyMain:""
    property string valuePropertySec:""
    property bool fullCirc: false
    property string subDivVal: "6"
    //    property alias rotation : rotation
    property int saveInitialSizes: 0
    property int initialX: 0
    property int initialY: 0
    property int initialWidth: 0
    property int initialHeight: 0
    property int initialtitlefontsize: 0
    property int initialmainfontsize:0

    CircularGauge {
        id: revcounterticks
        stepSize: parent.stepsize
        z: 12
        anchors.fill: parent

        style: TachometerStyle2 {
            id: tachStyle
            halfGauge: false

            needleTipWidth: 0
            needleLength: 0
            needleBaseWidth: 0
            maximumValueAngle: maxValueAngle
            redline: gaugecolor5
            redlineVal: warnvaluehigh
            //            arcStartDeg: ((((warnvaluehigh ) * (maximumValueAngle-minimumValueAngle) / maxvalue)+minValueAngle) * (Math.PI/180)) + (Math.PI/2)
            arcStartDeg: ((((warnvaluehigh/maxvalue) * (maximumValueAngle-minimumValueAngle))+minValueAngle -90) * (Math.PI/180))// + ((90 - minValueAngle) * Math.PI/180)

            //            arcStartDeg : (((warnvaluehigh ) * (maximumValueAngle-minimumValueAngle) / maxvalue)+minValueAngle)+90
            tickmarkLabel: Text {
                color: gaugecolor1
                text: styleData.value
                //                font.bold: styleData.value >= Dashboard.rpm/1000+0.5 || styleData.value <= Dashboard.rpm/1000-0.5  ? false : true
                antialiasing: true
                //                font.pixelSize: styleData.value >= Dashboard.rpm/1000+0.5 || styleData.value <= Dashboard.rpm/1000-0.5  ? revcounterticks.parent.height /22 : (revcounterticks.value-Dashboard.rpm/1000)+revcounterticks.parent.height /11
                font.pixelSize: revcounterticks.parent.height /22
            }
            minimumValueAngle: minValueAngle

        }
        maximumValue: parent.maxvalue
        OpacityAnimator on opacity{
            from: 0;
            to: 1;
            duration: 2000
        }
    }

    GaugeNeedle {
        id: revneedele
        z: 13
        anchors.verticalCenterOffset: 0
        value: Dashboard.rpm * (77/(parent.maxvalue*1000))//0.009625

        //        angleOffset: Math.PI
        //        rotateNeedle: {
        //            if(Dashboard.rpm == 0){
        //                0 + minValueAngle
        //            }else{

        //                (((Dashboard.rpm/1000) / maxval) * (maxValueAngle - minValueAngle)) + minValueAngle// - 90
        //            }
        //        }
        //        rotation: rotateNeedle
        //        currVal: rotateNeedle - (maxValueAngle - minValueAngle)
        minval: minValueAngle
        maxvaldegs: maxValueAngle
        angle: (Dashboard.rpm * (77/(parent.maxvalue*1000)))*3.5*Math.PI / 180
        //        4000/8000
        needlecolor: gaugecolor4
        angleOffset: (minValueAngle-90) * (Math.PI / 180)
        clorStop1: shadecolor1
        clorStop2: shadecolor2
        clorStop3: shadecolor3
        clorStop4: shadecolor4

    }

    Image {
        id: revinner
        width: parent.width /1.68
        height: width
        z: 14
        source: "qrc:/graphics/Tacho_Mitte.png"
        anchors.centerIn: parent
        fillMode: Image.PreserveAspectFit
    }

    Text {
        id: revinnertesxt
        color: gaugecolor4
        text: Dashboard.rpm
        z: 15
        font.family: "Eurostile"
        font.pixelSize: parent.width / 10
        anchors.centerIn: parent
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
            initialID.height = initialID.initialHeight * Connect.getWidth() /1024;
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
            initialID.initialWidth = initialWidth * 5 / 4;
            initialID.initialHeight = initialHeight  * 5 / 4;

            initialID.width = initialID.initialWidth * Connect.getWidth() /1024;
            initialID.height = initialID.initialHeight * Connect.getWidth() /1024;
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
            initialID.initialWidth = initialWidth * 4 / 5;
            initialID.initialHeight = initialHeight  * 4 / 5;
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
    Connections{
        target: Dashboard
        onOrientationChanged:{
            colorsettings.setsizes();
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
//                colorsettings.increaseFonts()
                stepsize += 1
                revcounterticks.stepSize = initialID.stepsize

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
//                colorsettings.decreaseFonts()
                stepsize -= 1
                revcounterticks.stepSize = initialID.stepsize
                minusDivRect.color = "red"
            }

        }
    }
    //    anchors.top: scalerect.top
}




//Rectangle {
//    id: initialID
//    width: 250
//    height: 200
//    //color: "black"
//    border.color: "#9f9f9f"
//    border.width: 2
//    Component.onCompleted: colorsettings.set()

//    property alias title: gaugetextfield.text
//    property alias mainunit: mainvalueunittextfield.text
//    property alias vertgaugevisible: vertgauge.visible
//    property alias horigaugevisible: horizgauge.visible
//    property alias secvaluevisible: secondaryvaluetextfield.visible
//    property alias secvalue: secondaryvaluetextfield.text
//    property alias maintextvalue: mainvaluetextfield.text
//    property alias mainvalue: mainvaluetextfield.text
//    property alias maxvalue: speedometer.maximumValue
//    property alias titlecolor: titlebar.color
//    property alias titlefontsize :gaugetextfield.font.pixelSize
//    property alias mainfontsize :mainvaluetextfield.font.pixelSize
//    property string resettitlecolor
//    property string resetbackroundcolor
//    property string framecolor
//    property string titletextcolor
//    property string textcolor
//    property string barcolor
//    property double mainvalue
//    property int maxvalue
//    property double warnvaluehigh: 20000
//    property double warnvaluelow : -20000
//    property String gaugecolor1 : "white" //speedo color below current speed
//    property String gaugecolor2 : "red" // speedo color above current speed
//    property String gaugecolor3 : "#ffffff" // Speedo text  --------Qt.rgba(0.66, 0, 0, 0.66); // needle color
//    property String gaugecolor4 : "blue" // needle color
//    property String gaugecolor5 : "white"
//    property String gaugecolor6 : "red"
//    property String gaugecolor7 : "blue"
//    property String gaugecolor8 : "white"
//    property String gaugecolor9 : "red"
//    property String shadecolor1 : "blue"
//    property String shadecolor2 : "white"
//    property String shadecolor3 : "red"
//    property String shadecolor4 : "red"
//    property string stepsize : speedometer.stepSize
//    CircularGauge {
//        id: speedometer
//        stepSize: parent.stepsize
//        z: 11
//        anchors.fill: parent
//        style: DashboardGaugeStyle {
//            labelStepSize: 20
//            needleTipWidth: 0
//            needleLength: 0
//            needleBaseWidth: 0
////            needleColor: gaugecolor3
//            tickmarkLabel: Text {
//                color: styleData.value >= speedometer.value+10 || styleData.value <= speedometer.value-10  ? gaugecolor1 : gaugecolor2
//                text: styleData.value
//                font.bold: styleData.value >= speedometer.value+10 || styleData.value <= speedometer.value-10  ? false : true
//                antialiasing: true
//                font.pixelSize: styleData.value >= speedometer.value+15 || styleData.value <= speedometer.value-15  ? speedo.height /22 : (speedometer.value-styleData.value)+speedo.height /11
//            }
//        }
//        maximumValue: parent.maxvalue
//        OpacityAnimator on opacity{
//            from: 0;
//            to: 1;
//            duration: 2000
//        }
//    }

//    GaugeNeedle_minus180to90 {
//        id: speedoNeedlekph
//        z: 7
//        anchors.verticalCenterOffset: 0
//        value: Dashboard.speed / 4.155844155844156
//        angleOffset: -Math.PI / 2
//        needlecolor: gaugecolor4
//        clorStop1: shadecolor1
//        clorStop2: shadecolor2
//        clorStop3: shadecolor3
//        clorStop4: shadecolor4

//    }

//    GaugeNeedle_minus180to90 {
//        id: speedoNeedlemph
//        z: 6
//        anchors.verticalCenterOffset: 0
//        value: Dashboard.speed / 2.597402597402597
//        angleOffset: -Math.PI / 2
//        needlecolor: gaugecolor4
//        clorStop1: shadecolor1
//        clorStop2: shadecolor2
//        clorStop3: shadecolor3
//        clorStop4: shadecolor4
//    }

//    Image {
//        id: speedoinner
//        width: parent.width /1.68
//        height: width
//        z: 9
//        source: "qrc:/graphics/Tacho_Mitte.png"
//        anchors.centerIn: parent
//        fillMode: Image.PreserveAspectFit
//    }

//    Text {
//        id: speedinnertext
//        color: gaugecolor4
//        text: Dashboard.speed
//        z: 10
//        font.family: "Eurostile"
//        font.pixelSize: scalerect.width / 20
//        anchors.centerIn: parent
//    }
//    anchors.left: scalerect.left
//    anchors.top: scalerect.top
//}
