var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module788 = require('./788'),
  module760 = require('./760'),
  module924 = require('./924'),
  module967 = require('./967'),
  module968 = require('./968'),
  module787 = require('./787'),
  P = '/Users/trensik/dev/react-native-paper/src/components/ToggleButton/ToggleButton.tsx',
  T = (function (t) {
    function n() {
      module27.default(this, n);
      return module40.default(this, module37.default(n).apply(this, arguments));
    }

    module38.default(n, t);
    module28.default(n, [
      {
        key: 'render',
        value: function () {
          var t = this.props,
            n = t.icon,
            s = t.size,
            o = t.theme,
            c = t.accessibilityLabel,
            f = t.disabled,
            b = t.style,
            h = t.value,
            v = t.status,
            y = t.onPress,
            w = module56.default(t, ['icon', 'size', 'theme', 'accessibilityLabel', 'disabled', 'style', 'value', 'status', 'onPress']),
            T = o.roundness;
          return React.createElement(
            module967.ToggleButtonGroupContext.Consumer,
            {
              __source: {
                fileName: P,
                lineNumber: 121,
              },
            },
            function (t) {
              var module56,
                C = (t && t.value === h) || 'checked' === v;
              module56 = C ? (o.dark ? 'rgba(255, 255, 255, .12)' : 'rgba(0, 0, 0, .08)') : 'transparent';
              return React.createElement(
                module924.default,
                module14.default(
                  {
                    borderless: false,
                    icon: n,
                    onPress: function (n) {
                      if (y) y(n);
                      if (t) t.onValueChange(C ? null : h);
                    },
                    size: s,
                    accessibilityLabel: c,
                    disabled: f,
                    style: [
                      z.content,
                      {
                        backgroundColor: module56,
                        borderRadius: T,
                        borderColor: module760
                          .default(o.dark ? module787.white : module787.black)
                          .alpha(0.29)
                          .rgb()
                          .string(),
                      },
                      b,
                    ],
                  },
                  w,
                  {
                    __source: {
                      fileName: P,
                      lineNumber: 137,
                    },
                  }
                )
              );
            }
          );
        },
      },
    ]);
    return n;
  })(React.Component);

module50.default(T, 'Group', module967.default);
module50.default(T, 'Row', module968.default);
var z = ReactNative.StyleSheet.create({
    content: {
      width: 42,
      height: 42,
      margin: 0,
    },
  }),
  B = module788.withTheme(T);
exports.default = B;
