const { Before, After } = require('@cucumber/cucumber');
const { remote } = require('webdriverio');
const config = require('config');
const path = require('path');

Before({ tags: '@mobile', timeout: 60000 }, async function () {
    const capabilities = config?.mobile?.appium?.capabilities;
    const appFile = path.join(process.cwd(), capabilities['appium:app']);
    capabilities['appium:app'] = appFile;

    this.mydemoapp = config?.mobile?.mydemoapp;
    this.appium = await remote({
        ...config?.mobile?.appium,
        capabilities
    });
});

After({ tags: '@mobile' }, async function () {
    if (this.appium) { await this.appium.deleteSession(); }
});