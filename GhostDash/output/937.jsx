var module15 = require('@babel/runtime/helpers/slicedToArray'),
  regeneratorRuntime = require('regenerator-runtime'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module42 = require('./42'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module788 = require('./788'),
  module939 = require('./939'),
  module901 = require('./901'),
  module941 = require('./941'),
  module942 = require('./942'),
  L = '/Users/trensik/dev/react-native-paper/src/components/Menu/Menu.tsx';

function O(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var s = Object.getOwnPropertySymbols(t);
    if (n)
      s = s.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, s);
  }

  return o;
}

function E(t) {
  for (var n = 1; n < arguments.length; n++) {
    var o = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      O(Object(o), true).forEach(function (n) {
        module50.default(t, n, o[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      O(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

var P = 250,
  x = ReactNative.Easing.bezier(0.4, 0, 0.2, 1),
  R = (function (t, ...args) {
    function n() {
      var t, module28;
      module27.default(this, n);
      module28 = module40.default(this, (t = module37.default(n)).call.apply(t, [this].concat(args)));
      module50.default(module42.default(module28), 'state', {
        rendered: module28.props.visible,
        top: 0,
        left: 0,
        menuLayout: {
          width: 0,
          height: 0,
        },
        anchorLayout: {
          width: 0,
          height: 0,
        },
        opacityAnimation: new ReactNative.Animated.Value(0),
        scaleAnimation: new ReactNative.Animated.ValueXY({
          x: 0,
          y: 0,
        }),
      });
      module50.default(module42.default(module28), 'anchor', null);
      module50.default(module42.default(module28), 'menu', null);
      module50.default(module42.default(module28), 'isAnchorCoord', function () {
        return !React.isValidElement(module28.props.anchor);
      });
      module50.default(module42.default(module28), 'measureMenuLayout', function () {
        return new Promise(function (t) {
          if (module28.menu)
            module28.menu.measureInWindow(function (n, o, s, u) {
              t({
                x: n,
                y: o,
                width: s,
                height: u,
              });
            });
        });
      });
      module50.default(module42.default(module28), 'measureAnchorLayout', function () {
        return new Promise(function (t) {
          var n = module28.props.anchor;
          if (module28.isAnchorCoord())
            t({
              x: n.x,
              y: n.y,
              width: 0,
              height: 0,
            });
          else if (module28.anchor)
            module28.anchor.measureInWindow(function (n, o, s, u) {
              t({
                x: n,
                y: o,
                width: s,
                height: u,
              });
            });
        });
      });
      module50.default(module42.default(module28), 'updateVisibility', function () {
        return regeneratorRuntime.default.async(function (t) {
          for (;;)
            switch ((t.prev = t.next)) {
              case 0:
                t.next = 2;
                return regeneratorRuntime.default.awrap(Promise.resolve());

              case 2:
                if (module28.props.visible) module28.show();
                else module28.hide();

              case 3:
              case 'end':
                return t.stop();
            }
        });
      });
      module50.default(module42.default(module28), 'isBrowser', function () {
        return 'web' === ReactNative.Platform.OS && 'document' in globals;
      });
      module50.default(module42.default(module28), 'focusFirstDOMNode', function (t) {
        if (t && module28.isBrowser()) {
          var n = ReactNative.findNodeHandle(t).querySelector('button, [href], input, select, textarea, [tabindex]:not([tabindex="-1"])');
          if (!(null === n || undefined === n)) n.focus();
        }
      });
      module50.default(module42.default(module28), 'handleDismiss', function () {
        if (module28.props.visible) module28.props.onDismiss();
        return true;
      });
      module50.default(module42.default(module28), 'handleKeypress', function (t) {
        if ('Escape' === t.key) module28.props.onDismiss();
      });
      module50.default(module42.default(module28), 'attachListeners', function () {
        ReactNative.BackHandler.addEventListener('hardwareBackPress', module28.handleDismiss);
        ReactNative.Dimensions.addEventListener('change', module28.handleDismiss);
        if (module28.isBrowser()) document.addEventListener('keyup', module28.handleKeypress);
      });
      module50.default(module42.default(module28), 'removeListeners', function () {
        ReactNative.BackHandler.removeEventListener('hardwareBackPress', module28.handleDismiss);
        ReactNative.Dimensions.removeEventListener('change', module28.handleDismiss);
        if (module28.isBrowser()) document.removeEventListener('keyup', module28.handleKeypress);
      });
      module50.default(module42.default(module28), 'show', function () {
        var t, n, u, h, c;
        return regeneratorRuntime.default.async(function (f) {
          for (;;)
            switch ((f.prev = f.next)) {
              case 0:
                t = ReactNative.Dimensions.get('window');
                f.next = 3;
                return regeneratorRuntime.default.awrap(Promise.all([module28.measureMenuLayout(), module28.measureAnchorLayout()]));

              case 3:
                if (
                  ((n = f.sent),
                  (u = module15.default(n, 2)),
                  (h = u[0]),
                  (c = u[1]),
                  t.width && t.height && h.width && h.height && (c.width || module28.isAnchorCoord()) && (c.height || module28.isAnchorCoord()))
                ) {
                  f.next = 10;
                  break;
                }

                requestAnimationFrame(module28.show);
                return f.abrupt('return');

              case 10:
                module28.setState(
                  function () {
                    return {
                      left: c.x,
                      top: c.y,
                      anchorLayout: {
                        height: c.height,
                        width: c.width,
                      },
                      menuLayout: {
                        width: h.width,
                        height: h.height,
                      },
                    };
                  },
                  function () {
                    module28.attachListeners();
                    var t = module28.props.theme.animation;
                    ReactNative.Animated.parallel([
                      ReactNative.Animated.timing(module28.state.scaleAnimation, {
                        toValue: {
                          x: h.width,
                          y: h.height,
                        },
                        duration: P * t.scale,
                        easing: x,
                        useNativeDriver: true,
                      }),
                      ReactNative.Animated.timing(module28.state.opacityAnimation, {
                        toValue: 1,
                        duration: P * t.scale,
                        easing: x,
                        useNativeDriver: true,
                      }),
                    ]).start(function (t) {
                      if (t.finished) module28.focusFirstDOMNode(module28.menu);
                    });
                  }
                );

              case 11:
              case 'end':
                return f.stop();
            }
        });
      });
      module50.default(module42.default(module28), 'hide', function () {
        module28.removeListeners();
        var t = module28.props.theme.animation;
        ReactNative.Animated.timing(module28.state.opacityAnimation, {
          toValue: 0,
          duration: P * t.scale,
          easing: x,
          useNativeDriver: true,
        }).start(function (t) {
          if (t) {
            module28.setState({
              menuLayout: {
                width: 0,
                height: 0,
              },
              rendered: false,
            });
            module28.state.scaleAnimation.setValue({
              x: 0,
              y: 0,
            });
            module28.focusFirstDOMNode(module28.anchor);
          }
        });
      });
      return module28;
    }

    module38.default(n, t);
    module28.default(
      n,
      [
        {
          key: 'componentDidUpdate',
          value: function (t) {
            if (t.visible !== this.props.visible) this.updateVisibility();
          },
        },
        {
          key: 'componentWillUnmount',
          value: function () {
            this.removeListeners();
          },
        },
        {
          key: 'render',
          value: function () {
            var t = this,
              n = this.props,
              o = n.visible,
              s = n.anchor,
              u = n.contentStyle,
              l = n.style,
              h = n.children,
              c = n.theme,
              f = n.statusBarHeight,
              p = n.onDismiss,
              w = this.state,
              b = w.rendered,
              D = w.menuLayout,
              _ = w.anchorLayout,
              O = w.opacityAnimation,
              P = w.scaleAnimation,
              x = this.state,
              R = x.left,
              k = x.top,
              S = ReactNative.Platform.select({
                android: f,
                default: 0,
              }),
              j = [
                {
                  scaleX: P.x.interpolate({
                    inputRange: [0, D.width],
                    outputRange: [0, 1],
                  }),
                },
                {
                  scaleY: P.y.interpolate({
                    inputRange: [0, D.height],
                    outputRange: [0, 1],
                  }),
                },
              ],
              M = ReactNative.Dimensions.get('window'),
              B = [];

            if (R <= M.width - D.width - 8) {
              B.push({
                translateX: P.x.interpolate({
                  inputRange: [0, D.width],
                  outputRange: [-D.width / 2, 0],
                }),
              });
              if (R < 8) R = 8;
            } else {
              B.push({
                translateX: P.x.interpolate({
                  inputRange: [0, D.width],
                  outputRange: [D.width / 2, 0],
                }),
              });
              if ((R += _.width - D.width) + D.width > M.width - 8) R = M.width - 8 - D.width;
            }

            var C = 0;

            if (
              (k >= M.height - D.height - 8 - S && k <= M.height - k
                ? (C = M.height - k - 8 - S)
                : k >= M.height - D.height - 8 - S && k >= M.height - k && k <= D.height - _.height + 8 - S && (C = k + _.height - 8 + S),
              (C = C > M.height - 16 ? M.height - 16 : C),
              k <= M.height - D.height - 8 - S || (k >= M.height - D.height - 8 - S && k <= M.height - k))
            ) {
              B.push({
                translateY: P.y.interpolate({
                  inputRange: [0, D.height],
                  outputRange: [-(C || D.height) / 2, 0],
                }),
              });
              if (k < 8) k = 8;
            } else {
              B.push({
                translateY: P.y.interpolate({
                  inputRange: [0, D.height],
                  outputRange: [(C || D.height) / 2, 0],
                }),
              });
              if ((k += _.height - (C || D.height)) + (C || D.height) + S > M.height - 8) k = C === M.height - 16 ? -16 : M.height - D.height - 8 - S;
            }

            var F = E(
                {
                  opacity: O,
                  transform: j,
                  borderRadius: c.roundness,
                },
                C
                  ? {
                      height: C,
                    }
                  : {}
              ),
              H = E(
                {
                  top: this.isAnchorCoord() ? k : k + S,
                },
                ReactNative.I18nManager.isRTL
                  ? {
                      right: R,
                    }
                  : {
                      left: R,
                    }
              );
            return (
              <ReactNative.View
                ref={function (n) {
                  t.anchor = n;
                }}
                collapsable={false}
                __source={{
                  fileName: L,
                  lineNumber: 529,
                }}
              >
                {this.isAnchorCoord() ? null : s}
                {b ? (
                  <module939.default
                    __source={{
                      fileName: L,
                      lineNumber: 537,
                    }}
                  >
                    <ReactNative.TouchableWithoutFeedback
                      onPress={p}
                      __source={{
                        fileName: L,
                        lineNumber: 538,
                      }}
                    >
                      <ReactNative.View
                        style={ReactNative.StyleSheet.absoluteFill}
                        __source={{
                          fileName: L,
                          lineNumber: 539,
                        }}
                      />
                    </ReactNative.TouchableWithoutFeedback>
                    <ReactNative.View
                      ref={function (n) {
                        t.menu = n;
                      }}
                      collapsable={false}
                      accessibilityViewIsModal={o}
                      style={[V.wrapper, H, l]}
                      pointerEvents={o ? 'box-none' : 'none'}
                      __source={{
                        fileName: L,
                        lineNumber: 541,
                      }}
                    >
                      {React.createElement(
                        ReactNative.Animated.View,
                        {
                          style: {
                            transform: B,
                          },
                          __source: {
                            fileName: L,
                            lineNumber: 550,
                          },
                        },
                        React.createElement(
                          module901.default,
                          {
                            style: [V.shadowMenuContainer, F, u],
                            __source: {
                              fileName: L,
                              lineNumber: 551,
                            },
                          },
                          (C &&
                            React.createElement(
                              ReactNative.ScrollView,
                              {
                                __source: {
                                  fileName: L,
                                  lineNumber: 561,
                                },
                              },
                              h
                            )) ||
                            React.createElement(
                              React.Fragment,
                              {
                                __source: {
                                  fileName: L,
                                  lineNumber: 562,
                                },
                              },
                              h
                            )
                        )
                      )}
                    </ReactNative.View>
                  </module939.default>
                ) : null}
              </ReactNative.View>
            );
          },
        },
      ],
      [
        {
          key: 'getDerivedStateFromProps',
          value: function (t, n) {
            return t.visible && !n.rendered
              ? {
                  rendered: true,
                }
              : null;
          },
        },
      ]
    );
    return n;
  })(React.Component);

module50.default(R, 'Item', module941.default);
module50.default(R, 'defaultProps', {
  statusBarHeight: module942.APPROX_STATUSBAR_HEIGHT,
});
var V = ReactNative.StyleSheet.create({
    wrapper: {
      position: 'absolute',
    },
    shadowMenuContainer: {
      opacity: 0,
      paddingVertical: 8,
      elevation: 8,
    },
  }),
  k = module788.withTheme(R);
exports.default = k;
