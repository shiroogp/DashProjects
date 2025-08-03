var module23 = require('@babel/runtime/helpers/toConsumableArray'),
  module42 = require('./42'),
  module50 = require('./50'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  React = require('react'),
  ReactNative = require('react-native'),
  module904 = require('./904'),
  module760 = require('./760'),
  module879 = require('./879'),
  module882 = require('./882'),
  module901 = require('./901'),
  module898 = require('./898'),
  module888 = require('./888'),
  module885 = require('./885'),
  module787 = require('./787'),
  module788 = require('./788'),
  P = '/Users/trensik/dev/react-native-paper/src/components/BottomNavigation.tsx';

function D(t, n) {
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
  for (var n = 1; n < arguments.length; n++) {
    var o = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      D(Object(o), true).forEach(function (n) {
        module50.default(t, n, o[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      D(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

var K = 0.001,
  R = module888.default.supported
    ? module888.default
    : function (t) {
        var n = t.style,
          o = t.children,
          l = module56.default(t, ['style', 'children', 'borderless', 'centered', 'rippleColor']);
        return (
          <ReactNative.TouchableWithoutFeedback>
            <ReactNative.View
              style={n}
              __source={{
                fileName: P,
                lineNumber: 272,
              }}
            >
              {o}
            </ReactNative.View>
          </ReactNative.TouchableWithoutFeedback>
        );
      },
  T = (function (t) {
    function n() {
      module27.default(this, n);
      return module40.default(this, module37.default(n).apply(this, arguments));
    }

    module38.default(n, t);
    module28.default(n, [
      {
        key: 'render',
        value: function () {
          var t = this.props,
            n = t.component,
            o = module56.default(t, ['component']);
          return <n />;
        },
      },
    ]);
    return n;
  })(React.PureComponent),
  L = (function (t) {
    function n(t) {
      var c;
      module27.default(this, n);
      c = module40.default(this, module37.default(n).call(this, t));
      module50.default(module42.default(c), 'handleKeyboardShow', function () {
        var t = c.props.theme.animation.scale;
        c.setState(
          {
            keyboard: true,
          },
          function () {
            return ReactNative.Animated.timing(c.state.visible, {
              toValue: 0,
              duration: 150 * t,
              useNativeDriver: true,
            }).start();
          }
        );
      });
      module50.default(module42.default(c), 'handleKeyboardHide', function () {
        var t = c.props.theme.animation.scale;
        ReactNative.Animated.timing(c.state.visible, {
          toValue: 1,
          duration: 100 * t,
          useNativeDriver: true,
        }).start(function () {
          c.setState({
            keyboard: false,
          });
        });
      });
      module50.default(module42.default(c), 'animateToCurrentIndex', function () {
        var t = c.isShifting(),
          n = c.props,
          l = n.navigationState,
          u = n.theme.animation.scale,
          s = l.routes,
          f = l.index;
        c.state.ripple.setValue(K);
        ReactNative.Animated.parallel(
          [
            ReactNative.Animated.timing(c.state.ripple, {
              toValue: 1,
              duration: t ? 400 * u : 0,
              useNativeDriver: true,
            }),
          ].concat(
            module23.default(
              s.map(function (n, o) {
                return ReactNative.Animated.timing(c.state.tabs[o], {
                  toValue: o === f ? 1 : 0,
                  duration: t ? 150 * u : 0,
                  useNativeDriver: true,
                });
              })
            )
          )
        ).start(function (t) {
          var n = t.finished;
          c.state.tabs.map(function (t, n) {
            return t.setValue(n === f ? 1 : 0);
          });
          c.state.index.setValue(f);
          c.state.ripple.setValue(K);
          if (n)
            c.state.offsets.forEach(function (t, n) {
              if (n === f) t.setValue(0);
              else t.setValue(1);
            });
        });
      });
      module50.default(module42.default(c), 'handleLayout', function (t) {
        var n = c.state.layout,
          o = t.nativeEvent.layout,
          l = o.height,
          u = o.width;
        if (!(l === n.height && u === n.width))
          c.setState({
            layout: {
              height: l,
              width: u,
              measured: true,
            },
          });
      });
      module50.default(module42.default(c), 'handleTabPress', function (t) {
        var n = c.props,
          o = n.navigationState,
          l = n.onTabPress,
          u = n.onIndexChange,
          s = {
            route: o.routes[t],
            defaultPrevented: false,
            preventDefault: function () {
              s.defaultPrevented = true;
            },
          };
        if (!(null === l || undefined === l)) l(s);
        if (!s.defaultPrevented) t !== o.index && u(t);
      });
      module50.default(module42.default(c), 'jumpTo', function (t) {
        var n = c.props.navigationState.routes.findIndex(function (n) {
          return n.key === t;
        });
        c.props.onIndexChange(n);
      });
      module50.default(module42.default(c), 'isShifting', function () {
        return 'boolean' == typeof c.props.shifting ? c.props.shifting : c.props.navigationState.routes.length > 3;
      });
      var b = c.props.navigationState.index;
      c.state = {
        visible: new ReactNative.Animated.Value(1),
        tabs: [],
        offsets: [],
        index: new ReactNative.Animated.Value(b),
        ripple: new ReactNative.Animated.Value(K),
        touch: new ReactNative.Animated.Value(K),
        layout: {
          height: 0,
          width: 0,
          measured: false,
        },
        current: b,
        previous: 0,
        loaded: [b],
        keyboard: false,
      };
      return c;
    }

    module38.default(n, t);
    module28.default(n, null, [
      {
        key: 'SceneMap',
        value: function (t) {
          return function (n) {
            var o = n.route,
              l = n.jumpTo;
            return (
              <T
                key={o.key}
                component={t[o.key ? o.key : '']}
                route={o}
                jumpTo={l}
                __source={{
                  fileName: P,
                  lineNumber: 356,
                }}
              />
            );
          };
        },
      },
      {
        key: 'getDerivedStateFromProps',
        value: function (t, n) {
          var l = t.navigationState,
            u = l.index,
            s = l.routes,
            c = {
              tabs: s.map(function (t, o) {
                return n.tabs[o] || new ReactNative.Animated.Value(o === u ? 1 : 0);
              }),
              offsets: s.map(function (t, o) {
                return n.offsets[o] || new ReactNative.Animated.Value(o === u ? 0 : 1);
              }),
            };
          if (u !== n.current)
            module14.default(c, {
              current: u,
              previous: n.current,
              loaded: n.loaded.includes(u) ? n.loaded : [].concat(module23.default(n.loaded), [u]),
            });
          return c;
        },
      },
    ]);
    module28.default(n, [
      {
        key: 'componentDidMount',
        value: function () {
          this.animateToCurrentIndex();

          if ('ios' === ReactNative.Platform.OS) {
            ReactNative.Keyboard.addListener('keyboardWillShow', this.handleKeyboardShow);
            ReactNative.Keyboard.addListener('keyboardWillHide', this.handleKeyboardHide);
          } else {
            ReactNative.Keyboard.addListener('keyboardDidShow', this.handleKeyboardShow);
            ReactNative.Keyboard.addListener('keyboardDidHide', this.handleKeyboardHide);
          }
        },
      },
      {
        key: 'componentDidUpdate',
        value: function (t) {
          var n = this;

          if (t.navigationState.index !== this.props.navigationState.index) {
            this.state.offsets.forEach(function (o, l) {
              if (!(l !== n.props.navigationState.index && l !== t.navigationState.index)) o.setValue(0);
            });
            this.animateToCurrentIndex();
          }
        },
      },
      {
        key: 'componentWillUnmount',
        value: function () {
          if ('ios' === ReactNative.Platform.OS) {
            ReactNative.Keyboard.removeListener('keyboardWillShow', this.handleKeyboardShow);
            ReactNative.Keyboard.removeListener('keyboardWillHide', this.handleKeyboardHide);
          } else {
            ReactNative.Keyboard.removeListener('keyboardDidShow', this.handleKeyboardShow);
            ReactNative.Keyboard.removeListener('keyboardDidHide', this.handleKeyboardHide);
          }
        },
      },
      {
        key: 'render',
        value: function () {
          var t = this,
            n = this.props,
            o = n.navigationState,
            l = n.renderScene,
            u = n.renderIcon,
            s = n.renderLabel,
            c = n.getLabelText,
            f =
              undefined === c
                ? function (t) {
                    return t.route.title;
                  }
                : c,
            p = n.getBadge,
            b =
              undefined === p
                ? function (t) {
                    return t.route.badge;
                  }
                : p,
            h = n.getColor,
            y =
              undefined === h
                ? function (t) {
                    return t.route.color;
                  }
                : h,
            x = n.getAccessibilityLabel,
            O =
              undefined === x
                ? function (t) {
                    return t.route.accessibilityLabel;
                  }
                : x,
            D = n.getTestID,
            j =
              undefined === D
                ? function (t) {
                    return t.route.testID;
                  }
                : D,
            T = n.activeColor,
            L = n.inactiveColor,
            H = n.keyboardHidesNavigationBar,
            W = n.barStyle,
            z = n.labeled,
            F = n.style,
            B = n.theme,
            M = n.sceneAnimationEnabled,
            U = this.state,
            Y = U.layout,
            q = U.loaded,
            G = U.index,
            J = U.visible,
            Q = U.ripple,
            X = U.keyboard,
            Z = U.tabs,
            $ = U.offsets,
            ee = o.routes,
            te = B.colors,
            ne = B.dark,
            ae = B.mode,
            re = this.isShifting(),
            ie = ReactNative.StyleSheet.flatten(W) || {},
            oe = ie.backgroundColor,
            le = ie.elevation,
            ue = undefined === le ? 4 : le,
            se = oe || (ne && 'adaptive' === ae ? module879.default(ue, te.surface) : te.primary),
            de = re
              ? G.interpolate({
                  inputRange: ee.map(function (t, n) {
                    return n;
                  }),
                  outputRange: ee.map(function (t) {
                    return (
                      y({
                        route: t,
                      }) || se
                    );
                  }),
                })
              : se,
            ce = !module760.default(se).isLight() ? module787.white : module787.black,
            fe = undefined !== T ? T : ce,
            me = undefined !== L ? L : module760.default(ce).alpha(0.5).rgb().string(),
            pe = module760
              .default(T || fe)
              .alpha(0.12)
              .rgb()
              .string(),
            be = (ee.length > 3 ? 96 : 168) * ee.length,
            he = Y.width ** be / ee.length,
            ye = Y.width / 4;
          return (
            <ReactNative.View
              style={[I.container, F]}
              __source={{
                fileName: P,
                lineNumber: 674,
              }}
            >
              <ReactNative.View
                style={[
                  I.content,
                  {
                    backgroundColor: te.background,
                  },
                ]}
                __source={{
                  fileName: P,
                  lineNumber: 675,
                }}
              >
                {ee.map(function (n, u) {
                  if (!q.includes(u)) return null;
                  var s = o.index === u,
                    c = false !== M ? Z[u] : s ? 1 : 0,
                    f = $[u].interpolate({
                      inputRange: [0, 1],
                      outputRange: [0, 9999],
                    });
                  return React.createElement(
                    ReactNative.Animated.View,
                    {
                      key: n.key,
                      pointerEvents: s ? 'auto' : 'none',
                      accessibilityElementsHidden: !s,
                      importantForAccessibility: s ? 'auto' : 'no-hide-descendants',
                      style: [
                        ReactNative.StyleSheet.absoluteFill,
                        {
                          opacity: c,
                        },
                      ],
                      collapsable: false,
                      removeClippedSubviews: 'ios' !== ReactNative.Platform.OS || o.index !== u,
                      __source: {
                        fileName: P,
                        lineNumber: 692,
                      },
                    },
                    React.createElement(
                      ReactNative.Animated.View,
                      {
                        style: [
                          I.content,
                          {
                            top: f,
                          },
                        ],
                        __source: {
                          fileName: P,
                          lineNumber: 707,
                        },
                      },
                      l({
                        route: n,
                        jumpTo: t.jumpTo,
                      })
                    )
                  );
                })}
              </ReactNative.View>
              <module901.default
                style={[
                  I.bar,
                  H
                    ? {
                        transform: [
                          {
                            translateY: J.interpolate({
                              inputRange: [0, 1],
                              outputRange: [Y.height, 0],
                            }),
                          },
                        ],
                        position: X ? 'absolute' : null,
                      }
                    : null,
                  W,
                ]}
                pointerEvents={Y.measured ? (H && X ? 'none' : 'auto') : 'none'}
                onLayout={this.handleLayout}
                __source={{
                  fileName: P,
                  lineNumber: 717,
                }}
              >
                {React.createElement(
                  ReactNative.Animated.View,
                  {
                    style: [
                      I.barContent,
                      {
                        backgroundColor: de,
                      },
                    ],
                    __source: {
                      fileName: P,
                      lineNumber: 749,
                    },
                  },
                  React.createElement(
                    module904.default,
                    {
                      forceInset: {
                        top: 'never',
                        bottom: 'always',
                      },
                      style: [
                        I.items,
                        {
                          maxWidth: be,
                        },
                      ],
                      __source: {
                        fileName: P,
                        lineNumber: 750,
                      },
                    },
                    re
                      ? React.createElement(ReactNative.Animated.View, {
                          pointerEvents: 'none',
                          style: [
                            I.ripple,
                            {
                              top: (56 - ye) / 2,
                              left: he * (o.index + 0.5) - ye / 2,
                              height: ye,
                              width: ye,
                              borderRadius: ye / 2,
                              backgroundColor: y({
                                route: ee[o.index],
                              }),
                              transform: [
                                {
                                  scale: Q.interpolate({
                                    inputRange: [0, 1],
                                    outputRange: [0, 8],
                                  }),
                                },
                              ],
                              opacity: Q.interpolate({
                                inputRange: [0, K, 0.3, 1],
                                outputRange: [0, 0, 1, 1],
                              }),
                            },
                          ],
                          __source: {
                            fileName: P,
                            lineNumber: 755,
                          },
                        })
                      : null,
                    ee.map(function (n, l) {
                      var c = o.index === l,
                        p = Z[l],
                        h =
                          z && re
                            ? p.interpolate({
                                inputRange: [0, 1],
                                outputRange: [0.5, 1],
                              })
                            : 1,
                        y = z
                          ? re
                            ? p.interpolate({
                                inputRange: [0, 1],
                                outputRange: [7, 0],
                              })
                            : 0
                          : 7,
                        _ = p,
                        w = p.interpolate({
                          inputRange: [0, 1],
                          outputRange: [1, 0],
                        }),
                        S = b({
                          route: n,
                        });
                      return React.createElement(
                        R,
                        {
                          key: n.key,
                          borderless: true,
                          centered: true,
                          rippleColor: pe,
                          onPress: function () {
                            return t.handleTabPress(l);
                          },
                          testID: j({
                            route: n,
                          }),
                          accessibilityLabel: O({
                            route: n,
                          }),
                          accessibilityTraits: c ? ['button', 'selected'] : 'button',
                          accessibilityComponentType: 'button',
                          accessibilityRole: 'button',
                          accessibilityStates: ['selected'],
                          style: I.item,
                          __source: {
                            fileName: P,
                            lineNumber: 824,
                          },
                        },
                        React.createElement(
                          ReactNative.View,
                          {
                            pointerEvents: 'none',
                            __source: {
                              fileName: P,
                              lineNumber: 840,
                            },
                          },
                          React.createElement(
                            ReactNative.Animated.View,
                            {
                              style: [
                                I.iconContainer,
                                {
                                  transform: [
                                    {
                                      translateY: y,
                                    },
                                  ],
                                },
                              ],
                              __source: {
                                fileName: P,
                                lineNumber: 841,
                              },
                            },
                            React.createElement(
                              ReactNative.Animated.View,
                              {
                                style: [
                                  I.iconWrapper,
                                  {
                                    opacity: _,
                                  },
                                ],
                                __source: {
                                  fileName: P,
                                  lineNumber: 847,
                                },
                              },
                              u
                                ? u({
                                    route: n,
                                    focused: true,
                                    color: fe,
                                  })
                                : React.createElement(module882.default, {
                                    source: n.icon,
                                    color: fe,
                                    size: 24,
                                    __source: {
                                      fileName: P,
                                      lineNumber: 860,
                                    },
                                  })
                            ),
                            React.createElement(
                              ReactNative.Animated.View,
                              {
                                style: [
                                  I.iconWrapper,
                                  {
                                    opacity: w,
                                  },
                                ],
                                __source: {
                                  fileName: P,
                                  lineNumber: 867,
                                },
                              },
                              u
                                ? u({
                                    route: n,
                                    focused: false,
                                    color: me,
                                  })
                                : React.createElement(module882.default, {
                                    source: n.icon,
                                    color: me,
                                    size: 24,
                                    __source: {
                                      fileName: P,
                                      lineNumber: 880,
                                    },
                                  })
                            ),
                            React.createElement(
                              ReactNative.View,
                              {
                                style: [
                                  I.badgeContainer,
                                  {
                                    right: (null != S && 'boolean' != typeof S ? -2 * String(S).length : 0) - 2,
                                  },
                                ],
                                __source: {
                                  fileName: P,
                                  lineNumber: 887,
                                },
                              },
                              'boolean' == typeof S
                                ? React.createElement(module898.default, {
                                    visible: S,
                                    size: 8,
                                    __source: {
                                      fileName: P,
                                      lineNumber: 899,
                                    },
                                  })
                                : React.createElement(
                                    module898.default,
                                    {
                                      visible: null != S,
                                      size: 16,
                                      __source: {
                                        fileName: P,
                                        lineNumber: 901,
                                      },
                                    },
                                    S
                                  )
                            )
                          ),
                          z
                            ? React.createElement(
                                ReactNative.Animated.View,
                                {
                                  style: [
                                    I.labelContainer,
                                    {
                                      transform: [
                                        {
                                          scale: h,
                                        },
                                      ],
                                    },
                                  ],
                                  __source: {
                                    fileName: P,
                                    lineNumber: 908,
                                  },
                                },
                                React.createElement(
                                  ReactNative.Animated.View,
                                  {
                                    style: [
                                      I.labelWrapper,
                                      {
                                        opacity: _,
                                      },
                                    ],
                                    __source: {
                                      fileName: P,
                                      lineNumber: 914,
                                    },
                                  },
                                  s
                                    ? s({
                                        route: n,
                                        focused: true,
                                        color: fe,
                                      })
                                    : React.createElement(
                                        module885.default,
                                        {
                                          style: [
                                            I.label,
                                            {
                                              color: fe,
                                            },
                                          ],
                                          __source: {
                                            fileName: P,
                                            lineNumber: 927,
                                          },
                                        },
                                        f({
                                          route: n,
                                        })
                                      )
                                ),
                                re
                                  ? null
                                  : React.createElement(
                                      ReactNative.Animated.View,
                                      {
                                        style: [
                                          I.labelWrapper,
                                          {
                                            opacity: w,
                                          },
                                        ],
                                        __source: {
                                          fileName: P,
                                          lineNumber: 938,
                                        },
                                      },
                                      s
                                        ? s({
                                            route: n,
                                            focused: false,
                                            color: me,
                                          })
                                        : React.createElement(
                                            module885.default,
                                            {
                                              style: [
                                                I.label,
                                                {
                                                  color: me,
                                                },
                                              ],
                                              __source: {
                                                fileName: P,
                                                lineNumber: 951,
                                              },
                                            },
                                            f({
                                              route: n,
                                            })
                                          )
                                    )
                              )
                            : React.createElement(ReactNative.View, {
                                style: I.labelContainer,
                                __source: {
                                  fileName: P,
                                  lineNumber: 964,
                                },
                              })
                        )
                      );
                    })
                  )
                )}
              </module901.default>
            </ReactNative.View>
          );
        },
      },
    ]);
    return n;
  })(React.Component);

module50.default(L, 'defaultProps', {
  labeled: true,
  keyboardHidesNavigationBar: true,
});
var H = module788.withTheme(L);
exports.default = H;
var I = ReactNative.StyleSheet.create({
  container: {
    flex: 1,
    overflow: 'hidden',
  },
  content: {
    flex: 1,
  },
  bar: {
    left: 0,
    right: 0,
    bottom: 0,
    elevation: 4,
  },
  barContent: {
    alignItems: 'center',
    overflow: 'hidden',
  },
  items: {
    flexDirection: 'row',
    width: '100%',
  },
  item: {
    flex: 1,
    paddingVertical: 6,
  },
  ripple: {
    position: 'absolute',
  },
  iconContainer: {
    height: 24,
    width: 24,
    marginTop: 2,
    marginHorizontal: 12,
    alignSelf: 'center',
  },
  iconWrapper: j({}, ReactNative.StyleSheet.absoluteFillObject, {
    alignItems: 'center',
  }),
  labelContainer: {
    height: 16,
    paddingBottom: 2,
  },
  labelWrapper: j({}, ReactNative.StyleSheet.absoluteFillObject),
  label: j(
    {
      fontSize: 12,
      textAlign: 'center',
      backgroundColor: 'transparent',
    },
    'web' === ReactNative.Platform.OS
      ? {
          whiteSpace: 'nowrap',
        }
      : null
  ),
  badgeContainer: {
    position: 'absolute',
    left: 0,
    top: -2,
  },
});
