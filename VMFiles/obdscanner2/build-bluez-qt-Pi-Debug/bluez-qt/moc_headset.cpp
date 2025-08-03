/****************************************************************************
** Meta object code from reading C++ file 'headset.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.11.4)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../libbluez-qt/bluez-qt/headset.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'headset.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.11.4. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_OrgBluezHeadsetInterface_t {
    QByteArrayData data[32];
    char stringdata0[442];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_OrgBluezHeadsetInterface_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_OrgBluezHeadsetInterface_t qt_meta_stringdata_OrgBluezHeadsetInterface = {
    {
QT_MOC_LITERAL(0, 0, 24), // "OrgBluezHeadsetInterface"
QT_MOC_LITERAL(1, 25, 15), // "AnswerRequested"
QT_MOC_LITERAL(2, 41, 0), // ""
QT_MOC_LITERAL(3, 42, 14), // "CallTerminated"
QT_MOC_LITERAL(4, 57, 9), // "Connected"
QT_MOC_LITERAL(5, 67, 12), // "Disconnected"
QT_MOC_LITERAL(6, 80, 21), // "MicrophoneGainChanged"
QT_MOC_LITERAL(7, 102, 3), // "in0"
QT_MOC_LITERAL(8, 106, 7), // "Playing"
QT_MOC_LITERAL(9, 114, 15), // "PropertyChanged"
QT_MOC_LITERAL(10, 130, 12), // "QDBusVariant"
QT_MOC_LITERAL(11, 143, 3), // "in1"
QT_MOC_LITERAL(12, 147, 18), // "SpeakerGainChanged"
QT_MOC_LITERAL(13, 166, 7), // "Stopped"
QT_MOC_LITERAL(14, 174, 10), // "CancelCall"
QT_MOC_LITERAL(15, 185, 19), // "QDBusPendingReply<>"
QT_MOC_LITERAL(16, 205, 7), // "Connect"
QT_MOC_LITERAL(17, 213, 10), // "Disconnect"
QT_MOC_LITERAL(18, 224, 17), // "GetMicrophoneGain"
QT_MOC_LITERAL(19, 242, 25), // "QDBusPendingReply<ushort>"
QT_MOC_LITERAL(20, 268, 13), // "GetProperties"
QT_MOC_LITERAL(21, 282, 30), // "QDBusPendingReply<QVariantMap>"
QT_MOC_LITERAL(22, 313, 14), // "GetSpeakerGain"
QT_MOC_LITERAL(23, 328, 12), // "IndicateCall"
QT_MOC_LITERAL(24, 341, 11), // "IsConnected"
QT_MOC_LITERAL(25, 353, 23), // "QDBusPendingReply<bool>"
QT_MOC_LITERAL(26, 377, 9), // "IsPlaying"
QT_MOC_LITERAL(27, 387, 4), // "Play"
QT_MOC_LITERAL(28, 392, 17), // "SetMicrophoneGain"
QT_MOC_LITERAL(29, 410, 11), // "SetProperty"
QT_MOC_LITERAL(30, 422, 14), // "SetSpeakerGain"
QT_MOC_LITERAL(31, 437, 4) // "Stop"

    },
    "OrgBluezHeadsetInterface\0AnswerRequested\0"
    "\0CallTerminated\0Connected\0Disconnected\0"
    "MicrophoneGainChanged\0in0\0Playing\0"
    "PropertyChanged\0QDBusVariant\0in1\0"
    "SpeakerGainChanged\0Stopped\0CancelCall\0"
    "QDBusPendingReply<>\0Connect\0Disconnect\0"
    "GetMicrophoneGain\0QDBusPendingReply<ushort>\0"
    "GetProperties\0QDBusPendingReply<QVariantMap>\0"
    "GetSpeakerGain\0IndicateCall\0IsConnected\0"
    "QDBusPendingReply<bool>\0IsPlaying\0"
    "Play\0SetMicrophoneGain\0SetProperty\0"
    "SetSpeakerGain\0Stop"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_OrgBluezHeadsetInterface[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
      23,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       9,       // signalCount

 // signals: name, argc, parameters, tag, flags
       1,    0,  129,    2, 0x06 /* Public */,
       3,    0,  130,    2, 0x06 /* Public */,
       4,    0,  131,    2, 0x06 /* Public */,
       5,    0,  132,    2, 0x06 /* Public */,
       6,    1,  133,    2, 0x06 /* Public */,
       8,    0,  136,    2, 0x06 /* Public */,
       9,    2,  137,    2, 0x06 /* Public */,
      12,    1,  142,    2, 0x06 /* Public */,
      13,    0,  145,    2, 0x06 /* Public */,

 // slots: name, argc, parameters, tag, flags
      14,    0,  146,    2, 0x0a /* Public */,
      16,    0,  147,    2, 0x0a /* Public */,
      17,    0,  148,    2, 0x0a /* Public */,
      18,    0,  149,    2, 0x0a /* Public */,
      20,    0,  150,    2, 0x0a /* Public */,
      22,    0,  151,    2, 0x0a /* Public */,
      23,    0,  152,    2, 0x0a /* Public */,
      24,    0,  153,    2, 0x0a /* Public */,
      26,    0,  154,    2, 0x0a /* Public */,
      27,    0,  155,    2, 0x0a /* Public */,
      28,    1,  156,    2, 0x0a /* Public */,
      29,    2,  159,    2, 0x0a /* Public */,
      30,    1,  164,    2, 0x0a /* Public */,
      31,    0,  167,    2, 0x0a /* Public */,

 // signals: parameters
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void, QMetaType::UShort,    7,
    QMetaType::Void,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 10,    7,   11,
    QMetaType::Void, QMetaType::UShort,    7,
    QMetaType::Void,

 // slots: parameters
    0x80000000 | 15,
    0x80000000 | 15,
    0x80000000 | 15,
    0x80000000 | 19,
    0x80000000 | 21,
    0x80000000 | 19,
    0x80000000 | 15,
    0x80000000 | 25,
    0x80000000 | 25,
    0x80000000 | 15,
    0x80000000 | 15, QMetaType::UShort,    7,
    0x80000000 | 15, QMetaType::QString, 0x80000000 | 10,    7,   11,
    0x80000000 | 15, QMetaType::UShort,    7,
    0x80000000 | 15,

       0        // eod
};

void OrgBluezHeadsetInterface::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        OrgBluezHeadsetInterface *_t = static_cast<OrgBluezHeadsetInterface *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->AnswerRequested(); break;
        case 1: _t->CallTerminated(); break;
        case 2: _t->Connected(); break;
        case 3: _t->Disconnected(); break;
        case 4: _t->MicrophoneGainChanged((*reinterpret_cast< ushort(*)>(_a[1]))); break;
        case 5: _t->Playing(); break;
        case 6: _t->PropertyChanged((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusVariant(*)>(_a[2]))); break;
        case 7: _t->SpeakerGainChanged((*reinterpret_cast< ushort(*)>(_a[1]))); break;
        case 8: _t->Stopped(); break;
        case 9: { QDBusPendingReply<> _r = _t->CancelCall();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 10: { QDBusPendingReply<> _r = _t->Connect();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 11: { QDBusPendingReply<> _r = _t->Disconnect();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 12: { QDBusPendingReply<ushort> _r = _t->GetMicrophoneGain();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<ushort>*>(_a[0]) = std::move(_r); }  break;
        case 13: { QDBusPendingReply<QVariantMap> _r = _t->GetProperties();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<QVariantMap>*>(_a[0]) = std::move(_r); }  break;
        case 14: { QDBusPendingReply<ushort> _r = _t->GetSpeakerGain();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<ushort>*>(_a[0]) = std::move(_r); }  break;
        case 15: { QDBusPendingReply<> _r = _t->IndicateCall();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 16: { QDBusPendingReply<bool> _r = _t->IsConnected();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<bool>*>(_a[0]) = std::move(_r); }  break;
        case 17: { QDBusPendingReply<bool> _r = _t->IsPlaying();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<bool>*>(_a[0]) = std::move(_r); }  break;
        case 18: { QDBusPendingReply<> _r = _t->Play();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 19: { QDBusPendingReply<> _r = _t->SetMicrophoneGain((*reinterpret_cast< ushort(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 20: { QDBusPendingReply<> _r = _t->SetProperty((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusVariant(*)>(_a[2])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 21: { QDBusPendingReply<> _r = _t->SetSpeakerGain((*reinterpret_cast< ushort(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        case 22: { QDBusPendingReply<> _r = _t->Stop();
            if (_a[0]) *reinterpret_cast< QDBusPendingReply<>*>(_a[0]) = std::move(_r); }  break;
        default: ;
        }
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        switch (_id) {
        default: *reinterpret_cast<int*>(_a[0]) = -1; break;
        case 6:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusVariant >(); break;
            }
            break;
        case 20:
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
            using _t = void (OrgBluezHeadsetInterface::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezHeadsetInterface::AnswerRequested)) {
                *result = 0;
                return;
            }
        }
        {
            using _t = void (OrgBluezHeadsetInterface::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezHeadsetInterface::CallTerminated)) {
                *result = 1;
                return;
            }
        }
        {
            using _t = void (OrgBluezHeadsetInterface::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezHeadsetInterface::Connected)) {
                *result = 2;
                return;
            }
        }
        {
            using _t = void (OrgBluezHeadsetInterface::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezHeadsetInterface::Disconnected)) {
                *result = 3;
                return;
            }
        }
        {
            using _t = void (OrgBluezHeadsetInterface::*)(ushort );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezHeadsetInterface::MicrophoneGainChanged)) {
                *result = 4;
                return;
            }
        }
        {
            using _t = void (OrgBluezHeadsetInterface::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezHeadsetInterface::Playing)) {
                *result = 5;
                return;
            }
        }
        {
            using _t = void (OrgBluezHeadsetInterface::*)(const QString & , const QDBusVariant & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezHeadsetInterface::PropertyChanged)) {
                *result = 6;
                return;
            }
        }
        {
            using _t = void (OrgBluezHeadsetInterface::*)(ushort );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezHeadsetInterface::SpeakerGainChanged)) {
                *result = 7;
                return;
            }
        }
        {
            using _t = void (OrgBluezHeadsetInterface::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&OrgBluezHeadsetInterface::Stopped)) {
                *result = 8;
                return;
            }
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject OrgBluezHeadsetInterface::staticMetaObject = {
    { &QDBusAbstractInterface::staticMetaObject, qt_meta_stringdata_OrgBluezHeadsetInterface.data,
      qt_meta_data_OrgBluezHeadsetInterface,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *OrgBluezHeadsetInterface::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *OrgBluezHeadsetInterface::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_OrgBluezHeadsetInterface.stringdata0))
        return static_cast<void*>(this);
    return QDBusAbstractInterface::qt_metacast(_clname);
}

int OrgBluezHeadsetInterface::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QDBusAbstractInterface::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 23)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 23;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 23)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 23;
    }
    return _id;
}

// SIGNAL 0
void OrgBluezHeadsetInterface::AnswerRequested()
{
    QMetaObject::activate(this, &staticMetaObject, 0, nullptr);
}

// SIGNAL 1
void OrgBluezHeadsetInterface::CallTerminated()
{
    QMetaObject::activate(this, &staticMetaObject, 1, nullptr);
}

// SIGNAL 2
void OrgBluezHeadsetInterface::Connected()
{
    QMetaObject::activate(this, &staticMetaObject, 2, nullptr);
}

// SIGNAL 3
void OrgBluezHeadsetInterface::Disconnected()
{
    QMetaObject::activate(this, &staticMetaObject, 3, nullptr);
}

// SIGNAL 4
void OrgBluezHeadsetInterface::MicrophoneGainChanged(ushort _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 4, _a);
}

// SIGNAL 5
void OrgBluezHeadsetInterface::Playing()
{
    QMetaObject::activate(this, &staticMetaObject, 5, nullptr);
}

// SIGNAL 6
void OrgBluezHeadsetInterface::PropertyChanged(const QString & _t1, const QDBusVariant & _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 6, _a);
}

// SIGNAL 7
void OrgBluezHeadsetInterface::SpeakerGainChanged(ushort _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 7, _a);
}

// SIGNAL 8
void OrgBluezHeadsetInterface::Stopped()
{
    QMetaObject::activate(this, &staticMetaObject, 8, nullptr);
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
