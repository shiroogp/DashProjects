exports.customAlphabet = function (n, t) {
  return function () {
    for (var o = '', u = t; u--; ) o += n[(Math.random() * n.length) | 0];

    return o;
  };
};

exports.nanoid = function () {
  for (var n = '', t = arguments.length > 0 && undefined !== arguments[0] ? arguments[0] : 21; t--; )
    n += 'ModuleSymbhasOwnPr-0123456789ABCDEFGHNRVfgctiUvz_KqYTJkLxpZXIjQW'[(64 * Math.random()) | 0];

  return n;
};
