var module551 = require('./551'),
  module521 = require('./521'),
  module534 = require('./534');

module.exports = function () {
  this.size = 0;
  this.__data__ = {
    hash: new module551(),
    map: new (module534 || module521)(),
    string: new module551(),
  };
};
