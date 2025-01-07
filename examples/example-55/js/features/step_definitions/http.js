const { Before, Given } = require('@cucumber/cucumber');
const { executeHttpRequest } = require('../../utils/http');


Before({ tags: '@http-ignore-errors' }, function () {
    this.http = this?.http ?? {};
    this.http.ignoreErrors = true;
});

Given('an HTTP {string} call {string} is made', async function(method, url) {
    const response = await executeHttpRequest(this, { method, url });
});
