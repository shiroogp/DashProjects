var module586 = require('./586'),
  module587 = require('./587'),
  l = Object.prototype,
  c = l.hasOwnProperty,
  o = l.propertyIsEnumerable,
  p = module586(
    (function () {
      return arguments;
    })()
  )
    ? module586
    : function (t) {
        return module587(t) && c.call(t, 'callee') && !o.call(t, 'callee');
      };

module.exports = p;
