import QtQuick 2.7
import QtQuick.Controls 2.0
import QtQuick.Layouts 1.3
import QtQuick.Dialogs 1.0

ApplicationWindow {
    id:mainwindow
    visible: true
    width: 1400
    height: 700
    title: qsTr("PowerTune Dash Designer V 0.1 Beta")
    property bool vertvisble: false
    property bool fullCircle: false
    property bool horizvisible: false
    property bool secvisible: false
    property var component;
    property double testvalue: testvalueslider.value;
    property int gaugenumber : 1;
    property var gauge1;
    property var gauge2;
    property var gauge3;
    property var gauge4;
    property var gauge5;
    property var gauge6;
    property var gauge7;
    property var gauge8;
    property var gauge9;
    property var gauge10;
    property var gauge11;
    property var gauge12;
    property var gauge13;
    property var gauge14;
    property var gauge15;
    property var gauge16;
    property var gauge17;
    property var gauge18;
    property var gauge19;
    property var gauge20;
    property var tempgauge;
    property bool refreshing: false

    property string imgSource:""
    //    property string title
    //    property string mainunit
    //    property string secvalue
    //    property string maintextvalue
    //    property string mainvalue
    //    property string maxvalue
    //    property string maxval: maxvalue
    property string titlecolor
    //    property string titlefontsize
    //    property string mainfontsize
    property string resettitlecolor
    property string resetbackroundcolor: "transparent"
    property string framecolor: "transparent"
    property string titletextcolor
    property string textcolor
    property string barcolor
    //    property double warnvaluehigh: 20000
    //    property double warnvaluelow : -20000
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
    //    property int stepsize : 1
    //    property real maxValueAngle : 180
    //    property real minValueAngle : -90

    ListModel {
        id: gaugenames

    }
    TabBar {
        id: bar
        width: 240
        anchors.bottom: stackLayout.top
        anchors.top: parent.top
        anchors.left: appwindow.right
        anchors.right: parent.right
        TabButton {
            text: qsTr("Values")
        }
        TabButton {
            text: qsTr("Values ...")
        }
        TabButton {
            text: qsTr("Colors")
        }
    }


    StackLayout {
        id: stackLayout
        width: 240
        anchors.top: bar.bottom
        anchors.bottom: parent.bottom
        anchors.left: appwindow.right
        anchors.right: parent.right
        currentIndex: bar.currentIndex
        Item {
            id: homeTab
            Rectangle
            {
                id:menues
                color: "#a9a9a9"
                anchors.fill: parent
                Grid {
                    anchors.right: parent.right
                    anchors.bottom: parent.bottom
                    anchors.top: parent.top
                    spacing: 2
                    rows: 25
                    columns: 2
                    Text
                    {
                        text: "Gauge Type:"
                        height :30
                        width :180
                        color: "white"
                    }
                    ComboBox {
                        id: gaugetype
                        width: 150
                        height: 30
                        model : [ "Round","Speedo","Tacho","Square","Image"]
                        delegate: ItemDelegate {
                            width: gaugetype.width
                            text: gaugetype.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                            font.weight: gaugetype.currentIndex === index ? Font.DemiBold : Font.Normal
                            font.family: gaugetype.font.family
                            font.pixelSize: gaugetype.font.pixelSize
                            highlighted: gaugetype.highlightedIndex === index
                            hoverEnabled: gaugetype.hoverEnabled
                        }
                        //onCurrentIndexChanged: switchgauge.updatevalues()
                    }
                    Button{
                        id: remove
                        height :30
                        width :180
                        text:"Remove Gauge"

                    }
                    Button{
                        id: create
                        height :30
                        width :180
                        text:"Add Gauge"
                        onClicked: {


                            if(gaugetype.currentText == "Round"){
                                container.createRoundGauge(gwidth.text,gheight.text,300,240,150,decimalplaces.value,units.text,title.text,vertvisble,horizvisible,secvisible,"","","","2000","-2000","blue","black","blue","white","white","blue","25","40","white","red","#ffffff","blue","red","red","blue","white","red","#ffffff","#e96448","#f22900","transparent","1","-135","135","0","false","20","images/dashboard.png"),gaugenames.append({"name": gaugenumber.toString() }),gaugenumber++;
                            }else if(gaugetype.currentText == "Speedo"){
                                container.createSpeedoGauge(gwidth.text,gheight.text,300,240,320,decimalplaces.value,units.text,title.text,vertvisble,horizvisible,secvisible,"","","","290","0","blue","black","blue","white","white","blue","25","40","white","red","#ffffff","blue","red","red","blue","white","red","#ffffff","#e96448","#f22900","transparent","10","-135","135","0","false","20","images/dashboard.png"),gaugenames.append({"name": gaugenumber.toString() }),gaugenumber++;
                            }else if(gaugetype.currentText == "Tacho"){
                                container.createTachoGauge(gwidth.text,gheight.text,300,240,10,decimalplaces.value,units.text,title.text,vertvisble,horizvisible,secvisible,"","","","6.5","1","blue","black","blue","white","white","blue","25","40","white","red","#ffffff","blue","red","red","blue","white","red","#ffffff","#e96448","#f22900","transparent","1000","-135","135","0","false","20","images/dashboard.png"),gaugenames.append({"name": gaugenumber.toString() }),gaugenumber++;
                            }else if(gaugetype.currentText == "Square"){
                                container.createSquareGauge(gwidth.text,gheight.text,300,240,150,decimalplaces.value,units.text,title.text,vertvisble,horizvisible,secvisible,"","",""),gaugenames.append({"name": gaugenumber.toString() }),gaugenumber++;
                            }else if(gaugetype.currentText == "Image"){
                                container.createImage(gwidth.text,gheight.text,300,240,150,decimalplaces.value,units.text,title.text,vertvisble,horizvisible,secvisible,"","","","2000","-2000","blue","black","blue","white","white","blue","25","40","white","red","#ffffff","blue","red","red","blue","white","red","#ffffff","#e96448","#f22900","transparent","1","-135","135","0","false","20","images/dashboard.png"),gaugenames.append({"name": gaugenumber.toString() }),gaugenumber++;
                                //                                createImage(setWidth,setHeight,setX,setY,setMaxValue,setDecPlace,setUnit,setID,setVertGaugeVis,setHoriGaugeVis,setSecValueVis,SetValueObject,SetValuePropertyMain,SetValuePropertySec,Setwarnvaluehigh,Setwarnvaluelow,color1,color2,color3,color4,color5,color6,color7,color8,color9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize1,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal,imgSource)
                                //                            if (dashvalue.textAt(44) !== "") {imgSource = "file://"+dashvalue.textAt(44);}else {imgSource = "";}                            }
                            }
                        }
                    }
                    Text
                    {
                        text: "Select Gauge:"
                        height :30
                        width :180
                        color: "white"
                    }
                    ComboBox {
                        id: gaugeselect
                        width: 150
                        height: 30
                        model : gaugenames
                        delegate: ItemDelegate {
                            width: gaugeselect.width
                            text: gaugeselect.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                            font.weight: gaugeselect.currentIndex === index ? Font.DemiBold : Font.Normal
                            font.family: gaugeselect.font.family
                            font.pixelSize: gaugeselect.font.pixelSize
                            highlighted: gaugeselect.highlightedIndex === index
                            hoverEnabled: gaugeselect.hoverEnabled
                        }
                        onCurrentIndexChanged: switchgauge.updatevalues()
                    }
                    Text
                    {
                        text: "Title"
                        height :30
                        width :180
                        color: "white"
                    }
                    TextField {
                        selectByMouse: true
                        id:title
                        text: qsTr("BatteryV")
                        height :30
                        width :180
                        inputMethodHints: Qt.ImhNoAutoUppercase | Qt.ImhPreferLowercase | Qt.ImhSensitiveData | Qt.ImhNoPredictiveText
                        onTextChanged : changevalues.valuechange()
                        onFocusChanged: {
                            if(focus == true){
                                switchgauge.updatevalues()
                            }
                        }
                    }
                    Text
                    {
                        text: "Unit description"
                        height :30
                        width :180
                        color: "white"
                    }
                    TextField {
                        selectByMouse: true
                        id:units
                        text: qsTr("V")
                        height :30
                        width :180
                        inputMethodHints: Qt.ImhNoAutoUppercase | Qt.ImhPreferLowercase | Qt.ImhSensitiveData | Qt.ImhNoPredictiveText
                        onTextChanged : changevalues.valuechange()
                    }
                    Text
                    {
                        text: "Height:"
                        height :30
                        width :180
                        color: "white"
                        //                        onTextChanged : changevalues.valuechange()
                    }
                    TextField {
                        selectByMouse: true
                        id:gheight
                        text: qsTr("200")
                        height :30
                        width :180
                        inputMethodHints: Qt.ImhDigitsOnly
                        onTextChanged : {
                            if((gheight.text*1) > 30){
                                changevalues.valuechange()
                            }
                        }
                    }
                    Text
                    {
                        text: "Width:"
                        height :30
                        width :180
                        color: "white"
                    }
                    TextField {
                        selectByMouse: true
                        id:gwidth
                        text: qsTr("120")
                        height :30
                        width :180
                        inputMethodHints: Qt.ImhDigitsOnly
                        onTextChanged : {
                            if((gwidth.text*1) > 30){
                                changevalues.valuechange()
                            }
                        }
                    }
                    Text
                    {
                        text: "X :"
                        height :30
                        width :180
                        color: "white"
                        //                        onTextChanged : changevalues.valuechange()
                    }
                    TextField {
                        selectByMouse: true
                        id:gx
                        text: qsTr("200")
                        height :30
                        width :180
                        inputMethodHints: Qt.ImhDigitsOnly
                        onTextChanged : changevalues.valuechange()
                        onFocusChanged: {
                            if(focus == true){
                                switchgauge.updatevalues()
                            }
                        }
                    }
                    Text
                    {
                        text: "Y :"
                        height :30
                        width :180
                        color: "white"
                    }
                    TextField {
                        selectByMouse: true
                        id:gy
                        text: qsTr("120")
                        height :30
                        width :180
                        inputMethodHints: Qt.ImhDigitsOnly
                        onTextChanged : changevalues.valuechange()
                        onFocusChanged: {
                            if(focus == true){
                                switchgauge.updatevalues()
                            }
                        }
                    }
                    Text
                    {
                        text: "Max Val:"
                        height :30
                        width :180
                        color: "white"

                    }
                    TextField {
                        selectByMouse: true
                        id:maxval
                        text: qsTr("200")
                        height :30
                        width :180
                        inputMethodHints: Qt.ImhDigitsOnly
                        onTextChanged : {
//                            testvalueslider.from = text*-1
//                            testvalueslider.to = text
                            changevalues.valuechange()
                        }
                    }
                    Text
                    {
                        text: "Vertical Bar gauge visible:"
                        height :30
                        width :180
                        color: "white"
                    }
                    ComboBox {
                        id: vertvis
                        width: 150
                        height: 30
                        model : ["false","true"]
                        //initialized : "true"
                        delegate: ItemDelegate {
                            width: vertvis.width
                            text: vertvis.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                            font.weight: vertvis.currentIndex === index ? Font.DemiBold : Font.Normal
                            font.family: vertvis.font.family
                            font.pixelSize: vertvis.font.pixelSize
                            highlighted: vertvis.highlightedIndex === index
                            hoverEnabled: vertvis.hoverEnabled
                        }
                        Component.onCompleted: {
                            if (vertvis.currentIndex == 0) {vertvisble = false};
                            if (vertvis.currentIndex == 1) {vertvisble = true};
                        }
                        onCurrentIndexChanged:
                        {
                            if (vertvis.currentIndex == 0) {vertvisble = false};
                            if (vertvis.currentIndex == 1) {vertvisble = true};
                            changevalues.valuechange()
                        }
                    }
                    Text
                    {
                        text: "Horizontal Bar gauge visible:"
                        height :30
                        width :180
                        color: "white"
                    }
                    ComboBox {
                        id: horizvis
                        width: 150
                        height: 30
                        model : ["false","true"]
                        //initialized : "true"
                        delegate: ItemDelegate {
                            width: horizvis.width
                            text: horizvis.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                            font.weight: horizvis.currentIndex === index ? Font.DemiBold : Font.Normal
                            font.family: horizvis.font.family
                            font.pixelSize: horizvis.font.pixelSize
                            highlighted: horizvis.highlightedIndex === index
                            hoverEnabled: horizvis.hoverEnabled
                        }
                        Component.onCompleted:
                        {
                            if (horizvis.currentIndex == 0) {horizvisible = false};
                            if (horizvis.currentIndex  == 1) {horizvisible = true};

                        }
                        onCurrentIndexChanged:
                        {
                            if (horizvis.currentIndex == 0) {horizvisible = false};
                            if (horizvis.currentIndex  == 1) {horizvisible = true};
                            changevalues.valuechange()
                        }

                    }
                    Text
                    {
                        text: "Secondary Val visible:"
                        height :30
                        width :180
                        color: "white"
                    }
                    ComboBox {
                        id: secvis
                        width: 150
                        height: 30
                        model : ["false","true"]
                        //initialized : "true"
                        delegate: ItemDelegate {
                            width: secvis.width
                            text: secvis.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                            font.weight: secvis.currentIndex === index ? Font.DemiBold : Font.Normal
                            font.family: secvis.font.family
                            font.pixelSize: secvis.font.pixelSize
                            highlighted: secvis.highlightedIndex === index
                            hoverEnabled: secvis.hoverEnabled
                        }
                        Component.onCompleted:
                        {
                            if (secvis.currentIndex == 0) {secvisible = false};
                            if (secvis.currentIndex == 1) {secvisible = true};
                        }
                        onCurrentIndexChanged:
                        {
                            if (secvis.currentIndex == 0) {secvisible = false};
                            if (secvis.currentIndex == 1) {secvisible = true};
                            changevalues.valuechange()
                        }
                    }
                    Text
                    {
                        text: "Decimal places:"
                        height :30
                        width :180
                        color: "white"
                    }

                    SpinBox {
                        id: decimalplaces
                        height :30
                        width :180
                        from: 0
                        value: 0
                        to: 5
                        stepSize: 1
                        onValueChanged: changevalues.valuechange()
                    }
                    Text
                    {
                        text: "Warning High:"
                        height :30
                        width :180
                        color: "white"
                    }
                    TextField {
                        selectByMouse: true
                        id : highwarn
                        text: qsTr("20000")
                        height :30
                        width :180
                        inputMethodHints: Qt.ImhDigitsOnly
                        onTextChanged : changevalues.valuechange()
                    }
                    Text
                    {
                        text: "Warning Low:"
                        height :30
                        width :180
                        color: "white"
                    }
                    TextField {
                        selectByMouse: true
                        id : lowwarn
                        text: qsTr("-20000")
                        height :30
                        width :180
                        inputMethodHints: Qt.ImhDigitsOnly
                        onTextChanged : changevalues.valuechange()
                    }

                    Slider {
                        id: testvalueslider
                        height :30
                        width :180
                        from: 0
                        value: 0
                        stepSize: 1
                        to: 100
                        onValueChanged: {
                            changevalues.valuechange()
                                gauge1.mainvalue = ((testvalueslider.value/100)*gauge1.maxval).toFixed(2)
                                gauge2.mainvalue = ((testvalueslider.value/100)*gauge2.maxval).toFixed(2)
                                gauge3.mainvalue = ((testvalueslider.value/100)*gauge3.maxval).toFixed(2)
                                gauge4.mainvalue = ((testvalueslider.value/100)*gauge4.maxval).toFixed(2)
                                gauge5.mainvalue = ((testvalueslider.value/100)*gauge5.maxval).toFixed(2)
                                gauge6.mainvalue = ((testvalueslider.value/100)*gauge6.maxval).toFixed(2)
                                gauge7.mainvalue = ((testvalueslider.value/100)*gauge7.maxval).toFixed(2)
                                gauge8.mainvalue = ((testvalueslider.value/100)*gauge8.maxval).toFixed(2)
                                gauge9.mainvalue = ((testvalueslider.value/100)*gauge9.maxval).toFixed(2)
                                gauge10.mainvalue =( (testvalueslider.value/100)*gauge10.maxval).toFixed(2)
                                gauge11.mainvalue = ((testvalueslider.value/100)*gauge11.maxval).toFixed(2)
                                gauge12.mainvalue = ((testvalueslider.value/100)*gauge12.maxval).toFixed(2)
                                gauge13.mainvalue = ((testvalueslider.value/100)*gauge13.maxval).toFixed(2)
                                gauge14.mainvalue =((testvalueslider.value/100)*gauge14.maxval).toFixed(2)
                                gauge15.mainvalue = ((testvalueslider.value/100)*gauge15.maxval).toFixed(2)
                                gauge16.mainvalue = ((testvalueslider.value/100)*gauge16.maxval).toFixed(2)
                                gauge17.mainvalue = ((testvalueslider.value/100)*gauge17.maxval).toFixed(2)
                                gauge18.mainvalue = ((testvalueslider.value/100)*gauge18.maxval).toFixed(2)
                                gauge19.mainvalue = ((testvalueslider.value/100)*gauge19.maxval).toFixed(2)
                                gauge20.mainvalue = ((testvalueslider.value/100)*gauge20.maxval).toFixed(2)

                        }
                    }
                    Text
                    {
                        text: ""
                        height :30
                        width :180
                        color: "white"
                    }
                    Text
                    {
                        text: "Priority:"
                        height :30
                        width :180
                        color: "white"
                    }
                    TextField {
                        selectByMouse: true
                        id : zVal
                        text: qsTr("0")
                        height :30
                        width :180
                        inputMethodHints: Qt.ImhDigitsOnly
                        onTextChanged : changevalues.valuechange()
                    }
                    Button {
                        id: applyChanges1
                        width: 180
                        height: 30
                        text: "Apply"
                        onClicked: {
                            changevalues.updateGaugeValues()
                        }
                    }

                }
            }

        }

        Item {
            id: valuestab
            Rectangle
            {
                id:menues2
                color: "#a9a9a9"
                anchors.fill: parent
                Grid {
                    anchors.right: parent.right
                    anchors.bottom: parent.bottom
                    anchors.top: parent.top
                    spacing: 2
                    rows: 25
                    columns: 2
                    Text
                    {
                        text: "Title Font Size:"
                        height :30
                        width :180
                        color: "white"
                    }

                    TextField {
                        selectByMouse: true
                        id : setTitlefontsize
                        text: qsTr("10")
                        height :30
                        width :180
                        inputMethodHints: Qt.ImhDigitsOnly
                        onTextChanged : changevalues.valuechange()
                    }
                    Text
                    {
                        text: "Main Font Size:"
                        height :30
                        width :180
                        color: "white"
                    }
                    TextField {
                        selectByMouse: true
                        id : setMainfontsize
                        text: qsTr("20")
                        height :30
                        width :180
                        inputMethodHints: Qt.ImhDigitsOnly
                        onTextChanged : changevalues.valuechange()
                    }
                    Text
                    {
                        text: "Step Size:"
                        height :30
                        width :180
                        color: "white"
                    }
                    TextField {
                        selectByMouse: true
                        id : stepsize1
                        text: qsTr("1000")
                        height :30
                        width :180
                        inputMethodHints: Qt.ImhDigitsOnly
                        onTextChanged : changevalues.valuechange()
                    }
                    Text
                    {
                        text: "Min Value Angle:"
                        height :30
                        width :180
                        color: "white"
                    }
                    TextField {
                        selectByMouse: true
                        id : minValueAngle
                        text: qsTr("-90")
                        height :30
                        width :180
                        inputMethodHints: Qt.ImhDigitsOnly
                        onTextChanged : changevalues.valuechange()
                    }
                    Text
                    {
                        text: "Max Value Angle:"
                        height :30
                        width :180
                        color: "white"
                    }
                    TextField {
                        selectByMouse: true
                        id : maxValueAngle
                        text: qsTr("180")
                        height :30
                        width :180
                        inputMethodHints: Qt.ImhDigitsOnly
                        onTextChanged : changevalues.valuechange()
                    }
                    Text
                    {
                        text: "Rotation:"
                        height :30
                        width :180
                        color: "white"
                    }
                    TextField {
                        selectByMouse: true
                        id : myRotation
                        text: qsTr("0")
                        height :30
                        width :180
                        inputMethodHints: Qt.ImhDigitsOnly
                        onTextChanged : changevalues.valuechange()
                    }
                    Text
                    {
                        text: "Full Circle?:"
                        height :30
                        width :180
                        color: "white"
                    }
                    ComboBox {
                        id: fullCirc
                        width: 180
                        height: 30
                        model : ["false","true"]
                        //initialized : "true"
                        delegate: ItemDelegate {
                            width: fullCirc.width
                            text: fullCirc.textRole ? (Array.isArray(control.model) ? modelData[control.textRole] : model[control.textRole]) : modelData
                            font.weight: fullCirc.currentIndex === index ? Font.DemiBold : Font.Normal
                            font.family: fullCirc.font.family
                            font.pixelSize: fullCirc.font.pixelSize
                            highlighted: fullCirc.highlightedIndex === index
                            hoverEnabled: fullCirc.hoverEnabled
                        }
                        Component.onCompleted: {
                            if (fullCirc.currentIndex == 0) {fullCircle = false};
                            if (fullCirc.currentIndex == 1) {fullCircle = true};
                        }
                        onCurrentIndexChanged:
                        {
                            if (fullCirc.currentIndex == 0) {fullCircle = false};
                            if (fullCirc.currentIndex == 1) {fullCircle = true};
                            changevalues.valuechange()
                        }
                    }
                    Text
                    {
                        text: "Sub Divs:"
                        height :30
                        width :180
                        color: "white"
                    }
                    TextField {
                        selectByMouse: true
                        id : subDivVal
                        text: qsTr("5")
                        height :30
                        width :180
                        inputMethodHints: Qt.ImhDigitsOnly
                        onTextChanged : changevalues.valuechange()
                    }
                    Text
                    {
                        text: "Image Location:"
                        height :30
                        width :180
                        color: "white"
                    }

                    Button {
                        id: imgLoc
                        width: 180
                        height: 30
                        text: imgSource
                        ToolTip.text: imgSource
                        onClicked: {
                            fileDialog.visible=true
                        }

                        FileDialog {
                            id: fileDialog
                            selectMultiple: false
                            title: "Please choose a file"
                            folder: shortcuts.home
                            onAccepted: {
                                console.log("You chose: " + fileDialog.fileUrls)
                                imgSource=fileDialog.fileUrls[0]
                                fileDialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                fileDialog.visible=false
                            }
                        }
                    }
                    Button {
                        id: applyChanges2
                        width: 180
                        height: 30
                        text: "Apply"
                        onClicked: {
                            changevalues.updateGaugeValues()
                        }
                    }

                }
            }

        }

        Item {
            id: discoverTab
            Rectangle {
                id: rectangle
                color: "#a9a9a9"
                anchors.fill: parent

                Grid {
                    spacing: 2
                    anchors.fill: parent
                    //                anchors.right: parent.right
                    //                anchors.bottom: parent.bottom
                    rows: 25
                    columns: 3
                    Text
                    {
                        text: "Frame Colour"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: frameColourButton
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: framecolor
                        }
                        onClicked: {
                            frameColorDialog.visible=true
                        }
                        ColorDialog {
                            id: frameColorDialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + frameColorDialog.color)
                                framecolor=frameColorDialog.color
                                frameColourText.text=frameColorDialog.color
                                frameColorDialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                frameColorDialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:frameColourText
                        text: qsTr("transparent")
                        height :30
                        width :150
                        onTextChanged : {
                            framecolor=text
                            changevalues.valuechange()
                        }
                    }
                    Text
                    {
                        text: "background Color"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: backgroundColorButton
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: resetbackroundcolor
                        }
                        onClicked: {
                            backgroundColorDialog.visible=true
                        }
                        ColorDialog {
                            id: backgroundColorDialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + backgroundColorDialog.color)
                                resetbackroundcolor=backgroundColorDialog.color
                                backgroundColorText.text=backgroundColorDialog.color
                                backgroundColorDialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                backgroundColorDialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:backgroundColorText
                        text: qsTr("transparent")
                        height :30
                        width :150
                        onTextChanged : {
                            resetbackroundcolor=text
                            changevalues.valuechange()

                        }
                    }
                    Text
                    {
                        text: "title Color"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: titleColorButton
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: titlecolor
                        }
                        onClicked: {
                            titleColorDialog.visible=true
                        }
                        ColorDialog {
                            id: titleColorDialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + titleColorDialog.color)
                                titlecolor=titleColorDialog.color
                                titleColorText.text=titleColorDialog.color
                                titleColorDialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                titleColorDialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:titleColorText
                        text: qsTr("transparent")
                        height :30
                        width :150
                        onTextChanged : {
                            titlecolor=text
                            changevalues.valuechange()

                        }
                    }
                    Text
                    {
                        text: "titleTextColor"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: titleTextColorButton
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: titletextcolor
                        }
                        onClicked: {
                            titleTextColorDialog.visible=true
                        }
                        ColorDialog {
                            id: titleTextColorDialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + titleTextColorDialog.color)
                                titletextcolor=titleTextColorDialog.color
                                titleTextColorText.text=titleTextColorDialog.color
                                titleTextColorDialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                titleTextColorDialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:titleTextColorText
                        text: qsTr("grey")
                        height :30
                        width :150
                        onTextChanged : {
                            titletextcolor=text
                            changevalues.valuechange()

                        }
                    }
                    Text
                    {
                        text: "textColor"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: textColorButton
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: textcolor
                        }
                        onClicked: {
                            textColorDialog.visible=true
                        }
                        ColorDialog {
                            id: textColorDialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + textColorDialog.color)
                                textcolor=textColorDialog.color
                                textColorText.text=textColorDialog.color
                                textColorDialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                textColorDialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:textColorText
                        text: qsTr("white")
                        height :30
                        width :150
                        onTextChanged : {
                            textcolor=text
                            changevalues.valuechange()

                        }
                    }
                    Text
                    {
                        text: "barColor"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: barColorButton
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: barcolor
                        }
                        onClicked: {
                            barColorDialog.visible=true
                        }
                        ColorDialog {
                            id: barColorDialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + barColorDialog.color)
                                barcolor=barColorDialog.color
                                barColorText.text=barColorDialog.color
                                barColorDialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                barColorDialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:barColorText
                        text: qsTr("blue")
                        height :30
                        width :150
                        onTextChanged : {
                            barcolor=text
                            changevalues.valuechange()

                        }
                    }
                    Text
                    {
                        text: "color1"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: color1Button
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: gaugecolor1
                        }
                        onClicked: {
                            color1Dialog.visible=true
                        }
                        ColorDialog {
                            id: color1Dialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + color1Dialog.color)
                                gaugecolor1=color1Dialog.color
                                color1Text.text=color1Dialog.color
                                color1Dialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                color1Dialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:color1Text
                        text: qsTr("#0066FF")
                        height :30
                        width :150
                        onTextChanged : {
                            gaugecolor1=text
                            changevalues.valuechange()

                        }
                    }
                    Text
                    {
                        text: "color2"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: color2Button
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: gaugecolor2
                        }
                        onClicked: {
                            color2Dialog.visible=true
                        }
                        ColorDialog {
                            id: color2Dialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + color2Dialog.color)
                                gaugecolor2=color2Dialog.color
                                color2Text.text=color2Dialog.color
                                color2Dialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                color2Dialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:color2Text
                        text: qsTr("#cc0000")
                        height :30
                        width :150
                        onTextChanged : {
                            gaugecolor2=text
                            changevalues.valuechange()

                        }
                    }
                    Text
                    {
                        text: "color3"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: color3Button
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: gaugecolor3
                        }
                        onClicked: {
                            color3Dialog.visible=true
                        }
                        ColorDialog {
                            id: color3Dialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + color3Dialog.color)
                                gaugecolor3=color3Dialog.color
                                color3Text.text=color3Dialog.color
                                color3Dialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                color3Dialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:color3Text
                        text: qsTr("white")
                        height :30
                        width :150
                        onTextChanged : {
                            gaugecolor3=text
                            changevalues.valuechange()

                        }
                    }

                    Text
                    {
                        text: "color4"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: color4Button
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: gaugecolor4
                        }
                        onClicked: {
                            color4Dialog.visible=true
                        }
                        ColorDialog {
                            id: color4Dialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + color4Dialog.color)
                                gaugecolor4=color4Dialog.color
                                color4Text.text=color4Dialog.color
                                color4Dialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                color4Dialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:color4Text
                        text: qsTr("#0099FF")
                        height :30
                        width :150
                        onTextChanged : {
                            gaugecolor4=text
                            changevalues.valuechange()

                        }
                    }
                    Text
                    {
                        text: "color5"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: color5Button
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: gaugecolor5
                        }
                        onClicked: {
                            color5Dialog.visible=true
                        }
                        ColorDialog {
                            id: color5Dialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + color5Dialog.color)
                                gaugecolor5=color5Dialog.color
                                color5Text.text=color5Dialog.color
                                color5Dialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                color5Dialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:color5Text
                        text: qsTr("white")
                        height :30
                        width :150
                        onTextChanged : {
                            gaugecolor5=text
                            changevalues.valuechange()

                        }
                    }
                    Text
                    {
                        text: "color6"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: color6Button
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: gaugecolor6
                        }
                        onClicked: {
                            color6Dialog.visible=true
                        }
                        ColorDialog {
                            id: color6Dialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + color6Dialog.color)
                                gaugecolor6=color6Dialog.color
                                color6Text.text=color6Dialog.color
                                color6Dialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                color6Dialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:color6Text
                        text: qsTr("blue")
                        height :30
                        width :150
                        onTextChanged : {
                            gaugecolor6=text
                            changevalues.valuechange()

                        }
                    }
                    Text
                    {
                        text: "color7"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: color7Button
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: gaugecolor7
                        }
                        onClicked: {
                            color7Dialog.visible=true
                        }
                        ColorDialog {
                            id: color7Dialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + color7Dialog.color)
                                gaugecolor7=color7Dialog.color
                                color7Text.text=color7Dialog.color
                                color7Dialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                color7Dialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:color7Text
                        text: qsTr("black")
                        height :30
                        width :150
                        onTextChanged : {
                            gaugecolor7=text
                            changevalues.valuechange()

                        }
                    }
                    Text
                    {
                        text: "color8"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: color8Button
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: gaugecolor8
                        }
                        onClicked: {
                            color8Dialog.visible=true
                        }
                        ColorDialog {
                            id: color8Dialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + color8Dialog.color)
                                gaugecolor8=color8Dialog.color
                                color8Text.text=color8Dialog.color
                                color8Dialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                color8Dialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:color8Text
                        text: qsTr("transparent")
                        height :30
                        width :150
                        onTextChanged : {
                            gaugecolor8=text
                            changevalues.valuechange()

                        }
                    }
                    Text
                    {
                        text: "color9"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: color9Button
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: gaugecolor9
                        }
                        onClicked: {
                            color9Dialog.visible=true
                        }
                        ColorDialog {
                            id: color9Dialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + color9Dialog.color)
                                gaugecolor9=color9Dialog.color
                                color9Text.text=color9Dialog.color
                                color9Dialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                color9Dialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:color9Text
                        text: qsTr("transparent")
                        height :30
                        width :150
                        onTextChanged : {
                            gaugecolor9=text
                            changevalues.valuechange()

                        }
                    }
                    Text
                    {
                        text: "shadecolor1"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: shadecolor1Button
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: shadecolor1
                        }
                        onClicked: {
                            shadecolor1Dialog.visible=true
                        }
                        ColorDialog {
                            id: shadecolor1Dialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + shadecolor1Dialog.color)
                                shadecolor1=shadecolor1Dialog.color
                                shadecolor1Text.text=shadecolor1Dialog.color
                                shadecolor1Dialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                shadecolor1Dialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:shadecolor1Text
                        text: qsTr("#ffffff")
                        height :30
                        width :150
                        onTextChanged : {
                            shadecolor1=text
                            changevalues.valuechange()

                        }
                    }
                    Text
                    {
                        text: "shadecolor2"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: shadecolor2Button
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: shadecolor2
                        }
                        onClicked: {
                            shadecolor2Dialog.visible=true
                        }
                        ColorDialog {
                            id: shadecolor2Dialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + shadecolor2Dialog.color)
                                shadecolor2=shadecolor2Dialog.color
                                shadecolor2Text.text=shadecolor2Dialog.color
                                shadecolor2Dialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                shadecolor2Dialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:shadecolor2Text
                        text: qsTr("#e96448")
                        height :30
                        width :150
                        onTextChanged : {
                            shadecolor2=text
                            changevalues.valuechange()

                        }
                    }
                    Text
                    {
                        text: "shadecolor3"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: shadecolor3Button
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: shadecolor3
                        }
                        onClicked: {
                            shadecolor3Dialog.visible=true
                        }
                        ColorDialog {
                            id: shadecolor3Dialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + shadecolor3Dialog.color)
                                shadecolor3=shadecolor3Dialog.color
                                shadecolor3Text.text=shadecolor3Dialog.color
                                shadecolor3Dialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                shadecolor3Dialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:shadecolor3Text
                        text: qsTr("#f22900")
                        height :30
                        width :150
                        onTextChanged : {
                            shadecolor3=text
                            changevalues.valuechange()

                        }
                    }
                    Text
                    {
                        text: "shadecolor4"
                        height :30
                        width :110
                        color: "white"
                    }
                    Button {
                        id: shadecolor4Button
                        width: 110
                        height: 30
                        text: "Click"
                        background: Rectangle {
                            color: shadecolor4
                        }
                        onClicked: {
                            shadecolor4Dialog.visible=true
                        }
                        ColorDialog {
                            id: shadecolor4Dialog
                            title: "Please choose a color"
                            onAccepted: {
                                console.log("You chose: " + shadecolor4Dialog.color)
                                shadecolor4=shadecolor4Dialog.color
                                shadecolor4Text.text=shadecolor4Dialog.color
                                shadecolor4Dialog.visible=false
                                changevalues.valuechange()
                            }
                            onRejected: {
                                console.log("Canceled")
                                shadecolor4Dialog.visible=false
                            }
                        }
                    }
                    TextField {
                        selectByMouse: true
                        id:shadecolor4Text
                        text: qsTr("transparent")
                        height :30
                        width :150
                        onTextChanged : {
                            shadecolor4=text
                            changevalues.valuechange()

                        }
                    }
                    Button {
                        id: applyChanges3
                        width: 110
                        height: 30
                        text: "Apply"
                        onClicked: {
                            changevalues.updateGaugeValues()
                        }
                    }

                }
            }

        }


    }


    Rectangle{
        id:appwindow
        width: 1024
        height: 600
        color: "black"
        Item
        {
            id: switchgauge
            function updatevalues(){
                switch (gaugeselect.currentIndex) {
                case 0:
                    mainwindow.tempgauge = gauge1
                    container.setValuesWhenClicked()

                    /*
                  gwidth.text = gauge1.width
                  gheight.text = gauge1.height
                  title.text = gauge1.title
                  maxval.text = gauge1.maxvalue
                  if (gauge1.vertgaugevisible == true ) {vertvis.currentIndex = 1 }
                  else {vertvis.currentIndex = 0 }
                      //horizvis
                  //vertvisble  = gauge1.vertgaugevisible
                  // = gauge1.horigaugevisible = horizvisible
                  // = gauge1.secvaluevisible = secvisible
                  lowwarn.text = gauge1.warnvaluelow
                  highwarn.text = gauge1.warnvaluehigh
                  units.text = gauge1.mainunit*/
                    break;

                case 1:

                    mainwindow.tempgauge = gauge2
                    container.setValuesWhenClicked()
                    break;

                case 2:
                    mainwindow.tempgauge = gauge3
                    container.setValuesWhenClicked()

                    break;

                case 3:
                    mainwindow.tempgauge = gauge4
                    container.setValuesWhenClicked()

                    break;

                case 4:

                    mainwindow.tempgauge = gauge5
                    container.setValuesWhenClicked()
                    break;

                case 5:

                    mainwindow.tempgauge = gauge6
                    container.setValuesWhenClicked()
                    break;

                case 6:

                    mainwindow.tempgauge = gauge7
                    container.setValuesWhenClicked()

                    break;

                case 7:
                    mainwindow.tempgauge = gauge8
                    container.setValuesWhenClicked()

                    break;

                case 8:

                    mainwindow.tempgauge = gauge9
                    container.setValuesWhenClicked()
                    break;

                case 9:

                    mainwindow.tempgauge = gauge10
                    container.setValuesWhenClicked()
                    break;

                case 10:
                    mainwindow.tempgauge = gauge11
                    container.setValuesWhenClicked()

                    break;

                case 11:
                    mainwindow.tempgauge = gauge12
                    container.setValuesWhenClicked()

                    break;

                case 12:

                    mainwindow.tempgauge = gauge13
                    container.setValuesWhenClicked()
                    break;

                case 13:

                    mainwindow.tempgauge = gauge14
                    container.setValuesWhenClicked()
                    break;

                case 14:
                    mainwindow.tempgauge = gauge15
                    container.setValuesWhenClicked()

                    break;

                case 15:
                    mainwindow.tempgauge = gauge16
                    container.setValuesWhenClicked()

                    break;

                case 16:
                    mainwindow.tempgauge = gauge17
                    container.setValuesWhenClicked()

                    break;

                case 17:
                    mainwindow.tempgauge = gauge18
                    container.setValuesWhenClicked()

                    break;

                case 18:
                    mainwindow.tempgauge = gauge19
                    container.setValuesWhenClicked()

                    break;

                case 19:
                    mainwindow.tempgauge = gauge20
                    container.setValuesWhenClicked()

                    break;

                }
            }
        }
        Item
        {
            id: changevalues
            function valuechange(){
                if (refreshing){
                    //                    updateGaugeValues()
                }else{
                    updateGaugeValues()

                }
            }

            function updateGaugeValues(){
                tempgauge.width = gwidth.text
                tempgauge.height = gheight.text
                tempgauge.title = title.text
                tempgauge.maxvalue = maxval.text
                tempgauge.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                tempgauge.vertgaugevisible = vertvisble
                tempgauge.horigaugevisible = horizvisible
                tempgauge.secvaluevisible = secvisible
                tempgauge.warnvaluelow = lowwarn.text
                tempgauge.warnvaluehigh = highwarn.text
                tempgauge.mainunit = units.text
                tempgauge.titlecolor = titlecolor
                tempgauge.framecolor = framecolor
                tempgauge.resetbackroundcolor = resetbackroundcolor
                tempgauge.resettitlecolor = resettitlecolor
                tempgauge.textcolor = textcolor
                tempgauge.titlecolor = titlecolor
                tempgauge.titletextcolor = titletextcolor
                tempgauge.barcolor = barcolor
                tempgauge.titlefontsize = setTitlefontsize.text
                tempgauge.mainfontsize = setMainfontsize.text
                tempgauge.gaugecolor1 = gaugecolor1
                tempgauge.gaugecolor2 = gaugecolor2
                tempgauge.gaugecolor3 = gaugecolor3
                tempgauge.gaugecolor4 = gaugecolor4
                tempgauge.gaugecolor5 = gaugecolor5
                tempgauge.gaugecolor6 = gaugecolor6
                tempgauge.gaugecolor7 = gaugecolor7
                tempgauge.gaugecolor8 = gaugecolor8
                tempgauge.gaugecolor9 = gaugecolor9
                tempgauge.shadecolor1 = shadecolor1
                tempgauge.shadecolor2 = shadecolor2
                tempgauge.shadecolor3 = shadecolor3
                tempgauge.shadecolor4 = shadecolor4
                tempgauge.stepsize = stepsize1.text
                tempgauge.minValueAngle = minValueAngle.text
                tempgauge.maxValueAngle = maxValueAngle.text
                tempgauge.rotation = myRotation.text
                tempgauge.imgSource = imgSource
                tempgauge.fullCirc = fullCircle
                tempgauge.subDivVal = subDivVal.text
                tempgauge.z = zVal.text
                tempgauge.x = gx.text
                tempgauge.y = gy.text
                switch (gaugeselect.currentIndex) {
                case 0:
                    gauge1 = tempgauge
                    gauge1.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    break;
                case 1:
                    gauge2 = tempgauge
                    gauge2.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    break;
                case 2:
                    gauge3 = tempgauge
                    gauge3.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    break;
                case 3:
                    gauge4 = tempgauge
                    break;
                case 4:
                    gauge5 = tempgauge
                    break;
                case 5:
                    gauge6 = tempgauge
                    break;
                case 6:
                    gauge7 = tempgauge
                    break;
                case 7:
                    gauge8 = tempgauge
                    break;
                case 8:
                    gauge9 = tempgauge
                    break;
                case 9:
                    gauge10 = tempgauge
                    break;
                case 10:
                    gauge11 = tempgauge
                    break;
                case 11:
                    gauge12 = tempgauge
                    break;
                case 12:
                    gauge13 = tempgauge
                    break;
                case 13:
                    gauge14 = tempgauge
                    break;
                case 14:
                    gauge15 = tempgauge
                    break;
                case 15:
                    gauge16 = tempgauge
                    break;
                case 16:
                    gauge17 = tempgauge
                    break;
                case 17:
                    gauge18 = tempgauge
                    break;
                case 18:
                    gauge19 = tempgauge
                    break;
                case 19:
                    gauge20 = tempgauge
                    break;
                    //                    gauge1.width = gwidth.text
                    //                    gauge1.height = gheight.text
                    //                    gauge1.title = title.text
                    //                    gauge1.maxvalue = maxval.text
                    //                    gauge1.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge1.vertgaugevisible = vertvisble
                    //                    gauge1.horigaugevisible = horizvisible
                    //                    gauge1.secvaluevisible = secvisible
                    //                    gauge1.warnvaluelow = lowwarn.text
                    //                    gauge1.warnvaluehigh = highwarn.text
                    //                    gauge1.mainunit = units.text
                    //                    gauge1.titlecolor = titlecolor
                    //                    gauge1.framecolor = framecolor
                    //                    gauge1.resetbackroundcolor = resetbackroundcolor
                    //                    gauge1.resettitlecolor = resettitlecolor
                    //                    gauge1.textcolor = textcolor
                    //                    gauge1.titlecolor = titlecolor
                    //                    gauge1.titletextcolor = titletextcolor
                    //                    gauge1.barcolor = barcolor
                    //                    gauge1.titlefontsize = setTitlefontsize.value
                    //                    gauge1.mainfontsize = setMainfontsize.value
                    //                    gauge1.gaugecolor1 = gaugecolor1
                    //                    gauge1.gaugecolor2 = gaugecolor2
                    //                    gauge1.gaugecolor3 = gaugecolor3
                    //                    gauge1.gaugecolor4 = gaugecolor4
                    //                    gauge1.gaugecolor5 = gaugecolor5
                    //                    gauge1.gaugecolor6 = gaugecolor6
                    //                    gauge1.gaugecolor7 = gaugecolor7
                    //                    gauge1.gaugecolor8 = gaugecolor8
                    //                    gauge1.gaugecolor9 = gaugecolor9
                    //                    gauge1.shadecolor1 = shadecolor1
                    //                    gauge1.shadecolor2 = shadecolor2
                    //                    gauge1.shadecolor3 = shadecolor3
                    //                    gauge1.shadecolor4 = shadecolor4
                    //                    gauge1.stepsize = stepsize1.value
                    //                    gauge1.minValueAngle = minValueAngle.value
                    //                    gauge1.maxValueAngle = maxValueAngle.value
                    //                    gauge1.rotation = myRotation.value
                    //                    gauge1.imgSource = imgSource
                    //                    gauge1.fullCirc = fullCircle
                    //                    gauge1.subDivVal = subDivVal.value
                    //                    gauge1.z = zVal.text
                    //                    gauge1.x = gx.text
                    //                    gauge1.y = gy.text
                    //                    break;

                    //                case 1:

                    //                    gauge2.width = gwidth.text
                    //                    gauge2.height = gheight.text
                    //                    gauge2.title = title.text
                    //                    gauge2.maxvalue = maxval.text
                    //                    gauge2.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge2.vertgaugevisible = vertvisble
                    //                    gauge2.horigaugevisible = horizvisible
                    //                    gauge2.secvaluevisible = secvisible
                    //                    gauge2.warnvaluelow = lowwarn.text
                    //                    gauge2.warnvaluehigh = highwarn.text
                    //                    gauge2.mainunit = units.text
                    //                    gauge2.titlecolor = titlecolor
                    //                    gauge2.framecolor = framecolor
                    //                    gauge2.resetbackroundcolor = resetbackroundcolor
                    //                    gauge2.resettitlecolor = resettitlecolor
                    //                    gauge2.textcolor = textcolor
                    //                    gauge2.titlecolor = titlecolor
                    //                    gauge2.titletextcolor = titletextcolor
                    //                    gauge2.barcolor = barcolor
                    //                    gauge2.titlefontsize = setTitlefontsize.value
                    //                    gauge2.mainfontsize = setMainfontsize.value
                    //                    gauge2.gaugecolor1 = gaugecolor1
                    //                    gauge2.gaugecolor2 = gaugecolor2
                    //                    gauge2.gaugecolor3 = gaugecolor3
                    //                    gauge2.gaugecolor4 = gaugecolor4
                    //                    gauge2.gaugecolor5 = gaugecolor5
                    //                    gauge2.gaugecolor6 = gaugecolor6
                    //                    gauge2.gaugecolor7 = gaugecolor7
                    //                    gauge2.gaugecolor8 = gaugecolor8
                    //                    gauge2.gaugecolor9 = gaugecolor9
                    //                    gauge2.shadecolor1 = shadecolor1
                    //                    gauge2.shadecolor2 = shadecolor2
                    //                    gauge2.shadecolor3 = shadecolor3
                    //                    gauge2.shadecolor4 = shadecolor4
                    //                    gauge2.stepsize = stepsize1.value
                    //                    gauge2.minValueAngle = minValueAngle.value
                    //                    gauge2.maxValueAngle = maxValueAngle.value
                    //                    gauge2.rotation = myRotation.value
                    //                    gauge2.imgSource = imgSource
                    //                    gauge2.fullCirc = fullCircle
                    //                    gauge2.subDivVal = subDivVal.value
                    //                    gauge2.z = zVal.text
                    //                    break;

                    //                case 2:

                    //                    gauge3.width = gwidth.text
                    //                    gauge3.height = gheight.text
                    //                    gauge3.title = title.text
                    //                    gauge3.maxvalue = maxval.text
                    //                    gauge3.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge3.vertgaugevisible = vertvisble
                    //                    gauge3.horigaugevisible = horizvisible
                    //                    gauge3.secvaluevisible = secvisible
                    //                    gauge3.warnvaluelow = lowwarn.text
                    //                    gauge3.warnvaluehigh = highwarn.text
                    //                    gauge3.mainunit = units.text
                    //                    gauge3.titlecolor = titlecolor
                    //                    gauge3.framecolor = framecolor
                    //                    gauge3.resetbackroundcolor = resetbackroundcolor
                    //                    gauge3.resettitlecolor = resettitlecolor
                    //                    gauge3.textcolor = textcolor
                    //                    gauge3.titlecolor = titlecolor
                    //                    gauge3.titletextcolor = titletextcolor
                    //                    gauge3.barcolor = barcolor
                    //                    gauge3.titlefontsize = setTitlefontsize.value
                    //                    gauge3.mainfontsize = setMainfontsize.value
                    //                    gauge3.gaugecolor1 = gaugecolor1
                    //                    gauge3.gaugecolor2 = gaugecolor2
                    //                    gauge3.gaugecolor3 = gaugecolor3
                    //                    gauge3.gaugecolor4 = gaugecolor4
                    //                    gauge3.gaugecolor5 = gaugecolor5
                    //                    gauge3.gaugecolor6 = gaugecolor6
                    //                    gauge3.gaugecolor7 = gaugecolor7
                    //                    gauge3.gaugecolor8 = gaugecolor8
                    //                    gauge3.gaugecolor9 = gaugecolor9
                    //                    gauge3.shadecolor1 = shadecolor1
                    //                    gauge3.shadecolor2 = shadecolor2
                    //                    gauge3.shadecolor3 = shadecolor3
                    //                    gauge3.shadecolor4 = shadecolor4
                    //                    gauge3.stepsize = stepsize1.value
                    //                    gauge3.minValueAngle = minValueAngle.value
                    //                    gauge3.maxValueAngle = maxValueAngle.value
                    //                    gauge3.rotation = myRotation.value
                    //                    gauge3.imgSource = imgSource
                    //                    gauge3.fullCirc = fullCircle
                    //                    gauge3.subDivVal = subDivVal.value
                    //                    gauge3.z = zVal.text
                    //                    break;

                    //                case 3:

                    //                    gauge4.width = gwidth.text
                    //                    gauge4.height = gheight.text
                    //                    gauge4.title = title.text
                    //                    gauge4.maxvalue = maxval.text
                    //                    gauge4.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge4.vertgaugevisible = vertvisble
                    //                    gauge4.horigaugevisible = horizvisible
                    //                    gauge4.secvaluevisible = secvisible
                    //                    gauge4.warnvaluelow = lowwarn.text
                    //                    gauge4.warnvaluehigh = highwarn.text
                    //                    gauge4.mainunit = units.text
                    //                    gauge4.titlecolor = titlecolor
                    //                    gauge4.framecolor = framecolor
                    //                    gauge4.resetbackroundcolor = resetbackroundcolor
                    //                    gauge4.resettitlecolor = resettitlecolor
                    //                    gauge4.textcolor = textcolor
                    //                    gauge4.titlecolor = titlecolor
                    //                    gauge4.titletextcolor = titletextcolor
                    //                    gauge4.barcolor = barcolor
                    //                    gauge4.titlefontsize = setTitlefontsize.value
                    //                    gauge4.mainfontsize = setMainfontsize.value
                    //                    gauge4.gaugecolor1 = gaugecolor1
                    //                    gauge4.gaugecolor2 = gaugecolor2
                    //                    gauge4.gaugecolor3 = gaugecolor3
                    //                    gauge4.gaugecolor4 = gaugecolor4
                    //                    gauge4.gaugecolor5 = gaugecolor5
                    //                    gauge4.gaugecolor6 = gaugecolor6
                    //                    gauge4.gaugecolor7 = gaugecolor7
                    //                    gauge4.gaugecolor8 = gaugecolor8
                    //                    gauge4.gaugecolor9 = gaugecolor9
                    //                    gauge4.shadecolor1 = shadecolor1
                    //                    gauge4.shadecolor2 = shadecolor2
                    //                    gauge4.shadecolor3 = shadecolor3
                    //                    gauge4.shadecolor4 = shadecolor4
                    //                    gauge4.stepsize = stepsize1.value
                    //                    gauge4.minValueAngle = minValueAngle.value
                    //                    gauge4.maxValueAngle = maxValueAngle.value
                    //                    gauge4.rotation = myRotation.value
                    //                    gauge4.imgSource = imgSource
                    //                    gauge4.fullCirc = fullCircle
                    //                    gauge4.subDivVal = subDivVal.value
                    //                    gauge4.z = zVal.text
                    //                    break;

                    //                case 4:
                    //                    gauge5.width = gwidth.text
                    //                    gauge5.height = gheight.text
                    //                    gauge5.title = title.text
                    //                    gauge5.maxvalue = maxval.text
                    //                    gauge5.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge5.vertgaugevisible = vertvisble
                    //                    gauge5.horigaugevisible = horizvisible
                    //                    gauge5.secvaluevisible = secvisible
                    //                    gauge5.warnvaluelow = lowwarn.text
                    //                    gauge5.warnvaluehigh = highwarn.text
                    //                    gauge5.mainunit = units.text
                    //                    gauge5.titlecolor = titlecolor
                    //                    gauge5.framecolor = framecolor
                    //                    gauge5.resetbackroundcolor = resetbackroundcolor
                    //                    gauge5.resettitlecolor = resettitlecolor
                    //                    gauge5.textcolor = textcolor
                    //                    gauge5.titlecolor = titlecolor
                    //                    gauge5.titletextcolor = titletextcolor
                    //                    gauge5.barcolor = barcolor
                    //                    gauge5.titlefontsize = setTitlefontsize.value
                    //                    gauge5.mainfontsize = setMainfontsize.value
                    //                    gauge5.gaugecolor1 = gaugecolor1
                    //                    gauge5.gaugecolor2 = gaugecolor2
                    //                    gauge5.gaugecolor3 = gaugecolor3
                    //                    gauge5.gaugecolor4 = gaugecolor4
                    //                    gauge5.gaugecolor5 = gaugecolor5
                    //                    gauge5.gaugecolor6 = gaugecolor6
                    //                    gauge5.gaugecolor7 = gaugecolor7
                    //                    gauge5.gaugecolor8 = gaugecolor8
                    //                    gauge5.gaugecolor9 = gaugecolor9
                    //                    gauge5.shadecolor1 = shadecolor1
                    //                    gauge5.shadecolor2 = shadecolor2
                    //                    gauge5.shadecolor3 = shadecolor3
                    //                    gauge5.shadecolor4 = shadecolor4
                    //                    gauge5.stepsize = stepsize1.value
                    //                    gauge5.minValueAngle = minValueAngle.value
                    //                    gauge5.maxValueAngle = maxValueAngle.value
                    //                    gauge5.rotation = myRotation.value
                    //                    gauge5.imgSource = imgSource
                    //                    gauge5.fullCirc = fullCircle
                    //                    gauge5.subDivVal = subDivVal.value
                    //                    gauge5.z = zVal.text
                    //                    break;

                    //                case 5:

                    //                    gauge6.width = gwidth.text
                    //                    gauge6.height = gheight.text
                    //                    gauge6.title = title.text
                    //                    gauge6.maxvalue = maxval.text
                    //                    gauge6.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge6.vertgaugevisible = vertvisble
                    //                    gauge6.horigaugevisible = horizvisible
                    //                    gauge6.secvaluevisible = secvisible
                    //                    gauge6.warnvaluelow = lowwarn.text
                    //                    gauge6.warnvaluehigh = highwarn.text
                    //                    gauge6.mainunit = units.text
                    //                    gauge6.titlecolor = titlecolor
                    //                    gauge6.framecolor = framecolor
                    //                    gauge6.resetbackroundcolor = resetbackroundcolor
                    //                    gauge6.resettitlecolor = resettitlecolor
                    //                    gauge6.textcolor = textcolor
                    //                    gauge6.titlecolor = titlecolor
                    //                    gauge6.titletextcolor = titletextcolor
                    //                    gauge6.barcolor = barcolor
                    //                    gauge6.titlefontsize = setTitlefontsize.value
                    //                    gauge6.mainfontsize = setMainfontsize.value
                    //                    gauge6.gaugecolor1 = gaugecolor1
                    //                    gauge6.gaugecolor2 = gaugecolor2
                    //                    gauge6.gaugecolor3 = gaugecolor3
                    //                    gauge6.gaugecolor4 = gaugecolor4
                    //                    gauge6.gaugecolor5 = gaugecolor5
                    //                    gauge6.gaugecolor6 = gaugecolor6
                    //                    gauge6.gaugecolor7 = gaugecolor7
                    //                    gauge6.gaugecolor8 = gaugecolor8
                    //                    gauge6.gaugecolor9 = gaugecolor9
                    //                    gauge6.shadecolor1 = shadecolor1
                    //                    gauge6.shadecolor2 = shadecolor2
                    //                    gauge6.shadecolor3 = shadecolor3
                    //                    gauge6.shadecolor4 = shadecolor4
                    //                    gauge6.stepsize = stepsize1.value
                    //                    gauge6.minValueAngle = minValueAngle.value
                    //                    gauge6.maxValueAngle = maxValueAngle.value
                    //                    gauge6.rotation = myRotation.value
                    //                    gauge6.imgSource = imgSource
                    //                    gauge6.fullCirc = fullCircle
                    //                    gauge6.subDivVal = subDivVal.value
                    //                    gauge6.z = zVal.text
                    //                    break;

                    //                case 6:

                    //                    gauge7.width = gwidth.text
                    //                    gauge7.height = gheight.text
                    //                    gauge7.title = title.text
                    //                    gauge7.maxvalue = maxval.text
                    //                    gauge7.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge7.vertgaugevisible = vertvisble
                    //                    gauge7.horigaugevisible = horizvisible
                    //                    gauge7.secvaluevisible = secvisible
                    //                    gauge7.warnvaluelow = lowwarn.text
                    //                    gauge7.warnvaluehigh = highwarn.text
                    //                    gauge7.mainunit = units.text
                    //                    gauge7.titlecolor = titlecolor
                    //                    gauge7.framecolor = framecolor
                    //                    gauge7.resetbackroundcolor = resetbackroundcolor
                    //                    gauge7.resettitlecolor = resettitlecolor
                    //                    gauge7.textcolor = textcolor
                    //                    gauge7.titlecolor = titlecolor
                    //                    gauge7.titletextcolor = titletextcolor
                    //                    gauge7.barcolor = barcolor
                    //                    gauge7.titlefontsize = setTitlefontsize.value
                    //                    gauge7.mainfontsize = setMainfontsize.value
                    //                    gauge7.gaugecolor1 = gaugecolor1
                    //                    gauge7.gaugecolor2 = gaugecolor2
                    //                    gauge7.gaugecolor3 = gaugecolor3
                    //                    gauge7.gaugecolor4 = gaugecolor4
                    //                    gauge7.gaugecolor5 = gaugecolor5
                    //                    gauge7.gaugecolor6 = gaugecolor6
                    //                    gauge7.gaugecolor7 = gaugecolor7
                    //                    gauge7.gaugecolor8 = gaugecolor8
                    //                    gauge7.gaugecolor9 = gaugecolor9
                    //                    gauge7.shadecolor1 = shadecolor1
                    //                    gauge7.shadecolor2 = shadecolor2
                    //                    gauge7.shadecolor3 = shadecolor3
                    //                    gauge7.shadecolor4 = shadecolor4
                    //                    gauge7.stepsize = stepsize1.value
                    //                    gauge7.minValueAngle = minValueAngle.value
                    //                    gauge7.maxValueAngle = maxValueAngle.value
                    //                    gauge7.rotation = myRotation.value
                    //                    gauge7.imgSource = imgSource
                    //                    gauge7.fullCirc = fullCircle
                    //                    gauge7.subDivVal = subDivVal.value
                    //                    gauge7.z = zVal.text
                    //                    break;

                    //                case 7:

                    //                    gauge8.width = gwidth.text
                    //                    gauge8.height = gheight.text
                    //                    gauge8.title = title.text
                    //                    gauge8.maxvalue = maxval.text
                    //                    gauge8.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge8.vertgaugevisible = vertvisble
                    //                    gauge8.horigaugevisible = horizvisible
                    //                    gauge8.secvaluevisible = secvisible
                    //                    gauge8.warnvaluelow = lowwarn.text
                    //                    gauge8.warnvaluehigh = highwarn.text
                    //                    gauge8.mainunit = units.text
                    //                    gauge8.titlecolor = titlecolor
                    //                    gauge8.framecolor = framecolor
                    //                    gauge8.resetbackroundcolor = resetbackroundcolor
                    //                    gauge8.resettitlecolor = resettitlecolor
                    //                    gauge8.textcolor = textcolor
                    //                    gauge8.titlecolor = titlecolor
                    //                    gauge8.titletextcolor = titletextcolor
                    //                    gauge8.barcolor = barcolor
                    //                    gauge8.titlefontsize = setTitlefontsize.value
                    //                    gauge8.mainfontsize = setMainfontsize.value
                    //                    gauge8.gaugecolor1 = gaugecolor1
                    //                    gauge8.gaugecolor2 = gaugecolor2
                    //                    gauge8.gaugecolor3 = gaugecolor3
                    //                    gauge8.gaugecolor4 = gaugecolor4
                    //                    gauge8.gaugecolor5 = gaugecolor5
                    //                    gauge8.gaugecolor6 = gaugecolor6
                    //                    gauge8.gaugecolor7 = gaugecolor7
                    //                    gauge8.gaugecolor8 = gaugecolor8
                    //                    gauge8.gaugecolor9 = gaugecolor9
                    //                    gauge8.shadecolor1 = shadecolor1
                    //                    gauge8.shadecolor2 = shadecolor2
                    //                    gauge8.shadecolor3 = shadecolor3
                    //                    gauge8.shadecolor4 = shadecolor4
                    //                    gauge8.stepsize = stepsize1.value
                    //                    gauge8.minValueAngle = minValueAngle.value
                    //                    gauge8.maxValueAngle = maxValueAngle.value
                    //                    gauge8.rotation = myRotation.value
                    //                    gauge8.imgSource = imgSource
                    //                    gauge8.fullCirc = fullCircle
                    //                    gauge8.subDivVal = subDivVal.value
                    //                    gauge8.z = zVal.text
                    //                    break

                    //                case 8:

                    //                    gauge9.width = gwidth.text
                    //                    gauge9.height = gheight.text
                    //                    gauge9.title = title.text
                    //                    gauge9.maxvalue = maxval.text
                    //                    gauge9.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge9.vertgaugevisible = vertvisble
                    //                    gauge9.horigaugevisible = horizvisible
                    //                    gauge9.secvaluevisible = secvisible
                    //                    gauge9.warnvaluelow = lowwarn.text
                    //                    gauge9.warnvaluehigh = highwarn.text
                    //                    gauge9.mainunit = units.text
                    //                    gauge9.titlecolor = titlecolor
                    //                    gauge9.framecolor = framecolor
                    //                    gauge9.resetbackroundcolor = resetbackroundcolor
                    //                    gauge9.resettitlecolor = resettitlecolor
                    //                    gauge9.textcolor = textcolor
                    //                    gauge9.titlecolor = titlecolor
                    //                    gauge9.titletextcolor = titletextcolor
                    //                    gauge9.barcolor = barcolor
                    //                    gauge9.titlefontsize = setTitlefontsize.value
                    //                    gauge9.mainfontsize = setMainfontsize.value
                    //                    gauge9.gaugecolor1 = gaugecolor1
                    //                    gauge9.gaugecolor2 = gaugecolor2
                    //                    gauge9.gaugecolor3 = gaugecolor3
                    //                    gauge9.gaugecolor4 = gaugecolor4
                    //                    gauge9.gaugecolor5 = gaugecolor5
                    //                    gauge9.gaugecolor6 = gaugecolor6
                    //                    gauge9.gaugecolor7 = gaugecolor7
                    //                    gauge9.gaugecolor8 = gaugecolor8
                    //                    gauge9.gaugecolor9 = gaugecolor9
                    //                    gauge9.shadecolor1 = shadecolor1
                    //                    gauge9.shadecolor2 = shadecolor2
                    //                    gauge9.shadecolor3 = shadecolor3
                    //                    gauge9.shadecolor4 = shadecolor4
                    //                    gauge9.stepsize = stepsize1.value
                    //                    gauge9.minValueAngle = minValueAngle.value
                    //                    gauge9.maxValueAngle = maxValueAngle.value
                    //                    gauge9.rotation = myRotation.value
                    //                    gauge9.imgSource = imgSource
                    //                    gauge9.fullCirc = fullCircle
                    //                    gauge9.subDivVal = subDivVal.value
                    //                    gauge9.z = zVal.text
                    //                    break;

                    //                case 9:

                    //                    gauge10.width = gwidth.text
                    //                    gauge10.height = gheight.text
                    //                    gauge10.title = title.text
                    //                    gauge10.maxvalue = maxval.text
                    //                    gauge10.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge10.vertgaugevisible = vertvisble
                    //                    gauge10.horigaugevisible = horizvisible
                    //                    gauge10.secvaluevisible = secvisible
                    //                    gauge10.warnvaluelow = lowwarn.text
                    //                    gauge10.warnvaluehigh = highwarn.text
                    //                    gauge10.mainunit = units.text
                    //                    gauge10.titlecolor = titlecolor
                    //                    gauge10.framecolor = framecolor
                    //                    gauge10.resetbackroundcolor = resetbackroundcolor
                    //                    gauge10.resettitlecolor = resettitlecolor
                    //                    gauge10.textcolor = textcolor
                    //                    gauge10.titlecolor = titlecolor
                    //                    gauge10.titletextcolor = titletextcolor
                    //                    gauge10.barcolor = barcolor
                    //                    gauge10.titlefontsize = setTitlefontsize.value
                    //                    gauge10.mainfontsize = setMainfontsize.value
                    //                    gauge10.gaugecolor1 = gaugecolor1
                    //                    gauge10.gaugecolor2 = gaugecolor2
                    //                    gauge10.gaugecolor3 = gaugecolor3
                    //                    gauge10.gaugecolor4 = gaugecolor4
                    //                    gauge10.gaugecolor5 = gaugecolor5
                    //                    gauge10.gaugecolor6 = gaugecolor6
                    //                    gauge10.gaugecolor7 = gaugecolor7
                    //                    gauge10.gaugecolor8 = gaugecolor8
                    //                    gauge10.gaugecolor9 = gaugecolor9
                    //                    gauge10.shadecolor1 = shadecolor1
                    //                    gauge10.shadecolor2 = shadecolor2
                    //                    gauge10.shadecolor3 = shadecolor3
                    //                    gauge10.shadecolor4 = shadecolor4
                    //                    gauge10.stepsize = stepsize1.value
                    //                    gauge10.minValueAngle = minValueAngle.value
                    //                    gauge10.maxValueAngle = maxValueAngle.value
                    //                    gauge10.rotation = myRotation.value
                    //                    gauge10.imgSource = imgSource
                    //                    gauge10.fullCirc = fullCircle
                    //                    gauge10.subDivVal = subDivVal.value
                    //                    gauge10.z = zVal.text
                    //                    break;

                    //                case 10:

                    //                    gauge11.width = gwidth.text
                    //                    gauge11.height = gheight.text
                    //                    gauge11.title = title.text
                    //                    gauge11.maxvalue = maxval.text
                    //                    gauge11.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge11.vertgaugevisible = vertvisble
                    //                    gauge11.horigaugevisible = horizvisible
                    //                    gauge11.secvaluevisible = secvisible
                    //                    gauge11.warnvaluelow = lowwarn.text
                    //                    gauge11.warnvaluehigh = highwarn.text
                    //                    gauge11.mainunit = units.text
                    //                    gauge11.titlecolor = titlecolor
                    //                    gauge11.framecolor = framecolor
                    //                    gauge11.resetbackroundcolor = resetbackroundcolor
                    //                    gauge11.resettitlecolor = resettitlecolor
                    //                    gauge11.textcolor = textcolor
                    //                    gauge11.titlecolor = titlecolor
                    //                    gauge11.titletextcolor = titletextcolor
                    //                    gauge11.barcolor = barcolor
                    //                    gauge11.titlefontsize = setTitlefontsize.value
                    //                    gauge11.mainfontsize = setMainfontsize.value
                    //                    gauge11.gaugecolor1 = gaugecolor1
                    //                    gauge11.gaugecolor2 = gaugecolor2
                    //                    gauge11.gaugecolor3 = gaugecolor3
                    //                    gauge11.gaugecolor4 = gaugecolor4
                    //                    gauge11.gaugecolor5 = gaugecolor5
                    //                    gauge11.gaugecolor6 = gaugecolor6
                    //                    gauge11.gaugecolor7 = gaugecolor7
                    //                    gauge11.gaugecolor8 = gaugecolor8
                    //                    gauge11.gaugecolor9 = gaugecolor9
                    //                    gauge11.shadecolor1 = shadecolor1
                    //                    gauge11.shadecolor2 = shadecolor2
                    //                    gauge11.shadecolor3 = shadecolor3
                    //                    gauge11.shadecolor4 = shadecolor4
                    //                    gauge11.stepsize = stepsize1.value
                    //                    gauge11.minValueAngle = minValueAngle.value
                    //                    gauge11.maxValueAngle = maxValueAngle.value
                    //                    gauge11.rotation = myRotation.value
                    //                    gauge11.imgSource = imgSource
                    //                    gauge11.fullCirc = fullCircle
                    //                    gauge11.subDivVal = subDivVal.value
                    //                    gauge11.z = zVal.text
                    //                    break;

                    //                case 11:

                    //                    gauge12.width = gwidth.text
                    //                    gauge12.height = gheight.text
                    //                    gauge12.title = title.text
                    //                    gauge12.maxvalue = maxval.text
                    //                    gauge12.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge12.vertgaugevisible = vertvisble
                    //                    gauge12.horigaugevisible = horizvisible
                    //                    gauge12.secvaluevisible = secvisible
                    //                    gauge12.warnvaluelow = lowwarn.text
                    //                    gauge12.warnvaluehigh = highwarn.text
                    //                    gauge12.mainunit = units.text
                    //                    gauge12.titlecolor = titlecolor
                    //                    gauge12.framecolor = framecolor
                    //                    gauge12.resetbackroundcolor = resetbackroundcolor
                    //                    gauge12.resettitlecolor = resettitlecolor
                    //                    gauge12.textcolor = textcolor
                    //                    gauge12.titlecolor = titlecolor
                    //                    gauge12.titletextcolor = titletextcolor
                    //                    gauge12.barcolor = barcolor
                    //                    gauge12.titlefontsize = setTitlefontsize.value
                    //                    gauge12.mainfontsize = setMainfontsize.value
                    //                    gauge12.gaugecolor1 = gaugecolor1
                    //                    gauge12.gaugecolor2 = gaugecolor2
                    //                    gauge12.gaugecolor3 = gaugecolor3
                    //                    gauge12.gaugecolor4 = gaugecolor4
                    //                    gauge12.gaugecolor5 = gaugecolor5
                    //                    gauge12.gaugecolor6 = gaugecolor6
                    //                    gauge12.gaugecolor7 = gaugecolor7
                    //                    gauge12.gaugecolor8 = gaugecolor8
                    //                    gauge12.gaugecolor9 = gaugecolor9
                    //                    gauge12.shadecolor1 = shadecolor1
                    //                    gauge12.shadecolor2 = shadecolor2
                    //                    gauge12.shadecolor3 = shadecolor3
                    //                    gauge12.shadecolor4 = shadecolor4
                    //                    gauge12.stepsize = stepsize1.value
                    //                    gauge12.minValueAngle = minValueAngle.value
                    //                    gauge12.maxValueAngle = maxValueAngle.value
                    //                    gauge12.rotation = myRotation.value
                    //                    gauge12.imgSource = imgSource
                    //                    gauge12.fullCirc = fullCircle
                    //                    gauge12.subDivVal = subDivVal.value
                    //                    gauge12.z = zVal.text
                    //                    break;

                    //                case 12:

                    //                    gauge13.width = gwidth.text
                    //                    gauge13.height = gheight.text
                    //                    gauge13.title = title.text
                    //                    gauge13.maxvalue = maxval.text
                    //                    gauge13.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge13.vertgaugevisible = vertvisble
                    //                    gauge13.horigaugevisible = horizvisible
                    //                    gauge13.secvaluevisible = secvisible
                    //                    gauge13.warnvaluelow = lowwarn.text
                    //                    gauge13.warnvaluehigh = highwarn.text
                    //                    gauge13.mainunit = units.text
                    //                    gauge13.titlecolor = titlecolor
                    //                    gauge13.framecolor = framecolor
                    //                    gauge13.resetbackroundcolor = resetbackroundcolor
                    //                    gauge13.resettitlecolor = resettitlecolor
                    //                    gauge13.textcolor = textcolor
                    //                    gauge13.titlecolor = titlecolor
                    //                    gauge13.titletextcolor = titletextcolor
                    //                    gauge13.barcolor = barcolor
                    //                    gauge13.titlefontsize = setTitlefontsize.value
                    //                    gauge13.mainfontsize = setMainfontsize.value
                    //                    gauge13.gaugecolor1 = gaugecolor1
                    //                    gauge13.gaugecolor2 = gaugecolor2
                    //                    gauge13.gaugecolor3 = gaugecolor3
                    //                    gauge13.gaugecolor4 = gaugecolor4
                    //                    gauge13.gaugecolor5 = gaugecolor5
                    //                    gauge13.gaugecolor6 = gaugecolor6
                    //                    gauge13.gaugecolor7 = gaugecolor7
                    //                    gauge13.gaugecolor8 = gaugecolor8
                    //                    gauge13.gaugecolor9 = gaugecolor9
                    //                    gauge13.shadecolor1 = shadecolor1
                    //                    gauge13.shadecolor2 = shadecolor2
                    //                    gauge13.shadecolor3 = shadecolor3
                    //                    gauge13.shadecolor4 = shadecolor4
                    //                    gauge13.stepsize = stepsize1.value
                    //                    gauge13.minValueAngle = minValueAngle.value
                    //                    gauge13.maxValueAngle = maxValueAngle.value
                    //                    gauge13.rotation = myRotation.value
                    //                    gauge13.imgSource = imgSource
                    //                    gauge13.fullCirc = fullCircle
                    //                    gauge13.subDivVal = subDivVal.value
                    //                    gauge13.z = zVal.text
                    //                    break;

                    //                case 13:
                    //                    gauge14.width = gwidth.text
                    //                    gauge14.height = gheight.text
                    //                    gauge14.title = title.text
                    //                    gauge14.maxvalue = maxval.text
                    //                    gauge14.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge14.vertgaugevisible = vertvisble
                    //                    gauge14.horigaugevisible = horizvisible
                    //                    gauge14.secvaluevisible = secvisible
                    //                    gauge14.warnvaluelow = lowwarn.text
                    //                    gauge14.warnvaluehigh = highwarn.text
                    //                    gauge14.mainunit = units.text
                    //                    gauge14.titlecolor = titlecolor
                    //                    gauge14.framecolor = framecolor
                    //                    gauge14.resetbackroundcolor = resetbackroundcolor
                    //                    gauge14.resettitlecolor = resettitlecolor
                    //                    gauge14.textcolor = textcolor
                    //                    gauge14.titlecolor = titlecolor
                    //                    gauge14.titletextcolor = titletextcolor
                    //                    gauge14.barcolor = barcolor
                    //                    gauge14.titlefontsize = setTitlefontsize.value
                    //                    gauge14.mainfontsize = setMainfontsize.value
                    //                    gauge14.gaugecolor1 = gaugecolor1
                    //                    gauge14.gaugecolor2 = gaugecolor2
                    //                    gauge14.gaugecolor3 = gaugecolor3
                    //                    gauge14.gaugecolor4 = gaugecolor4
                    //                    gauge14.gaugecolor5 = gaugecolor5
                    //                    gauge14.gaugecolor6 = gaugecolor6
                    //                    gauge14.gaugecolor7 = gaugecolor7
                    //                    gauge14.gaugecolor8 = gaugecolor8
                    //                    gauge14.gaugecolor9 = gaugecolor9
                    //                    gauge14.shadecolor1 = shadecolor1
                    //                    gauge14.shadecolor2 = shadecolor2
                    //                    gauge14.shadecolor3 = shadecolor3
                    //                    gauge14.shadecolor4 = shadecolor4
                    //                    gauge14.stepsize = stepsize1.value
                    //                    gauge14.minValueAngle = minValueAngle.value
                    //                    gauge14.maxValueAngle = maxValueAngle.value
                    //                    gauge14.rotation = myRotation.value
                    //                    gauge14.imgSource = imgSource
                    //                    gauge14.fullCirc = fullCircle
                    //                    gauge14.subDivVal = subDivVal.value
                    //                    gauge14.z = zVal.text
                    //                    break;

                    //                case 14:

                    //                    gauge15.width = gwidth.text
                    //                    gauge15.height = gheight.text
                    //                    gauge15.title = title.text
                    //                    gauge15.maxvalue = maxval.text
                    //                    gauge15.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge15.vertgaugevisible = vertvisble
                    //                    gauge15.horigaugevisible = horizvisible
                    //                    gauge15.secvaluevisible = secvisible
                    //                    gauge15.warnvaluelow = lowwarn.text
                    //                    gauge15.warnvaluehigh = highwarn.text
                    //                    gauge15.mainunit = units.text
                    //                    gauge15.titlecolor = titlecolor
                    //                    gauge15.framecolor = framecolor
                    //                    gauge15.resetbackroundcolor = resetbackroundcolor
                    //                    gauge15.resettitlecolor = resettitlecolor
                    //                    gauge15.textcolor = textcolor
                    //                    gauge15.titlecolor = titlecolor
                    //                    gauge15.titletextcolor = titletextcolor
                    //                    gauge15.barcolor = barcolor
                    //                    gauge15.titlefontsize = setTitlefontsize.value
                    //                    gauge15.mainfontsize = setMainfontsize.value
                    //                    gauge15.gaugecolor1 = gaugecolor1
                    //                    gauge15.gaugecolor2 = gaugecolor2
                    //                    gauge15.gaugecolor3 = gaugecolor3
                    //                    gauge15.gaugecolor4 = gaugecolor4
                    //                    gauge15.gaugecolor5 = gaugecolor5
                    //                    gauge15.gaugecolor6 = gaugecolor6
                    //                    gauge15.gaugecolor7 = gaugecolor7
                    //                    gauge15.gaugecolor8 = gaugecolor8
                    //                    gauge15.gaugecolor9 = gaugecolor9
                    //                    gauge15.shadecolor1 = shadecolor1
                    //                    gauge15.shadecolor2 = shadecolor2
                    //                    gauge15.shadecolor3 = shadecolor3
                    //                    gauge15.shadecolor4 = shadecolor4
                    //                    gauge15.stepsize = stepsize1.value
                    //                    gauge15.minValueAngle = minValueAngle.value
                    //                    gauge15.maxValueAngle = maxValueAngle.value
                    //                    gauge15.rotation = myRotation.value
                    //                    gauge15.imgSource = imgSource
                    //                    gauge15.fullCirc = fullCircle
                    //                    gauge15.subDivVal = subDivVal.value
                    //                    gauge15.z = zVal.text
                    //                    break;

                    //                case 15:

                    //                    gauge16.width = gwidth.text
                    //                    gauge16.height = gheight.text
                    //                    gauge16.title = title.text
                    //                    gauge16.maxvalue = maxval.text
                    //                    gauge16.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge16.vertgaugevisible = vertvisble
                    //                    gauge16.horigaugevisible = horizvisible
                    //                    gauge16.secvaluevisible = secvisible
                    //                    gauge16.warnvaluelow = lowwarn.text
                    //                    gauge16.warnvaluehigh = highwarn.text
                    //                    gauge16.mainunit = units.text
                    //                    gauge16.titlecolor = titlecolor
                    //                    gauge16.framecolor = framecolor
                    //                    gauge16.resetbackroundcolor = resetbackroundcolor
                    //                    gauge16.resettitlecolor = resettitlecolor
                    //                    gauge16.textcolor = textcolor
                    //                    gauge16.titlecolor = titlecolor
                    //                    gauge16.titletextcolor = titletextcolor
                    //                    gauge16.barcolor = barcolor
                    //                    gauge16.titlefontsize = setTitlefontsize.value
                    //                    gauge16.mainfontsize = setMainfontsize.value
                    //                    gauge16.gaugecolor1 = gaugecolor1
                    //                    gauge16.gaugecolor2 = gaugecolor2
                    //                    gauge16.gaugecolor3 = gaugecolor3
                    //                    gauge16.gaugecolor4 = gaugecolor4
                    //                    gauge16.gaugecolor5 = gaugecolor5
                    //                    gauge16.gaugecolor6 = gaugecolor6
                    //                    gauge16.gaugecolor7 = gaugecolor7
                    //                    gauge16.gaugecolor8 = gaugecolor8
                    //                    gauge16.gaugecolor9 = gaugecolor9
                    //                    gauge16.shadecolor1 = shadecolor1
                    //                    gauge16.shadecolor2 = shadecolor2
                    //                    gauge16.shadecolor3 = shadecolor3
                    //                    gauge16.shadecolor4 = shadecolor4
                    //                    gauge16.stepsize = stepsize1.value
                    //                    gauge16.minValueAngle = minValueAngle.value
                    //                    gauge16.maxValueAngle = maxValueAngle.value
                    //                    gauge16.rotation = myRotation.value
                    //                    gauge16.imgSource = imgSource
                    //                    gauge16.fullCirc = fullCircle
                    //                    gauge16.subDivVal = subDivVal.value
                    //                    gauge16.z = zVal.text
                    //                    break;

                    //                case 16:

                    //                    gauge17.width = gwidth.text
                    //                    gauge17.height = gheight.text
                    //                    gauge17.title = title.text
                    //                    gauge17.maxvalue = maxval.text
                    //                    gauge17.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge17.vertgaugevisible = vertvisble
                    //                    gauge17.horigaugevisible = horizvisible
                    //                    gauge17.secvaluevisible = secvisible
                    //                    gauge17.warnvaluelow = lowwarn.text
                    //                    gauge17.warnvaluehigh = highwarn.text
                    //                    gauge17.mainunit = units.text
                    //                    gauge17.titlecolor = titlecolor
                    //                    gauge17.framecolor = framecolor
                    //                    gauge17.resetbackroundcolor = resetbackroundcolor
                    //                    gauge17.resettitlecolor = resettitlecolor
                    //                    gauge17.textcolor = textcolor
                    //                    gauge17.titlecolor = titlecolor
                    //                    gauge17.titletextcolor = titletextcolor
                    //                    gauge17.barcolor = barcolor
                    //                    gauge17.titlefontsize = setTitlefontsize.value
                    //                    gauge17.mainfontsize = setMainfontsize.value
                    //                    gauge17.gaugecolor1 = gaugecolor1
                    //                    gauge17.gaugecolor2 = gaugecolor2
                    //                    gauge17.gaugecolor3 = gaugecolor3
                    //                    gauge17.gaugecolor4 = gaugecolor4
                    //                    gauge17.gaugecolor5 = gaugecolor5
                    //                    gauge17.gaugecolor6 = gaugecolor6
                    //                    gauge17.gaugecolor7 = gaugecolor7
                    //                    gauge17.gaugecolor8 = gaugecolor8
                    //                    gauge17.gaugecolor9 = gaugecolor9
                    //                    gauge17.shadecolor1 = shadecolor1
                    //                    gauge17.shadecolor2 = shadecolor2
                    //                    gauge17.shadecolor3 = shadecolor3
                    //                    gauge17.shadecolor4 = shadecolor4
                    //                    gauge17.stepsize = stepsize1.value
                    //                    gauge17.minValueAngle = minValueAngle.value
                    //                    gauge17.maxValueAngle = maxValueAngle.value
                    //                    gauge17.rotation = myRotation.value
                    //                    gauge17.imgSource = imgSource
                    //                    gauge17.fullCirc = fullCircle
                    //                    gauge17.subDivVal = subDivVal.value
                    //                    gauge17.z = zVal.text
                    //                    break;

                    //                case 17:

                    //                    gauge18.width = gwidth.text
                    //                    gauge18.height = gheight.text
                    //                    gauge18.title = title.text
                    //                    gauge18.maxvalue = maxval.text
                    //                    gauge18.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge18.vertgaugevisible = vertvisble
                    //                    gauge18.horigaugevisible = horizvisible
                    //                    gauge18.secvaluevisible = secvisible
                    //                    gauge18.warnvaluelow = lowwarn.text
                    //                    gauge18.warnvaluehigh = highwarn.text
                    //                    gauge18.mainunit = units.text
                    //                    gauge18.titlecolor = titlecolor
                    //                    gauge18.framecolor = framecolor
                    //                    gauge18.resetbackroundcolor = resetbackroundcolor
                    //                    gauge18.resettitlecolor = resettitlecolor
                    //                    gauge18.textcolor = textcolor
                    //                    gauge18.titlecolor = titlecolor
                    //                    gauge18.titletextcolor = titletextcolor
                    //                    gauge18.barcolor = barcolor
                    //                    gauge18.titlefontsize = setTitlefontsize.value
                    //                    gauge18.mainfontsize = setMainfontsize.value
                    //                    gauge18.gaugecolor1 = gaugecolor1
                    //                    gauge18.gaugecolor2 = gaugecolor2
                    //                    gauge18.gaugecolor3 = gaugecolor3
                    //                    gauge18.gaugecolor4 = gaugecolor4
                    //                    gauge18.gaugecolor5 = gaugecolor5
                    //                    gauge18.gaugecolor6 = gaugecolor6
                    //                    gauge18.gaugecolor7 = gaugecolor7
                    //                    gauge18.gaugecolor8 = gaugecolor8
                    //                    gauge18.gaugecolor9 = gaugecolor9
                    //                    gauge18.shadecolor1 = shadecolor1
                    //                    gauge18.shadecolor2 = shadecolor2
                    //                    gauge18.shadecolor3 = shadecolor3
                    //                    gauge18.shadecolor4 = shadecolor4
                    //                    gauge18.stepsize = stepsize1.value
                    //                    gauge18.minValueAngle = minValueAngle.value
                    //                    gauge18.maxValueAngle = maxValueAngle.value
                    //                    gauge18.rotation = myRotation.value
                    //                    gauge18.imgSource = imgSource
                    //                    gauge18.fullCirc = fullCircle
                    //                    gauge18.subDivVal = subDivVal.value
                    //                    gauge18.z = zVal.text
                    //                    break;

                    //                case 18:

                    //                    gauge19.width = gwidth.text
                    //                    gauge19.height = gheight.text
                    //                    gauge19.title = title.text
                    //                    gauge19.maxvalue = maxval.text
                    //                    gauge19.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge19.vertgaugevisible = vertvisble
                    //                    gauge19.horigaugevisible = horizvisible
                    //                    gauge19.secvaluevisible = secvisible
                    //                    gauge19.warnvaluelow = lowwarn.text
                    //                    gauge19.warnvaluehigh = highwarn.text
                    //                    gauge19.mainunit = units.text
                    //                    gauge19.titlecolor = titlecolor
                    //                    gauge19.framecolor = framecolor
                    //                    gauge19.resetbackroundcolor = resetbackroundcolor
                    //                    gauge19.resettitlecolor = resettitlecolor
                    //                    gauge19.textcolor = textcolor
                    //                    gauge19.titlecolor = titlecolor
                    //                    gauge19.titletextcolor = titletextcolor
                    //                    gauge19.barcolor = barcolor
                    //                    gauge19.titlefontsize = setTitlefontsize.value
                    //                    gauge19.mainfontsize = setMainfontsize.value
                    //                    gauge19.gaugecolor1 = gaugecolor1
                    //                    gauge19.gaugecolor2 = gaugecolor2
                    //                    gauge19.gaugecolor3 = gaugecolor3
                    //                    gauge19.gaugecolor4 = gaugecolor4
                    //                    gauge19.gaugecolor5 = gaugecolor5
                    //                    gauge19.gaugecolor6 = gaugecolor6
                    //                    gauge19.gaugecolor7 = gaugecolor7
                    //                    gauge19.gaugecolor8 = gaugecolor8
                    //                    gauge19.gaugecolor9 = gaugecolor9
                    //                    gauge19.shadecolor1 = shadecolor1
                    //                    gauge19.shadecolor2 = shadecolor2
                    //                    gauge19.shadecolor3 = shadecolor3
                    //                    gauge19.shadecolor4 = shadecolor4
                    //                    gauge19.stepsize = stepsize1.value
                    //                    gauge19.minValueAngle = minValueAngle.value
                    //                    gauge19.maxValueAngle = maxValueAngle.value
                    //                    gauge19.rotation = myRotation.value
                    //                    gauge19.imgSource = imgSource
                    //                    gauge19.fullCirc = fullCircle
                    //                    gauge19.subDivVal = subDivVal.value
                    //                    gauge19.z = zVal.text
                    //                    break;

                    //                case 19:

                    //                    gauge20.width = gwidth.text
                    //                    gauge20.height = gheight.text
                    //                    gauge20.title = title.text
                    //                    gauge20.maxvalue = maxval.text
                    //                    gauge20.mainvalue = testvalueslider.value.toFixed(decimalplaces.value)
                    //                    gauge20.vertgaugevisible = vertvisble
                    //                    gauge20.horigaugevisible = horizvisible
                    //                    gauge20.secvaluevisible = secvisible
                    //                    gauge20.warnvaluelow = lowwarn.text
                    //                    gauge20.warnvaluehigh = highwarn.text
                    //                    gauge20.mainunit = units.text
                    //                    gauge20.titlecolor = titlecolor
                    //                    gauge20.framecolor = framecolor
                    //                    gauge20.resetbackroundcolor = resetbackroundcolor
                    //                    gauge20.resettitlecolor = resettitlecolor
                    //                    gauge20.textcolor = textcolor
                    //                    gauge20.titlecolor = titlecolor
                    //                    gauge20.titletextcolor = titletextcolor
                    //                    gauge20.barcolor = barcolor
                    //                    gauge20.titlefontsize = setTitlefontsize.value
                    //                    gauge20.mainfontsize = setMainfontsize.value
                    //                    gauge20.gaugecolor1 = gaugecolor1
                    //                    gauge20.gaugecolor2 = gaugecolor2
                    //                    gauge20.gaugecolor3 = gaugecolor3
                    //                    gauge20.gaugecolor4 = gaugecolor4
                    //                    gauge20.gaugecolor5 = gaugecolor5
                    //                    gauge20.gaugecolor6 = gaugecolor6
                    //                    gauge20.gaugecolor7 = gaugecolor7
                    //                    gauge20.gaugecolor8 = gaugecolor8
                    //                    gauge20.gaugecolor9 = gaugecolor9
                    //                    gauge20.shadecolor1 = shadecolor1
                    //                    gauge20.shadecolor2 = shadecolor2
                    //                    gauge20.shadecolor3 = shadecolor3
                    //                    gauge20.shadecolor4 = shadecolor4
                    //                    gauge20.stepsize = stepsize1.value
                    //                    gauge20.minValueAngle = minValueAngle.value
                    //                    gauge20.maxValueAngle = maxValueAngle.value
                    //                    gauge20.rotation = myRotation.value
                    //                    gauge20.imgSource = imgSource
                    //                    gauge20.fullCirc = fullCircle
                    //                    gauge20.subDivVal = subDivVal.value
                    //                    gauge20.z = zVal.text
                    //                    break;

                }
            }
        }
        Item
        {
            id: container
            function createSquareGauge(setWidth,setHeight,setX,setY,setMaxValue,setDecPlace,setUnit,setID,setVertGaugeVis,setHoriGaugeVis,setSecValueVis,SetValueObject,SetValuePropertyMain,SetValuePropertySec,Setwarnvaluehigh,Setwarnvaluelow) {
                component = Qt.createComponent("SquareGauge.qml");
                if (component.status === Component.Ready){
                    console.log("component ready");
                    finishCreation(setWidth,setHeight,setX,setY,setMaxValue,setDecPlace,setUnit,setID,setVertGaugeVis,setHoriGaugeVis,setSecValueVis,SetValueObject,SetValuePropertyMain,SetValuePropertySec,Setwarnvaluehigh,Setwarnvaluelow);

                }
                else {
                    component.statusChanged.connect(finishCreation);
                    console.log("component not ready!");
                }
            }


            function createTachoGauge(setWidth,setHeight,setX,setY,setMaxValue,setDecPlace,setUnit,setID,setVertGaugeVis,setHoriGaugeVis,setSecValueVis,SetValueObject,SetValuePropertyMain,SetValuePropertySec,Setwarnvaluehigh,Setwarnvaluelow,Setframeclolor,Setbackroundcolor,Settitlecolor,Settitletextcolor,Settextcolor,Setbarcolor,SetTitlefontsize,SetMainfontsize,color1,color2,color3,color4,color5,color6,color7,color8,color9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize1,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal) {
                component = Qt.createComponent("TachoGauge.qml");
                if (component.status === Component.Ready){
                    console.log("component ready");
                    finishCreation2(setWidth,setHeight,setX,setY,setMaxValue,setDecPlace,setUnit,setID,setVertGaugeVis,setHoriGaugeVis,setSecValueVis,SetValueObject,SetValuePropertyMain,SetValuePropertySec,Setwarnvaluehigh,Setwarnvaluelow,Setframeclolor,Setbackroundcolor,Settitlecolor,Settitletextcolor,Settextcolor,Setbarcolor,SetTitlefontsize,SetMainfontsize,color1,color2,color3,color4,color5,color6,color7,color8,color9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize1,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal);
                }
                else {
                    if( component.status == Component.Error ){
                        console.debug("Error:"+ component.errorString() );
                    }
                    component.statusChanged.connect(finishCreation);
                    console.log("component not ready!");
                }
            }

            function createSpeedoGauge(setWidth,setHeight,setX,setY,setMaxValue,setDecPlace,setUnit,setID,setVertGaugeVis,setHoriGaugeVis,setSecValueVis,SetValueObject,SetValuePropertyMain,SetValuePropertySec,Setwarnvaluehigh,Setwarnvaluelow,Setframeclolor,Setbackroundcolor,Settitlecolor,Settitletextcolor,Settextcolor,Setbarcolor,SetTitlefontsize,SetMainfontsize,color1,color2,color3,color4,color5,color6,color7,color8,color9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize1,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal) {
                component = Qt.createComponent("SpeedoGauge.qml");
                if (component.status === Component.Ready){
                    console.log("component ready");
                    finishCreation2(setWidth,setHeight,setX,setY,setMaxValue,setDecPlace,setUnit,setID,setVertGaugeVis,setHoriGaugeVis,setSecValueVis,SetValueObject,SetValuePropertyMain,SetValuePropertySec,Setwarnvaluehigh,Setwarnvaluelow,Setframeclolor,Setbackroundcolor,Settitlecolor,Settitletextcolor,Settextcolor,Setbarcolor,SetTitlefontsize,SetMainfontsize,color1,color2,color3,color4,color5,color6,color7,color8,color9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize1,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal);
                }
                else {
                    if( component.status == Component.Error ){
                        console.debug("Error:"+ component.errorString() );
                    }
                    component.statusChanged.connect(finishCreation);
                    console.log("component not ready!");
                }
            }

            function createImage(setWidth,setHeight,setX,setY,setMaxValue,setDecPlace,setUnit,setID,setVertGaugeVis,setHoriGaugeVis,setSecValueVis,SetValueObject,SetValuePropertyMain,SetValuePropertySec,Setwarnvaluehigh,Setwarnvaluelow,Setframeclolor,Setbackroundcolor,Settitlecolor,Settitletextcolor,Settextcolor,Setbarcolor,SetTitlefontsize,SetMainfontsize,color1,color2,color3,color4,color5,color6,color7,color8,color9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize1,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal,imgSource) {
                component = Qt.createComponent("ImageGauge.qml");
                if (component.status === Component.Ready){
                    console.log("component ready");
                    finishCreation2(setWidth,setHeight,setX,setY,setMaxValue,setDecPlace,setUnit,setID,setVertGaugeVis,setHoriGaugeVis,setSecValueVis,SetValueObject,SetValuePropertyMain,SetValuePropertySec,Setwarnvaluehigh,Setwarnvaluelow,Setframeclolor,Setbackroundcolor,Settitlecolor,Settitletextcolor,Settextcolor,Setbarcolor,SetTitlefontsize,SetMainfontsize,color1,color2,color3,color4,color5,color6,color7,color8,color9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize1,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal,imgSource);
                }
                else {
                    if( component.status == Component.Error ){
                        console.debug("Error:"+ component.errorString() );
                    }
                    component.statusChanged.connect(finishCreation);
                    console.log("component not ready!");
                }
            }


            function createRoundGauge(setWidth,setHeight,setX,setY,setMaxValue,setDecPlace,setUnit,setID,setVertGaugeVis,setHoriGaugeVis,setSecValueVis,SetValueObject,SetValuePropertyMain,SetValuePropertySec,Setwarnvaluehigh,Setwarnvaluelow,Setframeclolor,Setbackroundcolor,Settitlecolor,Settitletextcolor,Settextcolor,Setbarcolor,SetTitlefontsize,SetMainfontsize,color1,color2,color3,color4,color5,color6,color7,color8,color9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize1,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal) {
                component = Qt.createComponent("RoundGauge.qml");
                if (component.status === Component.Ready){
                    console.log("component ready");
                    finishCreation2(setWidth,setHeight,setX,setY,setMaxValue,setDecPlace,setUnit,setID,setVertGaugeVis,setHoriGaugeVis,setSecValueVis,SetValueObject,SetValuePropertyMain,SetValuePropertySec,Setwarnvaluehigh,Setwarnvaluelow,Setframeclolor,Setbackroundcolor,Settitlecolor,Settitletextcolor,Settextcolor,Setbarcolor,SetTitlefontsize,SetMainfontsize,color1,color2,color3,color4,color5,color6,color7,color8,color9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize1,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal);
                }
                else {
                    if( component.status == Component.Error ){
                        console.debug("Error:"+ component.errorString() );
                    }
                    component.statusChanged.connect(finishCreation);
                    console.log("component not ready!");
                }
            }

            function setValuesWhenClicked(){
                refreshing = true
                gwidth.text = tempgauge.width
                gheight.text = tempgauge.height
                title.text = tempgauge.title
                maxval.text = tempgauge.maxvalue
                //testvalueslider.value.toFixed(decimalplaces.value) = tempgauge.mainvalue
//                testvalueslider.from = -1*(tempgauge.maxvalue)
//                testvalueslider.to = tempgauge.maxvalue
                vertvisble = tempgauge.vertgaugevisible
                horizvisible = tempgauge.horigaugevisible
                secvisible = tempgauge.secvaluevisible
                lowwarn.text = tempgauge.warnvaluelow
                highwarn.text = tempgauge.warnvaluehigh
                units.text = tempgauge.mainunit
                titleColorText.text = tempgauge.titlecolor
                frameColourText.text = tempgauge.framecolor
                backgroundColorText.text = tempgauge.resetbackroundcolor
                titleColorText.text = tempgauge.resettitlecolor
                textColorText.text = tempgauge.textcolor
                titleColorText.text = tempgauge.titlecolor
                titleTextColorText.text = tempgauge.titletextcolor
                barColorText.text = tempgauge.barcolor
                setTitlefontsize.text = tempgauge.titlefontsize
                setMainfontsize.text = tempgauge.mainfontsize
                color1Text.text = tempgauge.gaugecolor1
                color2Text.text = tempgauge.gaugecolor2
                color3Text.text = tempgauge.gaugecolor3
                color4Text.text = tempgauge.gaugecolor4
                color5Text.text = tempgauge.gaugecolor5
                color6Text.text = tempgauge.gaugecolor6
                color7Text.text = tempgauge.gaugecolor7
                color8Text.text = tempgauge.gaugecolor8
                color9Text.text = tempgauge.gaugecolor9
                shadecolor1Text.text = tempgauge.shadecolor1
                shadecolor2Text.text = tempgauge.shadecolor2
                shadecolor3Text.text = tempgauge.shadecolor3
                shadecolor4Text.text = tempgauge.shadecolor4
                stepsize1.text = tempgauge.stepsize
                minValueAngle.text = tempgauge.minValueAngle
                maxValueAngle.text = tempgauge.maxValueAngle
                myRotation.text = tempgauge.rotation
                imgSource = tempgauge.imgSource
                zVal.text = tempgauge.z
                gx.text = tempgauge.x
                gy.text = tempgauge.y
                refreshing = false
            }

            function finishCreation3(setWidth,setHeight,setX,setY,setMaxValue,setDecPlace,setUnit,setID,setVertGaugeVis,setHoriGaugeVis,setSecValueVis,SetValueObject,SetValuePropertyMain,SetValuePropertySec,Setwarnvaluehigh,Setwarnvaluelow,Setframeclolor,Setbackroundcolor,Settitlecolor,Settitletextcolor,Settextcolor,Setbarcolor,SetTitlefontsize,SetMainfontsize,color1,color2,color3,color4,color5,color6,color7,color8,color9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize1,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal) {
                if (component.status === Component.Ready) {
                    gauge = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                       "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                       "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                       "maxvalue": setMaxValue,
                                                       "warnvaluehigh": Setwarnvaluehigh,
                                                       "warnvaluelow":Setwarnvaluelow,
                                                       "mainunit": setUnit,
                                                       "titlecolor":Settitlecolor,
                                                       "resettitlecolor":Settitlecolor,
                                                       "framecolor":Setframeclolor,
                                                       "resetbackroundcolor":Setbackroundcolor,
                                                       "textcolor":Settextcolor,
                                                       "titletextcolor":Settitletextcolor,
                                                       "barcolor":Setbarcolor,
                                                       "titlefontsize":SetTitlefontsize,
                                                       "mainfontsize":SetMainfontsize,
                                                       "vertgaugevisible": setVertGaugeVis,
                                                       "horigaugevisible": setHoriGaugeVis,
                                                       "secvaluevisible": setSecValueVis,
                                                       "x": setX,
                                                       "y": setY,
                                                       "gaugecolor1": color1,
                                                       "gaugecolor2": color2,
                                                       "gaugecolor3": color3,
                                                       "gaugecolor4": color4,
                                                       "gaugecolor5": color5,
                                                       "gaugecolor6": color6,
                                                       "gaugecolor7": color7,
                                                       "gaugecolor8": color8,
                                                       "gaugecolor9": color9,
                                                       "shadecolor1": shadecolor1,
                                                       "shadecolor2": shadecolor2,
                                                       "shadecolor3": shadecolor3,
                                                       "shadecolor4": shadecolor4,
                                                       "stepsize": stepsize1,
                                                       "minValueAngle": minValueAngle,
                                                       "maxValueAngle": maxValueAngle,
                                                       "rotation": myRotation
                                                   });
                    if (gauge === null) {
                        // Error Handling
                        console.log("Error creating object");
                    }

                } else if (component.status === Component.Error) {
                    // Error Handling
                    console.log("Error loading component:", component.errorString());
                }
            }


            function finishCreation(setWidth,setHeight,setX,setY,setMaxValue,setDecPlace,setUnit,setID,setVertGaugeVis,setHoriGaugeVis,setSecValueVis,SetValueObject,SetValuePropertyMain,SetValuePropertySec,Setwarnvaluehigh,Setwarnvaluelow) {
                if (component.status === Component.Ready) {
                    gaugeselect.currentIndex = gaugenumber-1
                    switch (gaugenumber) {
                    case 1:
                        gauge1 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                            "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                            "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                            "maxvalue": setMaxValue,
                                                            "mainunit": setUnit,
                                                            "warnvaluehigh": Setwarnvaluehigh,
                                                            "warnvaluelow":Setwarnvaluelow,
                                                            "vertgaugevisible": setVertGaugeVis,
                                                            "horigaugevisible": setHoriGaugeVis,
                                                            "secvaluevisible": setSecValueVis,
                                                            "x": setX, "y": setY});
                        if (gauge1 === null) {
                            // Error Handling
                            console.log("Error creating object");
                        }else{
                            tempgauge = gauge1
                        }

                        break;


                    case 2:
                        gauge2 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                            "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                            "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                            "maxvalue": setMaxValue,
                                                            "mainunit": setUnit,
                                                            "warnvaluehigh": Setwarnvaluehigh,
                                                            "warnvaluelow":Setwarnvaluelow,
                                                            "vertgaugevisible": setVertGaugeVis,
                                                            "horigaugevisible": setHoriGaugeVis,
                                                            "secvaluevisible": setSecValueVis,
                                                            "x": setX, "y": setY});
                        if (gauge2 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge2

                        }
                        break;

                    case 3:
                        gauge3 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                            "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                            "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                            "maxvalue": setMaxValue,
                                                            "mainunit": setUnit,
                                                            "warnvaluehigh": Setwarnvaluehigh,
                                                            "warnvaluelow":Setwarnvaluelow,
                                                            "vertgaugevisible": setVertGaugeVis,
                                                            "horigaugevisible": setHoriGaugeVis,
                                                            "secvaluevisible": setSecValueVis,
                                                            "x": setX, "y": setY});
                        if (gauge3 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge3

                        }
                        break;

                    case 4:
                        gauge4 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                            "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                            "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                            "maxvalue": setMaxValue,
                                                            "mainunit": setUnit,
                                                            "warnvaluehigh": Setwarnvaluehigh,
                                                            "warnvaluelow":Setwarnvaluelow,
                                                            "vertgaugevisible": setVertGaugeVis,
                                                            "horigaugevisible": setHoriGaugeVis,
                                                            "secvaluevisible": setSecValueVis,
                                                            "x": setX, "y": setY});
                        if (gauge4 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge4

                        }
                        break;

                    case 5:
                        gauge5 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                            "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                            "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                            "maxvalue": setMaxValue,
                                                            "mainunit": setUnit,
                                                            "warnvaluehigh": Setwarnvaluehigh,
                                                            "warnvaluelow":Setwarnvaluelow,
                                                            "vertgaugevisible": setVertGaugeVis,
                                                            "horigaugevisible": setHoriGaugeVis,
                                                            "secvaluevisible": setSecValueVis,
                                                            "x": setX, "y": setY});
                        if (gauge5 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge5

                        }
                        break;

                    case 6:
                        gauge6 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                            "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                            "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                            "maxvalue": setMaxValue,
                                                            "mainunit": setUnit,
                                                            "warnvaluehigh": Setwarnvaluehigh,
                                                            "warnvaluelow":Setwarnvaluelow,
                                                            "vertgaugevisible": setVertGaugeVis,
                                                            "horigaugevisible": setHoriGaugeVis,
                                                            "secvaluevisible": setSecValueVis,
                                                            "x": setX, "y": setY});
                        if (gauge6 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge6

                        }
                        break;

                    case 7:
                        gauge7 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                            "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                            "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                            "maxvalue": setMaxValue,
                                                            "mainunit": setUnit,
                                                            "warnvaluehigh": Setwarnvaluehigh,
                                                            "warnvaluelow":Setwarnvaluelow,
                                                            "vertgaugevisible": setVertGaugeVis,
                                                            "horigaugevisible": setHoriGaugeVis,
                                                            "secvaluevisible": setSecValueVis,
                                                            "x": setX, "y": setY});
                        if (gauge7 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge7

                        }
                        break;

                    case 8:
                        gauge8 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                            "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                            "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                            "maxvalue": setMaxValue,
                                                            "mainunit": setUnit,
                                                            "warnvaluehigh": Setwarnvaluehigh,
                                                            "warnvaluelow":Setwarnvaluelow,
                                                            "vertgaugevisible": setVertGaugeVis,
                                                            "horigaugevisible": setHoriGaugeVis,
                                                            "secvaluevisible": setSecValueVis,
                                                            "x": setX, "y": setY});
                        if (gauge8 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge8

                        }
                        break;

                    case 9:
                        gauge9 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                            "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                            "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                            "maxvalue": setMaxValue,
                                                            "mainunit": setUnit,
                                                            "warnvaluehigh": Setwarnvaluehigh,
                                                            "warnvaluelow":Setwarnvaluelow,
                                                            "vertgaugevisible": setVertGaugeVis,
                                                            "horigaugevisible": setHoriGaugeVis,
                                                            "secvaluevisible": setSecValueVis,
                                                            "x": setX, "y": setY});
                        if (gauge9 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge9

                        }
                        break;

                    case 10:
                        gauge10 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "mainunit": setUnit,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX, "y": setY});
                        if (gauge10 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge10

                        }
                        break;

                    case 11:
                        gauge11 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "mainunit": setUnit,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX, "y": setY});
                        if (gauge11 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge11

                        }
                        break;

                    case 12:
                        gauge12 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "mainunit": setUnit,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX, "y": setY});
                        if (gauge12 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge12

                        }
                        break;

                    case 13:
                        gauge13 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "mainunit": setUnit,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX, "y": setY});
                        if (gauge13 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge13

                        }
                        break;

                    case 14:
                        gauge14 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "mainunit": setUnit,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX, "y": setY});
                        if (gauge14 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge14

                        }
                        break;

                    case 15:
                        gauge15 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "mainunit": setUnit,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX, "y": setY});
                        if (gauge15 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge15

                        }
                        break;

                    case 16:
                        gauge16 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "mainunit": setUnit,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX, "y": setY});
                        if (gauge16 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge16

                        }
                        break;

                    case 17:
                        gauge17 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "mainunit": setUnit,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX, "y": setY});
                        if (gauge17 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge17

                        }
                        break;

                    case 18:
                        gauge18 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "mainunit": setUnit,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX, "y": setY});
                        if (gauge18 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge18

                        }
                        break;

                    case 19:
                        gauge19 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "mainunit": setUnit,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX, "y": setY});
                        if (gauge19 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge19

                        }
                        break;

                    case 20:
                        gauge20 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "mainunit": setUnit,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX, "y": setY});
                        if (gauge20 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge20

                        }
                        break;

                    }
                }

            }


            function finishCreation2(setWidth,setHeight,setX,setY,setMaxValue,setDecPlace,setUnit,setID,setVertGaugeVis,setHoriGaugeVis,setSecValueVis,SetValueObject,SetValuePropertyMain,SetValuePropertySec,Setwarnvaluehigh,Setwarnvaluelow,Setframeclolor,Setbackroundcolor,Settitlecolor,Settitletextcolor,Settextcolor,Setbarcolor,SetTitlefontsize,SetMainfontsize,color1,color2,color3,color4,color5,color6,color7,color8,color9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize1,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal) {
                if (component.status === Component.Ready) {
                    gaugeselect.currentIndex = gaugenumber-1
                    switch (gaugenumber) {
                    case 1:
                        gauge1 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                            "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                            "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                            "maxvalue": setMaxValue,
                                                            "warnvaluehigh": Setwarnvaluehigh,
                                                            "warnvaluelow":Setwarnvaluelow,
                                                            "mainunit": setUnit,
                                                            "titlecolor":Settitlecolor,
                                                            "resettitlecolor":Settitlecolor,
                                                            "framecolor":Setframeclolor,
                                                            "resetbackroundcolor":Setbackroundcolor,
                                                            "textcolor":Settextcolor,
                                                            "titletextcolor":Settitletextcolor,
                                                            "barcolor":Setbarcolor,
                                                            "titlefontsize":SetTitlefontsize,
                                                            "mainfontsize":SetMainfontsize,
                                                            "vertgaugevisible": setVertGaugeVis,
                                                            "horigaugevisible": setHoriGaugeVis,
                                                            "secvaluevisible": setSecValueVis,
                                                            "x": setX,
                                                            "y": setY,
                                                            "gaugecolor1": color1,
                                                            "gaugecolor2": color2,
                                                            "gaugecolor3": color3,
                                                            "gaugecolor4": color4,
                                                            "gaugecolor5": color5,
                                                            "gaugecolor6": color6,
                                                            "gaugecolor7": color7,
                                                            "gaugecolor8": color8,
                                                            "gaugecolor9": color9,
                                                            "shadecolor1": shadecolor1,
                                                            "shadecolor2": shadecolor2,
                                                            "shadecolor3": shadecolor3,
                                                            "shadecolor4": shadecolor4,
                                                            "stepsize": stepsize1,
                                                            "minValueAngle": minValueAngle,
                                                            "maxValueAngle": maxValueAngle,
                                                            "rotation": myRotation
                                                        });
                        if (gauge1 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge1

                        }
                        break;


                    case 2:
                        gauge2 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                            "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                            "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                            "maxvalue": setMaxValue,
                                                            "warnvaluehigh": Setwarnvaluehigh,
                                                            "warnvaluelow":Setwarnvaluelow,
                                                            "mainunit": setUnit,
                                                            "titlecolor":Settitlecolor,
                                                            "resettitlecolor":Settitlecolor,
                                                            "framecolor":Setframeclolor,
                                                            "resetbackroundcolor":Setbackroundcolor,
                                                            "textcolor":Settextcolor,
                                                            "titletextcolor":Settitletextcolor,
                                                            "barcolor":Setbarcolor,
                                                            "titlefontsize":SetTitlefontsize,
                                                            "mainfontsize":SetMainfontsize,
                                                            "vertgaugevisible": setVertGaugeVis,
                                                            "horigaugevisible": setHoriGaugeVis,
                                                            "secvaluevisible": setSecValueVis,
                                                            "x": setX,
                                                            "y": setY,
                                                            "gaugecolor1": color1,
                                                            "gaugecolor2": color2,
                                                            "gaugecolor3": color3,
                                                            "gaugecolor4": color4,
                                                            "gaugecolor5": color5,
                                                            "gaugecolor6": color6,
                                                            "gaugecolor7": color7,
                                                            "gaugecolor8": color8,
                                                            "gaugecolor9": color9,
                                                            "shadecolor1": shadecolor1,
                                                            "shadecolor2": shadecolor2,
                                                            "shadecolor3": shadecolor3,
                                                            "shadecolor4": shadecolor4,
                                                            "stepsize": stepsize1,
                                                            "minValueAngle": minValueAngle,
                                                            "maxValueAngle": maxValueAngle,
                                                            "rotation": myRotation
                                                        });
                        if (gauge2 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge2

                        }
                        break;

                    case 3:
                        gauge3 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                            "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                            "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                            "maxvalue": setMaxValue,
                                                            "warnvaluehigh": Setwarnvaluehigh,
                                                            "warnvaluelow":Setwarnvaluelow,
                                                            "mainunit": setUnit,
                                                            "titlecolor":Settitlecolor,
                                                            "resettitlecolor":Settitlecolor,
                                                            "framecolor":Setframeclolor,
                                                            "resetbackroundcolor":Setbackroundcolor,
                                                            "textcolor":Settextcolor,
                                                            "titletextcolor":Settitletextcolor,
                                                            "barcolor":Setbarcolor,
                                                            "titlefontsize":SetTitlefontsize,
                                                            "mainfontsize":SetMainfontsize,
                                                            "vertgaugevisible": setVertGaugeVis,
                                                            "horigaugevisible": setHoriGaugeVis,
                                                            "secvaluevisible": setSecValueVis,
                                                            "x": setX,
                                                            "y": setY,
                                                            "gaugecolor1": color1,
                                                            "gaugecolor2": color2,
                                                            "gaugecolor3": color3,
                                                            "gaugecolor4": color4,
                                                            "gaugecolor5": color5,
                                                            "gaugecolor6": color6,
                                                            "gaugecolor7": color7,
                                                            "gaugecolor8": color8,
                                                            "gaugecolor9": color9,
                                                            "shadecolor1": shadecolor1,
                                                            "shadecolor2": shadecolor2,
                                                            "shadecolor3": shadecolor3,
                                                            "shadecolor4": shadecolor4,
                                                            "stepsize": stepsize1,
                                                            "minValueAngle": minValueAngle,
                                                            "maxValueAngle": maxValueAngle,
                                                            "rotation": myRotation
                                                        });
                        if (gauge3 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge3
                        }
                        break;

                    case 4:
                        gauge4 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                            "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                            "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                            "maxvalue": setMaxValue,
                                                            "warnvaluehigh": Setwarnvaluehigh,
                                                            "warnvaluelow":Setwarnvaluelow,
                                                            "mainunit": setUnit,
                                                            "titlecolor":Settitlecolor,
                                                            "resettitlecolor":Settitlecolor,
                                                            "framecolor":Setframeclolor,
                                                            "resetbackroundcolor":Setbackroundcolor,
                                                            "textcolor":Settextcolor,
                                                            "titletextcolor":Settitletextcolor,
                                                            "barcolor":Setbarcolor,
                                                            "titlefontsize":SetTitlefontsize,
                                                            "mainfontsize":SetMainfontsize,
                                                            "vertgaugevisible": setVertGaugeVis,
                                                            "horigaugevisible": setHoriGaugeVis,
                                                            "secvaluevisible": setSecValueVis,
                                                            "x": setX,
                                                            "y": setY,
                                                            "gaugecolor1": color1,
                                                            "gaugecolor2": color2,
                                                            "gaugecolor3": color3,
                                                            "gaugecolor4": color4,
                                                            "gaugecolor5": color5,
                                                            "gaugecolor6": color6,
                                                            "gaugecolor7": color7,
                                                            "gaugecolor8": color8,
                                                            "gaugecolor9": color9,
                                                            "shadecolor1": shadecolor1,
                                                            "shadecolor2": shadecolor2,
                                                            "shadecolor3": shadecolor3,
                                                            "shadecolor4": shadecolor4,
                                                            "stepsize": stepsize1,
                                                            "minValueAngle": minValueAngle,
                                                            "maxValueAngle": maxValueAngle,
                                                            "rotation": myRotation
                                                        });
                        if (gauge4 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge4
                        }
                        break;

                    case 5:
                        gauge5 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                            "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                            "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                            "maxvalue": setMaxValue,
                                                            "warnvaluehigh": Setwarnvaluehigh,
                                                            "warnvaluelow":Setwarnvaluelow,
                                                            "mainunit": setUnit,
                                                            "titlecolor":Settitlecolor,
                                                            "resettitlecolor":Settitlecolor,
                                                            "framecolor":Setframeclolor,
                                                            "resetbackroundcolor":Setbackroundcolor,
                                                            "textcolor":Settextcolor,
                                                            "titletextcolor":Settitletextcolor,
                                                            "barcolor":Setbarcolor,
                                                            "titlefontsize":SetTitlefontsize,
                                                            "mainfontsize":SetMainfontsize,
                                                            "vertgaugevisible": setVertGaugeVis,
                                                            "horigaugevisible": setHoriGaugeVis,
                                                            "secvaluevisible": setSecValueVis,
                                                            "x": setX,
                                                            "y": setY,
                                                            "gaugecolor1": color1,
                                                            "gaugecolor2": color2,
                                                            "gaugecolor3": color3,
                                                            "gaugecolor4": color4,
                                                            "gaugecolor5": color5,
                                                            "gaugecolor6": color6,
                                                            "gaugecolor7": color7,
                                                            "gaugecolor8": color8,
                                                            "gaugecolor9": color9,
                                                            "shadecolor1": shadecolor1,
                                                            "shadecolor2": shadecolor2,
                                                            "shadecolor3": shadecolor3,
                                                            "shadecolor4": shadecolor4,
                                                            "stepsize": stepsize1,
                                                            "minValueAngle": minValueAngle,
                                                            "maxValueAngle": maxValueAngle,
                                                            "rotation": myRotation
                                                        });
                        if (gauge5 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge5
                        }
                        break;

                    case 6:
                        gauge6 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                            "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                            "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                            "maxvalue": setMaxValue,
                                                            "warnvaluehigh": Setwarnvaluehigh,
                                                            "warnvaluelow":Setwarnvaluelow,
                                                            "mainunit": setUnit,
                                                            "titlecolor":Settitlecolor,
                                                            "resettitlecolor":Settitlecolor,
                                                            "framecolor":Setframeclolor,
                                                            "resetbackroundcolor":Setbackroundcolor,
                                                            "textcolor":Settextcolor,
                                                            "titletextcolor":Settitletextcolor,
                                                            "barcolor":Setbarcolor,
                                                            "titlefontsize":SetTitlefontsize,
                                                            "mainfontsize":SetMainfontsize,
                                                            "vertgaugevisible": setVertGaugeVis,
                                                            "horigaugevisible": setHoriGaugeVis,
                                                            "secvaluevisible": setSecValueVis,
                                                            "x": setX,
                                                            "y": setY,
                                                            "gaugecolor1": color1,
                                                            "gaugecolor2": color2,
                                                            "gaugecolor3": color3,
                                                            "gaugecolor4": color4,
                                                            "gaugecolor5": color5,
                                                            "gaugecolor6": color6,
                                                            "gaugecolor7": color7,
                                                            "gaugecolor8": color8,
                                                            "gaugecolor9": color9,
                                                            "shadecolor1": shadecolor1,
                                                            "shadecolor2": shadecolor2,
                                                            "shadecolor3": shadecolor3,
                                                            "shadecolor4": shadecolor4,
                                                            "stepsize": stepsize1,
                                                            "minValueAngle": minValueAngle,
                                                            "maxValueAngle": maxValueAngle,
                                                            "rotation": myRotation
                                                        });
                        if (gauge6 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge6
                        }
                        break;

                    case 7:
                        gauge7 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                            "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                            "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                            "maxvalue": setMaxValue,
                                                            "warnvaluehigh": Setwarnvaluehigh,
                                                            "warnvaluelow":Setwarnvaluelow,
                                                            "mainunit": setUnit,
                                                            "titlecolor":Settitlecolor,
                                                            "resettitlecolor":Settitlecolor,
                                                            "framecolor":Setframeclolor,
                                                            "resetbackroundcolor":Setbackroundcolor,
                                                            "textcolor":Settextcolor,
                                                            "titletextcolor":Settitletextcolor,
                                                            "barcolor":Setbarcolor,
                                                            "titlefontsize":SetTitlefontsize,
                                                            "mainfontsize":SetMainfontsize,
                                                            "vertgaugevisible": setVertGaugeVis,
                                                            "horigaugevisible": setHoriGaugeVis,
                                                            "secvaluevisible": setSecValueVis,
                                                            "x": setX,
                                                            "y": setY,
                                                            "gaugecolor1": color1,
                                                            "gaugecolor2": color2,
                                                            "gaugecolor3": color3,
                                                            "gaugecolor4": color4,
                                                            "gaugecolor5": color5,
                                                            "gaugecolor6": color6,
                                                            "gaugecolor7": color7,
                                                            "gaugecolor8": color8,
                                                            "gaugecolor9": color9,
                                                            "shadecolor1": shadecolor1,
                                                            "shadecolor2": shadecolor2,
                                                            "shadecolor3": shadecolor3,
                                                            "shadecolor4": shadecolor4,
                                                            "stepsize": stepsize1,
                                                            "minValueAngle": minValueAngle,
                                                            "maxValueAngle": maxValueAngle,
                                                            "rotation": myRotation
                                                        });
                        if (gauge7 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge7
                        }
                        break;

                    case 8:
                        gauge8 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                            "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                            "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                            "maxvalue": setMaxValue,
                                                            "warnvaluehigh": Setwarnvaluehigh,
                                                            "warnvaluelow":Setwarnvaluelow,
                                                            "mainunit": setUnit,
                                                            "titlecolor":Settitlecolor,
                                                            "resettitlecolor":Settitlecolor,
                                                            "framecolor":Setframeclolor,
                                                            "resetbackroundcolor":Setbackroundcolor,
                                                            "textcolor":Settextcolor,
                                                            "titletextcolor":Settitletextcolor,
                                                            "barcolor":Setbarcolor,
                                                            "titlefontsize":SetTitlefontsize,
                                                            "mainfontsize":SetMainfontsize,
                                                            "vertgaugevisible": setVertGaugeVis,
                                                            "horigaugevisible": setHoriGaugeVis,
                                                            "secvaluevisible": setSecValueVis,
                                                            "x": setX,
                                                            "y": setY,
                                                            "gaugecolor1": color1,
                                                            "gaugecolor2": color2,
                                                            "gaugecolor3": color3,
                                                            "gaugecolor4": color4,
                                                            "gaugecolor5": color5,
                                                            "gaugecolor6": color6,
                                                            "gaugecolor7": color7,
                                                            "gaugecolor8": color8,
                                                            "gaugecolor9": color9,
                                                            "shadecolor1": shadecolor1,
                                                            "shadecolor2": shadecolor2,
                                                            "shadecolor3": shadecolor3,
                                                            "shadecolor4": shadecolor4,
                                                            "stepsize": stepsize1,
                                                            "minValueAngle": minValueAngle,
                                                            "maxValueAngle": maxValueAngle,
                                                            "rotation": myRotation
                                                        });
                        if (gauge8 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge8
                        }
                        break;

                    case 9:
                        gauge9 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                            "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                            "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                            "maxvalue": setMaxValue,
                                                            "warnvaluehigh": Setwarnvaluehigh,
                                                            "warnvaluelow":Setwarnvaluelow,
                                                            "mainunit": setUnit,
                                                            "titlecolor":Settitlecolor,
                                                            "resettitlecolor":Settitlecolor,
                                                            "framecolor":Setframeclolor,
                                                            "resetbackroundcolor":Setbackroundcolor,
                                                            "textcolor":Settextcolor,
                                                            "titletextcolor":Settitletextcolor,
                                                            "barcolor":Setbarcolor,
                                                            "titlefontsize":SetTitlefontsize,
                                                            "mainfontsize":SetMainfontsize,
                                                            "vertgaugevisible": setVertGaugeVis,
                                                            "horigaugevisible": setHoriGaugeVis,
                                                            "secvaluevisible": setSecValueVis,
                                                            "x": setX,
                                                            "y": setY,
                                                            "gaugecolor1": color1,
                                                            "gaugecolor2": color2,
                                                            "gaugecolor3": color3,
                                                            "gaugecolor4": color4,
                                                            "gaugecolor5": color5,
                                                            "gaugecolor6": color6,
                                                            "gaugecolor7": color7,
                                                            "gaugecolor8": color8,
                                                            "gaugecolor9": color9,
                                                            "shadecolor1": shadecolor1,
                                                            "shadecolor2": shadecolor2,
                                                            "shadecolor3": shadecolor3,
                                                            "shadecolor4": shadecolor4,
                                                            "stepsize": stepsize1,
                                                            "minValueAngle": minValueAngle,
                                                            "maxValueAngle": maxValueAngle,
                                                            "rotation": myRotation
                                                        });
                        if (gauge9 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge9
                        }
                        break;

                    case 10:
                        gauge10 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "mainunit": setUnit,
                                                             "titlecolor":Settitlecolor,
                                                             "resettitlecolor":Settitlecolor,
                                                             "framecolor":Setframeclolor,
                                                             "resetbackroundcolor":Setbackroundcolor,
                                                             "textcolor":Settextcolor,
                                                             "titletextcolor":Settitletextcolor,
                                                             "barcolor":Setbarcolor,
                                                             "titlefontsize":SetTitlefontsize,
                                                             "mainfontsize":SetMainfontsize,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX,
                                                             "y": setY,
                                                             "gaugecolor1": color1,
                                                             "gaugecolor2": color2,
                                                             "gaugecolor3": color3,
                                                             "gaugecolor4": color4,
                                                             "gaugecolor5": color5,
                                                             "gaugecolor6": color6,
                                                             "gaugecolor7": color7,
                                                             "gaugecolor8": color8,
                                                             "gaugecolor9": color9,
                                                             "shadecolor1": shadecolor1,
                                                             "shadecolor2": shadecolor2,
                                                             "shadecolor3": shadecolor3,
                                                             "shadecolor4": shadecolor4,
                                                             "stepsize": stepsize1,
                                                             "minValueAngle": minValueAngle,
                                                             "maxValueAngle": maxValueAngle,
                                                             "rotation": myRotation
                                                         });
                        if (gauge10 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge10
                        }
                        break;

                    case 11:
                        gauge11 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "mainunit": setUnit,
                                                             "titlecolor":Settitlecolor,
                                                             "resettitlecolor":Settitlecolor,
                                                             "framecolor":Setframeclolor,
                                                             "resetbackroundcolor":Setbackroundcolor,
                                                             "textcolor":Settextcolor,
                                                             "titletextcolor":Settitletextcolor,
                                                             "barcolor":Setbarcolor,
                                                             "titlefontsize":SetTitlefontsize,
                                                             "mainfontsize":SetMainfontsize,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX,
                                                             "y": setY,
                                                             "gaugecolor1": color1,
                                                             "gaugecolor2": color2,
                                                             "gaugecolor3": color3,
                                                             "gaugecolor4": color4,
                                                             "gaugecolor5": color5,
                                                             "gaugecolor6": color6,
                                                             "gaugecolor7": color7,
                                                             "gaugecolor8": color8,
                                                             "gaugecolor9": color9,
                                                             "shadecolor1": shadecolor1,
                                                             "shadecolor2": shadecolor2,
                                                             "shadecolor3": shadecolor3,
                                                             "shadecolor4": shadecolor4,
                                                             "stepsize": stepsize1,
                                                             "minValueAngle": minValueAngle,
                                                             "maxValueAngle": maxValueAngle,
                                                             "rotation": myRotation
                                                         });
                        if (gauge11 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge11
                        }
                        break;

                    case 12:
                        gauge12 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "mainunit": setUnit,
                                                             "titlecolor":Settitlecolor,
                                                             "resettitlecolor":Settitlecolor,
                                                             "framecolor":Setframeclolor,
                                                             "resetbackroundcolor":Setbackroundcolor,
                                                             "textcolor":Settextcolor,
                                                             "titletextcolor":Settitletextcolor,
                                                             "barcolor":Setbarcolor,
                                                             "titlefontsize":SetTitlefontsize,
                                                             "mainfontsize":SetMainfontsize,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX,
                                                             "y": setY,
                                                             "gaugecolor1": color1,
                                                             "gaugecolor2": color2,
                                                             "gaugecolor3": color3,
                                                             "gaugecolor4": color4,
                                                             "gaugecolor5": color5,
                                                             "gaugecolor6": color6,
                                                             "gaugecolor7": color7,
                                                             "gaugecolor8": color8,
                                                             "gaugecolor9": color9,
                                                             "shadecolor1": shadecolor1,
                                                             "shadecolor2": shadecolor2,
                                                             "shadecolor3": shadecolor3,
                                                             "shadecolor4": shadecolor4,
                                                             "stepsize": stepsize1,
                                                             "minValueAngle": minValueAngle,
                                                             "maxValueAngle": maxValueAngle,
                                                             "rotation": myRotation
                                                         });
                        if (gauge12 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge12
                        }
                        break;

                    case 13:
                        gauge13 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "mainunit": setUnit,
                                                             "titlecolor":Settitlecolor,
                                                             "resettitlecolor":Settitlecolor,
                                                             "framecolor":Setframeclolor,
                                                             "resetbackroundcolor":Setbackroundcolor,
                                                             "textcolor":Settextcolor,
                                                             "titletextcolor":Settitletextcolor,
                                                             "barcolor":Setbarcolor,
                                                             "titlefontsize":SetTitlefontsize,
                                                             "mainfontsize":SetMainfontsize,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX,
                                                             "y": setY,
                                                             "gaugecolor1": color1,
                                                             "gaugecolor2": color2,
                                                             "gaugecolor3": color3,
                                                             "gaugecolor4": color4,
                                                             "gaugecolor5": color5,
                                                             "gaugecolor6": color6,
                                                             "gaugecolor7": color7,
                                                             "gaugecolor8": color8,
                                                             "gaugecolor9": color9,
                                                             "shadecolor1": shadecolor1,
                                                             "shadecolor2": shadecolor2,
                                                             "shadecolor3": shadecolor3,
                                                             "shadecolor4": shadecolor4,
                                                             "stepsize": stepsize1,
                                                             "minValueAngle": minValueAngle,
                                                             "maxValueAngle": maxValueAngle,
                                                             "rotation": myRotation
                                                         });
                        if (gauge13 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge13
                        }
                        break;

                    case 14:
                        gauge14 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "mainunit": setUnit,
                                                             "titlecolor":Settitlecolor,
                                                             "resettitlecolor":Settitlecolor,
                                                             "framecolor":Setframeclolor,
                                                             "resetbackroundcolor":Setbackroundcolor,
                                                             "textcolor":Settextcolor,
                                                             "titletextcolor":Settitletextcolor,
                                                             "barcolor":Setbarcolor,
                                                             "titlefontsize":SetTitlefontsize,
                                                             "mainfontsize":SetMainfontsize,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX,
                                                             "y": setY,
                                                             "gaugecolor1": color1,
                                                             "gaugecolor2": color2,
                                                             "gaugecolor3": color3,
                                                             "gaugecolor4": color4,
                                                             "gaugecolor5": color5,
                                                             "gaugecolor6": color6,
                                                             "gaugecolor7": color7,
                                                             "gaugecolor8": color8,
                                                             "gaugecolor9": color9,
                                                             "shadecolor1": shadecolor1,
                                                             "shadecolor2": shadecolor2,
                                                             "shadecolor3": shadecolor3,
                                                             "shadecolor4": shadecolor4,
                                                             "stepsize": stepsize1,
                                                             "minValueAngle": minValueAngle,
                                                             "maxValueAngle": maxValueAngle,
                                                             "rotation": myRotation
                                                         });
                        if (gauge14 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge14
                        }
                        break;

                    case 15:
                        gauge15 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "mainunit": setUnit,
                                                             "titlecolor":Settitlecolor,
                                                             "resettitlecolor":Settitlecolor,
                                                             "framecolor":Setframeclolor,
                                                             "resetbackroundcolor":Setbackroundcolor,
                                                             "textcolor":Settextcolor,
                                                             "titletextcolor":Settitletextcolor,
                                                             "barcolor":Setbarcolor,
                                                             "titlefontsize":SetTitlefontsize,
                                                             "mainfontsize":SetMainfontsize,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX,
                                                             "y": setY,
                                                             "gaugecolor1": color1,
                                                             "gaugecolor2": color2,
                                                             "gaugecolor3": color3,
                                                             "gaugecolor4": color4,
                                                             "gaugecolor5": color5,
                                                             "gaugecolor6": color6,
                                                             "gaugecolor7": color7,
                                                             "gaugecolor8": color8,
                                                             "gaugecolor9": color9,
                                                             "shadecolor1": shadecolor1,
                                                             "shadecolor2": shadecolor2,
                                                             "shadecolor3": shadecolor3,
                                                             "shadecolor4": shadecolor4,
                                                             "stepsize": stepsize1,
                                                             "minValueAngle": minValueAngle,
                                                             "maxValueAngle": maxValueAngle,
                                                             "rotation": myRotation
                                                         });
                        if (gauge15 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge15
                        }
                        break;

                    case 16:
                        gauge16 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "mainunit": setUnit,
                                                             "titlecolor":Settitlecolor,
                                                             "resettitlecolor":Settitlecolor,
                                                             "framecolor":Setframeclolor,
                                                             "resetbackroundcolor":Setbackroundcolor,
                                                             "textcolor":Settextcolor,
                                                             "titletextcolor":Settitletextcolor,
                                                             "barcolor":Setbarcolor,
                                                             "titlefontsize":SetTitlefontsize,
                                                             "mainfontsize":SetMainfontsize,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX,
                                                             "y": setY,
                                                             "gaugecolor1": color1,
                                                             "gaugecolor2": color2,
                                                             "gaugecolor3": color3,
                                                             "gaugecolor4": color4,
                                                             "gaugecolor5": color5,
                                                             "gaugecolor6": color6,
                                                             "gaugecolor7": color7,
                                                             "gaugecolor8": color8,
                                                             "gaugecolor9": color9,
                                                             "shadecolor1": shadecolor1,
                                                             "shadecolor2": shadecolor2,
                                                             "shadecolor3": shadecolor3,
                                                             "shadecolor4": shadecolor4,
                                                             "stepsize": stepsize1,
                                                             "minValueAngle": minValueAngle,
                                                             "maxValueAngle": maxValueAngle,
                                                             "rotation": myRotation
                                                         });
                        if (gauge16 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge16
                        }
                        break;

                    case 17:
                        gauge17 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "mainunit": setUnit,
                                                             "titlecolor":Settitlecolor,
                                                             "resettitlecolor":Settitlecolor,
                                                             "framecolor":Setframeclolor,
                                                             "resetbackroundcolor":Setbackroundcolor,
                                                             "textcolor":Settextcolor,
                                                             "titletextcolor":Settitletextcolor,
                                                             "barcolor":Setbarcolor,
                                                             "titlefontsize":SetTitlefontsize,
                                                             "mainfontsize":SetMainfontsize,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX,
                                                             "y": setY,
                                                             "gaugecolor1": color1,
                                                             "gaugecolor2": color2,
                                                             "gaugecolor3": color3,
                                                             "gaugecolor4": color4,
                                                             "gaugecolor5": color5,
                                                             "gaugecolor6": color6,
                                                             "gaugecolor7": color7,
                                                             "gaugecolor8": color8,
                                                             "gaugecolor9": color9,
                                                             "shadecolor1": shadecolor1,
                                                             "shadecolor2": shadecolor2,
                                                             "shadecolor3": shadecolor3,
                                                             "shadecolor4": shadecolor4,
                                                             "stepsize": stepsize1,
                                                             "minValueAngle": minValueAngle,
                                                             "maxValueAngle": maxValueAngle,
                                                             "rotation": myRotation
                                                         });
                        if (gauge17 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge17
                        }
                        break;

                    case 18:
                        gauge18 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "mainunit": setUnit,
                                                             "titlecolor":Settitlecolor,
                                                             "resettitlecolor":Settitlecolor,
                                                             "framecolor":Setframeclolor,
                                                             "resetbackroundcolor":Setbackroundcolor,
                                                             "textcolor":Settextcolor,
                                                             "titletextcolor":Settitletextcolor,
                                                             "barcolor":Setbarcolor,
                                                             "titlefontsize":SetTitlefontsize,
                                                             "mainfontsize":SetMainfontsize,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX,
                                                             "y": setY,
                                                             "gaugecolor1": color1,
                                                             "gaugecolor2": color2,
                                                             "gaugecolor3": color3,
                                                             "gaugecolor4": color4,
                                                             "gaugecolor5": color5,
                                                             "gaugecolor6": color6,
                                                             "gaugecolor7": color7,
                                                             "gaugecolor8": color8,
                                                             "gaugecolor9": color9,
                                                             "shadecolor1": shadecolor1,
                                                             "shadecolor2": shadecolor2,
                                                             "shadecolor3": shadecolor3,
                                                             "shadecolor4": shadecolor4,
                                                             "stepsize": stepsize1,
                                                             "minValueAngle": minValueAngle,
                                                             "maxValueAngle": maxValueAngle,
                                                             "rotation": myRotation
                                                         });
                        if (gauge18 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge18
                        }
                        break;

                    case 19:
                        gauge19 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "mainunit": setUnit,
                                                             "titlecolor":Settitlecolor,
                                                             "resettitlecolor":Settitlecolor,
                                                             "framecolor":Setframeclolor,
                                                             "resetbackroundcolor":Setbackroundcolor,
                                                             "textcolor":Settextcolor,
                                                             "titletextcolor":Settitletextcolor,
                                                             "barcolor":Setbarcolor,
                                                             "titlefontsize":SetTitlefontsize,
                                                             "mainfontsize":SetMainfontsize,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX,
                                                             "y": setY,
                                                             "gaugecolor1": color1,
                                                             "gaugecolor2": color2,
                                                             "gaugecolor3": color3,
                                                             "gaugecolor4": color4,
                                                             "gaugecolor5": color5,
                                                             "gaugecolor6": color6,
                                                             "gaugecolor7": color7,
                                                             "gaugecolor8": color8,
                                                             "gaugecolor9": color9,
                                                             "shadecolor1": shadecolor1,
                                                             "shadecolor2": shadecolor2,
                                                             "shadecolor3": shadecolor3,
                                                             "shadecolor4": shadecolor4,
                                                             "stepsize": stepsize1,
                                                             "minValueAngle": minValueAngle,
                                                             "maxValueAngle": maxValueAngle,
                                                             "rotation": myRotation
                                                         });
                        if (gauge19 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge19
                        }
                        break;

                    case 20:
                        gauge20 = component.createObject(appwindow, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
                                                             "mainvalue": Qt.binding(function(){return SetValueObject[SetValuePropertyMain].toFixed(setDecPlace)}),
                                                             "secvalue": Qt.binding(function(){return SetValueObject[SetValuePropertySec].toFixed(setDecPlace)}),
                                                             "maxvalue": setMaxValue,
                                                             "warnvaluehigh": Setwarnvaluehigh,
                                                             "warnvaluelow":Setwarnvaluelow,
                                                             "mainunit": setUnit,
                                                             "titlecolor":Settitlecolor,
                                                             "resettitlecolor":Settitlecolor,
                                                             "framecolor":Setframeclolor,
                                                             "resetbackroundcolor":Setbackroundcolor,
                                                             "textcolor":Settextcolor,
                                                             "titletextcolor":Settitletextcolor,
                                                             "barcolor":Setbarcolor,
                                                             "titlefontsize":SetTitlefontsize,
                                                             "mainfontsize":SetMainfontsize,
                                                             "vertgaugevisible": setVertGaugeVis,
                                                             "horigaugevisible": setHoriGaugeVis,
                                                             "secvaluevisible": setSecValueVis,
                                                             "x": setX,
                                                             "y": setY,
                                                             "gaugecolor1": color1,
                                                             "gaugecolor2": color2,
                                                             "gaugecolor3": color3,
                                                             "gaugecolor4": color4,
                                                             "gaugecolor5": color5,
                                                             "gaugecolor6": color6,
                                                             "gaugecolor7": color7,
                                                             "gaugecolor8": color8,
                                                             "gaugecolor9": color9,
                                                             "shadecolor1": shadecolor1,
                                                             "shadecolor2": shadecolor2,
                                                             "shadecolor3": shadecolor3,
                                                             "shadecolor4": shadecolor4,
                                                             "stepsize": stepsize1,
                                                             "minValueAngle": minValueAngle,
                                                             "maxValueAngle": maxValueAngle,
                                                             "rotation": myRotation
                                                         });
                        if (gauge20 === null) {
                            // Error Handling
                            console.log("Error creating object");                        }else{
                            tempgauge = gauge20
                        }
                        break;

                    }
                    //                    setValuesWhenClicked()
                    refreshing=false

                }

            }
        }
    }

}

































/*##^## Designer {
    D{i:3;anchors_height:480;anchors_width:300;anchors_x:1025;anchors_y:0}D{i:2;anchors_height:30;anchors_x:1023;anchors_y:0}
D{i:62;anchors_height:200;anchors_width:200}
}
 ##^##*/
