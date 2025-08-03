exports.createAnimatedPropAdapter = n;

var module455 = require('./455');

function n(n, l) {
  var o = {};
  if (!(null == l))
    l.forEach(function (t) {
      o[t] = true;
    });
  module455.addWhitelistedNativeProps(o);
  return n;
}

exports.SVGAdapter = n(function (t) {
  'worklet';

  if (Object.keys(t).includes('transform'))
    if (Array.isArray(t.transform)) {
      var n, l;
      if (6 !== t.transform.length) throw new Error('invalid transform length of ' + t.transform.length + ', should be 6');
      var o = t.transform,
        s = null != (n = t.x) ? n : 0,
        f = null != (l = t.y) ? l : 0;
      t.transform = [
        {
          translateX: o[0] * s + o[2] * f + o[4],
        },
        {
          translateY: o[1] * s + o[3] * f + o[5],
        },
      ];
    } else if ('string' == typeof t.transform) {
      var u = t.transform.replace('translate(', '').replace(')', '').split(' ');
      t.transform = [
        {
          translateX: parseFloat(u[0]),
        },
        {
          translateY: parseFloat(u[1]),
        },
      ];
    }
});
exports.TextInputAdapter = n(
  function (t) {
    'worklet';

    if (Object.keys(t).includes('value')) {
      t.text = t.value;
      delete t.value;
    }
  },
  ['text']
);
