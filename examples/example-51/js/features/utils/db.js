const knex = require('knex');
const { setDbContext, createSchema } = require('../../src/db');

async function initializeDatabase() {
    const con = setDbContext(knex({ client: 'sqlite3', connection: ':memory:' }));
    return createSchema(con);
}

async function loadBaselineData(context) {
    await context('users').insert({ name: 'Test User 1' });
}

module.exports = { initializeDatabase, loadBaselineData };