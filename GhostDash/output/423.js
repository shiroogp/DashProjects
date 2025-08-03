exports.makeShareable = function (t) {
  if (l) return t;
  var n = y({
    __init: function () {
      'worklet';

      return t;
    },
  });
  v(t, n);
  return t;
};

exports.makeShareableCloneOnUIRecursive = function (t) {
  'worklet';

  if (l) return t;
  return (function t(o) {
    var u = typeof o;

    if (('object' === u || 'function' === u) && null !== o) {
      var l;
      if (Array.isArray(o))
        l = o.map(function (n) {
          return t(n);
        });
      else if (undefined !== o) {
        l = {};

        for (var f = 0, c = Object.entries(o); f < c.length; f++) {
          var s = c[f],
            h = module15.default(s, 2),
            v = h[0],
            b = h[1];
          l[v] = t(b);
        }
      }
      return _makeShareableClone(l);
    }

    return _makeShareableClone(o);
  })(t);
};

exports.makeShareableCloneRecursive = y;
exports.registerShareableMapping = v;

require('./424');

require('./419');

var module15 = require('@babel/runtime/helpers/slicedToArray'),
  module414 = require('./414'),
  module421 = require('./421'),
  l = module421.shouldBeUseWeb(),
  f = new WeakMap(),
  c = Symbol('shareable flag'),
  s = 'REANIMATED_MAGIC_KEY';

function h(t) {
  return s in t;
}

function v(t, n) {
  if (!l) f.set(t, n || c);
}

var b,
  _ = {
    __init: function () {
      'worklet';

      return new Proxy(
        {},
        {
          get: function (t, n) {
            if ('_isReanimatedSharedValue' === n) return false;
            throw new Error('Trying to access property `' + n + '` of an object which cannot be sent to the UI runtime.');
          },
          set: function () {
            throw new Error('Trying to write to an object which cannot be sent to the UI runtime.');
          },
        }
      );
    },
  },
  w = 30;

function y(t) {
  var u = arguments.length > 1 && undefined !== arguments[1] && arguments[1],
    s = arguments.length > 2 && undefined !== arguments[2] ? arguments[2] : 0;
  if (l) return t;

  if (s >= w) {
    if (s === w) b = t;
    else if (t === b) throw new Error('Trying to convert a cyclic object to a shareable. This is not supported.');
  } else b = undefined;

  var v,
    p = typeof t,
    k = 'function' === p;

  if (('object' === p || k) && null !== t) {
    var j,
      S = f.get(t);
    if (S === c) return t;
    if (undefined !== S) return S;
    if (Array.isArray(t))
      j = t.map(function (t) {
        return y(t, u, s + 1);
      });
    else if (k && undefined === t.__workletHash) j = t;
    else if (h(t)) j = t;
    else {
      if (((v = t), Object.getPrototypeOf(v) !== Object.prototype && !k)) {
        var A = y(_);
        f.set(t, A);
        return A;
      }

      j = {};

      if (undefined !== t.__workletHash) {
        j.__initData = y(t.__initData, true, s + 1);
        delete t.__initData;
      }

      for (var C = 0, O = Object.entries(t); C < O.length; C++) {
        var E = O[C],
          I = module15.default(E, 2),
          M = I[0],
          T = I[1];
        j[M] = y(T, u, s + 1);
      }
    }
    var D = module414.default.makeShareableClone(j, u);
    f.set(t, D);
    f.set(D, c);
    return D;
  }

  return module414.default.makeShareableClone(t, u);
}
