require 'rspec'

Given('a user is created with name {string}') do |name|
    User.create!(name: name)
end

Then('a user with name {string} should exist') do |expected_name|
    user = User.find_by(name: expected_name)
    expect(user).not_to be_nil
    expect(user.name).to eq(expected_name)
end