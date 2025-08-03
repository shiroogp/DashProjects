from ws4py.client.threadedclient import WebSocketClient
import serial
import json
import threading
# import codecs
# from datetime import datetime
import time
import sys
import glob
import subprocess
import pygame
import sys
import os
import sys

import paho.mqtt.client as paho




class HUDWs(WebSocketClient):
    serial_thread = None
    serialopen = False
    client = paho.Client("publish")

    def opened(self):
        print("serial_client_opend")
        

        if self.client.connect("localhost", 1883, 60) != 0:
            print("Couldn't connect to the mqtt broker")
            sys.exit(1)
            pass

    def closed(self, code, reason=None):
        print("serial_client_closed")
        self.client.disconnect()
        # pass

    def received_message(self, message):
        print(message)
        print(message.data)
        data = message.data.decode()
        self.client.publish("ecu", data, 0)
# self.serial_thread.send_message(data)
        # if data["type"] == "send":
        #     self.serial_thread.send_message(data["message"])
        # elif data["type"] == "open":
        #     if self.serialopen == False:
        #         self.serial_thread = SerialThread(
        #             data["port"],
        #             data["baudrate"],
        #             data["databit"],
        #             data["stopbit"],
        #             data["parity"],
        #             self
        #         )
        #         self.serial_thread.setDaemon(True)
        #         self.serial_thread.start()
        #         self.serialopen = True
        # elif data["type"] == "close":
        #     self.serial_thread.stop()
        # elif data["type"] == "exit":
        #     subprocess.check_output('killall - KILL SerialTool', shell=True)
        #     sys.exit()
        # else:
        #     pass


