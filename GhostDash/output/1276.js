exports.minMaxIntNumber = function (t, o) {
  return module1206.default.refinement(module1206.default.String, function (l) {
    var n = parseInt(l.replace(',', '.').trim(), 10) || false;
    return n >= t && n <= o;
  });
};

var module15 = require('@babel/runtime/helpers/slicedToArray'),
  React = require('react'),
  ReactNative = require('react-native'),
  PropTypes = require('prop-types'),
  module1206 = require('./1206'),
  regeneratorRuntime = require('regenerator-runtime'),
  module992 = require('./992'),
  module1101 = require('./1101'),
  module1277 = require('./1277'),
  module1143 = require('./1143'),
  module1056 = require('./1056'),
  x = module1206.default.form.Form;

x.i18n.optional = '';
x.stylesheet.textbox.normal.color = module992.colors.white;
x.stylesheet.textbox.error.color = module992.colors.red;
x.stylesheet.textbox.normal.borderWidth = 0;
x.stylesheet.textbox.normal.height = 44;
x.stylesheet.pickerContainer.normal.borderWidth = 0;
x.stylesheet.textbox.normal.backgroundColor = module992.colors.textInput;
x.stylesheet.pickerTouchable.normal.backgroundColor = module992.colors.textInput;
x.stylesheet.pickerTouchable.normal.borderRadius = 4;
x.stylesheet.pickerValue.normal.color = module992.colors.white;
x.stylesheet.select.normal.color = module992.colors.white;
x.stylesheet.select.normal.backgroundColor = module992.colors.lighter;
x.stylesheet.select.normal.borderBottomWidth = 2;
x.stylesheet.select.normal.width = '100%';
x.stylesheet.formGroup.normal.color = module992.colors.mainText;
x.stylesheet.controlLabel.normal.color = module992.colors.mainText;
x.stylesheet.formGroup.normal.marginBottom = 16;
x.stylesheet.formGroup.error.marginBottom = 16;
x.stylesheet.helpBlock.normal.fontSize = 14;
x.stylesheet.helpBlock.error.fontSize = 14;
x.stylesheet.formGroup.normal.width = '100%';
x.stylesheet.formGroup.error.width = '100%';

var v = ReactNative.StyleSheet.create({
    mainForm: {
      display: 'flex',
      flex: 1,
    },
  }),
  R = function (t) {
    var s = t.type,
      u = t.options,
      f = t.value,
      R = t.saveAction,
      w = t.formRef,
      k = t.willRestart,
      C = t.onChange,
      S = regeneratorRuntime.useRecoilState(module1056.currentBluetoothState),
      T = module15.default(S, 1)[0];
    return React.default.createElement(
      ReactNative.View,
      {
        style: [module1101.default.main, module1101.default.alignToTop, v.mainForm],
      },
      React.default.createElement(
        ReactNative.View,
        {
          style: v.mainForm,
        },
        React.default.createElement(
          ReactNative.ScrollView,
          {
            contentContainerStyle: module1101.default.paddedContainer,
          },
          React.default.createElement(x, {
            ref: w,
            type: s,
            options: u,
            value: f,
            onChange: C,
          })
        )
      ),
      React.default.createElement(module1277.default, {
        onSave: function () {
          return k ? module1143.checkUIRestart(R) : R();
        },
        loading: 'conn' !== T,
      })
    );
  };

R.propTypes = {
  type: PropTypes.default.func.isRequired,
  options: PropTypes.default.object.isRequired,
  value: PropTypes.default.object.isRequired,
  saveAction: PropTypes.default.func.isRequired,
  formRef: PropTypes.default.object.isRequired,
  willRestart: PropTypes.default.bool,
  onChange: PropTypes.default.func,
};
R.defaultProps = {
  willRestart: false,
  onChange: function () {},
};
exports.default = R;
