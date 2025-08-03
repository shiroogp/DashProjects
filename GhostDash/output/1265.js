var module35 = require('./35'),
  module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  React = require('react'),
  module1208 = require('./1208'),
  module1266 = require('./1266');

function v(t) {
  var n = y();
  return function () {
    var o,
      s = module37.default(t);

    if (n) {
      var u = module37.default(this).constructor;
      o = Reflect.construct(s, arguments, u);
    } else o = s.apply(this, arguments);

    return module40.default(this, o);
  };
}

function y() {
  if ('undefined' == typeof Reflect || !Reflect.construct) return false;
  if (Reflect.construct.sham) return false;
  if ('function' == typeof Proxy) return true;

  try {
    Boolean.prototype.valueOf.call(Reflect.construct(Boolean, [], function () {}));
    return true;
  } catch (t) {
    return false;
  }
}

Object.freeze({});

var k = function () {},
  b = Object.freeze({}),
  x = Object.freeze([]),
  C = module1208.default.Nil;

function T(t, n) {
  if (n.factory) return n.factory;
  if (t.getTcombFormFactory) return t.getTcombFormFactory(n);
  var o = module1208.default.getTypeName(t);

  switch (t.meta.kind) {
    case 'irreducible':
      return t === module1208.default.Boolean ? V : t === module1208.default.Date ? D : S;

    case 'struct':
      return N;

    case 'list':
      return F;

    case 'enums':
      return L;

    case 'maybe':
    case 'subtype':
      return T(t.meta.type, n);

    default:
      module1208.default.fail('[tcomb-form-native] unsupported type ' + o);
  }
}

function I(t, n) {
  return t.text < n.text ? -1 : t.text > n.text ? 1 : 0;
}

var E = (function (t) {
  module38.default(l, t);
  var n = v(l);

  function l(t) {
    var s;
    module27.default(this, l);
    (s = n.call(this, t)).typeInfo = module1266.getTypeInfo(t.type);
    s.state = {
      hasError: false,
      value: s.getTransformer().format(t.value),
    };
    return s;
  }

  module28.default(l, [
    {
      key: 'getTransformer',
      value: function () {
        return this.props.options.transformer || this.constructor.transformer;
      },
    },
    {
      key: 'shouldComponentUpdate',
      value: function (t, n) {
        return n.value !== this.state.value || n.hasError !== this.state.hasError || t.options !== this.props.options || t.type !== this.props.type;
      },
    },
    {
      key: 'componentWillReceiveProps',
      value: function (t) {
        if (t.type !== this.props.type) this.typeInfo = module1266.getTypeInfo(t.type);
        this.setState({
          value: this.getTransformer().format(t.value),
        });
      },
    },
    {
      key: 'onChange',
      value: function (t) {
        var n = this;
        this.setState(
          {
            value: t,
          },
          function () {
            return n.props.onChange(t, n.props.ctx.path);
          }
        );
      },
    },
    {
      key: 'getValidationOptions',
      value: function () {
        return {
          path: this.props.ctx.path,
          context: module1208.default.mixin(module1208.default.mixin({}, this.props.context || this.props.ctx.context), {
            options: this.props.options,
          }),
        };
      },
    },
    {
      key: 'getValue',
      value: function () {
        return this.getTransformer().parse(this.state.value);
      },
    },
    {
      key: 'isValueNully',
      value: function () {
        return C.is(this.getValue());
      },
    },
    {
      key: 'removeErrors',
      value: function () {
        this.setState({
          hasError: false,
        });
      },
    },
    {
      key: 'pureValidate',
      value: function () {
        return module1208.default.validate(this.getValue(), this.props.type, this.getValidationOptions());
      },
    },
    {
      key: 'validate',
      value: function () {
        var t = this.pureValidate();
        this.setState({
          hasError: !t.isValid(),
        });
        return t;
      },
    },
    {
      key: 'getAuto',
      value: function () {
        return this.props.options.auto || this.props.ctx.auto;
      },
    },
    {
      key: 'getI18n',
      value: function () {
        return this.props.options.i18n || this.props.ctx.i18n;
      },
    },
    {
      key: 'getDefaultLabel',
      value: function () {
        var t = this.props.ctx;
        if (t.label) return t.label + (this.typeInfo.isMaybe ? this.getI18n().optional : this.getI18n().required);
      },
    },
    {
      key: 'getLabel',
      value: function () {
        var t = this.props.options.label || this.props.options.legend;
        if (C.is(t) && 'placeholders' === this.getAuto()) t = null;
        else if (C.is(t) && 'labels' === this.getAuto()) t = this.getDefaultLabel();
        else if (t) t += this.typeInfo.isMaybe ? this.getI18n().optional : this.getI18n().required;
        return t;
      },
    },
    {
      key: 'getError',
      value: function () {
        if (this.hasError()) {
          var t = this.props.options.error || this.typeInfo.getValidationErrorMessage;

          if (module1208.default.Function.is(t)) {
            var n = this.getValidationOptions();
            return t(this.getValue(), n.path, n.context);
          }

          return t;
        }
      },
    },
    {
      key: 'hasError',
      value: function () {
        return this.props.options.hasError || this.state.hasError;
      },
    },
    {
      key: 'getConfig',
      value: function () {
        return module1266.merge(this.props.ctx.config, this.props.options.config);
      },
    },
    {
      key: 'getStylesheet',
      value: function () {
        return this.props.options.stylesheet || this.props.ctx.stylesheet;
      },
    },
    {
      key: 'getLocals',
      value: function () {
        return {
          path: this.props.ctx.path,
          error: this.getError(),
          hasError: this.hasError(),
          label: this.getLabel(),
          onChange: this.onChange.bind(this),
          config: this.getConfig(),
          value: this.state.value,
          hidden: this.props.options.hidden,
          stylesheet: this.getStylesheet(),
        };
      },
    },
    {
      key: 'render',
      value: function () {
        var t = this.getLocals();
        module1208.default.assert(module1208.default.Function.is(this.getTemplate), '[tcomb-form-native] missing getTemplate method of component ' + this.constructor.name);
        return this.getTemplate()(t);
      },
    },
  ]);
  return l;
})(React.default.Component);

function O(t) {
  return (module1208.default.String.is(t) && '' === t.trim()) || C.is(t) ? null : t;
}

E.transformer = {
  format: function (t) {
    return C.is(t) ? null : t;
  },
  parse: function (t) {
    return t;
  },
};

var S = (function (t) {
  module38.default(h, t);
  var l = v(h);

  function h() {
    module27.default(this, h);
    return l.apply(this, arguments);
  }

  module28.default(h, [
    {
      key: 'getTransformer',
      value: function () {
        var t = this.props.options;
        return t.transformer ? t.transformer : this.typeInfo.innerType === module1208.default.Number ? h.numberTransformer : h.transformer;
      },
    },
    {
      key: 'getTemplate',
      value: function () {
        return this.props.options.template || this.props.ctx.templates.textbox;
      },
    },
    {
      key: 'getPlaceholder',
      value: function () {
        var t = this.props.options.placeholder;
        if (C.is(t) && 'placeholders' === this.getAuto()) t = this.getDefaultLabel();
        return t;
      },
    },
    {
      key: 'getKeyboardType',
      value: function () {
        var t = this.props.options.keyboardType;
        return module1208.default.Nil.is(t) && this.typeInfo.innerType === module1208.default.Number ? 'numeric' : t;
      },
    },
    {
      key: 'getLocals',
      value: function () {
        var t = this,
          o = module35.default(module37.default(h.prototype), 'getLocals', this).call(this);
        o.placeholder = this.getPlaceholder();
        o.onChangeNative = this.props.options.onChange;
        o.keyboardType = this.getKeyboardType();
        o.underlineColorAndroid = this.props.options.underlineColorAndroid || 'transparent';
        [
          'help',
          'allowFontScaling',
          'autoCapitalize',
          'autoCorrect',
          'autoFocus',
          'blurOnSubmit',
          'editable',
          'maxLength',
          'multiline',
          'onBlur',
          'onEndEditing',
          'onFocus',
          'onLayout',
          'onSelectionChange',
          'onSubmitEditing',
          'onContentSizeChange',
          'placeholderTextColor',
          'secureTextEntry',
          'selectTextOnFocus',
          'selectionColor',
          'numberOfLines',
          'clearButtonMode',
          'clearTextOnFocus',
          'enablesReturnKeyAutomatically',
          'keyboardAppearance',
          'onKeyPress',
          'returnKeyType',
          'selectionState',
          'testID',
          'textContentType',
        ].forEach(function (n) {
          return (o[n] = t.props.options[n]);
        });
        return o;
      },
    },
  ]);
  return h;
})(E);

S.transformer = {
  format: function (t) {
    return C.is(t) ? '' : t;
  },
  parse: O,
};
S.numberTransformer = {
  format: function (t) {
    return C.is(t) ? '' : String(t);
  },
  parse: function (t) {
    var n = parseFloat(t);
    return t - n + 1 >= 0 ? n : O(t);
  },
};

var V = (function (t) {
  module38.default(h, t);
  var l = v(h);

  function h() {
    module27.default(this, h);
    return l.apply(this, arguments);
  }

  module28.default(h, [
    {
      key: 'getTemplate',
      value: function () {
        return this.props.options.template || this.props.ctx.templates.checkbox;
      },
    },
    {
      key: 'getLocals',
      value: function () {
        var t = this,
          o = module35.default(module37.default(h.prototype), 'getLocals', this).call(this);
        o.label = 'none' !== this.props.ctx.auto ? o.label || this.getDefaultLabel() : null;
        ['help', 'disabled', 'onTintColor', 'thumbTintColor', 'tintColor', 'testID'].forEach(function (n) {
          return (o[n] = t.props.options[n]);
        });
        return o;
      },
    },
  ]);
  return h;
})(E);

V.transformer = {
  format: function (t) {
    return !C.is(t) && t;
  },
  parse: function (t) {
    return t;
  },
};

var L = (function (t) {
  module38.default(h, t);
  var l = v(h);

  function h() {
    module27.default(this, h);
    return l.apply(this, arguments);
  }

  module28.default(h, [
    {
      key: 'getTransformer',
      value: function () {
        var t = this.props.options;
        return t.transformer ? t.transformer : h.transformer(this.getNullOption());
      },
    },
    {
      key: 'getTemplate',
      value: function () {
        return this.props.options.template || this.props.ctx.templates.select;
      },
    },
    {
      key: 'getNullOption',
      value: function () {
        return (
          this.props.options.nullOption || {
            value: '',
            text: '-',
          }
        );
      },
    },
    {
      key: 'getEnum',
      value: function () {
        return this.typeInfo.innerType;
      },
    },
    {
      key: 'getOptions',
      value: function () {
        var t = this.props.options,
          n = t.options ? t.options.slice() : module1266.getOptionsOfEnum(this.getEnum());
        if (t.order)
          n.sort(
            {
              asc: I,
              desc: function (t, n) {
                return -I(t, n);
              },
            }[t.order]
          );
        var o = this.getNullOption();
        if (false !== t.nullOption) n.unshift(o);
        return n;
      },
    },
    {
      key: 'getLocals',
      value: function () {
        var t = this,
          o = module35.default(module37.default(h.prototype), 'getLocals', this).call(this);
        o.options = this.getOptions();
        ['help', 'disabled', 'mode', 'prompt', 'itemStyle', 'isCollapsed', 'onCollapseChange', 'testID'].forEach(function (n) {
          return (o[n] = t.props.options[n]);
        });
        return o;
      },
    },
  ]);
  return h;
})(E);

L.transformer = function (t) {
  return {
    format: function (n) {
      return C.is(n) && t ? t.value : String(n);
    },
    parse: function (n) {
      return t && t.value === n ? null : n;
    },
  };
};

var D = (function (t) {
  module38.default(h, t);
  var l = v(h);

  function h() {
    module27.default(this, h);
    return l.apply(this, arguments);
  }

  module28.default(h, [
    {
      key: 'getTemplate',
      value: function () {
        return this.props.options.template || this.props.ctx.templates.datepicker;
      },
    },
    {
      key: 'getLocals',
      value: function () {
        var t = this,
          o = module35.default(module37.default(h.prototype), 'getLocals', this).call(this);
        ['help', 'disabled', 'maximumDate', 'minimumDate', 'minuteInterval', 'mode', 'timeZoneOffsetInMinutes', 'onPress'].forEach(function (n) {
          return (o[n] = t.props.options[n]);
        });
        return o;
      },
    },
  ]);
  return h;
})(E);

D.transformer = {
  format: function (t) {
    return C.is(t) ? null : t;
  },
  parse: function (t) {
    return t;
  },
};

var N = (function (t) {
  module38.default(y, t);
  var l = v(y);

  function y() {
    module27.default(this, y);
    return l.apply(this, arguments);
  }

  module28.default(y, [
    {
      key: 'isValueNully',
      value: function () {
        var t = this;
        return Object.keys(this.refs).every(function (n) {
          return t.refs[n].isValueNully();
        });
      },
    },
    {
      key: 'removeErrors',
      value: function () {
        var t = this;
        this.setState({
          hasError: false,
        });
        Object.keys(this.refs).forEach(function (n) {
          return t.refs[n].removeErrors();
        });
      },
    },
    {
      key: 'getValue',
      value: function () {
        var t = {};

        for (var n in this.refs) t[n] = this.refs[n].getValue();

        return this.getTransformer().parse(t);
      },
    },
    {
      key: 'validate',
      value: function () {
        var t,
          n = {},
          o = [],
          s = false;

        if (this.typeInfo.isMaybe && this.isValueNully()) {
          this.removeErrors();
          return new module1208.default.ValidationResult({
            errors: [],
            value: null,
          });
        }

        for (var u in this.refs) this.refs.hasOwnProperty(u) && ((t = this.refs[u].validate()), (o = o.concat(t.errors)), (n[u] = t.value));

        if (0 === o.length) {
          n = new this.typeInfo.innerType(n);

          if (this.typeInfo.isSubtype && 0 === o.length) {
            s = !(t = module1208.default.validate(n, this.props.type, this.getValidationOptions())).isValid();
            o = o.concat(t.errors);
          }
        }

        this.setState({
          hasError: s,
        });
        return new module1208.default.ValidationResult({
          errors: o,
          value: n,
        });
      },
    },
    {
      key: 'onChange',
      value: function (t, n, o) {
        var s = this,
          u = module1208.default.mixin({}, this.state.value);
        u[t] = n;
        this.setState(
          {
            value: u,
          },
          function () {
            s.props.onChange(u, o);
          }
        );
      },
    },
    {
      key: 'getTemplates',
      value: function () {
        return module1266.merge(this.props.ctx.templates, this.props.options.templates);
      },
    },
    {
      key: 'getTemplate',
      value: function () {
        return this.props.options.template || this.getTemplates().struct;
      },
    },
    {
      key: 'getTypeProps',
      value: function () {
        return this.typeInfo.innerType.meta.props;
      },
    },
    {
      key: 'getOrder',
      value: function () {
        return this.props.options.order || Object.keys(this.getTypeProps());
      },
    },
    {
      key: 'getInputs',
      value: function () {
        var t = this.props,
          n = t.ctx,
          o = t.options,
          s = this.getTypeProps(),
          u = this.getAuto(),
          l = this.getI18n(),
          p = this.getConfig(),
          f = this.state.value || {},
          v = this.getTemplates(),
          y = this.getStylesheet(),
          k = {};

        for (var x in s)
          if (s.hasOwnProperty(x)) {
            var C = s[x],
              I = f[x],
              E = module1266.getTypeFromUnion(C, I),
              O = o.fields || b,
              S = module1266.getComponentOptions(O[x], b, I, C);
            k[x] = React.default.createElement(T(E, S), {
              key: x,
              ref: x,
              type: E,
              options: S,
              value: f[x],
              onChange: this.onChange.bind(this, x),
              ctx: {
                context: n.context,
                uidGenerator: n.uidGenerator,
                auto: u,
                config: p,
                label: module1266.humanize(x),
                i18n: l,
                stylesheet: y,
                templates: v,
                path: this.props.ctx.path.concat(x),
              },
            });
          }

        return k;
      },
    },
    {
      key: 'getLocals',
      value: function () {
        var t = this.getTemplates(),
          o = module35.default(module37.default(y.prototype), 'getLocals', this).call(this);
        o.order = this.getOrder();
        o.inputs = this.getInputs();
        o.template = t.struct;
        return o;
      },
    },
  ]);
  return y;
})(E);

function w(t, n, o) {
  if (t.length === n.length) return n;

  for (var s = [], u = 0, l = t.length; u < l; u++) s[u] = n[u] || o.next();

  return s;
}

var F = (exports.List = (function (t) {
  module38.default(y, t);
  var l = v(y);

  function y(t) {
    var n;
    module27.default(this, y);
    (n = l.call(this, t)).state.keys = n.state.value.map(function () {
      return t.ctx.uidGenerator.next();
    });
    return n;
  }

  module28.default(y, [
    {
      key: 'componentWillReceiveProps',
      value: function (t) {
        if (t.type !== this.props.type) this.typeInfo = module1266.getTypeInfo(t.type);
        var n = this.getTransformer().format(t.value);
        this.setState({
          value: n,
          keys: w(n, this.state.keys, t.ctx.uidGenerator),
        });
      },
    },
    {
      key: 'isValueNully',
      value: function () {
        return 0 === this.state.value.length;
      },
    },
    {
      key: 'removeErrors',
      value: function () {
        var t = this;
        this.setState({
          hasError: false,
        });
        Object.keys(this.refs).forEach(function (n) {
          return t.refs[n].removeErrors();
        });
      },
    },
    {
      key: 'getValue',
      value: function () {
        for (var t = [], n = 0, o = this.state.value.length; n < o; n++) this.refs.hasOwnProperty(n) && t.push(this.refs[n].getValue());

        return this.getTransformer().parse(t);
      },
    },
    {
      key: 'validate',
      value: function () {
        var t,
          n = [],
          o = [],
          s = false;

        if (this.typeInfo.isMaybe && this.isValueNully()) {
          this.removeErrors();
          return new module1208.default.ValidationResult({
            errors: [],
            value: null,
          });
        }

        for (var u = 0, l = this.state.value.length; u < l; u++) {
          t = this.refs[u].validate();
          o = o.concat(t.errors);
          n.push(t.value);
        }

        if (this.typeInfo.isSubtype && 0 === o.length) {
          s = !(t = module1208.default.validate(n, this.props.type, this.getValidationOptions())).isValid();
          o = o.concat(t.errors);
        }

        this.setState({
          hasError: s,
        });
        return new module1208.default.ValidationResult({
          errors: o,
          value: n,
        });
      },
    },
    {
      key: 'onChange',
      value: function (t, n, o, s) {
        var u = this,
          l = w(t, n, this.props.ctx.uidGenerator);
        this.setState(
          {
            value: t,
            keys: l,
            isPristine: false,
          },
          function () {
            u.props.onChange(t, o, s);
          }
        );
      },
    },
    {
      key: 'addItem',
      value: function () {
        var t = this.state.value.concat(undefined),
          n = this.state.keys.concat(this.props.ctx.uidGenerator.next());
        this.onChange(t, n, this.props.ctx.path.concat(t.length - 1), 'add');
      },
    },
    {
      key: 'onItemChange',
      value: function (t, n, o, s) {
        var u = this.state.value.slice();
        u[t] = n;
        this.onChange(u, this.state.keys, o, s);
      },
    },
    {
      key: 'removeItem',
      value: function (t) {
        var n = this.state.value.slice();
        n.splice(t, 1);
        var o = this.state.keys.slice();
        o.splice(t, 1);
        this.onChange(n, o, this.props.ctx.path.concat(t), 'remove');
      },
    },
    {
      key: 'moveUpItem',
      value: function (t) {
        if (t > 0) this.onChange(module1266.move(this.state.value.slice(), t, t - 1), module1266.move(this.state.keys.slice(), t, t - 1), this.props.ctx.path.concat(t), 'moveUp');
      },
    },
    {
      key: 'moveDownItem',
      value: function (t) {
        if (t < this.state.value.length - 1)
          this.onChange(module1266.move(this.state.value.slice(), t, t + 1), module1266.move(this.state.keys.slice(), t, t + 1), this.props.ctx.path.concat(t), 'moveDown');
      },
    },
    {
      key: 'getTemplates',
      value: function () {
        return module1266.merge(this.props.ctx.templates, this.props.options.templates);
      },
    },
    {
      key: 'getTemplate',
      value: function () {
        return this.props.options.template || this.getTemplates().list;
      },
    },
    {
      key: 'getItems',
      value: function () {
        var t = this,
          n = this.props,
          o = n.options,
          s = n.ctx,
          u = this.getAuto(),
          l = this.getI18n(),
          p = this.getConfig(),
          f = this.getStylesheet(),
          v = this.getTemplates();
        return this.state.value.map(function (n, y) {
          var k = t.typeInfo.innerType.meta.type,
            x = module1266.getTypeFromUnion(k, n),
            C = module1266.getComponentOptions(o.item, b, n, k),
            I = T(x, C),
            E = [];
          if (!o.disableRemove)
            E.push({
              type: 'remove',
              label: l.remove,
              click: t.removeItem.bind(t, y),
            });
          if (!o.disableOrder)
            E.push(
              {
                type: 'move-up',
                label: l.up,
                click: t.moveUpItem.bind(t, y),
              },
              {
                type: 'move-down',
                label: l.down,
                click: t.moveDownItem.bind(t, y),
              }
            );
          return {
            input: React.default.createElement(I, {
              ref: y,
              type: x,
              options: C,
              value: n,
              onChange: t.onItemChange.bind(t, y),
              ctx: {
                context: s.context,
                uidGenerator: s.uidGenerator,
                auto: u,
                config: p,
                label: s.label ? s.label + '[' + (y + 1) + ']' : String(y + 1),
                i18n: l,
                stylesheet: f,
                templates: v,
                path: s.path.concat(y),
              },
            }),
            key: t.state.keys[y],
            buttons: E,
          };
        });
      },
    },
    {
      key: 'getLocals',
      value: function () {
        var t = this.props.options,
          o = this.getI18n(),
          s = module35.default(module37.default(y.prototype), 'getLocals', this).call(this);
        s.add = t.disableAdd
          ? null
          : {
              type: 'add',
              label: o.add,
              click: this.addItem.bind(this),
            };
        s.items = this.getItems();
        s.className = t.className;
        return s;
      },
    },
  ]);
  return y;
})(E));

F.transformer = {
  format: function (t) {
    return C.is(t) ? x : t;
  },
  parse: function (t) {
    return t;
  },
};

var P = (function (t) {
  module38.default(l, t);
  var n = v(l);

  function l() {
    module27.default(this, l);
    return n.apply(this, arguments);
  }

  module28.default(l, [
    {
      key: 'pureValidate',
      value: function () {
        return this.refs.input.pureValidate();
      },
    },
    {
      key: 'validate',
      value: function () {
        return this.refs.input.validate();
      },
    },
    {
      key: 'getValue',
      value: function () {
        var t = this.validate();
        return t.isValid() ? t.value : null;
      },
    },
    {
      key: 'getComponent',
      value: function (t) {
        return (t = module1208.default.String.is(t) ? t.split('.') : t).reduce(function (t, n) {
          return t.refs[n];
        }, this.refs.input);
      },
    },
    {
      key: 'getSeed',
      value: function () {
        var t = this._reactInternalInstance;

        if (t) {
          if (t._hostContainerInfo) return t._hostContainerInfo._idCounter;
          if (t._nativeContainerInfo) return t._nativeContainerInfo._idCounter;
          if (t._rootNodeID) return t._rootNodeID;
        }

        return '0';
      },
    },
    {
      key: 'getUIDGenerator',
      value: function () {
        this.uidGenerator = this.uidGenerator || new module1266.UIDGenerator(this.getSeed());
        return this.uidGenerator;
      },
    },
    {
      key: 'render',
      value: function () {
        var t = this.props.stylesheet || l.stylesheet,
          n = this.props.templates || l.templates,
          o = this.props.i18n || l.i18n,
          s = this.props.value,
          u = module1266.getTypeFromUnion(this.props.type, s),
          p = module1266.getComponentOptions(this.props.options, b, s, this.props.type),
          f = this.getUIDGenerator();
        return React.default.createElement(T(u, p), {
          ref: 'input',
          type: u,
          options: p,
          value: this.props.value,
          onChange: this.props.onChange || k,
          ctx: {
            context: this.props.context,
            uidGenerator: f,
            auto: 'labels',
            stylesheet: t,
            templates: n,
            i18n: o,
            path: [],
          },
        });
      },
    },
  ]);
  return l;
})(React.default.Component);

module.exports = {
  getComponent: T,
  Component: E,
  Textbox: S,
  Checkbox: V,
  Select: L,
  DatePicker: D,
  Struct: N,
  List: F,
  Form: P,
};
