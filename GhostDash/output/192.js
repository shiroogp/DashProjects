(function (t, n) {
  if (!n && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var u = l(n);
  if (u && u.has(t)) return u.get(t);
  var o = {
      __proto__: null,
    },
    f = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var p in t)
    if ('default' !== p && Object.prototype.hasOwnProperty.call(t, p)) {
      var c = f ? Object.getOwnPropertyDescriptor(t, p) : null;
      if (c && (c.get || c.set)) Object.defineProperty(o, p, c);
      else o[p] = t[p];
    }

  o.default = t;
  if (u) u.set(t, o);
})(require('react'));

var module178 = require('./178'),
  module87 = require('./87'),
  module193 = require('./193');

function l(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    u = new WeakMap();
  return (l = function (t) {
    return t ? u : n;
  })(t);
}

var f,
  module175 = require('./175');

exports.Commands = module87.default({
  supportedCommands: ['focus', 'blur', 'setTextAndSelection'],
});

if (globals.RN$Bridgeless) {
  module175.register('RCTSinglelineTextInputView', function () {
    return module193.default;
  });
  f = 'RCTSinglelineTextInputView';
} else f = module178.default('RCTSinglelineTextInputView');

exports.default = f;
