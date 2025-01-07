const amqp = require('amqplib');

let connection = null;
let channel = null;
let lastMessage = null;

async function connectMessaging() {
    connection = await amqp.connect('amqp://localhost');
    channel = await connection.createChannel();
    await channel.assertQueue('messages', { durable: false });

    await channel.consume('messages', (msg) => {
        lastMessage = msg.content.toString();
        console.log('---- Received ', lastMessage);
        channel.ack(msg);
    });

    return { connection, channel };
}

async function closeMessaging() {
    if (!connection) { return; }
    await connection.close();
}

const getLastMessage = () => lastMessage;

module.exports = { connectMessaging, closeMessaging, getLastMessage };
