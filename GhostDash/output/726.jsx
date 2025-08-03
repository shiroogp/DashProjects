var module14 = require('./14'),
  module56 = require('@babel/runtime/helpers/defineEnumerableProperties'),
  module50 = require('./50'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = w(n);
    if (o && o.has(t)) return o.get(t);
    var u = {
        __proto__: null,
      },
      s = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var c in t)
      if ('default' !== c && Object.prototype.hasOwnProperty.call(t, c)) {
        var l = s ? Object.getOwnPropertyDescriptor(t, c) : null;
        if (l && (l.get || l.set)) Object.defineProperty(u, c, l);
        else u[c] = t[c];
      }

    u.default = t;
    if (o) o.set(t, u);
    return u;
  })(require('react')),
  ReactNative = require('react-native'),
  module727 = require('./727'),
  module2 = require('./2'),
  module649 = require('./649'),
  module733 = require('./733'),
  module773 = require('./773'),
  module774 = require('./774'),
  module778 = require('./778'),
  j = ['state', 'navigation', 'keyboardHandlingEnabled', 'mode'];

function w(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (w = function (t) {
    return t ? o : n;
  })(t);
}

function S(t, n) {
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

function D(t) {
  for (var n = 1; n < arguments.length; n++) {
    var o = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      S(Object(o), true).forEach(function (n) {
        module50.default(t, n, o[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(o));
    else
      S(Object(o)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(o, n));
      });
  }

  return t;
}

function _() {
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

exports.default = (function (t, ...args) {
  module38.default(S, t);

  var module50 = S,
    module2 = _(),
    w = function () {
      var t,
        n = module37.default(module50);

      if (module2) {
        var o = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, o);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function S() {
    var t;
    module27.default(this, S);
    (t = w.call(this, ...args)).state = {
      routes: [],
      previousRoutes: [],
      previousDescriptors: {},
      openingRouteKeys: [],
      closingRouteKeys: [],
      replacingRouteKeys: [],
      descriptors: {},
    };

    t.getGesturesEnabled = function (n) {
      var o = n.route,
        u = t.state.descriptors[o.key];

      if (u) {
        var s = u.options,
          c = s.gestureEnabled;
        return false !== s.animationEnabled && (undefined !== c ? c : 'android' !== ReactNative.Platform.OS);
      }

      return false;
    };

    t.getPreviousRoute = function (n) {
      var o = n.route,
        u = t.state,
        s = u.closingRouteKeys,
        c = u.replacingRouteKeys,
        l = t.state.routes.filter(function (t) {
          return t.key === o.key || (!s.includes(t.key) && !c.includes(t.key));
        });
      return l[
        l.findIndex(function (t) {
          return t.key === o.key;
        }) - 1
      ];
    };

    t.renderScene = function (n) {
      var o = n.route,
        u = t.state.descriptors[o.key] || t.props.descriptors[o.key];
      return u ? u.render() : null;
    };

    t.renderHeader = function (t) {
      return <module774.default />;
    };

    t.handleOpenRoute = function (n) {
      var o = n.route;
      t.setState(function (t) {
        return {
          routes: t.replacingRouteKeys.length
            ? t.routes.filter(function (n) {
                return !t.replacingRouteKeys.includes(n.key);
              })
            : t.routes,
          openingRouteKeys: t.openingRouteKeys.filter(function (t) {
            return t !== o.key;
          }),
          closingRouteKeys: t.closingRouteKeys.filter(function (t) {
            return t !== o.key;
          }),
          replacingRouteKeys: [],
        };
      });
    };

    t.handleCloseRoute = function (n) {
      var o = n.route,
        u = t.props,
        s = u.state,
        c = u.navigation;
      if (
        s.routes.find(function (t) {
          return t.key === o.key;
        })
      )
        c.dispatch(
          D(
            D({}, module649.StackActions.pop()),
            {},
            {
              source: o.key,
              target: s.key,
            }
          )
        );
      else
        t.setState(function (t) {
          return {
            routes: t.routes.filter(function (t) {
              return t.key !== o.key;
            }),
            openingRouteKeys: t.openingRouteKeys.filter(function (t) {
              return t !== o.key;
            }),
            closingRouteKeys: t.closingRouteKeys.filter(function (t) {
              return t !== o.key;
            }),
          };
        });
    };

    t.handleTransitionStart = function (n, o) {
      var u = n.route;
      return t.props.navigation.emit({
        type: 'transitionStart',
        data: {
          closing: o,
        },
        target: u.key,
      });
    };

    t.handleTransitionEnd = function (n, o) {
      var u = n.route;
      return t.props.navigation.emit({
        type: 'transitionEnd',
        data: {
          closing: o,
        },
        target: u.key,
      });
    };

    return t;
  }

  module28.default(
    S,
    [
      {
        key: 'render',
        value: function () {
          var t = this,
            n = this.props,
            s = n.state,
            c = n.keyboardHandlingEnabled,
            l = n.mode,
            f = undefined === l ? 'card' : l,
            p = module56.default(n, j),
            y = this.state,
            h = y.routes,
            b = y.descriptors,
            E = y.openingRouteKeys,
            w = y.closingRouteKeys,
            S = 'modal' !== f && 'ios' === ReactNative.Platform.OS ? 'float' : 'screen';
          return (
            <T style={H.container}>
              <module778.default>
                <module727.SafeAreaConsumer>
                  {function (n) {
                    return (
                      <module773.default enabled={false !== c}>
                        {function (u) {
                          return <module733.default />;
                        }}
                      </module773.default>
                    );
                  }}
                </module727.SafeAreaConsumer>
              </module778.default>
            </T>
          );
        },
      },
    ],
    [
      {
        key: 'getDerivedStateFromProps',
        value: function (t, o) {
          if (
            (t.state.routes === o.previousRoutes ||
              ((p = t.state.routes.map(function (t) {
                return t.key;
              })),
              (y = o.previousRoutes.map(function (t) {
                return t.key;
              })),
              p.length === y.length &&
                p.every(function (t, n) {
                  return t === y[n];
                }))) &&
            o.routes.length
          ) {
            var u = o.routes,
              s = o.previousRoutes,
              c = t.descriptors,
              l = o.previousDescriptors;

            if (
              (t.descriptors !== o.previousDescriptors &&
                ((c = o.routes.reduce(function (n, u) {
                  n[u.key] = t.descriptors[u.key] || o.descriptors[u.key];
                  return n;
                }, {})),
                (l = t.descriptors)),
              t.state.routes !== o.previousRoutes)
            ) {
              var f = t.state.routes.reduce(function (t, n) {
                t[n.key] = n;
                return t;
              }, {});
              u = o.routes.map(function (t) {
                return f[t.key] || t;
              });
              s = t.state.routes;
            }

            return {
              routes: u,
              previousRoutes: s,
              descriptors: c,
              previousDescriptors: l,
            };
          }

          var p,
            y,
            k,
            v,
            R = t.state.index < t.state.routes.length - 1 ? t.state.routes.slice(0, t.state.index + 1) : t.state.routes,
            h = o.openingRouteKeys,
            b = o.closingRouteKeys,
            O = o.replacingRouteKeys,
            K = o.previousRoutes,
            E = K[K.length - 1],
            P = R[R.length - 1],
            j = function (n) {
              var u = t.descriptors[n] || o.descriptors[n];
              return !u || false !== u.options.animationEnabled;
            };

          if (E && E.key !== P.key)
            K.find(function (t) {
              return t.key === P.key;
            })
              ? R.find(function (t) {
                  return t.key === E.key;
                }) ||
                (j(E.key) &&
                  !b.includes(E.key) &&
                  ((b = [].concat(module23.default(b), [E.key])),
                  (h = h.filter(function (t) {
                    return t !== E.key;
                  })),
                  (O = O.filter(function (t) {
                    return t !== E.key;
                  })),
                  (R = [].concat(module23.default(R), [E]))))
              : j(P.key) &&
                !h.includes(P.key) &&
                ((h = [].concat(module23.default(h), [P.key])),
                (b = b.filter(function (t) {
                  return t !== P.key;
                })),
                (O = O.filter(function (t) {
                  return t !== P.key;
                })),
                R.find(function (t) {
                  return t.key === E.key;
                }) ||
                  ((h = h.filter(function (t) {
                    return t !== E.key;
                  })),
                  'pop' === ((k = P.key), null != (v = (t.descriptors[k] || o.descriptors[k]).options.animationTypeForReplace) ? v : 'push')
                    ? ((b = [].concat(module23.default(b), [E.key])),
                      (h = h.filter(function (t) {
                        return t !== P.key;
                      })),
                      (R = [].concat(module23.default(R), [E])))
                    : ((O = [].concat(module23.default(O), [E.key])),
                      (b = b.filter(function (t) {
                        return t !== E.key;
                      })),
                      (R = R.slice()).splice(R.length - 1, 0, E))));
          else if (O.length || b.length) {
            var w;
            (w = R = R.slice()).splice.apply(
              w,
              [R.length - 1, 0].concat(
                module23.default(
                  o.routes.filter(function (t) {
                    var n = t.key;
                    return !!j(n) && (O.includes(n) || b.includes(n));
                  })
                )
              )
            );
          }
          if (!R.length) throw new Error('There should always be at least one route in the navigation state.');
          var S = R.reduce(function (n, u) {
            n[u.key] = t.descriptors[u.key] || o.descriptors[u.key];
            return n;
          }, {});
          return {
            routes: R,
            previousRoutes: t.state.routes,
            previousDescriptors: t.descriptors,
            openingRouteKeys: h,
            closingRouteKeys: b,
            replacingRouteKeys: O,
            descriptors: S,
          };
        },
      },
    ]
  );
  return S;
})(React.Component);

var T = null != module2.GestureHandlerRootView ? module2.GestureHandlerRootView : ReactNative.View,
  H = ReactNative.StyleSheet.create({
    container: {
      flex: 1,
    },
  });
