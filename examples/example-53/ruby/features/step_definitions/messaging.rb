require('rspec')
require('retries')

When('a message {string} is sent to the queue {string}') do |message, queue_name|
    queue = @channel.queue(queue_name)
    queue.publish(message)
end

Then('the last message received is {string}') do |message|
    with_retries(
        max_tries: 10,
        rescue: [RSpec::Expectations::ExpectationNotMetError],
        base_sleep_seconds: 0.1,
        max_sleep_seconds: 2.0
    ) do
        expect($last_message).to eq(message)
    end
end
