var module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module936 = require('./936'),
  p = '/Users/trensik/dev/react-native-paper/src/components/TextInput/Label/InputLabel.tsx';

function c(t, l) {
  var n = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var o = Object.getOwnPropertySymbols(t);
    if (l)
      o = o.filter(function (l) {
        return Object.getOwnPropertyDescriptor(t, l).enumerable;
      });
    n.push.apply(n, o);
  }

  return n;
}

function s(t) {
  for (var n = 1; n < arguments.length; n++) {
    var o = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      c(Object(o), true).forEach(function (n) {
        module50.default(t, n, o[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      c(Object(o)).forEach(function (l) {
        Object.defineProperty(t, l, Object.getOwnPropertyDescriptor(o, l));
      });
  }

  return t;
}

var f = function (t) {
  var l = t.parentState,
    c = t.labelBackground,
    f = t.labelProps,
    b = f.label,
    y = f.error,
    O = f.onLayoutAnimatedText,
    v = f.hasActiveOutline,
    P = f.activeColor,
    j = f.placeholderStyle,
    h = f.baseLabelTranslateX,
    S = f.baseLabelTranslateY,
    R = f.font,
    _ = f.fontSize,
    L = f.fontWeight,
    w = f.placeholderOpacity,
    E = f.wiggleOffsetX,
    N = f.labelScale,
    D = f.topPosition,
    T = f.paddingOffset,
    X = f.placeholderColor,
    k = f.errorColor,
    x = {
      transform: [
        {
          translateX: l.labeled.interpolate({
            inputRange: [0, 1],
            outputRange: [h, 0],
          }),
        },
      ],
    },
    A = s({}, R, {
      fontSize: _,
      fontWeight: L,
      transform: [
        {
          translateX: l.error.interpolate({
            inputRange: [0, 0.5, 1],
            outputRange: [0, l.value && y ? E : 0, 0],
          }),
        },
        {
          translateY: l.labeled.interpolate({
            inputRange: [0, 1],
            outputRange: [S, 0],
          }),
        },
        {
          scale: l.labeled.interpolate({
            inputRange: [0, 1],
            outputRange: [N, 1],
          }),
        },
      ],
    });
  return b
    ? React.default.createElement(
        ReactNative.Animated.View,
        {
          pointerEvents: 'none',
          style: [
            ReactNative.StyleSheet.absoluteFill,
            {
              opacity: l.value || l.focused ? (l.labelLayout.measured ? 1 : 0) : 1,
            },
            x,
          ],
          __source: {
            fileName: p,
            lineNumber: 75,
          },
        },
        null === c || undefined === c
          ? undefined
          : c({
              parentState: l,
              labelStyle: A,
              labelProps: t.labelProps,
            }),
        React.default.createElement(
          module936.default,
          {
            onLayout: O,
            style: [
              j,
              {
                top: D,
              },
              A,
              T || {},
              {
                color: P,
                opacity: l.labeled.interpolate({
                  inputRange: [0, 1],
                  outputRange: [v ? 1 : 0, 0],
                }),
              },
            ],
            numberOfLines: 1,
            __source: {
              fileName: p,
              lineNumber: 96,
            },
          },
          b
        ),
        React.default.createElement(
          module936.default,
          {
            style: [
              j,
              {
                top: D,
              },
              A,
              T,
              {
                color: y && k ? k : X,
                opacity: w,
              },
            ],
            numberOfLines: 1,
            __source: {
              fileName: p,
              lineNumber: 117,
            },
          },
          b
        )
      )
    : null;
};

exports.default = f;
