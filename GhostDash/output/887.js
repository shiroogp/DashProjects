var module27 = require('./27'),
  module40 = require('./40'),
  module37 = require('./37'),
  module42 = require('./42'),
  module38 = require('./38'),
  module50 = require('./50'),
  module760 = require('./760'),
  React = require('react'),
  ReactNative = require('react-native'),
  module888 = require('./888'),
  module798 = require('./798'),
  module885 = require('./885'),
  module788 = require('./788'),
  module889 = require('./889'),
  w = '/Users/trensik/dev/react-native-paper/src/components/List/ListAccordion.tsx',
  E = (function (t, ...args) {
    function n() {
      var t, module28;
      module27.default(this, n);
      module28 = module40.default(this, (t = module37.default(n)).call.apply(t, [this].concat(args)));
      module50.default(module42.default(module28), 'state', {
        expanded: module28.props.expanded || false,
      });
      module50.default(module42.default(module28), 'handlePress', function () {
        if (module28.props.onPress) module28.props.onPress();
        if (undefined === module28.props.expanded)
          module28.setState(function (t) {
            return {
              expanded: !t.expanded,
            };
          });
      });
      return module28;
    }

    module38.default(n, t);
    module28.default(n, [
      {
        key: 'render',
        value: function () {
          var t = this,
            n = this.props,
            l = n.left,
            o = n.title,
            s = n.description,
            c = n.children,
            u = n.theme,
            p = n.titleStyle,
            f = n.descriptionStyle,
            x = n.titleNumberOfLines,
            E = n.descriptionNumberOfLines,
            A = n.style,
            C = n.id,
            O = n.testID,
            S = module760.default(u.colors.text).alpha(0.87).rgb().string(),
            I = module760.default(u.colors.text).alpha(0.54).rgb().string(),
            V = undefined !== this.props.expanded ? this.props.expanded : this.state.expanded;
          return React.createElement(
            module889.ListAccordionGroupContext.Consumer,
            {
              __source: {
                fileName: w,
                lineNumber: 195,
              },
            },
            function (n) {
              if (null !== n && !C) throw new Error('List.Accordion is used inside a List.AccordionGroup without specifying an id prop.');
              var h = n ? n.expandedId === C : V,
                L =
                  n && undefined !== C
                    ? function () {
                        return n.onAccordionPress(C);
                      }
                    : t.handlePress;
              return React.createElement(
                ReactNative.View,
                {
                  __source: {
                    fileName: w,
                    lineNumber: 210,
                  },
                },
                React.createElement(
                  module888.default,
                  {
                    style: [P.container, A],
                    onPress: L,
                    accessibilityTraits: 'button',
                    accessibilityComponentType: 'button',
                    accessibilityRole: 'button',
                    testID: O,
                    __source: {
                      fileName: w,
                      lineNumber: 211,
                    },
                  },
                  React.createElement(
                    ReactNative.View,
                    {
                      style: P.row,
                      pointerEvents: 'none',
                      __source: {
                        fileName: w,
                        lineNumber: 219,
                      },
                    },
                    l
                      ? l({
                          color: h ? u.colors.primary : I,
                        })
                      : null,
                    React.createElement(
                      ReactNative.View,
                      {
                        style: [P.item, P.content],
                        __source: {
                          fileName: w,
                          lineNumber: 227,
                        },
                      },
                      React.createElement(
                        module885.default,
                        {
                          numberOfLines: x,
                          style: [
                            P.title,
                            {
                              color: h ? u.colors.primary : S,
                            },
                            p,
                          ],
                          __source: {
                            fileName: w,
                            lineNumber: 228,
                          },
                        },
                        o
                      ),
                      s &&
                        React.createElement(
                          module885.default,
                          {
                            numberOfLines: E,
                            style: [
                              P.description,
                              {
                                color: I,
                              },
                              f,
                            ],
                            __source: {
                              fileName: w,
                              lineNumber: 241,
                            },
                          },
                          s
                        )
                    ),
                    React.createElement(
                      ReactNative.View,
                      {
                        style: [P.item, s ? P.multiline : undefined],
                        __source: {
                          fileName: w,
                          lineNumber: 255,
                        },
                      },
                      React.createElement(module798.default, {
                        name: h ? 'chevron-up' : 'chevron-down',
                        color: S,
                        size: 24,
                        direction: ReactNative.I18nManager.isRTL ? 'rtl' : 'ltr',
                        __source: {
                          fileName: w,
                          lineNumber: 261,
                        },
                      })
                    )
                  )
                ),
                h
                  ? React.Children.map(c, function (t) {
                      return l && React.isValidElement(t) && !t.props.left && !t.props.right
                        ? React.cloneElement(t, {
                            style: [P.child, t.props.style],
                          })
                        : t;
                    })
                  : null
              );
            }
          );
        },
      },
    ]);
    return n;
  })(React.Component);

module50.default(E, 'displayName', 'List.Accordion');
module50.default(E, 'defaultProps', {
  titleNumberOfLines: 1,
  descriptionNumberOfLines: 2,
});
var P = ReactNative.StyleSheet.create({
    container: {
      padding: 8,
    },
    row: {
      flexDirection: 'row',
      alignItems: 'center',
    },
    multiline: {
      height: 40,
      alignItems: 'center',
      justifyContent: 'center',
    },
    title: {
      fontSize: 16,
    },
    description: {
      fontSize: 14,
    },
    item: {
      margin: 8,
    },
    child: {
      paddingLeft: 64,
    },
    content: {
      flex: 1,
      justifyContent: 'center',
    },
  }),
  A = module788.withTheme(E);
exports.default = A;
