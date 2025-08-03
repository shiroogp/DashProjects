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
  module787 = require('./787'),
  module788 = require('./788'),
  _ = (function (t) {
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
            u = t.style,
            h = t.theme,
            f = module56.default(t, ['children', 'style', 'theme']),
            s = module760
              .default(h.dark ? module787.white : module787.black)
              .alpha(0.12)
              .rgb()
              .string();
          return <ReactNative.View>{l}</ReactNative.View>;
        },
      },
    ]);
    return l;
  })(React.Component);

exports.DataTableHeader = _;
module50.default(_, 'displayName', 'DataTable.Header');
var H = ReactNative.StyleSheet.create({
    header: {
      flexDirection: 'row',
      height: 48,
      paddingHorizontal: 16,
      borderBottomWidth: 2 * ReactNative.StyleSheet.hairlineWidth,
    },
  }),
  k = module788.withTheme(_);
exports.default = k;
