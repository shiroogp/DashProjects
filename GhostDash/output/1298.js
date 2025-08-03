require('react');

exports.getProps = function (o) {
  var n = o.background ? o.background : '#FFF';
  return {
    shadow: !o.shadow || o.shadow,
    color: n,
    colorAsBackground: true,
  };
};
