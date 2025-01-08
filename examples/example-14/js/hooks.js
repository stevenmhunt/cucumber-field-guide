const { After, Before, AfterAll, BeforeAll, AfterStep, BeforeStep } = require('@cucumber/cucumber');

Before(function (scenario) {
    // run code before each scenario.
});

After(function (scenario) {
    // run code after each scenario.
});

BeforeAll(function () {
    // run code before all scenarios.
});

AfterAll(function () {
    // run code after all scenarios.
});

BeforeStep(function () {
    // run code before each step.
});

AfterStep(function () {
    // run code after each step.
});

Before({ tags: '@smoke and @ui' }, function (scenario) {
    // run code before each scenario.
});

After({ tags: '@smoke and @ui' }, function (scenario) {
    // run code after each scenario.
});