var t, n;
t = this;

n = function () {
  'use strict';

  var t = function (t) {
    return n(t) && !o(t);
  };

  function n(t) {
    return !!t && 'object' == typeof t;
  }

  function o(t) {
    var n = Object.prototype.toString.call(t);
    return '[object RegExp]' === n || '[object Date]' === n || u(t);
  }

  var c = 'function' == typeof Symbol && Symbol.for ? Symbol.for('react.element') : 60103;

  function u(t) {
    return t.$$typeof === c;
  }

  function f(t, n) {
    return false !== n.clone && n.isMergeableObject(t) ? j(((o = t), Array.isArray(o) ? [] : {}), t, n) : t;
    var o;
  }

  function y(t, n, o) {
    return t.concat(n).map(function (t) {
      return f(t, o);
    });
  }

  function b(t, n) {
    if (!n.customMerge) return j;
    var o = n.customMerge(t);
    return 'function' == typeof o ? o : j;
  }

  function s(t) {
    return Object.getOwnPropertySymbols
      ? Object.getOwnPropertySymbols(t).filter(function (n) {
          return t.propertyIsEnumerable(n);
        })
      : [];
  }

  function l(t) {
    return Object.keys(t).concat(s(t));
  }

  function p(t, n, o) {
    var c = {};
    if (o.isMergeableObject(t))
      l(t).forEach(function (n) {
        c[n] = f(t[n], o);
      });
    l(n).forEach(function (u) {
      if (o.isMergeableObject(n[u]) && t[u]) c[u] = b(u, o)(t[u], n[u], o);
      else c[u] = f(n[u], o);
    });
    return c;
  }

  function j(n, o, c) {
    (c = c || {}).arrayMerge = c.arrayMerge || y;
    c.isMergeableObject = c.isMergeableObject || t;
    var u = Array.isArray(o);
    return u === Array.isArray(n) ? (u ? c.arrayMerge(n, o, c) : p(n, o, c)) : f(o, c);
  }

  j.all = function (t, n) {
    if (!Array.isArray(t)) throw new Error('first argument should be an array');
    return t.reduce(function (t, o) {
      return j(t, o, n);
    }, {});
  };

  return j;
};

if ('object' == typeof exports && undefined !== module) module.exports = n();
else if ('function' == typeof define && define.amd) define(n);
else (t = t || self).deepmerge = n();
