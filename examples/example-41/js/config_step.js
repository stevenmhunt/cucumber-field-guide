const { Given } = require('@cucumber/cucumber');
const config = require('config');

Given('a test value is printed', function() {
    console.log(config.steps.testValue);
});