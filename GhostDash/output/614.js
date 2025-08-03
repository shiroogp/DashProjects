var module516 = require('./516'),
  module606 = require('./606'),
  l = (exports.rotationHandlerName = 'RotationGestureHandler');

exports.RotationGestureHandler = module516.default({
  name: l,
  allowedProps: module606.baseGestureHandlerProps,
  config: {},
});
