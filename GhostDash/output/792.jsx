exports.__esModule = true;

var React = (function (t) {
  if (t && t.__esModule) return t;
  var o = {};
  if (null != t)
    for (var n in t)
      if (Object.prototype.hasOwnProperty.call(t, n)) {
        var p = Object.defineProperty && Object.getOwnPropertyDescriptor ? Object.getOwnPropertyDescriptor(t, n) : {};
        if (p.get || p.set) Object.defineProperty(o, n, p);
        else o[n] = t[n];
      }
  o.default = t;
  return o;
})(require('react'));

var o = function (o, n) {
  var p, u, c, f, l;

  u = p = (function (o) {
    var p, u;

    function c() {
      return o.apply(this, arguments) || this;
    }

    u = o;
    (p = c).prototype = Object.create(u.prototype);
    p.prototype.constructor = p;
    p.__proto__ = u;

    c.prototype.render = function () {
      return <n.Provider value={this.props.theme}>{this.props.children}</n.Provider>;
    };

    return c;
  })(React.Component);

  l = {
    theme: o,
  };
  if ((f = 'defaultProps') in (c = p))
    Object.defineProperty(c, f, {
      value: l,
      enumerable: true,
      configurable: true,
      writable: true,
    });
  else c[f] = l;
  return u;
};

exports.default = o;
