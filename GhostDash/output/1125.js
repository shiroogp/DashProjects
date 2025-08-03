var React = require('react'),
  ReactNative = require('react-native'),
  PropTypes = require('prop-types'),
  module799 = require('./799'),
  module992 = require('./992'),
  s = ReactNative.StyleSheet.create({
    Button: {
      margin: 8,
      padding: 8,
      borderRadius: 8,
      backgroundColor: module992.colors.buttons.flat,
      justifyContent: 'center',
      alignItems: 'center',
      flexDirection: 'row',
      flexGrow: 1,
      maxHeight: 80,
    },
    ButtonDisabled: {
      backgroundColor: module992.colors.lighter,
      opacity: 0.35,
    },
    ButtonText: {
      fontSize: 16,
      marginLeft: 8,
      marginRight: 8,
      color: module992.colors.white,
    },
    ButtonTouch: {
      flexDirection: 'row',
      flex: 1,
      justifyContent: 'center',
      alignItems: 'center',
    },
    IconColor: {
      color: module992.colors.white,
    },
    ButtonBlock: {
      width: 50,
      flexGrow: 0,
    },
  }),
  f = function (t) {
    var n = t.action,
      f = t.size,
      b = t.disabled,
      C = t.text,
      h = t.icon,
      x = t.block,
      B = t.endIcon,
      y = t.bgColor;
    return React.default.createElement(
      ReactNative.TouchableHighlight,
      {
        activeOpacity: 0.5,
        underlayColor: module992.colors.interactionColor,
        onPress: function () {
          return b ? null : n();
        },
        style: [
          s.Button,
          {
            normal: {
              padding: 16,
            },
            small: {
              padding: 8,
            },
          }[f],
          b ? s.ButtonDisabled : {},
          x ? s.ButtonBlock : {},
          y
            ? {
                backgroundColor: y,
              }
            : {},
        ],
      },
      React.default.createElement(
        ReactNative.View,
        {
          style: s.ButtonTouch,
        },
        h &&
          React.default.createElement(module799.default, {
            name: h,
            color: s.IconColor.color,
            size: 16,
          }),
        C &&
          React.default.createElement(
            ReactNative.Text,
            {
              style: s.ButtonText,
            },
            C
          ),
        B &&
          React.default.createElement(module799.default, {
            name: B,
            color: s.IconColor.color,
            size: 16,
          })
      )
    );
  };

f.propTypes = {
  action: PropTypes.default.func,
  size: PropTypes.default.string,
  disabled: PropTypes.default.bool,
  text: PropTypes.default.string,
  icon: PropTypes.default.string,
  endIcon: PropTypes.default.string,
  block: PropTypes.default.bool,
  bgColor: PropTypes.default.string,
};
f.defaultProps = {
  action: function () {},
  size: 'normal',
  disabled: false,
  block: false,
  text: null,
  icon: null,
  endIcon: null,
  bgColor: null,
};
exports.default = f;
