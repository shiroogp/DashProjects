var t = /^ {4}at (.+?)(?: \((native)\)?| \((address at )?(.+?):(\d+):(\d+)\))$/,
  n = /^ {4}... skipping (\d+) frames$/;

function s(s) {
  var u = s.match(t);
  if (u)
    return {
      type: 'FRAME',
      functionName: u[1],
      location:
        'native' === u[2]
          ? {
              type: 'NATIVE',
            }
          : 'address at ' === u[3]
          ? {
              type: 'BYTECODE',
              sourceUrl: u[4],
              line1Based: Number.parseInt(u[5], 10),
              virtualOffset0Based: Number.parseInt(u[6], 10),
            }
          : {
              type: 'SOURCE',
              sourceUrl: u[4],
              line1Based: Number.parseInt(u[5], 10),
              column1Based: Number.parseInt(u[6], 10),
            },
    };
  var p = s.match(n);
  return p
    ? {
        type: 'SKIPPED',
        count: Number.parseInt(p[1], 10),
      }
    : undefined;
}

module.exports = function (t) {
  for (var n = t.split(/\n/), u = [], p = -1, o = 0; o < n.length; ++o) {
    var c = n[o];

    if (c) {
      var f = s(c);
      if (f) u.push(f);
      else {
        p = o;
        u = [];
      }
    }
  }

  return {
    message: n.slice(0, p + 1).join('\n'),
    entries: u,
  };
};
