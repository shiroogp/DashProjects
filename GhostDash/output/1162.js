var module27 = require('./27'),
  ReactNative = require('react-native').NativeModules.RNFetchBlob;

exports.default = (function () {
  function n(o, u, c) {
    module27.default(this, n);
    this.id = o;
    this.encoding = u;
    this.append = c;
  }

  module28.default(n, [
    {
      key: 'write',
      value: function (n) {
        var t = this;
        return new Promise(function (o, c) {
          try {
            var s = 'ascii' === t.encoding ? 'writeArrayChunk' : 'writeChunk';
            if ('ascii' === t.encoding.toLocaleLowerCase() && !Array.isArray(n)) return void c(new Error('ascii input data must be an Array'));
            ReactNative[s](t.id, n, function (n) {
              if (n) c(new Error(n));
              else o(t);
            });
          } catch (n) {
            c(new Error(n));
          }
        });
      },
    },
    {
      key: 'close',
      value: function () {
        var n = this;
        return new Promise(function (t, o) {
          try {
            ReactNative.closeStream(n.id, function () {
              t();
            });
          } catch (n) {
            o(new Error(n));
          }
        });
      },
    },
  ]);
  return n;
})();
