var module50 = require('./50'),
  module27 = require('./27');

function s(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var c = Object.getOwnPropertySymbols(t);
    if (n)
      c = c.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, c);
  }

  return o;
}

function u(t) {
  for (var o = 1; o < arguments.length; o++) {
    var c = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      s(Object(c), true).forEach(function (o) {
        module50.default(t, o, c[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(c));
    else
      s(Object(c)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(c, n));
      });
  }

  return t;
}

var ReactNative = require('react-native').NativeModules.RNFaceDetector || {
    stubbed: true,
    Mode: {},
    Landmarks: {},
    Classifications: {},
    detectFaces: function () {
      return new Promise(function (t, n) {
        return n('Face detection has not been included in this build.');
      });
    },
  },
  l = (exports.default = (function () {
    function t() {
      module27.default(this, t);
    }

    module28.default(t, null, [
      {
        key: 'detectFacesAsync',
        value: function (t, n) {
          return ReactNative.detectFaces(
            u(
              u({}, n),
              {},
              {
                uri: t,
              }
            )
          );
        },
      },
    ]);
    return t;
  })());

l.Constants = {
  Mode: ReactNative.Mode,
  Landmarks: ReactNative.Landmarks,
  Classifications: ReactNative.Classifications,
};
exports.Constants = l.Constants;
