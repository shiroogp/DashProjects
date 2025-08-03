var module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = p(n);
    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      l = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var f in t)
      if ('default' !== f && Object.prototype.hasOwnProperty.call(t, f)) {
        var c = l ? Object.getOwnPropertyDescriptor(t, f) : null;
        if (c && (c.get || c.set)) Object.defineProperty(u, f, c);
        else u[f] = t[f];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  PropTypes = require('prop-types'),
  ReactNative = require('react-native');

function p(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (p = function (t) {
    return t ? o : n;
  })(t);
}

function h(t) {
  var n = b();
  return function () {
    var o,
      u = module37.default(t);

    if (n) {
      var c = module37.default(this).constructor;
      o = Reflect.construct(u, arguments, c);
    } else o = u.apply(this, arguments);

    return module40.default(this, o);
  };
}

function b() {
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

var k = (exports.HideWithKeyboard = (function (t) {
  module38.default(f, t);
  var l = h(f);

  function f(t) {
    var o;
    module27.default(this, f);
    (o = l.call(this, t)).state = {
      keyboardUp: false,
    };
    return o;
  }

  module28.default(f, [
    {
      key: 'componentDidMount',
      value: function () {
        this._keyboardDidShowListener = ReactNative.Keyboard.addListener(
          'android' === ReactNative.Platform.OS ? 'keyboardDidShow' : 'keyboardWillShow',
          this.keyboardDidShow.bind(this)
        );
        this._keyboardDidHideListener = ReactNative.Keyboard.addListener(
          'android' === ReactNative.Platform.OS ? 'keyboardDidHide' : 'keyboardWillHide',
          this.keyboardDidHide.bind(this)
        );
      },
    },
    {
      key: 'componentWillUnmount',
      value: function () {
        this._keyboardDidShowListener.remove();

        this._keyboardDidHideListener.remove();
      },
    },
    {
      key: 'keyboardDidShow',
      value: function () {
        this.setState({
          keyboardUp: true,
        });
      },
    },
    {
      key: 'keyboardDidHide',
      value: function () {
        this.setState({
          keyboardUp: false,
        });
      },
    },
    {
      key: 'render',
      value: function () {
        return this.state.keyboardUp ? React.default.createElement(ReactNative.View, null) : React.default.createElement(ReactNative.View, this.props, this.props.children);
      },
    },
  ]);
  return f;
})(React.Component));

k.propTypes = {
  children: PropTypes.default.oneOfType([PropTypes.default.array, PropTypes.default.object]),
};

exports.ShowWithKeyboard = (function (t) {
  module38.default(f, t);
  var l = h(f);

  function f() {
    module27.default(this, f);
    return l.apply(this, arguments);
  }

  module28.default(f, [
    {
      key: 'render',
      value: function () {
        return this.state.keyboardUp ? React.default.createElement(ReactNative.View, this.props, this.props.children) : React.default.createElement(ReactNative.View, null);
      },
    },
  ]);
  return f;
})(k);

exports.default = k;
