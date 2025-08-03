module.exports = function (n) {
  return n.displayName || n.name || '<function' + n.length + '>';
};
