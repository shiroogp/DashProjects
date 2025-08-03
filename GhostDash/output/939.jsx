var module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  module940 = require('./940'),
  module875 = require('./875'),
  module797 = require('./797'),
  module788 = require('./788'),
  b = '/Users/trensik/dev/react-native-paper/src/components/Portal/Portal.tsx',
  P = (function (t) {
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
            n = t.children,
            u = t.theme;
          return (
            <module797.Consumer
              __source={{
                fileName: b,
                lineNumber: 51,
              }}
            >
              {function (t) {
                return React.createElement(
                  module875.PortalContext.Consumer,
                  {
                    __source: {
                      fileName: b,
                      lineNumber: 53,
                    },
                  },
                  function (l) {
                    return React.createElement(
                      module940.default,
                      {
                        manager: l,
                        __source: {
                          fileName: b,
                          lineNumber: 55,
                        },
                      },
                      React.createElement(
                        module797.Provider,
                        {
                          value: t,
                          __source: {
                            fileName: b,
                            lineNumber: 56,
                          },
                        },
                        React.createElement(
                          module788.ThemeProvider,
                          {
                            theme: u,
                            __source: {
                              fileName: b,
                              lineNumber: 57,
                            },
                          },
                          n
                        )
                      )
                    );
                  }
                );
              }}
            </module797.Consumer>
          );
        },
      },
    ]);
    return n;
  })(React.Component);

module50.default(P, 'Host', module875.default);
var E = module788.withTheme(P);
exports.default = E;
