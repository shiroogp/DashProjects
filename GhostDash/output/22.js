require('./31');

require('./7');

var module27 = require('./27'),
  module29 = require('./29'),
  module30 = require('./30'),
  module6 = require('./6'),
  module32 = require('./32').default,
  c = (function () {
    function c() {
      module27(this, c);
      this._lazyCallableModules = {};
      this._queue = [[], [], [], 0];
      this._successCallbacks = new Map();
      this._failureCallbacks = new Map();
      this._callID = 0;
      this._lastFlush = 0;
      this._eventLoopStartTime = Date.now();
      this._immediatesCallback = null;
      this.callFunctionReturnFlushedQueue = this.callFunctionReturnFlushedQueue.bind(this);
      this.flushedQueue = this.flushedQueue.bind(this);
      this.invokeCallbackAndReturnFlushedQueue = this.invokeCallbackAndReturnFlushedQueue.bind(this);
    }

    module28(
      c,
      [
        {
          key: 'callFunctionReturnFlushedQueue',
          value: function (t, l, u) {
            var s = this;

            this.__guard(function () {
              s.__callFunction(t, l, u);
            });

            return this.flushedQueue();
          },
        },
        {
          key: 'callFunctionReturnResultAndFlushedQueue',
          value: function (t, l, u) {},
        },
        {
          key: 'invokeCallbackAndReturnFlushedQueue',
          value: function (t, l) {
            var u = this;

            this.__guard(function () {
              u.__invokeCallback(t, l);
            });

            return this.flushedQueue();
          },
        },
        {
          key: 'flushedQueue',
          value: function () {
            var t = this;

            this.__guard(function () {
              t.__callImmediates();
            });

            var l = this._queue;
            this._queue = [[], [], [], this._callID];
            return l[0].length ? l : null;
          },
        },
        {
          key: 'getEventLoopRunningTime',
          value: function () {
            return Date.now() - this._eventLoopStartTime;
          },
        },
        {
          key: 'registerCallableModule',
          value: function (t, l) {
            this._lazyCallableModules[t] = function () {
              return l;
            };
          },
        },
        {
          key: 'registerLazyCallableModule',
          value: function (t, l) {
            var u,
              s = l;

            this._lazyCallableModules[t] = function () {
              if (s) {
                u = s();
                s = null;
              }

              return u;
            };
          },
        },
        {
          key: 'getCallableModule',
          value: function (t) {
            var l = this._lazyCallableModules[t];
            return l ? l() : null;
          },
        },
        {
          key: 'callNativeSyncHook',
          value: function (t, l, u, s, n) {
            this.processCallbacks(t, l, u, s, n);
            return globals.nativeCallSyncHook(t, l, u);
          },
        },
        {
          key: 'processCallbacks',
          value: function (t, l, u, s, n) {
            if (s || n) {
              if (s) u.push(this._callID << 1);
              if (n) u.push((this._callID << 1) | 1);

              this._successCallbacks.set(this._callID, n);

              this._failureCallbacks.set(this._callID, s);
            }

            this._callID++;
          },
        },
        {
          key: 'enqueueNativeCall',
          value: function (t, l, u, s, h) {
            this.processCallbacks(t, l, u, s, h);

            this._queue[0].push(t);

            this._queue[1].push(l);

            this._queue[2].push(u);

            var o = Date.now();

            if (globals.nativeFlushQueueImmediate && o - this._lastFlush >= 5) {
              var c = this._queue;
              this._queue = [[], [], [], this._callID];
              this._lastFlush = o;
              globals.nativeFlushQueueImmediate(c);
            }

            module30.counterEvent('pending_js_to_native_queue', this._queue[0].length);
            if (this.__spy)
              this.__spy({
                type: 1,
                module: t + '',
                method: l,
                args: u,
              });
          },
        },
        {
          key: 'createDebugLookup',
          value: function (t, l, u) {},
        },
        {
          key: 'setImmediatesCallback',
          value: function (t) {
            this._immediatesCallback = t;
          },
        },
        {
          key: '__guard',
          value: function (t) {
            if (this.__shouldPauseOnThrow()) t();
            else
              try {
                t();
              } catch (t) {
                module29.reportFatalError(t);
              }
          },
        },
        {
          key: '__shouldPauseOnThrow',
          value: function () {
            return 'undefined' != typeof DebuggerInternal && true === DebuggerInternal.shouldPauseOnThrow;
          },
        },
        {
          key: '__callImmediates',
          value: function () {
            module30.beginEvent('JSTimers.callImmediates()');
            if (null != this._immediatesCallback) this._immediatesCallback();
            module30.endEvent();
          },
        },
        {
          key: '__callFunction',
          value: function (t, l, u) {
            this._lastFlush = Date.now();
            this._eventLoopStartTime = this._lastFlush;
            if (this.__spy) module30.beginEvent(t + '.' + l + '(' + module32(u) + ')');
            else module30.beginEvent(t + '.' + l + '(...)');
            if (this.__spy)
              this.__spy({
                type: 0,
                module: t,
                method: l,
                args: u,
              });
            var s = this.getCallableModule(t);
            module6(!!s, 'Module %s is not a registered callable module (calling %s)', t, l);
            module6(!!s[l], 'Method %s does not exist on module %s', l, t);
            s[l].apply(s, u);
            module30.endEvent();
          },
        },
        {
          key: '__invokeCallback',
          value: function (l, u) {
            this._lastFlush = Date.now();
            this._eventLoopStartTime = this._lastFlush;
            var s = l >>> 1,
              n = 1 & l ? this._successCallbacks.get(s) : this._failureCallbacks.get(s);

            if (n) {
              this._successCallbacks.delete(s);

              this._failureCallbacks.delete(s);

              n.apply(undefined, u);
            }
          },
        },
      ],
      [
        {
          key: 'spy',
          value: function (t) {
            c.prototype.__spy =
              true === t
                ? function (t) {
                    console.log((0 === t.type ? 'N->JS' : 'JS->N') + ' : ' + (t.module ? t.module + '.' : '') + t.method + '(' + JSON.stringify(t.args) + ')');
                  }
                : false === t
                ? null
                : t;
          },
        },
      ]
    );
    return c;
  })();

module.exports = c;
