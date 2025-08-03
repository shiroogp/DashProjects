var module1210 = require('./1210'),
  module1220 = require('./1220');

module.exports = function (o, u) {
  module1210(!(o instanceof u), function () {
    return 'Cannot use the new operator to instantiate the type ' + module1220(u);
  });
};
