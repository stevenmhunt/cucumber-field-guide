const { Given, When, Then } = require('@cucumber/cucumber');
const assert = require('assert');

Given('the homepage is opened with webdriver', async function () {
    await this.pages.simpleSearch.open();
});

When('{string} is typed into the search box with webdriver', async function (text) {
    await this.pages.simpleSearch.typeSearch(text);
});

When('the {string} button is pressed with webdriver', async function (text) {
    await this.pages.simpleSearch.submitSearch();
});

Then('the results should display {string} with webdriver', async function (text) {
    const resultsText = await this.pages.simpleSearch.getResultsText();
    assert.ok(resultsText.includes(text));
});