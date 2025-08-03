!(function () {
  'use strict';

  var n = {
    not_string: /[^s]/,
    not_bool: /[^t]/,
    not_type: /[^T]/,
    not_primitive: /[^v]/,
    number: /[diefg]/,
    numeric_arg: /[bcdiefguxX]/,
    json: /[j]/,
    not_json: /[^j]/,
    text: /^[^\x25]+/,
    modulo: /^\x25{2}/,
    placeholder: /^\x25(?:([1-9]\d*)\$|\(([^)]+)\))?(\+)?(0|'[^$])?(-)?(\d+)?(?:\.(\d+))?([b-gijostTuvxX])/,
    key: /^([a-z_][a-z_\d]*)/i,
    key_access: /^\.([a-z_][a-z_\d]*)/i,
    index_access: /^\[(\d+)\]/,
    sign: /^[+-]/,
  };

  function t(n) {
    return o(c(n), arguments);
  }

  function s(n, s) {
    return t.apply(null, [n].concat(s || []));
  }

  function o(s, o) {
    var p,
      c,
      l,
      u,
      f,
      y,
      b,
      h,
      k,
      _ = 1,
      w = s.length,
      x = '';

    for (c = 0; c < w; c++)
      if ('string' == typeof s[c]) x += s[c];
      else if ('object' == typeof s[c]) {
        if ((u = s[c]).keys)
          for (p = o[_], l = 0; l < u.keys.length; l++) {
            if (undefined == p) throw new Error(t('[sprintf] Cannot access property "%s" of undefined value "%s"', u.keys[l], u.keys[l - 1]));
            p = p[u.keys[l]];
          }
        else p = u.param_no ? o[u.param_no] : o[_++];
        if ((n.not_type.test(u.type) && n.not_primitive.test(u.type) && p instanceof Function && (p = p()), n.numeric_arg.test(u.type) && 'number' != typeof p && isNaN(p)))
          throw new TypeError(t('[sprintf] expecting number but found %T', p));

        switch ((n.number.test(u.type) && (h = p >= 0), u.type)) {
          case 'b':
            p = parseInt(p, 10).toString(2);
            break;

          case 'c':
            p = String.fromCharCode(parseInt(p, 10));
            break;

          case 'd':
          case 'i':
            p = parseInt(p, 10);
            break;

          case 'j':
            p = JSON.stringify(p, null, u.width ? parseInt(u.width) : 0);
            break;

          case 'e':
            p = u.precision ? parseFloat(p).toExponential(u.precision) : parseFloat(p).toExponential();
            break;

          case 'f':
            p = u.precision ? parseFloat(p).toFixed(u.precision) : parseFloat(p);
            break;

          case 'g':
            p = u.precision ? String(Number(p.toPrecision(u.precision))) : parseFloat(p);
            break;

          case 'o':
            p = (parseInt(p, 10) >>> 0).toString(8);
            break;

          case 's':
            p = String(p);
            p = u.precision ? p.substring(0, u.precision) : p;
            break;

          case 't':
            p = String(!!p);
            p = u.precision ? p.substring(0, u.precision) : p;
            break;

          case 'T':
            p = Object.prototype.toString.call(p).slice(8, -1).toLowerCase();
            p = u.precision ? p.substring(0, u.precision) : p;
            break;

          case 'u':
            p = parseInt(p, 10) >>> 0;
            break;

          case 'v':
            p = p.valueOf();
            p = u.precision ? p.substring(0, u.precision) : p;
            break;

          case 'x':
            p = (parseInt(p, 10) >>> 0).toString(16);
            break;

          case 'X':
            p = (parseInt(p, 10) >>> 0).toString(16).toUpperCase();
        }

        if (n.json.test(u.type)) x += p;
        else {
          if (!n.number.test(u.type) || (h && !u.sign)) k = '';
          else {
            k = h ? '+' : '-';
            p = p.toString().replace(n.sign, '');
          }
          y = u.pad_char ? ('0' === u.pad_char ? '0' : u.pad_char.charAt(1)) : ' ';
          b = u.width - (k + p).length;
          f = u.width && b > 0 ? y.repeat(b) : '';
          x += u.align ? k + p + f : '0' === y ? k + f + p : f + k + p;
        }
      }

    return x;
  }

  var p = Object.create(null);

  function c(t) {
    if (p[t]) return p[t];

    for (var s, o = t, c = [], l = 0; o; ) {
      if (null !== (s = n.text.exec(o))) c.push(s[0]);
      else if (null !== (s = n.modulo.exec(o))) c.push('%');
      else {
        if (null === (s = n.placeholder.exec(o))) throw new SyntaxError('[sprintf] unexpected placeholder');

        if (s[2]) {
          l |= 1;
          var u = [],
            f = s[2],
            y = [];
          if (null === (y = n.key.exec(f))) throw new SyntaxError('[sprintf] failed to parse named argument key');

          for (u.push(y[1]); '' !== (f = f.substring(y[0].length)); )
            if (null !== (y = n.key_access.exec(f))) u.push(y[1]);
            else {
              if (null === (y = n.index_access.exec(f))) throw new SyntaxError('[sprintf] failed to parse named argument key');
              u.push(y[1]);
            }

          s[2] = u;
        } else l |= 2;

        if (3 === l) throw new Error('[sprintf] mixing positional and named placeholders is not (yet) supported');
        c.push({
          placeholder: s[0],
          param_no: s[1],
          keys: s[2],
          sign: s[3],
          pad_char: s[4],
          align: s[5],
          width: s[6],
          precision: s[7],
          type: s[8],
        });
      }
      o = o.substring(s[0].length);
    }

    return (p[t] = c);
  }

  if (undefined !== exports) {
    exports.sprintf = t;
    exports.vsprintf = s;
  }

  if ('undefined' != typeof window) {
    window.sprintf = t;
    window.vsprintf = s;
    if ('function' == typeof define && define.amd)
      define(function () {
        return {
          sprintf: t,
          vsprintf: s,
        };
      });
  }
})();
