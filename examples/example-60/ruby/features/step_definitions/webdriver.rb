require 'rspec'

Given('the homepage is opened with webdriver') do
    @driver.navigate.to 'http://host.docker.internal:9999'
end

When('{string} is typed into the search box with webdriver') do |value|
    wait = Selenium::WebDriver::Wait.new(timeout: 10)
    wait.until { @driver.find_element(id: 'search_box').displayed? }
    element = @driver.find_element(id: 'search_box')
    element.send_keys(value)
end

When('the {string} button is pressed with webdriver') do |btn|
    path = "//input[@type='submit'][@value='#{btn}']"
    wait = Selenium::WebDriver::Wait.new(timeout: 10)
    wait.until { @driver.find_element(xpath: path).displayed? }
    button = @driver.find_element(xpath: path)
    button.click
end

Then('the results should display {string} with webdriver') do |results|
    wait = Selenium::WebDriver::Wait.new(timeout: 10)
    wait.until { @driver.find_element(id: 'results').displayed? }
    text = @driver.find_element(id: 'results').text
    expect(text).to eq(results)
end