var module1221 = require('./1221');

require('./1215');

require('./1210');

require('./1214');

module.exports = function (n, o, u) {
  return module1221(n) ? (n.meta.identity || 'object' != typeof o || null === o ? n(o, u) : new n(o, u)) : o;
};
