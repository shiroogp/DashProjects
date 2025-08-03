var module27 = require('./27'),
  ReactNative = require('react-native'),
  module418 = require('./418');

exports.NativeReanimated = (function () {
  function n() {
    var u = !(arguments.length > 0 && undefined !== arguments[0]) || arguments[0];

    if ((module27.default(this, n), undefined === globals.__reanimatedModuleProxy && u)) {
      var s = ReactNative.NativeModules.ReanimatedModule;
      if (!(null == s)) s.installTurboModule();
    }

    if (((this.InnerNativeModule = globals.__reanimatedModuleProxy), (this.native = u), u)) {
      if (undefined === this.InnerNativeModule)
        throw new Error(
          "[Reanimated] The native part of Reanimated doesn't seem to be initialized. This could be caused by\n  - not rebuilding the app after installing or upgrading Reanimated\n  - trying to run Reanimated on an unsupported platform\n  - running in a brownfield app without manually initializing the native library"
        );
      module418.checkCppVersion();
    }
  }

  module28.default(n, [
    {
      key: 'installCoreFunctions',
      value: function (n, t) {
        return this.InnerNativeModule.installCoreFunctions(n, t);
      },
    },
    {
      key: 'makeShareableClone',
      value: function (n, t) {
        return this.InnerNativeModule.makeShareableClone(n, t);
      },
    },
    {
      key: 'makeSynchronizedDataHolder',
      value: function (n) {
        return this.InnerNativeModule.makeSynchronizedDataHolder(n);
      },
    },
    {
      key: 'getDataSynchronously',
      value: function (n) {
        return this.InnerNativeModule.getDataSynchronously(n);
      },
    },
    {
      key: 'updateDataSynchronously',
      value: function (n, t) {
        this.InnerNativeModule.updateDataSynchronously(n, t);
      },
    },
    {
      key: 'scheduleOnUI',
      value: function (n) {
        return this.InnerNativeModule.scheduleOnUI(n);
      },
    },
    {
      key: 'registerSensor',
      value: function (n, t, u, o) {
        return this.InnerNativeModule.registerSensor(n, t, u, o);
      },
    },
    {
      key: 'unregisterSensor',
      value: function (n) {
        return this.InnerNativeModule.unregisterSensor(n);
      },
    },
    {
      key: 'registerEventHandler',
      value: function (n, t) {
        return this.InnerNativeModule.registerEventHandler(n, t);
      },
    },
    {
      key: 'unregisterEventHandler',
      value: function (n) {
        return this.InnerNativeModule.unregisterEventHandler(n);
      },
    },
    {
      key: 'getViewProp',
      value: function (n, t, u) {
        return this.InnerNativeModule.getViewProp(n, t, u);
      },
    },
    {
      key: 'configureLayoutAnimation',
      value: function (n, t, u, o) {
        this.InnerNativeModule.configureLayoutAnimation(n, t, u, o);
      },
    },
    {
      key: 'enableLayoutAnimations',
      value: function (n) {
        this.InnerNativeModule.enableLayoutAnimations(n);
      },
    },
    {
      key: 'configureProps',
      value: function (n, t) {
        this.InnerNativeModule.configureProps(n, t);
      },
    },
    {
      key: 'subscribeForKeyboardEvents',
      value: function (n, t) {
        return this.InnerNativeModule.subscribeForKeyboardEvents(n, t);
      },
    },
    {
      key: 'unsubscribeFromKeyboardEvents',
      value: function (n) {
        this.InnerNativeModule.unsubscribeFromKeyboardEvents(n);
      },
    },
  ]);
  return n;
})();
