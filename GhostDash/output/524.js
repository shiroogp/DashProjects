var module525 = require('./525');

module.exports = function (t, f) {
  for (var o = t.length; o--; ) if (module525(t[o][0], f)) return o;

  return -1;
};
