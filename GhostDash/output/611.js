var module516 = require('./516'),
  module606 = require('./606'),
  t = (exports.longPressGestureHandlerProps = ['minDurationMs', 'maxDist']),
  u = (exports.longPressHandlerName = 'LongPressGestureHandler');

exports.LongPressGestureHandler = module516.default({
  name: u,
  allowedProps: [].concat(module23.default(module606.baseGestureHandlerProps), t),
  config: {
    shouldCancelWhenOutside: true,
  },
});
