var ReactNative = require('react-native'),
  t = ReactNative.NativeModules.RNFetchBlob;

exports.default = {
  openDocument: function (u, n) {
    return 'ios' === ReactNative.Platform.OS ? t.openDocument('file://' + u, n) : Promise.reject('RNFetchBlob.previewDocument only supports IOS.');
  },
  previewDocument: function (u, n) {
    return 'ios' === ReactNative.Platform.OS ? t.previewDocument('file://' + u, n) : Promise.reject('RNFetchBlob.openDocument only supports IOS.');
  },
  excludeFromBackupKey: function (o) {
    return t.excludeFromBackupKey('file://' + o);
  },
};
