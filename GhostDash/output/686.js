exports.default = function (t) {
  var n = t.getState,
    o = t.emitter,
    c = t.beforeRemoveListeners,
    y = React.useContext(module661.default).addKeyedListener,
    p = React.useContext(module675.default),
    s = null == p ? undefined : p.key;
  React.useEffect(
    function () {
      if (s)
        return null == y
          ? undefined
          : y('beforeRemove', s, function (t) {
              var u = n();
              return j(o, c, u.routes, t);
            });
    },
    [y, c, o, n, s]
  );
};

var module50 = require('./50'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = c(n);
    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      f = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var l in t)
      if ('default' !== l && Object.prototype.hasOwnProperty.call(t, l)) {
        var y = f ? Object.getOwnPropertyDescriptor(t, l) : null;
        if (y && (y.get || y.set)) Object.defineProperty(u, l, y);
        else u[l] = t[l];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  module661 = require('./661'),
  module675 = require('./675');

function c(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (c = function (t) {
    return t ? o : n;
  })(t);
}

function y(t, n) {
  var o = ('undefined' != typeof Symbol && t[Symbol.iterator]) || t['@@iterator'];
  if (o) return (o = o.call(t)).next.bind(o);

  if (Array.isArray(t) || (o = p(t)) || (n && t && 'number' == typeof t.length)) {
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

function p(t, n) {
  if (t) {
    if ('string' == typeof t) return s(t, n);
    var o = Object.prototype.toString.call(t).slice(8, -1);
    if ('Object' === o && t.constructor) o = t.constructor.name;
    return 'Map' === o || 'Set' === o ? Array.from(t) : 'Arguments' === o || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(o) ? s(t, n) : undefined;
  }
}

function s(t, n) {
  if (null == n || n > t.length) n = t.length;

  for (var o = 0, u = new Array(n); o < n; o++) u[o] = t[o];

  return u;
}

function v(t, n) {
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

function b(t) {
  for (var o = 1; o < arguments.length; o++) {
    var u = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      v(Object(u), true).forEach(function (o) {
        module50.default(t, o, u[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      v(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
}

var O = Symbol('VISITED_ROUTE_KEYS'),
  j = (exports.shouldPreventRemove = function (t, u, f, l) {
    for (var c, p, s = module23.default(f).reverse(), v = null != (c = l[O]) ? c : new Set(), j = b(b({}, l), {}, module50.default({}, O, v)), P = y(s); !(p = P()).done; ) {
      var h,
        w = p.value;

      if (!v.has(w.key)) {
        if (null == (h = u[w.key]) ? undefined : h.call(u, j)) return true;
        if (
          (v.add(w.key),
          t.emit({
            type: 'beforeRemove',
            target: w.key,
            data: {
              action: j,
            },
            canPreventDefault: true,
          }).defaultPrevented)
        )
          return true;
      }
    }

    return false;
  });
