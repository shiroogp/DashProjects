module.exports = function (n) {
  var t = null == n ? 0 : n.length;
  return t ? n[t - 1] : undefined;
};
