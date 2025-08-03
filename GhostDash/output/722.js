exports.forFade = function (t) {
  var o = t.current,
    p = t.next,
    u = n(
      o.progress.interpolate({
        inputRange: [0, 1],
        outputRange: [0, 1],
        extrapolate: 'clamp',
      }),
      p
        ? p.progress.interpolate({
            inputRange: [0, 1],
            outputRange: [0, 1],
            extrapolate: 'clamp',
          })
        : 0
    ),
    l = u.interpolate({
      inputRange: [0, 1, 2],
      outputRange: [0, 1, 0],
    });
  return {
    leftButtonStyle: {
      opacity: l,
    },
    rightButtonStyle: {
      opacity: l,
    },
    titleStyle: {
      opacity: l,
    },
    backgroundStyle: {
      opacity: u.interpolate({
        inputRange: [0, 1, 1.9, 2],
        outputRange: [0, 1, 1, 0],
      }),
    },
  };
};

exports.forNoAnimation = function () {
  return {};
};

exports.forSlideLeft = function (o) {
  var p = o.current,
    u = o.next,
    l = o.layouts.screen,
    s = [
      {
        translateX: n(
          p.progress.interpolate({
            inputRange: [0, 1],
            outputRange: [0, 1],
            extrapolate: 'clamp',
          }),
          u
            ? u.progress.interpolate({
                inputRange: [0, 1],
                outputRange: [0, 1],
                extrapolate: 'clamp',
              })
            : 0
        ).interpolate({
          inputRange: [0, 1, 2],
          outputRange: ReactNative.I18nManager.isRTL ? [-l.width, 0, l.width] : [l.width, 0, -l.width],
        }),
      },
    ];
  return {
    leftButtonStyle: {
      transform: s,
    },
    rightButtonStyle: {
      transform: s,
    },
    titleStyle: {
      transform: s,
    },
    backgroundStyle: {
      transform: s,
    },
  };
};

exports.forSlideRight = function (o) {
  var p = o.current,
    u = o.next,
    l = o.layouts.screen,
    s = [
      {
        translateX: n(
          p.progress.interpolate({
            inputRange: [0, 1],
            outputRange: [0, 1],
            extrapolate: 'clamp',
          }),
          u
            ? u.progress.interpolate({
                inputRange: [0, 1],
                outputRange: [0, 1],
                extrapolate: 'clamp',
              })
            : 0
        ).interpolate({
          inputRange: [0, 1, 2],
          outputRange: ReactNative.I18nManager.isRTL ? [l.width, 0, -l.width] : [-l.width, 0, l.width],
        }),
      },
    ];
  return {
    leftButtonStyle: {
      transform: s,
    },
    rightButtonStyle: {
      transform: s,
    },
    titleStyle: {
      transform: s,
    },
    backgroundStyle: {
      transform: s,
    },
  };
};

exports.forSlideUp = function (t) {
  var o = t.current,
    p = t.next,
    u = t.layouts.header,
    l = [
      {
        translateY: n(
          o.progress.interpolate({
            inputRange: [0, 1],
            outputRange: [0, 1],
            extrapolate: 'clamp',
          }),
          p
            ? p.progress.interpolate({
                inputRange: [0, 1],
                outputRange: [0, 1],
                extrapolate: 'clamp',
              })
            : 0
        ).interpolate({
          inputRange: [0, 1, 2],
          outputRange: [-u.height, 0, -u.height],
        }),
      },
    ];
  return {
    leftButtonStyle: {
      transform: l,
    },
    rightButtonStyle: {
      transform: l,
    },
    titleStyle: {
      transform: l,
    },
    backgroundStyle: {
      transform: l,
    },
  };
};

exports.forUIKit = function (o) {
  var p = o.current,
    u = o.next,
    l = o.layouts,
    s = l.leftLabel ? (l.screen.width - l.leftLabel.width) / 2 - 27 : 100,
    R = l.title ? (l.screen.width - l.title.width) / 2 - 27 : 100,
    c = l.screen.width / 4,
    f = n(
      p.progress.interpolate({
        inputRange: [0, 1],
        outputRange: [0, 1],
        extrapolate: 'clamp',
      }),
      u
        ? u.progress.interpolate({
            inputRange: [0, 1],
            outputRange: [0, 1],
            extrapolate: 'clamp',
          })
        : 0
    );
  return {
    leftButtonStyle: {
      opacity: f.interpolate({
        inputRange: [0.3, 1, 1.5],
        outputRange: [0, 1, 0],
      }),
    },
    leftLabelStyle: {
      transform: [
        {
          translateX: f.interpolate({
            inputRange: [0, 1, 2],
            outputRange: ReactNative.I18nManager.isRTL ? [-c, 0, s] : [s, 0, -c],
          }),
        },
      ],
    },
    rightButtonStyle: {
      opacity: f.interpolate({
        inputRange: [0.3, 1, 1.5],
        outputRange: [0, 1, 0],
      }),
    },
    titleStyle: {
      opacity: f.interpolate({
        inputRange: [0, 0.4, 1, 1.5],
        outputRange: [0, 0.1, 1, 0],
      }),
      transform: [
        {
          translateX: f.interpolate({
            inputRange: [0.5, 1, 2],
            outputRange: ReactNative.I18nManager.isRTL ? [-R, 0, c] : [c, 0, -R],
          }),
        },
      ],
    },
    backgroundStyle: {
      transform: [
        {
          translateX: f.interpolate({
            inputRange: [0, 1, 2],
            outputRange: ReactNative.I18nManager.isRTL ? [-l.screen.width, 0, l.screen.width] : [l.screen.width, 0, -l.screen.width],
          }),
        },
      ],
    },
  };
};

var ReactNative = require('react-native'),
  n = ReactNative.Animated.add;
