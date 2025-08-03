from websocket_client import DashWs
import time, subprocess, os, sys, threading

if __name__ == '__main__':

    # subprocess.call('open -a ' + os.path.join(os.path.dirname(sys.argv[0]), "SerialTool.app"),shell=True)

    ws = DashWs('ws://192.168.1.74:8738/ws', protocols=['http-only', 'chat'])
    ws.connect()
    ws.run_forever()
