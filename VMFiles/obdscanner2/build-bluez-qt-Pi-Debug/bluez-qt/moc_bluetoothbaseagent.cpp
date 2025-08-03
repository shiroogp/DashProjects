/****************************************************************************
** Meta object code from reading C++ file 'bluetoothbaseagent.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.11.4)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../libbluez-qt/bluez-qt/bluetoothbaseagent.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'bluetoothbaseagent.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.11.4. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_BluetoothBaseAgent_t {
    QByteArrayData data[14];
    char stringdata0[178];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_BluetoothBaseAgent_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_BluetoothBaseAgent_t qt_meta_stringdata_BluetoothBaseAgent = {
    {
QT_MOC_LITERAL(0, 0, 18), // "BluetoothBaseAgent"
QT_MOC_LITERAL(1, 19, 9), // "authorize"
QT_MOC_LITERAL(2, 29, 0), // ""
QT_MOC_LITERAL(3, 30, 24), // "OrgBluezDeviceInterface&"
QT_MOC_LITERAL(4, 55, 6), // "device"
QT_MOC_LITERAL(5, 62, 13), // "registerAgent"
QT_MOC_LITERAL(6, 76, 6), // "cancel"
QT_MOC_LITERAL(7, 83, 17), // "confirmModeChange"
QT_MOC_LITERAL(8, 101, 14), // "displayPasskey"
QT_MOC_LITERAL(9, 116, 3), // "key"
QT_MOC_LITERAL(10, 120, 7), // "release"
QT_MOC_LITERAL(11, 128, 19), // "requestConfirmation"
QT_MOC_LITERAL(12, 148, 14), // "requestPasskey"
QT_MOC_LITERAL(13, 163, 14) // "requestPidCode"

    },
    "BluetoothBaseAgent\0authorize\0\0"
    "OrgBluezDeviceInterface&\0device\0"
    "registerAgent\0cancel\0confirmModeChange\0"
    "displayPasskey\0key\0release\0"
    "requestConfirmation\0requestPasskey\0"
    "requestPidCode"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_BluetoothBaseAgent[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
       9,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       0,       // signalCount

 // slots: name, argc, parameters, tag, flags
       1,    2,   59,    2, 0x0a /* Public */,
       5,    0,   64,    2, 0x0a /* Public */,
       6,    0,   65,    2, 0x0a /* Public */,
       7,    1,   66,    2, 0x0a /* Public */,
       8,    2,   69,    2, 0x0a /* Public */,
      10,    0,   74,    2, 0x0a /* Public */,
      11,    2,   75,    2, 0x0a /* Public */,
      12,    1,   80,    2, 0x0a /* Public */,
      13,    1,   83,    2, 0x0a /* Public */,

 // slots: parameters
    QMetaType::Void, 0x80000000 | 3, QMetaType::QString,    4,    2,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void, QMetaType::QString,    2,
    QMetaType::Void, 0x80000000 | 3, QMetaType::UInt,    4,    9,
    QMetaType::Void,
    QMetaType::Void, 0x80000000 | 3, QMetaType::UInt,    4,    9,
    QMetaType::UInt, 0x80000000 | 3,    4,
    QMetaType::QString, 0x80000000 | 3,    4,

       0        // eod
};

void BluetoothBaseAgent::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        BluetoothBaseAgent *_t = static_cast<BluetoothBaseAgent *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->authorize((*reinterpret_cast< OrgBluezDeviceInterface(*)>(_a[1])),(*reinterpret_cast< QString(*)>(_a[2]))); break;
        case 1: _t->registerAgent(); break;
        case 2: _t->cancel(); break;
        case 3: _t->confirmModeChange((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 4: _t->displayPasskey((*reinterpret_cast< OrgBluezDeviceInterface(*)>(_a[1])),(*reinterpret_cast< uint(*)>(_a[2]))); break;
        case 5: _t->release(); break;
        case 6: _t->requestConfirmation((*reinterpret_cast< OrgBluezDeviceInterface(*)>(_a[1])),(*reinterpret_cast< uint(*)>(_a[2]))); break;
        case 7: { uint _r = _t->requestPasskey((*reinterpret_cast< OrgBluezDeviceInterface(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< uint*>(_a[0]) = std::move(_r); }  break;
        case 8: { QString _r = _t->requestPidCode((*reinterpret_cast< OrgBluezDeviceInterface(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< QString*>(_a[0]) = std::move(_r); }  break;
        default: ;
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject BluetoothBaseAgent::staticMetaObject = {
    { &QObject::staticMetaObject, qt_meta_stringdata_BluetoothBaseAgent.data,
      qt_meta_data_BluetoothBaseAgent,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *BluetoothBaseAgent::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *BluetoothBaseAgent::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_BluetoothBaseAgent.stringdata0))
        return static_cast<void*>(this);
    if (!strcmp(_clname, "QDBusContext"))
        return static_cast< QDBusContext*>(this);
    return QObject::qt_metacast(_clname);
}

int BluetoothBaseAgent::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QObject::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 9)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 9;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 9)
            *reinterpret_cast<int*>(_a[0]) = -1;
        _id -= 9;
    }
    return _id;
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
