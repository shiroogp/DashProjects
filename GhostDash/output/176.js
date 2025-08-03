require('./192');

require('react');

require('./52');

var module177 = require('./177'),
  module88 = require('./88').findNodeHandle,
  t = null,
  o = new Set();

function l(n) {
  if (t !== n && null != n) t = n;
}

function f(n) {
  if (t === n && null != n) t = null;
}

module.exports = {
  currentlyFocusedInput: function () {
    return t;
  },
  focusInput: l,
  blurInput: f,
  currentlyFocusedField: function () {
    return module88(t);
  },
  focusField: function (n) {},
  blurField: function (n) {},
  focusTextInput: function (u) {
    if ('number' != typeof u && t !== u && null != u) {
      l(u);
      module177.Commands.focus(u);
    }
  },
  blurTextInput: function (u) {
    if ('number' != typeof u && t === u && null != u) {
      f(u);
      module177.Commands.blur(u);
    }
  },
  registerInput: function (n) {
    if ('number' != typeof n) o.add(n);
  },
  unregisterInput: function (n) {
    if ('number' != typeof n) o.delete(n);
  },
  isTextInput: function (n) {
    return 'number' != typeof n && o.has(n);
  },
};
