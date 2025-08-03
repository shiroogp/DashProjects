var t = 'function' == typeof Symbol && Symbol.for,
  o = t ? Symbol.for('react.element') : 60103,
  n = t ? Symbol.for('react.portal') : 60106,
  c = t ? Symbol.for('react.fragment') : 60107,
  f = t ? Symbol.for('react.strict_mode') : 60108,
  s = t ? Symbol.for('react.profiler') : 60114,
  u = t ? Symbol.for('react.provider') : 60109,
  y = t ? Symbol.for('react.context') : 60110,
  l = t ? Symbol.for('react.async_mode') : 60111,
  p = t ? Symbol.for('react.concurrent_mode') : 60111,
  b = t ? Symbol.for('react.forward_ref') : 60112,
  S = t ? Symbol.for('react.suspense') : 60113,
  $ = t ? Symbol.for('react.suspense_list') : 60120,
  C = t ? Symbol.for('react.memo') : 60115,
  M = t ? Symbol.for('react.lazy') : 60116,
  _ = t ? Symbol.for('react.block') : 60121,
  w = t ? Symbol.for('react.fundamental') : 60117,
  P = t ? Symbol.for('react.responder') : 60118,
  v = t ? Symbol.for('react.scope') : 60119;

function x(t) {
  if ('object' == typeof t && null !== t) {
    var $ = t.$$typeof;

    switch ($) {
      case o:
        switch ((t = t.type)) {
          case l:
          case p:
          case c:
          case s:
          case f:
          case S:
            return t;

          default:
            switch ((t = t && t.$$typeof)) {
              case y:
              case b:
              case M:
              case C:
              case u:
                return t;

              default:
                return $;
            }
        }

      case n:
        return $;
    }
  }
}

function F(t) {
  return x(t) === p;
}

exports.AsyncMode = l;
exports.ConcurrentMode = p;
exports.ContextConsumer = y;
exports.ContextProvider = u;
exports.Element = o;
exports.ForwardRef = b;
exports.Fragment = c;
exports.Lazy = M;
exports.Memo = C;
exports.Portal = n;
exports.Profiler = s;
exports.StrictMode = f;
exports.Suspense = S;

exports.isAsyncMode = function (t) {
  return F(t) || x(t) === l;
};

exports.isConcurrentMode = F;

exports.isContextConsumer = function (t) {
  return x(t) === y;
};

exports.isContextProvider = function (t) {
  return x(t) === u;
};

exports.isElement = function (t) {
  return 'object' == typeof t && null !== t && t.$$typeof === o;
};

exports.isForwardRef = function (t) {
  return x(t) === b;
};

exports.isFragment = function (t) {
  return x(t) === c;
};

exports.isLazy = function (t) {
  return x(t) === M;
};

exports.isMemo = function (t) {
  return x(t) === C;
};

exports.isPortal = function (t) {
  return x(t) === n;
};

exports.isProfiler = function (t) {
  return x(t) === s;
};

exports.isStrictMode = function (t) {
  return x(t) === f;
};

exports.isSuspense = function (t) {
  return x(t) === S;
};

exports.isValidElementType = function (t) {
  return (
    'string' == typeof t ||
    'function' == typeof t ||
    t === c ||
    t === p ||
    t === s ||
    t === f ||
    t === S ||
    t === $ ||
    ('object' == typeof t &&
      null !== t &&
      (t.$$typeof === M ||
        t.$$typeof === C ||
        t.$$typeof === u ||
        t.$$typeof === y ||
        t.$$typeof === b ||
        t.$$typeof === w ||
        t.$$typeof === P ||
        t.$$typeof === v ||
        t.$$typeof === _))
  );
};

exports.typeOf = x;
