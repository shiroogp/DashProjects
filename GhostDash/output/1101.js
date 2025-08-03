var ReactNative = require('react-native'),
  module992 = require('./992');

exports.default = ReactNative.StyleSheet.create({
  main: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: module992.colors.transparent,
  },
  launchScreenLogo: {
    width: 150,
    height: 130,
  },
  launchScreenVersion: {
    position: 'absolute',
    bottom: 24,
    color: module992.colors.mainText,
  },
  alignToTop: {
    justifyContent: 'flex-start',
  },
  scrollView: {
    minHeight: module992.layout.fullHeightWithBar,
  },
  dashAdd: {
    borderRadius: 16,
    width: module992.layout.paddedWidth,
    padding: 24,
    marginTop: 0,
    marginBottom: 16,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: module992.colors.buttons.flat,
  },
  dashAddText: {
    color: module992.colors.mainText,
    marginTop: 16,
    fontSize: 16,
  },
  contentContainer: {
    alignItems: 'center',
    justifyContent: 'center',
    width: module992.layout.fullWidth,
  },
  loading: {
    margin: 48,
  },
  paddedContainer: {
    width: module992.layout.paddedWidth,
    color: module992.colors.mainText,
    margin: 16,
  },
  marginTop: {
    marginTop: 80,
  },
  loginInput: {
    backgroundColor: module992.colors.inputBg,
    color: module992.colors.mainText,
    padding: 8,
    paddingHorizontal: 16,
    borderRadius: 4,
    marginTop: 16,
  },
  loginText: {
    marginTop: 24,
    color: module992.colors.mainText,
  },
  loginBox: {
    padding: 24,
    paddingTop: 0,
    width: module992.layout.paddedWidth,
  },
  loginBtns: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    marginTop: 24,
  },
  loginBtn: {
    paddingVertical: 12,
    paddingHorizontal: 48,
    backgroundColor: module992.colors.buttons.save,
    borderRadius: 4,
    alignItems: 'center',
    justifyContent: 'center',
  },
  loginBtnText: {
    color: module992.colors.offWhite,
  },
  recoverPwBtn: {
    paddingVertical: 16,
  },
  marginVertical: {
    marginVertical: 16,
  },
  recoverPwBtnText: {
    textAlign: 'center',
    fontWeight: 'bold',
    color: module992.colors.mainText,
  },
  signupBox: {
    padding: 24,
    width: module992.layout.paddedWidth - 48,
    borderTopWidth: 1,
    borderTopColor: module992.colors.border,
    alignItems: 'center',
    justifyContent: 'space-between',
    height: 200,
  },
  alignCenter: {
    alignItems: 'center',
    justifyContent: 'center',
    textAlign: 'center',
  },
});
