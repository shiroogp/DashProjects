var module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module42 = require('./42'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module904 = require('./904'),
  module901 = require('./901'),
  module788 = require('./788'),
  w = '/Users/trensik/dev/react-native-paper/src/components/Modal.tsx';

function O(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var s = Object.getOwnPropertySymbols(t);
    if (n)
      s = s.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, s);
  }

  return o;
}

var E = 220,
  P = (function (t, ...args) {
    function n() {
      var t, module28;
      module27.default(this, n);
      module28 = module40.default(this, (t = module37.default(n)).call.apply(t, [this].concat(args)));
      module50.default(module42.default(module28), 'state', {
        opacity: new ReactNative.Animated.Value(module28.props.visible ? 1 : 0),
        rendered: module28.props.visible,
      });
      module50.default(module42.default(module28), 'handleBack', function () {
        if (module28.props.dismissable) module28.hideModal();
        return true;
      });
      module50.default(module42.default(module28), 'showModal', function () {
        ReactNative.BackHandler.removeEventListener('hardwareBackPress', module28.handleBack);
        ReactNative.BackHandler.addEventListener('hardwareBackPress', module28.handleBack);
        var t = module28.state.opacity,
          n = module28.props.theme.animation.scale;
        ReactNative.Animated.timing(t, {
          toValue: 1,
          duration: n * E,
          easing: ReactNative.Easing.out(ReactNative.Easing.cubic),
          useNativeDriver: true,
        }).start();
      });
      module50.default(module42.default(module28), 'hideModal', function () {
        ReactNative.BackHandler.removeEventListener('hardwareBackPress', module28.handleBack);
        var t = module28.state.opacity,
          n = module28.props.theme.animation.scale;
        ReactNative.Animated.timing(t, {
          toValue: 0,
          duration: n * E,
          easing: ReactNative.Easing.out(ReactNative.Easing.cubic),
          useNativeDriver: true,
        }).start(function (t) {
          if (t.finished) {
            if (module28.props.visible && module28.props.onDismiss) module28.props.onDismiss();
            if (module28.props.visible) module28.showModal();
            else
              module28.setState({
                rendered: false,
              });
          }
        });
      });
      return module28;
    }

    module38.default(n, t);
    module28.default(
      n,
      [
        {
          key: 'componentDidUpdate',
          value: function (t) {
            if (t.visible !== this.props.visible) this.props.visible ? this.showModal() : this.hideModal();
          },
        },
        {
          key: 'componentWillUnmount',
          value: function () {
            ReactNative.BackHandler.removeEventListener('hardwareBackPress', this.handleBack);
          },
        },
        {
          key: 'render',
          value: function () {
            var t = this.state,
              n = t.rendered,
              o = t.opacity;
            if (!n) return null;
            var s = this.props,
              l = s.children,
              c = s.dismissable,
              u = s.theme,
              p = s.contentContainerStyle,
              f = u.colors;
            return React.createElement(
              ReactNative.Animated.View,
              {
                pointerEvents: this.props.visible ? 'auto' : 'none',
                accessibilityViewIsModal: true,
                accessibilityLiveRegion: 'polite',
                style: ReactNative.StyleSheet.absoluteFill,
                __source: {
                  fileName: w,
                  lineNumber: 184,
                },
              },
              React.createElement(
                ReactNative.TouchableWithoutFeedback,
                {
                  disabled: !c,
                  onPress: c ? this.hideModal : undefined,
                  __source: {
                    fileName: w,
                    lineNumber: 190,
                  },
                },
                React.createElement(ReactNative.Animated.View, {
                  style: [
                    _.backdrop,
                    {
                      backgroundColor: f.backdrop,
                      opacity: o,
                    },
                  ],
                  __source: {
                    fileName: w,
                    lineNumber: 194,
                  },
                })
              ),
              React.createElement(
                module904.default,
                {
                  style: _.wrapper,
                  pointerEvents: 'box-none',
                  __source: {
                    fileName: w,
                    lineNumber: 201,
                  },
                },
                React.createElement(
                  module901.default,
                  {
                    style: [
                      {
                        opacity: o,
                      },
                      _.content,
                      p,
                    ],
                    __source: {
                      fileName: w,
                      lineNumber: 202,
                    },
                  },
                  l
                )
              )
            );
          },
        },
      ],
      [
        {
          key: 'getDerivedStateFromProps',
          value: function (t, n) {
            return t.visible && !n.rendered
              ? {
                  rendered: true,
                }
              : null;
          },
        },
      ]
    );
    return n;
  })(React.Component);

module50.default(P, 'defaultProps', {
  dismissable: true,
  visible: false,
});
var j = module788.withTheme(P);
exports.default = j;

var _ = ReactNative.StyleSheet.create({
  backdrop: {
    flex: 1,
  },
  wrapper: (function (t) {
    for (var n = 1; n < arguments.length; n++) {
      var o = null != arguments[n] ? arguments[n] : {};
      if (n % 2)
        O(Object(o), true).forEach(function (n) {
          module50.default(t, n, o[n]);
        });
      else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
      else
        O(Object(o)).forEach(function (n) {
          Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
        });
    }

    return t;
  })({}, ReactNative.StyleSheet.absoluteFillObject, {
    justifyContent: 'center',
  }),
  content: {
    backgroundColor: 'transparent',
    justifyContent: 'center',
  },
});
