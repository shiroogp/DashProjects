var module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module42 = require('./42'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native');

function v(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var u = Object.getOwnPropertySymbols(t);
    if (n)
      u = u.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, u);
  }

  return o;
}

function h(t) {
  for (var n = 1; n < arguments.length; n++) {
    var o = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      v(Object(o), true).forEach(function (n) {
        module50.default(t, n, o[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      v(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

var j = (function (t, ...args) {
  function n() {
    var t, module28;
    module27.default(this, n);
    module28 = module40.default(this, (t = module37.default(n)).call.apply(t, [this].concat(args)));
    module50.default(module42.default(module28), 'state', {
      portals: [],
    });
    module50.default(module42.default(module28), 'mount', function (t, n) {
      module28.setState(function (u) {
        return {
          portals: [].concat(module23.default(u.portals), [
            {
              key: t,
              children: n,
            },
          ]),
        };
      });
    });
    module50.default(module42.default(module28), 'update', function (t, n) {
      return module28.setState(function (o) {
        return {
          portals: o.portals.map(function (o) {
            return o.key === t
              ? h({}, o, {
                  children: n,
                })
              : o;
          }),
        };
      });
    });
    module50.default(module42.default(module28), 'unmount', function (t) {
      return module28.setState(function (n) {
        return {
          portals: n.portals.filter(function (n) {
            return n.key !== t;
          }),
        };
      });
    });
    return module28;
  }

  module38.default(n, t);
  module28.default(n, [
    {
      key: 'render',
      value: function () {
        return this.state.portals.map(function (t) {
          var n = t.key,
            o = t.children;
          return (
            <ReactNative.View
              key={n}
              collapsable={false}
              pointerEvents="box-none"
              style={ReactNative.StyleSheet.absoluteFill}
              __source={{
                fileName: '/Users/trensik/dev/react-native-paper/src/components/Portal/PortalManager.tsx',
                lineNumber: 42,
              }}
            >
              {o}
            </ReactNative.View>
          );
        });
      },
    },
  ]);
  return n;
})(React.PureComponent);

exports.default = j;
