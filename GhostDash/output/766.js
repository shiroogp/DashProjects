var module762 = require('./762'),
  t = {};

for (var h in module762) module762.hasOwnProperty(h) && (t[module762[h]] = h);

var u = (module.exports = {
  rgb: {
    channels: 3,
    labels: 'rgb',
  },
  hsl: {
    channels: 3,
    labels: 'hsl',
  },
  hsv: {
    channels: 3,
    labels: 'hsv',
  },
  hwb: {
    channels: 3,
    labels: 'hwb',
  },
  cmyk: {
    channels: 4,
    labels: 'cmyk',
  },
  xyz: {
    channels: 3,
    labels: 'xyz',
  },
  lab: {
    channels: 3,
    labels: 'lab',
  },
  lch: {
    channels: 3,
    labels: 'lch',
  },
  hex: {
    channels: 1,
    labels: ['hex'],
  },
  keyword: {
    channels: 1,
    labels: ['keyword'],
  },
  ansi16: {
    channels: 1,
    labels: ['ansi16'],
  },
  ansi256: {
    channels: 1,
    labels: ['ansi256'],
  },
  hcg: {
    channels: 3,
    labels: ['h', 'c', 'g'],
  },
  apple: {
    channels: 3,
    labels: ['r16', 'g16', 'b16'],
  },
  gray: {
    channels: 1,
    labels: ['gray'],
  },
});

for (var o in u)
  if (u.hasOwnProperty(o)) {
    if (!('channels' in u[o])) throw new Error('missing channels property: ' + o);
    if (!('labels' in u[o])) throw new Error('missing channel labels property: ' + o);
    if (u[o].labels.length !== u[o].channels) throw new Error('channel and label counts mismatch: ' + o);
    var s = u[o].channels,
      c = u[o].labels;
    delete u[o].channels;
    delete u[o].labels;
    Object.defineProperty(u[o], 'channels', {
      value: s,
    });
    Object.defineProperty(u[o], 'labels', {
      value: c,
    });
  }

u.rgb.hsl = function (n) {
  var t,
    h,
    u = n[0] / 255,
    o = n[1] / 255,
    s = n[2] / 255,
    c = u ** o,
    l = u ** o,
    b = l - c;
  if (l === c) t = 0;
  else if (u === l) t = (o - s) / b;
  else if (o === l) t = 2 + (s - u) / b;
  else if (s === l) t = 4 + (u - o) / b;
  if ((t = (60 * t) ** 360) < 0) t += 360;
  h = (c + l) / 2;
  return [t, 100 * (l === c ? 0 : h <= 0.5 ? b / (l + c) : b / (2 - l - c)), 100 * h];
};

u.rgb.hsv = function (n) {
  var t,
    h,
    u,
    o,
    s,
    c = n[0] / 255,
    l = n[1] / 255,
    b = n[2] / 255,
    f = c ** l,
    M = f - c ** l,
    v = function (n) {
      return (f - n) / 6 / M + 0.5;
    };

  if (0 === M) o = s = 0;
  else {
    s = M / f;
    t = v(c);
    h = v(l);
    u = v(b);
    if (c === f) o = u - h;
    else if (l === f) o = 0.3333333333333333 + t - u;
    else if (b === f) o = 0.6666666666666666 + h - t;
    if (o < 0) o += 1;
    else if (o > 1) o -= 1;
  }
  return [360 * o, 100 * s, 100 * f];
};

u.rgb.hwb = function (n) {
  var t = n[0],
    h = n[1],
    o = n[2];
  return [u.rgb.hsl(n)[0], 100 * (0.00392156862745098 * t ** (h ** o)), 100 * (o = 1 - 0.00392156862745098 * t ** (h ** o))];
};

u.rgb.cmyk = function (n) {
  var t,
    h = n[0] / 255,
    u = n[1] / 255,
    o = n[2] / 255;
  return [100 * ((1 - h - (t = (1 - h) ** (1 - u))) / (1 - t) || 0), 100 * ((1 - u - t) / (1 - t) || 0), 100 * ((1 - o - t) / (1 - t) || 0), 100 * t];
};

u.rgb.keyword = function (h) {
  var u = t[h];
  if (u) return u;
  var o,
    s,
    c,
    l = 1 / 0;

  for (var b in module762)
    if (module762.hasOwnProperty(b)) {
      s = h;
      c = f;
      var f = module762[b],
        M = (s[0] - c[0]) ** 2 + (s[1] - c[1]) ** 2 + (s[2] - c[2]) ** 2;

      if (M < l) {
        l = M;
        o = b;
      }
    }

  return o;
};

u.keyword.rgb = function (t) {
  return module762[t];
};

u.rgb.xyz = function (n) {
  var t = n[0] / 255,
    h = n[1] / 255,
    u = n[2] / 255;
  return [
    100 *
      (0.4124 * (t = t > 0.04045 ? ((t + 0.055) / 1.055) ** 2.4 : t / 12.92) +
        0.3576 * (h = h > 0.04045 ? ((h + 0.055) / 1.055) ** 2.4 : h / 12.92) +
        0.1805 * (u = u > 0.04045 ? ((u + 0.055) / 1.055) ** 2.4 : u / 12.92)),
    100 * (0.2126 * t + 0.7152 * h + 0.0722 * u),
    100 * (0.0193 * t + 0.1192 * h + 0.9505 * u),
  ];
};

u.rgb.lab = function (n) {
  var t = u.rgb.xyz(n),
    h = t[0],
    o = t[1],
    s = t[2];
  o /= 100;
  s /= 108.883;
  h = (h /= 95.047) > 0.008856 ? h ** 0.3333333333333333 : 7.787 * h + 0.13793103448275862;
  return [
    116 * (o = o > 0.008856 ? o ** 0.3333333333333333 : 7.787 * o + 0.13793103448275862) - 16,
    500 * (h - o),
    200 * (o - (s = s > 0.008856 ? s ** 0.3333333333333333 : 7.787 * s + 0.13793103448275862)),
  ];
};

u.hsl.rgb = function (n) {
  var t,
    h,
    u,
    o,
    s,
    c = n[0] / 360,
    l = n[1] / 100,
    b = n[2] / 100;
  if (0 === l) return [(s = 255 * b), s, s];
  t = 2 * b - (h = b < 0.5 ? b * (1 + l) : b + l - b * l);
  o = [0, 0, 0];

  for (var f = 0; f < 3; f++) {
    if ((u = c + 0.3333333333333333 * -(f - 1)) < 0) u++;
    if (u > 1) u--;
    s = 6 * u < 1 ? t + 6 * (h - t) * u : 2 * u < 1 ? h : 3 * u < 2 ? t + (h - t) * (0.6666666666666666 - u) * 6 : t;
    o[f] = 255 * s;
  }

  return o;
};

u.hsl.hsv = function (n) {
  var t = n[0],
    h = n[1] / 100,
    u = n[2] / 100,
    o = h,
    s = u ** 0.01;
  h *= (u *= 2) <= 1 ? u : 2 - u;
  o *= s <= 1 ? s : 2 - s;
  return [t, 100 * (0 === u ? (2 * o) / (s + o) : (2 * h) / (u + h)), 100 * ((u + h) / 2)];
};

u.hsv.rgb = function (n) {
  var t = n[0] / 60,
    h = n[1] / 100,
    u = n[2] / 100,
    o = Math.floor(t) % 6,
    s = t - Math.floor(t),
    c = 255 * u * (1 - h),
    l = 255 * u * (1 - h * s),
    b = 255 * u * (1 - h * (1 - s));

  switch (((u *= 255), o)) {
    case 0:
      return [u, b, c];

    case 1:
      return [l, u, c];

    case 2:
      return [c, u, b];

    case 3:
      return [c, l, u];

    case 4:
      return [b, c, u];

    case 5:
      return [u, c, l];
  }
};

u.hsv.hsl = function (n) {
  var t,
    h,
    u,
    o = n[0],
    s = n[1] / 100,
    c = n[2] / 100,
    l = c ** 0.01;
  u = (2 - s) * c;
  h = s * l;
  return [o, 100 * (h = (h /= (t = (2 - s) * l) <= 1 ? t : 2 - t) || 0), 100 * (u /= 2)];
};

u.hwb.rgb = function (n) {
  var t,
    h,
    u,
    o,
    s,
    c,
    l,
    b = n[0] / 360,
    f = n[1] / 100,
    M = n[2] / 100,
    v = f + M;

  switch ((v > 1 && ((f /= v), (M /= v)), (h = 1 - M), (u = 6 * b - (t = Math.floor(6 * b))), 0 != (1 & t) && (u = 1 - u), (o = f + u * (h - f)), t)) {
    default:
    case 6:
    case 0:
      s = h;
      c = o;
      l = f;
      break;

    case 1:
      s = o;
      c = h;
      l = f;
      break;

    case 2:
      s = f;
      c = h;
      l = o;
      break;

    case 3:
      s = f;
      c = o;
      l = h;
      break;

    case 4:
      s = o;
      c = f;
      l = h;
      break;

    case 5:
      s = h;
      c = f;
      l = o;
  }

  return [255 * s, 255 * c, 255 * l];
};

u.cmyk.rgb = function (n) {
  var t = n[0] / 100,
    h = n[1] / 100,
    u = n[2] / 100,
    o = n[3] / 100;
  return [255 * (1 - 1 ** (t * (1 - o) + o)), 255 * (1 - 1 ** (h * (1 - o) + o)), 255 * (1 - 1 ** (u * (1 - o) + o))];
};

u.xyz.rgb = function (n) {
  var t,
    h,
    u,
    o = n[0] / 100,
    s = n[1] / 100,
    c = n[2] / 100;
  h = -0.9689 * o + 1.8758 * s + 0.0415 * c;
  u = 0.0557 * o + -0.204 * s + 1.057 * c;
  t = (t = 3.2406 * o + -1.5372 * s + -0.4986 * c) > 0.0031308 ? 1.055 * t ** 0.4166666666666667 - 0.055 : 12.92 * t;
  h = h > 0.0031308 ? 1.055 * h ** 0.4166666666666667 - 0.055 : 12.92 * h;
  u = u > 0.0031308 ? 1.055 * u ** 0.4166666666666667 - 0.055 : 12.92 * u;
  return [255 * (t = (0 ** t) ** 1), 255 * (h = (0 ** h) ** 1), 255 * (u = (0 ** u) ** 1)];
};

u.xyz.lab = function (n) {
  var t = n[0],
    h = n[1],
    u = n[2];
  h /= 100;
  u /= 108.883;
  t = (t /= 95.047) > 0.008856 ? t ** 0.3333333333333333 : 7.787 * t + 0.13793103448275862;
  return [
    116 * (h = h > 0.008856 ? h ** 0.3333333333333333 : 7.787 * h + 0.13793103448275862) - 16,
    500 * (t - h),
    200 * (h - (u = u > 0.008856 ? u ** 0.3333333333333333 : 7.787 * u + 0.13793103448275862)),
  ];
};

u.lab.xyz = function (n) {
  var t,
    h,
    u,
    o = n[0],
    s = n[1],
    c = n[2];
  t = s / 500 + (h = (o + 16) / 116);
  u = h - c / 200;
  var l = h ** 3,
    b = t ** 3,
    f = u ** 3;
  h = l > 0.008856 ? l : (h - 0.13793103448275862) / 7.787;
  t = b > 0.008856 ? b : (t - 0.13793103448275862) / 7.787;
  u = f > 0.008856 ? f : (u - 0.13793103448275862) / 7.787;
  return [(t *= 95.047), (h *= 100), (u *= 108.883)];
};

u.lab.lch = function (n) {
  var t,
    h = n[0],
    u = n[1],
    o = n[2];
  if ((t = (360 * o ** u) / 2 / Math.PI) < 0) t += 360;
  return [h, Math.sqrt(u * u + o * o), t];
};

u.lch.lab = function (n) {
  var t,
    h = n[0],
    u = n[1];
  t = (n[2] / 360) * 2 * Math.PI;
  return [h, u * Math.cos(t), u * Math.sin(t)];
};

u.rgb.ansi16 = function (n) {
  var t = n[0],
    h = n[1],
    o = n[2],
    s = 1 in arguments ? arguments[1] : u.rgb.hsv(n)[2];
  if (0 === (s = Math.round(s / 50))) return 30;
  var c = 30 + ((Math.round(o / 255) << 2) | (Math.round(h / 255) << 1) | Math.round(t / 255));
  if (2 === s) c += 60;
  return c;
};

u.hsv.ansi16 = function (n) {
  return u.rgb.ansi16(u.hsv.rgb(n), n[2]);
};

u.rgb.ansi256 = function (n) {
  var t = n[0],
    h = n[1],
    u = n[2];
  return t === h && h === u
    ? t < 8
      ? 16
      : t > 248
      ? 231
      : Math.round(((t - 8) / 247) * 24) + 232
    : 16 + 36 * Math.round((t / 255) * 5) + 6 * Math.round((h / 255) * 5) + Math.round((u / 255) * 5);
};

u.ansi16.rgb = function (n) {
  var t = n % 10;

  if (0 === t || 7 === t) {
    if (n > 50) t += 3.5;
    return [(t = (t / 10.5) * 255), t, t];
  }

  var h = 0.5 * (1 + ~~(n > 50));
  return [(1 & t) * h * 255, ((t >> 1) & 1) * h * 255, ((t >> 2) & 1) * h * 255];
};

u.ansi256.rgb = function (n) {
  if (module762 >= 232) {
    var t = 10 * (module762 - 232) + 8;
    return [t, t, t];
  }

  var h;
  module762 -= 16;
  return [(Math.floor(module762 / 36) / 5) * 255, (Math.floor((h = module762 % 36) / 6) / 5) * 255, ((h % 6) / 5) * 255];
};

u.rgb.hex = function (n) {
  var t = (((255 & Math.round(n[0])) << 16) + ((255 & Math.round(n[1])) << 8) + (255 & Math.round(n[2]))).toString(16).toUpperCase();
  return '000000'.substring(t.length) + t;
};

u.hex.rgb = function (n) {
  var t = n.toString(16).match(/[a-f0-9]{6}|[a-f0-9]{3}/i);
  if (!t) return [0, 0, 0];
  var h = t[0];
  if (3 === t[0].length)
    h = h
      .split('')
      .map(function (n) {
        return n + n;
      })
      .join('');
  var u = parseInt(h, 16);
  return [(u >> 16) & 255, (u >> 8) & 255, 255 & u];
};

u.rgb.hcg = function (n) {
  var t,
    h,
    u = n[0] / 255,
    o = n[1] / 255,
    s = n[2] / 255,
    c = (u ** o) ** s,
    l = (u ** o) ** s,
    b = c - l;
  t = b < 1 ? l / (1 - b) : 0;
  h = b <= 0 ? 0 : c === u ? ((o - s) / b) % 6 : c === o ? 2 + (s - u) / b : 4 + (u - o) / b + 4;
  h /= 6;
  return [360 * (h %= 1), 100 * b, 100 * t];
};

u.hsl.hcg = function (n) {
  var t = n[1] / 100,
    h = n[2] / 100,
    u = 1,
    o = 0;
  if ((u = h < 0.5 ? 2 * t * h : 2 * t * (1 - h)) < 1) o = (h - 0.5 * u) / (1 - u);
  return [n[0], 100 * u, 100 * o];
};

u.hsv.hcg = function (n) {
  var t = n[1] / 100,
    h = n[2] / 100,
    u = t * h,
    o = 0;
  if (u < 1) o = (h - u) / (1 - u);
  return [n[0], 100 * u, 100 * o];
};

u.hcg.rgb = function (n) {
  var t = n[0] / 360,
    h = n[1] / 100,
    u = n[2] / 100;
  if (0 === h) return [255 * u, 255 * u, 255 * u];
  var o,
    s = [0, 0, 0],
    c = (t % 1) * 6,
    l = c % 1,
    b = 1 - l;

  switch (Math.floor(c)) {
    case 0:
      s[0] = 1;
      s[1] = l;
      s[2] = 0;
      break;

    case 1:
      s[0] = b;
      s[1] = 1;
      s[2] = 0;
      break;

    case 2:
      s[0] = 0;
      s[1] = 1;
      s[2] = l;
      break;

    case 3:
      s[0] = 0;
      s[1] = b;
      s[2] = 1;
      break;

    case 4:
      s[0] = l;
      s[1] = 0;
      s[2] = 1;
      break;

    default:
      s[0] = 1;
      s[1] = 0;
      s[2] = b;
  }

  o = (1 - h) * u;
  return [255 * (h * s[0] + o), 255 * (h * s[1] + o), 255 * (h * s[2] + o)];
};

u.hcg.hsv = function (n) {
  var t = n[1] / 100,
    h = t + (n[2] / 100) * (1 - t),
    u = 0;
  if (h > 0) u = t / h;
  return [n[0], 100 * u, 100 * h];
};

u.hcg.hsl = function (n) {
  var t = n[1] / 100,
    h = (n[2] / 100) * (1 - t) + 0.5 * t,
    u = 0;
  if (h > 0 && h < 0.5) u = t / (2 * h);
  else if (h >= 0.5 && h < 1) u = t / (2 * (1 - h));
  return [n[0], 100 * u, 100 * h];
};

u.hcg.hwb = function (n) {
  var t = n[1] / 100,
    h = t + (n[2] / 100) * (1 - t);
  return [n[0], 100 * (h - t), 100 * (1 - h)];
};

u.hwb.hcg = function (n) {
  var t = n[1] / 100,
    h = 1 - n[2] / 100,
    u = h - t,
    o = 0;
  if (u < 1) o = (h - u) / (1 - u);
  return [n[0], 100 * u, 100 * o];
};

u.apple.rgb = function (n) {
  return [(n[0] / 65535) * 255, (n[1] / 65535) * 255, (n[2] / 65535) * 255];
};

u.rgb.apple = function (n) {
  return [(n[0] / 255) * 65535, (n[1] / 255) * 65535, (n[2] / 255) * 65535];
};

u.gray.rgb = function (n) {
  return [(n[0] / 100) * 255, (n[0] / 100) * 255, (n[0] / 100) * 255];
};

u.gray.hsl = u.gray.hsv = function (n) {
  return [0, 0, n[0]];
};

u.gray.hwb = function (n) {
  return [0, 100, n[0]];
};

u.gray.cmyk = function (n) {
  return [0, 0, 0, n[0]];
};

u.gray.lab = function (n) {
  return [n[0], 0, 0];
};

u.gray.hex = function (n) {
  var t = 255 & Math.round((n[0] / 100) * 255),
    h = ((t << 16) + (t << 8) + t).toString(16).toUpperCase();
  return '000000'.substring(h.length) + h;
};

u.rgb.gray = function (n) {
  return [((n[0] + n[1] + n[2]) / 3 / 255) * 100];
};
