const amqp = require('amqplib');
const { Before, After, BeforeAll, AfterAll } = require('@cucumber/cucumber');
const { connectMessaging, closeMessaging } = require('../../src/messaging');

BeforeAll(async () => {
    await connectMessaging();
});

AfterAll(async () => {
    await closeMessaging();
});

Before({ tags: '@rabbitmq' }, async function hook() {
    this.amqp = { connection: await amqp.connect('amqp://localhost') };
    this.amqp.channel = await this.amqp.connection.createChannel();
});

After({ tags: '@rabbitmq' }, async function hook() {
    if (!this.amqp?.connection) { return; }
    await this.amqp.connection.close();
});