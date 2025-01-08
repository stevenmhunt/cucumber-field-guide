module.exports = {
    'default': {},
    'ci': {
        format: ['progress', 'junit:build/reports/output.xml', 'json:build/reports/results.json'],
        strict: true,
        tags: 'not @wip'
    }
};