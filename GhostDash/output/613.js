var module516 = require('./516'),
  module606 = require('./606'),
  o = (exports.pinchHandlerName = 'PinchGestureHandler');

exports.PinchGestureHandler = module516.default({
  name: o,
  allowedProps: module606.baseGestureHandlerProps,
  config: {},
});
