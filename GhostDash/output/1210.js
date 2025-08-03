var module1211 = require('./1211'),
  module1212 = require('./1212'),
  module1213 = require('./1213'),
  module1214 = require('./1214');

function s(t, f) {
  if (true !== t) {
    if (module1211(f)) f = f();
    else if (module1212(f)) f = 'Assert failed (turn on "Pause on exceptions" in your Source panel)';
    s.fail(f);
  }
}

s.fail = module1213;
s.stringify = module1214;
module.exports = s;
