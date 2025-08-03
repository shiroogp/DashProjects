exports.filterConfig = function (t, n) {
  for (var o, u = v({}, arguments.length > 2 && undefined !== arguments[2] ? arguments[2] : {}), l = s(n); !(o = l()).done; ) {
    var c = o.value,
      f = t[c];
    b = c;

    if (!(undefined === (p = f) || (p === Object(p) && '__isNative' in p) || 'onHandlerStateChange' === b || 'onGestureEvent' === b)) {
      if ('simultaneousHandlers' === c || 'waitFor' === c) f = h(t[c]);
      else if ('hitSlop' === c && 'object' != typeof f)
        f = {
          top: f,
          left: f,
          bottom: f,
          right: f,
        };
      u[c] = f;
    }
  }

  var p, b;
  return u;
};

exports.findNodeHandle = function (t) {
  if ('web' === ReactNative.Platform.OS) return t;
  return ReactNative.findNodeHandle(t);
};

exports.scheduleFlushOperations = function () {
  if (null === O)
    O = requestAnimationFrame(function () {
      module507.default.flushOperations();
      O = null;
    });
};

var module50 = require('./50'),
  ReactNative = require('react-native'),
  module405 = require('./405'),
  module406 = require('./406'),
  module507 = require('./507');

function s(t, n) {
  var o = ('undefined' != typeof Symbol && t[Symbol.iterator]) || t['@@iterator'];
  if (o) return (o = o.call(t)).next.bind(o);

  if (Array.isArray(t) || (o = f(t)) || (n && t && 'number' == typeof t.length)) {
    if (o) t = o;
    var u = 0;
    return function () {
      return u >= t.length
        ? {
            done: true,
          }
        : {
            done: false,
            value: t[u++],
          };
    };
  }

  throw new TypeError('Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.');
}

function f(t, n) {
  if (t) {
    if ('string' == typeof t) return p(t, n);
    var o = Object.prototype.toString.call(t).slice(8, -1);
    if ('Object' === o && t.constructor) o = t.constructor.name;
    return 'Map' === o || 'Set' === o ? Array.from(t) : 'Arguments' === o || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(o) ? p(t, n) : undefined;
  }
}

function p(t, n) {
  if (null == n || n > t.length) n = t.length;

  for (var o = 0, u = new Array(n); o < n; o++) u[o] = t[o];

  return u;
}

function b(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var u = Object.getOwnPropertySymbols(t);
    if (n)
      u = u.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, u);
  }

  return o;
}

function v(t) {
  for (var o = 1; o < arguments.length; o++) {
    var u = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      b(Object(u), true).forEach(function (o) {
        module50.default(t, o, u[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      b(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
}

var y = ['id', 'enabled', 'shouldCancelWhenOutside', 'hitSlop', 'cancelsTouchesInView', 'userSelect'];
exports.baseGestureHandlerProps = [].concat(
  y,
  ['waitFor', 'simultaneousHandlers'],
  ['onBegan', 'onFailed', 'onCancelled', 'onActivated', 'onEnded', 'onGestureEvent', 'onHandlerStateChange']
);
exports.baseGestureHandlerWithMonitorProps = [].concat(y, ['needsPointerData', 'manualActivation']);

function h(t) {
  t = module406.toArray(t);
  return 'web' === ReactNative.Platform.OS
    ? t
        .map(function (t) {
          return t.current;
        })
        .filter(function (t) {
          return t;
        })
    : t
        .map(function (t) {
          var n;
          return module405.handlerIDToTag[t] || (null == (n = t.current) ? undefined : n.handlerTag) || -1;
        })
        .filter(function (t) {
          return t > 0;
        });
}

var O = null;
