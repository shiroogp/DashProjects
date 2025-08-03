var ReactNative = require('react-native'),
  o = ReactNative.NativeModules.RNFetchBlob;

exports.default = {
  actionViewIntent: function (n) {
    var l = arguments.length > 1 && undefined !== arguments[1] ? arguments[1] : 'text/plain';
    return 'android' === ReactNative.Platform.OS ? o.actionViewIntent(n, l) : Promise.reject('RNFetchBlob.android.actionViewIntent only supports Android.');
  },
  getContentIntent: function (n) {
    return 'android' === ReactNative.Platform.OS ? o.getContentIntent(n) : Promise.reject('RNFetchBlob.android.getContentIntent only supports Android.');
  },
  addCompleteDownload: function (n) {
    return 'android' === ReactNative.Platform.OS ? o.addCompleteDownload(n) : Promise.reject('RNFetchBlob.android.addCompleteDownload only supports Android.');
  },
  getSDCardDir: function () {
    return 'android' === ReactNative.Platform.OS ? o.getSDCardDir() : Promise.reject('RNFetchBlob.android.getSDCardDir only supports Android.');
  },
  getSDCardApplicationDir: function () {
    return 'android' === ReactNative.Platform.OS ? o.getSDCardApplicationDir() : Promise.reject('RNFetchBlob.android.getSDCardApplicationDir only supports Android.');
  },
};
