var module597 = require('./597'),
  module598 = require('./598'),
  o = Object.prototype.hasOwnProperty;

module.exports = function (c) {
  if (!module597(c)) return module598(c);
  var u = [];

  for (var p in Object(c)) o.call(c, p) && 'constructor' != p && u.push(p);

  return u;
};
