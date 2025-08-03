exports.handlePress = function (n) {
  var u = n.onPress,
    c = n.value,
    s = n.onValueChange;
  if (s) s(c);
  else if (!(null === u || undefined === u)) u();
};

exports.isChecked = function (n) {
  var u = n.value,
    c = n.status,
    s = n.contextValue;
  return s ? (s === u ? 'checked' : 'unchecked') : c;
};
