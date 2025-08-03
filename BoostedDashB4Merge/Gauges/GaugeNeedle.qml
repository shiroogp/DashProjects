/*
Gauge Needle that moves from -90 degrees to 270 degrees which pulls a red Tail
modified code from
https://github.com/alex-adam/Tesla
*/
import QtQuick 2.8
import QtGraphicalEffects 1.0

Canvas {
    id: canvas

    property real minval : -90
    property real maxvaldegs : 180

    property real value : 0
    property real rotateNeedle : -90
    property real currVal: -90
    property color needlecolor : "white"   //outer needle ring color
    property color clorStop1 : "#ffffff"   //outer needle ring color
    property color clorStop2 : "#e96448"   //middle needle ring color
    property color clorStop3 : "#f22900"   //inner needle ring color
    property color clorStop4 : "transparent"   //unten


    onValueChanged: {
        zeiger.rotation = Math.min(Math.max(-250, canvas.value*3.5 + minval), maxvaldegs); canvas.currentValue = zeiger.rotation + minval} //130 minrotation, -30 maxrotation
    //    onValueChanged: {zeiger.rotation = Math.min(Math.max(-250, canvas.value*3.5 - 90), 180); canvas.currentValue = zeiger.rotation -270} //130 minrotation, -30 maxrotation
    //    onValueChanged: {
    //        zeiger.rotation = rotateNeedle;
    //        canvas.currentValue = currVal
    //    } //130 minrotation, -30 maxrotation
    width: parent.width;
    height: parent.height

    Rectangle {
        id: zeiger
        rotation: rotateNeedle //siehe minrotation
        width: parent.width / 85
        height: parent.width / 2.2
        transformOrigin: Item.Bottom
        anchors.horizontalCenter: parent.horizontalCenter
        anchors.bottom: parent.verticalCenter

        smooth: true
        antialiasing: true
        color: needlecolor
        onRotationChanged: {canvas.currentValue = zeiger.rotation + minval; canvas.requestPaint()}//texti.text = zeiger.rotation

        //        onRotationChanged: {
        //            if(zeiger.rotation > 0){
        //                canvas.currentValue = (zeiger.rotation*8/10) -270 ;
        //            }else{
        //                canvas.currentValue = (zeiger.rotation*10/8) -270 ;

        //            }

        //            canvas.requestPaint()}
        //        onRotationChanged: {
        //            canvas.currentValue = currVal;
        //            canvas.requestPaint()}

        Behavior on rotation {
            NumberAnimation{
                duration: 5
                easing.type: Easing.OutCirc
            }
        }
    }

//    RadialGradient {
////        anchors.fill: parent

//        gradient: Gradient {
//            centerX:1
//            GradientStop { position: 0.49; color: clorStop1 }
//            GradientStop { position: 0.45; color: clorStop2 }
//            GradientStop { position: 0.44; color: clorStop3 }
//            GradientStop { position: 0.33; color: clorStop4 }
//        }
//    }


    contextType: "2d"
    renderTarget: Canvas.FramebufferObject
    renderStrategy: Canvas.Immediate
    antialiasing: true;

    property color secondaryColor: zeiger.color

    property real centerWidth: width / 2
    property real centerHeight: height / 2
    property real radius: Math.min(canvas.width, canvas.height) / 2.08

    property real minimumValue: -360
    property real maximumValue: 0
    property real currentValue: -360
    property int initialisedd: 0

    // this is the angle that splits the circle in two arcs
    // first arc is drawn from 0 radians to angle radians
    // second arc is angle radians to 2*PI radians
    property real angle:(currentValue - minval) / (maxvaldegs - minval) * 2 * Math.PI //-0.01 //5.05
    property real angleOffset: Math.PI  //to start at 0mph

//    renderTarget: Canvas.FramebufferObject
//    renderStrategy: Canvas.Immediate

//    property RadialGradient gradient1//: context.createRadialGradient((parent.width / 2),(parent.height / 2), 0, (parent.width / 2),(parent.height / 2),parent.height );

    onPaint: {
        if(parent.visible == true){

//            console.log("paint gaugeneedle");

//            var ctx = getContext("2d");
//            ctx.save();
//            if(available == true){
//                if(initialisedd == 0){
//                    setGradient(ctx);
//                    initialisedd = 1;
//                }
//            }

            var gradient2 = context.createRadialGradient((parent.width / 2),(parent.height / 2), 0, (parent.width / 2),(parent.height / 2),parent.height );
            gradient2.addColorStop(0.49, clorStop1);   //outer needle ring color
            gradient2.addColorStop(0.45, clorStop2);   //middle needle ring color
            //          gradient2.addColorStop(0.46, "#e96448");   //middle needle ring color
            gradient2.addColorStop(0.44, clorStop3);   //inner needle ring color
            gradient2.addColorStop(0.33, clorStop4);   //unten

//            context.clearRect(0, 0, canvas.width, canvas.height);
            context.reset();
            context.beginPath();
            context.lineWidth = 75;
            context.strokeStyle = gradient2
//            context.strokeStyle = clorStop1
            context.arc(canvas.centerWidth, canvas.centerHeight, canvas.radius - (context.lineWidth / 2), canvas.angleOffset, canvas.angleOffset + canvas.angle);
            context.stroke();

//            ctx.restore();
        }
    }
//    function setGradient(ctx){
////        var ctx = getContext("2d");
//        gradient1: ctx.createRadialGradient((parent.width / 2),(parent.height / 2), 0, (parent.width / 2),(parent.height / 2),parent.height );
//        gradient1.addColorStop(0.49, clorStop1);   //outer needle ring color
//        gradient1.addColorStop(0.45, clorStop2);   //middle needle ring color
//        //          gradient2.addColorStop(0.46, "#e96448");   //middle needle ring color
//        gradient1.addColorStop(0.44, clorStop3);   //inner needle ring color
//        gradient1.addColorStop(0.33, clorStop4);   //unten
//    }
}
