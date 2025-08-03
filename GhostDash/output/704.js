exports.default = function (n) {
  var t = false;
  if (
    n &&
    (t = Object.keys(n).some(function (n) {
      return 'screens' !== n && 'initialRouteName' !== n;
    })) &&
    (n.hasOwnProperty('screens') || n.hasOwnProperty('initialRouteName'))
  )
    throw new Error(
      'Found invalid keys in the configuration object. See https://reactnavigation.org/docs/configuring-links/ for more details on the shape of the configuration object.'
    );
  if (t)
    return [
      t,
      {
        screens: n,
      },
    ];
  return [t, n];
};
