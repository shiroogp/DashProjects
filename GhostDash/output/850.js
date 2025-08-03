var module841 = require('./841');

module.exports = function (t) {
  if ('string' == typeof t || module841(t)) return t;
  var f = t + '';
  return '0' == f && 1 / t == -1 / 0 ? '-0' : f;
};
