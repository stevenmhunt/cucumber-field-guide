class UsersService
    include Injectable
    dependency :http
    dependency :message_broker
    argument :url
end