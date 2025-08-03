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
  module963 = require('./963'),
  module964 = require('./964'),
  T = '/Users/trensik/dev/react-native-paper/src/components/TextInput/TextInputFlat.tsx';

function L(t, n) {
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

function C(t) {
  for (var n = 1; n < arguments.length; n++) {
    var o = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      L(Object(o), true).forEach(function (n) {
        module50.default(t, n, o[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      L(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

var E = (function (t) {
  function n() {
    module27.default(this, n);
    return module40.default(this, module37.default(n).apply(this, arguments));
  }

  module38.default(n, t);
  module28.default(n, [
    {
      key: 'render',
      value: function () {
        var t,
          n,
          o,
          u,
          s,
          p = this.props,
          c = p.disabled,
          f = p.editable,
          b = p.label,
          L = p.error,
          E = p.selectionColor,
          I = p.underlineColor,
          N = p.dense,
          x = p.style,
          w = p.theme,
          F = p.render,
          j = p.multiline,
          z = p.parentState,
          B = p.innerRef,
          D = p.onFocus,
          H = p.onBlur,
          k = p.onChangeText,
          M = p.onLayoutAnimatedText,
          R = module56.default(p, [
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
          Z = w.colors,
          W = w.fonts.regular,
          X = z.focused || L,
          G = ReactNative.StyleSheet.flatten(x) || {},
          V = G.fontSize,
          Y = G.fontWeight,
          U = G.height,
          q = G.paddingHorizontal,
          J = module56.default(G, ['fontSize', 'fontWeight', 'height', 'paddingHorizontal']),
          K = V || module963.MAXIMIZED_LABEL_FONT_SIZE,
          Q =
            undefined !== q && 'number' == typeof q
              ? {
                  paddingHorizontal: q,
                }
              : ReactNative.StyleSheet.flatten(A.paddingOffset);

        if (c) {
          t = n = module760.default(Z.text).alpha(0.54).rgb().string();
          u = Z.disabled;
          o = 'transparent';
        } else {
          t = Z.text;
          n = L ? Z.error : Z.primary;
          u = Z.placeholder;
          s = Z.error;
          o = I || Z.disabled;
        }

        var $ = {
            backgroundColor: w.dark ? module760.default(Z.background).lighten(0.24).rgb().string() : module760.default(Z.background).darken(0.06).rgb().string(),
            borderTopLeftRadius: w.roundness,
            borderTopRightRadius: w.roundness,
          },
          ee = module963.MINIMIZED_LABEL_FONT_SIZE / K,
          te = module963.MAXIMIZED_LABEL_FONT_SIZE / K,
          re = z.labelLayout.width,
          ne = z.labelLayout.height,
          oe = re / 2,
          le = ne / 2,
          ae = (ReactNative.I18nManager.isRTL ? 1 : -1) * (oe - (ee * re) / 2) + (1 - ee) * Q.paddingHorizontal,
          ie = N ? (b ? 52 : 40) - 24 : 34,
          de = module964.calculateInputHeight(ne, U, ie),
          ue = module964.calculateLabelTopPosition(ne, de, j && U ? 0 : U ? 0 : ie / 2);
        if (U && 'number' != typeof U) console.warn('Currently we support only numbers in height prop');
        var se = {
            height: U ? +U : null,
            labelHalfHeight: le,
            offset: 8,
            multiline: j || null,
            dense: N || null,
            topPosition: ue,
            fontSize: K,
            label: b,
            scale: te,
            isAndroid: 'android' === ReactNative.Platform.OS,
            styles: ReactNative.StyleSheet.flatten(N ? A.inputFlatDense : A.inputFlat),
          },
          pe = module964.calculatePadding(se),
          ce = module964.adjustPaddingFlat(
            C({}, se, {
              pad: pe,
            })
          ),
          fe = -le - (ue + -18),
          ge = {
            label: b,
            onLayoutAnimatedText: M,
            placeholderOpacity: X ? module964.interpolatePlaceholder(z.labeled, X) : z.labelLayout.measured ? 1 : 0,
            error: L,
            placeholderStyle: A.placeholder,
            baseLabelTranslateY: fe,
            baseLabelTranslateX: ae,
            font: W,
            fontSize: K,
            fontWeight: Y,
            labelScale: ee,
            wiggleOffsetX: module963.LABEL_WIGGLE_X_OFFSET,
            topPosition: ue,
            paddingOffset: Q,
            hasActiveOutline: X,
            activeColor: n,
            placeholderColor: u,
            errorColor: s,
          },
          be = U || (N ? (b ? 52 : 40) : 64),
          he = de + (U ? 0 : N ? 24 : 30);
        return (
          <ReactNative.View
            style={[$, J]}
            __source={{
              fileName: T,
              lineNumber: 222,
            }}
          >
            <P
              parentState={z}
              underlineColorCustom={o}
              error={L}
              colors={Z}
              activeColor={n}
              __source={{
                fileName: T,
                lineNumber: 223,
              }}
            />
            <ReactNative.View
              style={{
                paddingTop: 0,
                paddingBottom: 0,
                minHeight: be,
              }}
              __source={{
                fileName: T,
                lineNumber: 230,
              }}
            >
              <module961.default
                parentState={z}
                labelProps={ge}
                __source={{
                  fileName: T,
                  lineNumber: 237,
                }}
              />
              {null === F || undefined === F
                ? undefined
                : F(
                    C({}, R, {
                      ref: B,
                      onChangeText: k,
                      placeholder: b ? z.placeholder : this.props.placeholder,
                      placeholderTextColor: u,
                      editable: !c && f,
                      selectionColor: undefined === E ? n : E,
                      onFocus: D,
                      onBlur: H,
                      underlineColorAndroid: 'transparent',
                      multiline: j,
                      style: [
                        A.input,
                        Q,
                        !j || (j && U)
                          ? {
                              height: he,
                            }
                          : {},
                        ce,
                        C({}, W, {
                          fontSize: K,
                          fontWeight: Y,
                          color: t,
                          textAlignVertical: j ? 'top' : 'center',
                        }),
                      ],
                    })
                  )}
            </ReactNative.View>
          </ReactNative.View>
        );
      },
    },
  ]);
  return n;
})(React.Component);

module50.default(E, 'defaultProps', {
  disabled: false,
  error: false,
  multiline: false,
  editable: true,
  render: function (t) {
    return <ReactNative.TextInput />;
  },
});
var I = E;
exports.default = I;

var P = function (t) {
    var n = t.parentState,
      o = t.error,
      l = t.colors,
      u = t.activeColor,
      s = t.underlineColorCustom,
      p = n.focused ? u : s;
    if (o) p = l.error;
    return React.createElement(ReactNative.Animated.View, {
      style: [
        A.underline,
        {
          backgroundColor: p,
          transform: [
            {
              scaleY: n.focused ? 1 : 0.5,
            },
          ],
        },
      ],
      __source: {
        fileName: T,
        lineNumber: 303,
      },
    });
  },
  A = ReactNative.StyleSheet.create({
    placeholder: {
      position: 'absolute',
      left: 0,
    },
    underline: {
      position: 'absolute',
      left: 0,
      right: 0,
      bottom: 0,
      height: 2,
    },
    input: {
      flexGrow: 1,
      margin: 0,
      textAlign: ReactNative.I18nManager.isRTL ? 'right' : 'left',
      zIndex: 1,
    },
    inputFlat: {
      paddingTop: 24,
      paddingBottom: 4,
    },
    inputFlatDense: {
      paddingTop: 22,
      paddingBottom: 2,
    },
    paddingOffset: {
      paddingHorizontal: module963.LABEL_PADDING_HORIZONTAL,
    },
  });
