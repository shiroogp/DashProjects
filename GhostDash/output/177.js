(function (t, n) {
  if (!n && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var o = f(n);
  if (o && o.has(t)) return o.get(t);
  var u = {
      __proto__: null,
    },
    l = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var p in t)
    if ('default' !== p && Object.prototype.hasOwnProperty.call(t, p)) {
      var c = l ? Object.getOwnPropertyDescriptor(t, p) : null;
      if (c && (c.get || c.set)) Object.defineProperty(u, p, c);
      else u[p] = t[p];
    }

  u.default = t;
  if (o) o.set(t, u);
})(require('react'));

var module178 = require('./178'),
  module87 = require('./87'),
  module189 = require('./189');

function f(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (f = function (t) {
    return t ? o : n;
  })(t);
}

var l,
  module175 = require('./175');

exports.Commands = module87.default({
  supportedCommands: ['focus', 'blur', 'setTextAndSelection'],
});

if (globals.RN$Bridgeless) {
  module175.register('AndroidTextInput', function () {
    return module189.default;
  });
  l = 'AndroidTextInput';
} else l = module178.default('AndroidTextInput');

exports.default = l;
