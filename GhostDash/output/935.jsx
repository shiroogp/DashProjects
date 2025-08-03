var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module42 = require('./42'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  module760 = require('./760'),
  ReactNative = require('react-native'),
  module936 = require('./936'),
  module788 = require('./788'),
  H = (function (t, ...args) {
    function n() {
      var t, module14;
      module27.default(this, n);
      module14 = module40.default(this, (t = module37.default(n)).call.apply(t, [this].concat(args)));
      module50.default(module42.default(module14), 'state', {
        shown: new ReactNative.Animated.Value(module14.props.visible ? 1 : 0),
        textHeight: 0,
      });
      module50.default(module42.default(module14), 'showText', function () {
        var t = module14.props.theme.animation.scale;
        ReactNative.Animated.timing(module14.state.shown, {
          toValue: 1,
          duration: 150 * t,
          useNativeDriver: true,
        }).start();
      });
      module50.default(module42.default(module14), 'hideText', function () {
        var t = module14.props.theme.animation.scale;
        ReactNative.Animated.timing(module14.state.shown, {
          toValue: 0,
          duration: 180 * t,
          useNativeDriver: true,
        }).start();
      });
      module50.default(module42.default(module14), 'handleTextLayout', function (t) {
        if (module14.props.onLayout) module14.props.onLayout(t);
        module14.setState({
          textHeight: t.nativeEvent.layout.height,
        });
      });
      return module14;
    }

    module38.default(n, t);
    module28.default(n, [
      {
        key: 'componentDidUpdate',
        value: function (t, n) {
          if (!(t.visible === this.props.visible && n.textHeight === this.state.textHeight)) this.props.visible ? this.showText() : this.hideText();
        },
      },
      {
        key: 'render',
        value: function () {
          var t = this.props,
            n = t.style,
            l = t.type,
            u = t.visible,
            p = t.theme,
            h = t.padding,
            f = module56.default(t, ['style', 'type', 'visible', 'theme', 'onLayout', 'padding']),
            v = p.colors,
            c = p.dark,
            b =
              'error' === this.props.type
                ? v.error
                : module760
                    .default(v.text)
                    .alpha(c ? 0.7 : 0.54)
                    .rgb()
                    .string();
          return <module936.default>{this.props.children}</module936.default>;
        },
      },
    ]);
    return n;
  })(React.PureComponent);

module50.default(H, 'defaultProps', {
  type: 'info',
  padding: 'normal',
  visible: true,
});

var L = ReactNative.StyleSheet.create({
    text: {
      fontSize: 12,
      paddingVertical: 4,
    },
    padding: {
      paddingHorizontal: 12,
    },
  }),
  _ = module788.withTheme(H);

exports.default = _;
