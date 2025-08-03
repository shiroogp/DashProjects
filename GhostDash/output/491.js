exports.useFrameCallback = function (c) {
  var l = !(arguments.length > 1 && undefined !== arguments[1]) || arguments[1],
    u = React.useRef({
      setActive: function (c) {
        module492.manageStateFrameCallback(u.current.callbackId, c);
        u.current.isActive = c;
      },
      isActive: l,
      callbackId: -1,
    });
  React.useEffect(
    function () {
      u.current.callbackId = module492.registerFrameCallback(c);
      u.current.setActive(u.current.isActive);
      return function () {
        module492.unregisterFrameCallback(u.current.callbackId);
        u.current.callbackId = -1;
      };
    },
    [c, l]
  );
  return u.current;
};

var React = require('react'),
  module492 = new (require('./492').default)();
