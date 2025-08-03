exports.hasProperty = v;

exports.isFabric = function () {
  var n;
  return !(null == (n = globals) || !n.nativeFabricUIManager);
};

exports.isJestEnv = function () {
  return v(globals, 'process') && !!process.env.JEST_WORKER_ID;
};

exports.isRemoteDebuggingEnabled = function () {
  return !globals.nativeCallSyncHook || globals.__REMOTEDEV__;
};

exports.shouldUseCodegenNativeComponent = function () {
  return f.minor >= 68 || f.major > 0;
};

exports.tagMessage = function (n) {
  return '[react-native-gesture-handler] ' + n;
};

exports.toArray = function (n) {
  if (!Array.isArray(n)) return [n];
  return n;
};

exports.withPrevAndCurrent = function (n, o) {
  var u = [null],
    s = [];
  module23.default(n).forEach(function (n, t) {
    var c = u[t],
      l = o(c, n);
    u.push(l);
    s.push(l);
  });
  return s;
};

var module15 = require('@babel/runtime/helpers/slicedToArray'),
  module407 = require('./407').default.version.split('.'),
  s = module15.default(module407, 2),
  c = s[0],
  l = s[1],
  f = (exports.REACT_NATIVE_VERSION = {
    major: parseInt(c, 10),
    minor: parseInt(l, 10),
  });

function v(n, t) {
  return Object.prototype.hasOwnProperty.call(n, t);
}
