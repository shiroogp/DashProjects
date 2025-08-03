var module14 = require('./14'),
  module1182 = require('./1182'),
  module1171 = require('./1171'),
  module1159 = require('./1159');

exports.default = function (t) {
  if (
    ((window.location = ''),
    window.XMLHttpRequest.isRNFBPolyfill ||
      ((window.XMLHttpRequest = module1171.default),
      console.warn(
        'Use JSONStream will automatically replace window.XMLHttpRequest with RNFetchBlob.polyfill.XMLHttpRequest. You are seeing this warning because you did not replace it manually.'
      )),
    'string' == typeof t)
  )
    t = module1159.default.isFileURI(t)
      ? {
          url: 'JSONStream://' + t,
          headers: {
            noCache: true,
          },
        }
      : 'JSONStream://' + t;
  else if ('object' == typeof t) {
    var s = t.headers || {};
    if (module1159.default.isFileURI(t.url)) s.noCache = true;
    t = module14.default(t, {
      url: 'JSONStream://' + t.url,
      headers: s,
    });
  }
  return module1182.default(t);
};
