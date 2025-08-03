/****************************************************************************
** Meta object code from reading C++ file 'blueadapter.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.11.4)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../libbluez-qt/bluez-qt/blueadapter.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'blueadapter.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.11.4. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_OrgBluezAdapterInterface_t {
    QByteArrayData data[30];
    char stringdata0[474];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_OrgBluezAdapterInterface_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_OrgBluezAdapterInterface_t qt_meta_stringdata_OrgBluezAdapterInterface = {
    {
QT_MOC_LITERAL(0, 0, 24), // "OrgBluezAdapterInterface"
QT_MOC_LITERAL(1, 25, 13), // "DeviceCreated"
QT_MOC_LITERAL(2, 39, 0), // ""
QT_MOC_LITERAL(3, 40, 15), // "QDBusObjectPath"
QT_MOC_LITERAL(4, 56, 3), // "in0"
QT_MOC_LITERAL(5, 60, 17), // "DeviceDisappeared"
QT_MOC_LITERAL(6, 78, 11), // "DeviceFound"
QT_MOC_LITERAL(7, 90, 3), // "in1"
QT_MOC_LITERAL(8, 94, 13), // "DeviceRemoved"
QT_MOC_LITERAL(9, 108, 15), // "PropertyChanged"
QT_MOC_LITERAL(10, 124, 12), // "QDBusVariant"
QT_MOC_LITERAL(11, 137, 20), // "CancelDeviceCreation"
QT_MOC_LITERAL(12, 158, 19), // "QDBusPendingReply<>"
QT_MOC_LITERAL(13, 178, 12), // "CreateDevice"
QT_MOC_LITERAL(14, 191, 34), // "QDBusPendingReply<QDBusObject..."
QT_MOC_LITERAL(15, 226, 18), // "CreatePairedDevice"
QT_MOC_LITERAL(16, 245, 3), // "in2"
QT_MOC_LITERAL(17, 249, 10), // "FindDevice"
QT_MOC_LITERAL(18, 260, 13), // "GetProperties"
QT_MOC_LITERAL(19, 274, 30), // "QDBusPendingReply<QVariantMap>"
QT_MOC_LITERAL(20, 305, 11), // "ListDevices"
QT_MOC_LITERAL(21, 317, 42), // "QDBusPendingReply<QList<QDBus..."
QT_MOC_LITERAL(22, 360, 13), // "RegisterAgent"
QT_MOC_LITERAL(23, 374, 14), // "ReleaseSession"
QT_MOC_LITERAL(24, 389, 12), // "RemoveDevice"
QT_MOC_LITERAL(25, 402, 14), // "RequestSession"
QT_MOC_LITERAL(26, 417, 11), // "SetProperty"
QT_MOC_LITERAL(27, 429, 14), // "StartDiscovery"
QT_MOC_LITERAL(28, 444, 13), // "StopDiscovery"
QT_MOC_LITERAL(29, 458, 15) // "UnregisterAgent"

    },
    "OrgBluezAdapterInterface\0DeviceCreated\0"
    "\0QDBusObjectPath\0in0\0DeviceDisappeared\0"
    "DeviceFound\0in1\0DeviceRemoved\0"
    "PropertyChanged\0QDBusVariant\0"
    "CancelDeviceCreation\0QDBusPendingReply<>\0"
    "CreateDevice\0QDBusPendingReply<QDBusObjectPath>\0"
    "CreatePairedDevice\0in2\0FindDevice\0"
    "GetProperties\0QDBusPendingReply<QVariantMap>\0"
    "ListDevices\0QDBusPendingReply<QList<QDBusObjectPath> >\0"
    "RegisterAgent\0ReleaseSession\0RemoveDevice\0"
    "RequestSession\0SetProperty\0StartDiscovery\0"
    "StopDiscovery\0UnregisterAgent"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_OrgBluezAdapterInterface[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
      19,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       5,       // signalCount

 // signals: name, argc, parameters, tag, flags
       1,    1,  109,    2, 0x06 /* Public */,
       5,    1,  112,    2, 0x06 /* Public */,
       6,    2,  115,    2, 0x06 /* Public */,
       8,    1,  120,    2, 0x06 /* Public */,
       9,    2,  123,    2, 0x06 /* Public */,

 // slots: name, argc, parameters, tag, flags
      11,    1,  128,    2, 0x0a /* Public */,
      13,    1,  131,    2, 0x0a /* Public */,
      15,    3,  134,    2, 0x0a /* Public */,
      17,    1,  141,    2, 0x0a /* Public */,
      18,    0,  144,    2, 0x0a /* Public */,
      20,    0,  145,    2, 0x0a /* Public */,
      22,    2,  146,    2, 0x0a /* Public */,
      23,    0,  151,    2, 0x0a /* Public */,
      24,    1,  152,    2, 0x0a /* Public */,
      25,    0,  155,    2, 0x0a /* Public */,
      26,    2,  156,    2, 0x0a /* Public */,
      27,    0,  161,    2, 0x0a /* Public */,
      28,    0,  162,    2, 0x0a /* Public */,
      29,    1,  163,    2, 0x0a /* Public */,

 // signals: parameters
    QMetaType::Void, 0x80000000 | 3,    4,
    QMetaType::Void, QMetaType::QString,    4,
    QMetaType::Void, QMetaType::QString, QMetaType::QVariantMap,    4,    7,
    QMetaType::Void, 0x80000000 | 3,    4,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 10,    4,    7,

 // slots: parameters
    0x80000000 | 12, QMetaType::QString,    4,
    0x80000000 | 14, QMetaType::QString,    4,
    0x80000000 | 14, QMetaType::QString, 0x80000000 | 3, QMetaType::QString,    4,    7,   16,
    0x80000000 | 14, QMetaType::QString,    4,
    0x80000000 | 19,
    0x80000000 | 21,
    0x80000000 | 12, 0x80000000 | 3, QMetaType::QString,    4,    7,
    0x80000000 | 12,
    0x80000000 | 12, 0x80000000 | 3,    4,
    0x80000000 | 12,
    0x80000000 | 12, QMetaType::QString, 0x80000000 | 10,    4,    7,
    0x80000000 | 12,
    0x80000000 | 12,
    0x80000000 | 12, 0x80000000 | 3,    4,

       0        // eod
};

void OrgBluezAdapterInterface::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        OrgBluezAdapterInterface *_t = static_cast<OrgBluezAdapterInterface *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->DeviceCreated((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1]))); break;
        case 1: _t->DeviceDisappeared((*reinterpret_cast< const QString(*)>(_a[1]))); break;
        case 2: _t->DeviceFound((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QVariantMap(*)>(_a[2]))); break;
        case 3: _t->DeviceRemoved((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1]))); break;
        case 4: _t->PropertyChanged((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusVariant(*)>(_a[2]))); break;
        case 5: { QDBusPendingReply<> _r = _t->CancelDeviceCreation((*reinterpret_cast< const QString(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 6: { QDBusPendingReply<QDBusObjectPath> _r = _t->CreateDevice((*reinterpret_cast< const QString(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<QDBusObjectPath>*>(_a[0]) = std::move(_r); }  break;
        case 7: { QDBusPendingReply<QDBusObjectPath> _r = _t->CreatePairedDevice((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusObjectPath(*)>(_a[2])),(*reinterpret_cast< const QString(*)>(_a[3])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<QDBusObjectPath>*>(_a[0]) = std::move(_r); }  break;
        case 8: { QDBusPendingReply<QDBusObjectPath> _r = _t->FindDevice((*reinterpret_cast< const QString(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<QDBusObjectPath>*>(_a[0]) = std::move(_r); }  break;
        case 9: { QDBusPendingReply<QVariantMap> _r = _t->GetProperties();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<QVariantMap>*>(_a[0]) = std::move(_r); }  break;
        case 10: { QDBusPendingReply<QList<QDBusObjectPath> > _r = _t->ListDevices();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<QList<QDBusObjectPath> >*>(_a[0]) = std::move(_r); }  break;
        case 11: { QDBusPendingReply<> _r = _t->RegisterAgent((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1])),(*reinterpret_cast< const QString(*)>(_a[2])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 12: { QDBusPendingReply<> _r = _t->ReleaseSession();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 13: { QDBusPendingReply<> _r = _t->RemoveDevice((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 14: { QDBusPendingReply<> _r = _t->RequestSession();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 15: { QDBusPendingReply<> _r = _t->SetProperty((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusVariant(*)>(_a[2])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 16: { QDBusPendingReply<> _r = _t->StartDiscovery();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 17: { QDBusPendingReply<> _r = _t->StopDiscovery();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 18: { QDBusPendingReply<> _r = _t->UnregisterAgent((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
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
        case 4:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusVariant >(); break;
            }
            break;
        case 7:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 11:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 13:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 15:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusVariant >(); break;
            }
            break;
        case 18:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        }
    } else if (_c == QMetaObject::IndexOfMethod) {
        int *result = reinterpret_cast<int *>(_a[0]);
        {
            using _t = void (OrgBluezAdapterInterface::*)(const QDBusObjectPath & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezAdapterInterface::DeviceCreated)) {
                *result = 0;
                return;
            }
        }
        {
            using _t = void (OrgBluezAdapterInterface::*)(const QString & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezAdapterInterface::DeviceDisappeared)) {
                *result = 1;
                return;
            }
        }
        {
            using _t = void (OrgBluezAdapterInterface::*)(const QString & , const QVariantMap & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezAdapterInterface::DeviceFound)) {
                *result = 2;
                return;
            }
        }
        {
            using _t = void (OrgBluezAdapterInterface::*)(const QDBusObjectPath & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezAdapterInterface::DeviceRemoved)) {
                *result = 3;
                return;
            }
        }
        {
            using _t = void (OrgBluezAdapterInterface::*)(const QString & , const QDBusVariant & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezAdapterInterface::PropertyChanged)) {
                *result = 4;
                return;
            }
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject OrgBluezAdapterInterface::staticMetaObject = {
    { &QDBusAbstractInterface::staticMetaObject, qt_meta_stringdata_OrgBluezAdapterInterface.data,
      qt_meta_data_OrgBluezAdapterInterface,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *OrgBluezAdapterInterface::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *OrgBluezAdapterInterface::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_OrgBluezAdapterInterface.stringdata0))
        return static_cast<void*>(this);
    return QDBusAbstractInterface::qt_metacast(_clname);
}

int OrgBluezAdapterInterface::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QDBusAbstractInterface::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 19)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 19;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 19)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 19;
    }
    return _id;
}

// SIGNAL 0
void OrgBluezAdapterInterface::DeviceCreated(const QDBusObjectPath & _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}

// SIGNAL 1
void OrgBluezAdapterInterface::DeviceDisappeared(const QString & _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 1, _a);
}

// SIGNAL 2
void OrgBluezAdapterInterface::DeviceFound(const QString & _t1, const QVariantMap & _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 2, _a);
}

// SIGNAL 3
void OrgBluezAdapterInterface::DeviceRemoved(const QDBusObjectPath & _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 3, _a);
}

// SIGNAL 4
void OrgBluezAdapterInterface::PropertyChanged(const QString & _t1, const QDBusVariant & _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 4, _a);
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
