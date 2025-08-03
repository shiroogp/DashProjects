var module50 = require('./50'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module619 = require('./619');

function h(t, n) {
  var u = ('undefined' != typeof Symbol && t[Symbol.iterator]) || t['@@iterator'];
  if (u) return (u = u.call(t)).next.bind(u);

  if (Array.isArray(t) || (u = y(t)) || (n && t && 'number' == typeof t.length)) {
    if (u) t = u;
    var o = 0;
    return function () {
      return o >= t.length
        ? {
            done: true,
          }
        : {
            done: false,
            value: t[o++],
          };
    };
  }

  throw new TypeError('Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.');
}

function y(t, n) {
  if (t) {
    if ('string' == typeof t) return v(t, n);
    var u = Object.prototype.toString.call(t).slice(8, -1);
    if ('Object' === u && t.constructor) u = t.constructor.name;
    return 'Map' === u || 'Set' === u ? Array.from(t) : 'Arguments' === u || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(u) ? v(t, n) : undefined;
  }
}

function v(t, n) {
  if (null == n || n > t.length) n = t.length;

  for (var u = 0, o = new Array(n); u < n; u++) o[u] = t[u];

  return o;
}

function b(t, n) {
  var u = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var o = Object.getOwnPropertySymbols(t);
    if (n)
      o = o.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    u.push.apply(u, o);
  }

  return u;
}

function G(t) {
  for (var u = 1; u < arguments.length; u++) {
    var o = null != arguments[u] ? arguments[u] : {};
    if (u % 2)
      b(Object(o), true).forEach(function (u) {
        module50.default(t, u, o[u]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      b(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

function O(t) {
  var n = j();
  return function () {
    var u,
      o = module37.default(t);

    if (n) {
      var s = module37.default(this).constructor;
      u = Reflect.construct(o, arguments, s);
    } else u = o.apply(this, arguments);

    return module40.default(this, u);
  };
}

function j() {
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

function S(t, n) {
  return undefined === t ? module23.default(n) : [].concat(module23.default(t), module23.default(n));
}

var A = (exports.ComposedGesture = (function (t, ...args) {
  module38.default(l, t);
  var n = O(l);

  function l() {
    var t;
    module27.default(this, l);
    (t = n.call(this)).gestures = [];
    t.simultaneousGestures = [];
    t.requireGesturesToFail = [];
    t.gestures = args;
    return t;
  }

  module28.default(l, [
    {
      key: 'prepareSingleGesture',
      value: function (t, n, u) {
        if (t instanceof module619.BaseGesture) {
          var o = G({}, t.config);
          o.simultaneousWith = S(o.simultaneousWith, n);
          o.requireToFail = S(o.requireToFail, u);
          t.config = o;
        } else t instanceof l && ((t.simultaneousGestures = n), (t.requireGesturesToFail = u), t.prepare());
      },
    },
    {
      key: 'prepare',
      value: function () {
        for (var t, n = h(this.gestures); !(t = n()).done; ) {
          var u = t.value;
          this.prepareSingleGesture(u, this.simultaneousGestures, this.requireGesturesToFail);
        }
      },
    },
    {
      key: 'initialize',
      value: function () {
        for (var t, n = h(this.gestures); !(t = n()).done; ) {
          t.value.initialize();
        }
      },
    },
    {
      key: 'toGestureArray',
      value: function () {
        return this.gestures.flatMap(function (t) {
          return t.toGestureArray();
        });
      },
    },
  ]);
  return l;
})(module619.Gesture));

exports.SimultaneousGesture = (function (t) {
  module38.default(l, t);
  var n = O(l);

  function l() {
    module27.default(this, l);
    return n.apply(this, arguments);
  }

  module28.default(l, [
    {
      key: 'prepare',
      value: function () {
        for (
          var t = this,
            n = this.gestures.map(function (n) {
              return t.gestures
                .filter(function (t) {
                  return t !== n;
                })
                .flatMap(function (t) {
                  return t.toGestureArray();
                });
            }),
            u = 0;
          u < this.gestures.length;
          u++
        )
          this.prepareSingleGesture(this.gestures[u], n[u], this.requireGesturesToFail);
      },
    },
  ]);
  return l;
})(A);

exports.ExclusiveGesture = (function (t) {
  module38.default(l, t);
  var n = O(l);

  function l() {
    module27.default(this, l);
    return n.apply(this, arguments);
  }

  module28.default(l, [
    {
      key: 'prepare',
      value: function () {
        for (
          var t = this.gestures.map(function (t) {
              return t.toGestureArray();
            }),
            n = [],
            u = 0;
          u < this.gestures.length;
          u++
        ) {
          this.prepareSingleGesture(this.gestures[u], this.simultaneousGestures, this.requireGesturesToFail.concat(n));
          n = n.concat(t[u]);
        }
      },
    },
  ]);
  return l;
})(A);
