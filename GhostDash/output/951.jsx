var module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module42 = require('./42'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module902 = require('./902'),
  module901 = require('./901'),
  module885 = require('./885'),
  module788 = require('./788'),
  _ = '/Users/trensik/dev/react-native-paper/src/components/Snackbar.tsx',
  I = (function (t, ...args) {
    function n() {
      var t, module28;
      module27.default(this, n);
      module28 = module40.default(this, (t = module37.default(n)).call.apply(t, [this].concat(args)));
      module50.default(module42.default(module28), 'state', {
        opacity: new ReactNative.Animated.Value(0),
        hidden: !module28.props.visible,
      });
      module50.default(module42.default(module28), 'toggle', function () {
        if (module28.props.visible) module28.show();
        else module28.hide();
      });
      module50.default(module42.default(module28), 'show', function () {
        if (module28.hideTimeout) clearTimeout(module28.hideTimeout);
        module28.setState({
          hidden: false,
        });
        var t = module28.props.theme.animation.scale;
        ReactNative.Animated.timing(module28.state.opacity, {
          toValue: 1,
          duration: 200 * t,
          useNativeDriver: true,
        }).start(function (t) {
          var n = t.finished;

          if (n) {
            var o = module28.props.duration,
              s = o === Number.POSITIVE_INFINITY || o === Number.NEGATIVE_INFINITY;
            if (n && !s) module28.hideTimeout = setTimeout(module28.props.onDismiss, o);
          }
        });
      });
      module50.default(module42.default(module28), 'hide', function () {
        if (module28.hideTimeout) clearTimeout(module28.hideTimeout);
        var t = module28.props.theme.animation.scale;
        ReactNative.Animated.timing(module28.state.opacity, {
          toValue: 0,
          duration: 100 * t,
          useNativeDriver: true,
        }).start(function (t) {
          if (t.finished)
            module28.setState({
              hidden: true,
            });
        });
      });
      module50.default(module42.default(module28), 'hideTimeout', undefined);
      return module28;
    }

    module38.default(n, t);
    module28.default(n, [
      {
        key: 'componentDidMount',
        value: function () {
          if (this.props.visible) this.show();
        },
      },
      {
        key: 'componentDidUpdate',
        value: function (t) {
          if (t.visible !== this.props.visible) this.toggle();
        },
      },
      {
        key: 'componentWillUnmount',
        value: function () {
          if (this.hideTimeout) clearTimeout(this.hideTimeout);
        },
      },
      {
        key: 'render',
        value: function () {
          var t = this.props,
            n = t.children,
            o = t.visible,
            l = t.action,
            s = t.onDismiss,
            u = t.theme,
            c = t.style,
            f = u.colors,
            p = u.roundness;
          return this.state.hidden ? null : (
            <ReactNative.SafeAreaView
              pointerEvents="box-none"
              style={w.wrapper}
              __source={{
                fileName: _,
                lineNumber: 220,
              }}
            >
              <module901.default
                pointerEvents="box-none"
                accessibilityLiveRegion="polite"
                style={[
                  w.container,
                  {
                    borderRadius: p,
                    opacity: this.state.opacity,
                    transform: [
                      {
                        scale: o
                          ? this.state.opacity.interpolate({
                              inputRange: [0, 1],
                              outputRange: [0.9, 1],
                            })
                          : 1,
                      },
                    ],
                  },
                  {
                    backgroundColor: f.onSurface,
                  },
                  c,
                ]}
                __source={{
                  fileName: _,
                  lineNumber: 221,
                }}
              >
                <module885.default
                  style={[
                    w.content,
                    {
                      marginRight: l ? 0 : 16,
                      color: f.surface,
                    },
                  ]}
                  __source={{
                    fileName: _,
                    lineNumber: 246,
                  }}
                >
                  {n}
                </module885.default>
                {l ? (
                  <module902.default
                    accessibilityLabel={l.accessibilityLabel}
                    onPress={function () {
                      l.onPress();
                      s();
                    }}
                    style={w.button}
                    color={f.accent}
                    compact
                    mode="text"
                    __source={{
                      fileName: _,
                      lineNumber: 255,
                    }}
                  >
                    {l.label}
                  </module902.default>
                ) : null}
              </module901.default>
            </ReactNative.SafeAreaView>
          );
        },
      },
    ]);
    return n;
  })(React.Component);

module50.default(I, 'DURATION_SHORT', 4e3);
module50.default(I, 'DURATION_MEDIUM', 7e3);
module50.default(I, 'DURATION_LONG', 1e4);
module50.default(I, 'defaultProps', {
  duration: 7e3,
});
var w = ReactNative.StyleSheet.create({
    wrapper: {
      position: 'absolute',
      bottom: 0,
      width: '100%',
    },
    container: {
      elevation: 6,
      flexDirection: 'row',
      justifyContent: 'space-between',
      alignItems: 'center',
      margin: 8,
      borderRadius: 4,
    },
    content: {
      marginLeft: 16,
      marginVertical: 14,
      flexWrap: 'wrap',
      flex: 1,
    },
    button: {
      marginHorizontal: 8,
      marginVertical: 6,
    },
  }),
  D = module788.withTheme(I);
exports.default = D;
