require './src/session'

Given('the user {string} logs in') do |user|
    performLogin(user)
end