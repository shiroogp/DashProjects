exports.default = function (n, t) {
  var o;
  return function (...args) {
    if (!o) {
      n.apply(this, args);
      o = setTimeout(function () {
        o = undefined;
      }, t);
    }
  };
};
