var n = 9007199254740991;

module.exports = function (t) {
  return 'number' == typeof t && t > -1 && t % 1 == 0 && t <= n;
};
