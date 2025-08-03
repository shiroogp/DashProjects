module.exports = function (n, t) {
  for (var o = -1, u = null == n ? 0 : n.length, f = Array(u); ++o < u; ) f[o] = t(n[o], o, n);

  return f;
};
