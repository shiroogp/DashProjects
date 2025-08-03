var module409 = require('./409'),
  module403 = require('./403'),
  module406 = require('./406').tagMessage('react-native-reanimated is required in order to use synchronous state management'),
  u = undefined !== (null == module409.Reanimated ? undefined : module409.Reanimated.useSharedValue),
  s = null == module409.Reanimated ? undefined : module409.Reanimated.setGestureState;

exports.GestureStateManager = {
  create: function (t) {
    'worklet';

    return {
      begin: function () {
        if (u) s(t, module403.State.BEGAN);
        else console.warn(module406);
      },
      activate: function () {
        if (u) s(t, module403.State.ACTIVE);
        else console.warn(module406);
      },
      fail: function () {
        if (u) s(t, module403.State.FAILED);
        else console.warn(module406);
      },
      end: function () {
        if (u) s(t, module403.State.END);
        else console.warn(module406);
      },
    };
  },
};
