var module862 = require('./862'),
  module811 = require('./811'),
  module863 = require('./863'),
  o = module811
    ? function (u, o) {
        return module811(u, 'toString', {
          configurable: true,
          enumerable: false,
          value: module862(o),
          writable: true,
        });
      }
    : module863;

module.exports = o;
