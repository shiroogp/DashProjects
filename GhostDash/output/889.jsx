var module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module42 = require('./42'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  x = React.createContext(null);

exports.ListAccordionGroupContext = x;

var A = (function (t, ...args) {
  function n() {
    var t, module28;
    module27.default(this, n);
    module28 = module40.default(this, (t = module37.default(n)).call.apply(t, [this].concat(args)));
    module50.default(module42.default(module28), 'state', {
      expandedId: undefined,
    });
    module50.default(module42.default(module28), 'onAccordionPress', function (t) {
      module28.setState(function (n) {
        return {
          expandedId: n.expandedId === t ? undefined : t,
        };
      });
    });
    return module28;
  }

  module38.default(n, t);
  module28.default(n, [
    {
      key: 'render',
      value: function () {
        var t = this.props,
          n = t.expandedId,
          o = t.onAccordionPress,
          c = t.children;
        return (
          <x.Provider
            value={{
              expandedId: n || this.state.expandedId,
              onAccordionPress: o || this.onAccordionPress,
            }}
            __source={{
              fileName: '/Users/trensik/dev/react-native-paper/src/components/List/ListAccordionGroup.tsx',
              lineNumber: 82,
            }}
          >
            {c}
          </x.Provider>
        );
      },
    },
  ]);
  return n;
})(React.Component);

module50.default(A, 'displayName', 'List.AccordionGroup');
var h = A;
exports.default = h;
