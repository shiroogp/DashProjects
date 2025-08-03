/****************************************************************************
** Meta object code from reading C++ file 'audiosource.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.11.4)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../libbluez-qt/bluez-qt/audiosource.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'audiosource.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.11.4. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_OrgBluezAudioSourceInterface_t {
    QByteArrayData data[11];
    char stringdata0[151];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_OrgBluezAudioSourceInterface_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_OrgBluezAudioSourceInterface_t qt_meta_stringdata_OrgBluezAudioSourceInterface = {
    {
QT_MOC_LITERAL(0, 0, 28), // "OrgBluezAudioSourceInterface"
QT_MOC_LITERAL(1, 29, 15), // "PropertyChanged"
QT_MOC_LITERAL(2, 45, 0), // ""
QT_MOC_LITERAL(3, 46, 3), // "in0"
QT_MOC_LITERAL(4, 50, 12), // "QDBusVariant"
QT_MOC_LITERAL(5, 63, 3), // "in1"
QT_MOC_LITERAL(6, 67, 7), // "Connect"
QT_MOC_LITERAL(7, 75, 19), // "QDBusPendingReply<>"
QT_MOC_LITERAL(8, 95, 10), // "Disconnect"
QT_MOC_LITERAL(9, 106, 13), // "GetProperties"
QT_MOC_LITERAL(10, 120, 30) // "QDBusPendingReply<QVariantMap>"

    },
    "OrgBluezAudioSourceInterface\0"
    "PropertyChanged\0\0in0\0QDBusVariant\0in1\0"
    "Connect\0QDBusPendingReply<>\0Disconnect\0"
    "GetProperties\0QDBusPendingReply<QVariantMap>"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_OrgBluezAudioSourceInterface[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
       4,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       1,       // signalCount

 // signals: name, argc, parameters, tag, flags
       1,    2,   34,    2, 0x06 /* Public */,

 // slots: name, argc, parameters, tag, flags
       6,    0,   39,    2, 0x0a /* Public */,
       8,    0,   40,    2, 0x0a /* Public */,
       9,    0,   41,    2, 0x0a /* Public */,

 // signals: parameters
    QMetaType::Void, QMetaType::QString, 0x80000000 | 4,    3,    5,

 // slots: parameters
    0x80000000 | 7,
    0x80000000 | 7,
    0x80000000 | 10,

       0        // eod
};

void OrgBluezAudioSourceInterface::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        OrgBluezAudioSourceInterface *_t = static_cast<OrgBluezAudioSourceInterface *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->PropertyChanged((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusVariant(*)>(_a[2]))); break;
        case 1: { QDBusPendingReply<> _r = _t->Connect();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 2: { QDBusPendingReply<> _r = _t->Disconnect();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 3: { QDBusPendingReply<QVariantMap> _r = _t->GetProperties();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<QVariantMap>*>(_a[0]) = std::move(_r); }  break;
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
        }
    } else if (_c == QMetaObject::IndexOfMethod) {
        int *result = reinterpret_cast<int *>(_a[0]);
        {
            using _t = void (OrgBluezAudioSourceInterface::*)(const QString & , const QDBusVariant & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezAudioSourceInterface::PropertyChanged)) {
                *result = 0;
                return;
            }
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject OrgBluezAudioSourceInterface::staticMetaObject = {
    { &QDBusAbstractInterface::staticMetaObject, qt_meta_stringdata_OrgBluezAudioSourceInterface.data,
      qt_meta_data_OrgBluezAudioSourceInterface,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *OrgBluezAudioSourceInterface::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *OrgBluezAudioSourceInterface::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_OrgBluezAudioSourceInterface.stringdata0))
        return static_cast<void*>(this);
    return QDBusAbstractInterface::qt_metacast(_clname);
}

int OrgBluezAudioSourceInterface::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QDBusAbstractInterface::qt_metacall(_c, _id, _a);
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
void OrgBluezAudioSourceInterface::PropertyChanged(const QString & _t1, const QDBusVariant & _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
