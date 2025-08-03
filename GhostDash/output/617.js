var module516 = require('./516'),
  module606 = require('./606'),
  s = (exports.nativeViewGestureHandlerProps = ['shouldActivateOnStart', 'disallowInterruption']),
  v = (exports.nativeViewProps = [].concat(module23.default(module606.baseGestureHandlerProps), s)),
  u = (exports.nativeViewHandlerName = 'NativeViewGestureHandler');

exports.NativeViewGestureHandler = module516.default({
  name: u,
  allowedProps: v,
  config: {},
});
