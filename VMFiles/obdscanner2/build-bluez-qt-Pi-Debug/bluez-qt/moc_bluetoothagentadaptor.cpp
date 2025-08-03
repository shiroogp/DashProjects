/****************************************************************************
** Meta object code from reading C++ file 'bluetoothagentadaptor.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.11.4)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../libbluez-qt/bluez-qt/bluetoothagentadaptor.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'bluetoothagentadaptor.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.11.4. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_BluetoothAgentAdaptor_t {
    QByteArrayData data[17];
    char stringdata0[204];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_BluetoothAgentAdaptor_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_BluetoothAgentAdaptor_t qt_meta_stringdata_BluetoothAgentAdaptor = {
    {
QT_MOC_LITERAL(0, 0, 21), // "BluetoothAgentAdaptor"
QT_MOC_LITERAL(1, 22, 15), // "D-Bus Interface"
QT_MOC_LITERAL(2, 38, 15), // "org.bluez.Agent"
QT_MOC_LITERAL(3, 54, 9), // "Authorize"
QT_MOC_LITERAL(4, 64, 0), // ""
QT_MOC_LITERAL(5, 65, 15), // "QDBusObjectPath"
QT_MOC_LITERAL(6, 81, 6), // "device"
QT_MOC_LITERAL(7, 88, 4), // "uuid"
QT_MOC_LITERAL(8, 93, 6), // "Cancel"
QT_MOC_LITERAL(9, 100, 17), // "ConfirmModeChange"
QT_MOC_LITERAL(10, 118, 4), // "mode"
QT_MOC_LITERAL(11, 123, 14), // "DisplayPasskey"
QT_MOC_LITERAL(12, 138, 7), // "passkey"
QT_MOC_LITERAL(13, 146, 7), // "Release"
QT_MOC_LITERAL(14, 154, 19), // "RequestConfirmation"
QT_MOC_LITERAL(15, 174, 14), // "RequestPasskey"
QT_MOC_LITERAL(16, 189, 14) // "RequestPinCode"

    },
    "BluetoothAgentAdaptor\0D-Bus Interface\0"
    "org.bluez.Agent\0Authorize\0\0QDBusObjectPath\0"
    "device\0uuid\0Cancel\0ConfirmModeChange\0"
    "mode\0DisplayPasskey\0passkey\0Release\0"
    "RequestConfirmation\0RequestPasskey\0"
    "RequestPinCode"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_BluetoothAgentAdaptor[] = {

 // content:
       7,       // revision
       0,       // classname
       1,   14, // classinfo
       8,   16, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       0,       // signalCount

 // classinfo: key, value
       1,    2,

 // slots: name, argc, parameters, tag, flags
       3,    2,   56,    4, 0x0a /* Public */,
       8,    0,   61,    4, 0x0a /* Public */,
       9,    1,   62,    4, 0x0a /* Public */,
      11,    2,   65,    4, 0x0a /* Public */,
      13,    0,   70,    4, 0x0a /* Public */,
      14,    2,   71,    4, 0x0a /* Public */,
      15,    1,   76,    4, 0x0a /* Public */,
      16,    1,   79,    4, 0x0a /* Public */,

 // slots: parameters
    QMetaType::Void, 0x80000000 | 5, QMetaType::QString,    6,    7,
    QMetaType::Void,
    QMetaType::Void, QMetaType::QString,   10,
    QMetaType::Void, 0x80000000 | 5, QMetaType::UInt,    6,   12,
    QMetaType::Void,
    QMetaType::Void, 0x80000000 | 5, QMetaType::UInt,    6,   12,
    QMetaType::UInt, 0x80000000 | 5,    6,
    QMetaType::QString, 0x80000000 | 5,    6,

       0        // eod
};

void BluetoothAgentAdaptor::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        BluetoothAgentAdaptor *_t = static_cast<BluetoothAgentAdaptor *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->Authorize((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1])),(*reinterpret_cast< const QString(*)>(_a[2]))); break;
        case 1: _t->Cancel(); break;
        case 2: _t->ConfirmModeChange((*reinterpret_cast< const QString(*)>(_a[1]))); break;
        case 3: _t->DisplayPasskey((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1])),(*reinterpret_cast< uint(*)>(_a[2]))); break;
        case 4: _t->Release(); break;
        case 5: _t->RequestConfirmation((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1])),(*reinterpret_cast< uint(*)>(_a[2]))); break;
        case 6: { uint _r = _t->RequestPasskey((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< uint*>(_a[0]) = std::move(_r); }  break;
        case 7: { QString _r = _t->RequestPinCode((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< QString*>(_a[0]) = std::move(_r); }  break;
        default: ;
        }
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        switch (_id) {
        default: *reinterpret_cast<int*>(_a[0]) = -1; break;
        case 0:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 3:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 5:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 6:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 7:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject BluetoothAgentAdaptor::staticMetaObject = {
    { &QDBusAbstractAdaptor::staticMetaObject, qt_meta_stringdata_BluetoothAgentAdaptor.data,
      qt_meta_data_BluetoothAgentAdaptor,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *BluetoothAgentAdaptor::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *BluetoothAgentAdaptor::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_BluetoothAgentAdaptor.stringdata0))
        return static_cast<void*>(this);
    return QDBusAbstractAdaptor::qt_metacast(_clname);
}

int BluetoothAgentAdaptor::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QDBusAbstractAdaptor::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 8)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 8;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 8)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 8;
    }
    return _id;
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
