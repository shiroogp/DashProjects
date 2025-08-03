Object.defineProperty(exports, 'useEvent', {
  enumerable: true,
  get: function () {
    return module484.useEvent;
  },
});
Object.defineProperty(exports, 'useHandler', {
  enumerable: true,
  get: function () {
    return module484.useHandler;
  },
});

exports.useWorkletCallback = function (t, u) {
  return React.useCallback(t, null != u ? u : []);
};

var React = require('react'),
  module482 = require('./482'),
  module484 = require('./484');

exports.useAnimatedProps = module482.useAnimatedStyle;
