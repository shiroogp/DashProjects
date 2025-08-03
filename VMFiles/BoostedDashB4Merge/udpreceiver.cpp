#include "udpreceiver.h"
#include "dashboard.h"
#include <QUdpSocket>
#include <QHostAddress>
#include <QDataStream>
#include <string.h>


udpreceiver::udpreceiver(QObject *parent)
    : QObject(parent)
    , m_dashboard(Q_NULLPTR)
    , m_connect(Q_NULLPTR)
{

}
udpreceiver::udpreceiver(DashBoard *dashboard, QObject *parent)
    : QObject(parent)
    , m_dashboard(dashboard)
    , m_connect(Q_NULLPTR)
{

}

void udpreceiver::startreceiver()
{
    udpSocket = new QUdpSocket(this);
    udpSocket->bind(45454, QUdpSocket::ShareAddress);
    connect(udpSocket, SIGNAL(readyRead()),
            this, SLOT(processPendingDatagrams()));
//    udpSocket->writeDatagram(datagram, QHostAddress::Broadcast, 45454);
    qDebug()<< "UDP CONNECETED";
}


void udpreceiver::broadcastFile(const QString &dashfile)
{
    QByteArray datagram = dashfile.toUtf8();// + "~" + QByteArray::number(0);

//    QByteArray datagram =  dashfile.    QByteArray::toStdString(dashfile);//  dashfile+"";
    udpSocket->writeDatagram(datagram, QHostAddress::Broadcast, 45454);
    udpSocket->waitForBytesWritten(120000);
    qDebug()<< "UDP CONNECETED";
}

void udpreceiver::closeConnection()
{
    udpSocket->close();
    delete udpSocket;
}
void udpreceiver::processGPRMC(const QString & line){
    QStringList fields = line.split(',');
    if(fields.size() >= 8)
    {
        QString time = fields[0];
        time.insert(2,":");
        time.insert(5,":");
        QString latitude = fields[2];
        QString latDirection = fields[3];
        QString longitude = fields[4];
        QString lonDirection = fields[5];
        QString groundspeedknots = fields[6];
        QString bearing = fields[7];
        if (bearing != "")
        {
            //We update bearing only if we have a valid baering
            m_dashboard->setgpsbaering(bearing.toDouble());
        }
        double speed = groundspeedknots.toDouble() * 1.852;
        /*   if (speed < 2)
    {
        speed = 0; // this is to ensure we show 0 if we standing as GPS sometimes sends a value greater 0 when standing still
    }*/
        QString decLat = convertToDecimal(latitude, latDirection);
        QString decLon = convertToDecimal(longitude, lonDirection);


        m_dashboard->setgpsLatitude(decLat.toDouble());
        m_dashboard->setgpsLongitude(decLon.toDouble());
        m_dashboard->setgpsSpeed(qRound(speed));// round speed to the nearest integer //todo put this back for gps speed
        m_dashboard->setgpsTime(time);
    }
}
QString udpreceiver::convertToDecimal(const QString & coord, const QString & dir)
{
    int decIndex = coord.indexOf('.');
    QString minutes = coord.mid(decIndex- 2);
    QString seconds = coord.mid(decIndex+1,2);
    double dec = minutes.toDouble() * 60 / 3600;
    double degrees = coord.mid(0, decIndex -2).toDouble();
    double decCoord = dec + degrees;
    if(dir.startsWith("W") || dir.startsWith("S"))
        decCoord *= -1.0;
    return QString::number(decCoord,'f',6);
}

void udpreceiver::processPendingDatagrams()
{

    QByteArray datagram;

    while (udpSocket->hasPendingDatagrams()) {
        datagram.resize(int(udpSocket->pendingDatagramSize()));
        udpSocket->readDatagram(datagram.data(), datagram.size());

        QDataStream in(&datagram, QIODevice::ReadOnly);
        QString raw = datagram.data();
//        qDebug()<<raw;
        if (raw.isEmpty())
        {raw ="0,0";}
//        QString dataPartStr = strtok(NULL,"~");
        if (raw.startsWith("GPS"))
        {
            QStringList list = raw.split( "~" );
            if (list.size() > 1){
                processGPRMC(list[1]);
            }
        } else if (raw.startsWith("FULL"))
        {
            QStringList list = raw.split( "~" );
            for (int i = 1; i < list.size(); ++i)
                {
//                processFullUpdate(list[1]);
            }
        } else if (raw.startsWith("CORE"))
        {
            QStringList list = raw.split( "~" );
            processCoreEFIUpdate(list[1]);
        } else if (raw.startsWith("NEWDASH"))
        {
            QStringList list = raw.split( "~" );
            if (list.size() > 1){
                m_dashboard->setNewDashFile(raw);
            }
        }else {

//        while(dataPartStr!=NULL)
//        {
            QStringList list = raw.split( "," );
            int ident =list[0].toInt();
            float Value =list[1].toFloat();

            switch(ident) {

            case 1:
                m_dashboard->setaccelpedpos(Value);
                break;
            case 2:
                m_dashboard->setAccelTimer(Value);
                break;
            case 3:
                m_dashboard->setaccelx(Value);
                break;
            case 4:
                m_dashboard->setaccely(Value);
                break;
            case 5:
                m_dashboard->setaccelz(Value);
                break;
            case 6:
                m_dashboard->setAFR(Value);
                break;
            case 7:
                m_dashboard->setairtempensor2(Value);
                break;
            case 8:
                m_dashboard->setambipress(Value);
                break;
            case 9:
                m_dashboard->setambitemp(Value);
                break;
            case 10:
                m_dashboard->setantilaglauchswitch(Value);
                break;
            case 11:
                m_dashboard->setantilaglaunchon(Value);
                break;
            case 12:
                m_dashboard->setauxcalc1(Value);
                break;
            case 13:
                m_dashboard->setauxcalc2(Value);
                break;
            case 14:
                m_dashboard->setauxcalc3(Value);
                break;
            case 15:
                m_dashboard->setauxcalc4(Value);
                break;
            case 16:
                m_dashboard->setauxrevlimitswitch(Value);
                break;
            case 17:
                m_dashboard->setAUXT(Value);
                break;
            case 18:
                m_dashboard->setavfueleconomy(Value);
                break;
            case 19:
                m_dashboard->setbattlight(Value);
                break;
            case 20:
                m_dashboard->setboostcontrol(Value);
                break;
            case 21:
                m_dashboard->setBoostDuty(Value);
                break;
            case 22:
                m_dashboard->setBoostPres(Value);
                break;
            case 23:
                m_dashboard->setBoosttp(Value);
                break;
            case 24:
                m_dashboard->setBoostwg(Value);
                break;
            case 25:
                //m_dashboard->setbrakepedalstate(Value);
                break;
            case 26:
                m_dashboard->setbrakepress(Value);
                break;
            case 27:
                m_dashboard->setclutchswitchstate(Value);
                break;
            case 28:
                m_dashboard->setcompass(Value);
                break;
            case 29:
                m_dashboard->setcoolantpress(Value);
                break;
            case 30:
                m_dashboard->setdecelcut(Value);
                break;
            case 31:
                m_dashboard->setdiffoiltemp(Value);
                break;
            case 32:
                m_dashboard->setdistancetoempty(Value);
                break;
            case 33:
                m_dashboard->setDwell(Value);
                break;
            case 34:
                m_dashboard->setegt1(Value);
                break;
            case 35:
                m_dashboard->setegt2(Value);
                break;
            case 36:
                m_dashboard->setegt3(Value);
                break;
            case 37:
                m_dashboard->setegt4(Value);
                break;
            case 38:
                m_dashboard->setegt5(Value);
                break;
            case 39:
                m_dashboard->setegt6(Value);
                break;
            case 40:
                m_dashboard->setegt7(Value);
                break;
            case 41:
                m_dashboard->setegt8(Value);
                break;
            case 42:
                m_dashboard->setegt9(Value);
                break;
            case 43:
                m_dashboard->setegt10(Value);
                break;
            case 44:
                m_dashboard->setegt11(Value);
                break;
            case 45:
                m_dashboard->setegt12(Value);
                break;
            case 46:
                m_dashboard->setEngLoad(Value);
                break;
            case 47:
                m_dashboard->setexcamangle1(Value);
                break;
            case 48:
                m_dashboard->setexcamangle2(Value);
                break;
            case 49:
                m_dashboard->setFlag1(Value);
                break;
            case 50:
                m_dashboard->setFlag2(Value);
                break;
            case 51:
                m_dashboard->setFlag3(Value);
                break;
            case 52:
                m_dashboard->setFlag4(Value);
                break;
            case 53:
                m_dashboard->setFlag5(Value);
                break;
            case 54:
                m_dashboard->setFlag6(Value);
                break;
            case 55:
                m_dashboard->setFlag7(Value);
                break;
            case 56:
                m_dashboard->setFlag8(Value);
                break;
            case 57:
                m_dashboard->setFlag9(Value);
                break;
            case 58:
                m_dashboard->setFlag10(Value);
                break;
            case 59:
                m_dashboard->setFlag11(Value);
                break;
            case 60:
                m_dashboard->setFlag12(Value);
                break;
            case 61:
                m_dashboard->setFlag13(Value);
                break;
            case 62:
                m_dashboard->setFlag14(Value);
                break;
            case 63:
                m_dashboard->setFlag15(Value);
                break;
            case 64:
                m_dashboard->setFlag16(Value);
                break;
            case 65:
                m_dashboard->setFlag17(Value);
                break;
            case 66:
                m_dashboard->setFlag18(Value);
                break;
            case 67:
                m_dashboard->setFlag19(Value);
                break;
            case 68:
                m_dashboard->setFlag20(Value);
                break;
            case 69:
                m_dashboard->setFlag21(Value);
                break;
            case 70:
                m_dashboard->setFlag22(Value);
                break;
            case 71:
                m_dashboard->setFlag23(Value);
                break;
            case 72:
                m_dashboard->setFlag24(Value);
                break;
            case 73:
                m_dashboard->setFlag25(Value);
                break;
            case 74:
                // Ignition Angle Bank 1
                break;
            case 75:
                //Ignition Angle Bank 2
                break;
            case 76:
                //Torque Management Driveshaft RPM Target
                break;
            case 77:
                //Torque Management Driveshaft RPM Target Error
                break;
            case 78:
                //Torque Management Driveshaft RPM Target Error Ignition Correction
                break;
            case 79:
                //Torque Management Driveshaft RPM Timed Ignition Correction
                break;
            case 80:
                //Torque Management Combined Ignition Correction
                break;
            case 81:
                m_dashboard->setflatshiftstate(Value);
                break;
            case 82:
                m_dashboard->setFuelc(Value);
                break;
            case 83:
                m_dashboard->setfuelclevel(Value);
                break;
            case 84:
                m_dashboard->setfuelcomposition(Value);
                break;
            case 85:
                m_dashboard->setfuelconsrate(Value);
                break;
            case 86:
                m_dashboard->setfuelcutperc(Value);
                break;
            case 87:
                m_dashboard->setfuelflow(Value);
                break;
            case 88:
                m_dashboard->setfuelflowdiff(Value);
                break;
            case 89:
                m_dashboard->setfuelflowret(Value);
                break;
            case 100:
                m_dashboard->setFuelPress(Value);
                break;
            case 101:
                m_dashboard->setFueltemp(Value);
                break;
            case 102:
                m_dashboard->setfueltrimlongtbank1(Value);
                break;
            case 103:
                m_dashboard->setfueltrimlongtbank2(Value);
                break;
            case 104:
                m_dashboard->setfueltrimshorttbank1(Value);
                break;
            case 105:
                m_dashboard->setfueltrimshorttbank2(Value);
                break;
            case 106:
                m_dashboard->setGear(Value);
                break;
            case 107:
                m_dashboard->setgearswitch(Value);
                break;
            case 108:
                //            m_dashboard->setgpsAltitude(Value);
                break;
            case 109:
                //-25.809581, 28.112241
                // m_dashboard->setgpsLatitude(QString::number(-25.809581));
                // m_dashboard->setgpsLongitude(QString::number(28.112241));
                //processGPRMC(Value);
                break;
            case 110:
                //m_dashboard->setgpsLongitude(Value);
                break;
            case 111:
                //m_dashboard->setgpsSpeed(Value);
                break;
            case 112:
                //m_dashboard->setgpsTime(Value);
                break;
            case 113:
                //            m_dashboard->setgpsVisibleSatelites(Value);
                break;
            case 114:
                m_dashboard->setgyrox(Value);
                break;
            case 115:
                m_dashboard->setgyroy(Value);
                break;
            case 116:
                m_dashboard->setgyroz(Value);
                break;
            case 117:
                m_dashboard->sethandbrake(Value);
                break;
            case 118:
                m_dashboard->sethighbeam(Value);
                break;
            case 119:
                m_dashboard->sethomeccounter(Value);
                break;
            case 120:
                m_dashboard->setIdleValue(Value);
                break;
            case 121:
                m_dashboard->setIgn(Value);
                break;
            case 122:
                m_dashboard->setIgn1(Value);
                break;
            case 123:
                m_dashboard->setIgn2(Value);
                break;
            case 124:
                m_dashboard->setIgn3(Value);
                break;
            case 125:
                m_dashboard->setIgn4(Value);
                break;
            case 126:
                m_dashboard->setincamangle1(Value);
                break;
            case 127:
                m_dashboard->setincamangle2(Value);
                break;
            case 128:
                m_dashboard->setInj(Value);
                break;
            case 129:
                m_dashboard->setInj1(Value);
                break;
            case 130:
                m_dashboard->setInj2(Value);
                break;
            case 131:
                m_dashboard->setInj3(Value);
                break;
            case 132:
                m_dashboard->setInj4(Value);
                break;
            case 133:
                m_dashboard->setInjDuty(Value);
                break;
            case 134:
                m_dashboard->setinjms(Value);
                break;
            case 135:
                m_dashboard->setIntaketemp(Value);
                break;
            case 136:
                m_dashboard->setIscvduty(Value);
                break;
            case 137:
                m_dashboard->setKnock(Value);
                break;
            case 138:
                m_dashboard->setknocklevlogged1(Value);
                break;
            case 139:
                m_dashboard->setknocklevlogged2(Value);
                break;
            case 140:
                m_dashboard->setknockretardbank1(Value);
                break;
            case 141:
                m_dashboard->setknockretardbank2(Value);
                break;
            case 142:
                m_dashboard->setLAMBDA(Value);
                break;
            case 143:
                m_dashboard->setlambda2(Value);
                break;
            case 144:
                m_dashboard->setlambda3(Value);
                break;
            case 145:
                m_dashboard->setlambda4(Value);
                break;
            case 146:
                m_dashboard->setLAMBDATarget(Value);
                break;
            case 147:
                m_dashboard->setlaunchcontolfuelenrich(Value);
                break;
            case 148:
                m_dashboard->setlaunchctrolignretard(Value);
                break;
            case 149:
                m_dashboard->setLeadingign(Value);
                break;
            case 150:
                m_dashboard->setleftindicator(Value);
                break;
            case 151:
                m_dashboard->setlimpmode(Value);
                break;
            case 152:
                m_dashboard->setMAF1V(Value);
                break;
            case 153:
                m_dashboard->setMAF2V(Value);
                break;
            case 154:
                m_dashboard->setMAFactivity(Value);
                break;
            case 155:
                m_dashboard->setMAP(Value);
                break;
            case 156:
                //            m_dashboard->setAFR(MAP2(Value);
                break;
            case 157:
                m_dashboard->setmil(Value);
                break;
            case 158:
                m_dashboard->setmissccount(Value);
                break;
            case 159:
                m_dashboard->setMoilp(Value);
                break;
            case 160:
                m_dashboard->setMVSS(Value);
                break;
            case 161:
                m_dashboard->setna1(Value);
                break;
            case 162:
                m_dashboard->setna2(Value);
                break;
            case 163:
                m_dashboard->setnosactive(Value);
                break;
            case 164:
                m_dashboard->setnospress(Value);
                break;
            case 165:
                m_dashboard->setnosswitch(Value);
                break;
            case 166:
                m_dashboard->setO2volt(Value);
                break;
            case 167:
                m_dashboard->setO2volt_2(Value);
                break;
            case 168:
                m_dashboard->setOdo(Value);
                break;
            case 169:
                m_dashboard->setoilpres(Value);
                break;
            case 170:
                m_dashboard->setoiltemp(Value);
                break;
            case 171:
                m_dashboard->setpim(Value);
                break;
            case 172:
                //            m_dashboard->setPlatform(Value);
                break;
            case 173:
                m_dashboard->setPower(Value);
                break;
            case 174:
                m_dashboard->setPressureV(Value);
                break;
            case 175:
                m_dashboard->setPrimaryinp(Value);
                break;
            case 176:
                m_dashboard->setrallyantilagswitch(Value);
                break;
            case 177:
                //            m_dashboard->setRecvData(Value);
                break;
            case 178:
                m_dashboard->setrightindicator(Value);
                break;
            case 179:
                m_dashboard->setrpm(Value);
                break;
            case 180:
                //            m_dashboard->setRunStat(Value);
                break;
            case 181:
                m_dashboard->setSecinjpulse(Value);
                break;
            case 182:
                m_dashboard->setsens1(Value);
                break;
            case 183:
                m_dashboard->setsens2(Value);
                break;
            case 184:
                m_dashboard->setsens3(Value);
                break;
            case 185:
                m_dashboard->setsens4(Value);
                break;
            case 186:
                m_dashboard->setsens5(Value);
                break;
            case 187:
                m_dashboard->setsens6(Value);
                break;
            case 188:
                m_dashboard->setsens7(Value);
                break;
            case 189:
                m_dashboard->setsens8(Value);
                break;
            case 190:
                //Generic Output 1 Duty Cycl
                break;
            case 191:
                //Fuel Level
                break;
            case 192:
                //Turbo Timer - Time Remaining
                break;
            case 193:
                //Turbo Timer - Engine Time Remaining
                break;
            case 194:
                //Steering Wheel Angle
                break;
            case 195:
                //Driveshaft RPM
                break;
            case 196:
                //NOS Pressure Sensor 2
                break;
            case 197:
                //NOS Pressure Sensor 3
                break;
            case 198:
                //NOS Pressure Sensor 4
                break;
            case 199:
                if (m_dashboard->ExternalSpeed() == 0 )
                {
                    m_dashboard->setSpeed(Value);
                }
                else
                {break;}
                break;
            case 200:
                m_dashboard->setSVSS(Value);
                break;
            case 201:
                m_dashboard->settargetbstlelkpa(Value);
                break;
            case 202:
                m_dashboard->setThrottleV(Value);
                break;
            case 203:
                m_dashboard->settimeddutyout1(Value);
                break;
            case 204:
                m_dashboard->settimeddutyout2(Value);
                break;
            case 205:
                m_dashboard->settimeddutyoutputactive(Value);
                break;
            case 206:
                //           m_dashboard->setTimeoutStat(Value);
                break;
            case 207:
                m_dashboard->setTorque(Value);
                break;
            case 208:
                m_dashboard->settorqueredcutactive(Value);
                break;
            case 209:
                m_dashboard->settorqueredlevelactive(Value);
                break;
            case 210:
                m_dashboard->setTPS(Value);
                break;
            case 211:
                m_dashboard->setTrailingign(Value);
                break;
            case 212:
                m_dashboard->settransientthroactive(Value);
                break;
            case 213:
                m_dashboard->settransoiltemp(Value);
                break;
            case 214:
                m_dashboard->settriggerccounter(Value);
                break;
            case 215:
                m_dashboard->settriggersrsinceasthome(Value);
                break;
            case 216:
                m_dashboard->setTRIM(Value);
                break;
            case 217:
                m_dashboard->setTrip(Value);
                break;
            case 218:
                m_dashboard->setturborpm(Value);
                break;

            case 219:
                m_dashboard->setecu(Value);
                break;
            case 220:
                m_dashboard->setwastegatepress(Value);
                break;
            case 221:
                m_dashboard->setWatertemp(Value);
                break;
            case 222:
                m_dashboard->setwheeldiff(Value);
                break;
            case 223:
                m_dashboard->setwheelslip(Value);
                break;
            case 224:
                m_dashboard->setwheelspdftleft(Value);
                break;
            case 225:
                m_dashboard->setwheelspdftright(Value);
                break;

            case 226:
                m_dashboard->setwheelspdrearleft(Value);
                break;
            case 227:
                m_dashboard->setwheelspdrearright(Value);
                break;

            case 228:
                m_dashboard->setBatteryV(Value);
                break;
            case 229:
                m_dashboard->setIntakepress(Value);
                break;

                //not yet implemented
            case 255:
                //CAS REF
                break;
            case 259:
                //AAC Valve
                break;
            case 260:
                //Turbo Speed Sensor 2
                break;
            case 261:
                //Generic Sensor 1
                break;
            case 262:
                //Generic Sensor 2
                break;
            case 263:
                //Generic Sensor 3
                break;
            case 264:
                //Generic Sensor 4
                break;
            case 265:
                //Generic Sensor 5
                break;
            case 266:
                //Generic Sensor 6
                break;
            case 267:
                //Generic Sensor 7
                break;
            case 268:
                //Generic Sensor 8
                break;
            case 269:
                //Generic Sensor 9
                break;
            case 270:
                //Generic Sensor 10
                break;
            case 271:
                //Gearbox Oil Pressure
                break;
            case 272:
                //Injection Stage 3 Duty Cycle
                break;
            case 273:
                //MAP N
                break;
            case 274:
                //MAP P
                break;
            case 275:
                m_dashboard->setInjDuty2(Value);
                break;
            case 276:
                m_dashboard->setInjAngle(Value);
                break;
            case 277:
                //Catalyst Temp Bank1 S1
                break;
            case 278:
                //Manifold Gauge Pressure kPa
                break;
            case 279:
                //
                break;
            case 280:
                //
                break;
            case 281:
                //
                break;
            case 282:
                //
                break;
            case 283:
                //
                break;
            case 284:
                //
                break;
            case 285:
                //
                break;
            case 286:
                //
                break;
            case 287:
                //
                break;
            case 288:
                //
                break;
            case 289:
                //
                break;
            case 290:
                //
                break;
            case 800:
                m_dashboard->setSensorString1(list[1]);
                break;
            case 801:
                m_dashboard->setSensorString2(list[1]);
                break;
            case 802:
                m_dashboard->setSensorString3(list[1]);
                break;
            case 803:
                m_dashboard->setSensorString4(list[1]);
                break;
            case 804:
                m_dashboard->setSensorString5(list[1]);
                break;
            case 805:
                m_dashboard->setSensorString6(list[1]);
                break;
            case 806:
                m_dashboard->setSensorString7(list[1]);
                break;
            case 807:
                m_dashboard->setSensorString8(list[1]);
                break;
            case 808:
                m_dashboard->setFlagString1(list[1]);
                break;
            case 809:
                m_dashboard->setFlagString2(list[1]);
                break;
            case 810:
                m_dashboard->setFlagString3(list[1]);
                break;
            case 811:
                m_dashboard->setFlagString4(list[1]);
                break;
            case 812:
                m_dashboard->setFlagString5(list[1]);
                break;
            case 813:
                m_dashboard->setFlagString6(list[1]);
                break;
            case 814:
                m_dashboard->setFlagString7(list[1]);
                break;
            case 815:
                m_dashboard->setFlagString8(list[1]);
                break;
            case 816:
                m_dashboard->setFlagString9(list[1]);
                break;
            case 817:
                m_dashboard->setFlagString10(list[1]);
                break;
            case 818:
                m_dashboard->setFlagString11(list[1]);
                break;
            case 819:
                m_dashboard->setFlagString12(list[1]);
                break;
            case 820:
                m_dashboard->setFlagString13(list[1]);
                break;
            case 821:
                m_dashboard->setFlagString14(list[1]);
                break;
            case 822:
                m_dashboard->setFlagString15(list[1]);
                break;
            case 823:
                m_dashboard->setFlagString16(list[1]);
                break;
            case 824:
                //m_dashboard->setModel(list[1]);
                break;
            case 825:
                m_dashboard->setError(list[1]);
                break;
            case 999:
                break;
            default:
                break;
            }
//            dataPartStr = strtok(NULL,"/");
        }

    }
}


void udpreceiver::processFullUpdate(const QString & line)
{


    QString raw = line;
//        qDebug()<<raw;
    if (raw.isEmpty())
    {raw ="0,0";}
//        QString dataPartStr = strtok(NULL,"~");
    if (raw.startsWith("GPS"))
    {
        QStringList list = raw.split( "~" );
        if (list.size() > 1){
            processGPRMC(list[1]);
        }
    } else if (raw.startsWith("FULL"))
    {
        QStringList list = raw.split( "~" );
        if (list.size() > 1){
            processGPRMC(list[1]);
        }
    } else if (raw.startsWith("NEWDASH"))
    {
        QStringList list = raw.split( "~" );
        if (list.size() > 1){
            m_dashboard->setNewDashFile(raw);
        }
    }else {

//        while(dataPartStr!=NULL)
//        {
        QStringList list = raw.split( "," );
        int ident =list[0].toInt();
        float Value =list[1].toFloat();

        switch(ident) {

        case 1:
            m_dashboard->setaccelpedpos(Value);
            break;
        case 2:
            m_dashboard->setAccelTimer(Value);
            break;
        case 3:
            m_dashboard->setaccelx(Value);
            break;
        case 4:
            m_dashboard->setaccely(Value);
            break;
        case 5:
            m_dashboard->setaccelz(Value);
            break;
        case 6:
            m_dashboard->setAFR(Value);
            break;
        case 7:
            m_dashboard->setairtempensor2(Value);
            break;
        case 8:
            m_dashboard->setambipress(Value);
            break;
        case 9:
            m_dashboard->setambitemp(Value);
            break;
        case 10:
            m_dashboard->setantilaglauchswitch(Value);
            break;
        case 11:
            m_dashboard->setantilaglaunchon(Value);
            break;
        case 12:
            m_dashboard->setauxcalc1(Value);
            break;
        case 13:
            m_dashboard->setauxcalc2(Value);
            break;
        case 14:
            m_dashboard->setauxcalc3(Value);
            break;
        case 15:
            m_dashboard->setauxcalc4(Value);
            break;
        case 16:
            m_dashboard->setauxrevlimitswitch(Value);
            break;
        case 17:
            m_dashboard->setAUXT(Value);
            break;
        case 18:
            m_dashboard->setavfueleconomy(Value);
            break;
        case 19:
            m_dashboard->setbattlight(Value);
            break;
        case 20:
            m_dashboard->setboostcontrol(Value);
            break;
        case 21:
            m_dashboard->setBoostDuty(Value);
            break;
        case 22:
            m_dashboard->setBoostPres(Value);
            break;
        case 23:
            m_dashboard->setBoosttp(Value);
            break;
        case 24:
            m_dashboard->setBoostwg(Value);
            break;
        case 25:
            //m_dashboard->setbrakepedalstate(Value);
            break;
        case 26:
            m_dashboard->setbrakepress(Value);
            break;
        case 27:
            m_dashboard->setclutchswitchstate(Value);
            break;
        case 28:
            m_dashboard->setcompass(Value);
            break;
        case 29:
            m_dashboard->setcoolantpress(Value);
            break;
        case 30:
            m_dashboard->setdecelcut(Value);
            break;
        case 31:
            m_dashboard->setdiffoiltemp(Value);
            break;
        case 32:
            m_dashboard->setdistancetoempty(Value);
            break;
        case 33:
            m_dashboard->setDwell(Value);
            break;
        case 34:
            m_dashboard->setegt1(Value);
            break;
        case 35:
            m_dashboard->setegt2(Value);
            break;
        case 36:
            m_dashboard->setegt3(Value);
            break;
        case 37:
            m_dashboard->setegt4(Value);
            break;
        case 38:
            m_dashboard->setegt5(Value);
            break;
        case 39:
            m_dashboard->setegt6(Value);
            break;
        case 40:
            m_dashboard->setegt7(Value);
            break;
        case 41:
            m_dashboard->setegt8(Value);
            break;
        case 42:
            m_dashboard->setegt9(Value);
            break;
        case 43:
            m_dashboard->setegt10(Value);
            break;
        case 44:
            m_dashboard->setegt11(Value);
            break;
        case 45:
            m_dashboard->setegt12(Value);
            break;
        case 46:
            m_dashboard->setEngLoad(Value);
            break;
        case 47:
            m_dashboard->setexcamangle1(Value);
            break;
        case 48:
            m_dashboard->setexcamangle2(Value);
            break;
        case 49:
            m_dashboard->setFlag1(Value);
            break;
        case 50:
            m_dashboard->setFlag2(Value);
            break;
        case 51:
            m_dashboard->setFlag3(Value);
            break;
        case 52:
            m_dashboard->setFlag4(Value);
            break;
        case 53:
            m_dashboard->setFlag5(Value);
            break;
        case 54:
            m_dashboard->setFlag6(Value);
            break;
        case 55:
            m_dashboard->setFlag7(Value);
            break;
        case 56:
            m_dashboard->setFlag8(Value);
            break;
        case 57:
            m_dashboard->setFlag9(Value);
            break;
        case 58:
            m_dashboard->setFlag10(Value);
            break;
        case 59:
            m_dashboard->setFlag11(Value);
            break;
        case 60:
            m_dashboard->setFlag12(Value);
            break;
        case 61:
            m_dashboard->setFlag13(Value);
            break;
        case 62:
            m_dashboard->setFlag14(Value);
            break;
        case 63:
            m_dashboard->setFlag15(Value);
            break;
        case 64:
            m_dashboard->setFlag16(Value);
            break;
        case 65:
            m_dashboard->setFlag17(Value);
            break;
        case 66:
            m_dashboard->setFlag18(Value);
            break;
        case 67:
            m_dashboard->setFlag19(Value);
            break;
        case 68:
            m_dashboard->setFlag20(Value);
            break;
        case 69:
            m_dashboard->setFlag21(Value);
            break;
        case 70:
            m_dashboard->setFlag22(Value);
            break;
        case 71:
            m_dashboard->setFlag23(Value);
            break;
        case 72:
            m_dashboard->setFlag24(Value);
            break;
        case 73:
            m_dashboard->setFlag25(Value);
            break;
        case 74:
            // Ignition Angle Bank 1
            break;
        case 75:
            //Ignition Angle Bank 2
            break;
        case 76:
            //Torque Management Driveshaft RPM Target
            break;
        case 77:
            //Torque Management Driveshaft RPM Target Error
            break;
        case 78:
            //Torque Management Driveshaft RPM Target Error Ignition Correction
            break;
        case 79:
            //Torque Management Driveshaft RPM Timed Ignition Correction
            break;
        case 80:
            //Torque Management Combined Ignition Correction
            break;
        case 81:
            m_dashboard->setflatshiftstate(Value);
            break;
        case 82:
            m_dashboard->setFuelc(Value);
            break;
        case 83:
            m_dashboard->setfuelclevel(Value);
            break;
        case 84:
            m_dashboard->setfuelcomposition(Value);
            break;
        case 85:
            m_dashboard->setfuelconsrate(Value);
            break;
        case 86:
            m_dashboard->setfuelcutperc(Value);
            break;
        case 87:
            m_dashboard->setfuelflow(Value);
            break;
        case 88:
            m_dashboard->setfuelflowdiff(Value);
            break;
        case 89:
            m_dashboard->setfuelflowret(Value);
            break;
        case 100:
            m_dashboard->setFuelPress(Value);
            break;
        case 101:
            m_dashboard->setFueltemp(Value);
            break;
        case 102:
            m_dashboard->setfueltrimlongtbank1(Value);
            break;
        case 103:
            m_dashboard->setfueltrimlongtbank2(Value);
            break;
        case 104:
            m_dashboard->setfueltrimshorttbank1(Value);
            break;
        case 105:
            m_dashboard->setfueltrimshorttbank2(Value);
            break;
        case 106:
            m_dashboard->setGear(Value);
            break;
        case 107:
            m_dashboard->setgearswitch(Value);
            break;
        case 108:
            //            m_dashboard->setgpsAltitude(Value);
            break;
        case 109:
            //-25.809581, 28.112241
            // m_dashboard->setgpsLatitude(QString::number(-25.809581));
            // m_dashboard->setgpsLongitude(QString::number(28.112241));
            //processGPRMC(Value);
            break;
        case 110:
            //m_dashboard->setgpsLongitude(Value);
            break;
        case 111:
            //m_dashboard->setgpsSpeed(Value);
            break;
        case 112:
            //m_dashboard->setgpsTime(Value);
            break;
        case 113:
            //            m_dashboard->setgpsVisibleSatelites(Value);
            break;
        case 114:
            m_dashboard->setgyrox(Value);
            break;
        case 115:
            m_dashboard->setgyroy(Value);
            break;
        case 116:
            m_dashboard->setgyroz(Value);
            break;
        case 117:
            m_dashboard->sethandbrake(Value);
            break;
        case 118:
            m_dashboard->sethighbeam(Value);
            break;
        case 119:
            m_dashboard->sethomeccounter(Value);
            break;
        case 120:
            m_dashboard->setIdleValue(Value);
            break;
        case 121:
            m_dashboard->setIgn(Value);
            break;
        case 122:
            m_dashboard->setIgn1(Value);
            break;
        case 123:
            m_dashboard->setIgn2(Value);
            break;
        case 124:
            m_dashboard->setIgn3(Value);
            break;
        case 125:
            m_dashboard->setIgn4(Value);
            break;
        case 126:
            m_dashboard->setincamangle1(Value);
            break;
        case 127:
            m_dashboard->setincamangle2(Value);
            break;
        case 128:
            m_dashboard->setInj(Value);
            break;
        case 129:
            m_dashboard->setInj1(Value);
            break;
        case 130:
            m_dashboard->setInj2(Value);
            break;
        case 131:
            m_dashboard->setInj3(Value);
            break;
        case 132:
            m_dashboard->setInj4(Value);
            break;
        case 133:
            m_dashboard->setInjDuty(Value);
            break;
        case 134:
            m_dashboard->setinjms(Value);
            break;
        case 135:
            m_dashboard->setIntaketemp(Value);
            break;
        case 136:
            m_dashboard->setIscvduty(Value);
            break;
        case 137:
            m_dashboard->setKnock(Value);
            break;
        case 138:
            m_dashboard->setknocklevlogged1(Value);
            break;
        case 139:
            m_dashboard->setknocklevlogged2(Value);
            break;
        case 140:
            m_dashboard->setknockretardbank1(Value);
            break;
        case 141:
            m_dashboard->setknockretardbank2(Value);
            break;
        case 142:
            m_dashboard->setLAMBDA(Value);
            break;
        case 143:
            m_dashboard->setlambda2(Value);
            break;
        case 144:
            m_dashboard->setlambda3(Value);
            break;
        case 145:
            m_dashboard->setlambda4(Value);
            break;
        case 146:
            m_dashboard->setLAMBDATarget(Value);
            break;
        case 147:
            m_dashboard->setlaunchcontolfuelenrich(Value);
            break;
        case 148:
            m_dashboard->setlaunchctrolignretard(Value);
            break;
        case 149:
            m_dashboard->setLeadingign(Value);
            break;
        case 150:
            m_dashboard->setleftindicator(Value);
            break;
        case 151:
            m_dashboard->setlimpmode(Value);
            break;
        case 152:
            m_dashboard->setMAF1V(Value);
            break;
        case 153:
            m_dashboard->setMAF2V(Value);
            break;
        case 154:
            m_dashboard->setMAFactivity(Value);
            break;
        case 155:
            m_dashboard->setMAP(Value);
            break;
        case 156:
            //            m_dashboard->setAFR(MAP2(Value);
            break;
        case 157:
            m_dashboard->setmil(Value);
            break;
        case 158:
            m_dashboard->setmissccount(Value);
            break;
        case 159:
            m_dashboard->setMoilp(Value);
            break;
        case 160:
            m_dashboard->setMVSS(Value);
            break;
        case 161:
            m_dashboard->setna1(Value);
            break;
        case 162:
            m_dashboard->setna2(Value);
            break;
        case 163:
            m_dashboard->setnosactive(Value);
            break;
        case 164:
            m_dashboard->setnospress(Value);
            break;
        case 165:
            m_dashboard->setnosswitch(Value);
            break;
        case 166:
            m_dashboard->setO2volt(Value);
            break;
        case 167:
            m_dashboard->setO2volt_2(Value);
            break;
        case 168:
            m_dashboard->setOdo(Value);
            break;
        case 169:
            m_dashboard->setoilpres(Value);
            break;
        case 170:
            m_dashboard->setoiltemp(Value);
            break;
        case 171:
            m_dashboard->setpim(Value);
            break;
        case 172:
            //            m_dashboard->setPlatform(Value);
            break;
        case 173:
            m_dashboard->setPower(Value);
            break;
        case 174:
            m_dashboard->setPressureV(Value);
            break;
        case 175:
            m_dashboard->setPrimaryinp(Value);
            break;
        case 176:
            m_dashboard->setrallyantilagswitch(Value);
            break;
        case 177:
            //            m_dashboard->setRecvData(Value);
            break;
        case 178:
            m_dashboard->setrightindicator(Value);
            break;
        case 179:
            m_dashboard->setrpm(Value);
            break;
        case 180:
            //            m_dashboard->setRunStat(Value);
            break;
        case 181:
            m_dashboard->setSecinjpulse(Value);
            break;
        case 182:
            m_dashboard->setsens1(Value);
            break;
        case 183:
            m_dashboard->setsens2(Value);
            break;
        case 184:
            m_dashboard->setsens3(Value);
            break;
        case 185:
            m_dashboard->setsens4(Value);
            break;
        case 186:
            m_dashboard->setsens5(Value);
            break;
        case 187:
            m_dashboard->setsens6(Value);
            break;
        case 188:
            m_dashboard->setsens7(Value);
            break;
        case 189:
            m_dashboard->setsens8(Value);
            break;
        case 190:
            //Generic Output 1 Duty Cycl
            break;
        case 191:
            //Fuel Level
            break;
        case 192:
            //Turbo Timer - Time Remaining
            break;
        case 193:
            //Turbo Timer - Engine Time Remaining
            break;
        case 194:
            //Steering Wheel Angle
            break;
        case 195:
            //Driveshaft RPM
            break;
        case 196:
            //NOS Pressure Sensor 2
            break;
        case 197:
            //NOS Pressure Sensor 3
            break;
        case 198:
            //NOS Pressure Sensor 4
            break;
        case 199:
            if (m_dashboard->ExternalSpeed() == 0 )
            {
                m_dashboard->setSpeed(Value);
            }
            else
            {break;}
            break;
        case 200:
            m_dashboard->setSVSS(Value);
            break;
        case 201:
            m_dashboard->settargetbstlelkpa(Value);
            break;
        case 202:
            m_dashboard->setThrottleV(Value);
            break;
        case 203:
            m_dashboard->settimeddutyout1(Value);
            break;
        case 204:
            m_dashboard->settimeddutyout2(Value);
            break;
        case 205:
            m_dashboard->settimeddutyoutputactive(Value);
            break;
        case 206:
            //           m_dashboard->setTimeoutStat(Value);
            break;
        case 207:
            m_dashboard->setTorque(Value);
            break;
        case 208:
            m_dashboard->settorqueredcutactive(Value);
            break;
        case 209:
            m_dashboard->settorqueredlevelactive(Value);
            break;
        case 210:
            m_dashboard->setTPS(Value);
            break;
        case 211:
            m_dashboard->setTrailingign(Value);
            break;
        case 212:
            m_dashboard->settransientthroactive(Value);
            break;
        case 213:
            m_dashboard->settransoiltemp(Value);
            break;
        case 214:
            m_dashboard->settriggerccounter(Value);
            break;
        case 215:
            m_dashboard->settriggersrsinceasthome(Value);
            break;
        case 216:
            m_dashboard->setTRIM(Value);
            break;
        case 217:
            m_dashboard->setTrip(Value);
            break;
        case 218:
            m_dashboard->setturborpm(Value);
            break;

        case 219:
            m_dashboard->setecu(Value);
            break;
        case 220:
            m_dashboard->setwastegatepress(Value);
            break;
        case 221:
            m_dashboard->setWatertemp(Value);
            break;
        case 222:
            m_dashboard->setwheeldiff(Value);
            break;
        case 223:
            m_dashboard->setwheelslip(Value);
            break;
        case 224:
            m_dashboard->setwheelspdftleft(Value);
            break;
        case 225:
            m_dashboard->setwheelspdftright(Value);
            break;

        case 226:
            m_dashboard->setwheelspdrearleft(Value);
            break;
        case 227:
            m_dashboard->setwheelspdrearright(Value);
            break;

        case 228:
            m_dashboard->setBatteryV(Value);
            break;
        case 229:
            m_dashboard->setIntakepress(Value);
            break;

            //not yet implemented
        case 255:
            //CAS REF
            break;
        case 259:
            //AAC Valve
            break;
        case 260:
            //Turbo Speed Sensor 2
            break;
        case 261:
            //Generic Sensor 1
            break;
        case 262:
            //Generic Sensor 2
            break;
        case 263:
            //Generic Sensor 3
            break;
        case 264:
            //Generic Sensor 4
            break;
        case 265:
            //Generic Sensor 5
            break;
        case 266:
            //Generic Sensor 6
            break;
        case 267:
            //Generic Sensor 7
            break;
        case 268:
            //Generic Sensor 8
            break;
        case 269:
            //Generic Sensor 9
            break;
        case 270:
            //Generic Sensor 10
            break;
        case 271:
            //Gearbox Oil Pressure
            break;
        case 272:
            //Injection Stage 3 Duty Cycle
            break;
        case 273:
            //MAP N
            break;
        case 274:
            //MAP P
            break;
        case 275:
            m_dashboard->setInjDuty2(Value);
            break;
        case 276:
            m_dashboard->setInjAngle(Value);
            break;
        case 277:
            //Catalyst Temp Bank1 S1
            break;
        case 278:
            //Manifold Gauge Pressure kPa
            break;
        case 279:
            //
            break;
        case 280:
            //
            break;
        case 281:
            //
            break;
        case 282:
            //
            break;
        case 283:
            //
            break;
        case 284:
            //
            break;
        case 285:
            //
            break;
        case 286:
            //
            break;
        case 287:
            //
            break;
        case 288:
            //
            break;
        case 289:
            //
            break;
        case 290:
            //
            break;
        case 800:
            m_dashboard->setSensorString1(list[1]);
            break;
        case 801:
            m_dashboard->setSensorString2(list[1]);
            break;
        case 802:
            m_dashboard->setSensorString3(list[1]);
            break;
        case 803:
            m_dashboard->setSensorString4(list[1]);
            break;
        case 804:
            m_dashboard->setSensorString5(list[1]);
            break;
        case 805:
            m_dashboard->setSensorString6(list[1]);
            break;
        case 806:
            m_dashboard->setSensorString7(list[1]);
            break;
        case 807:
            m_dashboard->setSensorString8(list[1]);
            break;
        case 808:
            m_dashboard->setFlagString1(list[1]);
            break;
        case 809:
            m_dashboard->setFlagString2(list[1]);
            break;
        case 810:
            m_dashboard->setFlagString3(list[1]);
            break;
        case 811:
            m_dashboard->setFlagString4(list[1]);
            break;
        case 812:
            m_dashboard->setFlagString5(list[1]);
            break;
        case 813:
            m_dashboard->setFlagString6(list[1]);
            break;
        case 814:
            m_dashboard->setFlagString7(list[1]);
            break;
        case 815:
            m_dashboard->setFlagString8(list[1]);
            break;
        case 816:
            m_dashboard->setFlagString9(list[1]);
            break;
        case 817:
            m_dashboard->setFlagString10(list[1]);
            break;
        case 818:
            m_dashboard->setFlagString11(list[1]);
            break;
        case 819:
            m_dashboard->setFlagString12(list[1]);
            break;
        case 820:
            m_dashboard->setFlagString13(list[1]);
            break;
        case 821:
            m_dashboard->setFlagString14(list[1]);
            break;
        case 822:
            m_dashboard->setFlagString15(list[1]);
            break;
        case 823:
            m_dashboard->setFlagString16(list[1]);
            break;
        case 824:
            //m_dashboard->setModel(list[1]);
            break;
        case 825:
            m_dashboard->setError(list[1]);
            break;
        case 999:
            break;
        default:
            break;
        }
//            dataPartStr = strtok(NULL,"/");
    }


}

void udpreceiver::processCoreEFIUpdate(const QString & line)
{


    QString raw = line;
//        qDebug()<<raw;
    if (raw.isEmpty())
    {raw ="0,0";}
//        QString dataPartStr = strtok(NULL,"~");
    if (raw.startsWith("GPS"))
    {
        QStringList list = raw.split( "~" );
        if (list.size() > 1){
            processGPRMC(list[1]);
        }
    } else if (raw.startsWith("FULL"))
    {
        QStringList list = raw.split( "~" );
        if (list.size() > 1){
            processGPRMC(list[1]);
        }
    } else if (raw.startsWith("NEWDASH"))
    {
        QStringList list = raw.split( "~" );
        if (list.size() > 1){
            m_dashboard->setNewDashFile(raw);
        }
    }else {

//        while(dataPartStr!=NULL)
//        {
        QStringList list = raw.split( " " );
        qreal map = list[4].toDouble();
        qreal baro = list[40].toDouble();

        qreal map_bar      = { (map - baro) / 101.33 };
        qreal map_psi      = { (map - baro) * 0.145038 };
        qreal map_inhg     = { (baro - map) * 0.2953007 } ;
        qreal map_vacboost = { map < baro ? -map_inhg : map_psi };

        qreal coolantRaw = list[7].toDouble();
        qreal coolant = coolantRaw - 40;
        qreal iatRaw = list[6].toDouble();
        qreal iat = iatRaw - 40;
        qreal fueltempRaw = list[114].toDouble();
        qreal fueltemp = fueltempRaw - 40;
        qreal afr = list[10].toDouble();
        qreal stoich = 14.7;
        qreal afrTarget = list[21].toDouble();
        qreal lambda           =  afr / stoich ;
        qreal lambdaTarget     =  afrTarget / stoich ;
        qreal fuelpressureRaw = list[105].toDouble();
        qreal fuelpressure = fuelpressureRaw * 0.06894;
        qreal oilpressureRaw = list[105].toDouble();
        qreal oilpressure = oilpressureRaw * 0.06894;

        m_dashboard->setAFR(list[10].toDouble());
        m_dashboard->setBoostDuty(list[30].toDouble());
        m_dashboard->setBoostPres(map_bar);
        m_dashboard->setDwell(list[89].toDouble());
        m_dashboard->setexcamangle1(list[93].toDouble());
        m_dashboard->setexcamangle2(list[109].toDouble());

        m_dashboard->setFuelPress(fuelpressure);
        m_dashboard->setFueltemp(fueltemp);
        m_dashboard->setIntaketemp(iat);
        m_dashboard->setLAMBDA(lambda);
        m_dashboard->setLAMBDATarget(lambdaTarget);
        m_dashboard->setMAP(list[4].toDouble());
        m_dashboard->setoilpres(oilpressure);
        m_dashboard->setrpm(list[14].toDouble());
        m_dashboard->setSpeed(list[14].toDouble()/10);
        m_dashboard->setTPS(list[24].toDouble());
        m_dashboard->setWatertemp(coolant);
        m_dashboard->setBatteryV(list[9].toDouble());
        m_dashboard->setIntakepress(map_bar);



        // fehrenheit
//        coolant = coolant * 1.8 +32;
//        iat = iat * 1.8 +32;
//        fueltemp = fueltemp * 1.8 +32;


//        m_dashboard->setaccelpedpos(Value);
//        m_dashboard->setAccelTimer(Value);
//        m_dashboard->setaccelx(Value);
//        m_dashboard->setaccely(Value);
//        m_dashboard->setaccelz(Value);
//        m_dashboard->setairtempensor2(list[10].toDouble());
//        m_dashboard->setambipress(Value);
//        m_dashboard->setambitemp(Value);
//        m_dashboard->setantilaglauchswitch(Value);
//        m_dashboard->setantilaglaunchon(Value);
//        m_dashboard->setauxcalc1(Value);
//        m_dashboard->setauxcalc2(Value);
//        m_dashboard->setauxcalc3(Value);
//        m_dashboard->setauxcalc4(Value);
//        m_dashboard->setauxrevlimitswitch(Value);
//        m_dashboard->setAUXT(Value);
//        m_dashboard->setavfueleconomy(Value);
//        m_dashboard->setbattlight(Value);
//        m_dashboard->setboostcontrol(Value);
//        m_dashboard->setBoosttp(Value);
//        m_dashboard->setBoostwg(Value);
        //m_dashboard->setbrakepedalstate(Value);
//        m_dashboard->setbrakepress(Value);
//        m_dashboard->setclutchswitchstate(Value);
//        m_dashboard->setcompass(Value);
//        m_dashboard->setcoolantpress(Value);
//        m_dashboard->setdecelcut(Value);
//        m_dashboard->setdiffoiltemp(Value);
//        m_dashboard->setdistancetoempty(Value);
//        m_dashboard->setegt1(list[].toDouble());
//        m_dashboard->setegt2(list[].toDouble());
//        m_dashboard->setegt3(list[].toDouble());
//        m_dashboard->setegt4(list[].toDouble());
//        m_dashboard->setegt5(list[].toDouble());
//        m_dashboard->setegt6(list[].toDouble());
//        m_dashboard->setegt7(list[].toDouble());
//        m_dashboard->setegt8(list[].toDouble());
//        m_dashboard->setegt9(list[].toDouble());
//        m_dashboard->setegt10(list[].toDouble());
//        m_dashboard->setegt11(list[].toDouble());
//        m_dashboard->setegt12(list[].toDouble());
//        m_dashboard->setEngLoad(list[].toDouble());
//        m_dashboard->setFlag1(list[].toDouble());
//        m_dashboard->setFlag2(list[].toDouble());
//        m_dashboard->setFlag3(list[].toDouble());
//        m_dashboard->setFlag4(list[].toDouble());
//        m_dashboard->setFlag5(list[].toDouble());
//        m_dashboard->setFlag6(list[].toDouble());
//        m_dashboard->setFlag7(list[].toDouble());
//        m_dashboard->setFlag8(list[].toDouble());
//        m_dashboard->setFlag9(list[].toDouble());
//        m_dashboard->setFlag10(list[].toDouble());
//        m_dashboard->setFlag11(list[].toDouble());
//        m_dashboard->setFlag12(list[].toDouble());
//        m_dashboard->setFlag13(list[].toDouble());
//        m_dashboard->setFlag14(list[].toDouble());
//        m_dashboard->setFlag15(list[].toDouble());
//        m_dashboard->setFlag16(list[].toDouble());
//        m_dashboard->setFlag17(list[].toDouble());
//        m_dashboard->setFlag18(list[].toDouble());
//        m_dashboard->setFlag19(list[].toDouble());
//        m_dashboard->setFlag20(list[].toDouble());
//        m_dashboard->setFlag21(list[].toDouble());
//        m_dashboard->setFlag22(list[].toDouble());
//        m_dashboard->setFlag23(list[].toDouble());
//        m_dashboard->setFlag24(list[].toDouble());
//        m_dashboard->setFlag25(list[].toDouble());
        // Ignition Angle Bank 1
        //Ignition Angle Bank 2
        //Torque Management Driveshaft RPM Target
        //Torque Management Driveshaft RPM Target Error
        //Torque Management Driveshaft RPM Target Error Ignition Correction
        //Torque Management Driveshaft RPM Timed Ignition Correction
        //Torque Management Combined Ignition Correction
//        m_dashboard->setflatshiftstate(list[].toDouble());
//        m_dashboard->setFuelc(list[].toDouble());
//        m_dashboard->setfuelclevel(list[].toDouble());
//        m_dashboard->setfuelcomposition(list[].toDouble());
//        m_dashboard->setfuelconsrate(list[].toDouble());
//        m_dashboard->setfuelcutperc(list[].toDouble());
//        m_dashboard->setfuelflow(list[].toDouble());
//        m_dashboard->setfuelflowdiff(list[].toDouble());
//        m_dashboard->setfuelflowret(list[].toDouble());
//        m_dashboard->setfueltrimlongtbank1(list[].toDouble());
//        m_dashboard->setfueltrimlongtbank2(list[].toDouble());
//        m_dashboard->setfueltrimshorttbank1(list[].toDouble());
//        m_dashboard->setfueltrimshorttbank2(list[].toDouble());
//        m_dashboard->setGear(list[].toDouble());
//        m_dashboard->setgearswitch(list[].toDouble());
        //            m_dashboard->setgpsAltitude(list[].toDouble());
        //-25.809581, 28.112241
        // m_dashboard->setgpsLatitude(QString::number(-25.809581));
        // m_dashboard->setgpsLongitude(QString::number(28.112241));
        //processGPRMC(list[].toDouble());
        //m_dashboard->setgpsLongitude(list[].toDouble());
        //m_dashboard->setgpsSpeed(list[].toDouble());
        //m_dashboard->setgpsTime(list[].toDouble());
        //            m_dashboard->setgpsVisibleSatelites(list[].toDouble());
//        m_dashboard->setgyrox(list[].toDouble());
//        m_dashboard->setgyroy(list[].toDouble());
//        m_dashboard->setgyroz(list[].toDouble());
//        m_dashboard->sethandbrake(list[].toDouble());
//        m_dashboard->sethighbeam(list[].toDouble());
//        m_dashboard->sethomeccounter(list[].toDouble());
//        m_dashboard->setIdleValue(list[].toDouble());
//        m_dashboard->setIgn(list[].toDouble());
//        m_dashboard->setIgn1(list[].toDouble());
//        m_dashboard->setIgn2(list[].toDouble());
//        m_dashboard->setIgn3(list[].toDouble());
//        m_dashboard->setIgn4(list[].toDouble());
//        m_dashboard->setincamangle1(list[].toDouble());
//        m_dashboard->setincamangle2(list[].toDouble());
//        m_dashboard->setInj(list[].toDouble());
//        m_dashboard->setInj1(list[].toDouble());
//        m_dashboard->setInj2(list[].toDouble());
//        m_dashboard->setInj3(list[].toDouble());
//        m_dashboard->setInj4(list[].toDouble());
//        m_dashboard->setInjDuty(list[].toDouble());
//        m_dashboard->setinjms(list[].toDouble());
//        m_dashboard->setIscvduty(list[].toDouble());
//        m_dashboard->setKnock(list[].toDouble());
//        m_dashboard->setknocklevlogged1(list[].toDouble());
//        m_dashboard->setknocklevlogged2(list[].toDouble());
//        m_dashboard->setknockretardbank1(list[].toDouble());
//        m_dashboard->setknockretardbank2(list[].toDouble());
//        m_dashboard->setlambda2(list[].toDouble());
//        m_dashboard->setlambda3(list[].toDouble());
//        m_dashboard->setlambda4(list[].toDouble());
//        m_dashboard->setlaunchcontolfuelenrich(list[].toDouble());
//        m_dashboard->setlaunchctrolignretard(list[].toDouble());
//        m_dashboard->setLeadingign(list[].toDouble());
//        m_dashboard->setleftindicator(list[].toDouble());
//        m_dashboard->setlimpmode(list[].toDouble());
//        m_dashboard->setMAF1V(list[].toDouble());
//        m_dashboard->setMAF2V(list[].toDouble());
//        m_dashboard->setMAFactivity(list[].toDouble());
        //            m_dashboard->setAFR(MAP2(list[].toDouble());
//        m_dashboard->setmil(list[].toDouble());
//        m_dashboard->setmissccount(list[].toDouble());
//        m_dashboard->setMoilp(list[].toDouble());
//        m_dashboard->setMVSS(list[].toDouble());
//        m_dashboard->setna1(list[].toDouble());
//        m_dashboard->setna2(list[].toDouble());
//        m_dashboard->setnosactive(list[].toDouble());
//        m_dashboard->setnospress(list[].toDouble());
//        m_dashboard->setnosswitch(list[].toDouble());
//        m_dashboard->setO2volt(list[].toDouble());
//        m_dashboard->setO2volt_2(list[].toDouble());
//        m_dashboard->setOdo(list[].toDouble());
//        m_dashboard->setoiltemp(list[].toDouble());
//        m_dashboard->setpim(list[].toDouble());
        //            m_dashboard->setPlatform(list[].toDouble());
//        m_dashboard->setPower(list[].toDouble());
//        m_dashboard->setPressureV(list[].toDouble());
//        m_dashboard->setPrimaryinp(list[].toDouble());
//        m_dashboard->setrallyantilagswitch(list[].toDouble());
        //            m_dashboard->setRecvData(list[].toDouble());
//        m_dashboard->setrightindicator(list[].toDouble());
        //            m_dashboard->setRunStat(list[].toDouble());
//        m_dashboard->setSecinjpulse(list[].toDouble());
//        m_dashboard->setsens1(list[].toDouble());
//        m_dashboard->setsens2(list[].toDouble());
//        m_dashboard->setsens3(list[].toDouble());
//        m_dashboard->setsens4(list[].toDouble());
//        m_dashboard->setsens5(list[].toDouble());
//        m_dashboard->setsens6(list[].toDouble());
//        m_dashboard->setsens7(list[].toDouble());
//        m_dashboard->setsens8(list[].toDouble());
        //Generic Output 1 Duty Cycl
        //Fuel Level
        //Turbo Timer - Time Remaining
        //Turbo Timer - Engine Time Remaining
        //Steering Wheel Angle
        //Driveshaft RPM
        //NOS Pressure Sensor 2
        //NOS Pressure Sensor 3
        //NOS Pressure Sensor 4
//        if (m_dashboard->ExternalSpeed() == 0 )
//        {
//            m_dashboard->setSpeed(list[].toDouble());
//        }
//        m_dashboard->setSVSS(list[].toDouble());
//        m_dashboard->settargetbstlelkpa(list[].toDouble());
//        m_dashboard->setThrottleV(list[].toDouble());
//        m_dashboard->settimeddutyout1(list[].toDouble());
//        m_dashboard->settimeddutyout2(list[].toDouble());
//        m_dashboard->settimeddutyoutputactive(list[].toDouble());
        //           m_dashboard->setTimeoutStat(list[].toDouble());
//        m_dashboard->setTorque(list[].toDouble());
//        m_dashboard->settorqueredcutactive(list[].toDouble());
//        m_dashboard->settorqueredlevelactive(list[].toDouble());
//        m_dashboard->setTrailingign(list[].toDouble());
//        m_dashboard->settransientthroactive(list[].toDouble());
//        m_dashboard->settransoiltemp(list[].toDouble());
//        m_dashboard->settriggerccounter(list[].toDouble());
//        m_dashboard->settriggersrsinceasthome(list[].toDouble());
//        m_dashboard->setTRIM(list[].toDouble());
//        m_dashboard->setTrip(list[].toDouble());
//        m_dashboard->setturborpm(list[].toDouble());
//        m_dashboard->setecu(list[].toDouble());
//        m_dashboard->setwastegatepress(list[].toDouble());
//        m_dashboard->setwheeldiff(list[].toDouble());
//        m_dashboard->setwheelslip(list[].toDouble());
//        m_dashboard->setwheelspdftleft(list[].toDouble());
//        m_dashboard->setwheelspdftright(list[].toDouble());
//        m_dashboard->setwheelspdrearleft(list[].toDouble());
//        m_dashboard->setwheelspdrearright(list[].toDouble());
        //not yet implemented
        //CAS REF
        //AAC Valve
        //Turbo Speed Sensor 2
        //Generic Sensor 1
        //Generic Sensor 2
        //Generic Sensor 3
        //Generic Sensor 4
        //Generic Sensor 5
        //Generic Sensor 6
        //Generic Sensor 7
        //Generic Sensor 8
        //Generic Sensor 9
        //Generic Sensor 10
        //Gearbox Oil Pressure
        //Injection Stage 3 Duty Cycle
        //MAP N
        //MAP P
//        m_dashboard->setInjDuty2(list[].toDouble());
//        m_dashboard->setInjAngle(list[].toDouble());
        //Catalyst Temp Bank1 S1
        //Manifold Gauge Pressure kPa
        //
        //
        //
//        m_dashboard->setSensorString1(list[1]);
//        m_dashboard->setSensorString2(list[1]);
//        m_dashboard->setSensorString3(list[1]);
//        m_dashboard->setSensorString4(list[1]);
//        m_dashboard->setSensorString5(list[1]);
//        m_dashboard->setSensorString6(list[1]);
//        m_dashboard->setSensorString7(list[1]);
//        m_dashboard->setSensorString8(list[1]);
//        m_dashboard->setFlagString1(list[1]);
//        m_dashboard->setFlagString2(list[1]);
//        m_dashboard->setFlagString3(list[1]);
//        m_dashboard->setFlagString4(list[1]);
//        m_dashboard->setFlagString5(list[1]);
//        m_dashboard->setFlagString6(list[1]);
//        m_dashboard->setFlagString7(list[1]);
//        m_dashboard->setFlagString8(list[1]);
//        m_dashboard->setFlagString9(list[1]);
//        m_dashboard->setFlagString10(list[1]);
//        m_dashboard->setFlagString11(list[1]);
//        m_dashboard->setFlagString12(list[1]);
//        m_dashboard->setFlagString13(list[1]);
//        m_dashboard->setFlagString14(list[1]);
//        m_dashboard->setFlagString15(list[1]);
//        m_dashboard->setFlagString16(list[1]);
        //m_dashboard->setModel(list[1]);
//        m_dashboard->setError(list[1]);
//            dataPartStr = strtok(NULL,"/");
    }


}
