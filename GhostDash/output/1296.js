exports.isEmpty = function n(t) {
  if ('string' == typeof t) return '' === (t = t.replace(/\s/g, ''));
  if (!t) return true;
  if (t === {}) return true;
  if (t === []) return true;
  if (null == t) return true;
  if (undefined === t) return true;
  if ('' === t) return true;
  if (t === function () {}) return true;

  if ('object' == typeof t) {
    if (0 === Object.entries(t).length && t.constructor === Object) return true;

    for (var o in t) if (t.hasOwnProperty(o) && !n(t[o])) return false;

    return true;
  }

  return false;
};

var n = (exports.parseColor = function (n) {
  var t,
    o = n.replace(/\s/g, '');
  t = (t = /#([\da-fA-F]{2})([\da-fA-F]{2})([\da-fA-F]{2})([\da-fA-F]{2})/.exec(o))
    ? [parseInt(t[1], 16), parseInt(t[2], 16), parseInt(t[3], 16), parseInt(t[4], 16)]
    : (t = /#([\da-fA-F]{2})([\da-fA-F]{2})([\da-fA-F]{2})/.exec(o))
    ? [parseInt(t[1], 16), parseInt(t[2], 16), parseInt(t[3], 16)]
    : (t = /#([\da-fA-F])([\da-fA-F])([\da-fA-F])/.exec(o))
    ? [17 * parseInt(t[1], 16), 17 * parseInt(t[2], 16), 17 * parseInt(t[3], 16)]
    : (t = /rgba\(([\d]+),([\d]+),([\d]+),([\d]+|[\d]*.[\d]+)\)/.exec(o))
    ? [+t[1], +t[2], +t[3], +t[4]]
    : (t = /rgb\(([\d]+),([\d]+),([\d]+)\)/.exec(o))
    ? [+t[1], +t[2], +t[3]]
    : [0, 0, 0, 0];
  if (isNaN(t[3])) t[3] = 255;
  return t;
});

exports.colorsToHex = function (n) {
  return (
    '#' +
    n
      .map(function (n) {
        for (n = n.toString(16); n.length < 2; ) n += '0';

        return n;
      })
      .join('')
  );
};

exports.isTransparentColor = function (t) {
  t = String(t).toLowerCase().trim();
  var o = n(t);
  return 'transparent' === String(t).toLowerCase().trim() || 0 === o[4];
};

exports.isCallable = function (n) {
  return null != n && (n instanceof Function || 'function' == typeof n);
};

exports.debounce = function (n, t) {
  var o;
  return function (...args) {
    var c = this;
    clearTimeout(o);
    o = setTimeout(function () {
      return n.apply(c, args);
    }, t);
    return o;
  };
};

exports.isNumeric = function (n) {
  return null != n && false !== n && '' !== n && !isNaN(parseFloat(n)) && !isNaN(n - 0);
};

exports.mergeViewStyle = function (n, t) {
  if (null == n) n = t;
  else if (Array.isArray(n) && Array.isArray(t)) t.concat(n);
  else if (Array.isArray(t)) t.push(n);
  else if (Array.isArray(n)) n.unshift(t);
  else n = [t, n];
  return n;
};

exports.getColorContrast = function (n) {
  if ('#' === n.slice(0, 1)) n = n.slice(1);
  if (3 === n.length)
    n = n
      .split('')
      .map(function (n) {
        return n + n;
      })
      .join('');
  return (299 * parseInt(n.substr(0, 2), 16) + 587 * parseInt(n.substr(2, 2), 16) + 114 * parseInt(n.substr(4, 2), 16)) / 1e3 >= 170 ? '#000000' : '#FFFFFF';
};
