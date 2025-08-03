var module14 = require('./14'),
  module50 = require('./50'),
  React = (function (t, o) {
    if (!o && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var n = s(o);
    if (n && n.has(t)) return n.get(t);
    var c = {
        __proto__: null,
      },
      l = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var u in t)
      if ('default' !== u && Object.prototype.hasOwnProperty.call(t, u)) {
        var f = l ? Object.getOwnPropertyDescriptor(t, u) : null;
        if (f && (f.get || f.set)) Object.defineProperty(c, u, f);
        else c[u] = t[u];
      }

    c.default = t;
    if (n) n.set(t, c);
    return c;
  })(require('react')),
  module649 = require('./649'),
  module747 = require('./747'),
  module776 = require('./776'),
  module777 = require('./777');

function s(t) {
  if ('function' != typeof WeakMap) return null;
  var o = new WeakMap(),
    n = new WeakMap();
  return (s = function (t) {
    return t ? n : o;
  })(t);
}

function y(t, o) {
  var n = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var c = Object.getOwnPropertySymbols(t);
    if (o)
      c = c.filter(function (o) {
        return Object.getOwnPropertyDescriptor(t, o).enumerable;
      });
    n.push.apply(n, c);
  }

  return n;
}

function O(t) {
  for (var o = 1; o < arguments.length; o++) {
    var c = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      y(Object(c), true).forEach(function (o) {
        module50.default(t, o, c[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(c));
    else
      y(Object(c)).forEach(function (o) {
        Object.defineProperty(t, o, Object.getOwnPropertyDescriptor(c, o));
      });
  }

  return t;
}

exports.default = React.memo(function (t) {
  var n,
    s = t.scene,
    y = t.previous,
    v = t.layout,
    b = t.insets,
    h = t.navigation,
    j = t.styleInterpolator,
    P = s.descriptor.options,
    k = 'function' != typeof P.headerTitle && undefined !== P.headerTitle ? P.headerTitle : undefined !== P.title ? P.title : s.route.name;
  if (undefined !== P.headerBackTitle) n = P.headerBackTitle;
  else if (y) {
    var w = y.descriptor.options;
    n = 'function' != typeof w.headerTitle && undefined !== w.headerTitle ? w.headerTitle : undefined !== w.title ? w.title : y.route.name;
  }
  var T = React.useCallback(
    module777.default(function () {
      if (h.isFocused() && h.canGoBack())
        h.dispatch(
          O(
            O({}, module649.StackActions.pop()),
            {},
            {
              source: s.route.key,
            }
          )
        );
    }, 50),
    [h, s.route.key]
  );
  return <module747.default />;
});
