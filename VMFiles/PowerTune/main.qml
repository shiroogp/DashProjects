import QtQuick 2.11
import QtQuick.Controls 2.3
import QtQuick.Controls.Styles 1.4
import QtQuick.Extras 1.4
import QtQuick.Layouts 1.1
import com.powertune 1.0
import "qml"

ApplicationWindow {
    id: applicationWindow


    visible: true
    width: 1200
    height: 600
    minimumWidth: 800
    minimumHeight: 480
    title: qsTr("BoostedGarage ") + Dashboard.Platform + "  V 1.0"
    // visibility: "FullScreen"
    color: "black"
    property int loadingScreenFile: 1
    onWidthChanged: {
        console.log("Width changed...orientation is " + width>height?"landscape":"portrait")
        Connect.setHeight(height);
        Connect.setWidth(width);
        Connect.setOrientation();
    }

    onHeightChanged: {
        console.log("Width changed...orientation is " + width>height?"landscape":"portrait")
        Connect.setHeight(height);
        Connect.setWidth(width);
        Connect.setOrientation();
    }

    Item {
        id: name
        Component.onCompleted: Connect.checkifraspberrypi()
    }
    SwipeView {
        id: view

        currentIndex: 0
        //        anchors.left: minus.right
        //        anchors.top: parent.top
        //        anchors.bottom: parent.bottom
        //        anchors.right: plus.left
        anchors.fill: parent
        Component.onCompleted: Connect.readavailabledashfiles()
        property bool secondPageLoaded: false
        property bool thirdPageLoaded: false
        property bool fourthPageLoaded: false
        property bool fifthPageLoaded: false
        property bool sixthPageLoaded: false

        Loader {

            id: firstPageLoader
            source: "qrc:/Intro.qml"
            onFocusChanged: {
                if (focus == true){
                    Connect.pageNo(view.currentIndex)
                    firstPageLoader.visible = firstPageLoader.status == Loader.Ready
                }else{
                    firstPageLoader.visible = false
                }
            }

        }

        Loader {
            id: secondPageLoader
            onFocusChanged: {
                if (focus == true){
                    Connect.pageNo(view.currentIndex)
                    secondPageLoader.visible = secondPageLoader.status == Loader.Ready
                }else{
                    secondPageLoader.visible = false
                }
            }

            //                        asynchronous: true
            //            source: "qrc:/qml/main2.qml"
            //            source: "qrc:/Gauges/MyElement.qml"

        }
        Loader {
            id: thirdPageLoader
            //                        asynchronous: true
            onFocusChanged: {
                if (focus == true){
                    Connect.pageNo(view.currentIndex)
                    thirdPageLoader.visible = thirdPageLoader.status == Loader.Ready
                }else{
                    thirdPageLoader.visible = false
                }
            }
            source: ""
        }

        Loader {
            id: fourthPageLoader
            //            asynchronous: true
            onFocusChanged: {
                if (focus == true){
                    Connect.pageNo(view.currentIndex)
                    fourthPageLoader.visible = fourthPageLoader.status == Loader.Ready
                }else{
                    fourthPageLoader.visible = false
                }
                //                if (focus == true && view.fourthPageLoaded == false){
                //                    Connect.pageNo(view.currentIndex)
                //                    view.fourthPageLoaded = true
                //                }else{
                //                    Connect.updatePageNo(view.currentIndex)

                //                }
            }
            source: ""
        }

        Loader {
            id: fifthPageLoader
            //            asynchronous: true
            onFocusChanged: {
                if (focus == true){
                    Connect.pageNo(view.currentIndex)
                    fifthPageLoader.visible = fifthPageLoader.status == Loader.Ready
                }else{
                    fifthPageLoader.visible = false
                }
            }
            source: ""
        }

        Loader {
            id: sixthPageLoader
            //            asynchronous: true
            onFocusChanged: {
                if (focus == true){
                    Connect.pageNo(view.currentIndex)
                    sixthPageLoader.visible = sixthPageLoader.status == Loader.Ready
                }else{
                    sixthPageLoader.visible = false
                }
            }
            source: ""

        }

        Item {
            id:lastPage
            SerialSettings{}
        }
    }



    //        PieMenu {
    ////            id: pieMenu

    ////            MenuItem {
    ////                text: "Customise"

    ////                onTriggered: sourceselect.visible = true;
    ////            }
    //            id: pieMenu
    //            triggerMode: TriggerMode.TriggerOnClick

    //            MenuItem {
    ////                iconSource: "qrc:/images/piemenu-rgb-" + (pieMenu.currentIndex === 0 ? "pressed" : "normal") + ".png"
    //                onTriggered: pieMenuImage.source = "qrc:/images/piemenu-image-rgb.jpg"
    //            }

    //        }

    Rectangle {
        id: sourceselect
        visible: false
        width: applicationWindow.width / 2
        height: 50
        color: "transparent"
        anchors.horizontalCenter: parent.horizontalCenter
        anchors.top: parent.top
        anchors.topMargin: 0
        property int loadingCombo: 1
        ComboBox {
            id: dash4
            width: applicationWindow.width / 6
            model: ["Screen Toggle", "Adaptronic","Charts", "GPS", "PowerFC Sensors","User Dash 1","User Dash 2","User Dash 3","G-Force","Dyno","Mediaplayer","Main Dash","Boosted","User Dash 4"]
            font.pixelSize: applicationWindow.height / 50
            property bool initialized: true
            x: 94
            y: 0
            property string fileName:""

            onCurrentIndexChanged:{
                dash5.visible = false
                if (applicationWindow.loadingScreenFile == 0){
                    if(currentIndex == 5 || currentIndex == 6 || currentIndex == 7 || currentIndex == 12 || currentIndex == 13 ){
                        sourceselect.loadingCombo = 1
                        if(currentIndex == 5){
                            fileName = Connect.getfilename1()
                        } else if(currentIndex == 6){
                            fileName = Connect.getfilename2()
                        } else if(currentIndex == 7){
                            fileName = Connect.getfilename3()
                        } else if(currentIndex == 12){
                            fileName = Connect.getfilename4()
                        } else if(currentIndex == 13){
                            fileName = Connect.getfilename5()
                        }
                        for (var i=0; i<dash5.model.length; i++){
                            if(dash5.textAt(i) == fileName){
                                dash5.currentIndex = i
                                break;
                            }
                        }

                        dash5.visible = true
                        sourceselect.loadingCombo = 0

                    }else{
                        Connect.pageNo(view.currentIndex)
                        Connect.sourceIndex(0)
                        Connect.sourceIndex(currentIndex)
                        sourceselect.visible = false
                    }
                }
            }
            //  Component.onCompleted: {select1.selDash4() }
        }
        ComboBox {
            id: dash5
            width: applicationWindow.width / 6
            visible: false
            model: Dashboard.dashfiles
            font.pixelSize: applicationWindow.height / 50
            anchors.right: applyScreen.left

            property bool initialized: true
            x: 280
            y: 0
            onCurrentIndexChanged:{
                if(sourceselect.loadingCombo == 0){
                    if(dash4.currentIndex == 5){
                        Connect.setfilename1(dash5.textAt(dash5.currentIndex))
                    } else if(dash4.currentIndex == 6){
                        Connect.setfilename2(dash5.textAt(dash5.currentIndex))
                    } else if(dash4.currentIndex == 7){
                        Connect.setfilename3(dash5.textAt(dash5.currentIndex))
                    } else if(dash4.currentIndex == 12){
                        Connect.setfilename4(dash5.textAt(dash5.currentIndex))
                    } else if(dash4.currentIndex == 13){
                        Connect.setfilename5(dash5.textAt(dash5.currentIndex))
                    }
                    Connect.pageNo(view.currentIndex)
                    Connect.sourceIndex(0)
                    Connect.sourceIndex(dash4.currentIndex)
                    sourceselect.visible = false}
            }
            //  Component.onCompleted: {select1.selDash4() }
        }
        Text { text: ""
            color : "white" }
        Rectangle
        {
            id:applyScreen
            width:applicationWindow.width / 22
            height:applicationWindow.height / 15
            anchors.right: parent.right
            x: 470
            y: 0
            color:"red"
            MouseArea
            {
                anchors.fill:parent
                onClicked:{

                    Connect.pageNo(view.currentIndex)
                    Connect.sourceIndex(0)
                    Connect.sourceIndex(dash4.currentIndex)
                    sourceselect.visible = false
                }
            }
        }

    }
    //Setting the scale of the speedo and temp gauges according to metric or imperial
    Item {
        id: units
        function unitadjust()
        {

            if (Dashboard.units == "imperial") {speedoopacity.target = speedoNeedlemph,speedometer.maximumValue = 200,speedoNeedlemph.visible = true, speedoNeedlekph.visible = false,revneedele.visible = true;tripunits.text = " mi",odounit.text = " mi" };
            if (Dashboard.units == "metric") {speedoopacity.target = speedoNeedlekph,speedometer.maximumValue = 320,speedoNeedlemph.visible = false, speedoNeedlekph.visible = true,tripunits.text = " km" ,odounit.text = " km"};

        }


    }
    Item {
        id: applysource
        function sourceapply()
        {

        }

    }
    Item {
        id: userDash
        anchors.fill: parent



        ComboBox{
            id: dashvalue
            width: 200
            model: Dashboard.maindashsetup
            visible:false
            Component.onCompleted: {Connect.readMaindashsetup()}
        }



    }




    Rectangle
    {
        id:minus
        width:parent.width/20
        height:20
        anchors.left:parent.left
        anchors.top:parent.top
        anchors.bottom:parent.bottom
        color:"transparent"
        opacity: 10
        Image {
            id: imageLeft
            width: 50
            height: 300
            opacity: 0.5
            anchors.horizontalCenter: parent.horizontalCenter
            anchors.verticalCenter: parent.verticalCenter
            source: "graphics/dashLeft.png"
            fillMode: Image.PreserveAspectFit
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
            onClicked:{

                if(view.currentIndex>0){
                    view.currentIndex--
                }else{
                    view.currentIndex = 5
                }
            }
            onPressAndHold: {
                contextLMenu.popup()
            }
            Action {
                id: custLAction
                text: "Select Dash"
                shortcut: "ctrl+x"
                //                iconSource: "images/editcut.png"
                //                iconName: "edit-cut"
                onTriggered: {
                    applicationWindow.loadingScreenFile = 1
                    dash5.visible = false
                    sourceselect.loadingCombo = 1
                    if(view.currentIndex == 0){
                        indicator.fileName = Connect.getdash1()
                    } else if(view.currentIndex == 1){
                        indicator.fileName = Connect.getdash6()
                    } else if(view.currentIndex == 2){
                        indicator.fileName = Connect.getdash5()
                    } else if(view.currentIndex == 3){
                        indicator.fileName = Connect.getdash2()
                    } else if(view.currentIndex == 4){
                        indicator.fileName = Connect.getdash3()
                    } else if(view.currentIndex == 5){
                        indicator.fileName = Connect.getdash4()
                    }
                    for (var i=0; i<dash4.model.length; i++){
                        if(dash4.textAt(i) == indicator.fileName){
                            dash4.currentIndex = i
                            break;
                        }
                    }
                    applicationWindow.loadingScreenFile = 0
                    dash4.fileName = ""
                    if(dash4.currentIndex == 5){
                        dash4.fileName = Connect.getfilename1()
                    } else if(dash4.currentIndex == 6){
                        dash4.fileName = Connect.getfilename2()
                    } else if(dash4.currentIndex == 7){
                        dash4.fileName = Connect.getfilename3()
                    } else if(dash4.currentIndex == 12){
                        dash4.fileName = Connect.getfilename4()
                    } else if(dash4.currentIndex == 13){
                        dash4.fileName = Connect.getfilename5()
                    }
                    if(dash4.fileName != ""){
                        for (var i=0; i<dash5.model.length; i++){
                            if(dash5.textAt(i) == dash4.fileName){
                                dash5.currentIndex = i
                                break;
                            }
                        }

                        dash5.visible = true
                    }
                    sourceselect.loadingCombo = 0
                    sourceselect.visible = true
                }
            }

            Action {
                id: writeLAction
                text: "Apply changes"
                shortcut: "ctrl+a"
                //                iconSource: "images/editcut.png"
                //                iconName: "edit-cut"
                onTriggered: {
                    applicationWindow.loadingScreenFile = 1
                    dash5.visible = false
                    sourceselect.loadingCombo = 1
                    if(view.currentIndex == 0){
                        indicator.fileName = Connect.getdash1()
                    } else if(view.currentIndex == 1){
                        indicator.fileName = Connect.getdash6()
                    } else if(view.currentIndex == 2){
                        indicator.fileName = Connect.getdash5()
                    } else if(view.currentIndex == 3){
                        indicator.fileName = Connect.getdash2()
                    } else if(view.currentIndex == 4){
                        indicator.fileName = Connect.getdash3()
                    } else if(view.currentIndex == 5){
                        indicator.fileName = Connect.getdash4()
                    }
                    for (var i=0; i<dash4.model.length; i++){
                        if(dash4.textAt(i) == indicator.fileName){
                            dash4.currentIndex = i
                            break;
                        }
                    }
                    applicationWindow.loadingScreenFile = 0
                    dash4.fileName = ""
                    if(dash4.currentIndex == 5){
                        dash4.fileName = Connect.getfilename1()
                    } else if(dash4.currentIndex == 6){
                        dash4.fileName = Connect.getfilename2()
                    } else if(dash4.currentIndex == 7){
                        dash4.fileName = Connect.getfilename3()
                    } else if(dash4.currentIndex == 12){
                        dash4.fileName = Connect.getfilename4()
                    } else if(dash4.currentIndex == 13){
                        dash4.fileName = Connect.getfilename5()
                    }
                    if(dash4.fileName != ""){
                        for (var i=0; i<dash5.model.length; i++){
                            if(dash5.textAt(i) == dash4.fileName){
                                dash5.currentIndex = i
                                break;
                            }
                        }

                        dash5.visible = true
                    }
                    sourceselect.loadingCombo = 0
                    sourceselect.visible = false

                    var outfileText = "";
                    if(view.currentIndex == 0){
                        for (var ii=0; ii<firstPageLoader.children[0].children.length; ii++){
                            if(firstPageLoader.children[0].children[ii].objectName == "SquareGauge" || firstPageLoader.children[0].children[ii].objectName == "RoundGauge" || firstPageLoader.children[0].children[ii].objectName == "SpeedoGauge" || firstPageLoader.children[0].children[ii].objectName == "TachoGauge" || firstPageLoader.children[0].children[ii].objectName == "ImageGauge"){
                            console.log(firstPageLoader.children[0].children[ii].objectName)//: "SquareGauge");
                            console.log(firstPageLoader.children[0].children[ii].x*1024/Connect.getWidth())//: "SquareGauge");
                            console.log(firstPageLoader.children[0].children[ii].y*600/Connect.getHeight())//: "SquareGauge");
                            console.log(firstPageLoader.children[0].children[ii].fullCircl)//: "SquareGauge");

                                outfileText+=
                                        firstPageLoader.children[0].children[ii].width*1024/Connect.getWidth()+","+
                                        firstPageLoader.children[0].children[ii].height*600/Connect.getHeight()+","+
                                        firstPageLoader.children[0].children[ii].x*1024/Connect.getWidth()+","+
                                        firstPageLoader.children[0].children[ii].y*600/Connect.getHeight()+","+
                                        firstPageLoader.children[0].children[ii].maxvalue+","+
                                        firstPageLoader.children[0].children[ii].decPlace+","+
                                        firstPageLoader.children[0].children[ii].mainunit+","+
                                        firstPageLoader.children[0].children[ii].myID+","+
                                        firstPageLoader.children[0].children[ii].vertgaugevisible+","+
                                        firstPageLoader.children[0].children[ii].horigaugevisible+","+
                                        firstPageLoader.children[0].children[ii].secvaluevisible+","+
                                        "Dashboard,"+
                                        firstPageLoader.children[0].children[ii].valuePropertyMain+","+
                                        firstPageLoader.children[0].children[ii].valuePropertySec+","+
                                        firstPageLoader.children[0].children[ii].warnvaluehigh+","+
                                        firstPageLoader.children[0].children[ii].warnvaluelow+","+
                                        firstPageLoader.children[0].children[ii].framecolor+","+
                                        firstPageLoader.children[0].children[ii].resetbackroundcolor+","+
                                        firstPageLoader.children[0].children[ii].titlecolor+","+
                                        firstPageLoader.children[0].children[ii].titletextcolor+","+
                                        firstPageLoader.children[0].children[ii].textcolor+","+
                                        firstPageLoader.children[0].children[ii].barcolor+","+
                                        firstPageLoader.children[0].children[ii].titlefontsize*600/Connect.getHeight()+","+
                                        firstPageLoader.children[0].children[ii].mainfontsize*600/Connect.getHeight()+","+
                                        firstPageLoader.children[0].children[ii].objectName+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor1+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor2+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor3+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor4+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor5+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor6+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor7+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor8+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor9+","+
                                        firstPageLoader.children[0].children[ii].shadecolor1+","+
                                        firstPageLoader.children[0].children[ii].shadecolor2+","+
                                        firstPageLoader.children[0].children[ii].shadecolor3+","+
                                        firstPageLoader.children[0].children[ii].shadecolor4+","+
                                        firstPageLoader.children[0].children[ii].stepsize+","+
                                        firstPageLoader.children[0].children[ii].minValueAngle+","+
                                        firstPageLoader.children[0].children[ii].maxValueAngle+","+
                                        firstPageLoader.children[0].children[ii].rotation+","+
                                        firstPageLoader.children[0].children[ii].fullCirc+","+
                                        firstPageLoader.children[0].children[ii].subDivVal+","+
                                        firstPageLoader.children[0].children[ii].imgSource.substring(7)+"\n";
                            }
                        }
                    } else if(view.currentIndex == 1){
                        for (var ii=0; ii<secondPageLoader.children[0].children.length; ii++){
                            if(secondPageLoader.children[0].children[ii].objectName == "SquareGauge" || secondPageLoader.children[0].children[ii].objectName == "RoundGauge" || secondPageLoader.children[0].children[ii].objectName == "SpeedoGauge" || secondPageLoader.children[0].children[ii].objectName == "TachoGauge" || secondPageLoader.children[0].children[ii].objectName == "ImageGauge"){
                            console.log(secondPageLoader.children[0].children[ii].objectName)//: "SquareGauge");
                            console.log(secondPageLoader.children[0].children[ii].x*1024/Connect.getWidth())//: "SquareGauge");
                            console.log(secondPageLoader.children[0].children[ii].y*600/Connect.getHeight())//: "SquareGauge");
                            console.log(secondPageLoader.children[0].children[ii].fullCircl)//: "SquareGauge");

                                outfileText+=
                                        secondPageLoader.children[0].children[ii].width*1024/Connect.getWidth()+","+
                                        secondPageLoader.children[0].children[ii].height*600/Connect.getHeight()+","+
                                        secondPageLoader.children[0].children[ii].x*1024/Connect.getWidth()+","+
                                        secondPageLoader.children[0].children[ii].y*600/Connect.getHeight()+","+
                                        secondPageLoader.children[0].children[ii].maxvalue+","+
                                        secondPageLoader.children[0].children[ii].decPlace+","+
                                        secondPageLoader.children[0].children[ii].mainunit+","+
                                        secondPageLoader.children[0].children[ii].myID+","+
                                        secondPageLoader.children[0].children[ii].vertgaugevisible+","+
                                        secondPageLoader.children[0].children[ii].horigaugevisible+","+
                                        secondPageLoader.children[0].children[ii].secvaluevisible+","+
                                        "Dashboard,"+
                                        secondPageLoader.children[0].children[ii].valuePropertyMain+","+
                                        secondPageLoader.children[0].children[ii].valuePropertySec+","+
                                        secondPageLoader.children[0].children[ii].warnvaluehigh+","+
                                        secondPageLoader.children[0].children[ii].warnvaluelow+","+
                                        secondPageLoader.children[0].children[ii].framecolor+","+
                                        secondPageLoader.children[0].children[ii].resetbackroundcolor+","+
                                        secondPageLoader.children[0].children[ii].titlecolor+","+
                                        secondPageLoader.children[0].children[ii].titletextcolor+","+
                                        secondPageLoader.children[0].children[ii].textcolor+","+
                                        secondPageLoader.children[0].children[ii].barcolor+","+
                                        secondPageLoader.children[0].children[ii].titlefontsize*600/Connect.getHeight()+","+
                                        secondPageLoader.children[0].children[ii].mainfontsize*600/Connect.getHeight()+","+
                                        secondPageLoader.children[0].children[ii].objectName+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor1+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor2+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor3+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor4+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor5+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor6+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor7+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor8+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor9+","+
                                        secondPageLoader.children[0].children[ii].shadecolor1+","+
                                        secondPageLoader.children[0].children[ii].shadecolor2+","+
                                        secondPageLoader.children[0].children[ii].shadecolor3+","+
                                        secondPageLoader.children[0].children[ii].shadecolor4+","+
                                        secondPageLoader.children[0].children[ii].stepsize+","+
                                        secondPageLoader.children[0].children[ii].minValueAngle+","+
                                        secondPageLoader.children[0].children[ii].maxValueAngle+","+
                                        secondPageLoader.children[0].children[ii].rotation+","+
                                        secondPageLoader.children[0].children[ii].fullCirc+","+
                                        secondPageLoader.children[0].children[ii].subDivVal+","+
                                        secondPageLoader.children[0].children[ii].imgSource.substring(7)+"\n";
                            }
                        }
                    } else if(view.currentIndex == 2){
                        for (var ii=0; ii<thirdPageLoader.children[0].children.length; ii++){
                            if(thirdPageLoader.children[0].children[ii].objectName == "SquareGauge" || thirdPageLoader.children[0].children[ii].objectName == "RoundGauge" || thirdPageLoader.children[0].children[ii].objectName == "SpeedoGauge" || thirdPageLoader.children[0].children[ii].objectName == "TachoGauge" || thirdPageLoader.children[0].children[ii].objectName == "ImageGauge"){
                            console.log(thirdPageLoader.children[0].children[ii].objectName)//: "SquareGauge");
                            console.log(thirdPageLoader.children[0].children[ii].x*1024/Connect.getWidth())//: "SquareGauge");
                            console.log(thirdPageLoader.children[0].children[ii].y*600/Connect.getHeight())//: "SquareGauge");
                            console.log(thirdPageLoader.children[0].children[ii].fullCircl)//: "SquareGauge");

                                outfileText+=
                                        thirdPageLoader.children[0].children[ii].width*1024/Connect.getWidth()+","+
                                        thirdPageLoader.children[0].children[ii].height*600/Connect.getHeight()+","+
                                        thirdPageLoader.children[0].children[ii].x*1024/Connect.getWidth()+","+
                                        thirdPageLoader.children[0].children[ii].y*600/Connect.getHeight()+","+
                                        thirdPageLoader.children[0].children[ii].maxvalue+","+
                                        thirdPageLoader.children[0].children[ii].decPlace+","+
                                        thirdPageLoader.children[0].children[ii].mainunit+","+
                                        thirdPageLoader.children[0].children[ii].myID+","+
                                        thirdPageLoader.children[0].children[ii].vertgaugevisible+","+
                                        thirdPageLoader.children[0].children[ii].horigaugevisible+","+
                                        thirdPageLoader.children[0].children[ii].secvaluevisible+","+
                                        "Dashboard,"+
                                        thirdPageLoader.children[0].children[ii].valuePropertyMain+","+
                                        thirdPageLoader.children[0].children[ii].valuePropertySec+","+
                                        thirdPageLoader.children[0].children[ii].warnvaluehigh+","+
                                        thirdPageLoader.children[0].children[ii].warnvaluelow+","+
                                        thirdPageLoader.children[0].children[ii].framecolor+","+
                                        thirdPageLoader.children[0].children[ii].resetbackroundcolor+","+
                                        thirdPageLoader.children[0].children[ii].titlecolor+","+
                                        thirdPageLoader.children[0].children[ii].titletextcolor+","+
                                        thirdPageLoader.children[0].children[ii].textcolor+","+
                                        thirdPageLoader.children[0].children[ii].barcolor+","+
                                        thirdPageLoader.children[0].children[ii].titlefontsize*600/Connect.getHeight()+","+
                                        thirdPageLoader.children[0].children[ii].mainfontsize*600/Connect.getHeight()+","+
                                        thirdPageLoader.children[0].children[ii].objectName+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor1+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor2+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor3+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor4+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor5+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor6+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor7+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor8+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor9+","+
                                        thirdPageLoader.children[0].children[ii].shadecolor1+","+
                                        thirdPageLoader.children[0].children[ii].shadecolor2+","+
                                        thirdPageLoader.children[0].children[ii].shadecolor3+","+
                                        thirdPageLoader.children[0].children[ii].shadecolor4+","+
                                        thirdPageLoader.children[0].children[ii].stepsize+","+
                                        thirdPageLoader.children[0].children[ii].minValueAngle+","+
                                        thirdPageLoader.children[0].children[ii].maxValueAngle+","+
                                        thirdPageLoader.children[0].children[ii].rotation+","+
                                        thirdPageLoader.children[0].children[ii].fullCirc+","+
                                        thirdPageLoader.children[0].children[ii].subDivVal+","+
                                        thirdPageLoader.children[0].children[ii].imgSource.substring(7)+"\n";
                            }
                        }
                    } else if(view.currentIndex == 3){
                        for (var ii=0; ii<fourthPageLoader.children[0].children.length; ii++){
                            if(fourthPageLoader.children[0].children[ii].objectName == "SquareGauge" || fourthPageLoader.children[0].children[ii].objectName == "RoundGauge" || fourthPageLoader.children[0].children[ii].objectName == "SpeedoGauge" || fourthPageLoader.children[0].children[ii].objectName == "TachoGauge" || fourthPageLoader.children[0].children[ii].objectName == "ImageGauge"){
                            console.log(fourthPageLoader.children[0].children[ii].objectName)//: "SquareGauge");
                            console.log(fourthPageLoader.children[0].children[ii].x*1024/Connect.getWidth())//: "SquareGauge");
                            console.log(fourthPageLoader.children[0].children[ii].y*600/Connect.getHeight())//: "SquareGauge");
                            console.log(fourthPageLoader.children[0].children[ii].fullCircl)//: "SquareGauge");

                                outfileText+=
                                        fourthPageLoader.children[0].children[ii].width*1024/Connect.getWidth()+","+
                                        fourthPageLoader.children[0].children[ii].height*600/Connect.getHeight()+","+
                                        fourthPageLoader.children[0].children[ii].x*1024/Connect.getWidth()+","+
                                        fourthPageLoader.children[0].children[ii].y*600/Connect.getHeight()+","+
                                        fourthPageLoader.children[0].children[ii].maxvalue+","+
                                        fourthPageLoader.children[0].children[ii].decPlace+","+
                                        fourthPageLoader.children[0].children[ii].mainunit+","+
                                        fourthPageLoader.children[0].children[ii].myID+","+
                                        fourthPageLoader.children[0].children[ii].vertgaugevisible+","+
                                        fourthPageLoader.children[0].children[ii].horigaugevisible+","+
                                        fourthPageLoader.children[0].children[ii].secvaluevisible+","+
                                        "Dashboard,"+
                                        fourthPageLoader.children[0].children[ii].valuePropertyMain+","+
                                        fourthPageLoader.children[0].children[ii].valuePropertySec+","+
                                        fourthPageLoader.children[0].children[ii].warnvaluehigh+","+
                                        fourthPageLoader.children[0].children[ii].warnvaluelow+","+
                                        fourthPageLoader.children[0].children[ii].framecolor+","+
                                        fourthPageLoader.children[0].children[ii].resetbackroundcolor+","+
                                        fourthPageLoader.children[0].children[ii].titlecolor+","+
                                        fourthPageLoader.children[0].children[ii].titletextcolor+","+
                                        fourthPageLoader.children[0].children[ii].textcolor+","+
                                        fourthPageLoader.children[0].children[ii].barcolor+","+
                                        fourthPageLoader.children[0].children[ii].titlefontsize*600/Connect.getHeight()+","+
                                        fourthPageLoader.children[0].children[ii].mainfontsize*600/Connect.getHeight()+","+
                                        fourthPageLoader.children[0].children[ii].objectName+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor1+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor2+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor3+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor4+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor5+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor6+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor7+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor8+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor9+","+
                                        fourthPageLoader.children[0].children[ii].shadecolor1+","+
                                        fourthPageLoader.children[0].children[ii].shadecolor2+","+
                                        fourthPageLoader.children[0].children[ii].shadecolor3+","+
                                        fourthPageLoader.children[0].children[ii].shadecolor4+","+
                                        fourthPageLoader.children[0].children[ii].stepsize+","+
                                        fourthPageLoader.children[0].children[ii].minValueAngle+","+
                                        fourthPageLoader.children[0].children[ii].maxValueAngle+","+
                                        fourthPageLoader.children[0].children[ii].rotation+","+
                                        fourthPageLoader.children[0].children[ii].fullCirc+","+
                                        fourthPageLoader.children[0].children[ii].subDivVal+","+
                                        fourthPageLoader.children[0].children[ii].imgSource.substring(7)+"\n";
                            }
                        }
                    } else if(view.currentIndex == 4){
                        for (var ii=0; ii<fifthPageLoader.children[0].children.length; ii++){
                            if(fifthPageLoader.children[0].children[ii].objectName == "SquareGauge" || fifthPageLoader.children[0].children[ii].objectName == "RoundGauge" || fifthPageLoader.children[0].children[ii].objectName == "SpeedoGauge" || fifthPageLoader.children[0].children[ii].objectName == "TachoGauge" || fifthPageLoader.children[0].children[ii].objectName == "ImageGauge"){
                            console.log(fifthPageLoader.children[0].children[ii].objectName)//: "SquareGauge");
                            console.log(fifthPageLoader.children[0].children[ii].x*1024/Connect.getWidth())//: "SquareGauge");
                            console.log(fifthPageLoader.children[0].children[ii].y*600/Connect.getHeight())//: "SquareGauge");
                            console.log(fifthPageLoader.children[0].children[ii].fullCircl)//: "SquareGauge");

                                outfileText+=
                                        fifthPageLoader.children[0].children[ii].width*1024/Connect.getWidth()+","+
                                        fifthPageLoader.children[0].children[ii].height*600/Connect.getHeight()+","+
                                        fifthPageLoader.children[0].children[ii].x*1024/Connect.getWidth()+","+
                                        fifthPageLoader.children[0].children[ii].y*600/Connect.getHeight()+","+
                                        fifthPageLoader.children[0].children[ii].maxvalue+","+
                                        fifthPageLoader.children[0].children[ii].decPlace+","+
                                        fifthPageLoader.children[0].children[ii].mainunit+","+
                                        fifthPageLoader.children[0].children[ii].myID+","+
                                        fifthPageLoader.children[0].children[ii].vertgaugevisible+","+
                                        fifthPageLoader.children[0].children[ii].horigaugevisible+","+
                                        fifthPageLoader.children[0].children[ii].secvaluevisible+","+
                                        "Dashboard,"+
                                        fifthPageLoader.children[0].children[ii].valuePropertyMain+","+
                                        fifthPageLoader.children[0].children[ii].valuePropertySec+","+
                                        fifthPageLoader.children[0].children[ii].warnvaluehigh+","+
                                        fifthPageLoader.children[0].children[ii].warnvaluelow+","+
                                        fifthPageLoader.children[0].children[ii].framecolor+","+
                                        fifthPageLoader.children[0].children[ii].resetbackroundcolor+","+
                                        fifthPageLoader.children[0].children[ii].titlecolor+","+
                                        fifthPageLoader.children[0].children[ii].titletextcolor+","+
                                        fifthPageLoader.children[0].children[ii].textcolor+","+
                                        fifthPageLoader.children[0].children[ii].barcolor+","+
                                        fifthPageLoader.children[0].children[ii].titlefontsize*600/Connect.getHeight()+","+
                                        fifthPageLoader.children[0].children[ii].mainfontsize*600/Connect.getHeight()+","+
                                        fifthPageLoader.children[0].children[ii].objectName+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor1+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor2+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor3+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor4+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor5+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor6+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor7+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor8+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor9+","+
                                        fifthPageLoader.children[0].children[ii].shadecolor1+","+
                                        fifthPageLoader.children[0].children[ii].shadecolor2+","+
                                        fifthPageLoader.children[0].children[ii].shadecolor3+","+
                                        fifthPageLoader.children[0].children[ii].shadecolor4+","+
                                        fifthPageLoader.children[0].children[ii].stepsize+","+
                                        fifthPageLoader.children[0].children[ii].minValueAngle+","+
                                        fifthPageLoader.children[0].children[ii].maxValueAngle+","+
                                        fifthPageLoader.children[0].children[ii].rotation+","+
                                        fifthPageLoader.children[0].children[ii].fullCirc+","+
                                        fifthPageLoader.children[0].children[ii].subDivVal+","+
                                        fifthPageLoader.children[0].children[ii].imgSource.substring(7)+"\n";
                            }
                        }
                    } else if(view.currentIndex == 5){
                        for (var ii=0; ii<sixthPageLoader.children[0].children.length; ii++){
                            if(sixthPageLoader.children[0].children[ii].objectName == "SquareGauge" || sixthPageLoader.children[0].children[ii].objectName == "RoundGauge" || sixthPageLoader.children[0].children[ii].objectName == "SpeedoGauge" || sixthPageLoader.children[0].children[ii].objectName == "TachoGauge" || sixthPageLoader.children[0].children[ii].objectName == "ImageGauge"){
                            console.log(sixthPageLoader.children[0].children[ii].objectName)//: "SquareGauge");
                            console.log(sixthPageLoader.children[0].children[ii].x*1024/Connect.getWidth())//: "SquareGauge");
                            console.log(sixthPageLoader.children[0].children[ii].y*600/Connect.getHeight())//: "SquareGauge");
                            console.log(sixthPageLoader.children[0].children[ii].fullCircl)//: "SquareGauge");

                                outfileText+=
                                        sixthPageLoader.children[0].children[ii].width*1024/Connect.getWidth()+","+
                                        sixthPageLoader.children[0].children[ii].height*600/Connect.getHeight()+","+
                                        sixthPageLoader.children[0].children[ii].x*1024/Connect.getWidth()+","+
                                        sixthPageLoader.children[0].children[ii].y*600/Connect.getHeight()+","+
                                        sixthPageLoader.children[0].children[ii].maxvalue+","+
                                        sixthPageLoader.children[0].children[ii].decPlace+","+
                                        sixthPageLoader.children[0].children[ii].mainunit+","+
                                        sixthPageLoader.children[0].children[ii].myID+","+
                                        sixthPageLoader.children[0].children[ii].vertgaugevisible+","+
                                        sixthPageLoader.children[0].children[ii].horigaugevisible+","+
                                        sixthPageLoader.children[0].children[ii].secvaluevisible+","+
                                        "Dashboard,"+
                                        sixthPageLoader.children[0].children[ii].valuePropertyMain+","+
                                        sixthPageLoader.children[0].children[ii].valuePropertySec+","+
                                        sixthPageLoader.children[0].children[ii].warnvaluehigh+","+
                                        sixthPageLoader.children[0].children[ii].warnvaluelow+","+
                                        sixthPageLoader.children[0].children[ii].framecolor+","+
                                        sixthPageLoader.children[0].children[ii].resetbackroundcolor+","+
                                        sixthPageLoader.children[0].children[ii].titlecolor+","+
                                        sixthPageLoader.children[0].children[ii].titletextcolor+","+
                                        sixthPageLoader.children[0].children[ii].textcolor+","+
                                        sixthPageLoader.children[0].children[ii].barcolor+","+
                                        sixthPageLoader.children[0].children[ii].titlefontsize*600/Connect.getHeight()+","+
                                        sixthPageLoader.children[0].children[ii].mainfontsize*600/Connect.getHeight()+","+
                                        sixthPageLoader.children[0].children[ii].objectName+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor1+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor2+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor3+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor4+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor5+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor6+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor7+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor8+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor9+","+
                                        sixthPageLoader.children[0].children[ii].shadecolor1+","+
                                        sixthPageLoader.children[0].children[ii].shadecolor2+","+
                                        sixthPageLoader.children[0].children[ii].shadecolor3+","+
                                        sixthPageLoader.children[0].children[ii].shadecolor4+","+
                                        sixthPageLoader.children[0].children[ii].stepsize+","+
                                        sixthPageLoader.children[0].children[ii].minValueAngle+","+
                                        sixthPageLoader.children[0].children[ii].maxValueAngle+","+
                                        sixthPageLoader.children[0].children[ii].rotation+","+
                                        sixthPageLoader.children[0].children[ii].fullCirc+","+
                                        sixthPageLoader.children[0].children[ii].subDivVal+","+
                                        sixthPageLoader.children[0].children[ii].imgSource.substring(7)+"\n";
                            }
                        }
                    }
                    Connect.writeDashFile(dash4.fileName,outfileText);
                }
            }

            Action {
                id: settingsLAction
                text: "Settings"
                shortcut: "ctrl+s"
                //                iconSource: "images/editcut.png"
                //                iconName: "edit-cut"
                onTriggered: view.currentIndex = 6
            }

            Menu {
                id: contextLMenu
                width: applicationWindow.width / 10
                MenuItem { action: custLAction
                width: contextLMenu.width}
                MenuItem { action: writeLAction
                width: contextLMenu.width}
                MenuItem { action: settingsLAction
                width: contextLMenu.width}

                //                MenuItem { text: "Copy" }
                //                MenuItem { text: "Paste" }
            }
        }


//        MouseArea
//        {
//            anchors.fill:parent

//        }

    }
    //    Rectangle
    //    {
    //        id:load
    //        width:parent.width/10
    //        height:40
    //        anchors.bottom:parent.bottom
    //        color:"yellow"
    //        anchors.horizontalCenter: parent.horizontalCenter
    //        MouseArea
    //        {
    //            anchors.fill:parent
    //            onClicked:{
    //                switch(view.currentIndex){
    //                case 0:
    //                    firstPageLoader.source = "qrc:/Gauges/Screentoggle.qml"
    //                    break
    //                case 1:
    //                    secondPageLoader.source = "qrc:/Gauges/Screentoggle.qml"
    //                    break
    //                case 2:
    //                    thirdPageLoader.source = "qrc:/Gauges/Screentoggle.qml"
    //                    break
    //                case 3:
    //                    fourthPageLoader.source = "qrc:/Gauges/Screentoggle.qml"
    //                    break
    //                case 4:
    //                    fifthPageLoader.source = "qrc:/Gauges/Screentoggle.qml"
    //                    break
    //                case 5:
    //                    sixthPageLoader.source = "qrc:/Gauges/Screentoggle.qml"
    //                    break
    //                }
    //                Connect.loadDash(view.currentIndex)
    //                //firstPageLoader.source
    //            }
    //        }
    //    }

    Rectangle
    {
        id:plus
        width:parent.width/20
        height:20
        anchors.right:parent.right
        anchors.top:parent.top
        anchors.bottom:parent.bottom
        color:"transparent"
        opacity: 10
        Image {
            id: imageRight
            width: 50
            height: 300
            opacity: 0.5
            anchors.horizontalCenter: parent.horizontalCenter
            anchors.verticalCenter: parent.verticalCenter
            source: "graphics/dashRight.png"
            fillMode: Image.PreserveAspectFit
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
            onClicked:{
                if(view.currentIndex<5){
                    view.currentIndex++
                }else{
                    view.currentIndex = 0
                }

            }
            onPressAndHold: {
                contextRMenu.popup()
            }
            Action {
                id: custRAction
                text: "Select Dash"
                shortcut: "ctrl+x"
                //                iconSource: "images/editcut.png"
                //                iconName: "edit-cut"
                onTriggered: {
                    applicationWindow.loadingScreenFile = 1
                    dash5.visible = false
                    sourceselect.loadingCombo = 1
                    if(view.currentIndex == 0){
                        indicator.fileName = Connect.getdash1()
                    } else if(view.currentIndex == 1){
                        indicator.fileName = Connect.getdash6()
                    } else if(view.currentIndex == 2){
                        indicator.fileName = Connect.getdash5()
                    } else if(view.currentIndex == 3){
                        indicator.fileName = Connect.getdash2()
                    } else if(view.currentIndex == 4){
                        indicator.fileName = Connect.getdash3()
                    } else if(view.currentIndex == 5){
                        indicator.fileName = Connect.getdash4()
                    }
                    for (var i=0; i<dash4.model.length; i++){
                        if(dash4.textAt(i) == indicator.fileName){
                            dash4.currentIndex = i
                            break;
                        }
                    }
                    applicationWindow.loadingScreenFile = 0
                    dash4.fileName = ""
                    if(dash4.currentIndex == 5){
                        dash4.fileName = Connect.getfilename1()
                    } else if(dash4.currentIndex == 6){
                        dash4.fileName = Connect.getfilename2()
                    } else if(dash4.currentIndex == 7){
                        dash4.fileName = Connect.getfilename3()
                    } else if(dash4.currentIndex == 12){
                        dash4.fileName = Connect.getfilename4()
                    } else if(dash4.currentIndex == 13){
                        dash4.fileName = Connect.getfilename5()
                    }
                    if(dash4.fileName != ""){
                        for (var i=0; i<dash5.model.length; i++){
                            if(dash5.textAt(i) == dash4.fileName){
                                dash5.currentIndex = i
                                break;
                            }
                        }

                        dash5.visible = true
                    }
                    sourceselect.loadingCombo = 0
                    sourceselect.visible = true
                }
            }

            Action {
                id: writeRAction
                text: "Apply changes"
                shortcut: "ctrl+a"
                //                iconSource: "images/editcut.png"
                //                iconName: "edit-cut"
                onTriggered: {
                    applicationWindow.loadingScreenFile = 1
                    dash5.visible = false
                    sourceselect.loadingCombo = 1
                    if(view.currentIndex == 0){
                        indicator.fileName = Connect.getdash1()
                    } else if(view.currentIndex == 1){
                        indicator.fileName = Connect.getdash6()
                    } else if(view.currentIndex == 2){
                        indicator.fileName = Connect.getdash5()
                    } else if(view.currentIndex == 3){
                        indicator.fileName = Connect.getdash2()
                    } else if(view.currentIndex == 4){
                        indicator.fileName = Connect.getdash3()
                    } else if(view.currentIndex == 5){
                        indicator.fileName = Connect.getdash4()
                    }
                    for (var i=0; i<dash4.model.length; i++){
                        if(dash4.textAt(i) == indicator.fileName){
                            dash4.currentIndex = i
                            break;
                        }
                    }
                    applicationWindow.loadingScreenFile = 0
                    dash4.fileName = ""
                    if(dash4.currentIndex == 5){
                        dash4.fileName = Connect.getfilename1()
                    } else if(dash4.currentIndex == 6){
                        dash4.fileName = Connect.getfilename2()
                    } else if(dash4.currentIndex == 7){
                        dash4.fileName = Connect.getfilename3()
                    } else if(dash4.currentIndex == 12){
                        dash4.fileName = Connect.getfilename4()
                    } else if(dash4.currentIndex == 13){
                        dash4.fileName = Connect.getfilename5()
                    }
                    if(dash4.fileName != ""){
                        for (var i=0; i<dash5.model.length; i++){
                            if(dash5.textAt(i) == dash4.fileName){
                                dash5.currentIndex = i
                                break;
                            }
                        }

                        dash5.visible = true
                    }
                    sourceselect.loadingCombo = 0
                    sourceselect.visible = false

                    var outfileText = "";
                    if(view.currentIndex == 0){
                        for (var ii=0; ii<firstPageLoader.children[0].children.length; ii++){
                            if(firstPageLoader.children[0].children[ii].objectName == "SquareGauge" || firstPageLoader.children[0].children[ii].objectName == "RoundGauge" || firstPageLoader.children[0].children[ii].objectName == "SpeedoGauge" || firstPageLoader.children[0].children[ii].objectName == "TachoGauge" || firstPageLoader.children[0].children[ii].objectName == "ImageGauge"){
                            console.log(firstPageLoader.children[0].children[ii].objectName)//: "SquareGauge");
                            console.log(firstPageLoader.children[0].children[ii].x*1024/Connect.getWidth())//: "SquareGauge");
                            console.log(firstPageLoader.children[0].children[ii].y*600/Connect.getHeight())//: "SquareGauge");
                            console.log(firstPageLoader.children[0].children[ii].fullCircl)//: "SquareGauge");

                                outfileText+=
                                        firstPageLoader.children[0].children[ii].width*1024/Connect.getWidth()+","+
                                        firstPageLoader.children[0].children[ii].height*600/Connect.getHeight()+","+
                                        firstPageLoader.children[0].children[ii].x*1024/Connect.getWidth()+","+
                                        firstPageLoader.children[0].children[ii].y*600/Connect.getHeight()+","+
                                        firstPageLoader.children[0].children[ii].maxvalue+","+
                                        firstPageLoader.children[0].children[ii].decPlace+","+
                                        firstPageLoader.children[0].children[ii].mainunit+","+
                                        firstPageLoader.children[0].children[ii].myID+","+
                                        firstPageLoader.children[0].children[ii].vertgaugevisible+","+
                                        firstPageLoader.children[0].children[ii].horigaugevisible+","+
                                        firstPageLoader.children[0].children[ii].secvaluevisible+","+
                                        "Dashboard,"+
                                        firstPageLoader.children[0].children[ii].valuePropertyMain+","+
                                        firstPageLoader.children[0].children[ii].valuePropertySec+","+
                                        firstPageLoader.children[0].children[ii].warnvaluehigh+","+
                                        firstPageLoader.children[0].children[ii].warnvaluelow+","+
                                        firstPageLoader.children[0].children[ii].framecolor+","+
                                        firstPageLoader.children[0].children[ii].resetbackroundcolor+","+
                                        firstPageLoader.children[0].children[ii].titlecolor+","+
                                        firstPageLoader.children[0].children[ii].titletextcolor+","+
                                        firstPageLoader.children[0].children[ii].textcolor+","+
                                        firstPageLoader.children[0].children[ii].barcolor+","+
                                        firstPageLoader.children[0].children[ii].titlefontsize*600/Connect.getHeight()+","+
                                        firstPageLoader.children[0].children[ii].mainfontsize*600/Connect.getHeight()+","+
                                        firstPageLoader.children[0].children[ii].objectName+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor1+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor2+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor3+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor4+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor5+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor6+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor7+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor8+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor9+","+
                                        firstPageLoader.children[0].children[ii].shadecolor1+","+
                                        firstPageLoader.children[0].children[ii].shadecolor2+","+
                                        firstPageLoader.children[0].children[ii].shadecolor3+","+
                                        firstPageLoader.children[0].children[ii].shadecolor4+","+
                                        firstPageLoader.children[0].children[ii].stepsize+","+
                                        firstPageLoader.children[0].children[ii].minValueAngle+","+
                                        firstPageLoader.children[0].children[ii].maxValueAngle+","+
                                        firstPageLoader.children[0].children[ii].rotation+","+
                                        firstPageLoader.children[0].children[ii].fullCirc+","+
                                        firstPageLoader.children[0].children[ii].subDivVal+","+
                                        firstPageLoader.children[0].children[ii].imgSource.substring(7)+"\n";
                            }
                        }
                    } else if(view.currentIndex == 1){
                        for (var ii=0; ii<secondPageLoader.children[0].children.length; ii++){
                            if(secondPageLoader.children[0].children[ii].objectName == "SquareGauge" || secondPageLoader.children[0].children[ii].objectName == "RoundGauge" || secondPageLoader.children[0].children[ii].objectName == "SpeedoGauge" || secondPageLoader.children[0].children[ii].objectName == "TachoGauge" || secondPageLoader.children[0].children[ii].objectName == "ImageGauge"){
                            console.log(secondPageLoader.children[0].children[ii].objectName)//: "SquareGauge");
                            console.log(secondPageLoader.children[0].children[ii].x*1024/Connect.getWidth())//: "SquareGauge");
                            console.log(secondPageLoader.children[0].children[ii].y*600/Connect.getHeight())//: "SquareGauge");
                            console.log(secondPageLoader.children[0].children[ii].fullCircl)//: "SquareGauge");

                                outfileText+=
                                        secondPageLoader.children[0].children[ii].width*1024/Connect.getWidth()+","+
                                        secondPageLoader.children[0].children[ii].height*600/Connect.getHeight()+","+
                                        secondPageLoader.children[0].children[ii].x*1024/Connect.getWidth()+","+
                                        secondPageLoader.children[0].children[ii].y*600/Connect.getHeight()+","+
                                        secondPageLoader.children[0].children[ii].maxvalue+","+
                                        secondPageLoader.children[0].children[ii].decPlace+","+
                                        secondPageLoader.children[0].children[ii].mainunit+","+
                                        secondPageLoader.children[0].children[ii].myID+","+
                                        secondPageLoader.children[0].children[ii].vertgaugevisible+","+
                                        secondPageLoader.children[0].children[ii].horigaugevisible+","+
                                        secondPageLoader.children[0].children[ii].secvaluevisible+","+
                                        "Dashboard,"+
                                        secondPageLoader.children[0].children[ii].valuePropertyMain+","+
                                        secondPageLoader.children[0].children[ii].valuePropertySec+","+
                                        secondPageLoader.children[0].children[ii].warnvaluehigh+","+
                                        secondPageLoader.children[0].children[ii].warnvaluelow+","+
                                        secondPageLoader.children[0].children[ii].framecolor+","+
                                        secondPageLoader.children[0].children[ii].resetbackroundcolor+","+
                                        secondPageLoader.children[0].children[ii].titlecolor+","+
                                        secondPageLoader.children[0].children[ii].titletextcolor+","+
                                        secondPageLoader.children[0].children[ii].textcolor+","+
                                        secondPageLoader.children[0].children[ii].barcolor+","+
                                        secondPageLoader.children[0].children[ii].titlefontsize*600/Connect.getHeight()+","+
                                        secondPageLoader.children[0].children[ii].mainfontsize*600/Connect.getHeight()+","+
                                        secondPageLoader.children[0].children[ii].objectName+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor1+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor2+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor3+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor4+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor5+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor6+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor7+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor8+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor9+","+
                                        secondPageLoader.children[0].children[ii].shadecolor1+","+
                                        secondPageLoader.children[0].children[ii].shadecolor2+","+
                                        secondPageLoader.children[0].children[ii].shadecolor3+","+
                                        secondPageLoader.children[0].children[ii].shadecolor4+","+
                                        secondPageLoader.children[0].children[ii].stepsize+","+
                                        secondPageLoader.children[0].children[ii].minValueAngle+","+
                                        secondPageLoader.children[0].children[ii].maxValueAngle+","+
                                        secondPageLoader.children[0].children[ii].rotation+","+
                                        secondPageLoader.children[0].children[ii].fullCirc+","+
                                        secondPageLoader.children[0].children[ii].subDivVal+","+
                                        secondPageLoader.children[0].children[ii].imgSource.substring(7)+"\n";
                            }
                        }
                    } else if(view.currentIndex == 2){
                        for (var ii=0; ii<thirdPageLoader.children[0].children.length; ii++){
                            if(thirdPageLoader.children[0].children[ii].objectName == "SquareGauge" || thirdPageLoader.children[0].children[ii].objectName == "RoundGauge" || thirdPageLoader.children[0].children[ii].objectName == "SpeedoGauge" || thirdPageLoader.children[0].children[ii].objectName == "TachoGauge" || thirdPageLoader.children[0].children[ii].objectName == "ImageGauge"){
                            console.log(thirdPageLoader.children[0].children[ii].objectName)//: "SquareGauge");
                            console.log(thirdPageLoader.children[0].children[ii].x*1024/Connect.getWidth())//: "SquareGauge");
                            console.log(thirdPageLoader.children[0].children[ii].y*600/Connect.getHeight())//: "SquareGauge");
                            console.log(thirdPageLoader.children[0].children[ii].fullCircl)//: "SquareGauge");

                                outfileText+=
                                        thirdPageLoader.children[0].children[ii].width*1024/Connect.getWidth()+","+
                                        thirdPageLoader.children[0].children[ii].height*600/Connect.getHeight()+","+
                                        thirdPageLoader.children[0].children[ii].x*1024/Connect.getWidth()+","+
                                        thirdPageLoader.children[0].children[ii].y*600/Connect.getHeight()+","+
                                        thirdPageLoader.children[0].children[ii].maxvalue+","+
                                        thirdPageLoader.children[0].children[ii].decPlace+","+
                                        thirdPageLoader.children[0].children[ii].mainunit+","+
                                        thirdPageLoader.children[0].children[ii].myID+","+
                                        thirdPageLoader.children[0].children[ii].vertgaugevisible+","+
                                        thirdPageLoader.children[0].children[ii].horigaugevisible+","+
                                        thirdPageLoader.children[0].children[ii].secvaluevisible+","+
                                        "Dashboard,"+
                                        thirdPageLoader.children[0].children[ii].valuePropertyMain+","+
                                        thirdPageLoader.children[0].children[ii].valuePropertySec+","+
                                        thirdPageLoader.children[0].children[ii].warnvaluehigh+","+
                                        thirdPageLoader.children[0].children[ii].warnvaluelow+","+
                                        thirdPageLoader.children[0].children[ii].framecolor+","+
                                        thirdPageLoader.children[0].children[ii].resetbackroundcolor+","+
                                        thirdPageLoader.children[0].children[ii].titlecolor+","+
                                        thirdPageLoader.children[0].children[ii].titletextcolor+","+
                                        thirdPageLoader.children[0].children[ii].textcolor+","+
                                        thirdPageLoader.children[0].children[ii].barcolor+","+
                                        thirdPageLoader.children[0].children[ii].titlefontsize*600/Connect.getHeight()+","+
                                        thirdPageLoader.children[0].children[ii].mainfontsize*600/Connect.getHeight()+","+
                                        thirdPageLoader.children[0].children[ii].objectName+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor1+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor2+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor3+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor4+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor5+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor6+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor7+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor8+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor9+","+
                                        thirdPageLoader.children[0].children[ii].shadecolor1+","+
                                        thirdPageLoader.children[0].children[ii].shadecolor2+","+
                                        thirdPageLoader.children[0].children[ii].shadecolor3+","+
                                        thirdPageLoader.children[0].children[ii].shadecolor4+","+
                                        thirdPageLoader.children[0].children[ii].stepsize+","+
                                        thirdPageLoader.children[0].children[ii].minValueAngle+","+
                                        thirdPageLoader.children[0].children[ii].maxValueAngle+","+
                                        thirdPageLoader.children[0].children[ii].rotation+","+
                                        thirdPageLoader.children[0].children[ii].fullCirc+","+
                                        thirdPageLoader.children[0].children[ii].subDivVal+","+
                                        thirdPageLoader.children[0].children[ii].imgSource.substring(7)+"\n";
                            }
                        }
                    } else if(view.currentIndex == 3){
                        for (var ii=0; ii<fourthPageLoader.children[0].children.length; ii++){
                            if(fourthPageLoader.children[0].children[ii].objectName == "SquareGauge" || fourthPageLoader.children[0].children[ii].objectName == "RoundGauge" || fourthPageLoader.children[0].children[ii].objectName == "SpeedoGauge" || fourthPageLoader.children[0].children[ii].objectName == "TachoGauge" || fourthPageLoader.children[0].children[ii].objectName == "ImageGauge"){
                            console.log(fourthPageLoader.children[0].children[ii].objectName)//: "SquareGauge");
                            console.log(fourthPageLoader.children[0].children[ii].x*1024/Connect.getWidth())//: "SquareGauge");
                            console.log(fourthPageLoader.children[0].children[ii].y*600/Connect.getHeight())//: "SquareGauge");
                            console.log(fourthPageLoader.children[0].children[ii].fullCircl)//: "SquareGauge");

                                outfileText+=
                                        fourthPageLoader.children[0].children[ii].width*1024/Connect.getWidth()+","+
                                        fourthPageLoader.children[0].children[ii].height*600/Connect.getHeight()+","+
                                        fourthPageLoader.children[0].children[ii].x*1024/Connect.getWidth()+","+
                                        fourthPageLoader.children[0].children[ii].y*600/Connect.getHeight()+","+
                                        fourthPageLoader.children[0].children[ii].maxvalue+","+
                                        fourthPageLoader.children[0].children[ii].decPlace+","+
                                        fourthPageLoader.children[0].children[ii].mainunit+","+
                                        fourthPageLoader.children[0].children[ii].myID+","+
                                        fourthPageLoader.children[0].children[ii].vertgaugevisible+","+
                                        fourthPageLoader.children[0].children[ii].horigaugevisible+","+
                                        fourthPageLoader.children[0].children[ii].secvaluevisible+","+
                                        "Dashboard,"+
                                        fourthPageLoader.children[0].children[ii].valuePropertyMain+","+
                                        fourthPageLoader.children[0].children[ii].valuePropertySec+","+
                                        fourthPageLoader.children[0].children[ii].warnvaluehigh+","+
                                        fourthPageLoader.children[0].children[ii].warnvaluelow+","+
                                        fourthPageLoader.children[0].children[ii].framecolor+","+
                                        fourthPageLoader.children[0].children[ii].resetbackroundcolor+","+
                                        fourthPageLoader.children[0].children[ii].titlecolor+","+
                                        fourthPageLoader.children[0].children[ii].titletextcolor+","+
                                        fourthPageLoader.children[0].children[ii].textcolor+","+
                                        fourthPageLoader.children[0].children[ii].barcolor+","+
                                        fourthPageLoader.children[0].children[ii].titlefontsize*600/Connect.getHeight()+","+
                                        fourthPageLoader.children[0].children[ii].mainfontsize*600/Connect.getHeight()+","+
                                        fourthPageLoader.children[0].children[ii].objectName+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor1+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor2+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor3+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor4+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor5+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor6+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor7+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor8+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor9+","+
                                        fourthPageLoader.children[0].children[ii].shadecolor1+","+
                                        fourthPageLoader.children[0].children[ii].shadecolor2+","+
                                        fourthPageLoader.children[0].children[ii].shadecolor3+","+
                                        fourthPageLoader.children[0].children[ii].shadecolor4+","+
                                        fourthPageLoader.children[0].children[ii].stepsize+","+
                                        fourthPageLoader.children[0].children[ii].minValueAngle+","+
                                        fourthPageLoader.children[0].children[ii].maxValueAngle+","+
                                        fourthPageLoader.children[0].children[ii].rotation+","+
                                        fourthPageLoader.children[0].children[ii].fullCirc+","+
                                        fourthPageLoader.children[0].children[ii].subDivVal+","+
                                        fourthPageLoader.children[0].children[ii].imgSource.substring(7)+"\n";
                            }
                        }
                    } else if(view.currentIndex == 4){
                        for (var ii=0; ii<fifthPageLoader.children[0].children.length; ii++){
                            if(fifthPageLoader.children[0].children[ii].objectName == "SquareGauge" || fifthPageLoader.children[0].children[ii].objectName == "RoundGauge" || fifthPageLoader.children[0].children[ii].objectName == "SpeedoGauge" || fifthPageLoader.children[0].children[ii].objectName == "TachoGauge" || fifthPageLoader.children[0].children[ii].objectName == "ImageGauge"){
                            console.log(fifthPageLoader.children[0].children[ii].objectName)//: "SquareGauge");
                            console.log(fifthPageLoader.children[0].children[ii].x*1024/Connect.getWidth())//: "SquareGauge");
                            console.log(fifthPageLoader.children[0].children[ii].y*600/Connect.getHeight())//: "SquareGauge");
                            console.log(fifthPageLoader.children[0].children[ii].fullCircl)//: "SquareGauge");

                                outfileText+=
                                        fifthPageLoader.children[0].children[ii].width*1024/Connect.getWidth()+","+
                                        fifthPageLoader.children[0].children[ii].height*600/Connect.getHeight()+","+
                                        fifthPageLoader.children[0].children[ii].x*1024/Connect.getWidth()+","+
                                        fifthPageLoader.children[0].children[ii].y*600/Connect.getHeight()+","+
                                        fifthPageLoader.children[0].children[ii].maxvalue+","+
                                        fifthPageLoader.children[0].children[ii].decPlace+","+
                                        fifthPageLoader.children[0].children[ii].mainunit+","+
                                        fifthPageLoader.children[0].children[ii].myID+","+
                                        fifthPageLoader.children[0].children[ii].vertgaugevisible+","+
                                        fifthPageLoader.children[0].children[ii].horigaugevisible+","+
                                        fifthPageLoader.children[0].children[ii].secvaluevisible+","+
                                        "Dashboard,"+
                                        fifthPageLoader.children[0].children[ii].valuePropertyMain+","+
                                        fifthPageLoader.children[0].children[ii].valuePropertySec+","+
                                        fifthPageLoader.children[0].children[ii].warnvaluehigh+","+
                                        fifthPageLoader.children[0].children[ii].warnvaluelow+","+
                                        fifthPageLoader.children[0].children[ii].framecolor+","+
                                        fifthPageLoader.children[0].children[ii].resetbackroundcolor+","+
                                        fifthPageLoader.children[0].children[ii].titlecolor+","+
                                        fifthPageLoader.children[0].children[ii].titletextcolor+","+
                                        fifthPageLoader.children[0].children[ii].textcolor+","+
                                        fifthPageLoader.children[0].children[ii].barcolor+","+
                                        fifthPageLoader.children[0].children[ii].titlefontsize*600/Connect.getHeight()+","+
                                        fifthPageLoader.children[0].children[ii].mainfontsize*600/Connect.getHeight()+","+
                                        fifthPageLoader.children[0].children[ii].objectName+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor1+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor2+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor3+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor4+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor5+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor6+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor7+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor8+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor9+","+
                                        fifthPageLoader.children[0].children[ii].shadecolor1+","+
                                        fifthPageLoader.children[0].children[ii].shadecolor2+","+
                                        fifthPageLoader.children[0].children[ii].shadecolor3+","+
                                        fifthPageLoader.children[0].children[ii].shadecolor4+","+
                                        fifthPageLoader.children[0].children[ii].stepsize+","+
                                        fifthPageLoader.children[0].children[ii].minValueAngle+","+
                                        fifthPageLoader.children[0].children[ii].maxValueAngle+","+
                                        fifthPageLoader.children[0].children[ii].rotation+","+
                                        fifthPageLoader.children[0].children[ii].fullCirc+","+
                                        fifthPageLoader.children[0].children[ii].subDivVal+","+
                                        fifthPageLoader.children[0].children[ii].imgSource.substring(7)+"\n";
                            }
                        }
                    } else if(view.currentIndex == 5){
                        for (var ii=0; ii<sixthPageLoader.children[0].children.length; ii++){
                            if(sixthPageLoader.children[0].children[ii].objectName == "SquareGauge" || sixthPageLoader.children[0].children[ii].objectName == "RoundGauge" || sixthPageLoader.children[0].children[ii].objectName == "SpeedoGauge" || sixthPageLoader.children[0].children[ii].objectName == "TachoGauge" || sixthPageLoader.children[0].children[ii].objectName == "ImageGauge"){
                            console.log(sixthPageLoader.children[0].children[ii].objectName)//: "SquareGauge");
                            console.log(sixthPageLoader.children[0].children[ii].x*1024/Connect.getWidth())//: "SquareGauge");
                            console.log(sixthPageLoader.children[0].children[ii].y*600/Connect.getHeight())//: "SquareGauge");
                            console.log(sixthPageLoader.children[0].children[ii].fullCircl)//: "SquareGauge");

                                outfileText+=
                                        sixthPageLoader.children[0].children[ii].width*1024/Connect.getWidth()+","+
                                        sixthPageLoader.children[0].children[ii].height*600/Connect.getHeight()+","+
                                        sixthPageLoader.children[0].children[ii].x*1024/Connect.getWidth()+","+
                                        sixthPageLoader.children[0].children[ii].y*600/Connect.getHeight()+","+
                                        sixthPageLoader.children[0].children[ii].maxvalue+","+
                                        sixthPageLoader.children[0].children[ii].decPlace+","+
                                        sixthPageLoader.children[0].children[ii].mainunit+","+
                                        sixthPageLoader.children[0].children[ii].myID+","+
                                        sixthPageLoader.children[0].children[ii].vertgaugevisible+","+
                                        sixthPageLoader.children[0].children[ii].horigaugevisible+","+
                                        sixthPageLoader.children[0].children[ii].secvaluevisible+","+
                                        "Dashboard,"+
                                        sixthPageLoader.children[0].children[ii].valuePropertyMain+","+
                                        sixthPageLoader.children[0].children[ii].valuePropertySec+","+
                                        sixthPageLoader.children[0].children[ii].warnvaluehigh+","+
                                        sixthPageLoader.children[0].children[ii].warnvaluelow+","+
                                        sixthPageLoader.children[0].children[ii].framecolor+","+
                                        sixthPageLoader.children[0].children[ii].resetbackroundcolor+","+
                                        sixthPageLoader.children[0].children[ii].titlecolor+","+
                                        sixthPageLoader.children[0].children[ii].titletextcolor+","+
                                        sixthPageLoader.children[0].children[ii].textcolor+","+
                                        sixthPageLoader.children[0].children[ii].barcolor+","+
                                        sixthPageLoader.children[0].children[ii].titlefontsize*600/Connect.getHeight()+","+
                                        sixthPageLoader.children[0].children[ii].mainfontsize*600/Connect.getHeight()+","+
                                        sixthPageLoader.children[0].children[ii].objectName+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor1+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor2+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor3+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor4+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor5+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor6+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor7+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor8+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor9+","+
                                        sixthPageLoader.children[0].children[ii].shadecolor1+","+
                                        sixthPageLoader.children[0].children[ii].shadecolor2+","+
                                        sixthPageLoader.children[0].children[ii].shadecolor3+","+
                                        sixthPageLoader.children[0].children[ii].shadecolor4+","+
                                        sixthPageLoader.children[0].children[ii].stepsize+","+
                                        sixthPageLoader.children[0].children[ii].minValueAngle+","+
                                        sixthPageLoader.children[0].children[ii].maxValueAngle+","+
                                        sixthPageLoader.children[0].children[ii].rotation+","+
                                        sixthPageLoader.children[0].children[ii].fullCirc+","+
                                        sixthPageLoader.children[0].children[ii].subDivVal+","+
                                        sixthPageLoader.children[0].children[ii].imgSource.substring(7)+"\n";
                            }
                        }
                    }
                    Connect.writeDashFile(dash4.fileName,outfileText);
                }
            }

            Action {
                id: settingsRAction
                text: "Settings"
                shortcut: "ctrl+s"
                //                iconSource: "images/editcut.png"
                //                iconName: "edit-cut"
                onTriggered: view.currentIndex = 6
            }

            Menu {
                id: contextRMenu
                width: applicationWindow.width / 10
                MenuItem { action: custRAction
                width: contextRMenu.width}
                MenuItem { action: writeRAction
                width: contextRMenu.width}
                MenuItem { action: settingsRAction
                width: contextRMenu.width}

                //                MenuItem { text: "Copy" }
                //                MenuItem { text: "Paste" }
            }
        }


//        MouseArea
//        {
//            anchors.fill:parent
//            onClicked:{
//                if(view.currentIndex<5){
//                    view.currentIndex++
//                }else{
//                    view.currentIndex = 0
//                }

//            }
//        }
    }

    PageIndicator {
        id: indicator

        count: view.count
        currentIndex: view.currentIndex

        anchors.bottom: view.bottom
        anchors.horizontalCenter: parent.horizontalCenter
        property string fileName: ""
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
                id: custAction
                text: "Select Dash"
                shortcut: "ctrl+x"
                //                iconSource: "images/editcut.png"
                //                iconName: "edit-cut"
                onTriggered: {
                    applicationWindow.loadingScreenFile = 1
                    dash5.visible = false
                    sourceselect.loadingCombo = 1
                    if(view.currentIndex == 0){
                        indicator.fileName = Connect.getdash1()
                    } else if(view.currentIndex == 1){
                        indicator.fileName = Connect.getdash6()
                    } else if(view.currentIndex == 2){
                        indicator.fileName = Connect.getdash5()
                    } else if(view.currentIndex == 3){
                        indicator.fileName = Connect.getdash2()
                    } else if(view.currentIndex == 4){
                        indicator.fileName = Connect.getdash3()
                    } else if(view.currentIndex == 5){
                        indicator.fileName = Connect.getdash4()
                    }
                    for (var i=0; i<dash4.model.length; i++){
                        if(dash4.textAt(i) == indicator.fileName){
                            dash4.currentIndex = i
                            break;
                        }
                    }
                    applicationWindow.loadingScreenFile = 0
                    dash4.fileName = ""
                    if(dash4.currentIndex == 5){
                        dash4.fileName = Connect.getfilename1()
                    } else if(dash4.currentIndex == 6){
                        dash4.fileName = Connect.getfilename2()
                    } else if(dash4.currentIndex == 7){
                        dash4.fileName = Connect.getfilename3()
                    } else if(dash4.currentIndex == 12){
                        dash4.fileName = Connect.getfilename4()
                    } else if(dash4.currentIndex == 13){
                        dash4.fileName = Connect.getfilename5()
                    }
                    if(dash4.fileName != ""){
                        for (var i=0; i<dash5.model.length; i++){
                            if(dash5.textAt(i) == dash4.fileName){
                                dash5.currentIndex = i
                                break;
                            }
                        }

                        dash5.visible = true
                    }
                    sourceselect.loadingCombo = 0
                    sourceselect.visible = true
                }
            }

            Action {
                id: writeAction
                text: "Apply changes"
                shortcut: "ctrl+a"
                //                iconSource: "images/editcut.png"
                //                iconName: "edit-cut"
                onTriggered: {
                    applicationWindow.loadingScreenFile = 1
                    dash5.visible = false
                    sourceselect.loadingCombo = 1
                    if(view.currentIndex == 0){
                        indicator.fileName = Connect.getdash1()
                    } else if(view.currentIndex == 1){
                        indicator.fileName = Connect.getdash6()
                    } else if(view.currentIndex == 2){
                        indicator.fileName = Connect.getdash5()
                    } else if(view.currentIndex == 3){
                        indicator.fileName = Connect.getdash2()
                    } else if(view.currentIndex == 4){
                        indicator.fileName = Connect.getdash3()
                    } else if(view.currentIndex == 5){
                        indicator.fileName = Connect.getdash4()
                    }
                    for (var i=0; i<dash4.model.length; i++){
                        if(dash4.textAt(i) == indicator.fileName){
                            dash4.currentIndex = i
                            break;
                        }
                    }
                    applicationWindow.loadingScreenFile = 0
                    dash4.fileName = ""
                    if(dash4.currentIndex == 5){
                        dash4.fileName = Connect.getfilename1()
                    } else if(dash4.currentIndex == 6){
                        dash4.fileName = Connect.getfilename2()
                    } else if(dash4.currentIndex == 7){
                        dash4.fileName = Connect.getfilename3()
                    } else if(dash4.currentIndex == 12){
                        dash4.fileName = Connect.getfilename4()
                    } else if(dash4.currentIndex == 13){
                        dash4.fileName = Connect.getfilename5()
                    }
                    if(dash4.fileName != ""){
                        for (var i=0; i<dash5.model.length; i++){
                            if(dash5.textAt(i) == dash4.fileName){
                                dash5.currentIndex = i
                                break;
                            }
                        }

                        dash5.visible = true
                    }
                    sourceselect.loadingCombo = 0
                    sourceselect.visible = false

                    var outfileText = "";
                    if(view.currentIndex == 0){
                        for (var ii=0; ii<firstPageLoader.children[0].children.length; ii++){
                            if(firstPageLoader.children[0].children[ii].objectName == "SquareGauge" || firstPageLoader.children[0].children[ii].objectName == "RoundGauge" || firstPageLoader.children[0].children[ii].objectName == "SpeedoGauge" || firstPageLoader.children[0].children[ii].objectName == "TachoGauge" || firstPageLoader.children[0].children[ii].objectName == "ImageGauge"){
                            console.log(firstPageLoader.children[0].children[ii].objectName)//: "SquareGauge");
                            console.log(firstPageLoader.children[0].children[ii].x*1024/Connect.getWidth())//: "SquareGauge");
                            console.log(firstPageLoader.children[0].children[ii].y*600/Connect.getHeight())//: "SquareGauge");
                            console.log(firstPageLoader.children[0].children[ii].fullCircl)//: "SquareGauge");

                                outfileText+=
                                        firstPageLoader.children[0].children[ii].width*1024/Connect.getWidth()+","+
                                        firstPageLoader.children[0].children[ii].height*600/Connect.getHeight()+","+
                                        firstPageLoader.children[0].children[ii].x*1024/Connect.getWidth()+","+
                                        firstPageLoader.children[0].children[ii].y*600/Connect.getHeight()+","+
                                        firstPageLoader.children[0].children[ii].maxvalue+","+
                                        firstPageLoader.children[0].children[ii].decPlace+","+
                                        firstPageLoader.children[0].children[ii].mainunit+","+
                                        firstPageLoader.children[0].children[ii].myID+","+
                                        firstPageLoader.children[0].children[ii].vertgaugevisible+","+
                                        firstPageLoader.children[0].children[ii].horigaugevisible+","+
                                        firstPageLoader.children[0].children[ii].secvaluevisible+","+
                                        "Dashboard,"+
                                        firstPageLoader.children[0].children[ii].valuePropertyMain+","+
                                        firstPageLoader.children[0].children[ii].valuePropertySec+","+
                                        firstPageLoader.children[0].children[ii].warnvaluehigh+","+
                                        firstPageLoader.children[0].children[ii].warnvaluelow+","+
                                        firstPageLoader.children[0].children[ii].framecolor+","+
                                        firstPageLoader.children[0].children[ii].resetbackroundcolor+","+
                                        firstPageLoader.children[0].children[ii].titlecolor+","+
                                        firstPageLoader.children[0].children[ii].titletextcolor+","+
                                        firstPageLoader.children[0].children[ii].textcolor+","+
                                        firstPageLoader.children[0].children[ii].barcolor+","+
                                        firstPageLoader.children[0].children[ii].titlefontsize*600/Connect.getHeight()+","+
                                        firstPageLoader.children[0].children[ii].mainfontsize*600/Connect.getHeight()+","+
                                        firstPageLoader.children[0].children[ii].objectName+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor1+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor2+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor3+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor4+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor5+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor6+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor7+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor8+","+
                                        firstPageLoader.children[0].children[ii].gaugecolor9+","+
                                        firstPageLoader.children[0].children[ii].shadecolor1+","+
                                        firstPageLoader.children[0].children[ii].shadecolor2+","+
                                        firstPageLoader.children[0].children[ii].shadecolor3+","+
                                        firstPageLoader.children[0].children[ii].shadecolor4+","+
                                        firstPageLoader.children[0].children[ii].stepsize+","+
                                        firstPageLoader.children[0].children[ii].minValueAngle+","+
                                        firstPageLoader.children[0].children[ii].maxValueAngle+","+
                                        firstPageLoader.children[0].children[ii].rotation+","+
                                        firstPageLoader.children[0].children[ii].fullCirc+","+
                                        firstPageLoader.children[0].children[ii].subDivVal+","+
                                        firstPageLoader.children[0].children[ii].imgSource.substring(7)+"\n";
                            }
                        }
                    } else if(view.currentIndex == 1){
                        for (var ii=0; ii<secondPageLoader.children[0].children.length; ii++){
                            if(secondPageLoader.children[0].children[ii].objectName == "SquareGauge" || secondPageLoader.children[0].children[ii].objectName == "RoundGauge" || secondPageLoader.children[0].children[ii].objectName == "SpeedoGauge" || secondPageLoader.children[0].children[ii].objectName == "TachoGauge" || secondPageLoader.children[0].children[ii].objectName == "ImageGauge"){
                            console.log(secondPageLoader.children[0].children[ii].objectName)//: "SquareGauge");
                            console.log(secondPageLoader.children[0].children[ii].x*1024/Connect.getWidth())//: "SquareGauge");
                            console.log(secondPageLoader.children[0].children[ii].y*600/Connect.getHeight())//: "SquareGauge");
                            console.log(secondPageLoader.children[0].children[ii].fullCircl)//: "SquareGauge");

                                outfileText+=
                                        secondPageLoader.children[0].children[ii].width*1024/Connect.getWidth()+","+
                                        secondPageLoader.children[0].children[ii].height*600/Connect.getHeight()+","+
                                        secondPageLoader.children[0].children[ii].x*1024/Connect.getWidth()+","+
                                        secondPageLoader.children[0].children[ii].y*600/Connect.getHeight()+","+
                                        secondPageLoader.children[0].children[ii].maxvalue+","+
                                        secondPageLoader.children[0].children[ii].decPlace+","+
                                        secondPageLoader.children[0].children[ii].mainunit+","+
                                        secondPageLoader.children[0].children[ii].myID+","+
                                        secondPageLoader.children[0].children[ii].vertgaugevisible+","+
                                        secondPageLoader.children[0].children[ii].horigaugevisible+","+
                                        secondPageLoader.children[0].children[ii].secvaluevisible+","+
                                        "Dashboard,"+
                                        secondPageLoader.children[0].children[ii].valuePropertyMain+","+
                                        secondPageLoader.children[0].children[ii].valuePropertySec+","+
                                        secondPageLoader.children[0].children[ii].warnvaluehigh+","+
                                        secondPageLoader.children[0].children[ii].warnvaluelow+","+
                                        secondPageLoader.children[0].children[ii].framecolor+","+
                                        secondPageLoader.children[0].children[ii].resetbackroundcolor+","+
                                        secondPageLoader.children[0].children[ii].titlecolor+","+
                                        secondPageLoader.children[0].children[ii].titletextcolor+","+
                                        secondPageLoader.children[0].children[ii].textcolor+","+
                                        secondPageLoader.children[0].children[ii].barcolor+","+
                                        secondPageLoader.children[0].children[ii].titlefontsize*600/Connect.getHeight()+","+
                                        secondPageLoader.children[0].children[ii].mainfontsize*600/Connect.getHeight()+","+
                                        secondPageLoader.children[0].children[ii].objectName+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor1+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor2+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor3+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor4+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor5+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor6+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor7+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor8+","+
                                        secondPageLoader.children[0].children[ii].gaugecolor9+","+
                                        secondPageLoader.children[0].children[ii].shadecolor1+","+
                                        secondPageLoader.children[0].children[ii].shadecolor2+","+
                                        secondPageLoader.children[0].children[ii].shadecolor3+","+
                                        secondPageLoader.children[0].children[ii].shadecolor4+","+
                                        secondPageLoader.children[0].children[ii].stepsize+","+
                                        secondPageLoader.children[0].children[ii].minValueAngle+","+
                                        secondPageLoader.children[0].children[ii].maxValueAngle+","+
                                        secondPageLoader.children[0].children[ii].rotation+","+
                                        secondPageLoader.children[0].children[ii].fullCirc+","+
                                        secondPageLoader.children[0].children[ii].subDivVal+","+
                                        secondPageLoader.children[0].children[ii].imgSource.substring(7)+"\n";
                            }
                        }
                    } else if(view.currentIndex == 2){
                        for (var ii=0; ii<thirdPageLoader.children[0].children.length; ii++){
                            if(thirdPageLoader.children[0].children[ii].objectName == "SquareGauge" || thirdPageLoader.children[0].children[ii].objectName == "RoundGauge" || thirdPageLoader.children[0].children[ii].objectName == "SpeedoGauge" || thirdPageLoader.children[0].children[ii].objectName == "TachoGauge" || thirdPageLoader.children[0].children[ii].objectName == "ImageGauge"){
                            console.log(thirdPageLoader.children[0].children[ii].objectName)//: "SquareGauge");
                            console.log(thirdPageLoader.children[0].children[ii].x*1024/Connect.getWidth())//: "SquareGauge");
                            console.log(thirdPageLoader.children[0].children[ii].y*600/Connect.getHeight())//: "SquareGauge");
                            console.log(thirdPageLoader.children[0].children[ii].fullCircl)//: "SquareGauge");

                                outfileText+=
                                        thirdPageLoader.children[0].children[ii].width*1024/Connect.getWidth()+","+
                                        thirdPageLoader.children[0].children[ii].height*600/Connect.getHeight()+","+
                                        thirdPageLoader.children[0].children[ii].x*1024/Connect.getWidth()+","+
                                        thirdPageLoader.children[0].children[ii].y*600/Connect.getHeight()+","+
                                        thirdPageLoader.children[0].children[ii].maxvalue+","+
                                        thirdPageLoader.children[0].children[ii].decPlace+","+
                                        thirdPageLoader.children[0].children[ii].mainunit+","+
                                        thirdPageLoader.children[0].children[ii].myID+","+
                                        thirdPageLoader.children[0].children[ii].vertgaugevisible+","+
                                        thirdPageLoader.children[0].children[ii].horigaugevisible+","+
                                        thirdPageLoader.children[0].children[ii].secvaluevisible+","+
                                        "Dashboard,"+
                                        thirdPageLoader.children[0].children[ii].valuePropertyMain+","+
                                        thirdPageLoader.children[0].children[ii].valuePropertySec+","+
                                        thirdPageLoader.children[0].children[ii].warnvaluehigh+","+
                                        thirdPageLoader.children[0].children[ii].warnvaluelow+","+
                                        thirdPageLoader.children[0].children[ii].framecolor+","+
                                        thirdPageLoader.children[0].children[ii].resetbackroundcolor+","+
                                        thirdPageLoader.children[0].children[ii].titlecolor+","+
                                        thirdPageLoader.children[0].children[ii].titletextcolor+","+
                                        thirdPageLoader.children[0].children[ii].textcolor+","+
                                        thirdPageLoader.children[0].children[ii].barcolor+","+
                                        thirdPageLoader.children[0].children[ii].titlefontsize*600/Connect.getHeight()+","+
                                        thirdPageLoader.children[0].children[ii].mainfontsize*600/Connect.getHeight()+","+
                                        thirdPageLoader.children[0].children[ii].objectName+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor1+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor2+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor3+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor4+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor5+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor6+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor7+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor8+","+
                                        thirdPageLoader.children[0].children[ii].gaugecolor9+","+
                                        thirdPageLoader.children[0].children[ii].shadecolor1+","+
                                        thirdPageLoader.children[0].children[ii].shadecolor2+","+
                                        thirdPageLoader.children[0].children[ii].shadecolor3+","+
                                        thirdPageLoader.children[0].children[ii].shadecolor4+","+
                                        thirdPageLoader.children[0].children[ii].stepsize+","+
                                        thirdPageLoader.children[0].children[ii].minValueAngle+","+
                                        thirdPageLoader.children[0].children[ii].maxValueAngle+","+
                                        thirdPageLoader.children[0].children[ii].rotation+","+
                                        thirdPageLoader.children[0].children[ii].fullCirc+","+
                                        thirdPageLoader.children[0].children[ii].subDivVal+","+
                                        thirdPageLoader.children[0].children[ii].imgSource.substring(7)+"\n";
                            }
                        }
                    } else if(view.currentIndex == 3){
                        for (var ii=0; ii<fourthPageLoader.children[0].children.length; ii++){
                            if(fourthPageLoader.children[0].children[ii].objectName == "SquareGauge" || fourthPageLoader.children[0].children[ii].objectName == "RoundGauge" || fourthPageLoader.children[0].children[ii].objectName == "SpeedoGauge" || fourthPageLoader.children[0].children[ii].objectName == "TachoGauge" || fourthPageLoader.children[0].children[ii].objectName == "ImageGauge"){
                            console.log(fourthPageLoader.children[0].children[ii].objectName)//: "SquareGauge");
                            console.log(fourthPageLoader.children[0].children[ii].x*1024/Connect.getWidth())//: "SquareGauge");
                            console.log(fourthPageLoader.children[0].children[ii].y*600/Connect.getHeight())//: "SquareGauge");
                            console.log(fourthPageLoader.children[0].children[ii].fullCircl)//: "SquareGauge");

                                outfileText+=
                                        fourthPageLoader.children[0].children[ii].width*1024/Connect.getWidth()+","+
                                        fourthPageLoader.children[0].children[ii].height*600/Connect.getHeight()+","+
                                        fourthPageLoader.children[0].children[ii].x*1024/Connect.getWidth()+","+
                                        fourthPageLoader.children[0].children[ii].y*600/Connect.getHeight()+","+
                                        fourthPageLoader.children[0].children[ii].maxvalue+","+
                                        fourthPageLoader.children[0].children[ii].decPlace+","+
                                        fourthPageLoader.children[0].children[ii].mainunit+","+
                                        fourthPageLoader.children[0].children[ii].myID+","+
                                        fourthPageLoader.children[0].children[ii].vertgaugevisible+","+
                                        fourthPageLoader.children[0].children[ii].horigaugevisible+","+
                                        fourthPageLoader.children[0].children[ii].secvaluevisible+","+
                                        "Dashboard,"+
                                        fourthPageLoader.children[0].children[ii].valuePropertyMain+","+
                                        fourthPageLoader.children[0].children[ii].valuePropertySec+","+
                                        fourthPageLoader.children[0].children[ii].warnvaluehigh+","+
                                        fourthPageLoader.children[0].children[ii].warnvaluelow+","+
                                        fourthPageLoader.children[0].children[ii].framecolor+","+
                                        fourthPageLoader.children[0].children[ii].resetbackroundcolor+","+
                                        fourthPageLoader.children[0].children[ii].titlecolor+","+
                                        fourthPageLoader.children[0].children[ii].titletextcolor+","+
                                        fourthPageLoader.children[0].children[ii].textcolor+","+
                                        fourthPageLoader.children[0].children[ii].barcolor+","+
                                        fourthPageLoader.children[0].children[ii].titlefontsize*600/Connect.getHeight()+","+
                                        fourthPageLoader.children[0].children[ii].mainfontsize*600/Connect.getHeight()+","+
                                        fourthPageLoader.children[0].children[ii].objectName+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor1+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor2+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor3+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor4+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor5+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor6+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor7+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor8+","+
                                        fourthPageLoader.children[0].children[ii].gaugecolor9+","+
                                        fourthPageLoader.children[0].children[ii].shadecolor1+","+
                                        fourthPageLoader.children[0].children[ii].shadecolor2+","+
                                        fourthPageLoader.children[0].children[ii].shadecolor3+","+
                                        fourthPageLoader.children[0].children[ii].shadecolor4+","+
                                        fourthPageLoader.children[0].children[ii].stepsize+","+
                                        fourthPageLoader.children[0].children[ii].minValueAngle+","+
                                        fourthPageLoader.children[0].children[ii].maxValueAngle+","+
                                        fourthPageLoader.children[0].children[ii].rotation+","+
                                        fourthPageLoader.children[0].children[ii].fullCirc+","+
                                        fourthPageLoader.children[0].children[ii].subDivVal+","+
                                        fourthPageLoader.children[0].children[ii].imgSource.substring(7)+"\n";
                            }
                        }
                    } else if(view.currentIndex == 4){
                        for (var ii=0; ii<fifthPageLoader.children[0].children.length; ii++){
                            if(fifthPageLoader.children[0].children[ii].objectName == "SquareGauge" || fifthPageLoader.children[0].children[ii].objectName == "RoundGauge" || fifthPageLoader.children[0].children[ii].objectName == "SpeedoGauge" || fifthPageLoader.children[0].children[ii].objectName == "TachoGauge" || fifthPageLoader.children[0].children[ii].objectName == "ImageGauge"){
                            console.log(fifthPageLoader.children[0].children[ii].objectName)//: "SquareGauge");
                            console.log(fifthPageLoader.children[0].children[ii].x*1024/Connect.getWidth())//: "SquareGauge");
                            console.log(fifthPageLoader.children[0].children[ii].y*600/Connect.getHeight())//: "SquareGauge");
                            console.log(fifthPageLoader.children[0].children[ii].fullCircl)//: "SquareGauge");

                                outfileText+=
                                        fifthPageLoader.children[0].children[ii].width*1024/Connect.getWidth()+","+
                                        fifthPageLoader.children[0].children[ii].height*600/Connect.getHeight()+","+
                                        fifthPageLoader.children[0].children[ii].x*1024/Connect.getWidth()+","+
                                        fifthPageLoader.children[0].children[ii].y*600/Connect.getHeight()+","+
                                        fifthPageLoader.children[0].children[ii].maxvalue+","+
                                        fifthPageLoader.children[0].children[ii].decPlace+","+
                                        fifthPageLoader.children[0].children[ii].mainunit+","+
                                        fifthPageLoader.children[0].children[ii].myID+","+
                                        fifthPageLoader.children[0].children[ii].vertgaugevisible+","+
                                        fifthPageLoader.children[0].children[ii].horigaugevisible+","+
                                        fifthPageLoader.children[0].children[ii].secvaluevisible+","+
                                        "Dashboard,"+
                                        fifthPageLoader.children[0].children[ii].valuePropertyMain+","+
                                        fifthPageLoader.children[0].children[ii].valuePropertySec+","+
                                        fifthPageLoader.children[0].children[ii].warnvaluehigh+","+
                                        fifthPageLoader.children[0].children[ii].warnvaluelow+","+
                                        fifthPageLoader.children[0].children[ii].framecolor+","+
                                        fifthPageLoader.children[0].children[ii].resetbackroundcolor+","+
                                        fifthPageLoader.children[0].children[ii].titlecolor+","+
                                        fifthPageLoader.children[0].children[ii].titletextcolor+","+
                                        fifthPageLoader.children[0].children[ii].textcolor+","+
                                        fifthPageLoader.children[0].children[ii].barcolor+","+
                                        fifthPageLoader.children[0].children[ii].titlefontsize*600/Connect.getHeight()+","+
                                        fifthPageLoader.children[0].children[ii].mainfontsize*600/Connect.getHeight()+","+
                                        fifthPageLoader.children[0].children[ii].objectName+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor1+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor2+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor3+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor4+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor5+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor6+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor7+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor8+","+
                                        fifthPageLoader.children[0].children[ii].gaugecolor9+","+
                                        fifthPageLoader.children[0].children[ii].shadecolor1+","+
                                        fifthPageLoader.children[0].children[ii].shadecolor2+","+
                                        fifthPageLoader.children[0].children[ii].shadecolor3+","+
                                        fifthPageLoader.children[0].children[ii].shadecolor4+","+
                                        fifthPageLoader.children[0].children[ii].stepsize+","+
                                        fifthPageLoader.children[0].children[ii].minValueAngle+","+
                                        fifthPageLoader.children[0].children[ii].maxValueAngle+","+
                                        fifthPageLoader.children[0].children[ii].rotation+","+
                                        fifthPageLoader.children[0].children[ii].fullCirc+","+
                                        fifthPageLoader.children[0].children[ii].subDivVal+","+
                                        fifthPageLoader.children[0].children[ii].imgSource.substring(7)+"\n";
                            }
                        }
                    } else if(view.currentIndex == 5){
                        for (var ii=0; ii<sixthPageLoader.children[0].children.length; ii++){
                            if(sixthPageLoader.children[0].children[ii].objectName == "SquareGauge" || sixthPageLoader.children[0].children[ii].objectName == "RoundGauge" || sixthPageLoader.children[0].children[ii].objectName == "SpeedoGauge" || sixthPageLoader.children[0].children[ii].objectName == "TachoGauge" || sixthPageLoader.children[0].children[ii].objectName == "ImageGauge"){
                            console.log(sixthPageLoader.children[0].children[ii].objectName)//: "SquareGauge");
                            console.log(sixthPageLoader.children[0].children[ii].x*1024/Connect.getWidth())//: "SquareGauge");
                            console.log(sixthPageLoader.children[0].children[ii].y*600/Connect.getHeight())//: "SquareGauge");
                            console.log(sixthPageLoader.children[0].children[ii].fullCircl)//: "SquareGauge");

                                outfileText+=
                                        sixthPageLoader.children[0].children[ii].width*1024/Connect.getWidth()+","+
                                        sixthPageLoader.children[0].children[ii].height*600/Connect.getHeight()+","+
                                        sixthPageLoader.children[0].children[ii].x*1024/Connect.getWidth()+","+
                                        sixthPageLoader.children[0].children[ii].y*600/Connect.getHeight()+","+
                                        sixthPageLoader.children[0].children[ii].maxvalue+","+
                                        sixthPageLoader.children[0].children[ii].decPlace+","+
                                        sixthPageLoader.children[0].children[ii].mainunit+","+
                                        sixthPageLoader.children[0].children[ii].myID+","+
                                        sixthPageLoader.children[0].children[ii].vertgaugevisible+","+
                                        sixthPageLoader.children[0].children[ii].horigaugevisible+","+
                                        sixthPageLoader.children[0].children[ii].secvaluevisible+","+
                                        "Dashboard,"+
                                        sixthPageLoader.children[0].children[ii].valuePropertyMain+","+
                                        sixthPageLoader.children[0].children[ii].valuePropertySec+","+
                                        sixthPageLoader.children[0].children[ii].warnvaluehigh+","+
                                        sixthPageLoader.children[0].children[ii].warnvaluelow+","+
                                        sixthPageLoader.children[0].children[ii].framecolor+","+
                                        sixthPageLoader.children[0].children[ii].resetbackroundcolor+","+
                                        sixthPageLoader.children[0].children[ii].titlecolor+","+
                                        sixthPageLoader.children[0].children[ii].titletextcolor+","+
                                        sixthPageLoader.children[0].children[ii].textcolor+","+
                                        sixthPageLoader.children[0].children[ii].barcolor+","+
                                        sixthPageLoader.children[0].children[ii].titlefontsize*600/Connect.getHeight()+","+
                                        sixthPageLoader.children[0].children[ii].mainfontsize*600/Connect.getHeight()+","+
                                        sixthPageLoader.children[0].children[ii].objectName+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor1+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor2+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor3+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor4+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor5+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor6+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor7+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor8+","+
                                        sixthPageLoader.children[0].children[ii].gaugecolor9+","+
                                        sixthPageLoader.children[0].children[ii].shadecolor1+","+
                                        sixthPageLoader.children[0].children[ii].shadecolor2+","+
                                        sixthPageLoader.children[0].children[ii].shadecolor3+","+
                                        sixthPageLoader.children[0].children[ii].shadecolor4+","+
                                        sixthPageLoader.children[0].children[ii].stepsize+","+
                                        sixthPageLoader.children[0].children[ii].minValueAngle+","+
                                        sixthPageLoader.children[0].children[ii].maxValueAngle+","+
                                        sixthPageLoader.children[0].children[ii].rotation+","+
                                        sixthPageLoader.children[0].children[ii].fullCirc+","+
                                        sixthPageLoader.children[0].children[ii].subDivVal+","+
                                        sixthPageLoader.children[0].children[ii].imgSource.substring(7)+"\n";
                            }
                        }
                    }
                    Connect.writeDashFile(dash4.fileName,outfileText);
                }
            }

            Action {
                id: settingsAction
                text: "Settings"
                shortcut: "ctrl+s"
                //                iconSource: "images/editcut.png"
                //                iconName: "edit-cut"
                onTriggered: view.currentIndex = 6
            }

            Menu {
                id: contextMenu
                width: applicationWindow.width / 10
                MenuItem { action: custAction
                width: contextMenu.width}
                MenuItem { action: writeAction
                width: contextMenu.width}
                MenuItem { action: settingsAction
                width: contextMenu.width}

                //                MenuItem { text: "Copy" }
                //                MenuItem { text: "Paste" }
            }
        }
    }

    Connections{
        target: Dashboard
        onOrientationChanged:{
            sourceselect.width = width / 2
            dash4.width = applicationWindow.width / 6
            dash5.width = applicationWindow.width / 6
            applyScreen.width = applicationWindow.width / 22

            contextLMenu.width = width / 4
            contextRMenu.width = width / 4
            contextMenu.width = width / 4

//            groove1.width = Connect.getWidth();
        }
        onNewDashFileChanged:{
            Connect.writeReceivedDashFile(newDashFile);
        }
    }

//    TableView {
//        anchors.fill: parent
//        columnSpacing: 1
//        rowSpacing: 1
//        clip: true

//        model: MainWindow.mReceiverModel

//        delegate: Rectangle {
//            implicitWidth: 100
//            implicitHeight: 50
//            Text {
//                text: display
//            }
//        }
//    }

//        onOrientationChanged:{
//            sourceselect.width = width / 2
//            dash4.width = applicationWindow.width / 6
//            dash5.width = applicationWindow.width / 6
//            applyScreen.width = applicationWindow.width / 22

//            contextLMenu.width = width / 4
//            contextRMenu.width = width / 4
//            contextMenu.width = width / 4

////            groove1.width = Connect.getWidth();
//        }
//        onNewDashFileChanged:{
//            Connect.writeReceivedDashFile(newDashFile);
//        }
//    }
}
























/*##^## Designer {
    D{i:0;height:0;width:0}D{i:22;anchors_height:100;anchors_width:100}
}
 ##^##*/
