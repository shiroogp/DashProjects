module1160.default.RNFetchBlobSession;
module1160.default.createFile;
module1160.default.exists;
module1160.default.mkdir;
module1160.default.writeStream;
module1160.default.ls;
module1160.default.isDir;
module1160.default.mv;
module1160.default.cp;

var module27 = require('./27'),
  ReactNative = require('react-native'),
  module1159 = require('./1159'),
  module1160 = require('./1160'),
  module1164 = require('./1164'),
  module1156 = require('./1156'),
  module1166 = require('./1166'),
  module1178 = require('./1178'),
  module1179 = require('./1179'),
  module1180 = require('./1180'),
  module1181 = require('./1181'),
  w = module1160.default.readStream,
  F = module1160.default.unlink,
  P = module1160.default.session,
  R = module1160.default.readFile,
  B = module1166.default.Blob,
  N = ReactNative.DeviceEventEmitter,
  k = ReactNative.NativeModules.RNFetchBlob;

function S(t) {
  return (t.startsWith('content://') ? 'RNFetchBlob-content://' : 'RNFetchBlob-file://') + t;
}

function E() {
  if (arguments.length > 0 && undefined !== arguments[0]) arguments[0];
  var t = arguments.length > 1 ? arguments[1] : undefined,
    n = arguments.length > 2 ? arguments[2] : undefined,
    o = arguments.length > 3 && undefined !== arguments[3] ? arguments[3] : {};
  if (arguments.length > 4) arguments[4];
  if (!module1159.default.isFileURI(n)) throw 'could not fetch file from an invalid URI : ' + n;
  n = module1159.default.unwrapFileURI(n);
  var ReactNative,
    module1164,
    f = null,
    module1166 = -1,
    p = '',
    b = null;

  switch (t.toLowerCase()) {
    case 'post':
    case 'put':
      break;

    default:
      f = module1160.default
        .stat(n)
        .then(function (t) {
          module1166 = t.size;
          return module1160.default.readStream(n, o.encoding || 'utf8', Math.floor(o.bufferSize) || 409600, Math.floor(o.interval) || 100);
        })
        .then(function (t) {
          return new Promise(function (n, l) {
            t.open();
            b = {
              state: '2',
              headers: {
                source: 'system-fs',
              },
              status: 200,
              respType: 'text',
              rnfbEncode: o.encoding || 'utf8',
            };
            module1164(b);
            t.onData(function (t) {
              if (ReactNative) ReactNative(0, module1166, t);
              if (!o.noCache) p += t;
            });
            t.onError(function (t) {
              l(t);
            });
            t.onEnd(function () {
              n(new C(null, b, p));
            });
          });
        });
  }

  f.progress = function (t) {
    ReactNative = t;
    return f;
  };

  f.stateChange = function (t) {
    module1164 = t;
    return f;
  };

  f.uploadProgress = function (t) {
    t;
    return f;
  };

  return f;
}

function I() {
  var w,
    F = [].concat(args),
    R = F[0],
    S = F[1],
    I = F[2],
    x = F[3];
  if (
    ((I = module1178.default.reduce(
      I,
      function (t, n, o) {
        t[o] = n || '';
        return t;
      },
      {}
    )),
    module1159.default.isFileURI(S))
  )
    return E(f, R, S, I, x);
  var A = new Promise(function (l, c) {
    l;
    w = c;
    var p = Array.isArray(x) ? 'fetchBlobForm' : 'fetchBlob';
    t = N.addListener('RNFetchBlobProgress', function (t) {
      if (t.taskId === u && A.onProgress) A.onProgress(t.written, t.total, t.chunk);
    });
    n = N.addListener('RNFetchBlobProgress-upload', function (t) {
      if (t.taskId === u && A.onUploadProgress) A.onUploadProgress(t.written, t.total);
    });
    o = N.addListener('RNFetchBlobState', function (t) {
      if (t.taskId === u) h = t;
      if (A.onStateChange) A.onStateChange(t);
    });
    t = N.addListener('RNFetchBlobExpire', function (t) {
      if (t.taskId === u && A.onExpire) A.onExpire(t);
    });
    s = N.addListener('RNFetchBlobServerPush', function (t) {
      if (t.taskId === u && A.onPartData) A.onPartData(t.chunk);
    });
    if (x instanceof B && x.isRNFetchBlobPolyfill) x = x.getRNFetchBlobRef();
    k[p](f, u, R, S, I || {}, x, function (p, b, v) {
      t.remove();
      n.remove();
      o.remove();
      s.remove();
      delete A.progress;
      delete A.uploadProgress;
      delete A.stateChange;
      delete A.part;
      delete A.cancel;

      A.cancel = function () {};

      if (p) c(new Error(p, h));
      else {
        if ((f.path || f.fileCache || f.addAndroidDownloads || f.key || (f.auto && 'blob' === h.respType)) && f.session) P(f.session).add(v);
        h.rnfbEncode = b;
        l(new C(u, h, v));
      }
    });
  });

  A.progress = function (...args) {
    if (2 === args.length) {
      t = args[0].interval || t;
      n = args[0].count || n;
      o = args[1];
    } else o = args[0];

    A.onProgress = o;
    k.enableProgressReport(u, t, n);
    return A;
  };

  A.uploadProgress = function (...args) {
    if (2 === args.length) {
      t = args[0].interval || t;
      n = args[0].count || n;
      o = args[1];
    } else o = args[0];

    A.onUploadProgress = o;
    k.enableUploadProgressReport(u, t, n);
    return A;
  };

  A.part = function (t) {
    A.onPartData = t;
    return A;
  };

  A.stateChange = function (t) {
    A.onStateChange = t;
    return A;
  };

  A.expire = function (t) {
    A.onExpire = t;
    return A;
  };

  A.cancel = function (s) {
    s = s || function () {};

    t.remove();
    n.remove();
    o.remove();
    k.cancelRequest(u, s);
    w(new Error('canceled'));
  };

  A.taskId = u;
  return A;
}

if ('ios' === ReactNative.Platform.OS)
  ReactNative.AppState.addEventListener('change', function (t) {
    if ('active' === t) k.emitExpiredEvent(function () {});
  });
N.addListener('RNFetchBlobMessage', function (t) {
  if ('warn' === t.event) console.warn(t.detail);
  else {
    if ('error' === t.event) throw t.detail;
    console.log('RNFetchBlob native message', t.detail);
  }
});
if (!(k && k.fetchBlobForm && k.fetchBlob))
  console.warn(
    'rn-fetch-blob could not find valid native module.',
    'please make sure you have linked native modules using `rnpm link`,',
    'and restart RN packager or manually compile IOS/Android project.'
  );
var C = module28.default(function t(n, s, l) {
  var c = this;
  module27.default(this, t);
  this.data = l;
  this.taskId = n;
  this.type = s.rnfbEncode;
  this.respInfo = s;

  this.info = function () {
    return c.respInfo;
  };

  this.array = function () {
    if (!s.headers['Content-Type']) s.headers['content-type'];
    return new Promise(function (t, n) {
      switch (c.type) {
        case 'base64':
          break;

        case 'path':
          module1160.default.readFile(c.data, 'ascii').then(t);
      }
    });
  };

  this.blob = function () {
    var t = module1166.default.Blob,
      n = s.headers['Content-Type'] || s.headers['content-type'];
    return new Promise(function (o, s) {
      switch (c.type) {
        case 'base64':
          t.build(c.data, {
            type: n + ';BASE64',
          }).then(o);
          break;

        case 'path':
          module1166.default.Blob.build(S(c.data), {
            type: n,
          }).then(o);
          break;

        default:
          module1166.default.Blob.build(c.data, {
            type: 'text/plain',
          }).then(o);
      }
    });
  };

  this.text = function () {
    c.data;

    switch (c.type) {
      case 'base64':
        return module1156.default.decode(c.data);

      case 'path':
        return module1160.default.readFile(c.data, 'base64').then(function (t) {
          return Promise.resolve(module1156.default.decode(t));
        });

      default:
        return c.data;
    }
  };

  this.json = function () {
    switch (c.type) {
      case 'base64':
        return JSON.parse(module1156.default.decode(c.data));

      case 'path':
        return module1160.default.readFile(c.data, 'utf8').then(function (t) {
          return Promise.resolve(JSON.parse(t));
        });

      default:
        return JSON.parse(c.data);
    }
  };

  this.base64 = function () {
    switch (c.type) {
      case 'base64':
        return c.data;

      case 'path':
        return module1160.default.readFile(c.data, 'base64');

      default:
        return module1156.default.encode(c.data);
    }
  };

  this.flush = function () {
    var t = c.path();
    if (t && 'path' === c.type) return F(t);
  };

  this.path = function () {
    return 'path' === c.type ? c.data : null;
  };

  this.session = function (t) {
    if ('path' === c.type) return P(t).add(c.data);
    else {
      console.warn('only file paths can be add into session.');
      return null;
    }
  };

  this.readStream = function (t) {
    if ('path' === c.type) return w(c.data, t);
    else {
      console.warn('RNFetchblob', 'this response data does not contains any available stream');
      return null;
    }
  };

  this.readFile = function (t) {
    if ('path' === c.type) return R(c.data, t);
    else {
      console.warn('RNFetchblob', 'this response does not contains a readable file');
      return null;
    }
  };
});
exports.default = {
  fetch: I,
  base64: module1156.default,
  android: module1179.default,
  ios: module1180.default,
  config: function (t) {
    return {
      fetch: I.bind(t),
    };
  },
  session: P,
  fs: module1160.default,
  wrap: S,
  polyfill: module1166.default,
  JSONStream: module1181.default,
};
