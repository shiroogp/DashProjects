exports.default = function (o) {
  var u = module650.useNavigation(),
    c = module650.useRoute();
  React.useEffect(
    function () {
      for (var t = u; t && 'tab' !== t.dangerouslyGetState().type; ) t = t.dangerouslyGetParent();

      if (t) {
        var n = t.addListener('tabPress', function (n) {
          var s = u.isFocused(),
            f = u === t || u.dangerouslyGetState().routes[0].key === c.key;
          requestAnimationFrame(function () {
            var t = l(o);
            if (s && f && t && !n.defaultPrevented)
              'scrollToTop' in t
                ? t.scrollToTop()
                : 'scrollTo' in t
                ? t.scrollTo({
                    y: 0,
                    animated: true,
                  })
                : 'scrollToOffset' in t
                ? t.scrollToOffset({
                    offset: 0,
                    animated: true,
                  })
                : 'scrollResponderScrollTo' in t &&
                  t.scrollResponderScrollTo({
                    y: 0,
                    animated: true,
                  });
          });
        });
        return n;
      }
    },
    [u, o, c.key]
  );
};

var React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var l = o(n);
    if (l && l.has(t)) return l.get(t);
    var u = {
        __proto__: null,
      },
      c = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var s in t)
      if ('default' !== s && Object.prototype.hasOwnProperty.call(t, s)) {
        var f = c ? Object.getOwnPropertyDescriptor(t, s) : null;
        if (f && (f.get || f.set)) Object.defineProperty(u, s, f);
        else u[s] = t[s];
      }

    u.default = t;
    if (l) l.set(t, u);
    return u;
  })(require('react')),
  module650 = require('./650');

function o(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    l = new WeakMap();
  return (o = function (t) {
    return t ? l : n;
  })(t);
}

function l(t) {
  return null == t.current
    ? null
    : 'scrollToTop' in t.current || 'scrollTo' in t.current || 'scrollToOffset' in t.current || 'scrollResponderScrollTo' in t.current
    ? t.current
    : 'getScrollResponder' in t.current
    ? t.current.getScrollResponder()
    : 'getNode' in t.current
    ? t.current.getNode()
    : t.current;
}
