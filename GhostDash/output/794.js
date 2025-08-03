var module760 = require('./760'),
  module787 = require('./787'),
  module795 = require('./795'),
  o = {
    dark: false,
    roundness: 4,
    colors: {
      primary: '#6200ee',
      accent: '#03dac4',
      background: '#f6f6f6',
      surface: module787.white,
      error: '#B00020',
      text: module787.black,
      onBackground: '#000000',
      onSurface: '#000000',
      disabled: module760.default(module787.black).alpha(0.26).rgb().string(),
      placeholder: module760.default(module787.black).alpha(0.54).rgb().string(),
      backdrop: module760.default(module787.black).alpha(0.5).rgb().string(),
      notification: module787.pinkA400,
    },
    fonts: module795.default(),
    animation: {
      scale: 1,
    },
  };

exports.default = o;
