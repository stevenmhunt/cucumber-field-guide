const { setDefinitionFunctionWrapper, DataTable } = require('@cucumber/cucumber');

let param_transform_callbacks = [];
let dt_cell_transform_callbacks = [];

function ParameterTransformer(callback) {
    param_transform_callbacks.push(callback);
}

function DataTableCellTransformer(callback) {
    dt_cell_transform_callbacks.push(callback);
}

function doTransform(args) {
    const processVal = (val, callbacks) => {
        if (val && val.raw && typeof val.raw === 'function') {
            return new DataTable(val.raw().map(row => row.map((v) => {
                return processVal(v, dt_cell_transform_callbacks);
            })));
        }
        let result = val;
        callbacks.forEach((cb) => {
            result = cb.call(this, result);
        });
        return result;
    };
    return args.map(arg => processVal(arg, param_transform_callbacks));
}

setDefinitionFunctionWrapper(fn => async function step(...args) {
    const result = await fn.apply(this, doTransform.call(this, args));
    return result;
});

module.exports = { ParameterTransformer, DataTableCellTransformer };