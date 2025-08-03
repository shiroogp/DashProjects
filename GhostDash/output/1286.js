!(function (t) {
  var n = /^\s+/,
    s = /\s+$/,
    o = 0,
    f = t.round,
    h = t.min,
    l = t.max,
    u = t.random;

  function c(t, n) {
    if (((t = t || ''), (n = n || {}), t instanceof c)) return t;
    if (!(this instanceof c)) return new c(t, n);
    var s = b(t);
    this._originalInput = t;
    this._r = s.r;
    this._g = s.g;
    this._b = s.b;
    this._a = s.a;
    this._roundA = f(100 * this._a) / 100;
    this._format = n.format || s.format;
    this._gradientType = n.gradientType;
    if (this._r < 1) this._r = f(this._r);
    if (this._g < 1) this._g = f(this._g);
    if (this._b < 1) this._b = f(this._b);
    this._ok = s.ok;
    this._tc_id = o++;
  }

  function b(t) {
    var n,
      s,
      o,
      f = {
        r: 0,
        g: 0,
        b: 0,
      },
      u = 1,
      c = null,
      b = null,
      _ = null,
      v = false,
      A = false;
    if ('string' == typeof t) t = W(t);

    if ('object' == typeof t) {
      if (Q(t.r) && Q(t.g) && Q(t.b)) {
        n = t.r;
        s = t.g;
        o = t.b;
        f = {
          r: 255 * P(n, 255),
          g: 255 * P(s, 255),
          b: 255 * P(o, 255),
        };
        v = true;
        A = '%' === String(t.r).substr(-1) ? 'prgb' : 'rgb';
      } else if (Q(t.h) && Q(t.s) && Q(t.v)) {
        c = V(t.s);
        b = V(t.v);
        f = y(t.h, c, b);
        v = true;
        A = 'hsv';
      } else if (Q(t.h) && Q(t.s) && Q(t.l)) {
        c = V(t.s);
        _ = V(t.l);
        f = p(t.h, c, _);
        v = true;
        A = 'hsl';
      }

      if (t.hasOwnProperty('a')) u = t.a;
    }

    u = O(u);
    return {
      ok: v,
      format: t.format || A,
      r: h(255, l(f.r, 0)),
      g: h(255, l(f.g, 0)),
      b: h(255, l(f.b, 0)),
      a: u,
    };
  }

  function _(t, n, s) {
    t = P(t, 255);
    n = P(n, 255);
    s = P(s, 255);
    var o,
      f,
      u = l(t, n, s),
      c = h(t, n, s),
      b = (u + c) / 2;
    if (u == c) o = f = 0;
    else {
      var _ = u - c;

      switch (((f = b > 0.5 ? _ / (2 - u - c) : _ / (u + c)), u)) {
        case t:
          o = (n - s) / _ + (n < s ? 6 : 0);
          break;

        case n:
          o = (s - t) / _ + 2;
          break;

        case s:
          o = (t - n) / _ + 4;
      }

      o /= 6;
    }
    return {
      h: o,
      s: f,
      l: b,
    };
  }

  function p(t, n, s) {
    var o, f, h;

    function l(t, n, s) {
      if (s < 0) s += 1;
      if (s > 1) s -= 1;
      return s < 0.16666666666666666 ? t + 6 * (n - t) * s : s < 0.5 ? n : s < 0.6666666666666666 ? t + (n - t) * (0.6666666666666666 - s) * 6 : t;
    }

    if (((t = P(t, 360)), (n = P(n, 100)), (s = P(s, 100)), 0 === n)) o = f = h = s;
    else {
      var u = s < 0.5 ? s * (1 + n) : s + n - s * n,
        c = 2 * s - u;
      o = l(c, u, t + 0.3333333333333333);
      f = l(c, u, t);
      h = l(c, u, t - 0.3333333333333333);
    }
    return {
      r: 255 * o,
      g: 255 * f,
      b: 255 * h,
    };
  }

  function v(t, n, s) {
    t = P(t, 255);
    n = P(n, 255);
    s = P(s, 255);

    var o,
      f,
      u = l(t, n, s),
      c = h(t, n, s),
      b = u,
      _ = u - c;

    if (((f = 0 === u ? 0 : _ / u), u == c)) o = 0;
    else {
      switch (u) {
        case t:
          o = (n - s) / _ + (n < s ? 6 : 0);
          break;

        case n:
          o = (s - t) / _ + 2;
          break;

        case s:
          o = (t - n) / _ + 4;
      }

      o /= 6;
    }
    return {
      h: o,
      s: f,
      v: b,
    };
  }

  function y(n, s, o) {
    n = 6 * P(n, 360);
    s = P(s, 100);
    o = P(o, 100);
    var f = t.floor(n),
      h = n - f,
      l = o * (1 - s),
      u = o * (1 - h * s),
      c = o * (1 - (1 - h) * s),
      b = f % 6;
    return {
      r: 255 * [o, u, l, l, c, o][b],
      g: 255 * [c, o, o, u, l, l][b],
      b: 255 * [l, l, c, o, o, u][b],
    };
  }

  function A(t, n, s, o) {
    var h = [G(f(t).toString(16)), G(f(n).toString(16)), G(f(s).toString(16))];
    return o && h[0].charAt(0) == h[0].charAt(1) && h[1].charAt(0) == h[1].charAt(1) && h[2].charAt(0) == h[2].charAt(1)
      ? h[0].charAt(0) + h[1].charAt(0) + h[2].charAt(0)
      : h.join('');
  }

  function x(t, n, s, o, h) {
    var l = [G(f(t).toString(16)), G(f(n).toString(16)), G(f(s).toString(16)), G(X(o))];
    return h && l[0].charAt(0) == l[0].charAt(1) && l[1].charAt(0) == l[1].charAt(1) && l[2].charAt(0) == l[2].charAt(1) && l[3].charAt(0) == l[3].charAt(1)
      ? l[0].charAt(0) + l[1].charAt(0) + l[2].charAt(0) + l[3].charAt(0)
      : l.join('');
  }

  function k(t, n, s, o) {
    return [G(X(o)), G(f(t).toString(16)), G(f(n).toString(16)), G(f(s).toString(16))].join('');
  }

  function w(t, n) {
    n = 0 === n ? 0 : n || 10;
    var s = c(t).toHsl();
    s.s -= n / 100;
    s.s = $(s.s);
    return c(s);
  }

  function S(t, n) {
    n = 0 === n ? 0 : n || 10;
    var s = c(t).toHsl();
    s.s += n / 100;
    s.s = $(s.s);
    return c(s);
  }

  function H(t) {
    return c(t).desaturate(100);
  }

  function R(t, n) {
    n = 0 === n ? 0 : n || 10;
    var s = c(t).toHsl();
    s.l += n / 100;
    s.l = $(s.l);
    return c(s);
  }

  function F(t, n) {
    n = 0 === n ? 0 : n || 10;
    var s = c(t).toRgb();
    s.r = l(0, h(255, s.r - f((-n / 100) * 255)));
    s.g = l(0, h(255, s.g - f((-n / 100) * 255)));
    s.b = l(0, h(255, s.b - f((-n / 100) * 255)));
    return c(s);
  }

  function C(t, n) {
    n = 0 === n ? 0 : n || 10;
    var s = c(t).toHsl();
    s.l -= n / 100;
    s.l = $(s.l);
    return c(s);
  }

  function q(t, n) {
    var s = c(t).toHsl(),
      o = (s.h + n) % 360;
    s.h = o < 0 ? 360 + o : o;
    return c(s);
  }

  function M(t) {
    var n = c(t).toHsl();
    n.h = (n.h + 180) % 360;
    return c(n);
  }

  function I(t) {
    var n = c(t).toHsl(),
      s = n.h;
    return [
      c(t),
      c({
        h: (s + 120) % 360,
        s: n.s,
        l: n.l,
      }),
      c({
        h: (s + 240) % 360,
        s: n.s,
        l: n.l,
      }),
    ];
  }

  function L(t) {
    var n = c(t).toHsl(),
      s = n.h;
    return [
      c(t),
      c({
        h: (s + 90) % 360,
        s: n.s,
        l: n.l,
      }),
      c({
        h: (s + 180) % 360,
        s: n.s,
        l: n.l,
      }),
      c({
        h: (s + 270) % 360,
        s: n.s,
        l: n.l,
      }),
    ];
  }

  function N(t) {
    var n = c(t).toHsl(),
      s = n.h;
    return [
      c(t),
      c({
        h: (s + 72) % 360,
        s: n.s,
        l: n.l,
      }),
      c({
        h: (s + 216) % 360,
        s: n.s,
        l: n.l,
      }),
    ];
  }

  function z(t, n, s) {
    n = n || 6;
    s = s || 30;
    var o = c(t).toHsl(),
      f = 360 / s,
      h = [c(t)];

    for (o.h = (o.h - ((f * n) >> 1) + 720) % 360; --n; ) {
      o.h = (o.h + f) % 360;
      h.push(c(o));
    }

    return h;
  }

  function E(t, n) {
    n = n || 6;

    for (var s = c(t).toHsv(), o = s.h, f = s.s, h = s.v, l = [], u = 1 / n; n--; ) {
      l.push(
        c({
          h: o,
          s: f,
          v: h,
        })
      );
      h = (h + u) % 1;
    }

    return l;
  }

  c.prototype = {
    isDark: function () {
      return this.getBrightness() < 128;
    },
    isLight: function () {
      return !this.isDark();
    },
    isValid: function () {
      return this._ok;
    },
    getOriginalInput: function () {
      return this._originalInput;
    },
    getFormat: function () {
      return this._format;
    },
    getAlpha: function () {
      return this._a;
    },
    getBrightness: function () {
      var t = this.toRgb();
      return (299 * t.r + 587 * t.g + 114 * t.b) / 1e3;
    },
    getLuminance: function () {
      var n,
        s,
        o,
        f = this.toRgb();
      n = f.r / 255;
      s = f.g / 255;
      o = f.b / 255;
      return (
        0.2126 * (n <= 0.03928 ? n / 12.92 : ((n + 0.055) / 1.055) ** 2.4) +
        0.7152 * (s <= 0.03928 ? s / 12.92 : ((s + 0.055) / 1.055) ** 2.4) +
        0.0722 * (o <= 0.03928 ? o / 12.92 : ((o + 0.055) / 1.055) ** 2.4)
      );
    },
    setAlpha: function (t) {
      this._a = O(t);
      this._roundA = f(100 * this._a) / 100;
      return this;
    },
    toHsv: function () {
      var t = v(this._r, this._g, this._b);
      return {
        h: 360 * t.h,
        s: t.s,
        v: t.v,
        a: this._a,
      };
    },
    toHsvString: function () {
      var t = v(this._r, this._g, this._b),
        n = f(360 * t.h),
        s = f(100 * t.s),
        o = f(100 * t.v);
      return 1 == this._a ? 'hsv(' + n + ', ' + s + '%, ' + o + '%)' : 'hsva(' + n + ', ' + s + '%, ' + o + '%, ' + this._roundA + ')';
    },
    toHsl: function () {
      var t = _(this._r, this._g, this._b);

      return {
        h: 360 * t.h,
        s: t.s,
        l: t.l,
        a: this._a,
      };
    },
    toHslString: function () {
      var t = _(this._r, this._g, this._b),
        n = f(360 * t.h),
        s = f(100 * t.s),
        o = f(100 * t.l);

      return 1 == this._a ? 'hsl(' + n + ', ' + s + '%, ' + o + '%)' : 'hsla(' + n + ', ' + s + '%, ' + o + '%, ' + this._roundA + ')';
    },
    toHex: function (t) {
      return A(this._r, this._g, this._b, t);
    },
    toHexString: function (t) {
      return '#' + this.toHex(t);
    },
    toHex8: function (t) {
      return x(this._r, this._g, this._b, this._a, t);
    },
    toHex8String: function (t) {
      return '#' + this.toHex8(t);
    },
    toRgb: function () {
      return {
        r: f(this._r),
        g: f(this._g),
        b: f(this._b),
        a: this._a,
      };
    },
    toRgbString: function () {
      return 1 == this._a
        ? 'rgb(' + f(this._r) + ', ' + f(this._g) + ', ' + f(this._b) + ')'
        : 'rgba(' + f(this._r) + ', ' + f(this._g) + ', ' + f(this._b) + ', ' + this._roundA + ')';
    },
    toPercentageRgb: function () {
      return {
        r: f(100 * P(this._r, 255)) + '%',
        g: f(100 * P(this._g, 255)) + '%',
        b: f(100 * P(this._b, 255)) + '%',
        a: this._a,
      };
    },
    toPercentageRgbString: function () {
      return 1 == this._a
        ? 'rgb(' + f(100 * P(this._r, 255)) + '%, ' + f(100 * P(this._g, 255)) + '%, ' + f(100 * P(this._b, 255)) + '%)'
        : 'rgba(' + f(100 * P(this._r, 255)) + '%, ' + f(100 * P(this._g, 255)) + '%, ' + f(100 * P(this._b, 255)) + '%, ' + this._roundA + ')';
    },
    toName: function () {
      return 0 === this._a ? 'transparent' : !(this._a < 1) && (j[A(this._r, this._g, this._b, true)] || false);
    },
    toFilter: function (t) {
      var n = '#' + k(this._r, this._g, this._b, this._a),
        s = n,
        o = this._gradientType ? 'GradientType = 1, ' : '';

      if (t) {
        var f = c(t);
        s = '#' + k(f._r, f._g, f._b, f._a);
      }

      return 'progid:DXImageTransform.Microsoft.gradient(' + o + 'startColorstr=' + n + ',endColorstr=' + s + ')';
    },
    toString: function (t) {
      var n = !!t;
      t = t || this._format;
      var s = false,
        o = this._a < 1 && this._a >= 0;

      if (n || !o || ('hex' !== t && 'hex6' !== t && 'hex3' !== t && 'hex4' !== t && 'hex8' !== t && 'name' !== t)) {
        if ('rgb' === t) s = this.toRgbString();
        if ('prgb' === t) s = this.toPercentageRgbString();
        if (!('hex' !== t && 'hex6' !== t)) s = this.toHexString();
        if ('hex3' === t) s = this.toHexString(true);
        if ('hex4' === t) s = this.toHex8String(true);
        if ('hex8' === t) s = this.toHex8String();
        if ('name' === t) s = this.toName();
        if ('hsl' === t) s = this.toHslString();
        if ('hsv' === t) s = this.toHsvString();
        return s || this.toHexString();
      } else return 'name' === t && 0 === this._a ? this.toName() : this.toRgbString();
    },
    clone: function () {
      return c(this.toString());
    },
    _applyModification: function (t, n) {
      var s = t.apply(null, [this].concat([].slice.call(n)));
      this._r = s._r;
      this._g = s._g;
      this._b = s._b;
      this.setAlpha(s._a);
      return this;
    },
    lighten: function () {
      return this._applyModification(R, arguments);
    },
    brighten: function () {
      return this._applyModification(F, arguments);
    },
    darken: function () {
      return this._applyModification(C, arguments);
    },
    desaturate: function () {
      return this._applyModification(w, arguments);
    },
    saturate: function () {
      return this._applyModification(S, arguments);
    },
    greyscale: function () {
      return this._applyModification(H, arguments);
    },
    spin: function () {
      return this._applyModification(q, arguments);
    },
    _applyCombination: function (t, n) {
      return t.apply(null, [this].concat([].slice.call(n)));
    },
    analogous: function () {
      return this._applyCombination(z, arguments);
    },
    complement: function () {
      return this._applyCombination(M, arguments);
    },
    monochromatic: function () {
      return this._applyCombination(E, arguments);
    },
    splitcomplement: function () {
      return this._applyCombination(N, arguments);
    },
    triad: function () {
      return this._applyCombination(I, arguments);
    },
    tetrad: function () {
      return this._applyCombination(L, arguments);
    },
  };

  c.fromRatio = function (t, n) {
    if ('object' == typeof t) {
      var s = {};

      for (var o in t) t.hasOwnProperty(o) && (s[o] = 'a' === o ? t[o] : V(t[o]));

      t = s;
    }

    return c(t, n);
  };

  c.equals = function (t, n) {
    return !(!t || !n) && c(t).toRgbString() == c(n).toRgbString();
  };

  c.random = function () {
    return c.fromRatio({
      r: u(),
      g: u(),
      b: u(),
    });
  };

  c.mix = function (t, n, s) {
    s = 0 === s ? 0 : s || 50;
    var o = c(t).toRgb(),
      f = c(n).toRgb(),
      h = s / 100;
    return c({
      r: (f.r - o.r) * h + o.r,
      g: (f.g - o.g) * h + o.g,
      b: (f.b - o.b) * h + o.b,
      a: (f.a - o.a) * h + o.a,
    });
  };

  c.readability = function (n, s) {
    var o = c(n),
      f = c(s);
    return (t.max(o.getLuminance(), f.getLuminance()) + 0.05) / (t.min(o.getLuminance(), f.getLuminance()) + 0.05);
  };

  c.isReadable = function (t, n, s) {
    var o,
      f,
      h = c.readability(t, n);

    switch (((f = false), (o = Y(s)).level + o.size)) {
      case 'AAsmall':
      case 'AAAlarge':
        f = h >= 4.5;
        break;

      case 'AAlarge':
        f = h >= 3;
        break;

      case 'AAAsmall':
        f = h >= 7;
    }

    return f;
  };

  c.mostReadable = function (t, n, s) {
    var o,
      f,
      h,
      l,
      u = null,
      b = 0;
    f = (s = s || {}).includeFallbackColors;
    h = s.level;
    l = s.size;

    for (var _ = 0; _ < n.length; _++) (o = c.readability(t, n[_])) > b && ((b = o), (u = c(n[_])));

    if (
      c.isReadable(t, u, {
        level: h,
        size: l,
      }) ||
      !f
    )
      return u;
    else {
      s.includeFallbackColors = false;
      return c.mostReadable(t, ['#fff', '#000'], s);
    }
  };

  var T = (c.names = {
      aliceblue: 'f0f8ff',
      antiquewhite: 'faebd7',
      aqua: '0ff',
      aquamarine: '7fffd4',
      azure: 'f0ffff',
      beige: 'f5f5dc',
      bisque: 'ffe4c4',
      black: '000',
      blanchedalmond: 'ffebcd',
      blue: '00f',
      blueviolet: '8a2be2',
      brown: 'a52a2a',
      burlywood: 'deb887',
      burntsienna: 'ea7e5d',
      cadetblue: '5f9ea0',
      chartreuse: '7fff00',
      chocolate: 'd2691e',
      coral: 'ff7f50',
      cornflowerblue: '6495ed',
      cornsilk: 'fff8dc',
      crimson: 'dc143c',
      cyan: '0ff',
      darkblue: '00008b',
      darkcyan: '008b8b',
      darkgoldenrod: 'b8860b',
      darkgray: 'a9a9a9',
      darkgreen: '006400',
      darkgrey: 'a9a9a9',
      darkkhaki: 'bdb76b',
      darkmagenta: '8b008b',
      darkolivegreen: '556b2f',
      darkorange: 'ff8c00',
      darkorchid: '9932cc',
      darkred: '8b0000',
      darksalmon: 'e9967a',
      darkseagreen: '8fbc8f',
      darkslateblue: '483d8b',
      darkslategray: '2f4f4f',
      darkslategrey: '2f4f4f',
      darkturquoise: '00ced1',
      darkviolet: '9400d3',
      deeppink: 'ff1493',
      deepskyblue: '00bfff',
      dimgray: '696969',
      dimgrey: '696969',
      dodgerblue: '1e90ff',
      firebrick: 'b22222',
      floralwhite: 'fffaf0',
      forestgreen: '228b22',
      fuchsia: 'f0f',
      gainsboro: 'dcdcdc',
      ghostwhite: 'f8f8ff',
      gold: 'ffd700',
      goldenrod: 'daa520',
      gray: '808080',
      green: '008000',
      greenyellow: 'adff2f',
      grey: '808080',
      honeydew: 'f0fff0',
      hotpink: 'ff69b4',
      indianred: 'cd5c5c',
      indigo: '4b0082',
      ivory: 'fffff0',
      khaki: 'f0e68c',
      lavender: 'e6e6fa',
      lavenderblush: 'fff0f5',
      lawngreen: '7cfc00',
      lemonchiffon: 'fffacd',
      lightblue: 'add8e6',
      lightcoral: 'f08080',
      lightcyan: 'e0ffff',
      lightgoldenrodyellow: 'fafad2',
      lightgray: 'd3d3d3',
      lightgreen: '90ee90',
      lightgrey: 'd3d3d3',
      lightpink: 'ffb6c1',
      lightsalmon: 'ffa07a',
      lightseagreen: '20b2aa',
      lightskyblue: '87cefa',
      lightslategray: '789',
      lightslategrey: '789',
      lightsteelblue: 'b0c4de',
      lightyellow: 'ffffe0',
      lime: '0f0',
      limegreen: '32cd32',
      linen: 'faf0e6',
      magenta: 'f0f',
      maroon: '800000',
      mediumaquamarine: '66cdaa',
      mediumblue: '0000cd',
      mediumorchid: 'ba55d3',
      mediumpurple: '9370db',
      mediumseagreen: '3cb371',
      mediumslateblue: '7b68ee',
      mediumspringgreen: '00fa9a',
      mediumturquoise: '48d1cc',
      mediumvioletred: 'c71585',
      midnightblue: '191970',
      mintcream: 'f5fffa',
      mistyrose: 'ffe4e1',
      moccasin: 'ffe4b5',
      navajowhite: 'ffdead',
      navy: '000080',
      oldlace: 'fdf5e6',
      olive: '808000',
      olivedrab: '6b8e23',
      orange: 'ffa500',
      orangered: 'ff4500',
      orchid: 'da70d6',
      palegoldenrod: 'eee8aa',
      palegreen: '98fb98',
      paleturquoise: 'afeeee',
      palevioletred: 'db7093',
      papayawhip: 'ffefd5',
      peachpuff: 'ffdab9',
      peru: 'cd853f',
      pink: 'ffc0cb',
      plum: 'dda0dd',
      powderblue: 'b0e0e6',
      purple: '800080',
      rebeccapurple: '663399',
      red: 'f00',
      rosybrown: 'bc8f8f',
      royalblue: '4169e1',
      saddlebrown: '8b4513',
      salmon: 'fa8072',
      sandybrown: 'f4a460',
      seagreen: '2e8b57',
      seashell: 'fff5ee',
      sienna: 'a0522d',
      silver: 'c0c0c0',
      skyblue: '87ceeb',
      slateblue: '6a5acd',
      slategray: '708090',
      slategrey: '708090',
      snow: 'fffafa',
      springgreen: '00ff7f',
      steelblue: '4682b4',
      tan: 'd2b48c',
      teal: '008080',
      thistle: 'd8bfd8',
      tomato: 'ff6347',
      turquoise: '40e0d0',
      violet: 'ee82ee',
      wheat: 'f5deb3',
      white: 'fff',
      whitesmoke: 'f5f5f5',
      yellow: 'ff0',
      yellowgreen: '9acd32',
    }),
    j = (c.hexNames = (function (t) {
      var n = {};

      for (var s in t) t.hasOwnProperty(s) && (n[t[s]] = s);

      return n;
    })(T));

  function O(t) {
    t = parseFloat(t);
    if (isNaN(t) || t < 0 || t > 1) t = 1;
    return t;
  }

  function P(n, s) {
    if (U(n)) n = '100%';
    var o = B(n);
    n = h(s, l(0, parseFloat(n)));
    if (o) n = parseInt(n * s, 10) / 100;
    return t.abs(n - s) < 1e-6 ? 1 : (n % s) / parseFloat(s);
  }

  function $(t) {
    return h(1, l(0, t));
  }

  function D(t) {
    return parseInt(t, 16);
  }

  function U(t) {
    return 'string' == typeof t && -1 != t.indexOf('.') && 1 === parseFloat(t);
  }

  function B(t) {
    return 'string' == typeof t && -1 != t.indexOf('%');
  }

  function G(t) {
    return 1 == t.length ? '0' + t : '' + t;
  }

  function V(t) {
    if (t <= 1) t = 100 * t + '%';
    return t;
  }

  function X(n) {
    return t.round(255 * parseFloat(n)).toString(16);
  }

  function J(t) {
    return D(t) / 255;
  }

  var K = {
    CSS_UNIT: new RegExp('(?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?)'),
    rgb: new RegExp(
      'rgb[\\s|\\(]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))[,|\\s]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))[,|\\s]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))\\s*\\)?'
    ),
    rgba: new RegExp(
      'rgba[\\s|\\(]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))[,|\\s]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))[,|\\s]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))[,|\\s]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))\\s*\\)?'
    ),
    hsl: new RegExp(
      'hsl[\\s|\\(]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))[,|\\s]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))[,|\\s]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))\\s*\\)?'
    ),
    hsla: new RegExp(
      'hsla[\\s|\\(]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))[,|\\s]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))[,|\\s]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))[,|\\s]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))\\s*\\)?'
    ),
    hsv: new RegExp(
      'hsv[\\s|\\(]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))[,|\\s]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))[,|\\s]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))\\s*\\)?'
    ),
    hsva: new RegExp(
      'hsva[\\s|\\(]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))[,|\\s]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))[,|\\s]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))[,|\\s]+((?:[-\\+]?\\d*\\.\\d+%?)|(?:[-\\+]?\\d+%?))\\s*\\)?'
    ),
    hex3: /^#?([0-9a-fA-F]{1})([0-9a-fA-F]{1})([0-9a-fA-F]{1})$/,
    hex6: /^#?([0-9a-fA-F]{2})([0-9a-fA-F]{2})([0-9a-fA-F]{2})$/,
    hex4: /^#?([0-9a-fA-F]{1})([0-9a-fA-F]{1})([0-9a-fA-F]{1})([0-9a-fA-F]{1})$/,
    hex8: /^#?([0-9a-fA-F]{2})([0-9a-fA-F]{2})([0-9a-fA-F]{2})([0-9a-fA-F]{2})$/,
  };

  function Q(t) {
    return !!K.CSS_UNIT.exec(t);
  }

  function W(t) {
    t = t.replace(n, '').replace(s, '').toLowerCase();
    var o,
      f = false;

    if (T[t]) {
      t = T[t];
      f = true;
    } else if ('transparent' == t)
      return {
        r: 0,
        g: 0,
        b: 0,
        a: 0,
        format: 'name',
      };

    return (o = K.rgb.exec(t))
      ? {
          r: o[1],
          g: o[2],
          b: o[3],
        }
      : (o = K.rgba.exec(t))
      ? {
          r: o[1],
          g: o[2],
          b: o[3],
          a: o[4],
        }
      : (o = K.hsl.exec(t))
      ? {
          h: o[1],
          s: o[2],
          l: o[3],
        }
      : (o = K.hsla.exec(t))
      ? {
          h: o[1],
          s: o[2],
          l: o[3],
          a: o[4],
        }
      : (o = K.hsv.exec(t))
      ? {
          h: o[1],
          s: o[2],
          v: o[3],
        }
      : (o = K.hsva.exec(t))
      ? {
          h: o[1],
          s: o[2],
          v: o[3],
          a: o[4],
        }
      : (o = K.hex8.exec(t))
      ? {
          r: D(o[1]),
          g: D(o[2]),
          b: D(o[3]),
          a: J(o[4]),
          format: f ? 'name' : 'hex8',
        }
      : (o = K.hex6.exec(t))
      ? {
          r: D(o[1]),
          g: D(o[2]),
          b: D(o[3]),
          format: f ? 'name' : 'hex',
        }
      : (o = K.hex4.exec(t))
      ? {
          r: D(o[1] + '' + o[1]),
          g: D(o[2] + '' + o[2]),
          b: D(o[3] + '' + o[3]),
          a: J(o[4] + '' + o[4]),
          format: f ? 'name' : 'hex8',
        }
      : !!(o = K.hex3.exec(t)) && {
          r: D(o[1] + '' + o[1]),
          g: D(o[2] + '' + o[2]),
          b: D(o[3] + '' + o[3]),
          format: f ? 'name' : 'hex',
        };
  }

  function Y(t) {
    var n, s;
    n = (
      (t = t || {
        level: 'AA',
        size: 'small',
      }).level || 'AA'
    ).toUpperCase();
    s = (t.size || 'small').toLowerCase();
    if ('AA' !== n && 'AAA' !== n) n = 'AA';
    if ('small' !== s && 'large' !== s) s = 'small';
    return {
      level: n,
      size: s,
    };
  }

  if (undefined !== module && module.exports) module.exports = c;
  else if ('function' == typeof define && define.amd)
    define(function () {
      return c;
    });
  else window.tinycolor = c;
})(Math);
