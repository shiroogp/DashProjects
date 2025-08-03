!(function (t) {
  var n = 'object' == typeof exports && exports,
    o = 'object' == typeof module && module && module.exports == n && module,
    c = 'object' == typeof globals && globals;
  if (!(c.global !== c && c.window !== c)) t = c;

  var h = function (t) {
    this.message = t;
  };

  (h.prototype = new Error()).name = 'InvalidCharacterError';

  var f = function (t) {
      throw new h(t);
    },
    s = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/',
    A = /[\t\n\f\r ]/g,
    l = {
      encode: function (t) {
        t = String(t);
        if (/[^\0-\xFF]/.test(t)) f('The string to be encoded contains characters outside of the Latin1 range.');

        for (var n, o, c, h, A = t.length % 3, l = '', p = -1, u = t.length - A; ++p < u; ) {
          n = t.charCodeAt(p) << 16;
          o = t.charCodeAt(++p) << 8;
          c = t.charCodeAt(++p);
          l += s.charAt(((h = n + o + c) >> 18) & 63) + s.charAt((h >> 12) & 63) + s.charAt((h >> 6) & 63) + s.charAt(63 & h);
        }

        if (2 == A) {
          n = t.charCodeAt(p) << 8;
          o = t.charCodeAt(++p);
          l += s.charAt((h = n + o) >> 10) + s.charAt((h >> 4) & 63) + s.charAt((h << 2) & 63) + '=';
        } else if (1 == A) {
          h = t.charCodeAt(p);
          l += s.charAt(h >> 2) + s.charAt((h << 4) & 63) + '==';
        }

        return l;
      },
      decode: function (t) {
        var n = (t = String(t).replace(A, '')).length;
        if (n % 4 == 0) n = (t = t.replace(/==?$/, '')).length;
        if (n % 4 == 1 || /[^+a-zA-Z0-9/]/.test(t)) f('Invalid character: the string to be decoded is not correctly encoded.');

        for (var o, c, h = 0, l = '', p = -1; ++p < n; ) {
          c = s.indexOf(t.charAt(p));
          o = h % 4 ? 64 * o + c : c;
          if (h++ % 4) l += String.fromCharCode(255 & (o >> ((-2 * h) & 6)));
        }

        return l;
      },
      version: '0.1.0',
    };

  if ('function' == typeof define && 'object' == typeof define.amd && define.amd)
    define(function () {
      return l;
    });
  else if (n && !n.nodeType) {
    if (o) o.exports = l;
    else for (var p in l) l.hasOwnProperty(p) && (n[p] = l[p]);
  } else t.base64 = l;
})(this);
