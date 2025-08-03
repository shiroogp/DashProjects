module.exports = function (c, l, n) {
  switch (n.length) {
    case 0:
      return c.call(l);

    case 1:
      return c.call(l, n[0]);

    case 2:
      return c.call(l, n[0], n[1]);

    case 3:
      return c.call(l, n[0], n[1], n[2]);
  }

  return c.apply(l, n);
};
