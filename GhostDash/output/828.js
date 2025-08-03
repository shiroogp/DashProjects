var module827 = require('./827');

module.exports = function (f, n) {
  var u = n ? module827(f.buffer) : f.buffer;
  return new f.constructor(u, f.byteOffset, f.byteLength);
};
