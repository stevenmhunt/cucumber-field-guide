require './src/db/schema'
require 'config'

Config.load_and_set_settings(
    Config.setting_files('config', ENV['TEST_ENV'] || 'default')
)

def test_db_connect
    ActiveRecord::Base.establish_connection(Settings.db.to_h)
end

def test_db_load_baseline
    User.create(name: 'Test User 1')
end