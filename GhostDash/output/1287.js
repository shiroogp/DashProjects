exports.HoloColorPicker = (function (t) {
  function o(o, n) {
    var l = t.call(this, o, n) || this;

    l._handleColorChange = function (t) {
      var o = t.x,
        n = t.y,
        s = l._getColor(),
        c = s.s,
        h = s.v,
        u = (l._layout.width - l.state.pickerSize) / 2,
        p = (l._layout.height - l.state.pickerSize) / 2,
        C = o - l._pageX - u,
        f = n - l._pageY - p,
        _ = l._computeHValue(C, f);

      l._onColorChange({
        h: _,
        s: c,
        v: h,
      });

      return true;
    };

    var u = {
      color: {
        h: 0,
        s: 1,
        v: 1,
      },
      pickerSize: null,
    };
    if (o.oldColor) u.color = module1286.default(o.oldColor).toHsv();
    if (o.defaultColor) u.color = module1286.default(o.defaultColor).toHsv();
    l.state = u;
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
      onStart: l._handleColorChange,
      onMove: l._handleColorChange,
    });
    return l;
  }

  u(o, t);

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
      c = n.height,
      h = l ** c;
    if (this.state.pickerSize !== h)
      this.setState({
        pickerSize: h,
      });
    ReactNative.InteractionManager.runAfterInteractions(function () {
      if (o.refs.pickerContainer)
        o.refs.pickerContainer.measure(function (t, n, l, s, c, h) {
          o._pageX = c;
          o._pageY = h;
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

  o.prototype._getSlider = function () {
    if (!this.props.hideSliders) {
      if (this.props.sliderComponent) return this.props.sliderComponent;
      if (!ReactNative.Slider)
        throw new Error('You need to install `@react-native-community/slider` and pass it (or any other Slider compatible component) as `sliderComponent` prop');
      return ReactNative.Slider;
    }
  };

  o.prototype.getColor = function () {
    return module1286.default(this._getColor()).toHexString();
  };

  o.prototype.render = function () {
    var t = this.state.pickerSize,
      o = this.props,
      h = o.oldColor,
      u = o.style,
      f = this._getColor(),
      _ = f.h,
      y = f.s,
      v = f.v,
      S = this._hValueToRad(_),
      w = module1286.default(f).toHexString(),
      k = module1286
        .default({
          h: _,
          s: 1,
          v: 1,
        })
        .toHexString(),
      b = p({
        pickerSize: t,
        selectedColor: w,
        indicatorColor: k,
        oldColor: h,
        angle: S,
        isRTL: this._isRTL,
      }),
      P = this._getSlider();

    return React.default.createElement(
      ReactNative.View,
      {
        style: u,
      },
      React.default.createElement(
        ReactNative.View,
        {
          onLayout: this._onLayout,
          ref: 'pickerContainer',
          style: C.pickerContainer,
        },
        t
          ? React.default.createElement(
              ReactNative.View,
              null,
              React.default.createElement(
                ReactNative.View,
                module14.default({}, this._pickerResponder.panHandlers, {
                  style: [b.picker],
                  collapsable: false,
                }),
                React.default.createElement(ReactNative.Image, {
                  source: require('./1288'),
                  resizeMode: 'contain',
                  style: [C.pickerImage],
                }),
                React.default.createElement(ReactNative.View, {
                  style: [C.pickerIndicator, b.pickerIndicator],
                })
              ),
              h &&
                React.default.createElement(ReactNative.TouchableOpacity, {
                  style: [C.selectedPreview, b.selectedPreview],
                  onPress: this._onColorSelected,
                  activeOpacity: 0.7,
                }),
              h &&
                React.default.createElement(ReactNative.TouchableOpacity, {
                  style: [C.originalPreview, b.originalPreview],
                  onPress: this._onOldColorSelected,
                  activeOpacity: 0.7,
                }),
              !h &&
                React.default.createElement(ReactNative.TouchableOpacity, {
                  style: [C.selectedFullPreview, b.selectedFullPreview],
                  onPress: this._onColorSelected,
                  activeOpacity: 0.7,
                })
            )
          : null
      ),
      this.props.hideSliders
        ? null
        : React.default.createElement(
            ReactNative.View,
            null,
            React.default.createElement(P, {
              value: y,
              onValueChange: this._onSValueChange,
            }),
            React.default.createElement(P, {
              value: v,
              onValueChange: this._onVValueChange,
            })
          )
    );
  };

  return o;
})(React.default.PureComponent);

var o,
  module14 = require('./14'),
  React = require('react'),
  ReactNative = require('react-native'),
  module1286 = require('./1286'),
  module1285 = require('./1285'),
  u =
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
    }),
  p = function (t) {
    var o,
      n = t.indicatorColor,
      l = t.selectedColor,
      s = t.oldColor,
      c = t.angle,
      h = t.pickerSize,
      u = t.isRTL,
      p = 0.5 * h,
      C = 0.08235294117647059 * h,
      f = C / 3,
      _ = h / 2 - C / 2 - f,
      y = h / 2,
      v = h / 2,
      S = Math.cos(c) * _,
      w = Math.sin(c) * _;

    return {
      picker: {
        padding: f,
        width: h,
        height: h,
      },
      pickerIndicator:
        ((o = {
          top: y + S - C / 2,
        }),
        (o[u ? 'right' : 'left'] = v + w - C / 2),
        (o.width = C),
        (o.height = C),
        (o.borderRadius = C / 2),
        (o.backgroundColor = n),
        o),
      selectedPreview: {
        width: p / 2,
        height: p,
        top: h / 2 - p / 2,
        left: Math.floor(h / 2),
        borderTopRightRadius: p / 2,
        borderBottomRightRadius: p / 2,
        backgroundColor: l,
      },
      originalPreview: {
        width: Math.ceil(p / 2),
        height: p,
        top: h / 2 - p / 2,
        left: h / 2 - p / 2,
        borderTopLeftRadius: p / 2,
        borderBottomLeftRadius: p / 2,
        backgroundColor: s,
      },
      selectedFullPreview: {
        width: p,
        height: p,
        top: h / 2 - p / 2,
        left: h / 2 - p / 2,
        borderRadius: p / 2,
        backgroundColor: l,
      },
    };
  },
  C = ReactNative.StyleSheet.create({
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
      shadowColor: 'black',
      shadowOpacity: 0.3,
      shadowOffset: {
        width: 3,
        height: 3,
      },
      shadowRadius: 4,
      elevation: 5,
    },
    selectedPreview: {
      position: 'absolute',
      borderLeftWidth: 0,
    },
    originalPreview: {
      position: 'absolute',
      borderRightWidth: 0,
    },
    selectedFullPreview: {
      position: 'absolute',
    },
    pickerAlignment: {
      alignItems: 'center',
    },
  });
