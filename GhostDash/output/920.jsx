var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module885 = require('./885'),
  module888 = require('./888'),
  N = '/Users/trensik/dev/react-native-paper/src/components/DataTable/DataTableCell.tsx',
  x = (function (t) {
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
            f = t.style,
            c = t.numeric,
            s = module56.default(t, ['children', 'style', 'numeric']);
          return (
            <module888.default>
              <module885.default
                numberOfLines={1}
                __source={{
                  fileName: N,
                  lineNumber: 34,
                }}
              >
                {l}
              </module885.default>
            </module888.default>
          );
        },
      },
    ]);
    return l;
  })(React.Component);

module50.default(x, 'displayName', 'DataTable.Cell');
var C = ReactNative.StyleSheet.create({
    container: {
      flex: 1,
      flexDirection: 'row',
      alignItems: 'center',
    },
    right: {
      justifyContent: 'flex-end',
    },
  }),
  D = x;
exports.default = D;
