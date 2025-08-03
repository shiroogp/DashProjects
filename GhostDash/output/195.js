var module96 = require('./96');

module.exports = {
  showErrorDialog: function (o) {
    var t,
      c = o.componentStack,
      p = o.error;
    t = p instanceof Error ? p : 'string' == typeof p ? new module96.SyntheticError(p) : new module96.SyntheticError('Unspecified error');

    try {
      t.componentStack = c;
      t.isComponentError = true;
    } catch (n) {}

    module96.handleException(t, false);
    return false;
  },
};
