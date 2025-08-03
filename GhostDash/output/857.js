var module539 = require('./539'),
  module585 = require('./585'),
  module578 = require('./578'),
  c = module539 ? module539.isConcatSpreadable : undefined;

module.exports = function (n) {
  return module578(n) || module585(n) || !!(c && n && n[c]);
};
