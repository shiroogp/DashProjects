module.exports = function (n) {
  var o = -1,
    t = Array(n.size);
  n.forEach(function (n) {
    t[++o] = n;
  });
  return t;
};
