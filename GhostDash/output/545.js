var n,
  module546 = require('./546'),
  o = (n = /[^.]+$/.exec((module546 && module546.keys && module546.keys.IE_PROTO) || '')) ? 'Symbol(src)_1.' + n : '';

module.exports = function (n) {
  return !!o && o in n;
};
