var module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module788 = require('./788'),
  y = '/Users/trensik/dev/react-native-paper/src/components/Avatar/AvatarImage.tsx',
  _ = (function (t) {
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
            u = t.size,
            l = undefined === u ? 64 : u,
            o = t.source,
            n = t.style,
            s = t.theme.colors,
            f = (ReactNative.StyleSheet.flatten(n) || {}).backgroundColor,
            c = undefined === f ? s.primary : f;
          return (
            <ReactNative.View
              style={[
                {
                  width: l,
                  height: l,
                  borderRadius: l / 2,
                  backgroundColor: c,
                },
                n,
              ]}
              __source={{
                fileName: y,
                lineNumber: 65,
              }}
            >
              <ReactNative.Image
                source={o}
                style={{
                  width: l,
                  height: l,
                  borderRadius: l / 2,
                }}
                __source={{
                  fileName: y,
                  lineNumber: 76,
                }}
              />
            </ReactNative.View>
          );
        },
      },
    ]);
    return u;
  })(React.Component);

module50.default(_, 'displayName', 'Avatar.Image');
module50.default(_, 'defaultProps', {
  size: 64,
});
var b = module788.withTheme(_);
exports.default = b;
