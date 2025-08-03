module.exports = function (n) {
  var t = [];
  if (null != n) for (var u in Object(n)) t.push(u);
  return t;
};
