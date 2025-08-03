from websocket_server import ws_server_run
from serial_client_hud import SerialWs
import time, subprocess, os, sys, threading

if __name__ == '__main__':
    serial_thread = threading.Thread(target=ws_server_run)
    serial_thread.setDaemon(True)
    serial_thread.start()

