var regeneratorRuntime = require('regenerator-runtime'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module42 = require('./42'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = (function (t, ...args) {
    function n() {
      var t, regeneratorRuntime;
      module27.default(this, n);
      regeneratorRuntime = module40.default(this, (t = module37.default(n)).call.apply(t, [this].concat(args)));
      module50.default(module42.default(regeneratorRuntime), 'key', undefined);
      return regeneratorRuntime;
    }

    module38.default(n, t);
    module28.default(n, [
      {
        key: 'componentDidMount',
        value: function () {
          return regeneratorRuntime.default.async(
            function (t) {
              for (;;)
                switch ((t.prev = t.next)) {
                  case 0:
                    this.checkManager();
                    t.next = 3;
                    return regeneratorRuntime.default.awrap(Promise.resolve());

                  case 3:
                    this.key = this.props.manager.mount(this.props.children);

                  case 4:
                  case 'end':
                    return t.stop();
                }
            },
            null,
            this
          );
        },
      },
      {
        key: 'componentDidUpdate',
        value: function () {
          this.checkManager();
          this.props.manager.update(this.key, this.props.children);
        },
      },
      {
        key: 'componentWillUnmount',
        value: function () {
          this.checkManager();
          this.props.manager.unmount(this.key);
        },
      },
      {
        key: 'checkManager',
        value: function () {
          if (!this.props.manager)
            throw new Error(
              "Looks like you forgot to wrap your root component with `Provider` component from `react-native-paper`.\n\nPlease read our getting-started guide and make sure you've followed all the required steps.\n\nhttps://callstack.github.io/react-native-paper/getting-started.html"
            );
        },
      },
      {
        key: 'render',
        value: function () {
          return null;
        },
      },
    ]);
    return n;
  })(require('react').Component);

exports.default = React;
