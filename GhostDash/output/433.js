var module27 = require('./27'),
  module414 = require('./414'),
  module420 = require('./420'),
  module429 = require('./429');

function f(n) {
  return n === module420.SensorType.ROTATION
    ? module429.makeMutable({
        qw: 0,
        qx: 0,
        qy: 0,
        qz: 0,
        yaw: 0,
        pitch: 0,
        roll: 0,
        interfaceOrientation: 0,
      })
    : module429.makeMutable({
        x: 0,
        y: 0,
        z: 0,
        interfaceOrientation: 0,
      });
}

exports.default = (function () {
  function n(s, u) {
    module27.default(this, n);
    this.listenersNumber = 0;
    this.sensorId = null;
    this.sensorType = s;
    this.config = u;
    this.data = f(s);
  }

  module28.default(n, [
    {
      key: 'register',
      value: function (n) {
        var t = this.config,
          s = this.sensorType;
        this.sensorId = module414.default.registerSensor(s, 'auto' === t.interval ? -1 : t.interval, t.iosReferenceFrame, n);
        return -1 !== this.sensorId;
      },
    },
    {
      key: 'isRunning',
      value: function () {
        return -1 !== this.sensorId && null !== this.sensorId;
      },
    },
    {
      key: 'isAvailable',
      value: function () {
        return -1 !== this.sensorId;
      },
    },
    {
      key: 'getSharedValue',
      value: function () {
        return this.data;
      },
    },
    {
      key: 'unregister',
      value: function () {
        if (null !== this.sensorId && -1 !== this.sensorId) module414.default.unregisterSensor(this.sensorId);
        this.sensorId = null;
      },
    },
  ]);
  return n;
})();
