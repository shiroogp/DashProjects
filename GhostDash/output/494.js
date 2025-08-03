exports.useAnimatedKeyboard = function () {
  var c =
      arguments.length > 0 && undefined !== arguments[0]
        ? arguments[0]
        : {
            isStatusBarTranslucentAndroid: false,
          },
    s = React.useRef(null),
    o = React.useRef(-1),
    l = React.useRef(false);

  if (null === s.current) {
    var b = {
      state: module422.makeMutable(module420.KeyboardState.UNKNOWN),
      height: module422.makeMutable(0),
    };
    o.current = module422.subscribeForKeyboardEvents(function (t, u) {
      'worklet';

      b.state.value = t;
      b.height.value = u;
    }, c);
    s.current = b;
    l.current = true;
  }

  React.useEffect(function () {
    if (false === l.current && null !== s.current) {
      var t = s.current;
      o.current = module422.subscribeForKeyboardEvents(function (u, n) {
        'worklet';

        t.state.value = u;
        t.height.value = n;
      }, c);
      l.current = true;
    }

    return function () {
      module422.unsubscribeFromKeyboardEvents(o.current);
      l.current = false;
    };
  }, []);
  return s.current;
};

var React = require('react'),
  module422 = require('./422'),
  module420 = require('./420');
