exports.checkCppVersion = function () {
  var t = globals._REANIMATED_VERSION_CPP;
  if (undefined === t)
    throw new Error(
      "[Reanimated] Couldn't determine the version of the native part of Reanimated. Did you forget to re-build the app after upgrading react-native-reanimated? If you use Expo Go, you must use the exact version which is bundled into Expo SDK."
    );
  if (!u(module419.jsVersion, t))
    throw new Error(
      '[Reanimated] Mismatch between JavaScript part and native part of Reanimated (' +
        module419.jsVersion +
        ' vs. ' +
        t +
        '). Did you forget to re-build the app after upgrading react-native-reanimated? If you use Expo Go, you must downgrade to ' +
        t +
        ' which is bundled into Expo SDK.'
    );
};

exports.matchVersion = u;

var module15 = require('@babel/runtime/helpers/slicedToArray'),
  module419 = require('./419');

function u(t, n) {
  if (t.match(/^\d+\.\d+\.\d+$/) && n.match(/^\d+\.\d+\.\d+$/)) {
    var u = t.split('.'),
      s = module15.default(u, 2),
      p = s[0],
      f = s[1],
      c = n.split('.'),
      h = module15.default(c, 2),
      v = h[0],
      l = h[1];
    return p === v && f === l;
  }

  return t === n;
}
