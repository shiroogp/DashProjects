var module99 = require('./99'),
  module624 = require('./624'),
  module625 = require('./625'),
  module626 = require('./626'),
  module627 = require('./627'),
  module628 = require('./628'),
  module629 = require('./629'),
  module630 = require('./630'),
  module631 = require('./631'),
  module632 = require('./632'),
  module633 = require('./633');

exports.GestureObjects = {
  Tap: function () {
    return new module631.TapGesture();
  },
  Pan: function () {
    return new module628.PanGesture();
  },
  Pinch: function () {
    return new module629.PinchGesture();
  },
  Rotation: function () {
    return new module630.RotationGesture();
  },
  Fling: function () {
    return new module624.FlingGesture();
  },
  LongPress: function () {
    return new module627.LongPressGesture();
  },
  ForceTouch: function () {
    return new module625.ForceTouchGesture();
  },
  Native: function () {
    return new module632.NativeGesture();
  },
  Manual: function () {
    return new module633.ManualGesture();
  },
  Race: function (...args) {
    return module99.default(module626.ComposedGesture, args);
  },
  Simultaneous: function (...args) {
    return module99.default(module626.SimultaneousGesture, args);
  },
  Exclusive: function (...args) {
    return module99.default(module626.ExclusiveGesture, args);
  },
};
