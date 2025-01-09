const { Given, When, Then } = require('@cucumber/cucumber');
const assert = require('assert');

Given('the app is opened', async function () { /* noop */ });

When('the {string} is clicked', async function (item) {
    const element = await this.appium.$(this.mydemoapp[item]);
    await element.click();
});

Then('the {string} should be displayed', async function (item) {
    const element = await this.appium.$(this.mydemoapp[item]);
    assert.ok(await element.isDisplayed());
});