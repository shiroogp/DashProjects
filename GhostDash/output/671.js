exports.default = function (t) {
  return function () {
    if (undefined !== arguments[0])
      throw new Error(
        "Creating a navigator doesn't take an argument. Maybe you are trying to use React Navigation 4 API with React Navigation 5? See https://reactnavigation.org/docs/upgrading-from-4.x for migration guide."
      );
    return {
      Navigator: t,
      Screen: module672.default,
    };
  };
};

var module672 = require('./672');
