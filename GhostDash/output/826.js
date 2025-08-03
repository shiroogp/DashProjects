var module827 = require('./827'),
  module828 = require('./828'),
  module829 = require('./829'),
  module830 = require('./830'),
  module831 = require('./831'),
  b = '[object Boolean]',
  j = '[object Date]',
  u = '[object Map]',
  y = '[object Number]',
  A = '[object RegExp]',
  w = '[object Set]',
  l = '[object String]',
  f = '[object Symbol]',
  p = '[object ArrayBuffer]',
  U = '[object DataView]',
  I = '[object Float32Array]',
  S = '[object Float64Array]',
  v = '[object Int8Array]',
  x = '[object Int16Array]',
  B = '[object Int32Array]',
  D = '[object Uint8Array]',
  F = '[object Uint8ClampedArray]',
  _ = '[object Uint16Array]',
  h = '[object Uint32Array]';

module.exports = function (C, E, M) {
  var N = C.constructor;

  switch (E) {
    case p:
      return module827(C);

    case b:
    case j:
      return new N(+C);

    case U:
      return module828(C, M);

    case I:
    case S:
    case v:
    case x:
    case B:
    case D:
    case F:
    case _:
    case h:
      return module831(C, M);

    case u:
      return new N();

    case y:
    case l:
      return new N(C);

    case A:
      return module829(C);

    case w:
      return new N();

    case f:
      return module830(C);
  }
};
