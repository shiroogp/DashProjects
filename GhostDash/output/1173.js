var module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module1174 = require('./1174');

function s() {
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

exports.default = (function (t) {
  module38.default(p, t);

  var module1174 = p,
    h = s(),
    _ = function () {
      var t,
        n = module37.default(module1174);

      if (h) {
        var u = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, u);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function p(t, u, l) {
    var o;
    module27.default(this, p);
    (o = _.call(this))._lengthComputable = false;
    o._loaded = -1;
    o._total = -1;
    o._lengthComputable = t;
    o._loaded = u;
    o._total = l;
    return o;
  }

  module28.default(p, [
    {
      key: 'lengthComputable',
      get: function () {
        return this._lengthComputable;
      },
    },
    {
      key: 'loaded',
      get: function () {
        return this._loaded;
      },
    },
    {
      key: 'total',
      get: function () {
        return this._total;
      },
    },
  ]);
  return p;
})(module1174.default);
