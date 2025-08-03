var module1221 = require('./1221');

function n(n) {
  return module1221(n) && 'subtype' === n.meta.kind;
}

function u(t) {
  return n(t) ? [t.meta.predicate].concat(u(t.meta.type)) : [];
}

function c(t) {
  return n(t) ? c(t.meta.type) : t;
}

module.exports = function (t) {
  return {
    predicates: u(t),
    unrefinedType: c(t),
  };
};
