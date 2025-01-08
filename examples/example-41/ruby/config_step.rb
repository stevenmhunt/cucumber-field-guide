require 'config'

Config.load_and_set_settings(
    Config.setting_files('config', ENV['TEST_ENV'] || 'default')
)

Given('a test value is printed') do
    puts Settings.steps.testValue
end