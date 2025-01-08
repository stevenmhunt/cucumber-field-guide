const { Given } = require('@cucumber/cucumber');

Given('the following users are created:', async function(table) {
    table.hashes().forEach((row) => console.log(JSON.stringify(row)));
});