exports.default = function (t, c) {
  var l = module771.default(c);

  switch (c) {
    case 'vertical':
    case 'vertical-inverted':
      return t.height * l;

    case 'horizontal':
    case 'horizontal-inverted':
      return t.width * l;
  }
};

var module771 = require('./771');
