exports.runOnJS = function (n) {
  'worklet';

  if (n.__remoteFunction) n = n.__remoteFunction;
  if (!_WORKLET) return n;
  return function (...args) {
    _scheduleOnJS(n, args.length > 0 ? module423.makeShareableCloneOnUIRecursive(args) : undefined);
  };
};

exports.runOnUI = function (n) {
  'worklet';

  return function (...args) {
    if (s)
      module414.default.scheduleOnUI(
        module423.makeShareableCloneRecursive(function () {
          n.apply(undefined, args);
        })
      );
    else {
      f.push([n, args]);
      if (1 === f.length)
        queueMicrotask(function () {
          var n = f;
          f = [];
          module414.default.scheduleOnUI(
            module423.makeShareableCloneRecursive(function () {
              n.forEach(function (n) {
                var o = module15.default(n, 2),
                  l = o[0],
                  c = o[1];
                l.apply(undefined, module23.default(c));
              });
              h();
            })
          );
        });
    }
  };
};

exports.runOnUIImmediately = function (n) {
  'worklet';

  return function (...args) {
    module414.default.scheduleOnUI(
      module423.makeShareableCloneRecursive(function () {
        n.apply(undefined, args);
      })
    );
  };
};

exports.setupMicrotasks = function () {
  'worklet';

  var n = [],
    t = false;

  globals.queueMicrotask = function (t) {
    n.push(t);
    return -1;
  };

  globals.__callMicrotasks = function () {
    if (!t)
      try {
        t = true;

        for (var u = 0; u < n.length; u += 1) n[u]();

        n = [];

        globals._maybeFlushUIUpdatesQueue();
      } finally {
        t = false;
      }
  };
};

module421.shouldBeUseWeb();

var module15 = require('@babel/runtime/helpers/slicedToArray'),
  module414 = require('./414'),
  module421 = require('./421'),
  module423 = require('./423'),
  s = module421.isJest(),
  f = [];

var h = (exports.callMicrotasks = module421.shouldBeUseWeb()
  ? function () {}
  : function () {
      'worklet';

      globals.__callMicrotasks();
    });
