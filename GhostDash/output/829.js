var n = /\w*$/;

module.exports = function (t) {
  var c = new t.constructor(t.source, n.exec(t));
  c.lastIndex = t.lastIndex;
  return c;
};
