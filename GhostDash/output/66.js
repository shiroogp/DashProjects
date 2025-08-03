var module50 = require('./50');

function o(t, o) {
  var n = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var b = Object.getOwnPropertySymbols(t);
    if (o)
      b = b.filter(function (o) {
        return Object.getOwnPropertyDescriptor(t, o).enumerable;
      });
    n.push.apply(n, b);
  }

  return n;
}

function n(n) {
  for (var b = 1; b < arguments.length; b++) {
    var c = null != arguments[b] ? arguments[b] : {};
    if (b % 2)
      o(Object(c), true).forEach(function (o) {
        module50(n, o, c[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(n, Object.getOwnPropertyDescriptors(c));
    else
      o(Object(c)).forEach(function (t) {
        Object.defineProperty(n, t, Object.getOwnPropertyDescriptor(c, t));
      });
  }

  return n;
}

var module67 = require('./67'),
  module70 = require('./70'),
  module74 = require('./74'),
  module75 = require('./75'),
  PropTypes = require('prop-types'),
  p = n(
    n(n(n({}, module70), module74), module75),
    {},
    {
      resizeMode: PropTypes.oneOf(['center', 'contain', 'cover', 'repeat', 'stretch']),
      backfaceVisibility: PropTypes.oneOf(['visible', 'hidden']),
      backgroundColor: module67,
      borderColor: module67,
      borderWidth: PropTypes.number,
      borderRadius: PropTypes.number,
      overflow: PropTypes.oneOf(['visible', 'hidden']),
      tintColor: module67,
      opacity: PropTypes.number,
      overlayColor: PropTypes.string,
      borderTopLeftRadius: PropTypes.number,
      borderTopRightRadius: PropTypes.number,
      borderBottomLeftRadius: PropTypes.number,
      borderBottomRightRadius: PropTypes.number,
    }
  );

module.exports = p;
