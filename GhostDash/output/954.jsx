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
  module885 = require('./885'),
  module788 = require('./788'),
  module787 = require('./787'),
  j = '/Users/trensik/dev/react-native-paper/src/components/Appbar/AppbarContent.tsx';

function _(t, l) {
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

function w(t) {
  for (var l = 1; l < arguments.length; l++) {
    var n = null != arguments[l] ? arguments[l] : {};
    if (l % 2)
      _(Object(n), true).forEach(function (l) {
        module50.default(t, l, n[l]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(n));
    else
      _(Object(n)).forEach(function (l) {
        Object.defineProperty(t, l, Object.getOwnPropertyDescriptor(n, l));
      });
  }

  return t;
}

var N = (function (t) {
  function l() {
    module27.default(this, l);
    return module40.default(this, module37.default(l).apply(this, arguments));
  }

  module38.default(l, t);
  module28.default(l, [
    {
      key: 'render',
      value: function () {
        var t = this.props,
          l = t.color,
          s = undefined === l ? module787.white : l,
          u = t.subtitle,
          c = t.subtitleStyle,
          f = t.onPress,
          b = t.style,
          p = t.titleRef,
          v = t.titleStyle,
          _ = t.theme,
          N = t.title,
          A = module56.default(t, ['color', 'subtitle', 'subtitleStyle', 'onPress', 'style', 'titleRef', 'titleStyle', 'theme', 'title']),
          C = _.fonts,
          k = module760.default(s).alpha(0.7).rgb().string();
        return (
          <ReactNative.TouchableWithoutFeedback
            onPress={f}
            disabled={!f}
            __source={{
              fileName: j,
              lineNumber: 83,
            }}
          >
            <ReactNative.View>
              <module885.default
                ref={p}
                style={[
                  w(
                    {
                      color: s,
                    },
                    'ios' === ReactNative.Platform.OS ? C.regular : C.medium
                  ),
                  E.title,
                  v,
                ]}
                numberOfLines={1}
                accessible
                accessibilityTraits="header"
                accessibilityRole={'web' === ReactNative.Platform.OS ? 'heading' : 'header'}
                __source={{
                  fileName: j,
                  lineNumber: 85,
                }}
              >
                {N}
              </module885.default>
              {u ? (
                <module885.default
                  style={[
                    E.subtitle,
                    {
                      color: k,
                    },
                    c,
                  ]}
                  numberOfLines={1}
                  __source={{
                    fileName: j,
                    lineNumber: 104,
                  }}
                >
                  {u}
                </module885.default>
              ) : null}
            </ReactNative.View>
          </ReactNative.TouchableWithoutFeedback>
        );
      },
    },
  ]);
  return l;
})(React.Component);

exports.AppbarContent = N;
module50.default(N, 'displayName', 'Appbar.Content');
var E = ReactNative.StyleSheet.create({
    container: {
      flex: 1,
      paddingHorizontal: 12,
    },
    title: {
      fontSize: 'ios' === ReactNative.Platform.OS ? 17 : 20,
    },
    subtitle: {
      fontSize: 'ios' === ReactNative.Platform.OS ? 11 : 14,
    },
  }),
  A = module788.withTheme(N);
exports.default = A;
