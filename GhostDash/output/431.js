exports.initializeUIRuntime = initializeUIRuntime;

var module50 = require('./50'),
  module424 = require('./424'),
  module414 = require('./414'),
  module421 = require('./421'),
  module426 = require('./426');

function ownKeys(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var c = Object.getOwnPropertySymbols(t);
    if (n)
      c = c.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, c);
  }

  return o;
}

function _objectSpread(t) {
  for (var n = 1; n < arguments.length; n++) {
    var o = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      ownKeys(Object(o), true).forEach(function (n) {
        module50.default(t, n, o[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      ownKeys(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

function callGuardDEV(t) {
  'worklet';

  for (var n = arguments.length, o = new Array(n > 1 ? n - 1 : 0), c = 1; c < n; c++) o[c - 1] = arguments[c];

  try {
    t.apply(undefined, o);
  } catch (t) {
    if (!globals.__ErrorUtils) throw t;

    globals.__ErrorUtils.reportFatalError(t);
  }
}

function valueUnpacker(objectToUnpack, category) {
  'worklet';

  var workletsCache = globals.__workletsCache,
    handleCache = globals.__handleCache;

  if (undefined === workletsCache) {
    workletsCache = globals.__workletsCache = new Map();
    handleCache = globals.__handleCache = new WeakMap();
  }

  var workletHash = objectToUnpack.__workletHash;

  if (undefined !== workletHash) {
    var workletFun = workletsCache.get(workletHash);

    if (undefined === workletFun) {
      var initData = objectToUnpack.__initData;
      workletFun = globals.evalWithSourceMap
        ? globals.evalWithSourceMap('(' + initData.code + '\n)', initData.location, initData.sourceMap)
        : globals.evalWithSourceUrl
        ? globals.evalWithSourceUrl('(' + initData.code + '\n)', 'worklet_' + workletHash)
        : eval('(' + initData.code + '\n)');
      workletsCache.set(workletHash, workletFun);
    }

    var functionInstance = workletFun.bind(objectToUnpack);
    objectToUnpack._recur = functionInstance;
    return functionInstance;
  }

  if (objectToUnpack.__init) {
    var value = handleCache.get(objectToUnpack);

    if (undefined === value) {
      value = objectToUnpack.__init();
      handleCache.set(objectToUnpack, value);
    }

    return value;
  }

  if ('RemoteFunction' === category) {
    var fun = function () {
      throw new Error(
        'Tried to synchronously call a non-worklet function on the UI thread.\n\nPossible solutions are:\n  a) If you want to synchronously execute this method, mark it as a worklet\n  b) If you want to execute this function on the JS thread, wrap it using `runOnJS`'
      );
    };

    fun.__remoteFunction = objectToUnpack;
    return fun;
  }

  throw new Error('data type not recognized by unpack method');
}

function setupRequestAnimationFrame() {
  'worklet';

  var t = globals.requestAnimationFrame,
    n = [],
    o = -1;

  globals.__flushAnimationFrame = function (t) {
    var o = n;
    n = [];
    o.forEach(function (n) {
      return n(t);
    });
    module426.callMicrotasks();
  };

  globals.requestAnimationFrame = function (c) {
    n.push(c);
    if (1 === n.length)
      t(function (t) {
        if (!(o >= t)) {
          o = t;
          globals.__frameTimestamp = t;

          globals.__flushAnimationFrame(t);

          globals.__frameTimestamp = undefined;
        }
      });
    return -1;
  };
}

function initializeUIRuntime() {
  module414.default.installCoreFunctions(callGuardDEV, valueUnpacker);
  var t = module421.isJest(),
    n = module421.isChromeDebugger();
  if (t)
    globals.requestAnimationFrame = function (t) {
      return setTimeout(function () {
        return t(performance.now());
      }, 0);
    };

  var o = _objectSpread({}, console);

  module426.runOnUIImmediately(function () {
    'worklet';

    globals.__ErrorUtils = {
      reportFatalError: function (t) {
        module426.runOnJS(module424.reportFatalErrorOnJS)({
          message: t.message,
          stack: t.stack,
        });
      },
    };
    if (!n)
      globals.console = {
        assert: module426.runOnJS(o.assert),
        debug: module426.runOnJS(o.debug),
        log: module426.runOnJS(o.log),
        warn: module426.runOnJS(o.warn),
        error: module426.runOnJS(o.error),
        info: module426.runOnJS(o.info),
      };

    if (!t) {
      module426.setupMicrotasks();
      setupRequestAnimationFrame();
    }
  })();
}
