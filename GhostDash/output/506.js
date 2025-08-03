var module421 = require('./421');

exports.default =
  (module421.shouldBeUseWeb() &&
    ((globals._measure = function () {
      console.warn("[Reanimated] You can't use `measure` with Chrome Debugger or with web version");
      return {
        x: 0,
        y: 0,
        width: 0,
        height: 0,
        pageX: 0,
        pageY: 0,
      };
    }),
    (globals._scrollTo = function () {
      console.warn("[Reanimated] You can't use `scrollTo` with Chrome Debugger or with web version");
    }),
    (globals._dispatchCommand = function () {
      console.warn("[Reanimated] You can't use `scrollTo` or `dispatchCommand` methods with Chrome Debugger or with web version");
    }),
    (globals._setGestureState = function () {
      console.warn("[Reanimated] You can't use `setGestureState` with Chrome Debugger or with web version");
    })),
  true);
