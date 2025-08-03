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
  module960 = require('./960'),
  module965 = require('./965'),
  module788 = require('./788'),
  L = '/Users/trensik/dev/react-native-paper/src/components/TextInput/TextInput.tsx',
  w = 180,
  A = 150,
  N = (function (t, ...args) {
    function o() {
      var t, module14;
      module27.default(this, o);
      module14 = module40.default(this, (t = module37.default(o)).call.apply(t, [this].concat(args)));
      module50.default(module42.default(module14), 'state', {
        labeled: new ReactNative.Animated.Value((undefined !== module14.props.value ? module14.props.value : module14.props.defaultValue) ? 0 : 1),
        error: new ReactNative.Animated.Value(module14.props.error ? 1 : 0),
        focused: false,
        placeholder: '',
        value: undefined !== module14.props.value ? module14.props.value : module14.props.defaultValue,
        labelLayout: {
          measured: false,
          width: 0,
          height: 0,
        },
      });
      module50.default(module42.default(module14), 'ref', undefined);
      module50.default(module42.default(module14), 'showPlaceholder', function () {
        if (module14.timer) clearTimeout(module14.timer);
        module14.timer = setTimeout(function () {
          return module14.setState({
            placeholder: module14.props.placeholder,
          });
        }, 50);
      });
      module50.default(module42.default(module14), 'hidePlaceholder', function () {
        return module14.setState({
          placeholder: '',
        });
      });
      module50.default(module42.default(module14), 'timer', undefined);
      module50.default(module42.default(module14), 'root', undefined);
      module50.default(module42.default(module14), 'showError', function () {
        var t = module14.props.theme.animation.scale;
        ReactNative.Animated.timing(module14.state.error, {
          toValue: 1,
          duration: A * t,
          useNativeDriver: ReactNative.Platform.select({
            ios: false,
            default: true,
          }),
        }).start(module14.showPlaceholder);
      });
      module50.default(module42.default(module14), 'hideError', function () {
        var t = module14.props.theme.animation.scale;
        ReactNative.Animated.timing(module14.state.error, {
          toValue: 0,
          duration: w * t,
          useNativeDriver: ReactNative.Platform.select({
            ios: false,
            default: true,
          }),
        }).start();
      });
      module50.default(module42.default(module14), 'restoreLabel', function () {
        var t = module14.props.theme.animation.scale;
        ReactNative.Animated.timing(module14.state.labeled, {
          toValue: 1,
          duration: A * t,
          useNativeDriver: ReactNative.Platform.select({
            ios: false,
            default: true,
          }),
        }).start();
      });
      module50.default(module42.default(module14), 'minimizeLabel', function () {
        var t = module14.props.theme.animation.scale;
        ReactNative.Animated.timing(module14.state.labeled, {
          toValue: 0,
          duration: w * t,
          useNativeDriver: ReactNative.Platform.select({
            ios: false,
            default: true,
          }),
        }).start();
      });
      module50.default(module42.default(module14), 'handleFocus', function (t) {
        if (!module14.props.disabled && module14.props.editable) {
          module14.setState({
            focused: true,
          });
          if (module14.props.onFocus) module14.props.onFocus(t);
        }
      });
      module50.default(module42.default(module14), 'handleBlur', function (t) {
        if (!module14.props.disabled && module14.props.editable) {
          module14.setState({
            focused: false,
          });
          if (module14.props.onBlur) module14.props.onBlur(t);
        }
      });
      module50.default(module42.default(module14), 'handleChangeText', function (t) {
        if (module14.props.editable) {
          module14.setState({
            value: t,
          });
          if (module14.props.onChangeText) module14.props.onChangeText(t);
        }
      });
      module50.default(module42.default(module14), 'handleLayoutAnimatedText', function (t) {
        module14.setState({
          labelLayout: {
            width: t.nativeEvent.layout.width,
            height: t.nativeEvent.layout.height,
            measured: true,
          },
        });
      });
      return module14;
    }

    module38.default(o, t);
    module28.default(
      o,
      [
        {
          key: 'componentDidUpdate',
          value: function (t, o) {
            if (!(o.focused === this.state.focused && o.value === this.state.value && o.labelLayout === this.state.labelLayout))
              this.state.value || this.state.focused ? this.minimizeLabel() : this.restoreLabel();
            if (!(o.focused === this.state.focused && t.label === this.props.label)) this.state.focused || !this.props.label ? this.showPlaceholder() : this.hidePlaceholder();
            if (t.error !== this.props.error) this.props.error ? this.showError() : this.hideError();
          },
        },
        {
          key: 'componentWillUnmount',
          value: function () {
            if (this.timer) clearTimeout(this.timer);
          },
        },
        {
          key: 'setNativeProps',
          value: function (t) {
            return this.root && this.root.setNativeProps(t);
          },
        },
        {
          key: 'isFocused',
          value: function () {
            return this.root && this.root.isFocused();
          },
        },
        {
          key: 'clear',
          value: function () {
            return this.root && this.root.clear();
          },
        },
        {
          key: 'focus',
          value: function () {
            return this.root && this.root.focus();
          },
        },
        {
          key: 'blur',
          value: function () {
            return this.root && this.root.blur();
          },
        },
        {
          key: 'render',
          value: function () {
            var t = this,
              o = this.props,
              n = o.mode,
              s = module56.default(o, ['mode']);
            return 'outlined' === n ? <module960.default /> : <module965.default />;
          },
        },
      ],
      [
        {
          key: 'getDerivedStateFromProps',
          value: function (t, o) {
            return {
              value: undefined !== t.value ? t.value : o.value,
            };
          },
        },
      ]
    );
    return o;
  })(React.Component);

module50.default(N, 'defaultProps', {
  mode: 'flat',
  dense: false,
  disabled: false,
  error: false,
  multiline: false,
  editable: true,
  render: function (t) {
    return <ReactNative.TextInput />;
  },
});
var k = module788.withTheme(N);
exports.default = k;
