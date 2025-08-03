exports.resolvePath = f;
exports.setPath = s;

exports.withStyleAnimation = function (v) {
  'worklet';

  return module437.defineAnimation({}, function () {
    return {
      isHigherOrder: true,
      onFrame: function (t, n) {
        var u = false,
          v = [
            {
              value: t.styleAnimations,
              path: [],
            },
          ];

        for (; v.length > 0; ) {
          var c = v.pop();
          if (Array.isArray(c.value))
            for (var f = 0; f < c.value.length; f++)
              v.push({
                value: c.value[f],
                path: c.path.concat(f),
              });
          else if ('object' == typeof c.value && undefined === c.value.onFrame)
            for (var p = 0, h = Object.keys(c.value); p < h.length; p++) {
              var y = h[p];
              v.push({
                value: c.value[y],
                path: c.path.concat(y),
              });
            }
          else {
            var b = c.value;
            if (b.finished) continue;
            var A = b.onFrame(b, n);

            if (A) {
              b.finished = true;
              if (b.callback) b.callback(true);
            } else u = true;

            if (module442.ColorProperties.includes(c.path[0])) b.current = module438.processColor(b.current);
            s(t.current, c.path, b.current);
          }
        }

        return !u;
      },
      onStart: function (t, o, l, u) {
        var c = [
          {
            value: v,
            path: [],
          },
        ];

        for (; c.length > 0; ) {
          var p = c.pop();
          if (Array.isArray(p.value))
            for (var h = 0; h < p.value.length; h++)
              c.push({
                value: p.value[h],
                path: p.path.concat(h),
              });
          else if ('object' == typeof p.value && undefined === p.value.onStart)
            for (var y = 0, b = Object.keys(p.value); y < b.length; y++) {
              var A = b[y];
              c.push({
                value: p.value[A],
                path: p.path.concat(A),
              });
            }
          else {
            var j = f(null == u ? undefined : u.styleAnimations, p.path),
              S = f(o, p.path);
            if (j && !S) S = j.current;
            if (undefined === S) console.warn('Initial values for animation are missing for property ' + p.path.join('.'));
            s(t.current, p.path, S);
            var k = undefined;
            if ('object' == typeof p.value && p.value.onStart) k = p.value;
            else {
              k = module439.withTiming(p.value, {
                duration: 0,
              });
              s(t.styleAnimations, p.path, k);
            }
            k.onStart(k, S, l, j);
          }
        }
      },
      current: {},
      styleAnimations: v,
      callback: function (t) {
        if (!t)
          for (var n = [v]; n.length > 0; ) {
            var o = n.pop();
            if (Array.isArray(o))
              for (var l, c = u(o); !(l = c()).done; ) {
                var f = l.value;
                n.push(f);
              }
            else if ('object' == typeof o && undefined === o.onStart)
              for (var s = 0, p = Object.values(o); s < p.length; s++) {
                var h = p[s];
                n.push(h);
              }
            else {
              var y = o;
              if (!y.finished && y.callback) y.callback(false);
            }
          }
      },
    };
  });
};

var module437 = require('./437'),
  module439 = require('./439'),
  module442 = require('./442'),
  module438 = require('./438');

function u(t, n) {
  var o = ('undefined' != typeof Symbol && t[Symbol.iterator]) || t['@@iterator'];
  if (o) return (o = o.call(t)).next.bind(o);

  if (Array.isArray(t) || (o = v(t)) || (n && t && 'number' == typeof t.length)) {
    if (o) t = o;
    var l = 0;
    return function () {
      return l >= t.length
        ? {
            done: true,
          }
        : {
            done: false,
            value: t[l++],
          };
    };
  }

  throw new TypeError('Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.');
}

function v(t, n) {
  if (t) {
    if ('string' == typeof t) return c(t, n);
    var o = Object.prototype.toString.call(t).slice(8, -1);
    if ('Object' === o && t.constructor) o = t.constructor.name;
    return 'Map' === o || 'Set' === o ? Array.from(t) : 'Arguments' === o || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(o) ? c(t, n) : undefined;
  }
}

function c(t, n) {
  if (null == n || n > t.length) n = t.length;

  for (var o = 0, l = new Array(n); o < n; o++) l[o] = t[o];

  return l;
}

function f(t, n) {
  'worklet';

  return (Array.isArray(n) ? n : [n]).reduce(function (t, n) {
    return Array.isArray(t) && 'number' == typeof n ? t[n] : null !== t && 'object' == typeof t && n in t ? t[n] : undefined;
  }, t);
}

function s(t, n, o) {
  'worklet';

  for (var l = Array.isArray(n) ? n : [n], u = t, v = 0; v < l.length - 1; v++) {
    u = u;
    if (!(l[v] in u)) 'number' == typeof l[v + 1] ? (u[l[v]] = []) : (u[l[v]] = {});
    u = u[l[v]];
  }

  u[l[l.length - 1]] = o;
}
