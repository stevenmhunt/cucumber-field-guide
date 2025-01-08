require 'active_record'

def db_connect
    # connect to the real database.
    ActiveRecord::Base.establish_connection(
        adapter: 'mysql',
        database: '...'
    )
end