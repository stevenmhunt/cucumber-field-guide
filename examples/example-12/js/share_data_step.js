const { Given } = require('@cucumber/cucumber');
const { performLogin } = require('../../src/session');

Given('the user {string} logs in', async function(user) {
    await performLogin(user);
    this.currentUser = user;
});