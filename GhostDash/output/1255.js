var module1221 = require('./1221');

module.exports = function (t) {
  return module1221(t) && 'interface' === t.meta.kind;
};
