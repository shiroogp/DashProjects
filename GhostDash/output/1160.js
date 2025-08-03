require('./1165');

var ReactNative = require('react-native'),
  module1161 = require('./1161'),
  module1162 = require('./1162'),
  module1163 = require('./1163'),
  f = ReactNative.NativeModules.RNFetchBlob,
  c = {
    DocumentDir: f.DocumentDir,
    CacheDir: f.CacheDir,
    PictureDir: f.PictureDir,
    MusicDir: f.MusicDir,
    MovieDir: f.MovieDir,
    DownloadDir: f.DownloadDir,
    DCIMDir: f.DCIMDir,
    SDCardDir: f.SDCardDir,
    SDCardApplicationDir: f.SDCardApplicationDir,
    MainBundleDir: f.MainBundleDir,
    LibraryDir: f.LibraryDir,
  };

function p(n, t) {
  t.code = n;
  return t;
}

function E(n) {
  return new Promise(function (t, o) {
    if ('string' != typeof n) return o(p('EINVAL', new TypeError('Missing argument "path" ')));
    f.stat(n, function (n, s) {
      if (n) o(new Error(n));
      else {
        if (s) {
          s.size = parseInt(s.size);
          s.lastModified = parseInt(s.lastModified);
        }

        t(s);
      }
    });
  });
}

exports.default = {
  RNFetchBlobSession: module1161.default,
  unlink: function (n) {
    return new Promise(function (t, o) {
      if ('string' != typeof n) return o(p('EINVAL', new TypeError('Missing argument "path" ')));
      f.unlink(n, function (n) {
        if (n) o(p('EUNSPECIFIED', new Error(n)));
        else t();
      });
    });
  },
  mkdir: function (n) {
    return 'string' != typeof n ? Promise.reject(p('EINVAL', new TypeError('Missing argument "path" '))) : f.mkdir(n);
  },
  session: function (n) {
    if (module1161.default.getSession(n)) return new module1161.default(n);
    else {
      module1161.default.setSession(n, []);
      return new module1161.default(n, []);
    }
  },
  ls: function (n) {
    return 'string' != typeof n ? Promise.reject(p('EINVAL', new TypeError('Missing argument "path" '))) : f.ls(n);
  },
  readStream: function (n) {
    var t = arguments.length > 1 && undefined !== arguments[1] ? arguments[1] : 'utf8',
      o = arguments.length > 2 ? arguments[2] : undefined,
      s = arguments.length > 3 && undefined !== arguments[3] ? arguments[3] : 10;
    return 'string' != typeof n ? Promise.reject(p('EINVAL', new TypeError('Missing argument "path" '))) : Promise.resolve(new module1163.default(n, t, o, s));
  },
  mv: function (n, t) {
    return new Promise(function (o, s) {
      if ('string' != typeof n || 'string' != typeof t) return s(p('EINVAL', new TypeError('Missing argument "path" and/or "destination"')));
      f.mv(n, t, function (n, t) {
        if (n) s(p('EUNSPECIFIED', new Error(n)));
        else o(t);
      });
    });
  },
  cp: function (n, t) {
    return new Promise(function (o, s) {
      if ('string' != typeof n || 'string' != typeof t) return s(p('EINVAL', new TypeError('Missing argument "path" and/or "destination"')));
      f.cp(n, t, function (n, t) {
        if (n) s(p('EUNSPECIFIED', new Error(n)));
        else o(t);
      });
    });
  },
  writeStream: function (n) {
    var t = arguments.length > 1 && undefined !== arguments[1] ? arguments[1] : 'utf8',
      o = arguments.length > 2 && undefined !== arguments[2] && arguments[2];
    return 'string' != typeof n
      ? Promise.reject(p('EINVAL', new TypeError('Missing argument "path" ')))
      : new Promise(function (u, c) {
          f.writeStream(n, t, o, function (n, o, f) {
            if (o) {
              var p = new Error(o);
              p.code = n;
              c(p);
            } else u(new module1162.default(f, t));
          });
        });
  },
  writeFile: function (n, t) {
    var o = arguments.length > 2 && undefined !== arguments[2] ? arguments[2] : 'utf8';
    return 'string' != typeof n
      ? Promise.reject(p('EINVAL', new TypeError('Missing argument "path" ')))
      : 'ascii' === o.toLocaleLowerCase()
      ? Array.isArray(t)
        ? f.writeFileArray(n, t, false)
        : Promise.reject(p('EINVAL', new TypeError('"data" must be an Array when encoding is "ascii"')))
      : 'string' != typeof t
      ? Promise.reject(p('EINVAL', new TypeError('"data" must be a String when encoding is "utf8" or "base64", but it is "' + typeof t + '"')))
      : f.writeFile(n, o, t, false);
  },
  appendFile: function (n, t) {
    var o = arguments.length > 2 && undefined !== arguments[2] ? arguments[2] : 'utf8';
    return 'string' != typeof n
      ? Promise.reject(p('EINVAL', new TypeError('Missing argument "path" ')))
      : 'ascii' === o.toLocaleLowerCase()
      ? Array.isArray(t)
        ? f.writeFileArray(n, t, true)
        : Promise.reject(p('EINVAL', new TypeError('`data` of ASCII file must be an array with 0..255 numbers')))
      : 'string' != typeof t
      ? Promise.reject(p('EINVAL'), new TypeError('"data" must be a String when encoding is "utf8" or "base64", but it is "' + typeof t + '"'))
      : f.writeFile(n, o, t, true);
  },
  pathForAppGroup: function (n) {
    return f.pathForAppGroup(n);
  },
  syncPathAppGroup: function (n) {
    return 'ios' === ReactNative.Platform.OS ? f.syncPathAppGroup(n) : '';
  },
  readFile: function (n) {
    var t = arguments.length > 1 && undefined !== arguments[1] ? arguments[1] : 'utf8';
    return 'string' != typeof n ? Promise.reject(p('EINVAL', new TypeError('Missing argument "path" '))) : f.readFile(n, t);
  },
  hash: function (n, t) {
    return 'string' != typeof n || 'string' != typeof t ? Promise.reject(p('EINVAL', new TypeError('Missing argument "path" and/or "algorithm"'))) : f.hash(n, t);
  },
  exists: function (n) {
    return new Promise(function (t, o) {
      if ('string' != typeof n) return o(p('EINVAL', new TypeError('Missing argument "path" ')));

      try {
        f.exists(n, function (n) {
          t(n);
        });
      } catch (n) {
        o(p('EUNSPECIFIED', new Error(n)));
      }
    });
  },
  createFile: function (n, t) {
    var o = arguments.length > 2 && undefined !== arguments[2] ? arguments[2] : 'utf8';
    return 'ascii' === o.toLowerCase()
      ? Array.isArray(t)
        ? f.createFileASCII(n, t)
        : Promise.reject(p('EINVAL', new TypeError('`data` of ASCII file must be an array with 0..255 numbers')))
      : f.createFile(n, t, o);
  },
  isDir: function (n) {
    return new Promise(function (t, o) {
      if ('string' != typeof n) return o(p('EINVAL', new TypeError('Missing argument "path" ')));

      try {
        f.exists(n, function (n, o) {
          t(o);
        });
      } catch (n) {
        o(p('EUNSPECIFIED', new Error(n)));
      }
    });
  },
  stat: E,
  lstat: function (n) {
    return new Promise(function (t, o) {
      if ('string' != typeof n) return o(p('EINVAL', new TypeError('Missing argument "path" ')));
      f.lstat(n, function (n, s) {
        if (n) o(p('EUNSPECIFIED', new Error(n)));
        else t(s);
      });
    });
  },
  scanFile: function (n) {
    return new Promise(function (t, o) {
      if (undefined === n) return o(p('EINVAL', new TypeError('Missing argument')));
      f.scanFile(n, function (n) {
        if (n) o(p('EUNSPECIFIED', new Error(n)));
        else t();
      });
    });
  },
  dirs: c,
  slice: function (n, t, o, s) {
    if ('string' != typeof n || 'string' != typeof t) return reject(p('EINVAL', new TypeError('Missing argument "src" and/or "destination"')));
    var u = Promise.resolve(),
      c = 0;

    function l(n, t) {
      return n < 0 ? 0 ** (t + n) : n || 0 === n ? n : t;
    }

    if (o < 0 || s < 0 || !o || !s)
      u = u
        .then(function () {
          return E(n);
        })
        .then(function (n) {
          c = Math.floor(n.size);
          o = l(o || 0, c);
          s = l(s, c);
        });
    return u.then(function () {
      return f.slice(n, t, o, s);
    });
  },
  asset: function (n) {
    return 'ios' === ReactNative.Platform.OS && /^assets-library\:\/\//.test(n) ? n : 'bundle-assets://' + n;
  },
  df: function () {
    return new Promise(function (n, t) {
      f.df(function (o, s) {
        if (o) t(p('EUNSPECIFIED', new Error(o)));
        else n(s);
      });
    });
  },
};
