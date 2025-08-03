var module27 = require('./27'),
  module42 = require('./42'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module1158 = require('./1158'),
  module1172 = require('./1172'),
  module1168 = require('./1168'),
  module1167 = require('./1167'),
  module1173 = require('./1173'),
  module1159 = require('./1159');

function b() {
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

var E = new module1168.default('XMLHttpRequest');
E.disable();
var R = 0;
(exports.default = (function (t) {
  module38.default(S, t);

  var module1168 = S,
    k = b(),
    T = function () {
      var t,
        s = module37.default(module1168);

      if (k) {
        var n = module37.default(this).constructor;
        t = Reflect.construct(s, arguments, n);
      } else t = s.apply(this, arguments);

      return module40.default(this, t);
    };

  function S() {
    var t;
    module27.default(this, S);
    E.verbose('XMLHttpRequest constructor called');
    (t = T.call(this)).upload = new module1172.default();
    t._readyState = R;
    t._uriType = 'net';
    t._response = '';
    t._responseText = '';
    t._responseHeaders = {};
    t._responseType = '';
    t._responseURL = '';
    t._responseXML = '';
    t._status = 0;
    t._statusText = '';
    t._timeout = 6e4;
    t._sendFlag = false;
    t._uploadStarted = false;
    t._increment = false;
    t._config = {};
    t._headers = {
      'Content-Type': 'text/plain',
    };
    t._cleanUp = null;

    t._headerReceived = function (s) {
      E.debug('header received ', t._task.taskId, s);
      t.responseURL = t._url;

      if ('2' === s.state && s.taskId === t._task.taskId) {
        t._responseHeaders = s.headers;
        t._statusText = s.status;
        t._status = Math.floor(s.status);

        t._dispatchReadStateChange(S.HEADERS_RECEIVED);
      }
    };

    t._uploadProgressEvent = function (s, n) {
      if (!t._uploadStarted) {
        t.upload.dispatchEvent('loadstart');
        t._uploadStarted = true;
      }

      if (s >= n) t.upload.dispatchEvent('load');
      t.upload.dispatchEvent('progress', new module1173.default(true, s, n));
    };

    t._progressEvent = function (s, n, o) {
      E.verbose(t.readyState);
      if (t._readyState === S.HEADERS_RECEIVED) t._dispatchReadStateChange(S.LOADING);
      var u = false;
      if (n && n >= 0) u = true;
      var p = new module1173.default(u, s, n);
      if (t._increment) t._responseText += o;
      t.dispatchEvent('progress', p);
    };

    t._onError = function (s) {
      var n = Math.floor(t.status);

      if (!(n >= 100 && 408 !== n)) {
        E.debug('XMLHttpRequest error', s);
        t._statusText = s;
        t._status = String(s).match(/\d+/);
        t._status = t._status ? Math.floor(t.status) : 404;

        t._dispatchReadStateChange(S.DONE);

        if ((s && String(s.message).match(/(timed\sout|timedout)/)) || 408 == t._status) t.dispatchEvent('timeout');
        t.dispatchEvent('loadend');
        t.dispatchEvent('error', {
          type: 'error',
          detail: s,
        });
        t.clearEventListeners();
      }
    };

    t._onDone = function (s) {
      E.debug('XMLHttpRequest done', t._url, s, module42.default(t));
      t._statusText = t._status;

      var n = function () {
        E.debug('request done state = 4');
        t.dispatchEvent('load');
        t.dispatchEvent('loadend');

        t._dispatchReadStateChange(S.DONE);

        t.clearEventListeners();
      };

      if (s) {
        var u = s.respInfo || {};

        switch ((E.debug(t._url, u, u.respType), t._responseType)) {
          case 'blob':
            s.blob().then(function (o) {
              t._responseText = s.text();
              t._response = o;
              n();
            });
            break;

          case 'arraybuffer':
            break;

          case 'json':
            t._response = s.json();
            t._responseText = s.text();
            break;

          default:
            t._responseText = s.text();
            t._response = t.responseText;
            n();
        }
      }
    };

    return t;
  }

  module28.default(
    S,
    [
      {
        key: 'UNSENT',
        get: function () {
          return R;
        },
      },
      {
        key: 'OPENED',
        get: function () {
          return 1;
        },
      },
      {
        key: 'HEADERS_RECEIVED',
        get: function () {
          return 2;
        },
      },
      {
        key: 'LOADING',
        get: function () {
          return 3;
        },
      },
      {
        key: 'DONE',
        get: function () {
          return 4;
        },
      },
      {
        key: 'open',
        value: function (t, s, n, o, u) {
          E.verbose('XMLHttpRequest open ', t, s, n, o, u);
          this._method = t;
          this._url = s;
          this._headers = {};
          this._increment = module1159.default.isJSONStreamURI(this._url);
          this._url = this._url.replace(/^JSONStream\:\/\//, '');

          this._dispatchReadStateChange(S.OPENED);
        },
      },
      {
        key: 'send',
        value: function (t) {
          var s = this;
          if (((this._body = t), this._readyState !== S.OPENED)) throw 'InvalidStateError : XMLHttpRequest is not opened yet.';
          var n = Promise.resolve();
          this._sendFlag = true;
          E.verbose('XMLHttpRequest send ', t);
          var o = this._method,
            u = this._url,
            p = this._headers;
          E.verbose('sending request with args', o, u, p, t);
          E.verbose(typeof t, t instanceof FormData);

          if (t instanceof module1167.default) {
            E.debug('sending blob body', t._blobCreated);
            n = new Promise(function (n, o) {
              t.onCreated(function (o) {
                if (o.isDerived)
                  s._cleanUp = function () {
                    o.close();
                  };
                E.debug('body created send request');
                t = module1158.default.wrap(o.getRNFetchBlobRef());
                n();
              });
            });
          } else if ('object' == typeof t) {
            t = JSON.stringify(t);
            n = Promise.resolve();
          } else {
            t = t ? t.toString() : t;
            n = Promise.resolve();
          }

          n.then(function () {
            for (var n in (E.debug('send request invoke', t), p)) p[n] = p[n].toString();

            s._task = module1158.default
              .config({
                auto: true,
                timeout: s._timeout,
                increment: s._increment,
                binaryContentTypes: S.binaryContentTypes,
              })
              .fetch(o, u, p, t);

            s._task.stateChange(s._headerReceived).uploadProgress(s._uploadProgressEvent).progress(s._progressEvent).catch(s._onError).then(s._onDone);
          });
        },
      },
      {
        key: 'overrideMimeType',
        value: function (t) {
          E.verbose('XMLHttpRequest overrideMimeType', t);
          this._headers['Content-Type'] = t;
        },
      },
      {
        key: 'setRequestHeader',
        value: function (t, s) {
          if ((E.verbose('XMLHttpRequest set header', t, s), 1 !== this._readyState || this._sendFlag))
            throw 'InvalidStateError : Calling setRequestHeader in wrong state  ' + this._readyState;
          if ('string' != typeof t || /[^\u0000-\u00ff]/.test(t)) throw 'TypeError : header field name should be a string';

          for (var n = 0, o = [/[\(\)\>\<\@\,\:\\\/\[\]\?\=\}\{\s\ \u007f\;\t\0\v\r]/, /tt/]; n < o.length; n++) {
            if (o[n].test(t) || 'string' != typeof t) throw 'SyntaxError : Invalid header field name ' + t;
          }

          this._headers[t] = s;
        },
      },
      {
        key: 'abort',
        value: function () {
          var t = this;
          E.verbose('XMLHttpRequest abort ');
          if (this._task)
            this._task.cancel(function (s) {
              var n = {
                timeStamp: Date.now(),
              };
              if (t.onabort) t.onabort();

              if (s) {
                n.detail = s;
                n.type = 'error';
                t.dispatchEvent('error', n);
              } else {
                n.type = 'abort';
                t.dispatchEvent('abort', n);
              }
            });
        },
      },
      {
        key: 'getResponseHeader',
        value: function (t) {
          E.verbose('XMLHttpRequest get header', t, this._responseHeaders);
          return this._responseHeaders ? this._responseHeaders[t] || this._responseHeaders[t.toLowerCase()] : null;
        },
      },
      {
        key: 'getAllResponseHeaders',
        value: function () {
          if ((E.verbose('XMLHttpRequest get all headers', this._responseHeaders), !this._responseHeaders)) return '';
          var t = '',
            s = this.responseHeaders;

          for (var n in s) t += n + ': ' + s[n] + String.fromCharCode(13, 10);

          return t.substr(0, t.length - 2);
        },
      },
      {
        key: '_dispatchReadStateChange',
        value: function (t) {
          this._readyState = t;
          if ('function' == typeof this._onreadystatechange) this._onreadystatechange();
        },
      },
      {
        key: 'onreadystatechange',
        get: function () {
          return this._onreadystatechange;
        },
        set: function (t) {
          E.verbose('XMLHttpRequest set onreadystatechange', t);
          this._onreadystatechange = t;
        },
      },
      {
        key: 'readyState',
        get: function () {
          E.verbose('get readyState', this._readyState);
          return this._readyState;
        },
      },
      {
        key: 'status',
        get: function () {
          E.verbose('get status', this._status);
          return this._status;
        },
      },
      {
        key: 'statusText',
        get: function () {
          E.verbose('get statusText', this._statusText);
          return this._statusText;
        },
      },
      {
        key: 'response',
        get: function () {
          E.verbose('get response', this._response);
          return this._response;
        },
      },
      {
        key: 'responseText',
        get: function () {
          E.verbose('get responseText', this._responseText);
          return this._responseText;
        },
      },
      {
        key: 'responseURL',
        get: function () {
          E.verbose('get responseURL', this._responseURL);
          return this._responseURL;
        },
      },
      {
        key: 'responseHeaders',
        get: function () {
          E.verbose('get responseHeaders', this._responseHeaders);
          return this._responseHeaders;
        },
      },
      {
        key: 'timeout',
        get: function () {
          E.verbose('get timeout', this._timeout);
          return this._timeout;
        },
        set: function (t) {
          this._timeout = 1e3 * t;
          E.verbose('set timeout', this._timeout);
        },
      },
      {
        key: 'responseType',
        get: function () {
          E.verbose('get response type', this._responseType);
          return this._responseType;
        },
        set: function (t) {
          E.verbose('set response type', this._responseType);
          this._responseType = t;
        },
      },
    ],
    [
      {
        key: 'UNSENT',
        get: function () {
          return R;
        },
      },
      {
        key: 'OPENED',
        get: function () {
          return 1;
        },
      },
      {
        key: 'HEADERS_RECEIVED',
        get: function () {
          return 2;
        },
      },
      {
        key: 'LOADING',
        get: function () {
          return 3;
        },
      },
      {
        key: 'DONE',
        get: function () {
          return 4;
        },
      },
      {
        key: 'setLog',
        value: function (t) {
          if (-1 === t) E.disable();
          else E.level(t);
        },
      },
      {
        key: 'addBinaryContentType',
        value: function (t) {
          for (var s in S.binaryContentTypes) if (new RegExp(t, 'i').test(S.binaryContentTypes[s])) return;

          S.binaryContentTypes.push(t);
        },
      },
      {
        key: 'removeBinaryContentType',
        value: function (t) {
          for (var s in S.binaryContentTypes) if (new RegExp(substr, 'i').test(S.binaryContentTypes[s])) return void S.binaryContentTypes.splice(s, 1);
        },
      },
      {
        key: 'isRNFBPolyfill',
        get: function () {
          return true;
        },
      },
    ]
  );
  return S;
})(module1172.default)).binaryContentTypes = ['image/', 'video/', 'audio/'];
