exports.get = o;

exports.getEnforcing = function (n) {
  var u = o(n);
  module6.default(null != u, "TurboModuleRegistry.getEnforcing(...): '" + n + "' could not be found. Verify that a module by this name is registered in the native binary.");
  return u;
};

var module6 = require('./6'),
  module13 = require('./13'),
  l = globals.__turboModuleProxy;

function o(n) {
  if (!globals.RN$Bridgeless) {
    var t = module13[n];
    if (null != t) return t;
  }

  return null != l ? l(n) : null;
}
