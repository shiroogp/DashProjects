var module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  React = require('react'),
  ReactNative = require('react-native'),
  h = ['maskElement', 'children'];

function v() {
  if ('undefined' == typeof Reflect || !Reflect.construct) return false;
  if (Reflect.construct.sham) return false;
  if ('function' == typeof Proxy) return true;

  try {
    Boolean.prototype.valueOf.call(Reflect.construct(Boolean, [], function () {}));
    return true;
  } catch (t) {
    return false;
  }
}

var k = ReactNative.requireNativeComponent('RNCMaskedView'),
  y = (function (t, ...args) {
    module38.default(w, t);

    var y = w,
      E = v(),
      R = function () {
        var t,
          n = module37.default(y);

        if (E) {
          var l = module37.default(this).constructor;
          t = Reflect.construct(n, arguments, l);
        } else t = n.apply(this, arguments);

        return module40.default(this, t);
      };

    function w() {
      var t;
      module27.default(this, w);
      (t = R.call(this, ...args))._hasWarnedInvalidRenderMask = false;
      return t;
    }

    module28.default(w, [
      {
        key: 'render',
        value: function () {
          var t = this.props,
            l = t.maskElement,
            o = t.children,
            u = module56.default(t, h);
          if (React.default.isValidElement(l))
            return React.default.createElement(
              k,
              u,
              React.default.createElement(
                ReactNative.View,
                {
                  pointerEvents: 'none',
                  style: ReactNative.StyleSheet.absoluteFill,
                },
                l
              ),
              o
            );
          else {
            if (!this._hasWarnedInvalidRenderMask) {
              console.warn('MaskedView: Invalid `maskElement` prop was passed to MaskedView. Expected a React Element. No mask will render.');
              this._hasWarnedInvalidRenderMask = true;
            }

            return React.default.createElement(ReactNative.View, u, o);
          }
        },
      },
    ]);
    return w;
  })(React.default.Component);

module.exports = y;
