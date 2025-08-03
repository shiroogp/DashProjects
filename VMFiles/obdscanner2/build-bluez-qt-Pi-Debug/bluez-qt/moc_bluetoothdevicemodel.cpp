/****************************************************************************
** Meta object code from reading C++ file 'bluetoothdevicemodel.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.11.4)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../libbluez-qt/bluez-qt/bluetoothdevicemodel.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'bluetoothdevicemodel.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.11.4. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_BluetoothDevicesModel_t {
    QByteArrayData data[45];
    char stringdata0[600];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_BluetoothDevicesModel_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_BluetoothDevicesModel_t qt_meta_stringdata_BluetoothDevicesModel = {
    {
QT_MOC_LITERAL(0, 0, 21), // "BluetoothDevicesModel"
QT_MOC_LITERAL(1, 22, 14), // "poweredChanged"
QT_MOC_LITERAL(2, 37, 0), // ""
QT_MOC_LITERAL(3, 38, 7), // "powered"
QT_MOC_LITERAL(4, 46, 26), // "discoverableTimeoutChanged"
QT_MOC_LITERAL(5, 73, 7), // "timeout"
QT_MOC_LITERAL(6, 81, 12), // "devicePaired"
QT_MOC_LITERAL(7, 94, 16), // "BluetoothDevice*"
QT_MOC_LITERAL(8, 111, 6), // "device"
QT_MOC_LITERAL(9, 118, 19), // "discoverableChanged"
QT_MOC_LITERAL(10, 138, 12), // "discoverable"
QT_MOC_LITERAL(11, 151, 14), // "adapterChanged"
QT_MOC_LITERAL(12, 166, 14), // "adapterPresent"
QT_MOC_LITERAL(13, 181, 16), // "connectedChanged"
QT_MOC_LITERAL(14, 198, 11), // "isConnected"
QT_MOC_LITERAL(15, 210, 11), // "columnCount"
QT_MOC_LITERAL(16, 222, 11), // "QModelIndex"
QT_MOC_LITERAL(17, 234, 8), // "rowCount"
QT_MOC_LITERAL(18, 243, 6), // "parent"
QT_MOC_LITERAL(19, 250, 4), // "data"
QT_MOC_LITERAL(20, 255, 5), // "index"
QT_MOC_LITERAL(21, 261, 4), // "role"
QT_MOC_LITERAL(22, 266, 10), // "devicePath"
QT_MOC_LITERAL(23, 277, 4), // "name"
QT_MOC_LITERAL(24, 282, 7), // "devices"
QT_MOC_LITERAL(25, 290, 23), // "QList<BluetoothDevice*>"
QT_MOC_LITERAL(26, 314, 9), // "connected"
QT_MOC_LITERAL(27, 324, 4), // "path"
QT_MOC_LITERAL(28, 329, 17), // "deviceByHwAddress"
QT_MOC_LITERAL(29, 347, 4), // "addy"
QT_MOC_LITERAL(30, 352, 11), // "makePowered"
QT_MOC_LITERAL(31, 364, 12), // "poweredValue"
QT_MOC_LITERAL(32, 377, 16), // "makeDiscoverable"
QT_MOC_LITERAL(33, 394, 17), // "discoverableValue"
QT_MOC_LITERAL(34, 412, 19), // "discoverableTimeout"
QT_MOC_LITERAL(35, 432, 22), // "setDiscoverableTimeout"
QT_MOC_LITERAL(36, 455, 21), // "defaultAdapterChanged"
QT_MOC_LITERAL(37, 477, 15), // "QDBusObjectPath"
QT_MOC_LITERAL(38, 493, 14), // "adapterRemoved"
QT_MOC_LITERAL(39, 508, 13), // "deviceCreated"
QT_MOC_LITERAL(40, 522, 13), // "deviceRemoved"
QT_MOC_LITERAL(41, 536, 21), // "devicePropertyChanged"
QT_MOC_LITERAL(42, 558, 5), // "value"
QT_MOC_LITERAL(43, 564, 22), // "adapterPropertyChanged"
QT_MOC_LITERAL(44, 587, 12) // "QDBusVariant"

    },
    "BluetoothDevicesModel\0poweredChanged\0"
    "\0powered\0discoverableTimeoutChanged\0"
    "timeout\0devicePaired\0BluetoothDevice*\0"
    "device\0discoverableChanged\0discoverable\0"
    "adapterChanged\0adapterPresent\0"
    "connectedChanged\0isConnected\0columnCount\0"
    "QModelIndex\0rowCount\0parent\0data\0index\0"
    "role\0devicePath\0name\0devices\0"
    "QList<BluetoothDevice*>\0connected\0"
    "path\0deviceByHwAddress\0addy\0makePowered\0"
    "poweredValue\0makeDiscoverable\0"
    "discoverableValue\0discoverableTimeout\0"
    "setDiscoverableTimeout\0defaultAdapterChanged\0"
    "QDBusObjectPath\0adapterRemoved\0"
    "deviceCreated\0deviceRemoved\0"
    "devicePropertyChanged\0value\0"
    "adapterPropertyChanged\0QDBusVariant"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_BluetoothDevicesModel[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
      27,   14, // methods
       5,  224, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       6,       // signalCount

 // signals: name, argc, parameters, tag, flags
       1,    1,  149,    2, 0x06 /* Public */,
       4,    1,  152,    2, 0x06 /* Public */,
       6,    1,  155,    2, 0x06 /* Public */,
       9,    1,  158,    2, 0x06 /* Public */,
      11,    1,  161,    2, 0x06 /* Public */,
      13,    1,  164,    2, 0x06 /* Public */,

 // slots: name, argc, parameters, tag, flags
      15,    1,  167,    2, 0x0a /* Public */,
      17,    1,  170,    2, 0x0a /* Public */,
      17,    0,  173,    2, 0x2a /* Public | MethodCloned */,
      19,    2,  174,    2, 0x0a /* Public */,
      22,    1,  179,    2, 0x0a /* Public */,
      24,    0,  182,    2, 0x0a /* Public */,
      26,    0,  183,    2, 0x0a /* Public */,
       8,    1,  184,    2, 0x0a /* Public */,
      28,    1,  187,    2, 0x0a /* Public */,
      30,    1,  190,    2, 0x0a /* Public */,
       3,    0,  193,    2, 0x0a /* Public */,
      32,    1,  194,    2, 0x0a /* Public */,
      10,    0,  197,    2, 0x0a /* Public */,
      34,    0,  198,    2, 0x0a /* Public */,
      35,    1,  199,    2, 0x0a /* Public */,
      36,    1,  202,    2, 0x08 /* Private */,
      38,    1,  205,    2, 0x08 /* Private */,
      39,    1,  208,    2, 0x08 /* Private */,
      40,    1,  211,    2, 0x08 /* Private */,
      41,    2,  214,    2, 0x08 /* Private */,
      43,    2,  219,    2, 0x08 /* Private */,

 // signals: parameters
    QMetaType::Void, QMetaType::Bool,    3,
    QMetaType::Void, QMetaType::Int,    5,
    QMetaType::Void, 0x80000000 | 7,    8,
    QMetaType::Void, QMetaType::Bool,   10,
    QMetaType::Void, QMetaType::Bool,   12,
    QMetaType::Void, QMetaType::Bool,   14,

 // slots: parameters
    QMetaType::Int, 0x80000000 | 16,    2,
    QMetaType::Int, 0x80000000 | 16,   18,
    QMetaType::Int,
    QMetaType::QVariant, 0x80000000 | 16, QMetaType::Int,   20,   21,
    QMetaType::QString, QMetaType::QString,   23,
    0x80000000 | 25,
    QMetaType::Bool,
    0x80000000 | 7, QMetaType::QString,   27,
    0x80000000 | 7, QMetaType::QString,   29,
    QMetaType::Void, QMetaType::Bool,   31,
    QMetaType::Bool,
    QMetaType::Void, QMetaType::Bool,   33,
    QMetaType::Bool,
    QMetaType::Int,
    QMetaType::Void, QMetaType::Int,    5,
    QMetaType::Void, 0x80000000 | 37,    2,
    QMetaType::Void, 0x80000000 | 37,    2,
    QMetaType::Void, 0x80000000 | 37,    2,
    QMetaType::Void, 0x80000000 | 37,    2,
    QMetaType::Void, QMetaType::QString, QMetaType::QVariant,   23,   42,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 44,   23,   42,

 // properties: name, type, flags
       3, QMetaType::Bool, 0x00495003,
      10, QMetaType::Bool, 0x00495003,
      34, QMetaType::Int, 0x00495103,
      12, QMetaType::Bool, 0x00495001,
      26, QMetaType::Bool, 0x00495001,

 // properties: notify_signal_id
       0,
       3,
       1,
       4,
       5,

       0        // eod
};

void BluetoothDevicesModel::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        BluetoothDevicesModel *_t = static_cast<BluetoothDevicesModel *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->poweredChanged((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 1: _t->discoverableTimeoutChanged((*reinterpret_cast< int(*)>(_a[1]))); break;
        case 2: _t->devicePaired((*reinterpret_cast< BluetoothDevice*(*)>(_a[1]))); break;
        case 3: _t->discoverableChanged((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 4: _t->adapterChanged((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 5: _t->connectedChanged((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 6: { int _r = _t->columnCount((*reinterpret_cast< const QModelIndex(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< int*>(_a[0]) = std::move(_r); }  break;
        case 7: { int _r = _t->rowCount((*reinterpret_cast< const QModelIndex(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< int*>(_a[0]) = std::move(_r); }  break;
        case 8: { int _r = _t->rowCount();
            if (_a[0]) *reinterpret_cast< int*>(_a[0]) = std::move(_r); }  break;
        case 9: { QVariant _r = _t->data((*reinterpret_cast< const QModelIndex(*)>(_a[1])),(*reinterpret_cast< int(*)>(_a[2])));
            if (_a[0]) *reinterpret_cast< QVariant*>(_a[0]) = std::move(_r); }  break;
        case 10: { QString _r = _t->devicePath((*reinterpret_cast< QString(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< QString*>(_a[0]) = std::move(_r); }  break;
        case 11: { QList<BluetoothDevice*> _r = _t->devices();
            if (_a[0]) *reinterpret_cast< QList<BluetoothDevice*>*>(_a[0]) = std::move(_r); }  break;
        case 12: { bool _r = _t->connected();
            if (_a[0]) *reinterpret_cast< bool*>(_a[0]) = std::move(_r); }  break;
        case 13: { BluetoothDevice* _r = _t->device((*reinterpret_cast< QString(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< BluetoothDevice**>(_a[0]) = std::move(_r); }  break;
        case 14: { BluetoothDevice* _r = _t->deviceByHwAddress((*reinterpret_cast< QString(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< BluetoothDevice**>(_a[0]) = std::move(_r); }  break;
        case 15: _t->makePowered((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 16: { bool _r = _t->powered();
            if (_a[0]) *reinterpret_cast< bool*>(_a[0]) = std::move(_r); }  break;
        case 17: _t->makeDiscoverable((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 18: { bool _r = _t->discoverable();
            if (_a[0]) *reinterpret_cast< bool*>(_a[0]) = std::move(_r); }  break;
        case 19: { int _r = _t->discoverableTimeout();
            if (_a[0]) *reinterpret_cast< int*>(_a[0]) = std::move(_r); }  break;
        case 20: _t->setDiscoverableTimeout((*reinterpret_cast< int(*)>(_a[1]))); break;
        case 21: _t->defaultAdapterChanged((*reinterpret_cast< QDBusObjectPath(*)>(_a[1]))); break;
        case 22: _t->adapterRemoved((*reinterpret_cast< QDBusObjectPath(*)>(_a[1]))); break;
        case 23: _t->deviceCreated((*reinterpret_cast< QDBusObjectPath(*)>(_a[1]))); break;
        case 24: _t->deviceRemoved((*reinterpret_cast< QDBusObjectPath(*)>(_a[1]))); break;
        case 25: _t->devicePropertyChanged((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< QVariant(*)>(_a[2]))); break;
        case 26: _t->adapterPropertyChanged((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< QDBusVariant(*)>(_a[2]))); break;
        default: ;
        }
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        switch (_id) {
        default: *reinterpret_cast<int*>(_a[0]) = -1; break;
        case 2:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< BluetoothDevice* >(); break;
            }
            break;
        case 21:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 22:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 23:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 24:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 26:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusVariant >(); break;
            }
            break;
        }
    } else if (_c == QMetaObject::IndexOfMethod) {
        int *result = reinterpret_cast<int *>(_a[0]);
        {
            using _t = void (BluetoothDevicesModel::*)(bool );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevicesModel::poweredChanged)) {
                *result = 0;
                return;
            }
        }
        {
            using _t = void (BluetoothDevicesModel::*)(int );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevicesModel::discoverableTimeoutChanged)) {
                *result = 1;
                return;
            }
        }
        {
            using _t = void (BluetoothDevicesModel::*)(BluetoothDevice * );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevicesModel::devicePaired)) {
                *result = 2;
                return;
            }
        }
        {
            using _t = void (BluetoothDevicesModel::*)(bool );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevicesModel::discoverableChanged)) {
                *result = 3;
                return;
            }
        }
        {
            using _t = void (BluetoothDevicesModel::*)(bool );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevicesModel::adapterChanged)) {
                *result = 4;
                return;
            }
        }
        {
            using _t = void (BluetoothDevicesModel::*)(bool );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevicesModel::connectedChanged)) {
                *result = 5;
                return;
            }
        }
    }
#ifndef QT_NO_PROPERTIES
    else if (_c == QMetaObject::ReadProperty) {
        BluetoothDevicesModel *_t = static_cast<BluetoothDevicesModel *>(_o);
        Q_UNUSED(_t)
        void *_v = _a[0];
        switch (_id) {
        case 0: *reinterpret_cast< bool*>(_v) = _t->powered(); break;
        case 1: *reinterpret_cast< bool*>(_v) = _t->discoverable(); break;
        case 2: *reinterpret_cast< int*>(_v) = _t->discoverableTimeout(); break;
        case 3: *reinterpret_cast< bool*>(_v) = _t->adapterPresent(); break;
        case 4: *reinterpret_cast< bool*>(_v) = _t->connected(); break;
        default: break;
        }
    } else if (_c == QMetaObject::WriteProperty) {
        BluetoothDevicesModel *_t = static_cast<BluetoothDevicesModel *>(_o);
        Q_UNUSED(_t)
        void *_v = _a[0];
        switch (_id) {
        case 0: _t->makePowered(*reinterpret_cast< bool*>(_v)); break;
        case 1: _t->makeDiscoverable(*reinterpret_cast< bool*>(_v)); break;
        case 2: _t->setDiscoverableTimeout(*reinterpret_cast< int*>(_v)); break;
        default: break;
        }
    } else if (_c == QMetaObject::ResetProperty) {
    }
#endif // QT_NO_PROPERTIES
}

QT_INIT_METAOBJECT const QMetaObject BluetoothDevicesModel::staticMetaObject = {
    { &QAbstractListModel::staticMetaObject, qt_meta_stringdata_BluetoothDevicesModel.data,
      qt_meta_data_BluetoothDevicesModel,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *BluetoothDevicesModel::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *BluetoothDevicesModel::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_BluetoothDevicesModel.stringdata0))
        return static_cast<void*>(this);
    return QAbstractListModel::qt_metacast(_clname);
}

int BluetoothDevicesModel::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QAbstractListModel::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 27)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 27;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 27)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 27;
    }
#ifndef QT_NO_PROPERTIES
   else if (_c == QMetaObject::ReadProperty || _c == QMetaObject::WriteProperty
            || _c == QMetaObject::ResetProperty || _c == QMetaObject::RegisterPropertyMetaType) {
        qt_static_metacall(this, _c, _id, _a);
        _id -= 5;
    } else if (_c == QMetaObject::QueryPropertyDesignable) {
        _id -= 5;
    } else if (_c == QMetaObject::QueryPropertyScriptable) {
        _id -= 5;
    } else if (_c == QMetaObject::QueryPropertyStored) {
        _id -= 5;
    } else if (_c == QMetaObject::QueryPropertyEditable) {
        _id -= 5;
    } else if (_c == QMetaObject::QueryPropertyUser) {
        _id -= 5;
    }
#endif // QT_NO_PROPERTIES
    return _id;
}

// SIGNAL 0
void BluetoothDevicesModel::poweredChanged(bool _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}

// SIGNAL 1
void BluetoothDevicesModel::discoverableTimeoutChanged(int _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 1, _a);
}

// SIGNAL 2
void BluetoothDevicesModel::devicePaired(BluetoothDevice * _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 2, _a);
}

// SIGNAL 3
void BluetoothDevicesModel::discoverableChanged(bool _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 3, _a);
}

// SIGNAL 4
void BluetoothDevicesModel::adapterChanged(bool _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 4, _a);
}

// SIGNAL 5
void BluetoothDevicesModel::connectedChanged(bool _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 5, _a);
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
