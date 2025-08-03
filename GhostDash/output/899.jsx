var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module42 = require('./42'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module788 = require('./788'),
  O = '/Users/trensik/dev/react-native-paper/src/components/ActivityIndicator.tsx';

function _(t, n) {
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

var A = (function (t, ...args) {
  function n() {
    var t, module14;
    module27.default(this, n);
    module14 = module40.default(this, (t = module37.default(n)).call.apply(t, [this].concat(args)));
    module50.default(module42.default(module14), 'state', {
      timer: new ReactNative.Animated.Value(0),
      fade: new ReactNative.Animated.Value(!module14.props.animating && module14.props.hidesWhenStopped ? 0 : 1),
    });
    module50.default(module42.default(module14), 'rotation', undefined);
    module50.default(module42.default(module14), 'startRotation', function () {
      var t = module14.state,
        n = t.fade,
        l = t.timer,
        s = module14.props.theme.animation.scale;
      ReactNative.Animated.timing(n, {
        duration: 200 * s,
        toValue: 1,
        isInteraction: false,
        useNativeDriver: true,
      }).start();

      if (module14.rotation) {
        l.setValue(0);
        ReactNative.Animated.loop(module14.rotation).start();
      }
    });
    module50.default(module42.default(module14), 'stopRotation', function () {
      if (module14.rotation) module14.rotation.stop();
    });
    return module14;
  }

  module38.default(n, t);
  module28.default(n, [
    {
      key: 'componentDidMount',
      value: function () {
        var t = this.props.animating,
          n = this.state.timer;
        this.rotation = ReactNative.Animated.timing(n, {
          duration: 2400,
          easing: ReactNative.Easing.linear,
          useNativeDriver: 'web' !== ReactNative.Platform.OS,
          toValue: 1,
          isInteraction: false,
        });
        if (t) this.startRotation();
      },
    },
    {
      key: 'componentDidUpdate',
      value: function (t) {
        var n = this.props,
          o = n.animating,
          l = n.hidesWhenStopped,
          s = n.theme.animation.scale,
          u = this.state.fade;
        if (o !== t.animating)
          o
            ? this.startRotation()
            : l
            ? ReactNative.Animated.timing(u, {
                duration: 200 * s,
                toValue: 0,
                useNativeDriver: true,
                isInteraction: false,
              }).start(this.stopRotation.bind(this))
            : this.stopRotation();
      },
    },
    {
      key: 'render',
      value: function () {
        var t = this.state,
          n = t.fade,
          s = t.timer,
          u = this.props,
          c = u.color,
          f = u.size,
          p = u.style,
          h = u.theme,
          y = module56.default(u, ['animating', 'color', 'hidesWhenStopped', 'size', 'style', 'theme']),
          w = c || h.colors.primary,
          _ = 'string' == typeof f ? ('small' === f ? 24 : 48) : f || 24,
          A = ReactNative.Easing.bezier(0.4, 0, 0.7, 1),
          j = {
            width: _,
            height: _ / 2,
            overflow: 'hidden',
          };

        return (
          <ReactNative.View>
            {React.createElement(
              ReactNative.Animated.View,
              {
                style: [
                  {
                    width: _,
                    height: _,
                    opacity: n,
                  },
                ],
                __source: {
                  fileName: O,
                  lineNumber: 186,
                },
              },
              [0, 1].map(function (t) {
                var n = Array.from(new Array(144), function (t, n) {
                    return n / 143;
                  }),
                  o = Array.from(new Array(144), function (n, o) {
                    var l = (2 * o) / 143,
                      s = t ? 345 : -165;
                    if (l > 1) l = 2 - l;
                    return ''.concat(150 * (t ? -1 : 1) * A(l) + s, 'deg');
                  }),
                  l = {
                    width: _,
                    height: _,
                    transform: [
                      {
                        rotate: s.interpolate({
                          inputRange: [0, 1],
                          outputRange: [''.concat(45, 'deg'), ''.concat(765, 'deg')],
                        }),
                      },
                    ],
                  },
                  u = {
                    width: _,
                    height: _,
                    transform: [
                      {
                        translateY: t ? -_ / 2 : 0,
                      },
                      {
                        rotate: s.interpolate({
                          inputRange: n,
                          outputRange: o,
                        }),
                      },
                    ],
                  },
                  c = t
                    ? {
                        top: _ / 2,
                      }
                    : null,
                  f = {
                    width: _,
                    height: _,
                    borderColor: w,
                    borderWidth: _ / 10,
                    borderRadius: _ / 2,
                  };
                return React.createElement(
                  ReactNative.Animated.View,
                  {
                    key: t,
                    style: [N.layer],
                    __source: {
                      fileName: O,
                      lineNumber: 250,
                    },
                  },
                  React.createElement(
                    ReactNative.Animated.View,
                    {
                      style: l,
                      __source: {
                        fileName: O,
                        lineNumber: 251,
                      },
                    },
                    React.createElement(
                      ReactNative.Animated.View,
                      {
                        style: [j, c],
                        collapsable: false,
                        __source: {
                          fileName: O,
                          lineNumber: 252,
                        },
                      },
                      React.createElement(
                        ReactNative.Animated.View,
                        {
                          style: u,
                          __source: {
                            fileName: O,
                            lineNumber: 256,
                          },
                        },
                        React.createElement(
                          ReactNative.Animated.View,
                          {
                            style: j,
                            collapsable: false,
                            __source: {
                              fileName: O,
                              lineNumber: 257,
                            },
                          },
                          React.createElement(ReactNative.Animated.View, {
                            style: f,
                            __source: {
                              fileName: O,
                              lineNumber: 258,
                            },
                          })
                        )
                      )
                    )
                  )
                );
              })
            )}
          </ReactNative.View>
        );
      },
    },
  ]);
  return n;
})(React.Component);

module50.default(A, 'defaultProps', {
  animating: true,
  size: 'small',
  hidesWhenStopped: true,
});
var N = ReactNative.StyleSheet.create({
    container: {
      justifyContent: 'center',
      alignItems: 'center',
    },
    layer: (function (t) {
      for (var n = 1; n < arguments.length; n++) {
        var o = null != arguments[n] ? arguments[n] : {};
        if (n % 2)
          _(Object(o), true).forEach(function (n) {
            module50.default(t, n, o[n]);
          });
        else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
        else
          _(Object(o)).forEach(function (n) {
            Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
          });
      }

      return t;
    })({}, ReactNative.StyleSheet.absoluteFillObject, {
      justifyContent: 'center',
      alignItems: 'center',
    }),
  }),
  j = module788.withTheme(A);
exports.default = j;
