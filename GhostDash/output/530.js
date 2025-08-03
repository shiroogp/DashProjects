module.exports = function (t) {
  var _ = this.__data__,
    n = _.delete(t);

  this.size = _.size;
  return n;
};
