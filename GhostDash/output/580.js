module.exports = function (n, t) {
  for (var o = -1, u = null == n ? 0 : n.length, f = 0, l = []; ++o < u; ) {
    var c = n[o];
    if (t(c, o, n)) l[f++] = c;
  }

  return l;
};
