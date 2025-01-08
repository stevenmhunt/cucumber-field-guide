const { Before, After } = require('@cucumber/cucumber');

// a place to track all of the failed {{scenario}}s.
const failedFilters = {};
const FAILURE_THRESHOLD = 1;

// identifies the feature tag using the pickle object.
function getTagFilter(pickle) {
    return pickle.tags.find(i => i.name.indexOf('@feature_') === 0)?.name;
}

// determines if the feature has failed, if it has then skip this test.
Before(function ({ pickle }) {
    const filter = getTagFilter(pickle);
    if (failedFilters[filter] && failedFilters[filter] >= FAILURE_THRESHOLD) {
        return 'skipped';
    }
});

// if a test has failed, record that this feature has also failed.
After(function ({ pickle, result }) {
    const filter = getTagFilter(pickle);
    if (result.status.toLowerCase() === 'failed') {
        failedFilters[filter] = (failedFilters[filter] ?? 0) + 1;
    }
});