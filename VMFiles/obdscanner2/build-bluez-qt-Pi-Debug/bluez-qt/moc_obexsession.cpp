/****************************************************************************
** Meta object code from reading C++ file 'obexsession.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.11.4)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../libbluez-qt/bluez-qt/obex/obexsession.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'obexsession.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.11.4. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_ObexSessionInterface_t {
    QByteArrayData data[6];
    char stringdata0[110];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_ObexSessionInterface_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_ObexSessionInterface_t qt_meta_stringdata_ObexSessionInterface = {
    {
QT_MOC_LITERAL(0, 0, 20), // "ObexSessionInterface"
QT_MOC_LITERAL(1, 21, 15), // "GetCapabilities"
QT_MOC_LITERAL(2, 37, 26), // "QDBusPendingReply<QString>"
QT_MOC_LITERAL(3, 64, 0), // ""
QT_MOC_LITERAL(4, 65, 13), // "GetProperties"
QT_MOC_LITERAL(5, 79, 30) // "QDBusPendingReply<QVariantMap>"

    },
    "ObexSessionInterface\0GetCapabilities\0"
    "QDBusPendingReply<QString>\0\0GetProperties\0"
    "QDBusPendingReply<QVariantMap>"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_ObexSessionInterface[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
       2,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       0,       // signalCount

 // slots: name, argc, parameters, tag, flags
       1,    0,   24,    3, 0x0a /* Public */,
       4,    0,   25,    3, 0x0a /* Public */,

 // slots: parameters
    0x80000000 | 2,
    0x80000000 | 5,

       0        // eod
};

void ObexSessionInterface::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        ObexSessionInterface *_t = static_cast<ObexSessionInterface *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: { QDBusPendingReply<QString> _r = _t->GetCapabilities();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<QString>*>(_a[0]) = std::move(_r); }  break;
        case 1: { QDBusPendingReply<QVariantMap> _r = _t->GetProperties();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<QVariantMap>*>(_a[0]) = std::move(_r); }  break;
        default: ;
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject ObexSessionInterface::staticMetaObject = {
    { &QDBusAbstractInterface::staticMetaObject, qt_meta_stringdata_ObexSessionInterface.data,
      qt_meta_data_ObexSessionInterface,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *ObexSessionInterface::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *ObexSessionInterface::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_ObexSessionInterface.stringdata0))
        return static_cast<void*>(this);
    return QDBusAbstractInterface::qt_metacast(_clname);
}

int ObexSessionInterface::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QDBusAbstractInterface::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 2)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 2;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 2)
            *reinterpret_cast<int*>(_a[0]) = -1;
        _id -= 2;
    }
    return _id;
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
