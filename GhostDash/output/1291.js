var module15 = require('@babel/runtime/helpers/slicedToArray'),
  React = S(require('react')),
  ReactNative = require('react-native'),
  module1206 = require('./1206'),
  module1101 = require('./1101'),
  module1276 = S(require('./1276')),
  regeneratorRuntime = require('regenerator-runtime'),
  module1104 = require('./1104'),
  module1279 = require('./1279'),
  regeneratorRuntime = require('regenerator-runtime');

function y(t) {
  if ('function' != typeof WeakMap) return null;
  var l = new WeakMap(),
    n = new WeakMap();
  return (y = function (t) {
    return t ? n : l;
  })(t);
}

function S(t, l) {
  if (!l && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var n = y(l);
  if (n && n.has(t)) return n.get(t);
  var o = {
      __proto__: null,
    },
    u = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var c in t)
    if ('default' !== c && Object.prototype.hasOwnProperty.call(t, c)) {
      var s = u ? Object.getOwnPropertyDescriptor(t, c) : null;
      if (s && (s.get || s.set)) Object.defineProperty(o, c, s);
      else o[c] = t[c];
    }

  o.default = t;
  if (n) n.set(t, o);
  return o;
}

var k = module1206.default.struct({
    v1: module1206.default.String,
    v2: module1206.default.String,
    v3: module1206.default.String,
  }),
  M = module1206.default.struct({
    fVls: k,
    tVls: k,
    nCyl: module1276.minMaxIntNumber(0, 32),
    cSpd: module1206.default.maybe(module1206.default.String),
  });

exports.default = function (t) {
  var u,
    y = t.navigation,
    S = regeneratorRuntime.default().sendData,
    k = regeneratorRuntime.default(),
    h = k.getData,
    P = k.saveData,
    _ = React.useState(false),
    w = module15.default(_, 2),
    C = w[0],
    O = w[1],
    V = React.useState({}),
    T = module15.default(V, 2),
    j = T[0],
    R = T[1],
    I = React.useRef();

  React.useEffect(
    function () {
      h().then(R);
    },
    [C]
  );
  return React.default.createElement(
    React.default.Fragment,
    null,
    C && React.default.createElement(module1104.default, null),
    React.default.createElement(
      ReactNative.SafeAreaView,
      {
        style: module1101.default.main,
      },
      React.default.createElement(module1276.default, {
        type: M,
        options:
          ((u = y),
          {
            fields: {
              fVls: {
                template: module1279.multiplePerRow,
                label: 'Valores de resist\xeancia do n\xedvel de combust\xedvel',
                config: {
                  help: 'Insira os valores de resist\xeancia da b\xf3ia do tanque para cada uma das condi\xe7\xf5es acima.',
                },
                fields: {
                  v1: {
                    label: 'Min',
                    keyboardType: 'decimal-pad',
                  },
                  v2: {
                    label: 'Med',
                    keyboardType: 'decimal-pad',
                  },
                  v3: {
                    label: 'Max',
                    keyboardType: 'decimal-pad',
                  },
                },
              },
              tVls: {
                template: module1279.multiplePerRow,
                label: 'Valores de resist\xeancia do sensor de temperatura',
                config: {
                  help: 'Insira os valores de resist\xeancia do sensor de temperatura da \xe1gua do motor para cada uma das condi\xe7\xf5es acima.',
                },
                fields: {
                  v1: {
                    label: '20\xb0C',
                    keyboardType: 'decimal-pad',
                  },
                  v2: {
                    label: '60\xb0C',
                    keyboardType: 'decimal-pad',
                  },
                  v3: {
                    label: '100\xb0C',
                    keyboardType: 'decimal-pad',
                  },
                },
              },
              nCyl: {
                label: 'Fator de divis\xe3o do RPM',
                help: 'Insira o valor no qual o comparador interno ser\xe1 dividido para corrigir o valor do RPM',
                error: 'Insira um n\xfamero entre 0 e 32',
                keyboardType: 'decimal-pad',
              },
              cSpd: {
                template: module1279.fullWidthButton,
                label: 'Calibra\xe7\xe3o autom\xe1tica do VSS',
                config: {
                  help: 'Inicie a calibra\xe7\xe3o e siga os passos na tela para continuar.',
                  btnTxt: 'Calibrar',
                  btnCta: function () {
                    return u.navigate('SpeedCalibration');
                  },
                },
              },
            },
          }),
        value: j,
        saveAction: function () {
          var t = I.current.getValue();

          if (t) {
            O(true);
            P(t);
            S({
              action: 'saveopts',
              opts: t,
            })
              .then(function () {
                return y.goBack();
              })
              .catch(function () {
                return O(false);
              });
          }
        },
        navigation: y,
        formRef: I,
        willRestart: true,
      })
    )
  );
};
