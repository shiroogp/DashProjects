module.exports = function (n, t, o) {
  var f = -1,
    u = n.length;
  if (t < 0) t = -t > u ? 0 : u + t;
  if ((o = o > u ? u : o) < 0) o += u;
  u = t > o ? 0 : (o - t) >>> 0;
  t >>>= 0;

  for (var c = Array(u); ++f < u; ) c[f] = n[f + t];

  return c;
};
