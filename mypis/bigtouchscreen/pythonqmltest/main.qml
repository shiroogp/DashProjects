import QtQuick 2.1
import QtQuick.Controls 1.4
import QtQuick.Layouts 1.2

ApplicationWindow {
    visible: true
    width: 640
    height: 240
    title: qsTr("PyQt5 love QML")
    color: "whitesmoke"

    GridLayout {
        anchors.top: parent.top
        anchors.left: parent.left
        anchors.right: parent.right
        anchors.margins: 9

        columns: 4
        rows: 6
        rowSpacing: 10
        columnSpacing: 10


            Rectangle
            {
                id : main_cadran
                objectName: "tacho_gauge"
                property int rpmval: 1000
            height: 100
            Layout.fillWidth: true
            Layout.columnSpan: 4
                color : "black"
                Component.onCompleted: forceActiveFocus();

                property real randVal : 0;

                Keys.onSpacePressed:
                {
                    randVal = Math.random();
                }

                RoundGauge
                {
                    anchors.bottomMargin: -50
                    anchors
                    {
                        left : parent.left
                        right : parent.horizontalCenter
                        top : parent.top
                        bottom : parent.verticalCenter
                    }
                    //            outerCirclingColor: "#cc6600"
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
                    subDivs: 33
                    minValue: 0
                    maxValue: 340
                    lowValues: 30
                    highValues: 220
                    currentValue: parent.randVal *  (maxValue - minValue) + minValue;
                    digitalFont.pointSize: 15
                }
                RoundGauge
                {
                    id : tacho_gauge
                    anchors.bottomMargin: -50
                    anchors
                    {
                        right : parent.right
                        left : parent.horizontalCenter
                        top : parent.top
                        bottom : parent.verticalCenter
                    }
                    outerCirclingColor: "#ff2200"
                    unit: "RPM x1000"
                    unitFont.pointSize: 12
                    unitFont.bold: true
                    unitFont.italic: true
                    unitFont.family: "Helvetica"
                    digitalFont.family : "Helvetica"
                    digitalFont.bold : true
                    digitalFont.italic : true
                    digitalFont.pointSize: 20
                    currentValue: main_cadran.rmpval * (maxValue - minValue) + minValue;
                    subDivs: 6
                    minValue: 0
                    maxValue: 7
                    lowValues: 1
                    highValues: 5
                }
        }
        Text {
            text: qsTr("First number")
        }

        // Input field of the first number
        TextField {
            id: firstNumber
        }

        Text {
            text: qsTr("Second number")
        }

        // Input field of the second number
        TextField {
            id: secondNumber
        }

        Button {
            height: 40
            Layout.fillWidth: true
            text: qsTr("Sum numbers")

            Layout.columnSpan: 2

            onClicked: {
                // Invoke the calculator slot to sum the numbers
                calculator.sum(firstNumber.text, secondNumber.text)
            }
        }

        Text {
            text: qsTr("Result")
        }

        // Here we see the result of sum
        Text {
            id: sumResult
        }

        Button {
            height: 40
            Layout.fillWidth: true
            text: qsTr("Subtraction numbers")

            Layout.columnSpan: 2

            onClicked: {
                // Invoke the calculator slot to subtract the numbers
                calculator.sub(firstNumber.text, secondNumber.text)
            }
        }

        Text {
            text: qsTr("Result")
        }

        // Here we see the result of subtraction
        Text {
            id: subResult
        }

        Button {
            height: 40
            Layout.fillWidth: true
            text: qsTr("Random")

            Layout.columnSpan: 2

            onClicked: {
                // Invoke the calculator slot to subtract the numbers
                calculator.rand(firstNumber.text)
            }
        }


        // Here we see the result of subtraction
        Text {
            x: 726
            y: 463
            width: 119
            height: 14
            color: "#f4f4f4"        
            id: randResult
            text: 0
        }

    }

    // Here we take the result of sum or subtracting numbers
    Connections {
        target: calculator

        // Sum signal handler
        onSumResult: {
            // sum was set through arguments=['sum']
            sumResult.text = sum
        }

        // Subtraction signal handler
        onSubResult: {
            // sub was set through arguments=['sub']
            subResult.text = sub
        }

        onRandom: {
                randResult.text = rand
        }
    }
}
