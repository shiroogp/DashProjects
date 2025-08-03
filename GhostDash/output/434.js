exports.default = function (t) {
  var n = t.getForwardedRef,
    o = t.setLocalRef;
  return function (t) {
    var f = n();
    o(t);
    if ('function' == typeof f) f(t);
    else if ('object' == typeof f && null != f) f.current = t;
  };
};
