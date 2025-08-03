/*
    LANShare - LAN file transfer.
    Copyright (C) 2016 Abdul Aris R. <abdularisrahmanudin10@gmail.com>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

#ifndef SETTINGS_H
#define SETTINGS_H

#include <QHostAddress>
#include <QString>

#include "model/device.h"


#if defined (Q_OS_WIN)
    #define OS_NAME "Windows"
#elif defined (Q_OS_OSX)
    #define OS_NAME "Mac OSX"
#elif defined (Q_OS_LINUX)
    #define OS_NAME "Linux"
#else
    #define OS_NAME "Unknown"
#endif

const QString PROGRAM_NAME{"LAN Share"};
const QString PROGRAM_DESC{"A simple program that let you transfer files over local area network (LAN) easily."};
constexpr int PROGRAM_X_VER{1};
constexpr int PROGRAM_Y_VER{2};
constexpr int PROGRAM_Z_VER{1};
const QString SETTINGS_FILE{"LANSConfig"};

class Settings
{
public:
    static Settings* instance() { return obj; }

    quint16 getBroadcastPort() const;
    quint16 getTransferPort() const;
    quint16 getBroadcastInterval() const;
    qint32 getFileBufferSize() const;
    QString getDownloadDir() const;

    Device getMyDevice() const;
    QString getDeviceId() const;
    QString getDeviceName() const;
    QHostAddress getDeviceAddress() const;
    bool getReplaceExistingFile() const;
    
    void setDeviceName(const QString& name);
    void setBroadcastPort(quint16 port);
    void setTransferPort(quint16 port);
    void setBroadcastInterval(quint16 interval);
    void setFileBufferSize(qint32 size);
    void setDownloadDir(const QString& dir);
    void setReplaceExistingFile(bool replace);

    void saveSettings();
    void reset();

private:
    Settings();
    void loadSettings();

    QString getDefaultDownloadPath();

    Device mThisDevice;
    quint16 mBCPort{0};
    quint16 mTransferPort{0};
    quint16 mBCInterval{0};
    qint32 mFileBuffSize{0};
    QString mDownloadDir;
    bool mReplaceExistingFile{false};

    static Settings* obj;
};

#endif // SETTINGS_H
