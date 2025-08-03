var module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module42 = require('./42'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module876 = require('./876'),
  k = '/Users/trensik/dev/react-native-paper/src/components/Portal/PortalHost.tsx',
  _ = React.createContext(null);

exports.PortalContext = _;

var x = (function (t, ...args) {
  function n() {
    var t, module28;
    module27.default(this, n);
    module28 = module40.default(this, (t = module37.default(n)).call.apply(t, [this].concat(args)));
    module50.default(module42.default(module28), 'setManager', function (t) {
      module28.manager = t;
    });
    module50.default(module42.default(module28), 'mount', function (t) {
      var n = module28.nextKey++;
      if (module28.manager) module28.manager.mount(n, t);
      else
        module28.queue.push({
          type: 'mount',
          key: n,
          children: t,
        });
      return n;
    });
    module50.default(module42.default(module28), 'update', function (t, n) {
      if (module28.manager) module28.manager.update(t, n);
      else {
        var u = {
            type: 'mount',
            key: t,
            children: n,
          },
          o = module28.queue.findIndex(function (n) {
            return 'mount' === n.type || ('update' === n.type && n.key === t);
          });
        if (o > -1) module28.queue[o] = u;
        else module28.queue.push(u);
      }
    });
    module50.default(module42.default(module28), 'unmount', function (t) {
      if (module28.manager) module28.manager.unmount(t);
      else
        module28.queue.push({
          type: 'unmount',
          key: t,
        });
    });
    module50.default(module42.default(module28), 'nextKey', 0);
    module50.default(module42.default(module28), 'queue', []);
    module50.default(module42.default(module28), 'manager', undefined);
    return module28;
  }

  module38.default(n, t);
  module28.default(n, [
    {
      key: 'componentDidMount',
      value: function () {
        for (var t = this.manager, n = this.queue; n.length && t; ) {
          var u = n.pop();
          if (u)
            switch (u.type) {
              case 'mount':
                t.mount(u.key, u.children);
                break;

              case 'update':
                t.update(u.key, u.children);
                break;

              case 'unmount':
                t.unmount(u.key);
            }
        }
      },
    },
    {
      key: 'render',
      value: function () {
        return (
          <_.Provider
            value={{
              mount: this.mount,
              update: this.update,
              unmount: this.unmount,
            }}
            __source={{
              fileName: k,
              lineNumber: 120,
            }}
          >
            <ReactNative.View
              style={b.container}
              collapsable={false}
              pointerEvents="box-none"
              __source={{
                fileName: k,
                lineNumber: 128,
              }}
            >
              {this.props.children}
            </ReactNative.View>
            <module876.default
              ref={this.setManager}
              __source={{
                fileName: k,
                lineNumber: 135,
              }}
            />
          </_.Provider>
        );
      },
    },
  ]);
  return n;
})(React.Component);

exports.default = x;
module50.default(x, 'displayName', 'Portal.Host');
var b = ReactNative.StyleSheet.create({
  container: {
    flex: 1,
  },
});
