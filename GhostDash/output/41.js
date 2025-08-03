function o(t) {
  '@babel/helpers - typeof';

  if ('function' == typeof Symbol && 'symbol' == typeof Symbol.iterator)
    module.exports = o = function (o) {
      return typeof o;
    };
  else
    module.exports = o = function (o) {
      return o && 'function' == typeof Symbol && o.constructor === Symbol && o !== Symbol.prototype ? 'symbol' : typeof o;
    };
  return o(t);
}

module.exports = o;
