module.exports = function (n) {
  var t = typeof n;
  return null != n && ('object' == t || 'function' == t);
};
