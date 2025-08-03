#ifndef UDPRECEIVER_H
#define UDPRECEIVER_H

#include <QObject>
class udpreceiver;
class QUdpSocket;
class DashBoard;
class Connect;

class udpreceiver : public QObject
{
    Q_OBJECT

public:
    explicit udpreceiver(QObject *parent = 0);
     explicit udpreceiver(DashBoard *dashboard, QObject *parent = 0);

private:
    DashBoard *m_dashboard;
    Connect *m_connect;
     QUdpSocket *udpSocket = nullptr;
     int         m_units;
     QString convertToDecimal(const QString & coord, const QString & dir);
     void processGPRMC(const QString &line);
     void processFullUpdate(const QString & line);
     void processCoreEFIUpdate(const QString & line);
public slots:
     void processPendingDatagrams();
     void startreceiver();
     void broadcastFile(const QString &dashfile);
     void closeConnection();
signals:


};


#endif // UDPRECEIVER_H
