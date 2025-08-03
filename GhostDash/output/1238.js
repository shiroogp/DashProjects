var module1221 = require('./1221');

module.exports = function (t, o) {
  return module1221(o) ? o.is(t) : t instanceof o;
};
