var module1207 = require('./1207'),
  module1267 = require('./1267'),
  module1268 = require('./1268'),
  module1275 = require('./1275');

module1207.default.form.Form.templates = module1268.default;
module1207.default.form.Form.stylesheet = module1275.default;
module1207.default.form.Form.i18n = module1267.default;
module1207.default.form.Form.defaultProps = {
  templates: module1207.default.form.Form.templates,
  stylesheet: module1207.default.form.Form.stylesheet,
  i18n: module1207.default.form.Form.i18n,
};
module.exports = module1207.default;
