exports.getConfigWithoutViewProps = function (t, f) {
  if (!t[f]) return {};
  return Object.keys(t[f])
    .filter(function (t) {
      return !module190.default[f][t];
    })
    .reduce(function (n, o) {
      n[o] = t[f][o];
      return n;
    }, {});
};

exports.lefthandObjectDiff = u;

exports.stringifyViewConfig = function (t) {
  return JSON.stringify(
    t,
    function (t, n) {
      return 'function' == typeof n ? '\u0192 ' + n.name : n;
    },
    2
  );
};

var module190 = require('./190'),
  module180 = require('./180'),
  o = ['transform', 'hitSlop'];

function u(t, n) {
  var f = {};

  function c(t, n, o) {
    if (typeof t == typeof n || null == t) {
      if ('object' != typeof t) t === n || (f[o] = n);
      else {
        var c = u(t, n);
        if (Object.keys(c).length > 1) f[o] = c;
      }
    } else f[o] = n;
  }

  for (var s in t) o.includes(s) || (n ? t.hasOwnProperty(s) && c(t[s], n[s], s) : (f[s] = {}));

  return f;
}

exports.default = function (t, n) {
  if (!globals.RN$Bridgeless) {
    var o = module180(t);
    ['validAttributes', 'bubblingEventTypes', 'directEventTypes'].forEach(function (f) {
      var c = Object.keys(u(o[f], n[f]));
      if (c.length) console.error(t + ' generated view config for ' + f + ' does not match native, missing: ' + c.join(' '));
    });
  }
};
