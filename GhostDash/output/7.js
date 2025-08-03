var module8 = require('./8'),
  n = {};

module.exports = function (c, o) {
  if (!n[c]) {
    module8(false, o);
    n[c] = true;
  }
};
