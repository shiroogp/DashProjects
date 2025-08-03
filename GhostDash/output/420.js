exports.SensorType = (function (t) {
  t[(t.ACCELEROMETER = 1)] = 'ACCELEROMETER';
  t[(t.GYROSCOPE = 2)] = 'GYROSCOPE';
  t[(t.GRAVITY = 3)] = 'GRAVITY';
  t[(t.MAGNETIC_FIELD = 4)] = 'MAGNETIC_FIELD';
  t[(t.ROTATION = 5)] = 'ROTATION';
  return t;
})({});

exports.IOSReferenceFrame = (function (t) {
  t[(t.XArbitraryZVertical = 0)] = 'XArbitraryZVertical';
  t[(t.XArbitraryCorrectedZVertical = 1)] = 'XArbitraryCorrectedZVertical';
  t[(t.XMagneticNorthZVertical = 2)] = 'XMagneticNorthZVertical';
  t[(t.XTrueNorthZVertical = 3)] = 'XTrueNorthZVertical';
  t[(t.Auto = 4)] = 'Auto';
  return t;
})({});

exports.InterfaceOrientation = (function (t) {
  t[(t.ROTATION_0 = 0)] = 'ROTATION_0';
  t[(t.ROTATION_90 = 90)] = 'ROTATION_90';
  t[(t.ROTATION_180 = 180)] = 'ROTATION_180';
  t[(t.ROTATION_270 = 270)] = 'ROTATION_270';
  return t;
})({});

exports.KeyboardState = (function (t) {
  t[(t.UNKNOWN = 0)] = 'UNKNOWN';
  t[(t.OPENING = 1)] = 'OPENING';
  t[(t.OPEN = 2)] = 'OPEN';
  t[(t.CLOSING = 3)] = 'CLOSING';
  t[(t.CLOSED = 4)] = 'CLOSED';
  return t;
})({});
