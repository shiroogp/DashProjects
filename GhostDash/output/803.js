exports.default = function (t) {
  var k;
  (k = (function (v) {
    module38.default(T, v);

    var k = T,
      w = S(),
      _ = function () {
        var t,
          n = module37.default(k);

        if (w) {
          var o = module37.default(this).constructor;
          t = Reflect.construct(n, arguments, o);
        } else t = n.apply(this, arguments);

        return module40.default(this, t);
      };

    function T() {
      module27.default(this, T);
      return _.apply(this, arguments);
    }

    module28.default(T, [
      {
        key: 'render',
        value: function () {
          var l = this.props,
            u = l.style,
            c = l.iconStyle,
            s = l.children,
            f = module56.default(l, O),
            v = module865.default(f, R, 'style', 'name', 'size', 'color'),
            k = module865.default(f, C),
            S = module805.default(f, Object.keys(v), Object.keys(k), 'iconStyle', 'borderRadius', 'backgroundColor');
          v.style = c ? [j.icon, c] : j.icon;

          var w = module865.default(this.props, 'color'),
            _ = module865.default(this.props, 'backgroundColor', 'borderRadius');

          return React.default.createElement(
            module801.TouchableHighlight,
            module14.default(
              {
                style: [j.touchable, _],
              },
              k
            ),
            React.default.createElement(
              module801.View,
              module14.default(
                {
                  style: [j.container, _, u],
                },
                S
              ),
              React.default.createElement(t, v),
              module804.default(s)
                ? React.default.createElement(
                    module801.Text,
                    {
                      style: [j.text, w],
                    },
                    s
                  )
                : s
            )
          );
        },
      },
    ]);
    return T;
  })(React.PureComponent)).propTypes = {
    backgroundColor: PropTypes.default.oneOfType([PropTypes.default.string, PropTypes.default.number]),
    borderRadius: PropTypes.default.number,
    color: PropTypes.default.oneOfType([PropTypes.default.string, PropTypes.default.number]),
    size: PropTypes.default.number,
    iconStyle: PropTypes.default.any,
    style: PropTypes.default.any,
    children: PropTypes.default.node,
  };
  k.defaultProps = {
    backgroundColor: w,
    borderRadius: 5,
    color: 'white',
    size: 20,
  };
  return k;
};

var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module804 = require('./804'),
  module805 = require('./805'),
  module865 = require('./865'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = k(n);
    if (o && o.has(t)) return o.get(t);
    var l = {
        __proto__: null,
      },
      u = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var c in t)
      if ('default' !== c && Object.prototype.hasOwnProperty.call(t, c)) {
        var s = u ? Object.getOwnPropertyDescriptor(t, c) : null;
        if (s && (s.get || s.set)) Object.defineProperty(l, c, s);
        else l[c] = t[c];
      }

    l.default = t;
    if (o) o.set(t, l);
    return l;
  })(require('react')),
  PropTypes = require('prop-types'),
  module801 = require('./801'),
  O = ['style', 'iconStyle', 'children'];

function k(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (k = function (t) {
    return t ? o : n;
  })(t);
}

function S() {
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

var j = module801.StyleSheet.create({
    container: {
      flexDirection: 'row',
      justifyContent: 'flex-start',
      alignItems: 'center',
      padding: 8,
    },
    touchable: {
      overflow: 'hidden',
    },
    icon: {
      marginRight: 10,
    },
    text: {
      fontWeight: '600',
      backgroundColor: 'transparent',
    },
  }),
  w = '#007AFF',
  R = ['ellipsizeMode', 'numberOfLines', 'textBreakStrategy', 'selectable', 'suppressHighlighting', 'allowFontScaling', 'adjustsFontSizeToFit', 'minimumFontScale'],
  C = [
    'accessible',
    'accessibilityLabel',
    'accessibilityHint',
    'accessibilityComponentType',
    'accessibilityRole',
    'accessibilityStates',
    'accessibilityTraits',
    'onFocus',
    'onBlur',
    'disabled',
    'onPress',
    'onPressIn',
    'onPressOut',
    'onLayout',
    'onLongPress',
    'nativeID',
    'testID',
    'delayPressIn',
    'delayPressOut',
    'delayLongPress',
    'activeOpacity',
    'underlayColor',
    'selectionColor',
    'onShowUnderlay',
    'onHideUnderlay',
    'hasTVPreferredFocus',
    'tvParallaxProperties',
  ];
