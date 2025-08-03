var module578 = require('./578'),
  module840 = require('./840'),
  module842 = require('./842'),
  module845 = require('./845');

module.exports = function (c, f) {
  return module578(c) ? c : module840(c, f) ? [c] : module842(module845(c));
};
