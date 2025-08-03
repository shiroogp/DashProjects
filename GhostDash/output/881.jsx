var module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module760 = require('./760'),
  module882 = require('./882'),
  module788 = require('./788'),
  module787 = require('./787'),
  C = '/Users/trensik/dev/react-native-paper/src/components/Avatar/AvatarIcon.tsx',
  N = (function (t) {
    function o() {
      module27.default(this, o);
      return module40.default(this, module37.default(o).apply(this, arguments));
    }

    module38.default(o, t);
    module28.default(o, [
      {
        key: 'render',
        value: function () {
          var t = this.props,
            o = t.icon,
            l = t.size,
            u = undefined === l ? 64 : l,
            s = t.style,
            c = t.theme,
            f = ReactNative.StyleSheet.flatten(s) || {},
            h = f.backgroundColor,
            _ = undefined === h ? c.colors.primary : h,
            N = module56.default(f, ['backgroundColor']),
            S = this.props.color || (module760.default(_).isLight() ? 'rgba(0, 0, 0, .54)' : module787.white);

          return (
            <ReactNative.View
              style={[
                {
                  width: u,
                  height: u,
                  borderRadius: u / 2,
                  backgroundColor: _,
                },
                w.container,
                N,
              ]}
              __source={{
                fileName: C,
                lineNumber: 68,
              }}
            >
              <module882.default
                source={o}
                color={S}
                size={0.6 * u}
                __source={{
                  fileName: C,
                  lineNumber: 80,
                }}
              />
            </ReactNative.View>
          );
        },
      },
    ]);
    return o;
  })(React.Component);

module50.default(N, 'displayName', 'Avatar.Icon');
module50.default(N, 'defaultProps', {
  size: 64,
});
var w = ReactNative.StyleSheet.create({
    container: {
      justifyContent: 'center',
      alignItems: 'center',
    },
  }),
  S = module788.withTheme(N);
exports.default = S;
