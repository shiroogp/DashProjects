var module50 = require('./50'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
  React = x(require('react')),
  ReactNative = require('react-native'),
  module1206 = require('./1206'),
  module1101 = require('./1101'),
  module1276 = x(require('./1276')),
  regeneratorRuntime = require('regenerator-runtime'),
  module1104 = require('./1104'),
  module1279 = require('./1279'),
  regeneratorRuntime = require('regenerator-runtime');

function O(t) {
  if ('function' != typeof WeakMap) return null;
  var o = new WeakMap(),
    n = new WeakMap();
  return (O = function (t) {
    return t ? n : o;
  })(t);
}

function x(t, o) {
  if (!o && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var n = O(o);
  if (n && n.has(t)) return n.get(t);
  var l = {
      __proto__: null,
    },
    u = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var s in t)
    if ('default' !== s && Object.prototype.hasOwnProperty.call(t, s)) {
      var p = u ? Object.getOwnPropertyDescriptor(t, s) : null;
      if (p && (p.get || p.set)) Object.defineProperty(l, s, p);
      else l[s] = t[s];
    }

  l.default = t;
  if (n) n.set(t, l);
  return l;
}

function h(t, o) {
  var n = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var l = Object.getOwnPropertySymbols(t);
    if (o)
      l = l.filter(function (o) {
        return Object.getOwnPropertyDescriptor(t, o).enumerable;
      });
    n.push.apply(n, l);
  }

  return n;
}

function I(t) {
  for (var n = 1; n < arguments.length; n++) {
    var l = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      h(Object(l), true).forEach(function (n) {
        module50.default(t, n, l[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(l));
    else
      h(Object(l)).forEach(function (o) {
        Object.defineProperty(t, o, Object.getOwnPropertyDescriptor(l, o));
      });
  }

  return t;
}

var j = module1206.default.struct({
  rpmM: module1206.default.enums({
    6: '6000',
    7: '7000',
    8: '8000',
    9: '9000',
    10: '10000',
  }),
  sLigt: module1276.minMaxIntNumber(1e3, 1e4),
  redline: module1276.minMaxIntNumber(1e3, 1e4),
  icon: module1206.default.enums({
    1: 'Moderno',
    2: 'Colorido',
  }),
  clt: module1276.minMaxIntNumber(50, 300),
  mat: module1276.minMaxIntNumber(50, 300),
  pOil: module1276.minMaxIntNumber(0, 1e4),
  pFuel: module1276.minMaxIntNumber(0, 1e4),
  pBoost: module1276.minMaxIntNumber(0, 1e4),
  tKm: module1276.minMaxIntNumber(0, 1e6),
  dzAdj: module1206.default.maybe(module1206.default.String),
  oilSwM: module1206.default.enums({
    1: 'Normalmente aberto',
    2: 'Normalmente fechado',
  }),
});

exports.default = function (t) {
  var o,
    s = t.navigation,
    O = React.useRef(),
    x = regeneratorRuntime.default().sendData,
    h = regeneratorRuntime.default(),
    M = h.getData,
    P = h.saveData,
    w = React.useState(false),
    k = module15.default(w, 2),
    S = k[0],
    T = k[1],
    D = React.useState({}),
    N = module15.default(D, 2),
    V = N[0],
    _ = N[1];
  React.useEffect(
    function () {
      M().then(_);
    },
    [S]
  );
  return React.default.createElement(
    React.default.Fragment,
    null,
    S && React.default.createElement(module1104.default, null),
    React.default.createElement(
      ReactNative.SafeAreaView,
      {
        style: module1101.default.main,
      },
      React.default.createElement(module1276.default, {
        type: j,
        options:
          ((o = s),
          {
            fields: {
              rpmM: {
                label: 'RPM m\xe1ximo',
                help: 'Valor m\xe1ximo a ser exibido na escala do tac\xf4metro',
                nullOption: false,
              },
              sLigt: {
                label: 'Shift Light',
                help: 'Valor alvo para exibi\xe7\xe3o do SHIFT na tela',
                error: 'Insira um n\xfamero entre 4000 e 10000',
                keyboardType: 'decimal-pad',
              },
              redline: {
                label: 'RPM Redline (anima\xe7\xe3o)',
                help: 'Valor alvo para a barra indicadora mudar de cor ou piscar',
                error: 'Insira um n\xfamero entre 4000 e 10000',
                keyboardType: 'decimal-pad',
              },
              icon: {
                label: 'Estilo visual dos \xedcones',
                help: 'Selecione o estilo visual desejado para os \xedcones de indica\xe7\xe3o (seta, farol alto, bateria, etc...) do tema',
                nullOption: false,
              },
              oilSwM: {
                label: 'Condi\xe7\xe3o para ativar a luz do \xf3leo',
                help:
                  'Selecione se a luz de \xf3leo ser\xe1 ativada quando o Interruptor de Press\xe3o de \xd3leo aterrar o sinal (normalmente aberto) ou flutuar (normalmente fechado)',
                nullOption: false,
              },
              clt: {
                label: 'Temperatura m\xe1xima da \xe1gua/motor',
                help: 'Valor m\xe1ximo a ser exibido na escala do indicador de temperatura da \xe1gua/motor',
                error: 'Insira um n\xfamero entre 50 e 300',
                keyboardType: 'decimal-pad',
              },
              mat: {
                label: 'Temperatura m\xe1xima do ar',
                help: 'Valor m\xe1ximo a ser exibido na escala do indicador de temperatura do ar da admiss\xe3o',
                error: 'Insira um n\xfamero entre 50 e 300',
                keyboardType: 'decimal-pad',
              },
              pOil: {
                label: 'Press\xe3o m\xe1xima de \xf3leo',
                help: 'Valor m\xe1ximo a ser exibido na escala do indicador de press\xe3o de \xf3leo',
                error: 'Insira um n\xfamero entre 0 e 10000',
                keyboardType: 'decimal-pad',
              },
              pFuel: {
                label: 'Press\xe3o m\xe1xima de combust\xedvel',
                help: 'Valor m\xe1ximo a ser exibido na escala do indicador de press\xe3o de combust\xedvel',
                error: 'Insira um n\xfamero entre 0 e 10000',
                keyboardType: 'decimal-pad',
              },
              pBoost: {
                label: 'Press\xe3o m\xe1xima de turbo/boost',
                help: 'Valor m\xe1ximo a ser exibido na escala do indicador de press\xe3o de turbo/boost',
                error: 'Insira um n\xfamero entre 0 e 10000',
                keyboardType: 'decimal-pad',
              },
              tKm: {
                label: 'Quilometragem base',
                help: 'Insira o valor atual da quilometragem total indicada no painel original do ve\xedculo.',
                error: 'Insira um n\xfamero entre 0 e 1000000',
                keyboardType: 'decimal-pad',
              },
              dzAdj: {
                template: module1279.fullWidthButton,
                label: 'Ajustar \xe1rea \xfatil do display',
                config: {
                  help: 'Ajuste a posi\xe7\xe3o e as dimens\xf5es m\xe1ximas que o tema pode ocupar no display',
                  btnTxt: 'Calibrar',
                  btnCta: function () {
                    return o.navigate('DeadzoneCalibration');
                  },
                },
              },
            },
          }),
        value: V,
        saveAction: function () {
          var t = O.current.getValue();

          if (t) {
            T(true);
            P(t);
            var o = I(
              I({}, t),
              {},
              {
                sLigt: parseInt(t.sLigt, 10),
                redline: parseInt(t.redline, 10),
                clt: parseInt(t.clt, 10),
                mat: parseInt(t.mat, 10),
                pOil: parseInt(t.pOil, 10),
                pFuel: parseInt(t.pFuel, 10),
                pBoost: parseInt(t.pBoost, 10),
              }
            );
            x({
              action: 'saveopts',
              set: 'dsp',
              opts: o,
            })
              .then(function () {
                return s.goBack();
              })
              .catch(function () {
                return T(false);
              });
          }
        },
        navigation: s,
        formRef: O,
        willRestart: true,
      })
    )
  );
};
