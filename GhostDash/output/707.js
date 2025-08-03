exports.default = function (t) {
  var n,
    o = t.state,
    s = t.params;
  return o
    ? o.routes[null != (n = o.index) ? n : 'string' == typeof o.type && 'stack' !== o.type ? 0 : o.routes.length - 1].name
    : 'string' == typeof (null == s ? undefined : s.screen)
    ? s.screen
    : undefined;
};
