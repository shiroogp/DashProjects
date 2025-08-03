exports.enableExperimentalWebImplementation = function () {
  var o = !(arguments.length > 0 && undefined !== arguments[0]) || arguments[0];
  if ('web' !== ReactNative.Platform.OS || t === o) return;
  if (l)
    return void console.error(
      'Some parts of this application have already started using old gesture handler implementation. No changes will be applied. You can try enabling new implementation earlier.'
    );
  t = o;
};

exports.isExperimentalWebImplementationEnabled = function () {
  l = true;
  return t;
};

var ReactNative = require('react-native'),
  t = false,
  l = false;
