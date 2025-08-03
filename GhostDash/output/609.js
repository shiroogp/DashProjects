var module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  React = require('react'),
  module406 = require('./406'),
  module610 = require('./610'),
  module516 = require('./516'),
  module606 = require('./606');

function y() {
  if ('undefined' == typeof Reflect || !Reflect.construct) return false;
  if (Reflect.construct.sham) return false;
  if ('function' == typeof Proxy) return true;

  try {
    Boolean.prototype.valueOf.call(Reflect.construct(Boolean, [], function () {}));
    return true;
  } catch (o) {
    return false;
  }
}

var b = (exports.forceTouchGestureHandlerProps = ['minForce', 'maxForce', 'feedbackOnActivation']),
  H = (function (o) {
    module38.default(p, o);

    var module23 = p,
      React = y(),
      v = function () {
        var o,
          c = module37.default(module23);

        if (React) {
          var n = module37.default(this).constructor;
          o = Reflect.construct(c, arguments, n);
        } else o = c.apply(this, arguments);

        return module40.default(this, o);
      };

    function p() {
      module27.default(this, p);
      return v.apply(this, arguments);
    }

    module28.default(p, [
      {
        key: 'componentDidMount',
        value: function () {
          console.warn(
            module406.tagMessage(
              'ForceTouchGestureHandler is not available on this platform. Please use ForceTouchGestureHandler.forceTouchAvailable to conditionally render other components that would provide a fallback behavior specific to your usecase'
            )
          );
        },
      },
      {
        key: 'render',
        value: function () {
          return this.props.children;
        },
      },
    ]);
    return p;
  })(React.default.Component);

H.forceTouchAvailable = false;
var G = (exports.forceTouchHandlerName = 'ForceTouchGestureHandler');
(exports.ForceTouchGestureHandler =
  null != module610.default && module610.default.forceTouchAvailable
    ? module516.default({
        name: G,
        allowedProps: [].concat(module23.default(module606.baseGestureHandlerProps), b),
        config: {},
      })
    : H).forceTouchAvailable = (null == module610.default ? undefined : module610.default.forceTouchAvailable) || false;
