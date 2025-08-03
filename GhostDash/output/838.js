var module839 = require('./839'),
  module847 = require('./847'),
  module848 = require('./848'),
  module850 = require('./850');

module.exports = function (o, c) {
  c = module839(c, o);
  return null == (o = module848(o, c)) || delete o[module850(module847(c))];
};
