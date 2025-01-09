require 'rspec'

Given('the app is opened') do
    @appium.start_driver
    @mydemoapp = MyDemoApp.new(@appium)
end

When('the {string} is clicked') do |item|
    wait = Selenium::WebDriver::Wait.new(timeout: 10)
    element = wait.until { @mydemoapp.find_element(item) }
    element.click
end

Then('the {string} should be displayed') do |item|
    wait = Selenium::WebDriver::Wait.new(timeout: 10)
    wait.until do
        found_element = @mydemoapp.find_element(item)
        found_element if found_element.displayed?
    end
end