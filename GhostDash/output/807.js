var module520 = require('./520'),
  module808 = require('./808'),
  module809 = require('./809'),
  module812 = require('./812'),
  module814 = require('./814'),
  module818 = require('./818'),
  module819 = require('./819'),
  module820 = require('./820'),
  module821 = require('./821'),
  module575 = require('./575'),
  module824 = require('./824'),
  module601 = require('./601'),
  module825 = require('./825'),
  module826 = require('./826'),
  module832 = require('./832'),
  module578 = require('./578'),
  module588 = require('./588'),
  module834 = require('./834'),
  module544 = require('./544'),
  module836 = require('./836'),
  module582 = require('./582'),
  module815 = require('./815'),
  B = 1,
  D = 2,
  M = 4,
  _ = '[object Arguments]',
  k = '[object Function]',
  C = '[object GeneratorFunction]',
  G = '[object Object]',
  N = {};

N[_] = N['[object Array]'] = N['[object ArrayBuffer]'] = N['[object DataView]'] = N['[object Boolean]'] = N['[object Date]'] = N['[object Float32Array]'] = N[
  '[object Float64Array]'
] = N['[object Int8Array]'] = N['[object Int16Array]'] = N['[object Int32Array]'] = N['[object Map]'] = N['[object Number]'] = N[G] = N['[object RegExp]'] = N['[object Set]'] = N[
  '[object String]'
] = N['[object Symbol]'] = N['[object Uint8Array]'] = N['[object Uint8ClampedArray]'] = N['[object Uint16Array]'] = N['[object Uint32Array]'] = true;
N['[object Error]'] = N[k] = N['[object WeakMap]'] = false;

module.exports = function O(R, V, W, q, z, H) {
  var J,
    K = V & B,
    L = V & D,
    P = V & M;
  if ((W && (J = z ? W(R, q, z, H) : W(R)), undefined !== J)) return J;
  if (!module544(R)) return R;
  var Q = module578(R);

  if (Q) {
    if (((J = module825(R)), !K)) return module819(R, J);
  } else {
    var T = module601(R),
      X = T == k || T == C;
    if (module588(R)) return module818(R, K);

    if (T == G || T == _ || (X && !z)) {
      if (((J = L || X ? {} : module832(R)), !K)) return L ? module821(R, module814(J, R)) : module820(R, module812(J, R));
    } else {
      if (!N[T]) return z ? R : {};
      J = module826(R, T, K);
    }
  }

  if (!H) H = new module520();
  var Y = H.get(R);
  if (Y) return Y;
  H.set(R, J);
  if (module836(R))
    R.forEach(function (t) {
      J.add(O(t, V, W, t, R, H));
    });
  else if (module834(R))
    R.forEach(function (t, o) {
      J.set(o, O(t, V, W, o, R, H));
    });
  var Z = Q ? undefined : (P ? (L ? module824 : module575) : L ? module815 : module582)(R);
  module808(Z || R, function (t, o) {
    if (Z) t = R[(o = t)];
    module809(J, o, O(t, V, W, o, R, H));
  });
  return J;
};
