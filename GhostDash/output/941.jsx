var module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  module760 = require('./760'),
  React = require('react'),
  ReactNative = require('react-native'),
  module882 = require('./882'),
  module888 = require('./888'),
  module885 = require('./885'),
  module788 = require('./788'),
  module787 = require('./787'),
  x = '/Users/trensik/dev/react-native-paper/src/components/Menu/MenuItem.tsx',
  E = (function (t) {
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
            l = t.title,
            o = t.disabled,
            u = t.onPress,
            s = t.theme,
            c = t.style,
            f = t.testID,
            v = t.titleStyle,
            E = module760
              .default(s.dark ? module787.white : module787.black)
              .alpha(0.32)
              .rgb()
              .string(),
            W = o ? E : module760.default(s.colors.text).alpha(0.87).rgb().string(),
            M = o ? E : module760.default(s.colors.text).alpha(0.54).rgb().string();
          return (
            <module888.default
              style={[I.container, c]}
              onPress={u}
              disabled={o}
              testID={f}
              __source={{
                fileName: x,
                lineNumber: 86,
              }}
            >
              <ReactNative.View
                style={I.row}
                __source={{
                  fileName: x,
                  lineNumber: 92,
                }}
              >
                {n ? (
                  <ReactNative.View
                    style={[I.item, I.icon]}
                    pointerEvents="box-none"
                    __source={{
                      fileName: x,
                      lineNumber: 94,
                    }}
                  >
                    <module882.default
                      source={n}
                      size={24}
                      color={M}
                      __source={{
                        fileName: x,
                        lineNumber: 95,
                      }}
                    />
                  </ReactNative.View>
                ) : null}
                <ReactNative.View
                  style={[I.item, I.content, n ? I.widthWithIcon : null]}
                  pointerEvents="none"
                  __source={{
                    fileName: x,
                    lineNumber: 98,
                  }}
                >
                  <module885.default
                    numberOfLines={1}
                    style={[
                      I.title,
                      {
                        color: W,
                      },
                      v,
                    ]}
                    __source={{
                      fileName: x,
                      lineNumber: 106,
                    }}
                  >
                    {l}
                  </module885.default>
                </ReactNative.View>
              </ReactNative.View>
            </module888.default>
          );
        },
      },
    ]);
    return n;
  })(React.Component);

exports.MenuItem = E;
module50.default(E, 'displayName', 'Menu.Item');
var I = ReactNative.StyleSheet.create({
    container: {
      padding: 8,
      minWidth: 112,
      maxWidth: 280,
    },
    row: {
      flexDirection: 'row',
    },
    icon: {
      width: 40,
    },
    title: {
      fontSize: 16,
    },
    item: {
      margin: 8,
    },
    content: {
      justifyContent: 'center',
      minWidth: 96,
      maxWidth: 264,
    },
    widthWithIcon: {
      maxWidth: 192,
    },
  }),
  W = module788.withTheme(E);
exports.default = W;
