var module27 = require('./27');

function u(t, n) {
  var o = ('undefined' != typeof Symbol && t[Symbol.iterator]) || t['@@iterator'];
  if (o) return (o = o.call(t)).next.bind(o);

  if (Array.isArray(t) || (o = l(t)) || (n && t && 'number' == typeof t.length)) {
    if (o) t = o;
    var u = 0;
    return function () {
      return u >= t.length
        ? {
            done: true,
          }
        : {
            done: false,
            value: t[u++],
          };
    };
  }

  throw new TypeError('Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.');
}

function l(t, n) {
  if (t) {
    if ('string' == typeof t) return s(t, n);
    var o = Object.prototype.toString.call(t).slice(8, -1);
    if ('Object' === o && t.constructor) o = t.constructor.name;
    return 'Map' === o || 'Set' === o ? Array.from(t) : 'Arguments' === o || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(o) ? s(t, n) : undefined;
  }
}

function s(t, n) {
  if (null == n || n > t.length) n = t.length;

  for (var o = 0, u = new Array(n); o < n; o++) u[o] = t[o];

  return u;
}

var ReactNative = require('react-native').NativeModules.RNFetchBlob,
  c = {};

exports.default = (function () {
  function t(o, u) {
    module27.default(this, t);
    this.name = o;
    if (!c[o]) Array.isArray(u) ? (c[o] = u) : (c[o] = []);
  }

  module28.default(
    t,
    [
      {
        key: 'add',
        value: function (t) {
          c[this.name].push(t);
          return this;
        },
      },
      {
        key: 'remove',
        value: function (t) {
          for (var n, o = c[this.name], l = u(o); !(n = l()).done; ) {
            var s = n.value;

            if (o[s] === t) {
              c[this.name].splice(s, 1);
              break;
            }
          }

          return this;
        },
      },
      {
        key: 'list',
        value: function () {
          return c[this.name];
        },
      },
      {
        key: 'dispose',
        value: function () {
          var t = this;
          return new Promise(function (n, o) {
            ReactNative.removeSession(c[t.name], function (u) {
              if (u) o(new Error(u));
              else {
                delete c[t.name];
                n();
              }
            });
          });
        },
      },
    ],
    [
      {
        key: 'getSession',
        value: function (t) {
          return c[t];
        },
      },
      {
        key: 'setSession',
        value: function (t, n) {
          c[t] = n;
        },
      },
      {
        key: 'removeSession',
        value: function (t) {
          delete c[t];
        },
      },
    ]
  );
  return t;
})();
