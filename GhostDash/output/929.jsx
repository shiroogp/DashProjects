var module14 = require('./14'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  y = (function (t) {
    function n() {
      module27.default(this, n);
      return module40.default(this, module37.default(n).apply(this, arguments));
    }

    module38.default(n, t);
    module28.default(n, [
      {
        key: 'render',
        value: function () {
          return <ReactNative.View>{this.props.children}</ReactNative.View>;
        },
      },
    ]);
    return n;
  })(React.Component);

module50.default(y, 'displayName', 'Dialog.Content');

var _ = ReactNative.StyleSheet.create({
    container: {
      paddingBottom: 24,
      paddingHorizontal: 24,
    },
  }),
  C = y;

exports.default = C;
