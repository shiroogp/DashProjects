var t = Function.prototype.toString;

module.exports = function (n) {
  if (null != n) {
    try {
      return t.call(n);
    } catch (t) {}

    try {
      return n + '';
    } catch (t) {}
  }

  return '';
};
