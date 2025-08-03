var module395 = require('./395');

exports.useSubscription = function (u) {
  return module395.useSyncExternalStore(u.subscribe, u.getCurrentValue);
};
