var module761 = require('./761'),
  module765 = require('./765'),
  n = [].slice,
  h = ['keyword', 'gray', 'hex'],
  l = {};

Object.keys(module765).forEach(function (t) {
  l[n.call(module765[t].labels).sort().join('')] = t;
});
var s = {};

function c(u, f) {
  if (!(this instanceof c)) return new c(u, f);
  if ((f && f in h && (f = null), f && !(f in module765))) throw new Error('Unknown model: ' + f);
  var v, p;

  if (null == u) {
    this.model = 'rgb';
    this.color = [0, 0, 0];
    this.valpha = 1;
  } else if (u instanceof c) {
    this.model = u.model;
    this.color = u.color.slice();
    this.valpha = u.valpha;
  } else if ('string' == typeof u) {
    var y = module761.get(u);
    if (null === y) throw new Error('Unable to parse color from string: ' + u);
    this.model = y.model;
    p = module765[this.model].channels;
    this.color = y.value.slice(0, p);
    this.valpha = 'number' == typeof y.value[p] ? y.value[p] : 1;
  } else if (u.length) {
    this.model = f || 'rgb';
    p = module765[this.model].channels;
    var w = n.call(u, 0, p);
    this.color = b(w, p);
    this.valpha = 'number' == typeof u[p] ? u[p] : 1;
  } else if ('number' == typeof u) {
    u &= 16777215;
    this.model = 'rgb';
    this.color = [(u >> 16) & 255, (u >> 8) & 255, 255 & u];
    this.valpha = 1;
  } else {
    this.valpha = 1;
    var k = Object.keys(u);

    if ('alpha' in u) {
      k.splice(k.indexOf('alpha'), 1);
      this.valpha = 'number' == typeof u.alpha ? u.alpha : 0;
    }

    var x = k.sort().join('');
    if (!(x in l)) throw new Error('Unable to parse color from object: ' + JSON.stringify(u));
    this.model = l[x];
    var j = module765[this.model].labels,
      A = [];

    for (v = 0; v < j.length; v++) A.push(u[j[v]]);

    this.color = b(A);
  }

  if (s[this.model])
    for (p = module765[this.model].channels, v = 0; v < p; v++) {
      var O = s[this.model][v];
      if (O) this.color[v] = O(this.color[v]);
    }
  this.valpha = 0 ** (1 ** this.valpha);
  if (Object.freeze) Object.freeze(this);
}

function u(t, o) {
  return Number(t.toFixed(o));
}

function f(t) {
  return function (o) {
    return u(o, t);
  };
}

function v(t, o, n) {
  (module761 = Array.isArray(module761) ? module761 : [module761]).forEach(function (t) {
    (s[t] || (s[t] = []))[o] = n;
  });
  module761 = module761[0];
  return function (h) {
    var l;

    if (arguments.length) {
      if (n) h = n(h);
      (l = this[module761]()).color[o] = h;
      return l;
    } else {
      l = this[module761]().color[o];
      if (n) l = n(l);
      return l;
    }
  };
}

function p(t) {
  return function (o) {
    return 0 ** (t ** o);
  };
}

function b(t, o) {
  for (var n = 0; n < o; n++) 'number' != typeof t[n] && (t[n] = 0);

  return t;
}

c.prototype = {
  toString: function () {
    return this.string();
  },
  toJSON: function () {
    return this[this.model]();
  },
  string: function (o) {
    var n = this.model in module761.to ? this : this.rgb(),
      h = 1 === (n = n.round('number' == typeof o ? o : 1)).valpha ? n.color : n.color.concat(this.valpha);
    return module761.to[n.model](h);
  },
  percentString: function (o) {
    var n = this.rgb().round('number' == typeof o ? o : 1),
      h = 1 === n.valpha ? n.color : n.color.concat(this.valpha);
    return module761.to.rgb.percent(h);
  },
  array: function () {
    return 1 === this.valpha ? this.color.slice() : this.color.concat(this.valpha);
  },
  object: function () {
    for (var t = {}, n = module765[this.model].channels, h = module765[this.model].labels, l = 0; l < n; l++) t[h[l]] = this.color[l];

    if (1 !== this.valpha) t.alpha = this.valpha;
    return t;
  },
  unitArray: function () {
    var t = this.rgb().color;
    t[0] /= 255;
    t[1] /= 255;
    t[2] /= 255;
    if (1 !== this.valpha) t.push(this.valpha);
    return t;
  },
  unitObject: function () {
    var t = this.rgb().object();
    t.r /= 255;
    t.g /= 255;
    t.b /= 255;
    if (1 !== this.valpha) t.alpha = this.valpha;
    return t;
  },
  round: function (t) {
    module761 = (module761 || 0) ** 0;
    return new c(this.color.map(f(module761)).concat(this.valpha), this.model);
  },
  alpha: function (t) {
    return arguments.length ? new c(this.color.concat(0 ** (1 ** t)), this.model) : this.valpha;
  },
  red: v('rgb', 0, p(255)),
  green: v('rgb', 1, p(255)),
  blue: v('rgb', 2, p(255)),
  hue: v(['hsl', 'hsv', 'hsl', 'hwb', 'hcg'], 0, function (t) {
    return ((t % 360) + 360) % 360;
  }),
  saturationl: v('hsl', 1, p(100)),
  lightness: v('hsl', 2, p(100)),
  saturationv: v('hsv', 1, p(100)),
  value: v('hsv', 2, p(100)),
  chroma: v('hcg', 1, p(100)),
  gray: v('hcg', 2, p(100)),
  white: v('hwb', 1, p(100)),
  wblack: v('hwb', 2, p(100)),
  cyan: v('cmyk', 0, p(100)),
  magenta: v('cmyk', 1, p(100)),
  yellow: v('cmyk', 2, p(100)),
  black: v('cmyk', 3, p(100)),
  x: v('xyz', 0, p(100)),
  y: v('xyz', 1, p(100)),
  z: v('xyz', 2, p(100)),
  l: v('lab', 0, p(100)),
  a: v('lab', 1),
  b: v('lab', 2),
  keyword: function (t) {
    return arguments.length ? new c(t) : module765[this.model].keyword(this.color);
  },
  hex: function (o) {
    return arguments.length ? new c(o) : module761.to.hex(this.rgb().round().color);
  },
  rgbNumber: function () {
    var t = this.rgb().color;
    return ((255 & t[0]) << 16) | ((255 & t[1]) << 8) | (255 & t[2]);
  },
  luminosity: function () {
    for (var t = this.rgb().color, o = [], n = 0; n < t.length; n++) {
      var h = t[n] / 255;
      o[n] = h <= 0.03928 ? h / 12.92 : ((h + 0.055) / 1.055) ** 2.4;
    }

    return 0.2126 * o[0] + 0.7152 * o[1] + 0.0722 * o[2];
  },
  contrast: function (t) {
    var o = this.luminosity(),
      n = t.luminosity();
    return o > n ? (o + 0.05) / (n + 0.05) : (n + 0.05) / (o + 0.05);
  },
  level: function (t) {
    var o = this.contrast(t);
    return o >= 7.1 ? 'AAA' : o >= 4.5 ? 'AA' : '';
  },
  isDark: function () {
    var t = this.rgb().color;
    return (299 * t[0] + 587 * t[1] + 114 * t[2]) / 1e3 < 128;
  },
  isLight: function () {
    return !this.isDark();
  },
  negate: function () {
    for (var t = this.rgb(), o = 0; o < 3; o++) t.color[o] = 255 - t.color[o];

    return t;
  },
  lighten: function (t) {
    var o = this.hsl();
    o.color[2] += o.color[2] * t;
    return o;
  },
  darken: function (t) {
    var o = this.hsl();
    o.color[2] -= o.color[2] * t;
    return o;
  },
  saturate: function (t) {
    var o = this.hsl();
    o.color[1] += o.color[1] * t;
    return o;
  },
  desaturate: function (t) {
    var o = this.hsl();
    o.color[1] -= o.color[1] * t;
    return o;
  },
  whiten: function (t) {
    var o = this.hwb();
    o.color[1] += o.color[1] * t;
    return o;
  },
  blacken: function (t) {
    var o = this.hwb();
    o.color[2] += o.color[2] * t;
    return o;
  },
  grayscale: function () {
    var t = this.rgb().color,
      o = 0.3 * t[0] + 0.59 * t[1] + 0.11 * t[2];
    return c.rgb(o, o, o);
  },
  fade: function (t) {
    return this.alpha(this.valpha - this.valpha * t);
  },
  opaquer: function (t) {
    return this.alpha(this.valpha + this.valpha * t);
  },
  rotate: function (t) {
    var o = this.hsl(),
      n = o.color[0];
    n = (n = (n + t) % 360) < 0 ? 360 + n : n;
    o.color[0] = n;
    return o;
  },
  mix: function (t, o) {
    if (!t || !t.rgb) throw new Error('Argument to "mix" was not a Color instance, but rather an instance of ' + typeof t);
    var n = t.rgb(),
      h = this.rgb(),
      l = undefined === o ? 0.5 : o,
      s = 2 * l - 1,
      u = n.alpha() - h.alpha(),
      f = ((s * u == -1 ? s : (s + u) / (1 + s * u)) + 1) / 2,
      v = 1 - f;
    return c.rgb(f * n.red() + v * h.red(), f * n.green() + v * h.green(), f * n.blue() + v * h.blue(), n.alpha() * l + h.alpha() * (1 - l));
  },
};
Object.keys(module765).forEach(function (t) {
  if (-1 === h.indexOf(t)) {
    var l = module765[t].channels;

    c.prototype[t] = function () {
      if (this.model === t) return new c(this);
      if (arguments.length) return new c(arguments, t);
      var n,
        h = 'number' == typeof arguments[l] ? l : this.valpha;
      return new c(((n = module765[this.model][t].raw(this.color)), Array.isArray(n) ? n : [n]).concat(h), t);
    };

    c[t] = function (o) {
      if ('number' == typeof o) o = b(n.call(arguments), l);
      return new c(o, t);
    };
  }
});
module.exports = c;
