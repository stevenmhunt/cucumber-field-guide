const Handlebars = require('handlebars');
const config = require('config');

Handlebars.registerHelper('config', (v) => config.get(v));