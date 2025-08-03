var module14 = require('./14'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module916 = require('./916'),
  module917 = require('./917'),
  module788 = require('./788'),
  k = '/Users/trensik/dev/react-native-paper/src/components/Checkbox.tsx',
  y = (function (t) {
    function u() {
      module27.default(this, u);
      return module40.default(this, module37.default(u).apply(this, arguments));
    }

    module38.default(u, t);
    module28.default(u, [
      {
        key: 'render',
        value: function () {
          return 'ios' === ReactNative.Platform.OS ? <module917.default /> : <module916.default />;
        },
      },
    ]);
    return u;
  })(React.Component);

module50.default(y, 'Android', module916.default);
module50.default(y, 'IOS', module917.default);
var O = module788.withTheme(y);
exports.default = O;
