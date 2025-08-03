import QtQuick 2.5
import QtQuick.Controls 1.4
import QtQuick.Layouts 1.2
import QtQuick.Window 2.2



Rectangle
{
    id : main_cadran
    objectName: "tacho_gauge"
    //rpmval: randResult

    anchors.fill: parent
    color : "black"
    Component.onCompleted : forceActiveFocus();

    property real randVal : 0;
    property real speedVal : 0;
    property real waterVal : 0;
    property real fuelVal : 0;
    property real oilVal : 0;
    width: 1024
    height: 600

    Connections{
        target: Dashboard
        onSpeedChanged :speedo.currentValue = Dashboard.speed
        onRpmChanged: {
            tacho_gauge1.currentValue = Dashboard.rpm;
            tacho_gauge.currentValue = Dashboard.rpm;
        }
//        onWatertempChanged:water_temp.currentValue = water
//        onOiltempChanged:oil_temp.currentValue = oiltemp
//        onBatteryVChanged:fuel_level.currentValue=batteryV

    }

    Keys.onSpacePressed:
    {
        randVal = Math.random();
    }

    RoundGauge
    {
        id : speedo
        width: 450
        height: 450
        anchors.verticalCenter: parent.verticalCenter
        anchors.horizontalCenter: parent.horizontalCenter
        textColor: "#ffff00"
        innerCirclingColor: qsTr("#ffffff")
        MouseArea {
            anchors.fill: parent
            onClicked: { speedo.currentValue = Math.random()*100; }


        }
        //textFont.family : "Helvetica"
        //textFont.bold : true
        //textFont.italic : true
        digitalFont.family : "Helvetica"
        digitalFont.bold : true
        digitalFont.italic : true

        //            textFont.pointSize : 12

        unit: "km/h"
        unitFont.pointSize: 12
        unitFont.bold: true
        unitFont.italic: true
        unitFont.family: "Helvetica"
        fullCircle: true
        subDivs: 17
        minValue: 0
        maxValue: 340
        lowValues: 30
        highValues: 220
        currentValue: (parent.speedVal/10) *  (maxValue - minValue) + minValue;
        digitalFont.pointSize: 15
    }
    RoundGauge
    {
        id : tacho_gauge
        width: 300
        height: 300
        rotation: 10
        anchors.right: parent.right
        anchors.rightMargin: 0
        innerCirclingColor: "#000000"
        fullCircle: false
        anchors
        {
            top : parent.top
        }
        MouseArea {
            anchors.fill: parent
            onClicked: { tacho_gauge.currentValue = Math.random()*10000; }
        }
        outerCirclingColor: "#ff2200"
        //            textFont.pointSize : 35
        //            textFont.family : "Helvetica"
        //            textFont.bold : true
        //            textFont.italic : true
        unit: "RPM x1000"
        unitFont.pointSize: 12
        unitFont.bold: true
        unitFont.italic: true
        unitFont.family: "Helvetica"
        digitalFont.family : "Helvetica"
        digitalFont.bold : true
        digitalFont.italic : true
        digitalFont.pointSize: 20
        //currentValue: parent.randVal * (maxValue - minValue) + minValue;
        subDivs: 6
        minValue: 0
        maxValue: 7000
        lowValues: 1000
        highValues: 5500
    }


    RoundGauge {
        id: tacho_gauge1
        x: -9
        y: -8
        width: 300
        height: 300
        z: 0
        rotation: -10
        contextType: qsTr("2d")
        anchors.leftMargin: 0
        minValue: 0
        subDivs: 6
        digitalFont.bold: true
        anchors.top: parent.top
        unitFont.family: "Helvetica"
        anchors.left: parent.left
        lowValues: 1000
        unitFont.pointSize: 12
        unitFont.italic: true
        highValues: 5500
        innerCirclingColor: "#000000"
        digitalFont.pointSize: 20
        digitalFont.italic: true
        fullCircle: false
        unit: "RPM x1000"
        maxValue: 7000
        digitalFont.family: "Helvetica"
        MouseArea {
            anchors.fill: parent
        }
        outerCirclingColor: "#ff2200"
        unitFont.bold: true
    }


}

// Here we take the result of sum or subtracting numbers
//Connections {
//    target: Dashboard
//    onSpeedChanged : speedo.currentValue = Dashboard.speed

    // Sum signal handler
//    onSumResult: {
//        // sum was set through arguments=['sum']
//        //sumResult.text = sum
//    }

//    // Subtraction signal handler
//    onSubResult: {
//        // sub was set through arguments=['sub']
//        //subResult.text = sub
//    }

//    onRandom: {
//        rand = rand / 7
//        main_cadran.randVal = rand
//        //                main_cadran.speedVal = rand
//        //                main_cadran.waterVal = rand
//        //                main_cadran.oilVal = rand
//        //                main_cadran.fuelVal = rand
//        //                main_cadran.randVal = rand
//    }
//    onSpeed:{
//        speedo.currentValue = speed
//        //                main_cadran.speedVal=speed
//    }
//    onRpm:{
//        tacho_gauge.currentValue = rpm
//        //                main_cadran.randVal=rpm
//    }
//    onWater:{
//        water_temp.currentValue = water
//        //                main_cadran.waterVal=water
//    }
//    onOil:{
//        oil_temp.currentValue = oil
//        //                main_cadran.oilVal=oil
//    }
//    onFuel:{
//        fuel_level.currentValue=fuel;
//        graph_gauge.currentValue = fuel;
//        //                main_cadran.fuelVal=fuel
//    }
//}








