var module50 = require('./50'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
  React = y(require('react')),
  ReactNative = require('react-native'),
  module1206 = require('./1206'),
  module1101 = require('./1101'),
  module1276 = y(require('./1276')),
  regeneratorRuntime = require('regenerator-runtime'),
  module1104 = require('./1104'),
  regeneratorRuntime = require('regenerator-runtime');

function O(t) {
  if ('function' != typeof WeakMap) return null;
  var o = new WeakMap(),
    n = new WeakMap();
  return (O = function (t) {
    return t ? n : o;
  })(t);
}

function y(t, o) {
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

function S(t, o) {
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

function M(t) {
  for (var n = 1; n < arguments.length; n++) {
    var l = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      S(Object(l), true).forEach(function (n) {
        module50.default(t, n, l[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(l));
    else
      S(Object(l)).forEach(function (o) {
        Object.defineProperty(t, o, Object.getOwnPropertyDescriptor(l, o));
      });
  }

  return t;
}

var h = module1206.default.struct({
    aFuel: module1206.default.enums({
      1: 'Maior precis\xe3o',
      2: 'Maior frequ\xeancia',
    }),
    aSpd: module1206.default.enums({
      1: 'Maior precis\xe3o',
      2: 'Maior frequ\xeancia',
    }),
    cVss: module1276.minMaxIntNumber(0, 5),
    sRpm: module1206.default.enums({
      1: 'M\xf3dulo interno',
      2: 'Rede CAN',
    }),
    sVss: module1206.default.enums({
      1: 'M\xf3dulo interno',
      2: 'Rede CAN',
    }),
    sClt: module1206.default.enums({
      1: 'M\xf3dulo interno',
      2: 'Rede CAN',
    }),
    sCan: module1206.default.enums({
      1: 'Ativado',
      2: 'Desativado',
    }),
    pCan: module1206.default.enums({
      1: 'MS2/MS2X | MS3/MS3X',
      2: 'Speeduino',
      3: 'InjePro',
      4: 'FT450 | FT550 | FT600',
      5: 'FT500',
      6: 'Pro Tune',
      7: 'Master Injection',
      8: 'Hondata',
      9: 'Link 1',
      10: 'Link 2',
      11: 'AEM 1',
      12: 'AEM 2',
      13: 'Adaptronic',
      14: 'Haltech',
      15: 'Holley',
      16: 'MaxxECU',
      17: 'Octtane',
    }),
    canSpd: module1276.minMaxIntNumber(0, 2e3),
    canId: module1276.minMaxIntNumber(0, 999999),
  }),
  C = {
    fields: {
      aFuel: {
        label: 'Algoritmo do n\xedvel de combust\xedvel',
        help: 'Selecione o modo no qual ser\xe3o feitos os c\xe1lculos do n\xedvel de combust\xedvel',
        nullOption: false,
      },
      aSpd: {
        label: 'Algoritmo do veloc\xedmetro',
        help: 'Selecione o modo no qual ser\xe3o feitos os c\xe1lculos do veloc\xedmetro',
        nullOption: false,
      },
      cVss: {
        label: 'Fator de corre\xe7\xe3o do veloc\xedmetro',
        help: 'Insira o valor no qual o comparador interno ser\xe1 multiplicado para corrigir o valor do veloc\xedmetro',
        error: 'Insira um n\xfamero entre 0 e 5 (at\xe9 duas casas decimais)',
        keyboardType: 'decimal-pad',
      },
      sRpm: {
        label: 'Fonte do sinal de RPM',
        help: 'Selecione a fonte na qual ser\xe1 feita a leitura do sinal de RPM',
        nullOption: false,
      },
      sVss: {
        label: 'Fonte do sinal do veloc\xedmetro (VSS)',
        help: 'Selecione a fonte na qual ser\xe1 feita a leitura do sinal do veloc\xedmetro (VSS)',
        nullOption: false,
      },
      sClt: {
        label: 'Fonte do sinal de temperatura do motor (CLT)',
        help: 'Selecione a fonte na qual ser\xe1 feita a leitura do sinal de temperatura do motor (CLT)',
        nullOption: false,
      },
      sCan: {
        label: 'Rede CAN (Dash Broadcasting)',
        help: 'Habilita a comunica\xe7\xe3o com a ECU via rede CAN',
        nullOption: false,
      },
      pCan: {
        label: 'Protocolo da rede CAN',
        help: 'Selecione o protocolo no qual a dash buscar\xe1 as informa\xe7\xf5es na rede CAN',
        nullOption: false,
      },
      canSpd: {
        label: 'Velocidade da conex\xe3o CAN',
        help: 'Insira a velocidade (baud rate) rede CAN (kbps)(0 para auto)',
        error: 'Insira um n\xfamero entre 0 e 2000',
        keyboardType: 'number-pad',
      },
      canId: {
        label: 'ID inicial dos pacotes na rede CAN',
        help: 'Insira o ID inicial dos pacotes na rede CAN (0 para auto)',
        error: 'Insira um n\xfamero entre 0 e 999999',
        keyboardType: 'number-pad',
      },
    },
  };

exports.default = function (t) {
  var o = t.navigation,
    c = regeneratorRuntime.default().sendData,
    O = React.useState(false),
    y = module15.default(O, 2),
    S = y[0],
    j = y[1],
    A = regeneratorRuntime.default(),
    I = A.getData,
    P = A.saveData,
    F = React.useRef(),
    N = React.useState({}),
    w = module15.default(N, 2),
    D = w[0],
    k = w[1];
  React.useEffect(
    function () {
      I().then(k);
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
        type: h,
        options: C,
        value: D,
        saveAction: function () {
          var t = F.current.getValue();

          if (t) {
            j(true);
            P(t);
            var n = M(
              M({}, t),
              {},
              {
                cVss: parseFloat(parseFloat(t.cVss, 10).toFixed(2), 10),
                canSpd: parseInt(t.canSpd, 10),
                canId: parseInt(t.canId, 10),
              }
            );
            c({
              action: 'saveopts',
              opts: n,
            })
              .then(function () {
                return o.goBack();
              })
              .catch(function () {
                return j(false);
              });
          }
        },
        navigation: o,
        formRef: F,
        willRestart: true,
      })
    )
  );
};
