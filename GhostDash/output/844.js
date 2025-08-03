var module549 = require('./549'),
  t = 'Expected a function';

function c(o, f) {
  if ('function' != typeof o || (null != f && 'function' != typeof f)) throw new TypeError(t);

  var u = function n() {
    var t = arguments,
      c = f ? f.apply(this, t) : t[0],
      u = n.cache;
    if (u.has(c)) return u.get(c);
    var h = o.apply(this, t);
    n.cache = u.set(c, h) || u;
    return h;
  };

  u.cache = new (c.Cache || module549)();
  return u;
}

c.Cache = module549;
module.exports = c;
