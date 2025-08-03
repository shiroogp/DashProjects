var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  React = require('react'),
  module787 = require('./787'),
  ReactNative = require('react-native'),
  module760 = require('./760'),
  module788 = require('./788'),
  y = ReactNative.NativeModules.PlatformConstants ? ReactNative.NativeModules.PlatformConstants.reactNativeVersion : undefined,
  _ = (function (t) {
    function o() {
      module27.default(this, o);
      return module40.default(this, module37.default(o).apply(this, arguments));
    }

    module38.default(o, t);
    module28.default(o, [
      {
        key: 'render',
        value: function () {
          var t = this.props,
            o = t.value,
            u = t.disabled,
            s = t.onValueChange,
            f = t.color,
            c = t.theme,
            h = module56.default(t, ['value', 'disabled', 'onValueChange', 'color', 'theme']),
            k = f || c.colors.accent,
            _ =
              'ios' === ReactNative.Platform.OS
                ? k
                : u
                ? c.dark
                  ? module760.default(module787.white).alpha(0.1).rgb().string()
                  : module760.default(module787.black).alpha(0.12).rgb().string()
                : module760.default(k).alpha(0.5).rgb().string(),
            N = 'ios' === ReactNative.Platform.OS ? undefined : u ? (c.dark ? module787.grey800 : module787.grey400) : o ? k : c.dark ? module787.grey400 : module787.grey50,
            P =
              y && 0 === y.major && y.minor <= 56
                ? {
                    onTintColor: _,
                    thumbTintColor: N,
                  }
                : {
                    thumbColor: N,
                    trackColor: {
                      true: _,
                      false: '',
                    },
                  };

          return <ReactNative.Switch />;
        },
      },
    ]);
    return o;
  })(React.Component),
  N = module788.withTheme(_);

exports.default = N;
