var module14 = require('./14'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  S = (function (t) {
    function l() {
      module27.default(this, l);
      return module40.default(this, module37.default(l).apply(this, arguments));
    }

    module38.default(l, t);
    module28.default(l, [
      {
        key: 'render',
        value: function () {
          return <ReactNative.View>{this.props.children}</ReactNative.View>;
        },
      },
    ]);
    return l;
  })(React.Component);

module50.default(S, 'displayName', 'Dialog.ScrollArea');
var v = ReactNative.StyleSheet.create({
    container: {
      borderColor: 'rgba(0, 0, 0, .12)',
      borderTopWidth: ReactNative.StyleSheet.hairlineWidth,
      borderBottomWidth: ReactNative.StyleSheet.hairlineWidth,
      paddingHorizontal: 24,
      flexGrow: 1,
      flexShrink: 1,
    },
  }),
  b = S;
exports.default = b;
