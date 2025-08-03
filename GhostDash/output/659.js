require('./670');

var module15 = require('@babel/runtime/helpers/slicedToArray'),
  module50 = require('./50'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = C(n);
    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      c = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var s in t)
      if ('default' !== s && Object.prototype.hasOwnProperty.call(t, s)) {
        var l = c ? Object.getOwnPropertyDescriptor(t, s) : null;
        if (l && (l.get || l.set)) Object.defineProperty(u, s, l);
        else u[s] = t[s];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  module651 = require('./651'),
  module660 = require('./660'),
  module661 = require('./661'),
  module662 = require('./662'),
  module663 = require('./663'),
  module664 = require('./664'),
  module665 = require('./665'),
  module666 = require('./666'),
  module667 = require('./667'),
  module668 = require('./668'),
  module669 = require('./669'),
  j = ['key', 'routeNames'];

function C(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (C = function (t) {
    return t ? o : n;
  })(t);
}

function _(t, n) {
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

function P(t) {
  for (var n = 1; n < arguments.length; n++) {
    var u = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      _(Object(u), true).forEach(function (n) {
        module50.default(t, n, u[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      _(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
}

try {
  Object.defineProperty(globals, 'REACT_NAVIGATION_REDUX_DEVTOOLS_EXTENSION_INTEGRATION_ENABLED', {
    set: function (t) {
      console.warn(
        "Redux devtools extension integration can be enabled with the '@react-navigation/devtools' package. For more details, see https://reactnavigation.org/docs/devtools"
      );
    },
  });
} catch (t) {}

var E = function t(n) {
    if (undefined !== n) {
      return P(
        P({}, module56.default(n, j)),
        {},
        {
          stale: true,
          routes: n.routes.map(function (n) {
            return undefined === n.state
              ? n
              : P(
                  P({}, n),
                  {},
                  {
                    state: t(n.state),
                  }
                );
          }),
        }
      );
    }
  },
  S = React.forwardRef(function (t, o) {
    var u = t.initialState,
      j = t.onStateChange,
      C = t.independent,
      _ = t.children;
    if (!React.useContext(module662.default).isDefault && !C)
      throw new Error(
        "Looks like you have nested a 'NavigationContainer' inside another. Normally you need only one container at the root of the app, so this was probably an error. If this was intentional, pass 'independent={true}' explicitely. Note that this will make the child navigators disconnected from the parent and you won't be able to navigate between them."
      );

    var S = module669.default(function () {
        return E(null == u ? undefined : u);
      }),
      R = module15.default(S, 5),
      N = R[0],
      D = R[1],
      A = R[2],
      I = R[3],
      x = R[4],
      G = React.useRef(true),
      L = React.useRef(),
      M = React.useCallback(function () {
        return L.current;
      }, []),
      T = React.useCallback(function (t) {
        L.current = t;
      }, []),
      K = module665.default(),
      U = K.listeners,
      B = K.addListener,
      W = module666.default(),
      z = W.keyedListeners,
      V = W.addKeyedListener,
      X = function (t) {
        if (null == U.focus[0])
          throw new Error(
            "The 'navigation' object hasn't been initialized yet. This might happen if you don't have a navigator mounted, or if the navigator hasn't finished mounting. See https://reactnavigation.org/docs/navigating-without-navigation-prop#handling-initialization for more details."
          );
        U.focus[0](function (n) {
          return n.dispatch(t);
        });
      },
      F = function () {
        if (null == U.focus[0]) return false;
        var t = U.focus[0](function (t) {
            return t.canGoBack();
          }),
          n = t.result;
        return !!t.handled && n;
      },
      H = React.useCallback(
        function (t) {
          A(t);
        },
        [A]
      ),
      q = React.useCallback(
        function () {
          return null == z.getState.root ? undefined : z.getState.root();
        },
        [z.getState]
      ),
      J = React.useCallback(
        function () {
          var t = q();

          if (undefined !== t) {
            for (; undefined !== t.routes[t.index].state; ) t = t.routes[t.index].state;

            return t.routes[t.index];
          }
        },
        [q]
      ),
      Q = module668.default(),
      Y = module667.default({}),
      Z = Y.addOptionsGetter,
      $ = Y.getCurrentOptions;

    React.useImperativeHandle(o, function () {
      return P(
        P(
          P(
            {},
            Object.keys(module651.CommonActions).reduce(function (t, n) {
              t[n] = function () {
                return X(module651.CommonActions[n].apply(module651.CommonActions, arguments));
              };

              return t;
            }, {})
          ),
          Q.create('root')
        ),
        {},
        {
          resetRoot: H,
          dispatch: X,
          canGoBack: F,
          getRootState: q,
          dangerouslyGetState: function () {
            return N;
          },
          dangerouslyGetParent: function () {},
          getCurrentRoute: J,
          getCurrentOptions: $,
        }
      );
    });
    var ee = React.useCallback(
        function (t, n) {
          Q.emit({
            type: '__unsafe_action__',
            data: {
              action: t,
              noop: n,
            },
          });
        },
        [Q]
      ),
      te = React.useRef(),
      ne = React.useCallback(
        function (t) {
          if (te.current !== t) {
            te.current = t;
            Q.emit({
              type: 'options',
              data: {
                options: t,
              },
            });
          }
        },
        [Q]
      ),
      re = React.useMemo(
        function () {
          return {
            addListener: B,
            addKeyedListener: V,
            onDispatchAction: ee,
            onOptionsChange: ne,
          };
        },
        [B, V, ee, ne]
      ),
      oe = React.useMemo(
        function () {
          return {
            scheduleUpdate: I,
            flushUpdates: x,
          };
        },
        [I, x]
      ),
      ae = React.useRef(true),
      ie = React.useCallback(function () {
        return ae.current;
      }, []),
      ue = React.useMemo(
        function () {
          return {
            state: N,
            getState: D,
            setState: A,
            getKey: M,
            setKey: T,
            getIsInitial: ie,
            addOptionsGetter: Z,
          };
        },
        [N, D, A, M, T, ie, Z]
      ),
      ce = React.useRef(j);
    React.useEffect(function () {
      ae.current = false;
      ce.current = j;
    });
    React.useEffect(
      function () {
        Q.emit({
          type: 'state',
          data: {
            state: N,
          },
        });
        if (!G.current && ce.current) ce.current(q());
        G.current = false;
      },
      [q, Q, N]
    );
    var se = React.useCallback(function (t) {}, []);
    return React.createElement(
      module664.ScheduleUpdateContext.Provider,
      {
        value: oe,
      },
      React.createElement(
        module661.default.Provider,
        {
          value: re,
        },
        React.createElement(
          module662.default.Provider,
          {
            value: ue,
          },
          React.createElement(
            module663.default.Provider,
            {
              value: se,
            },
            React.createElement(module660.default, null, _)
          )
        )
      )
    );
  });

exports.default = S;
