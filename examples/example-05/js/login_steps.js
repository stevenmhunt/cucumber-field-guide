const { Given } = require('@cucumber/cucumber');
const { performLogin } = require('../../src/session');

Given('the user logs in', async function() {
    await performLogin();
});