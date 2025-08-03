var ReactNative = require('react-native');

Object.keys(ReactNative).forEach(function (t) {
  if ('default' !== t && '__esModule' !== t)
    (t in exports && exports[t] === ReactNative[t]) ||
      Object.defineProperty(exports, t, {
        enumerable: true,
        get: function () {
          return ReactNative[t];
        },
      });
});
