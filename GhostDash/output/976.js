var React = require('react'),
  ReactNative = require('react-native'),
  PropTypes = require('prop-types'),
  module977 = require('./977'),
  module978 = require('./978');

function f(t) {
  var o = t.source,
    s = t.style;
  return o
    ? React.default.createElement(ReactNative.Image, {
        testID: 'icon',
        source: o,
        style: [module978.default.base, s],
        resizeMode: 'contain',
      })
    : null;
}

var c = PropTypes.default.oneOfType([
  PropTypes.default.number,
  PropTypes.default.shape({
    uri: PropTypes.default.string,
  }),
]);
f.propTypes = {
  source: c,
  style: module977.stylePropType,
};
f.defaultProps = {
  source: undefined,
  style: undefined,
};
exports.default = f;
