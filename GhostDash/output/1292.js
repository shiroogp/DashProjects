var module14 = require('./14'),
  module50 = require('./50'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
  React = O(require('react')),
  ReactNative = require('react-native'),
  module1293 = require('./1293'),
  module992 = O(require('./992')),
  module1277 = require('./1277'),
  regeneratorRuntime = require('regenerator-runtime'),
  module1104 = require('./1104'),
  regeneratorRuntime = require('regenerator-runtime');

function v(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (v = function (t) {
    return t ? o : n;
  })(t);
}

function O(t, n) {
  if (!n && t && t.__esModule) return t;
  if (null === t || ('object' != typeof t && 'function' != typeof t))
    return {
      default: t,
    };
  var o = v(n);
  if (o && o.has(t)) return o.get(t);
  var l = {
      __proto__: null,
    },
    u = Object.defineProperty && Object.getOwnPropertyDescriptor;

  for (var c in t)
    if ('default' !== c && Object.prototype.hasOwnProperty.call(t, c)) {
      var f = u ? Object.getOwnPropertyDescriptor(t, c) : null;
      if (f && (f.get || f.set)) Object.defineProperty(l, c, f);
      else l[c] = t[c];
    }

  l.default = t;
  if (o) o.set(t, l);
  return l;
}

function w(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var l = Object.getOwnPropertySymbols(t);
    if (n)
      l = l.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, l);
  }

  return o;
}

function j(t) {
  for (var n = 1; n < arguments.length; n++) {
    var l = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      w(Object(l), true).forEach(function (n) {
        module50.default(t, n, l[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(l));
    else
      w(Object(l)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(l, n));
      });
  }

  return t;
}

var E = ReactNative.StyleSheet.create({
    mainBg: {
      backgroundColor: module992.colors.buttons.flat,
      padding: 16,
      borderRadius: 16,
    },
    vertical: {
      flexDirection: 'column-reverse',
      height: 160,
    },
    horizontal: {
      width: 160,
    },
    buttons: {
      backgroundColor: module992.colors.buttons.save,
      width: 50,
      height: 50,
      borderRadius: 32,
    },
    content: {
      flexDirection: 'row',
      width: '100%',
      justifyContent: 'space-between',
      paddingVertical: 0,
    },
    outerBox: {
      width: module992.layout.paddedWidth - 164,
      height: 100,
      borderColor: module992.colors.white,
      borderWidth: 1,
      borderRadius: 4,
      alignSelf: 'center',
      position: 'relative',
    },
    innerBox: {
      borderColor: module992.colors.green,
      borderWidth: 1,
      borderRadius: 4,
      position: 'absolute',
      top: 20,
      left: 20,
      bottom: 40,
      right: 0,
    },
    tip: {
      width: module992.layout.paddedWidth,
      padding: 16,
    },
    title: {
      fontSize: 24,
      marginBottom: 8,
      color: module992.colors.mainText,
    },
  }),
  D = {
    max: 40,
    min: 0,
    step: 10,
    editable: false,
    textColor: module992.colors.white,
    fontSize: 20,
    buttonStyle: E.buttons,
    accelerationDelay: 350,
  };

exports.default = function (t) {
  var o = t.navigation,
    v = regeneratorRuntime.default(),
    O = v.getData,
    w = v.saveData,
    x = regeneratorRuntime.default().sendData,
    P = React.useState({}),
    C = module15.default(P, 2),
    S = C[0],
    _ = C[1],
    z = React.useState(false),
    B = module15.default(z, 2),
    V = B[0],
    W = B[1];
  React.useEffect(function () {
    O().then(function (t) {
      return _(t.cDz);
    });
  }, []);
  return React.default.createElement(
    React.default.Fragment,
    null,
    V && React.default.createElement(module1104.default, null),
    React.default.createElement(
      ReactNative.View,
      {
        style: [module992.default.mainPadded, module992.default.alignCenter, E.mainBg],
      },
      React.default.createElement(
        module1293.default,
        module14.default({}, D, {
          value: S.t,
          onChange: function (t) {
            return _(function (n) {
              return j(
                j({}, n),
                {},
                {
                  t: t,
                }
              );
            });
          },
          style: E.horizontal,
        })
      ),
      React.default.createElement(
        ReactNative.View,
        {
          style: E.content,
        },
        React.default.createElement(
          module1293.default,
          module14.default({}, D, {
            vertical: true,
            max: 120,
            value: S.l,
            onChange: function (t) {
              return _(function (n) {
                return j(
                  j({}, n),
                  {},
                  {
                    l: t,
                  }
                );
              });
            },
            style: E.vertical,
          })
        ),
        React.default.createElement(
          ReactNative.View,
          {
            style: E.outerBox,
          },
          React.default.createElement(ReactNative.View, {
            style: [
              E.innerBox,
              {
                top: S.t / 2 || 0,
                left: S.l / 4 || 0,
                bottom: S.b / 2 || 0,
                right: S.r / 4 || 0,
              },
            ],
          })
        ),
        React.default.createElement(
          module1293.default,
          module14.default({}, D, {
            vertical: true,
            max: 120,
            value: S.r,
            onChange: function (t) {
              return _(function (n) {
                return j(
                  j({}, n),
                  {},
                  {
                    r: t,
                  }
                );
              });
            },
            style: E.vertical,
          })
        )
      ),
      React.default.createElement(
        module1293.default,
        module14.default({}, D, {
          value: S.b,
          onChange: function (t) {
            return _(function (n) {
              return j(
                j({}, n),
                {},
                {
                  b: t,
                }
              );
            });
          },
          style: E.horizontal,
        })
      )
    ),
    React.default.createElement(
      ReactNative.View,
      {
        style: E.tip,
      },
      React.default.createElement(
        ReactNative.Text,
        {
          style: E.title,
        },
        'Instru\xe7\xf5es'
      ),
      React.default.createElement(
        ReactNative.Text,
        {
          style: {
            color: module992.colors.mainText,
          },
        },
        '- Utilize os controles acima para alterar o recuo de cada lado da tela.',
        '\n',
        '- Valores diferentes no mesmo eixo podem ser usados para deslocar a \xe1rea vis\xedvel e corrigir problemas de alinhamento f\xedsico.'
      )
    ),
    React.default.createElement(module1277.default, {
      onSave: function () {
        t = {
          cDz: S,
        };
        W(true);
        w(t);
        return void x({
          action: 'calibrateDz',
          data: t,
        })
          .then(function () {
            return o.navigate('Dashboard');
          })
          .catch(function () {
            return W(false);
          });
        var t;
      },
    })
  );
};
