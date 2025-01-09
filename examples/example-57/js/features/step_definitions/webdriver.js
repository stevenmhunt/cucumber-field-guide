const { Given, When, Then } = require('@cucumber/cucumber');
const { By, until } = require('selenium-webdriver');
const assert = require('assert');

Given('the homepage is opened with webdriver', async function () {
    await this.driver.get('http://localhost:9999');
});

When('{string} is typed into the search box with webdriver', async function (text) {
    const input = await this.driver.findElement(By.css('input[type="text"]'));
    await input.sendKeys(text);
});

When('the {string} button is pressed with webdriver', async function (text) {
    const button = await this.driver.findElement(
        By.css(`input[type="submit"][value="${text}"]`));
    await button.click();
});

Then('the results should display {string} with webdriver', async function (text) {
    const results = await this.driver.wait(
        until.elementLocated(By.css('div#results')), 10000);
    const resultsText = await results.getText();
    assert.ok(resultsText.includes(text));
});