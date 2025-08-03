var module50 = require('./50');

function n(t, n) {
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

function o(o) {
  for (var c = 1; c < arguments.length; c++) {
    var u = null != arguments[c] ? arguments[c] : {};
    if (c % 2)
      n(Object(u), true).forEach(function (n) {
        module50(o, n, u[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(o, Object.getOwnPropertyDescriptors(u));
    else
      n(Object(u)).forEach(function (t) {
        Object.defineProperty(o, t, Object.getOwnPropertyDescriptor(u, t));
      });
  }

  return o;
}

function c(t, n) {
  var o = ('undefined' != typeof Symbol && t[Symbol.iterator]) || t['@@iterator'];
  if (o) return (o = o.call(t)).next.bind(o);

  if (Array.isArray(t) || (o = u(t)) || (n && t && 'number' == typeof t.length)) {
    if (o) t = o;
    var c = 0;
    return function () {
      return c >= t.length
        ? {
            done: true,
          }
        : {
            done: false,
            value: t[c++],
          };
    };
  }

  throw new TypeError('Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.');
}

function u(t, n) {
  if (t) {
    if ('string' == typeof t) return l(t, n);
    var o = Object.prototype.toString.call(t).slice(8, -1);
    if ('Object' === o && t.constructor) o = t.constructor.name;
    return 'Map' === o || 'Set' === o ? Array.from(t) : 'Arguments' === o || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(o) ? l(t, n) : undefined;
  }
}

function l(t, n) {
  if (null == n || n > t.length) n = t.length;

  for (var o = 0, c = new Array(n); o < n; o++) c[o] = t[o];

  return c;
}

var module112 = require('./112');

function f(t) {
  for (var n, o = [], u = c(t.entries); !(n = u()).done; ) {
    var l = n.value;

    if ('FRAME' === l.type) {
      var s = l.location,
        f = l.functionName;
      if ('NATIVE' !== s.type)
        o.push({
          methodName: f,
          file: s.sourceUrl,
          lineNumber: s.line1Based,
          column: 'SOURCE' === s.type ? s.column1Based - 1 : s.virtualOffset0Based,
        });
    }
  }

  return o;
}

module.exports = function (t) {
  if (!t || !t.stack) return [];

  var module113 = require('./113');

  return Array.isArray(t.stack)
    ? t.stack
    : globals.HermesInternal
    ? f(module112(t.stack))
    : module113.parse(t.stack).map(function (t) {
        return o(
          o({}, t),
          {},
          {
            column: null != t.column ? t.column - 1 : null,
          }
        );
      });
};
