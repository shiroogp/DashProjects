#ifndef _OBEX_TYPES_H_
#define _OBEX_TYPES_H_

#include <QtCore/QMap>
#include <QtCore/QVariantMap>
#include <QtCore/QString>
#include <QtDBus/QDBusObjectPath>

typedef QList<QVariantMap> QVariantMapList;
Q_DECLARE_METATYPE(QVariantMapList)

// note this must be registered using qDBusRegisterMetaType() before use
typedef QPair<QDBusObjectPath, QVariantMap> QObexObjectData;
Q_DECLARE_METATYPE(QObexObjectData)

#endif
