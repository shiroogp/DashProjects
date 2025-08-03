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
  module908 = require('./908'),
  module909 = require('./909'),
  module910 = require('./910'),
  module911 = require('./911'),
  module901 = require('./901'),
  module788 = require('./788'),
  V = '/Users/trensik/dev/react-native-paper/src/components/Card/Card.tsx',
  w = (function (t, ...args) {
    function n() {
      var t, module14;
      module27.default(this, n);
      module14 = module40.default(this, (t = module37.default(n)).call.apply(t, [this].concat(args)));
      module50.default(module42.default(module14), 'state', {
        elevation: new ReactNative.Animated.Value(module14.props.elevation),
      });
      module50.default(module42.default(module14), 'handlePressIn', function () {
        var t = module14.props.theme.animation.scale;
        ReactNative.Animated.timing(module14.state.elevation, {
          toValue: 8,
          duration: 150 * t,
          useNativeDriver: false,
        }).start();
      });
      module50.default(module42.default(module14), 'handlePressOut', function () {
        var t = module14.props.theme.animation.scale;
        ReactNative.Animated.timing(module14.state.elevation, {
          toValue: module14.props.elevation,
          duration: 150 * t,
          useNativeDriver: false,
        }).start();
      });
      return module14;
    }

    module38.default(n, t);
    module28.default(n, [
      {
        key: 'render',
        value: function () {
          var t = this.props,
            n = t.children,
            o = t.onLongPress,
            u = t.onPress,
            f = t.style,
            c = t.theme,
            v = t.testID,
            h = t.accessible,
            p = module56.default(t, ['children', 'elevation', 'onLongPress', 'onPress', 'style', 'theme', 'testID', 'accessible']),
            b = this.state.elevation,
            C = c.roundness,
            _ = React.Children.count(n),
            N = React.Children.map(n, function (t) {
              return React.isValidElement(t) && t.type ? t.type.displayName : null;
            });

          return (
            <module901.default>
              <ReactNative.TouchableWithoutFeedback
                delayPressIn={0}
                disabled={!(u || o)}
                onLongPress={o}
                onPress={u}
                onPressIn={u ? this.handlePressIn : undefined}
                onPressOut={u ? this.handlePressOut : undefined}
                testID={v}
                accessible={h}
                __source={{
                  fileName: V,
                  lineNumber: 153,
                }}
              >
                <ReactNative.View
                  style={A.innerContainer}
                  __source={{
                    fileName: V,
                    lineNumber: 163,
                  }}
                >
                  <n />
                </ReactNative.View>
              </ReactNative.TouchableWithoutFeedback>
            </module901.default>
          );
        },
      },
    ]);
    return n;
  })(React.Component);

module50.default(w, 'Content', module908.default);
module50.default(w, 'Actions', module909.default);
module50.default(w, 'Cover', module910.default);
module50.default(w, 'Title', module911.default);
module50.default(w, 'defaultProps', {
  elevation: 1,
});
var A = ReactNative.StyleSheet.create({
    innerContainer: {
      flexGrow: 1,
      flexShrink: 1,
    },
  }),
  D = module788.withTheme(w);
exports.default = D;
