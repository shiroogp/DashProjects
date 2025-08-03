var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  React = require('react'),
  module760 = require('./760'),
  ReactNative = require('react-native'),
  module788 = require('./788'),
  module787 = require('./787'),
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
          var t = this.props,
            l = t.inset,
            h = t.style,
            s = t.theme,
            o = module56.default(t, ['inset', 'style', 'theme']),
            f = s.dark;
          return <ReactNative.View />;
        },
      },
    ]);
    return l;
  })(React.Component),
  _ = ReactNative.StyleSheet.create({
    light: {
      backgroundColor: module760.default(module787.black).alpha(0.12).rgb().string(),
      height: ReactNative.StyleSheet.hairlineWidth,
    },
    dark: {
      backgroundColor: module760.default(module787.white).alpha(0.12).rgb().string(),
      height: ReactNative.StyleSheet.hairlineWidth,
    },
    inset: {
      marginLeft: 72,
    },
  }),
  w = module788.withTheme(S);

exports.default = w;
