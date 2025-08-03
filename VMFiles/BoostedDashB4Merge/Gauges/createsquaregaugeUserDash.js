//Creates instances of SquaregaugeRaceDash, usable at runtime

var component;
var gauge;

function createSquareGauge(setWidth,setHeight,setX,setY,setMaxValue,setDecPlace,setUnit,setID,setVertGaugeVis,setHoriGaugeVis,setSecValueVis,SetValueObject,SetValuePropertyMain,SetValuePropertySec,Setwarnvaluehigh,Setwarnvaluelow,Setframeclolor,Setbackroundcolor,Settitlecolor,Settitletextcolor,Settextcolor,Setbarcolor,SetTitlefontsize,SetMainfontsize,color1,color2,color3,color4,color5,color6,color7,color8,color9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize1,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal,imgSource) {
    component = Qt.createComponent("Squaregauge.qml");
    if (component.status === Component.Ready){
        console.log("square component ready");
        finishCreation(setWidth,setHeight,setX,setY,setMaxValue,setDecPlace,setUnit,setID,setVertGaugeVis,setHoriGaugeVis,setSecValueVis,SetValueObject,SetValuePropertyMain,SetValuePropertySec,Setwarnvaluehigh,Setwarnvaluelow,Setframeclolor,Setbackroundcolor,Settitlecolor,Settitletextcolor,Settextcolor,Setbarcolor,SetTitlefontsize,SetMainfontsize,color1,color2,color3,color4,color5,color6,color7,color8,color9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize1,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal,imgSource);
    }
    else {
        if( component.status == Component.Error ){
                console.debug("Error:"+ component.errorString() );
        }
        component.statusChanged.connect(finishCreation);
        console.log("component not ready!");
    }
}

function finishCreation(setWidth,setHeight,setX,setY,setMaxValue,setDecPlace,setUnit,setID,setVertGaugeVis,setHoriGaugeVis,setSecValueVis,SetValueObject,SetValuePropertyMain,SetValuePropertySec,Setwarnvaluehigh,Setwarnvaluelow,Setframeclolor,Setbackroundcolor,Settitlecolor,Settitletextcolor,Settextcolor,Setbarcolor,SetTitlefontsize,SetMainfontsize,color1,color2,color3,color4,color5,color6,color7,color8,color9,shadecolor1,shadecolor2,shadecolor3,shadecolor4,stepsize1,minValueAngle,maxValueAngle,myRotation,fullCirc,subDivVal,imgSource) {
    if (component.status === Component.Ready) {
        gauge = component.createObject(userDash, {"id": setID, "title":setID, "width": setWidth, "height": setHeight,
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
                                           "x": setX, "y": setY,
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
                                           "rotation": myRotation,
                                           "imgSource": imgSource,
                                           "fullCirc": fullCirc,
                                           "subDivVal": subDivVal,
                                           "myID": setID,
                                           "valuePropertyMain": SetValuePropertyMain,
                                           "valuePropertySec": SetValuePropertySec,
                                           "decPlace":setDecPlace
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
