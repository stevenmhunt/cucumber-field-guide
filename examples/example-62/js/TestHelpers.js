class TestHelpers {
    // ... your code here...
}

let instance = null;
function getTestHelpers() {
    if (instance === null) {
        instance = new TestHelpers();
    }
    return instance;
}

module.exports = { getTestHelpers };