var module50 = require('@babel/runtime/helpers/interopRequireDefault')(require('./50')),
  module436 = require('./436'),
  module429 = require('./429'),
  module443 = require('./443');

function u(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var c = Object.getOwnPropertySymbols(t);
    if (n)
      c = c.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, c);
  }

  return o;
}

function l(n) {
  for (var o = 1; o < arguments.length; o++) {
    var c = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      u(Object(c), true).forEach(function (o) {
        module50.default(n, o, c[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(n, Object.getOwnPropertyDescriptors(c));
    else
      u(Object(c)).forEach(function (t) {
        Object.defineProperty(n, t, Object.getOwnPropertyDescriptor(c, t));
      });
  }

  return n;
}

var f = 1e9;

function s(t, n, o) {
  'worklet';

  var u = o === module443.LayoutAnimationType.SHARED_ELEMENT_TRANSITION;
  n.addListener(t + f, function () {
    _notifyAboutProgress(t, n.value, u);
  });
}

function y(t, n, o, c) {
  'worklet';

  n.removeListener(t + f);

  _notifyAboutEnd(t, o, c);
}

function p() {
  'worklet';

  var t = new Map(),
    u = new Map();
  return {
    start: function (f, p, b, v) {
      var O = v(b),
        w = O.animations;
      if (p === module443.LayoutAnimationType.ENTERING) t.set(f, w);
      else if (p === module443.LayoutAnimationType.LAYOUT) {
        var j = t.get(f);
        if (j) w = l(l({}, j), O.animations);
      }
      var A = u.get(f);

      if (undefined === A) {
        A = module429.makeUIMutable(O.initialValues);
        u.set(f, A);
      } else {
        y(f, A, false, false);
        A._value = O.initialValues;
      }

      var E = module436.withStyleAnimation(w);

      E.callback = function (n) {
        if (n) {
          t.delete(f);
          u.delete(f);
          var o = p === module443.LayoutAnimationType.EXITING;
          y(f, A, n, o);
        }

        if (O.callback) O.callback(undefined !== n && n);
      };

      s(f, A, p);
      A.value = E;
    },
    stop: function (t) {
      var n = u.get(t);
      if (n) y(t, n, true, true);
    },
  };
}

require('./426').runOnUIImmediately(function () {
  'worklet';

  globals.LayoutAnimationsManager = p();
})();
