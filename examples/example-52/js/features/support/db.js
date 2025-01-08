const { Before, After } = require('@cucumber/cucumber');
const { initializeDatabase, loadBaselineData } = require('../utils/db');

Before(async function hook() {
    this.db = await initializeDatabase();
    await loadBaselineData(this.db);
});
After(async function hook() { await this.db.destroy(); });