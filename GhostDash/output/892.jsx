var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module893 = require('./893'),
  module788 = require('./788'),
  N = '/Users/trensik/dev/react-native-paper/src/components/List/ListSection.tsx',
  b = (function (t) {
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
            l = t.children,
            s = t.title,
            c = t.titleStyle,
            f = t.style,
            o = module56.default(t, ['children', 'title', 'titleStyle', 'style']);
          return (
            <ReactNative.View>
              {s && (
                <module893.default
                  style={c}
                  __source={{
                    fileName: N,
                    lineNumber: 74,
                  }}
                >
                  {s}
                </module893.default>
              )}
              {l}
            </ReactNative.View>
          );
        },
      },
    ]);
    return l;
  })(React.Component);

module50.default(b, 'displayName', 'List.Section');
var L = ReactNative.StyleSheet.create({
    container: {
      marginVertical: 8,
    },
  }),
  k = module788.withTheme(b);
exports.default = k;
