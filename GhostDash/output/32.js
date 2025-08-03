exports.createStringifySafeWithLimits = l;

var module6 = require('./6');

function o(t, n) {
  var o = ('undefined' != typeof Symbol && t[Symbol.iterator]) || t['@@iterator'];
  if (o) return (o = o.call(t)).next.bind(o);

  if (Array.isArray(t) || (o = u(t)) || (n && t && 'number' == typeof t.length)) {
    if (o) t = o;
    var f = 0;
    return function () {
      return f >= t.length
        ? {
            done: true,
          }
        : {
            done: false,
            value: t[f++],
          };
    };
  }

  throw new TypeError('Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.');
}

function u(t, n) {
  if (t) {
    if ('string' == typeof t) return f(t, n);
    var o = Object.prototype.toString.call(t).slice(8, -1);
    if ('Object' === o && t.constructor) o = t.constructor.name;
    return 'Map' === o || 'Set' === o ? Array.from(t) : 'Arguments' === o || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(o) ? f(t, n) : undefined;
  }
}

function f(t, n) {
  if (null == n || n > t.length) n = t.length;

  for (var o = 0, u = new Array(n); o < n; o++) u[o] = t[o];

  return u;
}

function l(t) {
  var u = t.maxDepth,
    f = undefined === u ? Number.POSITIVE_INFINITY : u,
    l = t.maxStringLimit,
    c = undefined === l ? Number.POSITIVE_INFINITY : l,
    s = t.maxArrayLimit,
    y = undefined === s ? Number.POSITIVE_INFINITY : s,
    h = t.maxObjectKeysLimit,
    v = undefined === h ? Number.POSITIVE_INFINITY : h,
    b = [];

  function I(t, u) {
    for (; b.length && this !== b[0]; ) b.shift();

    if ('string' == typeof u) {
      return u.length > c + '...(truncated)...'.length ? u.substring(0, c) + '...(truncated)...' : u;
    }

    if ('object' != typeof u || null === u) return u;
    var l = u;
    if (Array.isArray(u))
      b.length >= f
        ? (l = '[ ... array with ' + u.length + ' values ... ]')
        : u.length > y && (l = u.slice(0, y).concat(['... extra ' + (u.length - y) + ' values truncated ...']));
    else {
      module6.default('object' == typeof u, 'This was already found earlier');
      var s = Object.keys(u);
      if (b.length >= f) l = '{ ... object with ' + s.length + ' keys ... }';
      else if (s.length > v) {
        l = {};

        for (var h, I = o(s.slice(0, v)); !(h = I()).done; ) {
          var p = h.value;
          l[p] = u[p];
        }

        l['...(truncated keys)...'] = s.length - v;
      }
    }
    b.unshift(l);
    return l;
  }

  return function (t) {
    if (undefined === t) return 'undefined';
    if (null === t) return 'null';
    if ('function' == typeof t)
      try {
        return t.toString();
      } catch (t) {
        return '[function unknown]';
      }
    else {
      if (t instanceof Error) return t.name + ': ' + t.message;

      try {
        var n = JSON.stringify(t, I);
        return undefined === n ? '["' + typeof t + '" failed to stringify]' : n;
      } catch (n) {
        if ('function' == typeof t.toString)
          try {
            return t.toString();
          } catch (t) {}
      }
    }
    return '["' + typeof t + '" failed to stringify]';
  };
}

var c = l({
  maxDepth: 10,
  maxStringLimit: 100,
  maxArrayLimit: 50,
  maxObjectKeysLimit: 50,
});
exports.default = c;
