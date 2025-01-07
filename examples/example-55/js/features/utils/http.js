const axios = require('axios');
const config = require('config');

async function executeHttpRequestInternal({
    url, method = 'GET', headers = {}, body = null }) {
    const response = await axios({
        method,
        url,
        headers,
        data: body
    });
    return response;
}

async function executeHttpRequest(world, request) {
    let res;
    world.http = world?.http ?? {};
    world.http.requests = world?.http?.requests ?? [];
    world.http.responses = world?.http?.responses ?? [];
    const ignoreErrors = world.http.ignoreErrors || config?.http?.ignoreErrors;
    try {
        const req = { ...request, url: `${config?.http?.baseUrl}${request.url}` };
        world.http.requests.unshift(req);
        res = await executeHttpRequestInternal(req);
    } catch (err) {
        if (!err.response || !ignoreErrors) {
            throw err;
        }
        res = err.response;
    } finally {
        world.http.responses.unshift(res);
    }
    return res;
}

module.exports = { executeHttpRequest };
