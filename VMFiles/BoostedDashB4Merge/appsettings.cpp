#include <QApplication>
#include "appsettings.h"
#include <QSettings>
#include <QDebug>
#include <QStandardPaths>


AppSettings::AppSettings(QObject *parent) : QObject(parent)
{

}

int AppSettings::getBaudRate()
{
    return getValue("serial/baudrate").toInt();
}

void AppSettings::setBaudRate(const int &arg)
{
    setValue("serial/baudrate", arg);
}

int AppSettings::getParity()
{
    return getValue("serial/parity").toInt();
}

void AppSettings::setParity(const int &arg)
{
    setValue("serial/parity", arg);
}

int AppSettings::getDataBits()
{
    return getValue("serial/databits").toInt();
}

void AppSettings::setDataBits(const int &arg)
{
    setValue("serial/databits", arg);
}

int AppSettings::getStopBits()
{
    return getValue("serial/stopbits").toInt();
}

void AppSettings::setStopBits(const int &arg)
{
    setValue("serial/stopbits", arg);
}

int AppSettings::getFlowControl()
{
    return getValue("serial/flowcontrol").toInt();
}

void AppSettings::setFlowControl(const int &arg)
{
    setValue("serial/flowcontrol", arg);
}

int AppSettings::getECU()
{
    return getValue("serial/ECU").toInt();

}

void AppSettings::setECU(const int &arg)
{
    setValue("serial/ECU", arg);
}

int AppSettings::getInterface()
{
    return getValue("serial/Interface").toInt();

}

void AppSettings::setInterface(const int &arg)
{
    setValue("serial/Interface", arg);
}

int AppSettings::getLogging()
{
    return getValue("serial/Logging").toInt();

}

void AppSettings::setLogging(const int &arg)
{
    setValue("serial/Logging", arg);
}

void AppSettings::setValue(const QString &key, const QVariant &value)
{
//    QSettings settings("Boosted Garage", "BoostedDash", this);
    QCoreApplication::setOrganizationName("Boosted Garage");
    QCoreApplication::setApplicationName("BoostedDash");
    QString m_sSettingsFile = QStandardPaths::writableLocation(QStandardPaths::AppDataLocation) + "/demosettings.ini";
    QSettings settings(m_sSettingsFile, QSettings::NativeFormat);
//    QSettings settings;
    settings.setValue(key, value);
    settings.sync();
}

QVariant AppSettings::getValue(const QString &key)
{
//    QSettings settings("Boosted Garage", "BoostedDash", this);
    QCoreApplication::setOrganizationName("Boosted Garage");
    QCoreApplication::setApplicationName("BoostedDash");
    QString m_sSettingsFile = QStandardPaths::writableLocation(QStandardPaths::AppDataLocation) + "/demosettings.ini";
    QSettings settings(m_sSettingsFile, QSettings::NativeFormat);
//    QSettings settings;
    return settings.value(key);
}


int AppSettings::getScreen1()
{
    return getValue("screen/screen1").toInt();

}

void AppSettings::setScreen1(const int &arg)
{
    setValue("screen/screen1", arg);
}

int AppSettings::getScreen2()
{
    return getValue("screen/screen2").toInt();

}

void AppSettings::setScreen2(const int &arg)
{
    setValue("screen/screen2", arg);
}

int AppSettings::getScreen3()
{
    return getValue("screen/screen3").toInt();

}

void AppSettings::setScreen3(const int &arg)
{
    setValue("screen/screen3", arg);
}

int AppSettings::getScreen4()
{
    return getValue("screen/screen4").toInt();

}

void AppSettings::setScreen4(const int &arg)
{
    setValue("screen/screen4", arg);
}

int AppSettings::getScreen5()
{
    return getValue("screen/screen5").toInt();

}

void AppSettings::setScreen5(const int &arg)
{
    setValue("screen/screen5", arg);
}

int AppSettings::getScreen6()
{
    return getValue("screen/screen6").toInt();

}

void AppSettings::setScreen6(const int &arg)
{
    setValue("screen/screen6", arg);
}

int AppSettings::getFile1()
{
    return getValue("screen/file1").toInt();

}

void AppSettings::setFile1(const int &arg)
{
    setValue("screen/file1", arg);
}

int AppSettings::getFile2()
{
    return getValue("screen/file2").toInt();

}

void AppSettings::setFile2(const int &arg)
{
    setValue("screen/file2", arg);
}

int AppSettings::getFile3()
{
    return getValue("screen/file3").toInt();

}

void AppSettings::setFile3(const int &arg)
{
    setValue("screen/file3", arg);
}

int AppSettings::getFile4()
{
    return getValue("screen/file4").toInt();

}

void AppSettings::setFile4(const int &arg)
{
    setValue("screen/file4", arg);
}

int AppSettings::getFile5()
{
    return getValue("screen/file5").toInt();

}

void AppSettings::setFile5(const int &arg)
{
    setValue("screen/file5", arg);
}

int AppSettings::getrpm1()
{
    return getValue("screen/rpm1").toInt();

}

void AppSettings::setrpm1(const int &arg)
{
    setValue("screen/rpm1", arg);
}

int AppSettings::getrpm2()
{
    return getValue("screen/rpm2").toInt();

}

void AppSettings::setrpm2(const int &arg)
{
    setValue("screen/rpm2", arg);
}

int AppSettings::getrpm3()
{
    return getValue("screen/rpm3").toInt();

}

void AppSettings::setrpm3(const int &arg)
{
    setValue("screen/rpm3", arg);
}

int AppSettings::getrpm4()
{
    return getValue("screen/rpm4").toInt();

}

void AppSettings::setrpm4(const int &arg)
{
    setValue("screen/rpm4", arg);
}

bool AppSettings::getautoconnect()
{
    return getValue("defaults/autoconnect").toBool();

}

void AppSettings::setautoconnect(const bool &arg)
{
    setValue("defaults/autoconnect", arg);
}
