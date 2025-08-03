var module50 = require('./50');

function o(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var l = Object.getOwnPropertySymbols(t);
    if (n)
      l = l.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, l);
  }

  return o;
}

function l(t) {
  for (var l = 1; l < arguments.length; l++) {
    var c = null != arguments[l] ? arguments[l] : {};
    if (l % 2)
      o(Object(c), true).forEach(function (o) {
        module50.default(t, o, c[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(c));
    else
      o(Object(c)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(c, n));
      });
  }

  return t;
}

var module79 = {
  uiViewClassName: 'AndroidTextInput',
  bubblingEventTypes: {
    topTextInput: {
      phasedRegistrationNames: {
        bubbled: 'onTextInput',
        captured: 'onTextInputCapture',
      },
    },
  },
  directEventTypes: {},
  validAttributes: l(
    l({}, require('./190').default.validAttributes),
    {},
    {
      maxFontSizeMultiplier: true,
      placeholder: true,
      inlineImagePadding: true,
      contextMenuHidden: true,
      textShadowColor: {
        process: require('./79'),
      },
      maxLength: true,
      selectTextOnFocus: true,
      textShadowRadius: true,
      underlineColorAndroid: {
        process: require('./79'),
      },
      textDecorationLine: true,
      blurOnSubmit: true,
      textAlignVertical: true,
      fontStyle: true,
      textShadowOffset: true,
      selectionColor: {
        process: require('./79'),
      },
      selection: true,
      placeholderTextColor: {
        process: require('./79'),
      },
      importantForAutofill: true,
      lineHeight: true,
      textTransform: true,
      returnKeyType: true,
      keyboardType: true,
      multiline: true,
      color: true,
      autoCompleteType: true,
      numberOfLines: true,
      letterSpacing: true,
      returnKeyLabel: true,
      fontSize: true,
      onKeyPress: true,
      cursorColor: {
        process: require('./79'),
      },
      text: true,
      showSoftInputOnFocus: true,
      textAlign: true,
      autoCapitalize: true,
      autoCorrect: true,
      caretHidden: true,
      secureTextEntry: true,
      textBreakStrategy: true,
      onScroll: true,
      onContentSizeChange: true,
      disableFullscreenUI: true,
      includeFontPadding: true,
      fontWeight: true,
      fontFamily: true,
      allowFontScaling: true,
      onSelectionChange: true,
      mostRecentEventCount: true,
      inlineImageLeft: true,
      editable: true,
      fontVariant: true,
    }
  ),
};
module.exports = module79;
