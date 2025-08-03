exports.configureLayoutAnimations = function (n, o, s) {
  var l = arguments.length > 3 && undefined !== arguments[3] ? arguments[3] : '';
  module414.default.configureLayoutAnimation(n, o, l, module423.makeShareableCloneRecursive(s));
};

exports.configureProps = function (n, u) {
  if (!module421.nativeShouldBeMock()) module414.default.configureProps(n, u);
};

exports.enableLayoutAnimations = function (n) {
  if (arguments.length > 1 && undefined !== arguments[1] && !arguments[1]) {
    if (!(k.setByUser || k.enableLayoutAnimations === n)) {
      k.enableLayoutAnimations = n;
      module414.default.enableLayoutAnimations(n);
    }
  } else {
    k = {
      enableLayoutAnimations: n,
      setByUser: true,
    };
    module414.default.enableLayoutAnimations(n);
  }
};

exports.getSensorContainer = _;

exports.getViewProp = function (n, o) {
  if (globals._IS_FABRIC) throw new Error('[react-native-reanimated] `getViewProp` is not supported on Fabric yet');
  return new Promise(function (u, s) {
    return module414.default.getViewProp(n, o, function (n) {
      if ('string' == typeof n && 'error:' === n.substr(0, 6)) s(n);
      else u(n);
    });
  });
};

exports.initializeSensor = function (n, t) {
  return _().initializeSensor(n, t);
};

exports.registerEventHandler = function (n, o) {
  return module414.default.registerEventHandler(
    n,
    module423.makeShareableCloneRecursive(function (n, t) {
      'worklet';

      globals.__frameTimestamp = n;
      o(t);

      globals.__flushAnimationFrame(n);

      globals.__frameTimestamp = undefined;
    })
  );
};

exports.registerSensor = function (n, t, o) {
  return _().registerSensor(n, t, module423.makeShareableCloneRecursive(o));
};

Object.defineProperty(exports, 'runOnJS', {
  enumerable: true,
  get: function () {
    return module426.runOnJS;
  },
});
Object.defineProperty(exports, 'runOnUI', {
  enumerable: true,
  get: function () {
    return module426.runOnUI;
  },
});
Object.defineProperty(exports, 'stopMapper', {
  enumerable: true,
  get: function () {
    return module425.stopMapper;
  },
});

exports.subscribeForKeyboardEvents = function (n, o) {
  var s;
  return module414.default.subscribeForKeyboardEvents(
    module423.makeShareableCloneRecursive(function (t, o) {
      'worklet';

      var u = performance.now();
      globals.__frameTimestamp = u;
      n(t, o);

      globals.__flushAnimationFrame(u);

      globals.__frameTimestamp = undefined;
    }),
    null != (s = o.isStatusBarTranslucentAndroid) && s
  );
};

exports.unregisterEventHandler = function (n) {
  return module414.default.unregisterEventHandler(n);
};

exports.unregisterSensor = function (n) {
  return _().unregisterSensor(n);
};

exports.unsubscribeFromKeyboardEvents = function (n) {
  return module414.default.unsubscribeFromKeyboardEvents(n);
};

var module414 = require('./414'),
  module421 = require('./421'),
  module423 = require('./423'),
  module425 = require('./425'),
  module429 = require('./429'),
  module431 = require('./431'),
  module432 = require('./432'),
  module426 = require('./426'),
  v = function () {
    'worklet';
  },
  p = function () {
    throw new Error(
      "Failed to initialize react-native-reanimated library, make sure you followed installation steps here: https://docs.swmansion.com/react-native-reanimated/docs/fundamentals/installation/ \n1) Make sure reanimated's babel plugin is installed in your babel.config.js (you should have 'react-native-reanimated/plugin' listed there - also see the above link for details) \n2) Make sure you reset build cache after updating the config, run: yarn start --reset-cache"
    );
  },
  h = (exports.checkPluginState = function () {
    var n = !(arguments.length > 0 && undefined !== arguments[0]) || arguments[0];
    return !(!v.__workletHash && !module421.shouldBeUseWeb()) || (n && p(), false);
  }),
  y = (exports.isConfigured = function () {
    var n = arguments.length > 0 && undefined !== arguments[0] && arguments[0];
    return h(n);
  });

exports.isConfiguredCheck = function () {
  h(true);
};

exports.startMapper = module425.startMapper;
exports.makeShareable = module423.makeShareable;
exports.makeMutable = module429.makeMutable;
exports.makeRemote = module429.makeRemote;

function _() {
  if (!globals.__sensorContainer) globals.__sensorContainer = new module432.SensorContainer();
  return globals.__sensorContainer;
}

globals._WORKLET = false;

globals._log = function (n) {
  console.log(n);
};

if (!module421.isWeb() && y()) module431.initializeUIRuntime();
var k = {
  enableLayoutAnimations: false,
  setByUser: false,
};
