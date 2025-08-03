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

#include "bluetoothdevice.h"
#include "bluedevice.h"
#include "audio.h"
#include "headset.h"
#include "input.h"

#include <QDBusPendingReply>
#include <QDBusPendingCallWatcher>

static const QLatin1String PropAddress("Address");
static const QLatin1String PropName("Name");
static const QLatin1String PropVendor("Vendor");
static const QLatin1String PropVendorSource("VendorSource");
static const QLatin1String PropProduct("Product");
static const QLatin1String PropVersion("Version");
static const QLatin1String PropIcon("Icon");
static const QLatin1String PropClassOfDevice("Class");
static const QLatin1String PropUuids("UUIDs");
static const QLatin1String PropServices("Services");
static const QLatin1String PropPaired("Paired");
static const QLatin1String PropConnected("Connected");
static const QLatin1String PropTrusted("Trusted");
static const QLatin1String PropBlocked("Blocked");
static const QLatin1String PropAlias("Alias");
static const QLatin1String PropNodes("Nodes");
static const QLatin1String PropAdapter("Adapter");
static const QLatin1String PropLegacyPairing("LegacyPairing");

static const QLatin1String AudioPropState("State");
static const QLatin1String AudioPropPlaying("Playing");
static const QLatin1String AudioPropStateConnecting("connecting");
static const QLatin1String AudioPropStateConnected("connected");
static const QLatin1String AudioPropStateDisconnecting("disconnecting");
static const QLatin1String AudioPropStateDisconnected("disconnected");

static const QLatin1String PropInputConnected("Connected");

BluetoothDevice::BluetoothDevice(QObject *parent)
    : QObject(parent)
{
    init();
}

BluetoothDevice::BluetoothDevice(const QDBusObjectPath &objectPath, QObject *parent)
    : QObject(parent)
    , m_objectPath(objectPath.path())
{
    init();
}

BluetoothDevice::~BluetoothDevice()
{
}

void BluetoothDevice::init()
{
    m_device = 0;
    m_audio = 0;
    m_headset = 0;
    m_input = 0;
    m_audioConnectionState = AudioStateUnknown;
    m_audioPlayingState = false;
    m_inputConnected = false;
    m_inputConnectedSet = false;
    m_ready = false;
    if (!m_objectPath.isEmpty()) {
        setPath(m_objectPath);
    }
}

bool BluetoothDevice::ready() const
{
    return m_ready;
}

QString BluetoothDevice::path() const
{
    return m_objectPath;
}

void BluetoothDevice::setPath(const QString &objectPath)
{
    delete m_device;
    m_device = 0;

    if (!objectPath.isEmpty()) {
        m_device = new OrgBluezDeviceInterface("org.bluez", objectPath, QDBusConnection::systemBus(), this);
        connect(m_device, SIGNAL(PropertyChanged(QString,QDBusVariant)),
                SLOT(propertyChanged(QString,QDBusVariant)));

        QDBusPendingReply<QVariantMap> getPropsResult = m_device->GetProperties();
        QDBusPendingCallWatcher *getPropsWatcher = new QDBusPendingCallWatcher(getPropsResult, this);
        connect(getPropsWatcher, SIGNAL(finished(QDBusPendingCallWatcher*)),
                SLOT(getPropertiesFinished(QDBusPendingCallWatcher*)));

        m_audio = new OrgBluezAudioInterface("org.bluez", m_objectPath, QDBusConnection::systemBus(), this);
        connect(m_audio, SIGNAL(PropertyChanged(QString,QDBusVariant)),
                SLOT(audioPropertyChanged(QString,QDBusVariant)));

        QDBusPendingReply<QVariantMap> getAudioPropsResult = m_audio->GetProperties();
        QDBusPendingCallWatcher *getAudioPropsWatcher = new QDBusPendingCallWatcher(getAudioPropsResult, this);
        connect(getAudioPropsWatcher, SIGNAL(finished(QDBusPendingCallWatcher*)),
                SLOT(getAudioPropertiesFinished(QDBusPendingCallWatcher*)));

        m_input = new OrgBluezInputInterface("org.bluez", m_objectPath, QDBusConnection::systemBus(), this);
        connect(m_input, SIGNAL(PropertyChanged(QString,QDBusVariant)),
                SLOT(inputPropertyChanged(QString,QDBusVariant)));
        updateInputConnectionState();
    }
}

BluetoothDevice::AudioConnectionState BluetoothDevice::audioConnectionState() const
{
    return m_audioConnectionState;
}

bool BluetoothDevice::audioPlayingState() const
{
    return m_audioPlayingState;
}

bool BluetoothDevice::inputConnected() const
{
    return m_inputConnected;
}

QString BluetoothDevice::address() const
{
    if (m_properties.contains(PropAddress))
        return m_properties[PropAddress].toString();
    return QString();
}

QString BluetoothDevice::name() const
{
    if (m_properties.contains(PropName))
        return m_properties[PropName].toString();
    return QString();
}

QString BluetoothDevice::icon() const
{
    if (m_properties.contains(PropIcon))
        return m_properties[PropIcon].toString();
    return QString();
}

quint32 BluetoothDevice::classOfDevice() const
{
    if (m_properties.contains(PropClassOfDevice))
        return (quint32)m_properties[PropClassOfDevice].toUInt();
    return 0;
}

QStringList BluetoothDevice::profiles() const
{
    if (m_properties.contains(PropUuids))
        return m_properties[PropUuids].toStringList();
    return QStringList();
}

bool BluetoothDevice::paired() const
{
    if (m_properties.contains(PropPaired))
        return m_properties[PropPaired].toBool();
    return false;
}

bool BluetoothDevice::connected() const
{
    if (m_properties.contains(PropConnected))
        return m_properties[PropConnected].toBool();
    return false;
}

bool BluetoothDevice::trusted() const
{
    if (m_properties.contains(PropTrusted))
        return m_properties[PropTrusted].toBool();
    return false;
}

void BluetoothDevice::setTrusted(bool trusted)
{
    if (trusted == this->trusted())
        return;

    if (m_device)
        m_device->SetProperty(PropTrusted, QDBusVariant(trusted));
}

QString BluetoothDevice::alias() const
{
    if (m_properties.contains(PropAlias))
        return m_properties[PropAlias].toString();
    return QString();
}

void BluetoothDevice::setAlias(const QString &alias)
{
    if (alias == this->alias())
        return;

    if (m_device)
        m_device->SetProperty(PropAlias, QDBusVariant(alias));
}

bool BluetoothDevice::legacyPairing() const
{
    if (m_properties.contains(PropLegacyPairing))
        return m_properties[PropLegacyPairing].toBool();
    return false;
}

void BluetoothDevice::connectAudio()
{
    if (m_audio) {
        m_audio->Connect();
    }
}

void BluetoothDevice::disconnectAudio()
{
    if (m_audio) {
        m_audio->Disconnect();
    }
}

void BluetoothDevice::connectInput()
{
    if (!m_input) {
        return;
    }
    QDBusPendingReply<> connectResult = m_input->Connect();
    QDBusPendingCallWatcher *connectWatcher = new QDBusPendingCallWatcher(connectResult, this);
    connect(connectWatcher, SIGNAL(finished(QDBusPendingCallWatcher*)),
            SLOT(inputConnectFinished(QDBusPendingCallWatcher*)));
}

void BluetoothDevice::disconnectInput()
{
    if (!m_input) {
        return;
    }
    QDBusPendingReply<> disconnectResult = m_input->Disconnect();
    QDBusPendingCallWatcher *disconnectWatcher = new QDBusPendingCallWatcher(disconnectResult, this);
    connect(disconnectWatcher, SIGNAL(finished(QDBusPendingCallWatcher*)),
            SLOT(inputDisconnectFinished(QDBusPendingCallWatcher*)));
}

void BluetoothDevice::disconnect()
{
    if (m_device) {
        m_device->Disconnect();
    }
}

bool BluetoothDevice::updateProperty(const QString &name, const QVariant &value)
{
    if (m_properties[name] == value)
        return false;

    bool propertyHandled = true;
    m_properties[name] = value;

    if (name == PropAddress) {
        emit addressChanged();
    } else if (name == PropName) {
        emit nameChanged();
    } else if (name == PropIcon) {
        emit iconChanged();
    } else if (name == PropClassOfDevice) {
        emit classOfDeviceChanged();
    } else if (name == PropUuids) {
        emit profilesChanged();
    } else if (name == PropPaired) {
        emit pairedChanged();
    } else if (name == PropConnected) {
        emit connectedChanged();
    } else if (name == PropTrusted) {
        emit trustedChanged();
    } else if (name == PropAlias) {
        emit aliasChanged();
    } else if (name == PropLegacyPairing) {
        emit legacyPairingChanged();
    } else if (name == PropVendor
               || name == PropVendorSource
               || name == PropProduct
               || name == PropVersion
               || name == PropServices
               || name == PropBlocked
               || name == PropNodes
               || name == PropAdapter
               || name == PropLegacyPairing) {
        // not handling these properties for now
        propertyHandled = false;
    } else {
        qWarning() << "BluetoothDevice: unhandled property change:" << name;
        propertyHandled = false;
    }

    return propertyHandled;
}

#define SET_INITIAL_PROPERTY(prop, values) {\
    if (!m_properties.contains(prop) && values.contains(prop) && values[prop] != m_properties[prop]) \
        updateProperty(prop, values[prop]); \
} \

void BluetoothDevice::getPropertiesFinished(QDBusPendingCallWatcher *call)
{
    QDBusPendingReply<QVariantMap> reply = *call;
    if (!reply.isError()) {
        QVariantMap values = reply.value();
        SET_INITIAL_PROPERTY(PropAddress, values);
        SET_INITIAL_PROPERTY(PropName, values);
        SET_INITIAL_PROPERTY(PropVendor, values);
        SET_INITIAL_PROPERTY(PropVendorSource, values);
        SET_INITIAL_PROPERTY(PropProduct, values);
        SET_INITIAL_PROPERTY(PropVersion, values);
        SET_INITIAL_PROPERTY(PropIcon, values);
        SET_INITIAL_PROPERTY(PropClassOfDevice, values);
        SET_INITIAL_PROPERTY(PropUuids, values);
        SET_INITIAL_PROPERTY(PropServices, values);
        SET_INITIAL_PROPERTY(PropPaired, values);
        SET_INITIAL_PROPERTY(PropConnected, values);
        SET_INITIAL_PROPERTY(PropTrusted, values);
        SET_INITIAL_PROPERTY(PropBlocked, values);
        SET_INITIAL_PROPERTY(PropAlias, values);
        SET_INITIAL_PROPERTY(PropNodes, values);
        SET_INITIAL_PROPERTY(PropAdapter, values);
        SET_INITIAL_PROPERTY(PropLegacyPairing, values);
    }
    call->deleteLater();

    emit devicePropertiesChanged();
    setReady();

    // If class of device is major type of audio device, then follow
    // device state changes.
    if (!m_headset && (classOfDevice() & 0x1f00) >> 8 == 4) {
        m_headset = new OrgBluezHeadsetInterface("org.bluez", m_objectPath, QDBusConnection::systemBus(), this);
        connect(m_headset, SIGNAL(PropertyChanged(QString,QDBusVariant)),
                SLOT(headsetPropertyChanged(QString,QDBusVariant)));

        QDBusPendingReply<bool> getIsPlayingResult = m_headset->IsPlaying();
        QDBusPendingCallWatcher *getIsPlayingWatcher = new QDBusPendingCallWatcher(getIsPlayingResult, this);
        connect(getIsPlayingWatcher, SIGNAL(finished(QDBusPendingCallWatcher*)),
                SLOT(getIsPlayingFinished(QDBusPendingCallWatcher*)));

    }
}

void BluetoothDevice::propertyChanged(QString name, QDBusVariant value)
{
    QVariant variant = value.variant();
    if (updateProperty(name, variant)) {
        emit devicePropertiesChanged();
        emit propertyChanged(name, variant);
    }
}

void BluetoothDevice::getAudioPropertiesFinished(QDBusPendingCallWatcher *call)
{
    QDBusPendingReply<QVariantMap> reply = *call;

    // we only care about the audio connection state property, and only set it here if
    // it hasn't already been set through a property change
    if (!reply.isError() && m_audioConnectionState == AudioStateUnknown) {
        QVariantMap values = reply.value();
        if (values.contains(AudioPropState)) {
            updateAudioProperty(AudioPropState, values[AudioPropState]);
        }
    }
    call->deleteLater();
    setReady();
}

void BluetoothDevice::audioPropertyChanged(QString name, QDBusVariant value)
{
    updateAudioProperty(name, value.variant());
}

void BluetoothDevice::headsetPropertyChanged(QString name, QDBusVariant value)
{
    updateHeadsetProperty(name, value.variant());
}

void BluetoothDevice::updateAudioProperty(const QString &name, const QVariant &value)
{
    if (name == AudioPropState) {
        AudioConnectionState newState = AudioStateUnknown;
        QString stateString = value.toString();
        if (stateString == AudioPropStateConnecting) {
            newState = AudioConnecting;
        } else if (stateString == AudioPropStateConnected) {
            newState = AudioConnected;
        } else if (stateString == AudioPropStateDisconnecting) {
            newState = AudioDisconnecting;
        } else if (stateString == AudioPropStateDisconnected) {
            newState = AudioDisconnected;
        }
        if (m_audioConnectionState != newState) {
            m_audioConnectionState = newState;
            emit audioConnectionStateChanged();
            emit devicePropertiesChanged();
        }
    }
}

void BluetoothDevice::getIsPlayingFinished(QDBusPendingCallWatcher *call)
{
    QDBusPendingReply<bool> reply = *call;
    if (!reply.isError() && m_audioPlayingState != reply.value()) {
        m_audioPlayingState = reply.value();
        emit audioPlayingStateChanged(m_audioPlayingState);
    }

    call->deleteLater();
}

void BluetoothDevice::updateHeadsetProperty(const QString &name, const QVariant &value)
{
    if (name == AudioPropPlaying && m_audioPlayingState != value.toBool()) {
        m_audioPlayingState = value.toBool();
        emit audioPlayingStateChanged(m_audioPlayingState);
    }
}

void BluetoothDevice::getInputPropertiesFinished(QDBusPendingCallWatcher *call)
{
    QDBusPendingReply<QVariantMap> reply = *call;

    // 'Connected' is the only property there will ever be, and only set it here if
    // it hasn't already been set through a property change
    if (!reply.isError() && !m_inputConnectedSet) {
        QVariantMap values = reply.value();
        if (values.contains(PropInputConnected)) {
            setInputConnected(values[PropInputConnected].toBool());
        }
    }
    call->deleteLater();
}

void BluetoothDevice::inputPropertyChanged(const QString &name, const QDBusVariant &value)
{
    if (name == PropInputConnected) {
        setInputConnected(value.variant().toBool());
    }
}

void BluetoothDevice::setInputConnected(bool connected)
{
    if (m_inputConnected != connected || !m_inputConnectedSet) {
        m_inputConnected = connected;
        m_inputConnectedSet = true;
        emit inputConnectedChanged();
        emit devicePropertiesChanged();
    }
}

void BluetoothDevice::updateInputConnectionState()
{
    QDBusPendingReply<QVariantMap> getInputPropsResult = m_input->GetProperties();
    QDBusPendingCallWatcher *getInputPropsWatcher = new QDBusPendingCallWatcher(getInputPropsResult, this);
    connect(getInputPropsWatcher, SIGNAL(finished(QDBusPendingCallWatcher*)),
            SLOT(getInputPropertiesFinished(QDBusPendingCallWatcher*)));
}

void BluetoothDevice::inputConnectFinished(QDBusPendingCallWatcher *call)
{
    QDBusPendingReply<> reply = *call;
    if (reply.isError()) {
        qWarning() << "org.bluez.Input.Connect() failed for" << address() << ":"
                   << reply.error().name() << reply.error().message();
        connectInputError(reply.error().name(), reply.error().message());
    } else {
        setInputConnected(true);
    }
    call->deleteLater();
}

void BluetoothDevice::inputDisconnectFinished(QDBusPendingCallWatcher *call)
{
    QDBusPendingReply<> reply = *call;
    if (reply.isError()) {
        qWarning() << "org.bluez.Input.Disconnect() failed for" << address() << ":"
                   << reply.error().name() << reply.error().message();
        disconnectInputError(reply.error().name(), reply.error().message());
    } else {
        setInputConnected(false);
    }
    call->deleteLater();
}

void BluetoothDevice::setReady()
{
    if (!m_ready && !m_properties.isEmpty() && m_audioConnectionState != AudioStateUnknown) {
        m_ready = true;
        emit readyChanged();
    }
}

