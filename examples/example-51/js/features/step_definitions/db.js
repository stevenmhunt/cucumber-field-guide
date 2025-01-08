const { Given, Then } = require('@cucumber/cucumber');
const assert = require('assert');

Given('a user is created with name {string}', async function step(name) {
    await this.db('users').insert({ name });
});

Then('a user with name {string} should exist', async function step(name) {
    const user = await this.db('users').where('name', name).first();
    assert.strictEqual(user?.name, name);
});