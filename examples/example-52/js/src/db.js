const knex = require('knex');

let db = null;

function getDbContext() {
    if (!db) { db = knex({ client: 'mysql', connection: '...' }); }
    return db;
}

function setDbContext(context) { return (db = context); }

async function createSchema(context) {
    await context.schema.dropTableIfExists('users');
    await context.schema.createTable('users', (table) => {
        table.increments('id');
        table.string('name');
        table.timestamps(true, true);
    });
    return context;
}

module.exports = { getDbContext, setDbContext, createSchema };