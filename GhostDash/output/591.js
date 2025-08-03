var module592 = require('./592'),
  module594 = require('./594'),
  module595 = require('./595'),
  s = module595 && module595.isTypedArray,
  t = s ? module594(s) : module592;

module.exports = t;
