var React = (function (t, o) {
  if (!o && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var u = n(o);
  if (u && u.has(t)) return u.get(t);
  var f = {
      __proto__: null,
    },
    p = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var c in t)
    if ('default' !== c && Object.prototype.hasOwnProperty.call(t, c)) {
      var l = p ? Object.getOwnPropertyDescriptor(t, c) : null;
      if (l && (l.get || l.set)) Object.defineProperty(f, c, l);
      else f[c] = t[c];
    }

  f.default = t;
  if (u) u.set(t, f);
  return f;
})(require('react'));

function n(t) {
  if ('function' != typeof WeakMap) return null;
  var o = new WeakMap(),
    u = new WeakMap();
  return (n = function (t) {
    return t ? u : o;
  })(t);
}

var o = "Couldn't find a navigation context. Have you wrapped your app with 'NavigationContainer'? See https://reactnavigation.org/docs/getting-started for setup instructions.";
exports.default = React.createContext({
  isDefault: true,

  get getKey() {
    throw new Error(o);
  },

  get setKey() {
    throw new Error(o);
  },

  get getState() {
    throw new Error(o);
  },

  get setState() {
    throw new Error(o);
  },

  get getIsInitial() {
    throw new Error(o);
  },
});
