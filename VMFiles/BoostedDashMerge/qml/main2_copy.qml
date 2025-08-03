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

    Connections{
        target: Dashboard
        onSpeedChanged :speedo.currentValue = Dashboard.speed
        onRpmChanged: tacho_gauge.currentValue = Dashboard.rpm
        onWatertempChanged:water_temp.currentValue = water
        onOiltempChanged:oil_temp.currentValue = oiltemp
        onBatteryVChanged:fuel_level.currentValue=batteryV

    }

    Keys.onSpacePressed:
    {
        randVal = Math.random();
    }

    Button {
        height: 40
        text: qsTr("Reload")
        z: 2
        opacity: 0.5
        anchors
        {
            horizontalCenter : parent.horizontalCenter
            verticalCenter : speedo.verticalCenter
        }

        onClicked: {
            // Invoke the calculator slot to sum the numbers
            calculator.oh_no(main_cadran.randVal)
        }
    }

    RoundGauge
    {
        id : speedo
        innerCirclingColor: qsTr("#ffffff")
        anchors
        {
            left : parent.left
            right : parent.horizontalCenter
            top : parent.top
            bottom : parent.verticalCenter
        }
        MouseArea {
            anchors.fill: parent
            onClicked: { speedo.currentValue = Math.random(); }


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
        innerCirclingColor: "#000000"
        fullCircle: false
        anchors
        {
            right : parent.right
            left : parent.horizontalCenter
            top : parent.top
            bottom : parent.verticalCenter
        }
        MouseArea {
            anchors.fill: parent
            onClicked: { tacho_gauge.currentValue = Math.random(); }
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


    Item
    {
        id : dashboard
        width : parent.width * 0.5
        property int gaugeWidth : width * 0.25;
        property int gaugeHeight : height * 0.5

        anchors
        {
            horizontalCenter : parent.horizontalCenter
            top : parent.verticalCenter
            bottom : parent.bottom
        }

        RoundGauge
        {
            id : water_temp
            anchors
            {
                left : parent.left
                top : parent.top
            }
            MouseArea {
                anchors.fill: parent
                onClicked: { currentValue: Math.random(); }
            }
            indicatorWidth: 5
            width : dashboard.gaugeWidth
            height : dashboard.gaugeHeight
            unit : "Water C"
            minValue: 0
            maxValue: 120
            subDivs: 2
            lowValues: 30
            highValues: 95
            unitFont.pointSize: 10
            //                textFont.pointSize : 6
            digitalFont.pointSize: 10
            //currentValue: main_cadran.waterVal *  (maxValue - minValue) + minValue;

        }
        RoundGauge
        {
            id : oil_temp
            anchors
            {
                horizontalCenter : parent.horizontalCenter
                top : parent.top
            }
            indicatorWidth: 5
            unit : "Oil C"
            width : dashboard.gaugeWidth
            height : dashboard.gaugeHeight
            minValue: 0
            maxValue: 100
            subDivs: 2
            lowValues: 12
            highValues: 70
            //                textFont.pointSize : 6
            unitFont.pointSize: 10
            digitalFont.pointSize: 10
//            currentValue: main_cadran.oilVal *  (maxValue - minValue) + minValue;
        }
        RoundGauge
        {
            id : fuel_level
            width : dashboard.gaugeWidth
            height : dashboard.gaugeHeight
            highValues: 14
            anchors
            {
                right : parent.right
                top : parent.top
            }
            indicatorWidth: 5
            unit : "Voltage"
            minValue: 0
            maxValue: 15
            lowValuesColor: "#cc0000"
            subDivs: 4
            lowValues: 10
            unitFont.pointSize: 10
            //                textFont.pointSize : 6
            digitalFont.pointSize: 10
//            currentValue: main_cadran.fuelVal *  (maxValue - minValue) + minValue;
        }
//        GraphGauge
//        {
//            id : graph_gauge
//            width : dashboard.gaugeWidth
//            height : dashboard.gaugeHeight
//            minValue: 0
//            maxValue: 60
//            subDivs: 4
//            anchors
//            {
//                left : fuel_level.right
//                top : parent.top
//            }
////            currentValue: main_cadran.fuelVal *  (maxValue - minValue) + minValue;
//            //                currentValue: 30
//        }

        RoundGauge
        {
            id : oil_pressure
            width : dashboard.gaugeWidth
            height : dashboard.gaugeHeight
            anchors
            {
                left : water_temp.horizontalCenter
                bottom : parent.bottom
            }
            indicatorWidth: 5
            unit : "Oil PSI"
            minValue: 0
            maxValue: 10
            lowValuesColor: "#cc0000"
            subDivs: 9
            lowValues: 2
            highValues: 8
            unitFont.pointSize: 10
            //                textFont.pointSize : 6
            digitalFont.pointSize: 10
//            currentValue: main_cadran.randVal *  (maxValue - minValue) + minValue;
        }
        RoundGauge
        {
            id : fuel_pressure
            width : dashboard.gaugeWidth
            height : dashboard.gaugeHeight
            anchors
            {
                right : fuel_level.horizontalCenter
                bottom : parent.bottom
            }
            indicatorWidth: 5
            unit : "Fuel PSI"
            minValue: 0
            maxValue: 10
            lowValuesColor: "#cc0000"
            subDivs: 9
            lowValues: 2
            highValues: 8
            unitFont.pointSize: 10
            //                textFont.pointSize : 6
            digitalFont.pointSize: 10
//            currentValue: main_cadran.randVal *  (maxValue - minValue) + minValue;
        }


        // Here we see the result of subtraction
        Text {
            id: randResult
            anchors
            {
                right : parent.left
                bottom : parent.bottom
            }
            //            x: 726
            //            y: 463
            //            width: 119
            //            height: 14
            color: "#f4f4f4"
        }
        //            Component.onCompleted: {
        //                calculator.oh_no(main_cadran.randVal)
        //            }
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







/*##^## Designer {
    D{i:0;autoSize:true;height:480;width:640}
}
 ##^##*/
