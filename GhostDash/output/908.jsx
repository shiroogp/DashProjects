var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  C = (function (t) {
    function n() {
      module27.default(this, n);
      return module40.default(this, module37.default(n).apply(this, arguments));
    }

    module38.default(n, t);
    module28.default(n, [
      {
        key: 'render',
        value: function () {
          var t,
            n,
            s,
            u = this.props,
            f = u.index,
            p = u.total,
            c = u.siblings,
            y = u.style,
            C = module56.default(u, ['index', 'total', 'siblings', 'style']),
            _ = 'withTheme(CardCover)',
            T = 'withTheme(CardTitle)';

          if ('number' == typeof f && c) {
            n = c[f - 1];
            s = c[f + 1];
          }

          if ((n === _ && s === _) || (n === T && s === T) || 1 === p) t = b.only;
          else if (0 === f) t = s === _ || s === T ? b.only : b.first;
          else if ('number' == typeof p && f === p - 1) t = n === _ || n === T ? b.only : b.last;
          else if (n === _ || n === T) t = b.first;
          else if (!(s !== _ && s !== T)) t = b.last;
          return <ReactNative.View />;
        },
      },
    ]);
    return n;
  })(React.Component);

module50.default(C, 'displayName', 'Card.Content');
var b = ReactNative.StyleSheet.create({
    container: {
      paddingHorizontal: 16,
    },
    first: {
      paddingTop: 16,
    },
    last: {
      paddingBottom: 16,
    },
    only: {
      paddingVertical: 16,
    },
  }),
  _ = C;
exports.default = _;
