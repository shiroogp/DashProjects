var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module920 = require('./920'),
  module921 = require('./921'),
  module922 = require('./922'),
  module923 = require('./923'),
  module926 = require('./926'),
  C = (function (t) {
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
            f = t.style,
            o = module56.default(t, ['children', 'style']);
          return <ReactNative.View>{l}</ReactNative.View>;
        },
      },
    ]);
    return l;
  })(React.Component);

module50.default(C, 'Header', module921.default);
module50.default(C, 'Title', module922.default);
module50.default(C, 'Row', module926.default);
module50.default(C, 'Cell', module920.default);
module50.default(C, 'Pagination', module923.default);
var D = ReactNative.StyleSheet.create({
    container: {
      width: '100%',
    },
  }),
  N = C;
exports.default = N;
