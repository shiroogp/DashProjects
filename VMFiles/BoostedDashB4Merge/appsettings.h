#ifndef APPSETTINGS_H
#define APPSETTINGS_H

#include <QObject>

class AppSettings : public QObject
{
    Q_OBJECT
public:
    explicit AppSettings(QObject *parent = 0);

    Q_INVOKABLE int getBaudRate();
    Q_INVOKABLE void setBaudRate(const int &arg);

    Q_INVOKABLE int getParity();
    Q_INVOKABLE void setParity(const int &arg);

    Q_INVOKABLE int getDataBits();
    Q_INVOKABLE void setDataBits(const int &arg);

    Q_INVOKABLE int getStopBits();
    Q_INVOKABLE void setStopBits(const int &arg);

    Q_INVOKABLE int getFlowControl();
    Q_INVOKABLE void setFlowControl(const int &arg);

    Q_INVOKABLE int getECU();
    Q_INVOKABLE void setECU(const int &arg);

    Q_INVOKABLE int getInterface();
    Q_INVOKABLE void setInterface(const int &arg);

    Q_INVOKABLE int getLogging();
    Q_INVOKABLE void setLogging(const int &arg);

    Q_INVOKABLE int getScreen1();
    Q_INVOKABLE void setScreen1(const int &arg);

    Q_INVOKABLE int getScreen2();
    Q_INVOKABLE void setScreen2(const int &arg);

    Q_INVOKABLE int getScreen3();
    Q_INVOKABLE void setScreen3(const int &arg);

    Q_INVOKABLE int getScreen4();
    Q_INVOKABLE void setScreen4(const int &arg);

    Q_INVOKABLE int getScreen5();
    Q_INVOKABLE void setScreen5(const int &arg);

    Q_INVOKABLE int getScreen6();
    Q_INVOKABLE void setScreen6(const int &arg);

    Q_INVOKABLE int getFile1();
    Q_INVOKABLE void setFile1(const int &arg);

    Q_INVOKABLE int getFile2();
    Q_INVOKABLE void setFile2(const int &arg);

    Q_INVOKABLE int getFile3();
    Q_INVOKABLE void setFile3(const int &arg);

    Q_INVOKABLE int getFile4();
    Q_INVOKABLE void setFile4(const int &arg);

    Q_INVOKABLE int getFile5();
    Q_INVOKABLE void setFile5(const int &arg);

    Q_INVOKABLE int getrpm1();
    Q_INVOKABLE void setrpm1(const int &arg);

    Q_INVOKABLE int getrpm2();
    Q_INVOKABLE void setrpm2(const int &arg);

    Q_INVOKABLE int getrpm3();
    Q_INVOKABLE void setrpm3(const int &arg);

    Q_INVOKABLE int getrpm4();
    Q_INVOKABLE void setrpm4(const int &arg);

    Q_INVOKABLE bool getautoconnect();
    Q_INVOKABLE void setautoconnect(const bool &arg);

private:
    void setValue(const QString &key, const QVariant &value);
    QVariant getValue(const QString &key);
};

#endif // APPSETTINGS_H
