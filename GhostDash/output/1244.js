require('./1210');

require('./1235');

require('./1221');

require('./1212');

var module1245 = require('./1245'),
  module1220 = require('./1220'),
  module1246 = require('./1246'),
  o = 1;

module.exports = function (y) {
  var s;

  function u(t, n) {
    return s(t, n);
  }

  u.define = function (n) {
    if (module1246(n) && u.hasOwnProperty('dispatch')) n.dispatch = u.dispatch;
    module1245(u, (s = n), true);

    if (y) {
      s.displayName = u.displayName = y;
      u.meta.name = y;
    }

    u.meta.identity = s.meta.identity;
    u.prototype = s.prototype;
    return u;
  };

  u.displayName = y || module1220(u) + '$' + o++;
  u.meta = {
    identity: false,
  };
  u.prototype = null;
  return u;
};
