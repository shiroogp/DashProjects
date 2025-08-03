exports.default = function (t) {
  var n = t.state,
    y = t.screens,
    O = t.navigation,
    b = t.screenOptions,
    j = t.onAction,
    P = t.getState,
    w = t.setState,
    h = t.addListener,
    _ = t.addKeyedListener,
    k = t.onRouteFocus,
    D = t.router,
    S = t.emitter,
    E = React.useState({}),
    M = module15.default(E, 2),
    A = M[0],
    L = M[1],
    C = React.useContext(module661.default),
    W = C.onDispatchAction,
    F = C.onOptionsChange,
    K = React.useMemo(
      function () {
        return {
          navigation: O,
          onAction: j,
          addListener: h,
          addKeyedListener: _,
          onRouteFocus: k,
          onDispatchAction: W,
          onOptionsChange: F,
        };
      },
      [O, j, h, _, k, W, F]
    ),
    R = module682.default({
      state: n,
      getState: P,
      navigation: O,
      setOptions: L,
      router: D,
      emitter: S,
    });
  return n.routes.reduce(function (t, n) {
    var o = y[n.name],
      f = R[n.key],
      O = v(
        v(
          v(
            {},
            'object' == typeof b || null == b
              ? b
              : b({
                  route: n,
                  navigation: f,
                })
          ),
          'object' == typeof o.options || null == o.options
            ? o.options
            : o.options({
                route: n,
                navigation: f,
              })
        ),
        A[n.key]
      );
    t[n.key] = {
      navigation: f,
      render: function () {
        return React.createElement(
          module661.default.Provider,
          {
            key: n.key,
            value: K,
          },
          React.createElement(
            module674.default.Provider,
            {
              value: f,
            },
            React.createElement(
              module675.default.Provider,
              {
                value: n,
              },
              React.createElement(module680.default, {
                navigation: f,
                route: n,
                screen: o,
                getState: P,
                setState: w,
                options: O,
              })
            )
          )
        );
      },
      options: O,
    };
    return t;
  }, {});
};

var module50 = require('./50'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = y(n);
    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      c = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var s in t)
      if ('default' !== s && Object.prototype.hasOwnProperty.call(t, s)) {
        var f = c ? Object.getOwnPropertyDescriptor(t, s) : null;
        if (f && (f.get || f.set)) Object.defineProperty(u, s, f);
        else u[s] = t[s];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  module680 = require('./680'),
  module661 = require('./661'),
  module682 = require('./682'),
  module674 = require('./674'),
  module675 = require('./675');

function y(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (y = function (t) {
    return t ? o : n;
  })(t);
}

function O(t, n) {
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

function v(t) {
  for (var o = 1; o < arguments.length; o++) {
    var u = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      O(Object(u), true).forEach(function (o) {
        module50.default(t, o, u[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      O(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
}
