require('./1210');

require('./1218');

require('./1211');

require('./1219');

module.exports = function (n, t) {
  function u(n, t) {
    return n;
  }

  u.meta = {
    kind: 'irreducible',
    name: n,
    predicate: t,
    identity: true,
  };
  u.displayName = n;
  u.is = t;
  return u;
};
