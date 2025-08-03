exports.forFadeFromBottomAndroid = function (t) {
  var n = t.current,
    o = t.inverted,
    u = t.layouts.screen,
    s = t.closing,
    c = l(
      n.progress.interpolate({
        inputRange: [0, 1],
        outputRange: [0.08 * u.height, 0],
        extrapolate: 'clamp',
      }),
      o
    );
  return {
    cardStyle: {
      opacity: module721.default(
        s,
        n.progress,
        n.progress.interpolate({
          inputRange: [0, 0.5, 0.9, 1],
          outputRange: [0, 0.25, 0.7, 1],
        })
      ),
      transform: [
        {
          translateY: c,
        },
      ],
    },
  };
};

exports.forHorizontalIOS = function (t) {
  var n = t.current,
    o = t.next,
    p = t.inverted,
    u = t.layouts.screen,
    s = l(
      n.progress.interpolate({
        inputRange: [0, 1],
        outputRange: [u.width, 0],
        extrapolate: 'clamp',
      }),
      p
    ),
    c = o
      ? l(
          o.progress.interpolate({
            inputRange: [0, 1],
            outputRange: [0, -0.3 * u.width],
            extrapolate: 'clamp',
          }),
          p
        )
      : 0,
    R = n.progress.interpolate({
      inputRange: [0, 1],
      outputRange: [0, 0.07],
      extrapolate: 'clamp',
    }),
    f = n.progress.interpolate({
      inputRange: [0, 1],
      outputRange: [0, 0.3],
      extrapolate: 'clamp',
    });
  return {
    cardStyle: {
      transform: [
        {
          translateX: s,
        },
        {
          translateX: c,
        },
      ],
    },
    overlayStyle: {
      opacity: R,
    },
    shadowStyle: {
      shadowOpacity: f,
    },
  };
};

exports.forModalPresentationIOS = function (t) {
  var n = t.index,
    p = t.current,
    s = t.next,
    c = t.inverted,
    R = t.layouts.screen,
    f = t.insets,
    h = R.width > R.height,
    y = h ? 0 : 10,
    v = f.top,
    x = R.height / R.width,
    S = u(
      p.progress.interpolate({
        inputRange: [0, 1],
        outputRange: [0, 1],
        extrapolate: 'clamp',
      }),
      s
        ? s.progress.interpolate({
            inputRange: [0, 1],
            outputRange: [0, 1],
            extrapolate: 'clamp',
          })
        : 0
    ),
    w = l(
      S.interpolate({
        inputRange: [0, 1, 2],
        outputRange: [R.height, 0 === n ? 0 : y, (0 === n ? v : 0) - y * x],
      }),
      c
    ),
    A = S.interpolate({
      inputRange: [0, 1, 1.0001, 2],
      outputRange: [0, 0.3, 1, 1],
    }),
    Y = h
      ? 1
      : S.interpolate({
          inputRange: [0, 1, 2],
          outputRange: [1, 1, R.width ? 1 - (2 * y) / R.width : 1],
        }),
    O = h
      ? 0
      : 0 === n
      ? S.interpolate({
          inputRange: [0, 1, 1.0001, 2],
          outputRange: [0, 0, module720.isIphoneX() ? 38 : 0, 10],
        })
      : 10;
  return {
    cardStyle: {
      overflow: 'hidden',
      borderTopLeftRadius: O,
      borderTopRightRadius: O,
      marginTop: 0 === n ? 0 : v,
      transform: [
        {
          translateY: w,
        },
        {
          scale: Y,
        },
      ],
    },
    overlayStyle: {
      opacity: A,
    },
  };
};

exports.forNoAnimation = function () {
  return {};
};

exports.forRevealFromBottomAndroid = function (t) {
  var n = t.current,
    o = t.next,
    p = t.inverted,
    u = t.layouts.screen,
    s = l(
      n.progress.interpolate({
        inputRange: [0, 1],
        outputRange: [u.height, 0],
        extrapolate: 'clamp',
      }),
      p
    ),
    c = l(
      n.progress.interpolate({
        inputRange: [0, 1],
        outputRange: [0.9590000000000001 * u.height * -1, 0],
        extrapolate: 'clamp',
      }),
      p
    ),
    R = o
      ? l(
          o.progress.interpolate({
            inputRange: [0, 1],
            outputRange: [0, 0.02 * u.height * -1],
            extrapolate: 'clamp',
          }),
          p
        )
      : 0,
    f = n.progress.interpolate({
      inputRange: [0, 0.36, 1],
      outputRange: [0, 0.1, 0.1],
      extrapolate: 'clamp',
    });
  return {
    containerStyle: {
      overflow: 'hidden',
      transform: [
        {
          translateY: s,
        },
      ],
    },
    cardStyle: {
      transform: [
        {
          translateY: c,
        },
        {
          translateY: R,
        },
      ],
    },
    overlayStyle: {
      opacity: f,
    },
  };
};

exports.forScaleFromCenterAndroid = function (t) {
  var n = t.current,
    o = t.next,
    l = t.closing,
    s = u(
      n.progress.interpolate({
        inputRange: [0, 1],
        outputRange: [0, 1],
        extrapolate: 'clamp',
      }),
      o
        ? o.progress.interpolate({
            inputRange: [0, 1],
            outputRange: [0, 1],
            extrapolate: 'clamp',
          })
        : 0
    ),
    c = s.interpolate({
      inputRange: [0, 0.8, 1, 1.2, 2],
      outputRange: [0, 0.5, 1, 0.33, 0],
    }),
    R = module721.default(
      l,
      n.progress.interpolate({
        inputRange: [0, 1],
        outputRange: [0.9, 1],
        extrapolate: 'clamp',
      }),
      s.interpolate({
        inputRange: [0, 1, 2],
        outputRange: [0.85, 1, 1.1],
      })
    );
  return {
    containerStyle: {
      opacity: c,
      transform: [
        {
          scale: R,
        },
      ],
    },
  };
};

exports.forVerticalIOS = function (t) {
  var n = t.current,
    o = t.inverted,
    p = t.layouts.screen;
  return {
    cardStyle: {
      transform: [
        {
          translateY: l(
            n.progress.interpolate({
              inputRange: [0, 1],
              outputRange: [p.height, 0],
              extrapolate: 'clamp',
            }),
            o
          ),
        },
      ],
    },
  };
};

var ReactNative = require('react-native'),
  module720 = require('./720'),
  module721 = require('./721'),
  u = ReactNative.Animated.add,
  l = ReactNative.Animated.multiply;
