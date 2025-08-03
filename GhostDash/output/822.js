var module577 = require('./577'),
  module823 = require('./823'),
  module579 = require('./579'),
  module581 = require('./581'),
  f = Object.getOwnPropertySymbols
    ? function (c) {
        for (var f = []; c; ) {
          module577(f, module579(c));
          c = module823(c);
        }

        return f;
      }
    : module581;

module.exports = f;
