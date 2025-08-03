var module811 = require('./811');

module.exports = function (o, _, t) {
  if ('__proto__' == _ && module811)
    module811(o, _, {
      configurable: true,
      enumerable: true,
      value: t,
      writable: true,
    });
  else o[_] = t;
};
