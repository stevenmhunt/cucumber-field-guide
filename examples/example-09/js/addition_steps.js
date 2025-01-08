const { When, Then } = require('@cucumber/cucumber');
const assert = require('assert');

When('The user adds {int} to {int}', function (num1, num2) {
    this.result = num1 + num2;
});

Then('the answer should be {int}', function (expected) {
    assert.strictEqual(this.result, expected);
});