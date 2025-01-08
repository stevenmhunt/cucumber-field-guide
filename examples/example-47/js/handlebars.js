const Handlebars = require('handlebars');
const { ParameterTransformer, DataTableCellTransformer } = require('./transformer');
let templates = {};

function processTemplate(context, val) {
    if (typeof val === 'string' || val instanceof String) {
        templates[val] = templates[val] || Handlebars.compile(val);
        return templates[val].call(null, context);
    }
    return val;
}

function hook(val) {
    try { return processTemplate(this, val); }
    catch (err) { return val; }
}

ParameterTransformer(hook);
DataTableCellTransformer(hook);