exports.default = function (t) {
  var o,
    u = arguments.length > 1 && undefined !== arguments[1] ? arguments[1] : {},
    p = f.forwardRef(function (o, p) {
      var s = Object.keys(o).reduce(function (t, n) {
          var u = v;
          if (u.includes(n)) t[n] = o[n];
          return t;
        }, O({}, u)),
        y = React.useRef(),
        b = React.useRef();
      React.useImperativeHandle(
        p,
        function () {
          var t = b.current;

          if (y.current && t) {
            y.current.handlerTag = t.handlerTag;
            return y.current;
          } else return null;
        },
        [y, b]
      );
      return f.createElement(
        module617.NativeViewGestureHandler,
        module14.default({}, s, {
          ref: b,
        }),
        f.createElement(
          t,
          module14.default({}, o, {
            ref: y,
          })
        )
      );
    });
  p.displayName =
    (null == t ? undefined : t.displayName) || (null == t ? undefined : null == (o = t.render) ? undefined : o.name) || ('string' == typeof t && t) || 'ComponentWrapper';
  return p;
};

var module14 = require('./14'),
  module50 = require('./50'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = p(n);
    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      c = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var f in t)
      if ('default' !== f && Object.prototype.hasOwnProperty.call(t, f)) {
        var l = c ? Object.getOwnPropertyDescriptor(t, f) : null;
        if (l && (l.get || l.set)) Object.defineProperty(u, f, l);
        else u[f] = t[f];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  f = React,
  module617 = require('./617');

function p(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (p = function (t) {
    return t ? o : n;
  })(t);
}

function s(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var u = Object.getOwnPropertySymbols(t);
    if (n)
      u = u.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, u);
  }

  return o;
}

function O(t) {
  for (var n = 1; n < arguments.length; n++) {
    var u = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      s(Object(u), true).forEach(function (n) {
        module50.default(t, n, u[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(u));
    else
      s(Object(u)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(u, n));
      });
  }

  return t;
}

var v = [].concat(module23.default(module617.nativeViewProps), ['onGestureHandlerEvent', 'onGestureHandlerStateChange']);
