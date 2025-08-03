exports.default = function (t) {
  var c = React.useRef(t);
  React.useEffect(function () {
    c.current = t;
  });
  var f = React.useRef({}),
    o = React.useCallback(function (t) {
      var n = function (n, u) {
        var c = f.current[n] ? f.current[n][t] : undefined;

        if (c) {
          var o = c.indexOf(u);
          c.splice(o, 1);
        }
      };

      return {
        addListener: function (u, c) {
          f.current[u] = f.current[u] || {};
          f.current[u][t] = f.current[u][t] || [];
          f.current[u][t].push(c);
          return function () {
            return n(u, c);
          };
        },
        removeListener: n,
      };
    }, []),
    l = React.useCallback(function (t) {
      var u,
        o = t.type,
        l = t.data,
        p = t.target,
        v = t.canPreventDefault,
        s = f.current[o] || {},
        b =
          undefined !== p
            ? s[p] && s[p].slice()
            : (u = []).concat
                .apply(
                  u,
                  module23.default(
                    Object.keys(s).map(function (t) {
                      return s[t];
                    })
                  )
                )
                .filter(function (t, n, u) {
                  return u.lastIndexOf(t) === n;
                }),
        y = {
          get type() {
            return o;
          },
        };

      if (
        (undefined !== p &&
          Object.defineProperty(y, 'target', {
            enumerable: true,
            get: function () {
              return p;
            },
          }),
        undefined !== l &&
          Object.defineProperty(y, 'data', {
            enumerable: true,
            get: function () {
              return l;
            },
          }),
        v)
      ) {
        var O = false;
        Object.defineProperties(y, {
          defaultPrevented: {
            enumerable: true,
            get: function () {
              return O;
            },
          },
          preventDefault: {
            enumerable: true,
            value: function () {
              O = true;
            },
          },
        });
      }

      if (!(null == c.current)) c.current(y);
      if (!(null == b))
        b.forEach(function (t) {
          return t(y);
        });
      return y;
    }, []);
  return React.useMemo(
    function () {
      return {
        create: o,
        emit: l,
      };
    },
    [o, l]
  );
};

var React = (function (t, n) {
  if (!n && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var u = c(n);
  if (u && u.has(t)) return u.get(t);
  var f = {
      __proto__: null,
    },
    o = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var l in t)
    if ('default' !== l && Object.prototype.hasOwnProperty.call(t, l)) {
      var p = o ? Object.getOwnPropertyDescriptor(t, l) : null;
      if (p && (p.get || p.set)) Object.defineProperty(f, l, p);
      else f[l] = t[l];
    }

  f.default = t;
  if (u) u.set(t, f);
  return f;
})(require('react'));

function c(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    u = new WeakMap();
  return (c = function (t) {
    return t ? u : n;
  })(t);
}
