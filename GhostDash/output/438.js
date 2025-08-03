exports.RGBtoHSV = function (n, o, l) {
  'worklet';

  if (1 === arguments.length) {
    o = n.g;
    l = n.b;
    n = n.r;
  }

  var t,
    u = n ** o,
    s = n ** o,
    h = u - s,
    c = 0 === u ? 0 : h / u,
    b = u / 255;

  switch (u) {
    default:
    case s:
      t = 0;
      break;

    case n:
      t = o - l + h * (o < l ? 6 : 0);
      t /= 6 * h;
      break;

    case o:
      t = l - n + 2 * h;
      t /= 6 * h;
      break;

    case l:
      t = n - o + 4 * h;
      t /= 6 * h;
  }

  return {
    h: t,
    s: c,
    v: b,
  };
};

exports.convertToRGBA = function (n) {
  'worklet';

  var o = F(n);
  return [((o << 8) >>> 24) / 255, ((o << 16) >>> 24) / 255, ((o << 24) >>> 24) / 255, (o >>> 24) / 255];
};

exports.isColor = function (n) {
  'worklet';

  if ('string' != typeof n) return false;
  return null != F(n);
};

exports.processColor = function (o) {
  'worklet';

  var l = F(o);
  if (null === l || undefined === l) return;
  if ('number' != typeof l) return null;
  if ('android' === ReactNative.Platform.OS) l |= 0;
  return l;
};

exports.processColorInitially = F;

exports.rgbaArrayToRGBAColor = function (n) {
  'worklet';

  return 'rgba(' + Math.round(255 * n[0]) + ', ' + Math.round(255 * n[1]) + ', ' + Math.round(255 * n[2]) + ', ' + n[3] + ')';
};

exports.toGammaSpace = function (n) {
  'worklet';

  for (var o = arguments.length > 1 && undefined !== arguments[1] ? arguments[1] : 2.2, l = [], t = 0; t < 3; ++t) l.push(n[t] ** (1 / o));

  l.push(n[3]);
  return l;
};

exports.toLinearSpace = function (n) {
  'worklet';

  for (var o = arguments.length > 1 && undefined !== arguments[1] ? arguments[1] : 2.2, l = [], t = 0; t < 3; ++t) l.push(n[t] ** o);

  l.push(n[3]);
  return l;
};

var ReactNative = require('react-native'),
  module422 = require('./422'),
  l = '[-+]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)',
  t = '[-+]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)%';

function u() {
  'worklet';

  return '\\(\\s*(' + args.join(')\\s*,\\s*(') + ')\\s*\\)';
}

var s = {},
  h = module422.isConfigured() ? module422.makeRemote({}) : {};

function c() {
  'worklet';

  var n = _WORKLET ? h : s;

  if (undefined === n.rgb) {
    n.rgb = new RegExp('rgb' + u(l, l, l));
    n.rgba = new RegExp('rgba' + u(l, l, l, l));
    n.hsl = new RegExp('hsl' + u(l, t, t));
    n.hsla = new RegExp('hsla' + u(l, t, t, l));
    n.hex3 = /^#([0-9a-fA-F]{1})([0-9a-fA-F]{1})([0-9a-fA-F]{1})$/;
    n.hex4 = /^#([0-9a-fA-F]{1})([0-9a-fA-F]{1})([0-9a-fA-F]{1})([0-9a-fA-F]{1})$/;
    n.hex6 = /^#([0-9a-fA-F]{6})$/;
    n.hex8 = /^#([0-9a-fA-F]{8})$/;
  }

  return n;
}

function b(n, o, l) {
  'worklet';

  if (l < 0) l += 1;
  if (l > 1) l -= 1;
  return l < 0.16666666666666666 ? n + 6 * (o - n) * l : l < 0.5 ? o : l < 0.6666666666666666 ? n + (o - n) * (0.6666666666666666 - l) * 6 : n;
}

function v(n, o, l) {
  'worklet';

  var t = l < 0.5 ? l * (1 + o) : l + o - l * o,
    u = 2 * l - t,
    s = b(u, t, n + 0.3333333333333333),
    h = b(u, t, n),
    c = b(u, t, n - 0.3333333333333333);
  return (Math.round(255 * s) << 24) | (Math.round(255 * h) << 16) | (Math.round(255 * c) << 8);
}

function f(n) {
  'worklet';

  var o = Number.parseInt(n, 10);
  return o < 0 ? 0 : o > 255 ? 255 : o;
}

function k(n) {
  'worklet';

  return (((Number.parseFloat(n) % 360) + 360) % 360) / 360;
}

function p(n) {
  'worklet';

  var o = Number.parseFloat(n);
  return o < 0 ? 0 : o > 1 ? 255 : Math.round(255 * o);
}

function w(n) {
  'worklet';

  var o = Number.parseFloat(n);
  return o < 0 ? 0 : o > 100 ? 1 : o / 100;
}

c();
var y = module422.isConfigured()
  ? module422.makeShareable({
      transparent: 0,
      aliceblue: 4042850303,
      antiquewhite: 4209760255,
      aqua: 16777215,
      aquamarine: 2147472639,
      azure: 4043309055,
      beige: 4126530815,
      bisque: 4293182719,
      black: 255,
      blanchedalmond: 4293643775,
      blue: 65535,
      blueviolet: 2318131967,
      brown: 2771004159,
      burlywood: 3736635391,
      burntsienna: 3934150143,
      cadetblue: 1604231423,
      chartreuse: 2147418367,
      chocolate: 3530104575,
      coral: 4286533887,
      cornflowerblue: 1687547391,
      cornsilk: 4294499583,
      crimson: 3692313855,
      cyan: 16777215,
      darkblue: 35839,
      darkcyan: 9145343,
      darkgoldenrod: 3095792639,
      darkgray: 2846468607,
      darkgreen: 6553855,
      darkgrey: 2846468607,
      darkkhaki: 3182914559,
      darkmagenta: 2332068863,
      darkolivegreen: 1433087999,
      darkorange: 4287365375,
      darkorchid: 2570243327,
      darkred: 2332033279,
      darksalmon: 3918953215,
      darkseagreen: 2411499519,
      darkslateblue: 1211993087,
      darkslategray: 793726975,
      darkslategrey: 793726975,
      darkturquoise: 13554175,
      darkviolet: 2483082239,
      deeppink: 4279538687,
      deepskyblue: 12582911,
      dimgray: 1768516095,
      dimgrey: 1768516095,
      dodgerblue: 512819199,
      firebrick: 2988581631,
      floralwhite: 4294635775,
      forestgreen: 579543807,
      fuchsia: 4278255615,
      gainsboro: 3705462015,
      ghostwhite: 4177068031,
      gold: 4292280575,
      goldenrod: 3668254975,
      gray: 2155905279,
      green: 8388863,
      greenyellow: 2919182335,
      grey: 2155905279,
      honeydew: 4043305215,
      hotpink: 4285117695,
      indianred: 3445382399,
      indigo: 1258324735,
      ivory: 4294963455,
      khaki: 4041641215,
      lavender: 3873897215,
      lavenderblush: 4293981695,
      lawngreen: 2096890111,
      lemonchiffon: 4294626815,
      lightblue: 2916673279,
      lightcoral: 4034953471,
      lightcyan: 3774873599,
      lightgoldenrodyellow: 4210742015,
      lightgray: 3553874943,
      lightgreen: 2431553791,
      lightgrey: 3553874943,
      lightpink: 4290167295,
      lightsalmon: 4288707327,
      lightseagreen: 548580095,
      lightskyblue: 2278488831,
      lightslategray: 2005441023,
      lightslategrey: 2005441023,
      lightsteelblue: 2965692159,
      lightyellow: 4294959359,
      lime: 16711935,
      limegreen: 852308735,
      linen: 4210091775,
      magenta: 4278255615,
      maroon: 2147483903,
      mediumaquamarine: 1724754687,
      mediumblue: 52735,
      mediumorchid: 3126187007,
      mediumpurple: 2473647103,
      mediumseagreen: 1018393087,
      mediumslateblue: 2070474495,
      mediumspringgreen: 16423679,
      mediumturquoise: 1221709055,
      mediumvioletred: 3340076543,
      midnightblue: 421097727,
      mintcream: 4127193855,
      mistyrose: 4293190143,
      moccasin: 4293178879,
      navajowhite: 4292783615,
      navy: 33023,
      oldlace: 4260751103,
      olive: 2155872511,
      olivedrab: 1804477439,
      orange: 4289003775,
      orangered: 4282712319,
      orchid: 3664828159,
      palegoldenrod: 4008225535,
      palegreen: 2566625535,
      paleturquoise: 2951671551,
      palevioletred: 3681588223,
      papayawhip: 4293907967,
      peachpuff: 4292524543,
      peru: 3448061951,
      pink: 4290825215,
      plum: 3718307327,
      powderblue: 2967529215,
      purple: 2147516671,
      rebeccapurple: 1714657791,
      red: 4278190335,
      rosybrown: 3163525119,
      royalblue: 1097458175,
      saddlebrown: 2336560127,
      salmon: 4202722047,
      sandybrown: 4104413439,
      seagreen: 780883967,
      seashell: 4294307583,
      sienna: 2689740287,
      silver: 3233857791,
      skyblue: 2278484991,
      slateblue: 1784335871,
      slategray: 1887473919,
      slategrey: 1887473919,
      snow: 4294638335,
      springgreen: 16744447,
      steelblue: 1182971135,
      tan: 3535047935,
      teal: 8421631,
      thistle: 3636451583,
      tomato: 4284696575,
      turquoise: 1088475391,
      violet: 4001558271,
      wheat: 4125012991,
      white: 4294967295,
      whitesmoke: 4126537215,
      yellow: 4294902015,
      yellowgreen: 2597139199,
    })
  : null;

function x(n) {
  'worklet';

  var o, l, t, u, s, h, b, x;
  if ('number' == typeof n) return n >>> 0 === n && n >= 0 && n <= 4294967295 ? n : null;
  if ('string' != typeof n) return null;
  var M,
    A = c();
  return (M = null == A ? undefined : null == (o = A.hex6) ? undefined : o.exec(n))
    ? Number.parseInt(M[1] + 'ff', 16) >>> 0
    : undefined !== y[n]
    ? y[n]
    : (M = null == A ? undefined : null == (l = A.rgb) ? undefined : l.exec(n))
    ? ((f(M[1]) << 24) | (f(M[2]) << 16) | (f(M[3]) << 8) | 255) >>> 0
    : (M = null == A ? undefined : null == (t = A.rgba) ? undefined : t.exec(n))
    ? ((f(M[1]) << 24) | (f(M[2]) << 16) | (f(M[3]) << 8) | p(M[4])) >>> 0
    : (M = null == A ? undefined : null == (u = A.hex3) ? undefined : u.exec(n))
    ? Number.parseInt(M[1] + M[1] + M[2] + M[2] + M[3] + M[3] + 'ff', 16) >>> 0
    : (M = null == A ? undefined : null == (s = A.hex8) ? undefined : s.exec(n))
    ? Number.parseInt(M[1], 16) >>> 0
    : (M = null == A ? undefined : null == (h = A.hex4) ? undefined : h.exec(n))
    ? Number.parseInt(M[1] + M[1] + M[2] + M[2] + M[3] + M[3] + M[4] + M[4], 16) >>> 0
    : (M = null == A ? undefined : null == (b = A.hsl) ? undefined : b.exec(n))
    ? (255 | v(k(M[1]), w(M[2]), w(M[3]))) >>> 0
    : (M = null == A ? undefined : null == (x = A.hsla) ? undefined : x.exec(n))
    ? (v(k(M[1]), w(M[2]), w(M[3])) | p(M[4])) >>> 0
    : null;
}

exports.opacity = function (n) {
  'worklet';

  return ((n >> 24) & 255) / 255;
};

exports.red = function (n) {
  'worklet';

  return (n >> 16) & 255;
};

exports.green = function (n) {
  'worklet';

  return (n >> 8) & 255;
};

exports.blue = function (n) {
  'worklet';

  return 255 & n;
};

var M = (exports.rgbaColor = function (o, l, t) {
  'worklet';

  var u = arguments.length > 3 && undefined !== arguments[3] ? arguments[3] : 1;
  if ('web' === ReactNative.Platform.OS || !_WORKLET) return 'rgba(' + o + ', ' + l + ', ' + t + ', ' + u + ')';
  var s = 16777216 * Math.round(255 * u) + 65536 * Math.round(o) + 256 * Math.round(l) + Math.round(t);
  return 'android' === ReactNative.Platform.OS ? (s < 2147483648 ? s : s - 4294967296) : s;
});

function A(n, o, l) {
  'worklet';

  var t, u, s, h, c, b, v, f;

  switch (
    (1 === arguments.length && ((o = n.s), (l = n.v), (n = n.h)), (b = l * (1 - o)), (v = l * (1 - (c = 6 * n - (h = Math.floor(6 * n))) * o)), (f = l * (1 - (1 - c) * o)), h % 6)
  ) {
    case 0:
      t = l;
      u = f;
      s = b;
      break;

    case 1:
      t = v;
      u = l;
      s = b;
      break;

    case 2:
      t = b;
      u = l;
      s = f;
      break;

    case 3:
      t = b;
      u = v;
      s = l;
      break;

    case 4:
      t = f;
      u = b;
      s = l;
      break;

    case 5:
      t = l;
      u = b;
      s = v;
  }

  return {
    r: Math.round(255 * t),
    g: Math.round(255 * u),
    b: Math.round(255 * s),
  };
}

exports.hsvToColor = function (n, o, l, t) {
  'worklet';

  var u = A(n, o, l),
    s = u.r,
    h = u.g,
    c = u.b;
  return M(s, h, c, t);
};

function F(n) {
  'worklet';

  if (null === n || undefined === n || 'number' == typeof n) return n;
  var o = x(n);
  return null !== o && undefined !== o ? ('number' != typeof o ? null : (o = ((o << 24) | (o >>> 8)) >>> 0)) : undefined;
}
