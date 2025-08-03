exports.useScrollViewOffset = function (l, f) {
  var s = React.useRef(undefined !== f ? f : module483.useSharedValue(0)),
    v = module484.useEvent(function (n) {
      'worklet';

      s.current.value = 0 === n.contentOffset.x ? n.contentOffset.y : n.contentOffset.x;
    }, c);
  React.useEffect(
    function () {
      var n,
        o = ReactNative.findNodeHandle(l.current);
      if (!(null == (n = v.current))) n.registerForEvents(o);
    },
    [l.current]
  );
  return s.current;
};

var React = require('react'),
  ReactNative = require('react-native'),
  module484 = require('./484'),
  module483 = require('./483'),
  c = ['onScroll', 'onScrollBeginDrag', 'onScrollEndDrag', 'onMomentumScrollBegin', 'onMomentumScrollEnd'];
