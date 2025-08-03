var o,
  n,
  module50 = require('./50'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
  module416 = require('./416');

function p(t, o) {
  var n = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var c = Object.getOwnPropertySymbols(t);
    if (o)
      c = c.filter(function (o) {
        return Object.getOwnPropertyDescriptor(t, o).enumerable;
      });
    n.push.apply(n, c);
  }

  return n;
}

function f(t) {
  for (var o = 1; o < arguments.length; o++) {
    var n = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      p(Object(n), true).forEach(function (o) {
        module50.default(t, o, n[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(n));
    else
      p(Object(n)).forEach(function (o) {
        Object.defineProperty(t, o, Object.getOwnPropertyDescriptor(n, o));
      });
  }

  return t;
}

if (require('./421').isWeb()) {
  try {
    o = require(d[5]).default;
  } catch (t) {}

  try {
    n = require(d[6]).createTransformValue;
  } catch (t) {}
}

var l = new module416.default();

globals._makeShareableClone = function (t) {
  return t;
};

globals._scheduleOnJS = queueMicrotask;

exports._updatePropsJS = function (t, n) {
  if (n._component) {
    var c = n._component,
      s = Object.keys(t).reduce(
        function (o, n) {
          var c = t[n];
          o['function' == typeof c ? 1 : 0][n] = c;
          return o;
        },
        [{}, {}]
      ),
      p = module15.default(s, 1)[0];
    if ('function' == typeof c.setNativeProps) y(c, p);
    else if (undefined !== o && undefined !== c.style) v(c, p);
    else if (Object.keys(c.props).length > 0)
      Object.keys(c.props).forEach(function (t) {
        if (p[t]) {
          var o = t.replace(/[A-Z]/g, function (t) {
            return '-' + t.toLowerCase();
          });

          c._touchableNode.setAttribute(o, p[t]);
        }
      });
    else console.warn('It is not possible to manipulate component');
  }
};

var y = function (t, o) {
    var n = f(f({}, t.previousStyle ? t.previousStyle : {}), o);
    t.previousStyle = n;
    if (!(null == t.setNativeProps))
      t.setNativeProps({
        style: n,
      });
  },
  v = function (t, c) {
    var u = f(f({}, t.previousStyle ? t.previousStyle : {}), c);
    t.previousStyle = u;
    var s = o(u);

    for (var p in (Array.isArray(s.transform) && undefined !== n && (s.transform = n(s.transform)), s)) t.style[p] = s[p];
  };

exports.default = l;
