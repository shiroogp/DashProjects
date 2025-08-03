exports.default = function (t) {
  var n = t.onAction,
    l = t.getState,
    p = t.emitter,
    O = t.router,
    y = React.useContext(module663.default),
    b = React.useContext(module674.default);
  return React.useMemo(
    function () {
      var t = function (t) {
          var o = 'function' == typeof t ? t(l()) : t,
            u = n(o);
          if (!(u || null == y)) y(o);
        },
        o = s(s({}, O.actionCreators), module651.CommonActions),
        c = Object.keys(o).reduce(function (n, u) {
          n[u] = function () {
            return t(o[u].apply(o, arguments));
          };

          return n;
        }, {});

      return s(
        s(s({}, b), c),
        {},
        {
          dispatch: t,
          emit: p.emit,
          isFocused: b
            ? b.isFocused
            : function () {
                return true;
              },
          canGoBack: function () {
            var t = l();
            return (
              null !==
                O.getStateForAction(t, module651.CommonActions.goBack(), {
                  routeNames: t.routeNames,
                  routeParamList: {},
                }) ||
              (null == b ? undefined : b.canGoBack()) ||
              false
            );
          },
          dangerouslyGetParent: function () {
            return b;
          },
          dangerouslyGetState: l,
        }
      );
    },
    [p.emit, l, n, y, b, O]
  );
};

var module50 = require('./50'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = l(n);
    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      c = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var f in t)
      if ('default' !== f && Object.prototype.hasOwnProperty.call(t, f)) {
        var p = c ? Object.getOwnPropertyDescriptor(t, f) : null;
        if (p && (p.get || p.set)) Object.defineProperty(u, f, p);
        else u[f] = t[f];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  module651 = require('./651'),
  module674 = require('./674'),
  module663 = require('./663');

function l(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (l = function (t) {
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

function s(t) {
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

require('./684').PrivateValueStore;
