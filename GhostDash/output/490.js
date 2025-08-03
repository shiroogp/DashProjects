exports.useAnimatedSensor = function (t, n) {
  var l = f(
      {
        interval: 'auto',
        adjustToInterfaceOrientation: true,
        iosReferenceFrame: module420.IOSReferenceFrame.Auto,
      },
      n
    ),
    O = React.useRef({
      sensor: module422.initializeSensor(t, l),
      unregister: function () {},
      isAvailable: false,
      config: l,
    });
  React.useEffect(
    function () {
      var o = f(f({}, l), n);
      O.current.sensor = module422.initializeSensor(t, o);
      var v = O.current.sensor,
        b = O.current.config.adjustToInterfaceOrientation,
        h = module422.registerSensor(t, l, function (n) {
          'worklet';

          if (b) n = t === module420.SensorType.ROTATION ? y(n) : p(n);
          v.value = n;
          module426.callMicrotasks();
        });

      if (-1 !== h) {
        O.current.unregister = function () {
          return module422.unregisterSensor(h);
        };

        O.current.isAvailable = true;
      } else {
        O.current.unregister = function () {};

        O.current.isAvailable = false;
      }

      return function () {
        O.current.unregister();
      };
    },
    [t, n]
  );
  return O.current;
};

var module50 = require('./50'),
  React = require('react'),
  module422 = require('./422'),
  module420 = require('./420'),
  module426 = require('./426');

function l(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var c = Object.getOwnPropertySymbols(t);
    if (n)
      c = c.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, c);
  }

  return o;
}

function f(t) {
  for (var o = 1; o < arguments.length; o++) {
    var c = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      l(Object(c), true).forEach(function (o) {
        module50.default(t, o, c[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(c));
    else
      l(Object(c)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(c, n));
      });
  }

  return t;
}

function O(t, n, o) {
  'worklet';

  var c = Math.cos(t / 2),
    u = Math.sin(t / 2),
    s = Math.cos(n / 2),
    l = Math.sin(n / 2),
    f = Math.cos(o / 2),
    O = Math.sin(o / 2);
  return [u * s * f - c * l * O, c * l * f + u * s * O, c * s * O + u * l * f, c * s * f - u * l * O];
}

function y(t) {
  'worklet';

  var n = t.interfaceOrientation,
    o = t.pitch,
    c = t.roll,
    u = t.yaw;

  if (90 === n) {
    t.pitch = c;
    t.roll = -o;
    t.yaw = u - Math.PI / 2;
  } else if (270 === n) {
    t.pitch = -c;
    t.roll = o;
    t.yaw = u + Math.PI / 2;
  } else if (180 === n) {
    t.pitch *= -1;
    t.roll *= -1;
    t.yaw *= -1;
  }

  var s = O(t.pitch, t.roll, t.yaw);
  t.qx = s[0];
  t.qy = s[1];
  t.qz = s[2];
  t.qw = s[3];
  return t;
}

function p(t) {
  'worklet';

  var n = t.interfaceOrientation,
    o = t.x,
    c = t.y;

  if (90 === n) {
    t.x = -c;
    t.y = o;
  } else if (270 === n) {
    t.x = c;
    t.y = -o;
  } else if (180 === n) {
    t.x *= -1;
    t.y *= -1;
  }

  return t;
}
