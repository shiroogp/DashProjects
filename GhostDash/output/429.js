exports.makeMutable = function (t) {
  var s,
    f = arguments.length > 1 && undefined !== arguments[1] && arguments[1],
    c = t;

  if (!f && module414.default.native) {
    s = module414.default.makeSynchronizedDataHolder(module423.makeShareableCloneRecursive(c));
    module423.registerShareableMapping(s);
  }

  var h = module423.makeShareableCloneRecursive({
      __init: function () {
        'worklet';

        return v(t, s);
      },
    }),
    p = module414.default.native ? undefined : new Map(),
    _ = {
      set value(t) {
        if (module414.default.native)
          module426.runOnUI(function () {
            _.value = t;
          })();
        else module430.valueSetter(_, t);
      },

      get value() {
        return s ? module414.default.getDataSynchronously(s) : c;
      },

      set _value(t) {
        if (module414.default.native) throw new Error('Setting `_value` directly is only possible on the UI runtime');
        c = t;
        p.forEach(function (n) {
          n(t);
        });
      },

      get _value() {
        if (module414.default.native) throw new Error('Reading from `_value` directly is only possible on the UI runtime');
        return c;
      },

      modify: function (t) {
        module426.runOnUI(function () {
          _.value = t(_.value);
        })();
      },
      addListener: function (t, u) {
        if (module414.default.native) throw new Error('adding listeners is only possible on the UI runtime');
        p.set(t, u);
      },
      removeListener: function (t) {
        if (module414.default.native) throw new Error('removing listeners is only possible on the UI runtime');
        p.delete(t);
      },
      _isReanimatedSharedValue: true,
    };
  module423.registerShareableMapping(_, h);
  return _;
};

exports.makeRemote = function () {
  var t = arguments.length > 0 && undefined !== arguments[0] ? arguments[0] : {},
    n = module423.makeShareableCloneRecursive({
      __init: function () {
        'worklet';

        return t;
      },
    });
  module423.registerShareableMapping(t, n);
  return t;
};

exports.makeUIMutable = v;
Object.defineProperty(exports, 'stopMapper', {
  enumerable: true,
  get: function () {
    return module425.stopMapper;
  },
});

var module414 = require('./414'),
  module423 = require('./423'),
  module426 = require('./426'),
  module430 = require('./430'),
  module425 = require('./425');

function v(t, n) {
  'worklet';

  var l = new Map(),
    s = t,
    v = {
      set value(t) {
        module430.valueSetter(v, t);
      },

      get value() {
        return s;
      },

      set _value(t) {
        s = t;
        if (n) _updateDataSynchronously(n, module423.makeShareableCloneOnUIRecursive(t));
        l.forEach(function (n) {
          n(t);
        });
      },

      get _value() {
        return s;
      },

      addListener: function (t, n) {
        l.set(t, n);
      },
      removeListener: function (t) {
        l.delete(t);
      },
      _animation: null,
      _isReanimatedSharedValue: true,
    };
  return v;
}
