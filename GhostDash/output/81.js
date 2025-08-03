var module15 = require('@babel/runtime/helpers/slicedToArray'),
  module6 = require('./6'),
  o = {
    createIdentityMatrix: function () {
      return [1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1];
    },
    createCopy: function (t) {
      return [t[0], t[1], t[2], t[3], t[4], t[5], t[6], t[7], t[8], t[9], t[10], t[11], t[12], t[13], t[14], t[15]];
    },
    createOrthographic: function (t, n, o, u, s, c) {
      return [2 / (n - t), 0, 0, 0, 0, 2 / (u - o), 0, 0, 0, 0, -2 / (c - s), 0, -(n + t) / (n - t), -(u + o) / (u - o), -(c + s) / (c - s), 1];
    },
    createFrustum: function (t, n, o, u, s, c) {
      var v = 1 / (n - t),
        f = 1 / (u - o),
        h = 1 / (s - c);
      return [s * v * 2, 0, 0, 0, 0, s * f * 2, 0, 0, (n + t) * v, (u + o) * f, (c + s) * h, -1, 0, 0, c * s * h * 2, 0];
    },
    createPerspective: function (t, n, o, u) {
      var s = 1 / Math.tan(t / 2),
        c = 1 / (o - u);
      return [s / n, 0, 0, 0, 0, s, 0, 0, 0, 0, (u + o) * c, -1, 0, 0, u * o * c * 2, 0];
    },
    createTranslate2d: function (t, n) {
      var u = o.createIdentityMatrix();
      o.reuseTranslate2dCommand(u, t, n);
      return u;
    },
    reuseTranslate2dCommand: function (t, n, o) {
      t[12] = n;
      t[13] = o;
    },
    reuseTranslate3dCommand: function (t, n, o, u) {
      t[12] = n;
      t[13] = o;
      t[14] = u;
    },
    createScale: function (t) {
      var n = o.createIdentityMatrix();
      o.reuseScaleCommand(n, t);
      return n;
    },
    reuseScaleCommand: function (t, n) {
      t[0] = n;
      t[5] = n;
    },
    reuseScale3dCommand: function (t, n, o, u) {
      t[0] = n;
      t[5] = o;
      t[10] = u;
    },
    reusePerspectiveCommand: function (t, n) {
      t[11] = -1 / n;
    },
    reuseScaleXCommand: function (t, n) {
      t[0] = n;
    },
    reuseScaleYCommand: function (t, n) {
      t[5] = n;
    },
    reuseScaleZCommand: function (t, n) {
      t[10] = n;
    },
    reuseRotateXCommand: function (t, n) {
      t[5] = Math.cos(n);
      t[6] = Math.sin(n);
      t[9] = -Math.sin(n);
      t[10] = Math.cos(n);
    },
    reuseRotateYCommand: function (t, n) {
      t[0] = Math.cos(n);
      t[2] = -Math.sin(n);
      t[8] = Math.sin(n);
      t[10] = Math.cos(n);
    },
    reuseRotateZCommand: function (t, n) {
      t[0] = Math.cos(n);
      t[1] = Math.sin(n);
      t[4] = -Math.sin(n);
      t[5] = Math.cos(n);
    },
    createRotateZ: function (t) {
      var n = o.createIdentityMatrix();
      o.reuseRotateZCommand(n, t);
      return n;
    },
    reuseSkewXCommand: function (t, n) {
      t[4] = Math.tan(n);
    },
    reuseSkewYCommand: function (t, n) {
      t[1] = Math.tan(n);
    },
    multiplyInto: function (t, n, o) {
      var u = n[0],
        s = n[1],
        c = n[2],
        v = n[3],
        f = n[4],
        h = n[5],
        M = n[6],
        l = n[7],
        C = n[8],
        p = n[9],
        x = n[10],
        T = n[11],
        y = n[12],
        S = n[13],
        P = n[14],
        q = n[15],
        D = o[0],
        X = o[1],
        Y = o[2],
        I = o[3];
      t[0] = D * u + X * f + Y * C + I * y;
      t[1] = D * s + X * h + Y * p + I * S;
      t[2] = D * c + X * M + Y * x + I * P;
      t[3] = D * v + X * l + Y * T + I * q;
      D = o[4];
      X = o[5];
      Y = o[6];
      I = o[7];
      t[4] = D * u + X * f + Y * C + I * y;
      t[5] = D * s + X * h + Y * p + I * S;
      t[6] = D * c + X * M + Y * x + I * P;
      t[7] = D * v + X * l + Y * T + I * q;
      D = o[8];
      X = o[9];
      Y = o[10];
      I = o[11];
      t[8] = D * u + X * f + Y * C + I * y;
      t[9] = D * s + X * h + Y * p + I * S;
      t[10] = D * c + X * M + Y * x + I * P;
      t[11] = D * v + X * l + Y * T + I * q;
      D = o[12];
      X = o[13];
      Y = o[14];
      I = o[15];
      t[12] = D * u + X * f + Y * C + I * y;
      t[13] = D * s + X * h + Y * p + I * S;
      t[14] = D * c + X * M + Y * x + I * P;
      t[15] = D * v + X * l + Y * T + I * q;
    },
    determinant: function (n) {
      var o = module15(n, 16),
        u = o[0],
        s = o[1],
        c = o[2],
        v = o[3],
        f = o[4],
        h = o[5],
        M = o[6],
        l = o[7],
        C = o[8],
        p = o[9],
        x = o[10],
        T = o[11],
        y = o[12],
        S = o[13],
        P = o[14],
        q = o[15];
      return (
        v * M * p * y -
        c * l * p * y -
        v * h * x * y +
        s * l * x * y +
        c * h * T * y -
        s * M * T * y -
        v * M * C * S +
        c * l * C * S +
        v * f * x * S -
        u * l * x * S -
        c * f * T * S +
        u * M * T * S +
        v * h * C * P -
        s * l * C * P -
        v * f * p * P +
        u * l * p * P +
        s * f * T * P -
        u * h * T * P -
        c * h * C * q +
        s * M * C * q +
        c * f * p * q -
        u * M * p * q -
        s * f * x * q +
        u * h * x * q
      );
    },
    inverse: function (n) {
      var u = o.determinant(n);
      if (!u) return n;
      var s = module15(n, 16),
        c = s[0],
        v = s[1],
        f = s[2],
        h = s[3],
        M = s[4],
        l = s[5],
        C = s[6],
        p = s[7],
        x = s[8],
        T = s[9],
        y = s[10],
        S = s[11],
        P = s[12],
        q = s[13],
        D = s[14],
        X = s[15];
      return [
        (C * S * q - p * y * q + p * T * D - l * S * D - C * T * X + l * y * X) / u,
        (h * y * q - f * S * q - h * T * D + v * S * D + f * T * X - v * y * X) / u,
        (f * p * q - h * C * q + h * l * D - v * p * D - f * l * X + v * C * X) / u,
        (h * C * T - f * p * T - h * l * y + v * p * y + f * l * S - v * C * S) / u,
        (p * y * P - C * S * P - p * x * D + M * S * D + C * x * X - M * y * X) / u,
        (f * S * P - h * y * P + h * x * D - c * S * D - f * x * X + c * y * X) / u,
        (h * C * P - f * p * P - h * M * D + c * p * D + f * M * X - c * C * X) / u,
        (f * p * x - h * C * x + h * M * y - c * p * y - f * M * S + c * C * S) / u,
        (l * S * P - p * T * P + p * x * q - M * S * q - l * x * X + M * T * X) / u,
        (h * T * P - v * S * P - h * x * q + c * S * q + v * x * X - c * T * X) / u,
        (v * p * P - h * l * P + h * M * q - c * p * q - v * M * X + c * l * X) / u,
        (h * l * x - v * p * x - h * M * T + c * p * T + v * M * S - c * l * S) / u,
        (C * T * P - l * y * P - C * x * q + M * y * q + l * x * D - M * T * D) / u,
        (v * y * P - f * T * P + f * x * q - c * y * q - v * x * D + c * T * D) / u,
        (f * l * P - v * C * P - f * M * q + c * C * q + v * M * D - c * l * D) / u,
        (v * C * x - f * l * x + f * M * T - c * C * T - v * M * y + c * l * y) / u,
      ];
    },
    transpose: function (t) {
      return [t[0], t[4], t[8], t[12], t[1], t[5], t[9], t[13], t[2], t[6], t[10], t[14], t[3], t[7], t[11], t[15]];
    },
    multiplyVectorByMatrix: function (n, o) {
      var u = module15(n, 4),
        s = u[0],
        c = u[1],
        v = u[2],
        f = u[3];
      return [
        s * o[0] + c * o[4] + v * o[8] + f * o[12],
        s * o[1] + c * o[5] + v * o[9] + f * o[13],
        s * o[2] + c * o[6] + v * o[10] + f * o[14],
        s * o[3] + c * o[7] + v * o[11] + f * o[15],
      ];
    },
    v3Length: function (t) {
      return Math.sqrt(t[0] * t[0] + t[1] * t[1] + t[2] * t[2]);
    },
    v3Normalize: function (t, n) {
      var u = 1 / (n || o.v3Length(t));
      return [t[0] * u, t[1] * u, t[2] * u];
    },
    v3Dot: function (t, n) {
      return t[0] * n[0] + t[1] * n[1] + t[2] * n[2];
    },
    v3Combine: function (t, n, o, u) {
      return [o * t[0] + u * n[0], o * t[1] + u * n[1], o * t[2] + u * n[2]];
    },
    v3Cross: function (t, n) {
      return [t[1] * n[2] - t[2] * n[1], t[2] * n[0] - t[0] * n[2], t[0] * n[1] - t[1] * n[0]];
    },
    quaternionToDegreesXYZ: function (n, u, s) {
      var c = module15(n, 4),
        v = c[0],
        f = c[1],
        h = c[2],
        M = c[3],
        l = v * v,
        C = f * f,
        p = h * h,
        x = v * f + h * M,
        T = M * M + l + C + p,
        y = 180 / Math.PI;
      return x > 0.49999 * T
        ? [0, 2 * v ** M * y, 90]
        : x < -0.49999 * T
        ? [0, -2 * v ** M * y, -90]
        : [
            o.roundTo3Places((2 * v * M - 2 * f * h) ** (1 - 2 * l - 2 * p) * y),
            o.roundTo3Places((2 * f * M - 2 * v * h) ** (1 - 2 * C - 2 * p) * y),
            o.roundTo3Places(Math.asin(2 * v * f + 2 * h * M) * y),
          ];
    },
    roundTo3Places: function (t) {
      var n = t.toString().split('e');
      return 0.001 * Math.round(n[0] + 'e' + (n[1] ? +n[1] - 3 : 3));
    },
    decomposeMatrix: function (t) {
      module6(16 === t.length, 'Matrix decomposition needs a list of 3d matrix values, received %s', t);
      var u = [],
        s = [],
        c = [],
        v = [],
        f = [];

      if (t[15]) {
        for (var h = [], M = [], l = 0; l < 4; l++) {
          h.push([]);

          for (var C = 0; C < 4; C++) {
            var p = t[4 * l + C] / t[15];
            h[l].push(p);
            M.push(3 === C ? 0 : p);
          }
        }

        if (((M[15] = 1), o.determinant(M))) {
          if (0 !== h[0][3] || 0 !== h[1][3] || 0 !== h[2][3]) {
            var x = [h[0][3], h[1][3], h[2][3], h[3][3]],
              T = o.inverse(M),
              y = o.transpose(T);
            u = o.multiplyVectorByMatrix(x, y);
          } else {
            u[0] = u[1] = u[2] = 0;
            u[3] = 1;
          }

          for (var S = 0; S < 3; S++) f[S] = h[3][S];

          for (var P = [], q = 0; q < 3; q++) P[q] = [h[q][0], h[q][1], h[q][2]];

          c[0] = o.v3Length(P[0]);
          P[0] = o.v3Normalize(P[0], c[0]);
          v[0] = o.v3Dot(P[0], P[1]);
          P[1] = o.v3Combine(P[1], P[0], 1, -v[0]);
          c[1] = o.v3Length(P[1]);
          P[1] = o.v3Normalize(P[1], c[1]);
          v[0] /= c[1];
          v[1] = o.v3Dot(P[0], P[2]);
          P[2] = o.v3Combine(P[2], P[0], 1, -v[1]);
          v[2] = o.v3Dot(P[1], P[2]);
          P[2] = o.v3Combine(P[2], P[1], 1, -v[2]);
          c[2] = o.v3Length(P[2]);
          P[2] = o.v3Normalize(P[2], c[2]);
          v[1] /= c[2];
          v[2] /= c[2];
          var D,
            X = o.v3Cross(P[1], P[2]);
          if (o.v3Dot(P[0], X) < 0)
            for (var Y = 0; Y < 3; Y++) {
              c[Y] *= -1;
              P[Y][0] *= -1;
              P[Y][1] *= -1;
              P[Y][2] *= -1;
            }
          s[0] = 0.5 * Math.sqrt((1 + P[0][0] - P[1][1] - P[2][2]) ** 0);
          s[1] = 0.5 * Math.sqrt((1 - P[0][0] + P[1][1] - P[2][2]) ** 0);
          s[2] = 0.5 * Math.sqrt((1 - P[0][0] - P[1][1] + P[2][2]) ** 0);
          s[3] = 0.5 * Math.sqrt((1 + P[0][0] + P[1][1] + P[2][2]) ** 0);
          if (P[2][1] > P[1][2]) s[0] = -s[0];
          if (P[0][2] > P[2][0]) s[1] = -s[1];
          if (P[1][0] > P[0][1]) s[2] = -s[2];
          return {
            rotationDegrees: (D =
              s[0] < 0.001 && s[0] >= 0 && s[1] < 0.001 && s[1] >= 0 ? [0, 0, o.roundTo3Places((180 * P[0][1] ** P[0][0]) / Math.PI)] : o.quaternionToDegreesXYZ(s, h, P)),
            perspective: u,
            quaternion: s,
            scale: c,
            skew: v,
            translation: f,
            rotate: D[2],
            rotateX: D[0],
            rotateY: D[1],
            scaleX: c[0],
            scaleY: c[1],
            translateX: f[0],
            translateY: f[1],
          };
        }
      }
    },
  };

module.exports = o;
