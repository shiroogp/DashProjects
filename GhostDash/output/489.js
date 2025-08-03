exports.useDerivedValue = function (u, f) {
  var s,
    v,
    _ = React.useRef(null),
    p = Object.values(null != (s = u._closure) ? s : {});

  if (module421.shouldBeUseWeb() && !p.length && null != (v = f) && v.length) p = f;
  if (undefined === f) f = [].concat(module23.default(p), [u.__workletHash]);
  else f.push(u.__workletHash);
  if (null === _.current) _.current = module422.makeMutable(module445.initialUpdaterRun(u));
  var h = _.current;
  React.useEffect(function () {
    var n = module422.startMapper(
      function () {
        'worklet';

        h.value = u();
      },
      p,
      [h]
    );
    return function () {
      module422.stopMapper(n);
    };
  }, f);
  React.useEffect(function () {
    return function () {
      _.current = null;
    };
  }, []);
  return h;
};

var React = require('react'),
  module445 = require('./445'),
  module422 = require('./422'),
  module421 = require('./421');
