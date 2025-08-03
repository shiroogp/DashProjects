exports.default = function (n) {
  n = n.replace(/\\u([\d\w]{4})/gi, function (n, t) {
    return String.fromCharCode(parseInt(t, 16));
  });
  return unescape(n);
};
