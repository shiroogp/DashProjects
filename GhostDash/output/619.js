var module50 = require('./50'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module27 = require('./27'),
  module405 = require('./405'),
  module406 = require('./406');

function v(t, n) {
  var s = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var o = Object.getOwnPropertySymbols(t);
    if (n)
      o = o.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    s.push.apply(s, o);
  }

  return s;
}

function y(t) {
  for (var s = 1; s < arguments.length; s++) {
    var o = null != arguments[s] ? arguments[s] : {};
    if (s % 2)
      v(Object(o), true).forEach(function (s) {
        module50.default(t, s, o[s]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      v(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

function k(t) {
  var n = O();
  return function () {
    var s,
      l = module37.default(t);

    if (n) {
      var h = module37.default(this).constructor;
      s = Reflect.construct(l, arguments, h);
    } else s = l.apply(this, arguments);

    return module40.default(this, s);
  };
}

function O() {
  if ('undefined' == typeof Reflect || !Reflect.construct) return false;
  if (Reflect.construct.sham) return false;
  if ('function' == typeof Proxy) return true;

  try {
    Boolean.prototype.valueOf.call(Reflect.construct(Boolean, [], function () {}));
    return true;
  } catch (t) {
    return false;
  }
}

var p = (exports.CALLBACK_TYPE = {
    UNDEFINED: 0,
    BEGAN: 1,
    START: 2,
    UPDATE: 3,
    CHANGE: 4,
    END: 5,
    FINALIZE: 6,
    TOUCHES_DOWN: 7,
    TOUCHES_MOVE: 8,
    TOUCHES_UP: 9,
    TOUCHES_CANCELLED: 10,
  }),
  E = (exports.Gesture = module28.default(function t() {
    module27.default(this, t);
  })),
  T = 0,
  W = (exports.BaseGesture = (function (t) {
    module38.default(o, t);
    var n = k(o);

    function o() {
      var t;
      module27.default(this, o);
      (t = n.call(this)).gestureId = -1;
      t.handlerTag = -1;
      t.handlerName = '';
      t.config = {};
      t.handlers = {
        gestureId: -1,
        handlerTag: -1,
        isWorklet: [],
      };
      t.gestureId = T++;
      t.handlers.gestureId = t.gestureId;
      return t;
    }

    module28.default(o, [
      {
        key: 'addDependency',
        value: function (t, n) {
          var s = this.config[t];
          this.config[t] = s ? Array().concat(s, n) : [n];
        },
      },
      {
        key: 'withRef',
        value: function (t) {
          this.config.ref = t;
          return this;
        },
      },
      {
        key: 'isWorklet',
        value: function (t) {
          return undefined !== t.__workletHash;
        },
      },
      {
        key: 'onBegin',
        value: function (t) {
          this.handlers.onBegin = t;
          this.handlers.isWorklet[p.BEGAN] = this.isWorklet(t);
          return this;
        },
      },
      {
        key: 'onStart',
        value: function (t) {
          this.handlers.onStart = t;
          this.handlers.isWorklet[p.START] = this.isWorklet(t);
          return this;
        },
      },
      {
        key: 'onEnd',
        value: function (t) {
          this.handlers.onEnd = t;
          this.handlers.isWorklet[p.END] = this.isWorklet(t);
          return this;
        },
      },
      {
        key: 'onFinalize',
        value: function (t) {
          this.handlers.onFinalize = t;
          this.handlers.isWorklet[p.FINALIZE] = this.isWorklet(t);
          return this;
        },
      },
      {
        key: 'onTouchesDown',
        value: function (t) {
          this.config.needsPointerData = true;
          this.handlers.onTouchesDown = t;
          this.handlers.isWorklet[p.TOUCHES_DOWN] = this.isWorklet(t);
          return this;
        },
      },
      {
        key: 'onTouchesMove',
        value: function (t) {
          this.config.needsPointerData = true;
          this.handlers.onTouchesMove = t;
          this.handlers.isWorklet[p.TOUCHES_MOVE] = this.isWorklet(t);
          return this;
        },
      },
      {
        key: 'onTouchesUp',
        value: function (t) {
          this.config.needsPointerData = true;
          this.handlers.onTouchesUp = t;
          this.handlers.isWorklet[p.TOUCHES_UP] = this.isWorklet(t);
          return this;
        },
      },
      {
        key: 'onTouchesCancelled',
        value: function (t) {
          this.config.needsPointerData = true;
          this.handlers.onTouchesCancelled = t;
          this.handlers.isWorklet[p.TOUCHES_CANCELLED] = this.isWorklet(t);
          return this;
        },
      },
      {
        key: 'enabled',
        value: function (t) {
          this.config.enabled = t;
          return this;
        },
      },
      {
        key: 'shouldCancelWhenOutside',
        value: function (t) {
          this.config.shouldCancelWhenOutside = t;
          return this;
        },
      },
      {
        key: 'hitSlop',
        value: function (t) {
          this.config.hitSlop = t;
          return this;
        },
      },
      {
        key: 'runOnJS',
        value: function (t) {
          this.config.runOnJS = t;
          return this;
        },
      },
      {
        key: 'simultaneousWithExternalGesture',
        value: function (...args) {
          for (var o = 0, u = args; o < u.length; o++) {
            var l = u[o];
            this.addDependency('simultaneousWith', l);
          }

          return this;
        },
      },
      {
        key: 'requireExternalGestureToFail',
        value: function (...args) {
          for (var o = 0, u = args; o < u.length; o++) {
            var l = u[o];
            this.addDependency('requireToFail', l);
          }

          return this;
        },
      },
      {
        key: 'withTestId',
        value: function (t) {
          this.config.testId = t;
          return this;
        },
      },
      {
        key: 'cancelsTouchesInView',
        value: function (t) {
          this.config.cancelsTouchesInView = t;
          return this;
        },
      },
      {
        key: 'initialize',
        value: function () {
          this.handlerTag = module405.getNextHandlerTag();
          this.handlers = y(
            y({}, this.handlers),
            {},
            {
              handlerTag: this.handlerTag,
            }
          );
          if (this.config.ref) this.config.ref.current = this;
        },
      },
      {
        key: 'toGestureArray',
        value: function () {
          return [this];
        },
      },
      {
        key: 'prepare',
        value: function () {},
      },
      {
        key: 'shouldUseReanimated',
        get: function () {
          return true !== this.config.runOnJS && !this.handlers.isWorklet.includes(false) && !module406.isRemoteDebuggingEnabled();
        },
      },
    ]);
    return o;
  })(E));

exports.ContinousBaseGesture = (function (t) {
  module38.default(o, t);
  var n = k(o);

  function o() {
    module27.default(this, o);
    return n.apply(this, arguments);
  }

  module28.default(o, [
    {
      key: 'onUpdate',
      value: function (t) {
        this.handlers.onUpdate = t;
        this.handlers.isWorklet[p.UPDATE] = this.isWorklet(t);
        return this;
      },
    },
    {
      key: 'onChange',
      value: function (t) {
        this.handlers.onChange = t;
        this.handlers.isWorklet[p.CHANGE] = this.isWorklet(t);
        return this;
      },
    },
    {
      key: 'manualActivation',
      value: function (t) {
        this.config.manualActivation = t;
        return this;
      },
    },
  ]);
  return o;
})(W);
