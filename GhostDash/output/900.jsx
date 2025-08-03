var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module42 = require('./42'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module901 = require('./901'),
  module885 = require('./885'),
  module902 = require('./902'),
  module882 = require('./882'),
  module788 = require('./788'),
  module878 = require('./878'),
  x = '/Users/trensik/dev/react-native-paper/src/components/Banner.tsx',
  S = (function (t, ...args) {
    function n() {
      var t, module14;
      module27.default(this, n);
      module14 = module40.default(this, (t = module37.default(n)).call.apply(t, [this].concat(args)));
      module50.default(module42.default(module14), 'state', {
        position: new ReactNative.Animated.Value(module14.props.visible ? 1 : 0),
        layout: {
          height: 0,
          measured: false,
        },
      });
      module50.default(module42.default(module14), 'handleLayout', function (t) {
        var n = t.nativeEvent.layout.height;
        module14.setState({
          layout: {
            height: n,
            measured: true,
          },
        });
      });
      module50.default(module42.default(module14), 'toggle', function () {
        if (module14.props.visible) module14.show();
        else module14.hide();
      });
      module50.default(module42.default(module14), 'show', function () {
        var t = module14.props.theme.animation.scale;
        ReactNative.Animated.timing(module14.state.position, {
          duration: 250 * t,
          toValue: 1,
          useNativeDriver: false,
        }).start();
      });
      module50.default(module42.default(module14), 'hide', function () {
        var t = module14.props.theme.animation.scale;
        ReactNative.Animated.timing(module14.state.position, {
          duration: 200 * t,
          toValue: 0,
          useNativeDriver: false,
        }).start();
      });
      return module14;
    }

    module38.default(n, t);
    module28.default(n, [
      {
        key: 'componentDidUpdate',
        value: function (t) {
          if (t.visible !== this.props.visible) this.toggle();
        },
      },
      {
        key: 'render',
        value: function () {
          var t = this.props,
            n = t.visible,
            u = t.icon,
            s = t.children,
            c = t.actions,
            f = t.contentStyle,
            h = t.style,
            p = module56.default(t, ['visible', 'icon', 'children', 'actions', 'contentStyle', 'style', 'theme']),
            y = this.state,
            A = y.position,
            S = y.layout,
            k = ReactNative.Animated.multiply(A, S.height),
            j = ReactNative.Animated.multiply(ReactNative.Animated.add(A, -1), S.height);
          return (
            <module901.default>
              <ReactNative.View
                style={[D.wrapper, f]}
                __source={{
                  fileName: x,
                  lineNumber: 199,
                }}
              >
                {React.createElement(ReactNative.Animated.View, {
                  style: {
                    height: k,
                  },
                  __source: {
                    fileName: x,
                    lineNumber: 200,
                  },
                })}
                {React.createElement(
                  ReactNative.Animated.View,
                  {
                    onLayout: this.handleLayout,
                    style: [
                      S.measured || !n
                        ? [
                            D.absolute,
                            {
                              transform: [
                                {
                                  translateY: j,
                                },
                              ],
                            },
                          ]
                        : null,
                      S.measured || n
                        ? null
                        : {
                            opacity: 0,
                          },
                    ],
                    __source: {
                      fileName: x,
                      lineNumber: 201,
                    },
                  },
                  React.createElement(
                    ReactNative.View,
                    {
                      style: D.content,
                      __source: {
                        fileName: x,
                        lineNumber: 217,
                      },
                    },
                    u
                      ? React.createElement(
                          ReactNative.View,
                          {
                            style: D.icon,
                            __source: {
                              fileName: x,
                              lineNumber: 219,
                            },
                          },
                          React.createElement(module882.default, {
                            source: u,
                            size: 40,
                            __source: {
                              fileName: x,
                              lineNumber: 222,
                            },
                          })
                        )
                      : null,
                    React.createElement(
                      module885.default,
                      {
                        style: D.message,
                        __source: {
                          fileName: x,
                          lineNumber: 225,
                        },
                      },
                      s
                    )
                  ),
                  React.createElement(
                    ReactNative.View,
                    {
                      style: D.actions,
                      __source: {
                        fileName: x,
                        lineNumber: 227,
                      },
                    },
                    c.map(function (t, n) {
                      var u = t.label,
                        s = module56.default(t, ['label']);
                      return React.createElement(
                        module902.default,
                        module14.default(
                          {
                            key: n,
                            compact: true,
                            mode: 'text',
                            style: D.button,
                          },
                          s,
                          {
                            __source: {
                              fileName: x,
                              lineNumber: 229,
                            },
                          }
                        ),
                        u
                      );
                    })
                  )
                )}
              </ReactNative.View>
            </module901.default>
          );
        },
      },
    ]);
    return n;
  })(React.Component),
  D = ReactNative.StyleSheet.create({
    container: {
      elevation: 1,
    },
    wrapper: {
      overflow: 'hidden',
      alignSelf: 'center',
      width: '100%',
      maxWidth: 960,
    },
    absolute: {
      position: 'absolute',
      top: 0,
      width: '100%',
    },
    content: {
      flexDirection: 'row',
      justifyContent: 'flex-start',
      marginHorizontal: 8,
      marginTop: 16,
      marginBottom: 0,
    },
    icon: {
      margin: 8,
    },
    message: {
      flex: 1,
      margin: 8,
    },
    actions: {
      flexDirection: 'row',
      justifyContent: 'flex-end',
      margin: 4,
    },
    button: {
      margin: 4,
    },
  }),
  k = module788.withTheme(S);

exports.default = k;
