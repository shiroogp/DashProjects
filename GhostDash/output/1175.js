require('./1173');

require('./1167');

var module27 = require('./27'),
  module35 = require('./35'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module1169 = require('./1169'),
  module1168 = require('./1168');

require('./1160');

function v() {
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

var h = new module1168.default('FileReader');
h.level(3);

exports.default = (function (t) {
  module38.default(k, t);

  var module1169 = k,
    module1168 = v(),
    p = function () {
      var t,
        n = module37.default(module1169);

      if (module1168) {
        var u = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, u);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function k() {
    var t;
    module27.default(this, k);
    (t = p.call(this))._readState = 0;
    h.verbose('file reader const');
    t._result = null;
    return t;
  }

  module28.default(
    k,
    [
      {
        key: 'isRNFBPolyFill',
        get: function () {
          return true;
        },
      },
      {
        key: 'abort',
        value: function () {
          h.verbose('abort');
        },
      },
      {
        key: 'readAsArrayBuffer',
        value: function (t) {
          h.verbose('readAsArrayBuffer', t);
        },
      },
      {
        key: 'readAsBinaryString',
        value: function (t) {
          h.verbose('readAsBinaryString', t);
        },
      },
      {
        key: 'readAsText',
        value: function (t, n) {
          h.verbose('readAsText', t, n);
        },
      },
      {
        key: 'readAsDataURL',
        value: function (t) {
          h.verbose('readAsDataURL', t);
        },
      },
      {
        key: 'dispatchEvent',
        value: function (t, n) {
          h.verbose('dispatch event', t, n);
          module35.default(module37.default(k.prototype), 'dispatchEvent', this).call(this, t, n);
          if ('function' == typeof this['on' + t]) this['on' + t](n);
        },
      },
      {
        key: 'readyState',
        get: function () {
          return this._readyState;
        },
      },
      {
        key: 'result',
        get: function () {
          return this._result;
        },
      },
    ],
    [
      {
        key: 'EMPTY',
        get: function () {
          return 0;
        },
      },
      {
        key: 'LOADING',
        get: function () {
          return 1;
        },
      },
      {
        key: 'DONE',
        get: function () {
          return 2;
        },
      },
    ]
  );
  return k;
})(module1169.default);
