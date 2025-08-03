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

#include <QDBusPendingReply>

#include "bluetoothdevice.h"
#include "asyncagent.h"

AsyncAgent::AsyncAgent(QString path, QObject *parent)
    : BluetoothBaseAgent(path, parent)
    , m_deviceToPair(0)
    , m_connection(QDBusConnection::systemBus())
    , m_pendingAction(InvalidAction)
    , m_confirmationRequestPasskey(0)
    , m_displayPasskey(0)
{
}

void AsyncAgent::authorize(OrgBluezDeviceInterface &device, QString uuid)
{
    qDebug() << Q_FUNC_INFO;
    m_pendingAction = AuthorizeAction;
    m_requestAuthorizeUuid = uuid;
    initializeDelayedReply(QDBusObjectPath(device.path()));
}

void AsyncAgent::displayPasskey(OrgBluezDeviceInterface &device, uint passkey)
{
    qDebug() << Q_FUNC_INFO;
    m_pendingAction = DisplayPasskeyAction;
    m_displayPasskey = passkey;
    initializeDelayedReply(QDBusObjectPath(device.path()));
}

void AsyncAgent::requestConfirmation(OrgBluezDeviceInterface &device, uint key)
{
    qDebug() << Q_FUNC_INFO;
    m_pendingAction = RequestConfirmationAction;
    m_confirmationRequestPasskey = key;
    initializeDelayedReply(QDBusObjectPath(device.path()));
}

uint AsyncAgent::requestPasskey(OrgBluezDeviceInterface &device)
{
    qDebug() << Q_FUNC_INFO;
    m_pendingAction = RequestPasskeyAction;
    initializeDelayedReply(QDBusObjectPath(device.path()));
    return 0;
}

QString AsyncAgent::requestPidCode(OrgBluezDeviceInterface &device)
{
    qDebug() << Q_FUNC_INFO;
    m_pendingAction = RequestPidCodeAction;
    initializeDelayedReply(QDBusObjectPath(device.path()));
    return QString();
}

void AsyncAgent::release()
{
    qDebug() << Q_FUNC_INFO;
    QMetaObject::invokeMethod(parent(), "release", Qt::QueuedConnection);
}

void AsyncAgent::replyRequestConfirmation(bool confirmed)
{
    if (!confirmed) {
        QDBusMessage reply = m_pendingMessage.createErrorReply("org.bluez.Error.Rejected", "The request was rejected");
        m_connection.send(reply);
    } else {
        QDBusMessage reply = m_pendingMessage.createReply();
        m_connection.send(reply);
    }
}

void AsyncAgent::replyPasskey(uint passkey)
{
    QDBusMessage reply = m_pendingMessage.createReply(passkey);
    m_connection.send(reply);
}

void AsyncAgent::replyRequestPidCode(QString pidCode)
{
    QDBusMessage reply = m_pendingMessage.createReply(pidCode);
    m_connection.send(reply);
}

void AsyncAgent::replyRequestAuthorization(bool authorize)
{
    if (authorize) {
        QDBusMessage reply = m_pendingMessage.createReply();
        m_connection.send(reply);
    } else {
        QDBusMessage reply = m_pendingMessage.createErrorReply("org.bluez.Error.Rejected", "Device not authorized");
        m_connection.send(reply);
    }
}

void AsyncAgent::devicePropertiesChanged()
{
    QObject::disconnect(m_deviceToPair, SIGNAL(devicePropertiesChanged()), this, SLOT(devicePropertiesChanged()));

    switch (m_pendingAction) {
    case InvalidAction:
        qWarning() << Q_FUNC_INFO << "called with invalid action";
        break;
    case AuthorizeAction:
        notifyAuthorizeRequest();
        break;
    case RequestConfirmationAction:
        notifyConfirmationRequest();
        break;
    case RequestPasskeyAction:
        notifyPasskeyRequest();
        break;
    case RequestPidCodeAction:
        notifyPidCodeRequest();
        break;
    case DisplayPasskeyAction:
        notifyPasskeyDisplay();
        break;
    }
    m_pendingAction = InvalidAction;
}

void AsyncAgent::initializeDelayedReply(const QDBusObjectPath &path)
{
    setDelayedReply(true);
    m_pendingMessage = message();
    m_connection = connection();

    delete m_deviceToPair;
    m_deviceToPair = new BluetoothDevice(path, this);
    QObject::connect(m_deviceToPair, SIGNAL(devicePropertiesChanged()), this, SLOT(devicePropertiesChanged()));
}

void AsyncAgent::notifyAuthorizeRequest()
{
    if (!m_deviceToPair->paired()) {
        QDBusMessage reply = m_pendingMessage.createErrorReply("org.bluez.Error.Rejected", "Remote device is not paired");
        m_connection.send(reply);
        return;
    }
    if (m_deviceToPair->trusted()) {
        QDBusMessage reply = m_pendingMessage.createReply();
        QDBusConnection::systemBus().send(reply);
    } else {
        QMetaObject::invokeMethod(parent(),
                                  "requestAuthorization",
                                  Qt::QueuedConnection,
                                  Q_ARG(QString, m_deviceToPair->address()),
                                  Q_ARG(uint, uint(m_deviceToPair->classOfDevice())),
                                  Q_ARG(QString, m_deviceToPair->alias()),
                                  Q_ARG(QString, m_requestAuthorizeUuid));
    }
}

void AsyncAgent::notifyConfirmationRequest()
{
    QMetaObject::invokeMethod(parent(),
                              "requestConfirmation",
                              Qt::QueuedConnection,
                              Q_ARG(QString, m_deviceToPair->address()),
                              Q_ARG(uint, uint(m_deviceToPair->classOfDevice())),
                              Q_ARG(QString, m_deviceToPair->alias()),
                              Q_ARG(uint, m_confirmationRequestPasskey));
}

void AsyncAgent::notifyPasskeyRequest()
{
    QMetaObject::invokeMethod(parent(),
                              "requestPasskey",
                              Qt::QueuedConnection,
                              Q_ARG(QString, m_deviceToPair->address()),
                              Q_ARG(uint, uint(m_deviceToPair->classOfDevice())),
                              Q_ARG(QString, m_deviceToPair->alias()));
}

void AsyncAgent::notifyPidCodeRequest()
{
    QMetaObject::invokeMethod(parent(),
                              "requestPidCode",
                              Qt::QueuedConnection,
                              Q_ARG(QString, m_deviceToPair->address()),
                              Q_ARG(uint, uint(m_deviceToPair->classOfDevice())),
                              Q_ARG(QString, m_deviceToPair->alias()));
}

void AsyncAgent::notifyPasskeyDisplay()
{
    QMetaObject::invokeMethod(parent(),
                              "displayPasskey",
                              Qt::QueuedConnection,
                              Q_ARG(QString, m_deviceToPair->address()),
                              Q_ARG(uint, uint(m_deviceToPair->classOfDevice())),
                              Q_ARG(QString, m_deviceToPair->alias()),
                              Q_ARG(uint, m_displayPasskey));
}
