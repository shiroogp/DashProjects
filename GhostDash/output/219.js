var module220 = require('./220');

module.exports = function (t) {
  var o,
    s = {};

  for (o in ((t instanceof Object && !Array.isArray(t)) || module220(false), t)) t.hasOwnProperty(o) && (s[o] = o);

  return s;
};
