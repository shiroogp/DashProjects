var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module42 = require('./42'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module760 = require('./760'),
  module899 = require('./899'),
  module882 = require('./882'),
  module901 = require('./901'),
  module885 = require('./885'),
  module888 = require('./888'),
  module787 = require('./787'),
  module788 = require('./788'),
  D = '/Users/trensik/dev/react-native-paper/src/components/Button.tsx';

function L(t, n) {
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

function E(t) {
  for (var n = 1; n < arguments.length; n++) {
    var l = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      L(Object(l), true).forEach(function (n) {
        module50.default(t, n, l[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(l));
    else
      L(Object(l)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(l, n));
      });
  }

  return t;
}

var I = (function (t, ...args) {
  function n() {
    var t, module14;
    module27.default(this, n);
    module14 = module40.default(this, (t = module37.default(n)).call.apply(t, [this].concat(args)));
    module50.default(module42.default(module14), 'state', {
      elevation: new ReactNative.Animated.Value('contained' === module14.props.mode ? 2 : 0),
    });
    module50.default(module42.default(module14), 'handlePressIn', function () {
      if ('contained' === module14.props.mode) {
        var t = module14.props.theme.animation.scale;
        ReactNative.Animated.timing(module14.state.elevation, {
          toValue: 8,
          duration: 200 * t,
          useNativeDriver: false,
        }).start();
      }
    });
    module50.default(module42.default(module14), 'handlePressOut', function () {
      if ('contained' === module14.props.mode) {
        var t = module14.props.theme.animation.scale;
        ReactNative.Animated.timing(module14.state.elevation, {
          toValue: 2,
          duration: 150 * t,
          useNativeDriver: false,
        }).start();
      }
    });
    return module14;
  }

  module38.default(n, t);
  module28.default(n, [
    {
      key: 'render',
      value: function () {
        var t,
          n,
          s,
          c,
          u = this.props,
          b = u.disabled,
          p = u.compact,
          f = u.mode,
          y = u.dark,
          k = u.loading,
          L = u.icon,
          I = u.color,
          V = u.children,
          x = u.uppercase,
          A = u.accessibilityLabel,
          R = u.onPress,
          z = u.style,
          T = u.theme,
          W = u.contentStyle,
          H = u.labelStyle,
          B = u.testID,
          M = module56.default(u, [
            'disabled',
            'compact',
            'mode',
            'dark',
            'loading',
            'icon',
            'color',
            'children',
            'uppercase',
            'accessibilityLabel',
            'onPress',
            'style',
            'theme',
            'contentStyle',
            'labelStyle',
            'testID',
          ]),
          U = T.colors,
          q = T.roundness,
          F = T.fonts.medium;
        if (
          ((t =
            'contained' === f
              ? b
                ? module760
                    .default(T.dark ? module787.white : module787.black)
                    .alpha(0.12)
                    .rgb()
                    .string()
                : I || U.primary
              : 'transparent'),
          'outlined' === f
            ? ((n = module760
                .default(T.dark ? module787.white : module787.black)
                .alpha(0.29)
                .rgb()
                .string()),
              (c = ReactNative.StyleSheet.hairlineWidth))
            : ((n = 'transparent'), (c = 0)),
          b)
        )
          s = module760
            .default(T.dark ? module787.white : module787.black)
            .alpha(0.32)
            .rgb()
            .string();
        else if ('contained' === f) {
          s = ('boolean' == typeof y ? y : 'transparent' !== t && !module760.default(t).isLight()) ? module787.white : module787.black;
        } else s = I || U.primary;
        var G = module760.default(s).alpha(0.32).rgb().string(),
          J = {
            backgroundColor: t,
            borderColor: n,
            borderWidth: c,
            borderRadius: q,
          },
          K = {
            borderRadius: (z && ReactNative.StyleSheet.flatten(z).borderRadius) || q,
          },
          Q = E(
            {
              color: s,
            },
            F
          ),
          X = b || 'contained' !== f ? 0 : this.state.elevation;
        return (
          <module901.default>
            <module888.default
              borderless
              delayPressIn={0}
              onPress={R}
              onPressIn={this.handlePressIn}
              onPressOut={this.handlePressOut}
              accessibilityLabel={A}
              accessibilityTraits={b ? ['button', 'disabled'] : 'button'}
              accessibilityComponentType="button"
              accessibilityRole="button"
              accessibilityStates={b ? ['disabled'] : []}
              disabled={b}
              rippleColor={G}
              style={K}
              testID={B}
              __source={{
                fileName: D,
                lineNumber: 263,
              }}
            >
              <ReactNative.View
                style={[C.content, W]}
                __source={{
                  fileName: D,
                  lineNumber: 279,
                }}
              >
                {L && true !== k ? (
                  <ReactNative.View
                    style={C.icon}
                    __source={{
                      fileName: D,
                      lineNumber: 281,
                    }}
                  >
                    <module882.default
                      source={L}
                      size={16}
                      color={s}
                      __source={{
                        fileName: D,
                        lineNumber: 282,
                      }}
                    />
                  </ReactNative.View>
                ) : null}
                {k ? (
                  <module899.default
                    size={16}
                    color={s}
                    style={C.icon}
                    __source={{
                      fileName: D,
                      lineNumber: 286,
                    }}
                  />
                ) : null}
                <module885.default
                  numberOfLines={1}
                  style={[C.label, p && C.compactLabel, x && C.uppercaseLabel, Q, F, H]}
                  __source={{
                    fileName: D,
                    lineNumber: 292,
                  }}
                >
                  {V}
                </module885.default>
              </ReactNative.View>
            </module888.default>
          </module901.default>
        );
      },
    },
  ]);
  return n;
})(React.Component);

module50.default(I, 'defaultProps', {
  mode: 'text',
  uppercase: true,
});
var C = ReactNative.StyleSheet.create({
    button: {
      minWidth: 64,
      borderStyle: 'solid',
    },
    compact: {
      minWidth: 'auto',
    },
    content: {
      flexDirection: 'row',
      alignItems: 'center',
      justifyContent: 'center',
    },
    icon: {
      width: 16,
      marginLeft: 12,
      marginRight: -4,
    },
    label: {
      textAlign: 'center',
      letterSpacing: 1,
      marginVertical: 9,
      marginHorizontal: 16,
    },
    compactLabel: {
      marginHorizontal: 8,
    },
    uppercaseLabel: {
      textTransform: 'uppercase',
    },
  }),
  V = module788.withTheme(I);
exports.default = V;
