var module27 = require('./27');

class n {
  constructor(s) {
    module27(this, n);
    this.subscriber = s;
  }

  remove() {
    this.subscriber.removeSubscription(this);
  }
}

module.exports = n;
