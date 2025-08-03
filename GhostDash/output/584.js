module.exports = function (n, o) {
  for (var t = -1, f = Array(n); ++t < n; ) f[t] = o(t);

  return f;
};
