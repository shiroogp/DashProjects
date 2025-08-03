exports.areDependenciesEqual = h;
exports.buildDependencies = v;
exports.buildWorkletsHash = f;

exports.hasColorProps = function (n) {
  var t = new Set(module442.colorProps);

  for (var o in n) if (t.has(o)) return true;

  return false;
};

exports.isAnimated = function n(t) {
  'worklet';

  if (Array.isArray(t)) return t.some(n);
  if ('object' == typeof t) return undefined !== t.onFrame || Object.values(t).some(n);
  return false;
};

exports.parseColors = function (n) {
  'worklet';

  for (var t in n)
    if (-1 !== module442.colorProps.indexOf(t)) {
      var u = module438.processColor(n[t]);
      if (undefined !== u) n[t] = u;
    }
};

exports.shallowEqual = function (n, t) {
  'worklet';

  var o = Object.keys(n),
    u = Object.keys(t);
  if (o.length !== u.length) return false;

  for (var s = 0; s < o.length; s++) if (n[o[s]] !== t[o[s]]) return false;

  return true;
};

exports.useEvent = function (n) {
  var o = arguments.length > 1 && undefined !== arguments[1] ? arguments[1] : [],
    u = arguments.length > 2 && undefined !== arguments[2] && arguments[2],
    s = React.useRef(null);
  if (null === s.current) s.current = new module413.default(n, o);
  else if (u) s.current.updateWorklet(n);
  return s;
};

exports.useHandler = function (n, o) {
  var c = React.useRef(null);
  if (null === c.current)
    c.current = {
      context: module422.makeRemote({}),
      savedDependencies: [],
    };
  React.useEffect(function () {
    return function () {
      c.current = null;
    };
  }, []);
  var l = c.current,
    f = l.context,
    p = l.savedDependencies,
    b = !h((o = v(o, n)), p);
  c.current.savedDependencies = o;
  var y = module421.isWeb() || module421.isJest();
  return {
    context: f,
    doDependenciesDiffer: b,
    useWeb: y,
  };
};

var React = require('react'),
  module438 = require('./438'),
  module422 = require('./422'),
  module421 = require('./421'),
  module442 = require('./442'),
  module413 = require('./413');

function f(n) {
  return Object.values(n).reduce(function (n, t) {
    return n + t.__workletHash.toString();
  }, '');
}

function v(n, t) {
  var o = Object.values(t).filter(function (n) {
    return undefined !== n;
  });
  if (n) n.push(f(o));
  else
    n = o.map(function (n) {
      return {
        workletHash: n.__workletHash,
        closure: n._closure,
      };
    });
  return n;
}

function h(n, t) {
  var o =
    'function' == typeof Object.is
      ? Object.is
      : function (n, t) {
          return n === t ? 0 !== n || 1 / n == 1 / t : n != n && t != t;
        };
  return (function (n, t) {
    if (!n || !t || t.length !== n.length) return false;

    for (var u = 0; u < t.length; ++u) if (!o(n[u], t[u])) return false;

    return true;
  })(n, t);
}

exports.validateAnimatedStyles = function (n) {
  'worklet';

  if ('object' != typeof n) throw new Error('useAnimatedStyle has to return an object, found ' + typeof n + ' instead');
  if (Array.isArray(n))
    throw new Error('useAnimatedStyle has to return an object and cannot return static styles combined with dynamic ones. Please do merging where a component receives props.');
};
