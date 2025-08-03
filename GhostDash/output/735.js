exports.Freeze = function (n) {
  var u = n.freeze,
    f = n.children,
    l = n.placeholder,
    c = undefined === l ? null : l;
  return React.default.createElement(
    React.Suspense,
    {
      fallback: c,
    },
    React.default.createElement(
      o,
      {
        freeze: u,
      },
      f
    )
  );
};

var React = (function (t, o) {
  if (!o && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var u = n(o);
  if (u && u.has(t)) return u.get(t);
  var f = {
      __proto__: null,
    },
    l = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var c in t)
    if ('default' !== c && Object.prototype.hasOwnProperty.call(t, c)) {
      var p = l ? Object.getOwnPropertyDescriptor(t, c) : null;
      if (p && (p.get || p.set)) Object.defineProperty(f, c, p);
      else f[c] = t[c];
    }

  f.default = t;
  if (u) u.set(t, f);
  return f;
})(require('react'));

function n(t) {
  if ('function' != typeof WeakMap) return null;
  var o = new WeakMap(),
    u = new WeakMap();
  return (n = function (t) {
    return t ? u : o;
  })(t);
}

function o(n) {
  var o = n.freeze,
    u = n.children,
    f = React.useRef({}).current;
  if (o && !f.promise)
    throw (
      ((f.promise = new Promise(function (t) {
        f.resolve = t;
      })),
      f.promise)
    );
  if (o) throw f.promise;

  if (f.promise) {
    f.resolve();
    f.promise = undefined;
  }

  return React.default.createElement(React.Fragment, null, u);
}
