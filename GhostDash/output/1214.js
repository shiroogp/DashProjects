var module1215 = require('./1215');

function t(t, u) {
  return 'function' == typeof u ? module1215(u) : u;
}

module.exports = function (n) {
  try {
    return JSON.stringify(n, t, 2);
  } catch (t) {
    return String(n);
  }
};
