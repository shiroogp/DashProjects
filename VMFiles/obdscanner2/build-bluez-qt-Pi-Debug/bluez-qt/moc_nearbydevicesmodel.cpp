/****************************************************************************
** Meta object code from reading C++ file 'nearbydevicesmodel.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.11.4)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../libbluez-qt/bluez-qt/nearbydevicesmodel.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'nearbydevicesmodel.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.11.4. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_NearbyItem_t {
    QByteArrayData data[10];
    char stringdata0[87];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_NearbyItem_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_NearbyItem_t qt_meta_stringdata_NearbyItem = {
    {
QT_MOC_LITERAL(0, 0, 10), // "NearbyItem"
QT_MOC_LITERAL(1, 11, 11), // "nameChanged"
QT_MOC_LITERAL(2, 23, 0), // ""
QT_MOC_LITERAL(3, 24, 12), // "aliasChanged"
QT_MOC_LITERAL(4, 37, 11), // "iconChanged"
QT_MOC_LITERAL(5, 49, 4), // "name"
QT_MOC_LITERAL(6, 54, 5), // "alias"
QT_MOC_LITERAL(7, 60, 7), // "address"
QT_MOC_LITERAL(8, 68, 4), // "icon"
QT_MOC_LITERAL(9, 73, 13) // "legacyPairing"

    },
    "NearbyItem\0nameChanged\0\0aliasChanged\0"
    "iconChanged\0name\0alias\0address\0icon\0"
    "legacyPairing"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_NearbyItem[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
       3,   14, // methods
       5,   32, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       3,       // signalCount

 // signals: name, argc, parameters, tag, flags
       1,    0,   29,    2, 0x06 /* Public */,
       3,    0,   30,    2, 0x06 /* Public */,
       4,    0,   31,    2, 0x06 /* Public */,

 // signals: parameters
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,

 // properties: name, type, flags
       5, QMetaType::QString, 0x00495001,
       6, QMetaType::QString, 0x00495001,
       7, QMetaType::QString, 0x00095001,
       8, QMetaType::QString, 0x00495001,
       9, QMetaType::Bool, 0x00095001,

 // properties: notify_signal_id
       0,
       1,
       0,
       2,
       0,

       0        // eod
};

void NearbyItem::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        NearbyItem *_t = static_cast<NearbyItem *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->nameChanged(); break;
        case 1: _t->aliasChanged(); break;
        case 2: _t->iconChanged(); break;
        default: ;
        }
    } else if (_c == QMetaObject::IndexOfMethod) {
        int *result = reinterpret_cast<int *>(_a[0]);
        {
            using _t = void (NearbyItem::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&NearbyItem::nameChanged)) {
                *result = 0;
                return;
            }
        }
        {
            using _t = void (NearbyItem::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&NearbyItem::aliasChanged)) {
                *result = 1;
                return;
            }
        }
        {
            using _t = void (NearbyItem::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&NearbyItem::iconChanged)) {
                *result = 2;
                return;
            }
        }
    }
#ifndef QT_NO_PROPERTIES
    else if (_c == QMetaObject::ReadProperty) {
        NearbyItem *_t = static_cast<NearbyItem *>(_o);
        Q_UNUSED(_t)
        void *_v = _a[0];
        switch (_id) {
        case 0: *reinterpret_cast< QString*>(_v) = _t->name(); break;
        case 1: *reinterpret_cast< QString*>(_v) = _t->alias(); break;
        case 2: *reinterpret_cast< QString*>(_v) = _t->address(); break;
        case 3: *reinterpret_cast< QString*>(_v) = _t->icon(); break;
        case 4: *reinterpret_cast< bool*>(_v) = _t->legacyPairing(); break;
        default: break;
        }
    } else if (_c == QMetaObject::WriteProperty) {
    } else if (_c == QMetaObject::ResetProperty) {
    }
#endif // QT_NO_PROPERTIES
    Q_UNUSED(_a);
}

QT_INIT_METAOBJECT const QMetaObject NearbyItem::staticMetaObject = {
    { &QObject::staticMetaObject, qt_meta_stringdata_NearbyItem.data,
      qt_meta_data_NearbyItem,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *NearbyItem::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *NearbyItem::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_NearbyItem.stringdata0))
        return static_cast<void*>(this);
    return QObject::qt_metacast(_clname);
}

int NearbyItem::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QObject::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 3)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 3;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 3)
            *reinterpret_cast<int*>(_a[0]) = -1;
        _id -= 3;
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
void NearbyItem::nameChanged()
{
    QMetaObject::activate(this, &staticMetaObject, 0, nullptr);
}

// SIGNAL 1
void NearbyItem::aliasChanged()
{
    QMetaObject::activate(this, &staticMetaObject, 1, nullptr);
}

// SIGNAL 2
void NearbyItem::iconChanged()
{
    QMetaObject::activate(this, &staticMetaObject, 2, nullptr);
}
struct qt_meta_stringdata_NearbyDevicesModel_t {
    QByteArrayData data[46];
    char stringdata0[545];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_NearbyDevicesModel_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_NearbyDevicesModel_t qt_meta_stringdata_NearbyDevicesModel = {
    {
QT_MOC_LITERAL(0, 0, 18), // "NearbyDevicesModel"
QT_MOC_LITERAL(1, 19, 19), // "requestConfirmation"
QT_MOC_LITERAL(2, 39, 0), // ""
QT_MOC_LITERAL(3, 40, 6), // "device"
QT_MOC_LITERAL(4, 47, 4), // "code"
QT_MOC_LITERAL(5, 52, 14), // "requestPasskey"
QT_MOC_LITERAL(6, 67, 14), // "requestPidCode"
QT_MOC_LITERAL(7, 82, 7), // "release"
QT_MOC_LITERAL(8, 90, 17), // "nearbyDeviceFound"
QT_MOC_LITERAL(9, 108, 5), // "index"
QT_MOC_LITERAL(10, 114, 19), // "nearbyDeviceRemoved"
QT_MOC_LITERAL(11, 134, 24), // "adapterPropertiesChanged"
QT_MOC_LITERAL(12, 159, 4), // "name"
QT_MOC_LITERAL(13, 164, 5), // "value"
QT_MOC_LITERAL(14, 170, 11), // "columnCount"
QT_MOC_LITERAL(15, 182, 11), // "QModelIndex"
QT_MOC_LITERAL(16, 194, 8), // "rowCount"
QT_MOC_LITERAL(17, 203, 6), // "parent"
QT_MOC_LITERAL(18, 210, 4), // "data"
QT_MOC_LITERAL(19, 215, 4), // "role"
QT_MOC_LITERAL(20, 220, 9), // "hwAddress"
QT_MOC_LITERAL(21, 230, 5), // "alias"
QT_MOC_LITERAL(22, 236, 4), // "pair"
QT_MOC_LITERAL(23, 241, 6), // "hwaddy"
QT_MOC_LITERAL(24, 248, 8), // "discover"
QT_MOC_LITERAL(25, 257, 5), // "start"
QT_MOC_LITERAL(26, 263, 9), // "removeAll"
QT_MOC_LITERAL(27, 273, 24), // "replyRequestConfirmation"
QT_MOC_LITERAL(28, 298, 9), // "confirmed"
QT_MOC_LITERAL(29, 308, 12), // "replyPasskey"
QT_MOC_LITERAL(30, 321, 7), // "passkey"
QT_MOC_LITERAL(31, 329, 19), // "replyRequestPidCode"
QT_MOC_LITERAL(32, 349, 7), // "pidCode"
QT_MOC_LITERAL(33, 357, 18), // "setAdapterProperty"
QT_MOC_LITERAL(34, 376, 21), // "defaultAdapterChanged"
QT_MOC_LITERAL(35, 398, 15), // "QDBusObjectPath"
QT_MOC_LITERAL(36, 414, 14), // "adapterRemoved"
QT_MOC_LITERAL(37, 429, 13), // "deviceCreated"
QT_MOC_LITERAL(38, 443, 10), // "properties"
QT_MOC_LITERAL(39, 454, 13), // "deviceRemoved"
QT_MOC_LITERAL(40, 468, 28), // "adapterPropertiesChangedSlot"
QT_MOC_LITERAL(41, 497, 1), // "n"
QT_MOC_LITERAL(42, 499, 12), // "QDBusVariant"
QT_MOC_LITERAL(43, 512, 1), // "v"
QT_MOC_LITERAL(44, 514, 13), // "pairingDevice"
QT_MOC_LITERAL(45, 528, 16) // "BluetoothDevice*"

    },
    "NearbyDevicesModel\0requestConfirmation\0"
    "\0device\0code\0requestPasskey\0requestPidCode\0"
    "release\0nearbyDeviceFound\0index\0"
    "nearbyDeviceRemoved\0adapterPropertiesChanged\0"
    "name\0value\0columnCount\0QModelIndex\0"
    "rowCount\0parent\0data\0role\0hwAddress\0"
    "alias\0pair\0hwaddy\0discover\0start\0"
    "removeAll\0replyRequestConfirmation\0"
    "confirmed\0replyPasskey\0passkey\0"
    "replyRequestPidCode\0pidCode\0"
    "setAdapterProperty\0defaultAdapterChanged\0"
    "QDBusObjectPath\0adapterRemoved\0"
    "deviceCreated\0properties\0deviceRemoved\0"
    "adapterPropertiesChangedSlot\0n\0"
    "QDBusVariant\0v\0pairingDevice\0"
    "BluetoothDevice*"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_NearbyDevicesModel[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
      25,   14, // methods
       1,  222, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       7,       // signalCount

 // signals: name, argc, parameters, tag, flags
       1,    2,  139,    2, 0x06 /* Public */,
       5,    1,  144,    2, 0x06 /* Public */,
       6,    1,  147,    2, 0x06 /* Public */,
       7,    0,  150,    2, 0x06 /* Public */,
       8,    1,  151,    2, 0x06 /* Public */,
      10,    1,  154,    2, 0x06 /* Public */,
      11,    2,  157,    2, 0x06 /* Public */,

 // slots: name, argc, parameters, tag, flags
      14,    1,  162,    2, 0x0a /* Public */,
      16,    1,  165,    2, 0x0a /* Public */,
      16,    0,  168,    2, 0x2a /* Public | MethodCloned */,
      18,    2,  169,    2, 0x0a /* Public */,
      20,    1,  174,    2, 0x0a /* Public */,
      21,    1,  177,    2, 0x0a /* Public */,
      22,    1,  180,    2, 0x0a /* Public */,
      24,    1,  183,    2, 0x0a /* Public */,
      26,    1,  186,    2, 0x0a /* Public */,
      27,    1,  189,    2, 0x0a /* Public */,
      29,    1,  192,    2, 0x0a /* Public */,
      31,    1,  195,    2, 0x0a /* Public */,
      33,    2,  198,    2, 0x0a /* Public */,
      34,    1,  203,    2, 0x08 /* Private */,
      36,    1,  206,    2, 0x08 /* Private */,
      37,    2,  209,    2, 0x08 /* Private */,
      39,    1,  214,    2, 0x08 /* Private */,
      40,    2,  217,    2, 0x08 /* Private */,

 // signals: parameters
    QMetaType::Void, QMetaType::QString, QMetaType::UInt,    3,    4,
    QMetaType::Void, QMetaType::QString,    3,
    QMetaType::Void, QMetaType::QString,    3,
    QMetaType::Void,
    QMetaType::Void, QMetaType::Int,    9,
    QMetaType::Void, QMetaType::Int,    9,
    QMetaType::Void, QMetaType::QString, QMetaType::QVariant,   12,   13,

 // slots: parameters
    QMetaType::Int, 0x80000000 | 15,    2,
    QMetaType::Int, 0x80000000 | 15,   17,
    QMetaType::Int,
    QMetaType::QVariant, 0x80000000 | 15, QMetaType::Int,    9,   19,
    QMetaType::QString, QMetaType::Int,    9,
    QMetaType::QString, QMetaType::Int,    9,
    QMetaType::Void, QMetaType::QString,   23,
    QMetaType::Void, QMetaType::Bool,   25,
    QMetaType::Void, QMetaType::Bool,    2,
    QMetaType::Void, QMetaType::Bool,   28,
    QMetaType::Void, QMetaType::UInt,   30,
    QMetaType::Void, QMetaType::QString,   32,
    QMetaType::Void, QMetaType::QString, QMetaType::QVariant,   12,   13,
    QMetaType::Void, 0x80000000 | 35,    2,
    QMetaType::Void, 0x80000000 | 35,    2,
    QMetaType::Void, QMetaType::QString, QMetaType::QVariantMap,   23,   38,
    QMetaType::Void, QMetaType::QString,   23,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 42,   41,   43,

 // properties: name, type, flags
      44, 0x80000000 | 45, 0x00095009,

       0        // eod
};

void NearbyDevicesModel::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        NearbyDevicesModel *_t = static_cast<NearbyDevicesModel *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->requestConfirmation((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< uint(*)>(_a[2]))); break;
        case 1: _t->requestPasskey((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 2: _t->requestPidCode((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 3: _t->release(); break;
        case 4: _t->nearbyDeviceFound((*reinterpret_cast< int(*)>(_a[1]))); break;
        case 5: _t->nearbyDeviceRemoved((*reinterpret_cast< int(*)>(_a[1]))); break;
        case 6: _t->adapterPropertiesChanged((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< QVariant(*)>(_a[2]))); break;
        case 7: { int _r = _t->columnCount((*reinterpret_cast< const QModelIndex(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< int*>(_a[0]) = std::move(_r); }  break;
        case 8: { int _r = _t->rowCount((*reinterpret_cast< const QModelIndex(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< int*>(_a[0]) = std::move(_r); }  break;
        case 9: { int _r = _t->rowCount();
            if (_a[0]) *reinterpret_cast< int*>(_a[0]) = std::move(_r); }  break;
        case 10: { QVariant _r = _t->data((*reinterpret_cast< const QModelIndex(*)>(_a[1])),(*reinterpret_cast< int(*)>(_a[2])));
            if (_a[0]) *reinterpret_cast< QVariant*>(_a[0]) = std::move(_r); }  break;
        case 11: { QString _r = _t->hwAddress((*reinterpret_cast< int(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< QString*>(_a[0]) = std::move(_r); }  break;
        case 12: { QString _r = _t->alias((*reinterpret_cast< int(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< QString*>(_a[0]) = std::move(_r); }  break;
        case 13: _t->pair((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 14: _t->discover((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 15: _t->removeAll((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 16: _t->replyRequestConfirmation((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 17: _t->replyPasskey((*reinterpret_cast< uint(*)>(_a[1]))); break;
        case 18: _t->replyRequestPidCode((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 19: _t->setAdapterProperty((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< QVariant(*)>(_a[2]))); break;
        case 20: _t->defaultAdapterChanged((*reinterpret_cast< QDBusObjectPath(*)>(_a[1]))); break;
        case 21: _t->adapterRemoved((*reinterpret_cast< QDBusObjectPath(*)>(_a[1]))); break;
        case 22: _t->deviceCreated((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< QVariantMap(*)>(_a[2]))); break;
        case 23: _t->deviceRemoved((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 24: _t->adapterPropertiesChangedSlot((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< QDBusVariant(*)>(_a[2]))); break;
        default: ;
        }
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        switch (_id) {
        default: *reinterpret_cast<int*>(_a[0]) = -1; break;
        case 20:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 21:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 24:
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
            using _t = void (NearbyDevicesModel::*)(QString , uint );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&NearbyDevicesModel::requestConfirmation)) {
                *result = 0;
                return;
            }
        }
        {
            using _t = void (NearbyDevicesModel::*)(QString );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&NearbyDevicesModel::requestPasskey)) {
                *result = 1;
                return;
            }
        }
        {
            using _t = void (NearbyDevicesModel::*)(QString );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&NearbyDevicesModel::requestPidCode)) {
                *result = 2;
                return;
            }
        }
        {
            using _t = void (NearbyDevicesModel::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&NearbyDevicesModel::release)) {
                *result = 3;
                return;
            }
        }
        {
            using _t = void (NearbyDevicesModel::*)(int );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&NearbyDevicesModel::nearbyDeviceFound)) {
                *result = 4;
                return;
            }
        }
        {
            using _t = void (NearbyDevicesModel::*)(int );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&NearbyDevicesModel::nearbyDeviceRemoved)) {
                *result = 5;
                return;
            }
        }
        {
            using _t = void (NearbyDevicesModel::*)(QString , QVariant );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&NearbyDevicesModel::adapterPropertiesChanged)) {
                *result = 6;
                return;
            }
        }
    } else if (_c == QMetaObject::RegisterPropertyMetaType) {
        switch (_id) {
        default: *reinterpret_cast<int*>(_a[0]) = -1; break;
        case 0:
            *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< BluetoothDevice* >(); break;
        }
    }

#ifndef QT_NO_PROPERTIES
    else if (_c == QMetaObject::ReadProperty) {
        NearbyDevicesModel *_t = static_cast<NearbyDevicesModel *>(_o);
        Q_UNUSED(_t)
        void *_v = _a[0];
        switch (_id) {
        case 0: *reinterpret_cast< BluetoothDevice**>(_v) = _t->pairingDevice(); break;
        default: break;
        }
    } else if (_c == QMetaObject::WriteProperty) {
    } else if (_c == QMetaObject::ResetProperty) {
    }
#endif // QT_NO_PROPERTIES
}

QT_INIT_METAOBJECT const QMetaObject NearbyDevicesModel::staticMetaObject = {
    { &QAbstractListModel::staticMetaObject, qt_meta_stringdata_NearbyDevicesModel.data,
      qt_meta_data_NearbyDevicesModel,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *NearbyDevicesModel::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *NearbyDevicesModel::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_NearbyDevicesModel.stringdata0))
        return static_cast<void*>(this);
    return QAbstractListModel::qt_metacast(_clname);
}

int NearbyDevicesModel::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QAbstractListModel::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 25)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 25;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 25)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 25;
    }
#ifndef QT_NO_PROPERTIES
   else if (_c == QMetaObject::ReadProperty || _c == QMetaObject::WriteProperty
            || _c == QMetaObject::ResetProperty || _c == QMetaObject::RegisterPropertyMetaType) {
        qt_static_metacall(this, _c, _id, _a);
        _id -= 1;
    } else if (_c == QMetaObject::QueryPropertyDesignable) {
        _id -= 1;
    } else if (_c == QMetaObject::QueryPropertyScriptable) {
        _id -= 1;
    } else if (_c == QMetaObject::QueryPropertyStored) {
        _id -= 1;
    } else if (_c == QMetaObject::QueryPropertyEditable) {
        _id -= 1;
    } else if (_c == QMetaObject::QueryPropertyUser) {
        _id -= 1;
    }
#endif // QT_NO_PROPERTIES
    return _id;
}

// SIGNAL 0
void NearbyDevicesModel::requestConfirmation(QString _t1, uint _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}

// SIGNAL 1
void NearbyDevicesModel::requestPasskey(QString _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 1, _a);
}

// SIGNAL 2
void NearbyDevicesModel::requestPidCode(QString _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 2, _a);
}

// SIGNAL 3
void NearbyDevicesModel::release()
{
    QMetaObject::activate(this, &staticMetaObject, 3, nullptr);
}

// SIGNAL 4
void NearbyDevicesModel::nearbyDeviceFound(int _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 4, _a);
}

// SIGNAL 5
void NearbyDevicesModel::nearbyDeviceRemoved(int _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 5, _a);
}

// SIGNAL 6
void NearbyDevicesModel::adapterPropertiesChanged(QString _t1, QVariant _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 6, _a);
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
