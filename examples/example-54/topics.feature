Feature: RabbitMQ Topics

@rabbitmq
Scenario: Sending and Receiving Topics
When a message "hello!" is sent to the topic "topic_messages"
Then a message "hello!" should be received by the topic "topic_messages"
