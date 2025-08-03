var module14 = require('./14'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module955 = require('./955'),
  module798 = require('./798'),
  y = '/Users/trensik/dev/react-native-paper/src/components/Appbar/AppbarBackAction.tsx',
  module957 = (function (t) {
    function n() {
      module27.default(this, n);
      return module40.default(this, module37.default(n).apply(this, arguments));
    }

    module38.default(n, t);
    module28.default(n, [
      {
        key: 'render',
        value: function () {
          return <module955.default />;
        },
      },
    ]);
    return n;
  })(React.Component);

module50.default(module957, 'displayName', 'Appbar.BackAction');
module50.default(module957, 'defaultProps', {
  accessibilityLabel: 'Back',
});
var w = ReactNative.StyleSheet.create({
    wrapper: {
      alignItems: 'center',
      justifyContent: 'center',
    },
    icon: {
      height: 21,
      width: 21,
      resizeMode: 'contain',
    },
  }),
  k = module957;
exports.default = k;
