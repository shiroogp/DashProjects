require('react');

var module1296 = require('./1296');

exports.getProps = function (o) {
  var t = o.color ? o.color : '#eeeafd',
    l = o.colorPress ? o.colorPress : '#a28df6';
  return {
    style: module1296.mergeViewStyle(o.style, {
      padding: 10,
      borderRadius: 3,
    }),
    height: o.height ? o.height : 30,
    shadow: !o.shadow || o.shadow,
    background: o.background ? o.background : '#FFF',
    color: t,
    colorPress: o.colorPress ? o.colorPress : l,
    buttonTextColor: l,
    buttonPressTextColor: 'auto',
  };
};
