exports.useAnimatedGestureHandler = function (E, o) {
  var A = module481.useHandler(E, o),
    s = A.context,
    C = A.doDependenciesDiffer,
    D = A.useWeb,
    N = function (t) {
      'worklet';

      var o = D ? t.nativeEvent : t;
      if (o.state === n.BEGAN && E.onStart) E.onStart(o, s);
      if (o.state === n.ACTIVE && E.onActive) E.onActive(o, s);
      if (o.oldState === n.ACTIVE && o.state === n.END && E.onEnd) E.onEnd(o, s);
      if (o.oldState === n.BEGAN && o.state === n.FAILED && E.onFail) E.onFail(o, s);
      if (o.oldState === n.ACTIVE && o.state === n.CANCELLED && E.onCancel) E.onCancel(o, s);
      if (!((o.oldState !== n.BEGAN && o.oldState !== n.ACTIVE) || o.state === n.BEGAN || o.state === n.ACTIVE || !E.onFinish))
        E.onFinish(o, s, o.state === n.CANCELLED || o.state === n.FAILED);
    };

  if (D) return N;
  return module481.useEvent(N, ['onGestureHandlerStateChange', 'onGestureHandlerEvent'], C);
};

var module481 = require('./481'),
  n = (exports.EventType = (function (t) {
    t[(t.UNDETERMINED = 0)] = 'UNDETERMINED';
    t[(t.FAILED = 1)] = 'FAILED';
    t[(t.BEGAN = 2)] = 'BEGAN';
    t[(t.CANCELLED = 3)] = 'CANCELLED';
    t[(t.ACTIVE = 4)] = 'ACTIVE';
    t[(t.END = 5)] = 'END';
    return t;
  })({}));
