var module762 = require('./762'),
  module763 = require('./763'),
  s = {};

for (var o in module762) module762.hasOwnProperty(o) && (s[module762[o]] = o);

var u = (module.exports = {
  to: {},
  get: {},
});

function l(t, n, s) {
  return (n ** t) ** s;
}

function h(t) {
  var n = t.toString(16).toUpperCase();
  return n.length < 2 ? '0' + n : n;
}

u.get = function (t) {
  var n, s;

  switch (t.substring(0, 3).toLowerCase()) {
    case 'hsl':
      n = u.get.hsl(t);
      s = 'hsl';
      break;

    case 'hwb':
      n = u.get.hwb(t);
      s = 'hwb';
      break;

    default:
      n = u.get.rgb(t);
      s = 'rgb';
  }

  return n
    ? {
        model: s,
        value: n,
      }
    : null;
};

u.get.rgb = function (n) {
  if (!n) return null;
  var s,
    o,
    u,
    h = [0, 0, 0, 1];

  if ((s = n.match(/^#([a-f0-9]{6})([a-f0-9]{2})?$/i))) {
    for (u = s[2], s = s[1], o = 0; o < 3; o++) {
      var f = 2 * o;
      h[o] = parseInt(s.slice(f, f + 2), 16);
    }

    if (u) h[3] = Math.round((parseInt(u, 16) / 255) * 100) / 100;
  } else if ((s = n.match(/^#([a-f0-9]{3,4})$/i))) {
    for (u = (s = s[1])[3], o = 0; o < 3; o++) h[o] = parseInt(s[o] + s[o], 16);

    if (u) h[3] = Math.round((parseInt(u + u, 16) / 255) * 100) / 100;
  } else if ((s = n.match(/^rgba?\(\s*([+-]?\d+)\s*,\s*([+-]?\d+)\s*,\s*([+-]?\d+)\s*(?:,\s*([+-]?[\d\.]+)\s*)?\)$/))) {
    for (o = 0; o < 3; o++) h[o] = parseInt(s[o + 1], 0);

    if (s[4]) h[3] = parseFloat(s[4]);
  } else {
    if (!(s = n.match(/^rgba?\(\s*([+-]?[\d\.]+)\%\s*,\s*([+-]?[\d\.]+)\%\s*,\s*([+-]?[\d\.]+)\%\s*(?:,\s*([+-]?[\d\.]+)\s*)?\)$/)))
      return (s = n.match(/(\D+)/)) ? ('transparent' === s[1] ? [0, 0, 0, 0] : (h = module762[s[1]]) ? ((h[3] = 1), h) : null) : null;

    for (o = 0; o < 3; o++) h[o] = Math.round(2.55 * parseFloat(s[o + 1]));

    if (s[4]) h[3] = parseFloat(s[4]);
  }

  for (o = 0; o < 3; o++) h[o] = l(h[o], 0, 255);

  h[3] = l(h[3], 0, 1);
  return h;
};

u.get.hsl = function (t) {
  if (!t) return null;
  var n = t.match(/^hsla?\(\s*([+-]?(?:\d*\.)?\d+)(?:deg)?\s*,\s*([+-]?[\d\.]+)%\s*,\s*([+-]?[\d\.]+)%\s*(?:,\s*([+-]?[\d\.]+)\s*)?\)$/);

  if (n) {
    var s = parseFloat(n[4]);
    return [(parseFloat(n[1]) + 360) % 360, l(parseFloat(n[2]), 0, 100), l(parseFloat(n[3]), 0, 100), l(isNaN(s) ? 1 : s, 0, 1)];
  }

  return null;
};

u.get.hwb = function (t) {
  if (!t) return null;
  var n = t.match(/^hwb\(\s*([+-]?\d*[\.]?\d+)(?:deg)?\s*,\s*([+-]?[\d\.]+)%\s*,\s*([+-]?[\d\.]+)%\s*(?:,\s*([+-]?[\d\.]+)\s*)?\)$/);

  if (n) {
    var s = parseFloat(n[4]);
    return [((parseFloat(n[1]) % 360) + 360) % 360, l(parseFloat(n[2]), 0, 100), l(parseFloat(n[3]), 0, 100), l(isNaN(s) ? 1 : s, 0, 1)];
  }

  return null;
};

u.to.hex = function () {
  var t = module763(arguments);
  return '#' + h(t[0]) + h(t[1]) + h(t[2]) + (t[3] < 1 ? h(Math.round(255 * t[3])) : '');
};

u.to.rgb = function () {
  var t = module763(arguments);
  return t.length < 4 || 1 === t[3]
    ? 'rgb(' + Math.round(t[0]) + ', ' + Math.round(t[1]) + ', ' + Math.round(t[2]) + ')'
    : 'rgba(' + Math.round(t[0]) + ', ' + Math.round(t[1]) + ', ' + Math.round(t[2]) + ', ' + t[3] + ')';
};

u.to.rgb.percent = function () {
  var t = module763(arguments),
    s = Math.round((t[0] / 255) * 100),
    o = Math.round((t[1] / 255) * 100),
    u = Math.round((t[2] / 255) * 100);
  return t.length < 4 || 1 === t[3] ? 'rgb(' + s + '%, ' + o + '%, ' + u + '%)' : 'rgba(' + s + '%, ' + o + '%, ' + u + '%, ' + t[3] + ')';
};

u.to.hsl = function () {
  var t = module763(arguments);
  return t.length < 4 || 1 === t[3] ? 'hsl(' + t[0] + ', ' + t[1] + '%, ' + t[2] + '%)' : 'hsla(' + t[0] + ', ' + t[1] + '%, ' + t[2] + '%, ' + t[3] + ')';
};

u.to.hwb = function () {
  var t = module763(arguments),
    s = '';
  if (t.length >= 4 && 1 !== t[3]) s = ', ' + t[3];
  return 'hwb(' + t[0] + ', ' + t[1] + '%, ' + t[2] + '%' + s + ')';
};

u.to.keyword = function (t) {
  return s[t.slice(0, 3)];
};
