const { Before, After } = require('@cucumber/cucumber');
const { Builder } = require('selenium-webdriver');
const SimpleSearchPage = require('../pages/SimpleSearchPage');

Before({ tags: '@webdriver' }, async function () {
    this.driver = await new Builder().forBrowser('firefox').build();
    this.pages = {
        simpleSearch: new SimpleSearchPage(this.driver, 'http://localhost:9999')
    };
});

After({ tags: '@webdriver' }, async function () {
    if (this.driver) {
        await this.driver.quit();
    }
});