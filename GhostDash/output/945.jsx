var module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  p = React.createContext(null);

exports.RadioButtonContext = p;

var h = (function (t) {
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
          n = t.value,
          u = t.onValueChange,
          o = t.children;
        return (
          <p.Provider
            value={{
              value: n,
              onValueChange: u,
            }}
            __source={{
              fileName: '/Users/trensik/dev/react-native-paper/src/components/RadioButton/RadioButtonGroup.tsx',
              lineNumber: 68,
            }}
          >
            {o}
          </p.Provider>
        );
      },
    },
  ]);
  return n;
})(React.Component);

module50.default(h, 'displayName', 'RadioButton.Group');
var C = h;
exports.default = C;
