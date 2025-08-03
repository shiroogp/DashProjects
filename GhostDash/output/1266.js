exports.getComponentOptions = function t(n, u, f, c) {
  if (module1208.default.Nil.is(n)) return u;
  if (module1208.default.Function.is(n)) return n(f);

  if (module1208.default.Array.is(n) && p(c)) {
    var s = y(c),
      l = s.dispatch(f),
      b = v(s.meta.types, l);
    return t(n[b], u, f, l);
  }

  return n;
};

exports.getOptionsOfEnum = function (t) {
  var n = t.meta.map;
  return Object.keys(n).map(function (t) {
    return {
      value: t,
      text: n[t],
    };
  });
};

exports.getTypeFromUnion = function (t, n) {
  if (p(t)) return l(t, n);
  return t;
};

exports.getTypeInfo = function (t) {
  var n,
    u,
    f = t,
    c = false,
    s = false;

  for (; f; )
    if (((n = f.meta.kind), module1208.default.Function.is(f.getValidationErrorMessage) && (u = f.getValidationErrorMessage), 'maybe' !== n)) {
      if ('subtype' !== n) break;
      s = true;
      f = f.meta.type;
    } else {
      c = true;
      f = f.meta.type;
    }

  var p = u
    ? function (n, f, c) {
        var s = module1208.default.validate(n, t, {
          path: f,
          context: c,
        });

        if (!s.isValid()) {
          for (var p = 0, l = s.errors.length; p < l; p++) if (module1208.default.Function.is(s.errors[p].expected.getValidationErrorMessage)) return s.errors[p].message;

          return u(n, f, c);
        }
      }
    : undefined;
  return {
    type: t,
    isMaybe: c,
    isSubtype: s,
    innerType: f,
    getValidationErrorMessage: p,
  };
};

exports.humanize = function (t) {
  return s(c(t).replace(/_id$/, '').replace(/_/g, ' '));
};

exports.merge = function (t, n) {
  return module1208.mixin(module1208.mixin({}, t), n, true);
};

exports.move = function (t, n, u) {
  var o = t.splice(n, 1)[0];
  t.splice(u, 0, o);
  return t;
};

var module27 = require('./27'),
  module1208 = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var u = f(n);
    if (u && u.has(t)) return u.get(t);
    var o = {
        __proto__: null,
      },
      c = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var s in t)
      if ('default' !== s && Object.prototype.hasOwnProperty.call(t, s)) {
        var p = c ? Object.getOwnPropertyDescriptor(t, s) : null;
        if (p && (p.get || p.set)) Object.defineProperty(o, s, p);
        else o[s] = t[s];
      }

    o.default = t;
    if (u) u.set(t, o);
    return o;
  })(require('./1208'));

function f(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    u = new WeakMap();
  return (f = function (t) {
    return t ? u : n;
  })(t);
}

function c(t) {
  return t
    .trim()
    .replace(/([a-z\d])([A-Z]+)/g, '$1_$2')
    .replace(/[-\s]+/g, '_')
    .toLowerCase();
}

function s(t) {
  return t.charAt(0).toUpperCase() + t.slice(1);
}

exports.UIDGenerator = (function () {
  function t(u) {
    module27.default(this, t);
    this.seed = 'tfid-' + u + '-';
    this.counter = 0;
  }

  module28.default(t, [
    {
      key: 'next',
      value: function () {
        return this.seed + this.counter++;
      },
    },
  ]);
  return t;
})();

function p(t) {
  switch (t.meta.kind) {
    case 'union':
      return true;

    case 'maybe':
    case 'subtype':
      return p(t.meta.type);

    default:
      return false;
  }
}

function l(t, n) {
  var u = t.meta.kind;
  return 'union' === u
    ? t.dispatch(n)
    : 'maybe' === u
    ? module1208.default.maybe(l(t.meta.type, n), t.meta.name)
    : 'subtype' === u
    ? module1208.default.subtype(l(t.meta.type, n), t.meta.predicate, t.meta.name)
    : undefined;
}

function y(t) {
  return 'union' === t.meta.kind ? t : y(t.meta.type);
}

function v(t, n) {
  for (var u = 0, o = t.length; u < o; u++) if (t[u] === n) return u;

  return -1;
}
