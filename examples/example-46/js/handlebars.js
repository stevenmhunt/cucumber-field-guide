const Handlebars = require('handlebars');

function doTransform(args) {
    const result = args.map((arg) => {
        if (typeof arg === 'string' || arg instanceof String) {
            arg = Handlebars.compile(arg).call(null, this);
        }
        return arg;
    });
    return result;
}