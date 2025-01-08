const promiseRetry = require('promise-retry');
const options = {
    retries: 10,
    factor: 2,
    minTimeout: 100,
    maxTimeout: 2000,
};

Given('some step which requires retries', function() {
    return promiseRetry(async function (retry) {
        try {
            // code which may require retries.
        }
        catch (ex) {
            // add additional logic here in order to conditionally retry.
            retry();
        }
    }, options);
});
