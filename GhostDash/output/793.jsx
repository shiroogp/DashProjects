exports.__esModule = true;

var React = (function (t) {
    if (t && t.__esModule) return t;
    var n = {};
    if (null != t)
      for (var o in t)
        if (Object.prototype.hasOwnProperty.call(t, o)) {
          var u = Object.defineProperty && Object.getOwnPropertyDescriptor ? Object.getOwnPropertyDescriptor(t, o) : {};
          if (u.get || u.set) Object.defineProperty(n, o, u);
          else n[o] = t[o];
        }
    n.default = t;
    return n;
  })(require('react')),
  module791 = require('./791'),
  module510 = require('./510');

function c() {
  return (c =
    Object.assign ||
    function (t) {
      for (var n = 1; n < arguments.length; n++) {
        var o = arguments[n];

        for (var u in o) Object.prototype.hasOwnProperty.call(o, u) && (t[u] = o[u]);
      }

      return t;
    }).apply(this, arguments);
}

function f(t, n) {
  if (null == t) return {};
  var o,
    u,
    c = {},
    f = Object.keys(t);

  for (u = 0; u < f.length; u++) {
    o = f[u];
    if (!(n.indexOf(o) >= 0)) c[o] = t[o];
  }

  return c;
}

function l(t) {
  if (undefined === t) throw new ReferenceError("this hasn't been initialised - super() hasn't been called");
  return t;
}

function p(t, n, o) {
  if (n in t)
    Object.defineProperty(t, n, {
      value: o,
      enumerable: true,
      configurable: true,
      writable: true,
    });
  else t[n] = o;
  return t;
}

var s = function (u, s) {
  return function (u) {
    var v = (function (o, ...args) {
        var v, h;

        function _() {
          p(l((t = o.call(this, ...args) || this)), '_previous', undefined);
          p(l(t), '_merge', function (o, u) {
            var c = t._previous;
            if (c && c.a === o && c.b === u) return c.result;
            var f = o && u && o !== u ? module791.default(o, u) : o || u;
            t._previous = {
              a: o,
              b: u,
              result: f,
            };
            return f;
          });
          return t;
        }

        h = o;
        (v = _).prototype = Object.create(h.prototype);
        v.prototype.constructor = v;
        v.__proto__ = h;

        _.prototype.render = function () {
          var n = this,
            o = this.props,
            l = o._reactThemeProviderForwardedRef,
            p = f(o, ['_reactThemeProviderForwardedRef']);
          return (
            <s.Consumer>
              {function (o) {
                return <u />;
              }}
            </s.Consumer>
          );
        };

        return _;
      })(React.Component),
      h = React.forwardRef(function (n, o) {
        return <v />;
      });

    h.displayName = 'withTheme(' + (u.displayName || u.name) + ')';
    module510.default(h, u);
    return h;
  };
};

exports.default = s;
