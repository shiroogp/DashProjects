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
  module882 = require('./882'),
  module901 = require('./901'),
  module885 = require('./885'),
  module888 = require('./888'),
  module788 = require('./788'),
  module787 = require('./787'),
  C = '/Users/trensik/dev/react-native-paper/src/components/Chip.tsx';

function j(t, l) {
  var n = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var o = Object.getOwnPropertySymbols(t);
    if (l)
      o = o.filter(function (l) {
        return Object.getOwnPropertyDescriptor(t, l).enumerable;
      });
    n.push.apply(n, o);
  }

  return n;
}

function k(t) {
  for (var l = 1; l < arguments.length; l++) {
    var n = null != arguments[l] ? arguments[l] : {};
    if (l % 2)
      j(Object(n), true).forEach(function (l) {
        module50.default(t, l, n[l]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(n));
    else
      j(Object(n)).forEach(function (l) {
        Object.defineProperty(t, l, Object.getOwnPropertyDescriptor(n, l));
      });
  }

  return t;
}

var D = (function (t, ...args) {
  function l() {
    var t, module14;
    module27.default(this, l);
    module14 = module40.default(this, (t = module37.default(l)).call.apply(t, [this].concat(args)));
    module50.default(module42.default(module14), 'state', {
      elevation: new ReactNative.Animated.Value(0),
    });
    module50.default(module42.default(module14), 'handlePressIn', function () {
      var t = module14.props.theme.animation.scale;
      ReactNative.Animated.timing(module14.state.elevation, {
        toValue: 4,
        duration: 200 * t,
        useNativeDriver: false,
      }).start();
    });
    module50.default(module42.default(module14), 'handlePressOut', function () {
      var t = module14.props.theme.animation.scale;
      ReactNative.Animated.timing(module14.state.elevation, {
        toValue: 0,
        duration: 150 * t,
        useNativeDriver: false,
      }).start();
    });
    return module14;
  }

  module38.default(l, t);
  module28.default(l, [
    {
      key: 'render',
      value: function () {
        var t = this.props,
          l = t.mode,
          s = t.children,
          c = t.icon,
          u = t.avatar,
          b = t.selected,
          f = t.disabled,
          p = t.accessibilityLabel,
          h = t.onPress,
          S = t.onLongPress,
          j = t.onClose,
          D = t.textStyle,
          x = t.style,
          I = t.theme,
          L = t.testID,
          R = t.selectedColor,
          T = module56.default(t, [
            'mode',
            'children',
            'icon',
            'avatar',
            'selected',
            'disabled',
            'accessibilityLabel',
            'onPress',
            'onLongPress',
            'onClose',
            'textStyle',
            'style',
            'theme',
            'testID',
            'selectedColor',
          ]),
          A = I.dark,
          W = I.colors,
          z = ReactNative.StyleSheet.flatten(x) || {},
          H = z.backgroundColor,
          F = undefined === H ? ('outlined' === l ? W.surface : A ? '#383838' : '#ebebeb') : H,
          M = z.borderRadius,
          U = undefined === M ? 16 : M,
          q =
            'outlined' === l
              ? module760
                  .default(undefined !== R ? R : module760.default(A ? module787.white : module787.black))
                  .alpha(0.29)
                  .rgb()
                  .string()
              : F,
          B = f
            ? W.disabled
            : module760
                .default(undefined !== R ? R : W.text)
                .alpha(0.87)
                .rgb()
                .string(),
          G = f
            ? W.disabled
            : module760
                .default(undefined !== R ? R : W.text)
                .alpha(0.54)
                .rgb()
                .string(),
          J = (A ? module760.default(F).lighten('outlined' === l ? 0.2 : 0.4) : module760.default(F).darken('outlined' === l ? 0.08 : 0.2)).rgb().string(),
          K = R ? module760.default(R).fade(0.5).rgb().string() : J,
          Q = ['button'],
          X = [];

        if (b) {
          Q.push('selected');
          X.push('selected');
        }

        if (f) {
          Q.push('disabled');
          X.push('disabled');
        }

        return (
          <module901.default>
            <module888.default
              borderless
              delayPressIn={0}
              style={{
                borderRadius: U,
              }}
              onPress={h}
              onLongPress={S}
              onPressIn={this.handlePressIn}
              onPressOut={this.handlePressOut}
              underlayColor={K}
              disabled={f}
              accessibilityLabel={p}
              accessibilityTraits={Q}
              accessibilityComponentType="button"
              accessibilityRole="button"
              accessibilityStates={X}
              testID={L}
              __source={{
                fileName: C,
                lineNumber: 242,
              }}
            >
              <ReactNative.View
                style={V.content}
                __source={{
                  fileName: C,
                  lineNumber: 259,
                }}
              >
                {u && !c ? (
                  <ReactNative.View
                    style={[
                      V.avatarWrapper,
                      f && {
                        opacity: 0.26,
                      },
                    ]}
                    __source={{
                      fileName: C,
                      lineNumber: 261,
                    }}
                  >
                    {React.isValidElement(u)
                      ? React.cloneElement(u, {
                          style: [V.avatar, u.props.style],
                        })
                      : u}
                  </ReactNative.View>
                ) : null}
                {c || b ? (
                  <ReactNative.View
                    style={[V.icon, u ? [V.avatar, V.avatarSelected] : null]}
                    __source={{
                      fileName: C,
                      lineNumber: 274,
                    }}
                  >
                    <module882.default
                      source={c || 'check'}
                      color={u ? module787.white : G}
                      size={18}
                      __source={{
                        fileName: C,
                        lineNumber: 280,
                      }}
                    />
                  </ReactNative.View>
                ) : null}
                <module885.default
                  numberOfLines={1}
                  style={[
                    V.text,
                    k({}, I.fonts.regular, {
                      color: B,
                      marginRight: j ? 4 : 8,
                      marginLeft: u || c || b ? 4 : 8,
                    }),
                    D,
                  ]}
                  __source={{
                    fileName: C,
                    lineNumber: 287,
                  }}
                >
                  {s}
                </module885.default>
                {j ? (
                  <ReactNative.TouchableWithoutFeedback
                    onPress={j}
                    accessibilityTraits="button"
                    accessibilityComponentType="button"
                    __source={{
                      fileName: C,
                      lineNumber: 303,
                    }}
                  >
                    <ReactNative.View
                      style={V.icon}
                      __source={{
                        fileName: C,
                        lineNumber: 308,
                      }}
                    >
                      <module882.default
                        source="close-circle"
                        size={16}
                        color={G}
                        __source={{
                          fileName: C,
                          lineNumber: 309,
                        }}
                      />
                    </ReactNative.View>
                  </ReactNative.TouchableWithoutFeedback>
                ) : null}
              </ReactNative.View>
            </module888.default>
          </module901.default>
        );
      },
    },
  ]);
  return l;
})(React.Component);

module50.default(D, 'defaultProps', {
  mode: 'flat',
  disabled: false,
  selected: false,
});
var V = ReactNative.StyleSheet.create({
    container: {
      borderWidth: ReactNative.StyleSheet.hairlineWidth,
      borderStyle: 'solid',
    },
    content: {
      flexDirection: 'row',
      alignItems: 'center',
      paddingHorizontal: 4,
    },
    icon: {
      padding: 4,
    },
    text: {
      minHeight: 24,
      lineHeight: 24,
      textAlignVertical: 'center',
      marginVertical: 4,
    },
    avatar: {
      width: 24,
      height: 24,
      borderRadius: 12,
    },
    avatarWrapper: {
      marginRight: 4,
    },
    avatarSelected: {
      position: 'absolute',
      top: 4,
      left: 4,
      backgroundColor: 'rgba(0, 0, 0, .29)',
    },
  }),
  x = module788.withTheme(D);
exports.default = x;
