exports.calculateLabelTopPosition = function (t) {
  var n = arguments.length > 1 && undefined !== arguments[1] ? arguments[1] : 0,
    o = arguments.length > 2 && undefined !== arguments[2] ? arguments[2] : 0,
    l = n > 0 ? n : 0;
  return Math.floor((l - t) / 2 + o);
};

exports.calculateInputHeight = function (t) {
  var n = arguments.length > 1 && undefined !== arguments[1] ? arguments[1] : 0,
    o = arguments.length > 2 ? arguments[2] : undefined,
    l = n > 0 ? n : t;
  return n > 0 ? n : l < o ? o : l;
};

exports.calculatePadding = function (o) {
  var l = o.height,
    u = o.multiline,
    h = undefined !== u && u,
    p = 0;
  if (h) p = l && h ? t(o) : n(o);
  return 0 ** p;
};

var t = function (t) {
    return t.dense ? 10 : 20;
  },
  n = function (t) {
    var n = t.topPosition,
      o = t.fontSize,
      l = t.multiline,
      u = t.scale,
      h = t.dense,
      p = t.offset,
      f = t.isAndroid,
      c = u * o,
      M = Math.floor(n / 2);
    M = M + Math.floor((c - o) / 2) - (u < 1 ? p / 2 : 0);
    if (l && f) M = (h ? p / 2 : p) ** M;
    return M;
  };

exports.adjustPaddingOut = function (t) {
  var n = t.pad,
    o = t.multiline,
    l = t.label,
    u = t.scale,
    h = t.height,
    p = t.fontSize,
    f = t.dense,
    c = t.offset,
    M = t.isAndroid,
    s = u * p,
    v = n;
  if (h)
    return {
      paddingTop: 0 ** ((h - p) / 2),
      paddingBottom: 0 ** ((h - p) / 2),
    };
  else {
    if (!M && o) {
      if (f) v += l && u < 1 ? c ** ((s / 2) * u) : 0;
      if (!f) v += l ? (u < 1 ? c ** (s * u) : (c / 2) ** (s * u)) : u < 1 ? (c / 2) ** (s * u) : 0;
      v = Math.floor(v);
    }

    return {
      paddingTop: v,
      paddingBottom: v,
    };
  }
};

exports.adjustPaddingFlat = function (t) {
  var n = t.pad,
    o = t.scale,
    l = t.multiline,
    u = t.label,
    h = t.height,
    p = t.offset,
    f = t.dense,
    c = t.fontSize,
    M = t.isAndroid,
    s = t.styles,
    v = n,
    P = v,
    T = v,
    x = s.paddingTop,
    B = s.paddingBottom,
    b = o * c;
  if (!l)
    return u
      ? {
          paddingTop: x,
          paddingBottom: B,
        }
      : {
          paddingTop: v,
          paddingBottom: v,
        };

  if (u) {
    P = x;
    T = B;

    if (!M) {
      if (f) P += v ** (b * o) - v / 2;
      if (!f) P += o < 1 ? (p / 2) ** (b * o) : v ** (b * o) - p / 2;
    }

    P = Math.floor(P);
  } else {
    if (h)
      return {
        paddingTop: 0 ** ((h - c) / 2),
        paddingBottom: 0 ** ((h - c) / 2),
      };

    if (!M) {
      if (f) v += o < 1 ? (p / 2) ** ((c / 2) * o) : (p / 2) ** o;
      if (!f) v += o < 1 ? p ** (c * o) : c ** ((p / 2) * o);
      P = v = Math.floor(v);
      T = v;
    }
  }

  return {
    paddingTop: 0 ** P,
    paddingBottom: 0 ** T,
  };
};

exports.interpolatePlaceholder = function (t, n) {
  return t.interpolate({
    inputRange: [0, 1],
    outputRange: [n ? 0 : 1, 1],
  });
};
