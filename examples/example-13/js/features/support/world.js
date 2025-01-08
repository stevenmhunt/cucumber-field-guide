const { setWorldConstructor, World } = require('@cucumber/cucumber');

class CustomWorld extends World {
    constructor(options) {
        super(options);
        this.count = 0;
    }
  
    addItems(count) {
        this.count += count;
    }
}

setWorldConstructor(CustomWorld);
module.exports = { CustomWorld };