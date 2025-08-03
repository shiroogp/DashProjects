exports.default = function (t, o) {
  module6.default(
    'function' != typeof t || (t.prototype && t.prototype.isReactComponent),
    "Looks like you're passing a function component `" +
      t.name +
      '` to `createAnimatedComponent` function which supports only class components. Please wrap your function component with `React.forwardRef()` or use a class component instead.'
  );

  var j = (function (w) {
    module38.default(z, w);

    var j = z,
      V = M(),
      F = function () {
        var t,
          n = module37.default(j);

        if (V) {
          var o = module37.default(this).constructor;
          t = Reflect.construct(n, arguments, o);
        } else t = n.apply(this, arguments);

        return module40.default(this, t);
      };

    function z(t) {
      var n;
      module27.default(this, z);
      (n = F.call(this, t))._styles = null;
      n._viewTag = -1;
      n._isFirstRender = true;
      n.animatedStyle = {
        value: {},
      };
      n.initialStyle = {};
      n._component = null;
      n._inlinePropsViewDescriptors = null;
      n._inlinePropsMapperId = null;
      n._inlineProps = {};
      n._setComponentRef = module434.default({
        getForwardedRef: function () {
          return n.props.forwardedRef;
        },
        setLocalRef: function (t) {
          var o = ReactNative.findNodeHandle(t),
            s = n.props,
            l = s.layout,
            u = s.entering,
            c = s.exiting,
            f = s.sharedTransitionTag;

          if (
            (l || u || c || f) &&
            null != o &&
            (module421.shouldBeUseWeb() || module422.enableLayoutAnimations(true, false),
            l && module422.configureLayoutAnimations(o, module457.LayoutAnimationType.LAYOUT, W(l)),
            u && module422.configureLayoutAnimations(o, module457.LayoutAnimationType.ENTERING, W(u)),
            c && module422.configureLayoutAnimations(o, module457.LayoutAnimationType.EXITING, W(c)),
            f)
          ) {
            var p,
              v = null != (p = n.props.sharedTransitionStyle) ? p : module457.DefaultSharedTransition;
            module422.configureLayoutAnimations(o, module457.LayoutAnimationType.SHARED_ELEMENT_TRANSITION, W(v), f);
          }

          if (t !== n._component) n._component = t;
        },
      });
      if (module421.isJest())
        n.animatedStyle = {
          value: {},
        };
      return n;
    }

    module28.default(z, [
      {
        key: 'componentWillUnmount',
        value: function () {
          this._detachNativeEvents();

          this._detachStyles();

          this._detachInlineProps();
        },
      },
      {
        key: 'componentDidMount',
        value: function () {
          this._attachNativeEvents();

          this._attachAnimatedStyles();

          this._attachInlineProps();
        },
      },
      {
        key: '_getEventViewRef',
        value: function () {
          var t;
          return null != (t = this._component) && t.getScrollableNode ? this._component.getScrollableNode() : this._component;
        },
      },
      {
        key: '_attachNativeEvents',
        value: function () {
          var t = this._getEventViewRef(),
            n = null;

          for (var s in this.props) {
            var l = this.props[s];

            if (G('current', l) && l.current instanceof module413.default) {
              if (null === n) n = ReactNative.findNodeHandle(null != o && o.setNativeProps ? this : t);
              l.current.registerForEvents(n, s);
            }
          }
        },
      },
      {
        key: '_detachNativeEvents',
        value: function () {
          for (var t in this.props) {
            var n = this.props[t];
            if (G('current', n) && n.current instanceof module413.default) n.current.unregisterFromEvents();
          }
        },
      },
      {
        key: '_detachStyles',
        value: function () {
          if ('web' === ReactNative.Platform.OS && null !== this._styles)
            for (var t, n = C(this._styles); !(t = n()).done; ) {
              var o = t.value;
              if (null != o && o.viewsRef) o.viewsRef.remove(this);
            }
          else if (-1 !== this._viewTag && null !== this._styles) {
            for (var s, l, u = C(this._styles); !(l = u()).done; ) {
              var c = l.value;
              c.viewDescriptors.remove(this._viewTag);
            }

            if ((null != (s = this.props.animatedProps) && s.viewDescriptors && this.props.animatedProps.viewDescriptors.remove(this._viewTag), globals._IS_FABRIC)) {
              var f = this._viewTag;
              module422.runOnUI(function () {
                _removeShadowNodeFromRegistry(f);
              })();
            }
          }
        },
      },
      {
        key: '_reattachNativeEvents',
        value: function (t) {
          for (var n in t) {
            var s = this.props[n];
            if (G('current', s) && s.current instanceof module413.default && s.current.reattachNeeded) s.current.unregisterFromEvents();
          }

          var l = null;

          for (var u in this.props) {
            var c = this.props[u];

            if (G('current', c) && c.current instanceof module413.default && c.current.reattachNeeded) {
              if (null === l) {
                var f = this._getEventViewRef();

                l = ReactNative.findNodeHandle(null != o && o.setNativeProps ? this : f);
              }

              c.current.registerForEvents(l, u);
              c.current.reattachNeeded = false;
            }
          }
        },
      },
      {
        key: '_updateFromNative',
        value: function (t) {
          var n;
          if (null != o && o.setNativeProps) o.setNativeProps(this._component, t);
          else if (!(null == (n = this._component) || null == n.setNativeProps)) n.setNativeProps(t);
        },
      },
      {
        key: '_getViewInfo',
        value: function () {
          var t,
            n,
            o,
            s,
            l = null,
            u = null != (t = this._component) && t.getAnimatableRef ? this._component.getAnimatableRef() : this;

          if ('web' === ReactNative.Platform.OS) {
            n = ReactNative.findNodeHandle(u);
            o = null;
            l = null;
            s = null;
          } else {
            var c,
              f = module456.RNRenderer.findHostInstance_DEPRECATED(u);
            if (!f) throw new Error('Cannot find host instance for this component. Maybe it renders nothing?');
            n = null == f ? undefined : f._nativeTag;
            o = null == f ? undefined : null == (c = f.viewConfig) ? undefined : c.uiViewClassName;
            s = null == f ? undefined : f.viewConfig;
            if (globals._IS_FABRIC) l = module478.getShadowNodeWrapperFromRef(this);
          }

          return {
            viewTag: n,
            viewName: o,
            shadowNodeWrapper: l,
            viewConfig: s,
          };
        },
      },
      {
        key: '_attachAnimatedStyles',
        value: function () {
          var t,
            n,
            o = this,
            s = this.props.style ? U(H(this.props.style)) : [],
            l = this._styles;
          this._styles = s;
          var u = this._animatedProps;
          this._animatedProps = this.props.animatedProps;

          var c = this._getViewInfo(),
            f = c.viewTag,
            p = c.viewName,
            v = c.shadowNodeWrapper,
            h = c.viewConfig,
            y = (null == (t = this.props.animatedProps) ? undefined : t.viewDescriptors) || s.length;

          if ((y && h && module455.adaptViewConfig(h), (this._viewTag = f), l)) {
            var _ = 1 === s.length && 1 === l.length && B(s[0], l[0]);

            if (!_)
              for (
                var w,
                  P = function (t) {
                    var n = s.some(function (n) {
                      return B(n, t);
                    });
                    if (!n) t.viewDescriptors.remove(f);
                  },
                  N = C(l);
                !(w = N()).done;

              ) {
                var R = w.value;
                P(R);
              }
          }

          s.forEach(function (t) {
            t.viewDescriptors.add({
              tag: f,
              name: p,
              shadowNodeWrapper: v,
            });

            if (module421.isJest()) {
              o.animatedStyle.value = T(T({}, o.animatedStyle.value), t.initial.value);
              t.animatedStyle.current = o.animatedStyle;
            }
          });
          if (u && !x(u, this.props.animatedProps)) u.viewDescriptors.remove(f);
          if (null != (n = this.props.animatedProps) && n.viewDescriptors)
            this.props.animatedProps.viewDescriptors.add({
              tag: f,
              name: p,
              shadowNodeWrapper: v,
            });
        },
      },
      {
        key: '_attachInlineProps',
        value: function () {
          var t = Y(this.props),
            n = $(t, this._inlineProps);

          if (n) {
            if (!this._inlinePropsViewDescriptors) {
              this._inlinePropsViewDescriptors = module477.makeViewDescriptorsSet();

              var o = this._getViewInfo(),
                s = o.viewTag,
                l = o.viewName,
                u = o.shadowNodeWrapper,
                c = o.viewConfig;

              if (Object.keys(t).length && c) module455.adaptViewConfig(c);

              this._inlinePropsViewDescriptors.add({
                tag: s,
                name: l,
                shadowNodeWrapper: u,
              });
            }

            var f = this._inlinePropsViewDescriptors.sharableViewDescriptors,
              p = module414.default.native
                ? undefined
                : {
                    items: new Set([this]),
                  };
            this._inlineProps = t;
            if (this._inlinePropsMapperId) module422.stopMapper(this._inlinePropsMapperId);
            this._inlinePropsMapperId = null;
            if (Object.keys(t).length)
              this._inlinePropsMapperId = module422.startMapper(function () {
                'worklet';

                var n = q(t);
                module442.default(f, n, p);
              }, Object.values(t));
          }
        },
      },
      {
        key: '_detachInlineProps',
        value: function () {
          if (this._inlinePropsMapperId) module422.stopMapper(this._inlinePropsMapperId);
        },
      },
      {
        key: 'componentDidUpdate',
        value: function (t) {
          this._reattachNativeEvents(t);

          this._attachAnimatedStyles();

          this._attachInlineProps();
        },
      },
      {
        key: '_filterNonAnimatedProps',
        value: function (t) {
          var n = this,
            o = {},
            s = function () {
              var s = t[l];

              if ('style' === l) {
                var u = t.style,
                  c = H(null != u ? u : []),
                  f = c.map(function (t) {
                    if (t && t.viewDescriptors) {
                      t.viewsRef.add(n);
                      if (n._isFirstRender) n.initialStyle = T(T({}, t.initial.value), module445.initialUpdaterRun(t.initial.updater));
                      return n.initialStyle;
                    }

                    if (X(t)) {
                      if (n._isFirstRender) return q(t);

                      for (var o = {}, s = 0, l = Object.entries(t); s < l.length; s++) {
                        var u = l[s],
                          c = module15.default(u, 2),
                          f = c[0],
                          v = c[1];
                        if (!(module479.isSharedValue(v) || ('transform' === f && J(v)))) o[f] = v;
                      }

                      return o;
                    }

                    return t;
                  });
                o[l] = ReactNative.StyleSheet.flatten(f);
              } else if ('animatedProps' === l) {
                var v = t.animatedProps;
                if (undefined !== v.initial)
                  Object.keys(v.initial.value).forEach(function (t) {
                    var s, l;
                    o[t] = null == (s = v.initial) ? undefined : s.value[t];
                    if (!(null == (l = v.viewsRef))) l.add(n);
                  });
              } else
                G('current', s) && s.current instanceof module413.default
                  ? s.current.eventNames.length > 0
                    ? s.current.eventNames.forEach(function (t) {
                        o[t] = G('listeners', s.current) ? s.current.listeners[t] : L;
                      })
                    : (o[l] = L)
                  : module479.isSharedValue(s)
                  ? n._isFirstRender && (o[l] = s.value)
                  : ('onGestureHandlerStateChange' === l && module421.isChromeDebugger()) || (o[l] = s);
            };

          for (var l in t) s();

          return o;
        },
      },
      {
        key: 'render',
        value: function () {
          var o = this._filterNonAnimatedProps(this.props);

          if (module421.isJest()) o.animatedStyle = this.animatedStyle;
          if (this._isFirstRender) this._isFirstRender = false;
          var s = ReactNative.Platform.select({
            web: {},
            default: {
              collapsable: false,
            },
          });
          return React.default.createElement(
            t,
            module14.default(
              {},
              o,
              {
                ref: this._setComponentRef,
              },
              s
            )
          );
        },
      },
    ]);
    return z;
  })(React.default.Component);

  j.displayName = 'AnimatedComponent(' + (t.displayName || t.name || 'Component') + ')';
  return React.default.forwardRef(function (t, o) {
    return React.default.createElement(
      j,
      module14.default(
        {},
        t,
        null === o
          ? null
          : {
              forwardedRef: o,
            }
      )
    );
  });
};

var module14 = require('./14'),
  module50 = require('./50'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
  React = require('react'),
  ReactNative = require('react-native'),
  module413 = require('./413'),
  module434 = require('./434');

require('./435');

var module6 = require('./6'),
  module455 = require('./455'),
  module456 = require('./456'),
  module422 = require('./422'),
  module421 = require('./421'),
  module445 = require('./445'),
  module457 = require('./457'),
  module477 = require('./477'),
  module478 = require('./478'),
  module442 = require('./442'),
  module414 = require('./414'),
  module479 = require('./479');

function j(t, n) {
  var o = Object.keys(t);

  if (Object.getOwnPropertySymbols) {
    var s = Object.getOwnPropertySymbols(t);
    if (n)
      s = s.filter(function (n) {
        return Object.getOwnPropertyDescriptor(t, n).enumerable;
      });
    o.push.apply(o, s);
  }

  return o;
}

function T(t) {
  for (var n = 1; n < arguments.length; n++) {
    var s = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      j(Object(s), true).forEach(function (n) {
        module50.default(t, n, s[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(s));
    else
      j(Object(s)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(s, n));
      });
  }

  return t;
}

function C(t, n) {
  var o = ('undefined' != typeof Symbol && t[Symbol.iterator]) || t['@@iterator'];
  if (o) return (o = o.call(t)).next.bind(o);

  if (Array.isArray(t) || (o = V(t)) || (n && t && 'number' == typeof t.length)) {
    if (o) t = o;
    var s = 0;
    return function () {
      return s >= t.length
        ? {
            done: true,
          }
        : {
            done: false,
            value: t[s++],
          };
    };
  }

  throw new TypeError('Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.');
}

function V(t, n) {
  if (t) {
    if ('string' == typeof t) return F(t, n);
    var o = Object.prototype.toString.call(t).slice(8, -1);
    if ('Object' === o && t.constructor) o = t.constructor.name;
    return 'Map' === o || 'Set' === o ? Array.from(t) : 'Arguments' === o || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(o) ? F(t, n) : undefined;
  }
}

function F(t, n) {
  if (null == n || n > t.length) n = t.length;

  for (var o = 0, s = new Array(n); o < n; o++) s[o] = t[o];

  return s;
}

function M() {
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

function L() {}

function W(t) {
  return 'build' in t && 'function' == typeof t.build ? t.build() : t;
}

function H(t) {
  if (!Array.isArray(t)) return [t];
  var n = [];

  (function t(o) {
    o.forEach(function (o) {
      if (Array.isArray(o)) t(o);
      else n.push(o);
    });
  })(t);

  return n;
}

function U(t) {
  return t.filter(function (t) {
    return null == t ? undefined : t.viewDescriptors;
  });
}

function B(t, n) {
  return (null == t ? undefined : t.viewsRef) === (null == n ? undefined : n.viewsRef);
}

var x = B,
  G = function (t, n) {
    return ('function' == typeof n || 'object' == typeof n) && null !== n && undefined !== n && t in n;
  };

function J(t) {
  return (
    !!t &&
    t.some(function (t) {
      return X(t);
    })
  );
}

function X(t) {
  return (
    !!t &&
    Object.keys(t).some(function (n) {
      var o = t[n];
      return module479.isSharedValue(o) || ('transform' === n && J(o));
    })
  );
}

function Y(t) {
  var n = {};

  for (var o in t) {
    var s,
      l = t[o];
    if ('style' === o)
      H(null != (s = t.style) ? s : []).forEach(function (t) {
        if (t)
          for (var o = 0, s = Object.entries(t); o < s.length; o++) {
            var l = s[o],
              u = module15.default(l, 2),
              c = u[0],
              f = u[1];
            if (module479.isSharedValue(f)) n[c] = f;
            else if ('transform' === c && J(f)) n[c] = f;
          }
      });
    else module479.isSharedValue(l) && (n[o] = l);
  }

  return n;
}

function $(t, n) {
  if (Object.keys(t).length !== Object.keys(n).length) return true;

  for (var o = 0, s = Object.keys(t); o < s.length; o++) {
    var l = s[o];
    if (t[l] !== n[l]) return true;
  }

  return false;
}

function q(t) {
  'worklet';

  for (var n = {}, o = 0, s = Object.entries(t); o < s.length; o++) {
    var l = s[o],
      u = module15.default(l, 2),
      c = u[0],
      f = u[1];
    if ('transform' === c)
      n[c] = f.map(function (t) {
        return q(t);
      });
    else if (module479.isSharedValue(f)) n[c] = f.value;
    else n[c] = f;
  }

  return n;
}
