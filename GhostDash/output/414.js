var u,
  module415 = require('./415'),
  module421 = require('./421'),
  module417 = require('./417');

u = module421.shouldBeUseWeb() ? module415.default : new module417.NativeReanimated();
exports.default = u;
