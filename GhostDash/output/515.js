var module516 = require('./516'),
  module606 = require('./606'),
  u = (exports.tapGestureHandlerProps = ['maxDurationMs', 'maxDelayMs', 'numberOfTaps', 'maxDeltaX', 'maxDeltaY', 'maxDist', 'minPointers']),
  o = (exports.tapHandlerName = 'TapGestureHandler');

exports.TapGestureHandler = module516.default({
  name: o,
  allowedProps: [].concat(module23.default(module606.baseGestureHandlerProps), u),
  config: {
    shouldCancelWhenOutside: true,
  },
});
