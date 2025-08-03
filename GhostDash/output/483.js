exports.useSharedValue = function (c) {
  var l = arguments.length > 1 && undefined !== arguments[1] && arguments[1],
    f = React.useRef(module422.makeMutable(c, l));
  if (null === f.current) f.current = module422.makeMutable(c, l);
  React.useEffect(function () {
    return function () {
      module445.cancelAnimation(f.current);
    };
  }, []);
  return f.current;
};

var React = require('react'),
  module445 = require('./445'),
  module422 = require('./422');
