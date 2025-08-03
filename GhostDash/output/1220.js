var module1221 = require('./1221'),
  module1215 = require('./1215');

module.exports = function (o) {
  return module1221(o) ? o.displayName : module1215(o);
};
