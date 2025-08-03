var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  module760 = require('./760'),
  React = require('react'),
  ReactNative = require('react-native'),
  module885 = require('./885'),
  module897 = require('./897'),
  module788 = require('./788'),
  _ = '/Users/trensik/dev/react-native-paper/src/components/Drawer/DrawerSection.tsx';

function N(t, n) {
  var l = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var o = Object.getOwnPropertySymbols(t);
    if (n)
      o = o.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    l.push.apply(l, o);
  }

  return l;
}

function P(t) {
  for (var n = 1; n < arguments.length; n++) {
    var l = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      N(Object(l), true).forEach(function (n) {
        module50.default(t, n, l[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(l));
    else
      N(Object(l)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(l, n));
      });
  }

  return t;
}

var D = (function (t) {
  function n() {
    module27.default(this, n);
    return module40.default(this, module37.default(n).apply(this, arguments));
  }

  module38.default(n, t);
  module28.default(n, [
    {
      key: 'render',
      value: function () {
        var t = this.props,
          n = t.children,
          c = t.title,
          u = t.theme,
          f = t.style,
          s = module56.default(t, ['children', 'title', 'theme', 'style']),
          p = u.colors,
          y = u.fonts,
          w = module760.default(p.text).alpha(0.54).rgb().string(),
          N = y.medium;
        return (
          <ReactNative.View>
            {c && (
              <ReactNative.View
                style={E.titleContainer}
                __source={{
                  fileName: _,
                  lineNumber: 74,
                }}
              >
                <module885.default
                  numberOfLines={1}
                  style={P(
                    {
                      color: w,
                    },
                    N,
                    {
                      marginLeft: 16,
                    }
                  )}
                  __source={{
                    fileName: _,
                    lineNumber: 75,
                  }}
                >
                  {c}
                </module885.default>
              </ReactNative.View>
            )}
            {n}
            <module897.default
              style={E.divider}
              __source={{
                fileName: _,
                lineNumber: 84,
              }}
            />
          </ReactNative.View>
        );
      },
    },
  ]);
  return n;
})(React.Component);

module50.default(D, 'displayName', 'Drawer.Section');
var E = ReactNative.StyleSheet.create({
    container: {
      marginBottom: 4,
    },
    titleContainer: {
      height: 40,
      justifyContent: 'center',
    },
    divider: {
      marginTop: 4,
    },
  }),
  S = module788.withTheme(D);
exports.default = S;
