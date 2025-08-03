var module602 = require('./602'),
  module534 = require('./534'),
  module603 = require('./603'),
  module604 = require('./604'),
  module605 = require('./605'),
  module538 = require('./538'),
  module547 = require('./547'),
  u = module547(module602),
  w = module547(module534),
  f = module547(module603),
  p = module547(module604),
  v = module547(module605),
  M = module538;

if (
  (module602 && '[object DataView]' != M(new module602(new ArrayBuffer(1)))) ||
  (module534 && '[object Map]' != M(new module534())) ||
  (module603 && '[object Promise]' != M(module603.resolve())) ||
  (module604 && '[object Set]' != M(new module604())) ||
  (module605 && '[object WeakMap]' != M(new module605()))
)
  M = function (t) {
    var c = module538(t),
      o = '[object Object]' == c ? t.constructor : undefined,
      n = o ? module547(o) : '';
    if (n)
      switch (n) {
        case u:
          return '[object DataView]';

        case w:
          return '[object Map]';

        case f:
          return '[object Promise]';

        case p:
          return '[object Set]';

        case v:
          return '[object WeakMap]';
      }
    return c;
  };
module.exports = M;
