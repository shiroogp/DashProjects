exports.onGestureHandlerEvent = S;

exports.startListening = function () {
  C();
  h = ReactNative.DeviceEventEmitter.addListener('onGestureHandlerEvent', S);
  u = ReactNative.DeviceEventEmitter.addListener('onGestureHandlerStateChange', S);
};

exports.stopListening = C;

var ReactNative = require('react-native'),
  module403 = require('./403'),
  module404 = require('./404'),
  module405 = require('./405'),
  module408 = require('./408'),
  h = null,
  u = null,
  E = new Map(),
  T = [];

function c(n) {
  return null != n.oldState;
}

function v(n) {
  return null != n.eventType;
}

function S(n) {
  var h,
    u,
    S,
    C,
    f = module405.findHandler(n.handlerTag);
  if (f) {
    if (c(n))
      n.oldState === module403.State.UNDETERMINED && n.state === module403.State.BEGAN
        ? null == f.handlers.onBegin || f.handlers.onBegin(n)
        : (n.oldState !== module403.State.BEGAN && n.oldState !== module403.State.UNDETERMINED) || n.state !== module403.State.ACTIVE
        ? n.oldState !== n.state && n.state === module403.State.END
          ? (n.oldState === module403.State.ACTIVE && (null == f.handlers.onEnd || f.handlers.onEnd(n, true)),
            null == f.handlers.onFinalize || f.handlers.onFinalize(n, true),
            (T[f.handlers.handlerTag] = undefined))
          : (n.state !== module403.State.FAILED && n.state !== module403.State.CANCELLED) ||
            n.oldState === n.state ||
            (n.oldState === module403.State.ACTIVE && (null == f.handlers.onEnd || f.handlers.onEnd(n, false)),
            null == f.handlers.onFinalize || f.handlers.onFinalize(n, false),
            E.delete(n.handlerTag),
            (T[f.handlers.handlerTag] = undefined))
        : (null == f.handlers.onStart || f.handlers.onStart(n), (T[f.handlers.handlerTag] = n));
    else if (v(n)) {
      if (!E.has(n.handlerTag)) E.set(n.handlerTag, module408.GestureStateManager.create(n.handlerTag));
      var p = E.get(n.handlerTag);

      switch (n.eventType) {
        case module404.TouchEventType.TOUCHES_DOWN:
          if (!(null == (h = f.handlers) || null == h.onTouchesDown)) h.onTouchesDown(n, p);
          break;

        case module404.TouchEventType.TOUCHES_MOVE:
          if (!(null == (u = f.handlers) || null == u.onTouchesMove)) u.onTouchesMove(n, p);
          break;

        case module404.TouchEventType.TOUCHES_UP:
          if (!(null == (S = f.handlers) || null == S.onTouchesUp)) S.onTouchesUp(n, p);
          break;

        case module404.TouchEventType.TOUCHES_CANCELLED:
          if (!(null == (C = f.handlers) || null == C.onTouchesCancelled)) C.onTouchesCancelled(n, p);
      }
    } else {
      if (!(null == f.handlers.onUpdate)) f.handlers.onUpdate(n);

      if (f.handlers.onChange && f.handlers.changeEventCalculator) {
        if (!(null == f.handlers.onChange))
          f.handlers.onChange(null == f.handlers.changeEventCalculator ? undefined : f.handlers.changeEventCalculator(n, T[f.handlers.handlerTag]));
        T[f.handlers.handlerTag] = n;
      }
    }
  } else {
    var D = module405.findOldGestureHandler(n.handlerTag);

    if (D) {
      var U = {
        nativeEvent: n,
      };
      return void (c(n) ? D.onGestureStateChange(U) : D.onGestureEvent(U));
    }
  }
}

function C() {
  if (h) {
    h.remove();
    h = null;
  }

  if (u) {
    u.remove();
    u = null;
  }
}
