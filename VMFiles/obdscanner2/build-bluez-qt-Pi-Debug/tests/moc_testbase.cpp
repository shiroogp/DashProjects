/****************************************************************************
** Meta object code from reading C++ file 'testbase.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.11.4)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../libbluez-qt/tests/testbase.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'testbase.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.11.4. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_Tests__TestBase_t {
    QByteArrayData data[1];
    char stringdata0[16];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_Tests__TestBase_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_Tests__TestBase_t qt_meta_stringdata_Tests__TestBase = {
    {
QT_MOC_LITERAL(0, 0, 15) // "Tests::TestBase"

    },
    "Tests::TestBase"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_Tests__TestBase[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
       0,    0, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       0,       // signalCount

       0        // eod
};

void Tests::TestBase::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    Q_UNUSED(_o);
    Q_UNUSED(_id);
    Q_UNUSED(_c);
    Q_UNUSED(_a);
}

QT_INIT_METAOBJECT const QMetaObject Tests::TestBase::staticMetaObject = {
    { &QObject::staticMetaObject, qt_meta_stringdata_Tests__TestBase.data,
      qt_meta_data_Tests__TestBase,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *Tests::TestBase::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *Tests::TestBase::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_Tests__TestBase.stringdata0))
        return static_cast<void*>(this);
    return QObject::qt_metacast(_clname);
}

int Tests::TestBase::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QObject::qt_metacall(_c, _id, _a);
    return _id;
}
struct qt_meta_stringdata_Tests__BluezTestBase_t {
    QByteArrayData data[1];
    char stringdata0[21];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_Tests__BluezTestBase_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_Tests__BluezTestBase_t qt_meta_stringdata_Tests__BluezTestBase = {
    {
QT_MOC_LITERAL(0, 0, 20) // "Tests::BluezTestBase"

    },
    "Tests::BluezTestBase"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_Tests__BluezTestBase[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
       0,    0, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       0,       // signalCount

       0        // eod
};

void Tests::BluezTestBase::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    Q_UNUSED(_o);
    Q_UNUSED(_id);
    Q_UNUSED(_c);
    Q_UNUSED(_a);
}

QT_INIT_METAOBJECT const QMetaObject Tests::BluezTestBase::staticMetaObject = {
    { &TestBase::staticMetaObject, qt_meta_stringdata_Tests__BluezTestBase.data,
      qt_meta_data_Tests__BluezTestBase,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *Tests::BluezTestBase::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *Tests::BluezTestBase::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_Tests__BluezTestBase.stringdata0))
        return static_cast<void*>(this);
    return TestBase::qt_metacast(_clname);
}

int Tests::BluezTestBase::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = TestBase::qt_metacall(_c, _id, _a);
    return _id;
}
struct qt_meta_stringdata_Tests__TestBase__SignalSpy_t {
    QByteArrayData data[3];
    char stringdata0[42];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_Tests__TestBase__SignalSpy_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_Tests__TestBase__SignalSpy_t qt_meta_stringdata_Tests__TestBase__SignalSpy = {
    {
QT_MOC_LITERAL(0, 0, 26), // "Tests::TestBase::SignalSpy"
QT_MOC_LITERAL(1, 27, 13), // "signalEmitted"
QT_MOC_LITERAL(2, 41, 0) // ""

    },
    "Tests::TestBase::SignalSpy\0signalEmitted\0"
    ""
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_Tests__TestBase__SignalSpy[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
       1,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       1,       // signalCount

 // signals: name, argc, parameters, tag, flags
       1,    0,   19,    2, 0x06 /* Public */,

 // signals: parameters
    QMetaType::Void,

       0        // eod
};

void Tests::TestBase::SignalSpy::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        SignalSpy *_t = static_cast<SignalSpy *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->signalEmitted(); break;
        default: ;
        }
    } else if (_c == QMetaObject::IndexOfMethod) {
        int *result = reinterpret_cast<int *>(_a[0]);
        {
            using _t = void (SignalSpy::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&SignalSpy::signalEmitted)) {
                *result = 0;
                return;
            }
        }
    }
    Q_UNUSED(_a);
}

QT_INIT_METAOBJECT const QMetaObject Tests::TestBase::SignalSpy::staticMetaObject = {
    { &QSignalSpy::staticMetaObject, qt_meta_stringdata_Tests__TestBase__SignalSpy.data,
      qt_meta_data_Tests__TestBase__SignalSpy,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *Tests::TestBase::SignalSpy::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *Tests::TestBase::SignalSpy::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_Tests__TestBase__SignalSpy.stringdata0))
        return static_cast<void*>(this);
    return QSignalSpy::qt_metacast(_clname);
}

int Tests::TestBase::SignalSpy::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QSignalSpy::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 1)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 1;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 1)
            *reinterpret_cast<int*>(_a[0]) = -1;
        _id -= 1;
    }
    return _id;
}

// SIGNAL 0
void Tests::TestBase::SignalSpy::signalEmitted()
{
    QMetaObject::activate(this, &staticMetaObject, 0, nullptr);
}
struct qt_meta_stringdata_Tests__BluezTestBase__ManagerMock_t {
    QByteArrayData data[21];
    char stringdata0[320];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_Tests__BluezTestBase__ManagerMock_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_Tests__BluezTestBase__ManagerMock_t qt_meta_stringdata_Tests__BluezTestBase__ManagerMock = {
    {
QT_MOC_LITERAL(0, 0, 33), // "Tests::BluezTestBase::Manager..."
QT_MOC_LITERAL(1, 34, 15), // "D-Bus Interface"
QT_MOC_LITERAL(2, 50, 17), // "org.bluez.Manager"
QT_MOC_LITERAL(3, 68, 15), // "PropertyChanged"
QT_MOC_LITERAL(4, 84, 0), // ""
QT_MOC_LITERAL(5, 85, 3), // "key"
QT_MOC_LITERAL(6, 89, 12), // "QDBusVariant"
QT_MOC_LITERAL(7, 102, 5), // "value"
QT_MOC_LITERAL(8, 108, 12), // "AdapterAdded"
QT_MOC_LITERAL(9, 121, 15), // "QDBusObjectPath"
QT_MOC_LITERAL(10, 137, 4), // "path"
QT_MOC_LITERAL(11, 142, 14), // "AdapterRemoved"
QT_MOC_LITERAL(12, 157, 21), // "DefaultAdapterChanged"
QT_MOC_LITERAL(13, 179, 18), // "defaultAdapterPath"
QT_MOC_LITERAL(14, 198, 14), // "DefaultAdapter"
QT_MOC_LITERAL(15, 213, 13), // "GetProperties"
QT_MOC_LITERAL(16, 227, 10), // "mock_reset"
QT_MOC_LITERAL(17, 238, 20), // "mock_beginAddAdapter"
QT_MOC_LITERAL(18, 259, 18), // "mock_endAddAdapter"
QT_MOC_LITERAL(19, 278, 18), // "mock_removeAdapter"
QT_MOC_LITERAL(20, 297, 22) // "mock_setDefaultAdapter"

    },
    "Tests::BluezTestBase::ManagerMock\0"
    "D-Bus Interface\0org.bluez.Manager\0"
    "PropertyChanged\0\0key\0QDBusVariant\0"
    "value\0AdapterAdded\0QDBusObjectPath\0"
    "path\0AdapterRemoved\0DefaultAdapterChanged\0"
    "defaultAdapterPath\0DefaultAdapter\0"
    "GetProperties\0mock_reset\0mock_beginAddAdapter\0"
    "mock_endAddAdapter\0mock_removeAdapter\0"
    "mock_setDefaultAdapter"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_Tests__BluezTestBase__ManagerMock[] = {

 // content:
       7,       // revision
       0,       // classname
       1,   14, // classinfo
      11,   16, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       4,       // signalCount

 // classinfo: key, value
       1,    2,

 // signals: name, argc, parameters, tag, flags
       3,    2,   71,    4, 0x46 /* Public | isScriptable */,
       8,    1,   76,    4, 0x46 /* Public | isScriptable */,
      11,    1,   79,    4, 0x46 /* Public | isScriptable */,
      12,    1,   82,    4, 0x46 /* Public | isScriptable */,

 // methods: name, argc, parameters, tag, flags
      14,    0,   85,    4, 0x42 /* Public | isScriptable */,
      15,    0,   86,    4, 0x42 /* Public | isScriptable */,
      16,    0,   87,    4, 0x42 /* Public | isScriptable */,
      17,    1,   88,    4, 0x42 /* Public | isScriptable */,
      18,    0,   91,    4, 0x42 /* Public | isScriptable */,
      19,    1,   92,    4, 0x42 /* Public | isScriptable */,
      20,    1,   95,    4, 0x42 /* Public | isScriptable */,

 // signals: parameters
    QMetaType::Void, QMetaType::QString, 0x80000000 | 6,    5,    7,
    QMetaType::Void, 0x80000000 | 9,   10,
    QMetaType::Void, 0x80000000 | 9,   10,
    QMetaType::Void, 0x80000000 | 9,   13,

 // methods: parameters
    0x80000000 | 9,
    QMetaType::QVariantMap,
    QMetaType::Void,
    QMetaType::Void, 0x80000000 | 9,   10,
    QMetaType::Void,
    QMetaType::Void, 0x80000000 | 9,   10,
    QMetaType::Void, 0x80000000 | 9,   10,

       0        // eod
};

void Tests::BluezTestBase::ManagerMock::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        ManagerMock *_t = static_cast<ManagerMock *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->PropertyChanged((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusVariant(*)>(_a[2]))); break;
        case 1: _t->AdapterAdded((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1]))); break;
        case 2: _t->AdapterRemoved((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1]))); break;
        case 3: _t->DefaultAdapterChanged((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1]))); break;
        case 4: { QDBusObjectPath _r = _t->DefaultAdapter();
            if (_a[0]) *reinterpret_cast< QDBusObjectPath*>(_a[0]) = std::move(_r); }  break;
        case 5: { QVariantMap _r = _t->GetProperties();
            if (_a[0]) *reinterpret_cast< QVariantMap*>(_a[0]) = std::move(_r); }  break;
        case 6: _t->mock_reset(); break;
        case 7: _t->mock_beginAddAdapter((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1]))); break;
        case 8: _t->mock_endAddAdapter(); break;
        case 9: _t->mock_removeAdapter((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1]))); break;
        case 10: _t->mock_setDefaultAdapter((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1]))); break;
        default: ;
        }
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        switch (_id) {
        default: *reinterpret_cast<int*>(_a[0]) = -1; break;
        case 0:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusVariant >(); break;
            }
            break;
        case 1:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 2:
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
        case 7:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 9:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 10:
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
            using _t = void (ManagerMock::*)(const QString & , const QDBusVariant & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ManagerMock::PropertyChanged)) {
                *result = 0;
                return;
            }
        }
        {
            using _t = void (ManagerMock::*)(const QDBusObjectPath & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ManagerMock::AdapterAdded)) {
                *result = 1;
                return;
            }
        }
        {
            using _t = void (ManagerMock::*)(const QDBusObjectPath & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ManagerMock::AdapterRemoved)) {
                *result = 2;
                return;
            }
        }
        {
            using _t = void (ManagerMock::*)(const QDBusObjectPath & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ManagerMock::DefaultAdapterChanged)) {
                *result = 3;
                return;
            }
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject Tests::BluezTestBase::ManagerMock::staticMetaObject = {
    { &QObject::staticMetaObject, qt_meta_stringdata_Tests__BluezTestBase__ManagerMock.data,
      qt_meta_data_Tests__BluezTestBase__ManagerMock,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *Tests::BluezTestBase::ManagerMock::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *Tests::BluezTestBase::ManagerMock::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_Tests__BluezTestBase__ManagerMock.stringdata0))
        return static_cast<void*>(this);
    return QObject::qt_metacast(_clname);
}

int Tests::BluezTestBase::ManagerMock::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QObject::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 11)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 11;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 11)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 11;
    }
    return _id;
}

// SIGNAL 0
void Tests::BluezTestBase::ManagerMock::PropertyChanged(const QString & _t1, const QDBusVariant & _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}

// SIGNAL 1
void Tests::BluezTestBase::ManagerMock::AdapterAdded(const QDBusObjectPath & _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 1, _a);
}

// SIGNAL 2
void Tests::BluezTestBase::ManagerMock::AdapterRemoved(const QDBusObjectPath & _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 2, _a);
}

// SIGNAL 3
void Tests::BluezTestBase::ManagerMock::DefaultAdapterChanged(const QDBusObjectPath & _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 3, _a);
}
struct qt_meta_stringdata_Tests__BluezTestBase__AdapterMock_t {
    QByteArrayData data[40];
    char stringdata0[606];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_Tests__BluezTestBase__AdapterMock_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_Tests__BluezTestBase__AdapterMock_t qt_meta_stringdata_Tests__BluezTestBase__AdapterMock = {
    {
QT_MOC_LITERAL(0, 0, 33), // "Tests::BluezTestBase::Adapter..."
QT_MOC_LITERAL(1, 34, 15), // "D-Bus Interface"
QT_MOC_LITERAL(2, 50, 17), // "org.bluez.Adapter"
QT_MOC_LITERAL(3, 68, 15), // "PropertyChanged"
QT_MOC_LITERAL(4, 84, 0), // ""
QT_MOC_LITERAL(5, 85, 3), // "key"
QT_MOC_LITERAL(6, 89, 12), // "QDBusVariant"
QT_MOC_LITERAL(7, 102, 5), // "value"
QT_MOC_LITERAL(8, 108, 11), // "DeviceFound"
QT_MOC_LITERAL(9, 120, 7), // "address"
QT_MOC_LITERAL(10, 128, 10), // "properties"
QT_MOC_LITERAL(11, 139, 13), // "DeviceCreated"
QT_MOC_LITERAL(12, 153, 15), // "QDBusObjectPath"
QT_MOC_LITERAL(13, 169, 4), // "path"
QT_MOC_LITERAL(14, 174, 13), // "DeviceRemoved"
QT_MOC_LITERAL(15, 188, 17), // "DeviceDisappeared"
QT_MOC_LITERAL(16, 206, 20), // "mock_agentRegistered"
QT_MOC_LITERAL(17, 227, 10), // "devicePath"
QT_MOC_LITERAL(18, 238, 29), // "mock_createPairedDeviceCalled"
QT_MOC_LITERAL(19, 268, 12), // "deviceAddres"
QT_MOC_LITERAL(20, 281, 9), // "agentPath"
QT_MOC_LITERAL(21, 291, 10), // "capability"
QT_MOC_LITERAL(22, 302, 13), // "GetProperties"
QT_MOC_LITERAL(23, 316, 11), // "SetProperty"
QT_MOC_LITERAL(24, 328, 14), // "StartDiscovery"
QT_MOC_LITERAL(25, 343, 13), // "StopDiscovery"
QT_MOC_LITERAL(26, 357, 11), // "ListDevices"
QT_MOC_LITERAL(27, 369, 22), // "QList<QDBusObjectPath>"
QT_MOC_LITERAL(28, 392, 13), // "RegisterAgent"
QT_MOC_LITERAL(29, 406, 12), // "QDBusMessage"
QT_MOC_LITERAL(30, 419, 7), // "message"
QT_MOC_LITERAL(31, 427, 18), // "CreatePairedDevice"
QT_MOC_LITERAL(32, 446, 13), // "deviceAddress"
QT_MOC_LITERAL(33, 460, 24), // "mock_setPropertyNoNotify"
QT_MOC_LITERAL(34, 485, 19), // "mock_beginAddDevice"
QT_MOC_LITERAL(35, 505, 17), // "mock_endAddDevice"
QT_MOC_LITERAL(36, 523, 17), // "mock_removeDevice"
QT_MOC_LITERAL(37, 541, 24), // "mock_requestConfirmation"
QT_MOC_LITERAL(38, 566, 19), // "mock_requestPasskey"
QT_MOC_LITERAL(39, 586, 19) // "mock_requestPinCode"

    },
    "Tests::BluezTestBase::AdapterMock\0"
    "D-Bus Interface\0org.bluez.Adapter\0"
    "PropertyChanged\0\0key\0QDBusVariant\0"
    "value\0DeviceFound\0address\0properties\0"
    "DeviceCreated\0QDBusObjectPath\0path\0"
    "DeviceRemoved\0DeviceDisappeared\0"
    "mock_agentRegistered\0devicePath\0"
    "mock_createPairedDeviceCalled\0"
    "deviceAddres\0agentPath\0capability\0"
    "GetProperties\0SetProperty\0StartDiscovery\0"
    "StopDiscovery\0ListDevices\0"
    "QList<QDBusObjectPath>\0RegisterAgent\0"
    "QDBusMessage\0message\0CreatePairedDevice\0"
    "deviceAddress\0mock_setPropertyNoNotify\0"
    "mock_beginAddDevice\0mock_endAddDevice\0"
    "mock_removeDevice\0mock_requestConfirmation\0"
    "mock_requestPasskey\0mock_requestPinCode"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_Tests__BluezTestBase__AdapterMock[] = {

 // content:
       7,       // revision
       0,       // classname
       1,   14, // classinfo
      21,   16, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       7,       // signalCount

 // classinfo: key, value
       1,    2,

 // signals: name, argc, parameters, tag, flags
       3,    2,  121,    4, 0x46 /* Public | isScriptable */,
       8,    2,  126,    4, 0x46 /* Public | isScriptable */,
      11,    1,  131,    4, 0x46 /* Public | isScriptable */,
      14,    1,  134,    4, 0x46 /* Public | isScriptable */,
      15,    1,  137,    4, 0x46 /* Public | isScriptable */,
      16,    1,  140,    4, 0x46 /* Public | isScriptable */,
      18,    3,  143,    4, 0x46 /* Public | isScriptable */,

 // methods: name, argc, parameters, tag, flags
      22,    0,  150,    4, 0x42 /* Public | isScriptable */,
      23,    2,  151,    4, 0x42 /* Public | isScriptable */,
      24,    0,  156,    4, 0x42 /* Public | isScriptable */,
      25,    0,  157,    4, 0x42 /* Public | isScriptable */,
      26,    0,  158,    4, 0x42 /* Public | isScriptable */,
      28,    3,  159,    4, 0x42 /* Public | isScriptable */,
      31,    3,  166,    4, 0x42 /* Public | isScriptable */,
      33,    2,  173,    4, 0x42 /* Public | isScriptable */,
      34,    1,  178,    4, 0x42 /* Public | isScriptable */,
      35,    0,  181,    4, 0x42 /* Public | isScriptable */,
      36,    1,  182,    4, 0x42 /* Public | isScriptable */,
      37,    3,  185,    4, 0x42 /* Public | isScriptable */,
      38,    2,  192,    4, 0x42 /* Public | isScriptable */,
      39,    2,  197,    4, 0x42 /* Public | isScriptable */,

 // signals: parameters
    QMetaType::Void, QMetaType::QString, 0x80000000 | 6,    5,    7,
    QMetaType::Void, QMetaType::QString, QMetaType::QVariantMap,    9,   10,
    QMetaType::Void, 0x80000000 | 12,   13,
    QMetaType::Void, 0x80000000 | 12,   13,
    QMetaType::Void, QMetaType::QString,    9,
    QMetaType::Void, 0x80000000 | 12,   17,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 12, QMetaType::QString,   19,   20,   21,

 // methods: parameters
    QMetaType::QVariantMap,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 6,    5,    7,
    QMetaType::Void,
    QMetaType::Void,
    0x80000000 | 27,
    QMetaType::Void, 0x80000000 | 12, QMetaType::QString, 0x80000000 | 29,   20,   21,   30,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 12, QMetaType::QString,   32,   20,   21,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 6,    5,    7,
    QMetaType::Void, 0x80000000 | 12,   13,
    QMetaType::Void,
    QMetaType::Void, 0x80000000 | 12,   13,
    QMetaType::Bool, 0x80000000 | 12, QMetaType::UInt, 0x80000000 | 29,   17,    5,   30,
    QMetaType::UInt, 0x80000000 | 12, 0x80000000 | 29,   17,   30,
    QMetaType::QString, 0x80000000 | 12, 0x80000000 | 29,   17,   30,

       0        // eod
};

void Tests::BluezTestBase::AdapterMock::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        AdapterMock *_t = static_cast<AdapterMock *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->PropertyChanged((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusVariant(*)>(_a[2]))); break;
        case 1: _t->DeviceFound((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QVariantMap(*)>(_a[2]))); break;
        case 2: _t->DeviceCreated((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1]))); break;
        case 3: _t->DeviceRemoved((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1]))); break;
        case 4: _t->DeviceDisappeared((*reinterpret_cast< const QString(*)>(_a[1]))); break;
        case 5: _t->mock_agentRegistered((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1]))); break;
        case 6: _t->mock_createPairedDeviceCalled((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusObjectPath(*)>(_a[2])),(*reinterpret_cast< const QString(*)>(_a[3]))); break;
        case 7: { QVariantMap _r = _t->GetProperties();
            if (_a[0]) *reinterpret_cast< QVariantMap*>(_a[0]) = std::move(_r); }  break;
        case 8: _t->SetProperty((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusVariant(*)>(_a[2]))); break;
        case 9: _t->StartDiscovery(); break;
        case 10: _t->StopDiscovery(); break;
        case 11: { QList<QDBusObjectPath> _r = _t->ListDevices();
            if (_a[0]) *reinterpret_cast< QList<QDBusObjectPath>*>(_a[0]) = std::move(_r); }  break;
        case 12: _t->RegisterAgent((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1])),(*reinterpret_cast< const QString(*)>(_a[2])),(*reinterpret_cast< const QDBusMessage(*)>(_a[3]))); break;
        case 13: _t->CreatePairedDevice((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusObjectPath(*)>(_a[2])),(*reinterpret_cast< const QString(*)>(_a[3]))); break;
        case 14: _t->mock_setPropertyNoNotify((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusVariant(*)>(_a[2]))); break;
        case 15: _t->mock_beginAddDevice((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1]))); break;
        case 16: _t->mock_endAddDevice(); break;
        case 17: _t->mock_removeDevice((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1]))); break;
        case 18: { bool _r = _t->mock_requestConfirmation((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1])),(*reinterpret_cast< uint(*)>(_a[2])),(*reinterpret_cast< const QDBusMessage(*)>(_a[3])));
            if (_a[0]) *reinterpret_cast< bool*>(_a[0]) = std::move(_r); }  break;
        case 19: { uint _r = _t->mock_requestPasskey((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1])),(*reinterpret_cast< const QDBusMessage(*)>(_a[2])));
            if (_a[0]) *reinterpret_cast< uint*>(_a[0]) = std::move(_r); }  break;
        case 20: { QString _r = _t->mock_requestPinCode((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1])),(*reinterpret_cast< const QDBusMessage(*)>(_a[2])));
            if (_a[0]) *reinterpret_cast< QString*>(_a[0]) = std::move(_r); }  break;
        default: ;
        }
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        switch (_id) {
        default: *reinterpret_cast<int*>(_a[0]) = -1; break;
        case 0:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusVariant >(); break;
            }
            break;
        case 2:
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
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 8:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusVariant >(); break;
            }
            break;
        case 12:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 2:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusMessage >(); break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 13:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 14:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusVariant >(); break;
            }
            break;
        case 15:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 17:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 18:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 2:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusMessage >(); break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 19:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusMessage >(); break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        case 20:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusMessage >(); break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusObjectPath >(); break;
            }
            break;
        }
    } else if (_c == QMetaObject::IndexOfMethod) {
        int *result = reinterpret_cast<int *>(_a[0]);
        {
            using _t = void (AdapterMock::*)(const QString & , const QDBusVariant & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&AdapterMock::PropertyChanged)) {
                *result = 0;
                return;
            }
        }
        {
            using _t = void (AdapterMock::*)(const QString & , const QVariantMap & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&AdapterMock::DeviceFound)) {
                *result = 1;
                return;
            }
        }
        {
            using _t = void (AdapterMock::*)(const QDBusObjectPath & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&AdapterMock::DeviceCreated)) {
                *result = 2;
                return;
            }
        }
        {
            using _t = void (AdapterMock::*)(const QDBusObjectPath & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&AdapterMock::DeviceRemoved)) {
                *result = 3;
                return;
            }
        }
        {
            using _t = void (AdapterMock::*)(const QString & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&AdapterMock::DeviceDisappeared)) {
                *result = 4;
                return;
            }
        }
        {
            using _t = void (AdapterMock::*)(const QDBusObjectPath & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&AdapterMock::mock_agentRegistered)) {
                *result = 5;
                return;
            }
        }
        {
            using _t = void (AdapterMock::*)(const QString & , const QDBusObjectPath & , const QString & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&AdapterMock::mock_createPairedDeviceCalled)) {
                *result = 6;
                return;
            }
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject Tests::BluezTestBase::AdapterMock::staticMetaObject = {
    { &QObject::staticMetaObject, qt_meta_stringdata_Tests__BluezTestBase__AdapterMock.data,
      qt_meta_data_Tests__BluezTestBase__AdapterMock,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *Tests::BluezTestBase::AdapterMock::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *Tests::BluezTestBase::AdapterMock::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_Tests__BluezTestBase__AdapterMock.stringdata0))
        return static_cast<void*>(this);
    return QObject::qt_metacast(_clname);
}

int Tests::BluezTestBase::AdapterMock::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QObject::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 21)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 21;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 21)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 21;
    }
    return _id;
}

// SIGNAL 0
void Tests::BluezTestBase::AdapterMock::PropertyChanged(const QString & _t1, const QDBusVariant & _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}

// SIGNAL 1
void Tests::BluezTestBase::AdapterMock::DeviceFound(const QString & _t1, const QVariantMap & _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 1, _a);
}

// SIGNAL 2
void Tests::BluezTestBase::AdapterMock::DeviceCreated(const QDBusObjectPath & _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 2, _a);
}

// SIGNAL 3
void Tests::BluezTestBase::AdapterMock::DeviceRemoved(const QDBusObjectPath & _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 3, _a);
}

// SIGNAL 4
void Tests::BluezTestBase::AdapterMock::DeviceDisappeared(const QString & _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 4, _a);
}

// SIGNAL 5
void Tests::BluezTestBase::AdapterMock::mock_agentRegistered(const QDBusObjectPath & _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 5, _a);
}

// SIGNAL 6
void Tests::BluezTestBase::AdapterMock::mock_createPairedDeviceCalled(const QString & _t1, const QDBusObjectPath & _t2, const QString & _t3)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)), const_cast<void*>(reinterpret_cast<const void*>(&_t3)) };
    QMetaObject::activate(this, &staticMetaObject, 6, _a);
}
struct qt_meta_stringdata_Tests__BluezTestBase__DeviceMock_t {
    QByteArrayData data[11];
    char stringdata0[157];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_Tests__BluezTestBase__DeviceMock_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_Tests__BluezTestBase__DeviceMock_t qt_meta_stringdata_Tests__BluezTestBase__DeviceMock = {
    {
QT_MOC_LITERAL(0, 0, 32), // "Tests::BluezTestBase::DeviceMock"
QT_MOC_LITERAL(1, 33, 15), // "D-Bus Interface"
QT_MOC_LITERAL(2, 49, 16), // "org.bluez.Device"
QT_MOC_LITERAL(3, 66, 15), // "PropertyChanged"
QT_MOC_LITERAL(4, 82, 0), // ""
QT_MOC_LITERAL(5, 83, 3), // "key"
QT_MOC_LITERAL(6, 87, 12), // "QDBusVariant"
QT_MOC_LITERAL(7, 100, 5), // "value"
QT_MOC_LITERAL(8, 106, 13), // "GetProperties"
QT_MOC_LITERAL(9, 120, 11), // "SetProperty"
QT_MOC_LITERAL(10, 132, 24) // "mock_setPropertyNoNotify"

    },
    "Tests::BluezTestBase::DeviceMock\0"
    "D-Bus Interface\0org.bluez.Device\0"
    "PropertyChanged\0\0key\0QDBusVariant\0"
    "value\0GetProperties\0SetProperty\0"
    "mock_setPropertyNoNotify"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_Tests__BluezTestBase__DeviceMock[] = {

 // content:
       7,       // revision
       0,       // classname
       1,   14, // classinfo
       4,   16, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       1,       // signalCount

 // classinfo: key, value
       1,    2,

 // signals: name, argc, parameters, tag, flags
       3,    2,   36,    4, 0x46 /* Public | isScriptable */,

 // methods: name, argc, parameters, tag, flags
       8,    0,   41,    4, 0x42 /* Public | isScriptable */,
       9,    2,   42,    4, 0x42 /* Public | isScriptable */,
      10,    2,   47,    4, 0x42 /* Public | isScriptable */,

 // signals: parameters
    QMetaType::Void, QMetaType::QString, 0x80000000 | 6,    5,    7,

 // methods: parameters
    QMetaType::QVariantMap,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 6,    5,    7,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 6,    5,    7,

       0        // eod
};

void Tests::BluezTestBase::DeviceMock::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        DeviceMock *_t = static_cast<DeviceMock *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->PropertyChanged((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusVariant(*)>(_a[2]))); break;
        case 1: { QVariantMap _r = _t->GetProperties();
            if (_a[0]) *reinterpret_cast< QVariantMap*>(_a[0]) = std::move(_r); }  break;
        case 2: _t->SetProperty((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusVariant(*)>(_a[2]))); break;
        case 3: _t->mock_setPropertyNoNotify((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusVariant(*)>(_a[2]))); break;
        default: ;
        }
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        switch (_id) {
        default: *reinterpret_cast<int*>(_a[0]) = -1; break;
        case 0:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusVariant >(); break;
            }
            break;
        case 2:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusVariant >(); break;
            }
            break;
        case 3:
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
            using _t = void (DeviceMock::*)(const QString & , const QDBusVariant & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&DeviceMock::PropertyChanged)) {
                *result = 0;
                return;
            }
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject Tests::BluezTestBase::DeviceMock::staticMetaObject = {
    { &QObject::staticMetaObject, qt_meta_stringdata_Tests__BluezTestBase__DeviceMock.data,
      qt_meta_data_Tests__BluezTestBase__DeviceMock,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *Tests::BluezTestBase::DeviceMock::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *Tests::BluezTestBase::DeviceMock::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_Tests__BluezTestBase__DeviceMock.stringdata0))
        return static_cast<void*>(this);
    return QObject::qt_metacast(_clname);
}

int Tests::BluezTestBase::DeviceMock::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QObject::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 4)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 4;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 4)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 4;
    }
    return _id;
}

// SIGNAL 0
void Tests::BluezTestBase::DeviceMock::PropertyChanged(const QString & _t1, const QDBusVariant & _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}
struct qt_meta_stringdata_Tests__BluezTestBase__DeviceMock__AudioAdaptor_t {
    QByteArrayData data[12];
    char stringdata0[170];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_Tests__BluezTestBase__DeviceMock__AudioAdaptor_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_Tests__BluezTestBase__DeviceMock__AudioAdaptor_t qt_meta_stringdata_Tests__BluezTestBase__DeviceMock__AudioAdaptor = {
    {
QT_MOC_LITERAL(0, 0, 46), // "Tests::BluezTestBase::DeviceM..."
QT_MOC_LITERAL(1, 47, 15), // "D-Bus Interface"
QT_MOC_LITERAL(2, 63, 15), // "org.bluez.Audio"
QT_MOC_LITERAL(3, 79, 15), // "PropertyChanged"
QT_MOC_LITERAL(4, 95, 0), // ""
QT_MOC_LITERAL(5, 96, 4), // "name"
QT_MOC_LITERAL(6, 101, 12), // "QDBusVariant"
QT_MOC_LITERAL(7, 114, 5), // "value"
QT_MOC_LITERAL(8, 120, 7), // "Connect"
QT_MOC_LITERAL(9, 128, 10), // "Disconnect"
QT_MOC_LITERAL(10, 139, 13), // "GetProperties"
QT_MOC_LITERAL(11, 153, 16) // "mock_setProperty"

    },
    "Tests::BluezTestBase::DeviceMock::AudioAdaptor\0"
    "D-Bus Interface\0org.bluez.Audio\0"
    "PropertyChanged\0\0name\0QDBusVariant\0"
    "value\0Connect\0Disconnect\0GetProperties\0"
    "mock_setProperty"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_Tests__BluezTestBase__DeviceMock__AudioAdaptor[] = {

 // content:
       7,       // revision
       0,       // classname
       1,   14, // classinfo
       5,   16, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       1,       // signalCount

 // classinfo: key, value
       1,    2,

 // signals: name, argc, parameters, tag, flags
       3,    2,   41,    4, 0x06 /* Public */,

 // slots: name, argc, parameters, tag, flags
       8,    0,   46,    4, 0x0a /* Public */,
       9,    0,   47,    4, 0x0a /* Public */,
      10,    0,   48,    4, 0x0a /* Public */,
      11,    2,   49,    4, 0x0a /* Public */,

 // signals: parameters
    QMetaType::Void, QMetaType::QString, 0x80000000 | 6,    5,    7,

 // slots: parameters
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::QVariantMap,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 6,    5,    7,

       0        // eod
};

void Tests::BluezTestBase::DeviceMock::AudioAdaptor::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        AudioAdaptor *_t = static_cast<AudioAdaptor *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->PropertyChanged((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusVariant(*)>(_a[2]))); break;
        case 1: _t->Connect(); break;
        case 2: _t->Disconnect(); break;
        case 3: { QVariantMap _r = _t->GetProperties();
            if (_a[0]) *reinterpret_cast< QVariantMap*>(_a[0]) = std::move(_r); }  break;
        case 4: _t->mock_setProperty((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusVariant(*)>(_a[2]))); break;
        default: ;
        }
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        switch (_id) {
        default: *reinterpret_cast<int*>(_a[0]) = -1; break;
        case 0:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusVariant >(); break;
            }
            break;
        case 4:
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
            using _t = void (AudioAdaptor::*)(const QString & , const QDBusVariant & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&AudioAdaptor::PropertyChanged)) {
                *result = 0;
                return;
            }
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject Tests::BluezTestBase::DeviceMock::AudioAdaptor::staticMetaObject = {
    { &QDBusAbstractAdaptor::staticMetaObject, qt_meta_stringdata_Tests__BluezTestBase__DeviceMock__AudioAdaptor.data,
      qt_meta_data_Tests__BluezTestBase__DeviceMock__AudioAdaptor,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *Tests::BluezTestBase::DeviceMock::AudioAdaptor::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *Tests::BluezTestBase::DeviceMock::AudioAdaptor::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_Tests__BluezTestBase__DeviceMock__AudioAdaptor.stringdata0))
        return static_cast<void*>(this);
    return QDBusAbstractAdaptor::qt_metacast(_clname);
}

int Tests::BluezTestBase::DeviceMock::AudioAdaptor::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QDBusAbstractAdaptor::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 5)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 5;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 5)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 5;
    }
    return _id;
}

// SIGNAL 0
void Tests::BluezTestBase::DeviceMock::AudioAdaptor::PropertyChanged(const QString & _t1, const QDBusVariant & _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}
struct qt_meta_stringdata_Tests__BluezTestBase__DeviceMock__InputAdaptor_t {
    QByteArrayData data[12];
    char stringdata0[170];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_Tests__BluezTestBase__DeviceMock__InputAdaptor_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_Tests__BluezTestBase__DeviceMock__InputAdaptor_t qt_meta_stringdata_Tests__BluezTestBase__DeviceMock__InputAdaptor = {
    {
QT_MOC_LITERAL(0, 0, 46), // "Tests::BluezTestBase::DeviceM..."
QT_MOC_LITERAL(1, 47, 15), // "D-Bus Interface"
QT_MOC_LITERAL(2, 63, 15), // "org.bluez.Input"
QT_MOC_LITERAL(3, 79, 15), // "PropertyChanged"
QT_MOC_LITERAL(4, 95, 0), // ""
QT_MOC_LITERAL(5, 96, 4), // "name"
QT_MOC_LITERAL(6, 101, 12), // "QDBusVariant"
QT_MOC_LITERAL(7, 114, 5), // "value"
QT_MOC_LITERAL(8, 120, 7), // "Connect"
QT_MOC_LITERAL(9, 128, 10), // "Disconnect"
QT_MOC_LITERAL(10, 139, 13), // "GetProperties"
QT_MOC_LITERAL(11, 153, 16) // "mock_setProperty"

    },
    "Tests::BluezTestBase::DeviceMock::InputAdaptor\0"
    "D-Bus Interface\0org.bluez.Input\0"
    "PropertyChanged\0\0name\0QDBusVariant\0"
    "value\0Connect\0Disconnect\0GetProperties\0"
    "mock_setProperty"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_Tests__BluezTestBase__DeviceMock__InputAdaptor[] = {

 // content:
       7,       // revision
       0,       // classname
       1,   14, // classinfo
       5,   16, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       1,       // signalCount

 // classinfo: key, value
       1,    2,

 // signals: name, argc, parameters, tag, flags
       3,    2,   41,    4, 0x06 /* Public */,

 // slots: name, argc, parameters, tag, flags
       8,    0,   46,    4, 0x0a /* Public */,
       9,    0,   47,    4, 0x0a /* Public */,
      10,    0,   48,    4, 0x0a /* Public */,
      11,    2,   49,    4, 0x0a /* Public */,

 // signals: parameters
    QMetaType::Void, QMetaType::QString, 0x80000000 | 6,    5,    7,

 // slots: parameters
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::QVariantMap,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 6,    5,    7,

       0        // eod
};

void Tests::BluezTestBase::DeviceMock::InputAdaptor::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        InputAdaptor *_t = static_cast<InputAdaptor *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->PropertyChanged((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusVariant(*)>(_a[2]))); break;
        case 1: _t->Connect(); break;
        case 2: _t->Disconnect(); break;
        case 3: { QVariantMap _r = _t->GetProperties();
            if (_a[0]) *reinterpret_cast< QVariantMap*>(_a[0]) = std::move(_r); }  break;
        case 4: _t->mock_setProperty((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusVariant(*)>(_a[2]))); break;
        default: ;
        }
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        switch (_id) {
        default: *reinterpret_cast<int*>(_a[0]) = -1; break;
        case 0:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusVariant >(); break;
            }
            break;
        case 4:
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
            using _t = void (InputAdaptor::*)(const QString & , const QDBusVariant & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&InputAdaptor::PropertyChanged)) {
                *result = 0;
                return;
            }
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject Tests::BluezTestBase::DeviceMock::InputAdaptor::staticMetaObject = {
    { &QDBusAbstractAdaptor::staticMetaObject, qt_meta_stringdata_Tests__BluezTestBase__DeviceMock__InputAdaptor.data,
      qt_meta_data_Tests__BluezTestBase__DeviceMock__InputAdaptor,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *Tests::BluezTestBase::DeviceMock::InputAdaptor::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *Tests::BluezTestBase::DeviceMock::InputAdaptor::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_Tests__BluezTestBase__DeviceMock__InputAdaptor.stringdata0))
        return static_cast<void*>(this);
    return QDBusAbstractAdaptor::qt_metacast(_clname);
}

int Tests::BluezTestBase::DeviceMock::InputAdaptor::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QDBusAbstractAdaptor::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 5)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 5;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 5)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 5;
    }
    return _id;
}

// SIGNAL 0
void Tests::BluezTestBase::DeviceMock::InputAdaptor::PropertyChanged(const QString & _t1, const QDBusVariant & _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
