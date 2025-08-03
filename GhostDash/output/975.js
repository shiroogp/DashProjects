var module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  PropTypes = require('prop-types'),
  module976 = require('./976'),
  module979 = require('./979'),
  module977 = require('./977'),
  module984 = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var l = p(n);
    if (l && l.has(t)) return l.get(t);
    var o = {
        __proto__: null,
      },
      c = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var u in t)
      if ('default' !== u && Object.prototype.hasOwnProperty.call(t, u)) {
        var s = c ? Object.getOwnPropertyDescriptor(t, u) : null;
        if (s && (s.get || s.set)) Object.defineProperty(o, u, s);
        else o[u] = t[u];
      }

    o.default = t;
    if (l) l.set(t, o);
    return o;
  })(require('./984'));

function p(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    l = new WeakMap();
  return (p = function (t) {
    return t ? l : n;
  })(t);
}

function O(t, n) {
  var l = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var o = Object.getOwnPropertySymbols(t);
    if (n)
      o = o.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    l.push.apply(l, o);
  }

  return l;
}

function I(t) {
  for (var l = 1; l < arguments.length; l++) {
    var o = null != arguments[l] ? arguments[l] : {};
    if (l % 2)
      O(Object(o), true).forEach(function (l) {
        module50.default(t, l, o[l]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      O(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

function b(t) {
  var n = t.leadingIcon,
    c = t.trailingIcon,
    s = t.text1,
    f = t.text2,
    p = t.onPress,
    O = t.onLeadingIconPress,
    b = t.onTrailingIconPress,
    v = t.style,
    P = t.leadingIconContainerStyle,
    x = t.trailingIconContainerStyle,
    S = t.leadingIconStyle,
    T = t.trailingIconStyle,
    j = t.contentContainerStyle,
    w = t.text1Style,
    E = t.text2Style,
    C = t.activeOpacity,
    D = t.text1NumberOfLines,
    L = t.text2NumberOfLines;
  return React.default.createElement(
    ReactNative.TouchableOpacity,
    {
      testID: 'rootView',
      style: [module984.default.base, module984.default.borderLeft, v],
      onPress: p,
      activeOpacity: p ? C : 1,
    },
    n &&
      React.default.createElement(
        ReactNative.TouchableOpacity,
        {
          testID: 'leadingIcon',
          style: [module984.default.leadingIconContainer, P],
          onPress: O,
          activeOpacity: O ? C : 1,
        },
        React.default.createElement(module976.default, {
          style: I(I({}, module984.default.leadingIcon), S),
          source: n,
        })
      ),
    React.default.createElement(
      ReactNative.View,
      {
        testID: 'contentContainer',
        style: [module984.default.contentContainer, j],
      },
      (null == s ? undefined : s.length) > 0 &&
        React.default.createElement(
          ReactNative.View,
          null,
          React.default.createElement(
            ReactNative.Text,
            {
              testID: 'text1',
              style: [module984.default.text1, w],
              numberOfLines: D,
            },
            s
          )
        ),
      (null == f ? undefined : f.length) > 0 &&
        React.default.createElement(
          ReactNative.View,
          null,
          React.default.createElement(
            ReactNative.Text,
            {
              testID: 'text2',
              style: [module984.default.text2, E],
              numberOfLines: L,
            },
            f
          )
        )
    ),
    c &&
      React.default.createElement(
        ReactNative.TouchableOpacity,
        {
          testID: 'trailingIcon',
          style: [module984.default.trailingIconContainer, x],
          onPress: b,
          activeOpacity: b ? C : 1,
        },
        React.default.createElement(module976.default, {
          style: I(I({}, module984.default.trailingIcon), T),
          source: c,
        })
      )
  );
}

b.HEIGHT = module984.HEIGHT;
b.propTypes = {
  leadingIcon: module976.default.propTypes.source,
  trailingIcon: module976.default.propTypes.source,
  text1: PropTypes.default.string,
  text2: PropTypes.default.string,
  onPress: PropTypes.default.func,
  onTrailingIconPress: PropTypes.default.func,
  onLeadingIconPress: PropTypes.default.func,
  style: module977.stylePropType,
  leadingIconContainerStyle: module977.stylePropType,
  trailingIconContainerStyle: module977.stylePropType,
  leadingIconStyle: module977.stylePropType,
  trailingIconStyle: module977.stylePropType,
  contentContainerStyle: module977.stylePropType,
  text1Style: module977.stylePropType,
  text2Style: module977.stylePropType,
  activeOpacity: PropTypes.default.number,
  text1NumberOfLines: PropTypes.default.number,
  text2NumberOfLines: PropTypes.default.number,
};
b.defaultProps = {
  leadingIcon: undefined,
  trailingIcon: module979.icons.close,
  text1: undefined,
  text2: undefined,
  onPress: undefined,
  onLeadingIconPress: undefined,
  onTrailingIconPress: undefined,
  style: undefined,
  leadingIconContainerStyle: undefined,
  trailingIconContainerStyle: undefined,
  leadingIconStyle: undefined,
  trailingIconStyle: undefined,
  contentContainerStyle: undefined,
  text1Style: undefined,
  text2Style: undefined,
  activeOpacity: 0.8,
  text1NumberOfLines: 1,
  text2NumberOfLines: 2,
};
exports.default = b;
