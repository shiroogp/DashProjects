var module521 = require('./521'),
  module534 = require('./534'),
  module549 = require('./549');

module.exports = function (n, h) {
  var f = this.__data__;

  if (f instanceof module521) {
    var u = f.__data__;

    if (!module534 || u.length < 199) {
      u.push([n, h]);
      this.size = ++f.size;
      return this;
    }

    f = this.__data__ = new module549(u);
  }

  f.set(n, h);
  this.size = f.size;
  return this;
};
