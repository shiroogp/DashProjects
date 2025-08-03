#!/bin/sh
# launcher.sh
# navigate to home directory, then to this directory, then execute python script, then back home

cd /
cd home/pi/
sudo python3 /home/pi/2dashKi.py >/home/pi/logs/dashlog &
sleep 2
cd home/pi/pythonqmltest
sudo python3 /home/pi/pythonqmltest/aaa.py >/home/pi/logs/seriallog &
sudo python3 /home/pi/pythonqmltest/abroadcastlisten.py >/home/pi/logs/broadcastlog &
cd /
