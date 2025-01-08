const { Before, Given } = require('@cucumber/cucumber');
const { resources } = require('./resources');

Before(function () { this.resources = resources; });

Given('some file is loaded', function () {
    const data = this.resources.someFile;
});