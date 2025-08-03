exports.initialize = function () {
  module4.startListening();
};

exports.maybeInitializeFabric = function () {
  if (module406.isFabric() && !u) {
    module507.default.install();
    u = true;
  }
};

var module4 = require('./4'),
  module507 = require('./507'),
  module406 = require('./406'),
  u = false;
