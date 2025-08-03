/***********************************************************************/
/* File: main.qml */
/* Brief: HMI Dashboard QML file */
/* Author: Raul Camacho */
/* Version: 1.0 */
/* Date: 30/Aug/2015 */
/***********************************************************************/
/***********************************************************************/
/* MODULE IMPORT */
/***********************************************************************/
import QtQuick 2.8
import QtGraphicalEffects 1.0
import QtQuick.Controls 1.4
import QtQuick.Controls.Styles 1.4
import QtQuick.Extras 1.4
import "../Gauges"
/***********************************************************************/
/***********************************************************************/
/* DASHBOARD COMPONENTS */
/***********************************************************************/
Rectangle {
    id: root
    width:1024
    height:600
    color:"black"

    property real battery : 0;
    property real shutdown : 0;
    property real env_temp : 0;
    property real speed : 0;
    property real fuel : 0;
    property real efficiency : 0;
    property real odometer : 0;
    property real rpms : 0;
    property real tire_presure_1 : 0;
    property real low_presure_1_warning : 0;
    property real tire_presure_2 : 0;
    property real low_presure_2_warning : 0;
    property real tire_presure_3 : 0;
    property real low_presure_3_warning : 0;
    property real tire_presure_4 : 0;
    property real low_presure_4_warning : 0;
    property real gear : 0;
    property real compass : 0;
    property real high_beam : 0;
    property real low_beam : 0;
    property real optical_horn : 0;
    property real turn_right : 0;
    property real turn_left : 0;
    property real hazard_warning_light : 0;
    property real abs_break : 0;
    property real airbag : 0;
    property real key_status : 0;
    property real low_battery : 0;
    property real low_fuel : 0;
    property real check_engine : 0;
    property real seat_belt : 0;
    property real hand_brake : 0;
    property real sattelital_notification : 0;
    property real oil : 0;
    property real door_warning_light : 0;
    property real motor_temperature_warning : 0;
    Connections{
        target: Dashboard
        onSpeedChanged :speed = Dashboard.speed
//        onRpmChanged: {
//            rpms = Dashboard.rpm;
//        }
//        onWatertempChanged:water_temp.currentValue = water
//        onOiltempChanged:oil_temp.currentValue = oiltemp
//        onBatteryVChanged:fuel_level.currentValue=batteryV

    }



    FontLoader { id: digital_font; source:"./fonts/digital-7-italic.ttf"}
    Image {
        id: dashboard_panel
        width: 1024
        height: 600
        z:6
        source:"images/dashboard_panel.png"
    }
    Image {
        id: speed_needle
        x:304
        y:7
        z:7
        source:"images/speed_needle.png"
        transform: Rotation {
            origin.x:37;
            origin.y:213;
            angle:-142.5+(1.422* speed);
            Behavior on angle {
                NumberAnimation {duration:100}
            }
        }
        smooth: true
    }
    Image {
        id: rpm_needle
        x:745
        y:-14
        z:7
        source:"images/rpm_needle.png"
        transform: Rotation {
            origin.x:37;
            origin.y:213;
            angle:-135.2+(2.445*(rpms/100));
            Behavior on angle {
                NumberAnimation {duration:100}
            }
        }
        smooth: true
    }
    Image {
        id: fuel_needle
        x:106.5
        y:25.5
        z:7
        source:"images/fuel_needle.png"
        transform: Rotation {
            origin.x:28.5;
            origin.y:96.5;
            angle:135-(2.834* fuel);
            Behavior on angle {
                NumberAnimation {duration:100}
            }
        }
        smooth: true
    }
    Image {
        id: battery_needle
        x:1202.5
        y:25.5
        z:7
        source:"images/batery_needle.png"
        transform: Rotation {
            origin.x:28.5;
            origin.y:96.5;
            angle:-135+(11.612* battery);
            Behavior on angle {
                NumberAnimation {duration:100}
            }
        }
        smooth: true
    }
    Rectangle {
        id: compass_panel
        width:89
        height:69
        x:474
        y:15
        z:7
        color:"#093375"
        border.color:"white"
        border.width:4
        radius:15
        Text {
            id: compass_value
            text:if(compass ===0){"N"}else if(compass===1){"NE"}else if(compass ===2){"E"}else if(compass===3){"SE"}else if(compass ===4){"S"}else if(compass===5){"SW"}else if(compass ===6){"W"}else if(compass ===7){"NW"}
            font.pointSize:68
            font.family: digital_font.name
            anchors.centerIn: compass_panel
            color:"white"
        }
    }
    Image {
        id: right_arrow
        x:546
        y:98
        z:9
        scale:1.3
        opacity: turn_right
        source:"images/arrow.png"
        Behavior on opacity {
            NumberAnimation {duration:100}
        }
    }
    Image {
        id: left_arrow
        x:573
        y:125
        z:7
        scale:1.3
        mirror: true
        opacity: turn_left
        source:"images/arrow.png"
        Behavior on opacity {
            NumberAnimation {duration:100}
        }
    }
    Image {
        id: fuel_static_indicator
        x:-643
        y:-599
        width: 1493
        height: 1395
        z:7
        scale:0.125
        opacity:0.75
        source:"images/fuel.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Image {
        id: fuel_warning_signal
        x:-160
        y:-100
        z:7
        scale:0.125
        opacity: low_fuel
        source:"images/fuel_warning.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Image {
        id: battery_static_indicator
        x:1017
        y:-105
        z:7
        scale:0.095
        opacity:0.7
        source:"images/battery.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Image {
        id: battery_warning_signal
        x:1017
        y:-105
        z:7
        scale:0.095
        opacity: low_battery
        source:"images/battery_warning.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Image {
        id: high_beam_signal
        x:660
        y:170
        z:7
        scale:1.05
        opacity: high_beam
        source:"images/high_beam.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Image {
        id: low_beam_signal
        x:646
        y:225
        z:7
        scale:0.8
        opacity: low_beam
        source:"images/low_beam.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Image {
        id: hand_brake_signal
        x:75
        y:250
        z:7
        scale:0.9
        opacity: hand_brake
        source:"images/handbrake.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Image {
        id: check_engine_signal
        x:67
        y:333
        z:7
        scale:0.8
        opacity: check_engine
        source:"images/check_engine.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Image {
        id: abs_break_signal
        x:74
        y:400
        z:7
        scale:0.9
        opacity: abs_break
        source:"images/abs_break.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Image {
        id: airbag_signal
        x:74
        y:464
        z:7
        scale:0.8
        opacity: airbag
        source:"images/airbag.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Image {
        id: key_status_signal
        x:71
        y:543
        z:7
        scale:0.9
        opacity: key_status
        source:"images/key_status.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Image {
        id: oil_signal
        x:1220
        y:260
        z:7
        scale:0.85
        opacity: oil
        source:"images/oil.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Image {
        id: motor_temperature_signal
        x:1225
        y:308
        z:7
        scale:0.75
        opacity: motor_temperature_warning
        source:"images/motor_temperature.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Image {
        id: seatbelt_signal
        x:1228
        y:375
        z:7
        scale:0.75
        opacity: seat_belt
        source:"images/seatbelt.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Image {
        id: door_warning_light_signal
        x:1186
        y:403
        z:7
        scale:0.57
        opacity: door_warning_light
        source:"images/door_warning_light.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Image {
        id: sattelital_notification_signal
        x:1228
        y:520
        z:7
        scale:0.85
        opacity: sattelital_notification
        source:"images/sattelital_notification.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Image {
        id: hazard_warning_light_signal
        x:651
        y:465
        z:7
        scale:1.2
        opacity: hazard_warning_light
        source:"images/hazard_warning_light.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Rectangle {
        id: clock_panel
        width:135
        height:34
        x:646
        y:15
        z:7
        color:"#093375"
        border.color:"white"
        border.width:2
        radius:1
        Text {
            id: clock_value
            text: Qt.formatDateTime(new Date(),"hh:mm:ss AP")
            font.pointSize:20
            font.family: digital_font.name
            anchors.centerIn: clock_panel
            color:"white"
        }
        Timer {
            id: clock_timer
            interval:1000
            repeat: true
            running: true
            onTriggered:
            {
                clock_value.text = Qt.formatTime(new Date(),"hh:mm:ss
AP")
            }
        }
    }
    Rectangle {
        id: env_temp_panel
        width:113
        height:34
        x:261
        y:15
        z:7
        color:"#093375"
        border.color:"white"
        border.width:2
        radius:8
        Text {
            id: env_temp_value
            text: env_temp +" C"
            font.pointSize:20
            font.family: digital_font.name
            anchors.centerIn: env_temp_panel
            color:"white"
        }
    }
    Image {
        id: tire_pressure_front_panel
        x:172
        y:546
        z:7
        scale:0.9
        opacity:1
        source:"images/tire_pressure.png"
    }
    Rectangle {
        id: tire_pressure_front_left
        width:90
        height:33
        x:116
        y:505
        z:7
        color:"#093375"
        border.color:"white"
        border.width:2
        radius:2
        Text {
            id: tire_pressure_front_left_value
            text: tire_presure_1 +" PSI "
            font.pointSize:18
            font.family: digital_font.name
            anchors.right: tire_pressure_front_left.right
            anchors.verticalCenter: parent.verticalCenter
            color:"white"
        }
    }
    Rectangle {
        id: tire_pressure_front_left_indicator
        width:10
        height:10
        x:119
        y:508
        z:8
        color:"white"
        border.color:"white"
        border.width:1
        radius:5
    }
    Image {
        id: tire_pressure_front_left_warning
        x:152
        y:630
        z:8
        scale:0.60
        opacity: low_presure_1_warning
        source:"images/tire_pressure_warning.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Rectangle {
        id: tire_pressure_front_right
        width:90
        height:33
        x:267
        y:505
        z:7
        color:"#093375"
        border.color:"white"
        border.width:2
        radius:2
        Text {
            id: tire_pressure_front_right_value
            text:" "+ tire_presure_2 +" PSI "
            font.pointSize:18
            font.family: digital_font.name
            anchors.left: tire_pressure_front_right.left
            anchors.verticalCenter: parent.verticalCenter
            color:"white"
        }
    }
    Rectangle {
        id: tire_pressure_front_right_indicator
        width:10
        height:10
        x:344
        y:508
        z:8
        color:"white"
        border.color:"white"
        border.width:1
        radius:5
    }
    Image {
        id: tire_pressure_front_right_warning
        x:407
        y:630
        z:8
        scale:0.60
        opacity: low_presure_2_warning
        source:"images/tire_pressure_warning.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Image {
        id: tire_pressure_back_panel
        x:743
        y:546
        z:7
        scale:0.9
        opacity:1
        source:"images/tire_pressure.png"
    }
    Rectangle {
        id: tire_pressure_back_left
        width:90
        height:33
        x:678
        y:505
        z:7
        color:"#093375"
        border.color:"white"
        border.width:2
        radius:2
        Text {
            id: tire_pressure_back_left_value
            text: tire_presure_3 +" PSI "
            font.pointSize:18
            font.family: digital_font.name
            anchors.right: tire_pressure_back_left.right
            anchors.verticalCenter: parent.verticalCenter
            color:"white"
        }
    }
    Rectangle {
        id: tire_pressure_back_left_indicator
        width:10
        height:10
        x:682
        y:524
        z:8
        color:"white"
        border.color:"white"
        border.width:1
        radius:5
    }
    Image {
        id: tire_pressure_back_left_warning
        x:904
        y:630
        z:8
        scale:0.60
        opacity: low_presure_3_warning
        source:"images/tire_pressure_warning.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Rectangle {
        id: tire_pressure_back_right
        width:90
        height:33
        x:834
        y:505
        z:7
        color:"#093375"
        border.color:"white"
        border.width:2
        radius:2
        Text {
            id: tire_pressure_back_right_value
            text:" "+ tire_presure_4 +" PSI "
            font.pointSize:18
            font.family: digital_font.name
            anchors.left: tire_pressure_back_right.left
            anchors.verticalCenter: parent.verticalCenter
            color:"white"
        }
    }
    Rectangle {
        id: tire_pressure_back_right_indicator
        width:10
        height:10
        x:909
        y:524
        z:8
        color:"white"
        border.color:"white"
        border.width:1
        radius:5
    }
    Image {
        id: tire_pressure_back_right_warning
        x:1161
        y:630
        z:8
        scale:0.60
        opacity: low_presure_4_warning
        source:"images/tire_pressure_warning.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Image {
        id: optical_horn_signal
        x:660
        y:170
        z:8
        scale:1.05
        opacity: optical_horn
        source:"images/high_beam.png"
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
    Rectangle {
        id: efficiency_panel
        width:93
        height:32
        x:466
        y:425
        z:7
        color:"black"
        border.color:"white"
        border.width:2
        radius:2
        Text {
            id: efficiency_value
            text: efficiency +" KM/L"
            font.pointSize:20
            font.family: digital_font.name
            anchors.centerIn: efficiency_panel
            color:"white"
        }
    }
    Rectangle {
        id: odometer_panel
        width:120
        height:31
        x:452
        y:452
        z:7
        color:"black"
        border.color:"white"
        border.width:2
        radius:8
        Text {
            id: odometer_value
            text: odometer +" KM"
            font.pointSize:20
            font.family: digital_font.name
            anchors.centerIn: odometer_panel
            color:"white"
        }
    }
    Rectangle {
        id: black_panel
        width:1024
        height:600
        color:"black"
        z:8
        opacity: shutdown
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }

    Rectangle {
        id: scalerect
        x: 2
        y: 7
        width: 1024
        height: 600
        color: "#00000000"
        z: 11
        Rectangle {
            id: odotrip
            width: scalerect.width /2.33
            height: scalerect.height /15
            color: "#00000000"
            z: 1
            Text {
                id: tripname
                color: "#808080"
                text: "Trip "
                z: 1
                anchors.right: trip.left
                font.family: "Eurostile"
                font.pixelSize: scalerect.width / 50
                anchors.bottom: odotrip.bottom
            }

            Text {
                id: trip
                color: "#808080"
                text: (Dashboard.Trip).toFixed(1)
                z: 1
                font.bold: true
                anchors.right: tripunits.left
                font.family: "Eurostile"
                font.pixelSize: scalerect.width / 45
                anchors.bottom: odotrip.bottom
            }

            Text {
                id: tripunits
                color: "#808080"
                text: " km"
                z: 1
                anchors.right: parent.right
                font.family: "Eurostile"
                font.pixelSize: scalerect.width / 50
                anchors.bottom: odotrip.bottom
            }

            Text {
                id: odoname
                color: "#808080"
                text: "Total "
                z: 1
                font.family: "Eurostile"
                font.pixelSize: scalerect.width / 50
                anchors.left: parent.left
                anchors.bottom: odotrip.bottom
            }

            Text {
                id: odo
                color: "#808080"
                text: (Dashboard.Odo).toFixed(0)
                z: 2
                font.bold: true
                font.family: "Eurostile"
                font.pixelSize: scalerect.width / 45
                anchors.left: odoname.right
                anchors.bottom: odotrip.bottom
            }

            Text {
                id: odounit
                color: "#808080"
                text: " km"
                z: 3
                font.family: "Eurostile"
                font.pixelSize: scalerect.width / 60
                anchors.left: odo.right
                anchors.bottom: odotrip.bottom
            }
            anchors.leftMargin: scalerect.width / 3.5
            anchors.left: scalerect.left
            anchors.bottom: scalerect.bottom
            anchors.bottomMargin: scalerect.height / 4
        }

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
                z: 1
                anchors.fill: parent
                style: DashboardGaugeStyle {
                    labelStepSize: 20
                    needleTipWidth: 0
                    needleLength: 0
                    needleBaseWidth: 0
                    tickmarkLabel: Text {
                        color: styleData.value >= speedometer.value+10 || styleData.value <= speedometer.value-10  ? "grey" : "white"
                        text: styleData.value
//                        font.bold: styleData.value >= speedometer.value+10 || styleData.value <= speedometer.value-10  ? false : true
                        antialiasing: true
//                        font.pixelSize: styleData.value >= speedometer.value+15 || styleData.value <= speedometer.value-15  ? speedo.height /22 : (speedometer.value-styleData.value)+speedo.height /11
                        font.pixelSize: speedo.height /22
                    }
                }
                maximumValue: 320
            }

            GaugeNeedle_minus180to90 {
                id: speedoNeedlekph
                z: 7
                anchors.verticalCenterOffset: 0
                value: Dashboard.speed / 4.155844155844156

            }

            GaugeNeedle_minus180to90 {
                id: speedoNeedlemph
                z: 6
                anchors.verticalCenterOffset: 0
                value: Dashboard.speed / 2.597402597402597

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
                stepSize: 1
                z: 5
                anchors.fill: parent
                style: TachometerStyle {
                    needleTipWidth: 0
                    needleLength: 0
                    needleBaseWidth: 0
                    maximumValueAngle: 180
                    tickmarkLabel: Text {
                        color: styleData.value <= Dashboard.rpm/1000 ? "white" : "grey"
                        text: styleData.value
//                        font.bold: styleData.value >= Dashboard.rpm/1000+0.5 || styleData.value <= Dashboard.rpm/1000-0.5  ? false : true
                        antialiasing: true
                        font.pixelSize: revcounterticks.height /22
//                        font.pixelSize: styleData.value >= Dashboard.rpm/1000+0.5 || styleData.value <= Dashboard.rpm/1000-0.5  ? revcounterticks.height /22 : (revcounterticks.value-Dashboard.rpm/1000)+speedo.height /11
                    }
                    minimumValueAngle: -90
                }
                maximumValue: 10
            }

            GaugeNeedle_minus90to180 {
                id: revneedele
                z: 8
                anchors.verticalCenterOffset: 0
                value: Dashboard.rpm *0.0077

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
        OpacityAnimator {
            target: speedometer;
            from: 0;
            to: 1;
            duration: 2000
            running: true
        }
        OpacityAnimator {
            target: revcounterticks;
            from: 0;
            to: 1;
            duration: 2000
            running: true
        }

        OpacityAnimator {
            id: speedoopacity
            target: speedoNeedlekph;
            from: 0;
            to: 1;
            duration: 2000
            running: true
        }


    }
}
/***********************************************************************/
