var module15 = require('@babel/runtime/helpers/slicedToArray'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module417 = require('./417'),
  module420 = require('./420');

function v() {
  if ('undefined' == typeof Reflect || !Reflect.construct) return false;
  if (Reflect.construct.sham) return false;
  if ('function' == typeof Proxy) return true;

  try {
    Boolean.prototype.valueOf.call(Reflect.construct(Boolean, [], function () {}));
    return true;
  } catch (n) {
    return false;
  }
}

exports.default = (function (n) {
  module38.default(p, n);

  var module417 = p,
    S = v(),
    w = function () {
      var n,
        t = module37.default(module417);

      if (S) {
        var o = module37.default(this).constructor;
        n = Reflect.construct(t, arguments, o);
      } else n = t.apply(this, arguments);

      return module40.default(this, n);
    };

  function p() {
    var n;
    module27.default(this, p);
    (n = w.call(this, false)).nextSensorId = 0;
    n.sensors = new Map();
    return n;
  }

  module28.default(p, [
    {
      key: 'makeShareableClone',
      value: function (n) {
        return {
          __hostObjectShareableJSRef: n,
        };
      },
    },
    {
      key: 'installCoreFunctions',
      value: function (n, t) {},
    },
    {
      key: 'scheduleOnUI',
      value: function (n) {
        requestAnimationFrame(n);
      },
    },
    {
      key: 'registerEventHandler',
      value: function (n, t) {
        return '';
      },
    },
    {
      key: 'unregisterEventHandler',
      value: function (n) {},
    },
    {
      key: 'enableLayoutAnimations',
      value: function () {
        console.warn('[Reanimated] Layout Animations are not supported on web yet.');
      },
    },
    {
      key: 'configureLayoutAnimation',
      value: function () {},
    },
    {
      key: 'registerSensor',
      value: function (n, o, s, u) {
        if (!(this.getSensorName(n) in window)) return -1;
        var module40,
          l = this.initializeSensor(n, o);
        module40 =
          n === module420.SensorType.ROTATION
            ? function () {
                var n = module15.default(l.quaternion, 4),
                  o = n[0],
                  s = n[1],
                  c = n[2],
                  f = n[3],
                  y = (2 * (c * f + o * s)) ** (o * o - s * s - c * c + f * f),
                  v = Math.sin(-2 * (s * f - o * c)),
                  S = (2 * (s * c + o * f)) ** (o * o + s * s - c * c - f * f);
                u({
                  qw: o,
                  qx: s,
                  qy: c,
                  qz: f,
                  yaw: y,
                  pitch: v,
                  roll: S,
                  interfaceOrientation: 0,
                });
              }
            : function () {
                var n = l.x,
                  t = l.y,
                  o = l.z;
                u({
                  x: n,
                  y: t,
                  z: o,
                  interfaceOrientation: 0,
                });
              };
        l.addEventListener('reading', module40);
        l.start();
        this.sensors.set(this.nextSensorId, l);
        return this.nextSensorId++;
      },
    },
    {
      key: 'unregisterSensor',
      value: function (n) {
        var t = this.sensors.get(n);

        if (undefined !== t) {
          t.stop();
          this.sensors.delete(n);
        }
      },
    },
    {
      key: 'subscribeForKeyboardEvents',
      value: function (n) {
        console.warn('[Reanimated] useAnimatedKeyboard is not available on web yet.');
        return -1;
      },
    },
    {
      key: 'unsubscribeFromKeyboardEvents',
      value: function (n) {},
    },
    {
      key: 'initializeSensor',
      value: function (n, t) {
        var o =
          t <= 0
            ? {
                referenceFrame: 'device',
              }
            : {
                frequency: 1e3 / t,
              };

        switch (n) {
          case module420.SensorType.ACCELEROMETER:
            return new window.Accelerometer(o);

          case module420.SensorType.GYROSCOPE:
            return new window.Gyroscope(o);

          case module420.SensorType.GRAVITY:
            return new window.GravitySensor(o);

          case module420.SensorType.MAGNETIC_FIELD:
            return new window.Magnetometer(o);

          case module420.SensorType.ROTATION:
            return new window.AbsoluteOrientationSensor(o);
        }
      },
    },
    {
      key: 'getSensorName',
      value: function (n) {
        switch (n) {
          case module420.SensorType.ACCELEROMETER:
            return 'Accelerometer';

          case module420.SensorType.GRAVITY:
            return 'GravitySensor';

          case module420.SensorType.GYROSCOPE:
            return 'Gyroscope';

          case module420.SensorType.MAGNETIC_FIELD:
            return 'Magnetometer';

          case module420.SensorType.ROTATION:
            return 'AbsoluteOrientationSensor';
        }
      },
    },
  ]);
  return p;
})(module417.NativeReanimated);
