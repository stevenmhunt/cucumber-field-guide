require 'rspec'

When('The users adds {int} to {int}') do |num1, num2|
    @result = num1 + num2
end

Then('the answer should be {int}') do |expected|
    expect(@result).to eq(expected)
end