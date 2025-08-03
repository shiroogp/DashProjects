var module50 = require('./50'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module97 = require('./97'),
  module101 = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = y(n);
    if (o && o.has(t)) return o.get(t);
    var c = {
        __proto__: null,
      },
      l = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var s in t)
      if ('default' !== s && Object.prototype.hasOwnProperty.call(t, s)) {
        var u = l ? Object.getOwnPropertyDescriptor(t, s) : null;
        if (u && (u.get || u.set)) Object.defineProperty(c, s, u);
        else c[s] = t[s];
      }

    c.default = t;
    if (o) o.set(t, c);
    return c;
  })(require('./101'));

function y(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (y = function (t) {
    return t ? o : n;
  })(t);
}

function O(t, n) {
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

function v(t) {
  for (var o = 1; o < arguments.length; o++) {
    var c = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      O(Object(c), true).forEach(function (o) {
        module50.default(t, o, c[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(c));
    else
      O(Object(c)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(c, n));
      });
  }

  return t;
}

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

var j,
  E = (function (t, ...args) {
    module38.default(y, t);

    var module50 = y,
      module97 = b(),
      p = function () {
        var t,
          o = module37.default(module50);

        if (module97) {
          var c = module37.default(this).constructor;
          t = Reflect.construct(o, arguments, c);
        } else t = o.apply(this, arguments);

        return module40.default(this, t);
      };

    function y() {
      var t;
      module27.default(this, y);
      (t = p.call(this, ...args)).name = '';
      return t;
    }

    return module28.default(y);
  })(module97.default(Error)),
  h = false;

function w(t) {
  if (j && !h) {
    h = true;

    try {
      return j(t);
    } catch (t) {
    } finally {
      h = false;
    }
  }

  return t;
}

var P = 0;

function k(t, n, o) {
  var module115 = require('./115').default;

  if (module115) {
    var module111 = require('./111')(t),
      s = ++P,
      u = t.message || '',
      f = u;

    if (null != t.componentStack) f += '\n\nThis error is located at:' + t.componentStack;
    var y = null == t.name || '' === t.name ? '' : t.name + ': ';
    if (!f.startsWith(y)) f = y + f;
    f = null == t.jsEngine ? f : f + ', js engine: ' + t.jsEngine;
    var O = true !== t.forceRedbox,
      b = w({
        message: f,
        originalMessage: f === u ? null : u,
        name: null == t.name || '' === t.name ? null : t.name,
        componentStack: 'string' == typeof t.componentStack ? t.componentStack : null,
        stack: module111,
        id: s,
        isFatal: n,
        extraData: {
          jsEngine: t.jsEngine,
          rawStack: t.stack,
          suppressRedBox: O,
        },
      });
    if (o) console.error(b.message);
    if (O)
      module101.addException(
        v(
          v({}, b),
          {},
          {
            isComponentError: !!t.isComponentError,
          }
        )
      );
    module115.reportException(b);
  } else o && console.error(t);
}

var x = false;

function _() {
  if ((console._errorOriginal.apply(console, arguments), console.reportErrorsAsExceptions && !x))
    if (arguments[0] && arguments[0].stack) k(arguments[0], false, false);
    else {
      var module32 = require('./32').default,
        n = Array.prototype.map
          .call(arguments, function (n) {
            return 'string' == typeof n ? n : module32(n);
          })
          .join(' ');

      if ('Warning: ' === n.slice(0, 9)) return;
      var o = new E(n);
      o.name = 'console.error';
      k(o, false, false);
    }
}

module.exports = {
  handleException: function (t, n) {
    var o;
    o = t instanceof Error ? t : new E(t);

    try {
      x = true;
      k(o, n, true);
    } finally {
      x = false;
    }
  },
  installConsoleErrorReporter: function () {
    if (!console._errorOriginal) {
      console._errorOriginal = console.error.bind(console);
      console.error = _;
      if (undefined === console.reportErrorsAsExceptions) console.reportErrorsAsExceptions = true;
    }
  },
  SyntheticError: E,
  unstable_setExceptionDecorator: function (t) {
    j = t;
  },
};
