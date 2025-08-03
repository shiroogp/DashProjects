var module27 = require('./27'),
  module433 = require('./433');

exports.SensorContainer = (function () {
  function n() {
    module27.default(this, n);
    this.nativeSensors = new Map();
  }

  module28.default(n, [
    {
      key: 'getSensorId',
      value: function (n, t) {
        return 100 * n + 10 * t.iosReferenceFrame + Number(t.adjustToInterfaceOrientation);
      },
    },
    {
      key: 'initializeSensor',
      value: function (n, t) {
        var s = this.getSensorId(n, t);

        if (!this.nativeSensors.has(s)) {
          var u = new module433.default(n, t);
          this.nativeSensors.set(s, u);
        }

        return this.nativeSensors.get(s).getSharedValue();
      },
    },
    {
      key: 'registerSensor',
      value: function (n, t, s) {
        var o = this.getSensorId(n, t);
        if (!this.nativeSensors.has(o)) return -1;
        var u = this.nativeSensors.get(o);

        if (u && u.isAvailable() && (u.isRunning() || u.register(s))) {
          u.listenersNumber++;
          return o;
        } else return -1;
      },
    },
    {
      key: 'unregisterSensor',
      value: function (n) {
        if (this.nativeSensors.has(n)) {
          var t = this.nativeSensors.get(n);

          if (t && t.isRunning()) {
            t.listenersNumber--;
            if (0 === t.listenersNumber) t.unregister();
          }
        }
      },
    },
  ]);
  return n;
})();
