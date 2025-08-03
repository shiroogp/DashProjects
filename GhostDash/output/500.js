var module50 = require('./50'),
  module421 = require('./421');

function o(t, n) {
  var s = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var o = Object.getOwnPropertySymbols(t);
    if (n)
      o = o.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    s.push.apply(s, o);
  }

  return s;
}

function u(t) {
  for (var s = 1; s < arguments.length; s++) {
    var u = null != arguments[s] ? arguments[s] : {};
    if (s % 2)
      o(Object(u), true).forEach(function (s) {
        module50.default(t, s, u[s]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      o(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
}

exports.withReanimatedTimer = function (t) {
  console.warn(
    'This method is deprecated, you should define your own before and after test hooks to enable jest.useFakeTimers(). Check out the documentation for details on testing'
  );
  jest.useFakeTimers();
  t();
  jest.runOnlyPendingTimers();
  jest.useRealTimers();
};

exports.advanceAnimationByTime = function () {
  var t = arguments.length > 0 && undefined !== arguments[0] ? arguments[0] : j;
  console.warn('This method is deprecated, use jest.advanceTimersByTime directly');
  jest.advanceTimersByTime(t);
  jest.runOnlyPendingTimers();
};

exports.advanceAnimationByFrame = function (t) {
  console.warn('This method is deprecated, use jest.advanceTimersByTime directly');
  jest.advanceTimersByTime(t * j);
  jest.runOnlyPendingTimers();
};

var c = {
    fps: 60,
  },
  f = function (t) {
    return !!t.animatedStyle;
  },
  p = function (t) {
    return t.animatedStyle.current.value;
  },
  l = function (t) {
    var n = t.props.style,
      s = {};
    if (Array.isArray(n))
      t.props.style.forEach(function (t) {
        s = f(t) ? u(u({}, s), p(t)) : u(u({}, s), t);
      });
    else s = f(n) ? p(n) : u(u({}, n), t.props.animatedStyle.value);
    return s;
  },
  y = function t(n, s) {
    if (Array.isArray(s)) {
      if (s.length !== n.length) return false;

      for (var o = 0; o < n.length; o++) if (!t(n[o], s[o])) return false;
    } else {
      if ('object' != typeof n || !n) return n === s;

      for (var u in s) if (!t(n[u], s[u])) return false;
    }

    return true;
  },
  v = function (t, n, s) {
    var o = [],
      u = true;

    for (var c in n)
      y(t[c], n[c]) ||
        ((u = false),
        o.push({
          property: c,
          current: t[c],
          expect: n[c],
        }));

    if (s && Object.keys(t).length !== Object.keys(n).length)
      for (var f in ((u = false), t))
        undefined === n[f] &&
          o.push({
            property: f,
            current: t[f],
            expect: n[f],
          });
    return {
      isEqual: u,
      diffs: o,
    };
  },
  h = function (t, n, s) {
    if (!t.props.style)
      return {
        message: (function (t) {
          function n() {
            return t.apply(this, arguments);
          }

          n.toString = function () {
            return t.toString();
          };

          return n;
        })(function () {
          return message;
        }),
        pass: false,
      };
    var o = s.shouldMatchAllProps,
      u = l(t),
      c = v(u, n, o),
      f = c.isEqual,
      p = c.diffs;
    if (f)
      return {
        message: function () {
          return 'ok';
        },
        pass: true,
      };
    var y = JSON.stringify(u),
      h = JSON.stringify(n),
      j = p
        .map(function (t) {
          return "- '" + t.property + "' should be " + JSON.stringify(t.expect) + ', but is ' + JSON.stringify(t.current);
        })
        .join('\n');
    return {
      message: function () {
        return 'Expected: ' + h + '\nReceived: ' + y + '\n\nDifferences:\n' + j;
      },
      pass: false,
    };
  },
  j = 1e3 / c.fps,
  O = module421.isJest()
    ? require
    : function () {
        throw new Error('[Reanimated] setUpTests() is available only in Jest environment');
      };

exports.setUpTests = function () {
  var t = arguments.length > 0 && undefined !== arguments[0] ? arguments[0] : {},
    n = globals.expect;

  if (undefined === n) {
    var s = O('expect');
    if ('object' == typeof (n = s)) n = O('@jest/globals').expect;
    if (!(undefined !== n && undefined !== n.extend)) n = s.default;
  }

  j = Math.round(1e3 / c.fps);
  c = u(u({}, c), t);
  n.extend({
    toHaveAnimatedStyle: function (t, n) {
      var s = arguments.length > 2 && undefined !== arguments[2] ? arguments[2] : {};
      return h(t, n, s);
    },
  });
};

exports.getAnimatedStyle = function (t) {
  return l(t);
};
