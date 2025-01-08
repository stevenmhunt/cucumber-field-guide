require './src/db/schema'

def test_db_connect
    ActiveRecord::Base.establish_connection(
        adapter: 'sqlite3',
        database: ':memory:'
    )
end

def test_db_load_baseline
    User.create(name: 'Test User 1')
end