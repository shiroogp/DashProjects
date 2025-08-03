#ifndef LOCKHELPER_H
#define LOCKHELPER_H


#pragma once
#include <QAndroidJniObject>

class KeepAwakeHelper
{
public:
    KeepAwakeHelper();
    virtual ~KeepAwakeHelper();

private:
    QAndroidJniObject m_wakeLock;
};

#endif // LOCKHELPER_H
