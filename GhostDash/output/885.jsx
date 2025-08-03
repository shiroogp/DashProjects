var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module42 = require('./42'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module788 = require('./788');

function j(t, o) {
  var n = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var u = Object.getOwnPropertySymbols(t);
    if (o)
      u = u.filter(function (o) {
        return Object.getOwnPropertyDescriptor(t, o).enumerable;
      });
    n.push.apply(n, u);
  }

  return n;
}

function P(t) {
  for (var o = 1; o < arguments.length; o++) {
    var n = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      j(Object(n), true).forEach(function (o) {
        module50.default(t, o, n[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(n));
    else
      j(Object(n)).forEach(function (o) {
        Object.defineProperty(t, o, Object.getOwnPropertyDescriptor(n, o));
      });
  }

  return t;
}

var w = (function (t, ...args) {
    function o() {
      var t, module14;
      module27.default(this, o);
      module14 = module40.default(this, (t = module37.default(o)).call.apply(t, [this].concat(args)));
      module50.default(module42.default(module14), 'root', undefined);
      return module14;
    }

    module38.default(o, t);
    module28.default(o, [
      {
        key: 'setNativeProps',
        value: function (t) {
          return this.root && this.root.setNativeProps(t);
        },
      },
      {
        key: 'render',
        value: function () {
          var t = this,
            o = this.props,
            c = o.style,
            l = o.theme,
            f = module56.default(o, ['style', 'theme']);
          return <ReactNative.Text />;
        },
      },
    ]);
    return o;
  })(React.Component),
  _ = module788.withTheme(w);

exports.default = _;
