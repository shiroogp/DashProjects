import QtQuick 2.0

ListView {
    width: 640; height: 480
    model: myModel
    delegate: Text {
        text: name + ": " + link + ", " + time
    }
}
