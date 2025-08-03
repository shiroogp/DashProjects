var module12 = (function (t, n) {
  if (!n && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var p = o(n);
  if (p && p.has(t)) return p.get(t);
  var c = {
      __proto__: null,
    },
    u = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var f in t)
    if ('default' !== f && Object.prototype.hasOwnProperty.call(t, f)) {
      var s = u ? Object.getOwnPropertyDescriptor(t, f) : null;
      if (s && (s.get || s.set)) Object.defineProperty(c, f, s);
      else c[f] = t[f];
    }

  c.default = t;
  if (p) p.set(t, c);
  return c;
})(require('./12'));

function o(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    p = new WeakMap();
  return (o = function (t) {
    return t ? p : n;
  })(t);
}

require('./52');

var n = module12.getEnforcing('ExceptionsManager'),
  p = {
    reportFatalException: function (t, o, p) {
      n.reportFatalException(t, o, p);
    },
    reportSoftException: function (t, o, p) {
      n.reportSoftException(t, o, p);
    },
    updateExceptionMessage: function (t, o, p) {
      n.updateExceptionMessage(t, o, p);
    },
    dismissRedbox: function () {
      if (n.dismissRedbox) n.dismissRedbox();
    },
    reportException: function (t) {
      if (n.reportException) n.reportException(t);
      else if (t.isFatal) p.reportFatalException(t.message, t.stack, t.id);
      else p.reportSoftException(t.message, t.stack, t.id);
    },
  };
exports.default = p;
