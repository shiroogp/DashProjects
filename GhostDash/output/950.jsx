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
  module924 = require('./924'),
  module901 = require('./901'),
  module788 = require('./788'),
  module798 = require('./798'),
  T = '/Users/trensik/dev/react-native-paper/src/components/Searchbar.tsx';

function j(t, o) {
  var l = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var n = Object.getOwnPropertySymbols(t);
    if (o)
      n = n.filter(function (o) {
        return Object.getOwnPropertyDescriptor(t, o).enumerable;
      });
    l.push.apply(l, n);
  }

  return l;
}

function L(t) {
  for (var o = 1; o < arguments.length; o++) {
    var l = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      j(Object(l), true).forEach(function (o) {
        module50.default(t, o, l[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(l));
    else
      j(Object(l)).forEach(function (o) {
        Object.defineProperty(t, o, Object.getOwnPropertyDescriptor(l, o));
      });
  }

  return t;
}

var k = (function (t, ...args) {
  function o() {
    var t, module14;
    module27.default(this, o);
    module14 = module40.default(this, (t = module37.default(o)).call.apply(t, [this].concat(args)));
    module50.default(module42.default(module14), 'handleClearPress', function () {
      module14.clear();
      if (module14.props.onChangeText) module14.props.onChangeText('');
    });
    module50.default(module42.default(module14), 'root', undefined);
    return module14;
  }

  module38.default(o, t);
  module28.default(o, [
    {
      key: 'setNativeProps',
      value: function (t) {
        return this.root && this.root.setNativeProps(t);
      },
    },
    {
      key: 'isFocused',
      value: function () {
        return this.root && this.root.isFocused();
      },
    },
    {
      key: 'clear',
      value: function () {
        return this.root && this.root.clear();
      },
    },
    {
      key: 'focus',
      value: function () {
        return this.root && this.root.focus();
      },
    },
    {
      key: 'blur',
      value: function () {
        return this.root && this.root.blur();
      },
    },
    {
      key: 'render',
      value: function () {
        var t = this,
          o = this.props,
          c = o.clearAccessibilityLabel,
          s = o.clearIcon,
          u = o.icon,
          f = o.iconColor,
          b = o.inputStyle,
          p = o.onIconPress,
          y = o.placeholder,
          C = o.searchAccessibilityLabel,
          j = o.style,
          k = o.theme,
          w = o.value,
          x = module56.default(o, [
            'clearAccessibilityLabel',
            'clearIcon',
            'icon',
            'iconColor',
            'inputStyle',
            'onIconPress',
            'placeholder',
            'searchAccessibilityLabel',
            'style',
            'theme',
            'value',
          ]),
          I = k.colors,
          S = k.roundness,
          E = k.dark,
          R = k.fonts,
          z = I.text,
          D = R.regular,
          M = f || (E ? z : module760.default(z).alpha(0.54).rgb().string()),
          F = module760.default(z).alpha(0.32).rgb().string();
        return (
          <module901.default
            style={[
              {
                borderRadius: S,
                elevation: 4,
              },
              A.container,
              j,
            ]}
            __source={{
              fileName: T,
              lineNumber: 178,
            }}
          >
            <module924.default
              accessibilityTraits="button"
              accessibilityComponentType="button"
              accessibilityRole="button"
              borderless
              rippleColor={F}
              onPress={p}
              color={M}
              icon={
                u ||
                function (t) {
                  var o = t.size,
                    l = t.color;
                  return (
                    <module798.default
                      name="magnify"
                      color={l}
                      size={o}
                      direction={ReactNative.I18nManager.isRTL ? 'rtl' : 'ltr'}
                      __source={{
                        fileName: T,
                        lineNumber: 196,
                      }}
                    />
                  );
                }
              }
              accessibilityLabel={C}
              __source={{
                fileName: T,
                lineNumber: 185,
              }}
            />
            <ReactNative.TextInput />
            <module924.default
              borderless
              disabled={!w}
              accessibilityLabel={c}
              color={w ? M : 'rgba(255, 255, 255, 0)'}
              rippleColor={F}
              onPress={this.handleClearPress}
              icon={
                s ||
                function (t) {
                  var o = t.size,
                    l = t.color;
                  return (
                    <module798.default
                      name="close"
                      color={l}
                      size={o}
                      direction={ReactNative.I18nManager.isRTL ? 'rtl' : 'ltr'}
                      __source={{
                        fileName: T,
                        lineNumber: 232,
                      }}
                    />
                  );
                }
              }
              accessibilityTraits="button"
              accessibilityComponentType="button"
              accessibilityRole="button"
              __source={{
                fileName: T,
                lineNumber: 222,
              }}
            />
          </module901.default>
        );
      },
    },
  ]);
  return o;
})(React.Component);

module50.default(k, 'defaultProps', {
  searchAccessibilityLabel: 'search',
  clearAccessibilityLabel: 'clear',
});
var A = ReactNative.StyleSheet.create({
    container: {
      flexDirection: 'row',
      alignItems: 'center',
    },
    input: {
      flex: 1,
      fontSize: 18,
      paddingLeft: 8,
      alignSelf: 'stretch',
      textAlign: ReactNative.I18nManager.isRTL ? 'right' : 'left',
      minWidth: 0,
    },
  }),
  w = module788.withTheme(k);
exports.default = w;
