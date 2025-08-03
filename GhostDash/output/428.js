exports.dispatchCommand = s;

exports.getTag = function (n) {
  return ReactNative.findNodeHandle(n);
};

exports.setGestureState = function (t, n) {
  'worklet';

  if (!_WORKLET || !o) return void console.warn('[Reanimated] You can not use setGestureState in non-worklet function.');

  _setGestureState(t, n);
};

var ReactNative = require('react-native'),
  module421 = require('./421');

var o = !module421.shouldBeUseWeb();

function s(t, n, s) {
  'worklet';

  if (_WORKLET && o) {
    var l = t();

    _dispatchCommand(l, n, s);
  }
}

if (module421.isWeb())
  exports.measure = function (t) {
    var n = t(),
      o = n.getBoundingClientRect();
    return {
      width: n.offsetWidth,
      height: n.offsetHeight,
      x: n.offsetLeft,
      y: n.offsetTop,
      pageX: o.left,
      pageY: o.top,
    };
  };
else if (module421.isChromeDebugger())
  exports.measure = function (t) {
    console.warn('[Reanimated] measure() cannot be used with Chrome Debugger.');
    return null;
  };
else
  exports.measure = function (t) {
    'worklet';

    if (!_WORKLET) return null;
    var n = t();

    if (-1 === n) {
      console.warn(
        '[Reanimated] The view with tag ' +
          n +
          ' is not a valid argument for measure(). This may be because the view is not currently rendered, which may not be a bug (e.g. an off-screen FlatList item).'
      );
      return null;
    }

    var o = _measure(n);

    if (null === o) {
      console.warn(
        '[Reanimated] The view with tag ' +
          n +
          ' has some undefined, not-yet-computed or meaningless value of `LayoutMetrics` type. This may be because the view is not currently rendered, which may not be a bug (e.g. an off-screen FlatList item).'
      );
      return null;
    } else if (-1234567 === o.x) {
      console.warn('[Reanimated] The view with tag ' + n + ' returned an invalid measurement response.');
      return null;
    } else if (isNaN(o.x)) {
      console.warn('[Reanimated] The view with tag ' + n + ' gets view-flattened on Android. To disable view-flattening, set `collapsable={false}` on this component.');
      return null;
    } else return o;
  };
if (module421.isWeb())
  exports.scrollTo = function (t, n, o, s) {
    'worklet';

    t().scrollTo({
      x: n,
      y: o,
      animated: s,
    });
  };
else if (o && globals._IS_FABRIC)
  exports.scrollTo = function (t, n, o, l) {
    'worklet';

    s(t, 'scrollTo', [n, o, l]);
  };
else
  exports.scrollTo = o
    ? function (t, n, o, s) {
        'worklet';

        if (_WORKLET) {
          var l = t();

          _scrollTo(l, n, o, s);
        }
      }
    : function (t, n, o) {};
