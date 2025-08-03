exports.default = function (t, o) {
  var v,
    L = module678.default(),
    D = React.useContext(module675.default),
    M = React.useRef(null == D ? undefined : D.params);
  React.useEffect(
    function () {
      M.current = null == D ? undefined : D.params;
    },
    [D]
  );
  var I = o.children,
    K = module56.default(o, A),
    W = React.useRef(
      t(
        x(
          x({}, K),
          null != D && D.params && false !== D.params.initial && 'string' == typeof D.params.screen
            ? {
                initialRouteName: D.params.screen,
              }
            : null
        )
      )
    ).current,
    V = F(I),
    H = V.reduce(function (t, n) {
      if (n.name in t) throw new Error("A navigator cannot contain multiple 'Screen' components with the same name (found duplicate screen named '" + n.name + "')");
      t[n.name] = n;
      return t;
    }, {}),
    T = V.map(function (t) {
      return t.name;
    }),
    q = T.reduce(function (t, n) {
      var o,
        u,
        s = H[n].initialParams,
        l =
          false !== (null == D ? undefined : null == (o = D.params) ? undefined : o.initial) && (null == D ? undefined : null == (u = D.params) ? undefined : u.screen) === n
            ? D.params.params
            : undefined;
      t[n] = undefined !== s || undefined !== l ? x(x({}, s), l) : undefined;
      return t;
    }, {});
  if (!T.length) throw new Error("Couldn't find any screens for the navigator. Have you defined any screens as its children?");
  var z = React.useCallback(
      function (t) {
        return undefined === t.type || t.type === W.type;
      },
      [W.type]
    ),
    B = React.useCallback(
      function (t) {
        return undefined !== t && false === t.stale && z(t);
      },
      [z]
    ),
    G = React.useContext(module662.default),
    J = G.state,
    Q = G.getState,
    U = G.setState,
    X = G.setKey,
    Y = G.getKey,
    Z = G.getIsInitial,
    $ = React.useMemo(
      function () {
        return undefined !== J && z(J)
          ? [
              W.getRehydratedState(J, {
                routeNames: T,
                routeParamList: q,
              }),
              false,
            ]
          : [
              W.getInitialState({
                routeNames: T,
                routeParamList: q,
              }),
              true,
            ];
      },
      [J, W, z]
    ),
    ee = module15.default($, 2),
    te = ee[0],
    re = ee[1],
    ne = B(J) ? J : te,
    ae = ne;
  if (!module691.default(ne.routeNames, T))
    ae = W.getStateForRouteNamesChange(ne, {
      routeNames: T,
      routeParamList: q,
    });

  if ('string' == typeof (null == D ? undefined : null == (v = D.params) ? undefined : v.screen) && (D.params !== M.current || (false === D.params.initial && re))) {
    var oe = W.getStateForAction(ae, module651.CommonActions.navigate(D.params.screen, D.params.params), {
      routeNames: T,
      routeParamList: q,
    });
    ae =
      null !== oe
        ? W.getRehydratedState(oe, {
            routeNames: T,
            routeParamList: q,
          })
        : ae;
  }

  var ie = ne !== ae;
  module664.default(function () {
    if (ie) U(ae);
  });
  ne = ae;
  React.useEffect(function () {
    X(L);
    if (!Z()) U(ae);
    return function () {
      setTimeout(function () {
        if (undefined !== Q() && Y() === L) U(undefined);
      }, 0);
    };
  }, []);
  var ue = React.useRef();
  ue.current = te;
  var se = React.useCallback(
      function () {
        var t = Q();
        return B(t) ? t : ue.current;
      },
      [Q, B]
    ),
    le = module668.default(function (t) {
      var n,
        o,
        u,
        l = [];

      if (t.target) {
        o = ne.routes.find(function (n) {
          return n.key === t.target;
        });
        if (null != (u = o) && u.name) l.push(o.name);
      } else {
        o = ne.routes[ne.index];
        l.push.apply(
          l,
          module23.default(
            Object.keys(H).filter(function (t) {
              var n;
              return (null == (n = o) ? undefined : n.name) === t;
            })
          )
        );
      }

      if (null != o) {
        var c = be[o.key].navigation,
          f = (n = []).concat
            .apply(
              n,
              module23.default(
                l.map(function (n) {
                  var u = H[n].listeners,
                    s =
                      'function' == typeof u
                        ? u({
                            route: o,
                            navigation: c,
                          })
                        : u;
                  return s
                    ? Object.keys(s)
                        .filter(function (n) {
                          return n === t.type;
                        })
                        .map(function (t) {
                          return null == s ? undefined : s[t];
                        })
                    : undefined;
                })
              )
            )
            .filter(function (t, n, o) {
              return t && o.lastIndexOf(t) === n;
            });
        f.forEach(function (n) {
          return null == n ? undefined : n(t);
        });
      }
    });
  module687.default({
    state: ne,
    emitter: le,
  });
  React.useEffect(
    function () {
      le.emit({
        type: 'state',
        data: {
          state: ne,
        },
      });
    },
    [le, ne]
  );
  var ce = module665.default(),
    fe = ce.listeners,
    de = ce.addListener,
    pe = module666.default(),
    me = pe.keyedListeners,
    ve = pe.addKeyedListener,
    ye = module685.default({
      router: W,
      getState: se,
      setState: U,
      key: null == D ? undefined : D.key,
      actionListeners: fe.action,
      beforeRemoveListeners: me.beforeRemove,
      routerConfigOptions: {
        routeNames: T,
        routeParamList: q,
      },
      emitter: le,
    }),
    ge = module688.default({
      router: W,
      key: null == D ? undefined : D.key,
      getState: se,
      setState: U,
    }),
    Oe = module683.default({
      onAction: ye,
      getState: se,
      emitter: le,
      router: W,
    });
  module689.default({
    navigation: Oe,
    focusedListeners: fe.focus,
  });
  module690.default({
    getState: se,
    getStateListeners: me.getState,
  });
  var be = module679.default({
    state: ne,
    screens: H,
    navigation: Oe,
    screenOptions: o.screenOptions,
    onAction: ye,
    getState: se,
    setState: U,
    onRouteFocus: ge,
    addListener: de,
    addKeyedListener: ve,
    router: W,
    emitter: le,
  });
  module692.default({
    state: ne,
    navigation: Oe,
    descriptors: be,
  });
  return {
    state: ne,
    navigation: Oe,
    descriptors: be,
  };
};

require('./512');

var module15 = require('@babel/runtime/helpers/slicedToArray'),
  module50 = require('./50'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = D(n);
    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      s = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var l in t)
      if ('default' !== l && Object.prototype.hasOwnProperty.call(t, l)) {
        var c = s ? Object.getOwnPropertyDescriptor(t, l) : null;
        if (c && (c.get || c.set)) Object.defineProperty(u, l, c);
        else u[l] = t[l];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  module651 = require('./651'),
  module662 = require('./662'),
  module675 = require('./675'),
  module672 = require('./672'),
  module668 = require('./668'),
  module678 = require('./678'),
  module679 = require('./679'),
  module683 = require('./683'),
  module685 = require('./685'),
  module687 = require('./687'),
  module688 = require('./688'),
  module665 = require('./665'),
  module689 = require('./689'),
  module684 = require('./684'),
  module666 = require('./666'),
  module690 = require('./690'),
  module664 = require('./664'),
  module692 = require('./692'),
  module691 = require('./691'),
  A = ['children'];

function D(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (D = function (t) {
    return t ? o : n;
  })(t);
}

function M(t, n) {
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

function x(t) {
  for (var n = 1; n < arguments.length; n++) {
    var u = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      M(Object(u), true).forEach(function (n) {
        module50.default(t, n, u[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      M(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
}

module684.PrivateValueStore;

var F = function t(n) {
  return React.Children.toArray(n).reduce(function (n, o) {
    if (React.isValidElement(o)) {
      if (o.type === module672.default) {
        n.push(o.props);
        return n;
      }

      if (o.type === React.Fragment) {
        n.push.apply(n, module23.default(t(o.props.children)));
        return n;
      }
    }

    throw new Error("A navigator can only contain 'Screen' components as its direct children (found '" + (o.type && o.type.name ? o.type.name : String(o)) + "')");
  }, []);
};
