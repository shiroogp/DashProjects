#include <QApplication>
#include <QDesktopWidget>
#include <QQmlApplicationEngine>
#include <QQmlContext>
#include <QtQml>
#include <QFileSystemModel>
#include "connect.h"


int main(int argc, char *argv[])
{
    qputenv("QT_IM_MODULE", QByteArray("qtvirtualkeyboard"));
    QApplication app(argc, argv);
    app.setOrganizationName("Power-Tune");
    app.setOrganizationDomain("power-tune.org");
    app.setApplicationName("PowerTune");
    QRect rec = QApplication::desktop()->screenGeometry();
    int height = rec.height();
    int width = rec.width();
    qDebug()<< "height";
    qDebug()<< height;
    qDebug()<< "width";
    qDebug()<< width;

    QQmlApplicationEngine engine;
    //File system models to show drive letter and Path
    /*
    QFileSystemModel pathmodel;
    QString mPath = "/";
    pathmodel.setRootPath(mPath);
    pathmodel.setFilter(QDir::NoDotAndDotDot |QDir::AllDirs);

    QFileSystemModel filemodel;
    filemodel.setRootPath(mPath);
    filemodel.setFilter(QDir::NoDotAndDotDot |QDir::Files);
    engine.rootContext()->setContextProperty("my_model", &pathmodel);
    */
    qmlRegisterType<Connect>("com.powertune", 1, 0, "ConnectObject");
    engine.rootContext()->setContextProperty("Connect", new Connect(&engine));
    engine.load(QUrl(QStringLiteral("qrc:/main.qml")));


    return app.exec();

}

