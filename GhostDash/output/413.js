var module27 = require('./27'),
  module50 = require('./50'),
  module414 = require('./414'),
  module422 = require('./422');

function f(t, n) {
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

function l(t) {
  for (var n = 1; n < arguments.length; n++) {
    var s = null != arguments[n] ? arguments[n] : {};
    if (n % 2)
      f(Object(s), true).forEach(function (n) {
        module50.default(t, n, s[n]);
      });
    else if (Object.getOwnPropertyDescriptors) Object.defineProperties(t, Object.getOwnPropertyDescriptors(s));
    else
      f(Object(s)).forEach(function (n) {
        Object.defineProperty(t, n, Object.getOwnPropertyDescriptor(s, n));
      });
  }

  return t;
}

function h(t, n) {
  return function (s) {
    n(
      l(
        l({}, s.nativeEvent),
        {},
        {
          eventName: t,
        }
      )
    );
  };
}

exports.default = (function () {
  function t(s) {
    var o = arguments.length > 1 && undefined !== arguments[1] ? arguments[1] : [];
    module27.default(this, t);
    this.worklet = s;
    this.eventNames = o;
    this.reattachNeeded = false;
    this.listeners = {};
    this.viewTag = undefined;
    this.registrations = [];
    if (!module414.default.native)
      this.listeners = o.reduce(function (t, n) {
        t[n] = h(n, s);
        return t;
      }, {});
  }

  module28.default(t, [
    {
      key: 'updateWorklet',
      value: function (t) {
        this.worklet = t;
        this.reattachNeeded = true;
      },
    },
    {
      key: 'registerForEvents',
      value: function (t, n) {
        var s = this;
        this.viewTag = t;
        this.registrations = this.eventNames.map(function (n) {
          return module422.registerEventHandler(t + n, s.worklet);
        });
        if (0 === this.registrations.length && n) this.registrations.push(module422.registerEventHandler(t + n, this.worklet));
      },
    },
    {
      key: 'unregisterFromEvents',
      value: function () {
        this.registrations.forEach(function (t) {
          return module422.unregisterEventHandler(t);
        });
        this.registrations = [];
      },
    },
  ]);
  return t;
})();
