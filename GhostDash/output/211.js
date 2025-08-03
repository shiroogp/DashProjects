var module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module50 = require('./50');

function R(t, E) {
  var R = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var o = Object.getOwnPropertySymbols(t);
    if (E)
      o = o.filter(function (E) {
        return Object.getOwnPropertyDescriptor(t, E).enumerable;
      });
    R.push.apply(R, o);
  }

  return R;
}

function o(t) {
  for (var o = 1; o < arguments.length; o++) {
    var s = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      R(Object(s), true).forEach(function (R) {
        module50(t, R, s[R]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(s));
    else
      R(Object(s)).forEach(function (E) {
        Object.defineProperty(t, E, Object.getOwnPropertyDescriptor(s, E));
      });
  }

  return t;
}

require('react');

require('./85');

require('./68');

var module212 = require('./212'),
  module52 = require('./52'),
  module214 = require('./214'),
  module88 = require('./88'),
  module61 = require('./61'),
  module215 = require('./215'),
  module47 = require('./47'),
  module217 = require('./217'),
  module219 = require('./219'),
  P = function (t) {
    var E = t.touches,
      R = t.changedTouches,
      o = E && E.length > 0,
      s = R && R.length > 0;
    return !o && s ? R[0] : o ? E[0] : t;
  },
  T = module219({
    NOT_RESPONDER: null,
    RESPONDER_INACTIVE_PRESS_IN: null,
    RESPONDER_INACTIVE_PRESS_OUT: null,
    RESPONDER_ACTIVE_PRESS_IN: null,
    RESPONDER_ACTIVE_PRESS_OUT: null,
    RESPONDER_ACTIVE_LONG_PRESS_IN: null,
    RESPONDER_ACTIVE_LONG_PRESS_OUT: null,
    ERROR: null,
  }),
  c = {
    NOT_RESPONDER: false,
    RESPONDER_INACTIVE_PRESS_IN: false,
    RESPONDER_INACTIVE_PRESS_OUT: false,
    RESPONDER_ACTIVE_PRESS_IN: false,
    RESPONDER_ACTIVE_PRESS_OUT: false,
    RESPONDER_ACTIVE_LONG_PRESS_IN: false,
    RESPONDER_ACTIVE_LONG_PRESS_OUT: false,
    ERROR: false,
  },
  D = o(
    o({}, c),
    {},
    {
      RESPONDER_ACTIVE_PRESS_OUT: true,
      RESPONDER_ACTIVE_PRESS_IN: true,
    }
  ),
  I = o(
    o({}, c),
    {},
    {
      RESPONDER_INACTIVE_PRESS_IN: true,
      RESPONDER_ACTIVE_PRESS_IN: true,
      RESPONDER_ACTIVE_LONG_PRESS_IN: true,
    }
  ),
  A = o(
    o({}, c),
    {},
    {
      RESPONDER_ACTIVE_LONG_PRESS_IN: true,
    }
  ),
  b = module219({
    DELAY: null,
    RESPONDER_GRANT: null,
    RESPONDER_RELEASE: null,
    RESPONDER_TERMINATED: null,
    ENTER_PRESS_RECT: null,
    LEAVE_PRESS_RECT: null,
    LONG_PRESS_DETECTED: null,
  }),
  p = {
    NOT_RESPONDER: {
      DELAY: T.ERROR,
      RESPONDER_GRANT: T.RESPONDER_INACTIVE_PRESS_IN,
      RESPONDER_RELEASE: T.ERROR,
      RESPONDER_TERMINATED: T.ERROR,
      ENTER_PRESS_RECT: T.ERROR,
      LEAVE_PRESS_RECT: T.ERROR,
      LONG_PRESS_DETECTED: T.ERROR,
    },
    RESPONDER_INACTIVE_PRESS_IN: {
      DELAY: T.RESPONDER_ACTIVE_PRESS_IN,
      RESPONDER_GRANT: T.ERROR,
      RESPONDER_RELEASE: T.NOT_RESPONDER,
      RESPONDER_TERMINATED: T.NOT_RESPONDER,
      ENTER_PRESS_RECT: T.RESPONDER_INACTIVE_PRESS_IN,
      LEAVE_PRESS_RECT: T.RESPONDER_INACTIVE_PRESS_OUT,
      LONG_PRESS_DETECTED: T.ERROR,
    },
    RESPONDER_INACTIVE_PRESS_OUT: {
      DELAY: T.RESPONDER_ACTIVE_PRESS_OUT,
      RESPONDER_GRANT: T.ERROR,
      RESPONDER_RELEASE: T.NOT_RESPONDER,
      RESPONDER_TERMINATED: T.NOT_RESPONDER,
      ENTER_PRESS_RECT: T.RESPONDER_INACTIVE_PRESS_IN,
      LEAVE_PRESS_RECT: T.RESPONDER_INACTIVE_PRESS_OUT,
      LONG_PRESS_DETECTED: T.ERROR,
    },
    RESPONDER_ACTIVE_PRESS_IN: {
      DELAY: T.ERROR,
      RESPONDER_GRANT: T.ERROR,
      RESPONDER_RELEASE: T.NOT_RESPONDER,
      RESPONDER_TERMINATED: T.NOT_RESPONDER,
      ENTER_PRESS_RECT: T.RESPONDER_ACTIVE_PRESS_IN,
      LEAVE_PRESS_RECT: T.RESPONDER_ACTIVE_PRESS_OUT,
      LONG_PRESS_DETECTED: T.RESPONDER_ACTIVE_LONG_PRESS_IN,
    },
    RESPONDER_ACTIVE_PRESS_OUT: {
      DELAY: T.ERROR,
      RESPONDER_GRANT: T.ERROR,
      RESPONDER_RELEASE: T.NOT_RESPONDER,
      RESPONDER_TERMINATED: T.NOT_RESPONDER,
      ENTER_PRESS_RECT: T.RESPONDER_ACTIVE_PRESS_IN,
      LEAVE_PRESS_RECT: T.RESPONDER_ACTIVE_PRESS_OUT,
      LONG_PRESS_DETECTED: T.ERROR,
    },
    RESPONDER_ACTIVE_LONG_PRESS_IN: {
      DELAY: T.ERROR,
      RESPONDER_GRANT: T.ERROR,
      RESPONDER_RELEASE: T.NOT_RESPONDER,
      RESPONDER_TERMINATED: T.NOT_RESPONDER,
      ENTER_PRESS_RECT: T.RESPONDER_ACTIVE_LONG_PRESS_IN,
      LEAVE_PRESS_RECT: T.RESPONDER_ACTIVE_LONG_PRESS_OUT,
      LONG_PRESS_DETECTED: T.RESPONDER_ACTIVE_LONG_PRESS_IN,
    },
    RESPONDER_ACTIVE_LONG_PRESS_OUT: {
      DELAY: T.ERROR,
      RESPONDER_GRANT: T.ERROR,
      RESPONDER_RELEASE: T.NOT_RESPONDER,
      RESPONDER_TERMINATED: T.NOT_RESPONDER,
      ENTER_PRESS_RECT: T.RESPONDER_ACTIVE_LONG_PRESS_IN,
      LEAVE_PRESS_RECT: T.RESPONDER_ACTIVE_LONG_PRESS_OUT,
      LONG_PRESS_DETECTED: T.ERROR,
    },
    error: {
      DELAY: T.NOT_RESPONDER,
      RESPONDER_GRANT: T.RESPONDER_INACTIVE_PRESS_IN,
      RESPONDER_RELEASE: T.NOT_RESPONDER,
      RESPONDER_TERMINATED: T.NOT_RESPONDER,
      ENTER_PRESS_RECT: T.NOT_RESPONDER,
      LEAVE_PRESS_RECT: T.NOT_RESPONDER,
      LONG_PRESS_DETECTED: T.NOT_RESPONDER,
    },
  },
  C = {
    componentDidMount: function () {
      if (module52.isTV) {
        this._tvEventHandler = new module215();

        this._tvEventHandler.enable(this, function (t, E) {
          var R = module88.findNodeHandle(t);
          E.dispatchConfig = {};
          if (R === E.tag) 'focus' === E.eventType ? t.touchableHandleFocus(E) : 'blur' === E.eventType ? t.touchableHandleBlur(E) : E.eventType;
        });
      }
    },
    componentWillUnmount: function () {
      if (this._tvEventHandler) {
        this._tvEventHandler.disable();

        delete this._tvEventHandler;
      }

      if (this.touchableDelayTimeout) clearTimeout(this.touchableDelayTimeout);
      if (this.longPressDelayTimeout) clearTimeout(this.longPressDelayTimeout);
      if (this.pressOutDelayTimeout) clearTimeout(this.pressOutDelayTimeout);
    },
    touchableGetInitialState: function () {
      return {
        touchable: {
          touchState: undefined,
          responderID: null,
        },
      };
    },
    touchableHandleResponderTerminationRequest: function () {
      return !this.props.rejectResponderTermination;
    },
    touchableHandleStartShouldSetResponder: function () {
      return !this.props.disabled;
    },
    touchableLongPressCancelsPress: function () {
      return true;
    },
    touchableHandleResponderGrant: function (t) {
      var E = t.currentTarget;
      t.persist();
      if (this.pressOutDelayTimeout) clearTimeout(this.pressOutDelayTimeout);
      this.pressOutDelayTimeout = null;
      this.state.touchable.touchState = T.NOT_RESPONDER;
      this.state.touchable.responderID = E;

      this._receiveSignal(b.RESPONDER_GRANT, t);

      var R = undefined !== this.touchableGetHighlightDelayMS ? this.touchableGetHighlightDelayMS() ** 0 : 130;
      if (0 !== (R = isNaN(R) ? 130 : R)) this.touchableDelayTimeout = setTimeout(this._handleDelay.bind(this, t), R);
      else this._handleDelay(t);
      var o = undefined !== this.touchableGetLongPressDelayMS ? this.touchableGetLongPressDelayMS() ** 10 : 370;
      o = isNaN(o) ? 370 : o;
      this.longPressDelayTimeout = setTimeout(this._handleLongDelay.bind(this, t), o + R);
    },
    touchableHandleResponderRelease: function (t) {
      this.pressInLocation = null;

      this._receiveSignal(b.RESPONDER_RELEASE, t);
    },
    touchableHandleResponderTerminate: function (t) {
      this.pressInLocation = null;

      this._receiveSignal(b.RESPONDER_TERMINATED, t);
    },
    touchableHandleResponderMove: function (t) {
      if (this.state.touchable.positionOnActivate) {
        var E = this.state.touchable.positionOnActivate,
          R = this.state.touchable.dimensionsOnActivate,
          o = this.touchableGetPressRectOffset
            ? this.touchableGetPressRectOffset()
            : {
                left: 20,
                right: 20,
                top: 20,
                bottom: 20,
              },
          s = o.left,
          n = o.top,
          _ = o.right,
          S = o.bottom,
          l = this.touchableGetHitSlop ? this.touchableGetHitSlop() : null;

        if (l) {
          s += l.left || 0;
          n += l.top || 0;
          _ += l.right || 0;
          S += l.bottom || 0;
        }

        var h = P(t.nativeEvent),
          u = h && h.pageX,
          O = h && h.pageY;
        if (this.pressInLocation) this._getDistanceBetweenPoints(u, O, this.pressInLocation.pageX, this.pressInLocation.pageY) > 10 && this._cancelLongPressDelayTimeout();

        if (u > E.left - s && O > E.top - n && u < E.left + R.width + _ && O < E.top + R.height + S) {
          var N = this.state.touchable.touchState;

          this._receiveSignal(b.ENTER_PRESS_RECT, t);

          if (this.state.touchable.touchState === T.RESPONDER_INACTIVE_PRESS_IN && N !== T.RESPONDER_INACTIVE_PRESS_IN) this._cancelLongPressDelayTimeout();
        } else {
          this._cancelLongPressDelayTimeout();

          this._receiveSignal(b.LEAVE_PRESS_RECT, t);
        }
      }
    },
    touchableHandleFocus: function (t) {
      if (this.props.onFocus) this.props.onFocus(t);
    },
    touchableHandleBlur: function (t) {
      if (this.props.onBlur) this.props.onBlur(t);
    },
    _remeasureMetricsOnActivation: function () {
      var t = this.state.touchable.responderID;
      if (null != t) 'number' == typeof t ? module47.measure(t, this._handleQueryLayout) : t.measure(this._handleQueryLayout);
    },
    _handleQueryLayout: function (t, E, R, o, n, S) {
      if (t || E || R || o || n || S) {
        if (this.state.touchable.positionOnActivate) module214.release(this.state.touchable.positionOnActivate);
        if (this.state.touchable.dimensionsOnActivate) module212.release(this.state.touchable.dimensionsOnActivate);
        this.state.touchable.positionOnActivate = module214.getPooled(n, S);
        this.state.touchable.dimensionsOnActivate = module212.getPooled(R, o);
      }
    },
    _handleDelay: function (t) {
      this.touchableDelayTimeout = null;

      this._receiveSignal(b.DELAY, t);
    },
    _handleLongDelay: function (t) {
      this.longPressDelayTimeout = null;
      var E = this.state.touchable.touchState;
      if (!(E !== T.RESPONDER_ACTIVE_PRESS_IN && E !== T.RESPONDER_ACTIVE_LONG_PRESS_IN)) this._receiveSignal(b.LONG_PRESS_DETECTED, t);
    },
    _receiveSignal: function (t, E) {
      var R = this.state.touchable.responderID,
        o = this.state.touchable.touchState,
        s = p[o] && p[o][t];

      if (R || t !== b.RESPONDER_RELEASE) {
        if (!s)
          throw new Error(
            'Unrecognized signal `' + t + '` or state `' + o + '` for Touchable responder `' + typeof this.state.touchable.responderID == 'number'
              ? this.state.touchable.responderID
              : 'host component`'
          );
        if (s === T.ERROR)
          throw new Error(
            'Touchable cannot transition from `' + o + '` to `' + t + '` for responder `' + typeof this.state.touchable.responderID == 'number'
              ? this.state.touchable.responderID
              : '<<host component>>`'
          );

        if (o !== s) {
          this._performSideEffectsForTransition(o, s, t, E);

          this.state.touchable.touchState = s;
        }
      }
    },
    _cancelLongPressDelayTimeout: function () {
      if (this.longPressDelayTimeout) clearTimeout(this.longPressDelayTimeout);
      this.longPressDelayTimeout = null;
    },
    _isHighlight: function (t) {
      return t === T.RESPONDER_ACTIVE_PRESS_IN || t === T.RESPONDER_ACTIVE_LONG_PRESS_IN;
    },
    _savePressInLocation: function (t) {
      var E = P(t.nativeEvent),
        R = E && E.pageX,
        o = E && E.pageY,
        s = E && E.locationX,
        n = E && E.locationY;
      this.pressInLocation = {
        pageX: R,
        pageY: o,
        locationX: s,
        locationY: n,
      };
    },
    _getDistanceBetweenPoints: function (t, E, R, o) {
      var s = t - R,
        n = E - o;
      return Math.sqrt(s * s + n * n);
    },
    _performSideEffectsForTransition: function (t, E, R, o) {
      var s = this._isHighlight(t),
        n = this._isHighlight(E);

      if (R === b.RESPONDER_TERMINATED || R === b.RESPONDER_RELEASE) this._cancelLongPressDelayTimeout();

      var _ = t === T.NOT_RESPONDER && E === T.RESPONDER_INACTIVE_PRESS_IN,
        S = !D[t] && D[E];

      if (
        ((_ || S) && this._remeasureMetricsOnActivation(),
        I[t] && R === b.LONG_PRESS_DETECTED && this.touchableHandleLongPress && this.touchableHandleLongPress(o),
        n && !s ? this._startHighlight(o) : !n && s && this._endHighlight(o),
        I[t] && R === b.RESPONDER_RELEASE)
      ) {
        var l = !!this.props.onLongPress,
          h = A[t] && (!l || !this.touchableLongPressCancelsPress());

        if ((!A[t] || h) && this.touchableHandlePress) {
          if (!(n || s)) {
            this._startHighlight(o);

            this._endHighlight(o);
          }

          if (!this.props.touchSoundDisabled) module217.playTouchSound();
          this.touchableHandlePress(o);
        }
      }

      if (this.touchableDelayTimeout) clearTimeout(this.touchableDelayTimeout);
      this.touchableDelayTimeout = null;
    },
    _startHighlight: function (t) {
      this._savePressInLocation(t);

      if (this.touchableHandleActivePressIn) this.touchableHandleActivePressIn(t);
    },
    _endHighlight: function (t) {
      var E = this;
      if (this.touchableHandleActivePressOut)
        this.touchableGetPressOutDelayMS && this.touchableGetPressOutDelayMS()
          ? (this.pressOutDelayTimeout = setTimeout(function () {
              E.touchableHandleActivePressOut(t);
            }, this.touchableGetPressOutDelayMS()))
          : this.touchableHandleActivePressOut(t);
    },
    withoutDefaultFocusAndBlur: {},
  },
  L = module56(C, ['touchableHandleFocus', 'touchableHandleBlur']);

C.withoutDefaultFocusAndBlur = L;
var f = {
  Mixin: C,
  TOUCH_TARGET_DEBUG: false,
  renderDebugView: function (t) {
    if (!f.TOUCH_TARGET_DEBUG) return null;
    throw Error('Touchable.TOUCH_TARGET_DEBUG should not be enabled in prod!');
  },
};
module61.create({
  debug: {
    position: 'absolute',
    borderWidth: 1,
    borderStyle: 'dashed',
  },
});
module.exports = f;
