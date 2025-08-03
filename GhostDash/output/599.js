module.exports = function (n, t) {
  return function (u) {
    return n(t(u));
  };
};
