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
    var o = s(n);
    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      l = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var c in t)
      if ('default' !== c && Object.prototype.hasOwnProperty.call(t, c)) {
        var f = l ? Object.getOwnPropertyDescriptor(t, c) : null;
        if (f && (f.get || f.set)) Object.defineProperty(u, c, f);
        else u[c] = t[c];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  ReactNative = require('react-native');

function s(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (s = function (t) {
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

exports.default = (function (t, ...args) {
  module38.default(T, t);

  var React = T,
    s = y(),
    h = function () {
      var t,
        n = module37.default(React);

      if (s) {
        var o = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, o);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function T() {
    var t;
    module27.default(this, T);
    (t = h.call(this, ...args)).previouslyFocusedTextInput = null;
    t.startTimestamp = 0;

    t.clearKeyboardTimeout = function () {
      if (undefined !== t.keyboardTimeout) {
        clearTimeout(t.keyboardTimeout);
        t.keyboardTimeout = undefined;
      }
    };

    t.handlePageChangeStart = function () {
      if (t.props.enabled) {
        t.clearKeyboardTimeout();
        var n = ReactNative.TextInput.State.currentlyFocusedField();
        ReactNative.TextInput.State.blurTextInput(n);
        t.previouslyFocusedTextInput = n;
        t.startTimestamp = Date.now();
      }
    };

    t.handlePageChangeConfirm = function () {
      if (t.props.enabled) {
        t.clearKeyboardTimeout();
        var n = t.previouslyFocusedTextInput;
        if ('android' === ReactNative.Platform.OS) ReactNative.Keyboard.dismiss();
        else if (n) ReactNative.TextInput.State.blurTextInput(n);
        t.previouslyFocusedTextInput = null;
      }
    };

    t.handlePageChangeCancel = function () {
      if (t.props.enabled) {
        t.clearKeyboardTimeout();
        var n = t.previouslyFocusedTextInput;
        if (n)
          Date.now() - t.startTimestamp < 100
            ? (t.keyboardTimeout = setTimeout(function () {
                ReactNative.TextInput.State.focusTextInput(n);
                t.previouslyFocusedTextInput = null;
              }, 100))
            : (ReactNative.TextInput.State.focusTextInput(n), (t.previouslyFocusedTextInput = null));
      }
    };

    return t;
  }

  module28.default(T, [
    {
      key: 'componentWillUnmount',
      value: function () {
        this.clearKeyboardTimeout();
      },
    },
    {
      key: 'render',
      value: function () {
        return this.props.children({
          onPageChangeStart: this.handlePageChangeStart,
          onPageChangeConfirm: this.handlePageChangeConfirm,
          onPageChangeCancel: this.handlePageChangeCancel,
        });
      },
    },
  ]);
  return T;
})(React.Component);
