var React = require('react'),
  ReactNative = require('react-native'),
  module1125 = require('./1125');

exports.multiplePerRow = function (t) {
  var o = t.stylesheet,
    u = t.hasError,
    c = o.controlLabel,
    f = o.formGroup,
    s = o.textboxView,
    y = o.helpBlock,
    p = o.errorBlock,
    h = f.normal,
    w = c.normal,
    E = s.normal,
    x = y.normal,
    b = p;
  return React.default.createElement(
    ReactNative.View,
    {
      style: [
        h,
        {
          marginBottom: 32,
        },
      ],
    },
    React.default.createElement(
      ReactNative.Text,
      {
        style: w,
      },
      t.label
    ),
    React.default.createElement(
      ReactNative.View,
      {
        style: [
          E,
          {
            flexDirection: 'row',
            justifyContent: 'space-between',
          },
        ],
      },
      t.order.map(function (o) {
        return React.default.createElement(
          ReactNative.View,
          {
            key: o,
            style: {
              width: '31%',
            },
          },
          t.inputs[o]
        );
      })
    ),
    React.default.createElement(
      ReactNative.Text,
      {
        style: x,
      },
      t.config.help
    ),
    u &&
      React.default.createElement(
        ReactNative.Text,
        {
          style: b,
        },
        t.config.error
      )
  );
};

exports.fullWidthButton = function (t) {
  var u = t.stylesheet,
    c = u.controlLabel,
    f = u.formGroup,
    s = u.helpBlock,
    y = f.normal,
    p = c.normal,
    h = s.normal;
  return React.default.createElement(
    ReactNative.View,
    {
      style: [
        y,
        {
          marginBottom: 32,
        },
      ],
    },
    React.default.createElement(
      ReactNative.Text,
      {
        style: p,
      },
      t.label
    ),
    React.default.createElement(module1125.default, {
      text: t.config.btnTxt,
      action: t.config.btnCta,
      size: 'small',
      endIcon: 'arrow-right',
    }),
    React.default.createElement(
      ReactNative.Text,
      {
        style: h,
      },
      t.config.help
    )
  );
};
