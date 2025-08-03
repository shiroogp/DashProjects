module.exports = function (n) {
  return 'number' == typeof n && isFinite(n) && !isNaN(n);
};
