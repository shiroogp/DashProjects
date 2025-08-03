var module540 = require('./540'),
  module589 = require('./589'),
  t = 'object' == typeof exports && exports && !exports.nodeType && exports,
  p = t && 'object' == typeof module && module && !module.nodeType && module,
  n = p && p.exports === t ? module540.Buffer : undefined,
  y = (n ? n.isBuffer : undefined) || module589;

module.exports = y;
