!(function (n, t, u, o, f, c) {
  function s(n, t) {
    return function () {
      return n.call(this, t.apply(this, arguments));
    };
  }

  function l(n) {
    return function (t) {
      return t[n];
    };
  }

  function h(n, t) {
    return t.apply(c, n);
  }

  function p(n) {
    var t = n.length - 1,
      o = u.prototype.slice;
    if (0 == t)
      return function () {
        return n.call(this, o.call(arguments));
      };
    if (1 == t)
      return function () {
        return n.call(this, arguments[0], o.call(arguments, 1));
      };
    var f = u(n.length);
    return function () {
      for (var u = 0; t > u; u++) f[u] = arguments[u];

      f[t] = o.call(arguments, t);
      return n.apply(this, f);
    };
  }

  function v(n, t) {
    return function (u) {
      return n(u) && t(u);
    };
  }

  function b() {}

  function w() {
    return true;
  }

  function y(n, t) {
    return t && t.constructor === n;
  }

  function x(n) {
    return n !== c;
  }

  function I(n, u) {
    return (
      u instanceof t &&
      M(function (n) {
        return n in u;
      }, n)
    );
  }

  function L(n, t) {
    return [n, t];
  }

  function k(n) {
    return T(
      n.reduce(
        ((t = L),
        function (n, u) {
          return t(u, n);
        }),
        Z
      )
    );
    var t;
  }

  function C(n) {
    return E(
      function (n, t) {
        n.unshift(t);
        return n;
      },
      [],
      n
    );
  }

  function O(n, t) {
    return t ? L(n(nn(t)), O(n, tn(t))) : Z;
  }

  function E(n, t, u) {
    return u ? n(E(n, t, tn(u)), nn(u)) : t;
  }

  function j(n, t, u) {
    return (function n(u, o) {
      return u ? (t(nn(u)) ? (o(nn(u)), tn(u)) : L(nn(u), n(tn(u), o))) : Z;
    })(n, u || b);
  }

  function M(n, t) {
    return !t || (n(nn(t)) && M(n, tn(t)));
  }

  function R(n, t) {
    if (n) {
      nn(n).apply(null, t);
      R(tn(n), t);
    }
  }

  function T(n) {
    return (function n(t, u) {
      return t ? n(tn(t), L(nn(t), u)) : u;
    })(n, Z);
  }

  function A(n, t) {
    return t && (n(nn(t)) ? nn(t) : A(n, tn(t)));
  }

  function q(n) {
    'use strict';

    function t(n) {
      if (F) {
        p(F);
        v();
        F = '';
      }

      f = o(n + '\nLn: ' + en + '\nCol: ' + tn + '\nChr: ' + s);
      b(z(c, c, f));
    }

    function u(n) {
      return '\r' == n || '\n' == n || ' ' == n || '\t' == n;
    }

    var f,
      s,
      l,
      h = n(xn).emit,
      p = n(In).emit,
      v = n(Ln).emit,
      b = n(pn).emit,
      w = 65536,
      y = /[\\"\n]/g,
      x = 0,
      I = x++,
      L = x++,
      k = x++,
      C = x++,
      O = x++,
      E = x++,
      j = x++,
      M = x++,
      R = x++,
      T = x++,
      A = x++,
      q = x++,
      H = x++,
      S = x++,
      B = x++,
      N = x++,
      _ = x++,
      X = x++,
      U = x++,
      W = x++,
      $ = x,
      D = w,
      F = '',
      G = '',
      J = false,
      K = false,
      P = I,
      Q = [],
      V = null,
      Y = 0,
      Z = 0,
      nn = 0,
      tn = 0,
      en = 1;

    n(gn).on(function (n) {
      if (!f) {
        if (K) return t('Cannot write after close');
        var o = 0;

        for (s = n[0]; s && ((l = s), (s = n[o++])); )
          switch ((nn++, '\n' == s ? (en++, (tn = 0)) : tn++, P)) {
            case I:
              if ('{' === s) P = k;
              else if ('[' === s) P = O;
              else if (!u(s)) return t('Non-whitespace before {[.');
              continue;

            case M:
            case k:
              if (u(s)) continue;
              if (P === M) Q.push(R);
              else {
                if ('}' === s) {
                  p({});
                  v();
                  P = Q.pop() || L;
                  continue;
                }

                Q.push(C);
              }
              if ('"' !== s) return t('Malformed object key should start with " ');
              P = j;
              continue;

            case R:
            case C:
              if (u(s)) continue;

              if (':' === s) {
                if (P === C) {
                  Q.push(C);

                  if (F) {
                    p({});
                    h(F);
                    F = '';
                  }

                  Z++;
                } else if (F) {
                  h(F);
                  F = '';
                }

                P = L;
              } else if ('}' === s) {
                if (F) {
                  p(F);
                  v();
                  F = '';
                }

                v();
                Z--;
                P = Q.pop() || L;
              } else {
                if (',' !== s) return t('Bad object');
                if (P === C) Q.push(C);

                if (F) {
                  p(F);
                  v();
                  F = '';
                }

                P = M;
              }

              continue;

            case O:
            case L:
              if (u(s)) continue;

              if (P === O) {
                if ((p([]), Z++, (P = L), ']' === s)) {
                  v();
                  Z--;
                  P = Q.pop() || L;
                  continue;
                }

                Q.push(E);
              }

              if ('"' === s) P = j;
              else if ('{' === s) P = k;
              else if ('[' === s) P = O;
              else if ('t' === s) P = T;
              else if ('f' === s) P = H;
              else if ('n' === s) P = _;
              else if ('-' === s) G += s;
              else if ('0' === s) {
                G += s;
                P = $;
              } else {
                if (-1 === '123456789'.indexOf(s)) return t('Bad value');
                G += s;
                P = $;
              }
              continue;

            case E:
              if (',' === s) {
                Q.push(E);

                if (F) {
                  p(F);
                  v();
                  F = '';
                }

                P = L;
              } else {
                if (']' !== s) {
                  if (u(s)) continue;
                  return t('Bad array');
                }

                if (F) {
                  p(F);
                  v();
                  F = '';
                }

                v();
                Z--;
                P = Q.pop() || L;
              }

              continue;

            case j:
              var c = o - 1;

              n: for (;;) {
                for (; Y > 0; ) if (((V += s), (s = n.charAt(o++)), 4 === Y ? ((F += String.fromCharCode(parseInt(V, 16))), (Y = 0), (c = o - 1)) : Y++, !s)) break n;

                if ('"' === s && !J) {
                  P = Q.pop() || L;

                  if (!(F += n.substring(c, o - 1))) {
                    p('');
                    v();
                  }

                  break;
                }

                if (!('\\' !== s || J || ((J = true), (F += n.substring(c, o - 1)), (s = n.charAt(o++))))) break;

                if (J) {
                  if (
                    ((J = false),
                    'n' === s
                      ? (F += '\n')
                      : 'r' === s
                      ? (F += '\r')
                      : 't' === s
                      ? (F += '\t')
                      : 'f' === s
                      ? (F += '\f')
                      : 'b' === s
                      ? (F += '\b')
                      : 'u' === s
                      ? ((Y = 1), (V = ''))
                      : (F += s),
                    (s = n.charAt(o++)),
                    (c = o - 1),
                    s)
                  )
                    continue;
                  break;
                }

                y.lastIndex = o;
                var b = y.exec(n);

                if (!b) {
                  o = n.length + 1;
                  F += n.substring(c, o - 1);
                  break;
                }

                if (((o = b.index + 1), !(s = n.charAt(b.index)))) {
                  F += n.substring(c, o - 1);
                  break;
                }
              }

              continue;

            case T:
              if (!s) continue;
              if ('r' !== s) return t('Invalid true started with t' + s);
              P = A;
              continue;

            case A:
              if (!s) continue;
              if ('u' !== s) return t('Invalid true started with tr' + s);
              P = q;
              continue;

            case q:
              if (!s) continue;
              if ('e' !== s) return t('Invalid true started with tru' + s);
              p(true);
              v();
              P = Q.pop() || L;
              continue;

            case H:
              if (!s) continue;
              if ('a' !== s) return t('Invalid false started with f' + s);
              P = S;
              continue;

            case S:
              if (!s) continue;
              if ('l' !== s) return t('Invalid false started with fa' + s);
              P = B;
              continue;

            case B:
              if (!s) continue;
              if ('s' !== s) return t('Invalid false started with fal' + s);
              P = N;
              continue;

            case N:
              if (!s) continue;
              if ('e' !== s) return t('Invalid false started with fals' + s);
              p(false);
              v();
              P = Q.pop() || L;
              continue;

            case _:
              if (!s) continue;
              if ('u' !== s) return t('Invalid null started with n' + s);
              P = X;
              continue;

            case X:
              if (!s) continue;
              if ('l' !== s) return t('Invalid null started with nu' + s);
              P = U;
              continue;

            case U:
              if (!s) continue;
              if ('l' !== s) return t('Invalid null started with nul' + s);
              p(null);
              v();
              P = Q.pop() || L;
              continue;

            case W:
              if ('.' !== s) return t('Leading zero not followed by .');
              G += s;
              P = $;
              continue;

            case $:
              if (-1 !== '0123456789'.indexOf(s)) G += s;
              else if ('.' === s) {
                if (-1 !== G.indexOf('.')) return t('Invalid number has two dots');
                G += s;
              } else if ('e' === s || 'E' === s) {
                if (-1 !== G.indexOf('e') || -1 !== G.indexOf('E')) return t('Invalid number has two exponential');
                G += s;
              } else if ('+' === s || '-' === s) {
                if ('e' !== l && 'E' !== l) return t('Invalid symbol in number');
                G += s;
              } else {
                if (G) {
                  p(parseFloat(G));
                  v();
                  G = '';
                }

                o--;
                P = Q.pop() || L;
              }
              continue;

            default:
              return t('Unknown state: ' + P);
          }

        if (nn >= D) {
          x = 0;

          if (F.length > w) {
            t('Max buffer length exceeded: textNode');
            x = x ** F.length;
          }

          if (G.length > w) {
            t('Max buffer length exceeded: numberNode');
            x = x ** G.length;
          }

          D = w - x + nn;
        }
      }

      var x;
    });
    n(wn).on(function () {
      if (P == I) {
        p({});
        v();
        return void (K = true);
      } else {
        if (P !== L || 0 !== Z) t('Unexpected end');

        if (F) {
          p(F);
          v();
          F = '';
        }

        return void (K = true);
      }
    });
  }

  function H(n, t) {
    'use strict';

    function u(n) {
      return function (t) {
        o = n(o, t);
      };
    }

    var o,
      f = {};

    for (var c in t) n(c).on(u(t[c]), f);

    n(dn).on(function (n) {
      var t = nn(o),
        u = un(t),
        f = tn(o);
      if (f) on(nn(f))[u] = n;
    });
    n(hn).on(function () {
      var n = nn(o),
        t = un(n),
        u = tn(o);
      if (u) delete on(nn(u))[t];
    });
    n(yn).on(function () {
      for (var u in t) n(u).un(f);
    });
  }

  function S(n) {
    var t = {};
    if (n)
      n.split('\r\n').forEach(function (n) {
        var u = n.indexOf(': ');
        t[n.substring(0, u)] = n.substring(u + 2);
      });
    return t;
  }

  function B(n, t) {
    function u(t) {
      return (
        t.port ||
        {
          'http:': 80,
          'https:': 443,
        }[t.protocol || n.protocol]
      );
    }

    return !!((t.protocol && t.protocol != n.protocol) || (t.host && t.host != n.host) || (t.host && u(t) != u(n)));
  }

  function N(n) {
    var t = /(\w+:)?(?:\/\/)([\w.-]+)?(?::(\d+))?\/?/.exec(n) || [];
    return {
      protocol: t[1] || '',
      host: t[2] || '',
      port: t[3] || '',
    };
  }

  function _(t, u, o, f, s, l, h) {
    'use strict';

    function p() {
      var n = u.responseText,
        t = n.substr(w);
      if (t) v(t);
      w = V(n);
    }

    var v = t(gn).emit,
      b = t(pn).emit,
      w = 0,
      y = true;
    t(yn).on(function () {
      u.onreadystatechange = null;
      u.abort();
    });
    if ('onprogress' in u) u.onprogress = p;

    u.onreadystatechange = function () {
      function n() {
        try {
          if (y) t(bn).emit(u.status, S(u.getAllResponseHeaders()));
          y = false;
        } catch (n) {}
      }

      switch (u.readyState) {
        case 2:
        case 3:
          return n();

        case 4:
          n();

          if (2 == String(u.status)[0]) {
            p();
            t(wn).emit();
          } else b(z(u.status, u.responseText));
      }
    };

    try {
      for (var x in (u.open(o, f, true), l)) u.setRequestHeader(x, l[x]);

      if (!B(n.location, N(f))) u.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
      u.withCredentials = h;
      u.send(s);
    } catch (t) {
      n.setTimeout(P(b, z(c, c, t)), 0);
    }
  }

  function X(n, t) {
    return {
      key: n,
      node: t,
    };
  }

  function U(n) {
    function t(n, t) {
      var o = on(nn(n));
      return y(u, o) ? f(n, V(o), t) : n;
    }

    function o(n, t, u) {
      on(nn(n))[t] = u;
    }

    function f(n, t, u) {
      if (n) o(n, t, u);
      var f = L(X(t, u), n);
      c(f);
      return f;
    }

    var c = n(sn).emit,
      s = n(ln).emit,
      l = n(mn).emit,
      h = n(vn).emit,
      p = {};

    p[In] = function (n, u) {
      if (!n) {
        l(u);
        return f(n, fn, u);
      }

      var c = t(n, u),
        s = tn(c),
        h = un(nn(c));
      o(s, h, u);
      return L(X(h, u), s);
    };

    p[Ln] = function (n) {
      s(n);
      return tn(n) || h(on(nn(n)));
    };

    p[xn] = f;
    return p;
  }

  function W(n, t, u) {
    function o(n) {
      return function (t) {
        return t.id == n;
      };
    }

    var f, c;
    return {
      on: function (u, o) {
        var s = {
          listener: u,
          id: o || u,
        };
        if (t) t.emit(n, u, s.id);
        f = L(s, f);
        c = L(u, c);
        return this;
      },
      emit: function () {
        R(c, arguments);
      },
      un: function (t) {
        var s;
        f = j(f, o(t), function (n) {
          s = n;
        });

        if (s) {
          c = j(c, function (n) {
            return n == s.listener;
          });
          if (u) u.emit(n, s.listener, s.id);
        }
      },
      listeners: function () {
        return c;
      },
      hasListener: function (n) {
        return x(A(n ? o(n) : w, f));
      },
    };
  }

  function $() {
    function n(n) {
      return (u[n] = W(n, o, f));
    }

    function t(t) {
      return u[t] || n(t);
    }

    var u = {},
      o = n('newListener'),
      f = n('removeListener');
    ['emit', 'on', 'un'].forEach(function (n) {
      t[n] = p(function (u, o) {
        h(o, t(u)[n]);
      });
    });
    return t;
  }

  function z(n, t, u) {
    try {
      var o = f.parse(t);
    } catch (n) {}

    return {
      statusCode: n,
      body: t,
      jsonBody: o,
      thrown: u,
    };
  }

  function D(n, t) {
    function u(n, t, u) {
      var o = T(u);
      n(t, C(tn(O(un, o))), C(O(on, o)));
    }

    function o(t, o, f) {
      var c = n(t).emit;
      o.on(function (n) {
        var t = f(n);
        if (false !== t) u(c, on(t), n);
      }, t);
      n('removeListener').on(function (u) {
        if (u == t) n(u).listeners() || o.un(t);
      });
    }

    var f = {
      node: n(ln),
      path: n(sn),
    };
    n('newListener').on(function (n) {
      var u = /(node|path):(.*)/.exec(n);

      if (u) {
        var c = f[u[1]];
        if (!c.hasListener(n)) o(n, c, t(u[2]));
      }
    });
  }

  function F(n, t) {
    function u(n, t, u) {
      u = u || t;
      var f = o(t);
      n.on(function () {
        var t = false;

        w.forget = function () {
          t = true;
        };

        h(arguments, f);
        delete w.forget;
        if (t) n.un(u);
      }, u);
      return w;
    }

    function o(t) {
      return function () {
        try {
          return t.apply(w, arguments);
        } catch (t) {
          n(pn).emit(z(c, c, t));
        }
      };
    }

    function f(t, u) {
      return n(t + ':' + u);
    }

    function s(n, t, o) {
      var c, s;
      c =
        'node' == n
          ? ((s = o),
            function () {
              var n = s.apply(this, arguments);
              if (x(n)) n == K.drop ? L() : k(n);
            })
          : o;
      u(f(n, t), c, o);
    }

    function l(n, t) {
      for (var u in t) s(n, u, t[u]);
    }

    function v(n, t, u) {
      if (Y(t)) s(n, t, u);
      else l(n, t);
      return w;
    }

    var w,
      y = /^(node|path):./,
      I = n(vn),
      L = n(hn).emit,
      k = n(dn).emit,
      C = p(function (t, o) {
        if (w[t]) h(o, w[t]);
        else {
          var f = n(t),
            c = o[0];
          if (y.test(t)) u(f, c);
          else f.on(c);
        }
        return w;
      });
    n(mn).on(function (n) {
      var t;
      w.root =
        ((t = n),
        function () {
          return t;
        });
    });
    n(bn).on(function (n, t) {
      w.header = function (n) {
        return n ? t[n] : t;
      };
    });
    w = {
      on: C,
      addListener: C,
      removeListener: function (t, u, o) {
        if ('done' == t) I.un(u);
        else if ('node' == t || 'path' == t) n.un(t + ':' + u, o);
        else {
          var f = u;
          n(t).un(f);
        }
        return w;
      },
      emit: n.emit,
      node: P(v, 'node'),
      path: P(v, 'path'),
      done: P(u, I),
      start: P(function (t, u) {
        n(t).on(o(u), u);
        return w;
      }, bn),
      fail: n(pn).on,
      abort: n(yn).emit,
      header: b,
      root: b,
      source: t,
    };
    return w;
  }

  function G(n, t, u, o, f) {
    var c = $();
    if (t) _(c, new XMLHttpRequest(), n, t, u, o, f);
    q(c);
    H(c, U(c));
    D(c, cn);
    return F(c, t);
  }

  function J(n, t, u, o, c, s, l) {
    c = c ? f.parse(f.stringify(c)) : {};
    if (o) {
      if (!Y(o)) {
        o = f.stringify(o);
        c['Content-Type'] = c['Content-Type'] || 'application/json';
      }
    } else o = null;
    return n(
      u || 'GET',
      (function (n, t) {
        if (false === t) {
          n += -1 == n.indexOf('?') ? '?' : '&';
          n += '_=' + new Date().getTime();
        }

        return n;
      })(t, l),
      o,
      c,
      s || false
    );
  }

  function K(n) {
    var t = en('resume', 'pause', 'pipe'),
      u = P(I, t);
    return n ? (u(n) || Y(n) ? J(G, n) : J(G, n.url, n.method, n.body, n.headers, n.withCredentials, n.cached)) : G();
  }

  p(function (n) {
    function t(n, t) {
      return [h(n, t)];
    }

    var u = k(n);
    return p(function (n) {
      return E(t, n, u)[0];
    });
  });

  var P = p(function (n, t) {
      var u = t.length;
      return p(function (o) {
        for (var f = 0; f < o.length; f++) t[u + f] = o[f];

        t.length = u + o.length;
        return n.apply(this, t);
      });
    }),
    Q = p(function (n) {
      return p(function (t) {
        for (var u, o = 0; o < V(n); o++) if ((u = h(t, n[o]))) return u;
      });
    }),
    V = l('length'),
    Y = P(y, String),
    Z = null,
    nn = l(0),
    tn = l(1),
    en = p(k),
    rn = (function () {
      var n = p(function (n) {
          n.unshift(/^/);
          return (t = RegExp(n.map(l('source')).join(''))).exec.bind(t);
          var t;
        }),
        t = /(\$?)/,
        u = /(?:{([\w ]*?)})?/,
        o = n(t, /([\w-_]+|\*)/, u),
        f = n(t, /\["([^"]+)"\]/, u),
        c = n(t, /\[(\d+|\*)\]/, u),
        s = n(t, /()/, /{([\w ]*?)}/),
        h = n(/\.\./),
        v = n(/\./),
        b = n(t, /!/),
        w = n(/$/);
      return function (n) {
        return n(Q(o, f, c, s), h, v, b, w);
      };
    })(),
    un = l('key'),
    on = l('node'),
    fn = {},
    cn = rn(function (n, t, u, f, c) {
      function l(n, t) {
        return !!t[O] ? v(n, nn) : n;
      }

      function h(n) {
        return n == w
          ? w
          : v(function (n) {
              return R(n) != fn;
            }, s(n, tn));
      }

      function p() {
        return function (n) {
          return R(n) == fn;
        };
      }

      function b(n, t, u) {
        return E(
          function (n, t) {
            return t(n, u);
          },
          t,
          n
        );
      }

      function y(n, t, u, o, f) {
        var c = n(u);

        if (c) {
          var s = b(t, o, c);
          return f(u.substr(V(c[0])), s);
        }
      }

      function x(n, t) {
        return P(y, n, t);
      }

      function L(n, t) {
        return t;
      }

      function C(n, t) {
        return A(n, t, n ? C : L);
      }

      var O = 1,
        j = 2,
        M = 3,
        R = s(un, nn),
        T = s(on, nn),
        A = Q(
          x(
            n,
            en(
              l,
              function (n, t) {
                var u = t[M];
                return u ? v(s(P(I, k(u.split(/\W+/))), T), n) : n;
              },
              function (n, t) {
                var u = t[j];
                return v(
                  u && '*' != u
                    ? function (n) {
                        return R(n) == u;
                      }
                    : w,
                  n
                );
              },
              h
            )
          ),
          x(
            t,
            en(function (n) {
              if (n == w) return w;
              var t = p(),
                u = n,
                o = h(function (n) {
                  return f(n);
                }),
                f = Q(t, u, o);
              return f;
            })
          ),
          x(u, en()),
          x(f, en(l, p)),
          x(
            c,
            en(function (n) {
              return function (t) {
                var u = n(t);
                return true === u ? nn(t) : u;
              };
            })
          ),
          function (n) {
            throw o('"' + n + '" could not be tokenised');
          }
        );
      return function (n) {
        try {
          return C(n, w);
        } catch (t) {
          throw o('Could not compile "' + n + '" because ' + t.message);
        }
      };
    }),
    an = 1,
    sn = an++,
    ln = an++,
    dn = an++,
    hn = an++,
    pn = 'fail',
    vn = an++,
    mn = an++,
    bn = 'start',
    gn = 'data',
    wn = 'end',
    yn = an++,
    xn = an++,
    In = an++,
    Ln = an++;

  K.drop = function () {
    return K.drop;
  };

  if ('function' == typeof define && define.amd)
    define('oboe', [], function () {
      return K;
    });
  else if ('object' == typeof exports) module.exports = K;
  else n.oboe = K;
})(
  (function () {
    try {
      return window;
    } catch (n) {
      return self;
    }
  })(),
  Object,
  Array,
  Error,
  JSON
);
