var module14 = require('./14');

function u(t, n) {
  var o = ('undefined' != typeof Symbol && t[Symbol.iterator]) || t['@@iterator'];
  if (o) return (o = o.call(t)).next.bind(o);

  if (Array.isArray(t) || (o = c(t)) || (n && t && 'number' == typeof t.length)) {
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

function c(t, n) {
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

var module701 = require('./701'),
  module702 = require('./702'),
  module703 = require('./703');

function y(t) {
  switch (t.arrayFormat) {
    case 'index':
      return function (n) {
        return function (u, c) {
          var s = u.length;
          return undefined === c || (t.skipNull && null === c) || (t.skipEmptyString && '' === c)
            ? u
            : [].concat(u, null === c ? [[j(n, t), '[', s, ']'].join('')] : [[j(n, t), '[', j(s, t), ']=', j(c, t)].join('')]);
        };
      };

    case 'bracket':
      return function (n) {
        return function (u, c) {
          return undefined === c || (t.skipNull && null === c) || (t.skipEmptyString && '' === c)
            ? u
            : [].concat(u, null === c ? [[j(n, t), '[]'].join('')] : [[j(n, t), '[]=', j(c, t)].join('')]);
        };
      };

    case 'comma':
    case 'separator':
      return function (n) {
        return function (o, u) {
          return null === u || undefined === u || 0 === u.length ? o : 0 === o.length ? [[j(n, t), '=', j(u, t)].join('')] : [[o, j(u, t)].join(t.arrayFormatSeparator)];
        };
      };

    default:
      return function (n) {
        return function (u, c) {
          return undefined === c || (t.skipNull && null === c) || (t.skipEmptyString && '' === c) ? u : [].concat(u, null === c ? [j(n, t)] : [[j(n, t), '=', j(c, t)].join('')]);
        };
      };
  }
}

function v(t) {
  var n;

  switch (t.arrayFormat) {
    case 'index':
      return function (t, o, u) {
        n = /\[(\d*)\]$/.exec(t);
        t = t.replace(/\[\d*\]$/, '');

        if (n) {
          if (undefined === u[t]) u[t] = {};
          u[t][n[1]] = o;
        } else u[t] = o;
      };

    case 'bracket':
      return function (t, o, u) {
        n = /(\[\])$/.exec(t);
        t = t.replace(/\[\]$/, '');
        if (n) undefined !== u[t] ? (u[t] = [].concat(u[t], o)) : (u[t] = [o]);
        else u[t] = o;
      };

    case 'comma':
    case 'separator':
      return function (n, o, u) {
        var c =
          'string' == typeof o && o.split('').indexOf(t.arrayFormatSeparator) > -1
            ? o.split(t.arrayFormatSeparator).map(function (n) {
                return h(n, t);
              })
            : null === o
            ? o
            : h(o, t);
        u[n] = c;
      };

    default:
      return function (t, n, o) {
        if (undefined !== o[t]) o[t] = [].concat(o[t], n);
        else o[t] = n;
      };
  }
}

function b(t) {
  if ('string' != typeof t || 1 !== t.length) throw new TypeError('arrayFormatSeparator must be single character string');
}

function j(t, n) {
  return n.encode ? (n.strict ? module701(t) : encodeURIComponent(t)) : t;
}

function h(t, n) {
  return n.decode ? module702(t) : t;
}

function k(t) {
  return Array.isArray(t)
    ? t.sort()
    : 'object' == typeof t
    ? k(Object.keys(t))
        .sort(function (t, n) {
          return Number(t) - Number(n);
        })
        .map(function (n) {
          return t[n];
        })
    : t;
}

function S(t) {
  var n = t.indexOf('#');
  if (-1 !== n) t = t.slice(0, n);
  return t;
}

function O(t) {
  var n = '',
    o = t.indexOf('#');
  if (-1 !== o) n = t.slice(o);
  return n;
}

function F(t) {
  var n = (t = S(t)).indexOf('?');
  return -1 === n ? '' : t.slice(n + 1);
}

function N(t, n) {
  if (n.parseNumbers && !Number.isNaN(Number(t)) && 'string' == typeof t && '' !== t.trim()) t = Number(t);
  else if (!(!n.parseBooleans || null === t || ('true' !== t.toLowerCase() && 'false' !== t.toLowerCase()))) t = 'true' === t.toLowerCase();
  return t;
}

function A(o, c) {
  b(
    (c = module14(
      {
        decode: true,
        sort: true,
        arrayFormat: 'none',
        arrayFormatSeparator: ',',
        parseNumbers: false,
        parseBooleans: false,
      },
      c
    )).arrayFormatSeparator
  );
  var s = v(c),
    l = Object.create(null);
  if ('string' != typeof o) return l;
  if (!(o = o.trim().replace(/^[?#&]/, ''))) return l;

  for (var f, y = u(o.split('&')); !(f = y()).done; ) {
    var j = f.value,
      [F, A] = module703(c.decode ? j.replace(/\+/g, ' ') : j, '=');
    A = undefined === A ? null : ['comma', 'separator'].includes(c.arrayFormat) ? A : h(A, c);
    s(h(F, c), A, l);
  }

  for (var x = 0, w = Object.keys(l); x < w.length; x++) {
    var I = w[x],
      E = l[I];
    if ('object' == typeof E && null !== E)
      for (var C = 0, $ = Object.keys(E); C < $.length; C++) {
        var U = $[C];
        E[U] = N(E[U], c);
      }
    else l[I] = N(E, c);
  }

  return false === c.sort
    ? l
    : (true === c.sort ? Object.keys(l).sort() : Object.keys(l).sort(c.sort)).reduce(function (t, n) {
        var o = l[n];
        if (Boolean(o) && 'object' == typeof o && !Array.isArray(o)) t[n] = k(o);
        else t[n] = o;
        return t;
      }, Object.create(null));
}

exports.extract = F;
exports.parse = A;

exports.stringify = function (t, o) {
  if (!t) return '';
  b(
    (o = module14(
      {
        encode: true,
        strict: true,
        arrayFormat: 'none',
        arrayFormatSeparator: ',',
      },
      o
    )).arrayFormatSeparator
  );

  for (
    var u = function (n) {
        return o.skipNull ? null === (u = t[n]) || undefined === u : o.skipEmptyString && '' === t[n];
        var u;
      },
      c = y(o),
      s = {},
      l = 0,
      f = Object.keys(t);
    l < f.length;
    l++
  ) {
    var p = f[l];
    if (!u(p)) s[p] = t[p];
  }

  var v = Object.keys(s);
  if (false !== o.sort) v.sort(o.sort);
  return v
    .map(function (n) {
      var u = t[n];
      return undefined === u ? '' : null === u ? j(n, o) : Array.isArray(u) ? u.reduce(c(n), []).join('&') : j(n, o) + '=' + j(u, o);
    })
    .filter(function (t) {
      return t.length > 0;
    })
    .join('&');
};

exports.parseUrl = function (o, u) {
  u = module14(
    {
      decode: true,
    },
    u
  );
  var [l, f] = module703(o, '#');
  return module14(
    {
      url: l.split('?')[0] || '',
      query: A(F(o), u),
    },
    u && u.parseFragmentIdentifier && f
      ? {
          fragmentIdentifier: h(f, u),
        }
      : {}
  );
};

exports.stringifyUrl = function (t, o) {
  o = module14(
    {
      encode: true,
      strict: true,
    },
    o
  );
  var u = S(t.url).split('?')[0] || '',
    c = exports.extract(t.url),
    s = exports.parse(c, {
      sort: false,
    }),
    l = module14(s, t.query),
    f = exports.stringify(l, o);
  if (f) f = '?' + f;
  var p = O(t.url);
  if (t.fragmentIdentifier) p = '#' + j(t.fragmentIdentifier, o);
  return '' + u + f + p;
};
