const { Given } = require('@cucumber/cucumber');

Given('this step always fails', function () {
    throw new Error();
});