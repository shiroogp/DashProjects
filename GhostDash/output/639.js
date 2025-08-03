var module14 = require('./14'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  React = (function (t, s) {
    if (!s && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = v(s);
    if (o && o.has(t)) return o.get(t);
    var n = {
        __proto__: null,
      },
      l = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var u in t)
      if ('default' !== u && Object.prototype.hasOwnProperty.call(t, u)) {
        var p = l ? Object.getOwnPropertyDescriptor(t, u) : null;
        if (p && (p.get || p.set)) Object.defineProperty(n, u, p);
        else n[u] = t[u];
      }

    n.default = t;
    if (o) o.set(t, n);
    return n;
  })(require('react')),
  h = React,
  ReactNative = require('react-native'),
  module403 = require('./403'),
  module634 = require('./634');

function v(t) {
  if ('function' != typeof WeakMap) return null;
  var s = new WeakMap(),
    o = new WeakMap();
  return (v = function (t) {
    return t ? o : s;
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

var S = (exports.TOUCHABLE_STATE = {
  UNDETERMINED: 0,
  BEGAN: 1,
  MOVED_OUTSIDE: 2,
});
(exports.default = (function (t, ...args) {
  module38.default(O, t);

  var React = O,
    v = y(),
    D = function () {
      var t,
        s = module37.default(React);

      if (v) {
        var o = module37.default(this).constructor;
        t = Reflect.construct(s, arguments, o);
      } else t = s.apply(this, arguments);

      return module40.default(this, t);
    };

  function O() {
    var t;
    module27.default(this, O);
    (t = D.call(this, ...args)).longPressDetected = false;
    t.pointerInside = true;
    t.STATE = S.UNDETERMINED;

    t.onGestureEvent = function (s) {
      var o = s.nativeEvent.pointerInside;
      if (t.pointerInside !== o) o ? t.onMoveIn() : t.onMoveOut();
      t.pointerInside = o;
    };

    t.onHandlerStateChange = function (s) {
      var o = s.nativeEvent.state;
      if (o === module403.State.CANCELLED || o === module403.State.FAILED) t.moveToState(S.UNDETERMINED);
      else if (o === ('android' !== ReactNative.Platform.OS ? module403.State.ACTIVE : module403.State.BEGAN) && t.STATE === S.UNDETERMINED) t.handlePressIn();
      else if (o === module403.State.END) {
        var n = !t.longPressDetected && t.STATE !== S.MOVED_OUTSIDE && null === t.pressOutTimeout;
        t.handleGoToUndetermined();
        if (n) null == t.props.onPress || t.props.onPress();
      }
    };

    t.onLongPressDetected = function () {
      t.longPressDetected = true;
      if (!(null == t.props.onLongPress)) t.props.onLongPress();
    };

    return t;
  }

  module28.default(O, [
    {
      key: 'handlePressIn',
      value: function () {
        var t = this;

        if (
          (this.props.delayPressIn
            ? (this.pressInTimeout = setTimeout(function () {
                t.moveToState(S.BEGAN);
                t.pressInTimeout = null;
              }, this.props.delayPressIn))
            : this.moveToState(S.BEGAN),
          this.props.onLongPress)
        ) {
          var s = (this.props.delayPressIn || 0) + (this.props.delayLongPress || 0);
          this.longPressTimeout = setTimeout(this.onLongPressDetected, s);
        }
      },
    },
    {
      key: 'handleMoveOutside',
      value: function () {
        var t = this;
        if (this.props.delayPressOut)
          this.pressOutTimeout =
            this.pressOutTimeout ||
            setTimeout(function () {
              t.moveToState(S.MOVED_OUTSIDE);
              t.pressOutTimeout = null;
            }, this.props.delayPressOut);
        else this.moveToState(S.MOVED_OUTSIDE);
      },
    },
    {
      key: 'handleGoToUndetermined',
      value: function () {
        var t = this;
        clearTimeout(this.pressOutTimeout);
        if (this.props.delayPressOut)
          this.pressOutTimeout = setTimeout(function () {
            if (t.STATE === S.UNDETERMINED) t.moveToState(S.BEGAN);
            t.moveToState(S.UNDETERMINED);
            t.pressOutTimeout = null;
          }, this.props.delayPressOut);
        else {
          if (this.STATE === S.UNDETERMINED) this.moveToState(S.BEGAN);
          this.moveToState(S.UNDETERMINED);
        }
      },
    },
    {
      key: 'componentDidMount',
      value: function () {
        this.reset();
      },
    },
    {
      key: 'reset',
      value: function () {
        this.longPressDetected = false;
        this.pointerInside = true;
        clearTimeout(this.pressInTimeout);
        clearTimeout(this.pressOutTimeout);
        clearTimeout(this.longPressTimeout);
        this.pressOutTimeout = null;
        this.longPressTimeout = null;
        this.pressInTimeout = null;
      },
    },
    {
      key: 'moveToState',
      value: function (t) {
        var s, o;

        if (t !== this.STATE) {
          var n, l;
          if (t === S.BEGAN) null == (n = (l = this.props).onPressIn) || n.call(l);
          else if (t === S.MOVED_OUTSIDE) {
            var u, p;
            if (!(null == (u = (p = this.props).onPressOut))) u.call(p);
          } else if (t === S.UNDETERMINED) {
            var c, h;
            if ((this.reset(), this.STATE === S.BEGAN)) null == (c = (h = this.props).onPressOut) || c.call(h);
          }
          if (!(null == (s = (o = this.props).onStateChange))) s.call(o, this.STATE, t);
          this.STATE = t;
        }
      },
    },
    {
      key: 'componentWillUnmount',
      value: function () {
        this.reset();
      },
    },
    {
      key: 'onMoveIn',
      value: function () {
        if (this.STATE === S.MOVED_OUTSIDE) this.moveToState(S.BEGAN);
      },
    },
    {
      key: 'onMoveOut',
      value: function () {
        clearTimeout(this.longPressTimeout);
        this.longPressTimeout = null;
        if (this.STATE === S.BEGAN) this.handleMoveOutside();
      },
    },
    {
      key: 'render',
      value: function () {
        var t,
          o = {
            accessible: false !== this.props.accessible,
            accessibilityLabel: this.props.accessibilityLabel,
            accessibilityHint: this.props.accessibilityHint,
            accessibilityRole: this.props.accessibilityRole,
            accessibilityState: this.props.accessibilityState,
            accessibilityActions: this.props.accessibilityActions,
            onAccessibilityAction: this.props.onAccessibilityAction,
            nativeID: this.props.nativeID,
            onLayout: this.props.onLayout,
            hitSlop: this.props.hitSlop,
          };
        return h.createElement(
          module634.BaseButton,
          module14.default(
            {
              style: this.props.containerStyle,
              onHandlerStateChange: this.props.disabled ? undefined : this.onHandlerStateChange,
              onGestureEvent: this.onGestureEvent,
              hitSlop: this.props.hitSlop,
              shouldActivateOnStart: this.props.shouldActivateOnStart,
              disallowInterruption: this.props.disallowInterruption,
              testID: this.props.testID,
              touchSoundDisabled: null != (t = this.props.touchSoundDisabled) && t,
              enabled: !this.props.disabled,
            },
            this.props.extraButtonProps
          ),
          h.createElement(
            ReactNative.Animated.View,
            module14.default({}, o, {
              style: this.props.style,
            }),
            this.props.children
          )
        );
      },
    },
  ]);
  return O;
})(React.Component)).defaultProps = {
  delayLongPress: 600,
  extraButtonProps: {
    rippleColor: 'transparent',
    exclusive: true,
  },
};
