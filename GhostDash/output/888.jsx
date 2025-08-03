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
  module788 = require('./788'),
  k = '/Users/trensik/dev/react-native-paper/src/components/TouchableRipple/index.native.tsx',
  C = (function (l) {
    function t() {
      module27.default(this, t);
      return module40.default(this, module37.default(t).apply(this, arguments));
    }

    module38.default(t, l);
    module28.default(t, [
      {
        key: 'render',
        value: function () {
          var l = this.props,
            u = l.style,
            s = l.background,
            f = l.borderless,
            c = l.disabled,
            p = l.rippleColor,
            b = l.underlayColor,
            _ = l.children,
            C = l.theme,
            N = module56.default(l, ['style', 'background', 'borderless', 'disabled', 'rippleColor', 'underlayColor', 'children', 'theme']),
            P = C.dark,
            T = C.colors,
            w = c || !this.props.onPress,
            x =
              p ||
              module760
                .default(T.text)
                .alpha(P ? 0.32 : 0.2)
                .rgb()
                .string(),
            E = 'android' === ReactNative.Platform.OS && ReactNative.Platform.Version >= 28 && f;
          return t.supported ? (
            <ReactNative.TouchableNativeFeedback>
              <ReactNative.View
                style={[
                  f && {
                    overflow: 'hidden',
                  },
                  u,
                ]}
                __source={{
                  fileName: k,
                  lineNumber: 83,
                }}
              >
                <_ />
              </ReactNative.View>
            </ReactNative.TouchableNativeFeedback>
          ) : (
            <ReactNative.TouchableHighlight>
              <_ />
            </ReactNative.TouchableHighlight>
          );
        },
      },
    ]);
    return t;
  })(React.Component);

module50.default(C, 'defaultProps', {
  borderless: false,
});
module50.default(C, 'supported', 'android' === ReactNative.Platform.OS && ReactNative.Platform.Version >= 21);
var N = module788.withTheme(C);
exports.default = N;
