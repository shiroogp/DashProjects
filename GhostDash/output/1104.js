var React = require('react'),
  ReactNative = require('react-native'),
  PropTypes = require('prop-types'),
  module992 = require('./992'),
  s = ReactNative.StyleSheet.create({
    root: {
      position: 'absolute',
      top: 0,
      bottom: 0,
      left: 0,
      right: 0,
      justifyContent: 'center',
      alignItems: 'center',
      zIndex: 999,
      backgroundColor: module992.colors.smoke,
    },
    loading: {
      paddingBottom: module992.layout.fullHeight / 4,
    },
  }),
  u = function (t) {
    var l = t.content,
      u = t.size;
    return React.default.createElement(
      ReactNative.View,
      {
        style: [
          s.root,
          l && {
            backgroundColor: 'transparent',
          },
        ],
      },
      React.default.createElement(ReactNative.ActivityIndicator, {
        size: u,
        color: module992.colors.mainText,
        style: [
          s.loading,
          l && {
            paddingBottom: 0,
          },
        ],
      })
    );
  };

u.propTypes = {
  content: PropTypes.default.bool,
  size: PropTypes.default.string,
};
u.defaultProps = {
  content: false,
  size: 'large',
};
exports.default = u;
