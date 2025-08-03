var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module914 = require('./914'),
  module788 = require('./788'),
  D = (function (t) {
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
            s = t.theme,
            u = t.style,
            c = module56.default(t, ['children', 'theme', 'style']);
          return <module914.default>{l}</module914.default>;
        },
      },
    ]);
    return l;
  })(React.Component);

exports.DialogTitle = D;
module50.default(D, 'displayName', 'Dialog.Title');
var b = ReactNative.StyleSheet.create({
    text: {
      marginTop: 22,
      marginBottom: 18,
      marginHorizontal: 24,
    },
  }),
  x = module788.withTheme(D);
exports.default = x;
