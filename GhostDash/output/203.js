var module178 = require('./178'),
  module47 = require('./47');

exports.default = function (n, p) {
  var f = p && p.paperComponentName ? p.paperComponentName : n;
  if (null != p && null != p.paperComponentNameDeprecated)
    if (module47.default.getViewManagerConfig(n)) f = n;
    else {
      if (null == p.paperComponentNameDeprecated || !module47.default.getViewManagerConfig(p.paperComponentNameDeprecated))
        throw new Error('Failed to find native component for either ' + n + ' or ' + (p.paperComponentNameDeprecated || '(unknown)'));
      f = p.paperComponentNameDeprecated;
    }
  return module178.default(f);
};
