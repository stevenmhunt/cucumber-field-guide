require 'bunny'

Connection = Bunny.new

def messaging_start
    Connection.start
    channel = Connection.create_channel
    queue = channel.queue('messages')
    queue.subscribe do |delivery_info, properties, body|
        $last_message = body
        puts "---- Received #{body}"
    end
end

def messaging_stop
    return unless Connection.open?

    Connection.close
end
