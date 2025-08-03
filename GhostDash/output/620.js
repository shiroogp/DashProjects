var n;

exports.getShadowNodeFromRef = function (t) {
  if (undefined === n)
    try {
      n = require('./360').findHostInstance_DEPRECATED;
    } catch (t) {
      n = function (n) {
        return null;
      };
    }
  return n(t)._internalInstanceHandle.stateNode.node;
};
