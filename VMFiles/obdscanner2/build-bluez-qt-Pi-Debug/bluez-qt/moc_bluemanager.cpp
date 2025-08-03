/****************************************************************************
** Meta object code from reading C++ file 'bluemanager.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.11.4)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../libbluez-qt/bluez-qt/bluemanager.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'bluemanager.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.11.4. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_OrgBluezManagerInterface_t {
    QByteArrayData data[17];
    char stringdata0[292];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_OrgBluezManagerInterface_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_OrgBluezManagerInterface_t qt_meta_stringdata_OrgBluezManagerInterface = {
    {
QT_MOC_LITERAL(0, 0, 24), // "OrgBluezManagerInterface"
QT_MOC_LITERAL(1, 25, 12), // "AdapterAdded"
QT_MOC_LITERAL(2, 38, 0), // ""
QT_MOC_LITERAL(3, 39, 15), // "QDBusObjectPath"
QT_MOC_LITERAL(4, 55, 3), // "in0"
QT_MOC_LITERAL(5, 59, 14), // "AdapterRemoved"
QT_MOC_LITERAL(6, 74, 21), // "DefaultAdapterChanged"
QT_MOC_LITERAL(7, 96, 15), // "PropertyChanged"
QT_MOC_LITERAL(8, 112, 12), // "QDBusVariant"
QT_MOC_LITERAL(9, 125, 3), // "in1"
QT_MOC_LITERAL(10, 129, 14), // "DefaultAdapter"
QT_MOC_LITERAL(11, 144, 34), // "QDBusPendingReply<QDBusObject..."
QT_MOC_LITERAL(12, 179, 11), // "FindAdapter"
QT_MOC_LITERAL(13, 191, 13), // "GetProperties"
QT_MOC_LITERAL(14, 205, 30), // "QDBusPendingReply<QVariantMap>"
QT_MOC_LITERAL(15, 236, 12), // "ListAdapters"
QT_MOC_LITERAL(16, 249, 42) // "QDBusPendingReply<QList<QDBus..."

    },
    "OrgBluezManagerInterface\0AdapterAdded\0"
    "\0QDBusObjectPath\0in0\0AdapterRemoved\0"
    "DefaultAdapterChanged\0PropertyChanged\0"
    "QDBusVariant\0in1\0DefaultAdapter\0"
    "QDBusPendingReply<QDBusObjectPath>\0"
    "FindAdapter\0GetProperties\0"
    "QDBusPendingReply<QVariantMap>\0"
    "ListAdapters\0QDBusPendingReply<QList<QDBusObjectPath> >"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_OrgBluezManagerInterface[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
       8,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       4,       // signalCount

 // signals: name, argc, parameters, tag, flags
       1,    1,   54,    2, 0x06 /* Public */,
       5,    1,   57,    2, 0x06 /* Public */,
       6,    1,   60,    2, 0x06 /* Public */,
       7,    2,   63,    2, 0x06 /* Public */,

 // slots: name, argc, parameters, tag, flags
      10,    0,   68,    2, 0x0a /* Public */,
      12,    1,   69,    2, 0x0a /* Public */,
      13,    0,   72,    2, 0x0a /* Public */,
      15,    0,   73,    2, 0x0a /* Public */,

 // signals: parameters
    QMetaType::Void, 0x80000000 | 3,    4,
    QMetaType::Void, 0x80000000 | 3,    4,
    QMetaType::Void, 0x80000000 | 3,    4,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 8,    4,    9,

 // slots: parameters
    0x80000000 | 11,
    0x80000000 | 11, QMetaType::QString,    4,
    0x80000000 | 14,
    0x80000000 | 16,

       0        // eod
};

void OrgBluezManagerInterface::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        OrgBluezManagerInterface *_t = static_cast<OrgBluezManagerInterface *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->AdapterAdded((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1]))); break;
        case 1: _t->AdapterRemoved((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1]))); break;
        case 2: _t->DefaultAdapterChanged((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1]))); break;
        case 3: _t->PropertyChanged((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusVariant(*)>(_a[2]))); break;
        case 4: { QDBusPendingReply<QDBusObjectPath> _r = _t->DefaultAdapter();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<QDBusObjectPath>*>(_a[0]) = std::move(_r); }  break;
        case 5: { QDBusPendingReply<QDBusObjectPath> _r = _t->FindAdapter((*reinterpret_cast< const QString(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<QDBusObjectPath>*>(_a[0]) = std::move(_r); }  break;
        case 6: { QDBusPendingReply<QVariantMap> _r = _t->GetProperties();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<QVariantMap>*>(_a[0]) = std::move(_r); }  break;
        case 7: { QDBusPendingReply<QList<QDBusObjectPath> > _r = _t->ListAdapters();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<QList<QDBusObjectPath> >*>(_a[0]) = std::move(_r); }  break;
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
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusVariant >(); break;
            }
            break;
        }
    } else if (_c == QMetaObject::IndexOfMethod) {
        int *result = reinterpret_cast<int *>(_a[0]);
        {
            using _t = void (OrgBluezManagerInterface::*)(const QDBusObjectPath & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezManagerInterface::AdapterAdded)) {
                *result = 0;
                return;
            }
        }
        {
            using _t = void (OrgBluezManagerInterface::*)(const QDBusObjectPath & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezManagerInterface::AdapterRemoved)) {
                *result = 1;
                return;
            }
        }
        {
            using _t = void (OrgBluezManagerInterface::*)(const QDBusObjectPath & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezManagerInterface::DefaultAdapterChanged)) {
                *result = 2;
                return;
            }
        }
        {
            using _t = void (OrgBluezManagerInterface::*)(const QString & , const QDBusVariant & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezManagerInterface::PropertyChanged)) {
                *result = 3;
                return;
            }
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject OrgBluezManagerInterface::staticMetaObject = {
    { &QDBusAbstractInterface::staticMetaObject, qt_meta_stringdata_OrgBluezManagerInterface.data,
      qt_meta_data_OrgBluezManagerInterface,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *OrgBluezManagerInterface::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *OrgBluezManagerInterface::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_OrgBluezManagerInterface.stringdata0))
        return static_cast<void*>(this);
    return QDBusAbstractInterface::qt_metacast(_clname);
}

int OrgBluezManagerInterface::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QDBusAbstractInterface::qt_metacall(_c, _id, _a);
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

// SIGNAL 0
void OrgBluezManagerInterface::AdapterAdded(const QDBusObjectPath & _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}

// SIGNAL 1
void OrgBluezManagerInterface::AdapterRemoved(const QDBusObjectPath & _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 1, _a);
}

// SIGNAL 2
void OrgBluezManagerInterface::DefaultAdapterChanged(const QDBusObjectPath & _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 2, _a);
}

// SIGNAL 3
void OrgBluezManagerInterface::PropertyChanged(const QString & _t1, const QDBusVariant & _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 3, _a);
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
