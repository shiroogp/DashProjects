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



#ifndef BLUETOOTHAGENTADAPTOR_H
#define BLUETOOTHAGENTADAPTOR_H

#include <QDBusAbstractAdaptor>
#include "bluetoothbaseagent.h"

class BluetoothAgentAdaptor : public QDBusAbstractAdaptor
{
Q_OBJECT
Q_CLASSINFO("D-Bus Interface", "org.bluez.Agent");
public:
    BluetoothAgentAdaptor(BluetoothBaseAgent *parent = NULL);
    virtual ~BluetoothAgentAdaptor();

signals:

public slots:
	void Authorize(const QDBusObjectPath &device, const QString &uuid);
	void Cancel();
	void ConfirmModeChange(const QString &mode);
	void DisplayPasskey(const QDBusObjectPath &device, uint passkey);   // 'entered' arg is not actually provided in BlueZ 4.x
	void Release();
	void RequestConfirmation(const QDBusObjectPath &device, uint passkey);
	uint RequestPasskey(const QDBusObjectPath &device);
	QString RequestPinCode(const QDBusObjectPath &device);

private:
	BluetoothBaseAgent *agent;
};

#endif // BLUETOOTHAGENTADAPTOR_H
