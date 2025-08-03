module.exports = function (n, t) {
  for (var o = -1, u = null == n ? 0 : n.length; ++o < u && false !== t(n[o], o, n); );

  return n;
};
