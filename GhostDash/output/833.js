var module544 = require('./544'),
  n = Object.create,
  o = (function () {
    function o() {}

    return function (u) {
      if (!module544(u)) return {};
      if (n) return n(u);
      o.prototype = u;
      var c = new o();
      o.prototype = undefined;
      return c;
    };
  })();

module.exports = o;
