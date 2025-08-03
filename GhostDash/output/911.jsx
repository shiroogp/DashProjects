var module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module788 = require('./788'),
  module912 = require('./912'),
  module914 = require('./914'),
  p = '/Users/trensik/dev/react-native-paper/src/components/Card/CardTitle.tsx',
  v = (function (t) {
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
            l = t.left,
            n = t.leftStyle,
            u = t.right,
            s = t.rightStyle,
            f = t.subtitle,
            c = t.subtitleStyle,
            o = t.subtitleNumberOfLines,
            h = t.style,
            v = t.title,
            w = t.titleStyle;
          return (
            <ReactNative.View
              style={[
                C.container,
                {
                  minHeight: f || l || u ? 72 : 50,
                },
                h,
              ]}
              __source={{
                fileName: p,
                lineNumber: 115,
              }}
            >
              {l ? (
                <ReactNative.View
                  style={[C.left, n]}
                  __source={{
                    fileName: p,
                    lineNumber: 123,
                  }}
                >
                  {l({
                    size: 40,
                  })}
                </ReactNative.View>
              ) : null}
              <ReactNative.View
                style={[C.titles]}
                __source={{
                  fileName: p,
                  lineNumber: 130,
                }}
              >
                {v ? (
                  <module914.default
                    style={[
                      C.title,
                      {
                        marginBottom: f ? 0 : 2,
                      },
                      w,
                    ]}
                    __source={{
                      fileName: p,
                      lineNumber: 132,
                    }}
                  >
                    {v}
                  </module914.default>
                ) : null}
                {f ? (
                  <module912.default
                    style={[C.subtitle, c]}
                    numberOfLines={o}
                    __source={{
                      fileName: p,
                      lineNumber: 144,
                    }}
                  >
                    {f}
                  </module912.default>
                ) : null}
              </ReactNative.View>
              <ReactNative.View
                style={s}
                __source={{
                  fileName: p,
                  lineNumber: 153,
                }}
              >
                {u
                  ? u({
                      size: 24,
                    })
                  : null}
              </ReactNative.View>
            </ReactNative.View>
          );
        },
      },
    ]);
    return l;
  })(React.Component);

exports.CardTitle = v;
module50.default(v, 'displayName', 'Card.Title');
module50.default(v, 'defaultProps', {
  subtitleNumberOfLines: 1,
});
var C = ReactNative.StyleSheet.create({
    container: {
      flexDirection: 'row',
      alignItems: 'center',
      justifyContent: 'space-between',
      paddingLeft: 16,
    },
    left: {
      justifyContent: 'center',
      marginRight: 16,
      height: 40,
      width: 40,
    },
    titles: {
      flex: 1,
      flexDirection: 'column',
      justifyContent: 'center',
    },
    title: {
      minHeight: 30,
    },
    subtitle: {
      minHeight: 20,
      marginVertical: 0,
    },
  }),
  w = module788.withTheme(v);
exports.default = w;
