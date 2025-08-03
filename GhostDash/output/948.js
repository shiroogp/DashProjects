var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module760 = require('./760'),
  module945 = require('./945'),
  module947 = require('./947'),
  module798 = require('./798'),
  module888 = require('./888'),
  module788 = require('./788'),
  k = '/Users/trensik/dev/react-native-paper/src/components/RadioButton/RadioButtonIOS.tsx',
  B = (function (t) {
    function o() {
      module27.default(this, o);
      return module40.default(this, module37.default(o).apply(this, arguments));
    }

    module38.default(o, t);
    module28.default(o, [
      {
        key: 'render',
        value: function () {
          var t,
            o = this.props,
            s = o.disabled,
            u = o.onPress,
            c = o.theme,
            f = o.status,
            b = o.value,
            v = module56.default(o, ['disabled', 'onPress', 'theme', 'status', 'value']),
            S = s ? c.colors.disabled : this.props.color || c.colors.accent;
          t = s ? module760.default(c.colors.text).alpha(0.16).rgb().string() : module760.default(S).fade(0.32).rgb().string();
          return React.createElement(
            module945.RadioButtonContext.Consumer,
            {
              __source: {
                fileName: k,
                lineNumber: 78,
              },
            },
            function (o) {
              var l =
                'checked' ===
                module947.isChecked({
                  contextValue: null === o || undefined === o ? undefined : o.value,
                  status: f,
                  value: b,
                });
              return React.createElement(
                module888.default,
                module14.default({}, v, {
                  borderless: true,
                  rippleColor: t,
                  onPress: s
                    ? undefined
                    : function () {
                        module947.handlePress({
                          onPress: u,
                          value: b,
                          onValueChange: null === o || undefined === o ? undefined : o.onValueChange,
                        });
                      },
                  accessibilityTraits: s ? ['button', 'disabled'] : 'button',
                  accessibilityComponentType: l ? 'radiobutton_checked' : 'radiobutton_unchecked',
                  accessibilityRole: 'button',
                  accessibilityStates: s ? ['disabled'] : [],
                  accessibilityLiveRegion: 'polite',
                  style: P.container,
                  __source: {
                    fileName: k,
                    lineNumber: 88,
                  },
                }),
                React.createElement(
                  ReactNative.View,
                  {
                    style: {
                      opacity: l ? 1 : 0,
                    },
                    __source: {
                      fileName: k,
                      lineNumber: 112,
                    },
                  },
                  React.createElement(module798.default, {
                    allowFontScaling: false,
                    name: 'check',
                    size: 24,
                    color: S,
                    direction: ReactNative.I18nManager.isRTL ? 'rtl' : 'ltr',
                    __source: {
                      fileName: k,
                      lineNumber: 113,
                    },
                  })
                )
              );
            }
          );
        },
      },
    ]);
    return o;
  })(React.Component);

exports.RadioButtonIOS = B;
module50.default(B, 'displayName', 'RadioButton.IOS');
var P = ReactNative.StyleSheet.create({
    container: {
      borderRadius: 18,
      padding: 6,
    },
  }),
  I = module788.withTheme(B);
exports.default = I;
