var module15 = require('@babel/runtime/helpers/slicedToArray'),
  module50 = require('./50'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var u = w(n);
    if (u && u.has(t)) return u.get(t);
    var o = {
        __proto__: null,
      },
      f = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var l in t)
      if ('default' !== l && Object.prototype.hasOwnProperty.call(t, l)) {
        var c = f ? Object.getOwnPropertyDescriptor(t, l) : null;
        if (c && (c.get || c.set)) Object.defineProperty(o, l, c);
        else o[l] = t[l];
      }

    o.default = t;
    if (u) u.set(t, o);
    return o;
  })(require('react')),
  ReactNative = require('react-native'),
  module1206 = require('./1206'),
  module649 = require('./649'),
  PropTypes = require('prop-types'),
  module1036 = require('./1036'),
  module1101 = require('./1101'),
  module1276 = require('./1276'),
  regeneratorRuntime = require('regenerator-runtime'),
  module1104 = require('./1104'),
  regeneratorRuntime = require('regenerator-runtime'),
  module1314 = require('./1314');

function w(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    u = new WeakMap();
  return (w = function (t) {
    return t ? u : n;
  })(t);
}

function D(t, n) {
  var u = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var o = Object.getOwnPropertySymbols(t);
    if (n)
      o = o.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    u.push.apply(u, o);
  }

  return u;
}

function _(t) {
  for (var n = 1; n < arguments.length; n++) {
    var o = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      D(Object(o), true).forEach(function (n) {
        module50.default(t, n, o[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      D(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

var h = function (t) {
  var s = t.slots,
    w = t.codename,
    D = module649.useNavigation(),
    h = React.useRef(),
    S = regeneratorRuntime.default().sendData,
    E = regeneratorRuntime.default(),
    k = E.getData,
    M = E.saveData,
    R = E.defautSettings,
    W = React.useState(false),
    A = module15.default(W, 2),
    C = A[0],
    V = A[1],
    B = React.useState({}),
    F = module15.default(B, 2),
    N = F[0],
    T = F[1],
    q = (function () {
      for (
        var t = module1036.reduce(
            function (t, n) {
              var o = n.id,
                f = n.label;
              return _(_({}, t), {}, module50.default({}, o, f));
            },
            {},
            module1314.default[w]
          ),
          n = {},
          o = {},
          f = 0;
        f < s;
        f += 1
      ) {
        n['gS' + f] = module1206.default.enums(
          _(
            {
              0: 'Desativado',
            },
            t
          )
        );
        o['gS' + f] = {
          label: 'Slot ' + (f + 1),
          nullOption: false,
        };
      }

      return [
        module1206.default.struct(n),
        {
          fields: o,
        },
      ];
    })(),
    x = module15.default(q, 2),
    z = x[0],
    G = x[1];

  React.useEffect(function () {
    k().then(function (t) {
      return T(t);
    });
  }, []);
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
        type: z,
        options: G,
        value: N,
        saveAction: function () {
          var t = h.current.getValue();

          if (t) {
            V(true);
            M(t);
            S({
              action: 'saveopts',
              opts: _(
                _({}, t),
                {},
                {
                  gC: R.gC,
                }
              ),
            })
              .then(function () {
                return D.goBack();
              })
              .catch(function () {
                return V(false);
              });
          }
        },
        navigation: D,
        formRef: h,
        willRestart: true,
      })
    )
  );
};

h.propTypes = {
  slots: PropTypes.default.number,
  codename: PropTypes.default.string,
};
h.defaultProps = {
  slots: 20,
  codename: 'modular',
};
exports.default = h;
