var regeneratorRuntime = require('regenerator-runtime');

exports.currentBluetoothState = regeneratorRuntime.atom({
  key: 'btState',
  default: 'off',
});
exports.currentWifiState = regeneratorRuntime.atom({
  key: 'wifiState',
  default: 'off',
});
exports.bluetoothNotification = regeneratorRuntime.atom({
  key: 'btNotification',
  default: {
    type: '',
    data: '',
  },
});
