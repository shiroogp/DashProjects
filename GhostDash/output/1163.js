var module27 = require('./27'),
  ReactNative = require('react-native'),
  module1164 = require('./1164'),
  f = ReactNative.NativeModules.RNFetchBlob,
  u = ReactNative.DeviceEventEmitter;

exports.default = (function () {
  function t(o, s, f, c) {
    var l = this;
    if ((module27.default(this, t), (this.tick = 10), !o)) throw Error('RNFetchBlob could not open file stream with empty `path`');
    this.encoding = s || 'utf8';
    this.bufferSize = f;
    this.path = o;
    this.closed = false;
    this.tick = c;

    this._onData = function () {};

    this._onEnd = function () {};

    this._onError = function () {};

    this.streamId = 'RNFBRS' + module1164.default();
    var E = u.addListener(this.streamId, function (t) {
      var n = t.event,
        o = t.code,
        s = t.detail;
      if (l._onData && 'data' === n) l._onData(s);
      else {
        if (l._onEnd && 'end' === n) l._onEnd(s);
        else {
          var h = new Error(s);
          if (((h.code = o || 'EUNSPECIFIED'), !l._onError)) throw h;

          l._onError(h);
        }

        if (!('error' !== n && 'end' !== n)) {
          E.remove();
          l.closed = true;
        }
      }
    });
  }

  module28.default(t, [
    {
      key: 'open',
      value: function () {
        if (this.closed) throw new Error('Stream closed');
        f.readStream(this.path, this.encoding, this.bufferSize || 10240, this.tick || -1, this.streamId);
      },
    },
    {
      key: 'onData',
      value: function (t) {
        this._onData = t;
      },
    },
    {
      key: 'onError',
      value: function (t) {
        this._onError = t;
      },
    },
    {
      key: 'onEnd',
      value: function (t) {
        this._onEnd = t;
      },
    },
  ]);
  return t;
})();
