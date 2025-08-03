var module15 = require('@babel/runtime/helpers/slicedToArray'),
  React = (function (t, o) {
    if (!o && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var n = b(o);
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
  })(require('react')),
  ReactNative = require('react-native'),
  module1206 = require('./1206'),
  module1101 = require('./1101'),
  module1276 = require('./1276'),
  regeneratorRuntime = require('regenerator-runtime'),
  module1104 = require('./1104'),
  regeneratorRuntime = require('regenerator-runtime');

function b(t) {
  if ('function' != typeof WeakMap) return null;
  var o = new WeakMap(),
    n = new WeakMap();
  return (b = function (t) {
    return t ? n : o;
  })(t);
}

var h = module1206.default.struct({
    slp: module1206.default.enums({
      1: 'Abrir a porta',
      2: 'Desligar a igni\xe7\xe3o',
      3: 'Ativar o alarme',
    }),
    slpM: module1206.default.enums({
      1: 'Ativado',
      2: 'Desativado',
    }),
    slpT: module1206.default.enums({
      0: '0 (stand-by imediato)',
      15: '15',
      30: '30',
      60: '60',
      120: '120',
      240: '240',
    }),
    offT: module1206.default.enums({
      0: '0 (desligamento imediato)',
      6: '6',
      12: '12',
      18: '18',
      24: '24',
    }),
  }),
  y = {
    fields: {
      slp: {
        label: 'Gatilho de desligamento/stand-by',
        help: 'Selecione o gatilho desejado para que a dash entre em modo de espera (baixo consumo de energia) ou desligue completamente',
        nullOption: false,
      },
      slpM: {
        label: 'Modo stand-by',
        help: 'Selecione se a dash deve entrar em modo de espera (baixo consumo de energia) ou desligar completamente ap\xf3s a a\xe7\xe3o do gatilho',
        nullOption: false,
      },
      slpT: {
        label: 'Tempo de espera (stand-by)',
        help: 'Selecione o tempo (em segundos) ap\xf3s o gatilho para que a dash entre em modo de espera (baixo consumo de energia)',
        nullOption: false,
      },
      offT: {
        label: 'Tempo de espera (desligamento completo)',
        help: 'Selecione o tempo (em horas) ap\xf3s entrar em modo de espera para que a dash seja desligada por completo (nenhum consumo de energia)',
        nullOption: false,
      },
    },
  };

exports.default = function (t) {
  var u = t.navigation,
    b = regeneratorRuntime.default().sendData,
    O = regeneratorRuntime.default(),
    _ = O.getData,
    j = O.saveData,
    M = React.useState(false),
    D = module15.default(M, 2),
    S = D[0],
    w = D[1],
    P = React.useState({}),
    T = module15.default(P, 2),
    A = T[0],
    E = T[1],
    k = React.useRef();
  React.useEffect(
    function () {
      _().then(E);
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
        options: y,
        value: A,
        saveAction: function () {
          var t = k.current.getValue();

          if (t) {
            w(true);
            j(t);
            b({
              action: 'saveopts',
              opts: t,
            })
              .then(function () {
                return u.goBack();
              })
              .catch(function () {
                return w(false);
              });
          }
        },
        navigation: u,
        formRef: k,
      })
    )
  );
};
