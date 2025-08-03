var ReactNative = require('react-native'),
  module985 = require('./985'),
  l = (exports.HEIGHT = 60);

exports.default = ReactNative.StyleSheet.create({
  base: {
    flexDirection: 'row',
    height: l,
    width: '90%',
    borderRadius: 6,
    backgroundColor: module985.default.white,
    shadowOffset: {
      width: 0,
      height: 0,
    },
    shadowOpacity: 0.1,
    shadowRadius: 6,
    elevation: 2,
  },
  borderLeft: {
    borderLeftWidth: 5,
    borderLeftColor: module985.default.alto,
  },
  leadingIconContainer: {
    width: 50,
    justifyContent: 'center',
    alignItems: 'center',
  },
  contentContainer: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'flex-start',
  },
  trailingIconContainer: {
    width: 40,
    justifyContent: 'center',
    alignItems: 'center',
  },
  leadingIcon: {
    width: 20,
    height: 20,
  },
  trailingIcon: {
    width: 9,
    height: 9,
  },
  text1: {
    fontSize: 12,
    fontWeight: 'bold',
    marginBottom: 3,
  },
  text2: {
    fontSize: 10,
    color: module985.default.dustyGray,
  },
});
