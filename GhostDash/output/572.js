module.exports = function (n) {
  var o = -1,
    t = Array(n.size);
  n.forEach(function (n, c) {
    t[++o] = [c, n];
  });
  return t;
};
