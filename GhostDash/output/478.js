exports.getShadowNodeWrapperFromHostInstance = t;

exports.getShadowNodeWrapperFromRef = function (o) {
  return t(n(o));
};

var n = function (n) {
  return null;
};

try {
  n = require('./360').findHostInstance_DEPRECATED;
} catch (n) {}

function t(n) {
  return n._internalInstanceHandle.stateNode.node;
}
