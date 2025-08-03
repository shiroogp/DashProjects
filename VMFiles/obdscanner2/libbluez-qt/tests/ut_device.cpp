#include "testbase.h"
#include "moc_testbase.cpp"

#include <QtCore/QScopedPointer>

#include "bluetoothdevice.h"

namespace Tests {

class UtDevice : public BluezTestBase
{
    Q_OBJECT

public:
    UtDevice();

private slots:
    void initTestCase();
    void init();
    void cleanupTestCase();

    void testProperties1_data();
    void testProperties1();
    void testProperties2_data();
    void testProperties2();
    void testWriteProperties_data();
    void testWriteProperties();
    void testReflectPropertiesChange_data();
    void testReflectPropertiesChange();
    void testAudio();

private:
    static QString deviceDBusProperty2QtProperty(QString property);
    static QString deviceQtProperty2DBusProperty(QString property);

private:
    QPointer<BluetoothDevice> m_adapter0device2;
    QPointer<BluetoothDevice> m_adapter0device4;
};

} // namespace Tests

using namespace Tests;

/*
 * \class Tests::UtDevice
 */

UtDevice::UtDevice()
{
}

void UtDevice::initTestCase()
{
    QVERIFY(waitForService(SERVICE, bus()));
}

void UtDevice::init()
{
    delete m_adapter0device2;
    delete m_adapter0device4;

    QDBusInterface manager(SERVICE, MANAGER_PATH, MANAGER_INTERFACE, bus());
    QDBusReply<void> reply = manager.call("mock_reset");
    Q_ASSERT(reply.isValid());

    m_adapter0device2 = new BluetoothDevice(QDBusObjectPath("/adapter0/device2"));
    QVERIFY(m_adapter0device2->ready() || waitForSignal(m_adapter0device2, SIGNAL(readyChanged())));

    m_adapter0device4 = new BluetoothDevice(QDBusObjectPath("/adapter0/device4"));
    QVERIFY(m_adapter0device4->ready() || waitForSignal(m_adapter0device4, SIGNAL(readyChanged())));
}

void UtDevice::cleanupTestCase()
{
    delete m_adapter0device2;
    delete m_adapter0device4;
}

void UtDevice::testProperties1_data()
{
    QTest::addColumn<QVariant>("expected");

    createTestPropertyData(adapter0device2InitialProperties(), deviceDBusProperty2QtProperty);
    QTest::newRow("path") << QVariant("/adapter0/device2");
}

void UtDevice::testProperties1()
{
    QFETCH(QVariant, expected);

    testProperty(*m_adapter0device2, QTest::currentDataTag(), expected);
}

void UtDevice::testProperties2_data()
{
    QTest::addColumn<QVariant>("expected");

    createTestPropertyData(adapter0device4InitialProperties(), deviceDBusProperty2QtProperty);
    QTest::newRow("path") << QVariant("/adapter0/device4");
}

void UtDevice::testProperties2()
{
    QFETCH(QVariant, expected);

    testProperty(*m_adapter0device4, QTest::currentDataTag(), expected);
}

void UtDevice::testWriteProperties_data()
{
    QTest::addColumn<QVariant>("value");

    QTest::newRow("alias") << QVariant("bar");
    QTest::newRow("trusted") << QVariant(true);
}

void UtDevice::testWriteProperties()
{
    QFETCH(QVariant, value);

    QScopedPointer<BluetoothDevice> adapter0device2alt(
            new BluetoothDevice(QDBusObjectPath("/adapter0/device2")));

    testWriteProperty(m_adapter0device2, adapter0device2alt.data(), QTest::currentDataTag(), value);
}

void UtDevice::testReflectPropertiesChange_data()
{
    QTest::addColumn<QVariant>("injectedValue");

    QTest::newRow("connected") << QVariant(true);
    QTest::newRow("profiles") << QVariant(QStringList() << BluetoothProfiles::opush);
    QTest::newRow("trusted") << QVariant(true);
    QTest::newRow("paired") << QVariant(true);
}

void UtDevice::testReflectPropertiesChange()
{
    QFETCH(QVariant, injectedValue);

    const char *property = QTest::currentDataTag();

    QDBusInterface injectionInterface(SERVICE, "/adapter0/device2", DEVICE_INTERFACE, bus());
    const QString injectionMethod = "SetProperty";
    const QString injectionKey = deviceQtProperty2DBusProperty(property);

    testReflectPropertyChange(m_adapter0device2, property,
            &injectionInterface, injectionMethod, injectionKey, injectedValue);
}

void UtDevice::testAudio()
{
    QDBusInterface device(SERVICE, "/adapter0/device2", DEVICE_INTERFACE, bus());

    // Enable A2SINK profile
    {
        QDBusReply<void> reply = device.call("SetProperty", "UUIDs",
                QVariant::fromValue(QDBusVariant(QStringList() << BluetoothProfiles::a2sink)));
        Q_ASSERT(reply.isValid());

        QVERIFY(waitForSignal(m_adapter0device2, SIGNAL(devicePropertiesChanged())));
        QVERIFY(m_adapter0device2->profiles().contains(BluetoothProfiles::a2sink));
    }

    QDBusInterface audio(SERVICE, "/adapter0/device2", AUDIO_INTERFACE, bus());

    SignalSpy propertyChangedSpy(&audio, SIGNAL(PropertyChanged(QString,QDBusVariant)));
    SignalSpy connectedChangedSpy(m_adapter0device2, SIGNAL(audioConnectionStateChanged()));

    m_adapter0device2->connectAudio();

    QVERIFY(waitForSignal(&propertyChangedSpy));
    QCOMPARE(propertyChangedSpy.count(), 1);
    QCOMPARE(propertyChangedSpy.at(0).at(0), QVariant("State"));
    QCOMPARE(propertyChangedSpy.at(0).at(1).value<QDBusVariant>().variant(), QVariant("connected"));

    QVERIFY(waitForSignal(&connectedChangedSpy));
    QCOMPARE(connectedChangedSpy.count(), 1);

    QCOMPARE(m_adapter0device2->audioConnectionState(), BluetoothDevice::AudioConnected);

    propertyChangedSpy.clear();
    connectedChangedSpy.clear();

    m_adapter0device2->disconnectAudio();

    QVERIFY(waitForSignal(&propertyChangedSpy));
    QCOMPARE(propertyChangedSpy.count(), 1);
    QCOMPARE(propertyChangedSpy.at(0).at(0), QVariant("State"));
    QCOMPARE(propertyChangedSpy.at(0).at(1).value<QDBusVariant>().variant(), QVariant("disconnected"));

    QVERIFY(waitForSignal(&connectedChangedSpy));
    QCOMPARE(connectedChangedSpy.count(), 1);

    QCOMPARE(m_adapter0device2->audioConnectionState(), BluetoothDevice::AudioDisconnected);
}

QString UtDevice::deviceDBusProperty2QtProperty(QString property)
{
    if (property == "UUIDs") {
        return "profiles";
    } else if (property == "Class") {
        return "classOfDevice";
    } else {
        return firstLower(property);
    }
}

QString UtDevice::deviceQtProperty2DBusProperty(QString property)
{
    if (property == "profiles") {
        return "UUIDs";
    } else if (property == "classOfDevice") {
        return "Class";
    } else {
        return firstUpper(property);
    }
}

TEST_MAIN(UtDevice, BluezTestBase::ManagerMock)

#include "ut_device.moc"
