var module15 = require('@babel/runtime/helpers/slicedToArray'),
  React = b(require('react')),
  ReactNative = require('react-native'),
  module649 = require('./649'),
  module1304 = require('./1304'),
  module799 = require('./799'),
  module992 = b(require('./992')),
  module1277 = require('./1277'),
  regeneratorRuntime = require('regenerator-runtime');

function y(t) {
  if ('function' != typeof WeakMap) return null;
  var o = new WeakMap(),
    n = new WeakMap();
  return (y = function (t) {
    return t ? n : o;
  })(t);
}

function b(t, o) {
  if (!o && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var n = y(o);
  if (n && n.has(t)) return n.get(t);
  var l = {
      __proto__: null,
    },
    u = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var c in t)
    if ('default' !== c && Object.prototype.hasOwnProperty.call(t, c)) {
      var s = u ? Object.getOwnPropertyDescriptor(t, c) : null;
      if (s && (s.get || s.set)) Object.defineProperty(l, c, s);
      else l[c] = t[c];
    }

  l.default = t;
  if (n) n.set(t, l);
  return l;
}

var h = ReactNative.StyleSheet.create({
  mainBg: {
    backgroundColor: module992.colors.buttons.flat,
    padding: 16,
    borderRadius: 16,
  },
  texts: {
    width: module992.layout.paddedWidth,
    padding: 16,
  },
  title: {
    fontSize: 24,
    color: module992.colors.mainText,
  },
  directions: {
    lineHeight: 18,
    marginTop: 8,
    marginBottom: 24,
    color: module992.colors.mainText,
  },
  alert: {
    lineHeight: 18,
    color: module992.colors.orange,
  },
});

exports.default = function () {
  var t = module649.useNavigation(),
    y = regeneratorRuntime.default().sendData,
    b = React.useState(false),
    T = module15.default(b, 2),
    x = T[0],
    O = T[1],
    w = React.useState(false),
    E = module15.default(w, 2),
    S = E[0],
    _ = E[1];
  return React.default.createElement(
    React.default.Fragment,
    null,
    React.default.createElement(
      ReactNative.View,
      {
        style: [module992.default.mainPadded, module992.default.alignCenter, h.mainBg],
      },
      S
        ? React.default.createElement(module799.default, {
            name: 'checkbox-marked-circle-outline',
            color: module992.colors.mainText,
            size: 120,
          })
        : React.default.createElement(module1304.default, {
            until: 5,
            size: 30,
            onFinish: function () {
              setTimeout(function () {
                _(true);

                setTimeout(function () {
                  return t.navigate('Dashboard');
                }, 1e3);
              }, 1e3);
            },
            digitStyle: {
              backgroundColor: module992.colors.opacityWhite,
            },
            digitTxtStyle: {
              color: module992.colors.white,
            },
            timeToShow: ['M', 'S'],
            timeLabels: {
              m: null,
              s: null,
            },
            running: x,
          })
    ),
    React.default.createElement(
      ReactNative.View,
      {
        style: h.texts,
      },
      React.default.createElement(
        ReactNative.Text,
        {
          style: h.title,
        },
        'Instru\xe7\xf5es'
      ),
      React.default.createElement(
        ReactNative.Text,
        {
          style: h.directions,
        },
        '- Utilize um segundo aparelho para obter a velocidade real do ve\xedculo.',
        '\n',
        '- Acelere e mantenha o ve\xedculo a 50km/h.',
        '\n',
        '- Toque em INICIAR e mantenha o ve\xedculo em velocidade constante durante 5 segundos.',
        '\n',
        '- Utilize o contador acima como refer\xeancia para os 5 segundos.',
        '\n',
        '- Aguarde o aviso de confirma\xe7\xe3o na tela e confira se o veloc\xedmetro exibe a velocidade real do ve\xedculo.'
      ),
      React.default.createElement(
        ReactNative.Text,
        {
          style: h.alert,
        },
        'ATEN\xc7\xc3O! N\xe3o realize a calibra\xe7\xe3o sozinho! O procedimento deve ser realizado por outra pessoa que n\xe3o esteja dirigindo o ve\xedculo.'
      )
    ),
    React.default.createElement(module1277.default, {
      onSave: function () {
        O(true);
        return void y({
          action: 'calibrateVss',
        });
      },
      okText: 'Iniciar',
    })
  );
};
