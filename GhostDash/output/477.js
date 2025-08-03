exports.makeViewDescriptorsSet = function () {
  var n = module422.makeMutable([]);
  return {
    sharableViewDescriptors: n,
    add: function (t) {
      n.modify(function (n) {
        'worklet';

        var u = n.findIndex(function (n) {
          return n.tag === t.tag;
        });
        if (-1 !== u) n[u] = t;
        else n.push(t);
        return n;
      });
    },
    remove: function (t) {
      n.modify(function (n) {
        'worklet';

        var u = n.findIndex(function (n) {
          return n.tag === t;
        });
        if (-1 !== u) n.splice(u, 1);
        return n;
      });
    },
  };
};

exports.makeViewsRefSet = function () {
  var t = React.useRef(null);

  if (null === t.current) {
    var u = {
      items: new Set(),
      add: function (n) {
        if (!u.items.has(n)) u.items.add(n);
      },
      remove: function (n) {
        u.items.delete(n);
      },
    };
    t.current = u;
  }

  return t.current;
};

var React = require('react'),
  module422 = require('./422');
