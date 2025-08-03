exports.createMapperRegistry = l;

exports.startMapper = function (t) {
  var o = arguments.length > 1 && undefined !== arguments[1] ? arguments[1] : [],
    u = arguments.length > 2 && undefined !== arguments[2] ? arguments[2] : [],
    f = (p += 1);
  module426.runOnUI(function () {
    var n = globals.__mapperRegistry;
    if (undefined === n) n = globals.__mapperRegistry = l();
    n.start(f, t, o, u);
  })();
  return f;
};

exports.stopMapper = function (t) {
  module426.runOnUI(function () {
    var n = globals.__mapperRegistry;
    if (!(null == n)) n.stop(t);
  })();
};

var module421 = require('./421'),
  module426 = require('./426'),
  module427 = require('./427');

function u(t, n) {
  var o = ('undefined' != typeof Symbol && t[Symbol.iterator]) || t['@@iterator'];
  if (o) return (o = o.call(t)).next.bind(o);

  if (Array.isArray(t) || (o = f(t)) || (n && t && 'number' == typeof t.length)) {
    if (o) t = o;
    var u = 0;
    return function () {
      return u >= t.length
        ? {
            done: true,
          }
        : {
            done: false,
            value: t[u++],
          };
    };
  }

  throw new TypeError('Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.');
}

function f(t, n) {
  if (t) {
    if ('string' == typeof t) return s(t, n);
    var o = Object.prototype.toString.call(t).slice(8, -1);
    if ('Object' === o && t.constructor) o = t.constructor.name;
    return 'Map' === o || 'Set' === o ? Array.from(t) : 'Arguments' === o || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(o) ? s(t, n) : undefined;
  }
}

function s(t, n) {
  if (null == n || n > t.length) n = t.length;

  for (var o = 0, u = new Array(n); o < n; o++) u[o] = t[o];

  return u;
}

var v = module421.isJest();

function l() {
  'worklet';

  var t = new Map(),
    n = [],
    f = false,
    s = false;

  function l() {
    var o = new Map();
    t.forEach(function (t) {
      if (t.outputs)
        for (var n, f = u(t.outputs); !(n = f()).done; ) {
          var s = n.value,
            v = o.get(s);
          if (undefined === v) o.set(s, [t]);
          else v.push(t);
        }
    });
    var f = new Set(),
      s = [];

    function v(t) {
      f.add(t);

      for (var n, l = u(t.inputs); !(n = l()).done; ) {
        var p = n.value,
          c = o.get(p);
        if (c)
          for (var y, h = u(c); !(y = h()).done; ) {
            var b = y.value;
            if (!f.has(b)) v(b);
          }
      }

      s.push(t);
    }

    t.forEach(function (t) {
      if (!f.has(t)) v(t);
    });
    n = s;
  }

  function p() {
    if (((f = false), !s)) {
      s = true;
      if (t.size !== n.length) l();

      for (var o, v = u(n); !(o = v()).done; ) {
        var p = o.value;

        if (p.dirty) {
          p.dirty = false;
          p.worklet();
        }
      }

      s = false;
    }
  }

  function c() {
    if (v) p();
    else if (!f) {
      if (s) requestAnimationFrame(p);
      else queueMicrotask(p);
      f = true;
    }
  }

  function y(t, n) {
    if (Array.isArray(t))
      for (var f, s = u(t); !(f = s()).done; ) {
        var v = f.value;
        if (v) y(v, n);
      }
    else if (module427.isSharedValue(t)) n.push(t);
    else if (Object.getPrototypeOf(t) === Object.prototype)
      for (var l = 0, p = Object.values(t); l < p.length; l++) {
        var c = p[l];
        if (c) y(c, n);
      }
    return n;
  }

  return {
    start: function (o, f, s, v) {
      var l = {
        id: o,
        dirty: true,
        worklet: f,
        inputs: y(s, []),
        outputs: v,
      };
      t.set(l.id, l);
      n = [];

      for (var p, h = u(l.inputs); !(p = h()).done; ) {
        p.value.addListener(l.id, function () {
          l.dirty = true;
          c();
        });
      }

      c();
    },
    stop: function (o) {
      var f = t.get(o);

      if (f) {
        t.delete(f.id);
        n = [];

        for (var s, v = u(f.inputs); !(s = v()).done; ) {
          s.value.removeListener(f.id);
        }
      }
    },
  };
}

var p = 9999;
