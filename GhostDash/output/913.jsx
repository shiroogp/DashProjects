var module14 = require('./14'),
  module50 = require('./50'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module760 = require('./760'),
  React = require('react'),
  ReactNative = require('react-native'),
  module885 = require('./885'),
  module788 = require('./788');

function P(t, n) {
  var l = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var o = Object.getOwnPropertySymbols(t);
    if (n)
      o = o.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    l.push.apply(l, o);
  }

  return l;
}

function w(t) {
  for (var n = 1; n < arguments.length; n++) {
    var l = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      P(Object(l), true).forEach(function (n) {
        module50.default(t, n, l[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(l));
    else
      P(Object(l)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(l, n));
      });
  }

  return t;
}

var _ = (function (t) {
    function n() {
      module27.default(this, n);
      return module40.default(this, module37.default(n).apply(this, arguments));
    }

    module38.default(n, t);
    module28.default(n, [
      {
        key: 'render',
        value: function () {
          var t = this.props,
            n = t.theme,
            o = t.alpha,
            u = t.family,
            f = t.style,
            s = module56.default(t, ['theme', 'alpha', 'family', 'style']),
            p = module760.default(n.colors.text).alpha(o).rgb().string(),
            y = n.fonts[u],
            j = ReactNative.I18nManager.isRTL ? 'rtl' : 'ltr';
          return <module885.default />;
        },
      },
    ]);
    return n;
  })(React.Component),
  D = module788.withTheme(_);

exports.default = D;
