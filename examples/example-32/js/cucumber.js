module.exports = {
    'default': {},
    'ci': {
        format: ['progress', 'junit:build/reports/output.xml'],
        strict: true,
        tags: 'not @wip'
    }
};