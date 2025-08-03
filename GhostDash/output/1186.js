var module14 = require('./14'),
  module27 = require('./27'),
  module42 = require('./42'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  React = (function (t, n) {
    if (!n && t && t.__esModule) return t;
    if (null === t || ('object' != typeof t && 'function' != typeof t))
      return {
        default: t,
      };
    var o = b(n);
    if (o && o.has(t)) return o.get(t);
    var s = {
        __proto__: null,
      },
      l = Object.defineProperty && Object.getOwnPropertyDescriptor;

    for (var u in t)
      if ('default' !== u && Object.prototype.hasOwnProperty.call(t, u)) {
        var c = l ? Object.getOwnPropertyDescriptor(t, u) : null;
        if (c && (c.get || c.set)) Object.defineProperty(s, u, c);
        else s[u] = t[u];
      }

    s.default = t;
    if (o) o.set(t, s);
    return s;
  })(require('react')),
  PropTypes = require('prop-types'),
  ReactNative = require('react-native'),
  module1069 = require('./1069'),
  module1187 = require('./1187');

function b(t) {
  if ('function' != typeof WeakMap) return null;
  var n = new WeakMap(),
    o = new WeakMap();
  return (b = function (t) {
    return t ? o : n;
  })(t);
}

function w() {
  if ('undefined' == typeof Reflect || !Reflect.construct) return false;
  if (Reflect.construct.sham) return false;
  if ('function' == typeof Proxy) return true;

  try {
    Boolean.prototype.valueOf.call(Reflect.construct(Boolean, [], function () {}));
    return true;
  } catch (t) {
    return false;
  }
}

var k = module1187.RNCamera.Constants.FlashMode,
  S = [k.torch, k.on, k.off, k.auto],
  A = (exports.default = (function (t) {
    module38.default(S, t);

    var PropTypes = S,
      b = w(),
      k = function () {
        var t,
          n = module37.default(PropTypes);

        if (b) {
          var o = module37.default(this).constructor;
          t = Reflect.construct(n, arguments, o);
        } else t = n.apply(this, arguments);

        return module40.default(this, t);
      };

    function S(t) {
      var n;
      module27.default(this, S);
      (n = k.call(this, t)).state = {
        scanning: false,
        isCameraActivated: true,
        fadeInOpacity: new ReactNative.Animated.Value(0),
        isAuthorized: false,
        isAuthorizationChecked: false,
        disableVibrationByUser: false,
      };
      n.timer = null;
      n._scannerTimeout = null;
      n._handleBarCodeRead = n._handleBarCodeRead.bind(module42.default(n));
      return n;
    }

    module28.default(S, [
      {
        key: 'componentDidMount',
        value: function () {
          var t = this;
          if ('ios' === ReactNative.Platform.OS)
            module1069.request(module1069.PERMISSIONS.IOS.CAMERA).then(function (n) {
              t.setState({
                isAuthorized: n === module1069.RESULTS.GRANTED,
                isAuthorizationChecked: true,
              });
            });
          else if ('android' === ReactNative.Platform.OS && this.props.checkAndroid6Permissions)
            ReactNative.PermissionsAndroid.request(ReactNative.PermissionsAndroid.PERMISSIONS.CAMERA, {
              title: this.props.permissionDialogTitle,
              message: this.props.permissionDialogMessage,
              buttonPositive: this.props.buttonPositive,
            }).then(function (n) {
              var o = n === ReactNative.PermissionsAndroid.RESULTS.GRANTED;
              t.setState({
                isAuthorized: o,
                isAuthorizationChecked: true,
              });
            });
          else
            this.setState({
              isAuthorized: true,
              isAuthorizationChecked: true,
            });
          if (this.props.fadeIn)
            ReactNative.Animated.sequence([
              ReactNative.Animated.delay(1e3),
              ReactNative.Animated.timing(this.state.fadeInOpacity, {
                toValue: 1,
                easing: ReactNative.Easing.inOut(ReactNative.Easing.quad),
                useNativeDriver: true,
              }),
            ]).start();
        },
      },
      {
        key: 'componentWillUnmount',
        value: function () {
          if (null !== this._scannerTimeout) clearTimeout(this._scannerTimeout);
          if (null !== this.timer) clearTimeout(this.timer);
          this.timer = null;
          this._scannerTimeout = null;
        },
      },
      {
        key: 'disable',
        value: function () {
          this.setState({
            disableVibrationByUser: true,
          });
        },
      },
      {
        key: 'enable',
        value: function () {
          this.setState({
            disableVibrationByUser: false,
          });
        },
      },
      {
        key: '_setScanning',
        value: function (t) {
          this.setState({
            scanning: t,
          });
        },
      },
      {
        key: '_setCamera',
        value: function (t) {
          var n = this;
          this.setState(
            {
              isCameraActivated: t,
              scanning: false,
              fadeInOpacity: new ReactNative.Animated.Value(0),
            },
            function () {
              if (t && n.props.fadeIn && n.props.fadeIn)
                ReactNative.Animated.sequence([
                  ReactNative.Animated.delay(10),
                  ReactNative.Animated.timing(n.state.fadeInOpacity, {
                    toValue: 1,
                    easing: ReactNative.Easing.inOut(ReactNative.Easing.quad),
                    useNativeDriver: true,
                  }),
                ]).start();
            }
          );
        },
      },
      {
        key: '_handleBarCodeRead',
        value: function (t) {
          var n = this;

          if (!(this.state.scanning || this.state.disableVibrationByUser)) {
            if (this.props.vibrate) ReactNative.Vibration.vibrate();

            this._setScanning(true);

            this.props.onRead(t);
            if (this.props.reactivate)
              this._scannerTimeout = setTimeout(function () {
                return n._setScanning(false);
              }, this.props.reactivateTimeout);
          }
        },
      },
      {
        key: '_renderTopContent',
        value: function () {
          return this.props.topContent ? this.props.topContent : null;
        },
      },
      {
        key: '_renderBottomContent',
        value: function () {
          return this.props.bottomContent ? this.props.bottomContent : null;
        },
      },
      {
        key: '_renderCameraMarker',
        value: function () {
          return this.props.showMarker
            ? this.props.customMarker
              ? this.props.customMarker
              : React.default.createElement(
                  ReactNative.View,
                  {
                    style: T.rectangleContainer,
                  },
                  React.default.createElement(ReactNative.View, {
                    style: [T.rectangle, this.props.markerStyle ? this.props.markerStyle : null],
                  })
                )
            : null;
        },
      },
      {
        key: '_renderCameraComponent',
        value: function () {
          return React.default.createElement(
            module1187.RNCamera,
            module14.default(
              {
                androidCameraPermissionOptions: {
                  title: this.props.permissionDialogTitle,
                  message: this.props.permissionDialogMessage,
                  buttonPositive: this.props.buttonPositive,
                },
                style: [T.camera, this.props.cameraStyle],
                onBarCodeRead: this._handleBarCodeRead.bind(this),
                type: this.props.cameraType,
                flashMode: this.props.flashMode,
                captureAudio: false,
              },
              this.props.cameraProps
            ),
            this._renderCameraMarker()
          );
        },
      },
      {
        key: '_renderCamera',
        value: function () {
          var t = this,
            n = this.props,
            o = n.notAuthorizedView,
            s = n.pendingAuthorizationView,
            l = n.cameraTimeoutView;
          if (!this.state.isCameraActivated)
            return React.default.createElement(
              ReactNative.TouchableWithoutFeedback,
              {
                onPress: function () {
                  return t._setCamera(true);
                },
              },
              l
            );
          var u = this.state,
            c = u.isAuthorized,
            f = u.isAuthorizationChecked;

          if (c) {
            if (this.props.cameraTimeout > 0) {
              if (this.timer) clearTimeout(this.timer);
              this.timer = setTimeout(function () {
                return t._setCamera(false);
              }, this.props.cameraTimeout);
            }

            return this.props.fadeIn
              ? React.default.createElement(
                  ReactNative.Animated.View,
                  {
                    style: {
                      opacity: this.state.fadeInOpacity,
                      backgroundColor: 'transparent',
                      height: (this.props.cameraStyle && this.props.cameraStyle.height) || T.camera.height,
                    },
                  },
                  this._renderCameraComponent()
                )
              : this._renderCameraComponent();
          } else return f ? o : s;
        },
      },
      {
        key: 'reactivate',
        value: function () {
          this._setScanning(false);
        },
      },
      {
        key: 'render',
        value: function () {
          return React.default.createElement(
            ReactNative.View,
            {
              style: [T.mainContainer, this.props.containerStyle],
            },
            React.default.createElement(
              ReactNative.View,
              {
                style: [T.infoView, this.props.topViewStyle],
              },
              this._renderTopContent()
            ),
            React.default.createElement(
              ReactNative.View,
              {
                style: this.props.cameraContainerStyle,
              },
              this._renderCamera()
            ),
            React.default.createElement(
              ReactNative.View,
              {
                style: [T.infoView, this.props.bottomViewStyle],
              },
              this._renderBottomContent()
            )
          );
        },
      },
    ]);
    return S;
  })(React.Component));

A.propTypes = {
  onRead: PropTypes.default.func.isRequired,
  vibrate: PropTypes.default.bool,
  reactivate: PropTypes.default.bool,
  reactivateTimeout: PropTypes.default.number,
  cameraTimeout: PropTypes.default.number,
  fadeIn: PropTypes.default.bool,
  showMarker: PropTypes.default.bool,
  cameraType: PropTypes.default.oneOf(['front', 'back']),
  customMarker: PropTypes.default.element,
  containerStyle: PropTypes.default.any,
  cameraStyle: PropTypes.default.any,
  cameraContainerStyle: PropTypes.default.any,
  markerStyle: PropTypes.default.any,
  topViewStyle: PropTypes.default.any,
  bottomViewStyle: PropTypes.default.any,
  topContent: PropTypes.default.oneOfType([PropTypes.default.element, PropTypes.default.string]),
  bottomContent: PropTypes.default.oneOfType([PropTypes.default.element, PropTypes.default.string]),
  notAuthorizedView: PropTypes.default.element,
  permissionDialogTitle: PropTypes.default.string,
  permissionDialogMessage: PropTypes.default.string,
  buttonPositive: PropTypes.default.string,
  checkAndroid6Permissions: PropTypes.default.bool,
  flashMode: PropTypes.default.oneOf(S),
  cameraProps: PropTypes.default.object,
  cameraTimeoutView: PropTypes.default.element,
};
A.defaultProps = {
  onRead: function () {
    return null;
  },
  reactivate: false,
  vibrate: true,
  reactivateTimeout: 0,
  cameraTimeout: 0,
  fadeIn: true,
  showMarker: false,
  cameraType: 'back',
  notAuthorizedView: React.default.createElement(
    ReactNative.View,
    {
      style: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
      },
    },
    React.default.createElement(
      ReactNative.Text,
      {
        style: {
          textAlign: 'center',
          fontSize: 16,
        },
      },
      'Camera not authorized'
    )
  ),
  pendingAuthorizationView: React.default.createElement(
    ReactNative.View,
    {
      style: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
      },
    },
    React.default.createElement(
      ReactNative.Text,
      {
        style: {
          textAlign: 'center',
          fontSize: 16,
        },
      },
      '...'
    )
  ),
  permissionDialogTitle: 'Info',
  permissionDialogMessage: 'Need camera permission',
  buttonPositive: 'OK',
  checkAndroid6Permissions: false,
  flashMode: k.auto,
  cameraProps: {},
  cameraTimeoutView: React.default.createElement(
    ReactNative.View,
    {
      style: {
        flex: 0,
        alignItems: 'center',
        justifyContent: 'center',
        height: ReactNative.Dimensions.get('window').height,
        width: ReactNative.Dimensions.get('window').width,
        backgroundColor: 'black',
      },
    },
    React.default.createElement(
      ReactNative.Text,
      {
        style: {
          color: 'white',
        },
      },
      'Tap to activate camera'
    )
  ),
};
var T = ReactNative.StyleSheet.create({
  mainContainer: {
    flex: 1,
  },
  infoView: {
    flex: 2,
    justifyContent: 'center',
    alignItems: 'center',
    width: ReactNative.Dimensions.get('window').width,
  },
  camera: {
    flex: 0,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: 'transparent',
    height: ReactNative.Dimensions.get('window').width,
    width: ReactNative.Dimensions.get('window').width,
  },
  rectangleContainer: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: 'transparent',
  },
  rectangle: {
    height: 250,
    width: 250,
    borderWidth: 2,
    borderColor: '#00FF00',
    backgroundColor: 'transparent',
  },
});
