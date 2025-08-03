var module37 = require('./37'),
  module39 = require('./39'),
  module98 = require('./98'),
  module99 = require('./99');

function c(f) {
  var p = 'function' == typeof Map ? new Map() : undefined;

  module.exports = c = function (c) {
    if (null === c || !module98(c)) return c;
    if ('function' != typeof c) throw new TypeError('Super expression must either be null or a function');

    if (undefined !== p) {
      if (p.has(c)) return p.get(c);
      p.set(c, f);
    }

    function f() {
      return module99(c, arguments, module37(this).constructor);
    }

    f.prototype = Object.create(c.prototype, {
      constructor: {
        value: f,
        enumerable: false,
        writable: true,
        configurable: true,
      },
    });
    return module39(f, c);
  };

  return c(f);
}

module.exports = c;
