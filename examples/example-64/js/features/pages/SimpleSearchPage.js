const { By, until, Key } = require('selenium-webdriver');

class SimpleSearchPage {
    constructor(driver, baseUrl) {
        this.driver = driver;
        this.url = `${baseUrl}/index.html`;
        this.searchBoxLocator = By.id('search_box');
        this.resultsLocator = By.id('results');
    }

    async open() {
        await this.driver.get(this.url);
    }

    async typeSearch(query) {
        let searchBox = await this.driver.wait(
            until.elementLocated(this.searchBoxLocator), 10000);
        await searchBox.clear();
        await searchBox.sendKeys(query);
    }

    async submitSearch() {
        let searchBox = await this.driver.findElement(this.searchBoxLocator);
        await searchBox.sendKeys(Key.RETURN);
    }

    async results() {
        let resultsArea = await this.driver.wait(
            until.elementLocated(this.resultsLocator), 10000);
        return await resultsArea.getText();
    }
}

module.exports = SimpleSearchPage;