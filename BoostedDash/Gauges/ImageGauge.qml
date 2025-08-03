//import QtQuick 2.8
//import QtGraphicalEffects 1.0
//import QtQuick.Controls 2.1
//import QtQuick.Controls.Styles 1.4
//import QtQuick.Extras 1.4

import QtQuick 2.8
import QtQuick.Controls 2.3
import QtQuick.Controls.Styles 1.4
import QtQuick.Extras 1.4
import QtQuick.Layouts 1.1
import QtQuick.Dialogs 1.0
import "../Gauges"


Rectangle {
    objectName: "ImageGauge"
    id: initialID
    width: 250
    height: 200
//    z: -2147483647

    property string imgSource:""
    property string myID:""
    property string decPlace:""
    property string valuePropertyMain:""
    property string valuePropertySec:""
    property string title
    property string mainunit
    property string vertgaugevisible
    property string horigaugevisible
    property string secvaluevisible
    property string secvalue
    property string maintextvalue
    property string mainvalue
    property string maxvalue
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
    //    property alias rotation : rotation
    property int saveInitialSizes: 0
    property int initialX: 0
    property int initialY: 0
    property int initialWidth: 0
    property int initialHeight: 0
    property int initialtitlefontsize: 0
    property int initialmainfontsize:0


    property string imgSource1

    FileDialog {
        id: fileDialog
        selectMultiple: false
        title: "Please choose a file"
        folder: shortcuts.home
        onAccepted: {
            console.log("You chose: " + fileDialog.fileUrls)
            imgSource1=fileDialog.fileUrls[0].substring(7)
            imgSource="file://"+Connect.copyFileToStore(imgSource1,imgSource1)
            bgImage.source = imgSource
            fileDialog.visible=false

        }
        onRejected: {
            console.log("Canceled")
            fileDialog.visible=false
        }
    }

    MouseArea
    {
        anchors.fill:parent
        onDoubleClicked:{
            if(view.currentIndex<5){
                //                    view.currentIndex++
            }else{
                view.currentIndex = 6
            }

        }
        onClicked: {
            if (mouse.button === Qt.RightButton)
                contextMenu.popup()
        }
        onPressAndHold: {
            contextMenu.popup()
        }
        Action {
            id: settingsAction
            text: "Select Image"
            shortcut: "ctrl+s"
            //                iconSource: "images/editcut.png"
            //                iconName: "edit-cut"
            onTriggered: {

                fileDialog.visible=true
            }


        }

        Menu {
            id: contextMenu
            MenuItem { action: settingsAction }

            //                MenuItem { text: "Copy" }
            //                MenuItem { text: "Paste" }
        }
    }


    Image {
        id: bgImage
        z:0
        source: imgSource
        anchors.fill: parent


    }
    Item {
        //Set the colors of backround and Boarder
        id: colorsettings
        function set()
        {
            initialID.color = resetbackroundcolor;
            initialID.border.color = framecolor;
        }
        function setsizes(){
            if(saveInitialSizes == 0){
                saveInitialSizes = 1;
                initialID.initialWidth = initialID.width;
                initialID.initialHeight = initialID.height;
                initialID.initialX = initialID.x;
                initialID.initialY = initialID.y;
                initialID.initialtitlefontsize = initialID.titlefontsize;
                initialID.initialmainfontsize = initialID.mainfontsize;
            }

            initialID.width = initialID.initialWidth * Connect.getWidth() /1024;
            initialID.height = initialID.initialHeight * Connect.getWidth() /1024;
//            console.log(initialID.initialWidth);
//            console.log(Connect.getWidth());
//            console.log(initialID.initialHeight);
//            console.log(Connect.getHeight());
            initialID.titlefontsize = initialID.initialtitlefontsize * Connect.getHeight() /600;
            initialID.mainfontsize = initialID.initialmainfontsize * Connect.getHeight() /600;
            initialID.x = initialID.initialX * Connect.getWidth() /1024;
            initialID.y = initialID.initialY * Connect.getHeight() /600;

        }
        function increase(){
            initialID.initialWidth = initialWidth * 5 / 4;
            initialID.initialHeight = initialHeight  * 5 / 4;

            initialID.width = initialID.initialWidth * Connect.getWidth() /1024;
            initialID.height = initialID.initialHeight * Connect.getWidth() /1024;
            //            initialID.x = initialID.initialX * Connect.getWidth() /1024;
            //            initialID.y = initialID.initialY * Connect.getHeight() /600;

        }
        function increaseFonts(){
            initialID.initialtitlefontsize = initialID.initialtitlefontsize  * 11 / 10;
            initialID.initialmainfontsize = initialID.initialmainfontsize  * 11 / 10;
            initialID.titlefontsize = initialID.initialtitlefontsize * Connect.getHeight() /600;
            initialID.mainfontsize = initialID.initialmainfontsize * Connect.getHeight() /600;

        }
        function decrease(){
            initialID.initialWidth = initialWidth * 4 / 5;
            initialID.initialHeight = initialHeight  * 4 / 5;
            initialID.width = initialID.initialWidth * Connect.getWidth() /1024;
            initialID.height = initialID.initialHeight * Connect.getHeight() /600;
            //            initialID.x = initialID.initialX * Connect.getWidth() /1024;
            //            initialID.y = initialID.initialY * Connect.getHeight() /600;

        }
        function decreaseFonts(){
            initialID.initialtitlefontsize = initialID.initialtitlefontsize  * 10 / 11;
            initialID.initialmainfontsize = initialID.initialmainfontsize  * 10 / 11;
            initialID.titlefontsize = initialID.initialtitlefontsize * Connect.getHeight() /600;
            initialID.mainfontsize = initialID.initialmainfontsize * Connect.getHeight() /600;

        }

    }
    Connections{
        target: Dashboard
        onOrientationChanged:{
            colorsettings.setsizes();
        }
    }
    Rectangle {
        id : plusRect
        color: "transparent"
        anchors.right: parent.right
        anchors.top: parent.top
        width: parent.width / 2
        height: parent.height / 2
        MouseArea {
            id: mouseAreaPlus

            property int oldMouseX

            anchors.fill: parent
            hoverEnabled: true

            onDoubleClicked: {
                plusRect.color = "lightblue"
                colorsettings.increase();
                plusRect.color = "transparent"
            }

        }

    }
    Rectangle {
        id : minusRect
        color: "transparent"
        anchors.right: parent.right
        anchors.bottom: parent.bottom
        width: parent.width / 2
        height: parent.height / 2
        MouseArea {
            id: mouseAreaMinus
            anchors.fill: parent
            hoverEnabled: true

            onDoubleClicked: {
                minusRect.color = "lightblue"
                colorsettings.decrease();
                minusRect.color = "transparent"
            }

        }
    }
}

