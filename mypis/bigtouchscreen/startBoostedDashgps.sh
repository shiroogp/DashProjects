#!/bin/bash
export QT_QPA_EGLFS_PHYSICAL_WIDTH=223
export QT_QPA_EGLFS_PHYSICAL_HEIGHT=125
python /home/pi/pythonqmltest/connector1.py & /opt/boosteddash/bin/boosteddash
