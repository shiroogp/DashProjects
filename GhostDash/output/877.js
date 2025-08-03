var module50 = require('./50'),
  module760 = require('./760'),
  module794 = require('./794'),
  module787 = require('./787');

function u(t, o) {
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

function f(t) {
  for (var n = 1; n < arguments.length; n++) {
    var c = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      u(Object(c), true).forEach(function (n) {
        module50.default(t, n, c[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(c));
    else
      u(Object(c)).forEach(function (o) {
        Object.defineProperty(t, o, Object.getOwnPropertyDescriptor(c, o));
      });
  }

  return t;
}

var p = f({}, module794.default, {
  dark: true,
  mode: 'adaptive',
  colors: f({}, module794.default.colors, {
    primary: '#BB86FC',
    accent: '#03dac6',
    background: '#121212',
    surface: '#121212',
    error: '#CF6679',
    onBackground: '#FFFFFF',
    onSurface: '#FFFFFF',
    text: module787.white,
    disabled: module760.default(module787.white).alpha(0.38).rgb().string(),
    placeholder: module760.default(module787.white).alpha(0.54).rgb().string(),
    backdrop: module760.default(module787.black).alpha(0.5).rgb().string(),
    notification: module787.pinkA100,
  }),
});
exports.default = p;
