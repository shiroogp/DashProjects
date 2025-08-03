module.exports = function (n, o) {
  for (var t in o) o.hasOwnProperty(t) && (n[t] = o[t]);

  return n;
};
