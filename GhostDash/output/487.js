exports.useAnimatedRef = function () {
  var u = module483.useSharedValue(-1),
    l = React.useRef();

  if (!l.current) {
    var v = function t(n) {
      if (n) {
        u.value = f(c(n));
        t.current = n;
      }

      return u.value;
    };

    v.current = null;

    var _ = module423.makeShareableCloneRecursive({
      __init: function () {
        'worklet';

        return function () {
          return u.value;
        };
      },
    });

    module423.registerShareableMapping(v, _);
    l.current = v;
  }

  return l.current;
};

var React = require('react'),
  module483 = require('./483'),
  module428 = require('./428'),
  module478 = require('./478'),
  module423 = require('./423');

function c(t) {
  return globals._IS_FABRIC && t.getNativeScrollRef ? t.getNativeScrollRef() : !globals._IS_FABRIC && t.getScrollableNode ? t.getScrollableNode() : t;
}

var f = globals._IS_FABRIC
  ? function (t) {
      return module478.getShadowNodeWrapperFromHostInstance(t);
    }
  : module428.getTag;
