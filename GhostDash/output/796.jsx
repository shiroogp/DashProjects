var module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  React = require('react'),
  module788 = require('./788'),
  module797 = require('./797'),
  module798 = require('./798'),
  module875 = require('./875'),
  N = '/Users/trensik/dev/react-native-paper/src/core/Provider.tsx',
  b = (function (t) {
    function n() {
      module27.default(this, n);
      return module40.default(this, module37.default(n).apply(this, arguments));
    }

    module38.default(n, t);
    module28.default(n, [
      {
        key: 'render',
        value: function () {
          return (
            <module875.default
              __source={{
                fileName: N,
                lineNumber: 17,
              }}
            >
              <module797.Provider
                value={
                  this.props.settings || {
                    icon: module798.default,
                  }
                }
                __source={{
                  fileName: N,
                  lineNumber: 18,
                }}
              >
                <module788.ThemeProvider
                  theme={this.props.theme}
                  __source={{
                    fileName: N,
                    lineNumber: 21,
                  }}
                >
                  {this.props.children}
                </module788.ThemeProvider>
              </module797.Provider>
            </module875.default>
          );
        },
      },
    ]);
    return n;
  })(React.Component);

exports.default = b;
