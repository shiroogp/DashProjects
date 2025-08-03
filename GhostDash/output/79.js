require('./52');

var module68 = require('./68');

module.exports = function (t) {
  if (undefined === t || null === t) return t;
  var o = module68(t);

  if (null !== o && undefined !== o) {
    if ('object' == typeof o) {
      var module69 = require('./69').processColorObject(o);

      if (null != module69) return module69;
    }

    if ('number' != typeof o) return null;
    else {
      o = ((o << 24) | (o >>> 8)) >>> 0;
      o |= 0;
      return o;
    }
  }
};
