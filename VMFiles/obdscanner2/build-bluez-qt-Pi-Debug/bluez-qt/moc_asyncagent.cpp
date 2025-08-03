/****************************************************************************
** Meta object code from reading C++ file 'asyncagent.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.11.4)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../libbluez-qt/bluez-qt/asyncagent.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'asyncagent.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.11.4. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_AsyncAgent_t {
    QByteArrayData data[11];
    char stringdata0[156];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_AsyncAgent_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_AsyncAgent_t qt_meta_stringdata_AsyncAgent = {
    {
QT_MOC_LITERAL(0, 0, 10), // "AsyncAgent"
QT_MOC_LITERAL(1, 11, 24), // "replyRequestConfirmation"
QT_MOC_LITERAL(2, 36, 0), // ""
QT_MOC_LITERAL(3, 37, 9), // "confirmed"
QT_MOC_LITERAL(4, 47, 12), // "replyPasskey"
QT_MOC_LITERAL(5, 60, 7), // "passkey"
QT_MOC_LITERAL(6, 68, 19), // "replyRequestPidCode"
QT_MOC_LITERAL(7, 88, 7), // "pidCode"
QT_MOC_LITERAL(8, 96, 25), // "replyRequestAuthorization"
QT_MOC_LITERAL(9, 122, 9), // "authorize"
QT_MOC_LITERAL(10, 132, 23) // "devicePropertiesChanged"

    },
    "AsyncAgent\0replyRequestConfirmation\0"
    "\0confirmed\0replyPasskey\0passkey\0"
    "replyRequestPidCode\0pidCode\0"
    "replyRequestAuthorization\0authorize\0"
    "devicePropertiesChanged"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_AsyncAgent[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
       5,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       0,       // signalCount

 // slots: name, argc, parameters, tag, flags
       1,    1,   39,    2, 0x0a /* Public */,
       4,    1,   42,    2, 0x0a /* Public */,
       6,    1,   45,    2, 0x0a /* Public */,
       8,    1,   48,    2, 0x0a /* Public */,
      10,    0,   51,    2, 0x08 /* Private */,

 // slots: parameters
    QMetaType::Void, QMetaType::Bool,    3,
    QMetaType::Void, QMetaType::UInt,    5,
    QMetaType::Void, QMetaType::QString,    7,
    QMetaType::Void, QMetaType::Bool,    9,
    QMetaType::Void,

       0        // eod
};

void AsyncAgent::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        AsyncAgent *_t = static_cast<AsyncAgent *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->replyRequestConfirmation((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 1: _t->replyPasskey((*reinterpret_cast< uint(*)>(_a[1]))); break;
        case 2: _t->replyRequestPidCode((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 3: _t->replyRequestAuthorization((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 4: _t->devicePropertiesChanged(); break;
        default: ;
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject AsyncAgent::staticMetaObject = {
    { &BluetoothBaseAgent::staticMetaObject, qt_meta_stringdata_AsyncAgent.data,
      qt_meta_data_AsyncAgent,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *AsyncAgent::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *AsyncAgent::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_AsyncAgent.stringdata0))
        return static_cast<void*>(this);
    return BluetoothBaseAgent::qt_metacast(_clname);
}

int AsyncAgent::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = BluetoothBaseAgent::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 5)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 5;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 5)
            *reinterpret_cast<int*>(_a[0]) = -1;
        _id -= 5;
    }
    return _id;
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
