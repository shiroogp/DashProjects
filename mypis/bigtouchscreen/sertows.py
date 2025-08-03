#!/usr/bin/env python3
import serial
import time
import os
import socket
from select import select
import multiprocessing
import logging
import websocket

#from simple_websocket_server import WebSocketServer, WebSocket


#class SimpleChat(WebSocket):
#    def handle(self):
#        for client in clients:
#            if client != self:
#                client.send_message(self.address[0] + u' - ' + self.data)#
#
#    def connected(self):
#        print(self.address, 'connected')
#        for client in clients:
#            client.send_message(self.address[0] + u' - connected')
#        clients.append(self)
#
#    def handle_close(self):
#        clients.remove(self)
#        print(self.address, 'closed')
#        for client in clients:
#            client.send_message(self.address[0] + u' - disconnected')


clients = []

#server = WebSocketServer('', 8888, SimpleChat)
#server.serve_forever()


serverlist = []


#import asyncio
#from websockets.sync.client import connect

#def hello():
#    with connect("ws://localhost:8001") as websocket:
#        websocket.send("Hello world!")
#        message = websocket.recv()
#        print(f"Received: {message}")

#with connect("ws://localhost:8001") as websocket:
#    websocket.send("Hello world!")
#    message = websocket.recv()
#    print(f"Received: {message}")

#hello()



#NOTE websocketapp stops thread
#websocket.enableTrace(True)
#def on_error(wsapp, err):
#    print("EXAMPLE error encountered: ", err)
#def on_message(wsapp, message):
#    print(message)
#ws = websocket.WebSocketApp("ws://localhost:8001", on_message=on_message, on_error=on_error)
#ws.run_forever()

#Note - this works but disconnects after some time
#ws = websocket.WebSocket()
#ws.connect("ws://localhost:8001")

#Note trying websocket with threading
import websocket
import threading, time

ws = websocket.WebSocketApp("ws://127.0.0.1:8001")
def on_close(ws):
    # print('disconnected from server')
    print ("Retry : %s" % time.ctime())
    time.sleep(10)
    connect_websocket() # retry per 10 seconds
def on_open(ws):
    print('connection established')
def connect_websocket():
    ws.close()
    ws = websocket.WebSocketApp("ws://127.0.0.1:8001", on_open = on_open, on_close = on_close)
    wst = threading.Thread(target=ws.run_forever)
    wst.daemon = True
    wst.start()

connect_websocket()

UDP_IP = "localhost"
# UDP_IP = "192.168.1.123"
# UDP_IP = "255.255.255.255"
UDP_PORT = 45454
TCP_PORT = 45554
MESSAGE = "Hello, World!"


allips = []
try:
    f = open("broadcastips.txt", "r")
    for x in f:
        print(x)
        if len(x) > 0:
            print("Adding ip to broadcast = " + x)
            allips.append(x)
except:
    print("File does not exist")
walk_dir = "/home/pi/broadcast"

print("walk_dir = " + walk_dir)

# If your current working directory may change during script execution, it's recommended to
# immediately convert program arguments to an absolute path. Then the variable root below will
# be an absolute path as well. Example:
# walk_dir = os.path.abspath(walk_dir)
print("walk_dir (absolute) = " + os.path.abspath(walk_dir))

for root, subdirs, files in os.walk(walk_dir):
    print("--\nroot = " + root)

    for filename in files:
        file_path = os.path.join(root, filename)

        print("\t- file %s (full path: %s)" % (filename, file_path))

        with open(file_path, "rb") as f:
            f_content = f.read()
            if len(f_content.decode("utf-8")) > 0:
                allips.append(f_content.decode("utf-8"))
                print("IP Added - " + f_content.decode("utf-8"))
        os.remove(file_path)


basicips = []
tcpsockets = []
try:
    f = open("basicbroadcastips.txt", "r")
    for x in f:
        print(x)
        if len(x) > 0:
            print("Adding ip to basic broadcast = " + x)
            basicips.append(x)
            clientSocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
            clientSocket.connect((x, TCP_PORT))
            tcpsockets.append(clientSocket)
except:
    print("File does not exist")

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# connect to server on local computer
connected = False
while connected == False:
    try:
        s.connect(("127.0.0.1", TCP_PORT))
        connected = True
    except:
        print("Dash not ready for connection")
        time.sleep(1)


print("UDP target IP:", UDP_IP)
print("UDP target port:", UDP_PORT)
intspeed = 1
intrpm = 100
boost = 0.1


sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)  # Internet  # UDP
sock.setsockopt(socket.SOL_SOCKET, socket.SO_BROADCAST, 1)

connected = False
while connected == False:
    try:
        ArduinoSerial = serial.Serial(
            "/dev/ttyACM0", 115200, timeout=0.012
        )  # timeout for response on readline()
        print("ECU Ready")
        connected = True
        time.sleep(2)
    except:
        try:
            ArduinoSerial = serial.Serial(
                "/dev/ttyUSB0", 115200, timeout=0.012
            )  # timeout for response on readline()
            print("ECU Ready")
            connected = True
            time.sleep(2)
        except:
            print("ECU ttyUSB Not Ready")
        print("ECU ttyACM Not Ready")
        time.sleep(2)

# time.sleep(2) #allow time for serial port to open
var = "A"
# get input from user
print("Sending Command:  ", var)


# print the input for confirmation
count = 1
while True:
    # send to Arduino
    # read echo back from arduino to verify receipt of message
    # print ("Writing to Serial:", var )

    if count == 100:
        for root, subdirs, files in os.walk(walk_dir):
            for filename in files:
                file_path = os.path.join(root, filename)

                print("\t- file %s (full path: %s)" % (filename, file_path))

                with open(file_path, "rb") as f:
                    f_content = f.read()
                    if len(f_content.decode("utf-8")) > 0:
                        allips.append(f_content.decode("utf-8"))
                        print("IP Added - " + f_content.decode("utf-8"))
                os.remove(file_path)

    ArduinoSerial.write(var.encode())
    data = ArduinoSerial.read()  # the last bit gets rid of the new-line char
    lineout = ""
    bytecount = 0
    while data:
        try:
            currval1 = str(ord(data.decode()))
        except:
            currval1 = str(ord(data))
        # remove the below code when live   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if bytecount == 14:
            currval1 = str(count * 10)
        bytecount += 1
        lineout += currval1 + " "

        data = ArduinoSerial.read()
        print(data)
    try:
        vars = lineout.split()
        map_bar = (int(vars[4]) - int(vars[40])) / 101.33
        map_psi = (int(vars[4]) - int(vars[40])) * 0.145038
        map_inhg = (int(vars[40]) - int(vars[4])) * 0.2953007
        basicdashdata = (
            "BASIC~"
            + vars[4]
            + " "
            + vars[40]
            + " "
            + vars[7]
            + " "
            + vars[6]
            + " "
            + vars[114]
            + " "
            + vars[10]
            + " "
            + vars[105]
            + " "
            + vars[106]
            + " "
            + vars[14]
            + " "
            + vars[9]
            + " "
            + vars[24]
        )
        s.send(basicdashdata.encode("ascii"))
        ws.send(basicdashdata)
        ws.send("CORE~," + lineout)
        for extip in tcpsockets:
            try:
                # print("sending to IP - " + extip)
                basicdashdata = (
                    "BASIC~"
                    + vars[4]
                    + " "
                    + vars[40]
                    + " "
                    + vars[7]
                    + " "
                    + vars[6]
                    + " "
                    + vars[114]
                    + " "
                    + vars[10]
                    + " "
                    + vars[105]
                    + " "
                    + vars[106]
                    + " "
                    + vars[14]
                    + " "
                    + vars[9]
                    + " "
                    + vars[24]
                )
                extip.send(basicdashdata.encode("utf-8"))
            except Exception as e:
                print("Error sending to Basic Socket - " + e)

        for extip in allips:
            try:
                # print("sending to IP - " + extip)
                coredata = "CORE~," + lineout
#                ws.send("CORE~," + lineout)
                sock.sendto(coredata.encode("utf-8"), (extip, UDP_PORT))
            except:
                print("Error sending to IP - " + extip)

        # sock.sendto(("155," + vars[4]).encode("utf-8"), (UDP_IP, UDP_PORT))
        # sock.sendto(("210," + vars[24]).encode("utf-8"), (UDP_IP, UDP_PORT))
        # sock.sendto(("135," + vars[6]).encode("utf-8"), (UDP_IP, UDP_PORT))
        # sock.sendto(("179," + vars[14]).encode("utf-8"), (UDP_IP, UDP_PORT))
        # sock.sendto(("199," + str(count)).encode("utf-8"), (UDP_IP, UDP_PORT))
        # sock.sendto(("6," + vars[10]).encode("utf-8"), (UDP_IP, UDP_PORT))
        # sock.sendto(("22," + str(map_psi)).encode("utf-8"), (UDP_IP, UDP_PORT))
        count = count + 1
        if count > 300:
            count = 1
    except Exception as e:
        print(e)
        ws.close
        ws.connect("ws://localhost:8001")
        ws.send("Serial connection lost")
        print("Serial data corrupt")
        ArduinoSerial.flush()
        ArduinoSerial.close()
        try:
            ArduinoSerial = serial.Serial(
                "/dev/ttyACM0", 115200, timeout=0.012
            )  # timeout for response on readline()
        except:
            ArduinoSerial = serial.Serial(
                "/dev/ttyUSB0", 115200, timeout=0.012
            )  # timeout for response on readline()

        print("ECU Ready")
        connected = True
        time.sleep(2)

        # time.sleep(1)
