var module39 = require('./39'),
  module100 = require('./100');

function p(o, u, l) {
  if (module100()) module.exports = p = Reflect.construct;
  else
    module.exports = p = function (t, p, o) {
      var u = [null];
      u.push.apply(u, p);
      var l = new (Function.bind.apply(t, u))();
      if (o) module39(l, o.prototype);
      return l;
    };
  return p.apply(null, arguments);
}

module.exports = p;
