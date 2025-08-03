var module578 = require('./578'),
  module841 = require('./841'),
  o = /\.|\[(?:[^[\]]*|(["'])(?:(?!\1)[^\\]|\\.)*?\1)\]/,
  u = /^\w*$/;

module.exports = function (l, b) {
  if (module578(l)) return false;
  var f = typeof l;
  return !('number' != f && 'symbol' != f && 'boolean' != f && null != l && !module841(l)) || u.test(l) || !o.test(l) || (null != b && l in Object(b));
};
