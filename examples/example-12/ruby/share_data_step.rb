require './src/session'

Given('the user {string} logs in') do |user|
    performLogin(user)
    @current_user = user
end