var module524 = require('./524');

module.exports = function (s, _) {
  var n = this.__data__,
    h = module524(n, s);

  if (h < 0) {
    ++this.size;
    n.push([s, _]);
  } else n[h][1] = _;

  return this;
};
