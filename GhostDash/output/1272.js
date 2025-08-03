var React = require('@babel/runtime/helpers/interopRequireDefault')(require('react')),
  ReactNative = require('react-native');

module.exports = function (o) {
  if (o.hidden) return null;
  var l = o.stylesheet,
    u = l.formGroup.normal,
    c = l.controlLabel.normal,
    s = l.datepicker.normal,
    f = l.helpBlock.normal,
    v = l.errorBlock,
    h = l.dateValue.normal;

  if (o.hasError) {
    u = l.formGroup.error;
    c = l.controlLabel.error;
    s = l.datepicker.error;
    f = l.helpBlock.error;
    h = l.dateValue.error;
  }

  var b = o.mode;
  if ('date' !== b && 'time' !== b && 'datetime' !== b) throw new Error('Unrecognized date picker format ' + b);
  var D = o.value ? String(o.value) : '',
    k = ReactNative.TouchableNativeFeedback.SelectableBackground(),
    p = 'default',
    T = o.value ? o.value.toDateString() : '',
    x = o.value ? o.value.toTimeString() : '';

  if (o.config) {
    if (o.config.format && D) D = o.config.format(o.value);
    else if (!D) D = o.config.defaultValueText ? o.config.defaultValueText : 'Tap here to select a date';
    if (o.config.background) k = o.config.background;
    if (o.config.dialogMode) p = o.config.dialogMode;
    if (o.config.dateFormat && T) T = o.config.dateFormat(o.value);
    else if (!T) T = o.config.defaultValueText ? o.config.defaultValueText : 'Tap here to select a date';
    if (o.config.timeFormat && x) x = o.config.timeFormat(o.value);
    else if (!x) x = o.config.defaultValueText ? o.config.defaultValueText : 'Tap here to select a time';
  }

  var y = o.label
      ? React.default.createElement(
          ReactNative.Text,
          {
            style: c,
          },
          o.label
        )
      : null,
    E = o.help
      ? React.default.createElement(
          ReactNative.Text,
          {
            style: f,
          },
          o.help
        )
      : null,
    P =
      o.hasError && o.error
        ? React.default.createElement(
            ReactNative.Text,
            {
              accessibilityLiveRegion: 'polite',
              style: v,
            },
            o.error
          )
        : null,
    w = D
      ? React.default.createElement(
          ReactNative.Text,
          {
            style: h,
          },
          D
        )
      : null;
  return React.default.createElement(
    ReactNative.View,
    {
      style: u,
    },
    'datetime' === b
      ? React.default.createElement(
          ReactNative.View,
          {
            style: s,
          },
          y,
          React.default.createElement(
            ReactNative.TouchableNativeFeedback,
            {
              accessible: true,
              disabled: o.disabled,
              ref: 'input',
              background: k,
              onPress: function () {
                var t = {
                  date: o.value || new Date(),
                  mode: p,
                };
                if (o.minimumDate) t.minDate = o.minimumDate;
                if (o.maximumDate) t.maxDate = o.maximumDate;
                ReactNative.DatePickerAndroid.open(t).then(function (t) {
                  if (t.action !== ReactNative.DatePickerAndroid.dismissedAction) {
                    var l = new Date(o.value);
                    l.setFullYear(t.year, t.month, t.day);
                    o.onChange(l);
                  }
                });
                if ('function' == typeof o.onPress) o.onPress();
              },
            },
            React.default.createElement(
              ReactNative.View,
              null,
              React.default.createElement(
                ReactNative.Text,
                {
                  style: h,
                },
                T
              )
            )
          ),
          React.default.createElement(
            ReactNative.TouchableNativeFeedback,
            {
              accessible: true,
              disabled: o.disabled,
              ref: 'input',
              background: k,
              onPress: function () {
                var t = new Date(),
                  l = o.value && o.value instanceof Date,
                  u = {
                    hour: l ? o.value.getHours() : t.getHours(),
                    minute: l ? o.value.getMinutes() : t.getMinutes(),
                  };
                ReactNative.TimePickerAndroid.open({
                  is24Hour: true,
                  hour: u.hour,
                  minute: u.minute,
                }).then(function (t) {
                  if (t.action !== ReactNative.TimePickerAndroid.dismissedAction) {
                    var l = new Date(o.value);
                    l.setHours(t.hour);
                    l.setMinutes(t.minute);
                    o.onChange(l);
                  }
                });
                if ('function' == typeof o.onPress) o.onPress();
              },
            },
            React.default.createElement(
              ReactNative.View,
              null,
              React.default.createElement(
                ReactNative.Text,
                {
                  style: h,
                },
                x
              )
            )
          )
        )
      : React.default.createElement(
          ReactNative.TouchableNativeFeedback,
          {
            accessible: true,
            disabled: o.disabled,
            ref: 'input',
            background: k,
            onPress: function () {
              if ('time' === b) {
                var t = new Date(),
                  l = o.value && o.value instanceof Date,
                  u = {
                    hour: l ? o.value.getHours() : t.getHours(),
                    minute: l ? o.value.getMinutes() : t.getMinutes(),
                  };
                ReactNative.TimePickerAndroid.open({
                  is24Hour: true,
                  hour: u.hour,
                  minute: u.minute,
                }).then(function (t) {
                  if (t.action !== ReactNative.TimePickerAndroid.dismissedAction) {
                    var l = new Date();
                    l.setHours(t.hour);
                    l.setMinutes(t.minute);
                    o.onChange(l);
                  }
                });
              } else if ('date' === b) {
                var c = {
                  date: o.value || new Date(),
                  mode: p,
                };
                if (o.minimumDate) c.minDate = o.minimumDate;
                if (o.maximumDate) c.maxDate = o.maximumDate;
                ReactNative.DatePickerAndroid.open(c).then(function (t) {
                  if (t.action !== ReactNative.DatePickerAndroid.dismissedAction) {
                    var l = new Date(t.year, t.month, t.day);
                    o.onChange(l);
                  }
                });
              }

              if ('function' == typeof o.onPress) o.onPress();
            },
          },
          React.default.createElement(ReactNative.View, null, y, w)
        ),
    E,
    P
  );
};
