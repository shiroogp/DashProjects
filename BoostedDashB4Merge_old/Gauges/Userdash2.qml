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
        onDashsetup2Changed: {
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
            if (dashvalue.textAt(44) !== "") {imgSource = "file://"+dashvalue.textAt(44);}else {imgSource = "";}
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
        onRpmstyle2Changed:
        {
            rpmgauge.selctor();
        }
    }

    Loader{
        id: rpmbarloader
        anchors.fill:parent
        source: ""
    }
    ComboBox{
        id: dashvalue
        width: 200
        model: Dashboard.dashsetup2
        visible:false
        Component.onCompleted: {Connect.readdashsetup2(),rpmgauge.selctor();}
    }
    Item{
        id: rpmgauge
        function selctor()
        {
            switch (Dashboard.rpmstyle2) {

            case 0:
            {
                rpmbarloader.source = ""
                break;
            }
            case 1:
            {
                rpmbarloader.source = "qrc:/Gauges/RPMBarStyle1.qml"
                break;
            }
            case 2:
            {
                rpmbarloader.source = "qrc:/Gauges/RPMBARStyle2.qml"
                break;
            }
            case 3:
            {
                rpmbarloader.source = "qrc:/Gauges/RPMbarStyle3.qml"
                break;
            }
            case 4:
            {
                rpmbarloader.source = "qrc:/Gauges/RPMbar.qml"
                break;
            }
            }
        }
    }
    Rectangle{
        anchors.fill: parent
        z:100 //This makes the Rectangle appear in front of the bar gauges
        color: "transparent"
        WarningLoader{}
    }

}








/*##^## Designer {
    D{i:0;autoSize:true;height:480;width:640}
}
 ##^##*/
