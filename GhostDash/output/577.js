module.exports = function (n, t) {
  for (var o = -1, f = t.length, u = n.length; ++o < f; ) n[u + o] = t[o];

  return n;
};
