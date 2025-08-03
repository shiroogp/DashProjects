var module27 = require('./27'),
  module35 = require('./35'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module1169 = require('./1169');

function h() {
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

var module1168 = new (require('./1168').default)('XMLHttpRequestEventTarget');
module1168.disable();

exports.default = (function (t) {
  module38.default(y, t);

  var module1169 = y,
    p = h(),
    b = function () {
      var t,
        o = module37.default(module1169);

      if (p) {
        var n = module37.default(this).constructor;
        t = Reflect.construct(o, arguments, n);
      } else t = o.apply(this, arguments);

      return module40.default(this, t);
    };

  function y() {
    var t;
    module27.default(this, y);

    (t = b.call(this))._onabort = function () {};

    t._onerror = function () {};

    t._onload = function () {};

    t._onloadstart = function () {};

    t._onprogress = function () {};

    t._ontimeout = function () {};

    t._onloadend = function () {};

    module1168.info('constructor called');
    return t;
  }

  module28.default(y, [
    {
      key: 'dispatchEvent',
      value: function (t, o) {
        switch ((module1168.debug('dispatch event', t, o), module35.default(module37.default(y.prototype), 'dispatchEvent', this).call(this, t, o), t)) {
          case 'abort':
            this._onabort(o);

            break;

          case 'error':
            this._onerror(o);

            break;

          case 'load':
            this._onload(o);

            break;

          case 'loadstart':
            this._onloadstart(o);

            break;

          case 'loadend':
            this._onloadend(o);

            break;

          case 'progress':
            this._onprogress(o);

            break;

          case 'timeout':
            this._ontimeout(o);
        }
      },
    },
    {
      key: 'onabort',
      get: function () {
        return this._onabort;
      },
      set: function (t) {
        module1168.info('set onabort');
        this._onabort = t;
      },
    },
    {
      key: 'onerror',
      get: function () {
        return this._onerror;
      },
      set: function (t) {
        module1168.info('set onerror');
        this._onerror = t;
      },
    },
    {
      key: 'onload',
      get: function () {
        return this._onload;
      },
      set: function (t) {
        module1168.info('set onload', t);
        this._onload = t;
      },
    },
    {
      key: 'onloadstart',
      get: function () {
        return this._onloadstart;
      },
      set: function (t) {
        module1168.info('set onloadstart');
        this._onloadstart = t;
      },
    },
    {
      key: 'onprogress',
      get: function () {
        return this._onprogress;
      },
      set: function (t) {
        module1168.info('set onprogress');
        this._onprogress = t;
      },
    },
    {
      key: 'ontimeout',
      get: function () {
        return this._ontimeout;
      },
      set: function (t) {
        module1168.info('set ontimeout');
        this._ontimeout = t;
      },
    },
    {
      key: 'onloadend',
      get: function () {
        return this._onloadend;
      },
      set: function (t) {
        module1168.info('set onloadend');
        this._onloadend = t;
      },
    },
  ]);
  return y;
})(module1169.default);
