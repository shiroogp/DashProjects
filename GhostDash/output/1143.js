var ReactNative = require('react-native');

exports.checkUIRestart = function (n) {
  return ReactNative.Alert.alert(
    'Reiniciar a dash?',
    'Para que as altera\xe7\xf5es sejam aplicadas, sua dash ser\xe1 reiniciada.\nDeseja continuar?',
    [
      {
        text: 'Cancelar',
        style: 'cancel',
      },
      {
        text: 'Continuar',
        onPress: function () {
          return n();
        },
      },
    ],
    {
      cancelable: true,
    }
  );
};

exports.confirmDemoToggle = function (n) {
  return ReactNative.Alert.alert(
    'Ativar/Desativar',
    'Se o modo demonstra\xe7\xe3o estiver ativo, ele ser\xe1 desativado e vice-versa.\nDeseja continuar?',
    [
      {
        text: 'Cancelar',
        style: 'cancel',
      },
      {
        text: 'Continuar',
        onPress: function () {
          return n();
        },
      },
    ],
    {
      cancelable: true,
    }
  );
};

exports.confirmResetMedia = function (n) {
  return ReactNative.Alert.alert(
    'Restaurar/Desativar',
    'A configurac\xe3o ser\xe1 restaurada para o padr\xe3o de f\xe1brica.\nDeseja continuar?',
    [
      {
        text: 'Cancelar',
        style: 'cancel',
      },
      {
        text: 'Continuar',
        onPress: function () {
          return n();
        },
      },
    ],
    {
      cancelable: true,
    }
  );
};
