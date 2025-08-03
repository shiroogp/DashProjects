exports.default = {
  isFileURI: function (t) {
    return 'string' == typeof t && /^RNFetchBlob-file\:\/\//.test(t);
  },
  isJSONStreamURI: function (t) {
    return 'string' == typeof t && /^JSONStream\:\/\//.test(t);
  },
  removeURIScheme: function (t, n) {
    n = n || 1;

    for (var o = t, u = 0; u < n; u++) o = String(o).replace(/^[^\:]+\:\/\//, '');

    return String(o);
  },
  unwrapFileURI: function (t) {
    return String(t).replace(/^RNFetchBlob-file\:\/\//, '');
  },
};
