var module516 = require('./516'),
  module606 = require('./606'),
  s = (exports.flingGestureHandlerProps = ['numberOfPointers', 'direction']),
  u = (exports.flingHandlerName = 'FlingGestureHandler');

exports.FlingGestureHandler = module516.default({
  name: u,
  allowedProps: [].concat(module23.default(module606.baseGestureHandlerProps), s),
  config: {},
});
