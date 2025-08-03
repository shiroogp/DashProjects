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
  module760 = require('./760'),
  module798 = require('./798'),
  module888 = require('./888'),
  module788 = require('./788'),
  N = '/Users/trensik/dev/react-native-paper/src/components/CheckboxAndroid.tsx',
  x = (function (t, ...args) {
    function l() {
      var t, module14;
      module27.default(this, l);
      module14 = module40.default(this, (t = module37.default(l)).call.apply(t, [this].concat(args)));
      module50.default(module42.default(module14), 'state', {
        scaleAnim: new ReactNative.Animated.Value(1),
      });
      return module14;
    }

    module38.default(l, t);
    module28.default(l, [
      {
        key: 'componentDidUpdate',
        value: function (t) {
          if (t.status !== this.props.status) {
            var l = 'checked' === this.props.status,
              n = this.props.theme.animation;
            ReactNative.Animated.sequence([
              ReactNative.Animated.timing(this.state.scaleAnim, {
                toValue: 0.85,
                duration: l ? 100 * n.scale : 0,
              }),
              ReactNative.Animated.timing(this.state.scaleAnim, {
                toValue: 1,
                duration: l ? 100 * n.scale : 100 * n.scale * 1.75,
              }),
            ]).start();
          }
        },
      },
      {
        key: 'render',
        value: function () {
          var t,
            l,
            o = this.props,
            c = o.status,
            u = o.disabled,
            h = o.onPress,
            b = o.theme,
            f = module56.default(o, ['status', 'disabled', 'onPress', 'theme']),
            p = 'checked' === c,
            C = 'indeterminate' === c,
            x = this.props.color || b.colors.accent,
            R =
              this.props.uncheckedColor ||
              module760
                .default(b.colors.text)
                .alpha(b.dark ? 0.7 : 0.54)
                .rgb()
                .string();

          if (u) {
            t = module760.default(b.colors.text).alpha(0.16).rgb().string();
            l = b.colors.disabled;
          } else {
            t = module760.default(x).fade(0.32).rgb().string();
            l = p ? x : R;
          }

          var S = this.state.scaleAnim.interpolate({
              inputRange: [0.8, 1],
              outputRange: [7, 0],
            }),
            V = C ? 'minus-box' : p ? 'checkbox-marked' : 'checkbox-blank-outline';
          return (
            <module888.default>
              {React.createElement(
                ReactNative.Animated.View,
                {
                  style: {
                    transform: [
                      {
                        scale: this.state.scaleAnim,
                      },
                    ],
                  },
                  __source: {
                    fileName: N,
                    lineNumber: 140,
                  },
                },
                React.createElement(module798.default, {
                  allowFontScaling: false,
                  name: V,
                  size: 24,
                  color: l,
                  direction: ReactNative.I18nManager.isRTL ? 'rtl' : 'ltr',
                  __source: {
                    fileName: N,
                    lineNumber: 141,
                  },
                }),
                React.createElement(
                  ReactNative.View,
                  {
                    style: [ReactNative.StyleSheet.absoluteFill, w.fillContainer],
                    __source: {
                      fileName: N,
                      lineNumber: 148,
                    },
                  },
                  React.createElement(ReactNative.Animated.View, {
                    style: [
                      w.fill,
                      {
                        borderColor: l,
                      },
                      {
                        borderWidth: S,
                      },
                    ],
                    __source: {
                      fileName: N,
                      lineNumber: 149,
                    },
                  })
                )
              )}
            </module888.default>
          );
        },
      },
    ]);
    return l;
  })(React.Component);

exports.CheckboxAndroid = x;
module50.default(x, 'displayName', 'Checkbox.Android');
var w = ReactNative.StyleSheet.create({
    container: {
      borderRadius: 18,
      width: 36,
      height: 36,
      padding: 6,
    },
    fillContainer: {
      alignItems: 'center',
      justifyContent: 'center',
    },
    fill: {
      height: 14,
      width: 14,
    },
  }),
  R = module788.withTheme(x);
exports.default = R;
