var module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module1167 = require('./1167');

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

  var module1167 = p,
    v = s(),
    y = function () {
      var t,
        n = module37.default(module1167);

      if (v) {
        var u = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, u);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function p(t, u) {
    var f;
    module27.default(this, p);
    (f = y.call(this, t, u)).name = '';
    return f;
  }

  module28.default(p, null, [
    {
      key: 'build',
      value: function (t, n, u) {
        return new Promise(function (f, o) {
          if (undefined === n) o(new TypeError('data is undefined'));
          new p(n, u).onCreated(function (n) {
            n.name = t;
            f(n);
          });
        });
      },
    },
  ]);
  return p;
})(module1167.default);
