/****************************************************************************
** Meta object code from reading C++ file 'obdscanner.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.11.4)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../OBDScanner/obdscanner.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'obdscanner.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.11.4. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_OBDScanner_t {
    QByteArrayData data[22];
    char stringdata0[486];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_OBDScanner_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_OBDScanner_t qt_meta_stringdata_OBDScanner = {
    {
QT_MOC_LITERAL(0, 0, 10), // "OBDScanner"
QT_MOC_LITERAL(1, 11, 22), // "getSocketFromConnector"
QT_MOC_LITERAL(2, 34, 0), // ""
QT_MOC_LITERAL(3, 35, 17), // "QBluetoothSocket*"
QT_MOC_LITERAL(4, 53, 26), // "getDeviceInfoFromConnector"
QT_MOC_LITERAL(5, 80, 21), // "QBluetoothDeviceInfo*"
QT_MOC_LITERAL(6, 102, 22), // "getSignalFromConnector"
QT_MOC_LITERAL(7, 125, 24), // "on_btRadioButton_clicked"
QT_MOC_LITERAL(8, 150, 7), // "checked"
QT_MOC_LITERAL(9, 158, 25), // "on_btConfigButton_clicked"
QT_MOC_LITERAL(10, 184, 26), // "on_tabWidget_tabBarClicked"
QT_MOC_LITERAL(11, 211, 5), // "index"
QT_MOC_LITERAL(12, 217, 26), // "on_cmd_clearButton_clicked"
QT_MOC_LITERAL(13, 244, 25), // "on_cmd_sendButton_clicked"
QT_MOC_LITERAL(14, 270, 21), // "obdResponseDispatcher"
QT_MOC_LITERAL(15, 292, 6), // "getRTD"
QT_MOC_LITERAL(16, 299, 35), // "on_dtc_checkErrNumberButton_c..."
QT_MOC_LITERAL(17, 335, 32), // "on_dtc_getErrCodesButton_clicked"
QT_MOC_LITERAL(18, 368, 26), // "on_dtc_clearErrors_clicked"
QT_MOC_LITERAL(19, 395, 31), // "on_dtc_confirmationBox_accepted"
QT_MOC_LITERAL(20, 427, 31), // "on_dtc_confirmationBox_rejected"
QT_MOC_LITERAL(21, 459, 26) // "on_rtd_startButton_clicked"

    },
    "OBDScanner\0getSocketFromConnector\0\0"
    "QBluetoothSocket*\0getDeviceInfoFromConnector\0"
    "QBluetoothDeviceInfo*\0getSignalFromConnector\0"
    "on_btRadioButton_clicked\0checked\0"
    "on_btConfigButton_clicked\0"
    "on_tabWidget_tabBarClicked\0index\0"
    "on_cmd_clearButton_clicked\0"
    "on_cmd_sendButton_clicked\0"
    "obdResponseDispatcher\0getRTD\0"
    "on_dtc_checkErrNumberButton_clicked\0"
    "on_dtc_getErrCodesButton_clicked\0"
    "on_dtc_clearErrors_clicked\0"
    "on_dtc_confirmationBox_accepted\0"
    "on_dtc_confirmationBox_rejected\0"
    "on_rtd_startButton_clicked"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_OBDScanner[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
      17,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       0,       // signalCount

 // slots: name, argc, parameters, tag, flags
       1,    2,   99,    2, 0x0a /* Public */,
       4,    1,  104,    2, 0x0a /* Public */,
       6,    1,  107,    2, 0x0a /* Public */,
       7,    1,  110,    2, 0x08 /* Private */,
       9,    0,  113,    2, 0x08 /* Private */,
      10,    1,  114,    2, 0x08 /* Private */,
      12,    0,  117,    2, 0x08 /* Private */,
      13,    0,  118,    2, 0x08 /* Private */,
      14,    1,  119,    2, 0x08 /* Private */,
      14,    0,  122,    2, 0x08 /* Private */,
      15,    0,  123,    2, 0x08 /* Private */,
      16,    0,  124,    2, 0x08 /* Private */,
      17,    0,  125,    2, 0x08 /* Private */,
      18,    0,  126,    2, 0x08 /* Private */,
      19,    0,  127,    2, 0x08 /* Private */,
      20,    0,  128,    2, 0x08 /* Private */,
      21,    0,  129,    2, 0x08 /* Private */,

 // slots: parameters
    QMetaType::Void, 0x80000000 | 3, QMetaType::QString,    2,    2,
    QMetaType::Void, 0x80000000 | 5,    2,
    QMetaType::Void, QMetaType::QString,    2,
    QMetaType::Void, QMetaType::Bool,    8,
    QMetaType::Void,
    QMetaType::Void, QMetaType::Int,   11,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void, QMetaType::QString,    2,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,

       0        // eod
};

void OBDScanner::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        OBDScanner *_t = static_cast<OBDScanner *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->getSocketFromConnector((*reinterpret_cast< QBluetoothSocket*(*)>(_a[1])),(*reinterpret_cast< QString(*)>(_a[2]))); break;
        case 1: _t->getDeviceInfoFromConnector((*reinterpret_cast< QBluetoothDeviceInfo*(*)>(_a[1]))); break;
        case 2: _t->getSignalFromConnector((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 3: _t->on_btRadioButton_clicked((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 4: _t->on_btConfigButton_clicked(); break;
        case 5: _t->on_tabWidget_tabBarClicked((*reinterpret_cast< int(*)>(_a[1]))); break;
        case 6: _t->on_cmd_clearButton_clicked(); break;
        case 7: _t->on_cmd_sendButton_clicked(); break;
        case 8: _t->obdResponseDispatcher((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 9: _t->obdResponseDispatcher(); break;
        case 10: _t->getRTD(); break;
        case 11: _t->on_dtc_checkErrNumberButton_clicked(); break;
        case 12: _t->on_dtc_getErrCodesButton_clicked(); break;
        case 13: _t->on_dtc_clearErrors_clicked(); break;
        case 14: _t->on_dtc_confirmationBox_accepted(); break;
        case 15: _t->on_dtc_confirmationBox_rejected(); break;
        case 16: _t->on_rtd_startButton_clicked(); break;
        default: ;
        }
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        switch (_id) {
        default: *reinterpret_cast<int*>(_a[0]) = -1; break;
        case 0:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QBluetoothSocket* >(); break;
            }
            break;
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject OBDScanner::staticMetaObject = {
    { &QMainWindow::staticMetaObject, qt_meta_stringdata_OBDScanner.data,
      qt_meta_data_OBDScanner,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *OBDScanner::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *OBDScanner::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_OBDScanner.stringdata0))
        return static_cast<void*>(this);
    return QMainWindow::qt_metacast(_clname);
}

int OBDScanner::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QMainWindow::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 17)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 17;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 17)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 17;
    }
    return _id;
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
