var module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module928 = require('./928'),
  module929 = require('./929'),
  module930 = require('./930'),
  module931 = require('./931'),
  module932 = require('./932'),
  module788 = require('./788'),
  D = (function (t) {
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
            l = t.children,
            n = t.dismissable,
            o = t.onDismiss,
            s = t.visible,
            u = t.style,
            f = t.theme;
          return (
            <module928.default
              dismissable={n}
              onDismiss={o}
              visible={s}
              contentContainerStyle={[
                {
                  borderRadius: f.roundness,
                  backgroundColor: f.colors.surface,
                },
                k.container,
                u,
              ]}
              __source={{
                fileName: '/Users/trensik/dev/react-native-paper/src/components/Dialog/Dialog.tsx',
                lineNumber: 109,
              }}
            >
              {React.Children.toArray(l)
                .filter(function (t) {
                  return null != t && 'boolean' != typeof t;
                })
                .map(function (t, l) {
                  return 0 === l && React.isValidElement(t) && t.type === module929.default
                    ? React.cloneElement(t, {
                        style: [
                          {
                            paddingTop: 24,
                          },
                          t.props.style,
                        ],
                      })
                    : t;
                })}
            </module928.default>
          );
        },
      },
    ]);
    return l;
  })(React.Component);

module50.default(D, 'Content', module929.default);
module50.default(D, 'Actions', module930.default);
module50.default(D, 'Title', module931.default);
module50.default(D, 'ScrollArea', module932.default);
module50.default(D, 'defaultProps', {
  dismissable: true,
  visible: false,
});
var k = ReactNative.StyleSheet.create({
    container: {
      marginVertical: 'android' === ReactNative.Platform.OS ? 44 : 0,
      marginHorizontal: 26,
      elevation: 24,
      justifyContent: 'flex-start',
    },
  }),
  A = module788.withTheme(D);
exports.default = A;
