var module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module42 = require('./42'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module882 = require('./882'),
  module788 = require('./788'),
  y = '/Users/trensik/dev/react-native-paper/src/components/CrossFadeIcon.tsx',
  N = (function (t, ...args) {
    function n() {
      var t, module28;
      module27.default(this, n);
      module28 = module40.default(this, (t = module37.default(n)).call.apply(t, [this].concat(args)));
      module50.default(module42.default(module28), 'state', {
        currentIcon: module28.props.source,
        previousIcon: null,
        fade: new ReactNative.Animated.Value(1),
      });
      return module28;
    }

    module38.default(n, t);
    module28.default(
      n,
      [
        {
          key: 'componentDidUpdate',
          value: function (t, n) {
            var o = this.state.previousIcon,
              s = this.props.theme.animation.scale;

            if (module882.isValidIcon(o) && !module882.isEqualIcon(o, n.previousIcon)) {
              this.state.fade.setValue(1);
              ReactNative.Animated.timing(this.state.fade, {
                duration: 200 * s,
                toValue: 0,
                useNativeDriver: false,
              }).start();
            }
          },
        },
        {
          key: 'render',
          value: function () {
            var t = this.props,
              n = t.color,
              o = t.size,
              s = this.state.fade,
              u = this.state.previousIcon
                ? this.state.fade.interpolate({
                    inputRange: [0, 1],
                    outputRange: [1, 0],
                  })
                : 1,
              c = this.state.fade.interpolate({
                inputRange: [0, 1],
                outputRange: ['-90deg', '0deg'],
              }),
              l = this.state.previousIcon
                ? this.state.fade.interpolate({
                    inputRange: [0, 1],
                    outputRange: ['0deg', '-180deg'],
                  })
                : '0deg';
            return (
              <ReactNative.View
                style={[
                  w.content,
                  {
                    height: o,
                    width: o,
                  },
                ]}
                __source={{
                  fileName: y,
                  lineNumber: 98,
                }}
              >
                {this.state.previousIcon
                  ? React.createElement(
                      ReactNative.Animated.View,
                      {
                        style: [
                          w.icon,
                          {
                            opacity: s,
                            transform: [
                              {
                                rotate: c,
                              },
                            ],
                          },
                        ],
                        __source: {
                          fileName: y,
                          lineNumber: 108,
                        },
                      },
                      React.createElement(module882.default, {
                        source: this.state.previousIcon,
                        size: o,
                        color: n,
                        __source: {
                          fileName: y,
                          lineNumber: 117,
                        },
                      })
                    )
                  : null}
                {React.createElement(
                  ReactNative.Animated.View,
                  {
                    style: [
                      w.icon,
                      {
                        opacity: u,
                        transform: [
                          {
                            rotate: l,
                          },
                        ],
                      },
                    ],
                    __source: {
                      fileName: y,
                      lineNumber: 120,
                    },
                  },
                  React.createElement(module882.default, {
                    source: this.state.currentIcon,
                    size: o,
                    color: n,
                    __source: {
                      fileName: y,
                      lineNumber: 129,
                    },
                  })
                )}
              </ReactNative.View>
            );
          },
        },
      ],
      [
        {
          key: 'getDerivedStateFromProps',
          value: function (t, n) {
            return n.currentIcon === t.source
              ? null
              : {
                  currentIcon: t.source,
                  previousIcon: n.currentIcon,
                };
          },
        },
      ]
    );
    return n;
  })(React.Component),
  b = module788.withTheme(N);

exports.default = b;
var w = ReactNative.StyleSheet.create({
  content: {
    alignItems: 'center',
    justifyContent: 'center',
  },
  icon: {
    position: 'absolute',
    top: 0,
    left: 0,
    right: 0,
    bottom: 0,
  },
});
