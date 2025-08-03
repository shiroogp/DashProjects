var module50 = require('./50'),
  module15 = require('@babel/runtime/helpers/slicedToArray'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  module443 = require('./443');

function y(n, t) {
  var l = Object.keys(n);

  if (Object.getOwnPropertySymbols) {
    var u = Object.getOwnPropertySymbols(n);
    if (t)
      u = u.filter(function (t) {
        return Object.getOwnPropertyDescriptor(n, t).enumerable;
      });
    l.push.apply(l, u);
  }

  return l;
}

function h(n) {
  for (var l = 1; l < arguments.length; l++) {
    var u = null != arguments[l] ? arguments[l] : {};
    if (l % 2)
      y(Object(u), true).forEach(function (l) {
        module50.default(n, l, u[l]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(n, Object.getOwnPropertyDescriptors(u));
    else
      y(Object(u)).forEach(function (t) {
        Object.defineProperty(n, t, Object.getOwnPropertyDescriptor(u, t));
      });
  }

  return n;
}

function v(n) {
  var t = p();
  return function () {
    var l,
      u = module37.default(n);

    if (t) {
      var o = module37.default(this).constructor;
      l = Reflect.construct(u, arguments, o);
    } else l = u.apply(this, arguments);

    return module40.default(this, l);
  };
}

function p() {
  if ('undefined' == typeof Reflect || !Reflect.construct) return false;
  if (Reflect.construct.sham) return false;
  if ('function' == typeof Proxy) return true;

  try {
    Boolean.prototype.valueOf.call(Reflect.construct(Boolean, [], function () {}));
    return true;
  } catch (n) {
    return false;
  }
}

exports.SlideInRight = (function (n, ...args) {
  module38.default(f, n);
  var t = v(f);

  function f() {
    var n;
    module27.default(this, f);

    (n = t.call(this, ...args)).build = function () {
      var t = n.getDelayFunction(),
        u = n.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = n.getDelay(),
        w = n.callbackV,
        y = n.initialValues;
      return function (n) {
        'worklet';

        return {
          animations: {
            originX: t(s, c(n.targetOriginX, f)),
          },
          initialValues: h(
            {
              originX: n.targetOriginX + n.windowWidth,
            },
            y
          ),
          callback: w,
        };
      };
    };

    return n;
  }

  module28.default(f, null, [
    {
      key: 'createInstance',
      value: function () {
        return new f();
      },
    },
  ]);
  return f;
})(module443.ComplexAnimationBuilder);

exports.SlideInLeft = (function (n, ...args) {
  module38.default(f, n);
  var t = v(f);

  function f() {
    var n;
    module27.default(this, f);

    (n = t.call(this, ...args)).build = function () {
      var t = n.getDelayFunction(),
        u = n.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = n.getDelay(),
        w = n.callbackV,
        y = n.initialValues;
      return function (n) {
        'worklet';

        return {
          animations: {
            originX: t(s, c(n.targetOriginX, f)),
          },
          initialValues: h(
            {
              originX: n.targetOriginX - n.windowWidth,
            },
            y
          ),
          callback: w,
        };
      };
    };

    return n;
  }

  module28.default(f, null, [
    {
      key: 'createInstance',
      value: function () {
        return new f();
      },
    },
  ]);
  return f;
})(module443.ComplexAnimationBuilder);

exports.SlideOutRight = (function (n, ...args) {
  module38.default(f, n);
  var t = v(f);

  function f() {
    var n;
    module27.default(this, f);

    (n = t.call(this, ...args)).build = function () {
      var t = n.getDelayFunction(),
        u = n.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = n.getDelay(),
        w = n.callbackV,
        y = n.initialValues;
      return function (n) {
        'worklet';

        return {
          animations: {
            originX: t(s, c((n.currentOriginX + n.windowWidth) ** n.windowWidth, f)),
          },
          initialValues: h(
            {
              originX: n.currentOriginX,
            },
            y
          ),
          callback: w,
        };
      };
    };

    return n;
  }

  module28.default(f, null, [
    {
      key: 'createInstance',
      value: function () {
        return new f();
      },
    },
  ]);
  return f;
})(module443.ComplexAnimationBuilder);

exports.SlideOutLeft = (function (n, ...args) {
  module38.default(f, n);
  var t = v(f);

  function f() {
    var n;
    module27.default(this, f);

    (n = t.call(this, ...args)).build = function () {
      var t = n.getDelayFunction(),
        u = n.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = n.getDelay(),
        w = n.callbackV,
        y = n.initialValues;
      return function (n) {
        'worklet';

        return {
          animations: {
            originX: t(s, c((n.currentOriginX - n.windowWidth) ** -n.windowWidth, f)),
          },
          initialValues: h(
            {
              originX: n.currentOriginX,
            },
            y
          ),
          callback: w,
        };
      };
    };

    return n;
  }

  module28.default(f, null, [
    {
      key: 'createInstance',
      value: function () {
        return new f();
      },
    },
  ]);
  return f;
})(module443.ComplexAnimationBuilder);

exports.SlideInUp = (function (n, ...args) {
  module38.default(f, n);
  var t = v(f);

  function f() {
    var n;
    module27.default(this, f);

    (n = t.call(this, ...args)).build = function () {
      var t = n.getDelayFunction(),
        u = n.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = n.getDelay(),
        w = n.callbackV,
        y = n.initialValues;
      return function (n) {
        'worklet';

        return {
          animations: {
            originY: t(s, c(n.targetOriginY, f)),
          },
          initialValues: h(
            {
              originY: -n.windowHeight,
            },
            y
          ),
          callback: w,
        };
      };
    };

    return n;
  }

  module28.default(f, null, [
    {
      key: 'createInstance',
      value: function () {
        return new f();
      },
    },
  ]);
  return f;
})(module443.ComplexAnimationBuilder);

exports.SlideInDown = (function (n, ...args) {
  module38.default(f, n);
  var t = v(f);

  function f() {
    var n;
    module27.default(this, f);

    (n = t.call(this, ...args)).build = function () {
      var t = n.getDelayFunction(),
        u = n.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = n.getDelay(),
        w = n.callbackV,
        y = n.initialValues;
      return function (n) {
        'worklet';

        return {
          animations: {
            originY: t(s, c(n.targetOriginY, f)),
          },
          initialValues: h(
            {
              originY: n.targetOriginY + n.windowHeight,
            },
            y
          ),
          callback: w,
        };
      };
    };

    return n;
  }

  module28.default(f, null, [
    {
      key: 'createInstance',
      value: function () {
        return new f();
      },
    },
  ]);
  return f;
})(module443.ComplexAnimationBuilder);

exports.SlideOutUp = (function (n, ...args) {
  module38.default(f, n);
  var t = v(f);

  function f() {
    var n;
    module27.default(this, f);

    (n = t.call(this, ...args)).build = function () {
      var t = n.getDelayFunction(),
        u = n.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = n.getDelay(),
        w = n.callbackV,
        y = n.initialValues;
      return function (n) {
        'worklet';

        return {
          animations: {
            originY: t(s, c((n.currentOriginY - n.windowHeight) ** -n.windowHeight, f)),
          },
          initialValues: h(
            {
              originY: n.currentOriginY,
            },
            y
          ),
          callback: w,
        };
      };
    };

    return n;
  }

  module28.default(f, null, [
    {
      key: 'createInstance',
      value: function () {
        return new f();
      },
    },
  ]);
  return f;
})(module443.ComplexAnimationBuilder);

exports.SlideOutDown = (function (n, ...args) {
  module38.default(f, n);
  var t = v(f);

  function f() {
    var n;
    module27.default(this, f);

    (n = t.call(this, ...args)).build = function () {
      var t = n.getDelayFunction(),
        u = n.getAnimationAndConfig(),
        o = module15.default(u, 2),
        c = o[0],
        f = o[1],
        s = n.getDelay(),
        w = n.callbackV,
        y = n.initialValues;
      return function (n) {
        'worklet';

        return {
          animations: {
            originY: t(s, c((n.currentOriginY + n.windowHeight) ** n.windowHeight, f)),
          },
          initialValues: h(
            {
              originY: n.currentOriginY,
            },
            y
          ),
          callback: w,
        };
      };
    };

    return n;
  }

  module28.default(f, null, [
    {
      key: 'createInstance',
      value: function () {
        return new f();
      },
    },
  ]);
  return f;
})(module443.ComplexAnimationBuilder);
