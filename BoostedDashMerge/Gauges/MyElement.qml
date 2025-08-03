import QtQuick 2.8
import QtQuick.Extras 1.4
import QtQuick.Controls 2.1
import QtQuick.Controls.Styles 1.4
import "../Gauges"
import "qrc:/Gauges/createsquaregaugeUserDash.js" as CreateSquareGaugeScript
import "qrc:/Gauges/createroundgaugeUserDash.js" as CreateRoundGaugeScript
import "qrc:/Gauges/createspeedogaugeUserDash.js" as CreateSpeedoGaugeScript
import "qrc:/Gauges/createtachogaugeUserDash.js" as CreateTachoGaugeScript
import "qrc:/Gauges/createimageUserDash.js" as CreateImageScript


Item {
    id: userDash
    anchors.fill: parent
    property string imgSource: ""
    property bool val1: false
    property bool val2: false
    property bool val3: false
    property double val4 : 20000
    property int val5 : -20000
    property string val6 : "transparent"
    property string val7 : "transparent"
    property string val8 : "transparent"
    property string val9 : "transparent"
    property string val10 : "transparent"
    property string val11 : "transparent"
    property int val12
    property int val13
    property string gaugeType : "SquareGauge"
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
    property int stepsize : 20
    property string minValueAngle : "-90"
    property string maxValueAngle : "180"
    property string myRotation : "0"
    property bool fullCirc : false
    property string subDivVal : "6"

    Connections{
        target: Dashboard
        onDashsetup4Changed: {
            //Need to do this nicer but it works
            //console.log(Dashboard.dashsetup1)
            if (dashvalue.textAt(24) !== "") {gaugeType = dashvalue.textAt(24);}else {gaugeType = "SquareGauge";}
            if (dashvalue.textAt(8) === "true") {val1 = true};
            if (dashvalue.textAt(8) === "false") {val1 = false};
            if (dashvalue.textAt(9) === "true") {val2 = true};
            if (dashvalue.textAt(9) === "false") {val2 = false};
            if (dashvalue.textAt(10) === "true") {val3 = true};
            if (dashvalue.textAt(10) === "false") {val3 = false};
            if (dashvalue.textAt(14) !== "") {val4 = dashvalue.textAt(14);}else {val4 = 20000;}
            if (dashvalue.textAt(15) !== "") {val5 = dashvalue.textAt(15);}else {val5 = -20000;}
            if (dashvalue.textAt(16) !== "") {val6 = dashvalue.textAt(16);}else {val6 = "#9f9f9f";}
            if (dashvalue.textAt(17) !== "") {val7 = dashvalue.textAt(17);}else {val7 = "black";}
            if (dashvalue.textAt(18) !== "") {val8 = dashvalue.textAt(18);}else {val8 = "#9f9f9f";}
            if (dashvalue.textAt(19) !== "") {val9 = dashvalue.textAt(19);}else {val9 = "white";}
            if (dashvalue.textAt(20) !== "") {val10 = dashvalue.textAt(20);}else {val10 = "white";}
            if (dashvalue.textAt(21) !== "") {val11 = dashvalue.textAt(21);}else {val11 = "grey";}
            if (dashvalue.textAt(22) !== "") {val12 = dashvalue.textAt(22);}else {val12 = 28;}
            if (dashvalue.textAt(23) !== "") {val13 = dashvalue.textAt(23);}else {val13 = 50;}
            if (dashvalue.textAt(25) !== "") {gaugecolor1 = dashvalue.textAt(25);}else {gaugecolor1 = "white";}
            if (dashvalue.textAt(26) !== "") {gaugecolor2 = dashvalue.textAt(26);}else {gaugecolor2 = "red";}
            if (dashvalue.textAt(27) !== "") {gaugecolor3 = dashvalue.textAt(27);}else {gaugecolor3 = "#ffffff";}
            if (dashvalue.textAt(28) !== "") {gaugecolor4 = dashvalue.textAt(28);}else {gaugecolor4 = "blue";}
            if (dashvalue.textAt(29) !== "") {gaugecolor5 = dashvalue.textAt(29);}else {gaugecolor5 = "red";}
            if (dashvalue.textAt(30) !== "") {gaugecolor6 = dashvalue.textAt(30);}else {gaugecolor6 = "red";}
            if (dashvalue.textAt(31) !== "") {gaugecolor7 = dashvalue.textAt(31);}else {gaugecolor7 = "blue";}
            if (dashvalue.textAt(32) !== "") {gaugecolor8 = dashvalue.textAt(32);}else {gaugecolor8 = "white";}
            if (dashvalue.textAt(33) !== "") {gaugecolor9 = dashvalue.textAt(33);}else {gaugecolor9 = "red";}
            if (dashvalue.textAt(34) !== "") {shadecolor1 = dashvalue.textAt(34);}else {shadecolor1 = "#ffffff";}
            if (dashvalue.textAt(35) !== "") {shadecolor2 = dashvalue.textAt(35);}else {shadecolor2 = "#e96448";}
            if (dashvalue.textAt(36) !== "") {shadecolor3 = dashvalue.textAt(36);}else {shadecolor3 = "#f22900";}
            if (dashvalue.textAt(37) !== "") {shadecolor4 = dashvalue.textAt(37);}else {shadecolor4 = "transparent";}
            if (dashvalue.textAt(38) !== "") {stepsize = dashvalue.textAt(38);}else {stepsize = 20;}
            if (dashvalue.textAt(39) !== "") {minValueAngle = dashvalue.textAt(39);}else {minValueAngle = "-90";}
            if (dashvalue.textAt(40) !== "") {maxValueAngle = dashvalue.textAt(40);}else {maxValueAngle = "180";}
            if (dashvalue.textAt(41) !== "") {myRotation = dashvalue.textAt(41);}else {myRotation = "0";}
            if (dashvalue.textAt(42) !== "") {fullCirc = (dashvalue.textAt(42)==="true");}else {fullCirc = false;}
            if (dashvalue.textAt(43) !== "") {subDivVal = dashvalue.textAt(43);}else {subDivVal = "6";}
            if (dashvalue.textAt(44) !== "") {imgSource = dashvalue.textAt(44);}else {imgSource = "";}
            if (gaugeType.toLowerCase()== "squaregauge") {

                CreateSquareGaugeScript.createSquareGauge(dashvalue.textAt(0),dashvalue.textAt(1),dashvalue.textAt(2),dashvalue.textAt(3),dashvalue.textAt(4),dashvalue.textAt(5),dashvalue.textAt(6),dashvalue.textAt(7),val1,val2,val3,Dashboard,dashvalue.textAt(12),dashvalue.textAt(13),val4,val5,val6,val7,val8,val9,val10,val11,val12,val13,gaugecolor1,gaugecolor2,gaugecolor3,gaugecolor4,gaugecolor5,gaugecolor6,gaugecolor7,gaugecolor8,gaugecolor9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal,imgSource);
            }else if (gaugeType.toLowerCase()== "roundgauge") {

                CreateRoundGaugeScript.createRoundGauge(dashvalue.textAt(0),dashvalue.textAt(1),dashvalue.textAt(2),dashvalue.textAt(3),dashvalue.textAt(4),dashvalue.textAt(5),dashvalue.textAt(6),dashvalue.textAt(7),val1,val2,val3,Dashboard,dashvalue.textAt(12),dashvalue.textAt(13),val4,val5,val6,val7,val8,val9,val10,val11,val12,val13,gaugecolor1,gaugecolor2,gaugecolor3,gaugecolor4,gaugecolor5,gaugecolor6,gaugecolor7,gaugecolor8,gaugecolor9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal,imgSource);
            }else if (gaugeType.toLowerCase()== "speedogauge") {

                CreateSpeedoGaugeScript.createSpeedoGauge(dashvalue.textAt(0),dashvalue.textAt(1),dashvalue.textAt(2),dashvalue.textAt(3),dashvalue.textAt(4),dashvalue.textAt(5),dashvalue.textAt(6),dashvalue.textAt(7),val1,val2,val3,Dashboard,dashvalue.textAt(12),dashvalue.textAt(13),val4,val5,val6,val7,val8,val9,val10,val11,val12,val13,gaugecolor1,gaugecolor2,gaugecolor3,gaugecolor4,gaugecolor5,gaugecolor6,gaugecolor7,gaugecolor8,gaugecolor9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal,imgSource);
            }else if (gaugeType.toLowerCase()== "tachogauge") {

                CreateTachoGaugeScript.createTachoGauge(dashvalue.textAt(0),dashvalue.textAt(1),dashvalue.textAt(2),dashvalue.textAt(3),dashvalue.textAt(4),dashvalue.textAt(5),dashvalue.textAt(6),dashvalue.textAt(7),val1,val2,val3,Dashboard,dashvalue.textAt(12),dashvalue.textAt(13),val4,val5,val6,val7,val8,val9,val10,val11,val12,val13,gaugecolor1,gaugecolor2,gaugecolor3,gaugecolor4,gaugecolor5,gaugecolor6,gaugecolor7,gaugecolor8,gaugecolor9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal,imgSource);
            }else if (gaugeType.toLowerCase()== "imagegauge") {

                CreateImageScript.createImage(dashvalue.textAt(0),dashvalue.textAt(1),dashvalue.textAt(2),dashvalue.textAt(3),dashvalue.textAt(4),dashvalue.textAt(5),dashvalue.textAt(6),dashvalue.textAt(7),val1,val2,val3,Dashboard,dashvalue.textAt(12),dashvalue.textAt(13),val4,val5,val6,val7,val8,val9,val10,val11,val12,val13,gaugecolor1,gaugecolor2,gaugecolor3,gaugecolor4,gaugecolor5,gaugecolor6,gaugecolor7,gaugecolor8,gaugecolor9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal,imgSource);
            }
        }
    }
    ComboBox{
        id: dashvalue
        width: 200
        model: Dashboard.dashsetup4
        visible:false
        Component.onCompleted: {Connect.readdashsetup4()}
    }
    Rectangle{
        anchors.fill: parent
        z:100 //This makes the Rectangle appear in front of the bar gauges
        color: "transparent"
        WarningLoader{}
    }
    //    Connections{
//        target: Dashboard
//        onSpeedChanged :speed = Dashboard.speed
////        onRpmChanged: {
////            rpms = Dashboard.rpm;
////        }
////        onWatertempChanged:water_temp.currentValue = water
////        onOiltempChanged:oil_temp.currentValue = oiltemp
////        onBatteryVChanged:fuel_level.currentValue=batteryV

//    }
    Image {
        id: background
        source: "images/background.png"
        x: 0
        y: 0
        opacity: 1
    }
    Image {
        id: boosted
        source: "images/boosted.png"
        x: 304
        y: 0
        visible: false
        opacity: 1
    }
    Image {
        id: services
        source: "images/services.png"
        x: 236
        y: 523
        visible: false
        opacity: 1
    }
//    Image {
//        id: cl
//        source: "images/cl.png"
//        x: 130
//        y: 112
//        opacity: 1
//    }
//    Image {
//        id: cr
//        source: "images/cr.png"
//        x: 530
//        y: 112
//        opacity: 1
//    }
    Image {
        id: tr
        source: "images/tr.png"
        x: 844
        y: 9
        visible: false
        opacity: 0.85882352941176
    }
    Image {
        id: tl
        source: "images/tl.png"
        x: 9
        y: 9
        visible: false
        opacity: 0.85882352941176
    }
    Image {
        id: br
        source: "images/br.png"
        x: 844
        y: 414
        visible: false
        opacity: 0.85882352941176
    }
    Image {
        id: bl
        source: "images/bl.png"
        x: 9
        y: 414
        visible: false
        opacity: 0.85882352941176
    }

    Rectangle {
        id: scalerect
        x: 2
        y: 7
        anchors.fill: parent

        color: "#00000000"
        z: 11
//        Rectangle {
//            id: odotrip
//            width: scalerect.width /2.33
//            height: scalerect.height /15
//            color: "#00000000"
//            z: 1
//            Text {
//                id: tripname
//                color: "#808080"
//                text: "Trip "
//                z: 1
//                anchors.right: trip.left
//                font.family: "Eurostile"
//                font.pixelSize: scalerect.width / 50
//                anchors.bottom: odotrip.bottom
//            }

//            Text {
//                id: trip
//                color: "#808080"
//                text: (Dashboard.Trip).toFixed(1)
//                z: 1
//                font.bold: true
//                anchors.right: tripunits.left
//                font.family: "Eurostile"
//                font.pixelSize: scalerect.width / 45
//                anchors.bottom: odotrip.bottom
//            }

//            Text {
//                id: tripunits
//                color: "#808080"
//                text: " km"
//                z: 1
//                anchors.right: parent.right
//                font.family: "Eurostile"
//                font.pixelSize: scalerect.width / 50
//                anchors.bottom: odotrip.bottom
//            }

//            Text {
//                id: odoname
//                color: "#808080"
//                text: "Total "
//                z: 1
//                font.family: "Eurostile"
//                font.pixelSize: scalerect.width / 50
//                anchors.left: parent.left
//                anchors.bottom: odotrip.bottom
//            }

//            Text {
//                id: odo
//                color: "#808080"
//                text: (Dashboard.Odo).toFixed(0)
//                z: 2
//                font.bold: true
//                font.family: "Eurostile"
//                font.pixelSize: scalerect.width / 45
//                anchors.left: odoname.right
//                anchors.bottom: odotrip.bottom
//            }

//            Text {
//                id: odounit
//                color: "#808080"
//                text: " km"
//                z: 3
//                font.family: "Eurostile"
//                font.pixelSize: scalerect.width / 60
//                anchors.left: odo.right
//                anchors.bottom: odotrip.bottom
//            }
//            anchors.leftMargin: scalerect.width / 3.5
//            anchors.left: scalerect.left
//            anchors.bottom: scalerect.bottom
//            anchors.bottomMargin: scalerect.height / 4
//        }

        Rectangle {
            id: speedo
            width: height
            height: scalerect.height /1.6
            color: "#00000000"
            anchors.leftMargin: 122
            anchors.topMargin: 105
            CircularGauge {
                id: speedometer
                stepSize: 20
                z: 11
                anchors.fill: parent
                style: DashboardGaugeStyle {
                    labelStepSize: 20
                    needleTipWidth: 0
                    needleLength: 0
                    needleBaseWidth: 0
                    tickmarkLabel: Text {
                        color: gaugecolor5
//                        color: styleData.value >= speedometer.value+10 || styleData.value <= speedometer.value-10  ? "white" : "red"
                        text: styleData.value
//                        font.bold: styleData.value >= speedometer.value+10 || styleData.value <= speedometer.value-10  ? false : true
                        antialiasing: true
                        font.pixelSize:  speedo.height /22
//                        font.pixelSize: styleData.value >= speedometer.value+15 || styleData.value <= speedometer.value-15  ? speedo.height /22 : (speedometer.value-styleData.value)+speedo.height /11
                    }
                }
                maximumValue: 320
                OpacityAnimator on opacity{
                    from: 0;
                    to: 1;
                    duration: 2000
                }
            }

            GaugeNeedle_minus180to90 {
                id: speedoNeedlekph
                z: 7
                anchors.verticalCenterOffset: 0
                value: Dashboard.speed / 4.155844155844156
                angleOffset: Math.PI / 2

            }

//            GaugeNeedle_minus180to90 {
//                id: speedoNeedlemph
//                z: 6
//                anchors.verticalCenterOffset: 0
//                value: Dashboard.speed / 2.597402597402597
//                angleOffset: -Math.PI / 2
//            }

            Image {
                id: speedoinner
                width: parent.width /1.68
                height: width
                z: 9
                source: "qrc:/graphics/Tacho_Mitte.png"
                anchors.centerIn: parent
                fillMode: Image.PreserveAspectFit
            }

            Text {
                id: speedinnertext
                color: "#ffffff"
                text: Dashboard.speed
                z: 10
                font.family: "Eurostile"
                font.pixelSize: scalerect.width / 20
                anchors.centerIn: parent
            }
            anchors.left: scalerect.left
            anchors.top: scalerect.top
        }

        Rectangle {
            id: revcounter
            x: 526
            width: height
            height: scalerect.height /1.6
            color: "#00000000"
            z: 3
            anchors.rightMargin: 123
            anchors.topMargin: 105
            anchors.right: scalerect.right
            CircularGauge {
                id: revcounterticks
//                stepSize: 1
                z: 11
                anchors.fill: parent

                style: TachometerStyle2 {
                    needleTipWidth: 0
                    needleLength: 0
                    needleBaseWidth: 0
                    maximumValueAngle: 180
                    tickmarkLabel: Text {
//                        color: styleData.value <= Dashboard.rpm/1000 ? "blue" : "white"
                        color: gaugecolor4
                        text: styleData.value
//                        font.bold: styleData.value >= Dashboard.rpm/1000+0.5 || styleData.value <= Dashboard.rpm/1000-0.5  ? false : true
                        antialiasing: true
                        font.pixelSize:  revcounterticks.height /22
//                        font.pixelSize: styleData.value >= Dashboard.rpm/1000+0.5 || styleData.value <= Dashboard.rpm/1000-0.5  ? revcounterticks.height /22 : (revcounterticks.value-Dashboard.rpm/1000)+speedo.height /11
                    }
                    minimumValueAngle: -90

                }
                maximumValue: 10
                OpacityAnimator on opacity{
                    from: 0;
                    to: 1;
                    duration: 2000
                }
            }

            GaugeNeedle_minus90to180 {
                id: revneedele
                z: 8
                anchors.verticalCenterOffset: 0
                value: Dashboard.rpm *0.0077
                angleOffset: Math.PI
                secondaryColor: "black"
                clorStop1: "black"
                clorStop2: "white"
                clorStop3: "red"
                clorStop4: "transparent"

            }

            Image {
                id: revinner
                width: parent.width /1.68
                height: width
                z: 9
                source: "qrc:/graphics/Tacho_Mitte.png"
                anchors.centerIn: parent
                fillMode: Image.PreserveAspectFit
            }

            Text {
                id: revinnertesxt
                color: "#ffffff"
                text: Dashboard.rpm
                z: 10
                font.family: "Eurostile"
                font.pixelSize: scalerect.width / 20
                anchors.centerIn: parent
            }
            anchors.top: scalerect.top
        }
        anchors.centerIn: userDash
//        OpacityAnimator {
//            target: speedometer;
//            from: 0;
//            to: 1;
//            duration: 2000
//            running: true
//        }
//        OpacityAnimator {
//            target: revcounterticks;
//            from: 0;
//            to: 1;
//            duration: 2000
//            running: true
//        }

//        OpacityAnimator {
//            id: speedoopacity
//            target: speedoNeedlekph;
//            from: 0;
//            to: 1;
//            duration: 2000
//            running: true
//        }


    }
}



/*##^## Designer {
    D{i:0;autoSize:true;height:480;width:640}D{i:6;invisible:true}D{i:7;invisible:true}
D{i:8;invisible:true}D{i:9;invisible:true}D{i:10;invisible:true}D{i:11;invisible:true}
}
 ##^##*/
