#HUD_Demo.py
#Python file for debugging and testing code related to the UI without having to use raspberry pi

from websocket_client_gui import *

ws = DashWs('ws://192.168.1.74:8738/ws', protocols=['http-only', 'chat'])
ws.connect()
ws.run_forever()

