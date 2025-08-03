exports.isChromeDebugger = o;
exports.isJest = t;
exports.isWeb = u;

exports.nativeShouldBeMock = function () {
  return t() || o();
};

exports.shouldBeUseWeb = function () {
  return t() || o() || u();
};

var ReactNative = require('react-native');

function t() {
  return !!process.env.JEST_WORKER_ID;
}

function o() {
  return !globals.nativeCallSyncHook || globals.__REMOTEDEV__;
}

function u() {
  return 'web' === ReactNative.Platform.OS;
}
