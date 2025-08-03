var module519 = require('./519'),
  module587 = require('./587');

module.exports = function l(t, o, c, f, _) {
  return t === o || (null == t || null == o || (!module587(t) && !module587(o)) ? t != t && o != o : module519(t, o, c, f, l, _));
};
