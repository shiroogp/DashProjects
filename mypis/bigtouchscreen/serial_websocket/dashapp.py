from websocket_server import ws_server_run
from serial_client import SerialWs
import time, subprocess, os, sys, threading

if __name__ == '__main__':

    # subprocess.call('open -a ' + os.path.join(os.path.dirname(sys.argv[0]), "SerialTool.app"),shell=True)

    ws = SerialWs('ws://localhost:8738/ws', protocols=['http-only', 'chat'])
    ws.connect()
    ws.run_forever()
