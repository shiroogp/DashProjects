exports.default = function (t) {
  var h = (function (v) {
    module38.default(D, v);

    var h = D,
      w = y(),
      _ = function () {
        var t,
          n = module37.default(h);

        if (w) {
          var o = module37.default(this).constructor;
          t = Reflect.construct(n, arguments, o);
        } else t = n.apply(this, arguments);

        return module40.default(this, t);
      };

    function D() {
      var t;
      module27.default(this, D);

      (t = _.call(this)).handleOrientationChange = function (n) {
        var o = n.window,
          u = O(o);
        t.setState({
          isLandscape: u,
        });
      };

      var n = O(ReactNative.Dimensions.get('window'));
      t.state = {
        isLandscape: n,
      };
      return t;
    }

    module28.default(D, [
      {
        key: 'componentDidMount',
        value: function () {
          if ('function' == typeof ReactNative.Dimensions.addEventListener) ReactNative.Dimensions.addEventListener('change', this.handleOrientationChange);
        },
      },
      {
        key: 'componentWillUnmount',
        value: function () {
          if ('function' == typeof ReactNative.Dimensions.removeEventListener) ReactNative.Dimensions.removeEventListener('change', this.handleOrientationChange);
        },
      },
      {
        key: 'render',
        value: function () {
          return <t />;
        },
      },
    ]);
    return D;
  })(React.Component);

  return module905.default(h, t);
};

var module14 = require('./14'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = h(n);
    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      f = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var c in t)
      if ('default' !== c && Object.prototype.hasOwnProperty.call(t, c)) {
        var s = f ? Object.getOwnPropertyDescriptor(t, c) : null;
        if (s && (s.get || s.set)) Object.defineProperty(u, c, s);
        else u[c] = t[c];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  ReactNative = require('react-native'),
  module905 = require('./905');

function h(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (h = function (t) {
    return t ? o : n;
  })(t);
}

function y() {
  if ('undefined' == typeof Reflect || !Reflect.construct) return false;
  if (Reflect.construct.sham) return false;
  if ('function' == typeof Proxy) return true;

  try {
    Boolean.prototype.valueOf.call(Reflect.construct(Boolean, [], function () {}));
    return true;
  } catch (t) {
    return false;
  }
}

var O = (exports.isOrientationLandscape = function (t) {
  return t.width > t.height;
});
