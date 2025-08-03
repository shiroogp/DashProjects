var module524 = require('./524');

module.exports = function (_) {
  var n = this.__data__,
    o = module524(n, _);
  return o < 0 ? undefined : n[o][1];
};
