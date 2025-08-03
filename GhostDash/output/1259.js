require('./1210');

require('./1235');

require('./1248');

require('./1212');

require('./1226');

require('./1257');

var module1229 = require('./1229'),
  module1223 = require('./1223'),
  module1222 = require('./1222'),
  module1237 = require('./1237'),
  module1215 = require('./1215'),
  module1220 = require('./1220'),
  module1221 = require('./1221');

function l(n, t) {
  return '(' + n.map(module1220).join(', ') + ') => ' + module1220(t);
}

function p(t) {
  return module1229.is(t) && module1222(t.instrumentation);
}

function y(n) {
  for (var t = n.length, o = false, u = t - 1; u >= 0; u--) {
    var c = n[u];
    if (!module1221(c) || 'maybe' !== c.meta.kind) return u + 1;
    o = true;
  }

  return o ? 0 : t;
}

function v(n, o, f) {
  n = module1223(n) ? n : [n];
  var s = f || l(n, o),
    h = n.length;
  y(n);

  function N(n, t) {
    return p(n) ? n : N.of(n);
  }

  N.meta = {
    kind: 'func',
    domain: n,
    codomain: o,
    name: f,
    identity: true,
  };
  N.displayName = s;

  N.is = function (t) {
    return (
      p(t) &&
      t.instrumentation.domain.length === h &&
      t.instrumentation.domain.every(function (t, o) {
        return t === n[o];
      }) &&
      t.instrumentation.codomain === o
    );
  };

  N.of = function (t, f) {
    if (N.is(t)) return t;

    function s() {
      var c = Array.prototype.slice.call(arguments),
        s = c.length;

      if (f && s < h) {
        var l = Function.prototype.bind.apply(t, [this].concat(c));
        return v(n.slice(s), o).of(l, true);
      }

      return module1237(o, t.apply(this, c));
    }

    s.instrumentation = {
      domain: n,
      codomain: o,
      f: t,
    };
    s.displayName = module1215(t);
    return s;
  };

  return N;
}

v.getDefaultName = l;
v.getOptionalArgumentsIndex = y;
module.exports = v;
