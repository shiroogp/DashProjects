var n = 9007199254740991,
  t = /^(?:0|[1-9]\d*)$/;

module.exports = function (o, u) {
  var f = typeof o;
  return !!(u = null == u ? n : u) && ('number' == f || ('symbol' != f && t.test(o))) && o > -1 && o % 1 == 0 && o < u;
};
