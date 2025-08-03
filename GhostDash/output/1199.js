var ReactNative = require('react-native'),
  module992 = require('./992');

exports.default = ReactNative.StyleSheet.create({
  main: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'flex-start',
    backgroundColor: module992.colors.transparent,
  },
  header: {
    justifyContent: 'space-between',
    flexDirection: 'row',
    marginTop: 64,
    width: module992.layout.paddedWidth,
    marginBottom: 40,
  },
  headerText: {
    fontSize: 40,
    fontWeight: 'bold',
    color: module992.colors.mainText,
  },
  actionContent: {
    width: module992.layout.paddedWidth,
    paddingHorizontal: 12,
  },
  footerText: {
    fontSize: 12,
    lineHeight: 18,
    textAlign: 'center',
    color: module992.colors.mainText,
  },
  contentContainer: {
    flexDirection: 'column',
    justifyContent: 'space-between',
    flexGrow: 1,
    width: module992.layout.fullWidth,
    padding: 16,
  },
});
