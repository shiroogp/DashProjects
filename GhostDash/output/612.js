exports.managePanProps = X;

var module50 = require('./50'),
  module516 = require('./516'),
  module606 = require('./606');

function c(t, f) {
  var s = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var n = Object.getOwnPropertySymbols(t);
    if (f)
      n = n.filter(function (f) {
        return Object.getOwnPropertyDescriptor(t, f).enumerable;
      });
    s.push.apply(s, n);
  }

  return s;
}

function l(t) {
  for (var s = 1; s < arguments.length; s++) {
    var n = null != arguments[s] ? arguments[s] : {};
    if (s % 2)
      c(Object(n), true).forEach(function (s) {
        module50.default(t, s, n[s]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(n));
    else
      c(Object(n)).forEach(function (f) {
        Object.defineProperty(t, f, Object.getOwnPropertyDescriptor(n, f));
      });
  }

  return t;
}

var o = (exports.panGestureHandlerProps = [
    'activeOffsetY',
    'activeOffsetX',
    'failOffsetY',
    'failOffsetX',
    'minDist',
    'minVelocity',
    'minVelocityX',
    'minVelocityY',
    'minPointers',
    'maxPointers',
    'avgTouches',
    'enableTrackpadTwoFingerGesture',
    'activateAfterLongPress',
  ]),
  v = (exports.panGestureHandlerCustomNativeProps = [
    'activeOffsetYStart',
    'activeOffsetYEnd',
    'activeOffsetXStart',
    'activeOffsetXEnd',
    'failOffsetYStart',
    'failOffsetYEnd',
    'failOffsetXStart',
    'failOffsetXEnd',
  ]),
  u = (exports.panHandlerName = 'PanGestureHandler');
exports.PanGestureHandler = module516.default({
  name: u,
  allowedProps: [].concat(module23.default(module606.baseGestureHandlerProps), o),
  config: {},
  transformProps: X,
  customNativeProps: v,
});

function p(t) {
  var f = l({}, t);

  if (undefined !== t.activeOffsetX) {
    delete f.activeOffsetX;

    if (Array.isArray(t.activeOffsetX)) {
      f.activeOffsetXStart = t.activeOffsetX[0];
      f.activeOffsetXEnd = t.activeOffsetX[1];
    } else if (t.activeOffsetX < 0) f.activeOffsetXStart = t.activeOffsetX;
    else f.activeOffsetXEnd = t.activeOffsetX;
  }

  if (undefined !== t.activeOffsetY) {
    delete f.activeOffsetY;

    if (Array.isArray(t.activeOffsetY)) {
      f.activeOffsetYStart = t.activeOffsetY[0];
      f.activeOffsetYEnd = t.activeOffsetY[1];
    } else if (t.activeOffsetY < 0) f.activeOffsetYStart = t.activeOffsetY;
    else f.activeOffsetYEnd = t.activeOffsetY;
  }

  if (undefined !== t.failOffsetX) {
    delete f.failOffsetX;

    if (Array.isArray(t.failOffsetX)) {
      f.failOffsetXStart = t.failOffsetX[0];
      f.failOffsetXEnd = t.failOffsetX[1];
    } else if (t.failOffsetX < 0) f.failOffsetXStart = t.failOffsetX;
    else f.failOffsetXEnd = t.failOffsetX;
  }

  if (undefined !== t.failOffsetY) {
    delete f.failOffsetY;

    if (Array.isArray(t.failOffsetY)) {
      f.failOffsetYStart = t.failOffsetY[0];
      f.failOffsetYEnd = t.failOffsetY[1];
    } else if (t.failOffsetY < 0) f.failOffsetYStart = t.failOffsetY;
    else f.failOffsetYEnd = t.failOffsetY;
  }

  return f;
}

function X(t) {
  return p(t);
}
