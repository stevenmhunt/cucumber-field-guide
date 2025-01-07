const { Before, Given, Then } = require('@cucumber/cucumber');
const { executeHttpRequest } = require('../../utils/http');
const assert = require('assert');


Before({ tags: '@http-ignore-errors' }, function () {
    this.http = this?.http ?? {};
    this.http.ignoreErrors = true;
});

Given('an HTTP {string} call {string} is made', async function(method, url) {
    const response = await executeHttpRequest(this, { method, url });
});

Then('the HTTP call should have returned an HTTP {int}', function (status) {
    assert.strictEqual(this?.http?.responses?.[0]?.status, status);
});
