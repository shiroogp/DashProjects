require('./1160');

require('./1177');

var module14 = require('./14'),
  module27 = require('./27'),
  module1158 = require('./1158'),
  module1168 = require('./1168'),
  module1167 = require('./1167'),
  h = new module1168.default('FetchPolyfill');

h.disable();
exports.default = module28.default(function t(n) {
  module27.default(this, t);
  module14.default(this, new c(n));
});

var c = module28.default(function t(s) {
    module27.default(this, t);

    this.build = function () {
      return function (t) {
        var n = arguments.length > 1 && undefined !== arguments[1] ? arguments[1] : {},
          o = n.body,
          u = Promise.resolve(),
          c = null;
        n.headers = n.headers || {};
        var p,
          v,
          y,
          R = n['Content-Type'] || n['content-type'],
          P = n.headers['Content-Type'] || n.headers['content-type'];
        n.headers['Content-Type'] = R || P;
        n.headers['content-type'] = R || P;
        n.method = n.method || 'GET';
        if (o)
          o instanceof FormData
            ? (h.verbose('convert FormData to blob body'),
              (u = module1167.default.build(o).then(function (t) {
                c = t;
                n.headers['Content-Type'] = 'multipart/form-data;boundary=' + t.multipartBoundary;
                return Promise.resolve(module1158.default.wrap(t._ref));
              })))
            : (u = o.isRNFetchBlobPolyfill
                ? Promise.resolve(module1158.default.wrap(o.blobPath))
                : 'object' != typeof o && 'application/json' !== n.headers['Content-Type']
                ? Promise.resolve(JSON.stringify(o))
                : 'string' != typeof o
                ? Promise.resolve(o.toString())
                : Promise.resolve(o));
        var w = u.then(function (o) {
          var u = module1158.default.config(s).fetch(n.method, t, n.headers, o);
          if (p) u.progress(p);
          if (v) u.uploadProgress(v);
          if (y) u.cancel();
          return u.then(function (t) {
            h.verbose('response', t);
            if (null !== c && c instanceof module1167.default) c.close();
            return Promise.resolve(new b(t));
          });
        });

        w.progress = function (t) {
          p = t;
        };

        w.uploadProgress = function (t) {
          v = t;
        };

        w.cancel = function () {
          y = true;
          if (task.cancel) task.cancel();
        };

        return w;
      };
    };
  }),
  b = (function () {
    function t(s) {
      module27.default(this, t);
      var n = s.info();
      this.headers = n.headers;
      this.ok = n.status >= 200 && n.status <= 299;
      this.status = n.status;
      this.type = 'basic';
      this.bodyUsed = false;
      this.resp = s;
      this.rnfbRespInfo = n;
      this.rnfbResp = s;
    }

    module28.default(t, [
      {
        key: 'rawResp',
        value: function () {
          return Promise.resolve(this.rnfbResp);
        },
      },
      {
        key: 'arrayBuffer',
        value: function () {
          h.verbose('to arrayBuffer', this.rnfbRespInfo);
          this.bodyUsed = true;
          return p(this.rnfbResp, this.rnfbRespInfo);
        },
      },
      {
        key: 'text',
        value: function () {
          h.verbose('to text', this.rnfbResp, this.rnfbRespInfo);
          this.bodyUsed = true;
          return v(this.rnfbResp, this.rnfbRespInfo);
        },
      },
      {
        key: 'json',
        value: function () {
          h.verbose('to json', this.rnfbResp, this.rnfbRespInfo);
          this.bodyUsed = true;
          return R(this.rnfbResp, this.rnfbRespInfo);
        },
      },
      {
        key: 'blob',
        value: function () {
          h.verbose('to blob', this.rnfbResp, this.rnfbRespInfo);
          this.bodyUsed = true;
          return y(this.rnfbResp, this.rnfbRespInfo);
        },
      },
    ]);
    return t;
  })();

function p(t, s) {
  switch (s.rnfbEncode) {
    case 'path':
      return t.readFile('ascii');

    default:
      var n = [],
        o = t.text();

      for (var f in o) n[f] = o.charCodeAt(f);

      return Promise.resolve(n);
  }
}

function v(t, s) {
  switch (s.rnfbEncode) {
    case 'base64':
      return Promise.resolve(t.text());

    case 'path':
      return t.text();

    default:
      return Promise.resolve(t.text());
  }
}

function y(t, s) {
  h.verbose('readBlob', t, s);
  return t.blob();
}

function R(t, s) {
  switch ((h.verbose('readJSON', t, s), s.rnfbEncode)) {
    case 'base64':
      return Promise.resolve(t.json());

    case 'path':
      return t.json();

    default:
      return Promise.resolve(t.json());
  }
}
