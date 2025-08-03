!(function (t, n) {
  if (!n && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var u = o(n);
  if (u && u.has(t)) return u.get(t);
  var f = {
      __proto__: null,
    },
    p = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var l in t)
    if ('default' !== l && Object.prototype.hasOwnProperty.call(t, l)) {
      var s = p ? Object.getOwnPropertyDescriptor(t, l) : null;
      if (s && (s.get || s.set)) Object.defineProperty(f, l, s);
      else f[l] = t[l];
    }

  f.default = t;
  if (u) u.set(t, f);
})(require('react'));

var module87 = require('./87');

function o(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    u = new WeakMap();
  return (o = function (t) {
    return t ? u : n;
  })(t);
}

require('./52');

var u,
  f,
  module191 = require('./191'),
  module198 = require('./198'),
  module178 = require('./178');

if (globals.RN$Bridgeless) {
  f = module191;
  module198('RCTView', module191);
  u = 'RCTView';
} else u = module178('RCTView');

exports.__INTERNAL_VIEW_CONFIG = f;
exports.Commands = module87.default({
  supportedCommands: ['hotspotUpdate', 'setPressed'],
});
exports.default = u;
