var module539 = require('./539'),
  module571 = require('./571'),
  module525 = require('./525'),
  module564 = require('./564'),
  module572 = require('./572'),
  module573 = require('./573'),
  f = 1,
  u = 2,
  j = '[object Boolean]',
  y = '[object Date]',
  l = '[object Error]',
  v = '[object Map]',
  h = '[object Number]',
  p = '[object RegExp]',
  w = '[object Set]',
  L = '[object String]',
  O = '[object Symbol]',
  S = '[object ArrayBuffer]',
  x = '[object DataView]',
  z = module539 ? module539.prototype : undefined,
  B = z ? z.valueOf : undefined;

module.exports = function (t, z, D, E, _, A, M) {
  switch (D) {
    case x:
      if (t.byteLength != z.byteLength || t.byteOffset != z.byteOffset) return false;
      t = t.buffer;
      z = z.buffer;

    case S:
      return !(t.byteLength != z.byteLength || !A(new module571(t), new module571(z)));

    case j:
    case y:
    case h:
      return module525(+t, +z);

    case l:
      return t.name == z.name && t.message == z.message;

    case p:
    case L:
      return t == z + '';

    case v:
      var N = module572;

    case w:
      var R = E & f;
      if ((N || (N = module573), t.size != z.size && !R)) return false;
      var V = M.get(t);
      if (V) return V == z;
      E |= u;
      M.set(t, z);
      var k = module564(N(t), N(z), E, _, A, M);
      M.delete(t);
      return k;

    case O:
      if (B) return B.call(t) == B.call(z);
  }

  return false;
};
