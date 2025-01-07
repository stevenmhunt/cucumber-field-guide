Feature: RabbitMQ Queues

@rabbitmq
Scenario: Testing a Message Queue
When a message "hello!" is sent to the queue "messages"
Then the last message received is "hello!"
