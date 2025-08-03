exports.default = function (t) {
  return o(t, new Set(), []);
};

var o = function t(o, l, f) {
  if (undefined === o || null === o || 'boolean' == typeof o || 'number' == typeof o || 'string' == typeof o)
    return {
      serializable: true,
    };
  if ('[object Object]' !== Object.prototype.toString.call(o) && !Array.isArray(o))
    return {
      serializable: false,
      location: f,
      reason: 'function' == typeof o ? 'Function' : String(o),
    };
  if (l.has(o))
    return {
      serializable: false,
      reason: 'Circular reference',
      location: f,
    };
  if ((l.add(o), Array.isArray(o)))
    for (var u = 0; u < o.length; u++) {
      var c = t(o[u], new Set(l), [].concat(module23.default(f), [u]));
      if (!c.serializable) return c;
    }
  else
    for (var s in o) {
      var b = t(o[s], new Set(l), [].concat(module23.default(f), [s]));
      if (!b.serializable) return b;
    }
  return {
    serializable: true,
  };
};
