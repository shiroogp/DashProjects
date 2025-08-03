exports.useAnimatedReaction = function (l, s, c) {
  var _,
    v,
    f,
    h,
    p = React.useRef({
      value: null,
    }).current,
    b = Object.values(null != (_ = l._closure) ? _ : {});

  if (module421.shouldBeUseWeb() && !b.length && null != (v = c) && v.length) b = c;
  if (undefined === c)
    c = [].concat(module23.default(Object.values(null != (f = l._closure) ? f : {})), module23.default(Object.values(null != (h = s._closure) ? h : {})), [
      l.__workletHash,
      s.__workletHash,
    ]);
  else c.push(l.__workletHash, s.__workletHash);
  React.useEffect(function () {
    var u = module422.startMapper(
      function () {
        'worklet';

        var u = l();
        s(u, p.value);
        p.value = u;
      },
      b,
      []
    );
    return function () {
      module422.stopMapper(u);
    };
  }, c);
};

var React = require('react'),
  module422 = require('./422'),
  module421 = require('./421');
