exports.default = function (t) {
  var f = t.router,
    c = t.getState,
    l = t.setState,
    s = t.key,
    v = t.actionListeners,
    p = t.beforeRemoveListeners,
    y = t.routerConfigOptions,
    k = t.emitter,
    b = React.useContext(module661.default),
    O = b.onAction,
    _ = b.onRouteFocus,
    h = b.addListener,
    j = b.onDispatchAction,
    P = React.useRef(y);
  React.useEffect(function () {
    P.current = y;
  });
  var w = React.useCallback(
    function (t) {
      var n = arguments.length > 1 && undefined !== arguments[1] ? arguments[1] : new Set(),
        o = c();
      if (n.has(o.key)) return false;

      if ((n.add(o.key), 'string' != typeof t.target || t.target === o.key)) {
        var y = f.getStateForAction(o, t, P.current);

        if (null !== (y = null === y && t.target === o.key ? o : y)) {
          if ((j(t, o === y), o !== y)) {
            var b = y.routes.map(function (t) {
                return t.key;
              }),
              h = o.routes.filter(function (t) {
                return !b.includes(t.key);
              }),
              w = module686.shouldPreventRemove(k, p, h, t);
            if (w) return true;
            l(y);
          }

          if (undefined !== _) {
            var M = f.shouldActionChangeFocus(t);
            if (M && undefined !== s) _(s);
          }

          return true;
        }
      }

      if (undefined !== O && O(t, n)) return true;

      for (var R = v.length - 1; R >= 0; R--) {
        var S = v[R];
        if (S(t, n)) return true;
      }

      return false;
    },
    [v, p, k, c, s, O, j, _, f, l]
  );
  module686.default({
    getState: c,
    emitter: k,
    beforeRemoveListeners: p,
  });
  React.useEffect(
    function () {
      return null == h ? undefined : h('action', w);
    },
    [h, w]
  );
  return w;
};

var React = c(require('react')),
  module661 = require('./661'),
  module686 = c(require('./686'));

function f(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (f = function (t) {
    return t ? o : n;
  })(t);
}

function c(t, n) {
  if (!n && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var o = f(n);
  if (o && o.has(t)) return o.get(t);
  var u = {
      __proto__: null,
    },
    c = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var l in t)
    if ('default' !== l && Object.prototype.hasOwnProperty.call(t, l)) {
      var s = c ? Object.getOwnPropertyDescriptor(t, l) : null;
      if (s && (s.get || s.set)) Object.defineProperty(u, l, s);
      else u[l] = t[l];
    }

  u.default = t;
  if (o) o.set(t, u);
  return u;
}
