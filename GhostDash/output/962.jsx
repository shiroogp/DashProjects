var module23 = require("@babel/runtime/helpers/toConsumableArray"),
    React = require("react"),
    ReactNative = require("react-native"),
    module936 = require("./936"),
    p = "/Users/trensik/dev/react-native-paper/src/components/TextInput/Label/LabelBackground.tsx",
    c = function (t) {
  var l = t.parentState,
      c = t.labelProps,
      f = c.placeholderStyle,
      v = c.baseLabelTranslateX,
      y = c.topPosition,
      k = c.hasActiveOutline,
      _ = c.label,
      h = c.backgroundColor,
      S = t.labelStyle,
      L = k || l.value,
      R = l.labeled.interpolate({
    inputRange: [0, 1],
    outputRange: [L ? 1 : 0, 0]
  }),
      w = {
    transform: [{
      translateX: l.labeled.interpolate({
        inputRange: [0, 1],
        outputRange: [-v, 0]
      })
    }]
  };
  return _ ? [{React.createElement(ReactNative.Animated.View, {
    key: "labelBackground-view",
    pointerEvents: "none",
    style: [ReactNative.StyleSheet.absoluteFill, b.view, {
      backgroundColor: h,
      opacity: R
    }, w],
    __source: {
      fileName: p,
      lineNumber: 39
    }
  })}, React.createElement(module936.default, {
    key: "labelBackground-text",
    style: [f, S, b.outlinedLabel, {
      top: y + 1,
      backgroundColor: h,
      opacity: R,
      transform: [].concat(module23.default(S.transform), [{
        scaleY: l.labeled.interpolate({
          inputRange: [0, 1],
          outputRange: [.2, 1]
        })
      }])
    }],
    numberOfLines: 1,
    __source: {
      fileName: p,
      lineNumber: 52
    }
  }, _)] : null;
};

exports.default = c;
var b = ReactNative.StyleSheet.create({
  view: {
    position: 'absolute',
    top: 6,
    left: 10,
    width: 8,
    height: 2
  },
  outlinedLabel: {
    position: 'absolute',
    left: 18,
    paddingHorizontal: 0,
    color: 'transparent'
  }
});