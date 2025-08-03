var React = require('react'),
  ReactNative = require('react-native'),
  module649 = require('./649'),
  PropTypes = require('prop-types'),
  module1278 = require('./1278'),
  module992 = require('./992'),
  module1104 = require('./1104'),
  y = ReactNative.StyleSheet.create({
    bottomButtons: {
      flexDirection: 'row',
      display: 'flex',
      margin: -8,
      padding: 16,
    },
  }),
  b = function (t) {
    var u = t.onSave,
      b = t.okText,
      h = t.okOnly,
      v = t.disabled,
      T = t.loading,
      x = t.hideWithKeyboard,
      p = module649.useNavigation(),
      k = x ? module1278.default : ReactNative.View;
    return React.default.createElement(
      k,
      {
        style: y.bottomButtons,
      },
      !h &&
        React.default.createElement(
          ReactNative.TouchableHighlight,
          {
            style: [module992.style.button, module992.style.cancelButton],
            onPress: function () {
              return p.goBack();
            },
            underlayColor: module992.colors.interactionColor,
          },
          React.default.createElement(
            ReactNative.Text,
            {
              style: module992.style.buttonText,
            },
            'cancelar'
          )
        ),
      React.default.createElement(
        ReactNative.TouchableHighlight,
        {
          style: [
            module992.style.button,
            module992.style.saveButton,
            {
              opacity: v ? 0.2 : 1,
            },
          ],
          onPress: function () {
            return u();
          },
          underlayColor: module992.colors.interactionColor,
          disabled: v || T,
        },
        T
          ? React.default.createElement(module1104.default, {
              size: 20,
              content: true,
            })
          : React.default.createElement(
              ReactNative.Text,
              {
                style: module992.style.buttonText,
              },
              b
            )
      )
    );
  };

b.propTypes = {
  onSave: PropTypes.default.func.isRequired,
  okText: PropTypes.default.string,
  okOnly: PropTypes.default.bool,
  disabled: PropTypes.default.bool,
  loading: PropTypes.default.bool,
  hideWithKeyboard: PropTypes.default.bool,
};
b.defaultProps = {
  okText: 'salvar',
  okOnly: false,
  disabled: false,
  loading: false,
  hideWithKeyboard: true,
};
exports.default = b;
