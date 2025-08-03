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
  module945 = require('./945'),
  module947 = require('./947'),
  module888 = require('./888'),
  module788 = require('./788'),
  N = '/Users/trensik/dev/react-native-paper/src/components/RadioButton/RadioButtonAndroid.tsx',
  R = 2,
  w = (function (t, ...args) {
    function o() {
      var t, module14;
      module27.default(this, o);
      module14 = module40.default(this, (t = module37.default(o)).call.apply(t, [this].concat(args)));
      module50.default(module42.default(module14), 'state', {
        borderAnim: new ReactNative.Animated.Value(R),
        radioAnim: new ReactNative.Animated.Value(1),
      });
      return module14;
    }

    module38.default(o, t);
    module28.default(o, [
      {
        key: 'componentDidUpdate',
        value: function (t) {
          if (t.status !== this.props.status) {
            var o = this.props.theme.animation.scale;

            if ('checked' === this.props.status) {
              this.state.radioAnim.setValue(1.2);
              ReactNative.Animated.timing(this.state.radioAnim, {
                toValue: 1,
                duration: 150 * o,
              }).start();
            } else {
              this.state.borderAnim.setValue(10);
              ReactNative.Animated.timing(this.state.borderAnim, {
                toValue: R,
                duration: 150 * o,
              }).start();
            }
          }
        },
      },
      {
        key: 'render',
        value: function () {
          var t,
            o,
            l = this,
            u = this.props,
            c = u.disabled,
            h = u.onPress,
            b = u.theme,
            f = u.value,
            p = u.status,
            k = module56.default(u, ['disabled', 'onPress', 'theme', 'value', 'status']),
            R = this.props.color || b.colors.accent,
            w =
              this.props.uncheckedColor ||
              module760
                .default(b.colors.text)
                .alpha(b.dark ? 0.7 : 0.54)
                .rgb()
                .string();
          return React.createElement(
            module945.RadioButtonContext.Consumer,
            {
              __source: {
                fileName: N,
                lineNumber: 106,
              },
            },
            function (s) {
              var u =
                'checked' ===
                module947.isChecked({
                  contextValue: null === s || undefined === s ? undefined : s.value,
                  status: p,
                  value: f,
                });

              if (c) {
                t = module760.default(b.colors.text).alpha(0.16).rgb().string();
                o = b.colors.disabled;
              } else {
                t = module760.default(R).fade(0.32).rgb().string();
                o = u ? R : w;
              }

              return React.createElement(
                module888.default,
                module14.default({}, k, {
                  borderless: true,
                  rippleColor: t,
                  onPress: c
                    ? undefined
                    : function () {
                        module947.handlePress({
                          onPress: h,
                          onValueChange: null === s || undefined === s ? undefined : s.onValueChange,
                          value: f,
                        });
                      },
                  accessibilityTraits: c ? ['button', 'disabled'] : 'button',
                  accessibilityComponentType: u ? 'radiobutton_checked' : 'radiobutton_unchecked',
                  accessibilityRole: 'button',
                  accessibilityStates: c ? ['disabled'] : [],
                  accessibilityLiveRegion: 'polite',
                  style: B.container,
                  __source: {
                    fileName: N,
                    lineNumber: 130,
                  },
                }),
                React.createElement(
                  ReactNative.Animated.View,
                  {
                    style: [
                      B.radio,
                      {
                        borderColor: o,
                        borderWidth: l.state.borderAnim,
                      },
                    ],
                    __source: {
                      fileName: N,
                      lineNumber: 154,
                    },
                  },
                  u
                    ? React.createElement(
                        ReactNative.View,
                        {
                          style: [ReactNative.StyleSheet.absoluteFill, B.radioContainer],
                          __source: {
                            fileName: N,
                            lineNumber: 164,
                          },
                        },
                        React.createElement(ReactNative.Animated.View, {
                          style: [
                            B.dot,
                            {
                              backgroundColor: o,
                              transform: [
                                {
                                  scale: l.state.radioAnim,
                                },
                              ],
                            },
                          ],
                          __source: {
                            fileName: N,
                            lineNumber: 167,
                          },
                        })
                      )
                    : null
                )
              );
            }
          );
        },
      },
    ]);
    return o;
  })(React.Component);

exports.RadioButtonAndroid = w;
module50.default(w, 'displayName', 'RadioButton.Android');
var B = ReactNative.StyleSheet.create({
    container: {
      borderRadius: 18,
    },
    radioContainer: {
      alignItems: 'center',
      justifyContent: 'center',
    },
    radio: {
      height: 20,
      width: 20,
      borderRadius: 10,
      margin: 8,
    },
    dot: {
      height: 10,
      width: 10,
      borderRadius: 5,
    },
  }),
  P = module788.withTheme(w);
exports.default = P;
