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
  module798 = require('./798'),
  module888 = require('./888'),
  module788 = require('./788'),
  C = '/Users/trensik/dev/react-native-paper/src/components/CheckboxIOS.tsx',
  N = (function (t) {
    function s() {
      module27.default(this, s);
      return module40.default(this, module37.default(s).apply(this, arguments));
    }

    module38.default(s, t);
    module28.default(s, [
      {
        key: 'render',
        value: function () {
          var t,
            s = this.props,
            o = s.status,
            c = s.disabled,
            u = s.onPress,
            b = s.theme,
            f = module56.default(s, ['status', 'disabled', 'onPress', 'theme']),
            p = 'checked' === o,
            S = 'indeterminate' === o,
            N = c ? b.colors.disabled : this.props.color || b.colors.accent;
          t = c ? module760.default(b.colors.text).alpha(0.16).rgb().string() : module760.default(N).fade(0.32).rgb().string();
          var I = S ? 'minus' : 'check';
          return (
            <module888.default>
              <ReactNative.View
                style={{
                  opacity: S || p ? 1 : 0,
                }}
                __source={{
                  fileName: C,
                  lineNumber: 89,
                }}
              >
                <module798.default
                  allowFontScaling={false}
                  name={I}
                  size={24}
                  color={N}
                  direction={ReactNative.I18nManager.isRTL ? 'rtl' : 'ltr'}
                  __source={{
                    fileName: C,
                    lineNumber: 90,
                  }}
                />
              </ReactNative.View>
            </module888.default>
          );
        },
      },
    ]);
    return s;
  })(React.Component);

exports.CheckboxIOS = N;
module50.default(N, 'displayName', 'Checkbox.IOS');
var x = ReactNative.StyleSheet.create({
    container: {
      borderRadius: 18,
      padding: 6,
    },
  }),
  I = module788.withTheme(N);
exports.default = I;
