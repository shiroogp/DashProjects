var module15 = require('@babel/runtime/helpers/slicedToArray'),
  React = h(require('react')),
  ReactNative = require('react-native'),
  module649 = require('./649'),
  module799 = require('./799'),
  module992 = h(require('./992')),
  module1101 = require('./1101'),
  module1125 = require('./1125');

function p(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    l = new WeakMap();
  return (p = function (t) {
    return t ? l : n;
  })(t);
}

function h(t, n) {
  if (!n && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var l = p(n);
  if (l && l.has(t)) return l.get(t);
  var u = {
      __proto__: null,
    },
    o = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var c in t)
    if ('default' !== c && Object.prototype.hasOwnProperty.call(t, c)) {
      var f = o ? Object.getOwnPropertyDescriptor(t, c) : null;
      if (f && (f.get || f.set)) Object.defineProperty(u, c, f);
      else u[c] = t[c];
    }

  u.default = t;
  if (l) l.set(t, u);
  return u;
}

var x = ReactNative.StyleSheet.create({
  pinFrame: {
    maxHeight: 0.3 * module992.layout.fullHeight,
    flexDirection: 'column',
    justifyContent: 'flex-end',
    alignItems: 'center',
    flex: 1,
  },
  enterPinFrame: {
    flexDirection: 'column',
    justifyContent: 'flex-start',
    alignItems: 'center',
    flex: 1,
  },
  buttonFrame: {
    flex: 1,
    maxHeight: 80,
    width: module992.layout.paddedWidth,
  },
  errorText: {
    color: module992.colors.red,
    fontSize: 16,
    textAlign: 'center',
    paddingHorizontal: 32,
  },
});

exports.default = function () {
  var t = module649.useNavigation(),
    p = React.useState(false),
    h = module15.default(p, 2),
    v = h[0],
    E = h[1],
    P = React.useState(''),
    T = module15.default(P, 2),
    w = T[0],
    b = T[1],
    C = React.useState(false),
    O = module15.default(C, 2),
    F = O[0],
    S = O[1],
    _ = function (t) {
      b(t);
      S(false);
    };

  return React.default.createElement(
    React.default.Fragment,
    null,
    React.default.createElement(
      ReactNative.View,
      {
        style: [module992.default.mainPadded, module992.default.stacked],
      },
      !v &&
        React.default.createElement(
          React.default.Fragment,
          null,
          React.default.createElement(
            ReactNative.TouchableHighlight,
            {
              activeOpacity: 0.5,
              underlayColor: module992.colors.interactionColor,
              onPress: function () {
                return t.navigate('QRCodeScreen');
              },
              style: module1101.default.dashAdd,
            },
            React.default.createElement(
              ReactNative.View,
              {
                style: module992.default.alignCenter,
              },
              React.default.createElement(module799.default, {
                name: 'qrcode-scan',
                color: module992.colors.mainText,
                size: 80,
              }),
              React.default.createElement(
                ReactNative.Text,
                {
                  style: module1101.default.dashAddText,
                },
                'Parear via QR Code'
              )
            )
          ),
          React.default.createElement(
            ReactNative.TouchableHighlight,
            {
              activeOpacity: 0.5,
              underlayColor: module992.colors.interactionColor,
              onPress: function () {
                return E(true);
              },
              style: module1101.default.dashAdd,
            },
            React.default.createElement(
              ReactNative.View,
              {
                style: module992.default.alignCenter,
              },
              React.default.createElement(module799.default, {
                name: 'numeric',
                color: module992.colors.mainText,
                size: 80,
              }),
              React.default.createElement(
                ReactNative.Text,
                {
                  style: module1101.default.dashAddText,
                },
                'Parear via PIN'
              )
            )
          )
        ),
      v &&
        React.default.createElement(
          ReactNative.View,
          {
            style: x.enterPinFrame,
          },
          React.default.createElement(
            ReactNative.View,
            {
              style: x.pinFrame,
            },
            React.default.createElement(
              ReactNative.Text,
              {
                style: module1101.default.dashAddText,
              },
              'Digite o PIN'
            ),
            React.default.createElement(ReactNative.TextInput, {
              style: module992.default.pinInput,
              keyboardType: 'numeric',
              maxLength: 6,
              autoFocus: true,
              onChangeText: function (t) {
                return _(t.toString());
              },
              allowFontScaling: false,
            }),
            F &&
              React.default.createElement(
                ReactNative.Text,
                {
                  style: x.errorText,
                },
                'O PIN deve conter 6 d\xedgitos',
                '\n',
                '(apenas n\xfameros)'
              )
          ),
          React.default.createElement(
            ReactNative.View,
            {
              style: x.buttonFrame,
            },
            React.default.createElement(module1125.default, {
              text: 'Continuar',
              endIcon: 'arrow-right',
              action: function () {
                if (w.length < 6 || !w.match(/^[0-9]+$/)) S(true);
                else
                  t.replace('DashAddScreen', {
                    pin: w,
                  });
              },
            })
          )
        )
    )
  );
};
