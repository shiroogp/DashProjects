require('./1304');

require('./799');

var module15 = require('@babel/runtime/helpers/slicedToArray'),
  React = y(require('react')),
  ReactNative = require('react-native'),
  module649 = require('./649'),
  module992 = y(require('./992')),
  module1277 = require('./1277'),
  regeneratorRuntime = require('regenerator-runtime'),
  module1125 = require('./1125');

function b(t) {
  if ('function' != typeof WeakMap) return null;
  var o = new WeakMap(),
    l = new WeakMap();
  return (b = function (t) {
    return t ? l : o;
  })(t);
}

function y(t, o) {
  if (!o && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var l = b(o);
  if (l && l.has(t)) return l.get(t);
  var n = {
      __proto__: null,
    },
    s = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var u in t)
    if ('default' !== u && Object.prototype.hasOwnProperty.call(t, u)) {
      var c = s ? Object.getOwnPropertyDescriptor(t, u) : null;
      if (c && (c.get || c.set)) Object.defineProperty(n, u, c);
      else n[u] = t[u];
    }

  n.default = t;
  if (l) l.set(t, n);
  return n;
}

var T = ReactNative.StyleSheet.create({
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
  stepItem: {
    flexDirection: 'row',
    marginBottom: 24,
    paddingBottom: 16,
    borderBottomWidth: 1,
    borderBottomColor: module992.colors.border,
  },
  stepText: {
    alignContent: 'center',
    padding: 8,
    paddingLeft: 0,
    paddingRight: 24,
  },
  stepTitle: {
    fontSize: 18,
    color: module992.colors.buttons.save,
  },
});

exports.default = function () {
  module649.useNavigation();
  var t = regeneratorRuntime.default().sendData,
    b = React.useState(false),
    y = module15.default(b, 2),
    v = y[1],
    x = React.useState(false),
    E = module15.default(x, 2);
  return React.default.createElement(
    React.default.Fragment,
    null,
    React.default.createElement(
      ReactNative.View,
      {
        style: T.texts,
      },
      React.default.createElement(
        ReactNative.Text,
        {
          style: T.title,
        },
        'Instru\xe7\xf5es'
      ),
      React.default.createElement(
        ReactNative.Text,
        {
          style: T.directions,
        },
        '- Antes de iniciar a calibra\xe7\xe3o, certifique-se de que o sinal da b\xf3ia de combust\xedvel \xe9 recebido pela dash.',
        '\n',
        '- Posicione a b\xf3ia de combust\xedvel de acordo com cada passo.',
        '\n',
        '- Mantenha a b\xf3ia de combust\xedvel na posi\xe7\xe3o e toque no bot\xe3o correspondente ao passo atual.',
        '\n',
        '- Mantenha a posi\xe7\xe3o enquanto o bot\xe3o exibe o status "carregando".',
        '\n',
        '- Certifique-se que as tr\xeas etapas possuem o \xedcone de "check" e toque no bot\xe3o "Salvar".'
      ),
      React.default.createElement(
        ReactNative.Text,
        {
          style: T.alert,
        },
        'ATEN\xc7\xc3O! N\xe3o realize a calibra\xe7\xe3o sozinho!'
      )
    ),
    React.default.createElement(
      ReactNative.View,
      {
        style: module992.default.mainPadded,
      },
      React.default.createElement(
        ReactNative.View,
        {
          style: T.stepItem,
        },
        React.default.createElement(
          ReactNative.View,
          {
            style: T.stepText,
          },
          React.default.createElement(
            ReactNative.Text,
            {
              style: T.stepTitle,
            },
            'Passo 1'
          ),
          React.default.createElement(
            ReactNative.Text,
            {
              style: T.stepTitle,
            },
            'Posi\xe7\xe3o "tanque cheio"'
          )
        ),
        React.default.createElement(module1125.default, {
          text: 'N\xedvel m\xe1ximo',
          action: function () {},
        })
      ),
      React.default.createElement(
        ReactNative.View,
        {
          style: T.stepItem,
        },
        React.default.createElement(
          ReactNative.View,
          {
            style: T.stepText,
          },
          React.default.createElement(
            ReactNative.Text,
            {
              style: T.stepTitle,
            },
            'Passo 2'
          ),
          React.default.createElement(
            ReactNative.Text,
            {
              style: T.stepTitle,
            },
            'Posi\xe7\xe3o "meio tanque"'
          )
        ),
        React.default.createElement(module1125.default, {
          text: 'N\xedvel m\xe9dio',
          action: function () {},
        })
      ),
      React.default.createElement(
        ReactNative.View,
        {
          style: T.stepItem,
        },
        React.default.createElement(
          ReactNative.View,
          {
            style: T.stepText,
          },
          React.default.createElement(
            ReactNative.Text,
            {
              style: T.stepTitle,
            },
            'Passo 3'
          ),
          React.default.createElement(
            ReactNative.Text,
            {
              style: T.stepTitle,
            },
            'Posi\xe7\xe3o "tanque vazio"'
          )
        ),
        React.default.createElement(module1125.default, {
          text: 'N\xedvel m\xednimo',
          action: function () {},
        })
      )
    ),
    React.default.createElement(module1277.default, {
      onSave: function () {
        v(true);
        return void t({
          action: 'calibrateVss',
        });
      },
      okText: 'Salvar',
      disabled: true,
    })
  );
};
