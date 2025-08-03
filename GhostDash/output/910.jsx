var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module38 = require('./38'),
  module50 = require('./50'),
  React = require('react'),
  ReactNative = require('react-native'),
  module788 = require('./788'),
  module787 = require('./787'),
  _ = '/Users/trensik/dev/react-native-paper/src/components/Card/CardCover.tsx',
  x = (function (t) {
    function o() {
      module27.default(this, o);
      return module40.default(this, module37.default(o).apply(this, arguments));
    }

    module38.default(o, t);
    module28.default(o, [
      {
        key: 'render',
        value: function () {
          var t,
            o = this.props,
            u = o.index,
            s = o.total,
            f = o.style,
            c = o.theme,
            v = module56.default(o, ['index', 'total', 'style', 'theme']),
            h = c.roundness;
          if (0 === u)
            t =
              1 === s
                ? {
                    borderRadius: h,
                  }
                : {
                    borderTopLeftRadius: h,
                    borderTopRightRadius: h,
                  };
          else if ('number' == typeof s && u === s - 1)
            t = {
              borderBottomLeftRadius: h,
            };
          return (
            <ReactNative.View
              style={[N.container, t, f]}
              __source={{
                fileName: _,
                lineNumber: 69,
              }}
            >
              <ReactNative.Image />
            </ReactNative.View>
          );
        },
      },
    ]);
    return o;
  })(React.Component);

exports.CardCover = x;
module50.default(x, 'displayName', 'Card.Cover');
var N = ReactNative.StyleSheet.create({
    container: {
      height: 195,
      backgroundColor: module787.grey200,
      overflow: 'hidden',
    },
    image: {
      flex: 1,
      height: undefined,
      width: undefined,
      padding: 16,
      justifyContent: 'flex-end',
      resizeMode: 'cover',
    },
  }),
  R = module788.withTheme(x);
exports.default = R;
