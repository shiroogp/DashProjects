var module1298 = f(require('./1298')),
  module1299 = f(require('./1299')),
  module1300 = f(require('./1300')),
  module1301 = f(require('./1301')),
  module1302 = f(require('./1302'));

function p(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (p = function (t) {
    return t ? o : n;
  })(t);
}

function f(t, n) {
  if (!n && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var o = p(n);
  if (o && o.has(t)) return o.get(t);
  var u = {
      __proto__: null,
    },
    c = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var f in t)
    if ('default' !== f && Object.prototype.hasOwnProperty.call(t, f)) {
      var s = c ? Object.getOwnPropertyDescriptor(t, f) : null;
      if (s && (s.get || s.set)) Object.defineProperty(u, f, s);
      else u[f] = t[f];
    }

  u.default = t;
  if (o) o.set(t, u);
  return u;
}

exports.getSkin = function (p, f) {
  switch (String(f.skin).trim().toLowerCase()) {
    case 'clean':
      return module1298.getProps(f);

    case 'modern':
      return module1299.getProps(f);

    case 'paper':
      return module1300.getProps(f);

    case 'round':
      return module1301.getProps(f);

    case 'square':
      return module1302.getProps(f);

    default:
      return {};
  }
};
