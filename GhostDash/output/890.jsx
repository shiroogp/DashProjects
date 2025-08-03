var module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module882 = require('./882'),
  y = '/Users/trensik/dev/react-native-paper/src/components/List/ListIcon.tsx',
  _ = (function (t) {
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
            l = t.color,
            o = t.style;
          return (
            <ReactNative.View
              style={[N.item, o]}
              pointerEvents="box-none"
              __source={{
                fileName: y,
                lineNumber: 39,
              }}
            >
              <module882.default
                source={n}
                size={24}
                color={l}
                __source={{
                  fileName: y,
                  lineNumber: 40,
                }}
              />
            </ReactNative.View>
          );
        },
      },
    ]);
    return n;
  })(React.Component);

exports.default = _;
module50.default(_, 'displayName', 'List.Icon');
var N = ReactNative.StyleSheet.create({
  item: {
    margin: 8,
    height: 40,
    width: 40,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
