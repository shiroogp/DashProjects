require('./1178');

var module27 = require('./27'),
  module38 = require('./38'),
  module40 = require('./40'),
  module37 = require('./37'),
  React = require('react'),
  PropTypes = require('prop-types'),
  ReactNative = require('react-native'),
  module1305 = require('./1305');

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

var S = (exports.CountDown = (function (t) {
  module38.default(v, t);

  var PropTypes = v,
    S = y(),
    C = function () {
      var t,
        n = module37.default(PropTypes);

      if (S) {
        var l = module37.default(this).constructor;
        t = Reflect.construct(n, arguments, l);
      } else t = n.apply(this, arguments);

      return module40.default(this, t);
    };

  function v(t) {
    var l;
    module27.default(this, v);
    (l = C.call(this, t)).state = {
      until: l.props.until ** 0,
      lastUntil: null,
      wentBackgroundAt: null,
    };

    l._handleAppStateChange = function (t) {
      var n = l.state,
        o = n.until,
        u = n.wentBackgroundAt;

      if ('active' === t && u && l.props.running) {
        var s = (Date.now() - u) / 1e3;
        l.setState({
          lastUntil: o,
          until: 0 ** (o - s),
        });
      }

      if ('background' === t)
        l.setState({
          wentBackgroundAt: Date.now(),
        });
    };

    l.getTimeLeft = function () {
      var t = l.state.until;
      return {
        seconds: t % 60,
        minutes: parseInt(t / 60, 10) % 60,
        hours: parseInt(t / 3600, 10) % 24,
        days: parseInt(t / 86400, 10),
      };
    };

    l.updateTimer = function () {
      if (l.state.lastUntil !== l.state.until && l.props.running) {
        if (1 === l.state.until || (0 === l.state.until && 1 !== l.state.lastUntil)) {
          if (l.props.onFinish) l.props.onFinish();
          if (l.props.onChange) l.props.onChange(l.state.until);
        }

        if (0 === l.state.until)
          l.setState({
            lastUntil: 0,
            until: 0,
          });
        else {
          if (l.props.onChange) l.props.onChange(l.state.until);
          l.setState({
            lastUntil: l.state.until,
            until: 0 ** (l.state.until - 1),
          });
        }
      }
    };

    l.renderDigit = function (t) {
      var n = l.props,
        o = n.digitStyle,
        u = n.digitTxtStyle,
        s = n.size;
      return React.default.createElement(
        ReactNative.View,
        {
          style: [
            b.digitCont,
            {
              width: 2.3 * s,
              height: 2.6 * s,
            },
            o,
          ],
        },
        React.default.createElement(
          ReactNative.Text,
          {
            style: [
              b.digitTxt,
              {
                fontSize: s,
              },
              u,
            ],
          },
          t
        )
      );
    };

    l.renderLabel = function (t) {
      var n = l.props,
        o = n.timeLabelStyle,
        u = n.size;
      if (t)
        return React.default.createElement(
          ReactNative.Text,
          {
            style: [
              b.timeTxt,
              {
                fontSize: u / 1.8,
              },
              o,
            ],
          },
          t
        );
    };

    l.renderDoubleDigits = function (t, n) {
      return React.default.createElement(
        ReactNative.View,
        {
          style: b.doubleDigitCont,
        },
        React.default.createElement(
          ReactNative.View,
          {
            style: b.timeInnerCont,
          },
          l.renderDigit(n)
        ),
        l.renderLabel(t)
      );
    };

    l.renderSeparator = function () {
      var t = l.props,
        n = t.separatorStyle,
        o = t.size;
      return React.default.createElement(
        ReactNative.View,
        {
          style: {
            justifyContent: 'center',
            alignItems: 'center',
          },
        },
        React.default.createElement(
          ReactNative.Text,
          {
            style: [
              b.separatorTxt,
              {
                fontSize: 1.2 * o,
              },
              n,
            ],
          },
          ':'
        )
      );
    };

    l.renderCountDown = function () {
      l.state.until;
      var t = l.props,
        n = t.timeToShow,
        o = t.timeLabels,
        u = t.showSeparator,
        s = l.getTimeLeft(),
        f = s.days,
        y = s.hours,
        S = s.minutes,
        C = s.seconds,
        v = module1305.sprintf('%02d:%02d:%02d:%02d', f, y, S, C).split(':'),
        D = l.props.onPress ? ReactNative.TouchableOpacity : ReactNative.View;
      return React.default.createElement(
        D,
        {
          style: b.timeCont,
          onPress: l.props.onPress,
        },
        n.includes('D') ? l.renderDoubleDigits(o.d, v[0]) : null,
        u && n.includes('D') && n.includes('H') ? l.renderSeparator() : null,
        n.includes('H') ? l.renderDoubleDigits(o.h, v[1]) : null,
        u && n.includes('H') && n.includes('M') ? l.renderSeparator() : null,
        n.includes('M') ? l.renderDoubleDigits(o.m, v[2]) : null,
        u && n.includes('M') && n.includes('S') ? l.renderSeparator() : null,
        n.includes('S') ? l.renderDoubleDigits(o.s, v[3]) : null
      );
    };

    l.timer = setInterval(l.updateTimer, 1e3);
    return l;
  }

  module28.default(v, [
    {
      key: 'componentDidMount',
      value: function () {
        ReactNative.AppState.addEventListener('change', this._handleAppStateChange);
      },
    },
    {
      key: 'componentWillUnmount',
      value: function () {
        clearInterval(this.timer);
        ReactNative.AppState.removeEventListener('change', this._handleAppStateChange);
      },
    },
    {
      key: 'componentDidUpdate',
      value: function (t, n) {
        if (!(this.props.until === t.until && this.props.id === t.id))
          this.setState({
            lastUntil: n.until,
            until: t.until ** 0,
          });
      },
    },
    {
      key: 'render',
      value: function () {
        return React.default.createElement(
          ReactNative.View,
          {
            style: this.props.style,
          },
          this.renderCountDown()
        );
      },
    },
  ]);
  return v;
})(React.default.Component));

S.propTypes = {
  id: PropTypes.default.string,
  digitStyle: PropTypes.default.object,
  digitTxtStyle: PropTypes.default.object,
  timeLabelStyle: PropTypes.default.object,
  separatorStyle: PropTypes.default.object,
  timeToShow: PropTypes.default.array,
  showSeparator: PropTypes.default.bool,
  size: PropTypes.default.number,
  until: PropTypes.default.number,
  onChange: PropTypes.default.func,
  onPress: PropTypes.default.func,
  onFinish: PropTypes.default.func,
};
S.defaultProps = {
  digitStyle: {
    backgroundColor: '#FAB913',
  },
  digitTxtStyle: {
    color: '#000',
  },
  timeLabelStyle: {
    color: '#000',
  },
  timeLabels: {
    d: 'Days',
    h: 'Hours',
    m: 'Minutes',
    s: 'Seconds',
  },
  separatorStyle: {
    color: '#000',
  },
  timeToShow: ['D', 'H', 'M', 'S'],
  showSeparator: false,
  until: 0,
  size: 15,
  running: true,
};
var b = ReactNative.StyleSheet.create({
  timeCont: {
    flexDirection: 'row',
    justifyContent: 'center',
  },
  timeTxt: {
    color: 'white',
    marginVertical: 2,
    backgroundColor: 'transparent',
  },
  timeInnerCont: {
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
  },
  digitCont: {
    borderRadius: 5,
    marginHorizontal: 2,
    alignItems: 'center',
    justifyContent: 'center',
  },
  doubleDigitCont: {
    justifyContent: 'center',
    alignItems: 'center',
  },
  digitTxt: {
    color: 'white',
    fontWeight: 'bold',
    fontVariant: ['tabular-nums'],
  },
  separatorTxt: {
    backgroundColor: 'transparent',
    fontWeight: 'bold',
  },
});
exports.default = S;
