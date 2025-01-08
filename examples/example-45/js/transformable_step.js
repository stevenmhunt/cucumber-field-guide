const { Given } = require('@cucumber/cucumber');

function doTransform(args) {
    // do something with the args.
    return args;
}

function transformer(fn) {
    return async function step(...args) {
        const result = await fn.apply(this, doTransform.call(this, args));
        return result;
    };
}

Given('the user adds {int} items', transformer(async function (i) {
    // transformed args will be passed here.
}));