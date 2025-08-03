exports.default = function (t) {
  var n = t.name,
    o = t.allowedProps,
    h = undefined === o ? [] : o,
    G = t.config,
    C = undefined === G ? {} : G,
    D = t.transformProps,
    P = t.customNativeProps,
    I = undefined === P ? [] : P,
    _ = (function (t) {
      module38.default(_, t);

      var o = _,
        G = N(),
        P = function () {
          var t,
            n = module37.default(o);

          if (G) {
            var u = module37.default(this).constructor;
            t = Reflect.construct(n, arguments, u);
          } else t = n.apply(this, arguments);

          return module40.default(this, t);
        };

      function _(t) {
        var o;

        if (
          (module27.default(this, _),
          ((o = P.call(this, t)).updateEnqueued = null),
          (o.onGestureHandlerEvent = function (t) {
            if (t.nativeEvent.handlerTag === o.handlerTag) {
              if ('function' == typeof o.props.onGestureEvent) null == o.props.onGestureEvent || o.props.onGestureEvent(t);
            } else if (!(null == o.props.onGestureHandlerEvent)) o.props.onGestureHandlerEvent(t);
          }),
          (o.onGestureHandlerStateChange = function (t) {
            if (t.nativeEvent.handlerTag === o.handlerTag) {
              if ('function' == typeof o.props.onHandlerStateChange) null == o.props.onHandlerStateChange || o.props.onHandlerStateChange(t);
              var n = t.nativeEvent.state,
                u = J[n],
                s = u && o.props[u];
              if (s && 'function' == typeof s) s(t);
            } else null == o.props.onGestureHandlerStateChange || o.props.onGestureHandlerStateChange(t);
          }),
          (o.refHandler = function (t) {
            o.viewNode = t;
            var n = React.Children.only(o.props.children),
              u = n.ref;
            if (null !== u) 'function' == typeof u ? u(t) : (u.current = t);
          }),
          (o.createGestureHandler = function (t) {
            o.config = t;
            module507.default.createGestureHandler(n, o.handlerTag, t);
          }),
          (o.attachGestureHandler = function (t) {
            if (((o.viewTag = t), 'web' === ReactNative.Platform.OS)) module507.default.attachGestureHandler(o.handlerTag, t, module607.ActionType.JS_FUNCTION_OLD_API, o.propsRef);
            else {
              module405.registerOldGestureHandler(o.handlerTag, {
                onGestureEvent: o.onGestureHandlerEvent,
                onGestureStateChange: o.onGestureHandlerStateChange,
              });
              var n =
                null != (u = o.props) && u.onGestureEvent && 'current' in o.props.onGestureEvent
                  ? module607.ActionType.REANIMATED_WORKLET
                  : null != (s = o.props) && s.onGestureEvent && '__isNative' in o.props.onGestureEvent
                  ? module607.ActionType.NATIVE_ANIMATED_EVENT
                  : module607.ActionType.JS_FUNCTION_OLD_API;
              module507.default.attachGestureHandler(o.handlerTag, t, n);
            }
            var u, s;
            module606.scheduleFlushOperations();
          }),
          (o.updateGestureHandler = function (t) {
            o.config = t;
            module507.default.updateGestureHandler(o.handlerTag, t);
            module606.scheduleFlushOperations();
          }),
          (o.handlerTag = module405.getNextHandlerTag()),
          (o.config = {}),
          (o.propsRef = React.createRef()),
          (o.state = {
            allowTouches: k,
          }),
          t.id)
        ) {
          if (undefined !== module405.handlerIDToTag[t.id]) throw new Error('Handler with ID "' + t.id + '" already registered');
          module405.handlerIDToTag[t.id] = o.handlerTag;
        }

        return o;
      }

      module28.default(_, [
        {
          key: 'componentDidMount',
          value: function () {
            var t = this,
              n = this.props;
            if (F(n))
              this.updateEnqueued = setImmediate(function () {
                t.updateEnqueued = null;
                t.update(q);
              });
            this.createGestureHandler(module606.filterConfig(D ? D(this.props) : this.props, [].concat(module23.default(h), module23.default(I)), C));
            this.attachGestureHandler(module606.findNodeHandle(this.viewNode));
          },
        },
        {
          key: 'componentDidUpdate',
          value: function () {
            var t = module606.findNodeHandle(this.viewNode);
            if (this.viewTag !== t) this.attachGestureHandler(t);
            this.update(q);
          },
        },
        {
          key: 'componentWillUnmount',
          value: function () {
            var t;
            if (!(null == (t = this.inspectorToggleListener))) t.remove();
            module507.default.dropGestureHandler(this.handlerTag);
            module606.scheduleFlushOperations();
            if (this.updateEnqueued) clearImmediate(this.updateEnqueued);
            var n = this.props.id;
            if (n) delete module405.handlerIDToTag[n];
          },
        },
        {
          key: 'update',
          value: function (t) {
            var n = this,
              o = this.props;
            if (F(o) && t > 0)
              this.updateEnqueued = setImmediate(function () {
                n.updateEnqueued = null;
                n.update(t - 1);
              });
            else {
              var s = module606.filterConfig(D ? D(this.props) : this.props, [].concat(module23.default(h), module23.default(I)), C);
              if (!module517.default(this.config, s)) this.updateGestureHandler(s);
            }
          },
        },
        {
          key: 'setNativeProps',
          value: function (t) {
            var n = b(b({}, this.props), t),
              o = module606.filterConfig(D ? D(n) : n, [].concat(module23.default(h), module23.default(I)), C);
            this.updateGestureHandler(o);
          },
        },
        {
          key: 'render',
          value: function () {
            var t,
              o = this.onGestureHandlerEvent,
              u = this.props,
              s = u.onGestureEvent,
              l = u.onGestureHandlerEvent;

            if (s && 'function' != typeof s) {
              if (l) throw new Error('Nesting touch handlers with native animated driver is not supported yet');
              o = s;
            } else if (l && 'function' != typeof l) throw new Error('Nesting touch handlers with native animated driver is not supported yet');

            var p = this.onGestureHandlerStateChange,
              c = this.props,
              f = c.onHandlerStateChange,
              h = c.onGestureHandlerStateChange;

            if (f && 'function' != typeof f) {
              if (h) throw new Error('Nesting touch handlers with native animated driver is not supported yet');
              p = f;
            } else if (h && 'function' != typeof h) throw new Error('Nesting touch handlers with native animated driver is not supported yet');

            var y = {
              onGestureHandlerEvent: this.state.allowTouches ? o : undefined,
              onGestureHandlerStateChange: this.state.allowTouches ? p : undefined,
            };
            this.propsRef.current = y;
            var E = null;

            try {
              E = React.Children.only(this.props.children);
            } catch (t) {
              throw new Error(
                module406.tagMessage(
                  n + ' got more than one view as a child. If you want the gesture to work on multiple views, wrap them with a common parent and attach the gesture to that view.'
                )
              );
            }

            var w = E.props.children;
            return React.cloneElement(
              E,
              b(
                b(
                  {
                    ref: this.refHandler,
                    collapsable: false,
                  },
                  module406.isJestEnv()
                    ? {
                        handlerType: n,
                        handlerTag: this.handlerTag,
                      }
                    : {}
                ),
                {},
                {
                  testID: null != (t = this.props.testID) ? t : E.props.testID,
                },
                y
              ),
              w
            );
          },
        },
      ]);
      return _;
    })(React.Component);

  _.displayName = n;
  return _;
};

var n,
  o,
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module50 = require('./50'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = C(n);
    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      s = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var l in t)
      if ('default' !== l && Object.prototype.hasOwnProperty.call(t, l)) {
        var p = s ? Object.getOwnPropertyDescriptor(t, l) : null;
        if (p && (p.get || p.set)) Object.defineProperty(u, l, p);
        else u[l] = t[l];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  ReactNative = require('react-native'),
  module517 = require('./517'),
  module507 = require('./507'),
  module403 = require('./403'),
  module405 = require('./405'),
  module606 = require('./606'),
  module406 = require('./406'),
  module607 = require('./607');

require('./608');

function C(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (C = function (t) {
    return t ? o : n;
  })(t);
}

function N() {
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

function D(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var u = Object.getOwnPropertySymbols(t);
    if (n)
      u = u.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, u);
  }

  return o;
}

function b(t) {
  for (var n = 1; n < arguments.length; n++) {
    var o = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      D(Object(o), true).forEach(function (n) {
        module50.default(t, n, o[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      D(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

var P = ReactNative.UIManager,
  I = b(
    {
      onGestureHandlerEvent: {
        registrationName: 'onGestureHandlerEvent',
      },
      onGestureHandlerStateChange: {
        registrationName: 'onGestureHandlerStateChange',
      },
    },
    module406.isFabric() &&
      'android' === ReactNative.Platform.OS && {
        topOnGestureHandlerEvent: {
          registrationName: 'onGestureHandlerEvent',
        },
        topOnGestureHandlerStateChange: {
          registrationName: 'onGestureHandlerStateChange',
        },
      }
  );
P.genericDirectEventTypes = b(b({}, P.genericDirectEventTypes), I);

var _ = null != (n = null == P.getViewManagerConfig ? undefined : P.getViewManagerConfig('getConstants')) ? n : null == P.getConstants ? undefined : P.getConstants();

if (_) _.genericDirectEventTypes = b(b({}, _.genericDirectEventTypes), I);
var j = P.setJSResponder,
  A = undefined === j ? function () {} : j,
  R = P.clearJSResponder,
  M = undefined === R ? function () {} : R;

P.setJSResponder = function (t, n) {
  module507.default.handleSetJSResponder(t, n);
  A(t, n);
};

P.clearJSResponder = function () {
  module507.default.handleClearJSResponder();
  M();
};

var k = true;

function F(t) {
  var n = function (t) {
    return Array.isArray(t)
      ? t.some(function (t) {
          return t && null === t.current;
        })
      : t && null === t.current;
  };

  return n(t.simultaneousHandlers) || n(t.waitFor);
}

o = {};
module50.default(o, module403.State.UNDETERMINED, undefined);
module50.default(o, module403.State.BEGAN, 'onBegan');
module50.default(o, module403.State.FAILED, 'onFailed');
module50.default(o, module403.State.CANCELLED, 'onCancelled');
module50.default(o, module403.State.ACTIVE, 'onActivated');
module50.default(o, module403.State.END, 'onEnded');
var J = o,
  q = 1;
