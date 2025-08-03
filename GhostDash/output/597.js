var t = Object.prototype;

module.exports = function (o) {
  var n = o && o.constructor;
  return o === (('function' == typeof n && n.prototype) || t);
};
