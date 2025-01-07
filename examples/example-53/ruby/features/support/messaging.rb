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
end

After('@rabbitmq') { @connection.close }
