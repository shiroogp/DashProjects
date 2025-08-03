var module1212 = require('./1212');

require('./1210');

module.exports = function (t, o, f) {
  if (module1212(o)) return t;

  for (var u in o) o.hasOwnProperty(u) && (t[u] = o[u]);

  return t;
};
