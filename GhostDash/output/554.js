module.exports = function (t) {
  var s = this.has(t) && delete this.__data__[t];
  this.size -= s ? 1 : 0;
  return s;
};
