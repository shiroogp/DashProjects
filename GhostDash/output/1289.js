var o,
  module14 = require('./14'),
  React = require('react'),
  ReactNative = require('react-native'),
  module1286 = require('./1286'),
  module1285 = require('./1285'),
  p =
    (this && this.__extends) ||
    ((o = function (t, n) {
      return (o =
        Object.setPrototypeOf ||
        ({
          __proto__: [],
        } instanceof Array &&
          function (t, o) {
            t.__proto__ = o;
          }) ||
        function (t, o) {
          for (var n in o) o.hasOwnProperty(n) && (t[n] = o[n]);
        })(t, n);
    }),
    function (t, n) {
      function l() {
        this.constructor = t;
      }

      o(t, n);
      t.prototype = null === n ? Object.create(n) : ((l.prototype = n.prototype), new l());
    });

function u(t, o) {
  var n = t.rotationHackFactor;
  if (!(n < 1)) return 'r' + Math.floor(o * n);
}

exports.TriangleColorPicker = (function (t) {
  function o(o, n) {
    var l = t.call(this, o, n) || this;

    l._handleColorChange = function (t) {
      var o = t.x,
        n = t.y;
      if (l._changingHColor)
        l._handleHColorChange({
          x: o,
          y: n,
        });
      else
        l._handleSVColorChange({
          x: o,
          y: n,
        });
      return true;
    };

    var p = {
      color: {
        h: 0,
        s: 1,
        v: 1,
      },
      pickerSize: null,
    };
    if (o.oldColor) p.color = module1286.default(o.oldColor).toHsv();
    if (o.defaultColor) p.color = module1286.default(o.defaultColor).toHsv();
    l.state = p;
    l._layout = {
      width: 0,
      height: 0,
      x: 0,
      y: 0,
    };
    l._pageX = 0;
    l._pageY = 0;
    l._onLayout = l._onLayout.bind(l);
    l._onSValueChange = l._onSValueChange.bind(l);
    l._onVValueChange = l._onVValueChange.bind(l);
    l._onColorSelected = l._onColorSelected.bind(l);
    l._onOldColorSelected = l._onOldColorSelected.bind(l);
    l._isRTL = ReactNative.I18nManager.isRTL;
    l._pickerResponder = module1285.createPanResponder({
      onStart: function (t) {
        var o = t.x,
          n = t.y,
          s = l._computeColorFromTriangle({
            x: o,
            y: n,
          }),
          h = s.s,
          c = s.v;

        l._changingHColor = h > 1 || h < 0 || c > 1 || c < 0;

        l._handleColorChange({
          x: o,
          y: n,
        });

        return true;
      },
      onMove: l._handleColorChange,
    });
    return l;
  }

  p(o, t);

  o.prototype._getColor = function () {
    return ('string' == typeof this.props.color ? module1286.default(this.props.color).toHsv() : this.props.color) || this.state.color;
  };

  o.prototype._onColorSelected = function () {
    var t = this.props.onColorSelected,
      o = module1286.default(this._getColor()).toHexString();
    if (t) t(o);
  };

  o.prototype._onOldColorSelected = function () {
    var t = this.props,
      o = t.oldColor,
      n = t.onOldColorSelected,
      l = module1286.default(o);
    this.setState({
      color: l.toHsv(),
    });
    if (n) n(l.toHexString());
  };

  o.prototype._onSValueChange = function (t) {
    var o = this._getColor(),
      n = o.h,
      l = o.v;

    this._onColorChange({
      h: n,
      s: t,
      v: l,
    });
  };

  o.prototype._onVValueChange = function (t) {
    var o = this._getColor(),
      n = o.h,
      l = o.s;

    this._onColorChange({
      h: n,
      s: l,
      v: t,
    });
  };

  o.prototype._onColorChange = function (t) {
    this.setState({
      color: t,
    });
    if (this.props.onColorChange) this.props.onColorChange(t);
  };

  o.prototype._onLayout = function (t) {
    var o = this;
    this._layout = t.nativeEvent.layout;
    var n = this._layout,
      l = n.width,
      h = n.height,
      c = l ** h;
    if (this.state.pickerSize !== c)
      this.setState({
        pickerSize: c,
      });
    ReactNative.InteractionManager.runAfterInteractions(function () {
      if (o.refs.pickerContainer)
        o.refs.pickerContainer.measure(function (t, n, l, s, h, c) {
          o._pageX = h;
          o._pageY = c;
        });
    });
  };

  o.prototype._computeHValue = function (t, o) {
    var n = t - this.state.pickerSize / 2,
      l = o - this.state.pickerSize / 2;
    return ((180 * (n ** l + Math.PI + Math.PI / 2)) / Math.PI) % 360;
  };

  o.prototype._hValueToRad = function (t) {
    return (t * Math.PI) / 180 - Math.PI - Math.PI / 2;
  };

  o.prototype.getColor = function () {
    return module1286.default(this._getColor()).toHexString();
  };

  o.prototype._handleHColorChange = function (t) {
    var o = t.x,
      n = t.y,
      l = this._getColor(),
      s = l.s,
      h = l.v,
      c = (this._layout.width - this.state.pickerSize) / 2,
      p = (this._layout.height - this.state.pickerSize) / 2,
      u = o - this._pageX - c,
      C = n - this._pageY - p,
      y = this._computeHValue(u, C);

    this._onColorChange({
      h: y,
      s: s,
      v: h,
    });
  };

  o.prototype._handleSVColorChange = function (t) {
    var o = t.x,
      n = t.y,
      l = this._computeColorFromTriangle({
        x: o,
        y: n,
      }),
      s = l.h,
      h = l.s,
      c = l.v,
      p = (0 ** h) ** 1,
      u = (0 ** c) ** 1;

    this._onColorChange({
      h: s,
      s: p,
      v: u,
    });
  };

  o.prototype._normalizeTriangleTouch = function (t, o, n) {
    var l = 0.1,
      s = t > 1 ? (o > 0 ? 1 - (1 - t) * n : 1 - t * n) : o > 0 ? t * n : (1 - t) * n;
    if (t > 0.88 && o > 0.88)
      return {
        s: t,
        v: o,
      };
    else {
      if ((s < 0.12 && o > 0.88) || (s < 0.12 && o < 0.12)) l = 0.05;
      return {
        s: (t = (t = t < 0 && s > 0 - l ? 0 : t) > 1 && s < 1 + l ? 1 : t),
        v: (o = (o = o < 0 && o > 0 - l ? 0 : o) > 1 && o < 1 + l ? 1 : o),
      };
    }
  };

  o.prototype._computeColorFromTriangle = function (t) {
    var o = t.x,
      n = t.y,
      l = this.state.pickerSize,
      s = C(l),
      h = s.triangleHeight,
      p = s.triangleWidth,
      u = l / 2 - p / 2,
      y = l / 2 - (2 * h) / 3,
      f = (this._layout.width - this.state.pickerSize) / 2,
      _ = (this._layout.height - this.state.pickerSize) / 2,
      v = o - this._pageX - f - u,
      k = n - this._pageY - _ - y,
      S = this._getColor().h,
      I = (((S - 330 + 360) % 360) * Math.PI) / 180,
      w = {
        x: p / 2,
        y: (2 * h) / 3,
      },
      b = module1285.rotatePoint(
        {
          x: v,
          y: k,
        },
        I,
        w
      ),
      P = (p * b.y) / h,
      x = p / 2 - ((p / 2) * b.y) / h,
      V = (b.x - x) / P,
      M = b.y / h,
      H = this._normalizeTriangleTouch(V, M, P / h);

    return {
      h: S,
      s: H.s,
      v: H.v,
    };
  };

  o.prototype.render = function () {
    var t = this.state.pickerSize,
      o = this.props,
      c = o.oldColor,
      p = o.style,
      C = this._getColor(),
      _ = C.h,
      v = this._hValueToRad(_),
      k = module1286.default(C).toHexString(),
      S = module1286
        .default({
          h: _,
          s: 1,
          v: 1,
        })
        .toHexString(),
      I = y({
        pickerSize: t,
        selectedColorHsv: C,
        indicatorColor: S,
        angle: v,
        isRTL: this._isRTL,
      }),
      w = u(this.props, v);

    return React.default.createElement(
      ReactNative.View,
      {
        style: p,
      },
      React.default.createElement(
        ReactNative.View,
        {
          onLayout: this._onLayout,
          ref: 'pickerContainer',
          style: f.pickerContainer,
        },
        t
          ? React.default.createElement(
              ReactNative.View,
              null,
              React.default.createElement(
                ReactNative.View,
                {
                  key: w,
                  style: [f.triangleContainer, I.triangleContainer],
                },
                React.default.createElement(ReactNative.View, {
                  style: [f.triangleUnderlayingColor, I.triangleUnderlayingColor],
                }),
                React.default.createElement(ReactNative.Image, {
                  style: [I.triangleImage],
                  source: require('./1290'),
                })
              ),
              React.default.createElement(
                ReactNative.View,
                module14.default({}, this._pickerResponder.panHandlers, {
                  style: [I.picker],
                  collapsable: false,
                }),
                React.default.createElement(ReactNative.Image, {
                  source: require('./1288'),
                  resizeMode: 'contain',
                  style: [f.pickerImage],
                }),
                React.default.createElement(
                  ReactNative.View,
                  {
                    key: w,
                    style: [f.pickerIndicator, I.pickerIndicator],
                  },
                  React.default.createElement(ReactNative.View, {
                    style: [f.pickerIndicatorTick, I.pickerIndicatorTick],
                  })
                ),
                React.default.createElement(ReactNative.View, {
                  style: [f.svIndicator, I.svIndicator],
                })
              )
            )
          : null
      ),
      1 == this.props.hideControls
        ? null
        : React.default.createElement(
            ReactNative.View,
            {
              style: [f.colorPreviews, I.colorPreviews],
            },
            c &&
              React.default.createElement(ReactNative.TouchableOpacity, {
                style: [
                  f.colorPreview,
                  {
                    backgroundColor: c,
                  },
                ],
                onPress: this._onOldColorSelected,
                activeOpacity: 0.7,
              }),
            React.default.createElement(ReactNative.TouchableOpacity, {
              style: [
                f.colorPreview,
                {
                  backgroundColor: k,
                },
              ],
              onPress: this._onColorSelected,
              activeOpacity: 0.7,
            })
          )
    );
  };

  o.defaultProps = {
    rotationHackFactor: 100,
  };
  return o;
})(React.default.PureComponent);

function C(t) {
  var o = 0.08235294117647059 * t,
    n = o,
    l = o / 3,
    s = t - 6 * l,
    h = s / 2;
  return {
    triangleSize: s,
    triangleRadius: h,
    triangleHeight: (3 * h) / 2,
    triangleWidth: 2 * h * Math.sqrt(0.75),
    indicatorPickerRatio: 0.08235294117647059,
    indicatorSize: n,
    pickerPadding: l,
  };
}

var y = function (t) {
    var o,
      n,
      l = t.indicatorColor,
      s = t.angle,
      h = t.pickerSize,
      p = t.selectedColorHsv,
      u = t.isRTL,
      y = C(h),
      f = y.triangleSize,
      _ = y.triangleHeight,
      v = y.triangleWidth,
      k = y.indicatorSize,
      S = y.pickerPadding,
      I = h / 2 - k / 2 - S,
      w = h / 2,
      b = h / 2,
      P = Math.cos(s) * I,
      x = Math.sin(s) * I,
      V = 3 * S,
      M = 3 * S,
      H = -s + Math.PI / 3,
      T = p.s,
      z = p.v,
      E = z * _,
      R = v / 2 - z * (v / 2),
      O = T * (v - 2 * R) + R,
      L = (h - v) / 2,
      W = (h - (4 * _) / 3) / 2,
      j = (((p.h - 330 + 360) % 360) * Math.PI) / 180,
      F = {
        x: h / 2,
        y: h / 2,
      },
      U = {
        x: W + E,
        y: L + O,
      },
      X = module1285.rotatePoint(U, j, F);
    return {
      picker: {
        padding: S,
        width: h,
        height: h,
      },
      pickerIndicator:
        ((o = {
          top: w + P - k / 2,
        }),
        (o[u ? 'right' : 'left'] = b + x - k / 2),
        (o.width = k),
        (o.height = k),
        (o.transform = [
          {
            rotate: -s + 'rad',
          },
        ]),
        o),
      pickerIndicatorTick: {
        height: k / 2,
        backgroundColor: 'rgba(0,0,0,0.8)',
      },
      svIndicator:
        ((n = {
          top: X.x - 9,
        }),
        (n[u ? 'right' : 'left'] = X.y - 9),
        (n.width = 18),
        (n.height = 18),
        (n.borderRadius = 9),
        (n.borderColor = 'rgba(0,0,0,0.8)'),
        n),
      triangleContainer: {
        width: f,
        height: f,
        transform: [
          {
            rotate: H + 'rad',
          },
        ],
        top: V,
        left: M,
      },
      triangleImage: {
        width: v,
        height: _,
      },
      triangleUnderlayingColor: {
        left: (f - v) / 2,
        borderLeftWidth: v / 2,
        borderRightWidth: v / 2,
        borderBottomWidth: _,
        borderBottomColor: l,
      },
      colorPreviews: {
        height: 0.1 * h,
      },
    };
  },
  f = ReactNative.StyleSheet.create({
    pickerContainer: {
      flex: 1,
      alignItems: 'center',
      justifyContent: 'center',
    },
    pickerImage: {
      flex: 1,
      width: null,
      height: null,
    },
    pickerIndicator: {
      position: 'absolute',
      alignItems: 'center',
      justifyContent: 'center',
    },
    triangleContainer: {
      position: 'absolute',
      alignItems: 'center',
    },
    triangleUnderlayingColor: {
      position: 'absolute',
      top: 0,
      width: 0,
      height: 0,
      backgroundColor: 'transparent',
      borderStyle: 'solid',
      borderLeftColor: 'transparent',
      borderRightColor: 'transparent',
    },
    pickerAlignment: {
      alignItems: 'center',
    },
    svIndicator: {
      position: 'absolute',
      borderWidth: 4,
    },
    pickerIndicatorTick: {
      width: 5,
    },
    colorPreviews: {
      flexDirection: 'row',
    },
    colorPreview: {
      flex: 1,
    },
  });
