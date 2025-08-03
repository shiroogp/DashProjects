var module1210 = require('./1210'),
  module1211 = require('./1211'),
  module1221 = require('./1221'),
  module1216 = require('./1216');

module.exports = function (c) {
  for (var s, u, h, l = 1, v = arguments.length; l < v; )
    if (
      ((s = arguments[l]), (u = arguments[l + 1]), (h = arguments[l + 2]), module1211(h) && !module1221(h) ? (l += 3) : ((h = u), (u = module1216.is), (l += 2)), s.is(c) && u(c))
    )
      return h(c);

  module1210.fail('Match error');
};
