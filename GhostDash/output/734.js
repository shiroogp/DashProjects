var t,
  module14 = require('./14'),
  module50 = require('./50'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
  React = require('react'),
  ReactNative = require('react-native'),
  module735 = require('./735'),
  module79 = require('./79'),
  module407 = require('./407'),
  module736 = require('./736'),
  module737 = require('./737'),
  module738 = require('./738'),
  P = ['children'],
  E = ['enabled'],
  R = ['active', 'activityState', 'children', 'isNativeStack', 'statusBarColor'],
  H = ['active', 'activityState', 'style', 'onComponentRef'],
  B = ['enabled', 'hasTwoStates'];

function A(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var c = Object.getOwnPropertySymbols(t);
    if (n)
      c = c.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, c);
  }

  return o;
}

function F(t) {
  for (var n = 1; n < arguments.length; n++) {
    var o = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      A(Object(o), true).forEach(function (n) {
        module50.default(t, n, o[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      A(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

function j() {
  if ('undefined' == typeof Reflect || !Reflect.construct) return false;
  if (Reflect.construct.sham) return false;
  if ('function' == typeof Proxy) return true;

  try {
    Boolean.prototype.valueOf.call(Reflect.construct(Boolean, [], function () {}));
    return true;
  } catch (t) {
    return false;
  }
}

var V = 'ios' === ReactNative.Platform.OS || 'android' === ReactNative.Platform.OS || 'windows' === ReactNative.Platform.OS,
  z = V,
  I = !(null == (t = globals) || !t.nativeFabricUIManager),
  module739 = I ? require('./739') : {};
var x = false;

var D, M, W, T, U, _, L, G, J;

var K = {
  get NativeScreen() {
    D = D || module739.Screen || ReactNative.requireNativeComponent('RNSScreen');
    return D;
  },

  get NativeScreenContainer() {
    M = M || ReactNative.requireNativeComponent('RNSScreenContainer');
    return M;
  },

  get NativeScreenNavigationContainer() {
    W = W || ('ios' === ReactNative.Platform.OS ? ReactNative.requireNativeComponent('RNSScreenNavigationContainer') : this.NativeScreenContainer);
    return W;
  },

  get NativeScreenStack() {
    T = T || module739.ScreenStack || ReactNative.requireNativeComponent('RNSScreenStack');
    return T;
  },

  get NativeScreenStackHeaderConfig() {
    U = U || module739.ScreenStackHeaderConfig || ReactNative.requireNativeComponent('RNSScreenStackHeaderConfig');
    return U;
  },

  get NativeScreenStackHeaderSubview() {
    _ = _ || module739.ScreenStackHeaderSubview || ReactNative.requireNativeComponent('RNSScreenStackHeaderSubview');
    return _;
  },

  get NativeSearchBar() {
    G = G || ReactNative.requireNativeComponent('RNSSearchBar');
    return G;
  },

  get NativeFullWindowOverlay() {
    J = J || ReactNative.requireNativeComponent('RNSFullWindowOverlay');
    return J;
  },
};

function Q(t) {
  var n = t.freeze,
    o = t.children,
    c = React.default.useState(false),
    l = module15.default(c, 2),
    u = l[0],
    v = l[1];
  if (n !== u)
    setImmediate(function () {
      v(n);
    });
  return React.default.createElement(
    module735.Freeze,
    {
      freeze: !!n && u,
    },
    o
  );
}

function X(t) {
  var n = t.freeze,
    o = t.children;
  return x
    ? React.default.createElement(
        Q,
        {
          freeze: n,
        },
        o
      )
    : React.default.createElement(React.default.Fragment, null, o);
}

var Y = (function (t, ...args) {
  module38.default(y, t);

  var n = y,
    module50 = j(),
    p = function () {
      var t,
        o = module37.default(n);

      if (module50) {
        var l = module37.default(this).constructor;
        t = Reflect.construct(o, arguments, l);
      } else t = o.apply(this, arguments);

      return module40.default(this, t);
    };

  function y() {
    var t;
    module27.default(this, y);
    (t = p.call(this, ...args)).ref = null;
    t.closing = new ReactNative.Animated.Value(0);
    t.progress = new ReactNative.Animated.Value(0);
    t.goingForward = new ReactNative.Animated.Value(0);

    t.setRef = function (n) {
      t.ref = n;
      if (!(null == t.props.onComponentRef)) t.props.onComponentRef(n);
    };

    return t;
  }

  module28.default(y, [
    {
      key: 'setNativeProps',
      value: function (t) {
        var n;
        if (!(null == (n = this.ref))) n.setNativeProps(t);
      },
    },
    {
      key: 'render',
      value: function () {
        var t = this,
          n = this.props,
          c = n.enabled,
          l = undefined === c ? z : c,
          u = module56.default(n, E);

        if (l && V) {
          if (!L) L = I ? K.NativeScreen : ReactNative.Animated.createAnimatedComponent(K.NativeScreen);
          var v = u.active,
            s = u.activityState,
            f = u.children,
            p = u.isNativeStack,
            y = u.statusBarColor,
            b = module56.default(u, R);

          if (undefined !== v && undefined === s) {
            console.warn(
              'It appears that you are using old version of react-navigation library. Please update @react-navigation/bottom-tabs, @react-navigation/stack and @react-navigation/drawer to version 5.10.0 or above to take full advantage of new functionality added to react-native-screens'
            );
            s = 0 !== v ? 2 : 0;
          }

          var k = module79.default(y);
          return React.default.createElement(
            X,
            {
              freeze: 0 === s,
            },
            React.default.createElement(
              L,
              module14.default({}, b, {
                statusBarColor: k,
                activityState: s,
                ref: function (n) {
                  var o, c;

                  if (!I) {
                    if (null != n && null != (o = n.viewConfig) && null != (c = o.validAttributes) && c.style)
                      n.viewConfig.validAttributes.style = F(
                        F({}, n.viewConfig.validAttributes.style),
                        {},
                        {
                          display: false,
                        }
                      );
                    t.setRef(n);
                  }
                },
                onTransitionProgress: p
                  ? ReactNative.Animated.event(
                      [
                        {
                          nativeEvent: {
                            progress: this.progress,
                            closing: this.closing,
                            goingForward: this.goingForward,
                          },
                        },
                      ],
                      {
                        useNativeDriver: true,
                      }
                    )
                  : undefined,
              }),
              p
                ? React.default.createElement(
                    module736.default.Provider,
                    {
                      value: {
                        progress: this.progress,
                        closing: this.closing,
                        goingForward: this.goingForward,
                      },
                    },
                    f
                  )
                : f
            )
          );
        }

        var O = u.active,
          P = u.activityState,
          B = u.style,
          A = module56.default(u, H);
        if (undefined !== O && undefined === P) P = 0 !== O ? 2 : 0;
        return React.default.createElement(
          ReactNative.Animated.View,
          module14.default(
            {
              style: [
                B,
                {
                  display: 0 !== P ? 'flex' : 'none',
                },
              ],
              ref: this.setRef,
            },
            A
          )
        );
      },
    },
  ]);
  return y;
})(React.default.Component);

var Z = ReactNative.StyleSheet.create({
    headerSubview: {
      position: 'absolute',
      top: 0,
      right: 0,
      flexDirection: 'row',
      alignItems: 'center',
      justifyContent: 'center',
    },
  }),
  $ = React.default.createContext(Y);
module.exports = {
  Screen: Y,
  ScreenContainer: function (t) {
    var n = t.enabled,
      o = undefined === n ? z : n,
      c = t.hasTwoStates,
      l = module56.default(t, B);
    return o && V
      ? c
        ? React.default.createElement(K.NativeScreenNavigationContainer, l)
        : React.default.createElement(K.NativeScreenContainer, l)
      : React.default.createElement(ReactNative.View, l);
  },
  ScreenContext: $,
  ScreenStack: function (t) {
    if (x) {
      var n = t.children,
        o = module56.default(t, P),
        c = React.default.Children.count(n),
        l = React.default.Children.map(n, function (t, n) {
          return React.default.createElement(
            Q,
            {
              freeze: c - n > 1,
            },
            t
          );
        });
      return React.default.createElement(K.NativeScreenStack, o, l);
    }

    return React.default.createElement(K.NativeScreenStack, t);
  },

  get NativeScreen() {
    return K.NativeScreen;
  },

  get NativeScreenContainer() {
    return K.NativeScreenContainer;
  },

  get NativeScreenNavigationContainer() {
    return K.NativeScreenNavigationContainer;
  },

  get ScreenStackHeaderConfig() {
    return K.NativeScreenStackHeaderConfig;
  },

  get ScreenStackHeaderSubview() {
    return K.NativeScreenStackHeaderSubview;
  },

  get SearchBar() {
    if (module738.isSearchBarAvailableForCurrentPlatform) return K.NativeSearchBar;
    else {
      console.warn('Importing SearchBar is only valid on iOS and Android devices.');
      return ReactNative.View;
    }
  },

  get FullWindowOverlay() {
    if ('ios' !== ReactNative.Platform.OS) {
      console.warn('Importing FullWindowOverlay is only valid on iOS devices.');
      return ReactNative.View;
    } else return K.NativeFullWindowOverlay;
  },

  ScreenStackHeaderBackButtonImage: function (t) {
    return React.default.createElement(
      K.NativeScreenStackHeaderSubview,
      {
        type: 'back',
        style: Z.headerSubview,
      },
      React.default.createElement(
        ReactNative.Image,
        module14.default(
          {
            resizeMode: 'center',
            fadeDuration: 0,
          },
          t
        )
      )
    );
  },
  ScreenStackHeaderRightView: function (t) {
    return React.default.createElement(
      K.NativeScreenStackHeaderSubview,
      module14.default({}, t, {
        type: 'right',
        style: Z.headerSubview,
      })
    );
  },
  ScreenStackHeaderLeftView: function (t) {
    return React.default.createElement(
      K.NativeScreenStackHeaderSubview,
      module14.default({}, t, {
        type: 'left',
        style: Z.headerSubview,
      })
    );
  },
  ScreenStackHeaderCenterView: function (t) {
    return React.default.createElement(
      K.NativeScreenStackHeaderSubview,
      module14.default({}, t, {
        type: 'center',
        style: Z.headerSubview,
      })
    );
  },
  ScreenStackHeaderSearchBarView: function (t) {
    return React.default.createElement(
      K.NativeScreenStackHeaderSubview,
      module14.default({}, t, {
        type: 'searchBar',
        style: Z.headerSubview,
      })
    );
  },
  enableScreens: function () {
    var t = !(arguments.length > 0 && undefined !== arguments[0]) || arguments[0];
    if ((z = V && t) && !ReactNative.UIManager.getViewManagerConfig('RNSScreen'))
      console.error("Screen native module hasn't been linked. Please check the react-native-screens README for more details");
  },
  enableFreeze: function () {
    var t = !(arguments.length > 0 && undefined !== arguments[0]) || arguments[0],
      n = parseInt(module407.version.split('.')[1]);
    if (!(0 === n || n >= 64 || !t))
      console.warn('react-freeze library requires at least react-native 0.64. Please upgrade your react-native version in order to use this feature.');
    x = t;
  },
  screensEnabled: function () {
    return z;
  },
  shouldUseActivityState: true,
  useTransitionProgress: module737.default,
  isSearchBarAvailableForCurrentPlatform: module738.isSearchBarAvailableForCurrentPlatform,
  executeNativeBackPress: module738.executeNativeBackPress,
};
