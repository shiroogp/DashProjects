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
  module882 = require('./882'),
  module888 = require('./888'),
  module788 = require('./788'),
  j = '/Users/trensik/dev/react-native-paper/src/components/Drawer/DrawerItem.tsx';

function N(t, n) {
  var l = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var s = Object.getOwnPropertySymbols(t);
    if (n)
      s = s.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    l.push.apply(l, s);
  }

  return l;
}

function D(t) {
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

var E = (function (t) {
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
          n = t.icon,
          o = t.label,
          c = t.active,
          u = t.theme,
          b = t.style,
          f = t.onPress,
          p = t.accessibilityLabel,
          P = module56.default(t, ['icon', 'label', 'active', 'theme', 'style', 'onPress', 'accessibilityLabel']),
          N = u.colors,
          E = u.roundness,
          S = c ? module760.default(N.primary).alpha(0.12).rgb().string() : 'transparent',
          k = c ? N.primary : module760.default(N.text).alpha(0.68).rgb().string(),
          I = u.fonts.medium,
          R = n ? 32 : 0;
        return (
          <ReactNative.View>
            <module888.default
              borderless
              delayPressIn={0}
              onPress={f}
              style={{
                borderRadius: E,
              }}
              accessibilityTraits={c ? ['button', 'selected'] : 'button'}
              accessibilityComponentType="button"
              accessibilityRole="button"
              accessibilityStates={c ? ['selected'] : []}
              accessibilityLabel={p}
              __source={{
                fileName: j,
                lineNumber: 92,
              }}
            >
              <ReactNative.View
                style={L.wrapper}
                __source={{
                  fileName: j,
                  lineNumber: 103,
                }}
              >
                {n ? (
                  <module882.default
                    source={n}
                    size={24}
                    color={k}
                    __source={{
                      fileName: j,
                      lineNumber: 105,
                    }}
                  />
                ) : null}
                <module885.default
                  numberOfLines={1}
                  style={[
                    L.label,
                    D(
                      {
                        color: k,
                      },
                      I,
                      {
                        marginLeft: R,
                      }
                    ),
                  ]}
                  __source={{
                    fileName: j,
                    lineNumber: 107,
                  }}
                >
                  {o}
                </module885.default>
              </ReactNative.View>
            </module888.default>
          </ReactNative.View>
        );
      },
    },
  ]);
  return n;
})(React.Component);

module50.default(E, 'displayName', 'Drawer.Item');
var L = ReactNative.StyleSheet.create({
    container: {
      marginHorizontal: 10,
      marginVertical: 4,
    },
    wrapper: {
      flexDirection: 'row',
      alignItems: 'center',
      padding: 8,
    },
    label: {
      marginRight: 32,
    },
  }),
  S = module788.withTheme(E);
exports.default = S;
