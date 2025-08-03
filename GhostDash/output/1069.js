var t = {
  check: true,
  checkLocationAccuracy: true,
  checkMultiple: true,
  checkNotifications: true,
  openLimitedPhotoLibraryPicker: true,
  openSettings: true,
  request: true,
  requestLocationAccuracy: true,
  requestMultiple: true,
  requestNotifications: true,
  PERMISSIONS: true,
  RESULTS: true,
};
Object.defineProperty(exports, 'PERMISSIONS', {
  enumerable: true,
  get: function () {
    return module1074.PERMISSIONS;
  },
});
Object.defineProperty(exports, 'RESULTS', {
  enumerable: true,
  get: function () {
    return module1075.RESULTS;
  },
});

var regeneratorRuntime = require('regenerator-runtime'),
  module1074 = require('./1074'),
  module1075 = require('./1075'),
  module1076 = require('./1076');

Object.keys(module1076).forEach(function (c) {
  if ('default' !== c && '__esModule' !== c)
    Object.prototype.hasOwnProperty.call(t, c) ||
      (c in exports && exports[c] === module1076[c]) ||
      Object.defineProperty(exports, c, {
        enumerable: true,
        get: function () {
          return module1076[c];
        },
      });
});
var s = (exports.check = regeneratorRuntime.methods.check),
  h = (exports.checkLocationAccuracy = regeneratorRuntime.methods.checkLocationAccuracy),
  l = (exports.checkMultiple = regeneratorRuntime.methods.checkMultiple),
  S = (exports.checkNotifications = regeneratorRuntime.methods.checkNotifications),
  p = (exports.openLimitedPhotoLibraryPicker = regeneratorRuntime.methods.openLimitedPhotoLibraryPicker),
  k = (exports.openSettings = regeneratorRuntime.methods.openSettings),
  L = (exports.request = regeneratorRuntime.methods.request),
  f = (exports.requestLocationAccuracy = regeneratorRuntime.methods.requestLocationAccuracy),
  y = (exports.requestMultiple = regeneratorRuntime.methods.requestMultiple),
  q = (exports.requestNotifications = regeneratorRuntime.methods.requestNotifications);
exports.default = {
  PERMISSIONS: module1074.PERMISSIONS,
  RESULTS: module1075.RESULTS,
  check: s,
  checkLocationAccuracy: h,
  checkMultiple: l,
  checkNotifications: S,
  openLimitedPhotoLibraryPicker: p,
  openSettings: k,
  request: L,
  requestLocationAccuracy: f,
  requestMultiple: y,
  requestNotifications: q,
};
