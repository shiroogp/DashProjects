var module426 = require('./426');

exports.prepareUIRegistry = module426.runOnUIImmediately(function () {
  'worklet';

  var t = {
    frameCallbackRegistry: new Map(),
    activeFrameCallbacks: new Set(),
    previousFrameTimestamp: null,
    nextCallId: 0,
    runCallbacks: function (t) {
      var l = this;
      if (1 === this.activeFrameCallbacks.size && t === this.nextCallId)
        requestAnimationFrame(function s(c) {
          if (t === l.nextCallId) {
            if (null === l.previousFrameTimestamp) l.previousFrameTimestamp = c;
            var n = c - l.previousFrameTimestamp;
            l.activeFrameCallbacks.forEach(function (t) {
              var s = l.frameCallbackRegistry.get(t),
                u = s.startTime;

              if (null === u) {
                s.startTime = c;
                s.callback({
                  timestamp: c,
                  timeSincePreviousFrame: null,
                  timeSinceFirstFrame: 0,
                });
              } else
                s.callback({
                  timestamp: c,
                  timeSincePreviousFrame: n,
                  timeSinceFirstFrame: c - u,
                });
            });

            if (l.activeFrameCallbacks.size > 0) {
              l.previousFrameTimestamp = c;
              requestAnimationFrame(s);
            } else l.previousFrameTimestamp = null;
          }
        });
    },
    registerFrameCallback: function (t, l) {
      this.frameCallbackRegistry.set(l, {
        callback: t,
        startTime: null,
      });
    },
    unregisterFrameCallback: function (t) {
      this.manageStateFrameCallback(t, false);
      this.frameCallbackRegistry.delete(t);
    },
    manageStateFrameCallback: function (t, l) {
      if (-1 !== t)
        l
          ? (this.activeFrameCallbacks.add(t), this.runCallbacks(this.nextCallId))
          : ((this.frameCallbackRegistry.get(t).startTime = null), this.activeFrameCallbacks.delete(t), 0 === this.activeFrameCallbacks.size && (this.nextCallId += 1));
    },
  };
  globals._frameCallbackRegistry = t;
});
