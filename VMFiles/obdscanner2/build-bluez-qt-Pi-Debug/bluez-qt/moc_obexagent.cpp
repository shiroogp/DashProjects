/****************************************************************************
** Meta object code from reading C++ file 'obexagent.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.11.4)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../libbluez-qt/bluez-qt/obex/obexagent.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'obexagent.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.11.4. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_ObexAgentAdaptor_t {
    QByteArrayData data[15];
    char stringdata0[682];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_ObexAgentAdaptor_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_ObexAgentAdaptor_t qt_meta_stringdata_ObexAgentAdaptor = {
    {
QT_MOC_LITERAL(0, 0, 16), // "ObexAgentAdaptor"
QT_MOC_LITERAL(1, 17, 15), // "D-Bus Interface"
QT_MOC_LITERAL(2, 33, 20), // "org.bluez.obex.Agent"
QT_MOC_LITERAL(3, 54, 19), // "D-Bus Introspection"
QT_MOC_LITERAL(4, 74, 531), // "  <interface name=\"org.bluez..."
QT_MOC_LITERAL(5, 548, 9), // "Authorize"
QT_MOC_LITERAL(6, 558, 0), // ""
QT_MOC_LITERAL(7, 559, 15), // "QDBusObjectPath"
QT_MOC_LITERAL(8, 575, 8), // "transfer"
QT_MOC_LITERAL(9, 584, 10), // "bt_address"
QT_MOC_LITERAL(10, 595, 4), // "name"
QT_MOC_LITERAL(11, 600, 4), // "type"
QT_MOC_LITERAL(12, 605, 6), // "length"
QT_MOC_LITERAL(13, 612, 4), // "time"
QT_MOC_LITERAL(14, 617, 6) // "Cancel"

    },
    "ObexAgentAdaptor\0D-Bus Interface\0"
    "org.bluez.obex.Agent\0D-Bus Introspection\0"
    "  <interface name=\"org.bluez.obex.Agent\">\n    <method name=\"Author"
    "ize\">\n      <arg direction=\"in\" type=\"o\" name=\"transfer\"/>\n  "
    "    <arg direction=\"in\" type=\"s\" name=\"bt_address\"/>\n      <arg"
    " direction=\"in\" type=\"s\" name=\"name\"/>\n      <arg direction=\"i"
    "n\" type=\"s\" name=\"type\"/>\n      <arg direction=\"in\" type=\"i\""
    " name=\"length\"/>\n      <arg direction=\"in\" type=\"i\" name=\"time"
    "\"/>\n      <arg direction=\"out\" type=\"s\"/>\n    </method>\n    <m"
    "ethod name=\"Cancel\"/>\n  </interface>\n\0"
    "Authorize\0\0QDBusObjectPath\0transfer\0"
    "bt_address\0name\0type\0length\0time\0"
    "Cancel"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_ObexAgentAdaptor[] = {

 // content:
       7,       // revision
       0,       // classname
       2,   14, // classinfo
       2,   18, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       0,       // signalCount

 // classinfo: key, value
       1,    2,
       3,    4,

 // slots: name, argc, parameters, tag, flags
       5,    6,   28,    6, 0x0a /* Public */,
      14,    0,   41,    6, 0x0a /* Public */,

 // slots: parameters
    QMetaType::QString, 0x80000000 | 7, QMetaType::QString, QMetaType::QString, QMetaType::QString, QMetaType::Int, QMetaType::Int,    8,    9,   10,   11,   12,   13,
    QMetaType::Void,

       0        // eod
};

void ObexAgentAdaptor::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        ObexAgentAdaptor *_t = static_cast<ObexAgentAdaptor *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: { QString _r = _t->Authorize((*reinterpret_cast< const QDBusObjectPath(*)>(_a[1])),(*reinterpret_cast< const QString(*)>(_a[2])),(*reinterpret_cast< const QString(*)>(_a[3])),(*reinterpret_cast< const QString(*)>(_a[4])),(*reinterpret_cast< int(*)>(_a[5])),(*reinterpret_cast< int(*)>(_a[6])));
            if (_a[0]) *reinterpret_cast< QString*>(_a[0]) = std::move(_r); }  break;
        case 1: _t->Cancel(); break;
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
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject ObexAgentAdaptor::staticMetaObject = {
    { &QDBusAbstractAdaptor::staticMetaObject, qt_meta_stringdata_ObexAgentAdaptor.data,
      qt_meta_data_ObexAgentAdaptor,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *ObexAgentAdaptor::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *ObexAgentAdaptor::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_ObexAgentAdaptor.stringdata0))
        return static_cast<void*>(this);
    return QDBusAbstractAdaptor::qt_metacast(_clname);
}

int ObexAgentAdaptor::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QDBusAbstractAdaptor::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 2)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 2;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 2)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 2;
    }
    return _id;
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
