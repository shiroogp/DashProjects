var ReactNative = require('react-native'),
  t = Object.freeze({
    fieldset: {},
    formGroup: {
      normal: {
        marginBottom: 10,
      },
      error: {
        marginBottom: 10,
      },
    },
    controlLabel: {
      normal: {
        color: '#000000',
        fontSize: 17,
        marginBottom: 7,
        fontWeight: '500',
      },
      error: {
        color: '#a94442',
        fontSize: 17,
        marginBottom: 7,
        fontWeight: '500',
      },
    },
    helpBlock: {
      normal: {
        color: '#999999',
        fontSize: 17,
        marginBottom: 2,
      },
      error: {
        color: '#999999',
        fontSize: 17,
        marginBottom: 2,
      },
    },
    errorBlock: {
      fontSize: 17,
      marginBottom: 2,
      color: '#a94442',
    },
    textboxView: {
      normal: {},
      error: {},
      notEditable: {},
    },
    textbox: {
      normal: {
        color: '#000000',
        fontSize: 17,
        height: 36,
        paddingVertical: 'ios' === ReactNative.Platform.OS ? 7 : 0,
        paddingHorizontal: 7,
        borderRadius: 4,
        borderColor: '#cccccc',
        borderWidth: 1,
        marginBottom: 5,
      },
      error: {
        color: '#000000',
        fontSize: 17,
        height: 36,
        paddingVertical: 'ios' === ReactNative.Platform.OS ? 7 : 0,
        paddingHorizontal: 7,
        borderRadius: 4,
        borderColor: '#a94442',
        borderWidth: 1,
        marginBottom: 5,
      },
      notEditable: {
        fontSize: 17,
        height: 36,
        paddingVertical: 'ios' === ReactNative.Platform.OS ? 7 : 0,
        paddingHorizontal: 7,
        borderRadius: 4,
        borderColor: '#cccccc',
        borderWidth: 1,
        marginBottom: 5,
        color: '#777777',
        backgroundColor: '#eeeeee',
      },
    },
    checkbox: {
      normal: {
        marginBottom: 4,
      },
      error: {
        marginBottom: 4,
      },
    },
    pickerContainer: {
      normal: {
        marginBottom: 4,
        borderRadius: 4,
        borderColor: '#cccccc',
        borderWidth: 1,
      },
      error: {
        marginBottom: 4,
        borderRadius: 4,
        borderColor: '#a94442',
        borderWidth: 1,
      },
      open: {},
    },
    select: {
      normal: ReactNative.Platform.select({
        android: {
          paddingLeft: 7,
          color: '#000000',
        },
        ios: {},
      }),
      error: ReactNative.Platform.select({
        android: {
          paddingLeft: 7,
          color: '#a94442',
        },
        ios: {},
      }),
    },
    pickerTouchable: {
      normal: {
        height: 44,
        flexDirection: 'row',
        alignItems: 'center',
      },
      error: {
        height: 44,
        flexDirection: 'row',
        alignItems: 'center',
      },
      active: {
        borderBottomWidth: 1,
        borderColor: '#cccccc',
      },
      notEditable: {
        height: 44,
        flexDirection: 'row',
        alignItems: 'center',
        backgroundColor: '#eeeeee',
      },
    },
    pickerValue: {
      normal: {
        fontSize: 17,
        paddingLeft: 7,
      },
      error: {
        fontSize: 17,
        paddingLeft: 7,
      },
    },
    datepicker: {
      normal: {
        marginBottom: 4,
      },
      error: {
        marginBottom: 4,
      },
    },
    dateTouchable: {
      normal: {},
      error: {},
      notEditable: {
        backgroundColor: '#eeeeee',
      },
    },
    dateValue: {
      normal: {
        color: '#000000',
        fontSize: 17,
        padding: 7,
        marginBottom: 5,
      },
      error: {
        color: '#a94442',
        fontSize: 17,
        padding: 7,
        marginBottom: 5,
      },
    },
    buttonText: {
      fontSize: 18,
      color: 'white',
      alignSelf: 'center',
    },
    button: {
      height: 36,
      backgroundColor: '#48BBEC',
      borderColor: '#48BBEC',
      borderWidth: 1,
      borderRadius: 8,
      marginBottom: 10,
      alignSelf: 'stretch',
      justifyContent: 'center',
    },
  });

module.exports = t;
