var React = require('react');

var n =
    'function' == typeof Object.is
      ? Object.is
      : function (t, n) {
          return t === n ? 0 !== t || 1 / t == 1 / n : t != t && n != n;
        },
  u = React.useState,
  s = React.useEffect,
  c = React.useLayoutEffect,
  o = React.useDebugValue;

function f(t) {
  var u = t.getSnapshot;
  t = t.value;

  try {
    var s = u();
    return !n(t, s);
  } catch (t) {
    return true;
  }
}

exports.useSyncExternalStore =
  undefined !== React.useSyncExternalStore
    ? React.useSyncExternalStore
    : function (t, n) {
        var S = n(),
          v = u({
            inst: {
              value: S,
              getSnapshot: n,
            },
          }),
          l = v[0].inst,
          y = v[1];
        c(
          function () {
            l.value = S;
            l.getSnapshot = n;
            if (f(l))
              y({
                inst: l,
              });
          },
          [t, S, n]
        );
        s(
          function () {
            if (f(l))
              y({
                inst: l,
              });
            return t(function () {
              if (f(l))
                y({
                  inst: l,
                });
            });
          },
          [t]
        );
        o(S);
        return S;
      };
