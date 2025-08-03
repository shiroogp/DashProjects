/****************************************************************************
** Meta object code from reading C++ file 'bluetoothdevice.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.11.4)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../libbluez-qt/bluez-qt/bluetoothdevice.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'bluetoothdevice.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.11.4. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_BluetoothDevice_t {
    QByteArrayData data[63];
    char stringdata0[952];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_BluetoothDevice_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_BluetoothDevice_t qt_meta_stringdata_BluetoothDevice = {
    {
QT_MOC_LITERAL(0, 0, 15), // "BluetoothDevice"
QT_MOC_LITERAL(1, 16, 23), // "devicePropertiesChanged"
QT_MOC_LITERAL(2, 40, 0), // ""
QT_MOC_LITERAL(3, 41, 15), // "propertyChanged"
QT_MOC_LITERAL(4, 57, 4), // "name"
QT_MOC_LITERAL(5, 62, 7), // "variant"
QT_MOC_LITERAL(6, 70, 12), // "readyChanged"
QT_MOC_LITERAL(7, 83, 11), // "pathChanged"
QT_MOC_LITERAL(8, 95, 27), // "audioConnectionStateChanged"
QT_MOC_LITERAL(9, 123, 24), // "audioPlayingStateChanged"
QT_MOC_LITERAL(10, 148, 7), // "playing"
QT_MOC_LITERAL(11, 156, 21), // "inputConnectedChanged"
QT_MOC_LITERAL(12, 178, 14), // "addressChanged"
QT_MOC_LITERAL(13, 193, 11), // "nameChanged"
QT_MOC_LITERAL(14, 205, 11), // "iconChanged"
QT_MOC_LITERAL(15, 217, 20), // "classOfDeviceChanged"
QT_MOC_LITERAL(16, 238, 15), // "profilesChanged"
QT_MOC_LITERAL(17, 254, 13), // "pairedChanged"
QT_MOC_LITERAL(18, 268, 16), // "connectedChanged"
QT_MOC_LITERAL(19, 285, 14), // "trustedChanged"
QT_MOC_LITERAL(20, 300, 12), // "aliasChanged"
QT_MOC_LITERAL(21, 313, 20), // "legacyPairingChanged"
QT_MOC_LITERAL(22, 334, 17), // "connectInputError"
QT_MOC_LITERAL(23, 352, 5), // "error"
QT_MOC_LITERAL(24, 358, 12), // "errorMessage"
QT_MOC_LITERAL(25, 371, 20), // "disconnectInputError"
QT_MOC_LITERAL(26, 392, 12), // "connectAudio"
QT_MOC_LITERAL(27, 405, 15), // "disconnectAudio"
QT_MOC_LITERAL(28, 421, 12), // "connectInput"
QT_MOC_LITERAL(29, 434, 15), // "disconnectInput"
QT_MOC_LITERAL(30, 450, 10), // "disconnect"
QT_MOC_LITERAL(31, 461, 21), // "getPropertiesFinished"
QT_MOC_LITERAL(32, 483, 24), // "QDBusPendingCallWatcher*"
QT_MOC_LITERAL(33, 508, 4), // "call"
QT_MOC_LITERAL(34, 513, 12), // "QDBusVariant"
QT_MOC_LITERAL(35, 526, 5), // "value"
QT_MOC_LITERAL(36, 532, 26), // "getAudioPropertiesFinished"
QT_MOC_LITERAL(37, 559, 20), // "audioPropertyChanged"
QT_MOC_LITERAL(38, 580, 20), // "getIsPlayingFinished"
QT_MOC_LITERAL(39, 601, 22), // "headsetPropertyChanged"
QT_MOC_LITERAL(40, 624, 26), // "getInputPropertiesFinished"
QT_MOC_LITERAL(41, 651, 20), // "inputPropertyChanged"
QT_MOC_LITERAL(42, 672, 20), // "inputConnectFinished"
QT_MOC_LITERAL(43, 693, 23), // "inputDisconnectFinished"
QT_MOC_LITERAL(44, 717, 5), // "ready"
QT_MOC_LITERAL(45, 723, 4), // "path"
QT_MOC_LITERAL(46, 728, 20), // "audioConnectionState"
QT_MOC_LITERAL(47, 749, 20), // "AudioConnectionState"
QT_MOC_LITERAL(48, 770, 14), // "inputConnected"
QT_MOC_LITERAL(49, 785, 7), // "address"
QT_MOC_LITERAL(50, 793, 4), // "icon"
QT_MOC_LITERAL(51, 798, 13), // "classOfDevice"
QT_MOC_LITERAL(52, 812, 8), // "profiles"
QT_MOC_LITERAL(53, 821, 6), // "paired"
QT_MOC_LITERAL(54, 828, 9), // "connected"
QT_MOC_LITERAL(55, 838, 7), // "trusted"
QT_MOC_LITERAL(56, 846, 5), // "alias"
QT_MOC_LITERAL(57, 852, 13), // "legacyPairing"
QT_MOC_LITERAL(58, 866, 17), // "AudioStateUnknown"
QT_MOC_LITERAL(59, 884, 15), // "AudioConnecting"
QT_MOC_LITERAL(60, 900, 14), // "AudioConnected"
QT_MOC_LITERAL(61, 915, 18), // "AudioDisconnecting"
QT_MOC_LITERAL(62, 934, 17) // "AudioDisconnected"

    },
    "BluetoothDevice\0devicePropertiesChanged\0"
    "\0propertyChanged\0name\0variant\0"
    "readyChanged\0pathChanged\0"
    "audioConnectionStateChanged\0"
    "audioPlayingStateChanged\0playing\0"
    "inputConnectedChanged\0addressChanged\0"
    "nameChanged\0iconChanged\0classOfDeviceChanged\0"
    "profilesChanged\0pairedChanged\0"
    "connectedChanged\0trustedChanged\0"
    "aliasChanged\0legacyPairingChanged\0"
    "connectInputError\0error\0errorMessage\0"
    "disconnectInputError\0connectAudio\0"
    "disconnectAudio\0connectInput\0"
    "disconnectInput\0disconnect\0"
    "getPropertiesFinished\0QDBusPendingCallWatcher*\0"
    "call\0QDBusVariant\0value\0"
    "getAudioPropertiesFinished\0"
    "audioPropertyChanged\0getIsPlayingFinished\0"
    "headsetPropertyChanged\0"
    "getInputPropertiesFinished\0"
    "inputPropertyChanged\0inputConnectFinished\0"
    "inputDisconnectFinished\0ready\0path\0"
    "audioConnectionState\0AudioConnectionState\0"
    "inputConnected\0address\0icon\0classOfDevice\0"
    "profiles\0paired\0connected\0trusted\0"
    "alias\0legacyPairing\0AudioStateUnknown\0"
    "AudioConnecting\0AudioConnected\0"
    "AudioDisconnecting\0AudioDisconnected"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_BluetoothDevice[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
      34,   14, // methods
      14,  260, // properties
       1,  316, // enums/sets
       0,    0, // constructors
       0,       // flags
      19,       // signalCount

 // signals: name, argc, parameters, tag, flags
       1,    0,  184,    2, 0x06 /* Public */,
       3,    2,  185,    2, 0x06 /* Public */,
       6,    0,  190,    2, 0x06 /* Public */,
       7,    0,  191,    2, 0x06 /* Public */,
       8,    0,  192,    2, 0x06 /* Public */,
       9,    1,  193,    2, 0x06 /* Public */,
      11,    0,  196,    2, 0x06 /* Public */,
      12,    0,  197,    2, 0x06 /* Public */,
      13,    0,  198,    2, 0x06 /* Public */,
      14,    0,  199,    2, 0x06 /* Public */,
      15,    0,  200,    2, 0x06 /* Public */,
      16,    0,  201,    2, 0x06 /* Public */,
      17,    0,  202,    2, 0x06 /* Public */,
      18,    0,  203,    2, 0x06 /* Public */,
      19,    0,  204,    2, 0x06 /* Public */,
      20,    0,  205,    2, 0x06 /* Public */,
      21,    0,  206,    2, 0x06 /* Public */,
      22,    2,  207,    2, 0x06 /* Public */,
      25,    2,  212,    2, 0x06 /* Public */,

 // slots: name, argc, parameters, tag, flags
      26,    0,  217,    2, 0x0a /* Public */,
      27,    0,  218,    2, 0x0a /* Public */,
      28,    0,  219,    2, 0x0a /* Public */,
      29,    0,  220,    2, 0x0a /* Public */,
      30,    0,  221,    2, 0x0a /* Public */,
      31,    1,  222,    2, 0x08 /* Private */,
       3,    2,  225,    2, 0x08 /* Private */,
      36,    1,  230,    2, 0x08 /* Private */,
      37,    2,  233,    2, 0x08 /* Private */,
      38,    1,  238,    2, 0x08 /* Private */,
      39,    2,  241,    2, 0x08 /* Private */,
      40,    1,  246,    2, 0x08 /* Private */,
      41,    2,  249,    2, 0x08 /* Private */,
      42,    1,  254,    2, 0x08 /* Private */,
      43,    1,  257,    2, 0x08 /* Private */,

 // signals: parameters
    QMetaType::Void,
    QMetaType::Void, QMetaType::QString, QMetaType::QVariant,    4,    5,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void, QMetaType::Bool,   10,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void, QMetaType::QString, QMetaType::QString,   23,   24,
    QMetaType::Void, QMetaType::QString, QMetaType::QString,   23,   24,

 // slots: parameters
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void, 0x80000000 | 32,   33,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 34,    4,   35,
    QMetaType::Void, 0x80000000 | 32,   33,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 34,    4,   35,
    QMetaType::Void, 0x80000000 | 32,   33,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 34,    4,   35,
    QMetaType::Void, 0x80000000 | 32,   33,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 34,    4,   35,
    QMetaType::Void, 0x80000000 | 32,   33,
    QMetaType::Void, 0x80000000 | 32,   33,

 // properties: name, type, flags
      44, QMetaType::Bool, 0x00495001,
      45, QMetaType::QString, 0x00495103,
      46, 0x80000000 | 47, 0x00495009,
      48, QMetaType::Bool, 0x00495001,
      49, QMetaType::QString, 0x00495001,
       4, QMetaType::QString, 0x00495001,
      50, QMetaType::QString, 0x00495001,
      51, QMetaType::UInt, 0x00495001,
      52, QMetaType::QStringList, 0x00495001,
      53, QMetaType::Bool, 0x00495001,
      54, QMetaType::Bool, 0x00495001,
      55, QMetaType::Bool, 0x00495103,
      56, QMetaType::QString, 0x00495103,
      57, QMetaType::Bool, 0x00495001,

 // properties: notify_signal_id
       2,
       3,
       4,
       6,
       7,
       8,
       8,
      10,
      11,
      12,
      13,
      14,
      15,
      16,

 // enums: name, flags, count, data
      47, 0x0,    5,  320,

 // enum data: key, value
      58, uint(BluetoothDevice::AudioStateUnknown),
      59, uint(BluetoothDevice::AudioConnecting),
      60, uint(BluetoothDevice::AudioConnected),
      61, uint(BluetoothDevice::AudioDisconnecting),
      62, uint(BluetoothDevice::AudioDisconnected),

       0        // eod
};

void BluetoothDevice::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        BluetoothDevice *_t = static_cast<BluetoothDevice *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->devicePropertiesChanged(); break;
        case 1: _t->propertyChanged((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QVariant(*)>(_a[2]))); break;
        case 2: _t->readyChanged(); break;
        case 3: _t->pathChanged(); break;
        case 4: _t->audioConnectionStateChanged(); break;
        case 5: _t->audioPlayingStateChanged((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 6: _t->inputConnectedChanged(); break;
        case 7: _t->addressChanged(); break;
        case 8: _t->nameChanged(); break;
        case 9: _t->iconChanged(); break;
        case 10: _t->classOfDeviceChanged(); break;
        case 11: _t->profilesChanged(); break;
        case 12: _t->pairedChanged(); break;
        case 13: _t->connectedChanged(); break;
        case 14: _t->trustedChanged(); break;
        case 15: _t->aliasChanged(); break;
        case 16: _t->legacyPairingChanged(); break;
        case 17: _t->connectInputError((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QString(*)>(_a[2]))); break;
        case 18: _t->disconnectInputError((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QString(*)>(_a[2]))); break;
        case 19: _t->connectAudio(); break;
        case 20: _t->disconnectAudio(); break;
        case 21: _t->connectInput(); break;
        case 22: _t->disconnectInput(); break;
        case 23: _t->disconnect(); break;
        case 24: _t->getPropertiesFinished((*reinterpret_cast< QDBusPendingCallWatcher*(*)>(_a[1]))); break;
        case 25: _t->propertyChanged((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< QDBusVariant(*)>(_a[2]))); break;
        case 26: _t->getAudioPropertiesFinished((*reinterpret_cast< QDBusPendingCallWatcher*(*)>(_a[1]))); break;
        case 27: _t->audioPropertyChanged((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< QDBusVariant(*)>(_a[2]))); break;
        case 28: _t->getIsPlayingFinished((*reinterpret_cast< QDBusPendingCallWatcher*(*)>(_a[1]))); break;
        case 29: _t->headsetPropertyChanged((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< QDBusVariant(*)>(_a[2]))); break;
        case 30: _t->getInputPropertiesFinished((*reinterpret_cast< QDBusPendingCallWatcher*(*)>(_a[1]))); break;
        case 31: _t->inputPropertyChanged((*reinterpret_cast< const QString(*)>(_a[1])),(*reinterpret_cast< const QDBusVariant(*)>(_a[2]))); break;
        case 32: _t->inputConnectFinished((*reinterpret_cast< QDBusPendingCallWatcher*(*)>(_a[1]))); break;
        case 33: _t->inputDisconnectFinished((*reinterpret_cast< QDBusPendingCallWatcher*(*)>(_a[1]))); break;
        default: ;
        }
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        switch (_id) {
        default: *reinterpret_cast<int*>(_a[0]) = -1; break;
        case 25:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusVariant >(); break;
            }
            break;
        case 27:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusVariant >(); break;
            }
            break;
        case 29:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QDBusVariant >(); break;
            }
            break;
        case 31:
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
            using _t = void (BluetoothDevice::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::devicePropertiesChanged)) {
                *result = 0;
                return;
            }
        }
        {
            using _t = void (BluetoothDevice::*)(const QString & , const QVariant & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::propertyChanged)) {
                *result = 1;
                return;
            }
        }
        {
            using _t = void (BluetoothDevice::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::readyChanged)) {
                *result = 2;
                return;
            }
        }
        {
            using _t = void (BluetoothDevice::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::pathChanged)) {
                *result = 3;
                return;
            }
        }
        {
            using _t = void (BluetoothDevice::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::audioConnectionStateChanged)) {
                *result = 4;
                return;
            }
        }
        {
            using _t = void (BluetoothDevice::*)(bool );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::audioPlayingStateChanged)) {
                *result = 5;
                return;
            }
        }
        {
            using _t = void (BluetoothDevice::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::inputConnectedChanged)) {
                *result = 6;
                return;
            }
        }
        {
            using _t = void (BluetoothDevice::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::addressChanged)) {
                *result = 7;
                return;
            }
        }
        {
            using _t = void (BluetoothDevice::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::nameChanged)) {
                *result = 8;
                return;
            }
        }
        {
            using _t = void (BluetoothDevice::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::iconChanged)) {
                *result = 9;
                return;
            }
        }
        {
            using _t = void (BluetoothDevice::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::classOfDeviceChanged)) {
                *result = 10;
                return;
            }
        }
        {
            using _t = void (BluetoothDevice::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::profilesChanged)) {
                *result = 11;
                return;
            }
        }
        {
            using _t = void (BluetoothDevice::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::pairedChanged)) {
                *result = 12;
                return;
            }
        }
        {
            using _t = void (BluetoothDevice::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::connectedChanged)) {
                *result = 13;
                return;
            }
        }
        {
            using _t = void (BluetoothDevice::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::trustedChanged)) {
                *result = 14;
                return;
            }
        }
        {
            using _t = void (BluetoothDevice::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::aliasChanged)) {
                *result = 15;
                return;
            }
        }
        {
            using _t = void (BluetoothDevice::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::legacyPairingChanged)) {
                *result = 16;
                return;
            }
        }
        {
            using _t = void (BluetoothDevice::*)(const QString & , const QString & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::connectInputError)) {
                *result = 17;
                return;
            }
        }
        {
            using _t = void (BluetoothDevice::*)(const QString & , const QString & );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&BluetoothDevice::disconnectInputError)) {
                *result = 18;
                return;
            }
        }
    }
#ifndef QT_NO_PROPERTIES
    else if (_c == QMetaObject::ReadProperty) {
        BluetoothDevice *_t = static_cast<BluetoothDevice *>(_o);
        Q_UNUSED(_t)
        void *_v = _a[0];
        switch (_id) {
        case 0: *reinterpret_cast< bool*>(_v) = _t->ready(); break;
        case 1: *reinterpret_cast< QString*>(_v) = _t->path(); break;
        case 2: *reinterpret_cast< AudioConnectionState*>(_v) = _t->audioConnectionState(); break;
        case 3: *reinterpret_cast< bool*>(_v) = _t->inputConnected(); break;
        case 4: *reinterpret_cast< QString*>(_v) = _t->address(); break;
        case 5: *reinterpret_cast< QString*>(_v) = _t->name(); break;
        case 6: *reinterpret_cast< QString*>(_v) = _t->icon(); break;
        case 7: *reinterpret_cast< quint32*>(_v) = _t->classOfDevice(); break;
        case 8: *reinterpret_cast< QStringList*>(_v) = _t->profiles(); break;
        case 9: *reinterpret_cast< bool*>(_v) = _t->paired(); break;
        case 10: *reinterpret_cast< bool*>(_v) = _t->connected(); break;
        case 11: *reinterpret_cast< bool*>(_v) = _t->trusted(); break;
        case 12: *reinterpret_cast< QString*>(_v) = _t->alias(); break;
        case 13: *reinterpret_cast< bool*>(_v) = _t->legacyPairing(); break;
        default: break;
        }
    } else if (_c == QMetaObject::WriteProperty) {
        BluetoothDevice *_t = static_cast<BluetoothDevice *>(_o);
        Q_UNUSED(_t)
        void *_v = _a[0];
        switch (_id) {
        case 1: _t->setPath(*reinterpret_cast< QString*>(_v)); break;
        case 11: _t->setTrusted(*reinterpret_cast< bool*>(_v)); break;
        case 12: _t->setAlias(*reinterpret_cast< QString*>(_v)); break;
        default: break;
        }
    } else if (_c == QMetaObject::ResetProperty) {
    }
#endif // QT_NO_PROPERTIES
}

QT_INIT_METAOBJECT const QMetaObject BluetoothDevice::staticMetaObject = {
    { &QObject::staticMetaObject, qt_meta_stringdata_BluetoothDevice.data,
      qt_meta_data_BluetoothDevice,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *BluetoothDevice::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *BluetoothDevice::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_BluetoothDevice.stringdata0))
        return static_cast<void*>(this);
    return QObject::qt_metacast(_clname);
}

int BluetoothDevice::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QObject::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 34)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 34;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 34)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 34;
    }
#ifndef QT_NO_PROPERTIES
   else if (_c == QMetaObject::ReadProperty || _c == QMetaObject::WriteProperty
            || _c == QMetaObject::ResetProperty || _c == QMetaObject::RegisterPropertyMetaType) {
        qt_static_metacall(this, _c, _id, _a);
        _id -= 14;
    } else if (_c == QMetaObject::QueryPropertyDesignable) {
        _id -= 14;
    } else if (_c == QMetaObject::QueryPropertyScriptable) {
        _id -= 14;
    } else if (_c == QMetaObject::QueryPropertyStored) {
        _id -= 14;
    } else if (_c == QMetaObject::QueryPropertyEditable) {
        _id -= 14;
    } else if (_c == QMetaObject::QueryPropertyUser) {
        _id -= 14;
    }
#endif // QT_NO_PROPERTIES
    return _id;
}

// SIGNAL 0
void BluetoothDevice::devicePropertiesChanged()
{
    QMetaObject::activate(this, &staticMetaObject, 0, nullptr);
}

// SIGNAL 1
void BluetoothDevice::propertyChanged(const QString & _t1, const QVariant & _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 1, _a);
}

// SIGNAL 2
void BluetoothDevice::readyChanged()
{
    QMetaObject::activate(this, &staticMetaObject, 2, nullptr);
}

// SIGNAL 3
void BluetoothDevice::pathChanged()
{
    QMetaObject::activate(this, &staticMetaObject, 3, nullptr);
}

// SIGNAL 4
void BluetoothDevice::audioConnectionStateChanged()
{
    QMetaObject::activate(this, &staticMetaObject, 4, nullptr);
}

// SIGNAL 5
void BluetoothDevice::audioPlayingStateChanged(bool _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 5, _a);
}

// SIGNAL 6
void BluetoothDevice::inputConnectedChanged()
{
    QMetaObject::activate(this, &staticMetaObject, 6, nullptr);
}

// SIGNAL 7
void BluetoothDevice::addressChanged()
{
    QMetaObject::activate(this, &staticMetaObject, 7, nullptr);
}

// SIGNAL 8
void BluetoothDevice::nameChanged()
{
    QMetaObject::activate(this, &staticMetaObject, 8, nullptr);
}

// SIGNAL 9
void BluetoothDevice::iconChanged()
{
    QMetaObject::activate(this, &staticMetaObject, 9, nullptr);
}

// SIGNAL 10
void BluetoothDevice::classOfDeviceChanged()
{
    QMetaObject::activate(this, &staticMetaObject, 10, nullptr);
}

// SIGNAL 11
void BluetoothDevice::profilesChanged()
{
    QMetaObject::activate(this, &staticMetaObject, 11, nullptr);
}

// SIGNAL 12
void BluetoothDevice::pairedChanged()
{
    QMetaObject::activate(this, &staticMetaObject, 12, nullptr);
}

// SIGNAL 13
void BluetoothDevice::connectedChanged()
{
    QMetaObject::activate(this, &staticMetaObject, 13, nullptr);
}

// SIGNAL 14
void BluetoothDevice::trustedChanged()
{
    QMetaObject::activate(this, &staticMetaObject, 14, nullptr);
}

// SIGNAL 15
void BluetoothDevice::aliasChanged()
{
    QMetaObject::activate(this, &staticMetaObject, 15, nullptr);
}

// SIGNAL 16
void BluetoothDevice::legacyPairingChanged()
{
    QMetaObject::activate(this, &staticMetaObject, 16, nullptr);
}

// SIGNAL 17
void BluetoothDevice::connectInputError(const QString & _t1, const QString & _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 17, _a);
}

// SIGNAL 18
void BluetoothDevice::disconnectInputError(const QString & _t1, const QString & _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 18, _a);
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
