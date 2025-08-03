var t,
  module406 = require('./406');

try {
  if (((exports.Reanimated = t = require('./410')), !t.useSharedValue)) throw ((exports.Reanimated = t = undefined), new Error('react-native-reanimated is not found'));
  if (!t.setGestureState)
    t.setGestureState = function () {
      'worklet';

      console.warn(module406.tagMessage('Please use newer version of react-native-reanimated in order to control state of the gestures.'));
    };
} catch (t) {}
