/****************************************************************************
** Meta object code from reading C++ file 'obddataexchanger.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.11.4)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../OBDScanner/obddataexchanger.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'obddataexchanger.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.11.4. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_ObdDataExchanger_t {
    QByteArrayData data[8];
    char stringdata0[123];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_ObdDataExchanger_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_ObdDataExchanger_t qt_meta_stringdata_ObdDataExchanger = {
    {
QT_MOC_LITERAL(0, 0, 16), // "ObdDataExchanger"
QT_MOC_LITERAL(1, 17, 13), // "readDataReady"
QT_MOC_LITERAL(2, 31, 0), // ""
QT_MOC_LITERAL(3, 32, 15), // "sendNextRequest"
QT_MOC_LITERAL(4, 48, 17), // "getDataFromElm327"
QT_MOC_LITERAL(5, 66, 12), // "readingError"
QT_MOC_LITERAL(6, 79, 29), // "QBluetoothSocket::SocketError"
QT_MOC_LITERAL(7, 109, 13) // "writeToSocket"

    },
    "ObdDataExchanger\0readDataReady\0\0"
    "sendNextRequest\0getDataFromElm327\0"
    "readingError\0QBluetoothSocket::SocketError\0"
    "writeToSocket"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_ObdDataExchanger[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
       6,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       3,       // signalCount

 // signals: name, argc, parameters, tag, flags
       1,    0,   44,    2, 0x06 /* Public */,
       1,    1,   45,    2, 0x06 /* Public */,
       3,    0,   48,    2, 0x06 /* Public */,

 // slots: name, argc, parameters, tag, flags
       4,    0,   49,    2, 0x0a /* Public */,
       5,    1,   50,    2, 0x0a /* Public */,
       7,    0,   53,    2, 0x0a /* Public */,

 // signals: parameters
    QMetaType::Void,
    QMetaType::Void, QMetaType::QString,    2,
    QMetaType::Void,

 // slots: parameters
    QMetaType::Void,
    QMetaType::Void, 0x80000000 | 6,    2,
    QMetaType::Void,

       0        // eod
};

void ObdDataExchanger::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        ObdDataExchanger *_t = static_cast<ObdDataExchanger *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->readDataReady(); break;
        case 1: _t->readDataReady((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 2: _t->sendNextRequest(); break;
        case 3: _t->getDataFromElm327(); break;
        case 4: _t->readingError((*reinterpret_cast< QBluetoothSocket::SocketError(*)>(_a[1]))); break;
        case 5: _t->writeToSocket(); break;
        default: ;
        }
    } else if (_c == QMetaObject::IndexOfMethod) {
        int *result = reinterpret_cast<int *>(_a[0]);
        {
            using _t = void (ObdDataExchanger::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdDataExchanger::readDataReady)) {
                *result = 0;
                return;
            }
        }
        {
            using _t = void (ObdDataExchanger::*)(QString );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdDataExchanger::readDataReady)) {
                *result = 1;
                return;
            }
        }
        {
            using _t = void (ObdDataExchanger::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdDataExchanger::sendNextRequest)) {
                *result = 2;
                return;
            }
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject ObdDataExchanger::staticMetaObject = {
    { &QObject::staticMetaObject, qt_meta_stringdata_ObdDataExchanger.data,
      qt_meta_data_ObdDataExchanger,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *ObdDataExchanger::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *ObdDataExchanger::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_ObdDataExchanger.stringdata0))
        return static_cast<void*>(this);
    return QObject::qt_metacast(_clname);
}

int ObdDataExchanger::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QObject::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 6)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 6;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 6)
            *reinterpret_cast<int*>(_a[0]) = -1;
        _id -= 6;
    }
    return _id;
}

// SIGNAL 0
void ObdDataExchanger::readDataReady()
{
    QMetaObject::activate(this, &staticMetaObject, 0, nullptr);
}

// SIGNAL 1
void ObdDataExchanger::readDataReady(QString _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 1, _a);
}

// SIGNAL 2
void ObdDataExchanger::sendNextRequest()
{
    QMetaObject::activate(this, &staticMetaObject, 2, nullptr);
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
