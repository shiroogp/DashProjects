var module27 = require('./27'),
  module63 = require('./63'),
  o = (function () {
    function o() {
      module27(this, o);
    }

    module28(o, null, [
      {
        key: 'get',
        value: function () {
          return module63.get('window').scale;
        },
      },
      {
        key: 'getFontScale',
        value: function () {
          return module63.get('window').fontScale || o.get();
        },
      },
      {
        key: 'getPixelSizeForLayoutSize',
        value: function (t) {
          return Math.round(t * o.get());
        },
      },
      {
        key: 'roundToNearestPixel',
        value: function (t) {
          var n = o.get();
          return Math.round(t * n) / n;
        },
      },
      {
        key: 'startDetecting',
        value: function () {},
      },
    ]);
    return o;
  })();

module.exports = o;
