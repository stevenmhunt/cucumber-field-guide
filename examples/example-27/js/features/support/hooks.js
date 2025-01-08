const { Before, After } = require('@cucumber/cucumber');

// skip all remaining tests once this number has been reached.
const FAILURE_THRESHOLD = 3;

// a place to track the number of failed {{scenario}}s.
let failCount = 0;

// check if the fail count has been exceeded.
Before(function ({ pickle }) {
    if (failCount >= FAILURE_THRESHOLD) {
        return 'skipped';
    }
});

// increments fail count if the test failed.
After(function ({ pickle, result }) {
    console.log(result);
    if (result.status.toLowerCase() === 'failed') {
        failCount += 1;
    }
});