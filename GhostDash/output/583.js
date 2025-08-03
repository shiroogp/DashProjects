var module584 = require('./584'),
  module585 = require('./585'),
  module578 = require('./578'),
  module588 = require('./588'),
  module590 = require('./590'),
  module591 = require('./591'),
  l = Object.prototype.hasOwnProperty;

module.exports = function (s, u) {
  var b = module578(s),
    c = !b && module585(s),
    y = !b && !c && module588(s),
    v = !b && !c && !y && module591(s),
    O = b || c || y || v,
    _ = O ? module584(s.length, String) : [],
    j = _.length;

  for (var w in s)
    (!u && !l.call(s, w)) ||
      (O && ('length' == w || (y && ('offset' == w || 'parent' == w)) || (v && ('buffer' == w || 'byteLength' == w || 'byteOffset' == w)) || module590(w, j))) ||
      _.push(w);

  return _;
};
