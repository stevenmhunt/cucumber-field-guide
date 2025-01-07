const { When, Then } = require('@cucumber/cucumber');
const { getLastMessage } = require('../../src/messaging');
const assert = require('assert');
const promiseRetry = require('promise-retry');

When('a message {string} is sent to the queue {string}', async function (msg, q) {
    await this.amqp.channel.sendToQueue(q, Buffer.from(msg));
});

Then('the last message received is {string}', function (expectedMessage) {
    return promiseRetry(async function (retry) {
        try {
            assert.strictEqual(getLastMessage(), expectedMessage);
        } catch (ex) { retry(); }
    }, {
        retries: 10,
        factor: 2,
        minTimeout: 100,
        maxTimeout: 2000,
    });
});

When('a message {string} is sent to the topic {string}', async function (msg, t) {
    await this.amqp.channel.publish('topic_exchange', t, Buffer.from(msg));
});

Then('a message {string} should be received by the topic {string}', function (m, t) {
    return promiseRetry((retry) => {
        try {
            assert.ok(this.amqp?.topics?.[t]);
            assert.ok(this.amqp.topics[t].includes(m));
        } catch (ex) { retry(); }
    }, {
        retries: 10,
        factor: 2,
        minTimeout: 100,
        maxTimeout: 2000,
    });
});
