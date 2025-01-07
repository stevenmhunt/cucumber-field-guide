const amqp = require('amqplib');
const { Before, After, BeforeAll, AfterAll } = require('@cucumber/cucumber');
const { connectMessaging, closeMessaging } = require('../../src/messaging');

BeforeAll(async () => {
    await connectMessaging();
});

AfterAll(async () => {
    await closeMessaging();
});

Before({ tags: '@rabbitmq' }, async function () {
    const connection = await amqp.connect('amqp://localhost');
    this.amqp = { connection, topics: {} };
    this.amqp.channel = await this.amqp.connection.createChannel();

    await this.amqp.channel.assertExchange('topic_exchange', 'topic', {
        durable: false
    });

    const q = await this.amqp.channel.assertQueue('', { exclusive: true });
    await this.amqp.channel.bindQueue(q.queue, 'topic_exchange', '#');
    await this.amqp.channel.consume(q.queue, (msg) => {
        const topicName = msg.fields.routingKey;
        this.amqp.topics[topicName] = this.amqp.topics[topicName] || [];
        this.amqp.topics[topicName].push(msg.content.toString());
        console.log(`---- Topic ${topicName}: ${msg.content.toString()}`);
    }, { noAck: true });
});

After({ tags: '@rabbitmq' }, async function hook() {
    if (!this.amqp?.connection) { return; }
    await this.amqp.connection.close();
});