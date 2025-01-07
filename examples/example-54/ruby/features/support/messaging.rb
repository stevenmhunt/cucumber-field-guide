require 'bunny'
require './src/messaging'

messaging_start

at_exit do
    messaging_stop
end

Before('@rabbitmq') do
    @connection = Bunny.new
    @connection.start
    @channel = @connection.create_channel
    @topic_exchange = @channel.topic('topic_exchange', auto_delete: true)
    @topic_messages = []
    queue = @channel
            .queue('', exclusive: true)
            .bind(@topic_exchange, routing_key: '#')
    queue.subscribe do |delivery_info, properties, body|
        @topic_messages << { body: body, topic: delivery_info.routing_key }
        puts "---- Topic #{delivery_info.routing_key}: #{body}"
    end
end

After('@rabbitmq') { @connection.close }
