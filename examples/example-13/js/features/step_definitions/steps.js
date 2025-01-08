const { When } = require('@cucumber/cucumber');

When('the user adds {int} items to the cart', function(count) {
    this.addItems(count);
});