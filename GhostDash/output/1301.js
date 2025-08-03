require('react');

var module1296 = require('./1296');

exports.getProps = function (o) {
  return {
    shadow: !o.shadow || o.shadow,
    colorAsBackground: true,
    textColor: '#000',
    inputStyle: module1296.mergeViewStyle(o.inputStyle, {
      backgroundColor: '#FFF',
    }),
  };
};
