var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module760 = require('./760'),
  module954 = require('./954'),
  module955 = require('./955'),
  module956 = require('./956'),
  module958 = require('./958'),
  module901 = require('./901'),
  module788 = require('./788'),
  module787 = require('./787'),
  module879 = require('./879'),
  P = '/Users/trensik/dev/react-native-paper/src/components/Appbar/Appbar.tsx';

exports.DEFAULT_APPBAR_HEIGHT = 56;

var S = (function (t) {
  function l() {
    module27.default(this, l);
    return module40.default(this, module37.default(l).apply(this, arguments));
  }

  module38.default(l, t);
  module28.default(l, [
    {
      key: 'render',
      value: function () {
        var t,
          l = this.props,
          u = l.children,
          f = l.dark,
          c = l.style,
          s = l.theme,
          p = module56.default(l, ['children', 'dark', 'style', 'theme']),
          h = s.colors,
          k = s.dark,
          w = s.mode,
          S = ReactNative.StyleSheet.flatten(c) || {},
          I = S.backgroundColor,
          L = S.elevation,
          V = undefined === L ? 4 : L,
          B = module56.default(S, ['backgroundColor', 'elevation']),
          D = I || (k && 'adaptive' === w ? module879.default(V, h.surface) : h.primary);
        t = 'boolean' == typeof f ? f : 'transparent' !== D && !module760.default(D).isLight();
        var U = false,
          x = false,
          F = false;

        if ('ios' === ReactNative.Platform.OS) {
          var G = false,
            O = 0,
            R = 0;
          React.Children.forEach(u, function (t) {
            if (React.isValidElement(t)) t.type === module954.default ? (G = true) : G ? R++ : O++;
          });
          x = (U = G && O < 2 && R < 2) && 0 === O;
          F = U && 0 === R;
        }

        return (
          <module901.default>
            {x ? (
              <ReactNative.View
                style={T.spacing}
                __source={{
                  fileName: P,
                  lineNumber: 145,
                }}
              />
            ) : null}
            {React.Children.toArray(u)
              .filter(function (t) {
                return null != t && 'boolean' != typeof t;
              })
              .map(function (l, n) {
                if (!React.isValidElement(l) || ![module954.default, module955.default, module956.default].includes(l.type)) return l;
                var o = {
                  color: undefined !== l.props.color ? l.props.color : t ? module787.white : module787.black,
                };
                if (l.type === module954.default)
                  o.style = [
                    0 !== n && {
                      marginLeft: 8,
                    },
                    U && {
                      alignItems: 'center',
                    },
                    l.props.style,
                  ];
                return React.cloneElement(l, o);
              })}
            {F ? (
              <ReactNative.View
                style={T.spacing}
                __source={{
                  fileName: P,
                  lineNumber: 180,
                }}
              />
            ) : null}
          </module901.default>
        );
      },
    },
  ]);
  return l;
})(React.Component);

module50.default(S, 'Content', module954.default);
module50.default(S, 'Action', module955.default);
module50.default(S, 'BackAction', module956.default);
module50.default(S, 'Header', module958.default);
var T = ReactNative.StyleSheet.create({
    appbar: {
      height: 56,
      flexDirection: 'row',
      alignItems: 'center',
      paddingHorizontal: 4,
      elevation: 4,
    },
    spacing: {
      width: 48,
    },
  }),
  I = module788.withTheme(S);
exports.default = I;
