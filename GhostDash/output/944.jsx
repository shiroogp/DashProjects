var module14 = require('./14'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module945 = require('./945'),
  module946 = require('./946'),
  module948 = require('./948'),
  module949 = require('./949'),
  module788 = require('./788'),
  I = (function (t) {
    function u() {
      module27.default(this, u);
      return module40.default(this, module37.default(u).apply(this, arguments));
    }

    module38.default(u, t);
    module28.default(u, [
      {
        key: 'render',
        value: function () {
          var t = ReactNative.Platform.select({
            default: module946.default,
            ios: module948.default,
          });
          return <t />;
        },
      },
    ]);
    return u;
  })(React.Component);

module50.default(I, 'Group', module945.default);
module50.default(I, 'Android', module946.default);
module50.default(I, 'IOS', module948.default);
module50.default(I, 'Item', module949.default);
var N = module788.withTheme(I);
exports.default = N;
