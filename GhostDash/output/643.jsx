var module50 = require('./50'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
  module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = b(n);
    if (o && o.has(t)) return o.get(t);
    var l = {
        __proto__: null,
      },
      u = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var f in t)
      if ('default' !== f && Object.prototype.hasOwnProperty.call(t, f)) {
        var c = u ? Object.getOwnPropertyDescriptor(t, f) : null;
        if (c && (c.get || c.set)) Object.defineProperty(l, f, c);
        else l[f] = t[f];
      }

    l.default = t;
    if (o) o.set(t, l);
    return l;
  })(require('react')),
  ReactNative = require('react-native'),
  module616 = require('./616'),
  module617 = require('./617'),
  module406 = require('./406'),
  h = ['refreshControl', 'waitFor'],
  y = ['waitFor', 'refreshControl'];

function b(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (b = function (t) {
    return t ? o : n;
  })(t);
}

function v(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var l = Object.getOwnPropertySymbols(t);
    if (n)
      l = l.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, l);
  }

  return o;
}

function j(t) {
  for (var o = 1; o < arguments.length; o++) {
    var l = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      v(Object(l), true).forEach(function (o) {
        module50.default(t, o, l[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(l));
    else
      v(Object(l)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(l, n));
      });
  }

  return t;
}

exports.RefreshControl = module616.default(ReactNative.RefreshControl, {
  disallowInterruption: true,
  shouldCancelWhenOutside: false,
});
var P = module616.default(ReactNative.ScrollView, {
    disallowInterruption: true,
    shouldCancelWhenOutside: false,
  }),
  C = (exports.ScrollView = React.forwardRef(function (t, n) {
    var o = React.useRef(null),
      s = t.refreshControl,
      p = t.waitFor,
      w = module56.default(t, h);
    return <P />;
  }));
exports.Switch = module616.default(ReactNative.Switch, {
  shouldCancelWhenOutside: false,
  shouldActivateOnStart: true,
  disallowInterruption: true,
});
exports.TextInput = module616.default(ReactNative.TextInput);
exports.DrawerLayoutAndroid = module616.default(ReactNative.DrawerLayoutAndroid, {
  disallowInterruption: true,
});
exports.FlatList = React.forwardRef(function (t, n) {
  for (var p = React.useRef(null), h = t.waitFor, b = t.refreshControl, v = module56.default(t, y), P = {}, S = {}, _ = 0, D = Object.entries(v); _ < D.length; _++) {
    var F = D[_],
      E = module15.default(F, 2),
      I = E[0],
      R = E[1];
    if (module617.nativeViewProps.includes(I)) S[I] = R;
    else P[I] = R;
  }

  return <ReactNative.FlatList />;
});
