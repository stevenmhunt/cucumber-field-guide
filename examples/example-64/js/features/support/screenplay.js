const { Before, After } = require('@cucumber/cucumber');
const { actorCalled } = require('@serenity-js/core');
const { BrowseTheWebWithPlaywright } = require('@serenity-js/playwright');
const { firefox } = require('playwright');

Before({ tags: '@screenplay' }, async function() {
    this.browser = await firefox.launch();
    this.actor = actorCalled('user1')
        .whoCan(BrowseTheWebWithPlaywright.using(this.browser));
});

After({ tags: '@screenplay' }, async function() {
    if (this.browser) {
        await this.browser.close();
    }
});