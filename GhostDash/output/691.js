exports.default = function (n, t) {
  return (
    n.length === t.length &&
    n.every(function (n, u) {
      return n === t[u];
    })
  );
};
