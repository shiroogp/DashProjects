module.exports = {
  get BatchedBridge() {
    return require('./21');
  },

  get ExceptionsManager() {
    return require('./96');
  },

  get Platform() {
    return require('./52');
  },

  get RCTEventEmitter() {
    return require('./174');
  },

  get ReactNativeViewConfigRegistry() {
    return require('./175');
  },

  get TextInputState() {
    return require('./176');
  },

  get UIManager() {
    return require('./47');
  },

  get deepDiffer() {
    return require('./194');
  },

  get deepFreezeAndThrowOnMutationInDev() {
    return require('./31');
  },

  get flattenStyle() {
    return require('./84');
  },

  get ReactFiberErrorDialog() {
    return require('./195');
  },
};
