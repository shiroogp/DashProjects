var module571 = require('./571');

module.exports = function (t) {
  var o = new t.constructor(t.byteLength);
  new module571(o).set(new module571(t));
  return o;
};
