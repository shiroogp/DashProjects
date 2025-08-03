var module50 = require('./50'),
  module438 = require('./438'),
  module422 = require('./422'),
  module415 = require('./415'),
  module421 = require('./421');

function u(o, t) {
  var n = Object.keys(o);

  if (Object.getOwnPropertySymbols) {
    var c = Object.getOwnPropertySymbols(o);
    if (t)
      c = c.filter(function (t) {
        return Object.getOwnPropertyDescriptor(o, t).enumerable;
      });
    n.push.apply(n, c);
  }

  return n;
}

function f(o) {
  for (var n = 1; n < arguments.length; n++) {
    var c = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      u(Object(c), true).forEach(function (n) {
        module50.default(o, n, c[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(o, Object.getOwnPropertyDescriptors(c));
    else
      u(Object(c)).forEach(function (t) {
        Object.defineProperty(o, t, Object.getOwnPropertyDescriptor(c, t));
      });
  }

  return o;
}

var s,
  b = (exports.colorProps = [
    'backgroundColor',
    'borderBottomColor',
    'borderColor',
    'borderLeftColor',
    'borderRightColor',
    'borderTopColor',
    'borderStartColor',
    'borderEndColor',
    'color',
    'shadowColor',
    'textDecorationColor',
    'tintColor',
    'textShadowColor',
    'overlayColor',
  ]),
  P = (exports.ColorProperties = module422.isConfigured() ? module422.makeShareable(b) : []);
s = module421.shouldBeUseWeb()
  ? function (o, t, n) {
      'worklet';

      if (n)
        n.items.forEach(function (o, n) {
          module415._updatePropsJS(t, o);
        });
    }
  : globals._IS_FABRIC
  ? function (o, t, c) {
      'worklet';

      for (var p in t) -1 !== P.indexOf(p) && (t[p] = module438.processColor(t[p]));

      o.value.forEach(function (o) {
        _updatePropsFabric(o.shadowNodeWrapper, t);
      });
    }
  : function (o, t, c) {
      'worklet';

      for (var p in t) -1 !== P.indexOf(p) && (t[p] = module438.processColor(t[p]));

      o.value.forEach(function (o) {
        _updatePropsPaper(o.tag, o.name || 'RCTView', t);
      });
    };
var C = (exports.updateProps = s);

exports.updatePropsJestWrapper = function (o, t, n, c, p) {
  p.forEach(function (o) {
    o(t);
  });
  c.current.value = f(f({}, c.current.value), t);
  C(o, t, n);
};

exports.default = C;
