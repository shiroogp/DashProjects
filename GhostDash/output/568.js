module.exports = function (n, t) {
  for (var u = -1, f = null == n ? 0 : n.length; ++u < f; ) if (t(n[u], u, n)) return true;

  return false;
};
