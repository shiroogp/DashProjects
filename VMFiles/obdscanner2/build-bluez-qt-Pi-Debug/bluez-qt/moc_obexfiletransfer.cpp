/****************************************************************************
** Meta object code from reading C++ file 'obexfiletransfer.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.11.4)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../libbluez-qt/bluez-qt/obex/obexfiletransfer.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'obexfiletransfer.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.11.4. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_ObexFileTransferInterface_t {
    QByteArrayData data[15];
    char stringdata0[203];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_ObexFileTransferInterface_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_ObexFileTransferInterface_t qt_meta_stringdata_ObexFileTransferInterface = {
    {
QT_MOC_LITERAL(0, 0, 25), // "ObexFileTransferInterface"
QT_MOC_LITERAL(1, 26, 12), // "ChangeFolder"
QT_MOC_LITERAL(2, 39, 19), // "QDBusPendingReply<>"
QT_MOC_LITERAL(3, 59, 0), // ""
QT_MOC_LITERAL(4, 60, 3), // "in0"
QT_MOC_LITERAL(5, 64, 8), // "CopyFile"
QT_MOC_LITERAL(6, 73, 3), // "in1"
QT_MOC_LITERAL(7, 77, 12), // "CreateFolder"
QT_MOC_LITERAL(8, 90, 6), // "Delete"
QT_MOC_LITERAL(9, 97, 7), // "GetFile"
QT_MOC_LITERAL(10, 105, 34), // "QDBusPendingReply<QObexObject..."
QT_MOC_LITERAL(11, 140, 10), // "ListFolder"
QT_MOC_LITERAL(12, 151, 34), // "QDBusPendingReply<QVariantMap..."
QT_MOC_LITERAL(13, 186, 8), // "MoveFile"
QT_MOC_LITERAL(14, 195, 7) // "PutFile"

    },
    "ObexFileTransferInterface\0ChangeFolder\0"
    "QDBusPendingReply<>\0\0in0\0CopyFile\0in1\0"
    "CreateFolder\0Delete\0GetFile\0"
    "QDBusPendingReply<QObexObjectData>\0"
    "ListFolder\0QDBusPendingReply<QVariantMapList>\0"
    "MoveFile\0PutFile"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_ObexFileTransferInterface[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
       8,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       0,       // signalCount

 // slots: name, argc, parameters, tag, flags
       1,    1,   54,    3, 0x0a /* Public */,
       5,    2,   57,    3, 0x0a /* Public */,
       7,    1,   62,    3, 0x0a /* Public */,
       8,    1,   65,    3, 0x0a /* Public */,
       9,    2,   68,    3, 0x0a /* Public */,
      11,    0,   73,    3, 0x0a /* Public */,
      13,    2,   74,    3, 0x0a /* Public */,
      14,    2,   79,    3, 0x0a /* Public */,

 // slots: parameters
    0x80000000 | 2, QMetaType::QString,    4,
    0x80000000 | 2, QMetaType::QString, QMetaType::QString,    4,    6,
    0x80000000 | 2, QMetaType::QString,    4,
    0x80000000 | 2, QMetaType::QString,    4,
    0x80000000 | 10, QMetaType::QString, QMetaType::QString,    4,    6,
    0x80000000 | 12,
    0x80000000 | 2, QMetaType::QString, QMetaType::QString,    4,    6,
    0x80000000 | 10, QMetaType::QString, QMetaType::QString,    4,    6,

       0        // eod
};

void ObexFileTransferInterface::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        ObexFileTransferInterface *_t = static_cast<ObexFileTransferInterface *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: { QDBusPendingReply<> _r = _t->ChangeFolder((*reinterpret_cast< const QString(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 1: { QDBusPendingReply<> _r = _t->CopyFile((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QString(*)>(_a[2])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 2: { QDBusPendingReply<> _r = _t->CreateFolder((*reinterpret_cast< const QString(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 3: { QDBusPendingReply<> _r = _t->Delete((*reinterpret_cast< const QString(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 4: { QDBusPendingReply<QObexObjectData> _r = _t->GetFile((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QString(*)>(_a[2])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<QObexObjectData>*>(_a[0]) = std::move(_r); }  break;
        case 5: { QDBusPendingReply<QVariantMapList> _r = _t->ListFolder();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<QVariantMapList>*>(_a[0]) = std::move(_r); }  break;
        case 6: { QDBusPendingReply<> _r = _t->MoveFile((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QString(*)>(_a[2])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 7: { QDBusPendingReply<QObexObjectData> _r = _t->PutFile((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QString(*)>(_a[2])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<QObexObjectData>*>(_a[0]) = std::move(_r); }  break;
        default: ;
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject ObexFileTransferInterface::staticMetaObject = {
    { &QDBusAbstractInterface::staticMetaObject, qt_meta_stringdata_ObexFileTransferInterface.data,
      qt_meta_data_ObexFileTransferInterface,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *ObexFileTransferInterface::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *ObexFileTransferInterface::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_ObexFileTransferInterface.stringdata0))
        return static_cast<void*>(this);
    return QDBusAbstractInterface::qt_metacast(_clname);
}

int ObexFileTransferInterface::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
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
            *reinterpret_cast<int*>(_a[0]) = -1;
        _id -= 8;
    }
    return _id;
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
