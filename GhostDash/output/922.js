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
  module798 = require('./798'),
  module885 = require('./885'),
  module788 = require('./788'),
  w = '/Users/trensik/dev/react-native-paper/src/components/DataTable/DataTableTitle.tsx',
  A = (function (t, ...args) {
    function n() {
      var t, module14;
      module27.default(this, n);
      module14 = module40.default(this, (t = module37.default(n)).call.apply(t, [this].concat(args)));
      module50.default(module42.default(module14), 'state', {
        spinAnim: new ReactNative.Animated.Value('ascending' === module14.props.sortDirection ? 0 : 1),
      });
      return module14;
    }

    module38.default(n, t);
    module28.default(n, [
      {
        key: 'componentDidUpdate',
        value: function (t) {
          if (t.sortDirection !== this.props.sortDirection)
            ReactNative.Animated.timing(this.state.spinAnim, {
              toValue: 'ascending' === this.props.sortDirection ? 0 : 1,
              duration: 150,
              useNativeDriver: true,
            }).start();
        },
      },
      {
        key: 'render',
        value: function () {
          var t = this.props,
            n = t.numeric,
            s = t.children,
            u = t.onPress,
            c = t.sortDirection,
            f = t.theme,
            h = t.style,
            p = t.numberOfLines,
            b = module56.default(t, ['numeric', 'children', 'onPress', 'sortDirection', 'theme', 'style', 'numberOfLines']),
            T = module760.default(f.colors.text).alpha(0.6).rgb().string(),
            A = this.state.spinAnim.interpolate({
              inputRange: [0, 1],
              outputRange: ['0deg', '180deg'],
            }),
            L = c
              ? React.createElement(
                  ReactNative.Animated.View,
                  {
                    style: [
                      x.icon,
                      {
                        transform: [
                          {
                            rotate: A,
                          },
                        ],
                      },
                    ],
                    __source: {
                      fileName: w,
                      lineNumber: 97,
                    },
                  },
                  React.createElement(module798.default, {
                    name: 'arrow-down',
                    size: 16,
                    color: f.colors.text,
                    direction: ReactNative.I18nManager.isRTL ? 'rtl' : 'ltr',
                    __source: {
                      fileName: w,
                      lineNumber: 98,
                    },
                  })
                )
              : null;
          return React.createElement(
            ReactNative.TouchableWithoutFeedback,
            module14.default(
              {
                disabled: !u,
                onPress: u,
              },
              b,
              {
                __source: {
                  fileName: w,
                  lineNumber: 108,
                },
              }
            ),
            React.createElement(
              ReactNative.View,
              {
                style: [x.container, n && x.right, h],
                __source: {
                  fileName: w,
                  lineNumber: 109,
                },
              },
              L,
              React.createElement(
                module885.default,
                {
                  style: [
                    x.cell,
                    c
                      ? x.sorted
                      : {
                          color: T,
                        },
                  ],
                  numberOfLines: p,
                  __source: {
                    fileName: w,
                    lineNumber: 112,
                  },
                },
                s
              )
            )
          );
        },
      },
    ]);
    return n;
  })(React.Component);

exports.DataTableTitle = A;
module50.default(A, 'displayName', 'DataTable.Title');
module50.default(A, 'defaultProps', {
  numberOfLines: 1,
});
var x = ReactNative.StyleSheet.create({
    container: {
      flex: 1,
      flexDirection: 'row',
      alignContent: 'center',
      paddingVertical: 12,
    },
    right: {
      justifyContent: 'flex-end',
    },
    cell: {
      height: 24,
      lineHeight: 24,
      fontSize: 12,
      fontWeight: '500',
      alignItems: 'center',
    },
    sorted: {
      marginLeft: 8,
    },
    icon: {
      height: 24,
      justifyContent: 'center',
    },
  }),
  L = module788.withTheme(A);
exports.default = L;
