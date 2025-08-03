/****************************************************************************
** Meta object code from reading C++ file 'btconnector.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.11.4)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../OBDScanner/btconnector.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'btconnector.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.11.4. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_BtConnector_t {
    QByteArrayData data[29];
    char stringdata0[523];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_BtConnector_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_BtConnector_t qt_meta_stringdata_BtConnector = {
    {
QT_MOC_LITERAL(0, 0, 11), // "BtConnector"
QT_MOC_LITERAL(1, 12, 16), // "conectedToSocket"
QT_MOC_LITERAL(2, 29, 0), // ""
QT_MOC_LITERAL(3, 30, 17), // "QBluetoothSocket*"
QT_MOC_LITERAL(4, 48, 19), // "notConectedToSocket"
QT_MOC_LITERAL(5, 68, 21), // "QBluetoothDeviceInfo*"
QT_MOC_LITERAL(6, 90, 21), // "on_buttonScan_clicked"
QT_MOC_LITERAL(7, 112, 21), // "on_buttonPair_clicked"
QT_MOC_LITERAL(8, 134, 23), // "on_buttonUnpair_clicked"
QT_MOC_LITERAL(9, 158, 33), // "on_buttonRemoteDeviceInfo_cli..."
QT_MOC_LITERAL(10, 192, 24), // "on_buttonConnect_clicked"
QT_MOC_LITERAL(11, 217, 27), // "on_buttonDisconnect_clicked"
QT_MOC_LITERAL(12, 245, 13), // "startScanning"
QT_MOC_LITERAL(13, 259, 12), // "stopScanning"
QT_MOC_LITERAL(14, 272, 14), // "addFoundDevice"
QT_MOC_LITERAL(15, 287, 20), // "QBluetoothDeviceInfo"
QT_MOC_LITERAL(16, 308, 17), // "serviceDiscovered"
QT_MOC_LITERAL(17, 326, 21), // "QBluetoothServiceInfo"
QT_MOC_LITERAL(18, 348, 11), // "serviceInfo"
QT_MOC_LITERAL(19, 360, 13), // "finishPairing"
QT_MOC_LITERAL(20, 374, 17), // "QBluetoothAddress"
QT_MOC_LITERAL(21, 392, 4), // "addr"
QT_MOC_LITERAL(22, 397, 30), // "QBluetoothLocalDevice::Pairing"
QT_MOC_LITERAL(23, 428, 6), // "status"
QT_MOC_LITERAL(24, 435, 15), // "socketConnected"
QT_MOC_LITERAL(25, 451, 18), // "socketDisconnected"
QT_MOC_LITERAL(26, 470, 10), // "socketRead"
QT_MOC_LITERAL(27, 481, 11), // "socketError"
QT_MOC_LITERAL(28, 493, 29) // "QBluetoothSocket::SocketError"

    },
    "BtConnector\0conectedToSocket\0\0"
    "QBluetoothSocket*\0notConectedToSocket\0"
    "QBluetoothDeviceInfo*\0on_buttonScan_clicked\0"
    "on_buttonPair_clicked\0on_buttonUnpair_clicked\0"
    "on_buttonRemoteDeviceInfo_clicked\0"
    "on_buttonConnect_clicked\0"
    "on_buttonDisconnect_clicked\0startScanning\0"
    "stopScanning\0addFoundDevice\0"
    "QBluetoothDeviceInfo\0serviceDiscovered\0"
    "QBluetoothServiceInfo\0serviceInfo\0"
    "finishPairing\0QBluetoothAddress\0addr\0"
    "QBluetoothLocalDevice::Pairing\0status\0"
    "socketConnected\0socketDisconnected\0"
    "socketRead\0socketError\0"
    "QBluetoothSocket::SocketError"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_BtConnector[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
      18,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       3,       // signalCount

 // signals: name, argc, parameters, tag, flags
       1,    1,  104,    2, 0x06 /* Public */,
       1,    2,  107,    2, 0x06 /* Public */,
       4,    1,  112,    2, 0x06 /* Public */,

 // slots: name, argc, parameters, tag, flags
       6,    0,  115,    2, 0x08 /* Private */,
       7,    0,  116,    2, 0x08 /* Private */,
       8,    0,  117,    2, 0x08 /* Private */,
       9,    0,  118,    2, 0x08 /* Private */,
      10,    0,  119,    2, 0x08 /* Private */,
      11,    0,  120,    2, 0x08 /* Private */,
      12,    0,  121,    2, 0x08 /* Private */,
      13,    0,  122,    2, 0x08 /* Private */,
      14,    1,  123,    2, 0x08 /* Private */,
      16,    1,  126,    2, 0x08 /* Private */,
      19,    2,  129,    2, 0x08 /* Private */,
      24,    0,  134,    2, 0x08 /* Private */,
      25,    0,  135,    2, 0x08 /* Private */,
      26,    0,  136,    2, 0x08 /* Private */,
      27,    1,  137,    2, 0x08 /* Private */,

 // signals: parameters
    QMetaType::Void, 0x80000000 | 3,    2,
    QMetaType::Void, 0x80000000 | 3, QMetaType::QString,    2,    2,
    QMetaType::Void, 0x80000000 | 5,    2,

 // slots: parameters
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void, 0x80000000 | 15,    2,
    QMetaType::Void, 0x80000000 | 17,   18,
    QMetaType::Void, 0x80000000 | 20, 0x80000000 | 22,   21,   23,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void, 0x80000000 | 28,    2,

       0        // eod
};

void BtConnector::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        BtConnector *_t = static_cast<BtConnector *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->conectedToSocket((*reinterpret_cast< QBluetoothSocket*(*)>(_a[1]))); break;
        case 1: _t->conectedToSocket((*reinterpret_cast< QBluetoothSocket*(*)>(_a[1])),(*reinterpret_cast< QString(*)>(_a[2]))); break;
        case 2: _t->notConectedToSocket((*reinterpret_cast< QBluetoothDeviceInfo*(*)>(_a[1]))); break;
        case 3: _t->on_buttonScan_clicked(); break;
        case 4: _t->on_buttonPair_clicked(); break;
        case 5: _t->on_buttonUnpair_clicked(); break;
        case 6: _t->on_buttonRemoteDeviceInfo_clicked(); break;
        case 7: _t->on_buttonConnect_clicked(); break;
        case 8: _t->on_buttonDisconnect_clicked(); break;
        case 9: _t->startScanning(); break;
        case 10: _t->stopScanning(); break;
        case 11: _t->addFoundDevice((*reinterpret_cast< QBluetoothDeviceInfo(*)>(_a[1]))); break;
        case 12: _t->serviceDiscovered((*reinterpret_cast< const QBluetoothServiceInfo(*)>(_a[1]))); break;
        case 13: _t->finishPairing((*reinterpret_cast< QBluetoothAddress(*)>(_a[1])),(*reinterpret_cast< QBluetoothLocalDevice::Pairing(*)>(_a[2]))); break;
        case 14: _t->socketConnected(); break;
        case 15: _t->socketDisconnected(); break;
        case 16: _t->socketRead(); break;
        case 17: _t->socketError((*reinterpret_cast< QBluetoothSocket::SocketError(*)>(_a[1]))); break;
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
        case 1:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QBluetoothSocket* >(); break;
            }
            break;
        case 11:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QBluetoothDeviceInfo >(); break;
            }
            break;
        case 12:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QBluetoothServiceInfo >(); break;
            }
            break;
        case 13:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QBluetoothAddress >(); break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QBluetoothLocalDevice::Pairing >(); break;
            }
            break;
        }
    } else if (_c == QMetaObject::IndexOfMethod) {
        int *result = reinterpret_cast<int *>(_a[0]);
        {
            using _t = void (BtConnector::*)(QBluetoothSocket * );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BtConnector::conectedToSocket)) {
                *result = 0;
                return;
            }
        }
        {
            using _t = void (BtConnector::*)(QBluetoothSocket * , QString );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BtConnector::conectedToSocket)) {
                *result = 1;
                return;
            }
        }
        {
            using _t = void (BtConnector::*)(QBluetoothDeviceInfo * );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BtConnector::notConectedToSocket)) {
                *result = 2;
                return;
            }
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject BtConnector::staticMetaObject = {
    { &QDialog::staticMetaObject, qt_meta_stringdata_BtConnector.data,
      qt_meta_data_BtConnector,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *BtConnector::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *BtConnector::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_BtConnector.stringdata0))
        return static_cast<void*>(this);
    return QDialog::qt_metacast(_clname);
}

int BtConnector::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QDialog::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 18)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 18;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 18)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 18;
    }
    return _id;
}

// SIGNAL 0
void BtConnector::conectedToSocket(QBluetoothSocket * _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}

// SIGNAL 1
void BtConnector::conectedToSocket(QBluetoothSocket * _t1, QString _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 1, _a);
}

// SIGNAL 2
void BtConnector::notConectedToSocket(QBluetoothDeviceInfo * _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 2, _a);
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
