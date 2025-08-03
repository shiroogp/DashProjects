var module1209 = require('./1209'),
  o = module1209.stringify,
  n = {},
  s = module1209.struct(
    {
      message: module1209.Any,
      actual: module1209.Any,
      expected: module1209.Any,
      path: module1209.list(module1209.union([module1209.String, module1209.Number])),
    },
    'ValidationError'
  );

function u(n, s, u) {
  var c = module1209.getTypeName(s),
    l = u.length ? '/' + u.join('/') + ': ' + c : c;
  return 'Invalid value ' + o(n) + ' supplied to ' + l;
}

function c(o, n, s, c) {
  return module1209.Function.is(n.getValidationErrorMessage) ? n.getValidationErrorMessage(o, s, c) : u(o, n, s);
}

s.of = function (t, o, n, u) {
  return new s({
    message: c(t, o, n, u),
    actual: t,
    expected: o,
    path: n,
  });
};

var l = module1209.struct(
  {
    errors: module1209.list(s),
    value: module1209.Any,
  },
  'ValidationResult'
);

function v(o, n, s) {
  s = s || {};
  var u = module1209.Array.is(s) ? s : s.path || [];
  return new l(f(o, n, u, s));
}

function f(o, n, s, u) {
  return module1209.isType(n) ? p[n.meta.kind](o, n, s, u) : p.es6classes(o, n, s, u);
}

l.prototype.isValid = function () {
  return !this.errors.length;
};

l.prototype.firstError = function () {
  return this.isValid() ? null : this.errors[0];
};

l.prototype.toString = function () {
  return this.isValid()
    ? '[ValidationResult, true, ' + o(this.value) + ']'
    : '[ValidationResult, false, (' +
        this.errors
          .map(function (t) {
            return o(t.message);
          })
          .join(', ') +
        ')]';
};

var p = (v.validators = {});

p.es6classes = function (t, o, n, u) {
  return {
    value: t,
    errors: t instanceof o ? [] : [s.of(t, o, n, u.context)],
  };
};

p.irreducible = p.enums = function (t, o, n, u) {
  return {
    value: t,
    errors: o.is(t) ? [] : [s.of(t, o, n, u.context)],
  };
};

p.list = function (o, n, u, c) {
  if (!module1209.Array.is(o))
    return {
      value: o,
      errors: [s.of(o, n, u, c.context)],
    };

  for (
    var l = {
        value: [],
        errors: [],
      },
      v = 0,
      p = o.length;
    v < p;
    v++
  ) {
    var h = f(o[v], n.meta.type, u.concat(v), c);
    l.value[v] = h.value;
    l.errors = l.errors.concat(h.errors);
  }

  return l;
};

p.subtype = function (t, o, n, u) {
  var c = f(t, o.meta.type, n, u);
  if (c.errors.length) return c;
  else {
    if (!o.meta.predicate(c.value)) c.errors = [s.of(t, o, n, u.context)];
    return c;
  }
};

p.maybe = function (o, n, s, u) {
  return module1209.Nil.is(o)
    ? {
        value: o,
        errors: [],
      }
    : f(o, n.meta.type, s, u);
};

p.struct = function (o, u, c, l) {
  if (!module1209.Object.is(o))
    return {
      value: o,
      errors: [s.of(o, u, c, l.context)],
    };
  if (u.is(o))
    return {
      value: o,
      errors: [],
    };
  var v = {
      value: {},
      errors: [],
    },
    p = u.meta.props,
    h = u.meta.defaultProps || n;

  for (var y in p)
    if (p.hasOwnProperty(y)) {
      var x = o[y];
      if (undefined === x) x = h[y];
      var O = f(x, p[y], c.concat(y), l);
      v.value[y] = O.value;
      v.errors = v.errors.concat(O.errors);
    }

  if (l.hasOwnProperty('strict') ? l.strict : u.meta.strict)
    for (var V in o) o.hasOwnProperty(V) && !p.hasOwnProperty(V) && v.errors.push(s.of(o[V], module1209.Nil, c.concat(V), l.context));
  if (!v.errors.length) v.value = new u(v.value);
  return v;
};

p.tuple = function (o, n, u, c) {
  var l = n.meta.types,
    v = l.length;
  if (!module1209.Array.is(o) || o.length > v)
    return {
      value: o,
      errors: [s.of(o, n, u, c.context)],
    };

  for (
    var p = {
        value: [],
        errors: [],
      },
      h = 0;
    h < v;
    h++
  ) {
    var y = f(o[h], l[h], u.concat(h), c);
    p.value[h] = y.value;
    p.errors = p.errors.concat(y.errors);
  }

  return p;
};

p.dict = function (o, n, u, c) {
  if (!module1209.Object.is(o))
    return {
      value: o,
      errors: [s.of(o, n, u, c.context)],
    };
  var l = {
    value: {},
    errors: [],
  };

  for (var v in o)
    if (o.hasOwnProperty(v)) {
      var p = u.concat(v),
        h = f(v, n.meta.domain, p, c),
        y = f(o[v], n.meta.codomain, p, c);
      l.value[v] = y.value;
      l.errors = l.errors.concat(h.errors, y.errors);
    }

  return l;
};

p.union = function (o, n, u, c) {
  var l = n.dispatch(o);
  return module1209.Function.is(l)
    ? f(o, l, u.concat(n.meta.types.indexOf(l)), c)
    : {
        value: o,
        errors: [s.of(o, n, u, c.context)],
      };
};

p.intersection = function (t, o, n, u) {
  for (
    var c = o.meta.types,
      l = c.length,
      v = {
        value: t,
        errors: [],
      },
      p = 0,
      h = 0;
    h < l;
    h++
  ) {
    if ('struct' === c[h].meta.kind) p++;
    var y = f(t, c[h], n, u);
    v.errors = v.errors.concat(y.errors);
  }

  if (p > 1) v.errors.push(s.of(t, o, n, u.context));
  return v;
};

p.interface = function (o, n, u, c) {
  if (!module1209.Object.is(o))
    return {
      value: o,
      errors: [s.of(o, n, u, c.context)],
    };
  var l = {
      value: {},
      errors: [],
    },
    v = n.meta.props;

  for (var p in v) {
    var h = f(o[p], v[p], u.concat(p), c);
    l.value[p] = h.value;
    l.errors = l.errors.concat(h.errors);
  }

  if (c.hasOwnProperty('strict') ? c.strict : n.meta.strict)
    for (var y in o) v.hasOwnProperty(y) || module1209.Nil.is(o[y]) || l.errors.push(s.of(o[y], module1209.Nil, u.concat(y), c.context));
  return l;
};

module1209.mixin(module1209, {
  ValidationError: s,
  ValidationResult: l,
  validate: v,
});
module.exports = module1209;
