var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module42 = require('./42'),
  module38 = require('./38'),
  module50 = require('./50'),
  module760 = require('./760'),
  React = require('react'),
  ReactNative = require('react-native'),
  module899 = require('./899'),
  module934 = require('./934'),
  module901 = require('./901'),
  module925 = require('./925'),
  module885 = require('./885'),
  module888 = require('./888'),
  module787 = require('./787'),
  module788 = require('./788'),
  C = '/Users/trensik/dev/react-native-paper/src/components/FAB/FAB.tsx';

function S(t, l) {
  var n = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var s = Object.getOwnPropertySymbols(t);
    if (l)
      s = s.filter(function (l) {
        return Object.getOwnPropertyDescriptor(t, l).enumerable;
      });
    n.push.apply(n, s);
  }

  return n;
}

function A(t) {
  for (var l = 1; l < arguments.length; l++) {
    var n = null != arguments[l] ? arguments[l] : {};
    if (l % 2)
      S(Object(n), true).forEach(function (l) {
        module50.default(t, l, n[l]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(n));
    else
      S(Object(n)).forEach(function (l) {
        Object.defineProperty(t, l, Object.getOwnPropertyDescriptor(n, l));
      });
  }

  return t;
}

var x = (function (t, ...args) {
  function l() {
    var t, module14;
    module27.default(this, l);
    module14 = module40.default(this, (t = module37.default(l)).call.apply(t, [this].concat(args)));
    module50.default(module42.default(module14), 'state', {
      visibility: new ReactNative.Animated.Value(module14.props.visible ? 1 : 0),
    });
    return module14;
  }

  module38.default(l, t);
  module28.default(l, [
    {
      key: 'componentDidUpdate',
      value: function (t) {
        var l = this.props.theme.animation.scale;
        if (this.props.visible !== t.visible)
          this.props.visible
            ? ReactNative.Animated.timing(this.state.visibility, {
                toValue: 1,
                duration: 200 * l,
                useNativeDriver: true,
              }).start()
            : ReactNative.Animated.timing(this.state.visibility, {
                toValue: 0,
                duration: 150 * l,
                useNativeDriver: true,
              }).start();
      },
    },
    {
      key: 'render',
      value: function () {
        var t,
          l = this.props,
          o = l.small,
          c = l.icon,
          u = l.label,
          b = l.accessibilityLabel,
          f = undefined === b ? u : b,
          p = l.color,
          v = l.disabled,
          _ = l.onPress,
          E = l.theme,
          S = l.style,
          x = l.visible,
          I = l.loading,
          L = l.testID,
          V = module56.default(l, ['small', 'icon', 'label', 'accessibilityLabel', 'color', 'disabled', 'onPress', 'theme', 'style', 'visible', 'loading', 'testID']),
          R = this.state.visibility,
          T = module760
            .default(E.dark ? module787.white : module787.black)
            .alpha(0.12)
            .rgb()
            .string(),
          U = (ReactNative.StyleSheet.flatten(S) || {}).backgroundColor,
          B = undefined === U ? (v ? T : E.colors.accent) : U;
        t =
          undefined !== p
            ? p
            : v
            ? module760
                .default(E.dark ? module787.white : module787.black)
                .alpha(0.32)
                .rgb()
                .string()
            : module760.default(B).isLight()
            ? 'rgba(0, 0, 0, .54)'
            : module787.white;
        var F = module760.default(t).alpha(0.32).rgb().string();
        return (
          <module901.default>
            <module888.default
              borderless
              onPress={_}
              rippleColor={F}
              disabled={v}
              accessibilityLabel={f}
              accessibilityTraits={v ? ['button', 'disabled'] : 'button'}
              accessibilityComponentType="button"
              accessibilityRole="button"
              accessibilityStates={v ? ['disabled'] : []}
              style={z.touchable}
              testID={L}
              __source={{
                fileName: C,
                lineNumber: 201,
              }}
            >
              <ReactNative.View
                style={[z.content, u ? z.extended : o ? z.small : z.standard]}
                pointerEvents="none"
                __source={{
                  fileName: C,
                  lineNumber: 214,
                }}
              >
                {c && true !== I ? (
                  <module925.default
                    source={c}
                    size={24}
                    color={t}
                    __source={{
                      fileName: C,
                      lineNumber: 222,
                    }}
                  />
                ) : null}
                {I ? (
                  <module899.default
                    size={18}
                    color={t}
                    __source={{
                      fileName: C,
                      lineNumber: 225,
                    }}
                  />
                ) : null}
                {u
                  ? React.createElement(
                      module885.default,
                      {
                        style: [
                          z.label,
                          A(
                            {
                              color: t,
                            },
                            E.fonts.medium
                          ),
                        ],
                        __source: {
                          fileName: C,
                          lineNumber: 228,
                        },
                      },
                      u.toUpperCase()
                    )
                  : null}
              </ReactNative.View>
            </module888.default>
          </module901.default>
        );
      },
    },
  ]);
  return l;
})(React.Component);

module50.default(x, 'Group', module934.default);
module50.default(x, 'defaultProps', {
  visible: true,
});
var z = ReactNative.StyleSheet.create({
    container: {
      borderRadius: 28,
      elevation: 6,
    },
    touchable: {
      borderRadius: 28,
    },
    standard: {
      height: 56,
      width: 56,
    },
    small: {
      height: 40,
      width: 40,
    },
    extended: {
      height: 48,
      paddingHorizontal: 16,
    },
    content: {
      flexDirection: 'row',
      alignItems: 'center',
      justifyContent: 'center',
    },
    label: {
      marginHorizontal: 8,
    },
    disabled: {
      elevation: 0,
    },
  }),
  I = module788.withTheme(x);
exports.default = I;
