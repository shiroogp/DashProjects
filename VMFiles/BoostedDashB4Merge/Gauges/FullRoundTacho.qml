import QtQuick 2.8
import QtGraphicalEffects 1.0
import QtQuick.Controls 2.1
import QtQuick.Controls.Styles 1.4
import QtQuick.Extras 1.4
import "../Gauges"
import "../qml"

Item {
    objectName: "FullGauge"
    id: initialID

    property string title
    property string mainunit : "RPM x 1000"
    property string vertgaugevisible
    property string horigaugevisible
    property string secvaluevisible
    property string secvalue
    property string maintextvalue
    property alias mainvalue: tacho_gauge.currentValue
    property alias maxvalue: tacho_gauge.maxValue
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
    property bool small : true
    property string imgSource:""
    property string myID:""
    property string decPlace:""
    property string valuePropertyMain:""
    property string valuePropertySec:""
//    onMainvalueChanged: {
//        mainvaluetextfield.text = mainvalue;
//    }

    Drag.active: dragArea.drag.active


    MouseArea {
        // Mouse area in which the item can be dragged
        id: dragArea
        anchors.fill: parent
        drag.target: parent
        onDoubleClicked:{
            if(initialRoundID.visible == true){
                            initialTachoID.visible = true;
                            initialRoundID.visible = false;
                            //                    view.currentIndex++
                        }else if(initialTachoID.visible == true){
                            initialRoundID.visible = true;
                            initialTachoID.visible = false;
                            //                    view.currentIndex++
                        }
        }

//            if(initialRoundID.z == 1){
//                initialSpeedoID.z = 1;
//                initialRoundID.z = -234567;
//                //                    view.currentIndex++
//            }else if(initialImageID.z == 1){
//                initialSpeedoID.z = 1;
//                initialImageID.z = -234567;
//                //                    view.currentIndex++
//            }else if(initialSpeedoID.z == 1){
//                initialSquareID.z = 1;
//                initialSpeedoID.z = -234567;
//                //                    view.currentIndex++
//            }else if(initialSquareID.z == 1){
//                initialTachoID.z = 1;
//                initialSquareID.z = -234567;
//                //                    view.currentIndex++
//            }else if(initialTachoID.z == 1){
//                initialRoundID.z = 1;
//                initialTachoID.z = -234567;
//                //                    view.currentIndex++
//            }

//        }
        onClicked: {
            if (mouse.button === Qt.RightButton)
                contextMenu.popup()
        }
        onPressAndHold: {
//            if(initialRoundID.visible == true){
//                initialSpeedoID.visible = true;
//                initialRoundID.visible = false;
//                //                    view.currentIndex++
//            }else if(initialImageID.visible == true){
//                initialSpeedoID.visible = true;
//                initialImageID.visible = false;
//                //                    view.currentIndex++
//            }else if(initialSpeedoID.visible == true){
//                initialSquareID.visible = true;
//                initialSpeedoID.visible = false;
//                //                    view.currentIndex++
//            }else if(initialSquareID.visible == true){
//                initialTachoID.visible = true;
//                initialSquareID.visible = false;
//                //                    view.currentIndex++
//            }else if(initialTachoID.visible == true){
//                initialRoundID.visible = true;
//                initialTachoID.visible = false;
//                //                    view.currentIndex++
//            }
        }
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


    Rectangle {
        objectName: "RoundGauge"


        id: initialRoundID
        width: 250
        height: 200
        z: -2147483647
        //    rotation: rotation
        color: "transparent"
        //    border.color: "#9f9f9f"
        //    border.width: 2
        //    Component.onCompleted: colorsettings.set()
        property string title: parent.title
        property string mainunit : parent.mainunit
        property string vertgaugevisible : parent.vertgaugevisible
        property string horigaugevisible : parent.horigaugevisible
        property string secvaluevisible : parent.secvaluevisible
        property string secvalue : parent.secvalue
        property string maintextvalue : parent.maintextvalue
        property string mainvalue : parent.mainvalue
        property string maxvalue : parent.maxvalue
        property string maxval : parent.maxval
        property string titlecolor : parent.titlecolor
        property string titlefontsize : parent.titlefontsize
        property string mainfontsize : parent.mainfontsize
        property string resettitlecolor : parent.resettitlecolor
        property string resetbackroundcolor : parent.resetbackroundcolor
        property string framecolor : parent.framecolor
        property string titletextcolor : parent.titletextcolor
        property string textcolor : parent.textcolor
        property string barcolor : parent.barcolor
        property double warnvaluehigh : parent.warnvaluehigh
        property double warnvaluelow : parent.warnvaluelow
        property string gaugecolor1 : parent.gaugecolor1
        property string gaugecolor2 : parent.gaugecolor2
        property string gaugecolor3 : parent.gaugecolor3
        property string gaugecolor4 : parent.gaugecolor4
        property string gaugecolor5 : parent.gaugecolor5
        property string gaugecolor6 : parent.gaugecolor6
        property string gaugecolor7 : parent.gaugecolor7
        property string gaugecolor8 : parent.gaugecolor8
        property string gaugecolor9 : parent.gaugecolor9
        property string shadecolor1 : parent.shadecolor1
        property string shadecolor2 : parent.shadecolor2
        property string shadecolor3 : parent.shadecolor3
        property string shadecolor4 : parent.shadecolor4
        property int stepsize : parent.stepsize
        property real maxValueAngle : parent.maxValueAngle
        property real minValueAngle : parent.minValueAngle
        property bool fullCirc : parent.fullCirc
        property string subDivVal : parent.subDivVal
        property bool small : parent.small
        property string imgSource : parent.imgSource
        property string myID : parent.myID
        property string decPlace : parent.decPlace
        property string valuePropertyMain : parent.valuePropertyMain
        property string valuePropertySec : parent.valuePropertySec
        //    property alias rotation : rotation
        RoundGauge
        {
            id : tacho_gauge
            width: 300
            height: 300
            //        rotation: 10
            anchors.right: parent.right
            anchors.rightMargin: 0
            fullCircle: fullCirc
            anchors
            {
                top : parent.top
            }
    //        MouseArea {
    //            anchors.fill: parent
    //            onClicked: {
    //                if(small == true){
    //                    parent.digitalFont.pointSize = parent.height/4
    //                    small = false;
    //                }else{
    //                    parent.digitalFont.pointSize = parent.height/15
    //                    small = true;
    //                }
    //            }

    //            //            onClicked: { tacho_gauge.currentValue = Math.random()*10000; }
    //        }
            lowValuesColor : gaugecolor1
            highValuesColor : gaugecolor2
            innerCirclingColor : gaugecolor3
            outerCirclingColor : gaugecolor4
            textColor : gaugecolor5
            graduationColor : gaugecolor6
            backgroundColor : gaugecolor7
            cadrancolour  : gaugecolor8
            //            textFont.pointSize : 35
            //            textFont.family : "Helvetica"
            //            textFont.bold : true
            //            textFont.italic : true
            unit: mainunit
            unitFont.pointSize: height/30
            unitFont.bold: true
            unitFont.italic: true
            unitFont.family: "Helvetica"
            digitalFont.family : "Helvetica"
            digitalFont.bold : true
            digitalFont.italic : true
            digitalFont.pointSize: height/15
            //currentValue: parent.randVal * (maxValue - minValue) + minValue;
            currentValue: parent.mainvalue // / 1000// * (maxValue - minValue) + minValue;
            subDivs: subDivVal
            minValue: 0
            maxValue: maxval
            lowValues: warnvaluelow
            highValues: warnvaluehigh
        }

        //    anchors.top: scalerect.top
    }

//    Rectangle {
//        objectName: "ImageGauge"
//        z: -234567

//        id: initialImageID
//        anchors.fill: parent

////        width: 250
////        height: 200
////        z: -2147483647


//        Image {
//            id: bgImage
//            z:0
//            source: initialID.imgSource
//            anchors.fill: parent

//        }
//    }


//    Rectangle {

//        objectName: "SpeedoGauge"
//        z: -234567

//        id: initialSpeedoID
//        anchors.fill: parent
////        width: 250
////        height: 200
//        //    rotation: myRotation
//        //color: "black"
//        //    border.color: "#9f9f9f"
//        //    border.width: 2
//        Component.onCompleted: colorsettings.set()


//        //    property real myRotation : 0
//        CircularGauge {
//            id: speedometer
//            value: initialID.mainvalue
//            stepSize: initialID.stepsize
//            z: 11
//            anchors.fill: parent
//            style: DashboardGaugeStyle {
//                labelStepSize: 20
//                needleTipWidth: 0
//                needleLength: 0
//                needleBaseWidth: 0
//                //            needleColor: gaugecolor3
//                tickmarkLabel: Text {
//                    color: gaugecolor1
//                    text: styleData.value
//    //                font.bold: styleData.value >= speedometer.value+10 || styleData.value <= speedometer.value-10  ? false : true
//                    antialiasing: true
//    //                font.pixelSize: styleData.value >= speedometer.value+15 || styleData.value <= speedometer.value-15  ? speedometer.parent.height /22 : (parent.value-styleData.value)+speedometer.parent.height /11
//                    font.pixelSize: speedometer.parent.height /22
//                }
//            }
//            maximumValue: initialID.maxvalue
//            OpacityAnimator on opacity{
//                from: 0;
//                to: 1;
//                duration: 2000
//            }
//        }

//        GaugeNeedle {
//            id: speedoNeedlekph
//            z: 7
//            anchors.verticalCenterOffset: 0
//            //        value: Dashboard.speed / 4.155844155844156
//            value: Dashboard.speed * (77/(initialID.maxvalue))//0.009625

//            minval: initialID.minValueAngle
//            maxvaldegs: initialID.maxValueAngle
//            angle: (Dashboard.speed * (77/(initialID.maxvalue)))*3.5*Math.PI / 180
//            //        4000/8000
//            //        needlecolor: gaugecolor4
//            angleOffset: (initialID.minValueAngle-90) * (Math.PI / 180)

//            //angleOffset: -Math.PI / 2
//            needlecolor: initialID.gaugecolor4
//            clorStop1: initialID.shadecolor1
//            clorStop2: initialID.shadecolor2
//            clorStop3: initialID.shadecolor3
//            clorStop4: initialID.shadecolor4

//        }

//        Image {
//            id: speedoinner
//            width: parent.width /1.68
//            height: width
//            z: 9
//            source: "qrc:/graphics/Tacho_Mitte.png"
//            anchors.centerIn: parent
//            fillMode: Image.PreserveAspectFit
//        }

//        Text {
//            id: speedinnertext
//            color: gaugecolor4
//            text: Dashboard.speed
//            z: 10
//            font.family: "Eurostile"
//            font.pixelSize: parent.width / 10
//            anchors.centerIn: parent
//        }
//        Item {
//            //Set the colors of backround and Boarder
//            id: colorsettings
//            function set()
//            {
//                initialSpeedoID.color = initialID.resetbackroundcolor;
//                initialSpeedoID.border.color = initialID.framecolor;
//            }
//        }

//    }


//    Rectangle {
//        id: initialSquareID
////        width: 250
////        height: 200
//        //color: "black"
//        anchors.fill: parent
//        border.color: "#9f9f9f"
//        border.width: 2
//        Component.onCompleted: colorsettingsSquare.set()

//        objectName: "SquareGauge"
//        z: -234567

//        Rectangle {
//            id: titlebar
//            width: parent.width - 4
//            //height: (parent.height) * 0.2
//            height: 30
//            anchors.top : parent.top
//            anchors.left: parent.left
//            color: initialID.titlecolor
//            clip: false
//            visible: true
//            anchors.topMargin: 2
//            anchors.leftMargin: 2

//        }

//        SequentialAnimation {
//            id: anim
//            loops: Animation.Infinite
//            running: false
//            PropertyAnimation {
//                target: titlebar
//                property: "color"
//                from: "darkred"
//                to: "red"
//                duration: 3
//            }
//            PropertyAnimation {
//                target: titlebar
//                property: "color"
//                from: "red"
//                to: "darkred"
//                duration: 3
//            }
//        }
//        SequentialAnimation {
//            id: anim2
//            loops: Animation.Infinite
//            running: false
//            PropertyAnimation {
//                target: initialSquareID
//                property: "color"
//                from: "darkred"
//                to: "red"
//                duration: 3
//            }
//            PropertyAnimation {
//                target: initialSquareID
//                property: "color"
//                from: "red"
//                to: "darkred"
//                duration: 3
//            }
//        }
//        Text {
//            id: gaugetextfield
//            anchors.top: parent.top
//            anchors.horizontalCenter: parent.horizontalCenter
//            font.pixelSize: initialID.titlefontsize
//            font.bold: true
//            font.family: "Eurostile"
//            color: initialID.titletextcolor
//            text:initialID.title

//        }

//        Text {
//            id: mainvaluetextfield
//            /*anchors.top: parent.top
//                anchors.horizontalCenter: parent.horizontalCenter
//                anchors.topMargin: 30*/
//            anchors.horizontalCenter: parent.horizontalCenter
//            anchors.verticalCenter: parent.verticalCenter
//            font.pixelSize: initialID.mainfontsize
//            font.family: "Eurostile"
//            color: initialID.textcolor
//            onTextChanged: warningindication.warn()
//            text: initialID.mainvalue

//        }

//        Text {
//            id: mainvalueunittextfield
//            anchors.right: parent.right
//            anchors.rightMargin: 5
//            anchors.verticalCenter: parent.verticalCenter

//            font.pixelSize: 28
//            font.family: "Eurostile"
//            font.bold: true
//            color: initialID.textcolor
//            text: initialID.mainunit

//        }


//        Text {
//            id: secondaryvaluetextfield
//            anchors.bottom: parent.bottom
//            anchors.bottomMargin: 10
//            anchors.right: parent.right
//            anchors.rightMargin: 10
//            height: parent.height * 0.2
//            font.pixelSize: 28
//            font.family: "Eurostile"
//            color: initialID.textcolor
//            visible: initialID.secvaluevisible
//            text: initialID.secvalue
//        }

//        Gauge {
//            id: vertgauge
//            height: parent.height - 50
//            width: parent.width * 0.1
//            anchors.bottom: parent.bottom
//            anchors.bottomMargin: 0
//            anchors.top: parent.top
//            anchors.topMargin: 30
//            anchors.left: parent.left
//            anchors.leftMargin: 10
//            orientation: Qt.Vertical
//            minorTickmarkCount: 0
//            tickmarkAlignment: Qt.AlignRight
//            value: initialID.mainvalue
//            maximumValue: initialID.maxvalue
//            visible: initialID.vertgaugevisible

//            style: GaugeStyle {
//                tickmarkLabel: Text {
//                    font.pixelSize: 14
//                    color: "transparent"
//                }
//                tickmark: Item {
//                    implicitWidth: 18
//                    implicitHeight: 1

//                    Rectangle {
//                        color: "transparent"
//                        anchors.fill: parent
//                        anchors.leftMargin: 3
//                        anchors.rightMargin: 3
//                    }
//                }
//                valueBar: Rectangle {
//                    implicitWidth: 25
//                    color: barcolor
//                }
//            }

//        }

//        Item {
//            //to change the warning
//            id: warningindication
//            function warn()
//            {
//                if (mainvaluetextfield.text > initialID.warnvaluehigh || mainvaluetextfield.text < initialID.warnvaluelow )anim.running = true,anim2.running = true;
//                else anim.running = false,anim2.running = false,titlebar.color = initialID.resettitlecolor ,initialSquareID.color = initialID.resetbackroundcolor;

//            }
//        }
//        Item {
//            //Set the colors of backround and Boarder
//            id: colorsettingsSquare
//            function set()
//            {
//                initialSquareID.color = initialID.resetbackroundcolor;
//                initialSquareID.border.color = initialID.framecolor;
//            }
//        }
//        Gauge {
//            id: horizgauge
//            height: parent.height * 0.2
//            width: parent.width * 0.9
//            anchors.bottom: parent.bottom
//            anchors.bottomMargin: 10
//            anchors.left: parent.left
//            anchors.leftMargin: 0
//            //anchors.right: parent.right
//            //anchors.rightMargin: 0
//            anchors.horizontalCenter: parent.horizontalCenter
//            orientation: Qt.Horizontal
//            minorTickmarkCount: 0
//            tickmarkAlignment: Qt.AlignRight
//            value: initialID.mainvalue
//            maximumValue: initialID.maxvalue
//            visible: initialID.horigaugevisible

//            style: GaugeStyle {

//                tickmarkLabel: Text {
//                    font.pixelSize: 14
//                    color: "transparent"
//                }
//                tickmark: Item {
//                    implicitWidth: 18
//                    implicitHeight: 1

//                    Rectangle {
//                        color: "transparent"
//                        anchors.fill: parent
//                        anchors.leftMargin: 3
//                        anchors.rightMargin: 3
//                    }
//                }
//                valueBar: Rectangle {
//                    implicitWidth: 25
//                    color: barcolor
//                }
//            }

//        }

//    }

    Rectangle {
        objectName: "TachoGauge"

        id: initialTachoID
        width: 250
        height: 200
        z: -2147483647
    //    rotation: rotation
        //color: "black"
        //    border.color: "#9f9f9f"
        //    border.width: 2
        Component.onCompleted: colortachosettings.set()
        property string title: parent.title
        property string mainunit : parent.mainunit
        property string vertgaugevisible : parent.vertgaugevisible
        property string horigaugevisible : parent.horigaugevisible
        property string secvaluevisible : parent.secvaluevisible
        property string secvalue : parent.secvalue
        property string maintextvalue : parent.maintextvalue
        property string mainvalue : parent.mainvalue
        property string maxvalue : parent.maxvalue
        property string maxval : parent.maxval
        property string titlecolor : parent.titlecolor
        property string titlefontsize : parent.titlefontsize
        property string mainfontsize : parent.mainfontsize
        property string resettitlecolor : parent.resettitlecolor
        property string resetbackroundcolor : parent.resetbackroundcolor
        property string framecolor : parent.framecolor
        property string titletextcolor : parent.titletextcolor
        property string textcolor : parent.textcolor
        property string barcolor : parent.barcolor
        property double warnvaluehigh : parent.warnvaluehigh
        property double warnvaluelow : parent.warnvaluelow
        property string gaugecolor1 : parent.gaugecolor1
        property string gaugecolor2 : parent.gaugecolor2
        property string gaugecolor3 : parent.gaugecolor3
        property string gaugecolor4 : parent.gaugecolor4
        property string gaugecolor5 : parent.gaugecolor5
        property string gaugecolor6 : parent.gaugecolor6
        property string gaugecolor7 : parent.gaugecolor7
        property string gaugecolor8 : parent.gaugecolor8
        property string gaugecolor9 : parent.gaugecolor9
        property string shadecolor1 : parent.shadecolor1
        property string shadecolor2 : parent.shadecolor2
        property string shadecolor3 : parent.shadecolor3
        property string shadecolor4 : parent.shadecolor4
        property int stepsize : parent.stepsize
        property real maxValueAngle : parent.maxValueAngle
        property real minValueAngle : parent.minValueAngle
        property bool fullCirc : parent.fullCirc
        property string subDivVal : parent.subDivVal
        property bool small : parent.small
        property string imgSource : parent.imgSource
        property string myID : parent.myID
        property string decPlace : parent.decPlace
        property string valuePropertyMain : parent.valuePropertyMain
        property string valuePropertySec : parent.valuePropertySec
        //    property alias rotation : rotation
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
            value: parent.mainvalue
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
            id: colortachosettings
            function set()
            {
                initialTachoID.color = resetbackroundcolor;
                initialTachoID.border.color = framecolor;
    //            tachStyle.minimumValueAngle = minValueAngle
    //            tachStyle.maximumValueAngle = maxValueAngle
            }
        }
        //    anchors.top: scalerect.top
    }





}



