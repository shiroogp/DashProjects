var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  React = (function (t, f) {
    if (!f && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var n = s(f);
    if (n && n.has(t)) return n.get(t);
    var u = {
        __proto__: null,
      },
      l = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var o in t)
      if ('default' !== o && Object.prototype.hasOwnProperty.call(t, o)) {
        var c = l ? Object.getOwnPropertyDescriptor(t, o) : null;
        if (c && (c.get || c.set)) Object.defineProperty(u, o, c);
        else u[o] = t[o];
      }

    u.default = t;
    if (n) n.set(t, u);
    return u;
  })(require('react')),
  ReactNative = require('react-native'),
  module412 = require('./412'),
  module480 = require('./480'),
  p = ['scrollViewOffset'];

function s(t) {
  if ('function' != typeof WeakMap) return null;
  var f = new WeakMap(),
    n = new WeakMap();
  return (s = function (t) {
    return t ? n : f;
  })(t);
}

var O = module412.default(ReactNative.ScrollView),
  v = React.forwardRef(function (t, l) {
    var o = t.scrollViewOffset,
      s = module56.default(t, p),
      v = null === l ? module480.useAnimatedRef() : l;
    if (o) module480.useScrollViewOffset(v, o);
    return React.default.createElement(
      O,
      module14.default(
        {
          ref: v,
        },
        s
      )
    );
  });
exports.default = v;
