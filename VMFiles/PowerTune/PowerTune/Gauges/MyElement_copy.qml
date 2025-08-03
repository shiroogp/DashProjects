import QtQuick 2.8
import QtGraphicalEffects 1.0
import QtQuick.Controls 1.4
import QtQuick.Controls.Styles 1.4
import QtQuick.Extras 1.4
import "../Gauges"
Item {
    id:dashboard_panel
    width:1024
    height:600
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
        x: -169
        y: -82
        opacity: 1
    }
    Image {
        id: boosted
        source: "images/boosted.png"
        x: 304
        y: -28
        opacity: 1
    }
    Image {
        id: services
        source: "images/services.png"
        x: 236
        y: 523
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
        opacity: 0.85882352941176
    }
    Image {
        id: tl
        source: "images/tl.png"
        x: 9
        y: 9
        opacity: 0.85882352941176
    }
    Image {
        id: br
        source: "images/br.png"
        x: 844
        y: 414
        opacity: 0.85882352941176
    }
    Image {
        id: bl
        source: "images/bl.png"
        x: 9
        y: 414
        opacity: 0.85882352941176
    }

    Rectangle {
        id: scalerect
        x: 2
        y: 7
        width: 1024
        height: 600
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
                        color: styleData.value >= speedometer.value+10 || styleData.value <= speedometer.value-10  ? "white" : "red"
                        text: styleData.value
                        font.bold: styleData.value >= speedometer.value+10 || styleData.value <= speedometer.value-10  ? false : true
                        antialiasing: true
                        font.pixelSize: styleData.value >= speedometer.value+15 || styleData.value <= speedometer.value-15  ? speedo.height /22 : (speedometer.value-styleData.value)+speedo.height /11
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
                angleOffset: -Math.PI / 2

            }

            GaugeNeedle_minus180to90 {
                id: speedoNeedlemph
                z: 6
                anchors.verticalCenterOffset: 0
                value: Dashboard.speed / 2.597402597402597
                angleOffset: -Math.PI / 2
            }

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
                        color: styleData.value <= Dashboard.rpm/1000 ? "blue" : "white"
                        text: styleData.value
                        font.bold: styleData.value >= Dashboard.rpm/1000+0.5 || styleData.value <= Dashboard.rpm/1000-0.5  ? false : true
                        antialiasing: true
                        font.pixelSize: styleData.value >= Dashboard.rpm/1000+0.5 || styleData.value <= Dashboard.rpm/1000-0.5  ? revcounterticks.height /22 : (revcounterticks.value-Dashboard.rpm/1000)+speedo.height /11
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
        anchors.centerIn: dashboard_panel
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
