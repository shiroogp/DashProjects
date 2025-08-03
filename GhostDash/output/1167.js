var module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module1158 = require('./1158'),
  module1160 = require('./1160'),
  module1164 = require('./1164'),
  module1168 = require('./1168'),
  module1169 = require('./1169');

function _() {
  if ('undefined' == typeof Reflect || !Reflect.construct) return false;
  if (Reflect.construct.sham) return false;
  if ('function' == typeof Proxy) return true;

  try {
    Boolean.prototype.valueOf.call(Reflect.construct(Boolean, [], function () {}));
    return true;
  } catch (t) {
    return false;
  }
}

var p = new module1168.default('Blob'),
  B = module1160.default.dirs.DocumentDir + '/RNFetchBlob-blobs/';
p.disable();

exports.default = (function (t) {
  module38.default(y, t);

  var module23 = y,
    module1164 = _(),
    v = function () {
      var t,
        o = module37.default(module23);

      if (module1164) {
        var l = module37.default(this).constructor;
        t = Reflect.construct(o, arguments, l);
      } else t = o.apply(this, arguments);

      return module40.default(this, t);
    };

  function y(t, n, l) {
    var f;
    module27.default(this, y);
    (f = v.call(this)).isRNFetchBlobPolyfill = true;
    f.multipartBoundary = null;
    f._ref = null;
    f._blobCreated = false;
    f._onCreated = [];
    f._closed = false;
    n = n || {};
    f.cacheName = k();
    f.isRNFetchBlobPolyfill = true;
    f.isDerived = l;
    f.type = n.type || 'text/plain';
    p.verbose('Blob constructor called', 'mime', f.type, 'type', typeof t, 'length', t ? t.length : 0);
    f._ref = B + f.cacheName;
    var s = null;

    if ((t || (t = ''), t.isRNFetchBlobPolyfill)) {
      p.verbose('create Blob cache file from Blob object');
      f._ref = String(t.getRNFetchBlobRef());
      var c = f._ref;
      s = module1160.default.exists(c).then(function (n) {
        if (n)
          return module1160.default
            .writeFile(c, t, 'uri')
            .then(function (t) {
              return Promise.resolve(t);
            })
            .catch(function (t) {
              throw 'RNFetchBlob Blob file creation error, ' + t;
            });
        throw 'could not create Blob from path ' + c + ', file not exists';
      });
    } else if (t instanceof FormData) {
      p.verbose('create Blob cache file from FormData', t);
      var b = 'RNFetchBlob-' + f.cacheName + '-' + Date.now();
      f.multipartBoundary = b;

      var _ = t.getParts(),
        w = [];

      if (_) {
        for (var R in _) {
          w.push('\r\n--' + b + '\r\n');
          var P = _[R];

          for (var C in P.headers) w.push(C + ': ' + P.headers[C] + '\r\n');

          w.push('\r\n');
          if (P.isRNFetchBlobPolyfill) w.push(P);
          else w.push(P.string);
        }

        p.verbose('FormData array', w);
        w.push('\r\n--' + b + '--\r\n');
        s = F(f._ref, w);
      } else s = module1160.default.writeFile(f._ref, '', 'utf8');
    } else if ('string' == typeof t && t.startsWith('RNFetchBlob-file://')) {
      p.verbose('create Blob cache file from file path', t);
      f._isReference = true;
      f._ref = String(t).replace('RNFetchBlob-file://', '');
      var N = f._ref;
      if (l) return module40.default(f);
      s = module1160.default.stat(N).then(function (t) {
        return Promise.resolve(t.size);
      });
    } else if ('string' == typeof t) {
      var D = 'utf8',
        x = String(f.type);
      if (/(application\/octet|\;base64)/i.test(x)) D = 'base64';
      else t = t.toString();
      f.type = String(f.type).replace(/;base64/gi, '');
      p.verbose('create Blob cache file from string', 'encode', D);
      s = module1160.default.writeFile(f._ref, t, D).then(function (t) {
        return Promise.resolve(t);
      });
    } else
      Array.isArray(t)
        ? (p.verbose('create Blob cache file from mixed array', t), (s = F(f._ref, t)))
        : ((t = t.toString()),
          (s = module1160.default.writeFile(f._ref, t, 'utf8').then(function (t) {
            return Promise.resolve(t);
          })));

    if (s)
      s.then(function (t) {
        f.size = t;

        f._invokeOnCreateEvent();
      }).catch(function (t) {
        p.error('RNFetchBlob could not create Blob : ' + f._ref, t);
      });
    return f;
  }

  module28.default(
    y,
    [
      {
        key: 'blobPath',
        get: function () {
          return this._ref;
        },
      },
      {
        key: 'onCreated',
        value: function (t) {
          p.verbose('#register blob onCreated', this._blobCreated);
          if (this._blobCreated) t(this);
          else this._onCreated.push(t);
          return this;
        },
      },
      {
        key: 'markAsDerived',
        value: function () {
          this._isDerived = true;
        },
      },
      {
        key: 'isDerived',
        get: function () {
          return this._isDerived || false;
        },
      },
      {
        key: 'getRNFetchBlobRef',
        value: function () {
          return this._ref;
        },
      },
      {
        key: 'slice',
        value: function (t, n) {
          var o = this,
            l = arguments.length > 2 && undefined !== arguments[2] ? arguments[2] : '';
          if (this._closed) throw 'Blob has been released.';
          p.verbose('slice called', t, n, l);
          var f = B + k();
          p.debug('fs.slice new blob will at', f);
          var u = new y(
            module1158.default.wrap(f),
            {
              type: l,
            },
            true
          );
          module1160.default
            .exists(B)
            .then(function (t) {
              return t ? Promise.resolve() : module1160.default.mkdir(B);
            })
            .then(function () {
              return module1160.default.slice(o._ref, f, t, n);
            })
            .then(function (t) {
              p.debug('fs.slice done', t);

              u._invokeOnCreateEvent();

              true;
            })
            .catch(function (t) {
              console.warn('Blob.slice failed:', t);
              true;
            });
          p.debug('slice returning new Blob');
          return u;
        },
      },
      {
        key: 'readBlob',
        value: function (t) {
          if (this._closed) throw 'Blob has been released.';
          return module1160.default.readFile(this._ref, t || 'utf8');
        },
      },
      {
        key: 'close',
        value: function () {
          if (this._closed) return Promise.reject('Blob has been released.');
          else {
            this._closed = true;
            return module1160.default.unlink(this._ref).catch(function (t) {
              console.warn(t);
            });
          }
        },
      },
      {
        key: 'safeClose',
        value: function () {
          if (this._closed) return Promise.reject('Blob has been released.');
          else {
            this._closed = true;
            return this._isReference
              ? Promise.resolve()
              : module1160.default.unlink(this._ref).catch(function (t) {
                  console.warn(t);
                });
          }
        },
      },
      {
        key: '_invokeOnCreateEvent',
        value: function () {
          p.verbose('invoke create event', this._onCreated);
          this._blobCreated = true;
          var t = this._onCreated;

          for (var n in t) 'function' == typeof t[n] && t[n](this);

          delete this._onCreated;
        },
      },
    ],
    [
      {
        key: 'clearCache',
        value: function () {
          return module1160.default.unlink(B).then(function () {
            return module1160.default.mkdir(B);
          });
        },
      },
      {
        key: 'build',
        value: function (t, n) {
          return new Promise(function (o, l) {
            new y(t, n).onCreated(o);
          });
        },
      },
      {
        key: 'setLog',
        value: function (t) {
          if (-1 === t) p.disable();
          else p.level(t);
        },
      },
    ]
  );
  return y;
})(module1169.default);

function k() {
  return 'blob-' + module1164.default();
}

function F(t, o) {
  var l = module1160.default.writeFile(t, ''),
    f = [],
    u = 0;

  for (var s in o) {
    var c = o[s];
    if (c) c.isRNFetchBlobPolyfill ? f.push([t, c._ref, 'uri']) : 'string' == typeof c ? f.push([t, c, 'utf8']) : Array.isArray(c) && f.push([t, c, 'ascii']);
  }

  var b = function (t) {
    l = l.then(
      function (o) {
        if (o) u += o;
        p.verbose('mixed blob write', f[t], o);
        return module1160.default.appendFile.apply(module1160.default, module23.default(this));
      }.bind(f[t])
    );
  };

  for (var v in f) b(v);

  return l.then(function () {
    return Promise.resolve(u);
  });
}
