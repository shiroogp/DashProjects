exports.default = function (t) {
  var n = t.screen,
    s = t.route,
    p = t.navigation,
    O = t.getState,
    b = t.setState,
    v = t.options,
    j = React.useRef(),
    k = React.useCallback(function () {
      return j.current;
    }, []),
    P = module667.default({
      key: s.key,
      options: v,
      navigation: p,
    }).addOptionsGetter,
    w = React.useCallback(function (t) {
      j.current = t;
    }, []),
    _ = React.useCallback(
      function () {
        var t = O(),
          n = t.routes.find(function (t) {
            return t.key === s.key;
          });
        return n ? n.state : undefined;
      },
      [O, s.key]
    ),
    h = React.useCallback(
      function (t) {
        var n = O();
        b(
          y(
            y({}, n),
            {},
            {
              routes: n.routes.map(function (n) {
                return n.key === s.key
                  ? y(
                      y({}, n),
                      {},
                      {
                        state: t,
                      }
                    )
                  : n;
              }),
            }
          )
        );
      },
      [O, s.key, b]
    ),
    C = React.useRef(true);

  React.useEffect(function () {
    C.current = false;
  });
  var E = React.useCallback(function () {
      return C.current;
    }, []),
    D = React.useMemo(
      function () {
        return {
          state: s.state,
          getState: _,
          setState: h,
          getKey: k,
          setKey: w,
          getIsInitial: E,
          addOptionsGetter: P,
        };
      },
      [s.state, _, h, k, w, E, P]
    ),
    M = n.getComponent ? n.getComponent() : n.component;
  return React.createElement(
    module662.default.Provider,
    {
      value: D,
    },
    React.createElement(
      module660.default,
      null,
      React.createElement(
        module681.default,
        {
          name: n.name,
          render: M || n.children,
          navigation: p,
          route: s,
        },
        undefined !== M
          ? React.createElement(M, {
              navigation: p,
              route: s,
            })
          : undefined !== n.children
          ? n.children({
              navigation: p,
              route: s,
            })
          : null
      )
    )
  );
};

var module50 = require('./50'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = s(n);
    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      c = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var f in t)
      if ('default' !== f && Object.prototype.hasOwnProperty.call(t, f)) {
        var l = c ? Object.getOwnPropertyDescriptor(t, f) : null;
        if (l && (l.get || l.set)) Object.defineProperty(u, f, l);
        else u[f] = t[f];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  module662 = require('./662'),
  module681 = require('./681'),
  module660 = require('./660'),
  module667 = require('./667');

function s(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (s = function (t) {
    return t ? o : n;
  })(t);
}

function p(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var u = Object.getOwnPropertySymbols(t);
    if (n)
      u = u.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, u);
  }

  return o;
}

function y(t) {
  for (var o = 1; o < arguments.length; o++) {
    var u = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      p(Object(u), true).forEach(function (o) {
        module50.default(t, o, u[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      p(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
}
