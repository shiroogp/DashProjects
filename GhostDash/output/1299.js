require('react');

var module1296 = require('./1296');

exports.getProps = function (o) {
  var l = o.color ? o.color : '#898aff';
  return {
    style: module1296.mergeViewStyle(o.style, {
      minWidth: 150,
      maxWidth: 150,
    }),
    shadow: !o.shadow || o.shadow,
    width: o.width ? o.width : 150,
    colorAsBackground: true,
    color: l,
    textColor: '#000',
    inputStyle: module1296.mergeViewStyle(o.inputStyle, {
      borderRadius: 30,
      backgroundColor: '#FFF',
      minWidth: 50,
      maxWidth: 50,
      height: 50,
    }),
  };
};
