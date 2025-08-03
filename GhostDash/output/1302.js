exports.getProps = function (o) {
  return {
    shadow: !o.shadow || o.shadow,
    rounded: !!o.rounded && o.rounded,
    background: o.background ? o.background : '#FFF',
  };
};
