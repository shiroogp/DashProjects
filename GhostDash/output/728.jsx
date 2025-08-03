exports.SafeAreaProvider = function (t) {
  var n,
    s,
    h,
    y,
    S,
    w = t.children,
    C = t.initialMetrics,
    x = t.initialSafeAreaInsets,
    A = t.style,
    b = React.useContext(c),
    P = React.useContext(v),
    _ = React.useState(null != (n = null != (s = null != (h = null == C ? undefined : C.insets) ? h : x) ? s : b) ? n : null),
    O = module15.default(_, 2),
    E = O[0],
    M = O[1],
    j = React.useState(
      null != (y = null != (S = null == C ? undefined : C.frame) ? S : P)
        ? y
        : {
            x: 0,
            y: 0,
            width: ReactNative.Dimensions.get('window').width,
            height: ReactNative.Dimensions.get('window').height,
          }
    ),
    I = module15.default(j, 2),
    k = I[0],
    D = I[1],
    F = React.useCallback(
      function (t) {
        var n = t.nativeEvent,
          o = n.frame,
          l = n.insets;
        if (!(!o || (o.height === k.height && o.width === k.width && o.x === k.x && o.y === k.y))) D(o);
        if (!(E && l.bottom === E.bottom && l.left === E.left && l.right === E.right && l.top === E.top)) M(l);
      },
      [k, E]
    );

  return (
    <module729.default style={[p.fill, A]} onInsetsChange={F}>
      {null != E ? (
        <v.Provider value={k}>
          <c.Provider value={E}>{w}</c.Provider>
        </v.Provider>
      ) : null}
    </module729.default>
  );
};

exports.useSafeArea = function () {
  return h();
};

exports.useSafeAreaFrame = function () {
  var t = React.useContext(v);
  if (null == t) throw new Error('No safe area frame value available. Make sure you are rendering `<SafeAreaProvider>` at the top of your app.');
  return t;
};

exports.useSafeAreaInsets = h;

exports.withSafeAreaInsets = function (t) {
  return React.forwardRef(function (o, u) {
    return (
      <y>
        {function (f) {
          return <t />;
        }}
      </y>
    );
  });
};

var module14 = require('./14'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = s(n);
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
  module729 = require('./729');

function s(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (s = function (t) {
    return t ? o : n;
  })(t);
}

var c = (exports.SafeAreaInsetsContext = React.createContext(null));
c.displayName = 'SafeAreaInsetsContext';
var v = (exports.SafeAreaFrameContext = React.createContext(null));
v.displayName = 'SafeAreaFrameContext';
var p = ReactNative.StyleSheet.create({
  fill: {
    flex: 1,
  },
});

function h() {
  var t = React.useContext(c);
  if (null == t) throw new Error('No safe area insets value available. Make sure you are rendering `<SafeAreaProvider>` at the top of your app.');
  return t;
}

var y = (exports.SafeAreaConsumer = c.Consumer);
exports.SafeAreaContext = c;
