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
  module888 = require('./888'),
  module885 = require('./885'),
  module788 = require('./788'),
  _ = '/Users/trensik/dev/react-native-paper/src/components/List/ListItem.tsx';

function j(t, n) {
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

function M(t) {
  for (var n = 1; n < arguments.length; n++) {
    var l = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      j(Object(l), true).forEach(function (n) {
        module50.default(t, n, l[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(l));
    else
      j(Object(l)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(l, n));
      });
  }

  return t;
}

var P = (function (t) {
  function n() {
    module27.default(this, n);
    return module40.default(this, module37.default(n).apply(this, arguments));
  }

  module38.default(n, t);
  module28.default(n, [
    {
      key: 'renderDescription',
      value: function (t, n) {
        var l = this.props,
          o = l.descriptionEllipsizeMode,
          s = l.descriptionStyle,
          c = l.descriptionNumberOfLines;
        return 'function' == typeof n ? (
          n({
            ellipsizeMode: o,
            color: t,
            fontSize: w.description.fontSize,
          })
        ) : (
          <module885.default
            numberOfLines={c}
            ellipsizeMode={o}
            style={[
              w.description,
              {
                color: t,
              },
              s,
            ]}
            __source={{
              fileName: _,
              lineNumber: 144,
            }}
          >
            {n}
          </module885.default>
        );
      },
    },
    {
      key: 'render',
      value: function () {
        var t = this.props,
          n = t.left,
          s = t.right,
          c = t.title,
          f = t.description,
          u = t.onPress,
          p = t.theme,
          y = t.style,
          L = t.titleStyle,
          j = t.titleNumberOfLines,
          P = t.titleEllipsizeMode,
          S = module56.default(t, ['left', 'right', 'title', 'description', 'onPress', 'theme', 'style', 'titleStyle', 'titleNumberOfLines', 'titleEllipsizeMode']),
          z = module760.default(p.colors.text).alpha(0.87).rgb().string(),
          E = module760.default(p.colors.text).alpha(0.54).rgb().string();
        return (
          <module888.default>
            <ReactNative.View
              style={w.row}
              __source={{
                fileName: _,
                lineNumber: 187,
              }}
            >
              {n
                ? n({
                    color: E,
                    style: f ? w.iconMarginLeft : M({}, w.iconMarginLeft, {}, w.marginVerticalNone),
                  })
                : null}
              <ReactNative.View
                style={[w.item, w.content]}
                __source={{
                  fileName: _,
                  lineNumber: 199,
                }}
              >
                <module885.default
                  ellipsizeMode={P}
                  numberOfLines={j}
                  style={[
                    w.title,
                    {
                      color: z,
                    },
                    L,
                  ]}
                  __source={{
                    fileName: _,
                    lineNumber: 200,
                  }}
                >
                  {c}
                </module885.default>
                {f ? this.renderDescription(E, f) : null}
              </ReactNative.View>
              {s
                ? s({
                    color: E,
                    style: f ? w.iconMarginRight : M({}, w.iconMarginRight, {}, w.marginVerticalNone),
                  })
                : null}
            </ReactNative.View>
          </module888.default>
        );
      },
    },
  ]);
  return n;
})(React.Component);

module50.default(P, 'displayName', 'List.Item');
module50.default(P, 'defaultProps', {
  titleNumberOfLines: 1,
  descriptionNumberOfLines: 2,
});
var w = ReactNative.StyleSheet.create({
    container: {
      padding: 8,
    },
    row: {
      flexDirection: 'row',
    },
    title: {
      fontSize: 16,
    },
    description: {
      fontSize: 14,
    },
    marginVerticalNone: {
      marginVertical: 0,
    },
    iconMarginLeft: {
      marginLeft: 0,
      marginRight: 16,
    },
    iconMarginRight: {
      marginRight: 0,
    },
    item: {
      marginVertical: 6,
      paddingLeft: 8,
    },
    content: {
      flex: 1,
      justifyContent: 'center',
    },
  }),
  S = module788.withTheme(P);
exports.default = S;
