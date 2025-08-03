var module1220 = require('./1220');

module.exports = function (t) {
  return (
    '{' +
    Object.keys(t)
      .map(function (o) {
        return o + ': ' + module1220(t[o]);
      })
      .join(', ') +
    '}'
  );
};
