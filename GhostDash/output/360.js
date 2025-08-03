var t,
  module173 = require('./173');

t = require('react-dom');
if (globals.RN$Bridgeless) globals.RN$stopSurface = t.stopSurface;
else module173.BatchedBridge.registerCallableModule('ReactFabric', t);
module.exports = t;
