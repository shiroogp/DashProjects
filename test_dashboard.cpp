#include <QTest>
#include <QObject>
#include "dashboard.h"

class TestDashboard : public QObject
{
    Q_OBJECT

private slots:
    void testInitialization();
    void testCalculations();
};

void TestDashboard::testInitialization()
{
    Dashboard dashboard;
    // Test that dashboard initializes with default values
    QCOMPARE(dashboard.revs(), 0);
    QCOMPARE(dashboard.speed(), 0);
    QCOMPARE(dashboard.gear(), 0);
}

void TestDashboard::testCalculations()
{
    Dashboard dashboard;
    // Test a simple calculation
    dashboard.setRevs(3000);
    dashboard.setSpeed(60);
    
    // Assuming there's a method to calculate gear based on revs and speed
    dashboard.calculateGear();
    
    // This is just an example - actual values would depend on implementation
    QVERIFY(dashboard.gear() >= 0);
}

QTEST_MAIN(TestDashboard)
#include "test_dashboard.moc"