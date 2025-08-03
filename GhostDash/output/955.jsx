var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  module760 = require('./760'),
  module787 = require('./787'),
  module924 = require('./924'),
  A = (function (t) {
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
            l = t.color,
            o = undefined === l ? module760.default(module787.black).alpha(0.54).rgb().string() : l,
            u = t.icon,
            c = t.disabled,
            f = t.onPress,
            p = t.accessibilityLabel,
            b = module56.default(t, ['color', 'icon', 'disabled', 'onPress', 'accessibilityLabel']);
          return <module924.default />;
        },
      },
    ]);
    return l;
  })(React.Component);

exports.default = A;
module50.default(A, 'displayName', 'Appbar.Action');
module50.default(A, 'defaultProps', {
  size: 24,
});
