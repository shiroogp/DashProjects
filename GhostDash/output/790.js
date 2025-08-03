exports.__esModule = true;

exports.default = function (f) {
  var c = React.createContext(f),
    l = module792.default(f, c),
    s = module793.default(l, c);
  return {
    ThemeContext: c,
    ThemeProvider: l,
    withTheme: s,
    useTheme: function (u) {
      var o = React.useContext(c),
        f = React.useMemo(
          function () {
            return o && u ? module791.default(o, u) : o || u;
          },
          [o, u]
        );
      return f;
    },
  };
};

var React = (function (t) {
    if (t && t.__esModule) return t;
    var n = {};
    if (null != t)
      for (var u in t)
        if (Object.prototype.hasOwnProperty.call(t, u)) {
          var o = Object.defineProperty && Object.getOwnPropertyDescriptor ? Object.getOwnPropertyDescriptor(t, u) : {};
          if (o.get || o.set) Object.defineProperty(n, u, o);
          else n[u] = t[u];
        }
    n.default = t;
    return n;
  })(require('react')),
  module791 = require('./791'),
  module792 = require('./792'),
  module793 = require('./793');
