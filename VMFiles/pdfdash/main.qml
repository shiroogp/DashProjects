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
import QtQuick 2.1
/***********************************************************************/
/***********************************************************************/
/* DASHBOARD COMPONENTS */
/***********************************************************************/
Rectangle {
    id: root
    width:1366
    height:768
    color:"black"
    FontLoader { id: digital_font; source:"./fonts/digital-7-italic.ttf"}
    Image {
        id: dashboard_panel
        z:6
        source:"images/dashboard_panel.png"
    }
    Image {
        id: speed_needle
        x:377
        y:171
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
        x:917
        y:171
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
        width:115
        height:85
        x:633
        y:25
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
        x:759
        y:125
        z:7
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
        x:-160
        y:-100
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
        width:150
        height:38
        x:865
        y:25
        z:7
        color:"#093375"
        border.color:"white"
        border.width:2
        radius:8
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
        width:150
        height:38
        x:350
        y:25
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
    Rectangle {
        id: gear_panel
        width:45
        height:45
        x:if(gear ===0){518}else if(gear ===1){582}else if(gear
                                                           ===2){646}else if(gear ===3){710}else if(gear ===4){767}else if(gear
                                                                                                                           ===5){821}
        y:621
        z:7
        color:"#288de9"
        border.color:"green"
        border.width:1.5
        radius:10
        opacity:.75
        Behavior on x {
            NumberAnimation { duration:300}
        }
    }
    Image {
        id: tire_pressure_front_panel
        x:280
        y:630
        z:7
        scale:0.9
        opacity:1
        source:"images/tire_pressure.png"
    }
    Rectangle {
        id: tire_pressure_front_left
        width:120
        height:40
        x:155
        y:645
        z:7
        color:"#093375"
        border.color:"white"
        border.width:2
        radius:8
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
        x:160
        y:650
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
        width:120
        height:40
        x:357
        y:645
        z:7
        color:"#093375"
        border.color:"white"
        border.width:2
        radius:8
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
        x:462
        y:650
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
        x:1030
        y:630
        z:7
        scale:0.9
        opacity:1
        source:"images/tire_pressure.png"
    }
    Rectangle {
        id: tire_pressure_back_left
        width:120
        height:40
        x:905
        y:645
        z:7
        color:"#093375"
        border.color:"white"
        border.width:2
        radius:8
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
        x:910
        y:670
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
        width:120
        height:40
        x:1111
        y:645
        z:7
        color:"#093375"
        border.color:"white"
        border.width:2
        radius:8
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
        x:1216
        y:670
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
        width:125
        height:38
        x:621
        y:545
        z:7
        color:"black"
        border.color:"white"
        border.width:2
        radius:8
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
        width:160
        height:38
        x:604
        y:580
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
        width:1366
        height:768
        color:"black"
        z:8
        opacity: shutdown
        Behavior on opacity {
            NumberAnimation { duration:100}
        }
    }
}
/***********************************************************************/
