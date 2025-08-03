var module50 = require('./50'),
  module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  React = S(require('react')),
  h = React,
  module639 = S(require('./639')),
  ReactNative = require('react-native'),
  P = ['style'];

function b(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (b = function (t) {
    return t ? o : n;
  })(t);
}

function S(t, n) {
  if (!n && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var o = b(n);
  if (o && o.has(t)) return o.get(t);
  var l = {
      __proto__: null,
    },
    u = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var s in t)
    if ('default' !== s && Object.prototype.hasOwnProperty.call(t, s)) {
      var c = u ? Object.getOwnPropertyDescriptor(t, s) : null;
      if (c && (c.get || c.set)) Object.defineProperty(l, s, c);
      else l[s] = t[s];
    }

  l.default = t;
  if (o) o.set(t, l);
  return l;
}

function j(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var l = Object.getOwnPropertySymbols(t);
    if (n)
      l = l.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, l);
  }

  return o;
}

function C(t) {
  for (var o = 1; o < arguments.length; o++) {
    var l = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      j(Object(l), true).forEach(function (o) {
        module50.default(t, o, l[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(l));
    else
      j(Object(l)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(l, n));
      });
  }

  return t;
}

function E() {
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

(exports.default = (function (t) {
  module38.default(S, t);

  var module50 = S,
    React = E(),
    b = function () {
      var t,
        o = module37.default(module50);

      if (React) {
        var l = module37.default(this).constructor;
        t = Reflect.construct(o, arguments, l);
      } else t = o.apply(this, arguments);

      return module40.default(this, t);
    };

  function S(t) {
    var n;
    module27.default(this, S);

    (n = b.call(this, t)).showUnderlay = function () {
      if (n.hasPressHandler()) {
        n.setState({
          extraChildStyle: {
            opacity: n.props.activeOpacity,
          },
          extraUnderlayStyle: {
            backgroundColor: n.props.underlayColor,
          },
        });
        if (!(null == n.props.onShowUnderlay)) n.props.onShowUnderlay();
      }
    };

    n.hasPressHandler = function () {
      return n.props.onPress || n.props.onPressIn || n.props.onPressOut || n.props.onLongPress;
    };

    n.hideUnderlay = function () {
      n.setState({
        extraChildStyle: null,
        extraUnderlayStyle: null,
      });
      if (!(null == n.props.onHideUnderlay)) n.props.onHideUnderlay();
    };

    n.onStateChange = function (t, o) {
      if (o === module639.TOUCHABLE_STATE.BEGAN) n.showUnderlay();
      else if (!(o !== module639.TOUCHABLE_STATE.UNDETERMINED && o !== module639.TOUCHABLE_STATE.MOVED_OUTSIDE)) n.hideUnderlay();
    };

    n.state = {
      extraChildStyle: null,
      extraUnderlayStyle: null,
    };
    return n;
  }

  module28.default(S, [
    {
      key: 'renderChildren',
      value: function () {
        if (!this.props.children) return h.createElement(ReactNative.View, null);
        var t = h.Children.only(this.props.children);
        return h.cloneElement(t, {
          style: ReactNative.StyleSheet.compose(t.props.style, this.state.extraChildStyle),
        });
      },
    },
    {
      key: 'render',
      value: function () {
        var t = this.props,
          n = t.style,
          u = undefined === n ? {} : n,
          s = module56.default(t, P),
          c = this.state.extraUnderlayStyle;
        return h.createElement(
          module639.default,
          module14.default({}, s, {
            style: [u, c],
            onStateChange: this.onStateChange,
          }),
          this.renderChildren()
        );
      },
    },
  ]);
  return S;
})(React.Component)).defaultProps = C(
  C({}, module639.default.defaultProps),
  {},
  {
    activeOpacity: 0.85,
    delayPressOut: 100,
    underlayColor: 'black',
  }
);
