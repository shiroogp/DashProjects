exports.default = function (t, _, C, S) {
  var T = C ? C.replace(/\.(otf|ttf)$/, '') : _,
    j = module801.Platform.select({
      windows: '/Assets/' + C + '#' + _,
      android: T,
      web: T,
      default: _,
    }),
    E = PropTypes.default.oneOf(Object.keys(t)),
    M = (function (o, ...args) {
      module38.default(b, o);

      var PropTypes = b,
        module802 = w(),
        O = function () {
          var t,
            o = module37.default(PropTypes);

          if (module802) {
            var n = module37.default(this).constructor;
            t = Reflect.construct(o, arguments, n);
          } else t = o.apply(this, arguments);

          return module40.default(this, t);
        };

      function b() {
        var t;
        module27.default(this, b);
        (t = O.call(this, ...args)).root = null;

        t.handleRef = function (o) {
          t.root = o;
        };

        return t;
      }

      module28.default(b, [
        {
          key: 'setNativeProps',
          value: function (t) {
            if (this.root) this.root.setNativeProps(t);
          },
        },
        {
          key: 'render',
          value: function () {
            var o = this.props,
              l = o.name,
              u = o.size,
              f = o.color,
              c = o.style,
              s = o.children,
              v = module56.default(o, I),
              h = l ? t[l] || '?' : '';
            if ('number' == typeof h) h = String.fromCharCode(h);
            var O = {
                fontSize: u,
                color: f,
              },
              b = {
                fontFamily: j,
                fontWeight: 'normal',
                fontStyle: 'normal',
              };
            v.style = [O, c, b, S || {}];
            v.ref = this.handleRef;
            return React.default.createElement(module801.Text, v, h, s);
          },
        },
      ]);
      return b;
    })(React.PureComponent);

  M.propTypes = {
    allowFontScaling: PropTypes.default.bool,
    name: E,
    size: PropTypes.default.number,
    color: PropTypes.default.oneOfType([PropTypes.default.string, PropTypes.default.number]),
    children: PropTypes.default.node,
    style: PropTypes.default.any,
  };
  M.defaultProps = {
    size: N,
    allowFontScaling: false,
  };
  var A = {};

  function k(o) {
    var n = arguments.length > 1 && undefined !== arguments[1] ? arguments[1] : N,
      l = arguments.length > 2 && undefined !== arguments[2] ? arguments[2] : R;
    module802.default();
    var u = t[o] || '?';
    if ('number' == typeof u) u = String.fromCharCode(u);
    var f = module801.processColor(l),
      c = u + ':' + n + ':' + f,
      s = module801.PixelRatio.get();
    return new Promise(function (t, o) {
      var l = A[c];
      if (undefined !== l)
        !l || l instanceof Error
          ? o(l)
          : t({
              uri: l,
              scale: s,
            });
      else
        F.getImageForFont(j, u, n, f, function (n, l) {
          var u = 'string' == typeof n ? new Error(n) : n;
          A[c] = l || u || false;
          if (!u && l)
            t({
              uri: l,
              scale: s,
            });
          else o(u);
        });
    });
  }

  M.Button = module803.default(M);
  M.TabBarItem = regeneratorRuntime.default(E, k);
  M.TabBarItemIOS = M.TabBarItem;
  M.ToolbarAndroid = regeneratorRuntime.default(E, k);
  M.getImageSource = k;

  M.loadFont = function () {
    var t = arguments.length > 0 && undefined !== arguments[0] ? arguments[0] : C;

    if ('ios' === module801.Platform.OS) {
      module802.default();
      return t ? F.loadFontWithFileName.apply(F, module23.default(t.split('.'))) : Promise.reject(new Error('Unable to load font, because no file was specified. '));
    } else return Promise.resolve();
  };

  M.hasIcon = function (o) {
    return Object.prototype.hasOwnProperty.call(t, o);
  };

  M.getRawGlyphMap = function () {
    return t;
  };

  M.getFontFamily = function () {
    return j;
  };

  return M;
};

var module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
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

    var n = _(o);

    if (n && n.has(t)) return n.get(t);
    var l = {
        __proto__: null,
      },
      u = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var f in t)
      if ('default' !== f && Object.prototype.hasOwnProperty.call(t, f)) {
        var c = u ? Object.getOwnPropertyDescriptor(t, f) : null;
        if (c && (c.get || c.set)) Object.defineProperty(l, f, c);
        else l[f] = t[f];
      }

    l.default = t;
    if (n) n.set(t, l);
    return l;
  })(require('react')),
  PropTypes = require('prop-types'),
  module801 = require('./801'),
  module802 = require('./802'),
  module803 = require('./803'),
  regeneratorRuntime = require('regenerator-runtime'),
  regeneratorRuntime = require('regenerator-runtime'),
  I = ['name', 'size', 'color', 'style', 'children'];

function _(t) {
  if ('function' != typeof WeakMap) return null;
  var o = new WeakMap(),
    n = new WeakMap();
  return (_ = function (t) {
    return t ? n : o;
  })(t);
}

function w() {
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

var F = (exports.NativeIconAPI = module801.NativeModules.RNVectorIconsManager || module801.NativeModules.RNVectorIconsModule),
  N = (exports.DEFAULT_ICON_SIZE = 12),
  R = (exports.DEFAULT_ICON_COLOR = 'black');
