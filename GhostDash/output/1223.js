module.exports = function (n) {
  return Array.isArray ? Array.isArray(n) : n instanceof Array;
};
