var n = Object.prototype.hasOwnProperty;

module.exports = function (t) {
  var o = t.length,
    p = new t.constructor(o);

  if (o && 'string' == typeof t[0] && n.call(t, 'index')) {
    p.index = t.index;
    p.input = t.input;
  }

  return p;
};
