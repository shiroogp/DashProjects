var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  React = (function (t, o) {
    if (!o && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var n = v(o);
    if (n && n.has(t)) return n.get(t);
    var l = {
        __proto__: null,
      },
      u = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var c in t)
      if ('default' !== c && Object.prototype.hasOwnProperty.call(t, c)) {
        var f = u ? Object.getOwnPropertyDescriptor(t, c) : null;
        if (f && (f.get || f.set)) Object.defineProperty(l, c, f);
        else l[c] = t[c];
      }

    l.default = t;
    if (n) n.set(t, l);
    return l;
  })(require('react')),
  ReactNative = require('react-native'),
  module753 = require('./753'),
  b = ['style', 'pressColor', 'borderless', 'children'];

function v(t) {
  if ('function' != typeof WeakMap) return null;
  var o = new WeakMap(),
    n = new WeakMap();
  return (v = function (t) {
    return t ? n : o;
  })(t);
}

function O() {
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

(exports.default = (function (t) {
  module38.default(k, t);

  var v = k,
    P = O(),
    _ = function () {
      var t,
        o = module37.default(v);

      if (P) {
        var n = module37.default(this).constructor;
        t = Reflect.construct(o, arguments, n);
      } else t = o.apply(this, arguments);

      return module40.default(this, t);
    };

  function k() {
    module27.default(this, k);
    return _.apply(this, arguments);
  }

  module28.default(k, [
    {
      key: 'render',
      value: function () {
        if ('android' === ReactNative.Platform.OS && ReactNative.Platform.Version >= 21) {
          var t = this.props,
            l = t.style,
            u = t.pressColor,
            c = t.borderless,
            f = t.children,
            s = module56.default(t, b);
          return (
            <ReactNative.TouchableNativeFeedback>
              <ReactNative.View style={l}>
                <f />
              </ReactNative.View>
            </ReactNative.TouchableNativeFeedback>
          );
        }

        return 'ios' === ReactNative.Platform.OS ? (
          <module753.default>{this.props.children}</module753.default>
        ) : (
          <ReactNative.TouchableOpacity>{this.props.children}</ReactNative.TouchableOpacity>
        );
      },
    },
  ]);
  return k;
})(React.Component)).defaultProps = {
  borderless: false,
  pressColor: 'rgba(0, 0, 0, .32)',
};
