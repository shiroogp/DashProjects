var ReactNative = require('react-native'),
  module992 = require('./992');

exports.default = ReactNative.StyleSheet.create({
  centerText: {
    fontSize: 18,
    padding: 36,
    color: module992.colors.mainText,
    textAlign: 'center',
    alignItems: 'center',
    justifyContent: 'center',
  },
  textBold: {
    fontWeight: '500',
    color: '#000',
  },
  buttonText: {
    fontSize: 21,
    color: 'rgb(0,122,255)',
  },
  buttonTouchable: {
    padding: 16,
  },
  cancelButton: {
    borderRadius: 100,
  },
  topViewStyle: {
    paddingTop: 48,
    paddingBottom: 0,
    margin: 0,
    backgroundColor: module992.colors.basic,
    alignItems: 'center',
    justifyContent: 'center',
    zIndex: 999,
  },
  bottomViewStyle: {
    padding: 0,
    backgroundColor: module992.colors.basic,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
