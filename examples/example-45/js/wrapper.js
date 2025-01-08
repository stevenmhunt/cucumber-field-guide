const { setDefinitionFunctionWrapper } = require('@cucumber/cucumber');

function doTransform(args) { /* do something with the args. */ return args; }

setDefinitionFunctionWrapper(fn => async function step(...args) {
    const result = await fn.apply(this, doTransform.call(this, args));
    return result;
});