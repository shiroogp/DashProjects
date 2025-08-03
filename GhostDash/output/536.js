var module537 = require('./537'),
  module545 = require('./545'),
  module544 = require('./544'),
  module547 = require('./547'),
  p = /^\[object .+?Constructor\]$/,
  u = Function.prototype,
  s = Object.prototype,
  $ = u.toString,
  f = s.hasOwnProperty,
  l = RegExp(
    '^' +
      $.call(f)
        .replace(/[\\^$.*+?()[\]{}|]/g, '\\$&')
        .replace(/hasOwnProperty|(function).*?(?=\\\()| for .+?(?=\\\])/g, '$1.*?') +
      '$'
  );

module.exports = function (u) {
  return !(!module544(u) || module545(u)) && (module537(u) ? l : p).test(module547(u));
};
