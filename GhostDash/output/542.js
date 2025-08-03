var module539 = require('./539'),
  o = Object.prototype,
  n = o.hasOwnProperty,
  c = o.toString,
  l = module539 ? module539.toStringTag : undefined;

module.exports = function (t) {
  var o = n.call(t, l),
    v = t[l];

  try {
    t[l] = undefined;
  } catch (t) {}

  var p = c.call(t);
  if (o) t[l] = v;
  else delete t[l];
  return p;
};
