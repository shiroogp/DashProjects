var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module760 = require('./760'),
  module961 = require('./961'),
  module962 = require('./962'),
  module963 = require('./963'),
  module964 = require('./964'),
  S = '/Users/trensik/dev/react-native-paper/src/components/TextInput/TextInputOutlined.tsx';

function T(t, o) {
  var l = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var n = Object.getOwnPropertySymbols(t);
    if (o)
      n = n.filter(function (o) {
        return Object.getOwnPropertyDescriptor(t, o).enumerable;
      });
    l.push.apply(l, n);
  }

  return l;
}

function I(t) {
  for (var o = 1; o < arguments.length; o++) {
    var l = null != arguments[o] ? arguments[o] : {};
    if (o % 2)
      T(Object(l), true).forEach(function (o) {
        module50.default(t, o, l[o]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(l));
    else
      T(Object(l)).forEach(function (o) {
        Object.defineProperty(t, o, Object.getOwnPropertyDescriptor(l, o));
      });
  }

  return t;
}

var L = (function (t) {
  function o() {
    module27.default(this, o);
    return module40.default(this, module37.default(o).apply(this, arguments));
  }

  module38.default(o, t);
  module28.default(o, [
    {
      key: 'render',
      value: function () {
        var t,
          o,
          l,
          u,
          c,
          s = this.props,
          p = s.disabled,
          f = s.editable,
          b = s.label,
          T = s.error,
          L = s.selectionColor,
          N = s.dense,
          A = s.style,
          w = s.theme,
          j = s.render,
          B = s.multiline,
          k = s.parentState,
          M = s.innerRef,
          D = s.onFocus,
          F = s.onBlur,
          z = s.onChangeText,
          Z = s.onLayoutAnimatedText,
          H = module56.default(s, [
            'disabled',
            'editable',
            'label',
            'error',
            'selectionColor',
            'underlineColor',
            'dense',
            'style',
            'theme',
            'render',
            'multiline',
            'parentState',
            'innerRef',
            'onFocus',
            'onBlur',
            'onChangeText',
            'onLayoutAnimatedText',
          ]),
          W = w.colors,
          R = w.fonts.regular,
          V = k.focused || T,
          X = ReactNative.StyleSheet.flatten(A) || {},
          G = X.fontSize,
          U = X.fontWeight,
          Y = X.height,
          q = X.backgroundColor,
          J = undefined === q ? W.background : q,
          K = module56.default(X, ['fontSize', 'fontWeight', 'height', 'backgroundColor']),
          Q = G || module963.MAXIMIZED_LABEL_FONT_SIZE;

        if (p) {
          t = o = module760.default(W.text).alpha(0.54).rgb().string();
          u = l = W.disabled;
        } else {
          t = W.text;
          o = T ? W.error : W.primary;
          u = l = W.placeholder;
          c = W.error;
        }

        var $ = module963.MINIMIZED_LABEL_FONT_SIZE / Q,
          ee = module963.MAXIMIZED_LABEL_FONT_SIZE / Q,
          te = k.labelLayout.width,
          re = k.labelLayout.height,
          oe = te / 2,
          le = re / 2,
          ne = (ReactNative.I18nManager.isRTL ? 1 : -1) * (oe - ($ * te) / 2 - (Q - module963.MINIMIZED_LABEL_FONT_SIZE) * $),
          ae = (N ? 48 : 64) - 8,
          ie = module964.calculateInputHeight(re, Y, ae),
          ue = module964.calculateLabelTopPosition(re, ie, 8);
        if (Y && 'number' != typeof Y) console.warn('Currently we support only numbers in height prop');
        var de = {
            height: Y ? +Y : null,
            labelHalfHeight: le,
            offset: 8,
            multiline: B || null,
            dense: N || null,
            topPosition: ue,
            fontSize: Q,
            label: b,
            scale: ee,
            isAndroid: 'android' === ReactNative.Platform.OS,
            styles: ReactNative.StyleSheet.flatten(N ? x.inputOutlinedDense : x.inputOutlined),
          },
          ce = module964.calculatePadding(de),
          se = module964.adjustPaddingOut(
            I({}, de, {
              pad: ce,
            })
          ),
          pe = -le - (ue + -6),
          fe = {
            label: b,
            onLayoutAnimatedText: Z,
            placeholderOpacity: module964.interpolatePlaceholder(k.labeled, V),
            error: T,
            placeholderStyle: x.placeholder,
            baseLabelTranslateY: pe,
            baseLabelTranslateX: ne,
            font: R,
            fontSize: Q,
            fontWeight: U,
            labelScale: $,
            wiggleOffsetX: module963.LABEL_WIGGLE_X_OFFSET,
            topPosition: ue,
            hasActiveOutline: V,
            activeColor: o,
            placeholderColor: u,
            backgroundColor: J,
            errorColor: c,
          },
          be = Y || (N ? 48 : 64);
        return (
          <ReactNative.View
            style={K}
            __source={{
              fileName: S,
              lineNumber: 183,
            }}
          >
            <ReactNative.View
              __source={{
                fileName: S,
                lineNumber: 189,
              }}
            >
              <P
                theme={w}
                hasActiveOutline={V}
                activeColor={o}
                outlineColor={l}
                backgroundColor={J}
                __source={{
                  fileName: S,
                  lineNumber: 190,
                }}
              />
              <ReactNative.View
                style={{
                  paddingTop: 8,
                  paddingBottom: 0,
                  minHeight: be,
                }}
                __source={{
                  fileName: S,
                  lineNumber: 197,
                }}
              >
                <module961.default
                  parentState={k}
                  labelProps={fe}
                  labelBackground={module962.default}
                  __source={{
                    fileName: S,
                    lineNumber: 204,
                  }}
                />
                {null === j || undefined === j
                  ? undefined
                  : j(
                      I({}, H, {
                        ref: M,
                        onChangeText: z,
                        placeholder: b ? k.placeholder : this.props.placeholder,
                        placeholderTextColor: u,
                        editable: !p && f,
                        selectionColor: undefined === L ? o : L,
                        onFocus: D,
                        onBlur: F,
                        underlineColorAndroid: 'transparent',
                        multiline: B,
                        style: [
                          x.input,
                          !B || (B && Y)
                            ? {
                                height: ie,
                              }
                            : {},
                          se,
                          I({}, R, {
                            fontSize: Q,
                            fontWeight: U,
                            color: t,
                            textAlignVertical: B ? 'top' : 'center',
                          }),
                        ],
                      })
                    )}
              </ReactNative.View>
            </ReactNative.View>
          </ReactNative.View>
        );
      },
    },
  ]);
  return o;
})(React.Component);

module50.default(L, 'defaultProps', {
  disabled: false,
  error: false,
  multiline: false,
  editable: true,
  render: function (t) {
    return <ReactNative.TextInput />;
  },
});
var N = L;
exports.default = N;

var P = function (t) {
    var o = t.theme,
      l = t.hasActiveOutline,
      n = t.activeColor,
      u = t.outlineColor,
      c = t.backgroundColor;
    return (
      <ReactNative.View
        pointerEvents="none"
        style={[
          x.outline,
          {
            backgroundColor: c,
            borderRadius: o.roundness,
            borderWidth: l ? 2 : 1,
            borderColor: l ? n : u,
          },
        ]}
        __source={{
          fileName: S,
          lineNumber: 266,
        }}
      />
    );
  },
  x = ReactNative.StyleSheet.create({
    placeholder: {
      position: 'absolute',
      left: 0,
      paddingHorizontal: 14,
    },
    outline: {
      position: 'absolute',
      left: 0,
      right: 0,
      top: 6,
      bottom: 0,
    },
    input: {
      flexGrow: 1,
      paddingHorizontal: 14,
      margin: 0,
      textAlign: ReactNative.I18nManager.isRTL ? 'right' : 'left',
      zIndex: 1,
    },
    inputOutlined: {
      paddingTop: 8,
      paddingBottom: 8,
    },
    inputOutlinedDense: {
      paddingTop: 4,
      paddingBottom: 4,
    },
  });
