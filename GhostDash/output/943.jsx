var module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module42 = require('./42'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module760 = require('./760'),
  module788 = require('./788'),
  y = '/Users/trensik/dev/react-native-paper/src/components/ProgressBar.tsx',
  b = 2e3,
  N = ReactNative.I18nManager.isRTL,
  V = (function (t, ...args) {
    function n() {
      var t, module28;
      module27.default(this, n);
      module28 = module40.default(this, (t = module37.default(n)).call.apply(t, [this].concat(args)));
      module50.default(module42.default(module28), 'state', {
        width: 0,
        timer: new ReactNative.Animated.Value(0),
        fade: new ReactNative.Animated.Value(0),
      });
      module50.default(module42.default(module28), 'indeterminateAnimation', null);
      module50.default(module42.default(module28), 'onLayout', function (t) {
        var n = module28.props.visible,
          o = module28.state.width;
        module28.setState(
          {
            width: t.nativeEvent.layout.width,
          },
          function () {
            if (n && 0 === o) module28.startAnimation();
          }
        );
      });
      module50.default(module42.default(module28), 'startAnimation', function () {
        var t = module28.props,
          n = t.indeterminate,
          o = t.progress,
          u = t.theme.animation.scale,
          l = module28.state,
          p = l.fade,
          f = l.timer;
        ReactNative.Animated.timing(p, {
          duration: 200 * u,
          toValue: 1,
          useNativeDriver: true,
          isInteraction: false,
        }).start();

        if (n) {
          if (!module28.indeterminateAnimation)
            module28.indeterminateAnimation = ReactNative.Animated.timing(f, {
              duration: b,
              toValue: 1,
              useNativeDriver: 'web' !== ReactNative.Platform.OS,
              isInteraction: false,
            });
          f.setValue(0);
          ReactNative.Animated.loop(module28.indeterminateAnimation).start();
        } else
          ReactNative.Animated.timing(f, {
            duration: 200 * u,
            toValue: o || 0,
            useNativeDriver: true,
            isInteraction: false,
          }).start();
      });
      module50.default(module42.default(module28), 'stopAnimation', function () {
        var t = module28.state.fade,
          n = module28.props.theme.animation.scale;
        if (module28.indeterminateAnimation) module28.indeterminateAnimation.stop();
        ReactNative.Animated.timing(t, {
          duration: 200 * n,
          toValue: 0,
          useNativeDriver: true,
          isInteraction: false,
        }).start();
      });
      return module28;
    }

    module38.default(n, t);
    module28.default(n, [
      {
        key: 'componentDidUpdate',
        value: function (t) {
          var n = this.props,
            o = n.visible;
          if (!(n.progress === t.progress && o === t.visible)) o ? this.startAnimation() : this.stopAnimation();
        },
      },
      {
        key: 'render',
        value: function () {
          var t = this.props,
            n = t.color,
            o = t.indeterminate,
            s = t.style,
            u = t.theme,
            l = this.state,
            p = l.fade,
            f = l.timer,
            c = l.width,
            w = n || u.colors.primary,
            b = module760.default(w).alpha(0.38).rgb().string();
          return (
            <ReactNative.View
              onLayout={this.onLayout}
              __source={{
                fileName: y,
                lineNumber: 178,
              }}
            >
              {React.createElement(
                ReactNative.Animated.View,
                {
                  style: [
                    _.container,
                    {
                      backgroundColor: b,
                      opacity: p,
                    },
                    s,
                  ],
                  __source: {
                    fileName: y,
                    lineNumber: 179,
                  },
                },
                React.createElement(ReactNative.Animated.View, {
                  style: [
                    _.progressBar,
                    {
                      backgroundColor: w,
                      width: c,
                      transform: [
                        {
                          translateX: f.interpolate(
                            o
                              ? {
                                  inputRange: [0, 0.5, 1],
                                  outputRange: [0.5 * (N ? 1 : -1) * c, 0.5 * (N ? 1 : -1) * 0.6 * c, 0.7 * (N ? -1 : 1) * c],
                                }
                              : {
                                  inputRange: [0, 1],
                                  outputRange: [0.5 * (N ? 1 : -1) * c, 0],
                                }
                          ),
                        },
                        {
                          scaleX: f.interpolate(
                            o
                              ? {
                                  inputRange: [0, 0.5, 1],
                                  outputRange: [1e-4, 0.6, 1e-4],
                                }
                              : {
                                  inputRange: [0, 1],
                                  outputRange: [1e-4, 1],
                                }
                          ),
                        },
                      ],
                    },
                  ],
                  __source: {
                    fileName: y,
                    lineNumber: 186,
                  },
                })
              )}
            </ReactNative.View>
          );
        },
      },
    ]);
    return n;
  })(React.Component);

module50.default(V, 'defaultProps', {
  visible: true,
  progress: 0,
});

var _ = ReactNative.StyleSheet.create({
    container: {
      height: 4,
      overflow: 'hidden',
    },
    progressBar: {
      flex: 1,
    },
  }),
  R = module788.withTheme(V);

exports.default = R;
