var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  module760 = require('./760'),
  ReactNative = require('react-native'),
  module888 = require('./888'),
  module787 = require('./787'),
  module788 = require('./788'),
  T = '/Users/trensik/dev/react-native-paper/src/components/DataTable/DataTableRow.tsx',
  N = (function (t) {
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
            l = t.onPress,
            s = t.style,
            u = t.theme,
            f = module56.default(t, ['onPress', 'style', 'theme']),
            c = module760
              .default(u.dark ? module787.white : module787.black)
              .alpha(0.12)
              .rgb()
              .string();
          return (
            <module888.default>
              <ReactNative.View
                style={S.content}
                __source={{
                  fileName: T,
                  lineNumber: 41,
                }}
              >
                {this.props.children}
              </ReactNative.View>
            </module888.default>
          );
        },
      },
    ]);
    return l;
  })(React.Component);

exports.DataTableRow = N;
module50.default(N, 'displayName', 'DataTable.Row');
var S = ReactNative.StyleSheet.create({
    container: {
      borderStyle: 'solid',
      borderBottomWidth: ReactNative.StyleSheet.hairlineWidth,
      minHeight: 48,
      paddingHorizontal: 16,
    },
    content: {
      flex: 1,
      flexDirection: 'row',
    },
  }),
  k = module788.withTheme(N);
exports.default = k;
