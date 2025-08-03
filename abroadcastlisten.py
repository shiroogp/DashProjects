#!/usr/bin/env python3
import os
import sys

import serial
import time

import socket
from select import select
import multiprocessing
import logging

serverlist = []


def handle(connection, address):
    logging.basicConfig(level=logging.DEBUG)
    logger = logging.getLogger("process-%r" % (address,))
    try:
        logger.debug("Connected %r at %r", connection, address)
        while True:
            data = connection.recv(1024)
            if data == "":
                logger.debug("Socket closed remotely")
                break
            logger.debug("Received data %r", data)
            # connection.sendall(data)
            # logger.debug("Sent data")
    except:
        logger.exception("Problem handling request")
    finally:
        logger.debug("Closing socket")
        connection.close()


class Server(object):
    def __init__(self, hostname, port):
        self.logger = logging.getLogger("server")
        self.hostname = hostname
        self.port = port

    def start(self):
        self.logger.debug("listening")
        self.socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        self.socket.bind(("", self.port))
        #   self.socket.listen(10)

        while True:
            #   data, addr = s.recvfrom(8000)
            #   print("Recv UDP:'%s'" % data)
            conn, (ip, port) = self.socket.recvfrom(300)
            self.logger.debug("Got connection")
            if ip in serverlist:
                print("Already reeceived message from " + ip)
            else:
                serverlist.append(ip)
                print("First reeceived message from " + ip)

                walk_dir = "/home/pi/broadcast"

                print("walk_dir = " + walk_dir)

                # If your current working directory may change during script execution, it's recommended to
                # immediately convert program arguments to an absolute path. Then the variable root below will
                # be an absolute path as well. Example:
                # walk_dir = os.path.abspath(walk_dir)
                print("walk_dir (absolute) = " + os.path.abspath(walk_dir))

                for root, subdirs, files in os.walk(walk_dir):
                    print("--\nroot = " + root)
                    list_file_path = os.path.join(root, ip)
                    print("list_file_path = " + list_file_path)
                    with open(list_file_path, "wb") as list_file:
                        list_file.write(ip.encode("utf-8"))

            # process = multiprocessing.Process(
            #     target=handle, args=(self.socket, address)
            # )
            # process.daemon = True
            # process.start()
            # self.logger.debug("Started process %r", process)


logging.basicConfig(level=logging.DEBUG)
server = Server("0.0.0.0", 45456)
try:
    logging.info("Listening")
    server.start()
except:
    logging.exception("Unexpected exception")
finally:
    logging.info("Shutting down")
    for process in multiprocessing.active_children():
        logging.info("Shutting down process %r", process)
        process.terminate()
        process.join()
logging.info("All done")


# print the input for confirmation
