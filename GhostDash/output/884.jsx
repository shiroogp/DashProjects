var module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module760 = require('./760'),
  module885 = require('./885'),
  module788 = require('./788'),
  module787 = require('./787'),
  S = '/Users/trensik/dev/react-native-paper/src/components/Avatar/AvatarText.tsx',
  k = (function (t) {
    function l() {
      module27.default(this, l);
      return module40.default(this, module37.default(l).apply(this, arguments));
    }

    module38.default(l, t);
    module28.default(l, [
      {
        key: 'render',
        value: function () {
          var t = this.props,
            l = t.label,
            o = t.size,
            u = undefined === o ? 64 : o,
            s = t.style,
            c = t.theme,
            f = t.labelStyle,
            h = ReactNative.StyleSheet.flatten(s) || {},
            _ = h.backgroundColor,
            k = undefined === _ ? c.colors.primary : _,
            C = module56.default(h, ['backgroundColor']),
            N = this.props.color || (module760.default(k).isLight() ? 'rgba(0, 0, 0, .54)' : module787.white);
          return (
            <ReactNative.View
              style={[
                {
                  width: u,
                  height: u,
                  borderRadius: u / 2,
                  backgroundColor: k,
                },
                A.container,
                C,
              ]}
              __source={{
                fileName: S,
                lineNumber: 80,
              }}
            >
              <module885.default
                style={[
                  A.text,
                  {
                    color: N,
                    fontSize: u / 2,
                    lineHeight: u,
                  },
                  f,
                ]}
                numberOfLines={1}
                __source={{
                  fileName: S,
                  lineNumber: 92,
                }}
              >
                {l}
              </module885.default>
            </ReactNative.View>
          );
        },
      },
    ]);
    return l;
  })(React.Component);

module50.default(k, 'displayName', 'Avatar.Text');
module50.default(k, 'defaultProps', {
  size: 64,
});
var A = ReactNative.StyleSheet.create({
    container: {
      justifyContent: 'center',
      alignItems: 'center',
    },
    text: {
      textAlign: 'center',
      textAlignVertical: 'center',
    },
  }),
  C = module788.withTheme(k);
exports.default = C;
