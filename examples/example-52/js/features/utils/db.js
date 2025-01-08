const knex = require('knex');
const { setDbContext, createSchema } = require('../../src/db');
const config = require('config');

async function initializeDatabase() {
    const context = setDbContext(knex(config.db));
    return createSchema(context);
}

async function loadBaselineData(context) {
    await context('users').insert({ name: 'Test User 1' });
}

module.exports = { initializeDatabase, loadBaselineData };