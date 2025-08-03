/****************************************************************************
** Meta object code from reading C++ file 'ObdThread.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.11.4)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../libobd/ObdThread.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#include <QtCore/QList>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'ObdThread.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.11.4. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_ObdThread_t {
    QByteArrayData data[116];
    char stringdata0[1485];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_ObdThread_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_ObdThread_t qt_meta_stringdata_ObdThread = {
    {
QT_MOC_LITERAL(0, 0, 9), // "ObdThread"
QT_MOC_LITERAL(1, 10, 15), // "monitorModeLine"
QT_MOC_LITERAL(2, 26, 0), // ""
QT_MOC_LITERAL(3, 27, 4), // "line"
QT_MOC_LITERAL(4, 32, 16), // "monitorTestReply"
QT_MOC_LITERAL(5, 49, 70), // "QMap<ObdThread::CONTINUOUS_MO..."
QT_MOC_LITERAL(6, 120, 11), // "monitorlist"
QT_MOC_LITERAL(7, 132, 22), // "onBoardMonitoringReply"
QT_MOC_LITERAL(8, 155, 20), // "QList<unsigned char>"
QT_MOC_LITERAL(9, 176, 7), // "midlist"
QT_MOC_LITERAL(10, 184, 7), // "tidlist"
QT_MOC_LITERAL(11, 192, 14), // "QList<QString>"
QT_MOC_LITERAL(12, 207, 7), // "vallist"
QT_MOC_LITERAL(13, 215, 7), // "minlist"
QT_MOC_LITERAL(14, 223, 7), // "maxlist"
QT_MOC_LITERAL(15, 231, 8), // "passlist"
QT_MOC_LITERAL(16, 240, 14), // "mfgStringReply"
QT_MOC_LITERAL(17, 255, 6), // "string"
QT_MOC_LITERAL(18, 262, 8), // "liberror"
QT_MOC_LITERAL(19, 271, 19), // "ObdThread::ObdError"
QT_MOC_LITERAL(20, 291, 3), // "err"
QT_MOC_LITERAL(21, 295, 12), // "voltageReply"
QT_MOC_LITERAL(22, 308, 5), // "volts"
QT_MOC_LITERAL(23, 314, 19), // "supportedModesReply"
QT_MOC_LITERAL(24, 334, 4), // "list"
QT_MOC_LITERAL(25, 339, 9), // "connected"
QT_MOC_LITERAL(26, 349, 7), // "version"
QT_MOC_LITERAL(27, 357, 12), // "disconnected"
QT_MOC_LITERAL(28, 370, 14), // "reqLoopStarted"
QT_MOC_LITERAL(29, 385, 14), // "reqLoopStopped"
QT_MOC_LITERAL(30, 400, 16), // "elmCommandFailed"
QT_MOC_LITERAL(31, 417, 7), // "command"
QT_MOC_LITERAL(32, 425, 8), // "pidReply"
QT_MOC_LITERAL(33, 434, 3), // "pid"
QT_MOC_LITERAL(34, 438, 3), // "val"
QT_MOC_LITERAL(35, 442, 3), // "set"
QT_MOC_LITERAL(36, 446, 4), // "time"
QT_MOC_LITERAL(37, 451, 15), // "singleShotReply"
QT_MOC_LITERAL(38, 467, 7), // "request"
QT_MOC_LITERAL(39, 475, 18), // "supportedPidsReply"
QT_MOC_LITERAL(40, 494, 17), // "troubleCodesReply"
QT_MOC_LITERAL(41, 512, 3), // "ecu"
QT_MOC_LITERAL(42, 516, 5), // "codes"
QT_MOC_LITERAL(43, 522, 14), // "consoleMessage"
QT_MOC_LITERAL(44, 537, 7), // "message"
QT_MOC_LITERAL(45, 545, 12), // "obdPortFound"
QT_MOC_LITERAL(46, 558, 8), // "portname"
QT_MOC_LITERAL(47, 567, 13), // "protocolReply"
QT_MOC_LITERAL(48, 581, 8), // "protocol"
QT_MOC_LITERAL(49, 590, 15), // "rawCommsMessage"
QT_MOC_LITERAL(50, 606, 3), // "msg"
QT_MOC_LITERAL(51, 610, 12), // "debugMessage"
QT_MOC_LITERAL(52, 623, 18), // "obdLib::DebugLevel"
QT_MOC_LITERAL(53, 642, 3), // "lvl"
QT_MOC_LITERAL(54, 646, 5), // "debug"
QT_MOC_LITERAL(55, 652, 5), // "level"
QT_MOC_LITERAL(56, 658, 10), // "commsDebug"
QT_MOC_LITERAL(57, 669, 13), // "setDebugLevel"
QT_MOC_LITERAL(58, 683, 7), // "setPort"
QT_MOC_LITERAL(59, 691, 4), // "port"
QT_MOC_LITERAL(60, 696, 7), // "setBaud"
QT_MOC_LITERAL(61, 704, 4), // "baud"
QT_MOC_LITERAL(62, 709, 10), // "addRequest"
QT_MOC_LITERAL(63, 720, 4), // "mode"
QT_MOC_LITERAL(64, 725, 8), // "priority"
QT_MOC_LITERAL(65, 734, 4), // "wait"
QT_MOC_LITERAL(66, 739, 13), // "removeRequest"
QT_MOC_LITERAL(67, 753, 12), // "RequestClass"
QT_MOC_LITERAL(68, 766, 3), // "req"
QT_MOC_LITERAL(69, 770, 20), // "sendReqSupportedPids"
QT_MOC_LITERAL(70, 791, 7), // "getInfo"
QT_MOC_LITERAL(71, 799, 8), // "ObdInfo*"
QT_MOC_LITERAL(72, 808, 7), // "connect"
QT_MOC_LITERAL(73, 816, 4), // "init"
QT_MOC_LITERAL(74, 821, 10), // "disconnect"
QT_MOC_LITERAL(75, 832, 12), // "clearReqList"
QT_MOC_LITERAL(76, 845, 21), // "sendClearTroubleCodes"
QT_MOC_LITERAL(77, 867, 22), // "sendReqOnBoardMonitors"
QT_MOC_LITERAL(78, 890, 14), // "sendReqVoltage"
QT_MOC_LITERAL(79, 905, 21), // "sendReqSupportedModes"
QT_MOC_LITERAL(80, 927, 16), // "sendReqMfgString"
QT_MOC_LITERAL(81, 944, 18), // "sendReqFullPidScan"
QT_MOC_LITERAL(82, 963, 10), // "switchBaud"
QT_MOC_LITERAL(83, 974, 16), // "startMonitorMode"
QT_MOC_LITERAL(84, 991, 15), // "stopMonitorMode"
QT_MOC_LITERAL(85, 1007, 14), // "MX_setProtocol"
QT_MOC_LITERAL(86, 1022, 3), // "num"
QT_MOC_LITERAL(87, 1026, 15), // "MX_setSWCanMode"
QT_MOC_LITERAL(88, 1042, 14), // "MX_setBaudRate"
QT_MOC_LITERAL(89, 1057, 16), // "MX_checkBaudRate"
QT_MOC_LITERAL(90, 1074, 16), // "ST_addPassFilter"
QT_MOC_LITERAL(91, 1091, 6), // "filter"
QT_MOC_LITERAL(92, 1098, 17), // "ST_addBlockFilter"
QT_MOC_LITERAL(93, 1116, 23), // "ST_addFlowControlFilter"
QT_MOC_LITERAL(94, 1140, 14), // "sendCanMessage"
QT_MOC_LITERAL(95, 1155, 7), // "is29Bit"
QT_MOC_LITERAL(96, 1163, 19), // "ST_clearPassFilters"
QT_MOC_LITERAL(97, 1183, 20), // "ST_clearBlockFilters"
QT_MOC_LITERAL(98, 1204, 19), // "ST_clearFlowFilters"
QT_MOC_LITERAL(99, 1224, 19), // "ST_startMonitorMode"
QT_MOC_LITERAL(100, 1244, 18), // "ST_stopMonitorMode"
QT_MOC_LITERAL(101, 1263, 25), // "ST_startFilterMonitorMode"
QT_MOC_LITERAL(102, 1289, 24), // "ST_stopFilterMonitorMode"
QT_MOC_LITERAL(103, 1314, 21), // "sendSingleShotRequest"
QT_MOC_LITERAL(104, 1336, 26), // "sendSingleShotBlindRequest"
QT_MOC_LITERAL(105, 1363, 10), // "stopThread"
QT_MOC_LITERAL(106, 1374, 19), // "sendReqTroubleCodes"
QT_MOC_LITERAL(107, 1394, 5), // "start"
QT_MOC_LITERAL(108, 1400, 20), // "sendReqMonitorStatus"
QT_MOC_LITERAL(109, 1421, 11), // "findObdPort"
QT_MOC_LITERAL(110, 1433, 14), // "sendElmCommand"
QT_MOC_LITERAL(111, 1448, 3), // "cmd"
QT_MOC_LITERAL(112, 1452, 9), // "setHeader"
QT_MOC_LITERAL(113, 1462, 2), // "on"
QT_MOC_LITERAL(114, 1465, 7), // "setEcho"
QT_MOC_LITERAL(115, 1473, 11) // "setLineFeed"

    },
    "ObdThread\0monitorModeLine\0\0line\0"
    "monitorTestReply\0"
    "QMap<ObdThread::CONTINUOUS_MONITOR,ObdThread::MONITOR_COMPLETE_STATUS>\0"
    "monitorlist\0onBoardMonitoringReply\0"
    "QList<unsigned char>\0midlist\0tidlist\0"
    "QList<QString>\0vallist\0minlist\0maxlist\0"
    "passlist\0mfgStringReply\0string\0liberror\0"
    "ObdThread::ObdError\0err\0voltageReply\0"
    "volts\0supportedModesReply\0list\0connected\0"
    "version\0disconnected\0reqLoopStarted\0"
    "reqLoopStopped\0elmCommandFailed\0command\0"
    "pidReply\0pid\0val\0set\0time\0singleShotReply\0"
    "request\0supportedPidsReply\0troubleCodesReply\0"
    "ecu\0codes\0consoleMessage\0message\0"
    "obdPortFound\0portname\0protocolReply\0"
    "protocol\0rawCommsMessage\0msg\0debugMessage\0"
    "obdLib::DebugLevel\0lvl\0debug\0level\0"
    "commsDebug\0setDebugLevel\0setPort\0port\0"
    "setBaud\0baud\0addRequest\0mode\0priority\0"
    "wait\0removeRequest\0RequestClass\0req\0"
    "sendReqSupportedPids\0getInfo\0ObdInfo*\0"
    "connect\0init\0disconnect\0clearReqList\0"
    "sendClearTroubleCodes\0sendReqOnBoardMonitors\0"
    "sendReqVoltage\0sendReqSupportedModes\0"
    "sendReqMfgString\0sendReqFullPidScan\0"
    "switchBaud\0startMonitorMode\0stopMonitorMode\0"
    "MX_setProtocol\0num\0MX_setSWCanMode\0"
    "MX_setBaudRate\0MX_checkBaudRate\0"
    "ST_addPassFilter\0filter\0ST_addBlockFilter\0"
    "ST_addFlowControlFilter\0sendCanMessage\0"
    "is29Bit\0ST_clearPassFilters\0"
    "ST_clearBlockFilters\0ST_clearFlowFilters\0"
    "ST_startMonitorMode\0ST_stopMonitorMode\0"
    "ST_startFilterMonitorMode\0"
    "ST_stopFilterMonitorMode\0sendSingleShotRequest\0"
    "sendSingleShotBlindRequest\0stopThread\0"
    "sendReqTroubleCodes\0start\0"
    "sendReqMonitorStatus\0findObdPort\0"
    "sendElmCommand\0cmd\0setHeader\0on\0setEcho\0"
    "setLineFeed"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_ObdThread[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
      73,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
      21,       // signalCount

 // signals: name, argc, parameters, tag, flags
       1,    1,  379,    2, 0x06 /* Public */,
       4,    1,  382,    2, 0x06 /* Public */,
       7,    6,  385,    2, 0x06 /* Public */,
      16,    1,  398,    2, 0x06 /* Public */,
      18,    1,  401,    2, 0x06 /* Public */,
      21,    1,  404,    2, 0x06 /* Public */,
      23,    1,  407,    2, 0x06 /* Public */,
      25,    1,  410,    2, 0x06 /* Public */,
      27,    0,  413,    2, 0x06 /* Public */,
      28,    0,  414,    2, 0x06 /* Public */,
      29,    0,  415,    2, 0x06 /* Public */,
      30,    1,  416,    2, 0x06 /* Public */,
      32,    4,  419,    2, 0x06 /* Public */,
      37,    2,  428,    2, 0x06 /* Public */,
      39,    1,  433,    2, 0x06 /* Public */,
      40,    2,  436,    2, 0x06 /* Public */,
      43,    1,  441,    2, 0x06 /* Public */,
      45,    1,  444,    2, 0x06 /* Public */,
      47,    1,  447,    2, 0x06 /* Public */,
      49,    1,  450,    2, 0x06 /* Public */,
      51,    2,  453,    2, 0x06 /* Public */,

 // slots: name, argc, parameters, tag, flags
      54,    2,  458,    2, 0x0a /* Public */,
      56,    1,  463,    2, 0x0a /* Public */,
      57,    1,  466,    2, 0x0a /* Public */,
      58,    1,  469,    2, 0x0a /* Public */,
      60,    1,  472,    2, 0x0a /* Public */,
      62,    4,  475,    2, 0x0a /* Public */,
      66,    3,  484,    2, 0x0a /* Public */,
      62,    1,  491,    2, 0x0a /* Public */,
      66,    1,  494,    2, 0x0a /* Public */,
      69,    0,  497,    2, 0x0a /* Public */,
      70,    0,  498,    2, 0x0a /* Public */,
      72,    1,  499,    2, 0x0a /* Public */,
      72,    0,  502,    2, 0x2a /* Public | MethodCloned */,
      74,    0,  503,    2, 0x0a /* Public */,
      75,    0,  504,    2, 0x0a /* Public */,
      76,    0,  505,    2, 0x0a /* Public */,
      77,    0,  506,    2, 0x0a /* Public */,
      78,    0,  507,    2, 0x0a /* Public */,
      79,    0,  508,    2, 0x0a /* Public */,
      80,    0,  509,    2, 0x0a /* Public */,
      81,    0,  510,    2, 0x0a /* Public */,
      82,    0,  511,    2, 0x0a /* Public */,
      83,    0,  512,    2, 0x0a /* Public */,
      84,    0,  513,    2, 0x0a /* Public */,
      85,    1,  514,    2, 0x0a /* Public */,
      87,    1,  517,    2, 0x0a /* Public */,
      88,    1,  520,    2, 0x0a /* Public */,
      89,    0,  523,    2, 0x0a /* Public */,
      90,    1,  524,    2, 0x0a /* Public */,
      92,    1,  527,    2, 0x0a /* Public */,
      93,    1,  530,    2, 0x0a /* Public */,
      94,    2,  533,    2, 0x0a /* Public */,
      96,    0,  538,    2, 0x0a /* Public */,
      97,    0,  539,    2, 0x0a /* Public */,
      98,    0,  540,    2, 0x0a /* Public */,
      99,    0,  541,    2, 0x0a /* Public */,
     100,    0,  542,    2, 0x0a /* Public */,
     101,    0,  543,    2, 0x0a /* Public */,
     102,    0,  544,    2, 0x0a /* Public */,
     103,    1,  545,    2, 0x0a /* Public */,
     104,    1,  548,    2, 0x0a /* Public */,
     105,    0,  551,    2, 0x0a /* Public */,
     106,    0,  552,    2, 0x0a /* Public */,
     107,    0,  553,    2, 0x0a /* Public */,
     108,    0,  554,    2, 0x0a /* Public */,
      59,    0,  555,    2, 0x0a /* Public */,
     109,    0,  556,    2, 0x0a /* Public */,
     110,    1,  557,    2, 0x0a /* Public */,
     112,    1,  560,    2, 0x0a /* Public */,
     114,    1,  563,    2, 0x0a /* Public */,
     115,    1,  566,    2, 0x0a /* Public */,
      26,    0,  569,    2, 0x0a /* Public */,

 // signals: parameters
    QMetaType::Void, QMetaType::QByteArray,    3,
    QMetaType::Void, 0x80000000 | 5,    6,
    QMetaType::Void, 0x80000000 | 8, 0x80000000 | 8, 0x80000000 | 11, 0x80000000 | 11, 0x80000000 | 11, 0x80000000 | 11,    9,   10,   12,   13,   14,   15,
    QMetaType::Void, QMetaType::QString,   17,
    QMetaType::Void, 0x80000000 | 19,   20,
    QMetaType::Void, QMetaType::Double,   22,
    QMetaType::Void, 0x80000000 | 11,   24,
    QMetaType::Void, QMetaType::QString,   26,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void, QMetaType::QString,   31,
    QMetaType::Void, QMetaType::QString, QMetaType::QString, QMetaType::Int, QMetaType::Double,   33,   34,   35,   36,
    QMetaType::Void, QMetaType::QByteArray, QMetaType::QByteArray,   38,   24,
    QMetaType::Void, 0x80000000 | 11,   24,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 11,   41,   42,
    QMetaType::Void, QMetaType::QString,   44,
    QMetaType::Void, QMetaType::QString,   46,
    QMetaType::Void, QMetaType::QString,   48,
    QMetaType::Void, QMetaType::QString,   50,
    QMetaType::Void, QMetaType::QString, 0x80000000 | 52,   50,   53,

 // slots: parameters
    QMetaType::Void, QMetaType::QString, 0x80000000 | 52,   50,   55,
    QMetaType::Void, QMetaType::QString,   50,
    QMetaType::Void, 0x80000000 | 52,   55,
    QMetaType::Void, QMetaType::QString,   59,
    QMetaType::Void, QMetaType::Int,   61,
    QMetaType::Void, QMetaType::Int, QMetaType::Int, QMetaType::Int, QMetaType::Int,   63,   33,   64,   65,
    QMetaType::Void, QMetaType::Int, QMetaType::Int, QMetaType::Int,   63,   33,   64,
    QMetaType::Void, 0x80000000 | 67,   68,
    QMetaType::Void, 0x80000000 | 67,   68,
    QMetaType::Void,
    0x80000000 | 71,
    QMetaType::Void, QMetaType::Bool,   73,
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
    QMetaType::Void,
    QMetaType::Void, QMetaType::Int,   86,
    QMetaType::Void, QMetaType::Int,   86,
    QMetaType::Void, QMetaType::Int,   61,
    QMetaType::Void,
    QMetaType::Void, QMetaType::QString,   91,
    QMetaType::Void, QMetaType::QString,   91,
    QMetaType::Void, QMetaType::QString,   91,
    QMetaType::Void, QMetaType::QString, QMetaType::Bool,   50,   95,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void, QMetaType::QByteArray,   38,
    QMetaType::Void, QMetaType::QByteArray,   38,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::QString,
    QMetaType::Void,
    QMetaType::Void, QMetaType::QString,  111,
    QMetaType::Void, QMetaType::Bool,  113,
    QMetaType::Void, QMetaType::Bool,  113,
    QMetaType::Void, QMetaType::Bool,  113,
    QMetaType::QString,

       0        // eod
};

void ObdThread::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        ObdThread *_t = static_cast<ObdThread *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->monitorModeLine((*reinterpret_cast< QByteArray(*)>(_a[1]))); break;
        case 1: _t->monitorTestReply((*reinterpret_cast< QMap<ObdThread::CONTINUOUS_MONITOR,ObdThread::MONITOR_COMPLETE_STATUS>(*)>(_a[1]))); break;
        case 2: _t->onBoardMonitoringReply((*reinterpret_cast< QList<unsigned char>(*)>(_a[1])),(*reinterpret_cast< QList<unsigned char>(*)>(_a[2])),(*reinterpret_cast< QList<QString>(*)>(_a[3])),(*reinterpret_cast< QList<QString>(*)>(_a[4])),(*reinterpret_cast< QList<QString>(*)>(_a[5])),(*reinterpret_cast< QList<QString>(*)>(_a[6]))); break;
        case 3: _t->mfgStringReply((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 4: _t->liberror((*reinterpret_cast< ObdThread::ObdError(*)>(_a[1]))); break;
        case 5: _t->voltageReply((*reinterpret_cast< double(*)>(_a[1]))); break;
        case 6: _t->supportedModesReply((*reinterpret_cast< QList<QString>(*)>(_a[1]))); break;
        case 7: _t->connected((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 8: _t->disconnected(); break;
        case 9: _t->reqLoopStarted(); break;
        case 10: _t->reqLoopStopped(); break;
        case 11: _t->elmCommandFailed((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 12: _t->pidReply((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< QString(*)>(_a[2])),(*reinterpret_cast< int(*)>(_a[3])),(*reinterpret_cast< double(*)>(_a[4]))); break;
        case 13: _t->singleShotReply((*reinterpret_cast< QByteArray(*)>(_a[1])),(*reinterpret_cast< QByteArray(*)>(_a[2]))); break;
        case 14: _t->supportedPidsReply((*reinterpret_cast< QList<QString>(*)>(_a[1]))); break;
        case 15: _t->troubleCodesReply((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< QList<QString>(*)>(_a[2]))); break;
        case 16: _t->consoleMessage((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 17: _t->obdPortFound((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 18: _t->protocolReply((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 19: _t->rawCommsMessage((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 20: _t->debugMessage((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< obdLib::DebugLevel(*)>(_a[2]))); break;
        case 21: _t->debug((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< obdLib::DebugLevel(*)>(_a[2]))); break;
        case 22: _t->commsDebug((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 23: _t->setDebugLevel((*reinterpret_cast< obdLib::DebugLevel(*)>(_a[1]))); break;
        case 24: _t->setPort((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 25: _t->setBaud((*reinterpret_cast< int(*)>(_a[1]))); break;
        case 26: _t->addRequest((*reinterpret_cast< int(*)>(_a[1])),(*reinterpret_cast< int(*)>(_a[2])),(*reinterpret_cast< int(*)>(_a[3])),(*reinterpret_cast< int(*)>(_a[4]))); break;
        case 27: _t->removeRequest((*reinterpret_cast< int(*)>(_a[1])),(*reinterpret_cast< int(*)>(_a[2])),(*reinterpret_cast< int(*)>(_a[3]))); break;
        case 28: _t->addRequest((*reinterpret_cast< RequestClass(*)>(_a[1]))); break;
        case 29: _t->removeRequest((*reinterpret_cast< RequestClass(*)>(_a[1]))); break;
        case 30: _t->sendReqSupportedPids(); break;
        case 31: { ObdInfo* _r = _t->getInfo();
            if (_a[0]) *reinterpret_cast< ObdInfo**>(_a[0]) = std::move(_r); }  break;
        case 32: _t->connect((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 33: _t->connect(); break;
        case 34: _t->disconnect(); break;
        case 35: _t->clearReqList(); break;
        case 36: _t->sendClearTroubleCodes(); break;
        case 37: _t->sendReqOnBoardMonitors(); break;
        case 38: _t->sendReqVoltage(); break;
        case 39: _t->sendReqSupportedModes(); break;
        case 40: _t->sendReqMfgString(); break;
        case 41: _t->sendReqFullPidScan(); break;
        case 42: _t->switchBaud(); break;
        case 43: _t->startMonitorMode(); break;
        case 44: _t->stopMonitorMode(); break;
        case 45: _t->MX_setProtocol((*reinterpret_cast< int(*)>(_a[1]))); break;
        case 46: _t->MX_setSWCanMode((*reinterpret_cast< int(*)>(_a[1]))); break;
        case 47: _t->MX_setBaudRate((*reinterpret_cast< int(*)>(_a[1]))); break;
        case 48: _t->MX_checkBaudRate(); break;
        case 49: _t->ST_addPassFilter((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 50: _t->ST_addBlockFilter((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 51: _t->ST_addFlowControlFilter((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 52: _t->sendCanMessage((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< bool(*)>(_a[2]))); break;
        case 53: _t->ST_clearPassFilters(); break;
        case 54: _t->ST_clearBlockFilters(); break;
        case 55: _t->ST_clearFlowFilters(); break;
        case 56: _t->ST_startMonitorMode(); break;
        case 57: _t->ST_stopMonitorMode(); break;
        case 58: _t->ST_startFilterMonitorMode(); break;
        case 59: _t->ST_stopFilterMonitorMode(); break;
        case 60: _t->sendSingleShotRequest((*reinterpret_cast< QByteArray(*)>(_a[1]))); break;
        case 61: _t->sendSingleShotBlindRequest((*reinterpret_cast< QByteArray(*)>(_a[1]))); break;
        case 62: _t->stopThread(); break;
        case 63: _t->sendReqTroubleCodes(); break;
        case 64: _t->start(); break;
        case 65: _t->sendReqMonitorStatus(); break;
        case 66: { QString _r = _t->port();
            if (_a[0]) *reinterpret_cast< QString*>(_a[0]) = std::move(_r); }  break;
        case 67: _t->findObdPort(); break;
        case 68: _t->sendElmCommand((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 69: _t->setHeader((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 70: _t->setEcho((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 71: _t->setLineFeed((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 72: { QString _r = _t->version();
            if (_a[0]) *reinterpret_cast< QString*>(_a[0]) = std::move(_r); }  break;
        default: ;
        }
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        switch (_id) {
        default: *reinterpret_cast<int*>(_a[0]) = -1; break;
        case 2:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 5:
            case 4:
            case 3:
            case 2:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QList<QString> >(); break;
            case 1:
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QList<unsigned char> >(); break;
            }
            break;
        case 6:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QList<QString> >(); break;
            }
            break;
        case 14:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 0:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QList<QString> >(); break;
            }
            break;
        case 15:
            switch (*reinterpret_cast<int*>(_a[1])) {
            default: *reinterpret_cast<int*>(_a[0]) = -1; break;
            case 1:
                *reinterpret_cast<int*>(_a[0]) = qRegisterMetaType< QList<QString> >(); break;
            }
            break;
        }
    } else if (_c == QMetaObject::IndexOfMethod) {
        int *result = reinterpret_cast<int *>(_a[0]);
        {
            using _t = void (ObdThread::*)(QByteArray );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::monitorModeLine)) {
                *result = 0;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)(QMap<ObdThread::CONTINUOUS_MONITOR,ObdThread::MONITOR_COMPLETE_STATUS> );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::monitorTestReply)) {
                *result = 1;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)(QList<unsigned char> , QList<unsigned char> , QList<QString> , QList<QString> , QList<QString> , QList<QString> );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::onBoardMonitoringReply)) {
                *result = 2;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)(QString );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::mfgStringReply)) {
                *result = 3;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)(ObdThread::ObdError );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::liberror)) {
                *result = 4;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)(double );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::voltageReply)) {
                *result = 5;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)(QList<QString> );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::supportedModesReply)) {
                *result = 6;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)(QString );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::connected)) {
                *result = 7;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::disconnected)) {
                *result = 8;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::reqLoopStarted)) {
                *result = 9;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)();
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::reqLoopStopped)) {
                *result = 10;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)(QString );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::elmCommandFailed)) {
                *result = 11;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)(QString , QString , int , double );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::pidReply)) {
                *result = 12;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)(QByteArray , QByteArray );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::singleShotReply)) {
                *result = 13;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)(QList<QString> );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::supportedPidsReply)) {
                *result = 14;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)(QString , QList<QString> );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::troubleCodesReply)) {
                *result = 15;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)(QString );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::consoleMessage)) {
                *result = 16;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)(QString );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::obdPortFound)) {
                *result = 17;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)(QString );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::protocolReply)) {
                *result = 18;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)(QString );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::rawCommsMessage)) {
                *result = 19;
                return;
            }
        }
        {
            using _t = void (ObdThread::*)(QString , obdLib::DebugLevel );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&ObdThread::debugMessage)) {
                *result = 20;
                return;
            }
        }
    }
}

QT_INIT_METAOBJECT const QMetaObject ObdThread::staticMetaObject = {
    { &QThread::staticMetaObject, qt_meta_stringdata_ObdThread.data,
      qt_meta_data_ObdThread,  qt_static_metacall, nullptr, nullptr}
};


const QMetaObject *ObdThread::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *ObdThread::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_ObdThread.stringdata0))
        return static_cast<void*>(this);
    return QThread::qt_metacast(_clname);
}

int ObdThread::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QThread::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 73)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 73;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 73)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 73;
    }
    return _id;
}

// SIGNAL 0
void ObdThread::monitorModeLine(QByteArray _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}

// SIGNAL 1
void ObdThread::monitorTestReply(QMap<ObdThread::CONTINUOUS_MONITOR,ObdThread::MONITOR_COMPLETE_STATUS> _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 1, _a);
}

// SIGNAL 2
void ObdThread::onBoardMonitoringReply(QList<unsigned char> _t1, QList<unsigned char> _t2, QList<QString> _t3, QList<QString> _t4, QList<QString> _t5, QList<QString> _t6)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)), const_cast<void*>(reinterpret_cast<const void*>(&_t3)), const_cast<void*>(reinterpret_cast<const void*>(&_t4)), const_cast<void*>(reinterpret_cast<const void*>(&_t5)), const_cast<void*>(reinterpret_cast<const void*>(&_t6)) };
    QMetaObject::activate(this, &staticMetaObject, 2, _a);
}

// SIGNAL 3
void ObdThread::mfgStringReply(QString _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 3, _a);
}

// SIGNAL 4
void ObdThread::liberror(ObdThread::ObdError _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 4, _a);
}

// SIGNAL 5
void ObdThread::voltageReply(double _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 5, _a);
}

// SIGNAL 6
void ObdThread::supportedModesReply(QList<QString> _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 6, _a);
}

// SIGNAL 7
void ObdThread::connected(QString _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 7, _a);
}

// SIGNAL 8
void ObdThread::disconnected()
{
    QMetaObject::activate(this, &staticMetaObject, 8, nullptr);
}

// SIGNAL 9
void ObdThread::reqLoopStarted()
{
    QMetaObject::activate(this, &staticMetaObject, 9, nullptr);
}

// SIGNAL 10
void ObdThread::reqLoopStopped()
{
    QMetaObject::activate(this, &staticMetaObject, 10, nullptr);
}

// SIGNAL 11
void ObdThread::elmCommandFailed(QString _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 11, _a);
}

// SIGNAL 12
void ObdThread::pidReply(QString _t1, QString _t2, int _t3, double _t4)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)), const_cast<void*>(reinterpret_cast<const void*>(&_t3)), const_cast<void*>(reinterpret_cast<const void*>(&_t4)) };
    QMetaObject::activate(this, &staticMetaObject, 12, _a);
}

// SIGNAL 13
void ObdThread::singleShotReply(QByteArray _t1, QByteArray _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 13, _a);
}

// SIGNAL 14
void ObdThread::supportedPidsReply(QList<QString> _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 14, _a);
}

// SIGNAL 15
void ObdThread::troubleCodesReply(QString _t1, QList<QString> _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 15, _a);
}

// SIGNAL 16
void ObdThread::consoleMessage(QString _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 16, _a);
}

// SIGNAL 17
void ObdThread::obdPortFound(QString _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 17, _a);
}

// SIGNAL 18
void ObdThread::protocolReply(QString _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 18, _a);
}

// SIGNAL 19
void ObdThread::rawCommsMessage(QString _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 19, _a);
}

// SIGNAL 20
void ObdThread::debugMessage(QString _t1, obdLib::DebugLevel _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 20, _a);
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
