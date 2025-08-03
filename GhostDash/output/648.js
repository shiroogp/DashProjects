var module50 = require('./50'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = U(n);
    if (o && o.has(t)) return o.get(t);
    var c = {
        __proto__: null,
      },
      l = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var u in t)
      if ('default' !== u && Object.prototype.hasOwnProperty.call(t, u)) {
        var s = l ? Object.getOwnPropertyDescriptor(t, u) : null;
        if (s && (s.get || s.set)) Object.defineProperty(c, u, s);
        else c[u] = t[u];
      }

    c.default = t;
    if (o) o.set(t, c);
    return c;
  })(require('react')),
  c = React,
  module649 = require('./649'),
  module718 = require('./718'),
  module782 = require('./782'),
  module799 = require('./799'),
  ReactNative = require('react-native'),
  module734 = require('./734'),
  module972 = require('./972'),
  module992 = require('./992'),
  regeneratorRuntime = require('regenerator-runtime'),
  regeneratorRuntime = require('regenerator-runtime'),
  regeneratorRuntime = require('regenerator-runtime'),
  regeneratorRuntime = require('regenerator-runtime'),
  module1185 = require('./1185'),
  regeneratorRuntime = require('regenerator-runtime'),
  module1198 = require('./1198'),
  regeneratorRuntime = require('regenerator-runtime'),
  regeneratorRuntime = require('regenerator-runtime'),
  regeneratorRuntime = require('regenerator-runtime'),
  regeneratorRuntime = require('regenerator-runtime'),
  module1205 = require('./1205'),
  module1280 = require('./1280'),
  module1281 = require('./1281'),
  regeneratorRuntime = require('regenerator-runtime'),
  module1283 = require('./1283'),
  module1291 = require('./1291'),
  module1292 = require('./1292'),
  module1303 = require('./1303'),
  regeneratorRuntime = require('regenerator-runtime'),
  module1312 = require('./1312'),
  module1313 = require('./1313'),
  regeneratorRuntime = require('regenerator-runtime'),
  regeneratorRuntime = require('regenerator-runtime'),
  module1346 = require('./1346'),
  regeneratorRuntime = require('regenerator-runtime');

function U(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (U = function (t) {
    return t ? o : n;
  })(t);
}

function q(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var c = Object.getOwnPropertySymbols(t);
    if (n)
      c = c.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, c);
  }

  return o;
}

function H(t) {
  for (var o = 1; o < arguments.length; o++) {
    var c = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      q(Object(c), true).forEach(function (o) {
        module50.default(t, o, c[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(c));
    else
      q(Object(c)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(c, n));
      });
  }

  return t;
}

module734.enableScreens();
ReactNative.LogBox.ignoreLogs(['It appears']);

var J = module718.createStackNavigator(),
  K = module782.createMaterialBottomTabNavigator(),
  X = H(
    H({}, module649.DarkTheme),
    {},
    {
      dark: true,
      colors: H(
        H({}, module649.DarkTheme.colors),
        {},
        {
          primary: module992.colors.interactionColor,
          background: module992.colors.screenBackground,
          text: module992.colors.mainText,
          card: module992.colors.screenBackground,
        }
      ),
    }
  ),
  Y = function (t, n) {
    return c.createElement(module799.default, {
      name: n,
      color: t,
      size: 26,
    });
  };

function Z() {
  var t = 'android' === ReactNative.Platform.OS;
  return c.createElement(
    ReactNative.View,
    {
      style: {
        flex: 1,
        paddingBottom: t ? 0 : 32,
      },
    },
    c.createElement(
      K.Navigator,
      {
        initialRouteName: 'Dashboard',
        shifting: true,
        barStyle: module992.defaultScreenOptions.barStyle,
        tabBarOptions: module992.tabBarOptions,
        screenOptions: module992.defaultTabScreenOptions,
        activeColor: module992.colors.mainText,
        inactiveColor: module992.colors.inactive,
      },
      c.createElement(K.Screen, {
        name: 'Dashboard',
        component: regeneratorRuntime.default,
        options: {
          tabBarIcon: function (t) {
            var n = t.color;
            return Y(n, 'gauge');
          },
        },
      }),
      c.createElement(K.Screen, {
        name: 'Performance',
        component: module1198.default,
        options: {
          tabBarIcon: function (t) {
            var n = t.color;
            return Y(n, 'fire');
          },
        },
      }),
      c.createElement(K.Screen, {
        name: 'Configura\xe7\xf5es',
        component: regeneratorRuntime.default,
        options: {
          tabBarIcon: function (t) {
            var n = t.color;
            return Y(n, 'settings');
          },
        },
      })
    )
  );
}

exports.default = function () {
  var t = regeneratorRuntime.default(),
    n = t.getBtStatus,
    u = t.startBtModule,
    s = t.setupBtListeners,
    f = t.removeBtListeners,
    S = React.useRef(null);
  React.useEffect(function () {
    regeneratorRuntime.default(u);
  }, []);
  React.useEffect(
    function () {
      s(S);
      return function () {
        f();
      };
    },
    [n]
  );
  return c.createElement(
    module649.NavigationContainer,
    {
      theme: X,
      ref: S,
    },
    c.createElement(ReactNative.StatusBar, {
      barStyle: 'light-content',
      backgroundColor: module992.colors.opacityBlack,
      translucent: true,
    }),
    c.createElement(
      J.Navigator,
      {
        initialRouteName: 'LaunchScreen',
        screenOptions: module992.defaultScreenOptions,
      },
      c.createElement(J.Screen, {
        name: 'LaunchScreen',
        component: regeneratorRuntime.default,
        options: {
          headerShown: false,
          cardStyle: module992.defaultScreenOptions.cardStyle,
        },
      }),
      c.createElement(J.Screen, {
        name: 'QRCodeScreen',
        component: module1185.default,
        options: {
          headerShown: false,
        },
      }),
      c.createElement(J.Screen, {
        name: 'FirstPairScreen',
        component: module1346.default,
        options: {
          headerShown: true,
          title: 'Escolha como parear',
        },
      }),
      c.createElement(J.Screen, {
        name: 'Dashboard',
        component: Z,
        options: function (t) {
          var n = t.route;
          return {
            cardStyle: module992.defaultScreenOptions.cardStyle,
            title: n.state ? n.state.routeNames[n.state.index] : n.name,
            headerShown: false,
          };
        },
      }),
      c.createElement(J.Screen, {
        name: 'ThemesManager',
        component: regeneratorRuntime.default,
        options: {
          headerShown: true,
          title: 'Skins, cores e man\xf4metros',
        },
      }),
      c.createElement(J.Screen, {
        name: 'ChangeColors',
        component: regeneratorRuntime.default,
        options: {
          headerShown: true,
          title: 'Alterar cores',
        },
      }),
      c.createElement(J.Screen, {
        name: 'ColorPicker',
        component: module1283.default,
        options: {
          headerShown: true,
          title: 'Selecione a nova cor',
        },
      }),
      c.createElement(J.Screen, {
        name: 'ChangeThemeVariant',
        component: regeneratorRuntime.default,
        options: {
          headerShown: true,
          title: 'Alterar layout',
        },
      }),
      c.createElement(J.Screen, {
        name: 'DashAddScreen',
        component: regeneratorRuntime.default,
        options: {
          headerShown: false,
        },
      }),
      c.createElement(J.Screen, {
        name: 'BTActionScreen',
        component: regeneratorRuntime.default,
        options: {
          headerShown: false,
        },
      }),
      c.createElement(J.Screen, {
        name: 'DisplayConfig',
        component: module1205.default,
        options: {
          headerShown: true,
          title: 'Configura\xe7\u014des de exibi\xe7\xe3o',
        },
      }),
      c.createElement(J.Screen, {
        name: 'BehaviorConfig',
        component: module1280.default,
        options: {
          headerShown: true,
          title: 'Configura\xe7\u014des de comportamento',
        },
      }),
      c.createElement(J.Screen, {
        name: 'FunctionsConfig',
        component: module1281.default,
        options: {
          headerShown: true,
          title: 'Configura\xe7\u014des de funcionamento',
        },
      }),
      c.createElement(J.Screen, {
        name: 'CalibrationConfig',
        component: module1291.default,
        options: {
          headerShown: true,
          title: 'Calibrar sensores',
        },
      }),
      c.createElement(J.Screen, {
        name: 'DeadzoneCalibration',
        component: module1292.default,
        options: {
          headerShown: true,
          title: 'Ajustar \xe1rea \xfatil',
        },
      }),
      c.createElement(J.Screen, {
        name: 'SpeedCalibration',
        component: module1303.default,
        options: {
          headerShown: true,
          title: 'Calibrar VSS',
        },
      }),
      c.createElement(J.Screen, {
        name: 'FuelCalibration',
        component: module1312.default,
        options: {
          headerShown: true,
          title: 'Calibrar n\xedvel de combust\xedvel',
        },
      }),
      c.createElement(J.Screen, {
        name: 'ServerUpdate',
        component: regeneratorRuntime.default,
        options: {
          headerShown: true,
          title: 'Atualiza\xe7\xe3o de software',
        },
      }),
      c.createElement(J.Screen, {
        name: 'GetServerLogs',
        component: regeneratorRuntime.default,
        options: {
          headerShown: true,
          title: 'Atualiza\xe7\xe3o de software',
        },
      }),
      c.createElement(J.Screen, {
        name: 'SelectGaugesScreen',
        component: module1313.default,
        options: {
          headerShown: true,
          title: 'Selecione os indicadores',
        },
      }),
      c.createElement(J.Screen, {
        name: 'SelectMediaScreen',
        component: regeneratorRuntime.default,
        options: {
          headerShown: true,
          title: 'Selecionar m\xeddia',
        },
      }),
      c.createElement(J.Screen, {
        name: 'SendMediaScreen',
        component: regeneratorRuntime.default,
        options: {
          headerShown: true,
          title: 'Salvando m\xeddia',
        },
      }),
      c.createElement(J.Screen, {
        name: 'SetIntroTextScreen',
        component: regeneratorRuntime.default,
        options: {
          headerShown: true,
          title: 'Definir texto',
        },
      })
    ),
    c.createElement(module972.default, {
      ref: function (t) {
        return module972.default.setRef(t);
      },
      visibilityTime: 6e3,
      position: 'top',
      topOffset: 80,
    })
  );
};
