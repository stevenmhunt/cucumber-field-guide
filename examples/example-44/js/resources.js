const fs = require('fs');
const path = require('path');
const cache = {};

function loadResource(name) {
    if (cache[name]) { return cache[name]; }
    const resourcesDir = path.join(process.cwd(), 'resources');
    const files = fs.readdirSync(resourcesDir);
    const file = files.find(f => path.basename(f, path.extname(f)) === name);
    if (!file) { return null; }
    const fullPath = path.join(resourcesDir, file);
    const extension = path.extname(file).toLowerCase();
    let content;
    switch (extension) {
    case '.txt':
        content = fs.readFileSync(fullPath, 'utf8');
        break;
    default:
        content = fs.readFileSync(fullPath);
        break;
    }
    cache[name] = content;
    return content;
}

const resources = new Proxy({}, {
    get: function(t, p, r) { return loadResource(p); }
});

module.exports = { loadResource, resources };