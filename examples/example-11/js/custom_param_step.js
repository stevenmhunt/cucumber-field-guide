const { defineParameterType, When } = require('@cucumber/cucumber');

defineParameterType({
    name: 'isoDate',
    regexp: /\d{4}-\d{2}-\d{2}/,
    transformer: d => new Date(d)
});

When('the user selects the date {isoDate}', async function(date) {
    // do something with the date...
});