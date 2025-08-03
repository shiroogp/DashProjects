var module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module42 = require('./42'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module760 = require('./760'),
  module787 = require('./787'),
  module788 = require('./788');

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

function P(t) {
  for (var n = 1; n < arguments.length; n++) {
    var o = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      w(Object(o), true).forEach(function (n) {
        module50.default(t, n, o[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      w(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

var k = (function (t, ...args) {
  function n() {
    var t, module56;
    module27.default(this, n);
    module56 = module40.default(this, (t = module37.default(n)).call.apply(t, [this].concat(args)));
    module50.default(module42.default(module56), 'state', {
      opacity: new ReactNative.Animated.Value(module56.props.visible ? 1 : 0),
    });
    return module56;
  }

  module38.default(n, t);
  module28.default(n, [
    {
      key: 'componentDidUpdate',
      value: function (t) {
        var n = this.props,
          o = n.visible,
          l = n.theme.animation.scale;
        if (o !== t.visible)
          ReactNative.Animated.timing(this.state.opacity, {
            toValue: o ? 1 : 0,
            duration: 150 * l,
            useNativeDriver: true,
          }).start();
      },
    },
    {
      key: 'render',
      value: function () {
        var t = this.props,
          n = t.children,
          l = t.size,
          c = undefined === l ? 20 : l,
          s = t.style,
          u = t.theme,
          f = this.state.opacity,
          p = ReactNative.StyleSheet.flatten(s) || {},
          v = p.backgroundColor,
          j = undefined === v ? u.colors.notification : v,
          w = module56.default(p, ['backgroundColor']),
          k = module760.default(j).isLight() ? module787.black : module787.white,
          S = c / 2;
        return React.createElement(
          ReactNative.Animated.Text,
          {
            numberOfLines: 1,
            style: [
              P(
                {
                  opacity: f,
                  backgroundColor: j,
                  color: k,
                  fontSize: 0.5 * c,
                },
                u.fonts.regular,
                {
                  lineHeight: c,
                  height: c,
                  minWidth: c,
                  borderRadius: S,
                }
              ),
              A.container,
              w,
            ],
            __source: {
              fileName: '/Users/trensik/dev/react-native-paper/src/components/Badge.tsx',
              lineNumber: 88,
            },
          },
          n
        );
      },
    },
  ]);
  return n;
})(React.Component);

module50.default(k, 'defaultProps', {
  visible: true,
  size: 20,
});
var S = module788.withTheme(k);
exports.default = S;
var A = ReactNative.StyleSheet.create({
  container: {
    alignSelf: 'flex-end',
    textAlign: 'center',
    textAlignVertical: 'center',
    paddingHorizontal: 4,
    overflow: 'hidden',
  },
});
