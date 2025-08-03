module.exports = function (n, t) {
  var o = -1,
    f = n.length;

  for (t || (t = Array(f)); ++o < f; ) t[o] = n[o];

  return t;
};
