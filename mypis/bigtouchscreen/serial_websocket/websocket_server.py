from tornado import ioloop, web, websocket, gen
from serial_client import serial_ports
import os, sys, json

class IndexHandler(web.RequestHandler):
    @gen.coroutine
    def get(self):
        ports = serial_ports()
        self.render("index.html", ports=ports)


class WebSocketHandler(websocket.WebSocketHandler):
    waiters = set()

    def check_origin(self, origin):
        return True
        
    def open(self):
        print(self)
        self.waiters.add(self)
        print("WebSocket opened")

    def on_message(self, message):
        for waiter in self.waiters:
            if waiter == self:
                continue
            waiter.write_message(message)

    def on_close(self):
        print(self)
        self.waiters.remove(self)
        print("WebSocket closed")
        for waiter in self.waiters:
            if waiter == self:
                continue
            # waiter.write_message(json.dumps({"type":"exit"}))


def ws_server_run():
    # dpath = os.path.dirname(sys.argv[0])
    app = web.Application([
        (r"/", IndexHandler),
        (r"/ws", WebSocketHandler)
    ],
    template_path=os.path.join(os.path.dirname(sys.argv[0]), "templates"),
    # template_path="./templates",
    static_path=os.path.join(os.path.dirname(sys.argv[0]), "static")
    # static_path="./static"
    )
    app.listen(8738)
    ioloop.IOLoop.instance().start()
