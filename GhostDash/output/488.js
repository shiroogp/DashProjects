exports.useAnimatedScrollHandler = function (o, l) {
  var t =
      'function' == typeof o
        ? {
            onScroll: o,
          }
        : o,
    u = module481.useHandler(t, l),
    c = u.context,
    s = u.doDependenciesDiffer,
    v = ['onScroll'];
  if (undefined !== t.onBeginDrag) v.push('onScrollBeginDrag');
  if (undefined !== t.onEndDrag) v.push('onScrollEndDrag');
  if (undefined !== t.onMomentumBegin) v.push('onMomentumScrollBegin');
  if (undefined !== t.onMomentumEnd) v.push('onMomentumScrollEnd');
  return module481.useEvent(
    function (n) {
      'worklet';

      var o = t.onScroll,
        l = t.onBeginDrag,
        u = t.onEndDrag,
        s = t.onMomentumBegin,
        v = t.onMomentumEnd;
      if (o && n.eventName.endsWith('onScroll')) o(n, c);
      else if (l && n.eventName.endsWith('onScrollBeginDrag')) l(n, c);
      else if (u && n.eventName.endsWith('onScrollEndDrag')) u(n, c);
      else if (s && n.eventName.endsWith('onMomentumScrollBegin')) s(n, c);
      else if (v && n.eventName.endsWith('onMomentumScrollEnd')) v(n, c);
    },
    v,
    s
  );
};

var module481 = require('./481');
