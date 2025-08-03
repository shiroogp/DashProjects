/*  -*- Mode: C++ -*-
 *
 * meego handset bluetooth
 * Copyright © 2010, Intel Corporation.
 *
 * This program is licensed under the terms and conditions of the
 * Apache License, version 2.0.  The full text of the Apache License is at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 */

#ifndef ASYNCAGENT_H
#define ASYNCAGENT_H

#include "bluetoothbaseagent.h"

class BluetoothDevice;
class QDBusObjectPath;

class AsyncAgent : public BluetoothBaseAgent
{
    Q_OBJECT
public:
    explicit AsyncAgent(QString path, QObject *parent = 0);

    BluetoothDevice* device() { return m_deviceToPair; }

    void authorize(OrgBluezDeviceInterface &device, QString uuid);
    void displayPasskey(OrgBluezDeviceInterface &device, uint passkey);
    void requestConfirmation(OrgBluezDeviceInterface &device, uint key);
    uint requestPasskey(OrgBluezDeviceInterface &device);
    QString requestPidCode(OrgBluezDeviceInterface &device);
    void release();

public slots:
    void replyRequestConfirmation(bool confirmed);
    void replyPasskey(uint passkey);
    void replyRequestPidCode(QString pidCode);
    void replyRequestAuthorization(bool authorize);

private slots:
    void devicePropertiesChanged();

private:
    enum Action {
        InvalidAction,
        AuthorizeAction,
        RequestConfirmationAction,
        RequestPasskeyAction,
        RequestPidCodeAction,
        DisplayPasskeyAction
    };

    void initializeDelayedReply(const QDBusObjectPath &path);
    void notifyAuthorizeRequest();
    void notifyConfirmationRequest();
    void notifyPasskeyRequest();
    void notifyPidCodeRequest();
    void notifyPasskeyDisplay();

    BluetoothDevice* m_deviceToPair;
    QDBusMessage m_pendingMessage;
    QDBusConnection m_connection;
    Action m_pendingAction;
    QString m_requestAuthorizeUuid;
    uint m_confirmationRequestPasskey;
    uint m_displayPasskey;
};

#endif // ASYNCAGENT_H
