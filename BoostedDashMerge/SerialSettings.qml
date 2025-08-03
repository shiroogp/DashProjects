import QtQuick 2.8
import QtQuick.Controls 1.4 as Quick1
import QtQuick.Controls 2.1
import Qt.labs.settings 1.0
import QtQuick.VirtualKeyboard 2.1
import QtSensors 5.0
import QtQuick.Controls.Styles 1.4
import QtMultimedia 5.8
import QtQuick.Dialogs 1.0
import "qrc:/Gauges/"

Quick1.TabView {
    id: tabView
    anchors.fill: parent
    property bool loadScreens: false
    property string fileSource1
    property string fileSource

    Rectangle{
        id: keyboardcontainer
        color: "darkgrey"
        visible: false
        width :500
        height:180
        z:220
        MouseArea {
            id: touchAkeyboardcontainer
            anchors.fill:parent
            drag.target: keyboardcontainer
        }
        InputPanel {
            id: keyboard
            anchors.fill: parent
            visible: false
            states: State {
                name: "visible";
                when: keyboard.active;
                PropertyChanges {
                    target: keyboard;
                    visible: true
                }
                PropertyChanges {
                    target: keyboardcontainer;
                    visible: true;
                    x:300
                    y:200
                }
            }
        }
    }

    style: TabViewStyle {
        frameOverlap: 1
        tab: Rectangle {
            id:tabrect
            color: styleData.selected ? "grey" :"lightgrey"
            border.color:  "steelblue"
            implicitWidth: Math.max(text.width + 4, 80)
            implicitHeight: 50
            radius: 2
            Text {
                id: text
                anchors.centerIn: parent
                font.pixelSize: tabView.width / 55
                text: styleData.title
                color: styleData.selected ? "white" : "black"
            }
        }
        frame: Rectangle { color: "steelblue" }
    }
    Quick1.Tab {
        title: "         "
        anchors.fill: parent
        Rectangle {
            id: blankbackround
            anchors.fill: parent
            //            color: "grey"
            Component.onCompleted: tabView.currentIndex = 1;
        }
    }
    Quick1.Tab {
        title: "Main"
        anchors.fill: parent
        Rectangle {
            id: windowbackround
            anchors.fill: parent
            //            color: "grey"
            property  int test1: 0
            property  int connected: 0
            property  var gpscom

            Item {
                id: boostedSettings
                Settings {
                    property alias brightnessselect: brightness.value
                    property alias connectAtStartUp: connectAtStart.checked
                    //                    property alias gpsswitch: gpsswitch.checked
                    property alias remotedashswitch: remotedashswitch.checked
                    property alias serialPortName: serialName.currentText
                    //                    property alias gpsPortName: serialNameGPS.currentText
                    //                    property alias gpsPortNameindex: serialNameGPS.currentIndex
                    //property alias gpsBaud: serialGPSBaud.currentText
                    //property alias gpsBaudindex: serialGPSBaud.currentIndex
                    property alias ecuType: ecuSelect.currentText
                    //                    property alias auxunit1: unitaux1.text
                    //                    property alias aux1: an1V0.text
                    //                    property alias aux2: an2V5.text
                    //                    property alias auxunit2: unitaux2.text
                    //                    property alias aux3: an3V0.text
                    //                    property alias aux4: an4V5.text
                    //                    property alias goProVariant: goProSelect.currentIndex
                    //                    property alias password: goPropass.text
                    property alias vehicleweight: weight.text
                    property alias unitSelector1: unitSelect1.currentIndex
                    property alias unitSelector: unitSelect.currentIndex
                    property alias unitSelector2: unitSelect2.currentIndex
                    property alias odometervalue: odometer.text
                    property alias tripmetervalue: tripmeter.text
                    property alias remoteurl: remoteDashIP.text
                    property alias remoteip: remoteDashPort.text
                    //property alias protocol : protocol.currentIndex
                    property alias smoothingrpm : smoothrpm.currentIndex
                    property alias smoothingspeed : smoothspeed.currentIndex


                }
                //                SoundEffect {
                //                    id: warnsound
                //                    source: "qrc:/Sounds/alarm.wav"
                //                }

                Connections{
                    target: Dashboard
                    onOdoChanged:{odometer.text = (Dashboard.Odo).toFixed(0) }
                    onTripChanged:{tripmeter.text = (Dashboard.Trip).toFixed(1) }
                    onDone:{console.log("Done"),Connect.readavailabledashfiles()}
                    onErrorOcurred:{console.log("Error Occurrred: "+ errStr);}
                    onProgressChanged:{console.log("ProgressChanged: "+ progress);}
                    onFileOpened:{console.log("File Opened");}
                    //                    onWatertempChanged: { if (Dashboard.Watertemp > Dashboard.waterwarn) {playwarning.start()};}
                    //                    onRpmChanged: { if (Dashboard.rpm > Dashboard.rpmwarn) {playwarning.start()};}
                    //                    onKnockChanged: { if (Dashboard.Knock > Dashboard.knockwarn) {playwarning.start()};}
                    //                    onBoostPresChanged: { if (Dashboard.BoostPres > Dashboard.boostwarn) {playwarning.start()};}

                }
                Connections{
                    target: TransferInfo
                    onProgressChanged:{
                        console.log("ProgressChanged: "+ progress);
                    }
                    onStateChanged:{
                        console.log("StateChanged: "+ state);
                    }
                    onDone:{console.log("Done"),readavailabledashfiles()}
                    onErrorOcurred:{console.log("Error Occurrred: "+ errStr);}
//                    onProgressChanged:{console.log("ProgressChanged: "+ progress);}
                    onFileOpened:{console.log("File Opened");}
                }
                Connections{
                    target: SenderModel
                    onDataChanged:{
                        console.log("Sender DataChanged: ");
                    }
                }
                Connections{
                    target: ReceiverModel
                    onDataChanged:{
                        console.log("Receiver DataChanged: ");
                    }
                }
                Connections{
                    target: TransferServer
                    onNewReceiverAdded:{
                        console.log("onNewReceiverAdded: ");
                    }
                }
                Connections{
                    target: Sender

                }
                Connections{
                    target: Receiver
                    onDone:{console.log("Done"),readavailabledashfiles()}
                    onErrorOcurred:{console.log("Error Occurrred: "+ errStr);}
                    onProgressChanged:{console.log("ProgressChanged: "+ progress);}
                    onFileOpened:{console.log("File Opened");}
                }

                Row {
                    x: windowbackround.width /150
                    y: windowbackround.width /150
                    spacing: windowbackround.width /150
                    Grid {
                        anchors.top :parent.top
                        anchors.topMargin: parent.height / 20
                        rows: 13
                        columns: 2
                        spacing: windowbackround.width /150
                        // [0]
                        Text {
                            text: "ECU Serial Port: "
                            font.pixelSize: windowbackround.width / 55
                            ////color: "white"
                            visible: false//{ (ecuSelect.currentIndex >= "5") ? false: true; }
                        }
                        ComboBox {
                            id: serialName
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            model: Connect.portsNames
                            visible: false//{ (ecuSelect.currentIndex >= "5") ? false: true; }
                            property bool initialized: false
                            onCurrentIndexChanged: if (initialized) AppSettings.setBaudRate( currentIndex )
                            Component.onCompleted: { currentIndex = AppSettings.getBaudRate(); initialized = true; autoconnect.auto(); }
                            delegate: ItemDelegate {
                                width: serialName.width
                                text: serialName.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                font.weight: serialName.currentIndex === index ? Font.DemiBold : Font.Normal
                                font.family: serialName.font.family
                                font.pixelSize: serialName.font.pixelSize
                                highlighted: serialName.highlightedIndex === index
                                hoverEnabled: serialName.hoverEnabled
                            }
                        }
                        /* picking up from pmods
                        Text {
                            text: "GPS Port: "
                            font.pixelSize: windowbackround.width / 55
                            ////color: "white"
                            //visible: { (gpsswitch.checked == true ) ? true:false; }
                        }
                        ComboBox {
                            id: serialNameGPS
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            model: Connect.portsNames
                            // visible: { (gpsswitch.checked == true ) ? true:false; }
                            delegate: ItemDelegate {
                                width: serialNameGPS.width
                                text: serialNameGPS.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                font.weight: serialNameGPS.currentIndex === index ? Font.DemiBold : Font.Normal
                                font.family: serialNameGPS.font.family
                                font.pixelSize: serialNameGPS.font.pixelSize
                                highlighted: serialNameGPS.highlightedIndex === index
                                hoverEnabled: serialNameGPS.hoverEnabled
                            }

                        }
                        */
                        /*
                        Text {
                            text: "GPS Baud: "
                            font.pixelSize: windowbackround.width / 55
                            //color: "white"

                            //visible: { (gpsswitch.checked == true ) ? true:false; }
                        }
                        ComboBox {
                            id: serialGPSBaud
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            model: [ "2400", "4800", "9600", "14400", "19200", "38400", "57600", "115200"]
                            //visible: { (gpsswitch.checked == true ) ? true:false; }
                            Component.onCompleted: {autoconnectGPS.auto()}
                            delegate: ItemDelegate {
                                width: serialGPSBaud.width
                                text: serialGPSBaud.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                font.weight: serialGPSBaud.currentIndex === index ? Font.DemiBold : Font.Normal
                                font.family: serialGPSBaud.font.family
                                font.pixelSize: serialGPSBaud.font.pixelSize
                                highlighted: serialGPSBaud.highlightedIndex === index
                                hoverEnabled: serialGPSBaud.hoverEnabled
                            }
                        }*/
                        Text {
                            text: "Speed units:"
                            font.pixelSize: windowbackround.width / 55
                            //color: "white"
                        }
                        ComboBox {
                            id: unitSelect1
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            model: [ "Metric","Imperial"]
                            property bool initialized: false
                            Component.onCompleted: { Connect.setSpeedUnits(currentIndex);changeweighttext.changetext()}
                            onCurrentIndexChanged: { Connect.setSpeedUnits(currentIndex);changeweighttext.changetext()}
                            delegate: ItemDelegate {
                                width: unitSelect1.width
                                text: unitSelect1.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                font.weight: unitSelect1.currentIndex === index ? Font.DemiBold : Font.Normal
                                font.family: unitSelect1.font.family
                                font.pixelSize: unitSelect1.font.pixelSize
                                highlighted: unitSelect1.highlightedIndex === index
                                hoverEnabled: unitSelect1.hoverEnabled
                            }

                        }
                        Text {
                            text: "Temp units:"
                            font.pixelSize: windowbackround.width / 55
                            //color: "white"
                        }
                        ComboBox {
                            id: unitSelect
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            model: [ "Metric","Imperial"]
                            property bool initialized: false
                            Component.onCompleted: { Connect.setUnits(currentIndex);changeweighttext.changetext()}
                            onCurrentIndexChanged: { Connect.setUnits(currentIndex);changeweighttext.changetext()}
                            delegate: ItemDelegate {
                                width: unitSelect.width
                                text: unitSelect.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                font.weight: unitSelect.currentIndex === index ? Font.DemiBold : Font.Normal
                                font.family: unitSelect.font.family
                                font.pixelSize: unitSelect.font.pixelSize
                                highlighted: unitSelect.highlightedIndex === index
                                hoverEnabled: unitSelect.hoverEnabled
                            }

                        }
                        Text {
                            text: "Pressure units:"
                            font.pixelSize: windowbackround.width / 55
                            //color: "white"
                        }
                        ComboBox {
                            id: unitSelect2
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            model: [ "kPa","PSI"]
                            property bool initialized: false
                            Component.onCompleted: { Connect.setPressUnits(currentIndex);}
                            onCurrentIndexChanged: { Connect.setPressUnits(currentIndex);}
                            delegate: ItemDelegate {
                                width: unitSelect.width
                                text: unitSelect.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                font.weight: unitSelect.currentIndex === index ? Font.DemiBold : Font.Normal
                                font.family: unitSelect.font.family
                                font.pixelSize: unitSelect.font.pixelSize
                                highlighted: unitSelect.highlightedIndex === index
                                hoverEnabled: unitSelect.hoverEnabled
                            }

                        }
                        Text {
                            text: "ECU Selection:"
                            font.pixelSize: windowbackround.width / 55
                            //color: "white"
                        }
                        ComboBox {
                            id: ecuSelect
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            //                            model: [ "PowerFC","UDP","Adaptronic Select Modbus","CAN Adaptronic Modular","Consult","HaltechV1","HaltechV2","OBD2"]
                            model: [ "UDP"]
                            enabled: true
                            property bool initialized: false
                            onCurrentIndexChanged: {if (initialized) AppSettings.setECU( currentIndex ),Dashboard.setecu(ecuSelect.currentIndex);}
                            Component.onCompleted: { currentIndex = AppSettings.getECU(),Dashboard.setecu(ecuSelect.currentIndex),initialized = true; }
                            delegate: ItemDelegate {
                                width: ecuSelect.width
                                text: ecuSelect.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                font.weight: ecuSelect.currentIndex === index ? Font.DemiBold : Font.Normal
                                font.family: ecuSelect.font.family
                                font.pixelSize: ecuSelect.font.pixelSize
                                highlighted: ecuSelect.highlightedIndex === index
                                hoverEnabled: ecuSelect.hoverEnabled
                            }
                        }
                        /*
                        Text {
                            text: "Protocol Type:"
                            font.pixelSize: windowbackround.width / 55
                            //color: "white"
                            visible: { (ecuSelect.currentIndex >= "1") ? false: true; }
                        }
                        ComboBox {
                            id: protocol
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            model: [ "New", "Old"]
                            visible: { (ecuSelect.currentIndex >= "1") ? false: true; }

                            property bool initialized: false
                            onCurrentIndexChanged: {Apexi.SetProtocol(currentIndex)}
                            Component.onCompleted: {Apexi.SetProtocol(currentIndex)}
                            delegate: ItemDelegate {
                                width: protocol.width
                                text: protocol.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                font.weight: protocol.currentIndex === index ? Font.DemiBold : Font.Normal
                                font.family: protocol.font.family
                                font.pixelSize: protocol.font.pixelSize
                                highlighted: protocol.highlightedIndex === index
                                hoverEnabled: protocol.hoverEnabled
                            }
                        }*/
                        /*
                Text {
                    id: textloggingSelect
                    visible: { (ecuSelect.currentIndex >= "1") ? false: true; }
                    text: "Log Raw Messages:"

                }
                ComboBox {
                    id: loggerSelect
                    visible: { (ecuSelect.currentIndex >= "1") ? false: true; }
                    width: windowbackround.width / 5
                    height: windowbackround.height /15
                    font.pixelSize: windowbackround.width / 55
                    model: [ "OFF", "ON"]
                    property bool initialized: false
                    onCurrentIndexChanged: if (initialized) AppSettings.setLogging( currentIndex )
                    Component.onCompleted: { currentIndex = AppSettings.getLogging(); initialized = true }
                }
*/
                        /* Not needed for now
                        Text {
                            text: "GoPro Variant :"
                            font.pixelSize: windowbackround.width / 55
                            //color: "white"
                        }
                        ComboBox {
                            id: goProSelect
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            model: [ "Hero", "Hero2","Hero3"]
                            delegate: ItemDelegate {
                                width: goProSelect.width
                                text: goProSelect.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                font.weight: goProSelect.currentIndex === index ? Font.DemiBold : Font.Normal
                                font.family: goProSelect.font.family
                                font.pixelSize: goProSelect.font.pixelSize
                                highlighted: goProSelect.highlightedIndex === index
                                hoverEnabled: goProSelect.hoverEnabled
                            }

                        }
                        Text {
                            text: "GoPro Password :"
                            font.pixelSize: windowbackround.width / 55
                            //color: "white"
                        }
                        TextField {
                            id: goPropass
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            placeholderText: qsTr("GoPro Password")
                            inputMethodHints: Qt.ImhNoAutoUppercase | Qt.ImhPreferLowercase | Qt.ImhSensitiveData | Qt.ImhNoPredictiveText
                            Component.onCompleted: {transferSettings.sendSettings() }
                        }
                        */
                        Text
                        {
                            text: "Logfile name:"
                            font.pixelSize: windowbackround.width / 55
                            //color: "white"
                        }
                        TextField {
                            id: logfilenameSelect
                            text: qsTr("DataLog")
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            inputMethodHints: Qt.ImhNoAutoUppercase | Qt.ImhPreferLowercase | Qt.ImhSensitiveData | Qt.ImhNoPredictiveText
                            //enterKeyAction: EnterKeyAction.Next
                        }
                        Text
                        {
                            text: "Odo:"
                            font.pixelSize: windowbackround.width / 55
                            //color: "white"
                        }
                        TextField {
                            id: odometer
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            text: qsTr("0")
                            inputMethodHints: Qt.ImhDigitsOnly
                            //enterKeyAction: EnterKeyAction.Next
                        }
                        Text
                        {
                            text: "Trip:"
                            font.pixelSize: windowbackround.width / 55
                            //color: "white"

                        }
                        TextField{
                            id: tripmeter
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            readOnly: true
                            text: "0"
                            Component.onCompleted: Dashboard.setTrip(tripmeter.text)
                        }

                        Text
                        {
                            id: weighttext
                            font.pixelSize: windowbackround.width / 55
                            //color: "white"
                            text: "Weight:"
                        }
                        TextField {
                            id: weight
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            inputMethodHints: Qt.ImhDigitsOnly

                        }
                        Text
                        {
                            text: "Serial Status:"
                            font.pixelSize: windowbackround.width / 55
                            //color: "white"
                        }
                        TextField {
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            text: qsTr(Dashboard.SerialStat)


                        }
                        Text
                        {
                            text: "RemoteDash IP:"
                            font.pixelSize: windowbackround.width / 55
                            //color: "white"
                        }
                        TextField {
                            id: remoteDashIP
                            text: qsTr("")
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            inputMethodHints: Qt.ImhNoAutoUppercase | Qt.ImhPreferLowercase | Qt.ImhSensitiveData | Qt.ImhNoPredictiveText
                            //enterKeyAction: EnterKeyAction.Next
                        }
                        Text
                        {
                            text: "RemoteDash Port:"
                            font.pixelSize: windowbackround.width / 55
                            //color: "white"
                        }
                        TextField {
                            id: remoteDashPort
                            text: qsTr("")
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            inputMethodHints: Qt.ImhNoAutoUppercase | Qt.ImhPreferLowercase | Qt.ImhSensitiveData | Qt.ImhNoPredictiveText
                            //enterKeyAction: EnterKeyAction.Next
                        }

                    }

                    Grid {
                        rows: 13
                        columns: 2
                        spacing: windowbackround.width / 150
                        anchors.top :parent.top
                        anchors.topMargin: parent.height / 20
                        Button {
                            id: connectButton
                            text: "Connect ECU"
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            onClicked: {
                                functconnect.connectfunc();
                                connectButton.enabled =false;
                                ecuSelect.enabled = false;
                                disconnectButton.enabled = true;
                                //consultset.enabled = false;
                            }
                        }
                        Button {
                            id: disconnectButton
                            text: "Disconnect ECU"
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            enabled: false
                            onClicked: {
                                connectButton.enabled = true;
                                disconnectButton.enabled = false;
                                ecuSelect.enabled = true;
                                // consultset.enabled = true;
                                functdisconnect.disconnectfunc();
                            }
                        }
                        /* not needed right now
                        Button {
                            id: connectButtonGPS
                            text: "GPS Connect"
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            onClicked: {
                                GPS.openConnection(serialNameGPS.currentText,"38400")
                                connectButtonGPS.enabled=false
                                disconnectButtonGPS.enabled=true
                            }
                        }
                        Button {
                            id: disconnectButtonGPS
                            text: "GPS Disconnect"
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            enabled: false
                            onClicked: {
                                GPS.closeConnection()
                                connectButtonGPS.enabled = true;
                                disconnectButtonGPS.enabled = false;
                            }
                        }
                        */

                        Button {
                            id: resettrip
                            text: "Trip Reset"
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            onClicked: {Calculations.resettrip()}
                        }


                        //for official raspberry Pi image only !!!!
                        /*
                Button {
                    id: updateButton
                    text: "Pi Update "
                    onClicked: { updateButton.enabled =false,Connect.update();
                    }
                }
*/
                        Button {
                            text: "Quit"
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            onClicked: { Qt.quit()}
                        }
                        Button {
                            text: "Shutdown"
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            onClicked: {Connect.shutdown()}
                        }
                        Button {
                            text: "Reboot"
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            onClicked: {Connect.reboot()}
                        }


                        Text  { text: "RPM Smoothing :";font.pixelSize: windowbackround.width / 55}
                        ComboBox {
                            id: smoothrpm
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            model: ["OFF","2","3","4","5","6","7","8","9","10"]
                            //property bool initialized: true
                            onCurrentIndexChanged:{Dashboard.setsmoothrpm(smoothrpm.currentIndex);}
                            Component.onCompleted: {Dashboard.setsmoothrpm(smoothrpm.currentIndex);}
                            delegate: ItemDelegate {
                                width: smoothrpm.width
                                text: smoothrpm.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                font.weight: smoothrpm.currentIndex === index ? Font.DemiBold : Font.Normal
                                font.family: smoothrpm.font.family
                                font.pixelSize: smoothrpm.font.pixelSize
                                highlighted: smoothrpm.highlightedIndex === index
                                hoverEnabled: smoothrpm.hoverEnabled
                            }
                        }

                        Text  { text: "Speed Smoothing :";font.pixelSize: windowbackround.width / 55}
                        ComboBox {
                            id: smoothspeed
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            model: ["OFF","2","3","4","5","6","7","8","9","10"]
                            property bool initialized: true
                            onCurrentIndexChanged:{Dashboard.setsmoothspeed(smoothspeed.currentIndex)}
                            Component.onCompleted: {Dashboard.setsmoothspeed(smoothspeed.currentIndex)}
                            delegate: ItemDelegate {
                                width: smoothspeed.width
                                text: smoothspeed.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                font.weight: smoothspeed.currentIndex === index ? Font.DemiBold : Font.Normal
                                font.family: smoothspeed.font.family
                                font.pixelSize: smoothspeed.font.pixelSize
                                highlighted: smoothspeed.highlightedIndex === index
                                hoverEnabled: smoothspeed.hoverEnabled
                            }
                        }

                        Switch {
                            id: connectAtStart
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            text: qsTr("Autoconnect")
                        }
                        Switch {
                            id: loggerswitch
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            text: qsTr("Data Logger")
                            Component.onCompleted: {logger.datalogger()}
                            onCheckedChanged: logger.datalogger()
                        }
                        /* not needed right now
                        Switch {
                            id: record
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            text: qsTr("GoPro rec")
                            onCheckedChanged: {transferSettings.sendSettings(),goproRec.rec()}
                        }
                        Switch {
                            id: gpsswitch
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            text: qsTr("Autoconnect GPS")
                            Component.onCompleted: {autoconnectGPS.auto()}
                            //onCheckedChanged: {autoconnectGPS.auto()}
                        }
                        */
                        Switch {
                            id: remotedashswitch
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            font.pixelSize: windowbackround.width / 55
                            text: qsTr("Remote Dash")
                            Component.onCompleted: {remoteDash.write()}
                            onCheckedChanged: {remoteDash.write()}
                        }

                        Text  { text: "V 1.0 ";font.pixelSize: windowbackround.width / 55} //spacer

                        Slider {
                            id:brightness
                            width: windowbackround.width / 5
                            height: windowbackround.height /15
                            stepSize: 5
                            from: 20
                            to: 255
                            //value: brightnessselect
                            visible: Dashboard.screen
                            Component.onCompleted: Connect.setSreenbrightness(brightness.value),tabView.currentIndex = 2; // opens the 2nd tab
                            //                            onPositionChanged: Connect.setSreenbrightness(brightness.value);
                        }

                            //                            Grid {
                            //                                visible: { (ecuSelect.currentIndex >= "1") ? false: true; }
                            //                                rows: 10
                            //                                columns: 4
                            //                                spacing: windowbackround.width / 150
                            //                                //Just a spacer for now still need to do it properly
                            //                                Text  { text: "";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "";font.pixelSize: windowbackround.width / 55}
                            //                                //Spacer end


                            //                                Text  { text: "";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "0V";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "5V";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "Name";font.pixelSize: windowbackround.width / 55}
                            //                                Text  { text: "    ";font.pixelSize: windowbackround.width / 55}
                            //                                TextField {
                            //                                    id: an1V0
                            //                                    width: windowbackround.width / 10
                            //                                    height: windowbackround.height /15
                            //                                    font.pixelSize: windowbackround.width / 55
                            //                                    //validator: DoubleValidator {bottom: -1000.0; top: 1000.0;notation : DoubleValidator.StandardNotation ; decimals : 1}
                            //                                    //inputMethodHints: Qt.ImhDigitsOnly
                            //                                    placeholderText: qsTr("9")
                            //                                }
                            //                                TextField {
                            //                                    id: an2V5
                            //                                    width: windowbackround.width / 10
                            //                                    height: windowbackround.height /15
                            //                                    font.pixelSize: windowbackround.width / 55
                            //                                    // validator: DoubleValidator {bottom: -1000.0; top: 1000.0;notation : DoubleValidator.StandardNotation ; decimals : 1}
                            //                                    //inputMethodHints: Qt.ImhDigitsOnly
                            //                                    placeholderText: qsTr("16")
                            //                                }

                            //                                TextField {
                            //                                    id: unitaux1
                            //                                    width: windowbackround.width / 10
                            //                                    height: windowbackround.height /15
                            //                                    font.pixelSize: windowbackround.width / 55
                            //                                    placeholderText: qsTr("AFR")
                            //                                }
                            //                                Text  { text: "AN1-2";font.pixelSize: windowbackround.width / 55}
                            //                                TextField {
                            //                                    id: an3V0
                            //                                    width: windowbackround.width / 10
                            //                                    height: windowbackround.height /15
                            //                                    font.pixelSize: windowbackround.width / 55
                            //                                    //validator: DoubleValidator {bottom: -1000.0; top: 1000.0;notation : DoubleValidator.StandardNotation ; decimals : 1}
                            //                                    //inputMethodHints: Qt.ImhDigitsOnly
                            //                                    placeholderText: qsTr("Value @ 0V")

                            //                                }
                            //                                TextField {
                            //                                    id: an4V5
                            //                                    width: windowbackround.width / 10
                            //                                    height: windowbackround.height /15
                            //                                    font.pixelSize: windowbackround.width / 55
                            //                                    //validator: DoubleValidator {bottom: -1000.0; top: 1000.0;notation : DoubleValidator.StandardNotation ; decimals : 1}
                            //                                    //inputMethodHints: Qt.ImhDigitsOnly
                            //                                    placeholderText: qsTr("Value @ 5V")
                            //                                }
                            //                                TextField {
                            //                                    id: unitaux2
                            //                                    width: windowbackround.width / 10
                            //                                    height: windowbackround.height /15
                            //                                    font.pixelSize: windowbackround.width / 55
                            //                                    placeholderText: qsTr("AFR")
                            //                                }
                            //                                Text  { text: "AN3-4";font.pixelSize: windowbackround.width / 55}
                            //                                /*
                            //                    Text  { text: "AN5-AN6"; windowbackround.width /12;visible: { (interfaceSelect.currentIndex == "1") ? true: false; }}
                            //                    TextField {
                            //                        id: an5V0
                            //                        windowbackround.width /12
                            //                        validator: IntValidator {bottom: -1000; top: 1000;}
                            //                        placeholderText: qsTr("Value @ 0V")
                            //                        visible: { (interfaceSelect.currentIndex == "1") ? true: false; }
                            //                    }
                            //                    TextField {
                            //                        id: an6V5
                            //                        windowbackround.width /12
                            //                        validator: IntValidator {bottom: -1000; top: 1000;}
                            //                        placeholderText: qsTr("Value @ 5V")
                            //                        visible: { (interfaceSelect.currentIndex == "1") ? true: false; }
                            //                    }
                            //                    TextField {
                            //                        id: unitaux3
                            //                        windowbackround.width /12
                            //                        placeholderText: qsTr("AFR")
                            //                        visible: { (interfaceSelect.currentIndex == "1") ? true: false; }
                            //                    }
                            //                    Text  { text: "AN7-AN8"; windowbackround.width /12;visible: { (interfaceSelect.currentIndex == "1") ? true: false; }}
                            //                    TextField {
                            //                        id: an7V0
                            //                        windowbackround.width /12
                            //                        validator: IntValidator {bottom: -1000; top: 1000;}
                            //                        placeholderText: qsTr("Value @ 0V")
                            //                        visible: { (interfaceSelect.currentIndex == "1") ? true: false; }
                            //                    }
                            //                    TextField {
                            //                        id: an8V5
                            //                        windowbackround.width /12
                            //                        validator: IntValidator {bottom: -1000; top: 1000;}
                            //                        placeholderText: qsTr("Value @ 5V")
                            //                        visible: { (interfaceSelect.currentIndex == "1") ? true: false; }
                            //                    }
                            //                    TextField {
                            //                        id: unitaux4
                            //                        windowbackround.width /12
                            //                        placeholderText: qsTr("AFR")
                            //                        visible: { (interfaceSelect.currentIndex == "1") ? true: false; }
                            //                    }
                            //*/
                            //                            }

                        }
                        }
                        }

                            //Functions
                            Item {
                                //Function to automatically connect at Startup , function is called from COmbobox Serialname component.oncompleted
                                id: autoconnect
                                function auto()
                                {
                                    // if (connectAtStart.checked == true) Connect.openConnection(serialName.currentText, ecuSelect.currentIndex, interfaceSelect.currentIndex, loggerSelect.currentIndex);
                                    if (connectAtStart.checked == true) functconnect.connectfunc(),connectButton.enabled =false,ecuSelect.enabled = false,disconnectButton.enabled = true;//Connect.openConnection(serialName.currentText, ecuSelect.currentIndex, loggerSelect.currentIndex,logger.datalogger()),
                                }
                            }
                            Item {
                                //Function to connect and disconnect GPS
                                id: autoconnectGPS
                                function auto()
                                {

                                    // if (gpsswitch.checked == true)GPS.startGPScom(serialNameGPS.currentText,serialGPSBaud.currentText);
                                    if (gpsswitch.checked === true)GPS.openConnection(serialNameGPS.currentText,"9600"),connectButtonGPS.enabled=false,disconnectButtonGPS.enabled=true;
                                    //if (gpsswitch.checked === false)GPS.closeConnection(),console.log("GPS CLOSED BY QML");
                                }
                            }
                            Item {
                                //Function to connect and disconnect GPS
                                id: remoteDash
                                function write()
                                {

                                    // if (gpsswitch.checked == true)GPS.startGPScom(serialNameGPS.currentText,serialGPSBaud.currentText);
                                    if (remotedashswitch.checked === true)Connect.setRemoteDash("remoteDashIP","remoteDashPort");
                                    if (remotedashswitch.checked === false)Connect.setRemoteDash("","");
                                    //if (gpsswitch.checked === false)GPS.closeConnection(),console.log("GPS CLOSED BY QML");
                                }
                            }
                            Item {
                                id: changeweighttext
                                function changetext()
                                {
                                    if  (unitSelect.currentIndex == 0) weighttext.text = "Weight kg";
                                    if  (unitSelect.currentIndex == 1) weighttext.text = "Weight lbs";
                                }
                            }
                            Item {

                                //Function to transmit GoPro rec status on off

                                id: goproRec

                                property var recording: 0

                                function rec()

                                {

                                    if (record.checked == true) goproRec.recording = 1, GoPro.goprorec(recording.valueOf());

                                    if (record.checked == false) goproRec.recording = 0,GoPro.goprorec(recording.valueOf());





                                }

                            }
                            Item {
                                //Logger on off function
                                id: logger
                                property var loggeron: 0
                                function datalogger()
                                {

                                    if (loggerswitch.checked == true) logger.loggeron = 1, Logger.startLog(logfilenameSelect.text);
                                    if (loggerswitch.checked == false) logger.loggeron = 0,Logger.stopLog();
                                }
                            }
                            Item {
                                //Function to transmit GoPro variant and GoPro Password
                                id: transferSettings
                                function sendSettings()
                                {
                                    GoPro.goProSettings(goProSelect.currentIndex,goPropass.text);

                                }
                            }
                            Item {
                                //function to Connect
                                id: functconnect
                                function connectfunc()
                                {
                                    //Nissanconsult.LiveReqMsg(consRPM.checkState,consRPMREF.checkState,consMAFVolt.checkState,consRHMAFVolt.checkState,consCoolantTemp.checkState,consLHO2Volt.checkState,consRHO2Volt.checkState,consSpeed.checkState,consBattvolt.checkState,consTPS.checkState,consFuelTemp.checkState,consIAT.checkState,consEGT.checkState,consDigitalBitReg.checkState,consInjectTimeLH.checkState,consIGNTiming.checkState,consAACValve.checkState,consAFALPHALH.checkState,consAFALPHARH.checkState,consAFALPHASELFLEARNLH.checkState,consAFALPHASELFLEARNRH.checkState,consDigitalControlReg1.checkState,consDigitalControlReg2.checkState,consMRFCMNT.checkState,consInjecttimeRH.checkState,consWasteGate.checkState,consMAPVolt.checkState,consEngineMount.checkState,consPositionCounter.checkState);
                                    Connect.openConnection(serialName.currentText, ecuSelect.currentIndex ,weight.currentText);
                                    Connect.setOdometer(odometer.text);
                                    Connect.setWeight(weight.text);
                                    //                        Apexi.calculatorAux(an1V0.text,an2V5.text,an3V0.text,an4V5.text,unitaux1.text,unitaux2.text);
                                    connected = 1;
                                    //Dashboard.Auxcalc(unitaux1.text,an1V0.text,an2V5.text,unitaux2.text,an3V0.text,an4V5.text);

                                }
                            }

                            //function to Disconnect
                            Item {

                                id: functdisconnect
                                function disconnectfunc()
                                {
                                    Connect.closeConnection()
                                    connected = 0;
                                }
                            }


                            Item {
                                //Function to play warning sound
                                id: playwarning
                                function start()
                                {
                                    if (warnsound.playing == false) warnsound.play();
                                }
                            }







                        }
                    }
                    Quick1.Tab {
                        id :dash
                        title: "Dash Select"
                        anchors.fill : parent
                        width: 1024
                        property bool firstPageLoaded: false
                        property bool secondPageLoaded: false
                        property bool thirdPageLoaded: false
                        property bool fourthPageLoaded: false
                        property bool fifthPageLoaded: false
                        property bool sixthPageLoaded: false

                        Rectangle{

                            id: dashselector
                            anchors.fill : parent
                            //                color: "grey"
                            width: 1024

                            Item {
                                id: dashSettings
                                Settings {
                                    property alias rpmdash1 : rpm1.currentIndex
                                    property alias rpmdash2 : rpm2.currentIndex
                                    property alias rpmdash3 : rpm3.currentIndex
                                    property alias rpmdash4 : rpm4.currentIndex
                                    property alias file1select : dash1file.currentIndex
                                    property alias file2select : dash2file.currentIndex
                                    property alias file3select : dash3file.currentIndex
                                    property alias file4select : dash4file.currentIndex
                                    property alias file5select : dash5file.currentIndex
                                    property alias dashselect1 : dash1.currentIndex
                                    property alias dashselect2 : dash2.currentIndex
                                    property alias dashselect3 : dash3.currentIndex
                                    property alias dashselect4 : dash4.currentIndex
                                    property alias dashselect5 : dash5.currentIndex
                                    property alias dashselect6 : dash6.currentIndex


                                }
                                Row {
                                    x: dashselector.width /150
                                    y: dashselector.width /150
                                    spacing: dashselector.width /150
                                    Grid {
                                        rows: 6
                                        columns: 2
                                        anchors.top :parent.top
                                        anchors.topMargin: parent.height / 20
                                        //                        spacing: dashselector.width / 250
                                        Text { text: "Dash1 : "
                                            font.pixelSize: dashselector.width / 70
                                        width: dashselector.width / 13}

                                        ComboBox {
                                            id: dash1
                                            width: dashselector.width / 6
                                            height: dashselector.height /15
                                            font.pixelSize: dashselector.width / 80
                                            model: ["Boosted Logo","Boosted","User Dash 1","User Dash 2","User Dash 3","User Dash 4", "Charts", "GPS", "G-Force","Dyno"]
                                            property bool initialized: true
                                            onCurrentIndexChanged:{if(loadScreens == true){select1.selDash1()
                                                } }
                                            //                        Component.onCompleted: {if(loadScreens == true){select1.selDash1()} }
                                            delegate: ItemDelegate {
                                                width: dash1.width
                                                text: dash1.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                font.weight: dash1.currentIndex === index ? Font.DemiBold : Font.Normal
                                                font.family: dash1.font.family
                                                font.pixelSize: dash1.font.pixelSize
                                                highlighted: dash1.highlightedIndex === index
                                                hoverEnabled: dash1.hoverEnabled
                                            }
                                        }

                                        Text { text: "Dash2 : "
                                            font.pixelSize: dashselector.width / 70 }

                                        ComboBox {
                                            id: dash6
                                            width: dashselector.width / 6
                                            height: dashselector.height /15
                                            font.pixelSize: dashselector.width / 80
                                            model: ["Boosted Logo","Boosted","User Dash 1","User Dash 2","User Dash 3","User Dash 4", "Charts", "GPS", "G-Force","Dyno"]
//                                            model: ["Screen Toggle", "Adaptronic","Charts", "GPS", "PowerFC Sensors","User Dash 1","User Dash 2","User Dash 3","G-Force","Dyno","Mediaplayer","Main Dash","Boosted","User Dash 4"]
                                            property bool initialized: true
                                            //                        onCurrentIndexChanged:{/*Connect.setfilename5(dash5file.textAt(dash5file.currentIndex)),*/select6.selDash6() }
                                            //                        Component.onCompleted: {/*Connect.setfilename5(dash5file.textAt(dash5file.currentIndex)),*/select6.selDash6() }
                                            onCurrentIndexChanged:{if(loadScreens == true){select6.selDash6()
                                                    Connect.setdash6(dash6.textAt(dash6.currentIndex))} }
                                            //                        Component.onCompleted: {if(loadScreens == true){select6.selDash6()} }

                                            delegate: ItemDelegate {
                                                width: dash5.width
                                                text: dash5.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                font.weight: dash5.currentIndex === index ? Font.DemiBold : Font.Normal
                                                font.family: dash5.font.family
                                                font.pixelSize: dash5.font.pixelSize
                                                highlighted: dash5.highlightedIndex === index
                                                hoverEnabled: dash5.hoverEnabled
                                            }
                                        }

                                        Text { text: "Dash3 : "
                                            font.pixelSize: dashselector.width / 70}

                                        ComboBox {
                                            id: dash5
                                            width: dashselector.width / 6
                                            height: dashselector.height /15
                                            font.pixelSize: dashselector.width / 80
                                            model: ["Boosted Logo","Boosted","User Dash 1","User Dash 2","User Dash 3","User Dash 4", "Charts", "GPS", "G-Force","Dyno"]
//                                            model: ["Screen Toggle", "Adaptronic","Charts", "GPS", "PowerFC Sensors","User Dash 1","User Dash 2","User Dash 3","G-Force","Dyno","Mediaplayer","Main Dash","Boosted","User Dash 4"]
                                            property bool initialized: true
                                            //                        onCurrentIndexChanged:{/*Connect.setfilename4(dash4file.textAt(dash4file.currentIndex)),*/select5.selDash5() }
                                            //                        Component.onCompleted: {/*Connect.setfilename4(dash4file.textAt(dash4file.currentIndex)),*/select5.selDash5() }
                                            onCurrentIndexChanged:{if(loadScreens == true){select5.selDash5()
                                                    Connect.setdash5(dash5.textAt(dash5.currentIndex))} }
                                            //                        Component.onCompleted: {if(loadScreens == true){select5.selDash5()} }

                                            delegate: ItemDelegate {
                                                width: dash5.width
                                                text: dash5.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                font.weight: dash5.currentIndex === index ? Font.DemiBold : Font.Normal
                                                font.family: dash5.font.family
                                                font.pixelSize: dash5.font.pixelSize
                                                highlighted: dash5.highlightedIndex === index
                                                hoverEnabled: dash5.hoverEnabled
                                            }
                                        }

                                        Text { text: "Dash4 : "
                                            font.pixelSize: dashselector.width / 70}

                                        ComboBox {
                                            id: dash2
                                            width: dashselector.width / 6
                                            height: dashselector.height /15
                                            font.pixelSize: dashselector.width / 80
                                            model: ["Boosted Logo","Boosted","User Dash 1","User Dash 2","User Dash 3","User Dash 4", "Charts", "GPS", "G-Force","Dyno"]
//                                            model: ["Screen Toggle", "Adaptronic","Charts", "GPS", "PowerFC Sensors","User Dash 1","User Dash 2","User Dash 3","G-Force","Dyno","Mediaplayer","Main Dash","Boosted","User Dash 4"]
                                            property bool initialized: true
                                            //                        onCurrentIndexChanged:{/*Connect.setfilename1(dash1file.textAt(dash1file.currentIndex)),*/select2.selDash2() }
                                            //                        Component.onCompleted: {/*Connect.setfilename1(dash1file.textAt(dash1file.currentIndex)),*/select2.selDash2() }
                                            onCurrentIndexChanged:{if(loadScreens == true){select2.selDash2()
                                                    Connect.setdash2(dash2.textAt(dash2.currentIndex))} }
                                            //                        Component.onCompleted: {if(loadScreens == true){select2.selDash2()} }
                                            delegate: ItemDelegate {
                                                width: dash2.width
                                                text: dash2.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                font.weight: dash2.currentIndex === index ? Font.DemiBold : Font.Normal
                                                font.family: dash2.font.family
                                                font.pixelSize: dash2.font.pixelSize
                                                highlighted: dash2.highlightedIndex === index
                                                hoverEnabled: dash2.hoverEnabled
                                            }
                                        }

                                        Text { text: "Dash5 : "
                                            font.pixelSize: dashselector.width / 70}

                                        ComboBox {
                                            id: dash3
                                            width: dashselector.width / 6
                                            height: dashselector.height /15
                                            font.pixelSize: dashselector.width / 80
                                            model: ["Boosted Logo","Boosted","User Dash 1","User Dash 2","User Dash 3","User Dash 4", "Charts", "GPS", "G-Force","Dyno"]
//                                            model: ["Screen Toggle", "Adaptronic","Charts", "GPS", "PowerFC Sensors","User Dash 1","User Dash 2","User Dash 3","G-Force","Dyno","Mediaplayer","Main Dash","Boosted","User Dash 4"]
                                            property bool initialized: true
                                            //                        onCurrentIndexChanged:{/*Connect.setfilename2(dash2file.textAt(dash2file.currentIndex)),*/select3.selDash3() }
                                            //                        Component.onCompleted: {/*Connect.setfilename2(dash2file.textAt(dash2file.currentIndex)),*/select3.selDash3() }
                                            onCurrentIndexChanged:{if(loadScreens == true){select3.selDash3()
                                                    Connect.setdash3(dash3.textAt(dash3.currentIndex))} }
                                            //                        Component.onCompleted: {if(loadScreens == true){select3.selDash3()} }
                                            delegate: ItemDelegate {
                                                width: dash3.width
                                                text: dash3.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                font.weight: dash3.currentIndex === index ? Font.DemiBold : Font.Normal
                                                font.family: dash3.font.family
                                                font.pixelSize: dash3.font.pixelSize
                                                highlighted: dash3.highlightedIndex === index
                                                hoverEnabled: dash3.hoverEnabled
                                            }
                                        }

                                        Text { text: "Dash6 : "
                                            font.pixelSize: dashselector.width / 70}

                                        ComboBox {
                                            id: dash4
                                            width: dashselector.width / 6
                                            height: dashselector.height /15
                                            font.pixelSize: dashselector.width / 80
                                            model: ["Boosted Logo","Boosted","User Dash 1","User Dash 2","User Dash 3","User Dash 4", "Charts", "GPS", "G-Force","Dyno"]
//                                            model: ["Screen Toggle", "Adaptronic","Charts", "GPS", "PowerFC Sensors","User Dash 1","User Dash 2","User Dash 3","G-Force","Dyno","Mediaplayer","Main Dash","Boosted","User Dash 4"]
                                            property bool initialized: true
                                            //                        onCurrentIndexChanged:{/*Connect.setfilename3(dash3file.textAt(dash3file.currentIndex)),*/select4.selDash4() }
                                            //                        Component.onCompleted: {/*Connect.setfilename3(dash3file.textAt(dash3file.currentIndex)),*/select4.selDash4() }
                                            onCurrentIndexChanged:{if(loadScreens == true){select4.selDash4()
                                                    Connect.setdash4(dash4.textAt(dash4.currentIndex))} }
                                            //                        Component.onCompleted: {if(loadScreens == true){select4.selDash4()} }
                                            delegate: ItemDelegate {
                                                width: dash4.width
                                                text: dash4.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                font.weight: dash4.currentIndex === index ? Font.DemiBold : Font.Normal
                                                font.family: dash4.font.family
                                                font.pixelSize: dash4.font.pixelSize
                                                highlighted: dash4.highlightedIndex === index
                                                hoverEnabled: dash4.hoverEnabled
                                            }
                                        }

                                    }
                                    //                        width:1024
                                    //                        height:200
                                    //                        id: userdashsettings
                                    //                        anchors.horizontalCenter: firstgrid.horizontalCenter
                                    //                        anchors.top: firstgrid.bottom
                                    //                        color: "grey"

                                    Grid{
                                        id: dashgrid2
                                        anchors.top :parent.top
                                        anchors.topMargin: parent.height / 20
                                        rows: 5
                                        columns: 2

                                        //                            anchors.topMargin: dashselector.height /120
                                        spacing: dashselector.width / 250
                                        Text { text: "User1 File"
                                            font.pixelSize: dashselector.width / 70
                                        width: dashselector.width / 9
                                        }
                                        ComboBox {
                                            id: dash1file
                                            width: dashselector.width / 6
                                            height: dashselector.height /15
                                            font.pixelSize: dashselector.width / 90
                                            model: Dashboard.dashfiles
                                            property bool initialized: true
                                            delegate: ItemDelegate {
                                                width: dash1file.width
                                                text: dash1file.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                font.weight: dash1file.currentIndex === index ? Font.DemiBold : Font.Normal
                                                font.family: dash1file.font.family
                                                font.pixelSize: dash1file.font.pixelSize
                                                highlighted: dash1file.highlightedIndex === index
                                                hoverEnabled: dash1file.hoverEnabled
                                            }
                                            Component.onCompleted: Connect.setfilename1(dash1file.textAt(dash1file.currentIndex))
                                            onCurrentIndexChanged: Connect.setfilename1(dash1file.textAt(dash1file.currentIndex))
                                        }
                                        Text { text: "User2 File"
                                            font.pixelSize: dashselector.width / 70}
                                        ComboBox {
                                            id: dash2file
                                            width: dashselector.width / 6
                                            height: dashselector.height /15
                                            font.pixelSize: dashselector.width / 90
                                            model: Dashboard.dashfiles
                                            property bool initialized: true

                                            delegate: ItemDelegate {
                                                width: dash2file.width
                                                text: dash2file.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                font.weight: dash2file.currentIndex === index ? Font.DemiBold : Font.Normal
                                                font.family: dash2file.font.family
                                                font.pixelSize: dash2file.font.pixelSize
                                                highlighted: dash2file.highlightedIndex === index
                                                hoverEnabled: dash2file.hoverEnabled
                                            }
                                            Component.onCompleted: Connect.setfilename2(dash2file.textAt(dash2file.currentIndex))
                                            onCurrentIndexChanged: Connect.setfilename2(dash2file.textAt(dash2file.currentIndex))
                                        }
                                        Text { text: "User3 File"
                                            font.pixelSize: dashselector.width / 70}
                                        ComboBox {
                                            id: dash3file
                                            width: dashselector.width / 6
                                            height: dashselector.height /15
                                            font.pixelSize: dashselector.width / 90
                                            model: Dashboard.dashfiles
                                            property bool initialized: true

                                            delegate: ItemDelegate {
                                                width: dash3file.width
                                                text: dash3file.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                font.weight: dash3file.currentIndex === index ? Font.DemiBold : Font.Normal
                                                font.family: dash3file.font.family
                                                font.pixelSize: dash3file.font.pixelSize
                                                highlighted: dash3file.highlightedIndex === index
                                                hoverEnabled: dash3file.hoverEnabled
                                            }
                                            Component.onCompleted: Connect.setfilename3(dash3file.textAt(dash3file.currentIndex))
                                            onCurrentIndexChanged: Connect.setfilename3(dash3file.textAt(dash3file.currentIndex))

                                            //                            Component.onCompleted: Connect.setfilenames(dash1file.textAt(dash1file.currentIndex),dash2file.textAt(dash2file.currentIndex),dash3file.textAt(dash3file.currentIndex),dash4file.textAt(dash4file.currentIndex))
                                            //                            onCurrentIndexChanged: Connect.setfilenames(dash1file.textAt(dash1file.currentIndex),dash2file.textAt(dash2file.currentIndex),dash3file.textAt(dash3file.currentIndex),dash4file.textAt(dash4file.currentIndex))
                                        }
                                        Text { text: "User4 File"
                                            font.pixelSize: dashselector.width / 70}
                                        ComboBox {
                                            id: dash5file
                                            width: dashselector.width / 6
                                            height: dashselector.height /15
                                            font.pixelSize: dashselector.width / 90
                                            model: Dashboard.dashfiles
                                            property bool initialized: true

                                            delegate: ItemDelegate {
                                                width: dash5file.width
                                                text: dash5file.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                font.weight: dash5file.currentIndex === index ? Font.DemiBold : Font.Normal
                                                font.family: dash5file.font.family
                                                font.pixelSize: dash5file.font.pixelSize
                                                highlighted: dash5file.highlightedIndex === index
                                                hoverEnabled: dash5file.hoverEnabled
                                            }
                                            Component.onCompleted: Connect.setfilename5(dash5file.textAt(dash5file.currentIndex))
                                            onCurrentIndexChanged: Connect.setfilename5(dash5file.textAt(dash5file.currentIndex))

                                            //                            Component.onCompleted: Connect.setfilenames(dash1file.textAt(dash1file.currentIndex),dash2file.textAt(dash2file.currentIndex),dash3file.textAt(dash3file.currentIndex),dash4file.textAt(dash4file.currentIndex))
                                            //                            onCurrentIndexChanged: Connect.setfilenames(dash1file.textAt(dash1file.currentIndex),dash2file.textAt(dash2file.currentIndex),dash3file.textAt(dash3file.currentIndex),dash4file.textAt(dash4file.currentIndex))
                                        }
                                        Text { text: "Boosted File"
                                            font.pixelSize: dashselector.width / 70}
                                        ComboBox {
                                            id: dash4file
                                            width: dashselector.width / 6
                                            height: dashselector.height /15
                                            font.pixelSize: dashselector.width / 90
                                            model: Dashboard.dashfiles
                                            property bool initialized: true

                                            delegate: ItemDelegate {
                                                width: dash4file.width
                                                text: dash4file.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                font.weight: dash4file.currentIndex === index ? Font.DemiBold : Font.Normal
                                                font.family: dash4file.font.family
                                                font.pixelSize: dash4file.font.pixelSize
                                                highlighted: dash4file.highlightedIndex === index
                                                hoverEnabled: dash4file.hoverEnabled
                                            }
                                            Component.onCompleted: Connect.setfilename4(dash4file.textAt(dash4file.currentIndex))
                                            onCurrentIndexChanged: Connect.setfilename4(dash4file.textAt(dash4file.currentIndex))

                                            //                            Component.onCompleted: Connect.setfilenames(dash1file.textAt(dash1file.currentIndex),dash2file.textAt(dash2file.currentIndex),dash3file.textAt(dash3file.currentIndex),dash4file.textAt(dash4file.currentIndex))
                                            //                            onCurrentIndexChanged: Connect.setfilenames(dash1file.textAt(dash1file.currentIndex),dash2file.textAt(dash2file.currentIndex),dash3file.textAt(dash3file.currentIndex),dash4file.textAt(dash4file.currentIndex))
                                        }
                                    }
                                    Grid{
                                        id: dashgrid3
                                        anchors.top :parent.top
                                        anchors.topMargin: parent.height / 20
                                        rows: 8
                                        columns: 2
                                        Text { text: "User1 RPM"
                                            font.pixelSize: dashselector.width / 70
                                        width: dashselector.width / 6}
                                        ComboBox {
                                            id: rpm1
                                            width: dashselector.width / 6
                                            height: dashselector.height /15
                                            font.pixelSize: dashselector.width / 75
                                            model: ["None", "Style1","Style2", "Style3", "Style4"]
                                            property bool initialized: true
                                            onCurrentIndexChanged:{Connect.setrpm(rpm1.currentIndex,rpm2.currentIndex,rpm3.currentIndex,rpm4.currentIndex)}
                                            delegate: ItemDelegate {
                                                width: rpm1.width
                                                text: rpm1.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                font.weight: rpm1.currentIndex === index ? Font.DemiBold : Font.Normal
                                                font.family: rpm1.font.family
                                                font.pixelSize: rpm1.font.pixelSize
                                                highlighted: rpm1.highlightedIndex === index
                                                hoverEnabled: rpm1.hoverEnabled
                                            }
                                        }
                                        Text { text: "User2 RPM"
                                            font.pixelSize: dashselector.width / 70}
                                        ComboBox {
                                            id: rpm2
                                            width: dashselector.width / 6
                                            height: dashselector.height /15
                                            font.pixelSize: dashselector.width / 75
                                            model: ["None", "Style1","Style2", "Style3", "Style4"]
                                            property bool initialized: true
                                            onCurrentIndexChanged:{Connect.setrpm(rpm1.currentIndex,rpm2.currentIndex,rpm3.currentIndex,rpm4.currentIndex)}
                                            delegate: ItemDelegate {
                                                width: rpm2.width
                                                text: rpm2.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                font.weight: rpm2.currentIndex === index ? Font.DemiBold : Font.Normal
                                                font.family: rpm2.font.family
                                                font.pixelSize: rpm2.font.pixelSize
                                                highlighted: rpm2.highlightedIndex === index
                                                hoverEnabled: rpm2.hoverEnabled
                                            }
                                        }
                                        Text { text: "User3 RPM"
                                            font.pixelSize: dashselector.width / 70}
                                        ComboBox {
                                            id: rpm3
                                            width: dashselector.width / 6
                                            height: dashselector.height /15
                                            font.pixelSize: dashselector.width / 75
                                            model: ["None", "Style1","Style2", "Style3", "Style4"]
                                            property bool initialized: true
                                            onCurrentIndexChanged:{Connect.setrpm(rpm1.currentIndex,rpm2.currentIndex,rpm3.currentIndex,rpm4.currentIndex)}
                                            Component.onCompleted: {Connect.setrpm(rpm1.currentIndex,rpm2.currentIndex,rpm3.currentIndex,rpm4.currentIndex)}
                                            delegate: ItemDelegate {
                                                width: rpm3.width
                                                text: rpm3.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                font.weight: rpm3.currentIndex === index ? Font.DemiBold : Font.Normal
                                                font.family: rpm3.font.family
                                                font.pixelSize: rpm3.font.pixelSize
                                                highlighted: rpm3.highlightedIndex === index
                                                hoverEnabled: rpm3.hoverEnabled
                                            }
                                        }
                                        Text { text: "User4 RPM"
                                            font.pixelSize: dashselector.width / 70}
                                        ComboBox {
                                            id: rpm4
                                            width: dashselector.width / 6
                                            height: dashselector.height /15
                                            font.pixelSize: dashselector.width / 75
                                            model: ["None", "Style1","Style2", "Style3", "Style4"]
                                            property bool initialized: true
                                            onCurrentIndexChanged:{Connect.setrpm(rpm1.currentIndex,rpm2.currentIndex,rpm3.currentIndex,rpm4.currentIndex)}
                                            Component.onCompleted: {Connect.setrpm(rpm1.currentIndex,rpm2.currentIndex,rpm3.currentIndex,rpm4.currentIndex)}
                                            delegate: ItemDelegate {
                                                width: rpm4.width
                                                text: rpm4.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                font.weight: rpm4.currentIndex === index ? Font.DemiBold : Font.Normal
                                                font.family: rpm4.font.family
                                                font.pixelSize: rpm4.font.pixelSize
                                                highlighted: rpm4.highlightedIndex === index
                                                hoverEnabled: rpm4.hoverEnabled
                                            }
                                        }
                                        Button {
                                            id: dashLoad
                                            height: dashselector.height / 15
//                                            width: 300
                                            width: dashselector.width / 6

                                            font.pixelSize: dashselector.width / 70

                                            text: "Upload Dash"
                                            background: Rectangle {
                                                    implicitWidth: 100
                                                    implicitHeight: 25
                                                    border.width: 1
                                                    border.color: "black"
                                                    color:"white"
                                                    radius: 4
//                                                    gradient: Gradient {
//                                                        GradientStop { position: 0 ; color: control.pressed ? "#ccc" : "#eee" }
//                                                        GradientStop { position: 1 ; color: control.pressed ? "#aaa" : "#ccc" }
//                                                    }
                                                }
                                            //                                ToolTip.text: imgSource
                                            onClicked: {
                                                fileDialog.visible=true
                                            }

                                            FileDialog {
                                                id: fileDialog
                                                selectMultiple: false
                                                title: "Please choose a Dash file"
                                                folder: shortcuts.home
                                                onAccepted: {
                                                    console.log("You chose: " + fileDialog.fileUrls)
                                                    fileSource1=fileDialog.fileUrls[0].substring(7)
                                                    if(fileSource1.includes(":")){
                                                        fileSource1=fileSource1.substring(1)
                                                    }
                                                    fileSource="file://"+Connect.copyDashFile(fileSource1,fileSource1)
                                                    fileDialog.visible=false
                                                    //                                        changevalues.valuechange()
                                                }
                                                onRejected: {
                                                    console.log("Canceled")
                                                    fileDialog.visible=false
                                                }
                                            }
                                        }
                                        Button{
                                            id: reloadScreens
                                            height: dashselector.height / 15
                                            width: dashselector.width / 6

                                            font.pixelSize: dashselector.width / 70
                                            background: Rectangle {
                                                    implicitWidth: 100
                                                    implicitHeight: 25
                                                    border.width: 1
                                                    border.color: "black"
                                                    color:"white"
                                                    radius: 4
//                                                    gradient: Gradient {
//                                                        GradientStop { position: 0 ; color: control.pressed ? "#ccc" : "#eee" }
//                                                        GradientStop { position: 1 ; color: control.pressed ? "#aaa" : "#ccc" }
//                                                    }
                                                }
//                                            width: 200
                                            text: "Reload"
                                            //                                anchors.centerIn: buttonsquare
                                            onClicked: {select1.selDash1(),select2.selDash2(),select3.selDash3(),select4.selDash4(),select5.selDash5(),select6.selDash6()}
                                        }
                                        Text { text: "My IPs"
                                            font.pixelSize: dashselector.width / 70}
                                        ComboBox {
                                            id: myips
                                            width: dashselector.width / 6
                                            height: dashselector.height /15
                                            font.pixelSize: dashselector.width / 75
                                            model: Connect.getAddresses()
                                            property bool initialized: true
                                            delegate: ItemDelegate {
                                                width: myips.width
                                                text: myips.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                font.weight: myips.currentIndex === index ? Font.DemiBold : Font.Normal
                                                font.family: myips.font.family
                                                font.pixelSize: myips.font.pixelSize
                                                highlighted: myips.highlightedIndex === index
                                                hoverEnabled: myips.hoverEnabled
                                            }
                                        }
                                        Button{
                                            id: reloadNetwork
                                            width: dashselector.width / 6

                                            height: dashselector.height / 15
                                            font.pixelSize: dashselector.width / 70
                                            background: Rectangle {
                                                    implicitWidth: 100
                                                    implicitHeight: 25
                                                    border.width: 1
                                                    border.color: "black"
                                                    color:"white"
                                                    radius: 4
//                                                    gradient: Gradient {
//                                                        GradientStop { position: 0 ; color: control.pressed ? "#ccc" : "#eee" }
//                                                        GradientStop { position: 1 ; color: control.pressed ? "#aaa" : "#ccc" }
//                                                    }
                                                }
//                                            width: 200
                                            text: "Reload Friends"
                                            //                                anchors.centerIn: buttonsquare
                                            onClicked: {
                                                mynetwork.model = Connect.getNetwork();
                                                //                                    select1.selDash1(),select2.selDash2(),select3.selDash3(),select4.selDash4(),select5.selDash5(),select6.selDash6()
                                            }
                                        }

                                        ComboBox {
                                            id: mynetwork
                                            width: dashselector.width / 6
                                            height: dashselector.height /15
                                            font.pixelSize: dashselector.width / 75
                                            model: MainWindow.mDeviceModel
                                            property bool initialized: true
                                            delegate: ItemDelegate {
                                                width: mynetwork.width
                                                text: mynetwork.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                font.weight: mynetwork.currentIndex === index ? Font.DemiBold : Font.Normal
                                                font.family: mynetwork.font.family
                                                font.pixelSize: mynetwork.font.pixelSize
                                                highlighted: mynetwork.highlightedIndex === index
                                                hoverEnabled: mynetwork.hoverEnabled
                                            }
                                        }
                                        Button{
                                            id: reloadDefaultDashes
                                            width: dashselector.width / 6
                                            background: Rectangle {
                                                    implicitWidth: 100
                                                    implicitHeight: 25
                                                    border.width: 1
                                                    border.color: "black"
                                                    color:"white"
                                                    radius: 4
//                                                    gradient: Gradient {
//                                                        GradientStop { position: 0 ; color: control.pressed ? "#ccc" : "#eee" }
//                                                        GradientStop { position: 1 ; color: control.pressed ? "#aaa" : "#ccc" }
//                                                    }
                                                }
                                            height: dashselector.height / 15
                                            font.pixelSize: dashselector.width / 80

//                                            width: 300
                                            text: "Reset Dashes to default"
                                            //                                anchors.centerIn: buttonsquare
                                            onClicked: {Connect.writeDefaultFiles()}
                                        }
                                        ComboBox {
                                            id: qrcfiles
                                            visible: false
                                            width: dashselector.width / 6
                                            height: dashselector.height /15
                                            font.pixelSize: dashselector.width / 75
                                            model: ["qrc:/Gauges/Screentoggle.qml","qrc:/Gauges/MyElement.qml","qrc:/Gauges/Userdash1.qml","qrc:/Gauges/Userdash2.qml","qrc:/Gauges/Userdash3.qml","qrc:/Gauges/Userdash4.qml","qrc:/Gauges/Charts.qml","qrc:/GPSTracks/Laptimer.qml","qrc:/Gauges/ForceMeter.qml","qrc:/Gauges/Dyno.qml"]
                                            property bool initialized: true
                                            delegate: ItemDelegate {
                                                width: qrcfiles.width
                                                text: qrcfiles.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                font.weight: qrcfiles.currentIndex === index ? Font.DemiBold : Font.Normal
                                                font.family: qrcfiles.font.family
                                                font.pixelSize: qrcfiles.font.pixelSize
                                                highlighted: qrcfiles.highlightedIndex === index
                                                hoverEnabled: qrcfiles.hoverEnabled
                                            }
                                        }

                                    }
                                }
                                //Function to select Dash1
                                Connections{
                                    target: Dashboard
                                    onSourceIndexChanged: {
                                        //                            if(sourceselect.loadingCombo == 0){
                                        if(sourceIndex == 2){
                                            for (var i=0; i<dash1file.model.length; i++){
                                                if(dash1file.textAt(i) == Connect.getfilename1()){
                                                    dash1file.currentIndex = i
                                                    break;
                                                }
                                            }
                                        } else
                                            if(sourceIndex == 3){
                                                for (var i=0; i<dash2file.model.length; i++){
                                                    if(dash2file.textAt(i) == Connect.getfilename2()){
                                                        dash2file.currentIndex = i
                                                        break;
                                                    }
                                                }
                                            } else
                                                if(sourceIndex == 4){
                                                    for (var i=0; i<dash3file.model.length; i++){
                                                        if(dash3file.textAt(i) == Connect.getfilename3()){
                                                            dash3file.currentIndex = i
                                                            break;
                                                        }
                                                    }
                                                } else
                                                    if(sourceIndex == 1){
                                                        for (var i=0; i<dash4file.model.length; i++){
                                                            if(dash4file.textAt(i) == Connect.getfilename4()){
                                                                dash4file.currentIndex = i
                                                                break;
                                                            }
                                                        }
                                                    } else
                                                        if(sourceIndex == 5){
                                                            for (var i=0; i<dash5file.model.length; i++){
                                                                if(dash5file.textAt(i) == Connect.getfilename5()){
                                                                    dash5file.currentIndex = i
                                                                    break;
                                                                }
                                                            }
                                                        }

                                        switch(Dashboard.pageNo){
                                        case 0:
                                            dash1.currentIndex = sourceIndex
                                            return
                                        case 1:
                                            dash6.currentIndex = sourceIndex
                                            //                                select6.selDash6()
                                            return
                                        case 2:
                                            dash5.currentIndex = sourceIndex
                                            //                                select5.selDash5()
                                            return
                                        case 3:
                                            dash2.currentIndex = sourceIndex
                                            //                                select2.selDash2()
                                            return
                                        case 4:
                                            dash3.currentIndex = sourceIndex
                                            //                                select3.selDash3()
                                            return
                                        case 5:
                                            dash4.currentIndex = sourceIndex
                                            //                                select4.selDash4()
                                            return
                                        }
                                    }
                                    onPageNoChanged: {
                                        switch(pageNo){
                                        case 0:
                                            if(dash.firstPageLoaded == false){
                                                select1.selDash1()
                                                dash.firstPageLoaded = true
                                            }
                                            return
                                        case 1:
                                            if(dash.sixthPageLoaded == false){
                                                select6.selDash6()
                                                dash.sixthPageLoaded = true
                                            }

                                            return
                                        case 2:
                                            if(dash.fifthPageLoaded == false){
                                                select5.selDash5()
                                                dash.fifthPageLoaded = true
                                            }

                                            return
                                        case 3:
                                            if(dash.secondPageLoaded == false){
                                                select2.selDash2()
                                                dash.secondPageLoaded = true
                                            }

                                            return
                                        case 4:
                                            if(dash.thirdPageLoaded == false){
                                                select3.selDash3()
                                                dash.thirdPageLoaded = true
                                            }

                                            return
                                        case 5:
                                            if(dash.fourthPageLoaded == false){
                                                select4.selDash4()
                                                dash.fourthPageLoaded = true
                                            }

                                            return
                                        }
                                    }
                                }
                                Item {
                                    id: select1
                                    function selDash1()
                                    {

                                        if(loadScreens == true){
                                            Connect.setdash1(dash1.textAt(dash1.currentIndex))
                                            firstPageLoader.source = "";
                                            firstPageLoader.source = qrcfiles.textAt(dash1.currentIndex);
                                        }
                                        Connect.setOrientation();

                                    }

                                }
                                Item {
                                    id: select2
                                    function selDash2()
                                    {
                                        if(loadScreens == true){
                                            Connect.setdash2(dash2.textAt(dash2.currentIndex))
                                            fourthPageLoader.source = "";
                                            fourthPageLoader.source = qrcfiles.textAt(dash2.currentIndex);
                                        }
                                        Connect.setOrientation();
                                    }

                                }
                                Item {
                                    id: select3
                                    function selDash3()
                                    {
                                        if(loadScreens == true){
                                            Connect.setdash3(dash3.textAt(dash3.currentIndex))
                                            fifthPageLoader.source = "";
                                            fifthPageLoader.source = qrcfiles.textAt(dash3.currentIndex);
                                        }
                                        Connect.setOrientation();
                                    }

                                }
                                Item {
                                    id: select4
                                    function selDash4()
                                    {
                                        if(loadScreens == true){
                                            Connect.setdash4(dash4.textAt(dash4.currentIndex))
                                            sixthPageLoader.source = "";
                                            sixthPageLoader.source = qrcfiles.textAt(dash4.currentIndex);
                                        }
                                        Connect.setOrientation();
                                    }
                                    Component.onCompleted: tabView.currentIndex = 4 // opens the 3rd tab

                                }
                                Item {
                                    id: select5
                                    function selDash5()
                                    {
                                        if(loadScreens == true){
                                            Connect.setdash5(dash5.textAt(dash5.currentIndex))
                                            thirdPageLoader.source = "";
                                            thirdPageLoader.source = qrcfiles.textAt(dash5.currentIndex);
                                        }
                                        Connect.setOrientation();
                                    }
                                    //                    Component.onCompleted: tabView.currentIndex = 2 // opens the 3rd tab
                                }
                                Item {
                                    id: select6
                                    function selDash6()
                                    {
                                        if(loadScreens == true){
                                            Connect.setdash6(dash6.textAt(dash6.currentIndex))
                                            secondPageLoader.source = "";
                                            secondPageLoader.source = qrcfiles.textAt(dash6.currentIndex);

                                        }
                                        Connect.setOrientation();
                                    }
                                    //                   abc Component.onCompleted: tabView.currentIndex = 2 // opens the 3rd tab
                                    Component.onCompleted: {
                                        if(loadScreens == false){
                                            loadScreens = true
                                            select1.selDash1()//,select2.selDash2(),select3.selDash3(),select4.selDash4(),select5.selDash5(),select6.selDash6()
                                        }
                                    }
                                }
                            }
                        }
                    }

                    //        Quick1.Tab {
                    //            title: "Sensehat" // Tab index 2
                    //            //Sensehat Sensors
                    //            Rectangle{

                    //                id: senhatselector
                    //                anchors.fill: parent
                    //                color: "grey"

                    //                Item {
                    //                    id: sensehatsettings
                    //                    Settings {

                    //                        property alias accelswitch: accelsens.checked
                    //                        property alias gyrowitch:  gyrosense.checked
                    //                        property alias compassswitch: compass.checked
                    //                        property alias tempswitch: tempsense.checked
                    //                        property alias pressureswitch:pressuresens.checked

                    //                    }

                    //                    Grid {
                    //                        rows: 6
                    //                        columns: 2
                    //                        spacing: senhatselector.width / 150
                    //                        anchors.top :parent.top
                    //                        anchors.topMargin: parent.height / 20
                    //                        Switch {
                    //                            id: accelsens
                    //                            text: qsTr("Accelerometer")
                    //                            onCheckedChanged:
                    //                            {if (accelsens.checked == true){Sens.Accel()};
                    //                            }

                    //                        }
                    //                        Switch {
                    //                            id: gyrosense
                    //                            text: qsTr("Gyro Sensor")
                    //                            onCheckedChanged:
                    //                            {

                    //                                if (gyrosense.checked == true){Sens.Gyro()};
                    //                            }
                    //                        }
                    //                        Switch {
                    //                            id: compass
                    //                            text: qsTr("Compass")
                    //                            onCheckedChanged:{
                    //                                if (compass.checked == true){Sens.Comp()};
                    //                            }
                    //                        }
                    //                        Switch {
                    //                            id: pressuresens
                    //                            text: qsTr("Pressure Sensor")
                    //                            onCheckedChanged:{

                    //                                if (pressuresens.checked == true){Sens.Pressure()};
                    //                            }
                    //                        }
                    //                        Switch {
                    //                            id: tempsense
                    //                            text: qsTr("Temperature Sensor")
                    //                            onCheckedChanged:{

                    //                                if (tempsense.checked == true){Sens.Temperature()};
                    //                            }
                    //                            Component.onCompleted: tabView.currentIndex = 4 // opens the 4th tab
                    //                        }


                    //                    }
                    //                }

                    //            }
                    //        }


                    Quick1.Tab {
                        title: "Warn / Gear" // Tab index 3
                        //Warning Settings by Craig Shoesmith
                        Rectangle{

                            id: warningsettings
                            anchors.fill: parent
                            color: "black"

                            Item {
                                id: warnettings
                                Settings {
                                    property alias watertempwarning: watertempwarn.text
                                    property alias boostwarning: boostwarn.text
                                    property alias rpmwarning: rpmwarn.text
                                    property alias knockwarning: knockwarn.text
                                    property alias gearcalcselectswitch: gearcalcselect.checked
                                    property alias gearval1: valgear1.text
                                    property alias gearval2: valgear2.text
                                    property alias gearval3: valgear3.text
                                    property alias gearval4: valgear4.text
                                    property alias gearval5: valgear5.text
                                    property alias gearval6: valgear6.text
                                }


                                Grid {
                                    id: speedcorrgrid
                                    rows:3
                                    columns: 4
                                    spacing: warningsettings.height /150
                                    Text { text: "WaterTemp"
                                        font.pixelSize: warningsettings.width / 55;color:"white"}
                                    Text { text: "Boost"
                                        font.pixelSize: warningsettings.width / 55;color:"white"}
                                    Text { text: "Revs"
                                        font.pixelSize: warningsettings.width / 55;color:"white"}
                                    Text { text: "Knock"
                                        font.pixelSize: warningsettings.width / 55;color:"white"}
                                    TextField {
                                        id: watertempwarn
                                        width: warningsettings.width / 10
                                        height: warningsettings.height /15
                                        font.pixelSize: warningsettings.width / 55
                                        text:  "110"
                                        inputMethodHints: Qt.ImhDigitsOnly // this ensures valid inputs are number only
                                        onEditingFinished: Dashboard.setwaterwarn(watertempwarn.text)
                                        Component.onCompleted: Dashboard.setwaterwarn(watertempwarn.text)

                                    }
                                    TextField {
                                        id: boostwarn
                                        width: warningsettings.width / 10
                                        height: warningsettings.height /15
                                        font.pixelSize: warningsettings.width / 55
                                        inputMethodHints: Qt.ImhDigitsOnly
                                        text:  "0.9"
                                        onEditingFinished: Dashboard.setboostwarn(boostwarn.text)
                                        Component.onCompleted: Dashboard.setboostwarn(boostwarn.text)
                                    }
                                    TextField {
                                        id: rpmwarn
                                        width: warningsettings.width / 10
                                        height: warningsettings.height /15
                                        font.pixelSize: warningsettings.width / 55
                                        inputMethodHints: Qt.ImhDigitsOnly
                                        text:  "10000"
                                        onEditingFinished: Dashboard.setrpmwarn(rpmwarn.text)
                                        Component.onCompleted: Dashboard.setrpmwarn(rpmwarn.text)
                                    }
                                    TextField {
                                        id: knockwarn
                                        width: warningsettings.width / 10
                                        height: warningsettings.height /15
                                        font.pixelSize: warningsettings.width / 55
                                        inputMethodHints: Qt.ImhDigitsOnly
                                        text:  "80"
                                        onEditingFinished: Dashboard.setknockwarn(knockwarn.text)
                                        Component.onCompleted: Dashboard.setknockwarn(knockwarn.text),tabView.currentIndex = 5; // opens the 5th tab
                                    }

                                    }

                                    }
                                        Rectangle{
                                            id: gearsettings
                                            width: parent.width
                                            height: parent.height /2
                                            y:parent.height /5
                                            color: "transparent"
                                            Grid {
                                                id: geargrid
                                                rows:3
                                                columns: 7
                                                spacing: warningsettings.height /150

                                                Text {id: switchtext
                                                    text: "Gear Calc"
                                                    font.pixelSize: warningsettings.width / 55;color:"white"}
                                                Text { text: "Gear1"
                                                    font.pixelSize: warningsettings.width / 55;color:"white"}
                                                Text { text: "Gear2"
                                                    font.pixelSize: warningsettings.width / 55;color:"white"}
                                                Text { text: "Gear3"
                                                    font.pixelSize: warningsettings.width / 55;color:"white"}
                                                Text { text: "Gear4"
                                                    font.pixelSize: warningsettings.width / 55;color:"white"}
                                                Text { text: "Gear5"
                                                    font.pixelSize: warningsettings.width / 55;color:"white"}
                                                Text { text: "Gear6"
                                                    font.pixelSize: warningsettings.width / 55;color:"white"}


                                                Switch {
                                                    id: gearcalcselect
                                                    width: warningsettings.width / 5
                                                    height: warningsettings.height /15
                                                    font.pixelSize: warningsettings.width / 55

                                                    Component.onCompleted: if (gearcalcselect.checked == true){Dashboard.setgearcalcactivation(1),switchtext.text = "Gear Calulation ON";}else{Dashboard.setgearcalcactivation(0),switchtext.text = "Gear Calulation OFF";}
                                                    onCheckedChanged: if (gearcalcselect.checked == true){Dashboard.setgearcalcactivation(1),switchtext.text = "Gear Calulation ON";}else{Dashboard.setgearcalcactivation(0),switchtext.text = "Gear Calulation OFF";}
                                                }

                                                TextField {
                                                    id: valgear1
                                                    width: warningsettings.width / 10
                                                    height: warningsettings.height /15
                                                    font.pixelSize: warningsettings.width / 55
                                                    inputMethodHints: Qt.ImhDigitsOnly
                                                    text:  "120"
                                                    onEditingFinished: Dashboard.setgearcalc1(valgear1.text)
                                                    Component.onCompleted: Dashboard.setgearcalc1(valgear1.text)
                                                }
                                                TextField {
                                                    id: valgear2
                                                    width: warningsettings.width / 10
                                                    height: warningsettings.height /15
                                                    font.pixelSize: warningsettings.width / 55
                                                    inputMethodHints: Qt.ImhDigitsOnly
                                                    text:  "74"
                                                    onEditingFinished: Dashboard.setgearcalc2(valgear2.text)
                                                    Component.onCompleted: Dashboard.setgearcalc2(valgear2.text)
                                                }
                                                TextField {
                                                    id: valgear3
                                                    width: warningsettings.width / 10
                                                    height: warningsettings.height /15
                                                    font.pixelSize: warningsettings.width / 55
                                                    inputMethodHints: Qt.ImhDigitsOnly
                                                    text:  "54"
                                                    onEditingFinished: Dashboard.setgearcalc3(valgear3.text)
                                                    Component.onCompleted: Dashboard.setgearcalc3(valgear3.text)
                                                }
                                                TextField {
                                                    id: valgear4
                                                    width: warningsettings.width / 10
                                                    height: warningsettings.height /15
                                                    font.pixelSize: warningsettings.width / 55
                                                    inputMethodHints: Qt.ImhDigitsOnly
                                                    text:  "37"
                                                    onEditingFinished: Dashboard.setgearcalc4(valgear4.text)
                                                    Component.onCompleted: Dashboard.setgearcalc4(valgear4.text)
                                                }
                                                TextField {
                                                    id: valgear5
                                                    width: warningsettings.width / 10
                                                    height: warningsettings.height /15
                                                    font.pixelSize: warningsettings.width / 55
                                                    inputMethodHints: Qt.ImhDigitsOnly
                                                    text:  "28"
                                                    onEditingFinished: Dashboard.setgearcalc5(valgear5.text)
                                                    Component.onCompleted: Dashboard.setgearcalc5(valgear5.text)
                                                }
                                                TextField {
                                                    id: valgear6
                                                    width: warningsettings.width / 10
                                                    height: warningsettings.height /15
                                                    font.pixelSize: warningsettings.width / 55
                                                    inputMethodHints: Qt.ImhDigitsOnly
                                                    text:  ""
                                                    onEditingFinished: Dashboard.setgearcalc6(valgear6.text)
                                                    Component.onCompleted: Dashboard.setgearcalc6(valgear6.text)
                                                }

                                            }
                                        }





                                    }
                                }
                                Quick1.Tab {
                                    title: "Speed" // Tab index 4
                                    Rectangle{
                                        id: calcs
                                        anchors.fill : parent
                                        color: "black"

                                        //                            color: "grey"

                                        Item {
                                            id: speedcorretionsettings
                                            Settings {
                                                property alias speedpercentsetting: speedpercent.text
                                                property alias speedplusminussetting: speedplusminus.text

                                            }

                                        }
                                        Grid {
                                            rows:2
                                            columns: 2
                                            id: grid
                                            spacing: calcs.height /150
                                            Text { text: "Speed Correction %"
                                                font.pixelSize: calcs.width / 55;color:"white"}
                                            Text { text: "Speed + -"
                                                font.pixelSize: calcs.width / 55;color:"white"}
                                            TextField {
                                                id: speedpercent
                                                width: calcs.width / 5
                                                height: calcs.height /15
                                                font.pixelSize: calcs.width / 55
                                                text:  "100"
                                                inputMethodHints: Qt.ImhDigitsOnly // this ensures valid inputs are number only
                                                Component.onCompleted: Dashboard.setspeedpercent(speedpercent.text /100)
                                                onEditingFinished: Dashboard.setspeedpercent(speedpercent.text /100)
                                            }
                                            TextField {
                                                id: speedplusminus
                                                width: calcs.width / 5
                                                height: calcs.height /15
                                                text:  "0"
                                                font.pixelSize: calcs.width / 55
                                                inputMethodHints: Qt.ImhDigitsOnly
                                                Component.onCompleted: tabView.currentIndex = 6; //
                                            }


                                        }


                                    }
                                }
                                Quick1.Tab {
                                    id:regtab
                                    title: ""// Tab index 5

                                    visible: false
                                    Rectangle {
                                        id: backround1
                                        anchors.fill: parent
                                        color: "black"
                                        Loader {anchors.fill: backround1
                                            id: pageLoader }

                                        function loadersource()
                                        {
                                            //console.log(Dashboard.ecu)
                                            if(Dashboard.ecu == "4")pageLoader.source = "qrc:/ConsultRegs.qml",regtab.title = "Consult";
                                            if(Dashboard.ecu == "7")pageLoader.source = "qrc:/OBDPIDS.qml",regtab.title = "OBD";

                                        }
                                        Component.onCompleted: {loadersource(),tabView.currentIndex = 7;}
                                        Connections{
                                            target: Dashboard
                                            onEcuChanged :{loadersource()}
                                        }
                                    }


                                }
                                Quick1.Tab {
                                    title: "RPM" //
                                    Rectangle{
                                        id: rpmSettings
                                        anchors.fill : parent
                                        color: "black"

                                        //                            color: "grey"

                                        Item {
                                            Settings {
                                                property alias maxrpm: maxRPM.text
                                                property alias shift1: stage1.text
                                                property alias shift2: stage2.text
                                                property alias shift3: stage3.text
                                                property alias shift4: stage4.text

                                            }

                                        }

                                        Grid {

                                            rows:2
                                            columns: 5
                                            spacing: 5
                                            Text { text: "MAX RPM"
                                                font.pixelSize: rpmSettings.width / 55;color:"white"}
                                            Text { text: "Shift Light 1 (g)"
                                                font.pixelSize: rpmSettings.width / 55;color:"white"}
                                            Text { text: "Shift Light 2 (g)"
                                                font.pixelSize: rpmSettings.width / 55;color:"white"}
                                            Text { text: "Shift Light 3 (y)"
                                                font.pixelSize: rpmSettings.width / 55;color:"white"}
                                            Text { text: "Shift Light 4 (r)"
                                                font.pixelSize: rpmSettings.width / 55;color:"white"}
                                            TextField {
                                                id: maxRPM
                                                width: rpmSettings.width / 5.5
                                                height: rpmSettings.height /15
                                                font.pixelSize: rpmSettings.width / 55
                                                text:  "10000"
                                                inputMethodHints: Qt.ImhDigitsOnly // this ensures valid inputs are number only
                                                onEditingFinished: Dashboard.setmaxRPM(maxRPM.text)
                                                Component.onCompleted: Dashboard.setmaxRPM(maxRPM.text)
                                            }
                                            TextField {
                                                id: stage1
                                                width: rpmSettings.width / 5.5
                                                height: rpmSettings.height /15
                                                font.pixelSize: rpmSettings.width / 55
                                                text:  "3000"
                                                inputMethodHints: Qt.ImhDigitsOnly
                                                onEditingFinished:Dashboard.setrpmStage1(stage1.text)
                                                Component.onCompleted:Dashboard.setrpmStage1(stage1.text)
                                            }
                                            TextField {
                                                id: stage2
                                                width: rpmSettings.width / 5.5
                                                height: rpmSettings.height /15
                                                font.pixelSize: rpmSettings.width / 55
                                                text:  "5500"
                                                inputMethodHints: Qt.ImhDigitsOnly
                                                onEditingFinished:Dashboard.setrpmStage2(stage2.text)
                                                Component.onCompleted:Dashboard.setrpmStage2(stage2.text)
                                            }
                                            TextField {
                                                id: stage3
                                                width: rpmSettings.width / 5.5
                                                height: rpmSettings.height /15
                                                font.pixelSize: rpmSettings.width / 55
                                                text:  "5500"
                                                inputMethodHints: Qt.ImhDigitsOnly
                                                onEditingFinished:Dashboard.setrpmStage3(stage3.text)
                                                Component.onCompleted:Dashboard.setrpmStage3(stage3.text)

                                            }
                                            TextField {
                                                id: stage4
                                                width: rpmSettings.width / 5.5
                                                height: rpmSettings.height /15
                                                font.pixelSize: rpmSettings.width / 55
                                                text:  "7500"
                                                inputMethodHints: Qt.ImhDigitsOnly
                                                onEditingFinished: Dashboard.setrpmStage4(stage4.text)
                                                Component.onCompleted: Dashboard.setrpmStage4(stage4.text),tabView.currentIndex = 8;
                                            }

                                            }
                                            }
                                            }

                                                        Quick1.Tab {
                                                            title: "Startup"// Tab index 8



                                                            Rectangle{
                                                                id: daemons
                                                                anchors.fill: parent
                                                                //                                    color: "black"

                                                                //                                    color: "grey"
                                                                Connections{
                                                                    target: Dashboard
                                                                    //onSerialStatChanged :{consoletext.append(Dashboard.SerialStat)}
                                                                    //onSerialStatChanged :{consoletext = Dashboard.SerialStat}
                                                                }
                                                                Item {
                                                                    id: startupsettings
                                                                    Settings {
                                                                        //property alias comboArduinoPort : comboArduino.currentText
                                                                        //property alias comboArduinoindex: comboArduino.currentIndex
                                                                        //property alias autoconnectarduinoautoconnect : arduinoautoconnect.checked
                                                                        property alias mainspeedsource : mainspeedsource.currentIndex
                                                                        property alias daemonselect : daemonselect.currentIndex

                                                                    }
                                                                }/*
            ScrollView {
                id: scrollconsoletext
                width: 400
                height: parent.height
                TextArea {
                    id: consoletext
                    width: scrollconsoletext.width
                    wrapMode: TextArea.Wrap
                    //color: "white"
                }
            }*/
                                                                Grid {
                id:startupgrid
                                                                    anchors.top :parent.top
                                                                    anchors.topMargin: parent.height / 20
                                                                    anchors.right: parent.right
                                                                    rows: 10
                                                                    columns: 2
                                                                    spacing: parent.width /150
                                                                    Text { text: "Apply Settings :"
                                                                        font.pixelSize: daemons.width / 55 }
                                                                    Button {
                                                                        id: apply
                                                                        width: daemons.width / 5
                                                                        height: daemons.height /15
                                                                        text: "apply"
                                                                        onClicked: Connect.daemonstartup(daemonselect.currentIndex)
                                                                    }
                                                                    Text { text: "Start up Daemon :"
                                                                        font.pixelSize: daemons.width / 55 }
                                                                    ComboBox {
                                                                        id: daemonselect
                                                                        width: daemons.width / 5
                                                                        height: daemons.height /15
                                                                        font.pixelSize: daemons.width / 55
                                                                        model: [ "None","HaltechV2","Link Generic Dash","Microtech","Consult","Apexi","OBD2"]
                                                                        delegate: ItemDelegate {
                                                                            width: daemonselect.width
                                                                            text: daemonselect.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                                            font.weight: daemonselect.currentIndex === index ? Font.DemiBold : Font.Normal
                                                                            font.family: daemonselect.font.family
                                                                            font.pixelSize: daemonselect.font.pixelSize
                                                                            highlighted: daemonselect.highlightedIndex === index
                                                                            hoverEnabled: daemonselect.hoverEnabled
                                                                        }
                                                                        Component.onCompleted: tabView.currentIndex = 1;

                                                                    }
                                                                    /*
                Text { text: "Arduino Port"
                    font.pixelSize: daemons.width / 55 }
                ComboBox {
                    id: comboArduino
                    width: daemons.width / 5
                    height: daemons.height /15
                    font.pixelSize: daemons.width / 55
                    model: Connect.portsNames
                    //visible: { (ecuSelect.currentIndex >= "5") ? false: true; }
                    property bool initialized: false
                    delegate: ItemDelegate {
                        width: comboArduino.width
                        text: comboArduino.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                        font.weight: comboArduino.currentIndex === index ? Font.DemiBold : Font.Normal
                        font.family: comboArduino.font.family
                        font.pixelSize: comboArduino.font.pixelSize
                        highlighted: comboArduino.highlightedIndex === index
                        hoverEnabled: comboArduino.hoverEnabled
                    }
                }
                Text { text: "Connect Arduino"
                    font.pixelSize: daemons.width / 55 }
                Button {
                    id: arduino
                    width: daemons.width / 5
                    height: daemons.height /15
                    text: "Connect"
                    onClicked: Arduino.openConnection(comboArduino.currentText),arduino.enabled = false,Dashboard.setExternalSpeed(1);
                    }
                Text { text: "Autoconnect"
                    font.pixelSize: daemons.width / 55 }
                Switch {
                    id: arduinoautoconnect
                    width: daemons.width / 5
                    height: daemons.height/15
                    font.pixelSize: daemons.width / 55
                    Component.onCompleted: autoconnectarduino.autoarduino(),tabView.currentIndex = 0;
                }
                Text { text: "GPS as Mainspeedsource"
                    font.pixelSize: daemons.width / 55 }
                Switch {
                    id: speedsourcegps
                    width: daemons.width / 5
                    height: daemons.height/15
                    font.pixelSize: daemons.width / 55
                    onCheckedChanged: {Dashboard.setExternalSpeed(2)}
                }
                Item {
                    //Function to automatically connect
                    id: autoconnectarduino
                    function autoarduino()
                    {
                        if (arduinoautoconnect.checked == true) Arduino.openConnection("/dev/ttyACM0"),arduino.enabled = false,Dashboard.setExternalSpeed(1);
                    }
}
*/

                                                                    Text { text: "Main Speed Source"
                                                                        font.pixelSize: daemons.width / 55 }
                                                                    ComboBox {
                                                                        id: mainspeedsource
                                                                        width: daemons.width / 5
                                                                        height: daemons.height /15
                                                                        font.pixelSize: daemons.width / 55
                                                                        model: ["ECU Speed","LF Wheelspeed","RF Wheelspeed","LR Wheelspeed","RR Wheelspeed","GPS"]
                                                                        onCurrentIndexChanged: Dashboard.setExternalSpeed(mainspeedsource.currentIndex)//,console.log(mainspeedsource.currentIndex)
                                                                        property bool initialized: false
                                                                        Component.onCompleted: {
                                                                            if(loadScreens == false){
                                                                                loadScreens = true
                                                                                select1.selDash1()//,select2.selDash2(),select3.selDash3(),select4.selDash4(),select5.selDash5(),select6.selDash6()
                                                                            }
                                                                        }
                                                                        delegate: ItemDelegate {
                                                                            width: mainspeedsource.width
                                                                            text: mainspeedsource.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                                                                            font.weight: mainspeedsource.currentIndex === index ? Font.DemiBold : Font.Normal
                                                                            font.family: mainspeedsource.font.family
                                                                            font.pixelSize: mainspeedsource.font.pixelSize
                                                                            highlighted: mainspeedsource.highlightedIndex === index
                                                                            hoverEnabled: mainspeedsource.hoverEnabled
                                                                        }
                                                                        //
                                                                    }

                                                                }
                                                                Component.onCompleted: tabView.currentIndex = 1;

                                                            }
                                                        }




/////////////////////////////////////////////////////////////////////////////////////////////
    Quick1.Tab {
        title: "Network"// Tab index 9

        Rectangle{
            id: extrarect
            anchors.fill: parent
            color: "grey"
            Connections{
                target: Dashboard
                onSerialStatChanged : {
                    consoleText.append(Dashboard.SerialStat);
                    //console.log(Dashboard.SerialStat);
                 scrollBar.increase();
                }
            }
            WifiCountryList{id: wificountrynames}

            Settings {
                property alias wificountryindex: wificountrycbx.currentIndex
                      }

            Flickable {
                id: flickable
                width: 450
                height: 400

                TextArea.flickable: TextArea {
                    id : consoleText
                    wrapMode: TextArea.Wrap
                    readOnly: true
                    color: "green"
                    font.pixelSize: 15
                    background: Rectangle {
                        height:flickable.height
                        width: flickable.width
                        color: "black"
                    }
                }

                ScrollBar.vertical: ScrollBar { id:scrollBar
                policy: ScrollBar.AlwaysOn}
            }

            Grid {
                id:extragrid
                anchors.top :parent.top
                anchors.topMargin: parent.height / 20
                anchors.right: parent.right
                rows: 10
                columns: 2
                spacing: parent.width /150


                Text { text: " "
                    font.pixelSize: extrarect.width / 55 }
                Button {
                    id: btnScanNetwork
                   // visible: false
                    text: "Scan WIFI"
                    width: extrarect.width / 5
                    height: extrarect.height /15
                    font.pixelSize: extrarect.width / 55
                    onClicked: {
                                consoleText.clear();
                                Wifiscanner.initializeWifiscanner();
                                Wifiscanner.findActiveWirelesses();
                                //btnScanNetwork.enabled =false;
                        }
                }
                Text { text: "Wifi Country :"
                    font.pixelSize: extrarect.width / 55 }
                ComboBox {
                    id: wificountrycbx
                    //visible: false
                    width: extrarect.width / 5
                    height: extrarect.height /15
                    font.pixelSize: extrarect.width / 55
                    model: wificountrynames
                    textRole: "name"
                    property bool initialized: true
                }
                Text { text: "Wifi 1 :"
                    font.pixelSize: extrarect.width / 55 }
                ComboBox {
                    id: wifilistbox
                    //visible: false
                    width: extrarect.width / 5
                    height: extrarect.height /15
                    font.pixelSize: extrarect.width / 55
                    model: Dashboard.wifi
                    onCountChanged: btnScanNetwork.enabled =true;
                    property bool initialized: false
                    delegate: ItemDelegate {
                        width: wifilistbox.width
                        text: wifilistbox.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                        font.weight: wifilistbox.currentIndex === index ? Font.DemiBold : Font.Normal
                        font.family: wifilistbox.font.family
                        font.pixelSize: wifilistbox.font.pixelSize
                        highlighted: wifilistbox.highlightedIndex === index
                        hoverEnabled: wifilistbox.hoverEnabled
                    }
                }
                Text {

                    text: "Password 1:"
                    font.pixelSize: extrarect.width / 55 }
                TextField {
                    id: pw1
                    placeholderText: qsTr("Passphrase")
                    width: extrarect.width / 5
                    font.pixelSize: extrarect.width / 55 }
                /*
                Text { text: "Wifi 2 :"
                    //visible: false
                    font.pixelSize: extrarect.width / 55 }
                ComboBox {
                    id: wifilistbox2
                    //visible: false
                    width: extrarect.width / 5
                    height: extrarect.height /15
                    font.pixelSize: extrarect.width / 55
                    model: Dashboard.wifi
                    onCountChanged: btnScanNetwork.enabled =true;
                    property bool initialized: false
                    delegate: ItemDelegate {
                        width: wifilistbox2.width
                        text: wifilistbox2.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                        font.weight: wifilistbox2.currentIndex === index ? Font.DemiBold : Font.Normal
                        font.family: wifilistbox2.font.family
                        font.pixelSize: wifilistbox2.font.pixelSize
                        highlighted: wifilistbox2.highlightedIndex === index
                        hoverEnabled: wifilistbox2.hoverEnabled
                    }
                }
                Text {
                    text: "Password :"
                    font.pixelSize: extrarect.width / 55 }
                TextField {
                    id: pw2
                    placeholderText: qsTr("Passphrase")
                    width: extrarect.width / 5
                    font.pixelSize: extrarect.width / 55 }*/
                Text { text: " "
                    font.pixelSize: extrarect.width / 55 }
                Button {
                    id: updateBtn
                    text: "Update"
                    width: extrarect.width / 5
                    height: extrarect.height /15
                    font.pixelSize: extrarect.width / 55
                    onClicked: {
                                Connect.update();
                                updateBtn.enabled =false;
                        }
                }
                Text { text: " "
                    font.pixelSize: extrarect.width / 55 }

                Button {
                    id: applyWifiSettings
                    text: "Apply Settings"
                    width: extrarect.width / 5
                    height: extrarect.height /15
                    font.pixelSize: extrarect.width / 55
                    Component.onCompleted: {

                        Wifiscanner.findActiveWirelesses();
                        Wifiscanner.initializeWifiscanner();
                    }
                    onClicked: {
                        //Wifiscanner.setwifi(wificountrynames.get(wificountrycbx.currentIndex).countryname,wifilistbox.textAt(wifilistbox.currentIndex),pw1.text,wifilistbox2.textAt(wifilistbox2.currentIndex),pw2.text );
                        Wifiscanner.setwifi(wificountrynames.get(wificountrycbx.currentIndex).countryname,wifilistbox.textAt(wifilistbox.currentIndex),pw1.text,"placeholder","placeholder" );
                        Connect.reboot();
                    }
                }
            }
        }
    }

                                        }
///////////////////////////////////////////////////////////////////////////////////////////

                                                    /*##^## Designer {
    D{i:0;autoSize:true;height:480;width:640}
}
 ##^##*/
