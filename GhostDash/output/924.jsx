var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  React = require('react'),
  ReactNative = require('react-native'),
  module760 = require('./760'),
  module888 = require('./888'),
  module882 = require('./882'),
  module925 = require('./925'),
  module788 = require('./788'),
  h = '/Users/trensik/dev/react-native-paper/src/components/IconButton.tsx',
  v = ReactNative.StyleSheet.create({
    container: {
      alignItems: 'center',
      justifyContent: 'center',
      overflow: 'hidden',
      margin: 6,
    },
    disabled: {
      opacity: 0.32,
    },
  }),
  _ = module788.withTheme(function (t) {
    var l = t.icon,
      y = t.color,
      _ = t.size,
      N = undefined === _ ? 24 : _,
      w = t.accessibilityLabel,
      P = t.disabled,
      S = t.onPress,
      z = t.animated,
      C = undefined !== z && z,
      E = t.theme,
      L = t.style,
      T = module56.default(t, ['icon', 'color', 'size', 'accessibilityLabel', 'disabled', 'onPress', 'animated', 'theme', 'style']),
      j = undefined !== y ? y : E.colors.text,
      x = module760.default(j).alpha(0.32).rgb().string(),
      I = C ? module925.default : module882.default,
      R = 1.5 * N;
    return (
      <module888.default>
        <ReactNative.View
          __source={{
            fileName: h,
            lineNumber: 132,
          }}
        >
          <I
            color={j}
            source={l}
            size={N}
            __source={{
              fileName: h,
              lineNumber: 133,
            }}
          />
        </ReactNative.View>
      </module888.default>
    );
  });

exports.default = _;
