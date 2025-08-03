#!/usr/bin/env python3
#coding:utf-8
# Author:   --<>
# Purpose:  Stack Overflow
# Created: 19/12/15

import sys
import unittest


from PyQt5.QtCore import QThread, QObject, pyqtSignal, pyqtSlot
import time
import random


class Worker(QObject):
    finished = pyqtSignal(int)
    intReady = pyqtSignal(int,int)

    def __init__(self, i=0):
        '''__init__ is called while the worker is still in the Gui thread. Do not put slow or CPU intensive code in the __init__ method'''

        super().__init__()
        self.idd = i



    @pyqtSlot()
    def procCounter(self): # This slot takes no params
        for j in range(1, 10):
            random_time = random.weibullvariate(1,2)
            time.sleep(random_time)
            self.intReady.emit(j,self.idd)
            print('Worker {0} in thread {1}'.format(self.idd, self.thread().idd))

        self.finished.emit(self.idd)


if __name__=='__main__':
    unittest.main()
