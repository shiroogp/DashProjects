var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  React = require('react'),
  ReactNative = require('react-native'),
  module878 = require('./878'),
  module788 = require('./788'),
  module879 = require('./879'),
  b = (function (t) {
    function u() {
      module27.default(this, u);
      return module40.default(this, module37.default(u).apply(this, arguments));
    }

    module38.default(u, t);
    module28.default(u, [
      {
        key: 'render',
        value: function () {
          var t = this.props,
            u = t.style,
            f = t.theme,
            o = module56.default(t, ['style', 'theme']),
            s = (ReactNative.StyleSheet.flatten(u) || {}).elevation,
            c = undefined === s ? 4 : s,
            v = f.dark,
            _ = f.mode,
            b = f.colors;
          return React.createElement(
            ReactNative.Animated.View,
            module14.default({}, o, {
              style: [
                {
                  backgroundColor: v && 'adaptive' === _ ? module879.default(c, b.surface) : b.surface,
                },
                c && module878.default(c),
                u,
              ],
              __source: {
                fileName: '/Users/trensik/dev/react-native-paper/src/components/Surface.tsx',
                lineNumber: 70,
              },
            })
          );
        },
      },
    ]);
    return u;
  })(React.Component),
  S = module788.withTheme(b);

exports.default = S;
