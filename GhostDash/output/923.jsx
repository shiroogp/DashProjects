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
  module924 = require('./924'),
  module885 = require('./885'),
  module788 = require('./788'),
  module798 = require('./798'),
  x = '/Users/trensik/dev/react-native-paper/src/components/DataTable/DataTablePagination.tsx',
  D = (function (t) {
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
            n = t.label,
            u = t.page,
            c = t.numberOfPages,
            s = t.onPageChange,
            f = t.style,
            b = t.theme,
            h = module56.default(t, ['label', 'page', 'numberOfPages', 'onPageChange', 'style', 'theme']),
            y = module760.default(b.colors.text).alpha(0.6).rgb().string();
          return (
            <ReactNative.View>
              <module885.default
                style={[
                  E.label,
                  {
                    color: y,
                  },
                ]}
                numberOfLines={1}
                __source={{
                  fileName: x,
                  lineNumber: 60,
                }}
              >
                {n}
              </module885.default>
              <module924.default
                icon={function (t) {
                  var n = t.size,
                    l = t.color;
                  return (
                    <module798.default
                      name="chevron-left"
                      color={l}
                      size={n}
                      direction={ReactNative.I18nManager.isRTL ? 'rtl' : 'ltr'}
                      __source={{
                        fileName: x,
                        lineNumber: 65,
                      }}
                    />
                  );
                }}
                color={b.colors.text}
                disabled={0 === u}
                onPress={function () {
                  return s(u - 1);
                }}
                __source={{
                  fileName: x,
                  lineNumber: 63,
                }}
              />
              <module924.default
                icon={function (t) {
                  var n = t.size,
                    l = t.color;
                  return (
                    <module798.default
                      name="chevron-right"
                      color={l}
                      size={n}
                      direction={ReactNative.I18nManager.isRTL ? 'rtl' : 'ltr'}
                      __source={{
                        fileName: x,
                        lineNumber: 78,
                      }}
                    />
                  );
                }}
                color={b.colors.text}
                disabled={u === c - 1}
                onPress={function () {
                  return s(u + 1);
                }}
                __source={{
                  fileName: x,
                  lineNumber: 76,
                }}
              />
            </ReactNative.View>
          );
        },
      },
    ]);
    return n;
  })(React.Component);

exports.DataTablePagination = D;
module50.default(D, 'displayName', 'DataTable.Pagination');
var E = ReactNative.StyleSheet.create({
    container: {
      justifyContent: 'flex-end',
      flexDirection: 'row',
      alignItems: 'center',
      paddingLeft: 16,
    },
    label: {
      fontSize: 12,
      marginRight: 44,
    },
  }),
  z = module788.withTheme(D);
exports.default = z;
