require('./1210');

require('./1211');

require('./1223');

require('./1254');

require('./1255');

var module1245 = require('./1245'),
  module1222 = require('./1222'),
  module1234 = require('./1234'),
  module1256 = require('./1256');

function u(t, n, p) {
  var u = t.reduce(function (t, n) {
    return module1234(t, n);
  }, n);

  if (p) {
    u.displayName = p;
    u.meta.name = p;
  }

  return u;
}

function f(t) {
  return module1222(t) ? null : t.meta.defaultProps;
}

module.exports = function (o, s, c) {
  var l = {},
    y = {},
    v = [],
    P = {};
  s.forEach(function (o, u) {
    var s,
      c,
      h,
      _ = module1256(o),
      x = _.unrefinedType;

    s = v;
    c = _.predicates;
    Array.prototype.push.apply(s, c);
    module1245(l, module1222((h = x)) ? h : h.meta.props);
    module1245(y, x.prototype);
    module1245(P, f(x), true);
  });
  (c = o.getOptions(c)).defaultProps = module1245(P, c.defaultProps, true);
  var h = u(
    v,
    o(l, {
      strict: c.strict,
      defaultProps: c.defaultProps,
    }),
    c.name
  );
  module1245(h.prototype, y);
  return h;
};
