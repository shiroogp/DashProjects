#!/bin/sh
# launcher.sh
# navigate to home directory, then to this directory, then execute python script, then back home

cd /
cd /home/pi/ptest
sudo python3 app.py &
sudo python3 MQHUD.py &
cd /
