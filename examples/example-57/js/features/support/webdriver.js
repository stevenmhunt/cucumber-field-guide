const { Before, After } = require('@cucumber/cucumber');
const { Builder } = require('selenium-webdriver');

Before({ tags: '@webdriver' }, async function () {
    this.driver = await new Builder().forBrowser('firefox').build();
});

After({ tags: '@webdriver' }, async function () {
    if (this.driver) {
        await this.driver.quit();
    }
});