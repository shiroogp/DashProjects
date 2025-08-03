var n,
  module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  React = require('react'),
  ReactNative = require('react-native'),
  f = '/Users/trensik/dev/react-native-paper/src/components/MaterialCommunityIcon.tsx';

try {
  n = require('./799').default;
} catch (o) {
  if (globals.__expo && globals.__expo.Icon && globals.__expo.Icon.MaterialCommunityIcons) n = globals.__expo.Icon.MaterialCommunityIcons;
  else {
    var p = false;

    n = function (t) {
      var n = t.name,
        v = t.color,
        y = t.size,
        b = module56.default(t, ['name', 'color', 'size']);

      if (!p) {
        if (!/(Cannot find module|Module not found|Cannot resolve module)/.test(o.message)) console.error(o);
        console.warn(
          "Tried to use the icon '".concat(n, "' in a component from 'react-native-paper', but 'react-native-vector-icons' could not be loaded."),
          "To remove this warning, try installing 'react-native-vector-icons' or use another method to specify icon: https://callstack.github.io/react-native-paper/icons.html."
        );
        p = true;
      }

      return <ReactNative.Text>□</ReactNative.Text>;
    };
  }
}

var v =
  'web' === ReactNative.Platform.OS
    ? {
        role: 'img',
        focusable: false,
      }
    : {
        accessibilityElementsHidden: true,
        importantForAccessibility: 'no-hide-descendants',
      };
exports.accessibilityProps = v;

var _ = ReactNative.StyleSheet.create({
    icon: {
      backgroundColor: 'transparent',
    },
  }),
  y = function (o) {
    var t = o.name,
      l = o.color,
      u = o.size,
      p = o.direction,
      y = o.allowFontScaling;
    return <n />;
  };

exports.default = y;
