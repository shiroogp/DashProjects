require('./621');

var n,
  o,
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = D(n);
    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      l = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var s in t)
      if ('default' !== s && Object.prototype.hasOwnProperty.call(t, s)) {
        var c = l ? Object.getOwnPropertyDescriptor(t, s) : null;
        if (c && (c.get || c.set)) Object.defineProperty(u, s, c);
        else u[s] = t[s];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  module619 = require('./619'),
  module409 = require('./409'),
  module405 = require('./405'),
  module507 = require('./507'),
  module606 = require('./606'),
  module408 = require('./408'),
  module615 = require('./615'),
  module609 = require('./609'),
  module611 = require('./611'),
  module612 = require('./612'),
  module515 = require('./515'),
  module403 = require('./403'),
  module404 = require('./404'),
  module607 = require('./607'),
  module406 = require('./406'),
  module620 = require('./620'),
  ReactNative = require('react-native'),
  module4 = require('./4'),
  module622 = require('./622');

function D(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (D = function (t) {
    return t ? o : n;
  })(t);
}

function k() {
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

function K(t, n) {
  var o = ('undefined' != typeof Symbol && t[Symbol.iterator]) || t['@@iterator'];
  if (o) return (o = o.call(t)).next.bind(o);

  if (Array.isArray(t) || (o = Y(t)) || (n && t && 'number' == typeof t.length)) {
    if (o) t = o;
    var u = 0;
    return function () {
      return u >= t.length
        ? {
            done: true,
          }
        : {
            done: false,
            value: t[u++],
          };
    };
  }

  throw new TypeError('Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.');
}

function Y(t, n) {
  if (t) {
    if ('string' == typeof t) return M(t, n);
    var o = Object.prototype.toString.call(t).slice(8, -1);
    if ('Object' === o && t.constructor) o = t.constructor.name;
    return 'Map' === o || 'Set' === o ? Array.from(t) : 'Arguments' === o || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(o) ? M(t, n) : undefined;
  }
}

function M(t, n) {
  if (null == n || n > t.length) n = t.length;

  for (var o = 0, u = new Array(n); o < n; o++) u[o] = t[o];

  return u;
}

var F = [].concat(
  module23.default(module606.baseGestureHandlerWithMonitorProps),
  module23.default(module515.tapGestureHandlerProps),
  module23.default(module612.panGestureHandlerProps),
  module23.default(module612.panGestureHandlerCustomNativeProps),
  module23.default(module611.longPressGestureHandlerProps),
  module23.default(module609.forceTouchGestureHandlerProps),
  module23.default(module615.flingGestureHandlerProps)
);

function W(t) {
  return 'number' == typeof t ? t : t instanceof module619.BaseGesture ? t.handlerTag : null != (n = null == (o = t.current) ? undefined : o.handlerTag) ? n : -1;
  var n, o;
}

function V(t) {
  var n, o;
  return null !=
    (n =
      null == t
        ? undefined
        : null == (o = t.map(W))
        ? undefined
        : o.filter(function (t) {
            return t > 0;
          }))
    ? n
    : [];
}

function j(t) {
  for (var n, o = K(t.config); !(n = o()).done; ) {
    var u = n.value;
    module507.default.dropGestureHandler(u.handlerTag);
    module405.unregisterHandler(u.handlerTag, u.config.testId);
  }

  module606.scheduleFlushOperations();
}

function x(t) {
  if (!t.config.runOnJS) {
    var n = t.handlers.isWorklet.includes(false),
      o = t.handlers.isWorklet.includes(true);
    if (n && o)
      console.error(
        module406.tagMessage(
          "Some of the callbacks in the gesture are worklets and some are not. Either make sure that all calbacks are marked as 'worklet' if you wish to run them on the UI thread or use '.runOnJS(true)' modifier on the gesture explicitly to run all callbacks on the JS thread."
        )
      );
  }
}

function J(t) {
  var n = t.preparedGesture,
    o = t.gestureConfig,
    u = t.gesture,
    l = t.viewTag,
    s = t.webEventHandlersRef,
    c = t.mountedRef;
  if (n.firstExecution) n.firstExecution = false;
  else o.initialize();
  setImmediate(function () {
    if (c.current) o.prepare();
  });

  for (var f, h = K(u); !(f = h()).done; ) {
    var v = f.value;
    x(v);
    module507.default.createGestureHandler(v.handlerName, v.handlerTag, module606.filterConfig(v.config, F));
    module405.registerHandler(v.handlerTag, v, v.config.testId);
  }

  setImmediate(function () {
    if (c.current) {
      for (var t, n = K(u); !(t = n()).done; ) {
        var o = t.value,
          l = [];
        if (o.config.requireToFail) l = V(o.config.requireToFail);
        var s = [];
        if (o.config.simultaneousWith) s = V(o.config.simultaneousWith);
        module507.default.updateGestureHandler(
          o.handlerTag,
          module606.filterConfig(o.config, F, {
            simultaneousHandlers: s,
            waitFor: l,
          })
        );
      }

      module606.scheduleFlushOperations();
    }
  });
  n.config = u;

  for (var E, T = K(n.config); !(E = T()).done; ) {
    var p = E.value,
      L = p.shouldUseReanimated ? module607.ActionType.REANIMATED_WORKLET : module607.ActionType.JS_FUNCTION_NEW_API;
    if ('web' === ReactNative.Platform.OS) module507.default.attachGestureHandler(p.handlerTag, l, module607.ActionType.JS_FUNCTION_OLD_API, s);
    else module507.default.attachGestureHandler(p.handlerTag, l, L);
  }

  if (n.animatedHandlers) {
    n.animatedHandlers.value = u
      .filter(function (t) {
        return t.shouldUseReanimated;
      })
      .map(function (t) {
        return t.handlers;
      });
  }
}

function q(t, n, o, u) {
  n.prepare();

  for (var l = 0; l < o.length; l++) {
    var s = t.config[l];
    x(s);

    if (o[l].handlerTag !== s.handlerTag) {
      o[l].handlerTag = s.handlerTag;
      o[l].handlers.handlerTag = s.handlerTag;
    }
  }

  setImmediate(function () {
    if (u.current) {
      for (var n = 0; n < o.length; n++) {
        var l = t.config[n];
        l.config = o[n].config;
        l.handlers = o[n].handlers;
        var s = V(l.config.requireToFail),
          c = V(l.config.simultaneousWith);
        module507.default.updateGestureHandler(
          l.handlerTag,
          module606.filterConfig(l.config, F, {
            simultaneousHandlers: c,
            waitFor: s,
          })
        );
        module405.registerHandler(l.handlerTag, l, l.config.testId);
      }

      if (t.animatedHandlers) {
        var f,
          h = null != (f = t.animatedHandlers.value) ? f : [],
          v = t.config
            .filter(function (t) {
              return t.shouldUseReanimated;
            })
            .map(function (t) {
              return t.handlers;
            }),
          E = h.length !== v.length;
        if (!E)
          for (var T = 0; T < v.length; T++)
            if (v[T].gestureId !== h[T].gestureId) {
              E = true;
              break;
            }
        if (E) t.animatedHandlers.value = v;
      }

      module606.scheduleFlushOperations();
    }
  });
}

function z(t, n) {
  if (n.length !== t.config.length) return true;

  for (var o = 0; o < n.length; o++) if (n[o].handlerName !== t.config[o].handlerName || n[o].shouldUseReanimated !== t.config[o].shouldUseReanimated) return true;

  return false;
}

function Z(t) {
  'worklet';

  return null != t.oldState;
}

function $(t) {
  'worklet';

  return null != t.eventType;
}

function Q(t, n) {
  'worklet';

  switch (t) {
    case module619.CALLBACK_TYPE.BEGAN:
      return n.onBegin;

    case module619.CALLBACK_TYPE.START:
      return n.onStart;

    case module619.CALLBACK_TYPE.UPDATE:
      return n.onUpdate;

    case module619.CALLBACK_TYPE.CHANGE:
      return n.onChange;

    case module619.CALLBACK_TYPE.END:
      return n.onEnd;

    case module619.CALLBACK_TYPE.FINALIZE:
      return n.onFinalize;

    case module619.CALLBACK_TYPE.TOUCHES_DOWN:
      return n.onTouchesDown;

    case module619.CALLBACK_TYPE.TOUCHES_MOVE:
      return n.onTouchesMove;

    case module619.CALLBACK_TYPE.TOUCHES_UP:
      return n.onTouchesUp;

    case module619.CALLBACK_TYPE.TOUCHES_CANCELLED:
      return n.onTouchesCancelled;
  }
}

function X(t) {
  'worklet';

  switch (t) {
    case module404.TouchEventType.TOUCHES_DOWN:
      return module619.CALLBACK_TYPE.TOUCHES_DOWN;

    case module404.TouchEventType.TOUCHES_MOVE:
      return module619.CALLBACK_TYPE.TOUCHES_MOVE;

    case module404.TouchEventType.TOUCHES_UP:
      return module619.CALLBACK_TYPE.TOUCHES_UP;

    case module404.TouchEventType.TOUCHES_CANCELLED:
      return module619.CALLBACK_TYPE.TOUCHES_CANCELLED;
  }

  return module619.CALLBACK_TYPE.UNDEFINED;
}

function ee(t, n, o) {
  'worklet';

  var u = Q(t, n);

  if (n.isWorklet[t]) {
    for (var l = arguments.length, s = new Array(l > 3 ? l - 3 : 0), c = 3; c < l; c++) s[c - 3] = arguments[c];

    if (!(null == u)) u.apply(undefined, [o].concat(s));
  } else u && console.warn(module406.tagMessage('Animated gesture callback must be a worklet'));
}

function te(t, n) {
  if (module409.Reanimated) {
    var o = module409.Reanimated.useSharedValue(null),
      u = module409.Reanimated.useSharedValue([]),
      l = [],
      s = module409.Reanimated.useEvent(
        function (t) {
          'worklet';

          var n = o.value;
          if (n)
            for (var s = 0; s < n.length; s++) {
              var c = n[s];
              if (t.handlerTag === c.handlerTag)
                Z(t)
                  ? t.oldState === module403.State.UNDETERMINED && t.state === module403.State.BEGAN
                    ? ee(module619.CALLBACK_TYPE.BEGAN, c, t)
                    : (t.oldState !== module403.State.BEGAN && t.oldState !== module403.State.UNDETERMINED) || t.state !== module403.State.ACTIVE
                    ? t.oldState !== t.state && t.state === module403.State.END
                      ? (t.oldState === module403.State.ACTIVE && ee(module619.CALLBACK_TYPE.END, c, t, true), ee(module619.CALLBACK_TYPE.FINALIZE, c, t, true))
                      : (t.state !== module403.State.FAILED && t.state !== module403.State.CANCELLED) ||
                        t.state === t.oldState ||
                        (t.oldState === module403.State.ACTIVE && ee(module619.CALLBACK_TYPE.END, c, t, false), ee(module619.CALLBACK_TYPE.FINALIZE, c, t, false))
                    : (ee(module619.CALLBACK_TYPE.START, c, t), (u.value[c.handlerTag] = undefined))
                  : $(t)
                  ? (l[s] || (l[s] = module408.GestureStateManager.create(t.handlerTag)), t.eventType !== module404.TouchEventType.UNDETERMINED && ee(X(t.eventType), c, t, l[s]))
                  : (ee(module619.CALLBACK_TYPE.UPDATE, c, t),
                    c.onChange &&
                      c.changeEventCalculator &&
                      (ee(module619.CALLBACK_TYPE.CHANGE, c, null == c.changeEventCalculator ? undefined : c.changeEventCalculator(t, u.value[c.handlerTag])),
                      (u.value[c.handlerTag] = t)));
            }
        },
        ['onGestureHandlerStateChange', 'onGestureHandlerEvent'],
        n
      );
    t.animatedEventHandler = s;
    t.animatedHandlers = o;
  }
}

exports.GestureDetector = function (t) {
  var n = t.gesture;
  if (t.userSelect) ne(t.userSelect, n);
  var o = n.toGestureArray(),
    u = o.some(function (t) {
      return t.shouldUseReanimated;
    }),
    l = React.useRef({
      firstRender: true,
      viewRef: null,
      previousViewTag: -1,
      forceReattach: false,
    }).current,
    s = React.useRef(false),
    c = React.useRef({
      onGestureHandlerEvent: function (t) {
        module4.onGestureHandlerEvent(t.nativeEvent);
      },
      onGestureHandlerStateChange: module622.isExperimentalWebImplementationEnabled()
        ? function (t) {
            module4.onGestureHandlerEvent(t.nativeEvent);
          }
        : undefined,
    }),
    f = React.useState(false),
    v = module15.default(f, 2),
    T = v[0],
    p = v[1];
  var C = React.default.useRef({
    config: o,
    animatedEventHandler: null,
    animatedHandlers: null,
    firstExecution: true,
    useReanimatedHook: u,
  }).current;
  if (u !== C.useReanimatedHook) throw new Error(module406.tagMessage('You cannot change the thread the callbacks are ran on while the app is running'));

  function A(t) {
    var u = module606.findNodeHandle(l.viewRef),
      f = u !== l.previousViewTag;

    if (f || z(C, o)) {
      l.viewRef;
      j(C);
      J({
        preparedGesture: C,
        gestureConfig: n,
        gesture: o,
        webEventHandlersRef: c,
        viewTag: u,
        mountedRef: s,
      });
      l.previousViewTag = u;
      l.forceReattach = f;
      if (f) p(!T);
    } else if (!t) q(C, n, o, s);
  }

  var L = C.firstExecution || z(C, o) || l.forceReattach;
  l.forceReattach = false;
  if (C.firstExecution) n.initialize();
  if (u) te(C, L);
  React.useEffect(function () {
    var t = module606.findNodeHandle(l.viewRef);
    l.firstRender = true;
    s.current = true;
    J({
      preparedGesture: C,
      gestureConfig: n,
      gesture: o,
      webEventHandlersRef: c,
      viewTag: t,
      mountedRef: s,
    });
    return function () {
      s.current = false;
      j(C);
    };
  }, []);
  React.useEffect(
    function () {
      if (l.firstRender) l.firstRender = false;
      else A();
    },
    [t]
  );

  var H = function (t) {
    if (null !== t && ((l.viewRef = t), -1 === l.previousViewTag && (l.previousViewTag = module606.findNodeHandle(l.viewRef)), A(true), module406.isFabric())) {
      var n = module620.getShadowNodeFromRef(t);
      if (false === globals.isFormsStackingContext(n))
        console.error(
          module406.tagMessage(
            'GestureDetector has received a child that may get view-flattened. \nTo prevent it from misbehaving you need to wrap the child with a `<View collapsable={false}>`.'
          )
        );
    }
  };

  return u
    ? React.default.createElement(
        ae,
        {
          ref: H,
          onGestureHandlerEvent: C.animatedEventHandler,
        },
        t.children
      )
    : React.default.createElement(
        re,
        {
          ref: H,
        },
        t.children
      );
};

var ne = function (t, n) {
    for (var o, u = K(n.toGestureArray()); !(o = u()).done; ) {
      o.value.config.userSelect = t;
    }
  },
  re = (function (t) {
    module38.default(v, t);

    var n = v,
      o = k(),
      h = function () {
        var t,
          u = module37.default(n);

        if (o) {
          var l = module37.default(this).constructor;
          t = Reflect.construct(u, arguments, l);
        } else t = u.apply(this, arguments);

        return module40.default(this, t);
      };

    function v() {
      module27.default(this, v);
      return h.apply(this, arguments);
    }

    module28.default(v, [
      {
        key: 'render',
        value: function () {
          try {
            var t = React.default.Children.only(this.props.children);
            return React.default.cloneElement(
              t,
              {
                collapsable: false,
              },
              t.props.children
            );
          } catch (t) {
            throw new Error(
              module406.tagMessage(
                'GestureDetector got more than one view as a child. If you want the gesture to work on multiple views, wrap them with a common parent and attach the gesture to that view.'
              )
            );
          }
        },
      },
    ]);
    return v;
  })(React.default.Component),
  ae = null != (n = null == module409.Reanimated ? undefined : null == (o = module409.Reanimated.default) ? undefined : o.createAnimatedComponent(re)) ? n : re;
